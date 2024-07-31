package com.kwad.components.p208ad.reward;

import androidx.annotation.NonNull;
import com.kwad.components.core.request.C8916e;
import com.kwad.components.p208ad.reward.check.C7871a;
import com.kwad.components.p208ad.reward.model.RewardCallBackRespInfo;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7996l {
    /* renamed from: a */
    public static void m31898a(final int i, final C7907g c7907g) {
        AbstractC10436l<C8916e, RewardCallBackRespInfo> abstractC10436l = new AbstractC10436l<C8916e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.l.1
            @NonNull
            /* renamed from: C */
            private static RewardCallBackRespInfo m31893C(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            /* renamed from: gl */
            public C8916e createRequest() {
                return new C8916e(i, c7907g.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            @NonNull
            public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
                return m31893C(str);
            }
        };
        if (i == 1) {
            abstractC10436l.request(m31896i(c7907g));
        } else if (i == 2) {
            abstractC10436l.request(m31895j(c7907g));
        }
    }

    /* renamed from: i */
    private static AbstractC10439o<C8916e, RewardCallBackRespInfo> m31896i(final C7907g c7907g) {
        return new AbstractC10439o<C8916e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.l.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onStartRequest(@NonNull C8916e c8916e) {
                c8916e.f28800Rr = System.currentTimeMillis();
                C7871a.m32121b(C7907g.this.mAdTemplate, 1);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onSuccess(@NonNull C8916e c8916e, @NonNull final RewardCallBackRespInfo rewardCallBackRespInfo) {
                C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.l.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C7907g.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
                    }
                });
                C7871a.m32122a(C7907g.this.mAdTemplate, 1, System.currentTimeMillis() - c8916e.f28800Rr, rewardCallBackRespInfo.result, rewardCallBackRespInfo.errorMsg);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onError(@NonNull C8916e c8916e, int i, String str) {
                super.onError(c8916e, i, str);
                C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.l.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        C7907g.this.mCheckExposureResult = false;
                    }
                });
                C7871a.m32122a(C7907g.this.mAdTemplate, 1, System.currentTimeMillis() - c8916e.f28800Rr, i, str);
            }
        };
    }

    /* renamed from: j */
    private static AbstractC10439o<C8916e, RewardCallBackRespInfo> m31895j(final C7907g c7907g) {
        return new AbstractC10439o<C8916e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.l.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onStartRequest(@NonNull C8916e c8916e) {
                c8916e.f28800Rr = System.currentTimeMillis();
                C7871a.m32121b(C7907g.this.mAdTemplate, 2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onSuccess(@NonNull C8916e c8916e, @NonNull final RewardCallBackRespInfo rewardCallBackRespInfo) {
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.l.3.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        if (rewardCallBackRespInfo.result == 1) {
                            C7907g.this.f26558pg = 1;
                        } else {
                            C7907g.this.f26558pg = 2;
                        }
                        C7907g.this.f26528oI.onRewardVerify();
                    }
                });
                C7871a.m32122a(C7907g.this.mAdTemplate, 2, System.currentTimeMillis() - c8916e.f28800Rr, rewardCallBackRespInfo.result, rewardCallBackRespInfo.errorMsg);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onError(@NonNull C8916e c8916e, int i, String str) {
                super.onError(c8916e, i, str);
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.l.3.2
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C7907g.this.f26558pg = 2;
                    }
                });
                C7871a.m32122a(C7907g.this.mAdTemplate, 2, System.currentTimeMillis() - c8916e.f28800Rr, i, str);
            }
        };
    }

    /* renamed from: k */
    private static boolean m31894k(C7907g c7907g) {
        return !c7907g.f26559ph && C10483a.m25799da(C10487e.m25641dQ(c7907g.mAdTemplate));
    }

    /* renamed from: a */
    public static void m31897a(C7907g c7907g, long j, long j2, long j3) {
        boolean m31894k = m31894k(c7907g);
        long m25829cY = m31894k ? C10483a.m25829cY(C10487e.m25641dQ(c7907g.mAdTemplate)) : 0L;
        if (c7907g.f26559ph || !m31894k || !c7907g.mCheckExposureResult || j <= ((j2 - 800) - j3) - m25829cY || m25829cY <= 0) {
            return;
        }
        if (C10483a.m25828cZ(C10487e.m25641dQ(c7907g.mAdTemplate))) {
            c7907g.f26558pg = 1;
            m31898a(2, c7907g);
        } else {
            c7907g.f26528oI.onRewardVerify();
        }
        c7907g.f26559ph = true;
    }
}
