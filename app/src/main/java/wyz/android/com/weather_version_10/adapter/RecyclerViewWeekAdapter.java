package wyz.android.com.weather_version_10.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import wyz.android.com.weather_version_10.R;
import wyz.android.com.weather_version_10.activity.WeekWeatherActivity;
import wyz.android.com.weather_version_10.domain.CurrentWeather;
import wyz.android.com.weather_version_10.service.DataHandler;

/**
 * Created by wangyuzhe on 10/17/15.
 */
public class RecyclerViewWeekAdapter extends RecyclerView.Adapter<RecyclerViewWeekAdapter.ViewHolder> {

    private CurrentWeather currentWeather;
    private Context mContext;

    public RecyclerViewWeekAdapter(CurrentWeather currentWeather, Context context)
    {
        this.currentWeather = currentWeather;
        this.mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mTextName;
        private TextView mTextDescription;
        private TextView mTemp;
        private RelativeLayout mRelativeLayout;

        public ViewHolder(View itemView)
        {
            super(itemView);
            mTextName = (TextView)itemView.findViewById(R.id.text_week_name);
            mTextDescription = (TextView)itemView.findViewById(R.id.text_description);
            mTemp = (TextView)itemView.findViewById(R.id.text_week_temp);
            mRelativeLayout = (RelativeLayout)itemView.findViewById(R.id.relative_top);
        }

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String tempMin = DataHandler.parseTemp(Double.valueOf(currentWeather.getmDaily().getmList().get(position).getmTemperatureMin()));
        String tempMax = DataHandler.parseTemp(Double.valueOf(currentWeather.getmDaily().getmList().get(position).getmTemperatureMax()));
        String date = DataHandler.parseWeek(currentWeather.getmDaily().getmList().get(position).getmTime(),currentWeather.getmTimeZone());
        if(position == 0)
        {
            holder.mTextName.setText("Today");
        }
        else
        {
            holder.mTextName.setText(date);
        }
        holder.mTemp.setText(tempMin+"°/" + tempMax + "°");
        holder.mTextDescription.setText(currentWeather.getmDaily().getmList().get(position).getmSummary());
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, WeekWeatherActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("weather",currentWeather);
                bundle.putInt("position", position);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_detail_week_info,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
