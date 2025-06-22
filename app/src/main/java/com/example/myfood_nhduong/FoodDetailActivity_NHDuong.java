package com.example.myfood_nhduong;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FoodDetailActivity_NHDuong extends AppCompatActivity {

    int basePrice = 10000;
    int quantity = 1;

    TextView txtPrice, txtQuantity, txtFoodTitle, txtDescription;
    ImageView imgFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail_nhduong);

        // Nhận dữ liệu từ Intent gửi từ HomeActivity_NHDuong
        String foodName = getIntent().getStringExtra("foodName");
        String foodPrice = getIntent().getStringExtra("foodPrice");
        int foodImage = getIntent().getIntExtra("foodImage", R.drawable.banhmi1);
        String foodDesc = getIntent().getStringExtra("foodDesc");

        // Liên kết giao diện
        txtFoodTitle = findViewById(R.id.txtFoodTitle_NHDuong);
        txtDescription = findViewById(R.id.txtDescription_NHDuong);
        txtPrice = findViewById(R.id.txtPrice_NHDuong);
        txtQuantity = findViewById(R.id.txtQuantity_NHDuong);
        imgFood = findViewById(R.id.imgFood_NHDuong);

        Button btnSmall = findViewById(R.id.btnSmall_NHDuong);
        Button btnMedium = findViewById(R.id.btnMedium_NHDuong);
        Button btnLarge = findViewById(R.id.btnLarge_NHDuong);
        Button btnMinus = findViewById(R.id.btnMinus_NHDuong);
        Button btnPlus = findViewById(R.id.btnPlus_NHDuong);
        ImageView imgCart = findViewById(R.id.imgCart_NHDuong);

        // Hiển thị dữ liệu
        txtFoodTitle.setText(foodName);
        txtDescription.setText(foodDesc);
        txtPrice.setText(foodPrice); // giá mặc định hiển thị từ Home
        imgFood.setImageResource(foodImage);

        // Cập nhật giá động theo size
        basePrice = 10000; // mặc định nhỏ
        updatePrice();

        btnSmall.setOnClickListener(v -> {
            basePrice = 10000;
            updatePrice();
        });

        btnMedium.setOnClickListener(v -> {
            basePrice = 29000;
            updatePrice();
        });

        btnLarge.setOnClickListener(v -> {
            basePrice = 51000;
            updatePrice();
        });

        btnMinus.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                updatePrice();
            }
        });

        btnPlus.setOnClickListener(v -> {
            quantity++;
            updatePrice();
        });

        imgCart.setOnClickListener(v -> {
            Toast.makeText(this, "Đã thêm vào giỏ: " + quantity + " x " + foodName, Toast.LENGTH_SHORT).show();
        });
    }

    private void updatePrice() {
        txtQuantity.setText(String.valueOf(quantity));
        txtPrice.setText((basePrice * quantity) + " VND");
    }
}
