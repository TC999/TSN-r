package com.amap.api.col.p0003l;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ScaleGestureDetector.java */
/* renamed from: com.amap.api.col.3l.u  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private final Context f9110a;

    /* renamed from: b  reason: collision with root package name */
    private final a f9111b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9112c;

    /* renamed from: d  reason: collision with root package name */
    private MotionEvent f9113d;

    /* renamed from: e  reason: collision with root package name */
    private MotionEvent f9114e;

    /* renamed from: f  reason: collision with root package name */
    private float f9115f;

    /* renamed from: g  reason: collision with root package name */
    private float f9116g;

    /* renamed from: h  reason: collision with root package name */
    private float f9117h;

    /* renamed from: i  reason: collision with root package name */
    private float f9118i;

    /* renamed from: j  reason: collision with root package name */
    private float f9119j;

    /* renamed from: k  reason: collision with root package name */
    private float f9120k;

    /* renamed from: l  reason: collision with root package name */
    private float f9121l;

    /* renamed from: m  reason: collision with root package name */
    private float f9122m;

    /* renamed from: n  reason: collision with root package name */
    private float f9123n;

    /* renamed from: o  reason: collision with root package name */
    private float f9124o;

    /* renamed from: p  reason: collision with root package name */
    private float f9125p;

    /* renamed from: q  reason: collision with root package name */
    private long f9126q;

    /* renamed from: r  reason: collision with root package name */
    private final float f9127r;

    /* renamed from: s  reason: collision with root package name */
    private float f9128s;

    /* renamed from: t  reason: collision with root package name */
    private float f9129t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f9130u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f9131v;

    /* renamed from: w  reason: collision with root package name */
    private int f9132w;

    /* renamed from: x  reason: collision with root package name */
    private int f9133x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f9134y;

    /* renamed from: z  reason: collision with root package name */
    private int f9135z = 0;
    private int A = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ScaleGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.u$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        boolean a(u uVar);

        boolean b(u uVar);

        void c(u uVar);
    }

    public u(Context context, a aVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f9110a = context;
        this.f9111b = aVar;
        this.f9127r = viewConfiguration.getScaledEdgeSlop();
    }

    private static float a(MotionEvent motionEvent, int i4) {
        if (i4 < 0) {
            return Float.MIN_VALUE;
        }
        if (i4 == 0) {
            return motionEvent.getRawX();
        }
        return motionEvent.getX(i4) + (motionEvent.getRawX() - motionEvent.getX());
    }

    private int b(MotionEvent motionEvent, int i4, int i5) {
        int pointerCount = motionEvent.getPointerCount();
        int findPointerIndex = motionEvent.findPointerIndex(i4);
        for (int i6 = 0; i6 < pointerCount; i6++) {
            if (i6 != i5 && i6 != findPointerIndex) {
                float f4 = this.f9127r;
                float f5 = this.f9128s;
                float f6 = this.f9129t;
                float a4 = a(motionEvent, i6);
                float g4 = g(motionEvent, i6);
                if (a4 >= f4 && g4 >= f4 && a4 <= f5 && g4 <= f6) {
                    return i6;
                }
            }
        }
        return -1;
    }

    private static float g(MotionEvent motionEvent, int i4) {
        if (i4 < 0) {
            return Float.MIN_VALUE;
        }
        if (i4 == 0) {
            return motionEvent.getRawY();
        }
        return motionEvent.getY(i4) + (motionEvent.getRawY() - motionEvent.getY());
    }

    private void h(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f9114e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.f9114e = MotionEvent.obtain(motionEvent);
        this.f9121l = -1.0f;
        this.f9122m = -1.0f;
        this.f9123n = -1.0f;
        MotionEvent motionEvent3 = this.f9113d;
        int findPointerIndex = motionEvent3.findPointerIndex(this.f9132w);
        int findPointerIndex2 = motionEvent3.findPointerIndex(this.f9133x);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.f9132w);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.f9133x);
        if (findPointerIndex >= 0 && findPointerIndex2 >= 0 && findPointerIndex3 >= 0 && findPointerIndex4 >= 0) {
            float x3 = motionEvent3.getX(findPointerIndex);
            float y3 = motionEvent3.getY(findPointerIndex);
            float x4 = motionEvent3.getX(findPointerIndex2);
            float y4 = motionEvent3.getY(findPointerIndex2);
            float x5 = motionEvent.getX(findPointerIndex3);
            float y5 = motionEvent.getY(findPointerIndex3);
            float x6 = motionEvent.getX(findPointerIndex4) - x5;
            float y6 = motionEvent.getY(findPointerIndex4) - y5;
            this.f9117h = x4 - x3;
            this.f9118i = y4 - y3;
            this.f9119j = x6;
            this.f9120k = y6;
            this.f9115f = x5 + (x6 * 0.5f);
            this.f9116g = y5 + (y6 * 0.5f);
            this.f9126q = motionEvent.getEventTime() - motionEvent3.getEventTime();
            this.f9124o = motionEvent.getPressure(findPointerIndex3) + motionEvent.getPressure(findPointerIndex4);
            this.f9125p = motionEvent3.getPressure(findPointerIndex) + motionEvent3.getPressure(findPointerIndex2);
            return;
        }
        this.f9131v = true;
        if (this.f9112c) {
            this.f9111b.c(this);
        }
    }

    private void p() {
        MotionEvent motionEvent = this.f9113d;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f9113d = null;
        }
        MotionEvent motionEvent2 = this.f9114e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f9114e = null;
        }
        this.f9130u = false;
        this.f9112c = false;
        this.f9132w = -1;
        this.f9133x = -1;
        this.f9131v = false;
    }

    private float q() {
        if (this.f9121l == -1.0f) {
            float f4 = this.f9119j;
            float f5 = this.f9120k;
            this.f9121l = (float) Math.sqrt((f4 * f4) + (f5 * f5));
        }
        return this.f9121l;
    }

    private float r() {
        if (this.f9122m == -1.0f) {
            float f4 = this.f9117h;
            float f5 = this.f9118i;
            this.f9122m = (float) Math.sqrt((f4 * f4) + (f5 * f5));
        }
        return this.f9122m;
    }

    public final MotionEvent c() {
        return this.f9114e;
    }

    public final void d(int i4, int i5) {
        this.f9135z = i4;
        this.A = i5;
    }

    public final boolean e(MotionEvent motionEvent) {
        int b4;
        int b5;
        int i4;
        int b6;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            p();
        }
        boolean z3 = false;
        if (this.f9131v) {
            return false;
        }
        if (this.f9112c) {
            if (action == 1) {
                p();
            } else if (action == 2) {
                h(motionEvent);
                if (this.f9124o / this.f9125p > 0.67f && this.f9111b.a(this)) {
                    this.f9113d.recycle();
                    this.f9113d = MotionEvent.obtain(motionEvent);
                }
            } else if (action == 3) {
                this.f9111b.c(this);
                p();
            } else if (action == 5) {
                this.f9111b.c(this);
                int i5 = this.f9132w;
                int i6 = this.f9133x;
                p();
                this.f9113d = MotionEvent.obtain(motionEvent);
                if (!this.f9134y) {
                    i5 = i6;
                }
                this.f9132w = i5;
                this.f9133x = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.f9134y = false;
                int findPointerIndex = motionEvent.findPointerIndex(this.f9132w);
                if (findPointerIndex < 0 || this.f9132w == this.f9133x) {
                    int i7 = this.f9132w;
                    int i8 = this.f9133x;
                    this.f9132w = motionEvent.getPointerId(b(motionEvent, i7 != i8 ? i8 : -1, findPointerIndex));
                }
                h(motionEvent);
                this.f9112c = this.f9111b.b(this);
            } else if (action == 6) {
                int pointerCount = motionEvent.getPointerCount();
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                if (pointerCount > 2) {
                    int i9 = this.f9132w;
                    if (pointerId == i9) {
                        int b7 = b(motionEvent, this.f9133x, actionIndex);
                        if (b7 >= 0) {
                            this.f9111b.c(this);
                            this.f9132w = motionEvent.getPointerId(b7);
                            this.f9134y = true;
                            this.f9113d = MotionEvent.obtain(motionEvent);
                            h(motionEvent);
                            this.f9112c = this.f9111b.b(this);
                            this.f9113d.recycle();
                            this.f9113d = MotionEvent.obtain(motionEvent);
                            h(motionEvent);
                        }
                        z3 = true;
                        this.f9113d.recycle();
                        this.f9113d = MotionEvent.obtain(motionEvent);
                        h(motionEvent);
                    } else {
                        if (pointerId == this.f9133x) {
                            int b8 = b(motionEvent, i9, actionIndex);
                            if (b8 >= 0) {
                                this.f9111b.c(this);
                                this.f9133x = motionEvent.getPointerId(b8);
                                this.f9134y = false;
                                this.f9113d = MotionEvent.obtain(motionEvent);
                                h(motionEvent);
                                this.f9112c = this.f9111b.b(this);
                            }
                            z3 = true;
                        }
                        this.f9113d.recycle();
                        this.f9113d = MotionEvent.obtain(motionEvent);
                        h(motionEvent);
                    }
                } else {
                    z3 = true;
                }
                if (z3) {
                    h(motionEvent);
                    int i10 = this.f9132w;
                    if (pointerId == i10) {
                        i10 = this.f9133x;
                    }
                    int findPointerIndex2 = motionEvent.findPointerIndex(i10);
                    this.f9115f = motionEvent.getX(findPointerIndex2);
                    this.f9116g = motionEvent.getY(findPointerIndex2);
                    this.f9111b.c(this);
                    p();
                    this.f9132w = i10;
                    this.f9134y = true;
                }
            }
        } else if (action == 0) {
            this.f9132w = motionEvent.getPointerId(0);
            this.f9134y = true;
        } else if (action == 1) {
            p();
        } else if (action != 2) {
            if (action != 5) {
                if (action == 6 && this.f9130u) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    if (pointerCount2 > 2) {
                        int i11 = this.f9132w;
                        if (pointerId2 == i11) {
                            int b9 = b(motionEvent, this.f9133x, actionIndex2);
                            if (b9 >= 0) {
                                this.f9132w = motionEvent.getPointerId(b9);
                            }
                        } else if (pointerId2 == this.f9133x && (b6 = b(motionEvent, i11, actionIndex2)) >= 0) {
                            this.f9133x = motionEvent.getPointerId(b6);
                        }
                    } else {
                        int i12 = this.f9132w;
                        if (pointerId2 == i12) {
                            i12 = this.f9133x;
                        }
                        int findPointerIndex3 = motionEvent.findPointerIndex(i12);
                        if (findPointerIndex3 < 0) {
                            this.f9131v = true;
                            if (this.f9112c) {
                                this.f9111b.c(this);
                            }
                            return false;
                        }
                        this.f9132w = motionEvent.getPointerId(findPointerIndex3);
                        this.f9134y = true;
                        this.f9133x = -1;
                        this.f9115f = motionEvent.getX(findPointerIndex3);
                        this.f9116g = motionEvent.getY(findPointerIndex3);
                    }
                }
            } else {
                int i13 = this.f9135z;
                if (i13 != 0 && (i4 = this.A) != 0) {
                    float f4 = this.f9127r;
                    this.f9128s = i13 - f4;
                    this.f9129t = i4 - f4;
                } else {
                    DisplayMetrics displayMetrics = this.f9110a.getResources().getDisplayMetrics();
                    float f5 = this.f9127r;
                    this.f9128s = displayMetrics.widthPixels - f5;
                    this.f9129t = displayMetrics.heightPixels - f5;
                }
                MotionEvent motionEvent2 = this.f9113d;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.f9113d = MotionEvent.obtain(motionEvent);
                this.f9126q = 0L;
                int actionIndex3 = motionEvent.getActionIndex();
                int findPointerIndex4 = motionEvent.findPointerIndex(this.f9132w);
                int pointerId3 = motionEvent.getPointerId(actionIndex3);
                this.f9133x = pointerId3;
                if (findPointerIndex4 < 0 || findPointerIndex4 == actionIndex3) {
                    findPointerIndex4 = b(motionEvent, findPointerIndex4 != actionIndex3 ? pointerId3 : -1, findPointerIndex4);
                    this.f9132w = motionEvent.getPointerId(findPointerIndex4);
                }
                this.f9134y = false;
                h(motionEvent);
                float f6 = this.f9127r;
                float f7 = this.f9128s;
                float f8 = this.f9129t;
                float a4 = a(motionEvent, findPointerIndex4);
                float g4 = g(motionEvent, findPointerIndex4);
                float a5 = a(motionEvent, actionIndex3);
                float g5 = g(motionEvent, actionIndex3);
                boolean z4 = a4 < f6 || g4 < f6 || a4 > f7 || g4 > f8;
                boolean z5 = a5 < f6 || g5 < f6 || a5 > f7 || g5 > f8;
                if (z4 && z5) {
                    this.f9115f = -1.0f;
                    this.f9116g = -1.0f;
                    this.f9130u = true;
                } else if (z4) {
                    this.f9115f = motionEvent.getX(actionIndex3);
                    this.f9116g = motionEvent.getY(actionIndex3);
                    this.f9130u = true;
                } else if (z5) {
                    this.f9115f = motionEvent.getX(findPointerIndex4);
                    this.f9116g = motionEvent.getY(findPointerIndex4);
                    this.f9130u = true;
                } else {
                    this.f9130u = false;
                    this.f9112c = this.f9111b.b(this);
                }
            }
        } else if (this.f9130u) {
            float f9 = this.f9127r;
            float f10 = this.f9128s;
            float f11 = this.f9129t;
            int findPointerIndex5 = motionEvent.findPointerIndex(this.f9132w);
            int findPointerIndex6 = motionEvent.findPointerIndex(this.f9133x);
            float a6 = a(motionEvent, findPointerIndex5);
            float g6 = g(motionEvent, findPointerIndex5);
            float a7 = a(motionEvent, findPointerIndex6);
            float g7 = g(motionEvent, findPointerIndex6);
            boolean z6 = a6 < f9 || g6 < f9 || a6 > f10 || g6 > f11;
            boolean z7 = a7 < f9 || g7 < f9 || a7 > f10 || g7 > f11;
            if (z6 && (b5 = b(motionEvent, this.f9133x, findPointerIndex5)) >= 0) {
                this.f9132w = motionEvent.getPointerId(b5);
                a(motionEvent, b5);
                g(motionEvent, b5);
                findPointerIndex5 = b5;
                z6 = false;
            }
            if (z7 && (b4 = b(motionEvent, this.f9132w, findPointerIndex6)) >= 0) {
                this.f9133x = motionEvent.getPointerId(b4);
                a(motionEvent, b4);
                g(motionEvent, b4);
                findPointerIndex6 = b4;
                z7 = false;
            }
            if (z6 && z7) {
                this.f9115f = -1.0f;
                this.f9116g = -1.0f;
            } else if (z6) {
                this.f9115f = motionEvent.getX(findPointerIndex6);
                this.f9116g = motionEvent.getY(findPointerIndex6);
            } else if (z7) {
                this.f9115f = motionEvent.getX(findPointerIndex5);
                this.f9116g = motionEvent.getY(findPointerIndex5);
            } else {
                this.f9130u = false;
                this.f9112c = this.f9111b.b(this);
            }
        }
        return true;
    }

    public final float f() {
        return this.f9115f;
    }

    public final float i() {
        return this.f9116g;
    }

    public final float j() {
        return this.f9119j;
    }

    public final float k() {
        return this.f9120k;
    }

    public final float l() {
        return this.f9117h;
    }

    public final float m() {
        return this.f9118i;
    }

    public final float n() {
        if (this.f9123n == -1.0f) {
            this.f9123n = q() / r();
        }
        return this.f9123n;
    }

    public final long o() {
        return this.f9126q;
    }
}
