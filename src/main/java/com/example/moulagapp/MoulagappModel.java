package com.example.moulagapp;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class MoulagappModel {

    private double fund;
    private int type;
    private String description;
    private String category;
    private String created_at;

    private Statement stmt;

    public MoulagappModel()
    {
        stmt = connectDB();
    }

    private Statement connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/finance";
            Connection con = DriverManager.getConnection(url, "admin", "admin");
            Statement stmt = con.createStatement();
            return stmt;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double getFund()
    {
        try
        {
            String sql = "SELECT solde FROM finance.transactions ORDER BY id DESC LIMIT 1";
            ResultSet res = stmt.executeQuery(sql);
            while (res.next())
            {
                fund = res.getInt("solde");
            }

            return fund;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Historique> getHistory()
    {
        try
        {
            ArrayList<Historique> array = new ArrayList<>();
            String sql = "SELECT * FROM finance.transactions";
            ResultSet res = stmt.executeQuery(sql);
            while (res.next())
            {
                array.add(new Historique(
                        res.getInt("id"),
                        res.getDouble("solde"),
                        res.getInt("type"),
                        res.getString("description"),
                        res.getDouble("montant"),
                        res.getString("categorie"),
                        res.getDate("created_at")
                ));
            }

            return array;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public void register(double fund, int type, double amount, String description, LocalDate date, String category)
    {
        try {
            String sql = "INSERT INTO finance.transactions (solde, type, description, montant, categorie, created_at) VALUES ('"+ fund +"', '"+ type +"', '"+ description +"', '"+ amount +"', '"+ category +"', '"+ date +"')";
            stmt.execute(sql);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public int getType(int id)
    {
        try
        {
            String sql = "SELECT type FROM finance.transactions WHERE id = "+ id +"";
            ResultSet res = stmt.executeQuery(sql);
            while(res.next())
            {
                type = res.getInt("type");
            }

            return type;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
