package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.MediaType;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ResponseBody;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RealResponseBody extends ResponseBody {

    /* renamed from: a */
    private final String f948a;

    /* renamed from: b */
    private final long f949b;

    /* renamed from: c */
    private final BufferedSource f950c;

    public RealResponseBody(String str, long j, BufferedSource bufferedSource) {
        this.f948a = str;
        this.f949b = j;
        this.f950c = bufferedSource;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ResponseBody
    /* renamed from: a */
    public long mo58752a() {
        return this.f949b;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ResponseBody
    /* renamed from: b */
    public MediaType mo58751b() {
        String str = this.f948a;
        if (str != null) {
            return MediaType.m58268a(str);
        }
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ResponseBody
    /* renamed from: c */
    public BufferedSource mo58750c() {
        return this.f950c;
    }
}
