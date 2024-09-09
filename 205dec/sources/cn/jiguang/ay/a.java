package cn.jiguang.ay;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.ReportCallBack;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a implements ReportCallBack {

    /* renamed from: a  reason: collision with root package name */
    private Context f2476a;

    /* renamed from: b  reason: collision with root package name */
    private String f2477b;

    /* renamed from: c  reason: collision with root package name */
    private String f2478c;

    public a(Context context, String str, String str2) {
        this.f2476a = context;
        this.f2477b = str;
        this.f2478c = str2;
    }

    @Override // cn.jiguang.api.ReportCallBack
    public void onFinish(int i4) {
        cn.jiguang.w.a.b("DeviceReport", "report finish code:" + i4);
        if (i4 != 0) {
            return;
        }
        cn.jiguang.ah.c.h(this.f2476a, this.f2478c);
        if (TextUtils.isEmpty(this.f2477b)) {
            return;
        }
        cn.jiguang.ah.c.u(this.f2476a, this.f2477b);
    }
}
