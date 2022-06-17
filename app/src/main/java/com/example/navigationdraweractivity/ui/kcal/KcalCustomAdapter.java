package com.example.navigationdraweractivity.ui.kcal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdraweractivity.R;

import java.util.ArrayList;

public class KcalCustomAdapter extends RecyclerView.Adapter<KcalCustomAdapter.CustomViewHolder> {

    private Context context;
    private ArrayList<User2> arrayList;

    private double Kcal_potato=0, carbs_potato=0, fat_potato=0, protein_potato=0;
    private double Kcal_egg=0, carbs_egg=0, fat_egg=0, protein_egg=0;
    private double Kcal_leek=0, carbs_leek=0, fat_leek=0, protein_leek=0;
    private double Kcal_donut=0, carbs_donut=0, fat_donut=0, protein_donut=0;
    private double Kcal_garlic=0, carbs_garlic=0, fat_garlic=0, protein_garlic=0;
    private double Kcal_paprika=0, carbs_paprika=0, fat_paprika=0, protein_paprika=0;
    private double Kcal_apple=0, carbs_apple=0, fat_apple=0, protein_apple=0;
    private double Kcal_spam=0, carbs_spam=0, fat_spam=0, protein_spam=0;
    private double kcal_total=0, carbs_total=0, fat_total=0, protein_total=0;


    public KcalCustomAdapter(ArrayList<User2> arrayList, Context context){
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = LayoutInflater.from(context).inflate(R.layout.showkcal, parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return  holder;
    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        if(Integer.parseInt(arrayList.get(1).getPotato()) - Integer.parseInt(arrayList.get(0).getPotato()) > 0){
            Kcal_potato = 140 * (Integer.parseInt(arrayList.get(1).getPotato()) - Integer.parseInt(arrayList.get(0).getPotato()));
            carbs_potato = 30 * (Integer.parseInt(arrayList.get(1).getPotato()) - Integer.parseInt(arrayList.get(0).getPotato()));
            protein_potato = 4 * (Integer.parseInt(arrayList.get(1).getPotato()) - Integer.parseInt(arrayList.get(0).getPotato()));
            fat_potato = 0.3 * (Integer.parseInt(arrayList.get(1).getPotato()) - Integer.parseInt(arrayList.get(0).getPotato()));
        }
        if(Integer.parseInt(arrayList.get(1).getEgg()) - Integer.parseInt(arrayList.get(0).getEgg()) > 0){
            Kcal_egg = 70 * (Integer.parseInt(arrayList.get(1).getEgg()) - Integer.parseInt(arrayList.get(0).getEgg()));
            carbs_egg = 2 * (Integer.parseInt(arrayList.get(1).getEgg()) - Integer.parseInt(arrayList.get(0).getEgg()));
            protein_egg = 7 * (Integer.parseInt(arrayList.get(1).getEgg()) - Integer.parseInt(arrayList.get(0).getEgg()));
            fat_egg = 5 * (Integer.parseInt(arrayList.get(1).getEgg()) - Integer.parseInt(arrayList.get(0).getEgg()));
        }
        if(Integer.parseInt(arrayList.get(1).getLeek()) - Integer.parseInt(arrayList.get(0).getLeek()) > 0){
            Kcal_leek = 23 * (Integer.parseInt(arrayList.get(1).getLeek()) - Integer.parseInt(arrayList.get(0).getLeek()));
            carbs_leek = 5 * (Integer.parseInt(arrayList.get(1).getLeek()) - Integer.parseInt(arrayList.get(0).getLeek()));
            protein_leek = 2 * (Integer.parseInt(arrayList.get(1).getLeek()) - Integer.parseInt(arrayList.get(0).getLeek()));
            fat_leek = 3 * (Integer.parseInt(arrayList.get(1).getLeek()) - Integer.parseInt(arrayList.get(0).getLeek()));
        }
        if(Integer.parseInt(arrayList.get(1).getDonut()) - Integer.parseInt(arrayList.get(0).getDonut()) > 0){
            Kcal_donut = 294 * (Integer.parseInt(arrayList.get(1).getDonut()) - Integer.parseInt(arrayList.get(0).getDonut()));
            carbs_donut = 31.4 * (Integer.parseInt(arrayList.get(1).getDonut()) - Integer.parseInt(arrayList.get(0).getDonut()));
            protein_donut = 4.5 * (Integer.parseInt(arrayList.get(1).getDonut()) - Integer.parseInt(arrayList.get(0).getDonut()));
            fat_donut = 16.7 * (Integer.parseInt(arrayList.get(1).getDonut()) - Integer.parseInt(arrayList.get(0).getDonut()));
        }
        if(Integer.parseInt(arrayList.get(1).getGarlic()) - Integer.parseInt(arrayList.get(0).getGarlic()) > 0){
            Kcal_garlic = 123 * (Integer.parseInt(arrayList.get(1).getGarlic()) - Integer.parseInt(arrayList.get(0).getGarlic()));
            carbs_garlic = 26 * (Integer.parseInt(arrayList.get(1).getGarlic()) - Integer.parseInt(arrayList.get(0).getGarlic()));
            protein_garlic = 7 * (Integer.parseInt(arrayList.get(1).getGarlic()) - Integer.parseInt(arrayList.get(0).getGarlic()));
            fat_garlic = 0.16 * (Integer.parseInt(arrayList.get(1).getGarlic()) - Integer.parseInt(arrayList.get(0).getGarlic()));
        }
        if(Integer.parseInt(arrayList.get(1).getPaprika()) - Integer.parseInt(arrayList.get(0).getPaprika()) > 0){
            Kcal_paprika = 28 * (Integer.parseInt(arrayList.get(1).getPaprika()) - Integer.parseInt(arrayList.get(0).getPaprika()));
            carbs_paprika = 7 * (Integer.parseInt(arrayList.get(1).getPaprika()) - Integer.parseInt(arrayList.get(0).getPaprika()));
            protein_paprika = 1.17 * (Integer.parseInt(arrayList.get(1).getPaprika()) - Integer.parseInt(arrayList.get(0).getPaprika()));
            fat_paprika = 0.1 * (Integer.parseInt(arrayList.get(1).getPaprika()) - Integer.parseInt(arrayList.get(0).getPaprika()));
        }
        if(Integer.parseInt(arrayList.get(1).getApple()) - Integer.parseInt(arrayList.get(0).getApple()) > 0){
            Kcal_apple = 56 * (Integer.parseInt(arrayList.get(1).getApple()) - Integer.parseInt(arrayList.get(0).getApple()));
            carbs_apple = 15.17 * (Integer.parseInt(arrayList.get(1).getApple()) - Integer.parseInt(arrayList.get(0).getApple()));
            protein_apple = 0.21 * (Integer.parseInt(arrayList.get(1).getApple()) - Integer.parseInt(arrayList.get(0).getApple()));
            fat_apple = 0.04 * (Integer.parseInt(arrayList.get(1).getApple()) - Integer.parseInt(arrayList.get(0).getApple()));
        }
        if(Integer.parseInt(arrayList.get(1).getSpam()) - Integer.parseInt(arrayList.get(0).getSpam()) > 0){
            Kcal_spam = 610 * (Integer.parseInt(arrayList.get(1).getSpam()) - Integer.parseInt(arrayList.get(0).getSpam()));
            carbs_spam = 4 * (Integer.parseInt(arrayList.get(1).getSpam()) - Integer.parseInt(arrayList.get(0).getSpam()));
            protein_spam = 28 * (Integer.parseInt(arrayList.get(1).getSpam()) - Integer.parseInt(arrayList.get(0).getSpam()));
            fat_spam = 54 * (Integer.parseInt(arrayList.get(1).getSpam()) - Integer.parseInt(arrayList.get(0).getSpam()));
        }

        kcal_total = Kcal_potato + Kcal_egg + Kcal_leek + Kcal_donut + Kcal_garlic + Kcal_paprika + Kcal_apple + Kcal_spam;
        carbs_total = carbs_potato + carbs_egg + carbs_leek + carbs_donut + carbs_garlic + carbs_paprika + carbs_apple +carbs_spam;
        protein_total = protein_potato + protein_egg + protein_leek + protein_donut + protein_garlic + protein_paprika + protein_apple + protein_spam;
        fat_total = fat_potato + fat_egg + fat_leek + fat_donut + fat_garlic + fat_paprika + fat_apple + fat_spam;

        String kcal = String.format("%.2f", kcal_total);
        String carbs = String.format("%.2f", carbs_total);
        String protein = String.format("%.2f", protein_total);
        String fat = String.format("%.2f", fat_total);

        holder.show_k.setText("칼로리 : "+kcal + " kcal");
        holder.show_c.setText("탄수화물 : "+carbs+" g");
        holder.show_p.setText("단백질 : "+protein+" g");
        holder.show_f.setText("지방 : "+fat+" g");

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? (arrayList.size()-1) : 0);
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {


        TextView show_k, show_c, show_p, show_f;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.show_k = itemView.findViewById(R.id.show_kcal);
            this.show_c = itemView.findViewById(R.id.show_carbs);
            this.show_p = itemView.findViewById(R.id.show_protein);
            this.show_f = itemView.findViewById(R.id.show_fat);
        }
    }


}
