package org.example;

import java.util.Objects;

public class NumberOfSelledPiecesByBrand {
    private int numberPiecesKia;
    private int numberPiecesDaewoo;

    public int getNumberPiecesKia() {
        return numberPiecesKia;
    }

    public void setNumberPiecesKia(int numberPiecesKia) {
        this.numberPiecesKia = numberPiecesKia;
    }

    public int getNumberPiecesDaewoo() {
        return numberPiecesDaewoo;
    }

    public void setNumberPiecesDaewoo(int numberPiecesDaewoo) {
        this.numberPiecesDaewoo = numberPiecesDaewoo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NumberOfSelledPiecesByBrand that = (NumberOfSelledPiecesByBrand) o;
        return numberPiecesKia == that.numberPiecesKia && numberPiecesDaewoo == that.numberPiecesDaewoo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberPiecesKia, numberPiecesDaewoo);
    }

    @Override
    public String toString() {
        return "NumberOfSelledPiecesByBrand{" +
                "numberPiecesKia=" + numberPiecesKia +
                ", numberPiecesDaewoo=" + numberPiecesDaewoo +
                '}';
    }
}
