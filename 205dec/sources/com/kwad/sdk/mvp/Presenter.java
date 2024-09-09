package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.c;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class Presenter {
    private Object aJN;
    private View mRootView;
    private final List<Presenter> aJM = new CopyOnWriteArrayList();
    private PresenterState aJO = PresenterState.INIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
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
                        presenter2.G(presenter.mRootView);
                    } catch (Exception e4) {
                        c.gatherException(e4);
                        com.kwad.sdk.core.e.c.printStackTrace(e4);
                    }
                }
            }
        },
        BIND(2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.aJM) {
                    try {
                        presenter2.k(presenter.aJN);
                    } catch (Throwable th) {
                        c.gatherException(th);
                        com.kwad.sdk.core.e.c.printStackTrace(th);
                    }
                }
            }
        },
        UNBIND(3) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
            @Override // com.kwad.sdk.mvp.Presenter.PresenterState
            final void performCallState(Presenter presenter) {
                for (Presenter presenter2 : presenter.aJM) {
                    try {
                        presenter2.lW();
                    } catch (Exception e4) {
                        c.gatherException(e4);
                        com.kwad.sdk.core.e.c.printStackTrace(e4);
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
                    } catch (Exception e4) {
                        c.gatherException(e4);
                        com.kwad.sdk.core.e.c.printStackTrace(e4);
                    }
                }
            }
        };
        
        private int mIndex;

        public int index() {
            return this.mIndex;
        }

        abstract void performCallState(Presenter presenter);

        PresenterState(int i4) {
            this.mIndex = i4;
        }
    }

    private boolean Jv() {
        return this.aJO.index() >= PresenterState.CREATE.index();
    }

    private void b(Presenter presenter) {
        Object obj;
        View view;
        int index = this.aJO.index();
        PresenterState presenterState = PresenterState.UNBIND;
        if (index >= presenterState.index() || presenter.aJO.index() >= presenterState.index()) {
            return;
        }
        if (Jv() && !presenter.Jv() && (view = this.mRootView) != null) {
            presenter.G(view);
        }
        if (!isBound() || !presenter.Jv() || presenter.isBound() || (obj = this.aJN) == null) {
            return;
        }
        presenter.k(obj);
    }

    private boolean isBound() {
        return this.aJO == PresenterState.BIND;
    }

    @UiThread
    public final void G(View view) {
        try {
            this.aJO = PresenterState.CREATE;
            this.mRootView = view;
            onCreate();
            this.aJO.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final List<Presenter> Jw() {
        return this.aJM;
    }

    public final Object Jx() {
        return this.aJN;
    }

    public final void a(Presenter presenter) {
        this.aJM.add(presenter);
        if (!Jv() || presenter.Jv()) {
            return;
        }
        G(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aj() {
    }

    @UiThread
    public final void destroy() {
        try {
            if (this.aJO == PresenterState.BIND) {
                lW();
            }
            this.aJO = PresenterState.DESTROY;
            onDestroy();
            this.aJO.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final <T extends View> T findViewById(int i4) {
        return (T) this.mRootView.findViewById(i4);
    }

    @Nullable
    @UiThread
    public final Activity getActivity() {
        return l.dn(getContext());
    }

    @NonNull
    public final Context getContext() {
        return this.mRootView.getContext();
    }

    public final View getRootView() {
        return this.mRootView;
    }

    @UiThread
    public final void k(@NonNull Object obj) {
        try {
            PresenterState presenterState = this.aJO;
            if (presenterState != PresenterState.INIT) {
                PresenterState presenterState2 = PresenterState.DESTROY;
            }
            PresenterState presenterState3 = PresenterState.BIND;
            if (presenterState == presenterState3) {
                lW();
            }
            this.aJO = presenterState3;
            this.aJN = obj;
            aj();
            this.aJO.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @UiThread
    public final void lW() {
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

    public final void a(Presenter presenter, boolean z3) {
        this.aJM.add(presenter);
        try {
            b(presenter);
        } catch (Throwable th) {
            c.gatherException(th);
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }
}
