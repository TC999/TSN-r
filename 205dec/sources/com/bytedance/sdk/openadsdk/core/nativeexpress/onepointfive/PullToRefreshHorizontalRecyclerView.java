package com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.eq.xk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PullToRefreshHorizontalRecyclerView extends FrameLayout implements Handler.Callback {

    /* renamed from: c  reason: collision with root package name */
    private static final String f34139c = PullToRefreshHorizontalRecyclerView.class.getSimpleName();
    private static long fp = 0;

    /* renamed from: a  reason: collision with root package name */
    private boolean f34140a;
    private MotionEvent bk;
    private c ev;

    /* renamed from: f  reason: collision with root package name */
    private boolean f34141f;
    private float gd;

    /* renamed from: k  reason: collision with root package name */
    private Handler f34142k;

    /* renamed from: p  reason: collision with root package name */
    private boolean f34143p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f34144r;
    private float sr;

    /* renamed from: t  reason: collision with root package name */
    private boolean f34145t;
    private RecyclerView.gd ux;

    /* renamed from: w  reason: collision with root package name */
    private RecyclerView f34146w;
    private float xv;
    private View ys;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();
    }

    public PullToRefreshHorizontalRecyclerView(Context context) {
        this(context, null);
    }

    private void c() {
        addView(com.bytedance.sdk.openadsdk.res.ux.eu(getContext()));
        View findViewById = findViewById(2114387786);
        this.ys = findViewById;
        this.f34146w = (RecyclerView) findViewById.findViewById(2114387737);
        this.f34142k = new Handler(Looper.getMainLooper(), this);
        this.gd = xk.ux(getContext(), 64.0f);
    }

    private void sr() {
        try {
            RecyclerView recyclerView = this.f34146w;
            RecyclerView.j ux = recyclerView.ux(recyclerView.getAdapter().c() - 1);
            if (ux instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.c) {
                ((com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.c) ux).w(this.ys);
            }
        } catch (Throwable unused) {
        }
    }

    private void ux() {
        if (c(1000L)) {
            this.f34142k.removeMessages(1);
            this.f34142k.sendEmptyMessageDelayed(1, 280L);
            return;
        }
        xv();
        c cVar = this.ev;
        if (cVar != null) {
            cVar.c();
        }
    }

    private void w() {
        if (this.f34144r) {
            ux();
            this.f34144r = false;
            return;
        }
        xv();
    }

    private void xv() {
        RecyclerView recyclerView = this.f34146w;
        RecyclerView.j ux = recyclerView.ux(recyclerView.getAdapter().c() - 1);
        if (ux instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.c) {
            ((com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.c) ux).c(this.ys);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L46
            if (r0 == r1) goto L43
            r3 = 2
            if (r0 == r3) goto L11
            r1 = 3
            if (r0 == r1) goto L43
            goto L5d
        L11:
            r5.bk = r6
            float r0 = r6.getRawX()
            float r3 = r5.xv
            float r0 = r0 - r3
            int r0 = (int) r0
            float r3 = r6.getRawY()
            float r4 = r5.sr
            float r3 = r3 - r4
            int r3 = (int) r3
            int r0 = java.lang.Math.abs(r0)
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L3b
            boolean r0 = r5.f34141f
            if (r0 != 0) goto L3b
            r5.f34145t = r2
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L5d
        L3b:
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
            goto L5d
        L43:
            r5.f34145t = r2
            goto L5d
        L46:
            float r0 = r6.getRawX()
            int r0 = (int) r0
            float r0 = (float) r0
            r5.xv = r0
            float r0 = r6.getRawY()
            int r0 = (int) r0
            float r0 = (float) r0
            r5.sr = r0
            android.view.ViewParent r0 = r5.getParent()
            r0.requestDisallowInterceptTouchEvent(r1)
        L5d:
            boolean r2 = super.dispatchTouchEvent(r6)     // Catch: java.lang.IllegalArgumentException -> L61
        L61:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.PullToRefreshHorizontalRecyclerView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public c getOnPullToBottomListener() {
        return this.ev;
    }

    public RecyclerView getRecyclerView() {
        return this.f34146w;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            sr();
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        RecyclerView recyclerView = this.f34146w;
        if (recyclerView != null && recyclerView.getChildCount() != 0) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.xv = motionEvent.getRawX();
                this.sr = motionEvent.getRawY();
                if (this.f34145t) {
                    this.f34141f = true;
                    this.f34145t = false;
                    return true;
                }
            } else if (action == 2) {
                int rawX = (int) (motionEvent.getRawX() - this.xv);
                if (Math.abs(rawX) < Math.abs((int) (motionEvent.getRawY() - this.sr))) {
                    w();
                } else {
                    RecyclerView.gd layoutManager = this.f34146w.getLayoutManager();
                    this.ux = layoutManager;
                    int bk = layoutManager instanceof com.bytedance.sdk.component.widget.recycler.ux ? ((com.bytedance.sdk.component.widget.recycler.ux) layoutManager).bk() : -1;
                    try {
                        if (rawX < 0) {
                            if (bk == this.f34146w.getAdapter().c() - 1 && !this.f34140a) {
                                this.f34141f = true;
                                return true;
                            }
                            this.f34141f = false;
                        } else {
                            this.f34141f = false;
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Exception unused) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        RecyclerView recyclerView = this.f34146w;
        if (recyclerView != null && recyclerView.getChildCount() != 0) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.xv = motionEvent.getRawX();
                this.sr = motionEvent.getRawY();
            } else if (action != 1) {
                if (action == 2 && this.f34141f) {
                    int rawX = (int) (motionEvent.getRawX() - this.xv);
                    if (rawX >= 0) {
                        sr();
                    } else {
                        try {
                            RecyclerView recyclerView2 = this.f34146w;
                            RecyclerView.j ux = recyclerView2.ux(recyclerView2.getAdapter().c() - 1);
                            if (ux instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.c) {
                                ((com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.c) ux).c(rawX, this.ys);
                                if (Math.abs(rawX) > this.gd) {
                                    ((com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.c) ux).c();
                                    this.f34144r = true;
                                    if (!this.f34143p) {
                                        this.f34143p = true;
                                        ((com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.c) ux).xv();
                                    }
                                } else {
                                    this.f34143p = false;
                                    ((com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive.c) ux).w();
                                    this.f34144r = false;
                                }
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            } else if (this.f34141f) {
                w();
                this.f34141f = false;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        if (z3) {
            return;
        }
        this.f34142k.removeMessages(1);
        this.f34142k.sendEmptyMessageDelayed(1, 280L);
    }

    public void setIsLoadingMore(boolean z3) {
        this.f34140a = z3;
    }

    public void setLayoutManager(RecyclerView.gd gdVar) {
        this.f34146w.setLayoutManager(gdVar);
    }

    public void setOnPullToBottomListener(c cVar) {
        this.ev = cVar;
    }

    public PullToRefreshHorizontalRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullToRefreshHorizontalRecyclerView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.gd = 0.0f;
        this.f34140a = false;
        c();
    }

    private static boolean c(long j4) {
        boolean z3 = SystemClock.uptimeMillis() - fp <= j4;
        fp = SystemClock.uptimeMillis();
        return z3;
    }
}
