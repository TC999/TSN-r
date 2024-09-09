package com.qq.e.comm.plugin.nativeadunified;

import android.view.MotionEvent;
import android.view.View;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.util.d1;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class l implements View.OnTouchListener {

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f44976c;

    /* renamed from: d  reason: collision with root package name */
    private final int f44977d;

    /* renamed from: e  reason: collision with root package name */
    private int f44978e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f44979f;

    /* renamed from: g  reason: collision with root package name */
    private int f44980g;

    /* renamed from: h  reason: collision with root package name */
    private float f44981h;

    /* renamed from: i  reason: collision with root package name */
    private float f44982i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f44983j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f44984k;

    public l(com.qq.e.comm.plugin.g0.e eVar, int i4) {
        this.f44979f = new int[0];
        this.f44976c = eVar;
        this.f44977d = com.qq.e.dl.j.f.a(i4);
        y i02 = this.f44976c.i0();
        if (i02 == null) {
            return;
        }
        this.f44978e = i02.o();
        JSONArray b4 = i02.b();
        int length = b4 == null ? 0 : (b4.length() + 1) / 2;
        this.f44980g = length;
        if (length <= 0) {
            return;
        }
        this.f44979f = new int[length * 2];
        int i5 = 0;
        while (true) {
            int i6 = this.f44980g;
            if (i5 >= i6) {
                return;
            }
            int i7 = i5 * 2;
            this.f44979f[i7] = i6 > 0 ? b4.optInt(i7, 0) : 0;
            int[] iArr = this.f44979f;
            int i8 = i7 + 1;
            int i9 = 360;
            if (this.f44980g > 0) {
                i9 = b4.optInt(i8, 360);
            }
            iArr[i8] = i9;
            i5++;
        }
    }

    private boolean a(float f4, float f5) {
        double atan2;
        float f6 = f4 - this.f44981h;
        float f7 = f5 - this.f44982i;
        if (f6 == 0.0f && f7 == 0.0f) {
            atan2 = Double.NaN;
        } else {
            atan2 = (Math.atan2(f7, f6) / 3.141592653589793d) * 180.0d;
            if (atan2 < 0.0d) {
                atan2 += 360.0d;
            }
        }
        for (int i4 = 0; i4 < this.f44980g; i4++) {
            int i5 = i4 * 2;
            if (Double.isNaN(atan2)) {
                return true;
            }
            int[] iArr = this.f44979f;
            int i6 = iArr[i5];
            int i7 = iArr[i5 + 1];
            if ((i6 >= i7 || (atan2 >= i6 && atan2 <= i7)) && (i6 < i7 || atan2 >= i6 || atan2 <= i7)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f44984k) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f44983j = false;
            this.f44981h = motionEvent.getX();
            this.f44982i = motionEvent.getY();
            if (this.f44978e > 0) {
                com.qq.e.dl.l.j.f.a(view, true);
            }
        } else if (action != 1) {
            if (action == 2 && this.f44978e == 2 && !this.f44983j) {
                float y3 = motionEvent.getY() - this.f44982i;
                float x3 = motionEvent.getX() - this.f44981h;
                double hypot = Math.hypot(y3, x3);
                d1.a("moving process detect delta x = %.2f, delta y = %.2f, hypot = %.2f, slop = %d", Float.valueOf(x3), Float.valueOf(y3), Double.valueOf(hypot), Integer.valueOf(this.f44977d));
                if (hypot > this.f44977d) {
                    if (!a(motionEvent.getX(), motionEvent.getY())) {
                        com.qq.e.dl.l.j.f.a(view, false);
                    }
                    this.f44983j = true;
                }
            }
        } else {
            if (this.f44978e == 2) {
                if (a(motionEvent.getX(), motionEvent.getY())) {
                    view.performClick();
                }
            } else {
                view.performClick();
            }
            return true;
        }
        return false;
    }

    public void a() {
        this.f44984k = true;
    }
}
