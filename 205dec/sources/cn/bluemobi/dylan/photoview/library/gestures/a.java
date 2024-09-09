package cn.bluemobi.dylan.photoview.library.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CupcakeGestureDetector.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a implements d {

    /* renamed from: h  reason: collision with root package name */
    private static final String f1926h = "CupcakeGestureDetector";

    /* renamed from: a  reason: collision with root package name */
    protected e f1927a;

    /* renamed from: b  reason: collision with root package name */
    float f1928b;

    /* renamed from: c  reason: collision with root package name */
    float f1929c;

    /* renamed from: d  reason: collision with root package name */
    final float f1930d;

    /* renamed from: e  reason: collision with root package name */
    final float f1931e;

    /* renamed from: f  reason: collision with root package name */
    private VelocityTracker f1932f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1933g;

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1931e = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1930d = viewConfiguration.getScaledTouchSlop();
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.d
    public void a(e eVar) {
        this.f1927a = eVar;
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.d
    public boolean b() {
        return this.f1933g;
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.d
    public boolean c() {
        return false;
    }

    float d(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    float e(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int action = motionEvent.getAction();
        if (action == 0) {
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f1932f = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            } else {
                c.a.a().i("CupcakeGestureDetector", "Velocity tracker is null");
            }
            this.f1928b = d(motionEvent);
            this.f1929c = e(motionEvent);
            this.f1933g = false;
        } else if (action == 1) {
            if (this.f1933g && this.f1932f != null) {
                this.f1928b = d(motionEvent);
                this.f1929c = e(motionEvent);
                this.f1932f.addMovement(motionEvent);
                this.f1932f.computeCurrentVelocity(1000);
                float xVelocity = this.f1932f.getXVelocity();
                float yVelocity = this.f1932f.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f1931e) {
                    this.f1927a.g(this.f1928b, this.f1929c, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f1932f;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f1932f = null;
            }
        } else if (action == 2) {
            float d4 = d(motionEvent);
            float e4 = e(motionEvent);
            float f4 = d4 - this.f1928b;
            float f5 = e4 - this.f1929c;
            if (!this.f1933g) {
                this.f1933g = Math.sqrt((double) ((f4 * f4) + (f5 * f5))) >= ((double) this.f1930d);
            }
            if (this.f1933g) {
                this.f1927a.c(f4, f5);
                this.f1928b = d4;
                this.f1929c = e4;
                VelocityTracker velocityTracker3 = this.f1932f;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3 && (velocityTracker = this.f1932f) != null) {
            velocityTracker.recycle();
            this.f1932f = null;
        }
        return true;
    }
}
