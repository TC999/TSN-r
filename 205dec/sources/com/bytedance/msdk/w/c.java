package com.bytedance.msdk.w;

import android.content.Context;
import android.location.Address;
import com.bytedance.msdk.c.sr;
import com.bytedance.msdk.f.ls;
import com.bytedance.msdk.f.wv;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.sdk.component.ev.xv.w {

    /* renamed from: w  reason: collision with root package name */
    private Context f28466w;

    /* renamed from: c  reason: collision with root package name */
    String f28465c = "sp_multi_ttmadnet_config";
    private final wv xv = wv.c("sp_multi_ttmadnet_config", getContext());

    public c(Context context) {
        this.f28466w = context;
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public int c() {
        return 4741;
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public Address c(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public String c(Context context, String str, String str2) {
        return this.xv.w(str, str2);
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public String[] f() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public Context getContext() {
        return this.f28466w;
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public int sr() {
        return sr.c();
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public String ux() {
        return ls.c(this.f28466w);
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public String w() {
        return "msdk";
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public String xv() {
        return "android";
    }

    @Override // com.bytedance.sdk.component.ev.xv.w
    public void c(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.xv.c(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.xv.c(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.xv.c(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.xv.c(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.xv.c(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
