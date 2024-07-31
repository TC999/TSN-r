package com.kwad.components.core.p298i;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p303m.C8694a;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.request.AbstractC8925j;
import com.kwad.components.core.request.C8910a;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.core.i.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8665a {

    /* renamed from: LU */
    private static int f28323LU = 12;

    /* renamed from: LV */
    private static int f28324LV = 4;

    /* renamed from: LW */
    private static int f28325LW = 1;

    /* renamed from: com.kwad.components.core.i.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8672a {
        /* renamed from: e */
        void mo30038e(@Nullable List<C8674c> list);

        void onError(int i, String str);

        void onRequestResult(int i);
    }

    /* renamed from: a */
    public static void m30045a(@NonNull SceneImpl sceneImpl, InterfaceC8672a interfaceC8672a) {
        m30048a(15, f28324LV, sceneImpl, C8676e.AGGREGATION, interfaceC8672a);
    }

    /* renamed from: a */
    private static void m30048a(int i, int i2, @NonNull SceneImpl sceneImpl, final int i3, final InterfaceC8672a interfaceC8672a) {
        SceneImpl m60139clone = sceneImpl.m60139clone();
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        m60139clone.setAdStyle(i);
        m60139clone.setAdNum(i2);
        m30047a(new ImpInfo(m60139clone), null, false, true, new AbstractC8925j() { // from class: com.kwad.components.core.i.a.1
            @Override // com.kwad.components.core.request.InterfaceC8926k
            /* renamed from: a */
            public final void mo29595a(@NonNull final AdResultData adResultData) {
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.i.a.1.2
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        try {
                            InterfaceC8672a.this.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            C10331c.printStackTraceOnly(th);
                        }
                    }
                });
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.i.a.1.3
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        InterfaceC8672a.this.mo30038e(C8665a.m30042b(adResultData.getAdTemplateList(), i3));
                        C8665a.m30046a(adResultData, elapsedRealtime);
                    }
                });
            }

            @Override // com.kwad.components.core.request.InterfaceC8926k
            public final void onError(final int i4, final String str) {
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.i.a.1.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C10331c.m26246w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i4), str));
                        InterfaceC8672a.this.onError(i4, str);
                    }
                });
            }
        }, false);
    }

    /* renamed from: b */
    public static void m30043b(@NonNull SceneImpl sceneImpl, InterfaceC8672a interfaceC8672a) {
        m30048a(17, f28325LW, sceneImpl, C8676e.f28346Mg, interfaceC8672a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static List<C8674c> m30042b(List<AdTemplate> list, int i) {
        ArrayList arrayList = new ArrayList();
        for (AdTemplate adTemplate : list) {
            arrayList.add(new C8674c(adTemplate, i));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m30046a(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        C8766a.m29888qi().m29892g(adTemplate, elapsedRealtime - j);
    }

    /* renamed from: a */
    private static void m30047a(final ImpInfo impInfo, List<String> list, boolean z, boolean z2, @NonNull final AbstractC8925j abstractC8925j, boolean z3) {
        new C8694a(impInfo) { // from class: com.kwad.components.core.i.a.2
            @Override // com.kwad.components.core.p303m.C8694a, com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            /* renamed from: mO */
            public final C8910a createRequest() {
                C8910a c8910a = new C8910a(impInfo, r3, r4, null);
                c8910a.m29617aF(r5 ? 1 : 0);
                return c8910a;
            }
        }.request(new AbstractC10439o<C8910a, AdResultData>() { // from class: com.kwad.components.core.i.a.3
            /* renamed from: c */
            private void m30040c(@NonNull AdResultData adResultData) {
                if (adResultData.isAdResultDataEmpty() && !r1) {
                    abstractC8925j.onError(C10419e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? C10419e.avy.msg : adResultData.testErrorMsg);
                } else {
                    abstractC8925j.mo29595a(adResultData);
                }
            }

            /* renamed from: h */
            private void m30039h(int i, String str) {
                abstractC8925j.onError(i, str);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onError(@NonNull InterfaceC10420f interfaceC10420f, int i, String str) {
                m30039h(i, str);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onSuccess(@NonNull InterfaceC10420f interfaceC10420f, @NonNull BaseResultData baseResultData) {
                m30040c((AdResultData) baseResultData);
            }
        });
    }
}
