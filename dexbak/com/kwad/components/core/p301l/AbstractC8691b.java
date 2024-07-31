package com.kwad.components.core.p301l;

import androidx.annotation.CallSuper;
import com.kwad.components.core.p301l.C8688a;
import com.kwad.components.core.p301l.p302a.InterfaceC8689a;
import com.kwad.components.core.proxy.AbstractC8886c;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.components.core.l.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8691b<T extends C8688a> extends AbstractC8886c {
    public T mCallerContext;
    protected Presenter mPresenter;

    private void notifyOnCreate() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (InterfaceC8689a interfaceC8689a : t.f28358Ms) {
            interfaceC8689a.mo29621fP();
        }
    }

    private void notifyOnDestroy() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (InterfaceC8689a interfaceC8689a : t.f28358Ms) {
            interfaceC8689a.mo29620fQ();
        }
    }

    private void notifyOnPause() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (InterfaceC8689a interfaceC8689a : t.f28358Ms) {
            interfaceC8689a.mo29622d(this);
        }
    }

    private void notifyOnResume() {
        T t = this.mCallerContext;
        if (t == null) {
            return;
        }
        for (InterfaceC8689a interfaceC8689a : t.f28358Ms) {
            interfaceC8689a.mo29623c(this);
        }
    }

    public void initMVP() {
        this.mCallerContext = onCreateCallerContext();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.m24616G(this.mRootView);
        }
        this.mPresenter.m24605k(this.mCallerContext);
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c
    @CallSuper
    public void onActivityCreate() {
        try {
            super.onActivityCreate();
            initMVP();
            notifyOnCreate();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    protected abstract T onCreateCallerContext();

    protected abstract Presenter onCreatePresenter();

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onDestroy() {
        try {
            super.onDestroy();
            notifyOnDestroy();
            T t = this.mCallerContext;
            if (t != null) {
                t.release();
            }
            Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.destroy();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onPause() {
        try {
            super.onPause();
            notifyOnPause();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.AbstractC8886c, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onResume() {
        try {
            super.onResume();
            notifyOnResume();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
