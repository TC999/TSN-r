package p638r0;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import p642s0.OnStateChangedListener;

/* renamed from: r0.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface RefreshInternal extends OnStateChangedListener {
    SpinnerStyle getSpinnerStyle();

    @NonNull
    View getView();

    /* renamed from: n */
    void mo2099n(float f, int i, int i2);

    /* renamed from: o */
    void mo2098o(RefreshKernel refreshKernel, int i, int i2);

    /* renamed from: p */
    boolean mo2097p();

    void setPrimaryColors(@ColorInt int... iArr);

    /* renamed from: u */
    void mo2096u(RefreshLayout refreshLayout, int i, int i2);

    /* renamed from: v */
    int mo2095v(RefreshLayout refreshLayout, boolean z);
}
