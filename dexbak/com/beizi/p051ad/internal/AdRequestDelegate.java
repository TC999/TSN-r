package com.beizi.p051ad.internal;

import com.beizi.p051ad.internal.network.ServerResponse;
import com.beizi.p051ad.internal.p057a.MediationAd;
import com.beizi.p051ad.p055b.MediationAdRequest;
import java.util.LinkedList;

/* renamed from: com.beizi.ad.internal.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface AdRequestDelegate {
    /* renamed from: a */
    long mo49460a(long j);

    /* renamed from: a */
    void mo49374a();

    /* renamed from: a */
    void mo49373a(int i);

    /* renamed from: a */
    void mo49372a(ServerResponse serverResponse);

    /* renamed from: b */
    LinkedList<MediationAd> mo49458b();

    /* renamed from: c */
    AdParameters mo49370c();

    /* renamed from: d */
    MediationAdRequest mo49369d();
}
