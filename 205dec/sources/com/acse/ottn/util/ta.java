package com.acse.ottn.util;

import com.acse.ottn.util.va;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class ta implements Consumer<String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6882a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ va.a f6883b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ va f6884c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ta(va vaVar, String str, va.a aVar) {
        this.f6884c = vaVar;
        this.f6882a = str;
        this.f6883b = aVar;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        ra.a("MobclickAgentUtil", "\u7edf\u8ba1\u53d1\u9001\u6210\u529f ==" + this.f6882a);
        if (!"heart_beat".equals(this.f6882a)) {
            if ("open_app".equals(this.f6882a)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getInt("code") == 1) {
                    C1419ba.a().b("softkeyboard_content", jSONObject.getString("content"));
                    return;
                }
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        C1419ba.a().b("appHeartbeat", T.d().a());
        C1419ba.a().b("aes_key", jSONObject2.getString("aes_key"));
        C1419ba.a().a("send_state", jSONObject2.getString("send_state").equals("1"));
        C1419ba.a().b("show_ad_activity", str);
        va.a aVar = this.f6883b;
        if (aVar != null) {
            aVar.onSuccess();
        }
        ra.a("MobclickAgentUtil", "appStatistics s= " + str);
    }
}
