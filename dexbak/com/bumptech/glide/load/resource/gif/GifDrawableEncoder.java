package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.resource.gif.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GifDrawableEncoder implements ResourceEncoder<GifDrawable> {

    /* renamed from: a */
    private static final String f14218a = "GifEncoder";

    @Override // com.bumptech.glide.load.ResourceEncoder
    @NonNull
    /* renamed from: b */
    public EncodeStrategy mo44826b(@NonNull Options options) {
        return EncodeStrategy.SOURCE;
    }

    @Override // com.bumptech.glide.load.Encoder
    /* renamed from: c */
    public boolean mo44827a(@NonNull Resource<GifDrawable> resource, @NonNull File file, @NonNull Options options) {
        try {
            ByteBufferUtil.m44427e(resource.get().m44858c(), file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable(f14218a, 5)) {
                Log.w(f14218a, "Failed to encode GIF drawable data", e);
            }
            return false;
        }
    }
}
