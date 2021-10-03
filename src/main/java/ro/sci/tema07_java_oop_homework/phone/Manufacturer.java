package ro.sci.tema07_java_oop_homework.phone;

import java.util.ArrayList;
import java.util.List;

public abstract class Manufacturer {

    private String manufacturerName;
    private static List<Model> modelList = new ArrayList<>();

    public Manufacturer(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public List<Model> getModelList() {
        return modelList;
    }

    public abstract void addModel(Model model);

    public static void listModels(String manufacturer) {
        for (Model model : modelList) {
            if (model.getManufacturerName().equals(manufacturer)) {
                System.out.println(model);
            }
        }

    }


}
