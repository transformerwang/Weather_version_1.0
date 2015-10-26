package wyz.android.com.weather_version_10.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import wyz.android.com.weather_version_10.R;
import wyz.android.com.weather_version_10.domain.CurrentWeather;
import wyz.android.com.weather_version_10.service.DataHandler;

/**
 * Created by wangyuzhe on 10/10/15.
 */
public class HorizontalGridViewAdapter extends RecyclerView.Adapter<HorizontalGridViewAdapter.Viewholder>{

    private CurrentWeather mCurrentWeather;

    public HorizontalGridViewAdapter(CurrentWeather currentWeather)
    {
        this.mCurrentWeather = currentWeather;
    }

    public static class Viewholder extends RecyclerView.ViewHolder
    {
        public TextView textView_hour;
        public TextView textView_temp;
        public ImageView imageView;

        public Viewholder(View v)
        {
            super(v);
            textView_hour = (TextView) v.findViewById(R.id.hour_text_view);
            textView_temp = (TextView) v.findViewById(R.id.temp_text_view);
            imageView = (ImageView)v.findViewById(R.id.hour_image_view);
        }
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_detail_horizontal_info,parent,false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(Viewholder holder, final int position) {
        String time = DataHandler.parseTime(mCurrentWeather.getmHourly().getmList().get(position).getmTime(),mCurrentWeather.getmTimeZone());
        String hour = time.split(":")[0];
        if(position == 0)
        {
            holder.textView_hour.setText("Now");
        }
        else
        {
            holder.textView_hour.setText(hour);
        }

        double temp = Double.valueOf(mCurrentWeather.getmHourly().getmList().get(position).getmTemprature());
        int temp_1 = Integer.parseInt(new java.text.DecimalFormat("0").format(temp));
        String temp_2 = String.valueOf(temp_1+"°");
        holder.textView_temp.setText(temp_2);

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
