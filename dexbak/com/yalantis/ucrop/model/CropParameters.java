package com.yalantis.ucrop.model;

import android.graphics.Bitmap;

/* renamed from: com.yalantis.ucrop.model.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CropParameters {

    /* renamed from: a */
    private int f39831a;

    /* renamed from: b */
    private int f39832b;

    /* renamed from: c */
    private Bitmap.CompressFormat f39833c;

    /* renamed from: d */
    private int f39834d;

    /* renamed from: e */
    private String f39835e;

    /* renamed from: f */
    private String f39836f;

    /* renamed from: g */
    private ExifInfo f39837g;

    public CropParameters(int i, int i2, Bitmap.CompressFormat compressFormat, int i3, String str, String str2, ExifInfo exifInfo) {
        this.f39831a = i;
        this.f39832b = i2;
        this.f39833c = compressFormat;
        this.f39834d = i3;
        this.f39835e = str;
        this.f39836f = str2;
        this.f39837g = exifInfo;
    }

    /* renamed from: a */
    public Bitmap.CompressFormat m13047a() {
        return this.f39833c;
    }

    /* renamed from: b */
    public int m13046b() {
        return this.f39834d;
    }

    /* renamed from: c */
    public ExifInfo m13045c() {
        return this.f39837g;
    }

    /* renamed from: d */
    public String m13044d() {
        return this.f39835e;
    }

    /* renamed from: e */
    public String m13043e() {
        return this.f39836f;
    }

    /* renamed from: f */
    public int m13042f() {
        return this.f39831a;
    }

    /* renamed from: g */
    public int m13041g() {
        return this.f39832b;
    }
}
