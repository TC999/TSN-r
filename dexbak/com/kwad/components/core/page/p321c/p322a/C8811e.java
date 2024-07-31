package com.kwad.components.core.page.p321c.p322a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.KsAdWebView;

/* renamed from: com.kwad.components.core.page.c.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8811e extends AbstractC8803a {

    /* renamed from: Oa */
    private LinearLayout f28575Oa;

    /* renamed from: Ob */
    private TextView f28576Ob;

    /* renamed from: Oc */
    private ImageView f28577Oc;

    /* renamed from: pA */
    private void m29803pA() {
        this.f28575Oa = (LinearLayout) findViewById(C9659R.C9662id.ksad_web_tip_bar);
        if (!TextUtils.isEmpty(this.f28548OH.mPageTitle)) {
            this.f28575Oa.setVisibility(8);
            return;
        }
        this.f28576Ob = (TextView) findViewById(C9659R.C9662id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) findViewById(C9659R.C9662id.ksad_web_tip_close_btn);
        this.f28577Oc = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C8811e.this.f28575Oa.setVisibility(8);
            }
        });
        AdInfo m25641dQ = C10487e.m25641dQ(this.f28548OH.mAdTemplate);
        boolean m25857bw = C10483a.m25857bw(m25641dQ);
        String m25861bs = C10483a.m25861bs(m25641dQ);
        if (m25857bw) {
            this.f28575Oa.setVisibility(0);
            this.f28576Ob.setText(m25861bs);
            this.f28576Ob.setSelected(true);
        } else {
            this.f28575Oa.setVisibility(8);
        }
        this.f28548OH.m29829a(m29802pB());
    }

    @NonNull
    /* renamed from: pB */
    private KsAdWebView.InterfaceC10598c m29802pB() {
        return new KsAdWebView.InterfaceC10598c() { // from class: com.kwad.components.core.page.c.a.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10598c
            /* renamed from: pC */
            public final void mo25352pC() {
                if (C8811e.this.f28548OH.m29827pi() && C8811e.this.f28575Oa.getVisibility() == 0) {
                    C8811e.this.f28575Oa.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.p321c.p322a.AbstractC8803a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        m29803pA();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
