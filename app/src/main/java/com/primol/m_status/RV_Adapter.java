package com.primol.m_status;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by infogird47 on 18/12/2016.
 */

public class RV_Adapter extends RecyclerView.Adapter<RV_Adapter.MyViewHolder> {
    
    ArrayList<id_name_model> dataSet = new ArrayList<id_name_model>();
    public Context context;
    private int lastPosition = -1;
    private final static int FADE_DURATION = 1000; // in milliseconds

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Tv_status;
        RelativeLayout rel_ly;
        private CardView cv_status;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.Tv_status = (TextView)itemView.findViewById(R.id.tv_status_list);
            cv_status = (CardView) itemView.findViewById(R.id.cv_status_list);
            this.rel_ly= (RelativeLayout) itemView.findViewById(R.id.rel_ly_list);
        }

    }

    public RV_Adapter(ArrayList<id_name_model> data) {
        this.dataSet = data;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_list, parent, false);

        view.setOnClickListener(Home_Activity.myOnClickListener);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        context = parent.getContext();
        return myViewHolder;
    }

    @Override
    public void onViewDetachedFromWindow(MyViewHolder holder) {
        holder.itemView.clearAnimation();
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView Tv_status = holder.Tv_status;
        int id = dataSet.get(listPosition).getId();

        String status = ""+dataSet.get(listPosition).getStatus().trim()+"";
        Tv_status.setText(status);

        holder.rel_ly.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent it = new Intent(context, MainActivity.class);
                it.putExtra("id",dataSet.get(listPosition).getId());
                it.putExtra("status",dataSet.get(listPosition).getStatus());
                context.startActivity(it);

               // overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
    }
});
        // Here you apply the animation when the view is bound
      //  setAnimation(holder.rel_ly, listPosition);

        // Set the view to fade in
        setScaleAnimation(holder.itemView);
    }
    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    /**
     * Here is the key method to apply the animation
     */

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

}


