package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.ExtraParam;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.base.TTBaseAd;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTBaseAdCache implements Comparable<TTBaseAdCache> {

    /* renamed from: a */
    public TTBaseAd f425a;

    /* renamed from: b */
    public ExtraParam f426b;

    /* renamed from: c */
    private long f427c;

    /* renamed from: d */
    private long f428d;

    /* renamed from: e */
    private boolean f429e = false;

    /* renamed from: f */
    private AdSlot f430f;

    public TTBaseAdCache(TTBaseAd tTBaseAd, ExtraParam extraParam, long j, long j2, AdSlot adSlot) {
        this.f425a = tTBaseAd;
        this.f426b = extraParam;
        this.f427c = j;
        this.f428d = j2;
        this.f430f = adSlot;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(TTBaseAdCache tTBaseAdCache) {
        return this.f425a.compareTo(tTBaseAdCache.f425a);
    }

    /* renamed from: b */
    public long m59654b() {
        return this.f428d;
    }

    /* renamed from: c */
    public long m59653c() {
        return this.f427c;
    }

    /* renamed from: d */
    public boolean m59652d() {
        return this.f429e;
    }

    /* renamed from: a */
    public void m59655a(boolean z) {
        this.f429e = z;
    }

    /* renamed from: a */
    public AdSlot m59657a() {
        return this.f430f;
    }
}
