package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.C10974c;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class Presenter {
    private Object aJN;
    private View mRootView;
    private final List<Presenter> aJM = new CopyOnWriteArrayList();
    private PresenterState aJO = PresenterState.INIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum PresenterState {
        INIT(0) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
            }
        },
        CREATE(1) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            public final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.aJM) {
                    try {
                        presenter2.m24616G(presenter.mRootView);
                    } catch (Exception e) {
                        C10974c.gatherException(e);
                        C10331c.printStackTrace(e);
                    }
                }
            }
        },
        BIND(2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.aJM) {
                    try {
                        presenter2.m24605k(presenter.aJN);
                    } catch (Throwable th) {
                        C10974c.gatherException(th);
                        C10331c.printStackTrace(th);
                    }
                }
            }
        },
        UNBIND(3) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.aJM) {
                    try {
                        presenter2.m24604lW();
                    } catch (Exception e) {
                        C10974c.gatherException(e);
                        C10331c.printStackTrace(e);
                    }
                }
            }
        },
        DESTROY(4) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.aJM) {
                    try {
                        presenter2.destroy();
                    } catch (Exception e) {
                        C10974c.gatherException(e);
                        C10331c.printStackTrace(e);
                    }
                }
            }
        };
        
        private int mIndex;

        public int index() {
            return this.mIndex;
        }

        abstract void performCallState(Presenter presenter);

        PresenterState(int i) {
            this.mIndex = i;
        }
    }

    /* renamed from: Jv */
    private boolean m24615Jv() {
        return this.aJO.index() >= PresenterState.CREATE.index();
    }

    /* renamed from: b */
    private void m24609b(Presenter presenter) {
        Object obj;
        View view;
        int index = this.aJO.index();
        PresenterState presenterState = PresenterState.UNBIND;
        if (index >= presenterState.index() || presenter.aJO.index() >= presenterState.index()) {
            return;
        }
        if (m24615Jv() && !presenter.m24615Jv() && (view = this.mRootView) != null) {
            presenter.m24616G(view);
        }
        if (!isBound() || !presenter.m24615Jv() || presenter.isBound() || (obj = this.aJN) == null) {
            return;
        }
        presenter.m24605k(obj);
    }

    private boolean isBound() {
        return this.aJO == PresenterState.BIND;
    }

    @UiThread
    /* renamed from: G */
    public final void m24616G(View view) {
        try {
            this.aJO = PresenterState.CREATE;
            this.mRootView = view;
            onCreate();
            this.aJO.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: Jw */
    public final List<Presenter> m24614Jw() {
        return this.aJM;
    }

    /* renamed from: Jx */
    public final Object m24613Jx() {
        return this.aJN;
    }

    /* renamed from: a */
    public final void m24612a(Presenter presenter) {
        this.aJM.add(presenter);
        if (!m24615Jv() || presenter.m24615Jv()) {
            return;
        }
        m24616G(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aj */
    public void mo24610aj() {
    }

    @UiThread
    public final void destroy() {
        try {
            if (this.aJO == PresenterState.BIND) {
                m24604lW();
            }
            this.aJO = PresenterState.DESTROY;
            onDestroy();
            this.aJO.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final <T extends View> T findViewById(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    @Nullable
    @UiThread
    public final Activity getActivity() {
        return C10887l.m24559dn(getContext());
    }

    @NonNull
    public final Context getContext() {
        return this.mRootView.getContext();
    }

    public final View getRootView() {
        return this.mRootView;
    }

    @UiThread
    /* renamed from: k */
    public final void m24605k(@NonNull Object obj) {
        try {
            PresenterState presenterState = this.aJO;
            if (presenterState != PresenterState.INIT) {
                PresenterState presenterState2 = PresenterState.DESTROY;
            }
            PresenterState presenterState3 = PresenterState.BIND;
            if (presenterState == presenterState3) {
                m24604lW();
            }
            this.aJO = presenterState3;
            this.aJN = obj;
            mo24610aj();
            this.aJO.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @UiThread
    /* renamed from: lW */
    public final void m24604lW() {
        try {
            this.aJO = PresenterState.UNBIND;
            onUnbind();
            this.aJO.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onUnbind() {
    }

    /* renamed from: a */
    public final void m24611a(Presenter presenter, boolean z) {
        this.aJM.add(presenter);
        try {
            m24609b(presenter);
        } catch (Throwable th) {
            C10974c.gatherException(th);
            C10331c.printStackTrace(th);
        }
    }
}
