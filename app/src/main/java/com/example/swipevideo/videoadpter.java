package com.example.swipevideo;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class videoadpter extends RecyclerView.Adapter<videoadpter.videoviewholder> {

    private List<videoitem> videoitems;

    public videoadpter(List<videoitem> videoitems) {
        this.videoitems = videoitems;
    }


    @NonNull

    @Override
    public videoviewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new videoviewholder(
                LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_container_video,
                parent,
               false
        )
        );
    }


    @Override
    public void onBindViewHolder(@NonNull  videoadpter.videoviewholder holder, int position) {

        holder.setvideodata(videoitems.get(position));
    }


    @Override
    public int getItemCount() {
        return  videoitems.size();
    }

    static class videoviewholder extends RecyclerView.ViewHolder
    {

        VideoView videoview;
        TextView textvideotitle, textvideodescription;
        ProgressBar videoprogreebar;

        public videoviewholder(@NonNull  View itemView) {
            super(itemView);


            videoview= itemView.findViewById(R.id.videoview);
            textvideotitle=itemView.findViewById(R.id.textvideotitle);
            textvideodescription=itemView.findViewById(R.id.textvideodescription);
            videoprogreebar=itemView.findViewById(R.id.videoprogreebar);


        }

        void setvideodata(videoitem videoitem){
            textvideotitle.setText(videoitem.videotitle);
            textvideodescription.setText(videoitem.videodescription);
            videoview.setVideoPath(videoitem.videourl);
            videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    videoprogreebar.setVisibility(View.GONE);
                    mp.start();

                    float videoRatio= mp.getVideoWidth()/(float) mp.getVideoHeight();
                    float screenRatio= videoview.getWidth() /(float) videoview.getHeight();


                    float scale= videoRatio / screenRatio;
                    if(scale >= 1f){
                        videoview.setScaleX(scale);
                    }else {
                        videoview.setScaleY(1f/scale);
                    }
                }
            });

            videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
        }
    }
}
