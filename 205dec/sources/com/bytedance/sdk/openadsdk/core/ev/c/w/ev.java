package com.bytedance.sdk.openadsdk.core.ev.c.w;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.Map;

@com.bytedance.sdk.component.p.w.w(c = "SINGLETON")
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev implements com.bytedance.sdk.component.p.c.c.xv {
    @com.bytedance.sdk.component.p.w.c(c = "material_meta")

    /* renamed from: c  reason: collision with root package name */
    private me f33448c;
    @com.bytedance.sdk.component.p.w.c(c = "is_open_web_page")

    /* renamed from: f  reason: collision with root package name */
    private boolean f33449f;
    @com.bytedance.sdk.component.p.w.c(c = "interaction_type")
    private int sr;
    @com.bytedance.sdk.component.p.w.c(c = "activity_type")
    private int ux;
    @com.bytedance.sdk.component.p.w.c(c = "context")

    /* renamed from: w  reason: collision with root package name */
    private Context f33450w;
    @com.bytedance.sdk.component.p.w.c(c = "url")
    private String xv;

    @Override // com.bytedance.sdk.component.p.c.c.xv
    public boolean c(Map<String, Object> map, final Map<String, Object> map2, final com.bytedance.sdk.component.p.c.c cVar) {
        if (this.f33449f) {
            return true;
        }
        if (this.sr == 2) {
            boolean c4 = c();
            if (c4) {
                cVar.c(map2);
            } else {
                cVar.w(map2);
            }
            return c4;
        }
        Intent intent = new Intent(this.f33450w, wv.f(this.ux));
        if (!(this.f33450w instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("is_outer_click", true);
        if (map == null) {
            cVar.w(map2);
        }
        map.putAll(map2);
        map.remove("context");
        map.remove("activity_type");
        Object remove = map.remove("source");
        wv.c(map, this.f33448c);
        intent.putExtra("source", remove == null ? -1 : Integer.parseInt(remove.toString()));
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                intent.putExtra(entry.getKey(), value.toString());
            }
        }
        com.bytedance.sdk.component.utils.w.c(this.f33450w, intent, new w.c() { // from class: com.bytedance.sdk.openadsdk.core.ev.c.w.ev.1
            @Override // com.bytedance.sdk.component.utils.w.c
            public void c() {
                cVar.c(map2);
                map2.put("is_open_web_page", Boolean.TRUE);
            }

            @Override // com.bytedance.sdk.component.utils.w.c
            public void c(Throwable th) {
                cVar.w(map2);
            }
        });
        return true;
    }

    private boolean c() {
        if (com.bytedance.sdk.component.utils.ys.c(this.xv)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                intent.setData(Uri.parse(this.xv));
                if (!(this.f33450w instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                com.bytedance.sdk.component.utils.w.c(this.f33450w, intent, null);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }
}
