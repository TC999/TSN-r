package com.kwad.components.core.l;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.mvp.a;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class c<T extends com.kwad.sdk.mvp.a> extends KSFrameLayout {
    public T Mu;
    protected ViewGroup lD;
    protected Presenter mPresenter;

    public c(Context context) {
        this(context, null);
    }

    private void initMVP() {
        this.Mu = kt();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.G(this.lD);
        }
        this.mPresenter.k(this.Mu);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ac() {
        super.ac();
        initMVP();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ad() {
        super.ad();
        T t3 = this.Mu;
        if (t3 != null) {
            t3.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract void initData();

    protected boolean kp() {
        return false;
    }

    protected abstract void kr();

    protected abstract T kt();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void oJ() {
        initData();
        this.lD = (ViewGroup) l.inflate(getContext(), getLayoutId(), this);
        kr();
    }

    @NonNull
    public abstract Presenter onCreatePresenter();

    private c(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private c(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, 0);
        if (kp()) {
            return;
        }
        oJ();
    }
}
