package cn.jiguang.bm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.bp.j;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h {

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f2764c;

    /* renamed from: a  reason: collision with root package name */
    private static final BroadcastReceiver f2762a = new BroadcastReceiver() { // from class: cn.jiguang.bm.h.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            try {
                cn.jiguang.bp.h.a("JOperateProccessHelper", "onReceive:" + intent);
                if (intent == null) {
                    return;
                }
                final Context applicationContext = context.getApplicationContext();
                String action = intent.getAction();
                cn.jiguang.bp.h.a("JOperateProccessHelper", "action:" + action);
                if (!"cn.jiguang.joperate.to_main_process_action".equals(action) || (extras = intent.getExtras()) == null) {
                    return;
                }
                final String string = extras.getString("type");
                cn.jiguang.bp.h.a("JOperateProccessHelper", "type:" + string);
                final Bundle bundle = extras.getBundle("bundle_data");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                f.a(new Runnable() { // from class: cn.jiguang.bm.h.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.a(StubApp.getOrigApplicationContext(applicationContext.getApplicationContext()), string, bundle);
                    }
                }, new int[0]);
            } catch (Throwable unused) {
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2763b = false;

    /* renamed from: d  reason: collision with root package name */
    private static String f2765d = null;

    public static void a(Context context) {
        if (!f2763b && b(context)) {
            synchronized (h.class) {
                if (f2763b) {
                    return;
                }
                cn.jiguang.bp.h.a("JOperateProccessHelper", "init");
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("cn.jiguang.joperate.to_main_process_action");
                j.a(context, f2762a, intentFilter, c(context), null);
                f2763b = true;
            }
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        if (context.getPackageName().equals(f.h(context))) {
            return;
        }
        cn.jiguang.bp.h.a("JOperateProccessHelper", "toMainProcess:" + str);
        Intent intent = new Intent("cn.jiguang.joperate.to_main_process_action");
        intent.setPackage(context.getPackageName());
        intent.putExtra("type", str);
        intent.putExtra("bundle_data", bundle);
        StubApp.getOrigApplicationContext(context.getApplicationContext()).sendBroadcast(intent, c(context));
    }

    public static boolean b(Context context) {
        if (f2764c == null) {
            f2764c = Boolean.valueOf(context.getPackageName().equals(f.h(context)));
        }
        return f2764c.booleanValue();
    }

    private static String c(Context context) {
        String str = f2765d;
        if (str != null) {
            return str;
        }
        String str2 = context.getPackageName() + ".permission.JOPERATE_MESSAGE";
        if (!cn.jiguang.f.a.g(context, str2)) {
            if (cn.jiguang.bk.c.a().h()) {
                cn.jiguang.bp.h.e("JOperateProccessHelper", "The permission should be defined JO- " + str2);
            }
            str2 = context.getPackageName() + cn.jiguang.a.a.f2009a;
            if (!cn.jiguang.f.a.g(context, str2)) {
                if (cn.jiguang.bk.c.a().h()) {
                    cn.jiguang.bp.h.e("JOperateProccessHelper", "The permission should be defined JP- " + str2);
                }
                str2 = "android.permission.INTERNET";
            }
        }
        f2765d = str2;
        cn.jiguang.bp.h.a("JOperateProccessHelper", "getReceiverPermission:" + f2765d);
        return f2765d;
    }
}
