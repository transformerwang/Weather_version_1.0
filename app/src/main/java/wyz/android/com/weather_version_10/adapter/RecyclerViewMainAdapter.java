package wyz.android.com.weather_version_10.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
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
        private RelativeLayout mRelativeLayout;
        private View mView;


        public DataViewHolder(View itemView) {
            super(itemView);
            mTextCity = (TextView)itemView.findViewById(R.id.text_current_city);
            mTextCountry = (TextView)itemView.findViewById(R.id.text_current_country);
            mTextTemp = (TextView)itemView.findViewById(R.id.text_current_temp);
            mTextTime = (TextView)itemView.findViewById(R.id.text_current_time);
            mRelativeLayout = (RelativeLayout)itemView.findViewById(R.id.relative_main);
            View mView = itemView;
        }
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, final int position) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("session", Activity.MODE_PRIVATE);
        String address = sharedPreferences.getString("city_"+position,"");
        String[] address_info = address.split(",");
        int length = address_info.length;
        String city = sharedPreferences.getString("cityname_"+position,"");
        String country = address_info[length-1];
        holder.mTextCity.setText(city);
        holder.mTextCountry.setText(country);
        String temp = DataHandler.parseTemp(Double.valueOf(mList.get(position).getmCurrently().getmTemperature())) ;
        holder.mTextTemp.setText(temp+"°");
        String time = DataHandler.parseTime(mList.get(position).getmCurrently().getmTime(),mList.get(position).getmTimeZone());
        holder.mTextTime.setText(time);
        int backColor = DataHandler.setCardViewBackground(mList, position);
        holder.mRelativeLayout.setBackgroundColor(holder.itemView.getContext().getResources().getColor(backColor));
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyDataSetChanged();
                Intent intent = new Intent(mContext, CurrentWeatherDetailActivity.class);
                intent.putExtra("current", (Serializable) mList);
                intent.putExtra("position", position);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_citylist_main,parent,false);
        view.setBackgroundColor(view.getContext().getResources().getColor(R.color.darkorange));
        return new DataViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
