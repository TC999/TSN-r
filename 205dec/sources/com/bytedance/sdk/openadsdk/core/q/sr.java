package com.bytedance.sdk.openadsdk.core.q;

import android.content.Context;
import android.location.Address;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.ba;
import com.bytedance.sdk.openadsdk.core.i;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements com.bytedance.sdk.component.ev.xv.w {

    /* renamed from: c  reason: collision with root package name */
    String f34499c = "sp_multi_ttadnet_config";

    /* renamed from: w  reason: collision with root package name */
    com.bytedance.sdk.component.f.c f34500w = ba.c("sp_multi_ttadnet_config");
    private Context xv;

    public sr(Context context) {
        this.xv = context;
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public int c() {
        return Integer.parseInt("1371");
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public Address c(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public String[] f() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public Context getContext() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public int sr() {
        return eq.f33190w;
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public String ux() {
        return i.xv();
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public String w() {
        return "openadsdk";
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public String xv() {
        return "android";
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public String c(Context context, String str, String str2) {
        return this.f34500w.w(str, str2);
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public void c(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.f34500w.c(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.f34500w.c(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.f34500w.c(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.f34500w.c(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.f34500w.c(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
