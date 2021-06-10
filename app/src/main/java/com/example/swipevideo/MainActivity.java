package com.example.swipevideo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.media.MediaPlayer;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager2 videosViewPager= findViewById(R.id.videoviewpager);

        List<videoitem> videoitems = new ArrayList<>();
//
       videoitem videoItemcelebration= new videoitem();
        videoItemcelebration.videourl="https://assets.mixkit.co/videos/preview/mixkit-traffic-in-an-underground-tunnel-4067-large.mp4";
        videoItemcelebration.videotitle="video1";
        videoItemcelebration.videodescription="";
        videoitems.add(videoItemcelebration);

        videoitem videoItemcelebration1= new videoitem();
        videoItemcelebration1.videourl="https://assets.mixkit.co/videos/preview/mixkit-woman-walking-on-beach-towards-boulders-1012-large.mp4";
        videoItemcelebration1.videotitle="vidoe2";
        videoItemcelebration1.videodescription="";
        videoitems.add(videoItemcelebration1);


        videoitem videoItemcelebration2= new videoitem();
        videoItemcelebration1.videourl="https://assets.mixkit.co/videos/preview/mixkit-woman-walking-on-beach-towards-boulders-1012-large.mp4";
        videoItemcelebration1.videotitle="video3";
        videoItemcelebration1.videodescription="";
        videoitems.add(videoItemcelebration1);


        videosViewPager.setAdapter(new videoadpter(videoitems));
    }
}