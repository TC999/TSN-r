package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.OkHttpClient;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class NetExecutor {

    /* renamed from: a */
    protected OkHttpClient f773a;

    /* renamed from: b */
    protected String f774b = null;

    /* renamed from: c */
    protected final Map<String, String> f775c = new HashMap();

    /* renamed from: d */
    protected String f776d = null;

    public NetExecutor(OkHttpClient okHttpClient) {
        this.f773a = okHttpClient;
        m58999a(UUID.randomUUID().toString());
    }

    /* renamed from: a */
    public void m58998a(String str, String str2) {
        this.f775c.put(str, str2);
    }

    /* renamed from: b */
    public void m58997b(String str) {
        this.f776d = str;
    }

    /* renamed from: a */
    public void m58999a(String str) {
        this.f774b = str;
    }

    /* renamed from: a */
    public String m59001a() {
        return this.f774b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m59000a(Request.C1083a c1083a) {
        if (c1083a != null && this.f775c.size() > 0) {
            for (Map.Entry<String, String> entry : this.f775c.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    c1083a.m58196a(key, value);
                }
            }
        }
    }
}
