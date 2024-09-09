package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: NetExecutor.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected v f766a;

    /* renamed from: b  reason: collision with root package name */
    protected String f767b = null;

    /* renamed from: c  reason: collision with root package name */
    protected final Map<String, String> f768c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    protected String f769d = null;

    public b(v vVar) {
        this.f766a = vVar;
        a(UUID.randomUUID().toString());
    }

    public void a(String str, String str2) {
        this.f768c.put(str, str2);
    }

    public void b(String str) {
        this.f769d = str;
    }

    public void a(String str) {
        this.f767b = str;
    }

    public String a() {
        return this.f767b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y.a aVar) {
        if (aVar != null && this.f768c.size() > 0) {
            for (Map.Entry<String, String> entry : this.f768c.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    aVar.a(key, value);
                }
            }
        }
    }
}
