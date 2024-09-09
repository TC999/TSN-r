package com.kwad.components.ad.feed;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.feed.c;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.k;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.ad.feed.e$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class AnonymousClass2 extends com.kwad.components.core.request.d {
        final /* synthetic */ KsLoadManager.FeedAdListener el;
        final /* synthetic */ SceneImpl em;
        final /* synthetic */ boolean en;
        final /* synthetic */ long eo;

        AnonymousClass2(KsLoadManager.FeedAdListener feedAdListener, SceneImpl sceneImpl, boolean z3, long j4) {
            this.el = feedAdListener;
            this.em = sceneImpl;
            this.en = z3;
            this.eo = j4;
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void a(@NonNull AdResultData adResultData) {
            final ArrayList arrayList = new ArrayList();
            List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
            com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + adTemplateList.size());
            if (adTemplateList.isEmpty()) {
                com.kwad.components.ad.feed.monitor.b.aY();
            }
            String str = null;
            for (AdTemplate adTemplate : adTemplateList) {
                if (adTemplate != null) {
                    AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
                    if (!FeedType.checkTypeValid(adTemplate)) {
                        str = String.format("(\u6a21\u677f\u4e0d\u5339\u914dmaterialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.be(dQ)), FeedType.fromInt(adTemplate.type));
                        com.kwad.components.ad.feed.monitor.b.a(com.kwad.sdk.core.response.b.a.be(dQ), adTemplate.type, adTemplate);
                    } else {
                        adTemplate.mAdScene = this.em;
                        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(dQ))) {
                            Pair<Integer, String> d4 = com.kwad.components.ad.feed.monitor.a.d(adTemplate);
                            com.kwad.components.ad.feed.monitor.b.e(((Integer) d4.first).intValue(), (String) d4.second);
                        }
                        arrayList.add(new c(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate), this.en));
                    }
                }
            }
            com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + arrayList.size());
            com.kwad.components.ad.feed.monitor.b.t(arrayList.size());
            if (arrayList.isEmpty()) {
                int i4 = com.kwad.sdk.core.network.e.avy.errorCode;
                com.kwad.components.ad.feed.monitor.b.d(i4, com.kwad.sdk.core.network.e.avy.msg + str);
                int i5 = com.kwad.sdk.core.network.e.avy.errorCode;
                onError(i5, com.kwad.sdk.core.network.e.avy.msg + str);
                com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "loadFeedAd onError");
                return;
            }
            com.kwad.sdk.commercial.d.d.a(this.em, arrayList.size());
            if (com.kwad.sdk.core.config.d.By() && (!k.zd().yp() || (k.zd().yp() && com.kwad.sdk.core.config.d.Bz() == 1))) {
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.e.2.2
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        com.kwad.components.ad.feed.monitor.b.a(arrayList.size(), SystemClock.elapsedRealtime() - AnonymousClass2.this.eo);
                        KsAdLoadManager.M().b(arrayList);
                        AnonymousClass2.this.el.onFeedAdLoad(arrayList);
                        com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.em.getPosId(), arrayList);
                    }
                });
            } else {
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.e.2.3
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        final int size = arrayList.size();
                        final int[] iArr = {0};
                        for (final KsFeedAd ksFeedAd : arrayList) {
                            final c cVar = (c) ksFeedAd;
                            com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd);
                            final int i6 = com.kwad.sdk.core.response.b.b.cO(cVar.getAdTemplate()) ? 3 : 2;
                            final long elapsedRealtime = SystemClock.elapsedRealtime();
                            cVar.a(new c.a() { // from class: com.kwad.components.ad.feed.e.2.3.1
                                @Override // com.kwad.components.ad.feed.c.a
                                public final void c(int i7, String str2) {
                                    com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar);
                                    com.kwad.components.ad.feed.monitor.b.a(((c) ksFeedAd).getAdTemplate(), i7, i6, SystemClock.elapsedRealtime() - elapsedRealtime, str2);
                                    int[] iArr2 = iArr;
                                    int i8 = iArr2[0] + 1;
                                    iArr2[0] = i8;
                                    int i9 = size;
                                    if (i8 == i9) {
                                        com.kwad.components.ad.feed.monitor.b.a(i9, SystemClock.elapsedRealtime() - AnonymousClass2.this.eo);
                                        KsAdLoadManager.M().b(arrayList);
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        AnonymousClass2.this.el.onFeedAdLoad(arrayList);
                                        com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.em.getPosId(), arrayList);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void onError(final int i4, final String str) {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.e.2.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    AnonymousClass2.this.el.onError(i4, str);
                }
            });
            com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i4), str));
            com.kwad.components.ad.feed.monitor.b.d(i4, str);
            if (i4 == com.kwad.sdk.core.network.e.avt.errorCode || i4 == com.kwad.sdk.core.network.e.avy.errorCode) {
                return;
            }
            com.kwad.components.ad.feed.monitor.b.f(i4, str);
        }
    }

    public static void a(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener, boolean z3) {
        if (!k.zd().ys()) {
            com.kwad.sdk.core.e.c.e("KsAdFeedLoadManager", "loadConfigFeedAd please init sdk first");
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.e.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    KsLoadManager.FeedAdListener feedAdListener2 = KsLoadManager.FeedAdListener.this;
                    int i4 = com.kwad.sdk.core.network.e.avy.errorCode;
                    feedAdListener2.onError(i4, com.kwad.sdk.core.network.e.avy.msg + "sdk not init");
                }
            });
            return;
        }
        SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.feed.monitor.b.s(covert.getAdNum());
        boolean a4 = m.re().a(covert, "loadConfigFeedAd");
        covert.setAdStyle(1);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0649a().e(new ImpInfo(covert)).aJ(a4).a(new AnonymousClass2(feedAdListener, covert, z3, elapsedRealtime)).qy());
    }
}
