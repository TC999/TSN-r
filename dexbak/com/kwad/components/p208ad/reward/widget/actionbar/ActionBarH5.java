package com.kwad.components.p208ad.reward.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;

/* renamed from: com.kwad.components.ad.reward.widget.actionbar.ActionBarH5 */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ActionBarH5 extends FrameLayout implements InterfaceC11145c {

    /* renamed from: BA */
    private View f27562BA;

    /* renamed from: By */
    private TextView f27563By;

    /* renamed from: Bz */
    private InterfaceC8339a f27564Bz;

    /* renamed from: dM */
    private TextView f27565dM;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.reward.widget.actionbar.ActionBarH5$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8339a {
        /* renamed from: N */
        void mo30940N(boolean z);
    }

    public ActionBarH5(Context context) {
        super(context);
        m30944B(context);
    }

    /* renamed from: B */
    private void m30944B(Context context) {
        C10887l.inflate(context, C9659R.C9663layout.ksad_video_actionbar_h5, this);
        this.f27563By = (TextView) findViewById(C9659R.C9662id.ksad_h5_ad_desc);
        this.f27565dM = (TextView) findViewById(C9659R.C9662id.ksad_h5_open_btn);
        this.f27562BA = findViewById(C9659R.C9662id.ksad_download_bar_cover);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.mAdTemplate)) {
            m30941b(view, false);
        }
    }

    /* renamed from: a */
    public final void m30942a(@NonNull AdTemplate adTemplate, InterfaceC8339a interfaceC8339a) {
        this.mAdTemplate = adTemplate;
        this.f27564Bz = interfaceC8339a;
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.f27563By.setText(C10483a.m25915au(m25641dQ));
        this.f27565dM.setText(C10483a.m25957aE(m25641dQ));
        setClickable(true);
        this.f27562BA.setClickable(true);
        new GestureDetector$OnGestureListenerC11148f(this.f27562BA, this);
        new GestureDetector$OnGestureListenerC11148f(this, this);
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m30944B(context);
    }

    /* renamed from: b */
    private void m30941b(View view, final boolean z) {
        C8615a.m30233a(new C8615a.C8616a(view.getContext()).m30198aq(this.mAdTemplate).m30205an(view == this.f27562BA ? 1 : 2).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.1
            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
            public final void onAdClicked() {
                if (ActionBarH5.this.f27564Bz != null) {
                    ActionBarH5.this.f27564Bz.mo30940N(z);
                }
            }
        }));
    }

    public ActionBarH5(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30944B(context);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        m30941b(view, true);
    }
}
