package com.kwad.components.core.p287c;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.request.C8910a;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import java.util.List;

/* renamed from: com.kwad.components.core.c.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8557j extends AbstractC10439o<C8910a, AdResultData> {

    /* renamed from: Jn */
    private final C8927a f28109Jn;

    public C8557j(C8927a c8927a) {
        this.f28109Jn = c8927a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* renamed from: j */
    public static void m30356j(AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        C8544a m30401mu = C8544a.m30401mu();
        if (m30401mu == null || proceedTemplateList.size() <= 0) {
            return;
        }
        C8551e m30381s = C8551e.m30381s(adResultData.getPosId());
        m30401mu.m30400mv();
        m30401mu.m30402i(C8555h.m30371a(m30381s, adResultData));
        m30401mu.m30405a(C8551e.m30387aj(proceedTemplateList.get(0)));
    }

    /* renamed from: a */
    protected boolean mo30350a(C8927a c8927a, AdResultData adResultData) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
    /* renamed from: a */
    public void onSuccess(@NonNull C8910a c8910a, @NonNull final AdResultData adResultData) {
        super.onSuccess(c8910a, adResultData);
        GlobalThreadPools.m25601FH().submit(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.c.j.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8557j c8557j = C8557j.this;
                C8557j.m30356j(adResultData);
            }
        });
        if (mo30350a(this.f28109Jn, adResultData)) {
            return;
        }
        C8927a.m29593a(this.f28109Jn, adResultData, false);
    }

    @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
    /* renamed from: a */
    public void onError(@NonNull C8910a c8910a, int i, String str) {
        super.onError(c8910a, i, str);
        C8927a.m29594a(this.f28109Jn, i, str, false);
    }
}
