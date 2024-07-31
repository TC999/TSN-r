package com.beizi.p051ad.p056c;

/* renamed from: com.beizi.ad.c.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class EnumType {

    /* compiled from: EnumType.java */
    /* renamed from: com.beizi.ad.c.e$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2812a {
        ADP_UNKNOWN(0),
        ADP_IVIDEO(1),
        ADP_LOADING(2),
        ADP_TABLE(3),
        ADP_BANNER(4),
        ADP_CUSTOMER(5),
        ADP_NATIVE(6);
        

        /* renamed from: h */
        private final int f9764h;

        EnumC2812a(int i) {
            this.f9764h = i;
        }

        /* renamed from: a */
        public static EnumC2812a m49788a(int i) {
            switch (i) {
                case 0:
                    return ADP_UNKNOWN;
                case 1:
                    return ADP_IVIDEO;
                case 2:
                    return ADP_LOADING;
                case 3:
                    return ADP_TABLE;
                case 4:
                    return ADP_BANNER;
                case 5:
                    return ADP_CUSTOMER;
                case 6:
                    return ADP_NATIVE;
                default:
                    return null;
            }
        }
    }

    /* compiled from: EnumType.java */
    /* renamed from: com.beizi.ad.c.e$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2813b {
        DEVICE_UNKNOWN(0),
        DEVICE_PHONE(1),
        DEVICE_FLAT(2),
        DEVICE_WEAR(3),
        DEVICE_PC(4),
        DEVICE_OTHER(5);
        

        /* renamed from: g */
        private final int f9772g;

        EnumC2813b(int i) {
            this.f9772g = i;
        }
    }

    /* compiled from: EnumType.java */
    /* renamed from: com.beizi.ad.c.e$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2814c {
        ISP_UNKNOWN(0),
        ISP_CN_MOBILE(1),
        ISP_CN_UNICOM(2),
        ISP_CN_TEL(3),
        ISP_OTHER(4);
        

        /* renamed from: f */
        private final int f9779f;

        EnumC2814c(int i) {
            this.f9779f = i;
        }

        /* renamed from: a */
        public final int m49787a() {
            return this.f9779f;
        }
    }

    /* compiled from: EnumType.java */
    /* renamed from: com.beizi.ad.c.e$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2815d {
        NET_UNKNOWN(0),
        NET_3G(1),
        NET_4G(2),
        NET_5G(3),
        NET_WIFI(4),
        NET_OTHER(5),
        NET_2G(6);
        

        /* renamed from: h */
        private final int f9788h;

        EnumC2815d(int i) {
            this.f9788h = i;
        }

        /* renamed from: a */
        public final int m49786a() {
            return this.f9788h;
        }
    }

    /* compiled from: EnumType.java */
    /* renamed from: com.beizi.ad.c.e$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2816e {
        PLATFORM_UNKNOWN(0),
        PLATFORM_IOS(1),
        PLATFORM_ANDROID(2),
        PLATFORM_OTHER(3);
        

        /* renamed from: e */
        private final int f9794e;

        EnumC2816e(int i) {
            this.f9794e = i;
        }
    }

    /* compiled from: EnumType.java */
    /* renamed from: com.beizi.ad.c.e$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2817f {
        RENDER_UNKNOWN(0),
        RENDER_VIDEO(1),
        RENDER_PIC(2),
        RENDER_H5(3),
        RENDER_JSON(4),
        RENDER_VAST_VIDEO(5);
        

        /* renamed from: g */
        private final int f9802g;

        EnumC2817f(int i) {
            this.f9802g = i;
        }

        /* renamed from: a */
        public static EnumC2817f m49785a(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return null;
                                }
                                return RENDER_VAST_VIDEO;
                            }
                            return RENDER_JSON;
                        }
                        return RENDER_H5;
                    }
                    return RENDER_PIC;
                }
                return RENDER_VIDEO;
            }
            return RENDER_UNKNOWN;
        }
    }

    /* compiled from: EnumType.java */
    /* renamed from: com.beizi.ad.c.e$g */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2818g {
        REQ_UNKNOWN(0),
        REQ_AD(1),
        REQ_WIFI_PRELOAD(2);
        

        /* renamed from: d */
        private final int f9807d;

        EnumC2818g(int i) {
            this.f9807d = i;
        }
    }

    /* compiled from: EnumType.java */
    /* renamed from: com.beizi.ad.c.e$h */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2819h {
        SCREEN_DIRECTION_UNKOWN(0),
        PORTRAIT(1),
        LANDSCAPE(2);
        

        /* renamed from: d */
        private final int f9812d;

        EnumC2819h(int i) {
            this.f9812d = i;
        }

        /* renamed from: a */
        public static EnumC2819h m49784a(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return LANDSCAPE;
                }
                return PORTRAIT;
            }
            return SCREEN_DIRECTION_UNKOWN;
        }
    }

    /* compiled from: EnumType.java */
    /* renamed from: com.beizi.ad.c.e$i */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2820i {
        SRC_UNKNOWN(0),
        SRC_APP(1),
        SRC_WAP(2),
        SRC_PC(3),
        SRC_TEST(4);
        

        /* renamed from: f */
        private final int f9819f;

        EnumC2820i(int i) {
            this.f9819f = i;
        }
    }
}
