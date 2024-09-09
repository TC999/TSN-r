package cn.jiguang.ci;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class k extends cn.jiguang.cg.a {

    /* renamed from: a  reason: collision with root package name */
    private String f3419a;

    /* renamed from: b  reason: collision with root package name */
    private String f3420b;

    /* renamed from: c  reason: collision with root package name */
    private int f3421c;

    /* renamed from: d  reason: collision with root package name */
    private long f3422d;

    /* renamed from: e  reason: collision with root package name */
    private int f3423e;

    /* renamed from: f  reason: collision with root package name */
    private int f3424f;

    /* renamed from: g  reason: collision with root package name */
    private long f3425g;

    /* renamed from: h  reason: collision with root package name */
    private long f3426h;

    public k(Context context, String str) {
        super(context, str);
        this.f3419a = "unkown";
        this.f3420b = "unkown";
        this.f3419a = cn.jiguang.f.h.c(context);
        String b4 = cn.jiguang.f.h.b(context);
        if (TextUtils.isEmpty(b4)) {
            return;
        }
        this.f3419a = b4;
    }

    @Override // cn.jiguang.cg.a
    public JSONObject a() {
        try {
            this.f3422d = this.f3426h - this.f3425g;
            JSONObject d4 = d();
            d4.put("network_type", this.f3419a);
            d4.put("operate_type", this.f3420b);
            d4.put("signal_strength", this.f3421c);
            d4.put("cost_time", this.f3422d);
            d4.put("error_code", this.f3423e);
            d4.put("status_code", this.f3424f);
            d4.put("status_code", this.f3424f);
            return d4;
        } catch (JSONException e4) {
            cn.jiguang.bq.d.c("NetMoniter", "build netmoniter data error" + e4.getMessage());
            return null;
        }
    }

    public void c(int i4) {
        this.f3423e = i4;
    }

    abstract JSONObject d();

    public void d(int i4) {
        this.f3424f = i4;
    }

    public void e() {
        this.f3425g = System.currentTimeMillis();
    }

    public void f() {
        this.f3426h = System.currentTimeMillis();
    }
}
