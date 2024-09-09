package cn.jiguang.ci;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class j extends k {

    /* renamed from: a  reason: collision with root package name */
    private String f3415a;

    /* renamed from: b  reason: collision with root package name */
    private String f3416b;

    /* renamed from: c  reason: collision with root package name */
    private int f3417c;

    /* renamed from: d  reason: collision with root package name */
    private int f3418d;

    public j(Context context) {
        super(context, "NET_HTTP");
    }

    public void a(HttpRequest httpRequest, boolean z3) {
        int length;
        this.f3415a = z3 ? "POST" : "GET";
        if (!z3) {
            String[] split = httpRequest.getUrl().split(" \\?");
            this.f3416b = split[0];
            if (split.length > 1) {
                length = split[1].getBytes().length;
            }
            e();
        }
        this.f3416b = httpRequest.getUrl();
        length = httpRequest.getParas().length;
        this.f3417c = length;
        e();
    }

    public void a(HttpResponse httpResponse) {
        f();
        d(httpResponse.getStatusCode());
        if (httpResponse.getStatusCode() == -1) {
            c(httpResponse.getResponseCode());
        }
        if (TextUtils.isEmpty(httpResponse.getResponseBody())) {
            return;
        }
        this.f3418d = httpResponse.getResponseBody().getBytes().length;
    }

    @Override // cn.jiguang.ci.k
    JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("method", this.f3415a);
        jSONObject.put("url", this.f3416b);
        jSONObject.put("request_byte", this.f3417c);
        jSONObject.put("response_byte", this.f3418d);
        return jSONObject;
    }
}
