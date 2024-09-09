package com.kwad.components.core.l;

import androidx.annotation.CallSuper;
import com.kwad.components.core.l.a;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class b<T extends a> extends com.kwad.components.core.proxy.c {
    public T mCallerContext;
    protected Presenter mPresenter;

    private void notifyOnCreate() {
        T t3 = this.mCallerContext;
        if (t3 == null) {
            return;
        }
        for (com.kwad.components.core.l.a.a aVar : t3.Ms) {
            aVar.fP();
        }
    }

    private void notifyOnDestroy() {
        T t3 = this.mCallerContext;
        if (t3 == null) {
            return;
        }
        for (com.kwad.components.core.l.a.a aVar : t3.Ms) {
            aVar.fQ();
        }
    }

    private void notifyOnPause() {
        T t3 = this.mCallerContext;
        if (t3 == null) {
            return;
        }
        for (com.kwad.components.core.l.a.a aVar : t3.Ms) {
            aVar.d(this);
        }
    }

    private void notifyOnResume() {
        T t3 = this.mCallerContext;
        if (t3 == null) {
            return;
        }
        for (com.kwad.components.core.l.a.a aVar : t3.Ms) {
            aVar.c(this);
        }
    }

    public void initMVP() {
        this.mCallerContext = onCreateCallerContext();
        if (this.mPresenter == null) {
            Presenter onCreatePresenter = onCreatePresenter();
            this.mPresenter = onCreatePresenter;
            onCreatePresenter.G(this.mRootView);
        }
        this.mPresenter.k(this.mCallerContext);
    }

    @Override // com.kwad.components.core.proxy.c
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

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onDestroy() {
        try {
            super.onDestroy();
            notifyOnDestroy();
            T t3 = this.mCallerContext;
            if (t3 != null) {
                t3.release();
            }
            Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.destroy();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
    @CallSuper
    public void onPause() {
        try {
            super.onPause();
            notifyOnPause();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.c, com.kwad.sdk.api.proxy.IActivityProxy
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
