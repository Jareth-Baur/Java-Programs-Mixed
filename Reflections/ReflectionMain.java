package Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionMain {
    public static void main(String[] args) throws Exception {
        Cat myCat = new Cat("Stella", 6);
        Field[] catFields = myCat.getClass().getDeclaredFields();
        for (Field field : catFields) {
            if (field.getName().equals("NAME")) {
                field.setAccessible(true); // sets the private fields to be accessible
                // setting a new value for the private and final fields on cat class
                field.set(myCat, "JImmy Mcgill");
            }
        }
        Method[] catMethods = myCat.getClass().getDeclaredMethods();
        for (Method method : catMethods) {
            if (method.getName().equals("heyThisIsPrivate")) {
                method.setAccessible(true); // sets the private methods to accessible
                method.invoke(myCat); // performs the method
            }
            if (method.getName().equals("thisIsAPublicStaticMethod")) {
                method.setAccessible(true); // sets the private methods to accessible
                method.invoke(null); // performs the method
            }
            System.out.println(method.getName());
        }
        System.out.println(myCat.getName());
    }
}
