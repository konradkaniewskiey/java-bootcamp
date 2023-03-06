import annotations.Private;
import annotations.Public;
import annotations.ScanMe;
import classes.*;
import interfaces.MyInterface;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<MyInterface> scanMeClasses = new ArrayList<>();
    static List<MyInterface>  myInterfaceClasses = new ArrayList<>();
    public static void main(String[] args) {

        List<MyInterface> myObjectsToScan = new ArrayList<>();
        myObjectsToScan.add(new Class1());
        myObjectsToScan.add(new Class2());
        myObjectsToScan.add(new Class3());
        myObjectsToScan.add(new Class4());

        System.out.println("Classes implementing MyInterface interface:");
        findMyInterfaceClasses(myObjectsToScan);

        System.out.println("Classes with ScanMe annotation:");
        findClassesWithAnnotation(myObjectsToScan, ScanMe.class);

        System.out.println("Methods with @Private annotation inside of classes with @ScanMe annotation:");
        findMethodsInAnnotatedClasses(scanMeClasses, Private.class);

        System.out.println("Methods without custom annotations inside of classes without @ScanMe annotation:");
        findAnnotationlessMethodsInNoScanMeClasses(myObjectsToScan);

        System.out.println("All scanned classes:");
        findScannedClasses(myObjectsToScan);


    }

    public static void findMyInterfaceClasses(List<MyInterface> objects){
        for(MyInterface obj : objects) {
            if (obj instanceof MyInterface){
                myInterfaceClasses.add(obj);
            }
        }
        System.out.println(myInterfaceClasses);

    }

    public static void findClassesWithAnnotation(List<MyInterface> objects, Class<? extends Annotation> annotation) {
        for (MyInterface obj : objects) {
            if (obj.getClass().isAnnotationPresent(annotation)) {
                scanMeClasses.add(obj);
            }
        }
        System.out.println(scanMeClasses);
    }

    public static void findMethodsInAnnotatedClasses(List<MyInterface> objects, Class<? extends Annotation> annotation ){
        for (MyInterface obj: objects) {
            Method[] methods = obj.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(annotation)) {
                    System.out.println(obj.getClass() + ", " +method.getName());
                }
            }
        }
    }

    public static void findAnnotationlessMethodsInNoScanMeClasses(List<MyInterface> objects){
        for (MyInterface obj : objects){
            Class<?> scannedClass = obj.getClass();
            if(!scannedClass.isAnnotationPresent(ScanMe.class)){
                Method[] methods = scannedClass.getDeclaredMethods();
                for (Method method : methods){
                    if(!method.isAnnotationPresent(Private.class) && !method.isAnnotationPresent(Public.class)) {
                        System.out.println(scannedClass + ", " + method.getName());
                    }
                }
            }
        }

    }
    //Class: [annotation if exists] ClassName { [annotation if exists] methodName,  …next method…. }
    public static void findScannedClasses(List<MyInterface> objects){
        for(MyInterface obj : objects){
            Class<?> scannedClass = obj.getClass();
            Method[] methods = scannedClass.getDeclaredMethods();
            String output = "Class: ";
            if(scannedClass.isAnnotationPresent(ScanMe.class)){
                output += "[ScanMe] ";

            }
            output += scannedClass.getName() + " { ";
            for (Method method : methods) {
                if(method.isAnnotationPresent(Private.class) && method.isAnnotationPresent(Public.class)) {
                    output += "[Private, Public] ";
                } else if(method.isAnnotationPresent(Private.class)) {
                    output += "[Private] ";
                } else if(method.isAnnotationPresent(Public.class)){
                    output += "[Public] ";
                }
                output += method.getName() + ", ";
            }
            output += " }";
            System.out.println(output);
        }
    }

}