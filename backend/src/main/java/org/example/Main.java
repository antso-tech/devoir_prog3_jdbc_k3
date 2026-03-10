package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        dbConnection.getConnection();
        DataRetriever data = new DataRetriever();
        System.out.println(data.findTotalSelledPieces());
        System.out.println(data.findNumberOfSelledPiecesByBrand());
        System.out.println(data.findPurcentageOfTotalPiecesByBrand());
    }
}