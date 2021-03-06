package com.example.myapplication;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<ModelDev> dataModelArrayList;

    public Adapter(Context context, ArrayList<ModelDev> dataModelArrayList) {

        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return dataModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.model, null, true);

            holder.iv = (ImageView) convertView.findViewById(R.id.iv);
            holder.tvname = (TextView) convertView.findViewById(R.id.name);
            holder.tvsurname = (TextView) convertView.findViewById(R.id.surname);
            holder.tvpatronymic = (TextView) convertView.findViewById(R.id.patronymic);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

       // Picasso.get().load(dataModelArrayList.get(position).getImgURL()).into(holder.iv);
       // holder.tvname.setText("Name: "+dataModelArrayList.get(position).getName());
       // holder.tvsurname.setText("Country: "+dataModelArrayList.get(position).getSurname());
       // holder.tvpatronymic.setText("City: "+dataModelArrayList.get(position).getPatronymic());

        return convertView;
    }

    private class ViewHolder {

        protected TextView tvname, tvsurname, tvpatronymic;
        protected ImageView iv;
    }

}