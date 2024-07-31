package com.yalantis.ucrop.model;

import android.graphics.RectF;

/* renamed from: com.yalantis.ucrop.model.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ImageState {

    /* renamed from: a */
    private RectF f39841a;

    /* renamed from: b */
    private RectF f39842b;

    /* renamed from: c */
    private float f39843c;

    /* renamed from: d */
    private float f39844d;

    public ImageState(RectF rectF, RectF rectF2, float f, float f2) {
        this.f39841a = rectF;
        this.f39842b = rectF2;
        this.f39843c = f;
        this.f39844d = f2;
    }

    /* renamed from: a */
    public RectF m13034a() {
        return this.f39841a;
    }

    /* renamed from: b */
    public float m13033b() {
        return this.f39844d;
    }

    /* renamed from: c */
    public RectF m13032c() {
        return this.f39842b;
    }

    /* renamed from: d */
    public float m13031d() {
        return this.f39843c;
    }
}
