package com.qq.e.lib.a.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.qq.e.lib.a.e.d;
import com.qq.e.lib.a.e.f;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a<R extends d, W extends f> {

    /* renamed from: a  reason: collision with root package name */
    protected final R f47304a;

    /* renamed from: b  reason: collision with root package name */
    public int f47305b;

    /* renamed from: c  reason: collision with root package name */
    public int f47306c;

    /* renamed from: d  reason: collision with root package name */
    public int f47307d;

    /* renamed from: e  reason: collision with root package name */
    public int f47308e;

    /* renamed from: f  reason: collision with root package name */
    public int f47309f;

    /* renamed from: g  reason: collision with root package name */
    protected final Rect f47310g = new Rect();

    /* renamed from: h  reason: collision with root package name */
    protected final Rect f47311h = new Rect();

    public a(R r3) {
        this.f47304a = r3;
    }

    public abstract Bitmap a(Canvas canvas, Paint paint, int i4, Bitmap bitmap, W w3);
}
