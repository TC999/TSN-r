package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import android.content.Context;
import android.location.Address;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.k;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.r;
import java.util.Map;

/* compiled from: TTAdNetDepend.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a implements bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f614a;

    /* renamed from: c  reason: collision with root package name */
    String f616c = "sp_multi_ttmadnet_config";

    /* renamed from: b  reason: collision with root package name */
    private final r f615b = r.a("sp_multi_ttmadnet_config", g());

    public a(Context context) {
        this.f614a = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public Address a(Context context) {
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String a(Context context, String str, String str2) {
        return this.f615b.a(str, str2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String[] a() {
        return new String[]{"dm.toutiao.com", "dm.bytedance.com", "dm.pstatp.com"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String b() {
        return "android";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public int c() {
        return 4741;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String d() {
        return "msdk";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public int e() {
        return com.bytedance.msdk.base.b.f27662a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public String f() {
        return k.d(this.f614a);
    }

    public Context g() {
        return this.f614a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b
    public void a(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.f615b.b(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.f615b.b(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.f615b.b(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.f615b.b(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.f615b.b(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
