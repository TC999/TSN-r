package com.yalantis.ucrop.util;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: RotationGestureDetector.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h {

    /* renamed from: j  reason: collision with root package name */
    private static final int f54434j = -1;

    /* renamed from: a  reason: collision with root package name */
    private float f54435a;

    /* renamed from: b  reason: collision with root package name */
    private float f54436b;

    /* renamed from: c  reason: collision with root package name */
    private float f54437c;

    /* renamed from: d  reason: collision with root package name */
    private float f54438d;

    /* renamed from: e  reason: collision with root package name */
    private int f54439e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f54440f = -1;

    /* renamed from: g  reason: collision with root package name */
    private float f54441g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f54442h;

    /* renamed from: i  reason: collision with root package name */
    private a f54443i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: RotationGestureDetector.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        boolean a(h hVar);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: RotationGestureDetector.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class b implements a {
        @Override // com.yalantis.ucrop.util.h.a
        public boolean a(h hVar) {
            return false;
        }
    }

    public h(a aVar) {
        this.f54443i = aVar;
    }

    private float a(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        return b((float) Math.toDegrees((float) Math.atan2(f5 - f7, f4 - f6)), (float) Math.toDegrees((float) Math.atan2(f9 - f11, f8 - f10)));
    }

    private float b(float f4, float f5) {
        float f6 = (f5 % 360.0f) - (f4 % 360.0f);
        this.f54441g = f6;
        if (f6 < -180.0f) {
            this.f54441g = f6 + 360.0f;
        } else if (f6 > 180.0f) {
            this.f54441g = f6 - 360.0f;
        }
        return this.f54441g;
    }

    public float c() {
        return this.f54441g;
    }

    public boolean d(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f54437c = motionEvent.getX();
            this.f54438d = motionEvent.getY();
            this.f54439e = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
            this.f54441g = 0.0f;
            this.f54442h = true;
        } else if (actionMasked == 1) {
            this.f54439e = -1;
        } else if (actionMasked != 2) {
            if (actionMasked == 5) {
                this.f54435a = motionEvent.getX();
                this.f54436b = motionEvent.getY();
                this.f54440f = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                this.f54441g = 0.0f;
                this.f54442h = true;
            } else if (actionMasked == 6) {
                this.f54440f = -1;
            }
        } else if (this.f54439e != -1 && this.f54440f != -1 && motionEvent.getPointerCount() > this.f54440f) {
            float x3 = motionEvent.getX(this.f54439e);
            float y3 = motionEvent.getY(this.f54439e);
            float x4 = motionEvent.getX(this.f54440f);
            float y4 = motionEvent.getY(this.f54440f);
            if (this.f54442h) {
                this.f54441g = 0.0f;
                this.f54442h = false;
            } else {
                a(this.f54435a, this.f54436b, this.f54437c, this.f54438d, x4, y4, x3, y3);
            }
            a aVar = this.f54443i;
            if (aVar != null) {
                aVar.a(this);
            }
            this.f54435a = x4;
            this.f54436b = y4;
            this.f54437c = x3;
            this.f54438d = y3;
        }
        return true;
    }
}
