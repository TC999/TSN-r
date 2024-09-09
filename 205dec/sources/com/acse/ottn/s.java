package com.acse.ottn;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.acse.ottn.adapter.AutoScrollViewPager;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class s extends ViewPager {

    /* renamed from: g  reason: collision with root package name */
    public static final String f6247g = "AutoViewPager";

    /* renamed from: h  reason: collision with root package name */
    public static final int f6248h = 3000;

    /* renamed from: a  reason: collision with root package name */
    public Timer f6249a;

    /* renamed from: b  reason: collision with root package name */
    public c f6250b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6251c;

    /* renamed from: d  reason: collision with root package name */
    public int f6252d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f6253e;

    /* renamed from: f  reason: collision with root package name */
    public b f6254f;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.a();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class b extends Handler {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c extends TimerTask {
        public c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            s.this.f6254f.post(s.this.f6253e);
        }

        public /* synthetic */ c(s sVar, a aVar) {
            this();
        }
    }

    public s(Context context) {
        this(context, null);
    }

    public void d() {
        f();
    }

    public void e() {
        g();
    }

    public void f() {
        this.f6251c = false;
        Timer timer = this.f6249a;
        if (timer != null) {
            timer.cancel();
            this.f6249a = null;
        }
    }

    public void g() {
        if (((d0) getAdapter()).a() == 0) {
            return;
        }
        f();
        b();
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
            f();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            e();
        }
        return super.onTouchEvent(motionEvent);
    }

    public s(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6253e = new a();
        this.f6254f = new b(null);
    }

    public void a(s sVar, d0 d0Var) {
        d0Var.a(sVar, d0Var);
    }

    public final void b() {
        this.f6251c = true;
        if (this.f6249a == null) {
            this.f6249a = new Timer();
        }
        this.f6249a.schedule(new c(this, null), 3000L, 3000L);
    }

    public boolean c() {
        return this.f6251c;
    }

    public final void a() {
        int currentItem = getCurrentItem();
        this.f6252d = currentItem;
        if (currentItem == getAdapter().getCount() - 1) {
            this.f6252d = 0;
        } else {
            this.f6252d++;
        }
        setCurrentItem(this.f6252d);
        a(this.f6252d % ((d0) getAdapter()).a());
    }

    public void b(int i4) {
        a(i4, 0);
    }

    public void a(int i4, int i5) {
        if (getParent() instanceof AutoScrollViewPager) {
            ((AutoScrollViewPager) getParent()).a(i4, i5);
        } else {
            Log.e(f6247g, "parent view not be AutoScrollViewPager");
        }
    }

    public void a(int i4) {
        if (getParent() != null && (getParent() instanceof AutoScrollViewPager)) {
            ((AutoScrollViewPager) getParent()).b(i4);
        }
    }
}
