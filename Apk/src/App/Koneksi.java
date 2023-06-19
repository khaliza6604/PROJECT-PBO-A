/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public class Koneksi {
    private static Connection koneksi;

    public static Connection getKoneksi() {
    if (koneksi == null) {
        try {
            String url = "jdbc:mysql://localhost:3306/market";
            String user = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(url, user, password);
            System.out.println("Berhasil");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    return koneksi;
}
    public static void main(String args[]){
        getKoneksi();
}

}
