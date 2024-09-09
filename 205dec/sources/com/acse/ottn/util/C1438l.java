package com.acse.ottn.util;

import com.acse.ottn.activity.AcseHelpManager;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* renamed from: com.acse.ottn.util.l  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1438l implements Consumer<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AcseHelpManager.OnAccessiblityStateCallBack f6845a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C1442n f6846b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1438l(C1442n c1442n, AcseHelpManager.OnAccessiblityStateCallBack onAccessiblityStateCallBack) {
        this.f6846b = c1442n;
        this.f6845a = onAccessiblityStateCallBack;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getInt("r") == 1) {
            String string = jSONObject.getString("state");
            if (!"0".equals(jSONObject.getString("save_local"))) {
                C1419ba.a().b("accessiblity_type", string);
            }
            AcseHelpManager.OnAccessiblityStateCallBack onAccessiblityStateCallBack = this.f6845a;
            if (onAccessiblityStateCallBack != null) {
                onAccessiblityStateCallBack.onSuccess(string);
            }
        }
    }
}
