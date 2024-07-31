package com.amap.api.col.p0463l;

import android.content.Context;
import com.amap.api.col.p0463l.AuthConfigManager;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.a1 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractProtocalHandler<T, V> {

    /* renamed from: a */
    protected T f3517a;

    /* renamed from: b */
    protected int f3518b = 3;

    /* renamed from: c */
    protected Context f3519c;

    public AbstractProtocalHandler(Context context, T t) {
        m55752d(context, t);
    }

    /* renamed from: d */
    private void m55752d(Context context, T t) {
        this.f3519c = context;
        this.f3517a = t;
    }

    /* renamed from: g */
    private V m55750g() throws AMapException {
        int i;
        String str;
        AMapException aMapException;
        int i2 = 0;
        V v = null;
        AuthConfigManager.C1801c c1801c = null;
        while (i2 < this.f3518b) {
            try {
                c1801c = AuthConfigManager.m55061c(this.f3519c, C1732a3.m55691s(), mo54691b(), mo54689e());
                v = mo54692a(mo54690c(c1801c));
                i2 = this.f3518b;
            } finally {
                if (i2 < i) {
                    continue;
                }
            }
        }
        return v;
    }

    /* renamed from: a */
    protected abstract V mo54692a(JSONObject jSONObject) throws AMapException;

    /* renamed from: b */
    protected abstract String mo54691b();

    /* renamed from: c */
    protected abstract JSONObject mo54690c(AuthConfigManager.C1801c c1801c);

    /* renamed from: e */
    protected abstract Map<String, String> mo54689e();

    /* renamed from: f */
    public final V m55751f() throws AMapException {
        if (this.f3517a != null) {
            return m55750g();
        }
        return null;
    }
}
