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

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b extends ViewPager {
    private static final String TAG = "AutoViewPager";

    /* renamed from: a  reason: collision with root package name */
    private static final int f4776a = 3000;

    /* renamed from: b  reason: collision with root package name */
    private Timer f4777b;

    /* renamed from: c  reason: collision with root package name */
    private C0077b f4778c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4779d;

    /* renamed from: e  reason: collision with root package name */
    private int f4780e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f4781f;

    /* renamed from: g  reason: collision with root package name */
    private a f4782g;

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private static final class a extends Handler {
        private a() {
        }

        /* synthetic */ a(com.acse.ottn.adapter.a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.acse.ottn.adapter.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class C0077b extends TimerTask {
        private C0077b() {
        }

        /* synthetic */ C0077b(b bVar, com.acse.ottn.adapter.a aVar) {
            this();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            b.this.f4782g.post(b.this.f4781f);
        }
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4781f = new com.acse.ottn.adapter.a(this);
        this.f4782g = new a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int currentItem = getCurrentItem();
        this.f4780e = currentItem;
        this.f4780e = currentItem == getAdapter().getCount() + (-1) ? 0 : this.f4780e + 1;
        setCurrentItem(this.f4780e);
        a(this.f4780e % ((d) getAdapter()).a());
    }

    private void g() {
        this.f4779d = true;
        if (this.f4777b == null) {
            this.f4777b = new Timer();
        }
        this.f4777b.schedule(new C0077b(this, null), 3000L, 3000L);
    }

    public void a(int i4) {
        if (getParent() != null && (getParent() instanceof AutoScrollViewPager)) {
            ((AutoScrollViewPager) getParent()).b(i4);
        }
    }

    public void a(int i4, int i5) {
        if (getParent() instanceof AutoScrollViewPager) {
            ((AutoScrollViewPager) getParent()).a(i4, i5);
        } else {
            Log.e("AutoViewPager", "parent view not be AutoScrollViewPager");
        }
    }

    public void a(b bVar, d dVar) {
        dVar.a(bVar, dVar);
    }

    public boolean a() {
        return this.f4779d;
    }

    public void b() {
        d();
    }

    public void b(int i4) {
        a(i4, 0);
    }

    public void c() {
        e();
    }

    public void d() {
        this.f4779d = false;
        Timer timer = this.f4777b;
        if (timer != null) {
            timer.cancel();
            this.f4777b = null;
        }
    }

    public void e() {
        if (((d) getAdapter()).a() == 0) {
            return;
        }
        d();
        g();
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
            d();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            c();
        }
        return super.onTouchEvent(motionEvent);
    }
}
