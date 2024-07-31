package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import android.content.Context;
import android.location.Address;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IdUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.SPUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.ITTAdNetDepend;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.msdk.base.Sdk;
import java.util.Map;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTAdNetDepend implements ITTAdNetDepend {

    /* renamed from: a */
    private Context f621a;

    /* renamed from: c */
    String f623c = "sp_multi_ttmadnet_config";

    /* renamed from: b */
    private final SPUtils f622b = SPUtils.m59131a("sp_multi_ttmadnet_config", m59294g());

    public TTAdNetDepend(Context context) {
        this.f621a = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.ITTAdNetDepend
    /* renamed from: a */
    public Address mo59046a(Context context) {
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.ITTAdNetDepend
    /* renamed from: a */
    public String mo59045a(Context context, String str, String str2) {
        return this.f622b.m59130a(str, str2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.ITTAdNetDepend
    /* renamed from: a */
    public String[] mo59047a() {
        return new String[]{"dm.toutiao.com", "dm.bytedance.com", "dm.pstatp.com"};
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.ITTAdNetDepend
    /* renamed from: b */
    public String mo59043b() {
        return FaceEnvironment.f8430OS;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.ITTAdNetDepend
    /* renamed from: c */
    public int mo59042c() {
        return 4741;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.ITTAdNetDepend
    /* renamed from: d */
    public String mo59041d() {
        return "msdk";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.ITTAdNetDepend
    /* renamed from: e */
    public int mo59040e() {
        return Sdk.f21748a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.ITTAdNetDepend
    /* renamed from: f */
    public String mo59039f() {
        return IdUtils.m59191d(this.f621a);
    }

    /* renamed from: g */
    public Context m59294g() {
        return this.f621a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.ITTAdNetDepend
    /* renamed from: a */
    public void mo59044a(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.f622b.m59125b(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.f622b.m59124b(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.f622b.m59126b(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.f622b.m59122b(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.f622b.m59123b(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
