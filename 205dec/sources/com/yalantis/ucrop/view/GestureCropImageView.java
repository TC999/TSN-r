package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.util.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class GestureCropImageView extends CropImageView {
    private static final int S = 200;
    private ScaleGestureDetector K;

    /* renamed from: L  reason: collision with root package name */
    private h f54469L;
    private GestureDetector M;
    private float N;
    private float O;
    private boolean P;
    private boolean Q;
    private int R;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            gestureCropImageView.A(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200L);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
            GestureCropImageView.this.k(-f4, -f5);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class c extends h.b {
        private c() {
        }

        @Override // com.yalantis.ucrop.util.h.b, com.yalantis.ucrop.util.h.a
        public boolean a(h hVar) {
            GestureCropImageView.this.i(hVar.c(), GestureCropImageView.this.N, GestureCropImageView.this.O);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private d() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.j(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.N, GestureCropImageView.this.O);
            return true;
        }
    }

    public GestureCropImageView(Context context) {
        super(context);
        this.P = true;
        this.Q = true;
        this.R = 5;
    }

    private void J() {
        this.M = new GestureDetector(getContext(), new b(), null, true);
        this.K = new ScaleGestureDetector(getContext(), new d());
        this.f54469L = new h(new c());
    }

    public boolean H() {
        return this.P;
    }

    public boolean I() {
        return this.Q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yalantis.ucrop.view.TransformImageView
    public void g() {
        super.g();
        J();
    }

    public int getDoubleTapScaleSteps() {
        return this.R;
    }

    protected float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.R));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            s();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.N = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.O = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        this.M.onTouchEvent(motionEvent);
        if (this.Q) {
            this.K.onTouchEvent(motionEvent);
        }
        if (this.P) {
            this.f54469L.d(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            y();
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i4) {
        this.R = i4;
    }

    public void setRotateEnabled(boolean z3) {
        this.P = z3;
    }

    public void setScaleEnabled(boolean z3) {
        this.Q = z3;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.P = true;
        this.Q = true;
        this.R = 5;
    }
}
