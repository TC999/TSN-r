package com.bytedance.sdk.component.adexpress.dynamic.interact.c;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.interact.gd;
import com.bytedance.sdk.component.utils.a;
import java.lang.ref.SoftReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements View.OnTouchListener {
    private static int xv = 10;

    /* renamed from: c  reason: collision with root package name */
    private float f29238c;
    private gd sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private float f29242w;

    /* renamed from: f  reason: collision with root package name */
    private RectF f29239f = new RectF();

    /* renamed from: r  reason: collision with root package name */
    private long f29241r = 0;
    private final int ev = 200;
    private final int gd = 3;

    /* renamed from: p  reason: collision with root package name */
    private SoftReference<ViewGroup> f29240p = new SoftReference<>(null);

    public c(gd gdVar, int i4, final ViewGroup viewGroup) {
        this.ux = xv;
        this.sr = gdVar;
        if (i4 > 0) {
            this.ux = i4;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f29240p = new SoftReference(viewGroup);
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        gd gdVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f29239f = c(this.f29240p.get());
            this.f29238c = motionEvent.getRawX();
            this.f29242w = motionEvent.getRawY();
            this.f29241r = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.f29239f;
            if (rectF != null && !rectF.contains(this.f29238c, this.f29242w)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float abs = Math.abs(rawX - this.f29238c);
            float abs2 = Math.abs(rawY - this.f29242w);
            int i4 = this.ux;
            if (abs >= i4 && abs2 >= i4) {
                gd gdVar2 = this.sr;
                if (gdVar2 != null) {
                    gdVar2.c();
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis() - this.f29241r;
                a.w("limittouch", "d:" + currentTimeMillis + " a:" + abs + " b:" + abs2);
                if ((currentTimeMillis < 200 || (abs < 3.0f && abs2 < 3.0f)) && (gdVar = this.sr) != null) {
                    gdVar.c();
                }
            }
        }
        return true;
    }

    private RectF c(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }
}
