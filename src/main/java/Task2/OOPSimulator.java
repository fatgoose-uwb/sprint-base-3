package Task2;

import Task2.Animals.Cat;
import Task2.Animals.Dog;

import java.util.HashMap;
import java.util.Map;

// DO NOT MAKE CHANGES
public class OOPSimulator {

    /*
    This simulates the section that stores function codes
    Format: address -> function code
     */
    Map<Integer, Func> functions = new HashMap<>();

    /*
    This simulates the section that stores virtual tables
    Format: address -> function with its address
     */
    Map<Integer, Map<String, Integer>> vTables = new HashMap<>();

    /*
    This simulates the object section that store object members and metadata
    Format: address -> member + metadata
     */
    Map<Integer, MemoryObject> objects = new HashMap<>();

    private int nextObjectAddress = 60;  // starting point

    public OOPSimulator() {
        functions.put(10,   // all the 10, 20, and 30, etc. seen below are simulated (fictitious) memory addresses
                new Func("getName",
                        name -> "Pet class (getName): " + name));
        functions.put(20,
                new Func("speak",
                        msg -> {
                            System.out.println("Dog class (speak): Woof~ " + (msg != null ? msg : ""));
                            return (msg != null ? "'" + msg + "'" : "") + " spoken";
                        }
                ));

        functions.put(30,
                new Func("speak",
                        msg -> {
                            System.out.println("Cat class (speak): Meow~ " + (msg != null ? msg : ""));
                            return (msg != null ? "'" + msg + "'" : "") + " spoken";
                        }
                ));


        //----//

        vTables.put(
                40,
                new HashMap<String, Integer>() {{
                    put("getName", 10);
                    put("speak", 20);
                }}
        );
        vTables.put(
                50,
                new HashMap<String, Integer>() {{
                    put("getName", 10);
                    put("speak", 30);
                }}
        );
    }

    public Reference newDog(String name, int age, String owner) {
        int id = nextObjectAddress;
        nextObjectAddress += 10; // here address+10 is also a simulated (fictitious) memory address for objects
        objects.put(id, new MemoryObject(new Dog(name, age, owner), 40));
        return new Reference(id);
    }

    public Reference newCat(String name, int age, String favToy) {
        int id = nextObjectAddress;
        nextObjectAddress += 10; // here id+10 is also a simulated (fictitious) memory address for objects
        objects.put(id, new MemoryObject(new Cat(name, age, favToy), 50));
        return new Reference(id);
    }

    public String call(Reference ref, String funcName, String arg) {
        /*
         TODO: add code here that make call to the function 'funcName' in object pointed to by ref with argument arg
          Remember to use the unit test for this to understand what's the expected behaviors.
         */

        return null; // TODO: Replace this placeholder with your own code
    }

    private static String callFunc(MemoryObject memoryObject, Func function, String arg) {
        if (function.funcWithArgReturn != null) {
            if ("getName".equals(function.name)) {
                return function.funcWithArgReturn.apply(memoryObject.pet.name);
            } else if ("speak".equals(function.name)) {
                return function.funcWithArgReturn.apply(arg);
            }
        }
        return null;
    }
}
