package nl.qien.motorbike.reflection;

import nl.qien.motorbike.model.Motorbike;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/*
Reflection demo

First: what is reflection.
Reflection is THE java way to look into the structure of classes in a meta way.
e.g. print the list of fields of a class
e.g. print the list of methods of a class
e.g. print the list of constructors of a class
e.g. print the annotations on the class

Why would you want to do that?
e.g. When we are using JSON how can Jackson know that he has a method setColor or getColr
e.g. When we are using Jackson to write and to read XML, how could Jackson know the properties

=> That are (some) examples why we have to and want to use Reflection


 */
public class ReflectionDemo {

    public static void main(String[] args) {

        // 1. get the fields of the motorbike class
        {

            System.out.println("Fields: ======================");
            Field[] fields = Motorbike.class.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }
        }


        // 2. print the methods
        {
            System.out.println("Methods: ======================");
            Method[] methods = Motorbike.class.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
            }
        }
        //3. print the constructors
        {

            // how many constructors?
            System.out.println(Motorbike.class.getConstructors().length);

            Constructor<?>[] constructors = Motorbike.class.getConstructors();

            for (Constructor<?> constructor : constructors) {

                System.out.println("Constructor:");


                // now ... we are interesting in the parameters of the constructors???

                for (Parameter parameter : constructor.getParameters()) {

                    System.out.printf("\tConstructor with type %s and name %s %n", parameter.getName(), parameter.getType().toString());

                }
            }
        }

        // 4. Print the annotations
        {

            //Question for group: Why do we see only one annotation (@Entity) ???
            Annotation[] annotations = Motorbike.class.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.printf("The class %s has annotation %s which is of type %s %n", Motorbike.class.toString(), annotation, annotation.annotationType());
            }
        }

    }
}
