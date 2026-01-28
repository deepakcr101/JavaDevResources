# Override
 It's a safety net. It tells the compiler your intention. If the method signature 
doesn't correctly match a method in the superclass/interface (e.g., due to a typo, wrong parameters), 
the compiler will generate an error. Without @Override, you would have silently created a new, 
unrelated method, leading to subtle and hard-to-find bugs.

## @Deprecated
It  is a marker annotation used to indicate that a class, method, or field is 
outdated and should no longer be used. 

## Java 10: Local-Variable Type Inference (var)

var allows you to declare local variables without explicitly writing the type. The compiler 
infers the type from the right-hand side of the expression.

* Can only be used for local variables (inside methods, loops, etc.). Cannot be used for 
class fields, method parameters, or return types. 
* The variable must be initialized on the same line it's declared. 
* var is not a new keyword in the same way int or String is. It's context-sensitive. 
You can still have a variable named var. 
* It is statically typed. The type is determined at compile-time, not runtime. var is not 
like JavaScript's var. 

```
// Before Java 10 (Verbose) 
Map<String, List<Ciena.WaveLogic.Transponder>> siteToTranspondersMap = new HashMap<>(); 
// With Java 10 `var` (Clean and Readable) 
var siteToTranspondersMap = new HashMap<String,List<Ciena.WaveLogic.Transponder>>(); 
// Excellent for loops 
for (var entry : siteToTranspondersMap.entrySet()) { 
// entry is inferred as Map.Entry<String,List<Ciena.WaveLogic.Transponder>> 

var siteName = entry.getKey(); // Inferred as String 
var transponders = entry.getValue(); // Inferred as List<...> 
System.out.println("Site: " + siteName + " has " + transponders.size() + " transponders.");
}
```

## Pattern Matching of instanceof
This feature simplifies the common pattern of checking an object's type with 
instanceof, casting it, and then using it. It combines the type check and the cast into a single 
operation.
* It eliminates boilerplate code, reduces the chance of ClassCastException 
errors, and makes the code more concise and readable. 


## Java 17: Sealed Classes and Interfaces 
 The sealed modifier allows you to control which classes or interfaces can extend or 
implement a given class or interface. You explicitly declare the permitted subclasses using the 
permits clause.

* All permitted subclasses must be in the same module or package
