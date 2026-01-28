package Synchronization;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.Arrays;

// Mock Device and Status classes
class DeviceStatus {
    String deviceId;
    String status;
    public DeviceStatus(String id, String status) { this.deviceId = id; this.status = status; }
    @Override 
    public String toString() { 
        return "DeviceStatus{id='" + deviceId + "', status='" + status + "'}"; 
    }
}

public class NetworkPollingExample {

    // Simulates fetching status from a network device
    public static DeviceStatus fetchDeviceStatus(String deviceId)  {
        try {
            // Simulate variable network latency
            TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 1000) + 500);
            if (deviceId.equals("device-3")) { // Simulate a failed device
                throw new RuntimeException("Timeout connecting to " + deviceId);
            }
            return new DeviceStatus(deviceId, "OPERATIONAL");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return new DeviceStatus(deviceId, "FETCH_INTERRUPTED");
        } catch (Exception e) {
            // Propagate the runtime exception which CompletableFuture will catch
            throw new CompletionException(e);
        }
    }

    public static void main(String[] args) {
        ExecutorService pollingExecutor = Executors.newFixedThreadPool(50);
        List<String> deviceIds = Arrays.asList("device-1", "device-2", "device-3", "device-4", "device-5","device-6","device-7","device-8","device-9","device-10"); // Imagine 1000s

        System.out.println("Starting to poll " + deviceIds.size() + " devices...");

        List<CompletableFuture<DeviceStatus>> statusFutures = deviceIds.stream()
            .map(id -> CompletableFuture.supplyAsync(() -> fetchDeviceStatus(id), pollingExecutor)
                    .exceptionally(ex -> new DeviceStatus(id, "FAILED: " + ex.getCause().getMessage())) // Handle failure per-device
            )
            .collect(Collectors.toList());

        // We can now process results as they come in, or wait for all of them.
        // Let's wait for all to complete and then process.
        CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf(
            statusFutures.toArray(new CompletableFuture[0])
        );

        CompletableFuture<List<DeviceStatus>> allResultsFuture = allDoneFuture.thenApply(v -> 
            statusFutures.stream()
                         .map(CompletableFuture::join) // join() is safe here because we know they are all complete
                         .collect(Collectors.toList())
        );

        List<DeviceStatus> finalReport = allResultsFuture.join();

        System.out.println("\n--- Polling Complete. Final Report ---");
        finalReport.forEach(System.out::println);

        pollingExecutor.shutdown();
    }
}
