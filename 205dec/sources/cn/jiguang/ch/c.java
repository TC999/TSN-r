package cn.jiguang.ch;

import android.content.Context;
import cn.jiguang.bq.d;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c extends cn.jiguang.cg.a {

    /* renamed from: a  reason: collision with root package name */
    private String f3405a;

    public c(Context context, String str) {
        super(context, str);
    }

    @Override // cn.jiguang.cg.a
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_type", this.f3405a);
            jSONObject.put("count", 1);
        } catch (Throwable th) {
            d.i("ExceptMonitor", "build getExtraJson data failed, " + th.getMessage());
        }
        return jSONObject;
    }

    public void a(String str) {
        this.f3405a = str;
    }

    @Override // cn.jiguang.cg.a
    public JSONObject b() {
        return super.b();
    }

    @Override // cn.jiguang.cg.a
    public String c() {
        return super.c();
    }
}
