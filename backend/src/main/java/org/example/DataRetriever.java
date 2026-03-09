package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {
    public List<TotalSelledPieces> findTotalSelledPieces(){
        DBConnection dbConnection = new DBConnection();
        String findTotalSelledPiecesSQL = """
                SELECT m.marque, m.modele, COUNT(p.id)
                as total_piece_auto
                FROM modele_voiture m
                left join piece_auto p on p.id_modele_voiture = m.id
                GROUP BY m.marque, m.modele""";
        try(Connection connection = dbConnection.getConnection()) {
            List<TotalSelledPieces> totalSelledPieces = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement(findTotalSelledPiecesSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                TotalSelledPieces totalSelledPiece = new TotalSelledPieces();
                Brand brand = Brand.valueOf(rs.getString("marque"));
                Model model = Model.valueOf(rs.getString("modele"));
                int totalPieces = rs.getInt("total_piece_auto");

                totalSelledPiece.setBrand(brand);
                totalSelledPiece.setModel(model);
                totalSelledPiece.setTotalPieces(totalPieces);
                totalSelledPieces.add(totalSelledPiece);
            }
            return totalSelledPieces;
        }catch(SQLException e){
            throw new RuntimeException(e);

        }
    }

    public NumberOfSelledPiecesByBrand findNumberOfSelledPiecesByBrand(){
        DBConnection dbConnection = new DBConnection();
        String findNumberOfSelledPiecesByBrandSQL = """
                SELECT
                COUNT(CASE WHEN m.marque = 'KIA' THEN p.id END) AS nbre_piece_kia,
                COUNT(CASE WHEN m.marque = 'DAEWOO' THEN p.id END) AS nbre_piece_daewoo
                FROM modele_voiture m
                LEFT JOIN piece_auto p
                on p.id_modele_voiture = m.id
                """;

        try (Connection connection = dbConnection.getConnection()){
            NumberOfSelledPiecesByBrand numberOfSelledPiecesByBrand = new NumberOfSelledPiecesByBrand();

            PreparedStatement ps = connection.prepareStatement(findNumberOfSelledPiecesByBrandSQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                int numberPiecesKIA = rs.getInt("nbre_piece_kia");
                int numberPieceDaewoo = rs.getInt("nbre_piece_daewoo");

                numberOfSelledPiecesByBrand.setNumberPiecesKia(numberPiecesKIA);
                numberOfSelledPiecesByBrand.setNumberPiecesDaewoo(numberPieceDaewoo);

            }

            return numberOfSelledPiecesByBrand;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
