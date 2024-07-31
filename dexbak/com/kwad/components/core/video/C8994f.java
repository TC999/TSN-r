package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.View$OnClickListenerC8966a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.InterfaceC10547c;
import com.kwad.sdk.utils.C11067bq;
import com.kwad.sdk.utils.HandlerC11068br;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.kwad.components.core.video.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8994f extends View$OnClickListenerC8966a implements HandlerC11068br.InterfaceC11069a {

    /* renamed from: Em */
    private boolean f29002Em;

    /* renamed from: UI */
    private View f29003UI;

    /* renamed from: UJ */
    private final AtomicBoolean f29004UJ;

    /* renamed from: UM */
    private boolean f29005UM;

    /* renamed from: UN */
    private boolean f29006UN;

    /* renamed from: hh */
    private final HandlerC11068br f29007hh;

    /* renamed from: com.kwad.components.core.video.f$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8995a extends View$OnClickListenerC8966a.InterfaceC8970c {
        void onVideoPlayError(int i, int i2);
    }

    public C8994f(Context context, AdTemplate adTemplate, @NonNull InterfaceC10547c interfaceC10547c) {
        super(context, adTemplate, interfaceC10547c);
        this.f29007hh = new HandlerC11068br(this);
        this.f29004UJ = new AtomicBoolean(true);
        this.f29002Em = false;
        this.f29005UM = false;
        this.f29006UN = false;
        this.f29003UI = this;
    }

    /* renamed from: ac */
    private void m29425ac() {
        if (this.f29004UJ.getAndSet(false)) {
            C10331c.m26248i("InterstitialVideoPlayerController", "onViewAttached");
            this.f29007hh.sendEmptyMessage(1);
        }
    }

    /* renamed from: ad */
    private void m29424ad() {
        if (this.f29004UJ.getAndSet(true)) {
            return;
        }
        C10331c.m26248i("InterstitialVideoPlayerController", "onViewDetached");
        this.f29007hh.removeCallbacksAndMessages(null);
        release();
    }

    /* renamed from: rN */
    private void m29422rN() {
        this.f29002Em = false;
    }

    @Override // com.kwad.sdk.utils.HandlerC11068br.InterfaceC11069a
    /* renamed from: a */
    public final void mo23849a(Message message) {
        if (!this.f29002Em && message.what == 1) {
            if (this.f29006UN) {
                this.f29007hh.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            if (C11067bq.m23850o(this.f29003UI, 70)) {
                mo29420rn();
            } else {
                mo29419rp();
            }
            this.f29007hh.sendEmptyMessageDelayed(1, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.video.View$OnClickListenerC8966a
    /* renamed from: ex */
    public final void mo29423ex() {
        if (this.f29005UM) {
            super.mo29423ex();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        C10331c.m26248i("InterstitialVideoPlayerController", "onAttachedToWindow");
        m29422rN();
        m29425ac();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C10331c.m26248i("InterstitialVideoPlayerController", "onDetachedFromWindow");
        m29424ad();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        C10331c.m26248i("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
        m29425ac();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        C10331c.m26248i("InterstitialVideoPlayerController", "onStartTemporaryDetach");
        m29424ad();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.kwad.components.core.video.View$OnClickListenerC8966a
    public final void release() {
        super.release();
        this.f29002Em = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.video.View$OnClickListenerC8966a
    /* renamed from: rh */
    public final void mo29421rh() {
        super.mo29421rh();
        ImageView imageView = this.f28916mS;
        if (imageView != null) {
            imageView.setImageResource(C9659R.C9661drawable.ksad_interstitial_video_play);
        }
        TextView textView = this.f28917mT;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.video.View$OnClickListenerC8966a
    /* renamed from: rn */
    public final void mo29420rn() {
        super.mo29420rn();
    }

    @Override // com.kwad.components.core.video.View$OnClickListenerC8966a
    /* renamed from: rp */
    public final void mo29419rp() {
        super.mo29419rp();
    }

    public final void setShowLandingPage(boolean z) {
        this.f29006UN = z;
    }
}
