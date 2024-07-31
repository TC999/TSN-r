package com.kwad.components.core.p301l;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.kwad.sdk.mvp.AbstractC10868a;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.core.l.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8692c<T extends AbstractC10868a> extends KSFrameLayout {

    /* renamed from: Mu */
    public T f28360Mu;

    /* renamed from: lD */
    protected ViewGroup f28361lD;
    protected Presenter mPresenter;

    public AbstractC8692c(Context context) {
        this(context, null);
    }

    private void initMVP() {
        this.f28360Mu = mo29837kt();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.m24616G(this.f28361lD);
        }
        this.mPresenter.m24605k(this.f28360Mu);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ac */
    public void mo23565ac() {
        super.mo23565ac();
        initMVP();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ad */
    public void mo23564ad() {
        super.mo23564ad();
        T t = this.f28360Mu;
        if (t != null) {
            t.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract void initData();

    /* renamed from: kp */
    protected boolean mo30012kp() {
        return false;
    }

    /* renamed from: kr */
    protected abstract void mo29838kr();

    /* renamed from: kt */
    protected abstract T mo29837kt();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: oJ */
    public final void m30011oJ() {
        initData();
        this.f28361lD = (ViewGroup) C10887l.inflate(getContext(), getLayoutId(), this);
        mo29838kr();
    }

    @NonNull
    public abstract Presenter onCreatePresenter();

    private AbstractC8692c(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private AbstractC8692c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        if (mo30012kp()) {
            return;
        }
        m30011oJ();
    }
}
