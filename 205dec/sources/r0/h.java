package r0;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* compiled from: RefreshLayout.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface h {
    h A();

    h B();

    h C(float f4);

    h D(boolean z3);

    h E(int i4);

    h F(d dVar);

    h G(@ColorRes int... iArr);

    h H(boolean z3);

    h I(boolean z3);

    h J(float f4);

    h K(boolean z3);

    h L(boolean z3);

    h M(boolean z3);

    boolean N(int i4);

    h O(boolean z3);

    h P(boolean z3);

    h Q(boolean z3);

    h R(float f4);

    boolean S();

    h T(int i4);

    boolean U();

    h V(int i4, boolean z3, boolean z4);

    h W(int i4);

    h X(View view, int i4, int i5);

    boolean Y();

    h Z(float f4);

    h a(i iVar);

    boolean a0();

    h b(boolean z3);

    h b0(boolean z3);

    @Deprecated
    h c(boolean z3);

    h c0(s0.c cVar);

    h d(boolean z3);

    h d0(e eVar, int i4, int i5);

    h e(View view);

    h e0(boolean z3);

    boolean f();

    boolean f0(int i4);

    h g();

    h g0(Interpolator interpolator);

    ViewGroup getLayout();

    @Nullable
    d getRefreshFooter();

    @Nullable
    e getRefreshHeader();

    RefreshState getState();

    boolean h(int i4, int i5, float f4);

    boolean h0();

    boolean i();

    h i0(boolean z3);

    h j(s0.d dVar);

    boolean j0();

    h k(d dVar, int i4, int i5);

    h k0(float f4);

    h l(float f4);

    h l0(int i4, boolean z3);

    h m(boolean z3);

    h m0(int i4, boolean z3);

    h n(int i4);

    h o(s0.b bVar);

    h p(float f4);

    boolean q();

    boolean r();

    h s(boolean z3);

    h setPrimaryColors(int... iArr);

    h t(boolean z3);

    h u(int i4);

    h v(s0.e eVar);

    h w();

    boolean x(int i4, int i5, float f4);

    h y(e eVar);

    boolean z();
}
