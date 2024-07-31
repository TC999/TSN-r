package com.kwad.components.p208ad.splashscreen.p284f;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.p208ad.splashscreen.C8474d;
import com.kwad.components.p208ad.splashscreen.InterfaceC8477e;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;

/* renamed from: com.kwad.components.ad.splashscreen.f.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8484b implements InterfaceC11145c {

    /* renamed from: Dt */
    private AbstractC8483a f27858Dt;

    /* renamed from: Fq */
    private ViewStub f27859Fq;

    /* renamed from: Fr */
    private ViewGroup f27860Fr;

    /* renamed from: Fs */
    private View f27861Fs;

    /* renamed from: Ft */
    private TextView f27862Ft;

    /* renamed from: Fu */
    private boolean f27863Fu;
    @Nullable

    /* renamed from: Fv */
    private InterfaceC8477e f27864Fv;

    /* renamed from: Fw */
    private GestureDetector$OnGestureListenerC11148f f27865Fw;
    @NonNull

    /* renamed from: gS */
    private ViewGroup f27866gS;
    @Nullable
    private AdInfo mAdInfo;
    @Nullable
    private AdTemplate mAdTemplate;
    private C8619c mApkDownloadHelper;

    public C8484b(@NonNull ViewGroup viewGroup, ViewStub viewStub, boolean z, C8619c c8619c) {
        this.f27866gS = viewGroup;
        this.f27859Fq = viewStub;
        this.mApkDownloadHelper = c8619c;
        this.f27863Fu = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public void m30641V(String str) {
        TextView textView = this.f27862Ft;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    /* renamed from: g */
    private void m30636g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.f27861Fs = viewGroup.findViewById(C9659R.C9662id.ksad_splash_actionbar_native);
        this.f27862Ft = (TextView) viewGroup.findViewById(C9659R.C9662id.ksad_splash_actionbar_text);
        this.f27865Fw = new GestureDetector$OnGestureListenerC11148f(this.f27861Fs.getContext(), this.f27861Fs, this);
        m30640a(C8474d.m30657a(this.mAdTemplate, this.mAdInfo, this.mApkDownloadHelper, 4));
    }

    /* renamed from: i */
    private void m30635i(boolean z, boolean z2) {
        InterfaceC8477e interfaceC8477e = this.f27864Fv;
        if (interfaceC8477e != null) {
            interfaceC8477e.mo30651h(z, z2);
        }
    }

    /* renamed from: ah */
    public final void m30637ah(AdTemplate adTemplate) {
        AbstractC8483a abstractC8483a;
        this.mAdTemplate = adTemplate;
        AbstractC8483a abstractC8483a2 = this.f27858Dt;
        if (abstractC8483a2 == null) {
            this.f27858Dt = new AbstractC8483a(this.f27866gS.getContext(), this.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.f.b.1
                {
                    super(r3);
                }

                @Override // com.kwad.components.p208ad.splashscreen.p284f.AbstractC8483a
                /* renamed from: k */
                protected final void mo30633k(int i, String str) {
                    C8484b.this.m30641V(str);
                }
            };
        } else {
            abstractC8483a2.setAdTemplate(adTemplate);
        }
        if (adTemplate != null) {
            this.mAdInfo = C10487e.m25641dQ(adTemplate);
        }
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c == null || (abstractC8483a = this.f27858Dt) == null) {
            return;
        }
        c8619c.m30151b(abstractC8483a);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (this.f27863Fu) {
            m30635i(false, view.equals(this.f27861Fs));
        }
    }

    /* renamed from: lw */
    public final void m30634lw() {
        C10331c.m26254d("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.f27859Fq);
        if (this.f27860Fr == null) {
            ViewStub viewStub = this.f27859Fq;
            if (viewStub != null && viewStub.getParent() != null) {
                this.f27860Fr = (ViewGroup) this.f27859Fq.inflate();
            } else {
                this.f27860Fr = (ViewGroup) this.f27866gS.findViewById(C9659R.C9662id.ksad_splash_actionbar_native_root);
            }
            m30636g(this.f27860Fr);
        }
        ViewGroup viewGroup = this.f27860Fr;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public final void onUnbind() {
        AbstractC8483a abstractC8483a;
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c == null || (abstractC8483a = this.f27858Dt) == null) {
            return;
        }
        c8619c.m30148c(abstractC8483a);
    }

    /* renamed from: a */
    public final void m30639a(@Nullable InterfaceC8477e interfaceC8477e) {
        this.f27864Fv = interfaceC8477e;
    }

    /* renamed from: a */
    private void m30640a(C8474d c8474d) {
        if (c8474d == null) {
            return;
        }
        m30641V(c8474d.m30656ku());
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        m30635i(true, view.equals(this.f27861Fs));
    }
}
