package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* renamed from: com.amap.api.col.3l.q */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractTwoFingerGestureDetector extends BaseGestureDetector {

    /* renamed from: j */
    private final float f5085j;

    /* renamed from: k */
    private float f5086k;

    /* renamed from: l */
    private float f5087l;

    /* renamed from: m */
    protected float f5088m;

    /* renamed from: n */
    protected float f5089n;

    /* renamed from: o */
    protected float f5090o;

    /* renamed from: p */
    protected float f5091p;

    /* renamed from: q */
    private float f5092q;

    /* renamed from: r */
    private float f5093r;

    /* renamed from: s */
    private float f5094s;

    /* renamed from: t */
    private float f5095t;

    /* renamed from: u */
    private float f5096u;

    /* renamed from: v */
    private float f5097v;

    public AbstractTwoFingerGestureDetector(Context context) {
        super(context);
        this.f5094s = 0.0f;
        this.f5095t = 0.0f;
        this.f5096u = 0.0f;
        this.f5097v = 0.0f;
        this.f5085j = ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    /* renamed from: j */
    private static float m54159j(MotionEvent motionEvent, int i) {
        float x = (i + motionEvent.getX()) - motionEvent.getRawX();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getX(1) + x;
        }
        return 0.0f;
    }

    /* renamed from: m */
    private static float m54156m(MotionEvent motionEvent, int i) {
        float y = (i + motionEvent.getY()) - motionEvent.getRawY();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getY(1) + y;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0463l.BaseGestureDetector
    /* renamed from: e */
    public void mo53627e(MotionEvent motionEvent) {
        super.mo53627e(motionEvent);
        MotionEvent motionEvent2 = this.f5139c;
        int pointerCount = motionEvent2.getPointerCount();
        int pointerCount2 = motionEvent.getPointerCount();
        if (pointerCount2 == 2 && pointerCount2 == pointerCount) {
            this.f5092q = -1.0f;
            this.f5093r = -1.0f;
            float x = motionEvent2.getX(0);
            float y = motionEvent2.getY(0);
            float x2 = motionEvent2.getX(1);
            float y2 = motionEvent2.getY(1);
            this.f5088m = x2 - x;
            this.f5089n = y2 - y;
            float x3 = motionEvent.getX(0);
            float y3 = motionEvent.getY(0);
            float x4 = motionEvent.getX(1);
            float y4 = motionEvent.getY(1);
            this.f5090o = x4 - x3;
            this.f5091p = y4 - y3;
            this.f5094s = x3 - x;
            this.f5095t = y3 - y;
            this.f5096u = x4 - x2;
            this.f5097v = y4 - y2;
        }
    }

    /* renamed from: k */
    public final PointF m54158k(int i) {
        if (i == 0) {
            return new PointF(this.f5094s, this.f5095t);
        }
        return new PointF(this.f5096u, this.f5097v);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public final boolean m54157l(MotionEvent motionEvent, int i, int i2) {
        int i3;
        int i4 = this.f5144h;
        if (i4 != 0 && (i3 = this.f5145i) != 0) {
            float f = this.f5085j;
            this.f5086k = i4 - f;
            this.f5087l = i3 - f;
        } else {
            DisplayMetrics displayMetrics = this.f5137a.getResources().getDisplayMetrics();
            float f2 = this.f5085j;
            this.f5086k = displayMetrics.widthPixels - f2;
            this.f5087l = displayMetrics.heightPixels - f2;
        }
        float f3 = this.f5085j;
        float f4 = this.f5086k;
        float f5 = this.f5087l;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float m54159j = m54159j(motionEvent, i);
        float m54156m = m54156m(motionEvent, i2);
        boolean z = rawX < f3 || rawY < f3 || rawX > f4 || rawY > f5;
        boolean z2 = m54159j < f3 || m54156m < f3 || m54159j > f4 || m54156m > f5;
        return (z && z2) || z || z2;
    }
}
