package cn.jiguang.ay;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g extends cn.jiguang.ah.b {

    /* renamed from: a  reason: collision with root package name */
    public static String f2502a = ".permission.JPUSH_MESSAGE";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2503b;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    private static volatile g f2504d;

    /* renamed from: c  reason: collision with root package name */
    private Context f2505c;

    public static g d() {
        if (f2504d == null) {
            synchronized (c.class) {
                if (f2504d == null) {
                    f2504d = new g();
                }
            }
        }
        return f2504d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Context context) {
        String str;
        String str2 = "";
        try {
            if (cn.jiguang.ar.a.a().g(2900)) {
                return;
            }
            boolean c4 = cn.jiguang.ah.c.c(context, "JDeviceScreen");
            cn.jiguang.w.a.b("JDeviceScreen", "onReceive isReport:" + c4);
            if (c4) {
                boolean isScreenOn = ((PowerManager) context.getSystemService("power")).isScreenOn();
                cn.jiguang.w.a.b("JDeviceScreen", "onReceive isScreenOn:" + isScreenOn);
                boolean inKeyguardRestrictedInputMode = ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
                cn.jiguang.w.a.b("JDeviceScreen", "onReceive flag:" + inKeyguardRestrictedInputMode);
                boolean z3 = false;
                int i4 = 1;
                if (isScreenOn && !inKeyguardRestrictedInputMode) {
                    z3 = true;
                }
                if (!isScreenOn || inKeyguardRestrictedInputMode) {
                    i4 = (isScreenOn && inKeyguardRestrictedInputMode) ? 2 : 3;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("onReceive status:");
                sb.append(z3 ? "\u5f00" : "\u9501");
                cn.jiguang.w.a.b("JDeviceScreen", sb.toString());
                JSONObject jSONObject = new JSONObject();
                cn.jiguang.ah.d.a(context, jSONObject, "sc_status");
                jSONObject.put("status", z3);
                jSONObject.put("state", i4);
                String c5 = cn.jiguang.ag.a.c(context, "");
                try {
                    str = cn.jiguang.bd.a.a(context).getString("joad");
                } catch (Throwable unused) {
                    str = "";
                }
                if (!TextUtils.isEmpty(c5) || !TextUtils.isEmpty(str)) {
                    str2 = c5 + "|" + str;
                }
                jSONObject.put("dev_id", str2);
                cn.jiguang.ah.d.a(context, (Object) jSONObject);
                cn.jiguang.ah.c.h(context, "JDeviceScreen");
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2505c = context;
        return "JDeviceScreen";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        if (cn.jiguang.ar.a.a().g(2900)) {
            return;
        }
        try {
            c(context);
            super.b(context, str);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JDeviceScreen", "packageJson exception: " + th.getMessage());
        }
    }

    public void c(Context context) {
        try {
            if (f2503b) {
                return;
            }
            f2503b = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            cn.jiguang.ap.a.a(context, new BroadcastReceiver() { // from class: cn.jiguang.ay.g.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    if (intent == null) {
                        return;
                    }
                    try {
                        String action = intent.getAction();
                        cn.jiguang.w.a.b("JDeviceScreen", "onReceive Action:" + action);
                        g.this.g(context2);
                    } catch (Throwable unused) {
                    }
                }
            }, intentFilter, context.getPackageName() + f2502a, null);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
    }
}
