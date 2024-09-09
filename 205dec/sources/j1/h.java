package j1;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* compiled from: RefreshLayout.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface h {
    h A(boolean z3);

    h B(int i4);

    h C(d dVar, int i4, int i5);

    h D(@ColorRes int... iArr);

    h E(boolean z3);

    h F(boolean z3);

    h G(float f4);

    h H(k1.d dVar);

    h I(boolean z3);

    h J(boolean z3);

    h K(boolean z3);

    boolean L(int i4);

    h M(k1.e eVar);

    h N(boolean z3);

    h O(boolean z3);

    h P(boolean z3);

    h Q(float f4);

    boolean R();

    h S(int i4);

    boolean T();

    h U(int i4, boolean z3, boolean z4);

    h V(int i4);

    h W(View view, int i4, int i5);

    boolean X();

    h Y(float f4);

    h Z(d dVar);

    h a(i iVar);

    boolean a0();

    h b(boolean z3);

    h b0(boolean z3);

    @Deprecated
    h c(boolean z3);

    h c0(e eVar);

    h d(boolean z3);

    h d0(e eVar, int i4, int i5);

    h e(View view);

    h e0(boolean z3);

    boolean f();

    boolean f0(int i4);

    h g(k1.b bVar);

    h g0(Interpolator interpolator);

    ViewGroup getLayout();

    @Nullable
    d getRefreshFooter();

    @Nullable
    e getRefreshHeader();

    RefreshState getState();

    h h();

    boolean h0();

    boolean i(int i4, int i5, float f4);

    h i0(boolean z3);

    boolean j();

    boolean j0();

    h k(float f4);

    h k0(float f4);

    h l(boolean z3);

    h l0(int i4, boolean z3);

    h m(int i4);

    h m0(int i4, boolean z3);

    h n(float f4);

    h o(k1.c cVar);

    boolean p();

    boolean q();

    h r(boolean z3);

    h s(boolean z3);

    h setPrimaryColors(int... iArr);

    h t(int i4);

    h u();

    boolean v(int i4, int i5, float f4);

    boolean w();

    h x();

    h y();

    h z(float f4);
}
