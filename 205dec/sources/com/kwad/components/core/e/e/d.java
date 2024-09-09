package com.kwad.components.core.e.e;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends b implements View.OnClickListener {
    private TextView Lr;
    private TextView Ls;
    private TextView qO;

    @Override // com.kwad.components.core.e.e.b, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void aj() {
        super.aj();
        if (this.Lq.Lp.nB() == 1) {
            TextView textView = this.qO;
            textView.setText("\u5373\u5c06\u6253\u5f00" + com.kwad.sdk.core.response.b.a.cd(this.mAdInfo));
        } else if (this.Lq.Lp.nB() == 2) {
            this.qO.setText("\u5373\u5c06\u6253\u5f00\u7b2c\u4e09\u65b9\u9875\u9762");
        }
        com.kwad.sdk.d.a.a.a(this, this.Lr, this.Ls);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.Lq.Lp.ak(true);
        this.Lq.Ln.dismiss();
        if (view == this.Lr) {
            com.kwad.components.core.e.d.a.a(this.Lq.Lp);
            com.kwad.sdk.core.adlog.c.p(this.Lq.Lp.getAdTemplate(), MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT);
        } else if (view == this.Ls) {
            com.kwad.sdk.core.adlog.c.p(this.Lq.Lp.getAdTemplate(), MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.qO = (TextView) findViewById(R.id.ksad_second_confirm_content_view);
        this.Lr = (TextView) findViewById(R.id.ksad_second_confirm_ensure);
        this.Ls = (TextView) findViewById(R.id.ksad_second_confirm_cancle);
    }
}
