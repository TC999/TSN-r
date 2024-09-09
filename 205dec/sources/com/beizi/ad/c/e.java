package com.beizi.ad.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: EnumType.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: EnumType.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum a {
        ADP_UNKNOWN(0),
        ADP_IVIDEO(1),
        ADP_LOADING(2),
        ADP_TABLE(3),
        ADP_BANNER(4),
        ADP_CUSTOMER(5),
        ADP_NATIVE(6);
        

        /* renamed from: h  reason: collision with root package name */
        private final int f13462h;

        a(int i4) {
            this.f13462h = i4;
        }

        public static a a(int i4) {
            switch (i4) {
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: EnumType.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum b {
        DEVICE_UNKNOWN(0),
        DEVICE_PHONE(1),
        DEVICE_FLAT(2),
        DEVICE_WEAR(3),
        DEVICE_PC(4),
        DEVICE_OTHER(5);
        

        /* renamed from: g  reason: collision with root package name */
        private final int f13470g;

        b(int i4) {
            this.f13470g = i4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: EnumType.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum c {
        ISP_UNKNOWN(0),
        ISP_CN_MOBILE(1),
        ISP_CN_UNICOM(2),
        ISP_CN_TEL(3),
        ISP_OTHER(4);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f13477f;

        c(int i4) {
            this.f13477f = i4;
        }

        public final int a() {
            return this.f13477f;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: EnumType.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum d {
        NET_UNKNOWN(0),
        NET_3G(1),
        NET_4G(2),
        NET_5G(3),
        NET_WIFI(4),
        NET_OTHER(5),
        NET_2G(6);
        

        /* renamed from: h  reason: collision with root package name */
        private final int f13486h;

        d(int i4) {
            this.f13486h = i4;
        }

        public final int a() {
            return this.f13486h;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: EnumType.java */
    /* renamed from: com.beizi.ad.c.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum EnumC0122e {
        PLATFORM_UNKNOWN(0),
        PLATFORM_IOS(1),
        PLATFORM_ANDROID(2),
        PLATFORM_OTHER(3);
        

        /* renamed from: e  reason: collision with root package name */
        private final int f13492e;

        EnumC0122e(int i4) {
            this.f13492e = i4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: EnumType.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum f {
        RENDER_UNKNOWN(0),
        RENDER_VIDEO(1),
        RENDER_PIC(2),
        RENDER_H5(3),
        RENDER_JSON(4),
        RENDER_VAST_VIDEO(5);
        

        /* renamed from: g  reason: collision with root package name */
        private final int f13500g;

        f(int i4) {
            this.f13500g = i4;
        }

        public static f a(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                if (i4 != 5) {
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: EnumType.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum g {
        REQ_UNKNOWN(0),
        REQ_AD(1),
        REQ_WIFI_PRELOAD(2);
        

        /* renamed from: d  reason: collision with root package name */
        private final int f13505d;

        g(int i4) {
            this.f13505d = i4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: EnumType.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum h {
        SCREEN_DIRECTION_UNKOWN(0),
        PORTRAIT(1),
        LANDSCAPE(2);
        

        /* renamed from: d  reason: collision with root package name */
        private final int f13510d;

        h(int i4) {
            this.f13510d = i4;
        }

        public static h a(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        return null;
                    }
                    return LANDSCAPE;
                }
                return PORTRAIT;
            }
            return SCREEN_DIRECTION_UNKOWN;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: EnumType.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum i {
        SRC_UNKNOWN(0),
        SRC_APP(1),
        SRC_WAP(2),
        SRC_PC(3),
        SRC_TEST(4);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f13517f;

        i(int i4) {
            this.f13517f = i4;
        }
    }
}
