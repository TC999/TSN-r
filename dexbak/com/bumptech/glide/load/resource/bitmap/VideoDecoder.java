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
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.resource.bitmap.c0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {

    /* renamed from: d */
    private static final String f14072d = "VideoDecoder";

    /* renamed from: e */
    public static final long f14073e = -1;
    @VisibleForTesting

    /* renamed from: f */
    static final int f14074f = 2;

    /* renamed from: g */
    public static final Option<Long> f14075g = Option.m45436b("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new C3711a());

    /* renamed from: h */
    public static final Option<Integer> f14076h = Option.m45436b("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new C3712b());

    /* renamed from: i */
    private static final C3714d f14077i = new C3714d();

    /* renamed from: a */
    private final InterfaceC3715e<T> f14078a;

    /* renamed from: b */
    private final BitmapPool f14079b;

    /* renamed from: c */
    private final C3714d f14080c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.c0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3711a implements Option.InterfaceC3572b<Long> {

        /* renamed from: a */
        private final ByteBuffer f14081a = ByteBuffer.allocate(8);

        C3711a() {
        }

        @Override // com.bumptech.glide.load.Option.InterfaceC3572b
        public void update(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f14081a) {
                this.f14081a.position(0);
                messageDigest.update(this.f14081a.putLong(l.longValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.c0$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3712b implements Option.InterfaceC3572b<Integer> {

        /* renamed from: a */
        private final ByteBuffer f14082a = ByteBuffer.allocate(4);

        C3712b() {
        }

        @Override // com.bumptech.glide.load.Option.InterfaceC3572b
        public void update(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f14082a) {
                this.f14082a.position(0);
                messageDigest.update(this.f14082a.putInt(num.intValue()).array());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoDecoder.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.c0$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3713c implements InterfaceC3715e<AssetFileDescriptor> {
        private C3713c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.InterfaceC3715e
        /* renamed from: b */
        public void mo44984a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        /* synthetic */ C3713c(C3711a c3711a) {
            this();
        }
    }

    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.bitmap.c0$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C3714d {
        C3714d() {
        }

        /* renamed from: a */
        public MediaMetadataRetriever m44985a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.resource.bitmap.c0$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3715e<T> {
        /* renamed from: a */
        void mo44984a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.c0$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3716f implements InterfaceC3715e<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.InterfaceC3715e
        /* renamed from: b */
        public void mo44984a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoDecoder(BitmapPool bitmapPool, InterfaceC3715e<T> interfaceC3715e) {
        this(bitmapPool, interfaceC3715e, f14077i);
    }

    /* renamed from: c */
    public static ResourceDecoder<AssetFileDescriptor, Bitmap> m44991c(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new C3713c(null));
    }

    @Nullable
    /* renamed from: d */
    private static Bitmap m44990d(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        Bitmap m44988f = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f14063f) ? null : m44988f(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
        return m44988f == null ? m44989e(mediaMetadataRetriever, j, i) : m44988f;
    }

    /* renamed from: e */
    private static Bitmap m44989e(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    @TargetApi(27)
    /* renamed from: f */
    private static Bitmap m44988f(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float mo44996b = downsampleStrategy.mo44996b(parseInt, parseInt2, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(parseInt * mo44996b), Math.round(mo44996b * parseInt2));
        } catch (Throwable th) {
            if (Log.isLoggable(f14072d, 3)) {
                Log.d(f14072d, "Exception trying to decode frame on oreo+", th);
                return null;
            }
            return null;
        }
    }

    /* renamed from: g */
    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> m44987g(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new C3716f());
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a */
    public boolean mo2814a(@NonNull T t, @NonNull Options options) {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: b */
    public Resource<Bitmap> mo2813b(@NonNull T t, int i, int i2, @NonNull Options options) throws IOException {
        long longValue = ((Long) options.m45124c(f14075g)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) options.m45124c(f14076h);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.m45124c(DownsampleStrategy.f14065h);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.f14064g;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever m44985a = this.f14080c.m44985a();
        try {
            try {
                this.f14078a.mo44984a(m44985a, t);
                Bitmap m44990d = m44990d(m44985a, longValue, num.intValue(), i, i2, downsampleStrategy2);
                m44985a.release();
                return BitmapResource.m44977d(m44990d, this.f14079b);
            } catch (RuntimeException e) {
                throw new IOException(e);
            }
        } catch (Throwable th) {
            m44985a.release();
            throw th;
        }
    }

    @VisibleForTesting
    VideoDecoder(BitmapPool bitmapPool, InterfaceC3715e<T> interfaceC3715e, C3714d c3714d) {
        this.f14079b = bitmapPool;
        this.f14078a = interfaceC3715e;
        this.f14080c = c3714d;
    }
}
