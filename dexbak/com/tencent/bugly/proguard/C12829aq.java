package com.tencent.bugly.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.aq */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12829aq extends BroadcastReceiver {

    /* renamed from: d */
    private static C12829aq f36580d;

    /* renamed from: b */
    private Context f36582b;

    /* renamed from: c */
    private String f36583c;

    /* renamed from: e */
    private boolean f36584e = true;

    /* renamed from: a */
    private IntentFilter f36581a = new IntentFilter();

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            m15804a(context, intent);
        } catch (Throwable th) {
            if (C12820al.m15877a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static synchronized C12829aq m15806a() {
        C12829aq c12829aq;
        synchronized (C12829aq.class) {
            if (f36580d == null) {
                f36580d = new C12829aq();
            }
            c12829aq = f36580d;
        }
        return c12829aq;
    }

    /* renamed from: b */
    public final synchronized void m15800b(Context context) {
        try {
            C12820al.m15879a(C12829aq.class, "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f36582b = context;
        } catch (Throwable th) {
            if (C12820al.m15877a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public final synchronized void m15802a(String str) {
        if (!this.f36581a.hasAction(str)) {
            this.f36581a.addAction(str);
        }
        C12820al.m15874c("add action %s", str);
    }

    /* renamed from: a */
    public final synchronized void m15805a(Context context) {
        this.f36582b = context;
        C12828ap.m15835a(new Runnable() { // from class: com.tencent.bugly.proguard.aq.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C12820al.m15879a(C12829aq.f36580d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        C12829aq.this.f36582b.registerReceiver(C12829aq.f36580d, C12829aq.this.f36581a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* renamed from: a */
    private synchronized boolean m15804a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f36584e) {
                    this.f36584e = false;
                    return true;
                }
                String m15968c = C12787ab.m15968c(this.f36582b);
                C12820al.m15874c("is Connect BC ".concat(String.valueOf(m15968c)), new Object[0]);
                C12820al.m15878a("network %s changed to %s", this.f36583c, String.valueOf(m15968c));
                if (m15968c == null) {
                    this.f36583c = null;
                    return true;
                }
                String str = this.f36583c;
                this.f36583c = m15968c;
                long currentTimeMillis = System.currentTimeMillis();
                C12803ac m15950a = C12803ac.m15950a();
                C12814ai m15913a = C12814ai.m15913a();
                C12786aa m16009a = C12786aa.m16009a(context);
                if (m15950a != null && m15913a != null && m16009a != null) {
                    if (!m15968c.equals(str) && currentTimeMillis - m15913a.m15912a(C12848at.f36611a) > 30000) {
                        C12820al.m15878a("try to upload crash on network changed.", new Object[0]);
                        C12848at m15755a = C12848at.m15755a();
                        if (m15755a != null) {
                            m15755a.m15754a(0L);
                        }
                        C12820al.m15878a("try to upload userinfo on network changed.", new Object[0]);
                        C12912s.f36911b.m15552b();
                    }
                    return true;
                }
                C12820al.m15873d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
