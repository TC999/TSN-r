package com.bytedance.sdk.component.adexpress.dynamic.sr;

import com.bytedance.sdk.component.adexpress.w.bk;
import com.bytedance.sdk.component.utils.a;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r implements ev {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.ux.w f29307c;

    /* JADX INFO: Access modifiers changed from: private */
    public void w(bk bkVar) {
        try {
            JSONObject xv = bkVar.xv();
            JSONObject jSONObject = new JSONObject(xv.optString("template_Plugin"));
            JSONObject optJSONObject = xv.optJSONObject("creative");
            com.bytedance.sdk.component.adexpress.dynamic.xv.ev c4 = new f(jSONObject, optJSONObject, xv.optJSONObject("AdSize"), new JSONObject(xv.optString("diff_template_Plugin"))).c(bkVar.w(), bkVar.p(), optJSONObject.optDouble("score_exact_i18n"), optJSONObject.optString("comment_num_i18n"), bkVar);
            try {
                JSONObject jSONObject2 = new JSONObject(optJSONObject.optString("dynamic_creative"));
                c4.c(jSONObject2.optString("color"));
                c4.c(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.f29307c.c(c4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.sr.ev
    public void c(com.bytedance.sdk.component.adexpress.dynamic.ux.w wVar) {
        this.f29307c = wVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.sr.ev
    public void c(final bk bkVar) {
        if (bkVar.a() == 1) {
            a.w("DynamicNativeParser", "parse on ui thread");
            w(bkVar);
            return;
        }
        com.bytedance.sdk.component.adexpress.sr.xv.c(new com.bytedance.sdk.component.gd.p("dynamicparse") { // from class: com.bytedance.sdk.component.adexpress.dynamic.sr.r.1
            @Override // java.lang.Runnable
            public void run() {
                a.w("DynamicNativeParser", "parse on non ui thread");
                r.this.w(bkVar);
            }
        }, 5);
    }
}
