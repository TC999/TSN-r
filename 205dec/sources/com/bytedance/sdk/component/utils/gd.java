package com.bytedance.sdk.component.utils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f30188c;

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f30189f;

    /* renamed from: r  reason: collision with root package name */
    private static final int f30190r;
    private static final byte[] sr;
    private static final byte[] ux;

    /* renamed from: w  reason: collision with root package name */
    private static final byte[] f30191w;
    private static final byte[] xv;

    static {
        byte[] bArr = {-1, -40, -1};
        f30188c = bArr;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        f30191w = bArr2;
        byte[] bArr3 = {0, 0, 1, 0};
        xv = bArr3;
        byte[] c4 = c("BM");
        sr = c4;
        ux = c("GIF87a");
        f30189f = c("GIF89a");
        f30190r = ((Integer) Collections.max(Arrays.asList(Integer.valueOf(bArr.length), Integer.valueOf(bArr2.length), Integer.valueOf(bArr3.length), Integer.valueOf(c4.length), 6))).intValue();
    }

    public static int c() {
        return f30190r;
    }

    private static boolean f(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = xv;
        return length >= bArr2.length && c(bArr, bArr2);
    }

    private static boolean sr(byte[] bArr) {
        return (bArr.length >= 6 && c(bArr, ux)) || c(bArr, f30189f);
    }

    private static boolean ux(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = sr;
        return length >= bArr2.length && c(bArr, bArr2);
    }

    private static boolean w(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = f30188c;
        return length >= bArr2.length && c(bArr, bArr2);
    }

    private static boolean xv(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = f30191w;
        return length >= bArr2.length && c(bArr, bArr2);
    }

    public static final String c(byte[] bArr) {
        return w(bArr) ? "jpeg" : xv(bArr) ? "png" : sr(bArr) ? "gif" : ux(bArr) ? "bmp" : f(bArr) ? "ico" : "other";
    }

    private static boolean c(byte[] bArr, byte[] bArr2) {
        return c(bArr, bArr2, 0);
    }

    private static boolean c(byte[] bArr, byte[] bArr2, int i4) {
        if (bArr2.length + i4 > bArr.length) {
            return false;
        }
        for (int i5 = 0; i5 < bArr2.length; i5++) {
            if (bArr[i4 + i5] != bArr2[i5]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] c(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("ASCII not found!", e4);
        }
    }
}
