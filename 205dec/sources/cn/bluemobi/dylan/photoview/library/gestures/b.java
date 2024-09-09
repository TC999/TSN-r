package cn.bluemobi.dylan.photoview.library.gestures;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: EclairGestureDetector.java */
@TargetApi(5)
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends a {

    /* renamed from: k  reason: collision with root package name */
    private static final int f1934k = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f1935i;

    /* renamed from: j  reason: collision with root package name */
    private int f1936j;

    public b(Context context) {
        super(context);
        this.f1935i = -1;
        this.f1936j = 0;
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.a
    float d(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f1936j);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.a
    float e(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f1936j);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.a, cn.bluemobi.dylan.photoview.library.gestures.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.f1935i = -1;
            } else if (action == 6) {
                int a4 = cn.bluemobi.dylan.photoview.library.a.a(motionEvent.getAction());
                if (motionEvent.getPointerId(a4) == this.f1935i) {
                    int i4 = a4 != 0 ? 0 : 1;
                    this.f1935i = motionEvent.getPointerId(i4);
                    this.f1928b = motionEvent.getX(i4);
                    this.f1929c = motionEvent.getY(i4);
                }
            }
        } else {
            this.f1935i = motionEvent.getPointerId(0);
        }
        int i5 = this.f1935i;
        this.f1936j = motionEvent.findPointerIndex(i5 != -1 ? i5 : 0);
        return super.onTouchEvent(motionEvent);
    }
}
