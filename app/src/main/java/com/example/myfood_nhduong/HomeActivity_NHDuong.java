package com.example.myfood_nhduong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity_NHDuong extends AppCompatActivity {

    private LinearLayout layoutFoodList_NHDuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_nhduong);

        layoutFoodList_NHDuong = findViewById(R.id.layoutFoodList_NHDuong);

        addFoodItem("Bánh mì bò kho", "10000 VND", R.drawable.banhmi1);
        addFoodItem("Bánh mì bơ tỏi", "15000 VND", R.drawable.banhmibotoi);
        addFoodItem("Bánh mì chả", "15000 VND", R.drawable.banhmichao);
    }

    private void addFoodItem(String name, String price, int imageResId) {
        View itemView = getLayoutInflater().inflate(R.layout.food_item_nhduong, null);

        ImageView img = itemView.findViewById(R.id.imgFood_NHDuong);
        TextView txtName = itemView.findViewById(R.id.txtFoodName_NHDuong);
        TextView txtPrice = itemView.findViewById(R.id.txtFoodPrice_NHDuong);

        img.setImageResource(imageResId);
        txtName.setText(name);
        txtPrice.setText(price);

        itemView.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity_NHDuong.this, FoodDetailActivity_NHDuong.class);
            intent.putExtra("foodName", name);
            intent.putExtra("foodPrice", price);
            intent.putExtra("foodImage", imageResId);
            intent.putExtra("foodDesc", "Món ăn hấp dẫn, giòn thơm, ngon tuyệt!");
            intent.putExtra("restaurantName", "Quán bánh mì cô Mai");

            startActivity(intent);
        });

        layoutFoodList_NHDuong.addView(itemView);
    }

}
