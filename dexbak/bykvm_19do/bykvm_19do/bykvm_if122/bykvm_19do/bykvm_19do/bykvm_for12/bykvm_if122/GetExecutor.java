package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.net.Uri;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.NetResponse;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.NetCallback;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.NetLog;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.CacheControl;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Call;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Callback;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Headers;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.HttpUrl;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.OkHttpClient;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class GetExecutor extends NetExecutor {

    /* renamed from: g */
    public static final CacheControl f768g = new CacheControl.C1064a().m58428b().m58430a();

    /* renamed from: e */
    private CacheControl f769e;

    /* renamed from: f */
    private Map<String, String> f770f;

    static {
        new CacheControl.C1064a().m58430a();
    }

    public GetExecutor(OkHttpClient okHttpClient) {
        super(okHttpClient);
        this.f769e = f768g;
        this.f770f = new HashMap();
    }

    /* renamed from: a */
    public void m59003a(NetCallback netCallback) {
        Request.C1083a c1083a = new Request.C1083a();
        HttpUrl.C1077a c1077a = new HttpUrl.C1077a();
        try {
            Uri parse = Uri.parse(this.f776d);
            c1077a.m58281e(parse.getScheme());
            c1077a.m58286c(parse.getHost());
            String encodedPath = parse.getEncodedPath();
            if (!TextUtils.isEmpty(encodedPath)) {
                if (encodedPath.startsWith("/")) {
                    encodedPath = encodedPath.substring(1);
                }
                c1077a.m58295a(encodedPath);
            }
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() > 0) {
                for (String str : queryParameterNames) {
                    this.f770f.put(str, parse.getQueryParameter(str));
                }
            }
            for (Map.Entry<String, String> entry : this.f770f.entrySet()) {
                c1077a.m58292a(entry.getKey(), entry.getValue());
            }
            m59000a(c1083a);
            c1083a.m58203a(this.f769e);
            c1083a.m58199a((Object) m59001a());
            this.f773a.m58265a(c1083a.m58201a(c1077a.m58298a()).m58195b().m58204a()).mo58221a(new C1000a(netCallback));
        } catch (Throwable th) {
            th.printStackTrace();
            netCallback.mo59048a(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    /* renamed from: b */
    public void m59002b(String str, String str2) {
        if (str == null) {
            NetLog.m58984a("GetExecutor", "name cannot be null !!!");
        } else {
            this.f770f.put(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GetExecutor.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1000a implements Callback {

        /* renamed from: a */
        final /* synthetic */ NetCallback f771a;

        C1000a(NetCallback netCallback) {
            this.f771a = netCallback;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Callback
        /* renamed from: a */
        public void mo58423a(Call call, IOException iOException) {
            NetCallback netCallback = this.f771a;
            if (netCallback != null) {
                netCallback.mo59048a(GetExecutor.this, iOException);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Callback
        /* renamed from: a */
        public void mo58424a(Call call, Response response) throws IOException {
            if (this.f771a != null) {
                HashMap hashMap = new HashMap();
                if (response != null) {
                    Headers m58844e = response.m58844e();
                    if (m58844e != null) {
                        for (int i = 0; i < m58844e.m58338b(); i++) {
                            hashMap.put(m58844e.m58341a(i), m58844e.m58337b(i));
                        }
                    }
                    this.f771a.mo59049a(GetExecutor.this, new NetResponse(response.m58843f(), response.m58846c(), response.m58842g(), hashMap, response.m58850a().m58817d(), response.m58837l(), response.m58839j()));
                }
            }
        }
    }
}
