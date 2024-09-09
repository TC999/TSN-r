package com.qq.e.comm.plugin.b;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public enum g {
    SPLASH(4, 1, 3, 3),
    NATIVEEXPRESSAD(9, 1, 4, 4),
    REWARDVIDEOAD(11, 1, 5, 5),
    NATIVEUNIFIEDAD(12, 1, 6, 6),
    UNIFIED_BANNER(13, 1, 7, 7),
    UNIFIED_INTERSTITIAL(14, 2, 8, 8),
    UNIFIED_INTERSTITIAL_FULLSCREEN(22, 2, 9, 9);
    

    /* renamed from: c  reason: collision with root package name */
    private final int f41998c;

    /* renamed from: d  reason: collision with root package name */
    private final int f41999d;

    /* renamed from: e  reason: collision with root package name */
    public final int f42000e;

    /* renamed from: f  reason: collision with root package name */
    private final int f42001f;

    g(int i4, int i5, int i6, int i7) {
        this.f41998c = i4;
        this.f41999d = i5;
        this.f42000e = i6;
        this.f42001f = i7;
    }

    public int a() {
        return this.f41999d;
    }

    public String b() {
        return String.valueOf(this.f42001f);
    }

    public int c() {
        return this.f42001f;
    }

    public int d() {
        return this.f41998c;
    }

    public boolean e() {
        return this == UNIFIED_BANNER;
    }

    public boolean f() {
        return this == NATIVEEXPRESSAD;
    }

    public boolean g() {
        return this == UNIFIED_INTERSTITIAL_FULLSCREEN;
    }

    public boolean h() {
        return this == UNIFIED_INTERSTITIAL;
    }

    public boolean i() {
        return this == NATIVEUNIFIEDAD;
    }

    public boolean j() {
        return this == REWARDVIDEOAD;
    }

    public boolean k() {
        return this == SPLASH;
    }

    public static g a(int i4) {
        switch (i4) {
            case 3:
                return SPLASH;
            case 4:
                return NATIVEEXPRESSAD;
            case 5:
                return REWARDVIDEOAD;
            case 6:
                return NATIVEUNIFIEDAD;
            case 7:
                return UNIFIED_BANNER;
            case 8:
                return UNIFIED_INTERSTITIAL;
            case 9:
                return UNIFIED_INTERSTITIAL_FULLSCREEN;
            default:
                return null;
        }
    }

    public static g a(String str) {
        if ("splash".equals(str)) {
            return SPLASH;
        }
        if ("nativeexpressad".equals(str)) {
            return NATIVEEXPRESSAD;
        }
        if ("rewardvideoad".equals(str)) {
            return REWARDVIDEOAD;
        }
        if ("nativeunifiedad".equals(str)) {
            return NATIVEUNIFIEDAD;
        }
        if ("banner2".equals(str)) {
            return UNIFIED_BANNER;
        }
        if ("inter2".equals(str)) {
            return UNIFIED_INTERSTITIAL;
        }
        if ("inter2fs".equals(str)) {
            return UNIFIED_INTERSTITIAL_FULLSCREEN;
        }
        return null;
    }
}
