package cn.jiguang.ac;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.af.f;
import cn.jiguang.ah.e;
import cn.jiguang.ao.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends e {

    /* renamed from: f  reason: collision with root package name */
    private static long f2054f;

    /* renamed from: a  reason: collision with root package name */
    private Context f2055a;

    /* renamed from: b  reason: collision with root package name */
    private cn.jiguang.ad.a f2056b;

    /* renamed from: c  reason: collision with root package name */
    private String f2057c;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, Boolean> f2058e = new HashMap<>();

    /* renamed from: cn.jiguang.ac.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private static class C0048a extends e {

        /* renamed from: a  reason: collision with root package name */
        private Context f2059a;

        public C0048a(Context context) {
            this.f2059a = context;
            this.f2244d = "JWake#RequestConfigAction";
        }

        @Override // cn.jiguang.ah.e
        public void a() {
            a.d(this.f2059a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private static class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private Context f2060a;

        public b(Context context) {
            this.f2060a = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                cn.jiguang.w.a.b("JWake", "unbind wake ServiceConnection");
                StubApp.getOrigApplicationContext(this.f2060a.getApplicationContext()).unbindService(this);
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JWake", "onServiceConnected throwable" + th.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public a(Context context, String str) {
        this.f2055a = context;
        this.f2057c = str;
        this.f2244d = "JWake";
    }

    public static Intent a(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent parseUri = Intent.parseUri(str, i4);
        Intent intent = new Intent(parseUri);
        parseUri.addCategory("android.intent.category.BROWSABLE");
        parseUri.setComponent(null);
        parseUri.setSelector(null);
        return intent;
    }

    public static Object a(Context context, Object obj) {
        if (obj instanceof List) {
            return cn.jiguang.af.c.a(cn.jiguang.af.b.b(context), (List) obj);
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x018e, code lost:
        r0 = cn.jiguang.af.c.a(r6);
        r0.putInt("type", 16);
        r18.addAccount(r10.type, "cn.jiguang.sdk.wake", null, r0, null, null, null);
        cn.jiguang.w.a.b("JWake", "use ACCOUNT wake up ,start add account to:" + r10.type);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01c1, code lost:
        cn.jiguang.ah.c.e(r32, "JWake_account");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01c6, code lost:
        r0 = true;
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01c9, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01ca, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x021c, code lost:
        cn.jiguang.w.a.b("JWake", "Fail to add account  caused by:" + r0);
        r11.f2093b.put(16, 101);
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x04ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x024e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0243 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0518 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017a A[Catch: all -> 0x021b, TryCatch #21 {all -> 0x021b, blocks: (B:47:0x016e, B:49:0x017a, B:50:0x017f, B:52:0x0182, B:54:0x018e, B:62:0x01d3, B:63:0x01fb, B:64:0x0208, B:65:0x020c), top: B:293:0x016e }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x020c A[Catch: all -> 0x021b, TRY_LEAVE, TryCatch #21 {all -> 0x021b, blocks: (B:47:0x016e, B:49:0x017a, B:50:0x017f, B:52:0x0182, B:54:0x018e, B:62:0x01d3, B:63:0x01fb, B:64:0x0208, B:65:0x020c), top: B:293:0x016e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<cn.jiguang.ad.b> a(android.content.Context r32, java.util.List<cn.jiguang.ad.c> r33) {
        /*
            Method dump skipped, instructions count: 1625
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ac.a.a(android.content.Context, java.util.List):java.util.List");
    }

    public static void a(Context context) {
        try {
            cn.jiguang.ah.d.a(new C0048a(context));
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWake", "[requestConfig failed] " + th.getMessage());
        }
    }

    private static void a(Context context, cn.jiguang.ad.a aVar) {
        boolean z3 = true;
        cn.jiguang.af.a.a(context, ((aVar.f2067b && aVar.f2069d) && cn.jiguang.ah.c.b(context)) ? false : false);
        c.a(context, aVar.f2077l, f2054f);
    }

    public static void a(Context context, String str) {
        try {
            cn.jiguang.ah.d.a(new a(context, str));
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWake", "[doAction failed] " + str + " :" + th.getMessage());
        }
    }

    private static boolean a(Context context, Bundle bundle, Intent intent) {
        String str;
        try {
            if (intent == null) {
                cn.jiguang.w.a.f("JWake", "Fail to start activity ,activityIntent is null !!");
                return false;
            }
            intent.addFlags(276824064);
            intent.putExtras(bundle);
            context.startActivity(intent);
            if (intent.getComponent() != null) {
                String className = intent.getComponent().getClassName();
                if (!"cn.jpush.android.service.DActivity".equals(className) && !"cn.jpush.android.service.BActivity".equals(className)) {
                    str = "JWake_activity";
                    cn.jiguang.ah.c.e(context, str);
                    return true;
                }
                str = "JWake_dactivity";
                cn.jiguang.ah.c.e(context, str);
                return true;
            }
            return true;
        } catch (Throwable th) {
            cn.jiguang.w.a.b("JWake", "Fail to start activity caused by:" + th);
            return false;
        }
    }

    private boolean a(Intent intent, String str, boolean z3) {
        return cn.jiguang.af.a.a(this.f2055a, str, intent, z3);
    }

    private boolean a(String str) {
        StringBuilder sb;
        String str2;
        List<String> list = this.f2056b.f2081p;
        if (list != null && list.contains(str)) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = " is in black list";
        } else if (TextUtils.isEmpty(this.f2056b.f2079n)) {
            return false;
        } else {
            if (this.f2056b.f2079n.equals("exclude")) {
                if (!this.f2056b.f2080o.contains(str)) {
                    return false;
                }
                sb = new StringBuilder();
                sb.append(str);
                str2 = " is in excloude list";
            } else if (!this.f2056b.f2079n.equals("include") || this.f2056b.f2080o.contains(str)) {
                return false;
            } else {
                sb = new StringBuilder();
                sb.append(str);
                str2 = " is not in include list";
            }
        }
        sb.append(str2);
        cn.jiguang.w.a.b("JWake", sb.toString());
        return true;
    }

    private boolean a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (String str : list) {
                        if (this.f2058e.containsKey(str)) {
                            Boolean bool = this.f2058e.get(str);
                            if (bool == null || !bool.booleanValue()) {
                                return true;
                            }
                            cn.jiguang.w.a.b("JWake", "checkSafeStatus blackPkgName = " + str);
                            return false;
                        }
                        boolean e4 = cn.jiguang.ag.a.e(this.f2055a, str);
                        this.f2058e.put(str, Boolean.valueOf(e4));
                        if (e4) {
                            cn.jiguang.w.a.b("JWake", "checkSafeStatus blackPkgName = " + str);
                            return false;
                        }
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JWake", "checkSafeStatus error:" + th);
            }
        }
        return true;
    }

    public static Object b(Context context) {
        boolean b4 = cn.jiguang.ah.c.b(context);
        cn.jiguang.w.a.b("JWake", "isActionUserEnable :" + b4);
        return Boolean.valueOf(b4);
    }

    private boolean b() {
        boolean b4 = cn.jiguang.ah.c.b(this.f2055a);
        cn.jiguang.w.a.b("JWake", "isActionUserEnable :" + b4);
        return b4;
    }

    private void c() {
        long j4 = this.f2056b.f2077l;
        f2054f = cn.jiguang.ah.c.f(this.f2055a, "JWakeConfigHelper");
        long currentTimeMillis = System.currentTimeMillis();
        cn.jiguang.w.a.b("JWake", "[refeshWakeConfig] currentTimeMillis:" + currentTimeMillis + ",lastBusinessTime:" + f2054f + ",wakeConfigInterval:" + j4);
        if (currentTimeMillis - f2054f < j4) {
            cn.jiguang.w.a.b("JWake", "need not get wake config");
            return;
        }
        cn.jiguang.ad.a d4 = d(this.f2055a);
        if (d4 != null) {
            this.f2056b = d4;
        }
        c.a(this.f2055a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static cn.jiguang.ad.a d(Context context) {
        try {
            JSONObject a4 = cn.jiguang.af.b.a(context);
            if (a4 != null) {
                cn.jiguang.af.b.a(context, i.b(a4.toString()));
                return cn.jiguang.af.b.a(context, a4);
            }
            return null;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWake", "[requestConfigNow] failed:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x022c A[ADDED_TO_REGION] */
    @android.annotation.TargetApi(15)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<cn.jiguang.ad.c> d() {
        /*
            Method dump skipped, instructions count: 753
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ac.a.d():java.util.List");
    }

    @Override // cn.jiguang.ah.e
    public void a() {
        try {
            cn.jiguang.w.a.b("JWake", "wake with:" + this.f2057c);
            if (!cn.jiguang.ah.d.e(this.f2055a)) {
                cn.jiguang.w.a.f("JWake", "can't w because not r yet");
                return;
            }
            this.f2056b = cn.jiguang.af.b.b(this.f2055a);
            c();
            cn.jiguang.w.a.b("JWake", "use config:" + this.f2056b);
            a(this.f2055a, this.f2056b);
            if (!b()) {
                cn.jiguang.w.a.b("JWake", "wake is disabled by user");
                return;
            }
            cn.jiguang.ad.a aVar = this.f2056b;
            if (aVar.f2066a && aVar.f2068c) {
                if (aVar.f2090y == 7) {
                    cn.jiguang.w.a.b("JWake", "all wakeup type is unsupported of app, not wakeup any package");
                    return;
                } else if (aVar.f2074i && this.f2057c.equals(CampaignEx.JSON_NATIVE_VIDEO_START)) {
                    if (!a(this.f2056b.f2091z)) {
                        cn.jiguang.w.a.b("JWake", "wake is disabled by unsafe package");
                        return;
                    }
                    f.a().a(this.f2055a, this.f2056b, d());
                    return;
                } else if (!this.f2056b.f2073h) {
                    cn.jiguang.w.a.b("JWake", "time disabled");
                    return;
                } else {
                    long f4 = cn.jiguang.ah.c.f(this.f2055a, "JWake");
                    long j4 = this.f2056b.f2072g;
                    long currentTimeMillis = System.currentTimeMillis();
                    cn.jiguang.w.a.b("JWake", "[wakeUp]currentTimeMillis:" + currentTimeMillis + ",lastBusinessTime:" + f4 + ",wakeInterval:" + j4);
                    if (currentTimeMillis - f4 < j4) {
                        cn.jiguang.w.a.b("JWake", "need not wake up");
                        return;
                    } else if (!a(this.f2056b.f2091z)) {
                        cn.jiguang.w.a.b("JWake", "wake is disabled by unsafe package");
                        return;
                    } else {
                        f.a().a(this.f2055a, this.f2056b, d());
                        return;
                    }
                }
            }
            cn.jiguang.w.a.b("JWake", "wake is disabled by server");
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JWake", "wake failed:" + th.getMessage());
        }
    }
}
