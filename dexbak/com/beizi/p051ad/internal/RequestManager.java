package com.beizi.p051ad.internal;

import com.beizi.p051ad.internal.p057a.MediationAd;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.beizi.ad.internal.m */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class RequestManager implements AdRequestDelegate {

    /* renamed from: a */
    private LinkedList<MediationAd> f10170a;

    /* renamed from: b */
    private long f10171b = -1;

    /* renamed from: c */
    private ArrayList<String> f10172c = new ArrayList<>();

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: a */
    public long mo49460a(long j) {
        long j2 = this.f10171b;
        if (j2 > 0) {
            return j - j2;
        }
        return -1L;
    }

    @Override // com.beizi.p051ad.internal.AdRequestDelegate
    /* renamed from: b */
    public LinkedList<MediationAd> mo49458b() {
        return this.f10170a;
    }

    /* renamed from: e */
    public abstract void mo49368e();

    /* renamed from: g */
    public void m49457g() {
        this.f10171b = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void m49456h() {
        if (this.f10172c.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("Mediation Classes: \n");
        for (int size = this.f10172c.size(); size > 0; size--) {
            sb.append(String.format("%d: %s\n", Integer.valueOf(size), this.f10172c.get(size - 1)));
        }
        HaoboLog.m49288i(HaoboLog.mediationLogTag, sb.toString());
        this.f10172c.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public MediationAd m49455i() {
        LinkedList<MediationAd> linkedList = this.f10170a;
        if (linkedList == null || linkedList.getFirst() == null) {
            return null;
        }
        this.f10172c.add(this.f10170a.getFirst().m49783a());
        return this.f10170a.removeFirst();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m49459a(LinkedList<MediationAd> linkedList) {
        this.f10170a = linkedList;
    }
}
