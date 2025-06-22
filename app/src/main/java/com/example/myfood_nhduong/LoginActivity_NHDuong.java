package com.example.myfood_nhduong;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity_NHDuong extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogin;
    TextView txtRegister;

    DatabaseHelper_NHDuong dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_nhduong);

        edtUsername = findViewById(R.id.edtUsername_NHDuong);
        edtPassword = findViewById(R.id.edtPassword_NHDuong);
        btnLogin = findViewById(R.id.btnLogin_NHDuong);
        txtRegister = findViewById(R.id.txtRegister_NHDuong);

        dbHelper = new DatabaseHelper_NHDuong(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUsername.getText().toString().trim();
                String pass = edtPassword.getText().toString().trim();

                if (checkUser_NHDuong(user, pass)) {
                    Toast.makeText(LoginActivity_NHDuong.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity_NHDuong.this, FoodListActivity_NHDuong.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity_NHDuong.this, "Sai thông tin đăng nhập", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity_NHDuong.this, RegisterActivity_NHDuong.class);
                startActivity(intent);
            }
        });
    }

    private boolean checkUser_NHDuong(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM User_NHDuong WHERE username=? AND password=?", new String[]{username, password});
        boolean result = cursor.getCount() > 0;
        cursor.close();
        return result;
    }
}
