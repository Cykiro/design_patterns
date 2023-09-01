package org.example.exercises.design_patterns.factory_method.package_detail;

public class PackageGenerator {
    static public Package createPackage(int weigth, String from, String to){
        Package aPackage = new Package(weigth, from,to);
        return aPackage;
    }


}
