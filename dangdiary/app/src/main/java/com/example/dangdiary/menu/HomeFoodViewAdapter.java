package com.example.dangdiary.menu;

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

public class HomeFoodViewAdapter extends RecyclerView.Adapter<HomeFoodViewAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mealType;
        TextView menuName;
        TextView foodSugar;
        TextView carbon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mealType = (TextView) itemView.findViewById(R.id.mealType);
            menuName = (TextView) itemView.findViewById(R.id.menuName);
            carbon = (TextView) itemView.findViewById(R.id.carbon);
            foodSugar = (TextView) itemView.findViewById(R.id.foodSugar);
        }
    }

    private ArrayList<HomeFoodViewItem> fList = null;

    public HomeFoodViewAdapter(ArrayList<HomeFoodViewItem> fList) {
        this.fList = fList;
    }

    // 아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴
    @NonNull
    @Override
    public HomeFoodViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.homefoodview_listview, parent, false);
        HomeFoodViewAdapter.ViewHolder vh = new HomeFoodViewAdapter.ViewHolder(view);
        return vh;
    }

    // position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull HomeFoodViewAdapter.ViewHolder holder, int position) {
        HomeFoodViewItem item = fList.get(position);

        holder.menuName.setText(item.getMenuName());
        holder.mealType.setText(item.getMealType());
        holder.foodSugar.setText(String.valueOf(item.getFoodSugar()));
        holder.carbon.setText(String.valueOf(item.getCarbon()));
    }


    @Override
    public int getItemCount() {
        return fList.size();
    }
}
