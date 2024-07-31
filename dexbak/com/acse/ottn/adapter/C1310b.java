package com.acse.ottn.adapter;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.adapter.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1310b extends ViewPager {
    private static final String TAG = "AutoViewPager";

    /* renamed from: a */
    private static final int f2225a = 3000;

    /* renamed from: b */
    private Timer f2226b;

    /* renamed from: c */
    private C1312b f2227c;

    /* renamed from: d */
    private boolean f2228d;

    /* renamed from: e */
    private int f2229e;

    /* renamed from: f */
    private Runnable f2230f;

    /* renamed from: g */
    private HandlerC1311a f2231g;

    /* renamed from: com.acse.ottn.adapter.b$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static final class HandlerC1311a extends Handler {
        private HandlerC1311a() {
        }

        /* synthetic */ HandlerC1311a(RunnableC1309a runnableC1309a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.adapter.b$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1312b extends TimerTask {
        private C1312b() {
        }

        /* synthetic */ C1312b(C1310b c1310b, RunnableC1309a runnableC1309a) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C1310b.this.f2231g.post(C1310b.this.f2230f);
        }
    }

    public C1310b(Context context) {
        this(context, null);
    }

    public C1310b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2230f = new RunnableC1309a(this);
        this.f2231g = new HandlerC1311a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m57230f() {
        int currentItem = getCurrentItem();
        this.f2229e = currentItem;
        this.f2229e = currentItem == getAdapter().getCount() + (-1) ? 0 : this.f2229e + 1;
        setCurrentItem(this.f2229e);
        m57241a(this.f2229e % ((AbstractC1314d) getAdapter()).m57228a());
    }

    /* renamed from: g */
    private void m57229g() {
        this.f2228d = true;
        if (this.f2226b == null) {
            this.f2226b = new Timer();
        }
        this.f2226b.schedule(new C1312b(this, null), 3000L, 3000L);
    }

    /* renamed from: a */
    public void m57241a(int i) {
        if (getParent() != null && (getParent() instanceof AutoScrollViewPager)) {
            ((AutoScrollViewPager) getParent()).m57244b(i);
        }
    }

    /* renamed from: a */
    public void m57240a(int i, int i2) {
        if (getParent() instanceof AutoScrollViewPager) {
            ((AutoScrollViewPager) getParent()).m57247a(i, i2);
        } else {
            Log.e(TAG, "parent view not be AutoScrollViewPager");
        }
    }

    /* renamed from: a */
    public void m57238a(C1310b c1310b, AbstractC1314d abstractC1314d) {
        abstractC1314d.m57226a(c1310b, abstractC1314d);
    }

    /* renamed from: a */
    public boolean m57242a() {
        return this.f2228d;
    }

    /* renamed from: b */
    public void m57237b() {
        m57232d();
    }

    /* renamed from: b */
    public void m57236b(int i) {
        m57240a(i, 0);
    }

    /* renamed from: c */
    public void m57234c() {
        m57231e();
    }

    /* renamed from: d */
    public void m57232d() {
        this.f2228d = false;
        Timer timer = this.f2226b;
        if (timer != null) {
            timer.cancel();
            this.f2226b = null;
        }
    }

    /* renamed from: e */
    public void m57231e() {
        if (((AbstractC1314d) getAdapter()).m57228a() == 0) {
            return;
        }
        m57232d();
        m57229g();
    }

    public TextView getSubTitle() {
        if (getParent() instanceof AutoScrollViewPager) {
            return ((AutoScrollViewPager) getParent()).getSubTitle();
        }
        return null;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            m57232d();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            m57234c();
        }
        return super.onTouchEvent(motionEvent);
    }
}
