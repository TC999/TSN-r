package com.beizi.p051ad.internal;

import android.util.Log;
import com.beizi.p051ad.internal.network.AdRequestImpl;
import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.internal.p057a.MediationAd;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.lance.p062a.BeiZiExecutor;
import com.beizi.p051ad.p055b.MediationAdRequest;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.beizi.ad.internal.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PrefetchAdRequestManagerImpl extends RequestManager {

    /* renamed from: a */
    private AdRequestImpl f10168a;

    /* renamed from: b */
    private AdParameters f10169b = new AdParameters(BeiZiImpl.m49492a().m49473e(), StringUtil.createRequestId());

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: a */
    public void mo49374a() {
        this.f10168a = new AdRequestImpl(new AdRequestImpl.C2918a());
        m49457g();
        try {
            this.f10168a.m49345a(this);
            this.f10168a.executeOnExecutor(BeiZiExecutor.m49087b().m49086c(), new Void[0]);
        } catch (IllegalStateException e) {
            Log.d("lance", "ignored:" + e.getMessage());
        } catch (RejectedExecutionException e2) {
            String str = HaoboLog.baseLogTag;
            HaoboLog.m49290e(str, "Concurrent Thread Exception while firing new ad request: " + e2.getMessage());
        }
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: c */
    public AdParameters mo49370c() {
        return this.f10169b;
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: d */
    public MediationAdRequest mo49369d() {
        return null;
    }

    @Override // com.beizi.p051ad.internal.RequestManager
    /* renamed from: e */
    public void mo49368e() {
        AdRequestImpl adRequestImpl = this.f10168a;
        if (adRequestImpl != null) {
            adRequestImpl.cancel(true);
            this.f10168a = null;
        }
        m49459a((LinkedList<MediationAd>) null);
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: a */
    public void mo49373a(int i) {
        String str = HaoboLog.pbLogTag;
        HaoboLog.m49292d(str, "Failed to load prefetch request: " + i);
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: a */
    public void mo49372a(ServerResponse serverResponse) {
        Iterator<String> it = serverResponse.getPrefetchResources().iterator();
        while (it.hasNext()) {
            String str = HaoboLog.baseLogTag;
            HaoboLog.m49292d(str, "Prefetch resource: " + it.next());
        }
    }
}
