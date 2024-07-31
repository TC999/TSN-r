package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.NetResponse;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.NetCallback;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.NetLog;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Call;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Callback;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Headers;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.MediaType;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.OkHttpClient;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.RequestBody;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import java.io.IOException;
import java.util.HashMap;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class PostExecutor extends NetExecutor {

    /* renamed from: e */
    RequestBody f777e;

    public PostExecutor(OkHttpClient okHttpClient) {
        super(okHttpClient);
        this.f777e = null;
    }

    /* renamed from: a */
    public void m58995a(String str, byte[] bArr) {
        this.f777e = RequestBody.m58191a(MediaType.m58268a(str), bArr);
    }

    /* renamed from: b */
    public NetResponse m58994b() {
        Request.C1083a c1083a = new Request.C1083a();
        if (TextUtils.isEmpty(this.f776d)) {
            NetLog.m58984a("PostExecutor", "execute: Url is Empty");
            return null;
        }
        try {
            c1083a.m58194b(this.f776d);
            if (this.f777e == null) {
                NetLog.m58984a("PostExecutor", "RequestBody is null, content type is not support!!");
                return null;
            }
            m59000a(c1083a);
            c1083a.m58199a((Object) m59001a());
            try {
                Response mo58223A = this.f773a.m58265a(c1083a.m58200a(this.f777e).m58204a()).mo58223A();
                if (mo58223A != null) {
                    HashMap hashMap = new HashMap();
                    Headers m58844e = mo58223A.m58844e();
                    if (m58844e != null) {
                        for (int i = 0; i < m58844e.m58338b(); i++) {
                            hashMap.put(m58844e.m58341a(i), m58844e.m58337b(i));
                        }
                        return new NetResponse(mo58223A.m58843f(), mo58223A.m58846c(), mo58223A.m58842g(), hashMap, mo58223A.m58850a().m58817d(), mo58223A.m58837l(), mo58223A.m58839j());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } catch (IllegalArgumentException unused) {
            NetLog.m58984a("PostExecutor", "execute: Url is not a valid HTTP or HTTPS URL");
            return null;
        }
    }

    /* renamed from: c */
    public void m58993c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.f777e = RequestBody.m58192a(MediaType.m58268a("application/json; charset=utf-8"), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PostExecutor.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1001a implements Callback {

        /* renamed from: a */
        final /* synthetic */ NetCallback f778a;

        C1001a(NetCallback netCallback) {
            this.f778a = netCallback;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Callback
        /* renamed from: a */
        public void mo58423a(Call call, IOException iOException) {
            NetCallback netCallback = this.f778a;
            if (netCallback != null) {
                netCallback.mo59048a(PostExecutor.this, iOException);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Callback
        /* renamed from: a */
        public void mo58424a(Call call, Response response) throws IOException {
            if (this.f778a != null) {
                HashMap hashMap = new HashMap();
                if (response != null) {
                    Headers m58844e = response.m58844e();
                    if (m58844e != null) {
                        for (int i = 0; i < m58844e.m58338b(); i++) {
                            hashMap.put(m58844e.m58341a(i), m58844e.m58337b(i));
                        }
                    }
                    this.f778a.mo59049a(PostExecutor.this, new NetResponse(response.m58843f(), response.m58846c(), response.m58842g(), hashMap, response.m58850a().m58817d(), response.m58837l(), response.m58839j()));
                }
            }
        }
    }

    /* renamed from: a */
    public void m58996a(NetCallback netCallback) {
        Request.C1083a c1083a = new Request.C1083a();
        if (TextUtils.isEmpty(this.f776d)) {
            netCallback.mo59048a(this, new IOException("Url is Empty"));
            return;
        }
        try {
            c1083a.m58194b(this.f776d);
            if (this.f777e == null) {
                if (netCallback != null) {
                    netCallback.mo59048a(this, new IOException("RequestBody is null, content type is not support!!"));
                    return;
                }
                return;
            }
            m59000a(c1083a);
            c1083a.m58199a((Object) m59001a());
            this.f773a.m58265a(c1083a.m58200a(this.f777e).m58204a()).mo58221a(new C1001a(netCallback));
        } catch (IllegalArgumentException unused) {
            netCallback.mo59048a(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }
}
