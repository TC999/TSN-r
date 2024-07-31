package com.kwad.components.p208ad.fullscreen.p229c.p230a;

import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.HandlerC11068br;

/* renamed from: com.kwad.components.ad.fullscreen.c.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7614a extends C8094b implements HandlerC11068br.InterfaceC11069a {

    /* renamed from: gO */
    private C9002l f25865gO = new C9002l() { // from class: com.kwad.components.ad.fullscreen.c.a.a.1
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8996g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (C7614a.this.f25869hi) {
                return;
            }
            C7614a.this.f25868hh.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            if (!C7614a.this.f26957qo.f26529oJ.m31821jM()) {
                C7614a.this.m32782a(j, j2);
                C7614a.this.f25870hj = j2;
            } else if (j2 > 800) {
                C7614a.this.f25870hj = j2;
                if (C7614a.this.f25870hj > j) {
                    C7614a.this.f25866hf.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) C7614a.this.f25867hg.getLayoutParams();
                    marginLayoutParams.leftMargin = C10751a.m24924a(C7614a.this.getContext(), 0.0f);
                    C7614a.this.f25867hg.setLayoutParams(marginLayoutParams);
                }
                C7614a.this.m32782a(j, j2);
                C7614a.m32778a(C7614a.this, true);
            }
        }
    };

    /* renamed from: hf */
    private TextView f25866hf;

    /* renamed from: hg */
    private View f25867hg;

    /* renamed from: hh */
    private HandlerC11068br f25868hh;

    /* renamed from: hi */
    private boolean f25869hi;

    /* renamed from: hj */
    private long f25870hj;
    private AdInfo mAdInfo;

    /* renamed from: ca */
    private void m32775ca() {
        AdInfo m25641dQ = C10487e.m25641dQ(this.f26957qo.mAdTemplate);
        this.mAdInfo = m25641dQ;
        this.f25866hf.setText(String.valueOf(C10483a.m25976L(m25641dQ)));
        this.f25866hf.setVisibility(0);
        this.f26957qo.f26529oJ.m31828a(this.f25865gO);
    }

    /* renamed from: x */
    private void m32770x(int i) {
        this.f25866hf.setText(String.valueOf(i));
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f25868hh = new HandlerC11068br(this);
        m32775ca();
        if (this.f26957qo.f26529oJ.m31821jM()) {
            m32770x(30);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25866hf = (TextView) findViewById(C9659R.C9662id.ksad_video_count_down);
        this.f25867hg = findViewById(C9659R.C9662id.ksad_video_sound_switch);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.f26529oJ.m31826b(this.f25865gO);
        this.f25869hi = false;
        this.f25868hh.removeCallbacksAndMessages(null);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m32778a(C7614a c7614a, boolean z) {
        c7614a.f25869hi = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m32782a(long j, long j2) {
        m32770x(Math.max((int) ((((float) (j - j2)) / 1000.0f) + 0.5f), 0));
    }

    @Override // com.kwad.sdk.utils.HandlerC11068br.InterfaceC11069a
    /* renamed from: a */
    public final void mo23849a(Message message) {
        if (message.what == 1) {
            if (!this.f26957qo.m32002fM() && !this.f26957qo.m32003fL()) {
                long j = this.f25870hj + 500;
                this.f25870hj = j;
                if (j > 30000) {
                    this.f25866hf.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f25867hg.getLayoutParams();
                    marginLayoutParams.leftMargin = C10751a.m24924a(getContext(), 0.0f);
                    this.f25867hg.setLayoutParams(marginLayoutParams);
                    return;
                }
                m32782a(30000L, j);
                this.f25868hh.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.f25868hh.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
