package com.yalantis.ucrop.util;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* renamed from: com.yalantis.ucrop.util.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RotationGestureDetector {

    /* renamed from: j */
    private static final int f39898j = -1;

    /* renamed from: a */
    private float f39899a;

    /* renamed from: b */
    private float f39900b;

    /* renamed from: c */
    private float f39901c;

    /* renamed from: d */
    private float f39902d;

    /* renamed from: e */
    private int f39903e = -1;

    /* renamed from: f */
    private int f39904f = -1;

    /* renamed from: g */
    private float f39905g;

    /* renamed from: h */
    private boolean f39906h;

    /* renamed from: i */
    private InterfaceC13530a f39907i;

    /* compiled from: RotationGestureDetector.java */
    /* renamed from: com.yalantis.ucrop.util.h$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC13530a {
        /* renamed from: a */
        boolean mo12952a(RotationGestureDetector rotationGestureDetector);
    }

    /* compiled from: RotationGestureDetector.java */
    /* renamed from: com.yalantis.ucrop.util.h$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13531b implements InterfaceC13530a {
        @Override // com.yalantis.ucrop.util.RotationGestureDetector.InterfaceC13530a
        /* renamed from: a */
        public boolean mo12952a(RotationGestureDetector rotationGestureDetector) {
            return false;
        }
    }

    public RotationGestureDetector(InterfaceC13530a interfaceC13530a) {
        this.f39907i = interfaceC13530a;
    }

    /* renamed from: a */
    private float m12978a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return m12977b((float) Math.toDegrees((float) Math.atan2(f2 - f4, f - f3)), (float) Math.toDegrees((float) Math.atan2(f6 - f8, f5 - f7)));
    }

    /* renamed from: b */
    private float m12977b(float f, float f2) {
        float f3 = (f2 % 360.0f) - (f % 360.0f);
        this.f39905g = f3;
        if (f3 < -180.0f) {
            this.f39905g = f3 + 360.0f;
        } else if (f3 > 180.0f) {
            this.f39905g = f3 - 360.0f;
        }
        return this.f39905g;
    }

    /* renamed from: c */
    public float m12976c() {
        return this.f39905g;
    }

    /* renamed from: d */
    public boolean m12975d(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f39901c = motionEvent.getX();
            this.f39902d = motionEvent.getY();
            this.f39903e = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
            this.f39905g = 0.0f;
            this.f39906h = true;
        } else if (actionMasked == 1) {
            this.f39903e = -1;
        } else if (actionMasked != 2) {
            if (actionMasked == 5) {
                this.f39899a = motionEvent.getX();
                this.f39900b = motionEvent.getY();
                this.f39904f = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                this.f39905g = 0.0f;
                this.f39906h = true;
            } else if (actionMasked == 6) {
                this.f39904f = -1;
            }
        } else if (this.f39903e != -1 && this.f39904f != -1 && motionEvent.getPointerCount() > this.f39904f) {
            float x = motionEvent.getX(this.f39903e);
            float y = motionEvent.getY(this.f39903e);
            float x2 = motionEvent.getX(this.f39904f);
            float y2 = motionEvent.getY(this.f39904f);
            if (this.f39906h) {
                this.f39905g = 0.0f;
                this.f39906h = false;
            } else {
                m12978a(this.f39899a, this.f39900b, this.f39901c, this.f39902d, x2, y2, x, y);
            }
            InterfaceC13530a interfaceC13530a = this.f39907i;
            if (interfaceC13530a != null) {
                interfaceC13530a.mo12952a(this);
            }
            this.f39899a = x2;
            this.f39900b = y2;
            this.f39901c = x;
            this.f39902d = y;
        }
        return true;
    }
}
