package org.example;

import java.util.Objects;

public class PurcentageOfTotalPiecesByBrand {
    private int purcentageOfTotalPieces;
    private Brand carBrand;

    public int getPurcentageOfTotalPieces() {
        return purcentageOfTotalPieces;
    }

    public void setPurcentageOfTotalPieces(int purcentageOfTotalPieces) {
        this.purcentageOfTotalPieces = purcentageOfTotalPieces;
    }

    public Brand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(Brand carBrand) {
        this.carBrand = carBrand;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PurcentageOfTotalPiecesByBrand that = (PurcentageOfTotalPiecesByBrand) o;
        return purcentageOfTotalPieces == that.purcentageOfTotalPieces && carBrand == that.carBrand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purcentageOfTotalPieces, carBrand);
    }

    @Override
    public String toString() {
        return "PurcentageOfTotalPiecesByBrand{" +
                "purcentageOfTotalPieces=" + purcentageOfTotalPieces +
                ", carBrand=" + carBrand +
                '}';
    }
}
