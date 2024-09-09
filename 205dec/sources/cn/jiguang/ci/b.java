package cn.jiguang.ci;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends k {

    /* renamed from: a  reason: collision with root package name */
    private int f3406a;

    /* renamed from: b  reason: collision with root package name */
    private String f3407b;

    /* renamed from: c  reason: collision with root package name */
    private String f3408c;

    /* renamed from: d  reason: collision with root package name */
    private int f3409d;

    public b(Context context, String str) {
        super(context, str);
        this.f3407b = "";
        this.f3408c = "";
        this.f3406a = !cn.jiguang.bt.b.f2891a ? 1 : 0;
    }

    public void b(int i4) {
        this.f3409d = i4;
    }

    public void b(String str) {
        this.f3407b = str;
    }

    public void c(String str) {
        this.f3408c = str;
    }

    @Override // cn.jiguang.ci.k
    JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("is_foreground", this.f3406a);
        jSONObject.put("tcp_id", this.f3407b);
        jSONObject.put("host", this.f3408c);
        jSONObject.put("port", this.f3409d);
        return jSONObject;
    }
}
