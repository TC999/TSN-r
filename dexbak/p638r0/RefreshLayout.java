package p638r0;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import p642s0.OnLoadmoreListener;
import p642s0.OnMultiPurposeListener;
import p642s0.OnRefreshListener;
import p642s0.OnRefreshLoadmoreListener;

/* renamed from: r0.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface RefreshLayout {
    /* renamed from: A */
    RefreshLayout mo2079A();

    /* renamed from: B */
    RefreshLayout mo2078B();

    /* renamed from: C */
    RefreshLayout mo2077C(float f);

    /* renamed from: D */
    RefreshLayout mo2076D(boolean z);

    /* renamed from: E */
    RefreshLayout mo2075E(int i);

    /* renamed from: F */
    RefreshLayout mo2074F(RefreshFooter refreshFooter);

    /* renamed from: G */
    RefreshLayout mo2073G(@ColorRes int... iArr);

    /* renamed from: H */
    RefreshLayout mo2072H(boolean z);

    /* renamed from: I */
    RefreshLayout mo2071I(boolean z);

    /* renamed from: J */
    RefreshLayout mo2070J(float f);

    /* renamed from: K */
    RefreshLayout mo2069K(boolean z);

    /* renamed from: L */
    RefreshLayout mo2068L(boolean z);

    /* renamed from: M */
    RefreshLayout mo2067M(boolean z);

    /* renamed from: N */
    boolean mo2066N(int i);

    /* renamed from: O */
    RefreshLayout mo2065O(boolean z);

    /* renamed from: P */
    RefreshLayout mo2064P(boolean z);

    /* renamed from: Q */
    RefreshLayout mo2063Q(boolean z);

    /* renamed from: R */
    RefreshLayout mo2062R(float f);

    /* renamed from: S */
    boolean mo2061S();

    /* renamed from: T */
    RefreshLayout mo2060T(int i);

    /* renamed from: U */
    boolean mo2059U();

    /* renamed from: V */
    RefreshLayout mo2058V(int i, boolean z, boolean z2);

    /* renamed from: W */
    RefreshLayout mo2057W(int i);

    /* renamed from: X */
    RefreshLayout mo2056X(View view, int i, int i2);

    /* renamed from: Y */
    boolean mo2055Y();

    /* renamed from: Z */
    RefreshLayout mo2054Z(float f);

    /* renamed from: a */
    RefreshLayout mo2053a(ScrollBoundaryDecider scrollBoundaryDecider);

    /* renamed from: a0 */
    boolean mo2052a0();

    /* renamed from: b */
    RefreshLayout mo2051b(boolean z);

    /* renamed from: b0 */
    RefreshLayout mo2050b0(boolean z);

    @Deprecated
    /* renamed from: c */
    RefreshLayout mo2049c(boolean z);

    /* renamed from: c0 */
    RefreshLayout mo2048c0(OnMultiPurposeListener onMultiPurposeListener);

    /* renamed from: d */
    RefreshLayout mo2047d(boolean z);

    /* renamed from: d0 */
    RefreshLayout mo2046d0(RefreshHeader refreshHeader, int i, int i2);

    /* renamed from: e */
    RefreshLayout mo2045e(View view);

    /* renamed from: e0 */
    RefreshLayout mo2044e0(boolean z);

    /* renamed from: f */
    boolean mo2043f();

    /* renamed from: f0 */
    boolean mo2042f0(int i);

    /* renamed from: g */
    RefreshLayout mo2041g();

    /* renamed from: g0 */
    RefreshLayout mo2040g0(Interpolator interpolator);

    ViewGroup getLayout();

    @Nullable
    RefreshFooter getRefreshFooter();

    @Nullable
    RefreshHeader getRefreshHeader();

    RefreshState getState();

    /* renamed from: h */
    boolean mo2039h(int i, int i2, float f);

    /* renamed from: h0 */
    boolean mo2038h0();

    /* renamed from: i */
    boolean mo2037i();

    /* renamed from: i0 */
    RefreshLayout mo2036i0(boolean z);

    /* renamed from: j */
    RefreshLayout mo2035j(OnRefreshListener onRefreshListener);

    /* renamed from: j0 */
    boolean mo2034j0();

    /* renamed from: k */
    RefreshLayout mo2033k(RefreshFooter refreshFooter, int i, int i2);

    /* renamed from: k0 */
    RefreshLayout mo2032k0(float f);

    /* renamed from: l */
    RefreshLayout mo2031l(float f);

    /* renamed from: l0 */
    RefreshLayout mo2030l0(int i, boolean z);

    /* renamed from: m */
    RefreshLayout mo2029m(boolean z);

    /* renamed from: m0 */
    RefreshLayout mo2028m0(int i, boolean z);

    /* renamed from: n */
    RefreshLayout mo2027n(int i);

    /* renamed from: o */
    RefreshLayout mo2026o(OnLoadmoreListener onLoadmoreListener);

    /* renamed from: p */
    RefreshLayout mo2025p(float f);

    /* renamed from: q */
    boolean mo2024q();

    /* renamed from: r */
    boolean mo2023r();

    /* renamed from: s */
    RefreshLayout mo2022s(boolean z);

    RefreshLayout setPrimaryColors(int... iArr);

    /* renamed from: t */
    RefreshLayout mo2021t(boolean z);

    /* renamed from: u */
    RefreshLayout mo2020u(int i);

    /* renamed from: v */
    RefreshLayout mo2019v(OnRefreshLoadmoreListener onRefreshLoadmoreListener);

    /* renamed from: w */
    RefreshLayout mo2018w();

    /* renamed from: x */
    boolean mo2017x(int i, int i2, float f);

    /* renamed from: y */
    RefreshLayout mo2016y(RefreshHeader refreshHeader);

    /* renamed from: z */
    boolean mo2015z();
}
