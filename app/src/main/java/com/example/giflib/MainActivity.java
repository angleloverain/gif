package com.example.giflib;


import android.app.Activity;
import android.os.Bundle;
import android.support.rastermill.FrameSequence;
import android.support.rastermill.FrameSequenceDrawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.giflib.gif.GlideApp;


public class MainActivity extends Activity {

    ImageView image_gif;

    String url = "http://1257727316.vod2.myqcloud.com/1cf3d630vodtransgzp1257727316/d9dac7285285890796574796396/animatedGraphics/1575873798_3778167066.100_0.webp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image_gif = findViewById(R.id.image_gif);
//        FrameSequence frameSequence = null;
//        try {
////            frameSequence = FrameSequence.decodeStream( getAssets().open("start_x.gif"));
//            frameSequence = FrameSequence.decodeStream( getAssets().open("dome.webp"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FrameSequenceDrawable frameSequenceDrawable = new FrameSequenceDrawable(frameSequence);
//        image_gif.setImageDrawable(frameSequenceDrawable);

        GlideApp.with(this).asGif2().load(url).into(image_gif);
    }

}
