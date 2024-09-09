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
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Downsampler.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class n {

    /* renamed from: f  reason: collision with root package name */
    static final String f17441f = "Downsampler";

    /* renamed from: g  reason: collision with root package name */
    public static final com.bumptech.glide.load.e<DecodeFormat> f17442g = com.bumptech.glide.load.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public static final com.bumptech.glide.load.e<DownsampleStrategy> f17443h = DownsampleStrategy.f17382h;

    /* renamed from: i  reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Boolean> f17444i;

    /* renamed from: j  reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Boolean> f17445j;

    /* renamed from: k  reason: collision with root package name */
    private static final String f17446k = "image/vnd.wap.wbmp";

    /* renamed from: l  reason: collision with root package name */
    private static final String f17447l = "image/x-ico";

    /* renamed from: m  reason: collision with root package name */
    private static final Set<String> f17448m;

    /* renamed from: n  reason: collision with root package name */
    private static final b f17449n;

    /* renamed from: o  reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f17450o;

    /* renamed from: p  reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f17451p;

    /* renamed from: q  reason: collision with root package name */
    private static final int f17452q = 10485760;

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f17453a;

    /* renamed from: b  reason: collision with root package name */
    private final DisplayMetrics f17454b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f17455c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ImageHeaderParser> f17456d;

    /* renamed from: e  reason: collision with root package name */
    private final s f17457e = s.a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Downsampler.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.n.b
        public void a(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.n.b
        public void b() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Downsampler.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface b {
        void a(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f17444i = com.bumptech.glide.load.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f17445j = com.bumptech.glide.load.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f17448m = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f17449n = new a();
        f17450o = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f17451p = com.bumptech.glide.util.k.f(0);
    }

    public n(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f17456d = list;
        this.f17454b = (DisplayMetrics) com.bumptech.glide.util.j.d(displayMetrics);
        this.f17453a = (com.bumptech.glide.load.engine.bitmap_recycle.e) com.bumptech.glide.util.j.d(eVar);
        this.f17455c = (com.bumptech.glide.load.engine.bitmap_recycle.b) com.bumptech.glide.util.j.d(bVar);
    }

    private static int a(double d4) {
        int j4 = j(d4);
        double d5 = j4;
        Double.isNaN(d5);
        int t3 = t(d5 * d4);
        double d6 = t3 / j4;
        Double.isNaN(d6);
        double d7 = t3;
        Double.isNaN(d7);
        return t((d4 / d6) * d7);
    }

    private void b(InputStream inputStream, DecodeFormat decodeFormat, boolean z3, boolean z4, BitmapFactory.Options options, int i4, int i5) {
        if (this.f17457e.c(i4, i5, options, decodeFormat, z3, z4)) {
            return;
        }
        if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
            boolean z5 = false;
            try {
                z5 = com.bumptech.glide.load.b.getType(this.f17456d, inputStream, this.f17455c).hasAlpha();
            } catch (IOException e4) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e4);
                }
            }
            Bitmap.Config config = z5 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    private static void c(ImageHeaderParser.ImageType imageType, InputStream inputStream, b bVar, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, DownsampleStrategy downsampleStrategy, int i4, int i5, int i6, int i7, int i8, BitmapFactory.Options options) throws IOException {
        float b4;
        int min;
        int i9;
        int i10;
        int floor;
        double floor2;
        int i11;
        if (i5 <= 0 || i6 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i7 + "x" + i8 + "]");
                return;
            }
            return;
        }
        if (i4 != 90 && i4 != 270) {
            b4 = downsampleStrategy.b(i5, i6, i7, i8);
        } else {
            b4 = downsampleStrategy.b(i6, i5, i7, i8);
        }
        if (b4 > 0.0f) {
            DownsampleStrategy.SampleSizeRounding a4 = downsampleStrategy.a(i5, i6, i7, i8);
            if (a4 != null) {
                float f4 = i5;
                float f5 = i6;
                int t3 = i5 / t(b4 * f4);
                int t4 = i6 / t(b4 * f5);
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
                if (a4 == sampleSizeRounding) {
                    min = Math.max(t3, t4);
                } else {
                    min = Math.min(t3, t4);
                }
                int i12 = Build.VERSION.SDK_INT;
                if (i12 > 23 || !f17448m.contains(options.outMimeType)) {
                    int max = Math.max(1, Integer.highestOneBit(min));
                    i9 = (a4 != sampleSizeRounding || ((float) max) >= 1.0f / b4) ? max : max << 1;
                } else {
                    i9 = 1;
                }
                options.inSampleSize = i9;
                if (imageType == ImageHeaderParser.ImageType.JPEG) {
                    float min2 = Math.min(i9, 8);
                    i10 = i12;
                    floor = (int) Math.ceil(f4 / min2);
                    i11 = (int) Math.ceil(f5 / min2);
                    int i13 = i9 / 8;
                    if (i13 > 0) {
                        floor /= i13;
                        i11 /= i13;
                    }
                } else {
                    i10 = i12;
                    if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                        if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                            if (i10 >= 24) {
                                float f6 = i9;
                                floor = Math.round(f4 / f6);
                                i11 = Math.round(f5 / f6);
                            } else {
                                float f7 = i9;
                                floor = (int) Math.floor(f4 / f7);
                                floor2 = Math.floor(f5 / f7);
                            }
                        } else if (i5 % i9 == 0 && i6 % i9 == 0) {
                            floor = i5 / i9;
                            i11 = i6 / i9;
                        } else {
                            int[] k4 = k(inputStream, options, bVar, eVar);
                            int i14 = k4[0];
                            i11 = k4[1];
                            floor = i14;
                        }
                    } else {
                        float f8 = i9;
                        floor = (int) Math.floor(f4 / f8);
                        floor2 = Math.floor(f5 / f8);
                    }
                    i11 = (int) floor2;
                }
                double b5 = downsampleStrategy.b(floor, i11, i7, i8);
                if (i10 >= 19) {
                    options.inTargetDensity = a(b5);
                    options.inDensity = j(b5);
                }
                if (o(options)) {
                    options.inScaled = true;
                } else {
                    options.inTargetDensity = 0;
                    options.inDensity = 0;
                }
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler", "Calculate scaling, source: [" + i5 + "x" + i6 + "], target: [" + i7 + "x" + i8 + "], power of two scaled: [" + floor + "x" + i11 + "], exact scale factor: " + b4 + ", power of 2 sample size: " + i9 + ", adjusted scale factor: " + b5 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        throw new IllegalArgumentException("Cannot scale with factor: " + b4 + " from: " + downsampleStrategy + ", source: [" + i5 + "x" + i6 + "], target: [" + i7 + "x" + i8 + "]");
    }

    private Bitmap f(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z3, int i4, int i5, boolean z4, b bVar) throws IOException {
        int round;
        int round2;
        int i6;
        long b4 = com.bumptech.glide.util.f.b();
        int[] k4 = k(inputStream, options, bVar, this.f17453a);
        int i7 = k4[0];
        int i8 = k4[1];
        String str = options.outMimeType;
        boolean z5 = (i7 == -1 || i8 == -1) ? false : z3;
        int a4 = com.bumptech.glide.load.b.a(this.f17456d, inputStream, this.f17455c);
        int j4 = z.j(a4);
        boolean m4 = z.m(a4);
        int i9 = i4 == Integer.MIN_VALUE ? i7 : i4;
        int i10 = i5 == Integer.MIN_VALUE ? i8 : i5;
        ImageHeaderParser.ImageType type = com.bumptech.glide.load.b.getType(this.f17456d, inputStream, this.f17455c);
        c(type, inputStream, bVar, this.f17453a, downsampleStrategy, j4, i7, i8, i9, i10, options);
        b(inputStream, decodeFormat, z5, m4, options, i9, i10);
        boolean z6 = Build.VERSION.SDK_INT >= 19;
        if ((options.inSampleSize == 1 || z6) && v(type)) {
            if (i7 < 0 || i8 < 0 || !z4 || !z6) {
                float f4 = o(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i11 = options.inSampleSize;
                float f5 = i11;
                round = Math.round(((int) Math.ceil(i7 / f5)) * f4);
                round2 = Math.round(((int) Math.ceil(i8 / f5)) * f4);
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler", "Calculated target [" + round + "x" + round2 + "] for source [" + i7 + "x" + i8 + "], sampleSize: " + i11 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f4);
                }
            } else {
                round = i9;
                round2 = i10;
            }
            if (round > 0 && round2 > 0) {
                u(options, this.f17453a, round, round2);
            }
        }
        Bitmap g4 = g(inputStream, options, bVar, this.f17453a);
        bVar.a(this.f17453a, g4);
        if (Log.isLoggable("Downsampler", 2)) {
            i6 = a4;
            p(i7, i8, str, options, g4, i4, i5, b4);
        } else {
            i6 = a4;
        }
        Bitmap bitmap = null;
        if (g4 != null) {
            g4.setDensity(this.f17454b.densityDpi);
            bitmap = z.o(this.f17453a, g4, i6);
            if (!g4.equals(bitmap)) {
                this.f17453a.d(g4);
            }
        }
        return bitmap;
    }

    private static Bitmap g(InputStream inputStream, BitmapFactory.Options options, b bVar, com.bumptech.glide.load.engine.bitmap_recycle.e eVar) throws IOException {
        if (options.inJustDecodeBounds) {
            inputStream.mark(10485760);
        } else {
            bVar.b();
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        String str = options.outMimeType;
        z.i().lock();
        try {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                z.i().unlock();
                if (options.inJustDecodeBounds) {
                    inputStream.reset();
                }
                return decodeStream;
            } catch (IllegalArgumentException e4) {
                IOException q3 = q(e4, i4, i5, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", q3);
                }
                if (options.inBitmap != null) {
                    try {
                        inputStream.reset();
                        eVar.d(options.inBitmap);
                        options.inBitmap = null;
                        Bitmap g4 = g(inputStream, options, bVar, eVar);
                        z.i().unlock();
                        return g4;
                    } catch (IOException unused) {
                        throw q3;
                    }
                }
                throw q3;
            }
        } catch (Throwable th) {
            z.i().unlock();
            throw th;
        }
    }

    @Nullable
    @TargetApi(19)
    private static String h(Bitmap bitmap) {
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

    private static synchronized BitmapFactory.Options i() {
        BitmapFactory.Options poll;
        synchronized (n.class) {
            Queue<BitmapFactory.Options> queue = f17451p;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                s(poll);
            }
        }
        return poll;
    }

    private static int j(double d4) {
        if (d4 > 1.0d) {
            d4 = 1.0d / d4;
        }
        return (int) Math.round(d4 * 2.147483647E9d);
    }

    private static int[] k(InputStream inputStream, BitmapFactory.Options options, b bVar, com.bumptech.glide.load.engine.bitmap_recycle.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        g(inputStream, options, bVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String l(BitmapFactory.Options options) {
        return h(options.inBitmap);
    }

    private static boolean o(BitmapFactory.Options options) {
        int i4;
        int i5 = options.inTargetDensity;
        return i5 > 0 && (i4 = options.inDensity) > 0 && i5 != i4;
    }

    private static void p(int i4, int i5, String str, BitmapFactory.Options options, Bitmap bitmap, int i6, int i7, long j4) {
        Log.v("Downsampler", "Decoded " + h(bitmap) + " from [" + i4 + "x" + i5 + "] " + str + " with inBitmap " + l(options) + " for [" + i6 + "x" + i7 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.bumptech.glide.util.f.a(j4));
    }

    private static IOException q(IllegalArgumentException illegalArgumentException, int i4, int i5, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i4 + ", outHeight: " + i5 + ", outMimeType: " + str + ", inBitmap: " + l(options), illegalArgumentException);
    }

    private static void r(BitmapFactory.Options options) {
        s(options);
        Queue<BitmapFactory.Options> queue = f17451p;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void s(BitmapFactory.Options options) {
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

    private static int t(double d4) {
        return (int) (d4 + 0.5d);
    }

    @TargetApi(26)
    private static void u(BitmapFactory.Options options, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, int i4, int i5) {
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
        options.inBitmap = eVar.f(i4, i5, config);
    }

    private boolean v(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f17450o.contains(imageType);
    }

    public com.bumptech.glide.load.engine.u<Bitmap> d(InputStream inputStream, int i4, int i5, com.bumptech.glide.load.f fVar) throws IOException {
        return e(inputStream, i4, i5, fVar, f17449n);
    }

    public com.bumptech.glide.load.engine.u<Bitmap> e(InputStream inputStream, int i4, int i5, com.bumptech.glide.load.f fVar, b bVar) throws IOException {
        com.bumptech.glide.util.j.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f17455c.c(65536, byte[].class);
        BitmapFactory.Options i6 = i();
        i6.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) fVar.c(f17442g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) fVar.c(DownsampleStrategy.f17382h);
        boolean booleanValue = ((Boolean) fVar.c(f17444i)).booleanValue();
        com.bumptech.glide.load.e<Boolean> eVar = f17445j;
        try {
            return f.d(f(inputStream, i6, downsampleStrategy, decodeFormat, fVar.c(eVar) != null && ((Boolean) fVar.c(eVar)).booleanValue(), i4, i5, booleanValue, bVar), this.f17453a);
        } finally {
            r(i6);
            this.f17455c.put(bArr);
        }
    }

    public boolean m(InputStream inputStream) {
        return true;
    }

    public boolean n(ByteBuffer byteBuffer) {
        return true;
    }
}
