package org.example;

import java.util.Objects;

public class TotalSelledPieces {
    private Brand brand;
    private Model model;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TotalSelledPieces that = (TotalSelledPieces) o;
        return brand == that.brand && model == that.model;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }

    @Override
    public String toString() {
        return "TotalSelledPieces{" +
                "brand=" + brand +
                ", model=" + model +
                '}';
    }
}
