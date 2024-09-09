package com.bytedance.sdk.component.adexpress.dynamic.interact.c;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.interact.gd;
import java.lang.ref.SoftReference;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r implements View.OnTouchListener {
    private static int xv = 10;

    /* renamed from: c  reason: collision with root package name */
    private float f29251c;
    private gd sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private float f29255w;

    /* renamed from: f  reason: collision with root package name */
    private RectF f29252f = new RectF();

    /* renamed from: r  reason: collision with root package name */
    private long f29254r = 0;
    private final int ev = 200;
    private final int gd = 3;

    /* renamed from: p  reason: collision with root package name */
    private SoftReference<View> f29253p = new SoftReference<>(null);

    public r(gd gdVar, int i4, final ViewGroup viewGroup) {
        this.ux = xv;
        this.sr = gdVar;
        if (i4 > 0) {
            this.ux = i4;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.c.r.1
                @Override // java.lang.Runnable
                public void run() {
                    View findViewById = viewGroup.findViewById(2097610746);
                    r.this.f29253p = new SoftReference(findViewById);
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        gd gdVar;
        gd gdVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f29252f = c(this.f29253p.get());
            this.f29251c = motionEvent.getRawX();
            this.f29255w = motionEvent.getRawY();
            this.f29254r = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.f29252f;
            if (rectF != null && !rectF.contains(this.f29251c, this.f29255w)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float abs = Math.abs(rawX - this.f29251c);
            float abs2 = Math.abs(rawY - this.f29255w);
            int w3 = com.bytedance.sdk.component.adexpress.sr.f.w(com.bytedance.sdk.component.adexpress.sr.getContext(), Math.abs(rawX - this.f29251c));
            int i4 = xv;
            if (abs >= i4 && abs2 >= i4) {
                if (rawX > this.f29251c && w3 > this.ux && (gdVar2 = this.sr) != null) {
                    gdVar2.c();
                }
            } else if ((System.currentTimeMillis() - this.f29254r < 200 || (abs < 3.0f && abs2 < 3.0f)) && (gdVar = this.sr) != null) {
                gdVar.c();
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
