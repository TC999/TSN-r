package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.io.IOException;

/* compiled from: TncHostInterceptor.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class g implements t {

    /* renamed from: a  reason: collision with root package name */
    private int f757a;

    public void a(int i4) {
        this.f757a = i4;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t
    public a0 a(t.a aVar) throws IOException {
        a0 a0Var;
        y b4 = aVar.b();
        if (h.a().a(this.f757a).a() != null) {
            h.a().a(this.f757a).a().e();
        }
        String sVar = b4.g().toString();
        String a4 = h.a().a(this.f757a).a(sVar);
        if (!sVar.equals(a4)) {
            b4 = b4.f().b(a4).a();
        }
        try {
            a0Var = aVar.a(b4);
        } catch (Exception e4) {
            h.a().a(this.f757a).a(b4, e4);
            a0Var = null;
        }
        h.a().a(this.f757a).a(b4, a0Var);
        return a0Var == null ? aVar.a(b4) : a0Var;
    }
}
