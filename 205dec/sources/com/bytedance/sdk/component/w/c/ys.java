package com.bytedance.sdk.component.w.c;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ys {

    /* renamed from: c  reason: collision with root package name */
    private String f30450c;

    /* renamed from: f  reason: collision with root package name */
    public c f30451f;
    public String sr;
    public byte[] ux;

    /* renamed from: w  reason: collision with root package name */
    private String f30452w;
    public p xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum c {
        STRING_TYPE,
        BYTE_ARRAY_TYPE,
        FILE_TYPE
    }

    public ys() {
    }

    public String c() {
        return this.f30450c;
    }

    public String w() {
        return this.f30452w;
    }

    public ys(p pVar, String str, c cVar) {
        this.xv = pVar;
        this.sr = str;
        this.f30451f = cVar;
    }

    public static ys c(p pVar, String str) {
        return new ys(pVar, str, c.STRING_TYPE);
    }

    public static ys c(p pVar, byte[] bArr) {
        return new ys(pVar, bArr, c.BYTE_ARRAY_TYPE);
    }

    public static ys c(p pVar, byte[] bArr, String str, String str2) {
        return new ys(pVar, bArr, str, str2, c.FILE_TYPE);
    }

    public ys(p pVar, byte[] bArr, String str, String str2, c cVar) {
        this.xv = pVar;
        this.ux = bArr;
        this.f30452w = str;
        this.f30450c = str2;
        this.f30451f = cVar;
    }

    public ys(p pVar, byte[] bArr, c cVar) {
        this.xv = pVar;
        this.ux = bArr;
        this.f30451f = cVar;
    }
}
