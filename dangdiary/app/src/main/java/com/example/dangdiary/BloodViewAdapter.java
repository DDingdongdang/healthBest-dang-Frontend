package com.example.dangdiary;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BloodViewAdapter extends RecyclerView.Adapter<BloodViewAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mealType; // 아침점심저녁
        TextView mealTime; // 식전식후
        TextView date_hour;
        TextView date_minute;
        TextView sugar; //혈당량


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mealType = (TextView) itemView.findViewById(R.id.mealType);
            mealTime = (TextView) itemView.findViewById(R.id.mealTime);
            date_hour = (TextView) itemView.findViewById(R.id.date_hour);
            date_minute = (TextView) itemView.findViewById(R.id.date_minute);
            sugar = (TextView) itemView.findViewById(R.id.sugar);
        }
    }

    private ArrayList<BloodViewItem> mList = null;

    public BloodViewAdapter(ArrayList<BloodViewItem> mList) {
        this.mList = mList;
    }

    // 아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.bloodview_listview, parent, false);
        BloodViewAdapter.ViewHolder vh = new BloodViewAdapter.ViewHolder(view);
        return vh;
    }

    // position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull BloodViewAdapter.ViewHolder holder, int position) {
        BloodViewItem item = mList.get(position);

        holder.mealTime.setText(item.getMealTime());
        holder.mealType.setText(item.getMealType());
        holder.sugar.setText(String.valueOf(item.getSugar()));
        holder.date_hour.setText(String.valueOf(item.getDate_hour()));
        holder.date_minute.setText(String.valueOf(item.getDate_minute()));
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


}
