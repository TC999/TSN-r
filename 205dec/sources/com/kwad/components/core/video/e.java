package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.br;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@SuppressLint({"ViewConstructor"})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e extends a implements br.a {
    private View UI;
    private final AtomicBoolean UJ;
    private boolean UK;
    private boolean UL;
    private final KsAdVideoPlayConfig dU;
    private final br hh;

    public e(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context, adTemplate, cVar);
        this.hh = new br(this);
        this.UJ = new AtomicBoolean(true);
        this.UL = true;
        this.UI = this;
        this.dU = ksAdVideoPlayConfig;
    }

    private void ac() {
        if (this.UJ.getAndSet(false)) {
            com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onViewAttached");
            this.hh.sendEmptyMessage(1);
        }
    }

    private boolean rJ() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return ag.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ag.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                if (kSAdVideoPlayConfigImpl.isDataFlowAutoStart()) {
                    return ag.isNetworkConnected(this.mContext);
                }
                return ag.isWifiConnected(this.mContext);
            }
        }
        if (com.kwad.sdk.core.response.b.a.bU(this.mAdInfo)) {
            return ag.isNetworkConnected(this.mContext);
        }
        if (com.kwad.sdk.core.response.b.a.bV(this.mAdInfo)) {
            return ag.isWifiConnected(this.mContext);
        }
        return false;
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        if (!this.Tu && message.what == 1) {
            if (bq.o(this.UI, 30)) {
                if (!this.UK) {
                    rn();
                }
            } else {
                rp();
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public final void ad() {
        if (this.UJ.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onViewDetached");
        this.hh.removeCallbacksAndMessages(null);
        if (this.UL) {
            release();
        } else {
            this.aBE.pause();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onAttachedToWindow");
        ac();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onDetachedFromWindow");
        ad();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onFinishTemporaryDetach");
        ac();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.e.c.i("FeedVideoPlayerController", "onStartTemporaryDetach");
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

    public final void rI() {
        this.hh.removeCallbacksAndMessages(null);
        if (this.UL) {
            release();
        } else {
            this.aBE.pause();
        }
    }

    public final void rK() {
        this.aBE.pause();
        this.UK = true;
    }

    public final void rL() {
        rn();
        this.UK = false;
    }

    public final void rM() {
        this.UK = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.video.a
    public final void rn() {
        if (this.aBE.isIdle()) {
            com.kwad.components.core.video.a.a aVar = this.TI;
            if (aVar != null) {
                aVar.onStart();
            }
            if (!ag.isNetworkConnected(this.mContext)) {
                rj();
                return;
            }
            rk();
            if (this.Tu) {
                ro();
                this.aBE.start();
            } else if (rJ()) {
                ro();
                this.aBE.start();
            } else if (this.Ts) {
                ro();
                this.aBE.start();
            } else {
                rl();
            }
        } else if (this.aBE.isPaused() || this.aBE.Gj()) {
            ro();
            this.aBE.restart();
        }
    }

    public final void setAutoRelease(boolean z3) {
        this.UL = z3;
    }
}
