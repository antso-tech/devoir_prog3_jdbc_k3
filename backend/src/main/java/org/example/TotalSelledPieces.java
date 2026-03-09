package org.example;

import java.util.Objects;

public class TotalSelledPieces {
    private Brand brand;
    private Model model;
    private int totalPieces;

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

    public int getTotalPieces() {
        return totalPieces;
    }

    public void setTotalPieces(int totalPieces) {
        this.totalPieces = totalPieces;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TotalSelledPieces that = (TotalSelledPieces) o;
        return totalPieces == that.totalPieces && brand == that.brand && model == that.model;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, totalPieces);
    }

    @Override
    public String toString() {
        return "TotalSelledPieces{" +
                "brand=" + brand +
                ", model=" + model +
                ", totalPieces=" + totalPieces +
                '}';
    }
}
