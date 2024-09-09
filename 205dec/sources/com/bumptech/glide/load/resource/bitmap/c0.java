package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.e;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: VideoDecoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c0<T> implements com.bumptech.glide.load.g<T, Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f17389d = "VideoDecoder";

    /* renamed from: e  reason: collision with root package name */
    public static final long f17390e = -1;
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    static final int f17391f = 2;

    /* renamed from: g  reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Long> f17392g = com.bumptech.glide.load.e.b("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: h  reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Integer> f17393h = com.bumptech.glide.load.e.b("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: i  reason: collision with root package name */
    private static final d f17394i = new d();

    /* renamed from: a  reason: collision with root package name */
    private final e<T> f17395a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f17396b;

    /* renamed from: c  reason: collision with root package name */
    private final d f17397c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: VideoDecoder.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a implements e.b<Long> {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f17398a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // com.bumptech.glide.load.e.b
        public void update(@NonNull byte[] bArr, @NonNull Long l4, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f17398a) {
                this.f17398a.position(0);
                messageDigest.update(this.f17398a.putLong(l4.longValue()).array());
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: VideoDecoder.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class b implements e.b<Integer> {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f17399a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // com.bumptech.glide.load.e.b
        public void update(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f17399a) {
                this.f17399a.position(0);
                messageDigest.update(this.f17399a.putInt(num.intValue()).array());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: VideoDecoder.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class c implements e<AssetFileDescriptor> {
        private c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.c0.e
        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class d {
        d() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface e<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: VideoDecoder.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class f implements e<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.resource.bitmap.c0.e
        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, e<T> eVar2) {
        this(eVar, eVar2, f17394i);
    }

    public static com.bumptech.glide.load.g<AssetFileDescriptor, Bitmap> c(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        return new c0(eVar, new c(null));
    }

    @Nullable
    private static Bitmap d(MediaMetadataRetriever mediaMetadataRetriever, long j4, int i4, int i5, int i6, DownsampleStrategy downsampleStrategy) {
        Bitmap f4 = (Build.VERSION.SDK_INT < 27 || i5 == Integer.MIN_VALUE || i6 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f17380f) ? null : f(mediaMetadataRetriever, j4, i4, i5, i6, downsampleStrategy);
        return f4 == null ? e(mediaMetadataRetriever, j4, i4) : f4;
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j4, int i4) {
        return mediaMetadataRetriever.getFrameAtTime(j4, i4);
    }

    @TargetApi(27)
    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j4, int i4, int i5, int i6, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float b4 = downsampleStrategy.b(parseInt, parseInt2, i5, i6);
            return mediaMetadataRetriever.getScaledFrameAtTime(j4, i4, Math.round(parseInt * b4), Math.round(b4 * parseInt2));
        } catch (Throwable th) {
            if (Log.isLoggable("VideoDecoder", 3)) {
                Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
                return null;
            }
            return null;
        }
    }

    public static com.bumptech.glide.load.g<ParcelFileDescriptor, Bitmap> g(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        return new c0(eVar, new f());
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull T t3, @NonNull com.bumptech.glide.load.f fVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.g
    public com.bumptech.glide.load.engine.u<Bitmap> b(@NonNull T t3, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        long longValue = ((Long) fVar.c(f17392g)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) fVar.c(f17393h);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) fVar.c(DownsampleStrategy.f17382h);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.f17381g;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever a4 = this.f17397c.a();
        try {
            try {
                this.f17395a.a(a4, t3);
                Bitmap d4 = d(a4, longValue, num.intValue(), i4, i5, downsampleStrategy2);
                a4.release();
                return com.bumptech.glide.load.resource.bitmap.f.d(d4, this.f17396b);
            } catch (RuntimeException e4) {
                throw new IOException(e4);
            }
        } catch (Throwable th) {
            a4.release();
            throw th;
        }
    }

    @VisibleForTesting
    c0(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, e<T> eVar2, d dVar) {
        this.f17396b = eVar;
        this.f17395a = eVar2;
        this.f17397c = dVar;
    }
}
