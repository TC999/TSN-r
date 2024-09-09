package com.kwad.components.ad.splashscreen.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class g extends e {
    private static void j(View view, int i4) {
        if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = i4;
            view.setLayoutParams(layoutParams);
        } else if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.topMargin = i4;
            view.setLayoutParams(layoutParams2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.kwad.components.ad.splashscreen.presenter.g$1, java.lang.Runnable] */
    private void lf() {
        bo.postOnUiThread(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.g.1
            public final void doTask() {
                if (g.this.getActivity() != null) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) g.this.getActivity().getWindow().getDecorView();
                        if (com.kwad.sdk.c.a.a.C(viewGroup) && com.kwad.sdk.c.a.a.aV(g.this.getActivity()) == viewGroup.getHeight()) {
                            g.this.lg();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lg() {
        int i4;
        if (getContext() == null) {
            return;
        }
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate);
        if (com.kwad.components.ad.splashscreen.e.c.z(dS)) {
            i4 = R.id.ksad_preload_right_container;
        } else {
            i4 = R.id.ksad_preload_left_container;
        }
        j(findViewById(i4), x(dS));
        if (com.kwad.components.ad.splashscreen.e.c.z(dS)) {
            j(findViewById(R.id.ksad_splash_logo_container), com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.c.a.a.a(getContext(), 12.0f));
            j(findViewById(R.id.ksad_splash_sound), com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.c.a.a.a(getContext(), 32.0f));
            j(findViewById(R.id.ksad_skip_view_area), com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity()));
        }
    }

    private int x(AdInfo adInfo) {
        int a4;
        int statusBarHeight;
        if (com.kwad.components.ad.splashscreen.e.c.z(adInfo)) {
            a4 = com.kwad.sdk.c.a.a.a(getActivity(), 32.0f);
            statusBarHeight = com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity());
        } else {
            a4 = com.kwad.sdk.c.a.a.a(getActivity(), 16.0f);
            statusBarHeight = com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity());
        }
        return a4 + statusBarHeight;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        lf();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
