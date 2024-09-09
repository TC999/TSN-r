package com.bumptech.glide.load.resource.bitmap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class DownsampleStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DownsampleStrategy f17375a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final DownsampleStrategy f17376b;

    /* renamed from: c  reason: collision with root package name */
    public static final DownsampleStrategy f17377c;

    /* renamed from: d  reason: collision with root package name */
    public static final DownsampleStrategy f17378d;

    /* renamed from: e  reason: collision with root package name */
    public static final DownsampleStrategy f17379e;

    /* renamed from: f  reason: collision with root package name */
    public static final DownsampleStrategy f17380f;

    /* renamed from: g  reason: collision with root package name */
    public static final DownsampleStrategy f17381g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.bumptech.glide.load.e<DownsampleStrategy> f17382h;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class a extends DownsampleStrategy {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i4, int i5, int i6, int i7) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i4, int i5, int i6, int i7) {
            int min = Math.min(i5 / i7, i4 / i6);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(min);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class b extends DownsampleStrategy {
        b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i4, int i5, int i6, int i7) {
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i4, int i5, int i6, int i7) {
            int ceil = (int) Math.ceil(Math.max(i5 / i7, i4 / i6));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            return 1.0f / (max << (max >= ceil ? 0 : 1));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class c extends DownsampleStrategy {
        c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i4, int i5, int i6, int i7) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i4, int i5, int i6, int i7) {
            return Math.min(1.0f, DownsampleStrategy.f17375a.b(i4, i5, i6, i7));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class d extends DownsampleStrategy {
        d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i4, int i5, int i6, int i7) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i4, int i5, int i6, int i7) {
            return Math.max(i6 / i4, i7 / i5);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class e extends DownsampleStrategy {
        e() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i4, int i5, int i6, int i7) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i4, int i5, int i6, int i7) {
            return Math.min(i6 / i4, i7 / i5);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class f extends DownsampleStrategy {
        f() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i4, int i5, int i6, int i7) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i4, int i5, int i6, int i7) {
            return 1.0f;
        }
    }

    static {
        d dVar = new d();
        f17376b = dVar;
        f17377c = new a();
        f17378d = new b();
        f17379e = new c();
        f17380f = new f();
        f17381g = dVar;
        f17382h = com.bumptech.glide.load.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
    }

    public abstract SampleSizeRounding a(int i4, int i5, int i6, int i7);

    public abstract float b(int i4, int i5, int i6, int i7);
}
