package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class DownsampleStrategy {

    /* renamed from: a */
    public static final DownsampleStrategy f14058a = new C3708e();

    /* renamed from: b */
    public static final DownsampleStrategy f14059b;

    /* renamed from: c */
    public static final DownsampleStrategy f14060c;

    /* renamed from: d */
    public static final DownsampleStrategy f14061d;

    /* renamed from: e */
    public static final DownsampleStrategy f14062e;

    /* renamed from: f */
    public static final DownsampleStrategy f14063f;

    /* renamed from: g */
    public static final DownsampleStrategy f14064g;

    /* renamed from: h */
    public static final Option<DownsampleStrategy> f14065h;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3704a extends DownsampleStrategy {
        C3704a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: a */
        public SampleSizeRounding mo44997a(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: b */
        public float mo44996b(int i, int i2, int i3, int i4) {
            int min = Math.min(i2 / i4, i / i3);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(min);
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3705b extends DownsampleStrategy {
        C3705b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: a */
        public SampleSizeRounding mo44997a(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: b */
        public float mo44996b(int i, int i2, int i3, int i4) {
            int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            return 1.0f / (max << (max >= ceil ? 0 : 1));
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3706c extends DownsampleStrategy {
        C3706c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: a */
        public SampleSizeRounding mo44997a(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: b */
        public float mo44996b(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, DownsampleStrategy.f14058a.mo44996b(i, i2, i3, i4));
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3707d extends DownsampleStrategy {
        C3707d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: a */
        public SampleSizeRounding mo44997a(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: b */
        public float mo44996b(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3708e extends DownsampleStrategy {
        C3708e() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: a */
        public SampleSizeRounding mo44997a(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: b */
        public float mo44996b(int i, int i2, int i3, int i4) {
            return Math.min(i3 / i, i4 / i2);
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3709f extends DownsampleStrategy {
        C3709f() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: a */
        public SampleSizeRounding mo44997a(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: b */
        public float mo44996b(int i, int i2, int i3, int i4) {
            return 1.0f;
        }
    }

    static {
        C3707d c3707d = new C3707d();
        f14059b = c3707d;
        f14060c = new C3704a();
        f14061d = new C3705b();
        f14062e = new C3706c();
        f14063f = new C3709f();
        f14064g = c3707d;
        f14065h = Option.m45431g("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", c3707d);
    }

    /* renamed from: a */
    public abstract SampleSizeRounding mo44997a(int i, int i2, int i3, int i4);

    /* renamed from: b */
    public abstract float mo44996b(int i, int i2, int i3, int i4);
}
