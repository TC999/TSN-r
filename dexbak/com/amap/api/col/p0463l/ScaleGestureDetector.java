package com.amap.api.col.p0463l;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* renamed from: com.amap.api.col.3l.u */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ScaleGestureDetector {

    /* renamed from: a */
    private final Context f5405a;

    /* renamed from: b */
    private final InterfaceC1953a f5406b;

    /* renamed from: c */
    private boolean f5407c;

    /* renamed from: d */
    private MotionEvent f5408d;

    /* renamed from: e */
    private MotionEvent f5409e;

    /* renamed from: f */
    private float f5410f;

    /* renamed from: g */
    private float f5411g;

    /* renamed from: h */
    private float f5412h;

    /* renamed from: i */
    private float f5413i;

    /* renamed from: j */
    private float f5414j;

    /* renamed from: k */
    private float f5415k;

    /* renamed from: l */
    private float f5416l;

    /* renamed from: m */
    private float f5417m;

    /* renamed from: n */
    private float f5418n;

    /* renamed from: o */
    private float f5419o;

    /* renamed from: p */
    private float f5420p;

    /* renamed from: q */
    private long f5421q;

    /* renamed from: r */
    private final float f5422r;

    /* renamed from: s */
    private float f5423s;

    /* renamed from: t */
    private float f5424t;

    /* renamed from: u */
    private boolean f5425u;

    /* renamed from: v */
    private boolean f5426v;

    /* renamed from: w */
    private int f5427w;

    /* renamed from: x */
    private int f5428x;

    /* renamed from: y */
    private boolean f5429y;

    /* renamed from: z */
    private int f5430z = 0;

    /* renamed from: A */
    private int f5404A = 0;

    /* compiled from: ScaleGestureDetector.java */
    /* renamed from: com.amap.api.col.3l.u$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC1953a {
        /* renamed from: a */
        boolean mo53678a(ScaleGestureDetector scaleGestureDetector);

        /* renamed from: b */
        boolean mo53677b(ScaleGestureDetector scaleGestureDetector);

        /* renamed from: c */
        void mo53676c(ScaleGestureDetector scaleGestureDetector);
    }

    public ScaleGestureDetector(Context context, InterfaceC1953a interfaceC1953a) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f5405a = context;
        this.f5406b = interfaceC1953a;
        this.f5422r = viewConfiguration.getScaledEdgeSlop();
    }

    /* renamed from: a */
    private static float m53830a(MotionEvent motionEvent, int i) {
        if (i < 0) {
            return Float.MIN_VALUE;
        }
        if (i == 0) {
            return motionEvent.getRawX();
        }
        return motionEvent.getX(i) + (motionEvent.getRawX() - motionEvent.getX());
    }

    /* renamed from: b */
    private int m53829b(MotionEvent motionEvent, int i, int i2) {
        int pointerCount = motionEvent.getPointerCount();
        int findPointerIndex = motionEvent.findPointerIndex(i);
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (i3 != i2 && i3 != findPointerIndex) {
                float f = this.f5422r;
                float f2 = this.f5423s;
                float f3 = this.f5424t;
                float m53830a = m53830a(motionEvent, i3);
                float m53824g = m53824g(motionEvent, i3);
                if (m53830a >= f && m53824g >= f && m53830a <= f2 && m53824g <= f3) {
                    return i3;
                }
            }
        }
        return -1;
    }

    /* renamed from: g */
    private static float m53824g(MotionEvent motionEvent, int i) {
        if (i < 0) {
            return Float.MIN_VALUE;
        }
        if (i == 0) {
            return motionEvent.getRawY();
        }
        return motionEvent.getY(i) + (motionEvent.getRawY() - motionEvent.getY());
    }

    /* renamed from: h */
    private void m53823h(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f5409e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.f5409e = MotionEvent.obtain(motionEvent);
        this.f5416l = -1.0f;
        this.f5417m = -1.0f;
        this.f5418n = -1.0f;
        MotionEvent motionEvent3 = this.f5408d;
        int findPointerIndex = motionEvent3.findPointerIndex(this.f5427w);
        int findPointerIndex2 = motionEvent3.findPointerIndex(this.f5428x);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.f5427w);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.f5428x);
        if (findPointerIndex >= 0 && findPointerIndex2 >= 0 && findPointerIndex3 >= 0 && findPointerIndex4 >= 0) {
            float x = motionEvent3.getX(findPointerIndex);
            float y = motionEvent3.getY(findPointerIndex);
            float x2 = motionEvent3.getX(findPointerIndex2);
            float y2 = motionEvent3.getY(findPointerIndex2);
            float x3 = motionEvent.getX(findPointerIndex3);
            float y3 = motionEvent.getY(findPointerIndex3);
            float x4 = motionEvent.getX(findPointerIndex4) - x3;
            float y4 = motionEvent.getY(findPointerIndex4) - y3;
            this.f5412h = x2 - x;
            this.f5413i = y2 - y;
            this.f5414j = x4;
            this.f5415k = y4;
            this.f5410f = x3 + (x4 * 0.5f);
            this.f5411g = y3 + (y4 * 0.5f);
            this.f5421q = motionEvent.getEventTime() - motionEvent3.getEventTime();
            this.f5419o = motionEvent.getPressure(findPointerIndex3) + motionEvent.getPressure(findPointerIndex4);
            this.f5420p = motionEvent3.getPressure(findPointerIndex) + motionEvent3.getPressure(findPointerIndex2);
            return;
        }
        this.f5426v = true;
        if (this.f5407c) {
            this.f5406b.mo53676c(this);
        }
    }

    /* renamed from: p */
    private void m53815p() {
        MotionEvent motionEvent = this.f5408d;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f5408d = null;
        }
        MotionEvent motionEvent2 = this.f5409e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f5409e = null;
        }
        this.f5425u = false;
        this.f5407c = false;
        this.f5427w = -1;
        this.f5428x = -1;
        this.f5426v = false;
    }

    /* renamed from: q */
    private float m53814q() {
        if (this.f5416l == -1.0f) {
            float f = this.f5414j;
            float f2 = this.f5415k;
            this.f5416l = (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return this.f5416l;
    }

    /* renamed from: r */
    private float m53813r() {
        if (this.f5417m == -1.0f) {
            float f = this.f5412h;
            float f2 = this.f5413i;
            this.f5417m = (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return this.f5417m;
    }

    /* renamed from: c */
    public final MotionEvent m53828c() {
        return this.f5409e;
    }

    /* renamed from: d */
    public final void m53827d(int i, int i2) {
        this.f5430z = i;
        this.f5404A = i2;
    }

    /* renamed from: e */
    public final boolean m53826e(MotionEvent motionEvent) {
        int m53829b;
        int m53829b2;
        int i;
        int m53829b3;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            m53815p();
        }
        boolean z = false;
        if (this.f5426v) {
            return false;
        }
        if (this.f5407c) {
            if (action == 1) {
                m53815p();
            } else if (action == 2) {
                m53823h(motionEvent);
                if (this.f5419o / this.f5420p > 0.67f && this.f5406b.mo53678a(this)) {
                    this.f5408d.recycle();
                    this.f5408d = MotionEvent.obtain(motionEvent);
                }
            } else if (action == 3) {
                this.f5406b.mo53676c(this);
                m53815p();
            } else if (action == 5) {
                this.f5406b.mo53676c(this);
                int i2 = this.f5427w;
                int i3 = this.f5428x;
                m53815p();
                this.f5408d = MotionEvent.obtain(motionEvent);
                if (!this.f5429y) {
                    i2 = i3;
                }
                this.f5427w = i2;
                this.f5428x = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.f5429y = false;
                int findPointerIndex = motionEvent.findPointerIndex(this.f5427w);
                if (findPointerIndex < 0 || this.f5427w == this.f5428x) {
                    int i4 = this.f5427w;
                    int i5 = this.f5428x;
                    this.f5427w = motionEvent.getPointerId(m53829b(motionEvent, i4 != i5 ? i5 : -1, findPointerIndex));
                }
                m53823h(motionEvent);
                this.f5407c = this.f5406b.mo53677b(this);
            } else if (action == 6) {
                int pointerCount = motionEvent.getPointerCount();
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                if (pointerCount > 2) {
                    int i6 = this.f5427w;
                    if (pointerId == i6) {
                        int m53829b4 = m53829b(motionEvent, this.f5428x, actionIndex);
                        if (m53829b4 >= 0) {
                            this.f5406b.mo53676c(this);
                            this.f5427w = motionEvent.getPointerId(m53829b4);
                            this.f5429y = true;
                            this.f5408d = MotionEvent.obtain(motionEvent);
                            m53823h(motionEvent);
                            this.f5407c = this.f5406b.mo53677b(this);
                            this.f5408d.recycle();
                            this.f5408d = MotionEvent.obtain(motionEvent);
                            m53823h(motionEvent);
                        }
                        z = true;
                        this.f5408d.recycle();
                        this.f5408d = MotionEvent.obtain(motionEvent);
                        m53823h(motionEvent);
                    } else {
                        if (pointerId == this.f5428x) {
                            int m53829b5 = m53829b(motionEvent, i6, actionIndex);
                            if (m53829b5 >= 0) {
                                this.f5406b.mo53676c(this);
                                this.f5428x = motionEvent.getPointerId(m53829b5);
                                this.f5429y = false;
                                this.f5408d = MotionEvent.obtain(motionEvent);
                                m53823h(motionEvent);
                                this.f5407c = this.f5406b.mo53677b(this);
                            }
                            z = true;
                        }
                        this.f5408d.recycle();
                        this.f5408d = MotionEvent.obtain(motionEvent);
                        m53823h(motionEvent);
                    }
                } else {
                    z = true;
                }
                if (z) {
                    m53823h(motionEvent);
                    int i7 = this.f5427w;
                    if (pointerId == i7) {
                        i7 = this.f5428x;
                    }
                    int findPointerIndex2 = motionEvent.findPointerIndex(i7);
                    this.f5410f = motionEvent.getX(findPointerIndex2);
                    this.f5411g = motionEvent.getY(findPointerIndex2);
                    this.f5406b.mo53676c(this);
                    m53815p();
                    this.f5427w = i7;
                    this.f5429y = true;
                }
            }
        } else if (action == 0) {
            this.f5427w = motionEvent.getPointerId(0);
            this.f5429y = true;
        } else if (action == 1) {
            m53815p();
        } else if (action != 2) {
            if (action != 5) {
                if (action == 6 && this.f5425u) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    if (pointerCount2 > 2) {
                        int i8 = this.f5427w;
                        if (pointerId2 == i8) {
                            int m53829b6 = m53829b(motionEvent, this.f5428x, actionIndex2);
                            if (m53829b6 >= 0) {
                                this.f5427w = motionEvent.getPointerId(m53829b6);
                            }
                        } else if (pointerId2 == this.f5428x && (m53829b3 = m53829b(motionEvent, i8, actionIndex2)) >= 0) {
                            this.f5428x = motionEvent.getPointerId(m53829b3);
                        }
                    } else {
                        int i9 = this.f5427w;
                        if (pointerId2 == i9) {
                            i9 = this.f5428x;
                        }
                        int findPointerIndex3 = motionEvent.findPointerIndex(i9);
                        if (findPointerIndex3 < 0) {
                            this.f5426v = true;
                            if (this.f5407c) {
                                this.f5406b.mo53676c(this);
                            }
                            return false;
                        }
                        this.f5427w = motionEvent.getPointerId(findPointerIndex3);
                        this.f5429y = true;
                        this.f5428x = -1;
                        this.f5410f = motionEvent.getX(findPointerIndex3);
                        this.f5411g = motionEvent.getY(findPointerIndex3);
                    }
                }
            } else {
                int i10 = this.f5430z;
                if (i10 != 0 && (i = this.f5404A) != 0) {
                    float f = this.f5422r;
                    this.f5423s = i10 - f;
                    this.f5424t = i - f;
                } else {
                    DisplayMetrics displayMetrics = this.f5405a.getResources().getDisplayMetrics();
                    float f2 = this.f5422r;
                    this.f5423s = displayMetrics.widthPixels - f2;
                    this.f5424t = displayMetrics.heightPixels - f2;
                }
                MotionEvent motionEvent2 = this.f5408d;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.f5408d = MotionEvent.obtain(motionEvent);
                this.f5421q = 0L;
                int actionIndex3 = motionEvent.getActionIndex();
                int findPointerIndex4 = motionEvent.findPointerIndex(this.f5427w);
                int pointerId3 = motionEvent.getPointerId(actionIndex3);
                this.f5428x = pointerId3;
                if (findPointerIndex4 < 0 || findPointerIndex4 == actionIndex3) {
                    findPointerIndex4 = m53829b(motionEvent, findPointerIndex4 != actionIndex3 ? pointerId3 : -1, findPointerIndex4);
                    this.f5427w = motionEvent.getPointerId(findPointerIndex4);
                }
                this.f5429y = false;
                m53823h(motionEvent);
                float f3 = this.f5422r;
                float f4 = this.f5423s;
                float f5 = this.f5424t;
                float m53830a = m53830a(motionEvent, findPointerIndex4);
                float m53824g = m53824g(motionEvent, findPointerIndex4);
                float m53830a2 = m53830a(motionEvent, actionIndex3);
                float m53824g2 = m53824g(motionEvent, actionIndex3);
                boolean z2 = m53830a < f3 || m53824g < f3 || m53830a > f4 || m53824g > f5;
                boolean z3 = m53830a2 < f3 || m53824g2 < f3 || m53830a2 > f4 || m53824g2 > f5;
                if (z2 && z3) {
                    this.f5410f = -1.0f;
                    this.f5411g = -1.0f;
                    this.f5425u = true;
                } else if (z2) {
                    this.f5410f = motionEvent.getX(actionIndex3);
                    this.f5411g = motionEvent.getY(actionIndex3);
                    this.f5425u = true;
                } else if (z3) {
                    this.f5410f = motionEvent.getX(findPointerIndex4);
                    this.f5411g = motionEvent.getY(findPointerIndex4);
                    this.f5425u = true;
                } else {
                    this.f5425u = false;
                    this.f5407c = this.f5406b.mo53677b(this);
                }
            }
        } else if (this.f5425u) {
            float f6 = this.f5422r;
            float f7 = this.f5423s;
            float f8 = this.f5424t;
            int findPointerIndex5 = motionEvent.findPointerIndex(this.f5427w);
            int findPointerIndex6 = motionEvent.findPointerIndex(this.f5428x);
            float m53830a3 = m53830a(motionEvent, findPointerIndex5);
            float m53824g3 = m53824g(motionEvent, findPointerIndex5);
            float m53830a4 = m53830a(motionEvent, findPointerIndex6);
            float m53824g4 = m53824g(motionEvent, findPointerIndex6);
            boolean z4 = m53830a3 < f6 || m53824g3 < f6 || m53830a3 > f7 || m53824g3 > f8;
            boolean z5 = m53830a4 < f6 || m53824g4 < f6 || m53830a4 > f7 || m53824g4 > f8;
            if (z4 && (m53829b2 = m53829b(motionEvent, this.f5428x, findPointerIndex5)) >= 0) {
                this.f5427w = motionEvent.getPointerId(m53829b2);
                m53830a(motionEvent, m53829b2);
                m53824g(motionEvent, m53829b2);
                findPointerIndex5 = m53829b2;
                z4 = false;
            }
            if (z5 && (m53829b = m53829b(motionEvent, this.f5427w, findPointerIndex6)) >= 0) {
                this.f5428x = motionEvent.getPointerId(m53829b);
                m53830a(motionEvent, m53829b);
                m53824g(motionEvent, m53829b);
                findPointerIndex6 = m53829b;
                z5 = false;
            }
            if (z4 && z5) {
                this.f5410f = -1.0f;
                this.f5411g = -1.0f;
            } else if (z4) {
                this.f5410f = motionEvent.getX(findPointerIndex6);
                this.f5411g = motionEvent.getY(findPointerIndex6);
            } else if (z5) {
                this.f5410f = motionEvent.getX(findPointerIndex5);
                this.f5411g = motionEvent.getY(findPointerIndex5);
            } else {
                this.f5425u = false;
                this.f5407c = this.f5406b.mo53677b(this);
            }
        }
        return true;
    }

    /* renamed from: f */
    public final float m53825f() {
        return this.f5410f;
    }

    /* renamed from: i */
    public final float m53822i() {
        return this.f5411g;
    }

    /* renamed from: j */
    public final float m53821j() {
        return this.f5414j;
    }

    /* renamed from: k */
    public final float m53820k() {
        return this.f5415k;
    }

    /* renamed from: l */
    public final float m53819l() {
        return this.f5412h;
    }

    /* renamed from: m */
    public final float m53818m() {
        return this.f5413i;
    }

    /* renamed from: n */
    public final float m53817n() {
        if (this.f5418n == -1.0f) {
            this.f5418n = m53814q() / m53813r();
        }
        return this.f5418n;
    }

    /* renamed from: o */
    public final long m53816o() {
        return this.f5421q;
    }
}
