package cn.jpush.android.f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.text.TextUtils;
import cn.jiguang.push.asus.PushMessageReceiver;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4184a;

    /* renamed from: b  reason: collision with root package name */
    public static String f4185b;

    /* renamed from: g  reason: collision with root package name */
    private static cn.jpush.android.g.a f4190g;

    /* renamed from: h  reason: collision with root package name */
    private static String f4191h;

    /* renamed from: i  reason: collision with root package name */
    private static Boolean f4192i;

    /* renamed from: f  reason: collision with root package name */
    private static AtomicLong f4189f = new AtomicLong(0);

    /* renamed from: c  reason: collision with root package name */
    public static String f4186c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f4187d = false;

    /* renamed from: e  reason: collision with root package name */
    public static String f4188e = "com.asus.as";

    /* renamed from: j  reason: collision with root package name */
    private static ExecutorService f4193j = Executors.newSingleThreadExecutor();

    public static long a() {
        long incrementAndGet = f4189f.incrementAndGet();
        if (incrementAndGet == Long.MAX_VALUE) {
            f4189f.set(0L);
        }
        return incrementAndGet;
    }

    public static void a(Context context, String str, long j4, JSONObject jSONObject) {
        if (c(context)) {
            f4193j.execute(new d(str, j4, jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(String str, long j4, JSONObject jSONObject) {
        cn.jpush.android.g.a aVar = f4190g;
        if (!(aVar != null ? aVar.b() : false)) {
            cn.jpush.android.i.b.a("Gobal", "connect has disconnect, will reconnect.");
            cn.jpush.android.g.a aVar2 = f4190g;
            if (aVar2 != null) {
                aVar2.a();
            }
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("JPUSH_PACKAGE", f4186c);
            if (j4 <= 0) {
                j4 = a();
            }
            jSONObject.put("JPUSH_RID", j4);
            String jSONObject2 = jSONObject.toString();
            cn.jpush.android.i.b.c("Gobal", "cmd:" + str + ",data:" + jSONObject2);
            cn.jpush.android.g.a aVar3 = f4190g;
            if (aVar3 != null) {
                aVar3.a(str, jSONObject2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a(Context context) {
        return cn.jpush.android.g.c.a(context, f4188e);
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(f4191h)) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.ups.push.PUSH_RESPONSE");
                intent.setPackage(context.getPackageName());
                ComponentInfo a4 = cn.jpush.android.j.a.a(context, context.getPackageName(), PushMessageReceiver.class);
                if (a4 != null) {
                    f4191h = a4.name;
                    cn.jpush.android.i.a.a("ASUS_PUSH", "Gobal", 4, "found userServiceClass :" + f4191h + " by getComponentInfo");
                }
            } catch (Throwable th) {
                cn.jpush.android.i.b.e("Gobal", "not found PushMessageReceiver :" + th.getMessage());
            }
            return f4191h;
        }
        return f4191h;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(android.content.Context r6) {
        /*
            java.lang.String r0 = "asus_default_channel_id"
            java.lang.Boolean r1 = cn.jpush.android.f.c.f4192i
            if (r1 == 0) goto Lb
            boolean r6 = r1.booleanValue()
            return r6
        Lb:
            r1 = 0
            java.lang.String r2 = "Gobal"
            if (r6 != 0) goto L16
            java.lang.String r6 = "context is null"
            cn.jpush.android.i.b.g(r2, r6)
            return r1
        L16:
            boolean r3 = cn.jpush.android.j.a.a(r6)
            r4 = 0
            java.lang.String r5 = "ConnectionFactory"
            if (r3 != 0) goto L25
            java.lang.String r3 = "Manufacturer not match, give up create connection."
        L21:
            cn.jpush.android.i.b.f(r5, r3)
            goto L35
        L25:
            java.lang.String r3 = cn.jpush.android.f.c.f4188e
            boolean r3 = cn.jpush.android.g.c.a(r6, r3)
            if (r3 != 0) goto L30
            java.lang.String r3 = "cn.jpush.android.service.PushManagerService not exist in system, give up create connection."
            goto L21
        L30:
            cn.jpush.android.g.d r4 = new cn.jpush.android.g.d
            r4.<init>()
        L35:
            cn.jpush.android.f.c.f4190g = r4
            if (r4 != 0) goto L44
            java.lang.String r6 = "unsupport this device."
            cn.jpush.android.i.b.g(r2, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            cn.jpush.android.f.c.f4192i = r6
            return r1
        L44:
            android.content.Context r1 = r6.getApplicationContext()
            android.content.Context r1 = com.stub.StubApp.getOrigApplicationContext(r1)
            cn.jpush.android.f.c.f4184a = r1
            java.lang.String r1 = r1.getPackageName()
            cn.jpush.android.f.c.f4186c = r1
            cn.jpush.android.a.a.a(r6)
            java.lang.String r1 = "notification"
            java.lang.Object r6 = r6.getSystemService(r1)     // Catch: java.lang.Throwable -> L7d
            android.app.NotificationManager r6 = (android.app.NotificationManager) r6     // Catch: java.lang.Throwable -> L7d
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L7d
            r3 = 26
            if (r1 < r3) goto L93
            android.app.NotificationChannel r1 = r6.getNotificationChannel(r0)     // Catch: java.lang.Throwable -> L7d
            if (r1 != 0) goto L93
            java.lang.String r1 = "create default channel:\u9ed8\u8ba4"
            cn.jpush.android.i.b.b(r2, r1)     // Catch: java.lang.Throwable -> L7d
            android.app.NotificationChannel r1 = new android.app.NotificationChannel     // Catch: java.lang.Throwable -> L7d
            java.lang.String r3 = "\u9ed8\u8ba4"
            r4 = 3
            r1.<init>(r0, r3, r4)     // Catch: java.lang.Throwable -> L7d
            r6.createNotificationChannel(r1)     // Catch: java.lang.Throwable -> L7d
            goto L93
        L7d:
            r6 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "[initNotificationChannel] failed:"
            r0.<init>(r1)
            java.lang.String r6 = r6.getMessage()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            cn.jpush.android.i.b.e(r2, r6)
        L93:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            cn.jpush.android.f.c.f4192i = r6
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.f.c.c(android.content.Context):boolean");
    }
}
