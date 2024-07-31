package com.beizi.p051ad;

import android.content.Context;
import android.util.TypedValue;
import com.autonavi.amap.mapcore.tools.GlMapUtil;

/* renamed from: com.beizi.ad.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdSize {

    /* renamed from: a */
    public static final AdSize f9389a = new AdSize(GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 50, "320x50_mb");

    /* renamed from: b */
    public static final AdSize f9390b = new AdSize(468, 60, "468x60_as");

    /* renamed from: c */
    public static final AdSize f9391c = new AdSize(GlMapUtil.DEVICE_DISPLAY_DPI_HIGH, 100, "320x100_as");

    /* renamed from: d */
    public static final AdSize f9392d = new AdSize(728, 90, "728x90_as");

    /* renamed from: e */
    public static final AdSize f9393e = new AdSize(300, 250, "300x250_as");

    /* renamed from: f */
    public static final AdSize f9394f = new AdSize(160, 600, "160x600_as");

    /* renamed from: g */
    public static final AdSize f9395g = new AdSize(-1, -2, "smart_banner");

    /* renamed from: h */
    public static final AdSize f9396h = new AdSize(-3, -4, "fluid");

    /* renamed from: i */
    public static final AdSize f9397i = new AdSize(-3, 0, "search_v2");

    /* renamed from: j */
    private final int f9398j;

    /* renamed from: k */
    private final int f9399k;

    /* renamed from: l */
    private final String f9400l;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AdSize(int r3, int r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = -1
            if (r3 != r1) goto Lb
            java.lang.String r1 = "FULL"
            goto Lf
        Lb:
            java.lang.String r1 = java.lang.String.valueOf(r3)
        Lf:
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            r1 = -2
            if (r4 != r1) goto L1d
            java.lang.String r1 = "AUTO"
            goto L21
        L1d:
            java.lang.String r1 = java.lang.String.valueOf(r4)
        L21:
            r0.append(r1)
            java.lang.String r1 = "_as"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>(r3, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.p051ad.AdSize.<init>(int, int):void");
    }

    /* renamed from: a */
    public int m50192a() {
        return this.f9399k;
    }

    /* renamed from: b */
    public int m50190b() {
        return this.f9398j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AdSize) {
            AdSize adSize = (AdSize) obj;
            return this.f9398j == adSize.f9398j && this.f9399k == adSize.f9399k && this.f9400l.equals(adSize.f9400l);
        }
        return false;
    }

    public int hashCode() {
        return this.f9400l.hashCode();
    }

    public String toString() {
        return this.f9400l;
    }

    private AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        } else if (i2 < 0 && i2 != -2 && i2 != -4) {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        } else {
            this.f9398j = i;
            this.f9399k = i2;
            this.f9400l = str;
        }
    }

    /* renamed from: a */
    public int m50191a(Context context) {
        int i = this.f9399k;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i != -2) {
            return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: b */
    public int m50189b(Context context) {
        int i = this.f9398j;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i != -1) {
            return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
