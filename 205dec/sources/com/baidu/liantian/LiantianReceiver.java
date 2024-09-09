package com.baidu.liantian;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.liantian.ac.Callback;
import com.baidu.liantian.ac.U;
import com.baidu.liantian.b.r;
import com.baidu.liantian.core.ApkInfo;
import com.baidu.liantian.core.g;
import com.baidu.liantian.core.h;
import com.baidu.liantian.rp.Report;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LiantianReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    Callback f12090a = new Callback() { // from class: com.baidu.liantian.LiantianReceiver.1
        @Override // com.baidu.liantian.ac.Callback
        public final Object onEnd(Object... objArr) {
            return super.onEnd(objArr);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private boolean f12091b = false;

    /* renamed from: c  reason: collision with root package name */
    private long f12092c = 0;

    public final LiantianReceiver a() {
        try {
            this.f12092c = System.currentTimeMillis();
            this.f12091b = true;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
        return this;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (!this.f12091b || System.currentTimeMillis() - this.f12092c >= 2000) {
                intent.toString();
                b.a();
                final boolean z3 = this.f12091b;
                r.a().a(new Runnable() { // from class: com.baidu.liantian.LiantianReceiver.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean z4;
                        ApkInfo d4;
                        try {
                            intent.toString();
                            b.a();
                            System.currentTimeMillis();
                            if ("r".equals(intent.getStringExtra("t"))) {
                                String stringExtra = intent.getStringExtra("c");
                                Intent intent2 = new Intent();
                                intent2.putExtra("t", "r");
                                intent2.putExtra("c", stringExtra);
                                a.a(context, intent2);
                            }
                            String action = intent.getAction();
                            if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.BOOT_COMPLETED")) {
                                com.baidu.liantian.b.e.d(context);
                                com.baidu.liantian.b.b.a(context, true);
                                Report.getInstance(context).r(true);
                                com.baidu.liantian.core.d.a(2);
                                com.baidu.liantian.core.d.a(StubApp.getOrigApplicationContext(context.getApplicationContext())).a(new Callback() { // from class: com.baidu.liantian.LiantianReceiver.2.1
                                    @Override // com.baidu.liantian.ac.Callback
                                    public final Object onEnd(Object... objArr) {
                                        g a4 = g.a();
                                        if (a4 == null) {
                                            return null;
                                        }
                                        List<ApkInfo> b4 = a4.b();
                                        if (b4 == null) {
                                            b4 = new ArrayList<>();
                                        }
                                        com.baidu.liantian.a.a a5 = com.baidu.liantian.a.a.a(context.getApplicationContext());
                                        for (ApkInfo apkInfo : b4) {
                                            String[] b5 = a5.b(apkInfo.packageName);
                                            if (b5 != null) {
                                                try {
                                                    Class<?> loadClass = apkInfo.classLoader.loadClass(b5[0]);
                                                    loadClass.getDeclaredMethod(b5[1], Context.class, Intent.class).invoke(loadClass.newInstance(), context.getApplicationContext(), intent);
                                                } catch (Throwable th) {
                                                    th.getMessage();
                                                    b.b();
                                                }
                                            }
                                        }
                                        return super.onEnd(objArr);
                                    }
                                });
                                return;
                            }
                            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.liantian.b.e.f(context) && U.sMonitorNetworkWhenUpgradeNoNet) {
                                new U(StubApp.getOrigApplicationContext(context.getApplicationContext()), 3, false).start();
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && com.baidu.liantian.b.e.f12113a && !z4 && com.baidu.liantian.b.e.e(context)) {
                                new U(StubApp.getOrigApplicationContext(context.getApplicationContext()), 3, false).start();
                            }
                            if (z3) {
                                return;
                            }
                            if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.PACKAGE_REMOVED")) {
                                com.baidu.liantian.b.e.a(context, intent);
                            }
                            String stringExtra2 = intent.getStringExtra("from_plugin_package");
                            if (TextUtils.isEmpty(stringExtra2)) {
                                g a4 = g.a();
                                if (a4 == null) {
                                    return;
                                }
                                List<ApkInfo> b4 = a4.b();
                                if (b4 != null) {
                                    for (int i4 = 0; i4 < b4.size(); i4++) {
                                        ApkInfo apkInfo = b4.get(i4);
                                        if (apkInfo.intentFilters != null) {
                                            for (int i5 = 0; i5 < apkInfo.intentFilters.size(); i5++) {
                                                h hVar = apkInfo.intentFilters.get(i5);
                                                if (hVar.f12221d.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), "PIF") >= 0) {
                                                    apkInfo.toString();
                                                    b.a();
                                                    Class<?> loadClass = apkInfo.classLoader.loadClass(hVar.f12219b);
                                                    loadClass.getDeclaredMethod(hVar.f12220c, Context.class, Intent.class).invoke(loadClass.newInstance(), StubApp.getOrigApplicationContext(context.getApplicationContext()), intent);
                                                }
                                            }
                                        }
                                    }
                                }
                                System.currentTimeMillis();
                                intent.toString();
                                b.a();
                            } else if (context.getPackageName().equals(stringExtra2)) {
                                LiantianReceiver.a(context.getClassLoader(), intent, context);
                            } else {
                                g a5 = g.a();
                                if (a5 == null || (d4 = a5.d(stringExtra2)) == null) {
                                    return;
                                }
                                LiantianReceiver.a(d4.classLoader, intent, context);
                                System.currentTimeMillis();
                                intent.toString();
                                b.a();
                            }
                        } catch (Throwable unused) {
                            com.baidu.liantian.b.e.a();
                        }
                    }
                });
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    static /* synthetic */ void a(ClassLoader classLoader, Intent intent, Context context) {
        try {
            Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("target_class"));
            loadClass.getDeclaredMethod(intent.getStringExtra("target_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), StubApp.getOrigApplicationContext(context.getApplicationContext()), intent);
        } catch (Throwable th) {
            th.getMessage();
            b.b();
        }
    }
}
