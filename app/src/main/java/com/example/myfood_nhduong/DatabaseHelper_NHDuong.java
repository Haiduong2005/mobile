package com.example.myfood_nhduong;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper_NHDuong extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Food_NHDuong.db";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper_NHDuong(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Bảng User
        String createUserTable = "CREATE TABLE User_NHDuong (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT NOT NULL," +
                "password TEXT NOT NULL)";
        db.execSQL(createUserTable);

        // Bảng Restaurant
        String createRestaurantTable = "CREATE TABLE Restaurant_NHDuong (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "address TEXT," +
                "image TEXT)";
        db.execSQL(createRestaurantTable);

        // Bảng Food (liên kết Restaurant)
        String createFoodTable = "CREATE TABLE Food_NHDuong (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "price REAL," +
                "size TEXT," +
                "description TEXT," +
                "image TEXT," +
                "restaurantId INTEGER," +
                "FOREIGN KEY(restaurantId) REFERENCES Restaurant_NHDuong(id))";
        db.execSQL(createFoodTable);

        insertInitialData(db); // Chèn dữ liệu mẫu
    }

    private void insertInitialData(SQLiteDatabase db) {
        // 5 User
        db.execSQL("INSERT INTO User_NHDuong (username, password) VALUES ('admin', '123')");
        db.execSQL("INSERT INTO User_NHDuong (username, password) VALUES ('thinh1', '111')");
        db.execSQL("INSERT INTO User_NHDuong (username, password) VALUES ('thinh2', '222')");
        db.execSQL("INSERT INTO User_NHDuong (username, password) VALUES ('thinh3', '333')");
        db.execSQL("INSERT INTO User_NHDuong (username, password) VALUES ('thinh4', '444')");

        // 5 Restaurant
        db.execSQL("INSERT INTO Restaurant_NHDuong (name, address, image) VALUES ('Quán Ăn A', '123 Đường A', 'img1.jpg')");
        db.execSQL("INSERT INTO Restaurant_NHDuong (name, address, image) VALUES ('Quán Ăn B', '456 Đường B', 'img2.jpg')");
        db.execSQL("INSERT INTO Restaurant_NHDuong (name, address, image) VALUES ('Quán Ăn C', '789 Đường C', 'img3.jpg')");
        db.execSQL("INSERT INTO Restaurant_NHDuong (name, address, image) VALUES ('Quán Ăn D', '135 Đường D', 'img4.jpg')");
        db.execSQL("INSERT INTO Restaurant_NHDuong (name, address, image) VALUES ('Quán Ăn E', '246 Đường E', 'img5.jpg')");

        // 10 Food
        db.execSQL("INSERT INTO Food_NHDuong (name, price, size, description, image, restaurantId) VALUES ('Phở Bò', 30000, 'Small', 'Phở bò thơm ngon', 'pho.jpg', 1)");
        db.execSQL("INSERT INTO Food_NHDuong (name, price, size, description, image, restaurantId) VALUES ('Bún Chả', 35000, 'Medium', 'Bún chả Hà Nội', 'buncha.jpg', 1)");
        db.execSQL("INSERT INTO Food_NHDuong (name, price, size, description, image, restaurantId) VALUES ('Cơm Tấm', 40000, 'Large', 'Cơm tấm sườn bì', 'comtam.jpg', 2)");
        db.execSQL("INSERT INTO Food_NHDuong (name, price, size, description, image, restaurantId) VALUES ('Hủ Tiếu', 32000, 'Small', 'Hủ tiếu Nam Vang', 'hutieu.jpg', 2)");
        db.execSQL("INSERT INTO Food_NHDuong (name, price, size, description, image, restaurantId) VALUES ('Bánh Xèo', 27000, 'Medium', 'Bánh xèo miền Tây', 'banhxeo.jpg', 3)");
        db.execSQL("INSERT INTO Food_NHDuong (name, price, size, description, image, restaurantId) VALUES ('Gỏi Cuốn', 15000, 'Small', 'Gỏi cuốn tôm thịt', 'goicuon.jpg', 3)");
        db.execSQL("INSERT INTO Food_NHDuong (name, price, size, description, image, restaurantId) VALUES ('Mì Quảng', 33000, 'Medium', 'Mì Quảng Đà Nẵng', 'miquang.jpg', 4)");
        db.execSQL("INSERT INTO Food_NHDuong (name, price, size, description, image, restaurantId) VALUES ('Bánh Mì', 20000, 'Small', 'Bánh mì trứng', 'banhmi.jpg', 4)");
        db.execSQL("INSERT INTO Food_NHDuong (name, price, size, description, image, restaurantId) VALUES ('Cháo Gà', 25000, 'Small', 'Cháo gà nóng hổi', 'chaoga.jpg', 5)");
        db.execSQL("INSERT INTO Food_NHDuong (name, price, size, description, image, restaurantId) VALUES ('Trà Sữa', 28000, 'Medium', 'Trà sữa truyền thống', 'trasua.jpg', 5)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS User_NHDuong");
        db.execSQL("DROP TABLE IF EXISTS Restaurant_NHDuong");
        db.execSQL("DROP TABLE IF EXISTS Food_NHDuong");
        onCreate(db);
    }
}
