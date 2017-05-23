import java.util.Scanner;
import java.lang.reflect.Constructor;

class Singleton {
    private Singleton() {}
    public String str;
    private static Singleton instance = null;
    public static Singleton getSingleInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

/*
    "The singleton pattern is a design pattern that restricts the instantiation
    of a class to one object. This is useful when exactly one object is needed to coordinate actions across the system." 

    How to write the singleton design pattern

 */