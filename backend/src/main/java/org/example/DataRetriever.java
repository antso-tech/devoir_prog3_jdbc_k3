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
            TotalSelledPieces totalSelledPiece = new TotalSelledPieces();

            PreparedStatement ps = connection.prepareStatement(findTotalSelledPiecesSQL);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
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
}
