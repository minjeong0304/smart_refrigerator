package com.example.navigationdraweractivity.ui.home;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.navigationdraweractivity.R;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private ArrayList<User> arrayList;
    private Context context;
    private Intent intent;
    private ArrayList<User2> arrayList2;
    private ImageView load;  //


    public CustomAdapter(ArrayList<User> arrayList, ArrayList<User2> arrayList2, Context context){
        this.arrayList = arrayList;
        this.arrayList2 = arrayList2;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()); //추가

        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.iv_profile);
        holder.tv_name.setText(arrayList.get(position).getName());
        if(arrayList.get(position).getName().equals("썩은사과")){
            holder.tv_count.setText(", "+arrayList2.get(0).getRottenapple() + " 개 ");
        }
        if(arrayList.get(position).getName().equals("감자")){
            holder.tv_count.setText(", "+arrayList2.get(0).getPotato() + " 개 ");
        }
        if(arrayList.get(position).getName().equals("계란")){
            holder.tv_count.setText(", "+arrayList2.get(0).getEgg() + " 개 ");
        }
        if(arrayList.get(position).getName().equals("대파")){
            holder.tv_count.setText(", "+arrayList2.get(0).getLeek() + " 개 ");
        }
        if(arrayList.get(position).getName().equals("도넛")){
            holder.tv_count.setText(", "+arrayList2.get(0).getDonut() + " 개 ");
        }
        if(arrayList.get(position).getName().equals("마늘")){
            holder.tv_count.setText(", "+arrayList2.get(0).getGarlic() + " 개 ");
        }
        if(arrayList.get(position).getName().equals("빨간피망")){
            holder.tv_count.setText(", "+arrayList2.get(0).getPaprika() + " 개 ");
        }
        if(arrayList.get(position).getName().equals("사과")){
            holder.tv_count.setText(", "+arrayList2.get(0).getApple() + " 개 ");
        }
        if(arrayList.get(position).getName().equals("스팸")){
            holder.tv_count.setText(", "+arrayList2.get(0).getSpam() + " 개 ");
        }


        //추가 intent
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = holder.getAdapterPosition();

                intent = new Intent(view.getContext(), ItemActivity.class);
                //intent.putExtra("profile", arrayList.get(pos).getProfile());
                intent.putExtra("name", arrayList.get(pos).getName());
                intent.putExtra("kcal", arrayList.get(pos).getKcal());
                intent.putExtra("carbs", arrayList.get(pos).getCarbs());
                intent.putExtra("protein", arrayList.get(pos).getProtein());
                intent.putExtra("fat", arrayList.get(pos).getFat());
                intent.putExtra("sugar", arrayList.get(pos).getSugar());

                view.getContext().startActivity(CustomAdapter.this.intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_profile, load;  //
        TextView tv_name, tv_count;
        TextView item_detail_name, item_detail_cal, item_detail_carbs, item_detail_protein, item_detail_fat,item_datail_sugar;
        ImageView it_profile;
        ArrayList<User> arrayList;
        ArrayList<User2> arrayList2;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = itemView.findViewById(R.id.iv_profile);
//            this.load = itemView.findViewById(R.id.r_image);  //
            this.tv_name = itemView.findViewById(R.id.tv_name);
            this.tv_count = itemView.findViewById(R.id.tv_count);
            this.it_profile = itemView.findViewById(R.id.item_detail_image);
            this.item_detail_name = itemView.findViewById(R.id.item_detail_name);
            this.item_detail_cal = itemView.findViewById(R.id.item_detail_cal);
            this.item_detail_carbs = itemView.findViewById(R.id.item_detail_carbs);
            this.item_detail_protein = itemView.findViewById(R.id.item_detail_protein);
            this.item_detail_fat = itemView.findViewById(R.id.item_detail_fat);
            this.item_datail_sugar = itemView.findViewById(R.id.item_detail_sugar);
        }

    }

}
