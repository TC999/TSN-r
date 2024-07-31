package com.kwad.components.p208ad.splashscreen.p278c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.kwad.components.p208ad.splashscreen.p284f.C8486c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.ad.splashscreen.c.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8423g extends C8421e {
    /* renamed from: j */
    private static void m30751j(View view, int i) {
        if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = i;
            view.setLayoutParams(layoutParams);
        } else if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.topMargin = i;
            view.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: le */
    private void m30750le() {
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.c.g.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (C8423g.this.getActivity() != null) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) C8423g.this.getActivity().getWindow().getDecorView();
                        if (C10751a.m24928C(viewGroup) && C10751a.m24920aI(C8423g.this.getActivity()) == viewGroup.getHeight()) {
                            C8423g.this.m30749lf();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lf */
    public void m30749lf() {
        if (getContext() == null) {
            return;
        }
        AdInfo m25641dQ = C10487e.m25641dQ(this.f27734Dg.mAdTemplate);
        m30751j(findViewById(C8486c.m30630z(m25641dQ) ? C9659R.C9662id.ksad_preload_right_container : C9659R.C9662id.ksad_preload_left_container), m30748x(m25641dQ));
        if (C8486c.m30630z(m25641dQ)) {
            m30751j(findViewById(C9659R.C9662id.ksad_splash_logo_container), C10751a.getStatusBarHeight(getActivity()) + C10751a.m24924a(getContext(), 12.0f));
            m30751j(findViewById(C9659R.C9662id.ksad_splash_sound), C10751a.getStatusBarHeight(getActivity()) + C10751a.m24924a(getContext(), 32.0f));
            m30751j(findViewById(C9659R.C9662id.ksad_skip_view_area), C10751a.getStatusBarHeight(getActivity()));
        }
    }

    /* renamed from: x */
    private int m30748x(AdInfo adInfo) {
        int m24924a;
        int statusBarHeight;
        if (C8486c.m30630z(adInfo)) {
            m24924a = C10751a.m24924a(getActivity(), 32.0f);
            statusBarHeight = C10751a.getStatusBarHeight(getActivity());
        } else {
            m24924a = C10751a.m24924a(getActivity(), 16.0f);
            statusBarHeight = C10751a.getStatusBarHeight(getActivity());
        }
        return m24924a + statusBarHeight;
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        m30750le();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
