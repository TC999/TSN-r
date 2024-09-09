package com.bytedance.sdk.component.ev.w;

import android.text.TextUtils;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.t;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class xv {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f29748c;
    protected a xv;
    protected String sr = null;
    protected final Map<String, String> ux = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    protected String f29749f = null;

    /* renamed from: r  reason: collision with root package name */
    protected boolean f29750r = false;

    public xv(a aVar) {
        this.xv = aVar;
        w(UUID.randomUUID().toString());
    }

    public abstract com.bytedance.sdk.component.ev.w c();

    public void c(String str) {
        this.f29749f = str;
    }

    public void sr(Map<String, Object> map) {
        this.f29748c = map;
    }

    public void w(String str, String str2) {
        this.ux.put(str, str2);
    }

    public Map<String, Object> xv() {
        return this.f29748c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(t.c cVar) {
        if (cVar != null && this.ux.size() > 0) {
            for (Map.Entry<String, String> entry : this.ux.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    cVar.w(key, value);
                }
            }
        }
    }

    public void w(String str) {
        this.sr = str;
    }

    public String w() {
        return this.sr;
    }

    public void c(boolean z3) {
        this.f29750r = z3;
    }
}
