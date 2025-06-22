package com.example.myfood_nhduong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FoodListActivity_NHDuong extends AppCompatActivity {

    LinearLayout foodListLayout_NHDuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list_nhduong);

        foodListLayout_NHDuong = findViewById(R.id.foodListLayout_NHDuong);

        // Thêm danh sách nhà hàng (Bước 2)
        addRestaurant("Quán bánh mì cô Mai", "hẻm 68 Bùi Thị Xuân, Q.Tân Bình", R.drawable.banhmi1);
        addRestaurant("Quán trà sữa Coffee House", "số 11 Văn Ngân, Thủ Đức", R.drawable.trasua);
        addRestaurant("Quán cơm tấm Phúc Map", "Khu phố 6, Q.5", R.drawable.comtam);
        addRestaurant("Quán bánh ngọt Lê Văn Việt", "Q.9, TP.HCM", R.drawable.banhngot);
    }

    private void addRestaurant(String name, String address, int imageRes) {
        View itemView = getLayoutInflater().inflate(R.layout.food_item_row_nhduong, null);

        ImageView img = itemView.findViewById(R.id.imgFoodItem_NHDuong);
        TextView txtName = itemView.findViewById(R.id.txtFoodNameItem_NHDuong);
        TextView txtDesc = itemView.findViewById(R.id.txtFoodDescItem_NHDuong);
        Button btn = itemView.findViewById(R.id.btnInfo_NHDuong);

        img.setImageResource(imageRes);
        txtName.setText(name);
        txtDesc.setText(address);

        btn.setOnClickListener(v -> {
            Toast.makeText(this, "Đã chọn: " + name, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, HomeActivity_NHDuong.class); // sang Câu 4
            intent.putExtra("restaurantName", name);
            startActivity(intent);
        });

        foodListLayout_NHDuong.addView(itemView);
    }
}
