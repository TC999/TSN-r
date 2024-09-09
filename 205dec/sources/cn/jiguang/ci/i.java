package cn.jiguang.ci;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i extends cn.jiguang.cg.a {

    /* renamed from: a  reason: collision with root package name */
    private String f3410a;

    /* renamed from: b  reason: collision with root package name */
    private long f3411b;

    /* renamed from: c  reason: collision with root package name */
    private long f3412c;

    /* renamed from: d  reason: collision with root package name */
    private long f3413d;

    /* renamed from: e  reason: collision with root package name */
    private String f3414e;

    public i(Context context) {
        super(context, "NET_DATA");
    }

    @Override // cn.jiguang.cg.a
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f3414e);
            jSONObject.put("res", this.f3412c);
            jSONObject.put("req", this.f3411b);
            jSONObject.put("type", this.f3410a);
            jSONObject.put("count", this.f3413d);
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("NetDataLengthMonitor", "build getExtraJson data failed, " + th.getMessage());
        }
        return jSONObject;
    }

    public void a(long j4) {
        this.f3412c = j4;
    }

    public void a(String str) {
        this.f3414e = str;
    }

    public void b(long j4) {
        this.f3411b = j4;
    }

    public void b(String str) {
        this.f3410a = str;
    }

    public void c(long j4) {
        this.f3413d = j4;
    }
}
