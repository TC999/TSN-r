package com.kwad.components.core.page.c.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bn;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends a {
    private View OZ;
    private TextView Pa;
    private int Pb;
    private Runnable Pc = new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1
        @Override // java.lang.Runnable
        public final void run() {
            if (com.kwad.components.core.q.a.qH().qK()) {
                bn.runOnUiThreadDelay(this, 500L);
            } else if (d.this.Pb > 0) {
                d.this.Pa.setText(String.format("\u5012\u8ba1\u65f6%d\u79d2", Integer.valueOf(d.this.Pb)));
                d.c(d.this);
                com.kwad.components.core.q.a.qH().aJ(d.this.Pb);
                bn.runOnUiThreadDelay(this, 1000L);
            } else {
                d.this.Pa.setText("\u5df2\u83b7\u5f97\u6743\u76ca");
                bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.OZ.setVisibility(8);
                    }
                }, 500L);
                com.kwad.components.core.q.a.qH().aK(true);
            }
        }
    };

    static /* synthetic */ int c(d dVar) {
        int i4 = dVar.Pb;
        dVar.Pb = i4 - 1;
        return i4;
    }

    private void pz() {
        TextView textView;
        if (this.OZ == null || (textView = this.Pa) == null) {
            return;
        }
        textView.setText(String.format("\u5012\u8ba1\u65f6%d\u79d2", Integer.valueOf(this.Pb)));
        this.OZ.setVisibility(0);
        bn.runOnUiThreadDelay(this.Pc, 1000L);
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Pb = com.kwad.sdk.core.response.b.a.aM(com.kwad.sdk.core.response.b.e.dQ(this.OH.mAdTemplate));
        com.kwad.components.core.q.a.qH().aJ(this.Pb);
        pz();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.OZ = findViewById(R.id.ksad_web_reward_task_layout);
        this.Pa = (TextView) findViewById(R.id.ksad_web_reward_task_text);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        bn.c(this.Pc);
    }
}
