package cn.bluemobi.dylan.photoview.library.gestures;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import cn.bluemobi.dylan.photoview.library.Compat;

@TargetApi(5)
/* renamed from: cn.bluemobi.dylan.photoview.library.gestures.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class EclairGestureDetector extends CupcakeGestureDetector {

    /* renamed from: k */
    private static final int f1957k = -1;

    /* renamed from: i */
    private int f1958i;

    /* renamed from: j */
    private int f1959j;

    public EclairGestureDetector(Context context) {
        super(context);
        this.f1958i = -1;
        this.f1959j = 0;
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.CupcakeGestureDetector
    /* renamed from: d */
    float mo57518d(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f1959j);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.CupcakeGestureDetector
    /* renamed from: e */
    float mo57517e(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f1959j);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.CupcakeGestureDetector, cn.bluemobi.dylan.photoview.library.gestures.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.f1958i = -1;
            } else if (action == 6) {
                int m57558a = Compat.m57558a(motionEvent.getAction());
                if (motionEvent.getPointerId(m57558a) == this.f1958i) {
                    int i = m57558a != 0 ? 0 : 1;
                    this.f1958i = motionEvent.getPointerId(i);
                    this.f1951b = motionEvent.getX(i);
                    this.f1952c = motionEvent.getY(i);
                }
            }
        } else {
            this.f1958i = motionEvent.getPointerId(0);
        }
        int i2 = this.f1958i;
        this.f1959j = motionEvent.findPointerIndex(i2 != -1 ? i2 : 0);
        return super.onTouchEvent(motionEvent);
    }
}
