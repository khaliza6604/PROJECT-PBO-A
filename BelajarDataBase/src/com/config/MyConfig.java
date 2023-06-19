package com.config;

import com.config.MyConfig;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public abstract class MyConfig {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_el";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultset;

    public static void connection() {
        try {
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection: Error");
        }
    }

    // READ
    public static void getDatabase() {
        MyConfig.connection();
        try {
            statement = connect.createStatement();
            resultset = statement.executeQuery("SELECT * FROM tb_el1 ORDER BY ID DESC");

            while (resultset.next()) {
                System.out.println(
                        resultset.getString("Nama") + ": Rp." +
                                resultset.getString("Harga") + " (" +
                                resultset.getString("Jumlah") + ")");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertData() {
        String namaBaru;
        long hargaBaru;
        int jumlahBaru;

        Scanner input = new Scanner(System.in);

        System.out.print("Nama  : ");
        namaBaru = input.nextLine();

        System.out.print("Harga : ");
        hargaBaru = input.nextLong();

        System.out.print("Jumlah : ");
        jumlahBaru = input.nextInt();

        MyConfig.connection();

        try {
            PreparedStatement preparedStatement = connect
                    .prepareStatement("INSERT INTO `tb_el1` (`ID`, `Nama`, `Harga`, `Jumlah`) VALUES (NULL, ?, ?, ?)");
            preparedStatement.setString(1, namaBaru);
            preparedStatement.setLong(2, hargaBaru);
            preparedStatement.setInt(3, jumlahBaru);
            preparedStatement.executeUpdate();

            System.out.println("Data berhasil di simpan");

            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editData() {
        int jumlah = 45;
        try {
            statement = connect.createStatement();
            statement.executeUpdate("UPDATE `tb_el1` SET `Jumlah` = " + jumlah + " WHERE `tb_el1`.`ID` = 'id_value'");

            System.out.println("Data berhasil di Update");

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteData() {
        Scanner input = new Scanner(System.in);

        System.out.print("ID data yang ingin dihapus : ");
        int id = input.nextInt();

        MyConfig.connection();

        try {
            statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM `tb_el1` WHERE `ID` = " + id);

            System.out.println("Data berhasil dihapus");

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}