package com.parse.starter;

import android.content.Context;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseQueryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by salow on 11/21/2015.
 */
public class ParseGridAdapter extends ParseRecyclerQueryAdapter<Base, ParseGridAdapter.ViewHolder> {

    Context mContext;
    private LayoutInflater inflater;
    //List<Base> bases;
    private ViewGroup parent;
    private int viewType;



   OnItemClickListener mItemClickListener;


    public ParseGridAdapter(Context context,ParseQueryAdapter.QueryFactory<Base> factory, boolean hasStableIds) {
        super(factory, hasStableIds);
        //Your other code here
       inflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_places, parent,false);
        ViewHolder holder = new ViewHolder(view,viewType,mContext);

        return holder;
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Base current = getItem(position);
        holder.placeName.setText(current.getName());
        ParseFile imagefile  = current.getImage();
        if (imagefile != null){
            holder.placeImage.setParseFile(imagefile);
            holder.placeImage.loadInBackground();
        }







        //holder.placeImage.setImageResource(current.getImage());


    }
    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener =  mItemClickListener;
    }
    public interface OnItemClickListener {

        void onItemClick(Base base,View itemView, int position);
    }



    // 3
    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        public LinearLayout placeHolder;
        public LinearLayout placeNameHolder;
        public TextView placeName;
        public ParseImageView placeImage;


        public ViewHolder( View itemView,int viewType, Context context) {
            super(itemView);

            //itemView.setOnClickListener(this);
            placeHolder = (LinearLayout) itemView.findViewById(R.id.mainHolder);
            placeName = (TextView) itemView.findViewById(R.id.placeName);
            //placeNameHolder = (LinearLayout) itemView.findViewById(R.id.placeNameHolder);
            placeImage = (ParseImageView) itemView.findViewById(R.id.placeImage);
            placeHolder.setOnClickListener(this);

        }



        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(getItem(getPosition()),itemView, getPosition());
            }
           // Toast.makeText(mContext, "Clicked " + getPosition(), Toast.LENGTH_SHORT).show();

        }



    }
}
