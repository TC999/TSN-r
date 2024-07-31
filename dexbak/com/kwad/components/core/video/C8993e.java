package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.p331a.AbstractC8971a;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.video.videoview.InterfaceC10547c;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11067bq;
import com.kwad.sdk.utils.HandlerC11068br;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.kwad.components.core.video.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8993e extends View$OnClickListenerC8966a implements HandlerC11068br.InterfaceC11069a {

    /* renamed from: UI */
    private View f28996UI;

    /* renamed from: UJ */
    private final AtomicBoolean f28997UJ;

    /* renamed from: UK */
    private boolean f28998UK;

    /* renamed from: UL */
    private boolean f28999UL;

    /* renamed from: dU */
    private final KsAdVideoPlayConfig f29000dU;

    /* renamed from: hh */
    private final HandlerC11068br f29001hh;

    public C8993e(Context context, AdTemplate adTemplate, @NonNull InterfaceC10547c interfaceC10547c, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context, adTemplate, interfaceC10547c);
        this.f29001hh = new HandlerC11068br(this);
        this.f28997UJ = new AtomicBoolean(true);
        this.f28999UL = true;
        this.f28996UI = this;
        this.f29000dU = ksAdVideoPlayConfig;
    }

    /* renamed from: ac */
    private void m29432ac() {
        if (this.f28997UJ.getAndSet(false)) {
            C10331c.m26248i("FeedVideoPlayerController", "onViewAttached");
            this.f29001hh.sendEmptyMessage(1);
        }
    }

    /* renamed from: rJ */
    private boolean m29429rJ() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.f29000dU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return C11013ag.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return C11013ag.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                if (kSAdVideoPlayConfigImpl.isDataFlowAutoStart()) {
                    return C11013ag.isNetworkConnected(this.mContext);
                }
                return C11013ag.isWifiConnected(this.mContext);
            }
        }
        if (C10483a.m25887bU(this.mAdInfo)) {
            return C11013ag.isNetworkConnected(this.mContext);
        }
        if (C10483a.m25886bV(this.mAdInfo)) {
            return C11013ag.isWifiConnected(this.mContext);
        }
        return false;
    }

    @Override // com.kwad.sdk.utils.HandlerC11068br.InterfaceC11069a
    /* renamed from: a */
    public final void mo23849a(Message message) {
        if (!this.f28910Tu && message.what == 1) {
            if (C11067bq.m23850o(this.f28996UI, 30)) {
                if (!this.f28998UK) {
                    mo29420rn();
                }
            } else {
                mo29419rp();
            }
            this.f29001hh.sendEmptyMessageDelayed(1, 500L);
        }
    }

    /* renamed from: ad */
    public final void m29431ad() {
        if (this.f28997UJ.getAndSet(true)) {
            return;
        }
        C10331c.m26248i("FeedVideoPlayerController", "onViewDetached");
        this.f29001hh.removeCallbacksAndMessages(null);
        if (this.f28999UL) {
            release();
        } else {
            this.aBE.pause();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        C10331c.m26248i("FeedVideoPlayerController", "onAttachedToWindow");
        m29432ac();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C10331c.m26248i("FeedVideoPlayerController", "onDetachedFromWindow");
        m29431ad();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        C10331c.m26248i("FeedVideoPlayerController", "onFinishTemporaryDetach");
        m29432ac();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        C10331c.m26248i("FeedVideoPlayerController", "onStartTemporaryDetach");
        m29431ad();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    /* renamed from: rI */
    public final void m29430rI() {
        this.f29001hh.removeCallbacksAndMessages(null);
        if (this.f28999UL) {
            release();
        } else {
            this.aBE.pause();
        }
    }

    /* renamed from: rK */
    public final void m29428rK() {
        this.aBE.pause();
        this.f28998UK = true;
    }

    /* renamed from: rL */
    public final void m29427rL() {
        mo29420rn();
        this.f28998UK = false;
    }

    /* renamed from: rM */
    public final void m29426rM() {
        this.f28998UK = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.video.View$OnClickListenerC8966a
    /* renamed from: rn */
    public final void mo29420rn() {
        if (this.aBE.isIdle()) {
            AbstractC8971a abstractC8971a = this.f28906TI;
            if (abstractC8971a != null) {
                abstractC8971a.onStart();
            }
            if (!C11013ag.isNetworkConnected(this.mContext)) {
                m29503rj();
                return;
            }
            m29502rk();
            if (this.f28910Tu) {
                m29499ro();
                this.aBE.start();
            } else if (m29429rJ()) {
                m29499ro();
                this.aBE.start();
            } else if (this.f28908Ts) {
                m29499ro();
                this.aBE.start();
            } else {
                m29501rl();
            }
        } else if (this.aBE.isPaused() || this.aBE.mo25490Gj()) {
            m29499ro();
            this.aBE.restart();
        }
    }

    public final void setAutoRelease(boolean z) {
        this.f28999UL = z;
    }
}
