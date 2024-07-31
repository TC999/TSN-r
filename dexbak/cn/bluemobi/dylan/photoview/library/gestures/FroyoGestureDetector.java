package cn.bluemobi.dylan.photoview.library.gestures;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

@TargetApi(8)
/* renamed from: cn.bluemobi.dylan.photoview.library.gestures.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class FroyoGestureDetector extends EclairGestureDetector {

    /* renamed from: l */
    protected final ScaleGestureDetector f1960l;

    /* compiled from: FroyoGestureDetector.java */
    /* renamed from: cn.bluemobi.dylan.photoview.library.gestures.c$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class ScaleGestureDetector$OnScaleGestureListenerC1213a implements ScaleGestureDetector.OnScaleGestureListener {
        ScaleGestureDetector$OnScaleGestureListenerC1213a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            FroyoGestureDetector.this.f1950a.mo57512e(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public FroyoGestureDetector(Context context) {
        super(context);
        this.f1960l = new ScaleGestureDetector(context, new ScaleGestureDetector$OnScaleGestureListenerC1213a());
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.CupcakeGestureDetector, cn.bluemobi.dylan.photoview.library.gestures.GestureDetector
    /* renamed from: c */
    public boolean mo57514c() {
        return this.f1960l.isInProgress();
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.EclairGestureDetector, cn.bluemobi.dylan.photoview.library.gestures.CupcakeGestureDetector, cn.bluemobi.dylan.photoview.library.gestures.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f1960l.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
