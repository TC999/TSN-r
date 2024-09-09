package com.scwang.smartrefresh.layout.impl;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.core.widget.NestedScrollView;
import androidx.legacy.widget.Space;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Collections;
import java.util.concurrent.LinkedBlockingQueue;
import r0.g;
import r0.h;
import r0.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: RefreshContentWrapper.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements r0.c {

    /* renamed from: c  reason: collision with root package name */
    protected View f48022c;

    /* renamed from: d  reason: collision with root package name */
    protected View f48023d;

    /* renamed from: e  reason: collision with root package name */
    protected View f48024e;

    /* renamed from: f  reason: collision with root package name */
    protected View f48025f;

    /* renamed from: g  reason: collision with root package name */
    protected View f48026g;

    /* renamed from: j  reason: collision with root package name */
    protected MotionEvent f48029j;

    /* renamed from: a  reason: collision with root package name */
    protected int f48020a = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    protected int f48021b = Integer.MAX_VALUE - 1;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f48027h = true;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f48028i = true;

    /* renamed from: k  reason: collision with root package name */
    protected d f48030k = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: RefreshContentWrapper.java */
    /* renamed from: com.scwang.smartrefresh.layout.impl.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class C0931a implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f48031a;

        C0931a(h hVar) {
            this.f48031a = hVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i4) {
            a aVar = a.this;
            boolean z3 = true;
            aVar.f48027h = i4 >= 0;
            aVar.f48028i = (!this.f48031a.U() || appBarLayout.getTotalScrollRange() + i4 > 0) ? false : false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: RefreshContentWrapper.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        int f48033a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f48034b;

        b(int i4) {
            this.f48034b = i4;
            this.f48033a = i4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            try {
                View view = a.this.f48024e;
                if (view instanceof AbsListView) {
                    a.v((AbsListView) view, intValue - this.f48033a);
                } else {
                    view.scrollBy(0, intValue - this.f48033a);
                }
            } catch (Throwable unused) {
            }
            this.f48033a = intValue;
        }
    }

    public a(View view) {
        this.f48023d = view;
        this.f48022c = view;
    }

    protected static int u(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i4 = layoutParams.height;
        if (i4 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
        return view.getMeasuredHeight();
    }

    protected static void v(@NonNull AbsListView absListView, int i4) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            absListView.scrollListBy(i4);
        } else if (absListView instanceof ListView) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition == -1 || (childAt = absListView.getChildAt(0)) == null) {
                return;
            }
            ((ListView) absListView).setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i4);
        } else {
            absListView.smoothScrollBy(i4, 0);
        }
    }

    @Override // r0.c
    public void a(i iVar) {
        if (iVar instanceof d) {
            this.f48030k = (d) iVar;
        } else {
            this.f48030k.e(iVar);
        }
    }

    @Override // r0.c
    public void b(boolean z3) {
        this.f48030k.d(z3);
    }

    @Override // r0.c
    public int c() {
        return this.f48022c.getMeasuredHeight();
    }

    @Override // r0.c
    public void d(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.f48029j = obtain;
        obtain.offsetLocation(-this.f48022c.getLeft(), -this.f48022c.getTop());
        this.f48030k.c(this.f48029j);
        this.f48024e = r(this.f48022c, this.f48029j, this.f48024e);
    }

    @Override // r0.c
    public void e(int i4) {
        this.f48023d.setTranslationY(i4);
        View view = this.f48025f;
        if (view != null) {
            view.setTranslationY(Math.max(0, i4));
        }
        View view2 = this.f48026g;
        if (view2 != null) {
            view2.setTranslationY(Math.min(0, i4));
        }
    }

    @Override // r0.c
    public void f(int i4, int i5) {
        this.f48020a = i4;
        this.f48021b = i5;
    }

    @Override // r0.c
    public ValueAnimator.AnimatorUpdateListener g(int i4) {
        View view = this.f48024e;
        if (view == null || i4 == 0) {
            return null;
        }
        if ((i4 >= 0 || !com.scwang.smartrefresh.layout.util.d.c(view)) && (i4 <= 0 || !com.scwang.smartrefresh.layout.util.d.e(this.f48024e))) {
            return null;
        }
        return new b(i4);
    }

    @Override // r0.c
    public ViewGroup.LayoutParams getLayoutParams() {
        return this.f48022c.getLayoutParams();
    }

    @Override // r0.c
    @NonNull
    public View getView() {
        return this.f48022c;
    }

    @Override // r0.c
    public void h(int i4, int i5, int i6, int i7) {
        this.f48022c.layout(i4, i5, i6, i7);
    }

    @Override // r0.c
    public void i(g gVar, View view, View view2) {
        q(this.f48022c, gVar);
        if (view == null && view2 == null) {
            return;
        }
        this.f48025f = view;
        this.f48026g = view2;
        FrameLayout frameLayout = new FrameLayout(this.f48022c.getContext());
        gVar.n().getLayout().removeView(this.f48022c);
        ViewGroup.LayoutParams layoutParams = this.f48022c.getLayoutParams();
        frameLayout.addView(this.f48022c, -1, -1);
        gVar.n().getLayout().addView(frameLayout, layoutParams);
        this.f48022c = frameLayout;
        if (view != null) {
            view.setClickable(true);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams2.height = u(view);
            viewGroup.addView(new Space(this.f48022c.getContext()), indexOfChild, layoutParams2);
            frameLayout.addView(view);
        }
        if (view2 != null) {
            view2.setClickable(true);
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            int indexOfChild2 = viewGroup2.indexOfChild(view2);
            viewGroup2.removeView(view2);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(layoutParams3);
            layoutParams3.height = u(view2);
            viewGroup2.addView(new Space(this.f48022c.getContext()), indexOfChild2, layoutParams3);
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, layoutParams4);
        }
    }

    @Override // r0.c
    public int j() {
        return this.f48022c.getMeasuredWidth();
    }

    @Override // r0.c
    public View k() {
        return this.f48024e;
    }

    @Override // r0.c
    public void l(int i4) {
        View view = this.f48024e;
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i4);
        } else if (view instanceof AbsListView) {
            if (Build.VERSION.SDK_INT >= 21) {
                ((AbsListView) view).fling(i4);
            }
        } else if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i4);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i4);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i4);
        }
    }

    @Override // r0.c
    public boolean m() {
        return this.f48027h && this.f48030k.a(this.f48022c);
    }

    @Override // r0.c
    public void n() {
        this.f48029j = null;
    }

    @Override // r0.c
    public void o(int i4, int i5) {
        this.f48022c.measure(i4, i5);
    }

    @Override // r0.c
    public boolean p() {
        return this.f48028i && this.f48030k.b(this.f48022c);
    }

    protected void q(View view, g gVar) {
        this.f48024e = null;
        while (true) {
            View view2 = this.f48024e;
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                return;
            }
            view = s(view, view2 == null);
            if (view == this.f48024e) {
                return;
            }
            try {
                if (view instanceof CoordinatorLayout) {
                    gVar.n().M(false);
                    w((ViewGroup) view, gVar.n());
                }
            } catch (Throwable unused) {
            }
            this.f48024e = view;
        }
    }

    protected View r(View view, MotionEvent motionEvent, View view2) {
        if ((view instanceof ViewGroup) && motionEvent != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (com.scwang.smartrefresh.layout.util.d.f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                    if ((childAt instanceof ViewPager) || !t(childAt)) {
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.offsetLocation(pointF.x, pointF.y);
                        return r(childAt, obtain, view2);
                    }
                    return childAt;
                }
            }
        }
        return view2;
    }

    protected View s(View view, boolean z3) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(Collections.singletonList(view));
        View view2 = null;
        while (!linkedBlockingQueue.isEmpty() && view2 == null) {
            View view3 = (View) linkedBlockingQueue.poll();
            if (view3 != null) {
                if ((z3 || view3 != view) && t(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                        linkedBlockingQueue.add(viewGroup.getChildAt(i4));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    protected boolean t(View view) {
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof ScrollingView) || (view instanceof NestedScrollingChild) || (view instanceof NestedScrollingParent) || (view instanceof WebView) || (view instanceof ViewPager);
    }

    protected void w(ViewGroup viewGroup, h hVar) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof AppBarLayout) {
                ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new C0931a(hVar));
            }
        }
    }

    public a(Context context) {
        View view = new View(context);
        this.f48023d = view;
        this.f48022c = view;
    }
}
