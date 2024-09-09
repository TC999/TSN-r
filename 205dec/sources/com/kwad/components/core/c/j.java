package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.ay;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class j extends o<com.kwad.components.core.request.a, AdResultData> {
    private final com.kwad.components.core.request.model.a Jn;

    public j(com.kwad.components.core.request.model.a aVar) {
        this.Jn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static void j(AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        a mu = a.mu();
        if (mu == null || proceedTemplateList.size() <= 0) {
            return;
        }
        e s3 = e.s(adResultData.getPosId());
        mu.mv();
        mu.i(h.a(s3, adResultData));
        mu.a(e.aj(proceedTemplateList.get(0)));
    }

    protected boolean a(com.kwad.components.core.request.model.a aVar, AdResultData adResultData) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
    /* renamed from: a */
    public void onSuccess(@NonNull com.kwad.components.core.request.a aVar, @NonNull final AdResultData adResultData) {
        super.onSuccess(aVar, adResultData);
        GlobalThreadPools.FH().submit(new ay() { // from class: com.kwad.components.core.c.j.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                j jVar = j.this;
                j.j(adResultData);
            }
        });
        if (a(this.Jn, adResultData)) {
            return;
        }
        com.kwad.components.core.request.model.a.a(this.Jn, adResultData, false);
    }

    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
    /* renamed from: a */
    public void onError(@NonNull com.kwad.components.core.request.a aVar, int i4, String str) {
        super.onError(aVar, i4, str);
        com.kwad.components.core.request.model.a.a(this.Jn, i4, str, false);
    }
}
