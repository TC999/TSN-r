package com.jmolsmobile.landscapevideocapture.configuration;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class PredefinedCaptureConfigurations {

    /* renamed from: A */
    public static final int f24383A = 28000000;

    /* renamed from: B */
    public static final int f24384B = 40000000;

    /* renamed from: C */
    public static final int f24385C = 2160;

    /* renamed from: D */
    public static final int f24386D = 3840;

    /* renamed from: E */
    public static final int f24387E = 30;

    /* renamed from: F */
    public static final int f24388F = 20;

    /* renamed from: G */
    public static final int f24389G = 24;

    /* renamed from: H */
    public static final int f24390H = 60;

    /* renamed from: a */
    public static final int f24391a = 300000;

    /* renamed from: b */
    public static final int f24392b = 700000;

    /* renamed from: c */
    public static final int f24393c = 1000000;

    /* renamed from: d */
    public static final int f24394d = 360;

    /* renamed from: e */
    public static final int f24395e = 640;

    /* renamed from: f */
    public static final int f24396f = 750000;

    /* renamed from: g */
    public static final int f24397g = 1750000;

    /* renamed from: h */
    public static final int f24398h = 2500000;

    /* renamed from: i */
    public static final int f24399i = 480;

    /* renamed from: j */
    public static final int f24400j = 640;

    /* renamed from: k */
    public static final int f24401k = 1500000;

    /* renamed from: l */
    public static final int f24402l = 3500000;

    /* renamed from: m */
    public static final int f24403m = 5000000;

    /* renamed from: n */
    public static final int f24404n = 720;

    /* renamed from: o */
    public static final int f24405o = 1280;

    /* renamed from: p */
    public static final int f24406p = 2400000;

    /* renamed from: q */
    public static final int f24407q = 5600000;

    /* renamed from: r */
    public static final int f24408r = 8000000;

    /* renamed from: s */
    public static final int f24409s = 1080;

    /* renamed from: t */
    public static final int f24410t = 1920;

    /* renamed from: u */
    public static final int f24411u = 3000000;

    /* renamed from: v */
    public static final int f24412v = 7000000;

    /* renamed from: w */
    public static final int f24413w = 10000000;

    /* renamed from: x */
    public static final int f24414x = 1440;

    /* renamed from: y */
    public static final int f24415y = 2560;

    /* renamed from: z */
    public static final int f24416z = 12000000;

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum CaptureQuality {
        LOW,
        MEDIUM,
        HIGH
    }

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum CaptureResolution {
        RES_360P(640, 360, 1000000, PredefinedCaptureConfigurations.f24392b, PredefinedCaptureConfigurations.f24391a),
        RES_480P(640, 480, PredefinedCaptureConfigurations.f24398h, PredefinedCaptureConfigurations.f24397g, PredefinedCaptureConfigurations.f24396f),
        RES_720P(PredefinedCaptureConfigurations.f24405o, PredefinedCaptureConfigurations.f24404n, PredefinedCaptureConfigurations.f24403m, PredefinedCaptureConfigurations.f24402l, PredefinedCaptureConfigurations.f24401k),
        RES_1080P(PredefinedCaptureConfigurations.f24410t, PredefinedCaptureConfigurations.f24409s, PredefinedCaptureConfigurations.f24408r, PredefinedCaptureConfigurations.f24407q, PredefinedCaptureConfigurations.f24406p),
        RES_1440P(PredefinedCaptureConfigurations.f24415y, PredefinedCaptureConfigurations.f24414x, PredefinedCaptureConfigurations.f24413w, PredefinedCaptureConfigurations.f24412v, PredefinedCaptureConfigurations.f24411u),
        RES_2160P(PredefinedCaptureConfigurations.f24386D, PredefinedCaptureConfigurations.f24385C, PredefinedCaptureConfigurations.f24384B, PredefinedCaptureConfigurations.f24383A, PredefinedCaptureConfigurations.f24416z);
        
        public int height;
        private final int highBitrate;
        private final int lowBitrate;
        private final int medBitrate;
        public int width;

        CaptureResolution(int i, int i2, int i3, int i4, int i5) {
            this.width = i;
            this.height = i2;
            this.highBitrate = i3;
            this.medBitrate = i4;
            this.lowBitrate = i5;
        }

        public int getBitrate(CaptureQuality captureQuality) {
            int i = this.highBitrate;
            int i2 = C7140a.f24417a[captureQuality.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return i2 != 3 ? i : this.lowBitrate;
                }
                return this.medBitrate;
            }
            return this.highBitrate;
        }
    }

    /* renamed from: com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static /* synthetic */ class C7140a {

        /* renamed from: a */
        static final /* synthetic */ int[] f24417a;

        static {
            int[] iArr = new int[CaptureQuality.values().length];
            f24417a = iArr;
            try {
                iArr[CaptureQuality.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24417a[CaptureQuality.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24417a[CaptureQuality.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
