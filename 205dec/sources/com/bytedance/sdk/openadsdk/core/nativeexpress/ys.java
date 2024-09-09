package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ys {

    /* renamed from: c  reason: collision with root package name */
    private View f34214c;
    private float ev;
    private float gd;

    /* renamed from: k  reason: collision with root package name */
    private float f34216k;

    /* renamed from: p  reason: collision with root package name */
    private float f34217p;

    /* renamed from: w  reason: collision with root package name */
    private float f34220w;
    private float xv;
    private float sr = 0.0f;
    private float ux = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f34215f = 0.0f;

    /* renamed from: r  reason: collision with root package name */
    private float f34218r = 0.0f;

    /* renamed from: a  reason: collision with root package name */
    private boolean f34213a = false;
    private boolean bk = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f34219t = false;
    private boolean ys = false;

    public ys(View view) {
        this.f34214c = view;
    }

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.sr = motionEvent.getX();
            this.ux = motionEvent.getY();
            return false;
        } else if (action != 2) {
            return false;
        } else {
            this.f34215f = motionEvent.getX();
            this.f34218r = motionEvent.getY();
            if (Math.abs(this.f34215f - this.sr) >= 5.0f && Math.abs(this.f34218r - this.ux) >= 5.0f) {
                this.ys = true;
                return true;
            }
            this.ys = false;
            return false;
        }
    }

    public boolean w(MotionEvent motionEvent) {
        this.f34220w = ((ViewGroup) this.f34214c.getParent()).getWidth();
        this.xv = ((ViewGroup) this.f34214c.getParent()).getHeight();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.bk = false;
                this.f34219t = false;
                float x3 = motionEvent.getX();
                float y3 = motionEvent.getY();
                float f4 = x3 - this.sr;
                float f5 = y3 - this.ux;
                this.ev = this.f34214c.getLeft() + f4;
                this.gd = this.f34214c.getTop() + f5;
                this.f34217p = this.f34214c.getRight() + f4;
                this.f34216k = this.f34214c.getBottom() + f5;
                if (this.ev < 0.0f) {
                    this.f34219t = true;
                    this.ev = 0.0f;
                    this.f34217p = this.f34214c.getWidth() + 0.0f;
                }
                float f6 = this.f34217p;
                float f7 = this.f34220w;
                if (f6 > f7) {
                    this.bk = true;
                    this.f34217p = f7;
                    this.ev = f7 - this.f34214c.getWidth();
                }
                if (this.gd < 0.0f) {
                    this.gd = 0.0f;
                    this.f34216k = 0.0f + this.f34214c.getHeight();
                }
                float f8 = this.f34216k;
                float f9 = this.xv;
                if (f8 > f9) {
                    this.f34216k = f9;
                    this.gd = f9 - this.f34214c.getHeight();
                }
                this.f34214c.offsetLeftAndRight((int) f4);
                this.f34214c.offsetTopAndBottom((int) f5);
                if (this.f34219t) {
                    View view = this.f34214c;
                    view.offsetLeftAndRight(-view.getLeft());
                }
                if (this.bk) {
                    View view2 = this.f34214c;
                    view2.offsetLeftAndRight((int) (this.f34220w - view2.getRight()));
                }
            }
        } else if (!this.ys) {
            return false;
        } else {
            if (((int) motionEvent.getRawX()) > this.f34220w / 2.0f) {
                this.f34213a = false;
                this.f34214c.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(this.f34220w - this.f34214c.getWidth()).start();
                View view3 = this.f34214c;
                view3.offsetLeftAndRight((int) (this.f34220w - view3.getRight()));
            } else {
                this.f34213a = true;
                this.f34214c.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(0.0f).start();
                View view4 = this.f34214c;
                view4.offsetLeftAndRight(-view4.getLeft());
            }
            this.f34214c.invalidate();
        }
        return true;
    }
}
