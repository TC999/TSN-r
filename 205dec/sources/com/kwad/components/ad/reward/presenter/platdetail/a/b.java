package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ay;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private l gO = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.b.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j4, long j5) {
            b.this.g(j5);
        }
    };
    private TextView hl;
    private long hn;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    private void ca() {
        this.mApkDownloadHelper = this.qo.mApkDownloadHelper;
        this.hn = com.kwad.sdk.core.response.b.d.dC(this.mAdTemplate);
        this.qo.oJ.a(this.gO);
    }

    private void cb() {
        if (this.hl.getVisibility() == 0) {
            return;
        }
        this.hl.setText(com.kwad.sdk.core.response.b.d.dD(this.mAdTemplate));
        this.hl.setVisibility(0);
        this.hl.setOnClickListener(this);
        this.hl.post(new ay() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.b.2
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.this.cc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc() {
        this.qo.x("native_id");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j4) {
        if (j4 >= this.hn) {
            cb();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.hl) {
            this.qo.a(1, view.getContext(), 40, 1, this.qo.oJ.getPlayDuration());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        TextView textView = (TextView) findViewById(R.id.ksad_detail_call_btn);
        this.hl = textView;
        textView.setContentDescription("topBarCallLabel");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qo.oJ.b(this.gO);
        this.hl.setVisibility(8);
    }
}
