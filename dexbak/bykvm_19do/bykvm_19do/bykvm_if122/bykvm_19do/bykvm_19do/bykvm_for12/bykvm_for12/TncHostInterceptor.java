package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import java.io.IOException;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TncHostInterceptor implements Interceptor {

    /* renamed from: a */
    private int f764a;

    /* renamed from: a */
    public void m59007a(int i) {
        this.f764a = i;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor
    /* renamed from: a */
    public Response mo58275a(Interceptor.InterfaceC1079a interfaceC1079a) throws IOException {
        Response response;
        Request mo58272b = interfaceC1079a.mo58272b();
        if (TncInstanceManager.m59006a().m59005a(this.f764a).m59033a() != null) {
            TncInstanceManager.m59006a().m59005a(this.f764a).m59033a().m59053e();
        }
        String httpUrl = mo58272b.m58205g().toString();
        String m59024a = TncInstanceManager.m59006a().m59005a(this.f764a).m59024a(httpUrl);
        if (!httpUrl.equals(m59024a)) {
            mo58272b = mo58272b.m58206f().m58194b(m59024a).m58204a();
        }
        try {
            response = interfaceC1079a.mo58273a(mo58272b);
        } catch (Exception e) {
            TncInstanceManager.m59006a().m59005a(this.f764a).m59025a(mo58272b, e);
            response = null;
        }
        TncInstanceManager.m59006a().m59005a(this.f764a).m59026a(mo58272b, response);
        return response == null ? interfaceC1079a.mo58273a(mo58272b) : response;
    }
}
