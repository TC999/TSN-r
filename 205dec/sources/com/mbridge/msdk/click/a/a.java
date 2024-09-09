package com.mbridge.msdk.click.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.x;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: RetryReportControl.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f38801a = "mtg_retry_report=1";

    /* renamed from: b  reason: collision with root package name */
    public static int f38802b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public static int f38803c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static int f38804d = 50;

    /* renamed from: e  reason: collision with root package name */
    public static int f38805e = 600000;

    /* renamed from: f  reason: collision with root package name */
    public static int f38806f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f38807g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static int f38808h = 2;

    /* renamed from: i  reason: collision with root package name */
    public static int f38809i = 3;

    /* renamed from: j  reason: collision with root package name */
    public static int f38810j = 4;

    /* renamed from: k  reason: collision with root package name */
    public static int f38811k = 5;

    /* renamed from: l  reason: collision with root package name */
    private static String f38812l = "RetryReportControl";

    /* renamed from: o  reason: collision with root package name */
    private static int f38813o;

    /* renamed from: p  reason: collision with root package name */
    private static int f38814p;

    /* renamed from: m  reason: collision with root package name */
    private ConcurrentHashMap<String, com.mbridge.msdk.click.a.b> f38815m;

    /* renamed from: n  reason: collision with root package name */
    private c f38816n;

    /* renamed from: q  reason: collision with root package name */
    private BroadcastReceiver f38817q;

    /* renamed from: r  reason: collision with root package name */
    private final Handler f38818r;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RetryReportControl.java */
    /* renamed from: com.mbridge.msdk.click.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0730a {

        /* renamed from: a  reason: collision with root package name */
        private static a f38822a = new a();
    }

    /* compiled from: RetryReportControl.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i4 = message.what;
            if (i4 != 1) {
                if (i4 != 2) {
                    return;
                }
                a.a(a.a());
                return;
            }
            Object obj = message.obj;
            if (obj instanceof String) {
                a.a().a((String) obj, com.mbridge.msdk.click.a.b.f38823a);
            }
        }
    }

    private a() {
        this.f38815m = new ConcurrentHashMap<>();
        this.f38816n = new c(f38804d);
        this.f38818r = new b(Looper.getMainLooper());
        com.mbridge.msdk.c.a g4 = com.mbridge.msdk.c.b.a().g(com.mbridge.msdk.foundation.controller.a.f().k());
        f38803c = g4.g();
        f38802b = g4.i() * 1000;
        f38805e = g4.h() * 1000;
        f38813o = g4.f();
        f38814p = g4.e();
        try {
            if (this.f38817q == null) {
                this.f38817q = new BroadcastReceiver() { // from class: com.mbridge.msdk.click.a.a.2
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context, Intent intent) {
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            a.this.f38818r.sendEmptyMessage(2);
                        }
                    }
                };
                Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
                if (j4 != null) {
                    j4.registerReceiver(this.f38817q, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static a a() {
        return C0730a.f38822a;
    }

    private void a(com.mbridge.msdk.click.a.b bVar) {
        String str;
        String str2;
        try {
            CampaignEx f4 = bVar.f();
            if (f4 != null) {
                String requestId = f4.getRequestId();
                str2 = f4.getRequestIdNotice();
                str = requestId;
            } else {
                str = "";
                str2 = str;
            }
            a(com.mbridge.msdk.foundation.controller.a.f().j(), bVar.i().toString(), bVar.g(), str, str2, bVar.d());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean b(int i4) {
        return i4 == f38807g || i4 == f38808h;
    }

    private static void a(Context context, String str, String str2, String str3, String str4, int i4) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000105&");
                stringBuffer.append("url=" + URLEncoder.encode(str2, "utf-8") + "&");
                stringBuffer.append("type=" + i4 + "&");
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39391s)) {
                    stringBuffer.append("b=" + com.mbridge.msdk.foundation.same.a.f39391s + "&");
                }
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f39392t)) {
                    stringBuffer.append("c=" + com.mbridge.msdk.foundation.same.a.f39392t + "&");
                }
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append("rid=");
                    stringBuffer.append(str3);
                    stringBuffer.append("&");
                }
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append("rid_n=");
                    stringBuffer.append(str4);
                    stringBuffer.append("&");
                }
                stringBuffer.append("reason=" + URLEncoder.encode(str, "utf-8"));
                if (com.mbridge.msdk.foundation.same.report.b.a().c()) {
                    com.mbridge.msdk.foundation.same.report.b.a().a(stringBuffer.toString());
                } else {
                    a(context, stringBuffer.toString());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void a(final Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new com.mbridge.msdk.foundation.same.report.d.a(context).c(0, d.a().f39564a, e.a(str, context), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.click.a.a.1
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void a(String str2) {
                    x.d(a.f38812l, str2);
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void b(String str2) {
                    n nVar = new n();
                    nVar.d(str);
                    nVar.a(System.currentTimeMillis());
                    nVar.a(0);
                    nVar.c("POST");
                    nVar.b(d.a().f39564a);
                    o.a(i.a(context)).a(nVar);
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
            x.d(f38812l, e4.getMessage());
        }
    }

    private void a(String str) {
        Message obtainMessage = this.f38818r.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = str;
        this.f38818r.sendMessageDelayed(obtainMessage, f38802b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i4) {
        String str2;
        c cVar = this.f38816n;
        if (cVar != null) {
            com.mbridge.msdk.click.a.b b4 = cVar.b(str);
            this.f38816n.a(str);
            if (b4 != null) {
                if (System.currentTimeMillis() <= b4.j() + f38805e) {
                    b4.a(i4);
                    this.f38815m.put(str, b4);
                    if (ai.b(str) == 0) {
                        str2 = str + "?" + f38801a;
                    } else {
                        str2 = str + "&" + f38801a;
                    }
                    com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.controller.a.f().j(), b4.f(), b4.e(), str2, b4.a(), b4.b(), b4.d());
                    return;
                } else if (i4 != com.mbridge.msdk.click.a.b.f38824b) {
                    a(b4);
                    return;
                } else {
                    return;
                }
            }
            com.mbridge.msdk.click.a.b bVar = this.f38815m.get(str);
            if (bVar == null || System.currentTimeMillis() > bVar.j() + f38805e || bVar.h() >= f38803c || i4 == com.mbridge.msdk.click.a.b.f38824b) {
                return;
            }
            a(str);
        }
    }

    private boolean a(int i4) {
        return i4 == f38810j || i4 == f38809i;
    }

    public final void a(String str, String str2, CampaignEx campaignEx, String str3, boolean z3, boolean z4, int i4) {
        if (!(a(i4) || b(i4) || i4 == f38811k) || TextUtils.isEmpty(str)) {
            return;
        }
        String replace = str.replace("?" + f38801a, "");
        String replace2 = replace.replace("&" + f38801a, "");
        if (this.f38815m == null) {
            this.f38815m = new ConcurrentHashMap<>();
        }
        com.mbridge.msdk.click.a.b remove = this.f38815m.remove(replace2);
        if (remove == null) {
            remove = new com.mbridge.msdk.click.a.b(str, str2);
            remove.b(i4);
            remove.a(z3);
            remove.b(z4);
            remove.a(campaignEx);
            remove.a(str3);
        } else if (remove.c() != com.mbridge.msdk.click.a.b.f38824b) {
            remove.b(str2);
        }
        if ((a(i4) && f38813o != 0) || (b(i4) && f38814p != 0) || i4 == f38811k) {
            if (System.currentTimeMillis() < remove.j() + f38805e) {
                if (this.f38816n == null) {
                    this.f38816n = new c(f38804d);
                }
                this.f38816n.a(replace2, remove);
                if (remove.c() == com.mbridge.msdk.click.a.b.f38823a) {
                    if (remove.h() <= f38803c) {
                        a(replace2);
                        return;
                    } else {
                        a(remove);
                        return;
                    }
                }
                return;
            } else if (remove.c() == com.mbridge.msdk.click.a.b.f38823a) {
                a(remove);
                return;
            } else {
                return;
            }
        }
        a(remove);
    }

    static /* synthetic */ void a(a aVar) {
        c cVar = aVar.f38816n;
        if (cVar != null) {
            for (String str : cVar.a()) {
                aVar.a(str, com.mbridge.msdk.click.a.b.f38824b);
            }
        }
    }
}
