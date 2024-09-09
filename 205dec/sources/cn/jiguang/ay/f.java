package cn.jiguang.ay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f extends cn.jiguang.ah.b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static volatile f f2496b;

    /* renamed from: a  reason: collision with root package name */
    private Context f2497a;

    /* renamed from: c  reason: collision with root package name */
    private String f2498c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f2499d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f2500e = "";

    /* renamed from: f  reason: collision with root package name */
    private cn.jiguang.u.c f2501f = null;

    public static f d() {
        if (f2496b == null) {
            synchronized (f.class) {
                if (f2496b == null) {
                    f2496b = new f();
                }
            }
        }
        return f2496b;
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2497a = context;
        return "JDeviceMac";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean a(Context context, String str) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 29) {
            cn.jiguang.w.a.b("JDeviceMac", "it need not business, because os version less than 29, current is " + i4);
            return false;
        }
        return super.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    @Override // cn.jiguang.ah.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.Context r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ay.f.b(android.content.Context, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        if (cn.jiguang.ar.a.a().e(1600)) {
            if (this.f2501f == null || TextUtils.isEmpty(this.f2499d)) {
                cn.jiguang.w.a.b("JDeviceMac", "it need not report, because no wifi info or mac, mac: " + this.f2499d);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("itime", cn.jiguang.ah.d.i(context));
                jSONObject.put("type", "ssid_mac_info");
                jSONObject.put("tag", this.f2501f.f3819c);
                jSONObject.put("l_mac_address", this.f2499d);
                jSONObject.put("ssid", this.f2501f.f3818b);
                cn.jiguang.ah.d.a(context, (Object) jSONObject);
                this.f2500e = this.f2501f.f3818b;
                this.f2498c = this.f2499d;
                this.f2501f = null;
                this.f2499d = "";
                super.c(context, str);
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JDeviceMac", "ssid mac report failed, " + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean d(Context context, String str) {
        return true;
    }
}
