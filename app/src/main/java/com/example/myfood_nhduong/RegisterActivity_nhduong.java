package com.example.myfood_nhduong;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity_nhduong extends AppCompatActivity {

    EditText edtUsername, edtPassword, edtRePassword;
    ImageButton btnRegister;
    TextView txtBackLogin;

    DatabaseHelper_NHDuong dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_nhduong); // Đảm bảo tên file đúng

        // Ánh xạ
        edtUsername = findViewById(R.id.edtUsernameReg_NHDuong);
        edtPassword = findViewById(R.id.edtPasswordReg_NHDuong);
        edtRePassword = findViewById(R.id.edtRePassword_NHDuong);
        btnRegister = findViewById(R.id.btnRegister_NHDuong);
        txtBackLogin = findViewById(R.id.txtBackLogin_NHDuong);

        dbHelper = new DatabaseHelper_NHDuong(this);

        // Xử lý đăng ký
        btnRegister.setOnClickListener(v -> {
            String user = edtUsername.getText().toString().trim();
            String pass = edtPassword.getText().toString().trim();
            String repass = edtRePassword.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            } else if (!pass.equals(repass)) {
                Toast.makeText(this, "Mật khẩu nhập lại không khớp", Toast.LENGTH_SHORT).show();
            } else {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("username", user);
                values.put("password", pass);
                long result = db.insert("User_NHDuong", null, values);
                if (result != -1) {
                    Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, LoginActivity_NHDuong.class));
                    finish();
                } else {
                    Toast.makeText(this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý quay lại đăng nhập
        txtBackLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity_NHDuong.class));
            finish();
        });
    }
}
