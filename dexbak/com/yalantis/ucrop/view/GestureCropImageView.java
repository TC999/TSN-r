package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.util.RotationGestureDetector;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class GestureCropImageView extends CropImageView {

    /* renamed from: S */
    private static final int f39943S = 200;

    /* renamed from: K */
    private ScaleGestureDetector f39944K;

    /* renamed from: L */
    private RotationGestureDetector f39945L;

    /* renamed from: M */
    private GestureDetector f39946M;

    /* renamed from: N */
    private float f39947N;

    /* renamed from: O */
    private float f39948O;

    /* renamed from: P */
    private boolean f39949P;

    /* renamed from: Q */
    private boolean f39950Q;

    /* renamed from: R */
    private int f39951R;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.yalantis.ucrop.view.GestureCropImageView$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13535b extends GestureDetector.SimpleOnGestureListener {
        private C13535b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            gestureCropImageView.m12974A(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200L);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            GestureCropImageView.this.m12930k(-f, -f2);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.yalantis.ucrop.view.GestureCropImageView$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13536c extends RotationGestureDetector.C13531b {
        private C13536c() {
        }

        @Override // com.yalantis.ucrop.util.RotationGestureDetector.C13531b, com.yalantis.ucrop.util.RotationGestureDetector.InterfaceC13530a
        /* renamed from: a */
        public boolean mo12952a(RotationGestureDetector rotationGestureDetector) {
            GestureCropImageView.this.m12932i(rotationGestureDetector.m12976c(), GestureCropImageView.this.f39947N, GestureCropImageView.this.f39948O);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.yalantis.ucrop.view.GestureCropImageView$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C13537d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private C13537d() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.mo12931j(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.f39947N, GestureCropImageView.this.f39948O);
            return true;
        }
    }

    public GestureCropImageView(Context context) {
        super(context);
        this.f39949P = true;
        this.f39950Q = true;
        this.f39951R = 5;
    }

    /* renamed from: J */
    private void m12953J() {
        this.f39946M = new GestureDetector(getContext(), new C13535b(), null, true);
        this.f39944K = new ScaleGestureDetector(getContext(), new C13537d());
        this.f39945L = new RotationGestureDetector(new C13536c());
    }

    /* renamed from: H */
    public boolean m12955H() {
        return this.f39949P;
    }

    /* renamed from: I */
    public boolean m12954I() {
        return this.f39950Q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yalantis.ucrop.view.TransformImageView
    /* renamed from: g */
    public void mo12934g() {
        super.mo12934g();
        m12953J();
    }

    public int getDoubleTapScaleSteps() {
        return this.f39951R;
    }

    protected float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.f39951R));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            m12965s();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.f39947N = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.f39948O = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        this.f39946M.onTouchEvent(motionEvent);
        if (this.f39950Q) {
            this.f39944K.onTouchEvent(motionEvent);
        }
        if (this.f39949P) {
            this.f39945L.m12975d(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            m12959y();
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.f39951R = i;
    }

    public void setRotateEnabled(boolean z) {
        this.f39949P = z;
    }

    public void setScaleEnabled(boolean z) {
        this.f39950Q = z;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f39949P = true;
        this.f39950Q = true;
        this.f39951R = 5;
    }
}
