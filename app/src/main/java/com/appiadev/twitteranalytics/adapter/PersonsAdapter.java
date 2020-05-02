package com.appiadev.twitteranalytics.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appiadev.twitteranalytics.R;
import com.appiadev.twitteranalytics.ui.main.model.Person;

import java.util.List;

public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.ViewHolder>{

    private List<Person> mData;
    private LayoutInflater mInflater;
    private Context mContext;

    public interface OnItemClickListener {
        void onItemClick(Person item);
    }

    private final OnItemClickListener mListener;

    public PersonsAdapter(List<Person> mData, Context context, OnItemClickListener listener) {
        this.mData = mData;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_person_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(mData.get(i), mListener, mContext);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }

        public void bind(final Person item, final OnItemClickListener listener, Context mContext){
            name.setText(item.getPerson());
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }

    }
}