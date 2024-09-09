package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void b(AppStatusRules appStatusRules);

        void p(int i4, String str);
    }

    public static void a(final Context context, final a aVar) {
        if (context == null) {
            return;
        }
        d.a(context, new d.a() { // from class: com.kwad.sdk.collector.c.1
            @Override // com.kwad.sdk.collector.d.a
            public final void cq(String str) {
                com.kwad.sdk.core.e.c.e("AppStatusFetchConfigManager", "onLoadError: " + str);
            }

            @Override // com.kwad.sdk.collector.d.a
            public final void onLoaded() {
                c.b(context, aVar);
            }
        });
    }

    public static void b(final Context context, final a aVar) {
        new l<com.kwad.sdk.collector.a.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: Aw */
            public com.kwad.sdk.collector.a.a createRequest() {
                return new com.kwad.sdk.collector.a.a(bi.dh(context));
            }

            @NonNull
            private static AppStatusRules cr(String str) {
                return AppStatusRules.createFromJson(str);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ AppStatusRules parseData(String str) {
                return cr(str);
            }
        }.request(new o<com.kwad.sdk.collector.a.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.sdk.collector.a.a aVar2) {
                super.onStartRequest(aVar2);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                a((AppStatusRules) baseResultData);
            }

            private void a(@NonNull AppStatusRules appStatusRules) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.b(appStatusRules);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull com.kwad.sdk.collector.a.a aVar2, int i4, String str) {
                super.onError(aVar2, i4, str);
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.p(i4, str);
                }
            }
        });
    }
}
