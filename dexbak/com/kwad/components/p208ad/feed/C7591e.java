package com.kwad.components.p208ad.feed;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.kwad.components.core.p330s.C8950m;
import com.kwad.components.core.request.C8915d;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.model.FeedType;
import com.kwad.components.p208ad.KsAdLoadManager;
import com.kwad.components.p208ad.feed.C7577c;
import com.kwad.components.p208ad.feed.monitor.C7600a;
import com.kwad.components.p208ad.feed.monitor.C7601b;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.commercial.p375d.C9829d;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.ad.feed.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7591e {

    /* renamed from: com.kwad.components.ad.feed.e$2 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C75932 extends C8915d {

        /* renamed from: el */
        final /* synthetic */ KsLoadManager.FeedAdListener f25833el;

        /* renamed from: em */
        final /* synthetic */ SceneImpl f25834em;

        /* renamed from: en */
        final /* synthetic */ boolean f25835en;

        /* renamed from: eo */
        final /* synthetic */ long f25836eo;

        C75932(KsLoadManager.FeedAdListener feedAdListener, SceneImpl sceneImpl, boolean z, long j) {
            this.f25833el = feedAdListener;
            this.f25834em = sceneImpl;
            this.f25835en = z;
            this.f25836eo = j;
        }

        @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.InterfaceC8926k
        /* renamed from: a */
        public final void mo29595a(@NonNull AdResultData adResultData) {
            final ArrayList arrayList = new ArrayList();
            List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
            C10331c.m26254d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + adTemplateList.size());
            if (adTemplateList.isEmpty()) {
                C7601b.m32809aY();
            }
            String str = null;
            for (AdTemplate adTemplate : adTemplateList) {
                if (adTemplate != null) {
                    AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
                    if (!FeedType.checkTypeValid(adTemplate)) {
                        str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(C10483a.m25875be(m25641dQ)), FeedType.fromInt(adTemplate.type));
                        C7601b.m32824a(C10483a.m25875be(m25641dQ), adTemplate.type, adTemplate);
                    } else {
                        adTemplate.mAdScene = this.f25834em;
                        if (!TextUtils.isEmpty(C10483a.m25977K(m25641dQ))) {
                            Pair<Integer, String> m32825d = C7600a.m32825d(adTemplate);
                            C7601b.m32803e(((Integer) m32825d.first).intValue(), (String) m32825d.second);
                        }
                        arrayList.add(new C7577c(C10485c.m25664a(adResultData, adTemplate), this.f25835en));
                    }
                }
            }
            C10331c.m26254d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + arrayList.size());
            C7601b.m32798t(arrayList.size());
            if (arrayList.isEmpty()) {
                int i = C10419e.avy.errorCode;
                C7601b.m32804d(i, C10419e.avy.msg + str);
                int i2 = C10419e.avy.errorCode;
                onError(i2, C10419e.avy.msg + str);
                C10331c.m26254d("KsAdFeedLoadManager", "loadFeedAd onError");
                return;
            }
            C9829d.m27586a(this.f25834em, arrayList.size());
            if (C10251d.m26563By() && (!C10829k.m24699zd().m24703yp() || (C10829k.m24699zd().m24703yp() && C10251d.m26562Bz() == 1))) {
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.e.2.2
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C7601b.m32823a(arrayList.size(), SystemClock.elapsedRealtime() - C75932.this.f25836eo);
                        KsAdLoadManager.m33469M().m33466b(arrayList);
                        C75932.this.f25833el.onFeedAdLoad(arrayList);
                        C7601b.m32820a(C75932.this.f25834em.getPosId(), arrayList);
                    }
                });
            } else {
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.e.2.3
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        final int size = arrayList.size();
                        final int[] iArr = {0};
                        for (final KsFeedAd ksFeedAd : arrayList) {
                            final C7577c c7577c = (C7577c) ksFeedAd;
                            C10331c.m26254d("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd);
                            final int i3 = C10484b.m25777cO(c7577c.getAdTemplate()) ? 3 : 2;
                            final long elapsedRealtime = SystemClock.elapsedRealtime();
                            c7577c.m32854a(new C7577c.InterfaceC7585a() { // from class: com.kwad.components.ad.feed.e.2.3.1
                                @Override // com.kwad.components.p208ad.feed.C7577c.InterfaceC7585a
                                /* renamed from: c */
                                public final void mo32830c(int i4, String str2) {
                                    C10331c.m26254d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + c7577c);
                                    C7601b.m32816a(((C7577c) ksFeedAd).getAdTemplate(), i4, i3, SystemClock.elapsedRealtime() - elapsedRealtime, str2);
                                    int[] iArr2 = iArr;
                                    int i5 = iArr2[0] + 1;
                                    iArr2[0] = i5;
                                    int i6 = size;
                                    if (i5 == i6) {
                                        C7601b.m32823a(i6, SystemClock.elapsedRealtime() - C75932.this.f25836eo);
                                        KsAdLoadManager.m33469M().m33466b(arrayList);
                                        C75963 c75963 = C75963.this;
                                        C75932.this.f25833el.onFeedAdLoad(arrayList);
                                        C7601b.m32820a(C75932.this.f25834em.getPosId(), arrayList);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }

        @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.InterfaceC8926k
        public final void onError(final int i, final String str) {
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.e.2.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C75932.this.f25833el.onError(i, str);
                }
            });
            C10331c.m26254d("KsAdFeedLoadManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
            C7601b.m32804d(i, str);
            if (i == C10419e.avt.errorCode || i == C10419e.avy.errorCode) {
                return;
            }
            C7601b.m32801f(i, str);
        }
    }

    /* renamed from: a */
    public static void m32831a(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener, boolean z) {
        if (!C10829k.m24699zd().m24700ys()) {
            C10331c.m26250e("KsAdFeedLoadManager", "loadConfigFeedAd please init sdk first");
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.e.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    KsLoadManager.FeedAdListener feedAdListener2 = KsLoadManager.FeedAdListener.this;
                    int i = C10419e.avy.errorCode;
                    feedAdListener2.onError(i, C10419e.avy.msg + "sdk not init");
                }
            });
            return;
        }
        SceneImpl covert = SceneImpl.covert(ksScene);
        C9829d.m27583b(covert);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C7601b.m32799s(covert.getAdNum());
        boolean m29540a = C8950m.m29533re().m29540a(covert, "loadConfigFeedAd");
        covert.setAdStyle(1);
        KsAdLoadManager.m33469M();
        KsAdLoadManager.m33468a(new C8927a.C8928a().m29585e(new ImpInfo(covert)).m29586aJ(m29540a).m29589a(new C75932(feedAdListener, covert, z, elapsedRealtime)).m29584qy());
    }
}
