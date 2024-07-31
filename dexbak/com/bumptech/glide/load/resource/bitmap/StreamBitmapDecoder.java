package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.resource.bitmap.y */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: a */
    private final Downsampler f14170a;

    /* renamed from: b */
    private final ArrayPool f14171b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StreamBitmapDecoder.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.y$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3725a implements Downsampler.InterfaceC3722b {

        /* renamed from: a */
        private final RecyclableBufferedInputStream f14172a;

        /* renamed from: b */
        private final ExceptionCatchingInputStream f14173b;

        C3725a(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionCatchingInputStream exceptionCatchingInputStream) {
            this.f14172a = recyclableBufferedInputStream;
            this.f14173b = exceptionCatchingInputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.InterfaceC3722b
        /* renamed from: a */
        public void mo44903a(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException m44419b = this.f14173b.m44419b();
            if (m44419b != null) {
                if (bitmap != null) {
                    bitmapPool.mo44924d(bitmap);
                }
                throw m44419b;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.InterfaceC3722b
        /* renamed from: b */
        public void mo44902b() {
            this.f14172a.m44911b();
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler, ArrayPool arrayPool) {
        this.f14170a = downsampler;
        this.f14171b = arrayPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: c */
    public Resource<Bitmap> mo2813b(@NonNull InputStream inputStream, int i, int i2, @NonNull Options options) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f14171b);
            z = true;
        }
        ExceptionCatchingInputStream m44418c = ExceptionCatchingInputStream.m44418c(recyclableBufferedInputStream);
        try {
            return this.f14170a.m44944e(new MarkEnforcingInputStream(m44418c), i, i2, options, new C3725a(recyclableBufferedInputStream, m44418c));
        } finally {
            m44418c.m44417d();
            if (z) {
                recyclableBufferedInputStream.m44910c();
            }
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public boolean mo2814a(@NonNull InputStream inputStream, @NonNull Options options) {
        return this.f14170a.m44936m(inputStream);
    }
}
