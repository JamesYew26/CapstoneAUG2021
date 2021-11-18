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
    private ArrayList Mortsum, HPsum, TLsum, PLsum, CCsum, PTPTNsum;

    CustomAdapter(Context context, ArrayList mortsum, ArrayList hpsum, ArrayList tlsum,
                  ArrayList plsum, ArrayList ccsum, ArrayList ptptnsum){

        this.context = context;
        this.Mortsum = mortsum;
        this.HPsum = hpsum;
        this.TLsum = tlsum;
        this.PLsum = plsum;
        this.CCsum = ccsum;
        this.PTPTNsum = ptptnsum;
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
        holder.mort_sum_text.setText(String.valueOf(Mortsum.get(position)));
        holder.hirepurchase_sum_text.setText(String.valueOf(HPsum.get(position)));
        holder.termloan_sum_text.setText(String.valueOf(TLsum.get(position)));
        holder.personalloan_sum_text.setText(String.valueOf(PLsum.get(position)));
        holder.creditcard_sum_text.setText(String.valueOf(CCsum.get(position)));
        holder.ptptn_sum_text.setText(String.valueOf(PTPTNsum.get(position)));
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mort_sum_text, hirepurchase_sum_text, termloan_sum_text,
                personalloan_sum_text, creditcard_sum_text, ptptn_sum_text;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mort_sum_text = itemView.findViewById(R.id.mort_sum_text);
            hirepurchase_sum_text = itemView.findViewById(R.id.hirepurchase_sum_text);
            termloan_sum_text = itemView.findViewById(R.id.termloan_sum_text);
            personalloan_sum_text = itemView.findViewById(R.id.personalloan_sum_text);
            creditcard_sum_text = itemView.findViewById(R.id.creditcard_sum_text);
            ptptn_sum_text = itemView.findViewById(R.id.PTPTN_sum_text);

        }
    }
}
