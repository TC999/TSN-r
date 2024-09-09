package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.g4;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AbstractProtocalHandler.java */
/* renamed from: com.amap.api.col.3l.a1  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class a1<T, V> {

    /* renamed from: a  reason: collision with root package name */
    protected T f7083a;

    /* renamed from: b  reason: collision with root package name */
    protected int f7084b = 3;

    /* renamed from: c  reason: collision with root package name */
    protected Context f7085c;

    public a1(Context context, T t3) {
        d(context, t3);
    }

    private void d(Context context, T t3) {
        this.f7085c = context;
        this.f7083a = t3;
    }

    private V g() throws AMapException {
        int i4;
        String str;
        AMapException aMapException;
        int i5 = 0;
        V v3 = null;
        g4.c cVar = null;
        while (i5 < this.f7084b) {
            try {
                cVar = g4.c(this.f7085c, a3.s(), b(), e());
                v3 = a(c(cVar));
                i5 = this.f7084b;
            } finally {
                if (i5 < i4) {
                    continue;
                }
            }
        }
        return v3;
    }

    protected abstract V a(JSONObject jSONObject) throws AMapException;

    protected abstract String b();

    protected abstract JSONObject c(g4.c cVar);

    protected abstract Map<String, String> e();

    public final V f() throws AMapException {
        if (this.f7083a != null) {
            return g();
        }
        return null;
    }
}
