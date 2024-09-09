package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.util.k;
import com.stub.StubApp;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ByteBufferGifDecoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a implements com.bumptech.glide.load.g<ByteBuffer, GifDrawable> {

    /* renamed from: f  reason: collision with root package name */
    private static final String f17524f = "BufferGifDecoder";

    /* renamed from: g  reason: collision with root package name */
    private static final C0178a f17525g = new C0178a();

    /* renamed from: h  reason: collision with root package name */
    private static final b f17526h = new b();

    /* renamed from: a  reason: collision with root package name */
    private final Context f17527a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ImageHeaderParser> f17528b;

    /* renamed from: c  reason: collision with root package name */
    private final b f17529c;

    /* renamed from: d  reason: collision with root package name */
    private final C0178a f17530d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.load.resource.gif.b f17531e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.gif.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class C0178a {
        C0178a() {
        }

        GifDecoder a(GifDecoder.a aVar, com.bumptech.glide.gifdecoder.c cVar, ByteBuffer byteBuffer, int i4) {
            return new com.bumptech.glide.gifdecoder.e(aVar, cVar, byteBuffer, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<com.bumptech.glide.gifdecoder.d> f17532a = k.f(0);

        b() {
        }

        synchronized com.bumptech.glide.gifdecoder.d a(ByteBuffer byteBuffer) {
            com.bumptech.glide.gifdecoder.d poll;
            poll = this.f17532a.poll();
            if (poll == null) {
                poll = new com.bumptech.glide.gifdecoder.d();
            }
            return poll.q(byteBuffer);
        }

        synchronized void b(com.bumptech.glide.gifdecoder.d dVar) {
            dVar.a();
            this.f17532a.offer(dVar);
        }
    }

    public a(Context context) {
        this(context, com.bumptech.glide.d.d(context).l().g(), com.bumptech.glide.d.d(context).g(), com.bumptech.glide.d.d(context).f());
    }

    @Nullable
    private d c(ByteBuffer byteBuffer, int i4, int i5, com.bumptech.glide.gifdecoder.d dVar, com.bumptech.glide.load.f fVar) {
        long b4 = com.bumptech.glide.util.f.b();
        try {
            com.bumptech.glide.gifdecoder.c d4 = dVar.d();
            if (d4.b() > 0 && d4.c() == 0) {
                Bitmap.Config config = fVar.c(h.f17561a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                GifDecoder a4 = this.f17530d.a(this.f17531e, d4, byteBuffer, e(d4, i4, i5));
                a4.d(config);
                a4.b();
                Bitmap a5 = a4.a();
                if (a5 == null) {
                    return null;
                }
                d dVar2 = new d(new GifDrawable(this.f17527a, a4, com.bumptech.glide.load.resource.b.c(), i4, i5, a5));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.util.f.a(b4));
                }
                return dVar2;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.util.f.a(b4));
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.util.f.a(b4));
            }
        }
    }

    private static int e(com.bumptech.glide.gifdecoder.c cVar, int i4, int i5) {
        int min = Math.min(cVar.a() / i5, cVar.d() / i4);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i4 + "x" + i5 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return max;
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: d */
    public d b(@NonNull ByteBuffer byteBuffer, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        com.bumptech.glide.gifdecoder.d a4 = this.f17529c.a(byteBuffer);
        try {
            return c(byteBuffer, i4, i5, a4, fVar);
        } finally {
            this.f17529c.b(a4);
        }
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: f */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return !((Boolean) fVar.c(h.f17562b)).booleanValue() && com.bumptech.glide.load.b.getType(this.f17528b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this(context, list, eVar, bVar, f17526h, f17525g);
    }

    @VisibleForTesting
    a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar, b bVar2, C0178a c0178a) {
        this.f17527a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f17528b = list;
        this.f17530d = c0178a;
        this.f17531e = new com.bumptech.glide.load.resource.gif.b(eVar, bVar);
        this.f17529c = bVar2;
    }
}
