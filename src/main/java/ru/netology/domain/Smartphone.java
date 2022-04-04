package ru.netology.domain;

public class Smartphone extends Product {
    private String modelName;
    private String manufacturerName;

    public Smartphone() {
        super();
    }

    public String getModelName() {
        return modelName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public Smartphone(int id, String name, int price, String modelName, String manufacturerName) {
        super(id, name, price);
        this.modelName = modelName;
        this.manufacturerName = manufacturerName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}
