package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.n;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class EmptyView extends View implements n.c {

    /* renamed from: a  reason: collision with root package name */
    private int f31648a;
    private final Handler bk;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31649c;
    private List<View> ev;

    /* renamed from: f  reason: collision with root package name */
    private String f31650f;
    private List<View> gd;

    /* renamed from: k  reason: collision with root package name */
    private boolean f31651k;

    /* renamed from: p  reason: collision with root package name */
    private List<View> f31652p;

    /* renamed from: r  reason: collision with root package name */
    private WeakReference<Activity> f31653r;
    private View sr;

    /* renamed from: t  reason: collision with root package name */
    private final AtomicBoolean f31654t;
    private FrameLayout ux;

    /* renamed from: w  reason: collision with root package name */
    private boolean f31655w;
    private c xv;
    private int ys;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void c(View view);

        void c(boolean z3);

        void w();
    }

    public EmptyView(Context context, View view) {
        super(ls.getContext());
        this.bk = new com.bytedance.sdk.component.utils.n(Looper.getMainLooper(), this);
        this.f31654t = new AtomicBoolean(true);
        this.ys = 1000;
        if (context instanceof Activity) {
            this.f31653r = new WeakReference<>((Activity) context);
        }
        this.sr = view;
        FrameLayout frameLayout = new FrameLayout(context);
        this.ux = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        View view2 = this.sr;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(this.ux);
        }
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void sr() {
        if (!this.f31655w || this.f31649c) {
            return;
        }
        this.f31649c = true;
        this.bk.sendEmptyMessage(1);
    }

    private void ux() {
        if (this.f31649c) {
            this.bk.removeMessages(1);
            this.f31649c = false;
        }
    }

    private void w() {
        c cVar;
        if (!this.f31654t.getAndSet(false) || (cVar = this.xv) == null) {
            return;
        }
        cVar.c();
    }

    private void xv() {
        c cVar;
        if (this.f31654t.getAndSet(true) || (cVar = this.xv) == null) {
            return;
        }
        cVar.w();
    }

    public void c() {
        c(this.ev, null);
        c(this.gd, null);
        c(this.f31652p, null);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sr();
        this.f31651k = false;
        w();
        com.bytedance.sdk.openadsdk.core.playable.ux.c().c(this.ux, this.f31650f, 0L);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ux();
        this.f31651k = true;
        xv();
        com.bytedance.sdk.openadsdk.core.playable.ux.c().w(this.ux);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        w();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        xv();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        c cVar = this.xv;
        if (cVar != null) {
            cVar.c(z3);
        }
        if (z3) {
            com.bytedance.sdk.openadsdk.core.playable.ux.c().c(this.ux, this.f31650f, 500L);
        }
    }

    public void setAdType(int i4) {
        this.f31648a = i4;
    }

    public void setCallback(c cVar) {
        this.xv = cVar;
    }

    public void setNeedCheckingShow(boolean z3) {
        this.f31655w = z3;
        if (!z3 && this.f31649c) {
            ux();
        } else if (!z3 || this.f31649c) {
        } else {
            sr();
        }
    }

    public void setPreloadMainKey(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.eq.u.w(meVar))) {
            return;
        }
        this.f31650f = com.bytedance.sdk.openadsdk.core.eq.u.w(meVar);
    }

    public void setRefClickViews(List<View> list) {
        this.ev = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.gd = list;
    }

    public void setRefDirectDownloadViews(List<View> list) {
        this.f31652p = list;
    }

    public void c(List<View> list, com.bytedance.sdk.openadsdk.core.w.sr srVar) {
        if (com.bytedance.sdk.component.utils.p.w(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(srVar);
                    view.setOnTouchListener(srVar);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what == 1 && this.f31649c) {
            if (wx.c(this.sr, 20, this.f31648a)) {
                ux();
                c cVar = this.xv;
                if (cVar != null) {
                    cVar.c(this.sr);
                    return;
                }
                return;
            }
            this.bk.sendEmptyMessageDelayed(1, this.ys);
        }
    }

    public EmptyView(Context context, View view, int i4) {
        this(context, view);
        this.ys = i4;
    }
}
