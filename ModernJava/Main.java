package ModernJava;

import java.lang.String;
//import java.util.stream.*;

import ModernJava.Main.LinkDownEvent;

public class Main {
    // The sealed interface defines all possible types of network events.
    // No other class can implement NetworkEvent directly.
    public sealed interface NetworkEvent permits LinkDownEvent,
            PacketDropEvent, HighTempEvent {
        String getSourceDeviceId();
    }

    // These implementations must be final, sealed, or non-sealed.
    // Using `final` is most common for the end-points of the hierarchy.
    public final class LinkDownEvent implements NetworkEvent {
        // implementation details...
        public String getSourceDeviceId() {
            return "router-1";
        }

        public int getPort() {
            return 42;
        }
    }

    public final class PacketDropEvent implements NetworkEvent {
        // implementation details...
        public String getSourceDeviceId() {
            return "switch-5";
        }

        public long getDropCount() {
            return 1024;
        }
    }

    public final class HighTempEvent implements NetworkEvent {
        // implementation details...
        public String getSourceDeviceId() {
            return "transponder-3";
        }

        public double getTemperature() {
            return 85.5;
        }
    }

    public static void main(String args[]) {
        // isBlank()
        System.out.println("  \t  \n  ".isBlank()); // true
        System.out.println("".isBlank());
        System.out.println(" Ciena ".isBlank());

        String multiLineConfig = "hostname=ROUTER-A\nport=8080\nprotocol=https";
        multiLineConfig.lines().filter(line -> !line.contains("hostname")).forEach(System.out::println);

        // strip()
        String unicodeSpace = "\u2005" + "  Hello Ciena  " + "\u2005";
        System.out.println("'" + unicodeSpace.trim() + "'"); // 'Hello Ciena' (might not trim unicode space)
        System.out.println("'" + unicodeSpace.strip() + "'"); // 'Hello Ciena' (correctly trims unicode space)
        // repeat()
        String separator = "-=".repeat(20);
        System.out.println(separator);
    }

    public String processEvent(NetworkEvent event) {
        // This switch is clean, safe, and doesn't require any `instanceof` or casting.
        return switch (event) {
            // Case with type pattern, creating a variable 'lde' of the correct type
            case LinkDownEvent lde ->
                "ALERT: Link down on device " + lde.getSourceDeviceId() + " at port " + lde.getPort();
            case PacketDropEvent pde ->
                "WARN: Packets dropped on device " + pde.getSourceDeviceId() +
                        ". Total drops: " + pde.getDropCount();
            case HighTempEvent hte ->
                "CRITICAL: High temperature on device " +
                        hte.getSourceDeviceId() + ". Temp: " + hte.getTemperature();
            // Because NetworkEvent is sealed, the compiler knows all possible types.
            // If you comment out one of the cases above, the compiler will generate an
            // error:
            // "the switch expression does not cover all possible input values"
            // This forces you to write more robust code.
        };
    }
}