package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.base.TTBaseAd;

/* compiled from: TTBaseAdCache.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class f implements Comparable<f> {

    /* renamed from: a  reason: collision with root package name */
    public TTBaseAd f418a;

    /* renamed from: b  reason: collision with root package name */
    public bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d f419b;

    /* renamed from: c  reason: collision with root package name */
    private long f420c;

    /* renamed from: d  reason: collision with root package name */
    private long f421d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f422e = false;

    /* renamed from: f  reason: collision with root package name */
    private AdSlot f423f;

    public f(TTBaseAd tTBaseAd, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_try19.d dVar, long j4, long j5, AdSlot adSlot) {
        this.f418a = tTBaseAd;
        this.f419b = dVar;
        this.f420c = j4;
        this.f421d = j5;
        this.f423f = adSlot;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        return this.f418a.compareTo(fVar.f418a);
    }

    public long b() {
        return this.f421d;
    }

    public long c() {
        return this.f420c;
    }

    public boolean d() {
        return this.f422e;
    }

    public void a(boolean z3) {
        this.f422e = z3;
    }

    public AdSlot a() {
        return this.f423f;
    }
}
