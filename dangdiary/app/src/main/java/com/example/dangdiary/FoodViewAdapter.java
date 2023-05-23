package com.example.dangdiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FoodViewAdapter extends BaseAdapter {
    Context context;
    ArrayList<FoodViewItem> FoodViewItemArrList;

    ImageView meal_photo;
    TextView mealType;
    TextView mealTime;
//    TextView amount;
    TextView menuName;
    TextView dangAmount;

    public FoodViewAdapter(Context context, ArrayList<FoodViewItem> FoodViewItemArrList){
        this.context = context;
        this.FoodViewItemArrList = FoodViewItemArrList;
    }

    @Override
    public int getCount() { // 이 리스트뷰가 몇 개의 아이템을 가지고 있는지를 알려주는 함수 : arrayList의 size(갯수)만큼 가지고 잇음
        //return 0;
        return this.FoodViewItemArrList.size();
    }

    @Override
    public Object getItem(int position) { // 현재 어떤 아이템인지를 알려주는 부분
        return this.FoodViewItemArrList.get(position);
    }

    @Override
    public long getItemId(int position) { // 현재 어떤 포지션인지를 알려주는 부분
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { // 리스크뷰에서 아이템과 xml을 연결하여 화면에 표시해주는 부분->여기에서 반복문이 실행, 순차적으로 한 칸씩 화면 구성
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.foodview_listview,null); // 화면에 나타낼 뷰 지정-반복될 xml 파일 적어주기
            meal_photo = (ImageView) convertView.findViewById(R.id.meal_photo);
            mealType = (TextView)convertView.findViewById(R.id.mealType);
            mealTime = (TextView) convertView.findViewById(R.id.mealTime);
//            amount = (TextView) convertView.findViewById(R.id.amount);
            dangAmount = (TextView) convertView.findViewById(R.id.dangAmount);
            menuName = (TextView) convertView.findViewById(R.id.menuName);
        }
        meal_photo.setImageResource(FoodViewItemArrList.get(position).getFood_photo());
        mealType.setText(FoodViewItemArrList.get(position).getMealType());
        mealTime.setText(FoodViewItemArrList.get(position).getInputTime().toString()); // localdatetime으로 받아온 것을 String 형태로 다시 바꿔줌
//        amount.setText(FoodViewItemArrList.get(position).getAmount());
        dangAmount.setText(FoodViewItemArrList.get(position).getFoodSugar());
        menuName.setText(FoodViewItemArrList.get(position).getMenuName());
        return convertView;
    }
}
