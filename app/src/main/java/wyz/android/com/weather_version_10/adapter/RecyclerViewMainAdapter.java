package wyz.android.com.weather_version_10.adapter;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import wyz.android.com.weather_version_10.R;
import wyz.android.com.weather_version_10.activity.CurrentWeatherDetailActivity;
import wyz.android.com.weather_version_10.domain.CurrentWeather;
import wyz.android.com.weather_version_10.service.DataHandler;

/**
 * Created by wangyuzhe on 10/8/15.
 */
public class RecyclerViewMainAdapter extends RecyclerView.Adapter<RecyclerViewMainAdapter.DataViewHolder>{
    private List<CurrentWeather> mList;
    private Context mContext;

    public RecyclerViewMainAdapter(List<CurrentWeather> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTextCity;
        private TextView mTextCountry;
        private TextView mTextTemp;
        private TextView mTextTime;
        private CardView mCardView;
        private View mView;


        public DataViewHolder(View itemView) {
            super(itemView);
            mTextCity = (TextView)itemView.findViewById(R.id.text_current_city);
            mTextCountry = (TextView)itemView.findViewById(R.id.text_current_country);
            mTextTemp = (TextView)itemView.findViewById(R.id.text_current_temp);
            mTextTime = (TextView)itemView.findViewById(R.id.text_current_time);
            mCardView = (CardView) itemView.findViewById(R.id.current_card_view);
            View mView = itemView;
        }
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, final int position) {
        List<Address> list = DataHandler.parseCity(mList.get(position).getmLatitude(),mList.get(position).getmLongitude(),mContext);
        holder.mTextCity.setText(list.get(0).getAdminArea());
        holder.mTextCountry.setText(list.get(0).getCountryName());
        String temp = DataHandler.parseTemp(Double.valueOf(mList.get(position).getmCurrently().getmTemperature())) ;
        holder.mTextTemp.setText(temp+"°");
        String time = DataHandler.parseTime(mList.get(position).getmCurrently().getmTime(),mList.get(position).getmTimeZone());
        holder.mTextTime.setText(time);
        int backColor = DataHandler.setCardViewBackground(mList, position);
        holder.mCardView.setCardBackgroundColor(holder.itemView.getContext().getResources().getColor(backColor));
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyDataSetChanged();
                Intent intent = new Intent(mContext, CurrentWeatherDetailActivity.class);
                intent.putExtra("current", (Serializable)mList);
                intent.putExtra("position",position);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_main,parent,false);
        ((CardView)view).setCardBackgroundColor(view.getContext().getResources().getColor(R.color.darkorange));
        return new DataViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
