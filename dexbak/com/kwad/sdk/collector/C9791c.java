package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.collector.C9796d;
import com.kwad.sdk.collector.p370a.C9782a;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.C11059bi;

/* renamed from: com.kwad.sdk.collector.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9791c {

    /* renamed from: com.kwad.sdk.collector.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9795a {
        /* renamed from: b */
        void mo23803b(AppStatusRules appStatusRules);

        /* renamed from: p */
        void mo23802p(int i, String str);
    }

    /* renamed from: a */
    public static void m27770a(final Context context, final InterfaceC9795a interfaceC9795a) {
        if (context == null) {
            return;
        }
        C9796d.m27762a(context, new C9796d.InterfaceC9798a() { // from class: com.kwad.sdk.collector.c.1
            @Override // com.kwad.sdk.collector.C9796d.InterfaceC9798a
            /* renamed from: cq */
            public final void mo27756cq(String str) {
                C10331c.m26250e("AppStatusFetchConfigManager", "onLoadError: " + str);
            }

            @Override // com.kwad.sdk.collector.C9796d.InterfaceC9798a
            public final void onLoaded() {
                C9791c.m27769b(context, interfaceC9795a);
            }
        });
    }

    /* renamed from: b */
    public static void m27769b(final Context context, final InterfaceC9795a interfaceC9795a) {
        new AbstractC10436l<C9782a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            /* renamed from: Aw */
            public C9782a createRequest() {
                return new C9782a(C11059bi.m23878dh(context));
            }

            @NonNull
            /* renamed from: cr */
            private static AppStatusRules m27767cr(String str) {
                return AppStatusRules.createFromJson(str);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            @NonNull
            public final /* synthetic */ AppStatusRules parseData(String str) {
                return m27767cr(str);
            }
        }.request(new AbstractC10439o<C9782a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onStartRequest(@NonNull C9782a c9782a) {
                super.onStartRequest(c9782a);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onSuccess(@NonNull InterfaceC10420f interfaceC10420f, @NonNull BaseResultData baseResultData) {
                m27766a((AppStatusRules) baseResultData);
            }

            /* renamed from: a */
            private void m27766a(@NonNull AppStatusRules appStatusRules) {
                InterfaceC9795a interfaceC9795a2 = InterfaceC9795a.this;
                if (interfaceC9795a2 != null) {
                    interfaceC9795a2.mo23803b(appStatusRules);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onError(@NonNull C9782a c9782a, int i, String str) {
                super.onError(c9782a, i, str);
                InterfaceC9795a interfaceC9795a2 = InterfaceC9795a.this;
                if (interfaceC9795a2 != null) {
                    interfaceC9795a2.mo23802p(i, str);
                }
            }
        });
    }
}
