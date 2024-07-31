package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.C3771k;
import com.bumptech.glide.util.LogTime;
import com.stub.StubApp;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* renamed from: com.bumptech.glide.load.resource.gif.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {

    /* renamed from: f */
    private static final String f14207f = "BufferGifDecoder";

    /* renamed from: g */
    private static final C3728a f14208g = new C3728a();

    /* renamed from: h */
    private static final C3729b f14209h = new C3729b();

    /* renamed from: a */
    private final Context f14210a;

    /* renamed from: b */
    private final List<ImageHeaderParser> f14211b;

    /* renamed from: c */
    private final C3729b f14212c;

    /* renamed from: d */
    private final C3728a f14213d;

    /* renamed from: e */
    private final GifBitmapProvider f14214e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.gif.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3728a {
        C3728a() {
        }

        /* renamed from: a */
        GifDecoder m44836a(GifDecoder.InterfaceC3554a interfaceC3554a, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
            return new StandardGifDecoder(interfaceC3554a, gifHeader, byteBuffer, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.gif.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3729b {

        /* renamed from: a */
        private final Queue<GifHeaderParser> f14215a = C3771k.m44385f(0);

        C3729b() {
        }

        /* renamed from: a */
        synchronized GifHeaderParser m44835a(ByteBuffer byteBuffer) {
            GifHeaderParser poll;
            poll = this.f14215a.poll();
            if (poll == null) {
                poll = new GifHeaderParser();
            }
            return poll.m45600q(byteBuffer);
        }

        /* renamed from: b */
        synchronized void m44834b(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.m45616a();
            this.f14215a.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(Context context) {
        this(context, Glide.m45744d(context).m45736l().m45779g(), Glide.m45744d(context).m45741g(), Glide.m45744d(context).m45742f());
    }

    @Nullable
    /* renamed from: c */
    private GifDrawableResource m44840c(ByteBuffer byteBuffer, int i, int i2, GifHeaderParser gifHeaderParser, Options options) {
        long m44411b = LogTime.m44411b();
        try {
            GifHeader m45613d = gifHeaderParser.m45613d();
            if (m45613d.m45619b() > 0 && m45613d.m45618c() == 0) {
                Bitmap.Config config = options.m45124c(GifOptions.f14244a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                GifDecoder m44836a = this.f14213d.m44836a(this.f14214e, m45613d, byteBuffer, m44838e(m45613d, i, i2));
                m44836a.mo45593d(config);
                m44836a.mo45595b();
                Bitmap mo45596a = m44836a.mo45596a();
                if (mo45596a == null) {
                    return null;
                }
                GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.f14210a, m44836a, UnitTransformation.m44998c(), i, i2, mo45596a));
                if (Log.isLoggable(f14207f, 2)) {
                    Log.v(f14207f, "Decoded GIF from stream in " + LogTime.m44412a(m44411b));
                }
                return gifDrawableResource;
            }
            if (Log.isLoggable(f14207f, 2)) {
                Log.v(f14207f, "Decoded GIF from stream in " + LogTime.m44412a(m44411b));
            }
            return null;
        } finally {
            if (Log.isLoggable(f14207f, 2)) {
                Log.v(f14207f, "Decoded GIF from stream in " + LogTime.m44412a(m44411b));
            }
        }
    }

    /* renamed from: e */
    private static int m44838e(GifHeader gifHeader, int i, int i2) {
        int min = Math.min(gifHeader.m45620a() / i2, gifHeader.m45617d() / i);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable(f14207f, 2) && max > 1) {
            Log.v(f14207f, "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + gifHeader.m45617d() + "x" + gifHeader.m45620a() + "]");
        }
        return max;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public GifDrawableResource mo2813b(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull Options options) {
        GifHeaderParser m44835a = this.f14212c.m44835a(byteBuffer);
        try {
            return m44840c(byteBuffer, i, i2, m44835a, options);
        } finally {
            this.f14212c.m44834b(m44835a);
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: f */
    public boolean mo2814a(@NonNull ByteBuffer byteBuffer, @NonNull Options options) throws IOException {
        return !((Boolean) options.m45124c(GifOptions.f14245b)).booleanValue() && ImageHeaderParserUtils.getType(this.f14211b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, f14209h, f14208g);
    }

    @VisibleForTesting
    ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, C3729b c3729b, C3728a c3728a) {
        this.f14210a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f14211b = list;
        this.f14213d = c3728a;
        this.f14214e = new GifBitmapProvider(bitmapPool, arrayPool);
        this.f14212c = c3729b;
    }
}
