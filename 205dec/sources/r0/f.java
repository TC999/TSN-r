package r0;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

/* compiled from: RefreshInternal.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface f extends s0.f {
    SpinnerStyle getSpinnerStyle();

    @NonNull
    View getView();

    void n(float f4, int i4, int i5);

    void o(g gVar, int i4, int i5);

    boolean p();

    void setPrimaryColors(@ColorInt int... iArr);

    void u(h hVar, int i4, int i5);

    int v(h hVar, boolean z3);
}
