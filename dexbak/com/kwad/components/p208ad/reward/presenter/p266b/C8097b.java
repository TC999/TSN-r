package com.kwad.components.p208ad.reward.presenter.p266b;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.liveEnd.C8693a;
import com.kwad.components.core.p304n.p305a.p306a.InterfaceC8695a;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.p208ad.reward.model.AdLiveEndResultData;
import com.kwad.components.p208ad.reward.p257j.C7955b;
import com.kwad.components.p208ad.reward.p264n.C8074r;
import com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8072p;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.presenter.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8097b extends C8094b {

    /* renamed from: ga */
    private IAdLiveEndRequest f26960ga;

    /* renamed from: hj */
    private long f26961hj;
    @Nullable

    /* renamed from: pi */
    private View$OnClickListenerC8072p f26962pi;
    @Nullable

    /* renamed from: tP */
    private View f26964tP;
    private final AbstractC10436l<C8693a, AdLiveEndResultData> mNetworking = new AbstractC10436l<C8693a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.1
        @NonNull
        /* renamed from: P */
        private static AdLiveEndResultData m31587P(String str) {
            AdLiveEndResultData adLiveEndResultData = new AdLiveEndResultData();
            adLiveEndResultData.parseJson(new JSONObject(str));
            return adLiveEndResultData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.AbstractC10402a
        @NonNull
        /* renamed from: bC */
        public C8693a createRequest() {
            return new C8693a(C8097b.this.f26960ga);
        }

        @Override // com.kwad.sdk.core.network.AbstractC10436l
        public final boolean isPostByJson() {
            return false;
        }

        @Override // com.kwad.sdk.core.network.AbstractC10436l
        @NonNull
        public final /* synthetic */ AdLiveEndResultData parseData(String str) {
            return m31587P(str);
        }
    };

    /* renamed from: sv */
    private final C9002l f26963sv = new C9002l() { // from class: com.kwad.components.ad.reward.presenter.b.b.2
        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8996g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            C8097b.this.m31595hO();
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8996g
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            C8097b.this.m31594hP();
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            C8097b.this.f26961hj = j2;
        }

        @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            C8097b.this.m31594hP();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hO */
    public void m31595hO() {
        if (this.f26960ga == null) {
            return;
        }
        this.mNetworking.request(new AbstractC10439o<C8693a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onStartRequest(@NonNull C8693a c8693a) {
                super.onStartRequest(c8693a);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onSuccess(@NonNull C8693a c8693a, @NonNull final AdLiveEndResultData adLiveEndResultData) {
                super.onSuccess(c8693a, adLiveEndResultData);
                if (adLiveEndResultData.mQLivePushEndInfo == null) {
                    return;
                }
                C8097b.this.f26957qo.mRootContainer.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.b.b.3.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        if (C8097b.this.f26962pi == null) {
                            C8097b c8097b = C8097b.this;
                            c8097b.f26962pi = new View$OnClickListenerC8072p(c8097b.f26957qo);
                        }
                        C8097b.this.f26962pi.m31649h(C8097b.this.f26957qo.mRootContainer);
                        C8097b.this.f26962pi.m31726b(C8074r.m31647R(C8097b.this.f26957qo.mAdTemplate));
                        C8097b.this.f26962pi.m31652a(C8097b.this.f26957qo, adLiveEndResultData.mQLivePushEndInfo, C8097b.this.f26961hj);
                        C8097b.this.f26957qo.f26560pi = C8097b.this.f26962pi;
                        C8097b c8097b2 = C8097b.this;
                        c8097b2.f26964tP = c8097b2.findViewById(C9659R.C9662id.ksad_live_end_page_layout_root);
                        C8097b.this.f26964tP.setVisibility(0);
                        C8097b.this.m31593hx();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onError(@NonNull C8693a c8693a, int i, String str) {
                super.onError(c8693a, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hP */
    public void m31594hP() {
        View view = this.f26964tP;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hx */
    public void m31593hx() {
        C9913b c9913b = new C9913b();
        C9893a.C9894a c9894a = new C9893a.C9894a();
        c9913b.m27257cT(24);
        c9913b.m27268b(c9894a);
        C7955b.m31926a(true, this.f26957qo.mAdTemplate, null, c9913b);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        InterfaceC8695a interfaceC8695a;
        super.mo24610aj();
        if (this.f26957qo.f26529oJ.m31821jM()) {
            this.f26957qo.f26529oJ.m31828a(this.f26963sv);
            String m25873bg = C10483a.m25873bg(C10487e.m25641dQ(this.f26957qo.mAdTemplate));
            if (TextUtils.isEmpty(m25873bg) || (interfaceC8695a = (InterfaceC8695a) C9861c.m27501f(InterfaceC8695a.class)) == null) {
                return;
            }
            this.f26960ga = interfaceC8695a.getAdLiveEndRequest(m25873bg);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mNetworking.cancel();
        if (this.f26957qo.f26529oJ.m31821jM()) {
            this.f26957qo.f26529oJ.m31826b(this.f26963sv);
        }
    }
}
