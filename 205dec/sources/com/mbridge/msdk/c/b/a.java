package com.mbridge.msdk.c.b;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.x;
import java.util.List;

/* compiled from: ActiveAppUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f38722a;

    /* renamed from: b  reason: collision with root package name */
    private List<com.mbridge.msdk.foundation.entity.a> f38723b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f38724c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f38725d;

    /* compiled from: ActiveAppUtil.java */
    /* renamed from: com.mbridge.msdk.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static class C0728a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f38727a = new a();
    }

    public static a a() {
        return C0728a.f38727a;
    }

    public final void b() {
        Handler handler = this.f38725d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final boolean c() {
        return this.f38724c;
    }

    public final synchronized void d() {
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 != null) {
            if (b4.aN() == 2) {
                b();
            } else {
                List<com.mbridge.msdk.foundation.entity.a> aP = b4.aP();
                if (aP != null && aP.size() != 0) {
                    this.f38723b = aP;
                }
                b();
            }
        }
    }

    public final synchronized void e() {
        if (com.mbridge.msdk.foundation.controller.a.f().j() == null) {
            return;
        }
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 != null && b4.aN() != 2) {
            List<com.mbridge.msdk.foundation.entity.a> aP = b4.aP();
            this.f38723b = aP;
            if (aP != null && aP.size() != 0) {
                long longValue = ((Long) ae.b(com.mbridge.msdk.foundation.controller.a.f().j(), "active_last_time", 0L)).longValue();
                Message obtain = Message.obtain();
                if (longValue == 0) {
                    obtain.what = 1;
                    obtain.arg1 = b4.aO() * 1000;
                } else {
                    long currentTimeMillis = System.currentTimeMillis() - longValue;
                    int aO = b4.aO() * 1000;
                    long j4 = aO;
                    if (currentTimeMillis > j4) {
                        obtain.what = 1;
                        obtain.arg1 = aO;
                    } else {
                        obtain.what = 2;
                        obtain.arg1 = (int) (j4 - currentTimeMillis);
                        obtain.arg2 = aO;
                    }
                }
                this.f38725d.sendMessage(obtain);
                this.f38724c = true;
                x.d("ActiveAppUtil", "init");
            }
        }
    }

    private a() {
        this.f38722a = "ActiveAppUtil";
        this.f38724c = false;
        this.f38725d = new Handler() { // from class: com.mbridge.msdk.c.b.a.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                synchronized (a.this) {
                    Message obtain = Message.obtain();
                    int i4 = message.what;
                    if (i4 == 1) {
                        a.a(a.this);
                        obtain.what = 1;
                        obtain.arg1 = message.arg1;
                        sendMessageDelayed(obtain, message.arg1);
                    } else if (i4 == 2) {
                        obtain.what = 1;
                        obtain.arg1 = message.arg2;
                        sendMessageDelayed(obtain, message.arg1);
                    }
                }
            }
        };
    }

    static /* synthetic */ void a(a aVar) {
        if (com.mbridge.msdk.foundation.controller.a.f().j() == null) {
            return;
        }
        List<com.mbridge.msdk.foundation.entity.a> list = aVar.f38723b;
        if (list == null || list.size() == 0) {
            aVar.b();
        }
        ae.a(com.mbridge.msdk.foundation.controller.a.f().j(), "active_last_time", Long.valueOf(System.currentTimeMillis()));
        try {
            for (com.mbridge.msdk.foundation.entity.a aVar2 : aVar.f38723b) {
                Intent intent = new Intent();
                if (aVar2.b().contains("service")) {
                    if (!TextUtils.isEmpty(aVar2.a()) && !TextUtils.isEmpty(aVar2.c())) {
                        intent.setComponent(new ComponentName(aVar2.a(), aVar2.c()));
                        if (!TextUtils.isEmpty(aVar2.d())) {
                            intent.setAction(aVar2.d());
                        }
                        if (Build.VERSION.SDK_INT >= 26) {
                            com.mbridge.msdk.foundation.controller.a.f().j().startForegroundService(intent);
                        } else {
                            com.mbridge.msdk.foundation.controller.a.f().j().startService(intent);
                        }
                    }
                    return;
                }
                if (aVar2.b().contains("broadcast")) {
                    if (!TextUtils.isEmpty(aVar2.a()) && !TextUtils.isEmpty(aVar2.c()) && !TextUtils.isEmpty(aVar2.d())) {
                        intent.setComponent(new ComponentName(aVar2.a(), aVar2.c()));
                        intent.setAction(aVar2.d());
                        com.mbridge.msdk.foundation.controller.a.f().j().sendBroadcast(intent);
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            x.d("ActiveAppUtil", th.getMessage());
        }
    }
}
