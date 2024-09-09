package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.bytedance.sdk.component.widget.SSWebView;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class SSWebViewVideoPage extends SSWebView {

    /* renamed from: c  reason: collision with root package name */
    private boolean f36365c;
    private ViewParent sr;

    /* renamed from: w  reason: collision with root package name */
    private float f36366w;
    private boolean xv;

    public SSWebViewVideoPage(Context context) {
        super(context);
        this.f36365c = true;
        this.f36366w = -1.0f;
        this.xv = false;
        ys();
    }

    private void ys() {
    }

    public void bk() {
        if (this.xv) {
            return;
        }
        this.sr.requestDisallowInterceptTouchEvent(true);
        this.xv = true;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i4, int i5, boolean z3, boolean z4) {
        super.onOverScrolled(i4, i5, z3, z4);
        if (i5 == 0 && z4) {
            this.f36365c = true;
        } else {
            this.f36365c = false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.sr == null) {
            this.sr = c(this);
        }
        if (motionEvent.getAction() == 0) {
            this.f36366w = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            float y3 = motionEvent.getY() - this.f36366w;
            if (y3 > 0.0f) {
                w(true);
            } else if (y3 != 0.0f && y3 < 0.0f) {
                w(false);
            }
            this.f36366w = motionEvent.getY();
        } else if (motionEvent.getAction() == 1) {
            bk();
            this.xv = false;
        } else if (motionEvent.getAction() == 3) {
            bk();
            this.xv = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void t() {
        if (this.xv) {
            return;
        }
        this.sr.requestDisallowInterceptTouchEvent(false);
        this.xv = true;
    }

    public void w(boolean z3) {
        if (((ScrollView) this.sr).getScrollY() == 0) {
            if (z3) {
                bk();
            } else {
                t();
            }
        } else if (!this.f36365c) {
            bk();
        } else if (z3) {
            t();
        } else {
            bk();
        }
    }
}
