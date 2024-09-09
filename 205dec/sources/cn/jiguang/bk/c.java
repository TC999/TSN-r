package cn.jiguang.bk;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2700a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2701b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2702c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2703d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f2704e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f2705f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f2706g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f2707h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f2708i;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f2709j;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f2710k;

    /* renamed from: l  reason: collision with root package name */
    private static volatile c f2711l;

    /* renamed from: m  reason: collision with root package name */
    private static final Object f2712m = new Object();

    /* renamed from: n  reason: collision with root package name */
    private static AtomicInteger f2713n = new AtomicInteger(0);

    private c() {
        f2700a = i();
        f2701b = j();
        f2702c = k();
        f2703d = l();
        f2704e = m();
        f2705f = o();
        f2706g = n();
        f2707h = p();
        f2708i = q();
        f2709j = r();
        f2710k = s();
    }

    public static c a() {
        if (f2711l == null) {
            f2711l = new c();
        }
        return f2711l;
    }

    public static boolean b() {
        return (!f2705f || f2700a || f2701b || f2702c || f2703d || f2704e || f2707h || f2708i || f2709j || f2710k) ? false : true;
    }

    public static boolean c() {
        return (!f2700a || f2705f || f2701b || f2702c || f2703d || f2704e || f2707h || f2708i || f2709j || f2710k) ? false : true;
    }

    private static boolean i() {
        int i4;
        boolean z3 = false;
        try {
        } catch (ClassNotFoundException e4) {
            e = e4;
            i4 = 0;
        }
        if ((f2713n.intValue() & 1) != 0) {
            cn.jiguang.bq.d.c("JClientsHelper", "p jpush init");
            return f2700a;
        }
        i4 = f2713n.addAndGet(1);
        try {
            Class.forName("cn.jpush.android.api.JPushInterface");
            z3 = true;
        } catch (ClassNotFoundException e5) {
            e = e5;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJpushSDK:" + e.getMessage());
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJpushSDK:" + z3 + ", mPluginInitState: " + i4);
            return z3;
        }
        cn.jiguang.bq.d.a("JClientsHelper", "isPluginJpushSDK:" + z3 + ", mPluginInitState: " + i4);
        return z3;
    }

    private static boolean j() {
        int i4;
        boolean z3 = false;
        try {
        } catch (ClassNotFoundException e4) {
            e = e4;
            i4 = 0;
        }
        if ((f2713n.intValue() & 2) != 0) {
            cn.jiguang.bq.d.c("JClientsHelper", "p jmessage init");
            return f2701b;
        }
        int i5 = f2713n.addAndGet(2);
        try {
            Class.forName("cn.jpush.im.android.api.JMessageClient");
            z3 = true;
        } catch (ClassNotFoundException e5) {
            i4 = i5;
            e = e5;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJMessageSDK:" + e.getMessage());
            i5 = i4;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJMessageSDK:" + z3 + ", pluginState: " + i5);
            return z3;
        }
        cn.jiguang.bq.d.a("JClientsHelper", "isPluginJMessageSDK:" + z3 + ", pluginState: " + i5);
        return z3;
    }

    private static boolean k() {
        int i4;
        boolean z3 = false;
        try {
        } catch (ClassNotFoundException e4) {
            e = e4;
            i4 = 0;
        }
        if ((f2713n.intValue() & 4) != 0) {
            cn.jiguang.bq.d.c("JClientsHelper", "p janalytics init");
            return f2702c;
        }
        int i5 = f2713n.addAndGet(4);
        try {
            Class.forName("cn.jiguang.analytics.android.api.JAnalyticsInterface");
            z3 = true;
        } catch (ClassNotFoundException e5) {
            i4 = i5;
            e = e5;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJanalyticsSDK:" + e.getMessage());
            i5 = i4;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJanalyticsSDK:" + z3 + ", pluginState: " + i5);
            return z3;
        }
        cn.jiguang.bq.d.a("JClientsHelper", "isPluginJanalyticsSDK:" + z3 + ", pluginState: " + i5);
        return z3;
    }

    private static boolean l() {
        int i4;
        boolean z3 = false;
        try {
        } catch (ClassNotFoundException e4) {
            e = e4;
            i4 = 0;
        }
        if ((f2713n.intValue() & 8) != 0) {
            cn.jiguang.bq.d.c("JClientsHelper", "p jshare init");
            return f2703d;
        }
        int i5 = f2713n.addAndGet(8);
        try {
            Class.forName("cn.jiguang.share.android.api.JShareInterface");
            z3 = true;
        } catch (ClassNotFoundException e5) {
            i4 = i5;
            e = e5;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJshareSDK:" + e.getMessage());
            i5 = i4;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJshareSDK:" + z3 + ", pluginState: " + i5);
            return z3;
        }
        cn.jiguang.bq.d.a("JClientsHelper", "isPluginJshareSDK:" + z3 + ", pluginState: " + i5);
        return z3;
    }

    private static boolean m() {
        int i4;
        boolean z3 = false;
        try {
        } catch (ClassNotFoundException e4) {
            e = e4;
            i4 = 0;
        }
        if ((f2713n.intValue() & 16) != 0) {
            cn.jiguang.bq.d.c("JClientsHelper", "p ad init");
            return f2704e;
        }
        int i5 = f2713n.addAndGet(16);
        try {
            Class.forName("cn.jiguang.union.ads.base.api.JAdApi");
            z3 = true;
        } catch (ClassNotFoundException e5) {
            i4 = i5;
            e = e5;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginAdSDK:" + e.getMessage());
            i5 = i4;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginAdSDK:" + z3 + ", pluginState: " + i5);
            return z3;
        }
        cn.jiguang.bq.d.a("JClientsHelper", "isPluginAdSDK:" + z3 + ", pluginState: " + i5);
        return z3;
    }

    private static boolean n() {
        int i4;
        boolean z3 = false;
        try {
        } catch (ClassNotFoundException e4) {
            e = e4;
            i4 = 0;
        }
        if ((f2713n.intValue() & 32) != 0) {
            cn.jiguang.bq.d.c("JClientsHelper", "p jcommon init");
            return f2706g;
        }
        int i5 = f2713n.addAndGet(32);
        try {
            Class.forName("cn.jiguang.common.api.JCommonInterface");
            z3 = true;
        } catch (ClassNotFoundException e5) {
            i4 = i5;
            e = e5;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJCommonSDK:" + e.getMessage());
            i5 = i4;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJCommonSDK:" + z3 + ", pluginState: " + i5);
            return z3;
        }
        cn.jiguang.bq.d.a("JClientsHelper", "isPluginJCommonSDK:" + z3 + ", pluginState: " + i5);
        return z3;
    }

    private static boolean o() {
        int i4;
        boolean z3 = false;
        try {
        } catch (ClassNotFoundException e4) {
            e = e4;
            i4 = 0;
        }
        if ((f2713n.intValue() & 64) != 0) {
            cn.jiguang.bq.d.c("JClientsHelper", "p jverification init");
            return f2705f;
        }
        int i5 = f2713n.addAndGet(64);
        try {
            Class.forName("cn.jiguang.verifysdk.api.JVerificationInterface");
            z3 = true;
        } catch (ClassNotFoundException e5) {
            i4 = i5;
            e = e5;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJVerificationSDK:" + e.getMessage());
            i5 = i4;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJVerificationSDK:" + z3 + ", pluginState: " + i5);
            return z3;
        }
        cn.jiguang.bq.d.a("JClientsHelper", "isPluginJVerificationSDK:" + z3 + ", pluginState: " + i5);
        return z3;
    }

    private static boolean p() {
        int i4;
        boolean z3 = false;
        try {
        } catch (ClassNotFoundException e4) {
            e = e4;
            i4 = 0;
        }
        if ((f2713n.intValue() & 128) != 0) {
            cn.jiguang.bq.d.c("JClientsHelper", "p jmlink init");
            return f2707h;
        }
        int i5 = f2713n.addAndGet(128);
        try {
            Class.forName("cn.jiguang.jmlinksdk.core.JMlinkInterfaceImpl");
            z3 = true;
        } catch (ClassNotFoundException e5) {
            i4 = i5;
            e = e5;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJMLinkSDK:" + e.getMessage());
            i5 = i4;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJMLinkSDK:" + z3 + ", pluginState: " + i5);
            return z3;
        }
        cn.jiguang.bq.d.a("JClientsHelper", "isPluginJMLinkSDK:" + z3 + ", pluginState: " + i5);
        return z3;
    }

    private static boolean q() {
        int i4;
        boolean z3 = false;
        try {
        } catch (ClassNotFoundException e4) {
            e = e4;
            i4 = 0;
        }
        if ((f2713n.intValue() & 256) != 0) {
            cn.jiguang.bq.d.c("JClientsHelper", "p junion init");
            return f2708i;
        }
        int i5 = f2713n.addAndGet(256);
        try {
            Class.forName("cn.jiguang.junion.JUnionInterface");
            z3 = true;
        } catch (ClassNotFoundException e5) {
            i4 = i5;
            e = e5;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJUnionSDK:" + e.getMessage());
            i5 = i4;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJUnionSDK:" + z3 + ", pluginState: " + i5);
            return z3;
        }
        cn.jiguang.bq.d.a("JClientsHelper", "isPluginJUnionSDK:" + z3 + ", pluginState: " + i5);
        return z3;
    }

    private static boolean r() {
        int i4;
        boolean z3 = false;
        try {
        } catch (ClassNotFoundException e4) {
            e = e4;
            i4 = 0;
        }
        if ((f2713n.intValue() & 512) != 0) {
            cn.jiguang.bq.d.c("JClientsHelper", "p jportrait init");
            return f2709j;
        }
        int i5 = f2713n.addAndGet(256);
        try {
            Class.forName("cn.jiguang.portrait.api.JPortraitInterface");
            z3 = true;
        } catch (ClassNotFoundException e5) {
            i4 = i5;
            e = e5;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJUnionSDK:" + e.getMessage());
            i5 = i4;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJUnionSDK:" + z3 + ", pluginState: " + i5);
            return z3;
        }
        cn.jiguang.bq.d.a("JClientsHelper", "isPluginJUnionSDK:" + z3 + ", pluginState: " + i5);
        return z3;
    }

    private static boolean s() {
        int i4;
        boolean z3 = false;
        try {
        } catch (ClassNotFoundException e4) {
            e = e4;
            i4 = 0;
        }
        if ((f2713n.intValue() & 2048) != 0) {
            cn.jiguang.bq.d.c("JClientsHelper", "p joperate init");
            return f2709j;
        }
        int i5 = f2713n.addAndGet(2048);
        try {
            Class.forName("cn.jiguang.joperate.api.JOperateInterface");
            z3 = true;
        } catch (ClassNotFoundException e5) {
            i4 = i5;
            e = e5;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJOperateSDK:" + e.getMessage());
            i5 = i4;
            cn.jiguang.bq.d.a("JClientsHelper", "isPluginJOperateSDK:" + z3 + ", pluginState: " + i5);
            return z3;
        }
        cn.jiguang.bq.d.a("JClientsHelper", "isPluginJOperateSDK:" + z3 + ", pluginState: " + i5);
        return z3;
    }

    public boolean a(Context context) {
        boolean z3 = f2701b || f2700a || f2704e;
        cn.jiguang.bq.d.c("JClientsHelper", "isNeedKeepTcpConnect:" + z3);
        return z3;
    }

    public boolean d() {
        return f2701b;
    }

    public boolean e() {
        return f2700a;
    }

    public boolean f() {
        return f2704e;
    }

    public boolean g() {
        return f2705f;
    }

    public boolean h() {
        return f2710k;
    }
}
