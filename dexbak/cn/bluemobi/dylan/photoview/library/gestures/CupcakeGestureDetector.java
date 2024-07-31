package cn.bluemobi.dylan.photoview.library.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import p584e.LogManager;

/* renamed from: cn.bluemobi.dylan.photoview.library.gestures.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class CupcakeGestureDetector implements GestureDetector {

    /* renamed from: h */
    private static final String f1949h = "CupcakeGestureDetector";

    /* renamed from: a */
    protected OnGestureListener f1950a;

    /* renamed from: b */
    float f1951b;

    /* renamed from: c */
    float f1952c;

    /* renamed from: d */
    final float f1953d;

    /* renamed from: e */
    final float f1954e;

    /* renamed from: f */
    private VelocityTracker f1955f;

    /* renamed from: g */
    private boolean f1956g;

    public CupcakeGestureDetector(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1954e = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1953d = viewConfiguration.getScaledTouchSlop();
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.GestureDetector
    /* renamed from: a */
    public void mo57516a(OnGestureListener onGestureListener) {
        this.f1950a = onGestureListener;
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.GestureDetector
    /* renamed from: b */
    public boolean mo57515b() {
        return this.f1956g;
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.GestureDetector
    /* renamed from: c */
    public boolean mo57514c() {
        return false;
    }

    /* renamed from: d */
    float mo57518d(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    /* renamed from: e */
    float mo57517e(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int action = motionEvent.getAction();
        if (action == 0) {
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f1955f = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            } else {
                LogManager.m12836a().mo12828i(f1949h, "Velocity tracker is null");
            }
            this.f1951b = mo57518d(motionEvent);
            this.f1952c = mo57517e(motionEvent);
            this.f1956g = false;
        } else if (action == 1) {
            if (this.f1956g && this.f1955f != null) {
                this.f1951b = mo57518d(motionEvent);
                this.f1952c = mo57517e(motionEvent);
                this.f1955f.addMovement(motionEvent);
                this.f1955f.computeCurrentVelocity(1000);
                float xVelocity = this.f1955f.getXVelocity();
                float yVelocity = this.f1955f.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f1954e) {
                    this.f1950a.mo57511g(this.f1951b, this.f1952c, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f1955f;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f1955f = null;
            }
        } else if (action == 2) {
            float mo57518d = mo57518d(motionEvent);
            float mo57517e = mo57517e(motionEvent);
            float f = mo57518d - this.f1951b;
            float f2 = mo57517e - this.f1952c;
            if (!this.f1956g) {
                this.f1956g = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.f1953d);
            }
            if (this.f1956g) {
                this.f1950a.mo57513c(f, f2);
                this.f1951b = mo57518d;
                this.f1952c = mo57517e;
                VelocityTracker velocityTracker3 = this.f1955f;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3 && (velocityTracker = this.f1955f) != null) {
            velocityTracker.recycle();
            this.f1955f = null;
        }
        return true;
    }
}
