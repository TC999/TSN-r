package com.kwad.components.core.page.p321c.p322a;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.p326q.C8898a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.core.page.c.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8808d extends AbstractC8803a {

    /* renamed from: OZ */
    private View f28569OZ;

    /* renamed from: Pa */
    private TextView f28570Pa;

    /* renamed from: Pb */
    private int f28571Pb;

    /* renamed from: Pc */
    private Runnable f28572Pc = new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1
        @Override // java.lang.Runnable
        public final void run() {
            if (C8898a.m29651qH().m29648qK()) {
                C11064bn.runOnUiThreadDelay(this, 500L);
            } else if (C8808d.this.f28571Pb > 0) {
                C8808d.this.f28570Pa.setText(String.format("倒计时%d秒", Integer.valueOf(C8808d.this.f28571Pb)));
                C8808d.m29807c(C8808d.this);
                C8898a.m29651qH().m29655aJ(C8808d.this.f28571Pb);
                C11064bn.runOnUiThreadDelay(this, 1000L);
            } else {
                C8808d.this.f28570Pa.setText("已获得权益");
                C11064bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C8808d.this.f28569OZ.setVisibility(8);
                    }
                }, 500L);
                C8898a.m29651qH().m29654aK(true);
            }
        }
    };

    /* renamed from: c */
    static /* synthetic */ int m29807c(C8808d c8808d) {
        int i = c8808d.f28571Pb;
        c8808d.f28571Pb = i - 1;
        return i;
    }

    /* renamed from: pz */
    private void m29805pz() {
        TextView textView;
        if (this.f28569OZ == null || (textView = this.f28570Pa) == null) {
            return;
        }
        textView.setText(String.format("倒计时%d秒", Integer.valueOf(this.f28571Pb)));
        this.f28569OZ.setVisibility(0);
        C11064bn.runOnUiThreadDelay(this.f28572Pc, 1000L);
    }

    @Override // com.kwad.components.core.page.p321c.p322a.AbstractC8803a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f28571Pb = C10483a.m25949aM(C10487e.m25641dQ(this.f28548OH.mAdTemplate));
        C8898a.m29651qH().m29655aJ(this.f28571Pb);
        m29805pz();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f28569OZ = findViewById(C9659R.C9662id.ksad_web_reward_task_layout);
        this.f28570Pa = (TextView) findViewById(C9659R.C9662id.ksad_web_reward_task_text);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C11064bn.m23858c(this.f28572Pc);
    }
}
