package com.example.dangdiary.diet.java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dangdiary.R;

import java.util.ArrayList;

public class FoodViewAdapter extends RecyclerView.Adapter<FoodViewAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView food_photo;
        TextView mealType;
        TextView menuName;
        TextView date_hour;
        TextView foodSugar;
        TextView carbon;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            food_photo = (ImageView) itemView.findViewById(R.id.food_photo);
            mealType = (TextView) itemView.findViewById(R.id.mealType);
            menuName = (TextView) itemView.findViewById(R.id.menuName);
            date_hour = (TextView) itemView.findViewById(R.id.date_hour);
            foodSugar = (TextView) itemView.findViewById(R.id.foodSugar);
            carbon = (TextView) itemView.findViewById(R.id.carbon);

        }
    }

    private ArrayList<FoodViewItem> mList = null;

    public FoodViewAdapter(ArrayList<FoodViewItem> mList) {
        this.mList = mList;
    }

    // 아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.foodview_listview, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodViewItem item = mList.get(position);

        //holder.food_photo.setImageResource(R.drawable.bulgogi);
        holder.food_photo.setImageResource(item.getFood_photo());
        holder.menuName.setText(item.getMenuName());
        holder.mealType.setText(item.getMealType());
        holder.date_hour.setText(item.getDate_hour());
        holder.foodSugar.setText(String.valueOf(item.getFoodSugar()));
        holder.carbon.setText(String.valueOf(item.getCarbon()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


}