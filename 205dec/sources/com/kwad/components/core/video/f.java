package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.br;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@SuppressLint({"ViewConstructor"})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f extends com.kwad.components.core.video.a implements br.a {
    private boolean Em;
    private View UI;
    private final AtomicBoolean UJ;
    private boolean UM;
    private boolean UN;
    private final br hh;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a extends a.c {
        void onVideoPlayError(int i4, int i5);
    }

    public f(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, adTemplate, cVar);
        this.hh = new br(this);
        this.UJ = new AtomicBoolean(true);
        this.Em = false;
        this.UM = false;
        this.UN = false;
        this.UI = this;
    }

    private void ac() {
        if (this.UJ.getAndSet(false)) {
            com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onViewAttached");
            this.hh.sendEmptyMessage(1);
        }
    }

    private void ad() {
        if (this.UJ.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onViewDetached");
        this.hh.removeCallbacksAndMessages(null);
        release();
    }

    private void rN() {
        this.Em = false;
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (!this.Em && message.what == 1) {
            if (this.UN) {
                this.hh.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            if (bq.o(this.UI, 70)) {
                rn();
            } else {
                rp();
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.video.a
    public final void ex() {
        if (this.UM) {
            super.ex();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onAttachedToWindow");
        rN();
        ac();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onDetachedFromWindow");
        ad();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
        ac();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.e.c.i("InterstitialVideoPlayerController", "onStartTemporaryDetach");
        ad();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
    }

    @Override // com.kwad.components.core.video.a
    public final void release() {
        super.release();
        this.Em = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.video.a
    public final void rh() {
        super.rh();
        ImageView imageView = this.mS;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ksad_interstitial_video_play);
        }
        TextView textView = this.mT;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void rn() {
        super.rn();
    }

    @Override // com.kwad.components.core.video.a
    public final void rp() {
        super.rp();
    }

    public final void setShowLandingPage(boolean z3) {
        this.UN = z3;
    }
}
