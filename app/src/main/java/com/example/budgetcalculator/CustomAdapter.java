package com.example.budgetcalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList MortID, Mort1, Mort2, Mort3, Mort4, Mort5, Mort6, Mortsum;
    CustomAdapter(Context context,
                  ArrayList mortID,
                  ArrayList mort1,
                  ArrayList mort2,
                  ArrayList mort3,
                  ArrayList mort4,
                  ArrayList mort5,
                  ArrayList mort6,
                  ArrayList mortsum){

        this.context = context;
        this.Mortsum = mortID;
        this.Mort1 = mort1;
        this.Mort2 = mort2;
        this.Mort3 = mort3;
        this.Mort4 = mort4;
        this.Mort5 = mort5;
        this.Mort6 = mort6;
        this.Mortsum = mortsum;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mort_id_text.setText(String.valueOf(MortID.get(position)));
        holder.mort_1_text.setText(String.valueOf(Mort1.get(position)));
        holder.mort_2_text.setText(String.valueOf(Mort2.get(position)));
        holder.mort_3_text.setText(String.valueOf(Mort3.get(position)));
        holder.mort_4_text.setText(String.valueOf(Mort4.get(position)));
        holder.mort_5_text.setText(String.valueOf(Mort5.get(position)));
        holder.mort_6_text.setText(String.valueOf(Mort6.get(position)));
        holder.mort_sum_text.setText(String.valueOf(Mortsum.get(position)));
    }

    @Override
    public int getItemCount() {
        return MortID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mort_id_text, mort_1_text, mort_2_text, mort_3_text, mort_4_text, mort_5_text, mort_6_text, mort_sum_text;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mort_id_text = itemView.findViewById(R.id.mort_id_text);
            mort_1_text = itemView.findViewById(R.id.mort_1_text);
            mort_2_text = itemView.findViewById(R.id.mort_2_text);
            mort_3_text = itemView.findViewById(R.id.mort_3_text);
            mort_4_text = itemView.findViewById(R.id.mort_4_text);
            mort_5_text = itemView.findViewById(R.id.mort_5_text);
            mort_6_text = itemView.findViewById(R.id.mort_6_text);
            mort_sum_text = itemView.findViewById(R.id.mort_sum_text);

        }
    }
}
