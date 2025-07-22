package Task2;

import java.util.function.Consumer;
import java.util.function.Function;

// DO NOT MAKE CHANGES
public class Func {
    String name;
    Function<String, String> funcWithArgReturn;

    public Func(String name, Function<String, String> funcWithArgReturn) {
        this.name = name;
        this.funcWithArgReturn = funcWithArgReturn;
    }

    public Func(String name, Consumer<String> funcBody) {
        this.name = name;
    }
}

