package cn.bluemobi.dylan.photoview.library.gestures;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: FroyoGestureDetector.java */
@TargetApi(8)
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c extends b {

    /* renamed from: l  reason: collision with root package name */
    protected final ScaleGestureDetector f1937l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: FroyoGestureDetector.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            c.this.f1927a.e(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
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

    public c(Context context) {
        super(context);
        this.f1937l = new ScaleGestureDetector(context, new a());
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.a, cn.bluemobi.dylan.photoview.library.gestures.d
    public boolean c() {
        return this.f1937l.isInProgress();
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.b, cn.bluemobi.dylan.photoview.library.gestures.a, cn.bluemobi.dylan.photoview.library.gestures.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f1937l.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
