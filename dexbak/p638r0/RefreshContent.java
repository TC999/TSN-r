package p638r0;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: r0.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface RefreshContent {
    /* renamed from: a */
    void mo2122a(ScrollBoundaryDecider scrollBoundaryDecider);

    /* renamed from: b */
    void mo2121b(boolean z);

    /* renamed from: c */
    int mo2120c();

    /* renamed from: d */
    void mo2119d(MotionEvent motionEvent);

    /* renamed from: e */
    void mo2118e(int i);

    /* renamed from: f */
    void mo2117f(int i, int i2);

    /* renamed from: g */
    ValueAnimator.AnimatorUpdateListener mo2116g(int i);

    ViewGroup.LayoutParams getLayoutParams();

    View getView();

    /* renamed from: h */
    void mo2115h(int i, int i2, int i3, int i4);

    /* renamed from: i */
    void mo2114i(RefreshKernel refreshKernel, View view, View view2);

    /* renamed from: j */
    int mo2113j();

    /* renamed from: k */
    View mo2112k();

    /* renamed from: l */
    void mo2111l(int i);

    /* renamed from: m */
    boolean mo2110m();

    /* renamed from: n */
    void mo2109n();

    /* renamed from: o */
    void mo2108o(int i, int i2);

    /* renamed from: p */
    boolean mo2107p();
}
