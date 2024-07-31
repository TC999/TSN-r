package com.kwad.sdk.core.webview.request;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.webview.p423d.C10637b;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.webview.request.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10646b {

    /* renamed from: fS */
    private static final Handler f29651fS = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.sdk.core.webview.request.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10653a {
        @MainThread
        /* renamed from: a */
        void mo25231a(@NonNull WebCardGetDataResponse webCardGetDataResponse);

        @MainThread
        void onError(int i, String str);
    }

    /* renamed from: a */
    public final void m25237a(final C10637b.C10639a c10639a, @NonNull final InterfaceC10653a interfaceC10653a) {
        new AbstractC10436l<C10645a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            /* renamed from: Hc */
            public C10645a createRequest() {
                C10637b.C10639a c10639a2 = c10639a;
                return new C10645a(c10639a2.url, c10639a2.method, c10639a2.params) { // from class: com.kwad.sdk.core.webview.request.b.1.1
                    @Override // com.kwad.sdk.core.webview.request.C10645a, com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
                    public final String getUrl() {
                        return c10639a.url;
                    }
                };
            }

            @NonNull
            /* renamed from: eY */
            private static WebCardGetDataResponse m25235eY(String str) {
                JSONObject jSONObject = new JSONObject(str);
                WebCardGetDataResponse webCardGetDataResponse = new WebCardGetDataResponse();
                webCardGetDataResponse.parseJson(jSONObject);
                return webCardGetDataResponse;
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            @NonNull
            public final /* synthetic */ WebCardGetDataResponse parseData(String str) {
                return m25235eY(str);
            }
        }.request(new AbstractC10439o<C10645a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onStartRequest(@NonNull C10645a c10645a) {
                super.onStartRequest(c10645a);
                C10331c.m26254d("WebCardGetDataRequestManager", "onStartRequest");
                C10646b.f29651fS.post(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.webview.request.b.2.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                    }
                });
            }

            /* renamed from: b */
            private void m25233b(@NonNull final WebCardGetDataResponse webCardGetDataResponse) {
                C10331c.m26254d("WebCardGetDataRequestManager", "onSuccess");
                C10646b.f29651fS.post(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.webview.request.b.2.2
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        interfaceC10653a.mo25231a(webCardGetDataResponse);
                    }
                });
            }

            /* renamed from: r */
            private void m25232r(final int i, final String str) {
                C10331c.m26254d("WebCardGetDataRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
                C10646b.f29651fS.post(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.webview.request.b.2.3
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C10331c.m26254d("WebCardGetDataRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        interfaceC10653a.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onError(@NonNull InterfaceC10420f interfaceC10420f, int i, String str) {
                m25232r(i, str);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onSuccess(@NonNull InterfaceC10420f interfaceC10420f, @NonNull BaseResultData baseResultData) {
                m25233b((WebCardGetDataResponse) baseResultData);
            }
        });
    }
}
