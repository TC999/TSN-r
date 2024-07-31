package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.util.C3770j;
import com.bumptech.glide.util.C3771k;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.resource.bitmap.n */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Downsampler {

    /* renamed from: f */
    static final String f14124f = "Downsampler";

    /* renamed from: g */
    public static final Option<DecodeFormat> f14125g = Option.m45431g("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated

    /* renamed from: h */
    public static final Option<DownsampleStrategy> f14126h = DownsampleStrategy.f14065h;

    /* renamed from: i */
    public static final Option<Boolean> f14127i;

    /* renamed from: j */
    public static final Option<Boolean> f14128j;

    /* renamed from: k */
    private static final String f14129k = "image/vnd.wap.wbmp";

    /* renamed from: l */
    private static final String f14130l = "image/x-ico";

    /* renamed from: m */
    private static final Set<String> f14131m;

    /* renamed from: n */
    private static final InterfaceC3722b f14132n;

    /* renamed from: o */
    private static final Set<ImageHeaderParser.ImageType> f14133o;

    /* renamed from: p */
    private static final Queue<BitmapFactory.Options> f14134p;

    /* renamed from: q */
    private static final int f14135q = 10485760;

    /* renamed from: a */
    private final BitmapPool f14136a;

    /* renamed from: b */
    private final DisplayMetrics f14137b;

    /* renamed from: c */
    private final ArrayPool f14138c;

    /* renamed from: d */
    private final List<ImageHeaderParser> f14139d;

    /* renamed from: e */
    private final HardwareConfigState f14140e = HardwareConfigState.m44919a();

    /* compiled from: Downsampler.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.n$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3721a implements InterfaceC3722b {
        C3721a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.InterfaceC3722b
        /* renamed from: a */
        public void mo44903a(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.InterfaceC3722b
        /* renamed from: b */
        public void mo44902b() {
        }
    }

    /* compiled from: Downsampler.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.n$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3722b {
        /* renamed from: a */
        void mo44903a(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        /* renamed from: b */
        void mo44902b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f14127i = Option.m45431g("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f14128j = Option.m45431g("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f14131m = Collections.unmodifiableSet(new HashSet(Arrays.asList(f14129k, f14130l)));
        f14132n = new C3721a();
        f14133o = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f14134p = C3771k.m44385f(0);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f14139d = list;
        this.f14137b = (DisplayMetrics) C3770j.m44392d(displayMetrics);
        this.f14136a = (BitmapPool) C3770j.m44392d(bitmapPool);
        this.f14138c = (ArrayPool) C3770j.m44392d(arrayPool);
    }

    /* renamed from: a */
    private static int m44948a(double d) {
        int m44939j = m44939j(d);
        double d2 = m44939j;
        Double.isNaN(d2);
        int m44929t = m44929t(d2 * d);
        double d3 = m44929t / m44939j;
        Double.isNaN(d3);
        double d4 = m44929t;
        Double.isNaN(d4);
        return m44929t((d / d3) * d4);
    }

    /* renamed from: b */
    private void m44947b(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        if (this.f14140e.m44917c(i, i2, options, decodeFormat, z, z2)) {
            return;
        }
        if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
            boolean z3 = false;
            try {
                z3 = ImageHeaderParserUtils.getType(this.f14139d, inputStream, this.f14138c).hasAlpha();
            } catch (IOException e) {
                if (Log.isLoggable(f14124f, 3)) {
                    Log.d(f14124f, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e);
                }
            }
            Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    /* renamed from: c */
    private static void m44946c(ImageHeaderParser.ImageType imageType, InputStream inputStream, InterfaceC3722b interfaceC3722b, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) throws IOException {
        float mo44996b;
        int min;
        int i6;
        int i7;
        int floor;
        double floor2;
        int i8;
        if (i2 <= 0 || i3 <= 0) {
            if (Log.isLoggable(f14124f, 3)) {
                Log.d(f14124f, "Unable to determine dimensions for: " + imageType + " with target [" + i4 + "x" + i5 + "]");
                return;
            }
            return;
        }
        if (i != 90 && i != 270) {
            mo44996b = downsampleStrategy.mo44996b(i2, i3, i4, i5);
        } else {
            mo44996b = downsampleStrategy.mo44996b(i3, i2, i4, i5);
        }
        if (mo44996b > 0.0f) {
            DownsampleStrategy.SampleSizeRounding mo44997a = downsampleStrategy.mo44997a(i2, i3, i4, i5);
            if (mo44997a != null) {
                float f = i2;
                float f2 = i3;
                int m44929t = i2 / m44929t(mo44996b * f);
                int m44929t2 = i3 / m44929t(mo44996b * f2);
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
                if (mo44997a == sampleSizeRounding) {
                    min = Math.max(m44929t, m44929t2);
                } else {
                    min = Math.min(m44929t, m44929t2);
                }
                int i9 = Build.VERSION.SDK_INT;
                if (i9 > 23 || !f14131m.contains(options.outMimeType)) {
                    int max = Math.max(1, Integer.highestOneBit(min));
                    i6 = (mo44997a != sampleSizeRounding || ((float) max) >= 1.0f / mo44996b) ? max : max << 1;
                } else {
                    i6 = 1;
                }
                options.inSampleSize = i6;
                if (imageType == ImageHeaderParser.ImageType.JPEG) {
                    float min2 = Math.min(i6, 8);
                    i7 = i9;
                    floor = (int) Math.ceil(f / min2);
                    i8 = (int) Math.ceil(f2 / min2);
                    int i10 = i6 / 8;
                    if (i10 > 0) {
                        floor /= i10;
                        i8 /= i10;
                    }
                } else {
                    i7 = i9;
                    if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                        if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                            if (i7 >= 24) {
                                float f3 = i6;
                                floor = Math.round(f / f3);
                                i8 = Math.round(f2 / f3);
                            } else {
                                float f4 = i6;
                                floor = (int) Math.floor(f / f4);
                                floor2 = Math.floor(f2 / f4);
                            }
                        } else if (i2 % i6 == 0 && i3 % i6 == 0) {
                            floor = i2 / i6;
                            i8 = i3 / i6;
                        } else {
                            int[] m44938k = m44938k(inputStream, options, interfaceC3722b, bitmapPool);
                            int i11 = m44938k[0];
                            i8 = m44938k[1];
                            floor = i11;
                        }
                    } else {
                        float f5 = i6;
                        floor = (int) Math.floor(f / f5);
                        floor2 = Math.floor(f2 / f5);
                    }
                    i8 = (int) floor2;
                }
                double mo44996b2 = downsampleStrategy.mo44996b(floor, i8, i4, i5);
                if (i7 >= 19) {
                    options.inTargetDensity = m44948a(mo44996b2);
                    options.inDensity = m44939j(mo44996b2);
                }
                if (m44934o(options)) {
                    options.inScaled = true;
                } else {
                    options.inTargetDensity = 0;
                    options.inDensity = 0;
                }
                if (Log.isLoggable(f14124f, 2)) {
                    Log.v(f14124f, "Calculate scaling, source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "], power of two scaled: [" + floor + "x" + i8 + "], exact scale factor: " + mo44996b + ", power of 2 sample size: " + i6 + ", adjusted scale factor: " + mo44996b2 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        throw new IllegalArgumentException("Cannot scale with factor: " + mo44996b + " from: " + downsampleStrategy + ", source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "]");
    }

    /* renamed from: f */
    private Bitmap m44943f(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i, int i2, boolean z2, InterfaceC3722b interfaceC3722b) throws IOException {
        int round;
        int round2;
        int i3;
        long m44411b = LogTime.m44411b();
        int[] m44938k = m44938k(inputStream, options, interfaceC3722b, this.f14136a);
        int i4 = m44938k[0];
        int i5 = m44938k[1];
        String str = options.outMimeType;
        boolean z3 = (i4 == -1 || i5 == -1) ? false : z;
        int m45482a = ImageHeaderParserUtils.m45482a(this.f14139d, inputStream, this.f14138c);
        int m44892j = TransformationUtils.m44892j(m45482a);
        boolean m44889m = TransformationUtils.m44889m(m45482a);
        int i6 = i == Integer.MIN_VALUE ? i4 : i;
        int i7 = i2 == Integer.MIN_VALUE ? i5 : i2;
        ImageHeaderParser.ImageType type = ImageHeaderParserUtils.getType(this.f14139d, inputStream, this.f14138c);
        m44946c(type, inputStream, interfaceC3722b, this.f14136a, downsampleStrategy, m44892j, i4, i5, i6, i7, options);
        m44947b(inputStream, decodeFormat, z3, m44889m, options, i6, i7);
        boolean z4 = Build.VERSION.SDK_INT >= 19;
        if ((options.inSampleSize == 1 || z4) && m44927v(type)) {
            if (i4 < 0 || i5 < 0 || !z2 || !z4) {
                float f = m44934o(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i8 = options.inSampleSize;
                float f2 = i8;
                round = Math.round(((int) Math.ceil(i4 / f2)) * f);
                round2 = Math.round(((int) Math.ceil(i5 / f2)) * f);
                if (Log.isLoggable(f14124f, 2)) {
                    Log.v(f14124f, "Calculated target [" + round + "x" + round2 + "] for source [" + i4 + "x" + i5 + "], sampleSize: " + i8 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f);
                }
            } else {
                round = i6;
                round2 = i7;
            }
            if (round > 0 && round2 > 0) {
                m44928u(options, this.f14136a, round, round2);
            }
        }
        Bitmap m44942g = m44942g(inputStream, options, interfaceC3722b, this.f14136a);
        interfaceC3722b.mo44903a(this.f14136a, m44942g);
        if (Log.isLoggable(f14124f, 2)) {
            i3 = m45482a;
            m44933p(i4, i5, str, options, m44942g, i, i2, m44411b);
        } else {
            i3 = m45482a;
        }
        Bitmap bitmap = null;
        if (m44942g != null) {
            m44942g.setDensity(this.f14137b.densityDpi);
            bitmap = TransformationUtils.m44887o(this.f14136a, m44942g, i3);
            if (!m44942g.equals(bitmap)) {
                this.f14136a.mo44924d(m44942g);
            }
        }
        return bitmap;
    }

    /* renamed from: g */
    private static Bitmap m44942g(InputStream inputStream, BitmapFactory.Options options, InterfaceC3722b interfaceC3722b, BitmapPool bitmapPool) throws IOException {
        if (options.inJustDecodeBounds) {
            inputStream.mark(f14135q);
        } else {
            interfaceC3722b.mo44902b();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        TransformationUtils.m44893i().lock();
        try {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                TransformationUtils.m44893i().unlock();
                if (options.inJustDecodeBounds) {
                    inputStream.reset();
                }
                return decodeStream;
            } catch (IllegalArgumentException e) {
                IOException m44932q = m44932q(e, i, i2, str, options);
                if (Log.isLoggable(f14124f, 3)) {
                    Log.d(f14124f, "Failed to decode with inBitmap, trying again without Bitmap re-use", m44932q);
                }
                if (options.inBitmap != null) {
                    try {
                        inputStream.reset();
                        bitmapPool.mo44924d(options.inBitmap);
                        options.inBitmap = null;
                        Bitmap m44942g = m44942g(inputStream, options, interfaceC3722b, bitmapPool);
                        TransformationUtils.m44893i().unlock();
                        return m44942g;
                    } catch (IOException unused) {
                        throw m44932q;
                    }
                }
                throw m44932q;
            }
        } catch (Throwable th) {
            TransformationUtils.m44893i().unlock();
            throw th;
        }
    }

    @Nullable
    @TargetApi(19)
    /* renamed from: h */
    private static String m44941h(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    /* renamed from: i */
    private static synchronized BitmapFactory.Options m44940i() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = f14134p;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                m44930s(poll);
            }
        }
        return poll;
    }

    /* renamed from: j */
    private static int m44939j(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    /* renamed from: k */
    private static int[] m44938k(InputStream inputStream, BitmapFactory.Options options, InterfaceC3722b interfaceC3722b, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        m44942g(inputStream, options, interfaceC3722b, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* renamed from: l */
    private static String m44937l(BitmapFactory.Options options) {
        return m44941h(options.inBitmap);
    }

    /* renamed from: o */
    private static boolean m44934o(BitmapFactory.Options options) {
        int i;
        int i2 = options.inTargetDensity;
        return i2 > 0 && (i = options.inDensity) > 0 && i2 != i;
    }

    /* renamed from: p */
    private static void m44933p(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Log.v(f14124f, "Decoded " + m44941h(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + m44937l(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.m44412a(j));
    }

    /* renamed from: q */
    private static IOException m44932q(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + m44937l(options), illegalArgumentException);
    }

    /* renamed from: r */
    private static void m44931r(BitmapFactory.Options options) {
        m44930s(options);
        Queue<BitmapFactory.Options> queue = f14134p;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    /* renamed from: s */
    private static void m44930s(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    /* renamed from: t */
    private static int m44929t(double d) {
        return (int) (d + 0.5d);
    }

    @TargetApi(26)
    /* renamed from: u */
    private static void m44928u(BitmapFactory.Options options, BitmapPool bitmapPool, int i, int i2) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.mo45372f(i, i2, config);
    }

    /* renamed from: v */
    private boolean m44927v(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f14133o.contains(imageType);
    }

    /* renamed from: d */
    public Resource<Bitmap> m44945d(InputStream inputStream, int i, int i2, Options options) throws IOException {
        return m44944e(inputStream, i, i2, options, f14132n);
    }

    /* renamed from: e */
    public Resource<Bitmap> m44944e(InputStream inputStream, int i, int i2, Options options, InterfaceC3722b interfaceC3722b) throws IOException {
        C3770j.m44395a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f14138c.mo45394c(65536, byte[].class);
        BitmapFactory.Options m44940i = m44940i();
        m44940i.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.m45124c(f14125g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.m45124c(DownsampleStrategy.f14065h);
        boolean booleanValue = ((Boolean) options.m45124c(f14127i)).booleanValue();
        Option<Boolean> option = f14128j;
        try {
            return BitmapResource.m44977d(m44943f(inputStream, m44940i, downsampleStrategy, decodeFormat, options.m45124c(option) != null && ((Boolean) options.m45124c(option)).booleanValue(), i, i2, booleanValue, interfaceC3722b), this.f14136a);
        } finally {
            m44931r(m44940i);
            this.f14138c.put(bArr);
        }
    }

    /* renamed from: m */
    public boolean m44936m(InputStream inputStream) {
        return true;
    }

    /* renamed from: n */
    public boolean m44935n(ByteBuffer byteBuffer) {
        return true;
    }
}
