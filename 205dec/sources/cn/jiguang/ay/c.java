package cn.jiguang.ay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.jpush.android.api.JPushInterface;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c extends cn.jiguang.ah.b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f2484c;

    /* renamed from: a  reason: collision with root package name */
    private Context f2485a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f2486b;

    public static c d() {
        if (f2484c == null) {
            synchronized (c.class) {
                if (f2484c == null) {
                    f2484c = new c();
                }
            }
        }
        return f2484c;
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2485a = context;
        return "JDeviceBattery";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        if (cn.jiguang.ar.a.a().g(1200)) {
            return;
        }
        try {
            Intent a4 = cn.jiguang.ap.a.a(context, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX, null);
            if (a4 == null) {
                return;
            }
            int intExtra = a4.getIntExtra("level", -1);
            int intExtra2 = a4.getIntExtra("scale", -1);
            int intExtra3 = a4.getIntExtra("status", -1);
            if (intExtra3 == 1) {
                intExtra3 = 0;
            } else if (intExtra3 == 2) {
                intExtra3 = 2;
            } else if (intExtra3 == 3 || intExtra3 == 4) {
                intExtra3 = 1;
            } else if (intExtra3 == 5) {
                intExtra3 = 3;
            }
            int intExtra4 = a4.getIntExtra("voltage", -1);
            int intExtra5 = a4.getIntExtra("temperature", -1);
            if (this.f2486b == null) {
                this.f2486b = new JSONObject();
            }
            this.f2486b.put("level", intExtra);
            this.f2486b.put("scale", intExtra2);
            this.f2486b.put("status", intExtra3);
            this.f2486b.put("voltage", intExtra4);
            this.f2486b.put("temperature", intExtra5);
            cn.jiguang.w.a.b("JDeviceBattery", "collect success:" + this.f2486b);
            super.b(context, str);
        } catch (JSONException e4) {
            cn.jiguang.w.a.f("JDeviceBattery", "packageJson exception: " + e4.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        if (cn.jiguang.ar.a.a().g(1200)) {
            return;
        }
        JSONObject jSONObject = this.f2486b;
        if (jSONObject == null) {
            cn.jiguang.w.a.f("JDeviceBattery", "there are no data to report");
            return;
        }
        cn.jiguang.ah.d.a(context, jSONObject, "battery");
        cn.jiguang.ah.d.a(context, (Object) this.f2486b);
        super.c(context, str);
        this.f2486b = null;
    }
}
