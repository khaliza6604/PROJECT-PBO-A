# App.java
        Pada 'App.java' terdapat pemanggilan method :
        Menu.showMenu();
        yang digunakan untuk menampilkan menu pada aplikasi

# com
## config
### 'MyConfig.java'
        Terdapat abstract class berisi keyword connection() yang akan menghubungkan program ke database
        Juga terdapat pengimplementasian method read, insert, edit, dan hapus data

## layout
### 'Menu.java'
        Berisi method showMenu() untuk menampilkan menu pilihan yang akan dijalankan program

### 'ReadData.java'
### 'InsertData.java'
### 'EditData.java'
### 'HapusData.java'

    Pada metode 'ReadData.java', 'InsertData.java', 'EditData.java', 'HapusData.java', terdapat pemanggilan dua metode dari kelas MyConfig, yaitu connection() dan getDatabase()