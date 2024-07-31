package com.acse.ottn.util;

import com.acse.ottn.util.C1703va;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.util.ta */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1699ta implements Consumer<String> {

    /* renamed from: a */
    final /* synthetic */ String f3372a;

    /* renamed from: b */
    final /* synthetic */ C1703va.InterfaceC1704a f3373b;

    /* renamed from: c */
    final /* synthetic */ C1703va f3374c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1699ta(C1703va c1703va, String str, C1703va.InterfaceC1704a interfaceC1704a) {
        this.f3374c = c1703va;
        this.f3372a = str;
        this.f3373b = interfaceC1704a;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(String str) throws Exception {
        C1694ra.m55917a("MobclickAgentUtil", "统计发送成功 ==" + this.f3372a);
        if (!"heart_beat".equals(this.f3372a)) {
            if ("open_app".equals(this.f3372a)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getInt("code") == 1) {
                    C1661ba.m56097a().m56088b("softkeyboard_content", jSONObject.getString("content"));
                    return;
                }
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        C1661ba.m56097a().m56088b("appHeartbeat", C1650T.m56150d().m56161a());
        C1661ba.m56097a().m56088b("aes_key", jSONObject2.getString("aes_key"));
        C1661ba.m56097a().m56092a("send_state", jSONObject2.getString("send_state").equals("1"));
        C1661ba.m56097a().m56088b("show_ad_activity", str);
        C1703va.InterfaceC1704a interfaceC1704a = this.f3373b;
        if (interfaceC1704a != null) {
            interfaceC1704a.onSuccess();
        }
        C1694ra.m55917a("MobclickAgentUtil", "appStatistics s= " + str);
    }
}
