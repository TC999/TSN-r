package com.jmolsmobile.landscapevideocapture.configuration;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class PredefinedCaptureConfigurations {
    public static final int A = 28000000;
    public static final int B = 40000000;
    public static final int C = 2160;
    public static final int D = 3840;
    public static final int E = 30;
    public static final int F = 20;
    public static final int G = 24;
    public static final int H = 60;

    /* renamed from: a  reason: collision with root package name */
    public static final int f37931a = 300000;

    /* renamed from: b  reason: collision with root package name */
    public static final int f37932b = 700000;

    /* renamed from: c  reason: collision with root package name */
    public static final int f37933c = 1000000;

    /* renamed from: d  reason: collision with root package name */
    public static final int f37934d = 360;

    /* renamed from: e  reason: collision with root package name */
    public static final int f37935e = 640;

    /* renamed from: f  reason: collision with root package name */
    public static final int f37936f = 750000;

    /* renamed from: g  reason: collision with root package name */
    public static final int f37937g = 1750000;

    /* renamed from: h  reason: collision with root package name */
    public static final int f37938h = 2500000;

    /* renamed from: i  reason: collision with root package name */
    public static final int f37939i = 480;

    /* renamed from: j  reason: collision with root package name */
    public static final int f37940j = 640;

    /* renamed from: k  reason: collision with root package name */
    public static final int f37941k = 1500000;

    /* renamed from: l  reason: collision with root package name */
    public static final int f37942l = 3500000;

    /* renamed from: m  reason: collision with root package name */
    public static final int f37943m = 5000000;

    /* renamed from: n  reason: collision with root package name */
    public static final int f37944n = 720;

    /* renamed from: o  reason: collision with root package name */
    public static final int f37945o = 1280;

    /* renamed from: p  reason: collision with root package name */
    public static final int f37946p = 2400000;

    /* renamed from: q  reason: collision with root package name */
    public static final int f37947q = 5600000;

    /* renamed from: r  reason: collision with root package name */
    public static final int f37948r = 8000000;

    /* renamed from: s  reason: collision with root package name */
    public static final int f37949s = 1080;

    /* renamed from: t  reason: collision with root package name */
    public static final int f37950t = 1920;

    /* renamed from: u  reason: collision with root package name */
    public static final int f37951u = 3000000;

    /* renamed from: v  reason: collision with root package name */
    public static final int f37952v = 7000000;

    /* renamed from: w  reason: collision with root package name */
    public static final int f37953w = 10000000;

    /* renamed from: x  reason: collision with root package name */
    public static final int f37954x = 1440;

    /* renamed from: y  reason: collision with root package name */
    public static final int f37955y = 2560;

    /* renamed from: z  reason: collision with root package name */
    public static final int f37956z = 12000000;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum CaptureQuality {
        LOW,
        MEDIUM,
        HIGH
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum CaptureResolution {
        RES_360P(640, 360, 1000000, 700000, 300000),
        RES_480P(640, 480, 2500000, 1750000, 750000),
        RES_720P(1280, 720, 5000000, 3500000, 1500000),
        RES_1080P(1920, 1080, 8000000, 5600000, 2400000),
        RES_1440P(2560, 1440, 10000000, 7000000, 3000000),
        RES_2160P(3840, 2160, 40000000, 28000000, 12000000);
        
        public int height;
        private final int highBitrate;
        private final int lowBitrate;
        private final int medBitrate;
        public int width;

        CaptureResolution(int i4, int i5, int i6, int i7, int i8) {
            this.width = i4;
            this.height = i5;
            this.highBitrate = i6;
            this.medBitrate = i7;
            this.lowBitrate = i8;
        }

        public int getBitrate(CaptureQuality captureQuality) {
            int i4 = this.highBitrate;
            int i5 = a.f37957a[captureQuality.ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    return i5 != 3 ? i4 : this.lowBitrate;
                }
                return this.medBitrate;
            }
            return this.highBitrate;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37957a;

        static {
            int[] iArr = new int[CaptureQuality.values().length];
            f37957a = iArr;
            try {
                iArr[CaptureQuality.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37957a[CaptureQuality.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37957a[CaptureQuality.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
