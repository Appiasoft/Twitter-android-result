package com.appiadev.twitteranalytics.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appiadev.twitteranalytics.R;
import com.appiadev.twitteranalytics.ui.main.model.Person;
import com.appiadev.twitteranalytics.ui.main.model.Twett;

import java.util.List;

public class TwettsAdapter extends RecyclerView.Adapter<TwettsAdapter.ViewHolder>{

    private List<Twett> mData;
    private LayoutInflater mInflater;
    private Context mContext;


    public TwettsAdapter(List<Twett> mData, Context context) {
        this.mData = mData;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_twett_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tweet, date;

        ViewHolder(View itemView) {
            super(itemView);
            tweet = itemView.findViewById(R.id.tweet);
            date = itemView.findViewById(R.id.date);
        }

        public void bind(final Twett item){
            date.setText(item.getCreatedAt());
            tweet.setText(item.getText());
        }
    }
}