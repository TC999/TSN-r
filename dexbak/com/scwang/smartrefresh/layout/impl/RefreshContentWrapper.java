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
import com.scwang.smartrefresh.layout.util.ScrollBoundaryUtil;
import java.util.Collections;
import java.util.concurrent.LinkedBlockingQueue;
import p638r0.RefreshContent;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;
import p638r0.ScrollBoundaryDecider;

/* renamed from: com.scwang.smartrefresh.layout.impl.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RefreshContentWrapper implements RefreshContent {

    /* renamed from: c */
    protected View f33688c;

    /* renamed from: d */
    protected View f33689d;

    /* renamed from: e */
    protected View f33690e;

    /* renamed from: f */
    protected View f33691f;

    /* renamed from: g */
    protected View f33692g;

    /* renamed from: j */
    protected MotionEvent f33695j;

    /* renamed from: a */
    protected int f33686a = Integer.MAX_VALUE;

    /* renamed from: b */
    protected int f33687b = Integer.MAX_VALUE - 1;

    /* renamed from: h */
    protected boolean f33693h = true;

    /* renamed from: i */
    protected boolean f33694i = true;

    /* renamed from: k */
    protected ScrollBoundaryDeciderAdapter f33696k = new ScrollBoundaryDeciderAdapter();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RefreshContentWrapper.java */
    /* renamed from: com.scwang.smartrefresh.layout.impl.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11920a implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: a */
        final /* synthetic */ RefreshLayout f33697a;

        C11920a(RefreshLayout refreshLayout) {
            this.f33697a = refreshLayout;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            RefreshContentWrapper refreshContentWrapper = RefreshContentWrapper.this;
            boolean z = true;
            refreshContentWrapper.f33693h = i >= 0;
            refreshContentWrapper.f33694i = (!this.f33697a.mo2059U() || appBarLayout.getTotalScrollRange() + i > 0) ? false : false;
        }
    }

    /* compiled from: RefreshContentWrapper.java */
    /* renamed from: com.scwang.smartrefresh.layout.impl.a$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11921b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        int f33699a;

        /* renamed from: b */
        final /* synthetic */ int f33700b;

        C11921b(int i) {
            this.f33700b = i;
            this.f33699a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            try {
                View view = RefreshContentWrapper.this.f33690e;
                if (view instanceof AbsListView) {
                    RefreshContentWrapper.m19839v((AbsListView) view, intValue - this.f33699a);
                } else {
                    view.scrollBy(0, intValue - this.f33699a);
                }
            } catch (Throwable unused) {
            }
            this.f33699a = intValue;
        }
    }

    public RefreshContentWrapper(View view) {
        this.f33689d = view;
        this.f33688c = view;
    }

    /* renamed from: u */
    protected static int m19840u(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
        return view.getMeasuredHeight();
    }

    /* renamed from: v */
    protected static void m19839v(@NonNull AbsListView absListView, int i) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            absListView.scrollListBy(i);
        } else if (absListView instanceof ListView) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition == -1 || (childAt = absListView.getChildAt(0)) == null) {
                return;
            }
            ((ListView) absListView).setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
        } else {
            absListView.smoothScrollBy(i, 0);
        }
    }

    @Override // p638r0.RefreshContent
    /* renamed from: a */
    public void mo2122a(ScrollBoundaryDecider scrollBoundaryDecider) {
        if (scrollBoundaryDecider instanceof ScrollBoundaryDeciderAdapter) {
            this.f33696k = (ScrollBoundaryDeciderAdapter) scrollBoundaryDecider;
        } else {
            this.f33696k.m19835e(scrollBoundaryDecider);
        }
    }

    @Override // p638r0.RefreshContent
    /* renamed from: b */
    public void mo2121b(boolean z) {
        this.f33696k.m19836d(z);
    }

    @Override // p638r0.RefreshContent
    /* renamed from: c */
    public int mo2120c() {
        return this.f33688c.getMeasuredHeight();
    }

    @Override // p638r0.RefreshContent
    /* renamed from: d */
    public void mo2119d(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.f33695j = obtain;
        obtain.offsetLocation(-this.f33688c.getLeft(), -this.f33688c.getTop());
        this.f33696k.m19837c(this.f33695j);
        this.f33690e = m19843r(this.f33688c, this.f33695j, this.f33690e);
    }

    @Override // p638r0.RefreshContent
    /* renamed from: e */
    public void mo2118e(int i) {
        this.f33689d.setTranslationY(i);
        View view = this.f33691f;
        if (view != null) {
            view.setTranslationY(Math.max(0, i));
        }
        View view2 = this.f33692g;
        if (view2 != null) {
            view2.setTranslationY(Math.min(0, i));
        }
    }

    @Override // p638r0.RefreshContent
    /* renamed from: f */
    public void mo2117f(int i, int i2) {
        this.f33686a = i;
        this.f33687b = i2;
    }

    @Override // p638r0.RefreshContent
    /* renamed from: g */
    public ValueAnimator.AnimatorUpdateListener mo2116g(int i) {
        View view = this.f33690e;
        if (view == null || i == 0) {
            return null;
        }
        if ((i >= 0 || !ScrollBoundaryUtil.m19761c(view)) && (i <= 0 || !ScrollBoundaryUtil.m19759e(this.f33690e))) {
            return null;
        }
        return new C11921b(i);
    }

    @Override // p638r0.RefreshContent
    public ViewGroup.LayoutParams getLayoutParams() {
        return this.f33688c.getLayoutParams();
    }

    @Override // p638r0.RefreshContent
    @NonNull
    public View getView() {
        return this.f33688c;
    }

    @Override // p638r0.RefreshContent
    /* renamed from: h */
    public void mo2115h(int i, int i2, int i3, int i4) {
        this.f33688c.layout(i, i2, i3, i4);
    }

    @Override // p638r0.RefreshContent
    /* renamed from: i */
    public void mo2114i(RefreshKernel refreshKernel, View view, View view2) {
        m19844q(this.f33688c, refreshKernel);
        if (view == null && view2 == null) {
            return;
        }
        this.f33691f = view;
        this.f33692g = view2;
        FrameLayout frameLayout = new FrameLayout(this.f33688c.getContext());
        refreshKernel.mo2081n().getLayout().removeView(this.f33688c);
        ViewGroup.LayoutParams layoutParams = this.f33688c.getLayoutParams();
        frameLayout.addView(this.f33688c, -1, -1);
        refreshKernel.mo2081n().getLayout().addView(frameLayout, layoutParams);
        this.f33688c = frameLayout;
        if (view != null) {
            view.setClickable(true);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams2.height = m19840u(view);
            viewGroup.addView(new Space(this.f33688c.getContext()), indexOfChild, layoutParams2);
            frameLayout.addView(view);
        }
        if (view2 != null) {
            view2.setClickable(true);
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            int indexOfChild2 = viewGroup2.indexOfChild(view2);
            viewGroup2.removeView(view2);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(layoutParams3);
            layoutParams3.height = m19840u(view2);
            viewGroup2.addView(new Space(this.f33688c.getContext()), indexOfChild2, layoutParams3);
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, layoutParams4);
        }
    }

    @Override // p638r0.RefreshContent
    /* renamed from: j */
    public int mo2113j() {
        return this.f33688c.getMeasuredWidth();
    }

    @Override // p638r0.RefreshContent
    /* renamed from: k */
    public View mo2112k() {
        return this.f33690e;
    }

    @Override // p638r0.RefreshContent
    /* renamed from: l */
    public void mo2111l(int i) {
        View view = this.f33690e;
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i);
        } else if (view instanceof AbsListView) {
            if (Build.VERSION.SDK_INT >= 21) {
                ((AbsListView) view).fling(i);
            }
        } else if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i);
        }
    }

    @Override // p638r0.RefreshContent
    /* renamed from: m */
    public boolean mo2110m() {
        return this.f33693h && this.f33696k.mo2014a(this.f33688c);
    }

    @Override // p638r0.RefreshContent
    /* renamed from: n */
    public void mo2109n() {
        this.f33695j = null;
    }

    @Override // p638r0.RefreshContent
    /* renamed from: o */
    public void mo2108o(int i, int i2) {
        this.f33688c.measure(i, i2);
    }

    @Override // p638r0.RefreshContent
    /* renamed from: p */
    public boolean mo2107p() {
        return this.f33694i && this.f33696k.mo2013b(this.f33688c);
    }

    /* renamed from: q */
    protected void m19844q(View view, RefreshKernel refreshKernel) {
        this.f33690e = null;
        while (true) {
            View view2 = this.f33690e;
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                return;
            }
            view = m19842s(view, view2 == null);
            if (view == this.f33690e) {
                return;
            }
            try {
                if (view instanceof CoordinatorLayout) {
                    refreshKernel.mo2081n().mo2067M(false);
                    m19838w((ViewGroup) view, refreshKernel.mo2081n());
                }
            } catch (Throwable unused) {
            }
            this.f33690e = view;
        }
    }

    /* renamed from: r */
    protected View m19843r(View view, MotionEvent motionEvent, View view2) {
        if ((view instanceof ViewGroup) && motionEvent != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (ScrollBoundaryUtil.m19758f(viewGroup, childAt, motionEvent.getX(), motionEvent.getY(), pointF)) {
                    if ((childAt instanceof ViewPager) || !m19841t(childAt)) {
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.offsetLocation(pointF.x, pointF.y);
                        return m19843r(childAt, obtain, view2);
                    }
                    return childAt;
                }
            }
        }
        return view2;
    }

    /* renamed from: s */
    protected View m19842s(View view, boolean z) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(Collections.singletonList(view));
        View view2 = null;
        while (!linkedBlockingQueue.isEmpty() && view2 == null) {
            View view3 = (View) linkedBlockingQueue.poll();
            if (view3 != null) {
                if ((z || view3 != view) && m19841t(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        linkedBlockingQueue.add(viewGroup.getChildAt(i));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    /* renamed from: t */
    protected boolean m19841t(View view) {
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof ScrollingView) || (view instanceof NestedScrollingChild) || (view instanceof NestedScrollingParent) || (view instanceof WebView) || (view instanceof ViewPager);
    }

    /* renamed from: w */
    protected void m19838w(ViewGroup viewGroup, RefreshLayout refreshLayout) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof AppBarLayout) {
                ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new C11920a(refreshLayout));
            }
        }
    }

    public RefreshContentWrapper(Context context) {
        View view = new View(context);
        this.f33689d = view;
        this.f33688c = view;
    }
}
