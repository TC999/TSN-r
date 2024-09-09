package j1;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

/* compiled from: RefreshInternal.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface f extends k1.f {
    void f(g gVar, int i4, int i5);

    SpinnerStyle getSpinnerStyle();

    @NonNull
    View getView();

    void l(float f4, int i4, int i5);

    boolean m();

    int r(h hVar, boolean z3);

    void setPrimaryColors(@ColorInt int... iArr);

    void t(h hVar, int i4, int i5);
}
