package org.example.exercises.design_patterns.factory_method.package_detail;

public class Package {
    private int packageWeight;
    private Localization localization;

    public Package(int packageWeight, String from, String to) {

        this.packageWeight = packageWeight;
        this.localization = new Localization(from, to);
    }

    public int getPackageWeight() {
        return packageWeight;
    }

    public Localization getLocalization() {
        return localization;
    }
}
