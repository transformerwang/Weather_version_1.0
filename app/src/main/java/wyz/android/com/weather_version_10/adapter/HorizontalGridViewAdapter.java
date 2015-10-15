package wyz.android.com.weather_version_10.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wyz.android.com.weather_version_10.R;

/**
 * Created by wangyuzhe on 10/10/15.
 */
public class HorizontalGridViewAdapter extends RecyclerView.Adapter<HorizontalGridViewAdapter.Viewholder>{

    public static class Viewholder extends RecyclerView.ViewHolder
    {
        public TextView textView;
        public CardView cardView;
        public Viewholder(View v)
        {
            super(v);
            //textView = (TextView) v.findViewById(R.id.txt);
            //cardView = (CardView)v.findViewById(R.id.);
        }
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_horizontal,parent,false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, final int position) {
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("a", String.valueOf(position));
//                notifyDataSetChanged();
//            }
//        });
        //holder.textView.setText("");
    }

    @Override
    public int getItemCount() {
        return 24;
    }
}
