package com.bykv.vk.component.ttvideo.utils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AVUtils {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class ScaleInfo {

        /* renamed from: h  reason: collision with root package name */
        public int f24906h;

        /* renamed from: w  reason: collision with root package name */
        public int f24907w;

        /* renamed from: x  reason: collision with root package name */
        public int f24908x;

        /* renamed from: y  reason: collision with root package name */
        public int f24909y;
    }

    public static final ScaleInfo getScaleInfoFromSize(float f4, float f5, float f6, float f7) {
        ScaleInfo scaleInfo = new ScaleInfo();
        float f8 = f4 / f5;
        scaleInfo.f24907w = (int) f6;
        int i4 = (int) (f6 / f8);
        scaleInfo.f24906h = i4;
        if (i4 < f7) {
            scaleInfo.f24906h = (int) f7;
            scaleInfo.f24907w = (int) (f8 * f7);
        }
        int i5 = scaleInfo.f24906h;
        int i6 = ((int) (i5 - f7)) >> 1;
        scaleInfo.f24909y = i6;
        int i7 = scaleInfo.f24907w;
        int i8 = ((int) (i7 - f6)) >> 1;
        scaleInfo.f24908x = i8;
        if (i5 > f7) {
            scaleInfo.f24909y = 0 - i6;
        }
        if (i7 > f6) {
            scaleInfo.f24908x = 0 - i8;
        }
        return scaleInfo;
    }
}
