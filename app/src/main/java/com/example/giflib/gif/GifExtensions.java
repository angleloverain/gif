package com.example.giflib.gif;

import android.support.rastermill.FrameSequenceDrawable;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Administrator on 2018\11\19 0019.
 */

@GlideExtension
public class GifExtensions {
    private GifExtensions() {
    }

    final static RequestOptions DECODE_TYPE = RequestOptions
            .decodeTypeOf(FrameSequenceDrawable.class)
            .lock();

    @GlideType(FrameSequenceDrawable.class)
    public static RequestBuilder<FrameSequenceDrawable> asGif2(RequestBuilder<FrameSequenceDrawable> requestBuilder) {
        return requestBuilder
                .transition( new DrawableTransitionOptions())
                .apply(DECODE_TYPE);
    }
}
