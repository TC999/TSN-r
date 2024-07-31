package com.acse.ottn.util;

import com.acse.ottn.activity.AcseHelpManager;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* renamed from: com.acse.ottn.util.l */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1680l implements Consumer<String> {

    /* renamed from: a */
    final /* synthetic */ AcseHelpManager.OnAccessiblityStateCallBack f3335a;

    /* renamed from: b */
    final /* synthetic */ C1684n f3336b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1680l(C1684n c1684n, AcseHelpManager.OnAccessiblityStateCallBack onAccessiblityStateCallBack) {
        this.f3336b = c1684n;
        this.f3335a = onAccessiblityStateCallBack;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getInt("r") == 1) {
            String string = jSONObject.getString("state");
            if (!"0".equals(jSONObject.getString("save_local"))) {
                C1661ba.m56097a().m56088b("accessiblity_type", string);
            }
            AcseHelpManager.OnAccessiblityStateCallBack onAccessiblityStateCallBack = this.f3335a;
            if (onAccessiblityStateCallBack != null) {
                onAccessiblityStateCallBack.onSuccess(string);
            }
        }
    }
}
