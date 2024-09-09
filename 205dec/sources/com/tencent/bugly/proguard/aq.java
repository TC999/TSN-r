package com.tencent.bugly.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class aq extends BroadcastReceiver {

    /* renamed from: d  reason: collision with root package name */
    private static aq f50954d;

    /* renamed from: b  reason: collision with root package name */
    private Context f50956b;

    /* renamed from: c  reason: collision with root package name */
    private String f50957c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f50958e = true;

    /* renamed from: a  reason: collision with root package name */
    private IntentFilter f50955a = new IntentFilter();

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static synchronized aq a() {
        aq aqVar;
        synchronized (aq.class) {
            if (f50954d == null) {
                f50954d = new aq();
            }
            aqVar = f50954d;
        }
        return aqVar;
    }

    public final synchronized void b(Context context) {
        try {
            al.a(aq.class, "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f50956b = context;
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final synchronized void a(String str) {
        if (!this.f50955a.hasAction(str)) {
            this.f50955a.addAction(str);
        }
        al.c("add action %s", str);
    }

    public final synchronized void a(Context context) {
        this.f50956b = context;
        ap.a(new Runnable() { // from class: com.tencent.bugly.proguard.aq.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    al.a(aq.f50954d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        aq.this.f50956b.registerReceiver(aq.f50954d, aq.this.f50955a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f50958e) {
                    this.f50958e = false;
                    return true;
                }
                String c4 = ab.c(this.f50956b);
                al.c("is Connect BC ".concat(String.valueOf(c4)), new Object[0]);
                al.a("network %s changed to %s", this.f50957c, String.valueOf(c4));
                if (c4 == null) {
                    this.f50957c = null;
                    return true;
                }
                String str = this.f50957c;
                this.f50957c = c4;
                long currentTimeMillis = System.currentTimeMillis();
                ac a4 = ac.a();
                ai a5 = ai.a();
                aa a6 = aa.a(context);
                if (a4 != null && a5 != null && a6 != null) {
                    if (!c4.equals(str) && currentTimeMillis - a5.a(at.f50984a) > PolicyConfig.mServerBusyRetryBaseInternal) {
                        al.a("try to upload crash on network changed.", new Object[0]);
                        at a7 = at.a();
                        if (a7 != null) {
                            a7.a(0L);
                        }
                        al.a("try to upload userinfo on network changed.", new Object[0]);
                        s.f51277b.b();
                    }
                    return true;
                }
                al.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
