package cn.jpush.android.o;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import cn.jpush.android.ad.f;
import cn.jpush.android.ad.g;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.r.d;
import cn.jpush.android.s.c;
import cn.jpush.android.u.b;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f4282a;

    /* renamed from: b  reason: collision with root package name */
    private b f4283b;

    /* renamed from: d  reason: collision with root package name */
    private c f4285d;

    /* renamed from: c  reason: collision with root package name */
    private d f4284c = new d();

    /* renamed from: e  reason: collision with root package name */
    private List<String> f4286e = new ArrayList();

    /* renamed from: cn.jpush.android.o.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class C0070a extends f {

        /* renamed from: a  reason: collision with root package name */
        Context f4290a;

        /* renamed from: b  reason: collision with root package name */
        cn.jpush.android.d.d f4291b;

        public C0070a(Context context, cn.jpush.android.d.d dVar) {
            this.f4290a = context;
            this.f4291b = dVar;
        }

        @Override // cn.jpush.android.ad.f
        public void a() {
            try {
                if (a.o(this.f4290a, this.f4291b)) {
                    cn.jpush.android.q.a.a().b(this.f4290a, this.f4291b, "cn.jpush.android.intent.NOTIFY_INAPP_MESSAGE_ARRIVED");
                    return;
                }
                cn.jpush.android.q.a.a().a(this.f4290a, false);
                cn.jpush.android.q.a.a().b(this.f4290a, this.f4291b, "handle_message_failed");
            } catch (Throwable th) {
                Logger.ww("InAppManager", "notify inapp handle failed, " + th.getMessage());
            }
        }
    }

    public static a a() {
        if (f4282a == null) {
            synchronized (a.class) {
                if (f4282a == null) {
                    f4282a = new a();
                }
            }
        }
        return f4282a;
    }

    private void b(Context context) {
        try {
            if (context == null) {
                Logger.w("InAppManager", "dealNextCacheMessage param is null, context: " + context);
            } else if (!cn.jpush.android.ad.a.i(context) || c()) {
            } else {
                cn.jpush.android.q.a.a().a(context, (Bundle) null, "handle_cache_message");
            }
        } catch (Throwable th) {
            Logger.d("InAppManager", "handleNextCacheMessage  throwable=" + th);
        }
    }

    private void c(Context context) {
        try {
            d();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                d(context);
            } else {
                cn.jpush.android.q.a.a().b(context, this.f4283b.j(), 1003);
            }
        } catch (Throwable th) {
            Logger.w("InAppManager", "notify inapp dismiss failed, " + th.getMessage());
        }
    }

    private void d() {
        if (this.f4285d != null) {
            Logger.d("InAppManager", "cancel js load timer");
            this.f4285d.a();
        }
    }

    private void d(Context context) {
        if (this.f4284c == null || this.f4283b == null) {
            Logger.d("InAppManager", "notify inapp destroy wm is null");
            return;
        }
        try {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                this.f4284c.b(context, this.f4283b);
                this.f4283b.a((b.a) null);
                this.f4283b = null;
            } else {
                cn.jpush.android.q.a.a().b(context, this.f4283b.j(), 1003);
            }
            Logger.d("InAppManager", "notify inapp release completed");
        } catch (Throwable th) {
            Logger.w("InAppManager", "notify inapp release failed, " + th.getMessage());
        }
    }

    private void i(final Context context, final cn.jpush.android.d.d dVar) {
        Logger.d("InAppManager", "start h5 load timeout timer listener");
        d();
        c cVar = new c();
        this.f4285d = cVar;
        cVar.a(new c.a() { // from class: cn.jpush.android.o.a.1
            @Override // cn.jpush.android.s.c.a
            public void a() {
                Logger.ww("InAppManager", "js load callback timeout");
                a.this.f(context, dVar);
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 1000L);
    }

    private void j(Context context, cn.jpush.android.d.d dVar) {
        try {
            Logger.d("InAppManager", "handleCancelMessage  msgId=" + dVar.f4127d);
            if (40 == dVar.bs) {
                cn.jpush.android.helper.c.a(dVar.f4127d, 1602L, context);
            } else {
                cn.jpush.android.helper.c.a(context, dVar.f4127d, 2000L, 4);
            }
        } catch (Throwable th) {
            Logger.d("InAppManager", "handleCancelMessage  throwable=" + th);
        }
    }

    private void k(Context context, cn.jpush.android.d.d dVar) {
        try {
            Logger.d("InAppManager", "handleShowSuccess  msgId=" + dVar.f4127d);
            cn.jpush.android.x.b.a(context, JPushInterface.ACTION_IN_APP_MSG_SHOW, dVar, (Intent) null);
            n(context, dVar);
            if (40 != dVar.bs) {
                this.f4283b.d();
                if (30 == dVar.bs) {
                    cn.jpush.android.q.a.a().a(context, dVar, 1005);
                }
            }
            l(context, dVar);
            this.f4286e.add(dVar.f4127d);
            a(context, true);
            cn.jpush.android.r.b.a(context, dVar.ba);
        } catch (Throwable th) {
            Logger.d("InAppManager", "handleCancelMessage  throwable=" + th);
        }
    }

    private void l(Context context, cn.jpush.android.d.d dVar) {
        int i4 = dVar.bs;
        String str = dVar.f4127d;
        if (40 == i4) {
            cn.jpush.android.helper.c.a(str, 1600L, context);
        } else {
            cn.jpush.android.helper.c.a(context, str, 3000L, 4);
        }
    }

    private void m(Context context, cn.jpush.android.d.d dVar) {
        int i4 = dVar.bs;
        String str = dVar.f4127d;
        if (40 == i4) {
            cn.jpush.android.helper.c.a(str, 1604L, context);
        } else {
            cn.jpush.android.helper.c.a(context, str, 3012L, 4);
        }
    }

    private void n(Context context, cn.jpush.android.d.d dVar) {
        try {
            if (context == null || dVar == null) {
                Logger.w("InAppManager", "checkIsNeedSeedToNotification  context: " + context);
            } else if (dVar.ay == 104) {
                Logger.d("InAppManager", "start process notify message, msgType: " + dVar.ay + ", processName: " + cn.jpush.android.ad.a.c(context));
                Bundle bundle = new Bundle();
                bundle.putString("content", dVar.c());
                cn.jpush.android.q.a.a().a(context, bundle, "handle_notify_inapp_message");
            }
        } catch (Throwable th) {
            Logger.d("InAppManager", "checkIsNeedSeedToNotification  throwable=" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(Context context, cn.jpush.android.d.d dVar) {
        if (context == null || dVar == null) {
            Logger.w("InAppManager", "notify inapp handle param is null");
            return false;
        }
        if ((40 == dVar.bs ? cn.jpush.android.r.c.a(context, dVar) : cn.jpush.android.r.c.b(context, dVar)) == null) {
            Logger.ww("InAppManager", "notify inapp tpl dl failed");
            return false;
        }
        return true;
    }

    public void a(Context context) {
        if (context != null) {
            d(context);
        }
        cn.jpush.android.q.a.a().a(1005);
    }

    @Override // cn.jpush.android.u.b.a
    public void a(Context context, View view) {
    }

    @Override // cn.jpush.android.u.b.a
    public void a(Context context, View view, Object obj) {
        Logger.dd("InAppManager", "notify inapp dismiss");
        cn.jpush.android.q.a.a().a(1005);
        cn.jpush.android.p.a.a(context, System.currentTimeMillis());
        c(context);
        b(context);
    }

    public void a(Context context, cn.jpush.android.d.d dVar) {
        Logger.dd("InAppManager", "notify inapp inflate start");
        if (context == null || dVar == null) {
            Logger.w("InAppManager", "notify inapp inflate failed, param is null, context: " + context);
            return;
        }
        try {
            cn.jpush.android.r.b.a(context, dVar, dVar.bs);
            if (c()) {
                Logger.d("InAppManager", "notify inapp is showing now, return ");
                return;
            }
            cn.jpush.android.t.a a4 = cn.jpush.android.r.b.a(context, dVar.bs);
            if (a4 == null) {
                f(context, dVar);
                Logger.w("InAppManager", "notify inapp inflate failed, layout config is null");
                return;
            }
            b a5 = b.a(context, a4, dVar, dVar.bs);
            this.f4283b = a5;
            if (!a5.f()) {
                f(context, dVar);
                Logger.ww("InAppManager", "notify inapp inflate failed");
                return;
            }
            this.f4283b.a(this);
            if (40 != dVar.bs) {
                Logger.dd("InAppManager", "inapp start to show native");
                cn.jpush.android.q.a.a().b(context, dVar, 1002);
            } else {
                Logger.dd("InAppManager", "inapp start to show js web");
                i(context, dVar);
            }
            Logger.dd("InAppManager", "notify inapp inflate succeed");
        } catch (Throwable th) {
            f(context, dVar);
            Logger.w("InAppManager", "inflateNotifyInApp failed, " + th.getMessage());
        }
    }

    public void a(Context context, cn.jpush.android.d.d dVar, boolean z3) {
        d();
        if (context != null && dVar != null && z3) {
            Logger.dd("InAppManager", "notify inapp tpl load success will display");
            cn.jpush.android.q.a.a().b(context, dVar, 1002);
            return;
        }
        f(context, dVar);
        Logger.w("InAppManager", "notify inapp  load failed");
        Logger.d("InAppManager", "onLoadFail state, context: " + context + ", isSuccess: " + z3 + ", entity: " + dVar);
    }

    public void a(Context context, String str) {
        d dVar;
        if (context == null || (dVar = this.f4284c) == null || this.f4283b == null || !dVar.a(str) || !this.f4284c.a(this.f4283b)) {
            return;
        }
        Logger.d("InAppManager", "[onActivityDestroy] dismiss showing notify inapp, activityName: " + str);
        c(context);
    }

    public void a(Context context, boolean z3) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("result", z3);
        cn.jpush.android.q.a.a().a(context, bundle, "sync_view_show_success");
    }

    public void a(Context context, boolean z3, String str) {
        Logger.d("InAppManager", "onForegroundStateChange isForeground=" + z3 + " currentActivity=" + str);
        this.f4286e.clear();
        cn.jpush.android.p.a.a(context, -1L);
        a(context);
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("targert", str);
        }
        cn.jpush.android.q.a.a().a(context, bundle, "sync_target");
        if (z3) {
            Logger.d("InAppManager", "change to foreground, deal cache notify inapp");
            cn.jpush.android.q.a.a().a(context, (Bundle) null, "handle_cache_message");
        }
    }

    public void b(Context context, cn.jpush.android.d.d dVar) {
        try {
            if (context == null || dVar == null) {
                Logger.w("InAppManager", "notify inapp not display, param is null, context: " + context);
                f(context, dVar);
            } else if (!cn.jpush.android.ad.a.i(context)) {
                Logger.ww("InAppManager", "notify inapp not display in background");
            } else if (cn.jpush.android.x.d.a(context, dVar.f4127d, "")) {
                Logger.dd("InAppManager", "notify inapp is canceled already, not to show");
                j(context, dVar);
            } else {
                Activity a4 = cn.jpush.android.s.a.a(context);
                if (a4 == null || !this.f4284c.a(a4, this.f4283b)) {
                    Logger.ww("InAppManager", "notify inapp message display failed");
                    f(context, dVar);
                    return;
                }
                Logger.dd("InAppManager", "notify inapp message display success");
                k(context, dVar);
            }
        } catch (Throwable th) {
            f(context, dVar);
            Logger.ww("InAppManager", "notify inapp show failed" + th.getMessage());
        }
    }

    public void b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w("InAppManager", "[cancelNotifyInApp] unexpected param is null, cancelIds: " + str);
            return;
        }
        String[] split = str.split(",");
        int length = split.length;
        for (int i4 = 0; i4 < length; i4++) {
            String str2 = split[i4];
            if (!TextUtils.isEmpty(str2)) {
                cn.jpush.android.d.d a4 = cn.jpush.android.p.b.a().a(str2);
                if (cn.jpush.android.p.b.a().c(str2)) {
                    if (split.length == 2) {
                        str2 = split[1];
                    }
                    if (a4 == null || 40 == a4.bs) {
                        cn.jpush.android.helper.c.a(str2, 1602L, context);
                    } else {
                        cn.jpush.android.helper.c.a(context, str2, 4005L, 4);
                    }
                } else {
                    cn.jpush.android.d.d dVar = new cn.jpush.android.d.d();
                    dVar.f4127d = str2;
                    cn.jpush.android.x.b.a(context, "cn.jpush.android.intent.NOTIFY_INAPP_MESSAGE_CANCEL", dVar, (Intent) null);
                }
            }
        }
    }

    public boolean b() {
        StringBuilder sb = new StringBuilder();
        sb.append("hadDeleteMessage size=");
        sb.append(this.f4286e.size() > 0);
        Logger.d("InAppManager", sb.toString());
        return this.f4286e.size() > 0;
    }

    public void c(Context context, cn.jpush.android.d.d dVar) {
        b bVar;
        cn.jpush.android.d.d j4;
        if (context == null || dVar == null) {
            return;
        }
        String str = dVar.f4127d;
        if (!c() || (bVar = this.f4283b) == null || (j4 = bVar.j()) == null) {
            return;
        }
        Logger.d("InAppManager", "notify inapp cancel, cancel_messageId: " + str + ", msgId: " + j4.f4127d);
        if (TextUtils.equals(str, j4.f4127d)) {
            cn.jpush.android.q.a.a().b(context, j4, 1003);
            b(context);
            cn.jpush.android.p.a.a(context, System.currentTimeMillis());
        }
    }

    public boolean c() {
        d dVar = this.f4284c;
        return dVar != null && dVar.b(this.f4283b);
    }

    public void d(Context context, cn.jpush.android.d.d dVar) {
        Logger.dd("InAppManager", "notify inapp click");
        if (dVar != null) {
            g.a().a(context, dVar);
        }
        cn.jpush.android.p.a.a(context, System.currentTimeMillis());
        c(context);
        b(context);
    }

    public void e(Context context, cn.jpush.android.d.d dVar) {
        try {
            Logger.d("InAppManager", "handleMessageFailed  msgId=" + dVar.f4127d);
            n(context, dVar);
            m(context, dVar);
            b(context);
        } catch (Throwable th) {
            Logger.d("InAppManager", "handleMessageFailed  throwable=" + th);
        }
    }

    public void f(Context context, cn.jpush.android.d.d dVar) {
        try {
            Logger.d("InAppManager", "handleShowFailed  msgId=" + dVar.f4127d);
            a(context, false);
            n(context, dVar);
            c(context);
            m(context, dVar);
            b(context);
        } catch (Throwable th) {
            Logger.d("InAppManager", "handleShowFailed  throwable=" + th);
        }
    }

    public void g(Context context, cn.jpush.android.d.d dVar) {
        try {
            b bVar = this.f4283b;
            if (bVar != null) {
                bVar.g();
                cn.jpush.android.q.a.a().a(context, dVar, 1005);
            }
        } catch (Throwable th) {
            Logger.d("InAppManager", "handleCancelMessage  throwable=" + th);
        }
    }
}
