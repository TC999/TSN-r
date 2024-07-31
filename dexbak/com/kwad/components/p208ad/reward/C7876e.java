package com.kwad.components.p208ad.reward;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7876e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7877a {

        /* renamed from: oF */
        private static C7876e f26498oF = new C7876e((byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.e$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7878b extends AbstractC10436l<C7896f, BaseResultData> {
        @NonNull
        private AdTemplate adTemplate;

        /* renamed from: oG */
        private AbstractC10439o<C7896f, BaseResultData> f26499oG = new AbstractC10439o<C7896f, BaseResultData>() { // from class: com.kwad.components.ad.reward.e.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onSuccess(@NonNull C7896f c7896f, @NonNull BaseResultData baseResultData) {
                super.onSuccess(c7896f, baseResultData);
                C8766a.m29888qi().m29893g(C7878b.this.adTemplate, 0, "success");
                C10331c.m26248i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onError(@NonNull C7896f c7896f, int i, String str) {
                super.onError(c7896f, i, str);
                C8766a.m29888qi().m29893g(C7878b.this.adTemplate, 1, str);
                C10331c.m26248i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }
        };

        public C7878b(@NonNull AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.AbstractC10402a
        @NonNull
        /* renamed from: fs */
        public C7896f createRequest() {
            return new C7896f(this.adTemplate);
        }

        /* renamed from: fr */
        public final void m32101fr() {
            request(this.f26499oG);
        }

        @Override // com.kwad.sdk.core.network.AbstractC10436l
        @NonNull
        public final BaseResultData parseData(String str) {
            BaseResultData baseResultData = new BaseResultData() { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$ServerCallbackNetworking$2
            };
            if (!TextUtils.isEmpty(str)) {
                try {
                    baseResultData.parseJson(new JSONObject(str));
                } catch (Throwable th) {
                    C10331c.printStackTrace(th);
                }
            }
            return baseResultData;
        }
    }

    /* synthetic */ C7876e(byte b) {
        this();
    }

    /* renamed from: D */
    private static void m32106D(AdTemplate adTemplate) {
        new C7878b(adTemplate).m32101fr();
    }

    /* renamed from: fp */
    public static C7876e m32105fp() {
        return C7877a.f26498oF;
    }

    /* renamed from: C */
    public final void m32107C(AdTemplate adTemplate) {
        C10331c.m26254d("RewardCallbackVerifyHelper", "handleRewardVerify");
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        if (!TextUtils.isEmpty(C10483a.m25892bP(m25641dQ))) {
            m32106D(adTemplate);
        } else {
            C8076o.m31642b(adTemplate, m25641dQ);
        }
    }

    private C7876e() {
    }
}
