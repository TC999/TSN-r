package com.qq.e.comm.plugin.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.qq.e.comm.pi.IBidding;
import com.qq.e.comm.plugin.util.o1;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46577a = "r";

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, String> f46578b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Set<String> f46579c = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f46580c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f46581d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f46582e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f46583f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f46584g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ IBidding f46585h;

        a(int i4, int i5, com.qq.e.comm.plugin.g0.e eVar, String str, com.qq.e.comm.plugin.n0.c cVar, IBidding iBidding) {
            this.f46580c = i4;
            this.f46581d = i5;
            this.f46582e = eVar;
            this.f46583f = str;
            this.f46584g = cVar;
            this.f46585h = iBidding;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.b(this.f46580c, this.f46581d, this.f46582e, this.f46583f, this.f46584g, this.f46585h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f46586c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f46587d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f46588e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f46589f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f46590g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n0.c f46591h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ IBidding f46592i;

        b(int i4, int i5, String str, String str2, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.n0.c cVar, IBidding iBidding) {
            this.f46586c = i4;
            this.f46587d = i5;
            this.f46588e = str;
            this.f46589f = str2;
            this.f46590g = eVar;
            this.f46591h = cVar;
            this.f46592i = iBidding;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.c(this.f46586c, this.f46587d, this.f46588e, this.f46589f, this.f46590g, this.f46591h, this.f46592i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f46593c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ IBidding f46594d;

        c(String str, IBidding iBidding) {
            this.f46593c = str;
            this.f46594d = iBidding;
        }

        @Override // java.lang.Runnable
        public void run() {
            String b4 = r.b(this.f46593c, this.f46594d);
            String str = r.f46577a;
            d1.a(str, "resetWinNoticeReportStatus: " + b4);
            r.f46579c.remove(b4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        static final Handler f46595a;

        static {
            HandlerThread handlerThread = new HandlerThread("gdt_c2s_b_thread");
            handlerThread.start();
            f46595a = new Handler(handlerThread.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i4, int i5, String str, String str2, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.n0.c cVar, IBidding iBidding) {
        com.qq.e.comm.plugin.n0.v.a(1408005, cVar, Integer.valueOf(i5));
        if (c() && c(str2, iBidding)) {
            d1.a(f46577a, "sendLossNotification: \u91cd\u590d\u4e0a\u62a5!");
            return;
        }
        d1.a(f46577a, "sendLossNotification: price: %s, reason: %s, adnId: %s, posId: %s", Integer.valueOf(i4), Integer.valueOf(i5), str, str2);
        if (i5 == 2) {
            b(str2, i4);
        } else if (eVar != null) {
            a(eVar.S(), str, i4, i5);
        }
        f46579c.add(b(str2, iBidding));
    }

    public static void d(String str, IBidding iBidding) {
        d.f46595a.post(new c(str, iBidding));
    }

    public static String b(String str) {
        return f46578b.remove(str);
    }

    private static void b(String str, int i4) {
        String a4 = i2.a(i2.a("https://win.gdt.qq.com/win_notice.fcg?viewid=1", "position_id", str), "loss", String.valueOf(2));
        try {
            a4 = i2.a(a4, "win_price", a(i4));
        } catch (o1.d e4) {
            String str2 = f46577a;
            d1.a(str2, "reportCompetitionFailureBecauseNoAd: " + e4.getMessage(), e4);
        }
        String a5 = a(a4);
        d1.a(f46577a, "reportNotCompetition url: %s", a5);
        a1.a(a5, true);
    }

    public static void a(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String a4 = a(i4);
            d1.a(f46577a, "recordBiddingAdapterPrice: %s", a4);
            f46578b.put(str, a4);
        } catch (o1.d e4) {
            String str2 = f46577a;
            d1.a(str2, "recordBiddingAdapterPrice: " + e4.getMessage(), e4);
        }
    }

    public static String a(int i4) throws o1.d {
        return o1.a(String.valueOf(i4));
    }

    public static void b(int i4, int i5, com.qq.e.comm.plugin.g0.e eVar, String str, com.qq.e.comm.plugin.n0.c cVar, IBidding iBidding) {
        com.qq.e.comm.plugin.n0.v.a(1408004, cVar);
        if (c() && c(str, iBidding)) {
            d1.a(f46577a, "sendWinNotificationInWorkThread: \u91cd\u590d\u4e0a\u62a5!");
            return;
        }
        d1.a(f46577a, "sendWinNotificationInWorkThread: costPrice: %s, highestLossPrice: %s", Integer.valueOf(i4), Integer.valueOf(i5));
        if (eVar != null) {
            a(eVar.U0(), i4, i5);
        }
        f46579c.add(b(str, iBidding));
    }

    public static void a(String str, int i4, int i5) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String a4 = a(i4);
            String a5 = a(i5);
            d1.a(f46577a, "reportCompetitionWin: %s, packedPrice: %s, highestLossPrice: %s", Integer.valueOf(i4), a4, Integer.valueOf(i5));
            a1.a(a(str.replace("%24%7BAUCTION_PRICE%7D", a4).replace("%24%7BHIGHEST_LOSS_PRICE%7D", a5)), true);
        } catch (o1.d e4) {
            String str2 = f46577a;
            d1.a(str2, "reportCompetitionWin: " + e4.getMessage(), e4);
        }
    }

    private static boolean c() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("skcbwollt", 0) == 1;
    }

    private static boolean c(String str, IBidding iBidding) {
        String b4 = b(str, iBidding);
        boolean contains = f46579c.contains(b4);
        String str2 = f46577a;
        d1.a(str2, "isWinNoticeReportedInWorkThread, key:" + b4 + ", contains: " + contains);
        return contains;
    }

    public static void b(int i4, int i5, String str, String str2, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.n0.c cVar, IBidding iBidding) {
        d.f46595a.post(new b(i4, i5, str, str2, eVar, cVar, iBidding));
    }

    private static String b(Map<String, Object> map, String str) {
        if (map != null) {
            Object obj = map.get(str);
            return obj instanceof String ? (String) obj : "";
        }
        return "";
    }

    public static void a(String str, String str2, int i4, int i5) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String a4 = a(i4);
            d1.a(f46577a, "reportCompetitionFailure: %s, packedPrice: %s, adnId: %s", Integer.valueOf(i4), a4, str2);
            if (TextUtils.isEmpty(str2)) {
                str2 = "%24%7BAUCTION_SEAT_ID%7D";
            }
            a1.a(a(str.replace("%24%7BAUCTION_PRICE%7D", a4).replace("%24%7BAUCTION_SEAT_ID%7D", str2).replace("%24%7BAUCTION_LOSS%7D", String.valueOf(i5))), true);
        } catch (o1.d e4) {
            String str3 = f46577a;
            d1.a(str3, "reportCompetitionFailure: " + e4.getMessage(), e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, IBidding iBidding) {
        return str + iBidding.hashCode();
    }

    private static String a(String str) {
        String str2;
        String a4 = i2.a(str, "sdk_version", e1.c());
        try {
            str2 = URLEncoder.encode(com.qq.e.comm.plugin.d0.a.d().b().d(), "utf-8").replaceAll("\\+", "%20");
        } catch (Exception unused) {
            str2 = "";
        }
        return i2.a(a4, "app_version", str2);
    }

    public static void a(Map<String, Object> map, com.qq.e.comm.plugin.g0.e eVar, String str, com.qq.e.comm.plugin.n0.c cVar, IBidding iBidding) {
        a(a(map, "expectCostPrice"), a(map, "highestLossPrice"), eVar, str, cVar, iBidding);
    }

    public static void a(int i4, com.qq.e.comm.plugin.g0.e eVar, String str, com.qq.e.comm.plugin.n0.c cVar, IBidding iBidding) {
        a(i4, -1, eVar, str, cVar, iBidding);
    }

    public static void a(int i4, int i5, com.qq.e.comm.plugin.g0.e eVar, String str, com.qq.e.comm.plugin.n0.c cVar, IBidding iBidding) {
        d.f46595a.post(new a(i4, i5, eVar, str, cVar, iBidding));
    }

    public static void a(Map<String, Object> map, String str, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.n0.c cVar, IBidding iBidding) {
        b(a(map, "winPrice"), a(map, "lossReason"), b(map, "adnId"), str, eVar, cVar, iBidding);
    }

    private static int a(Map<String, Object> map, String str) {
        if (map != null) {
            Object obj = map.get(str);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }
        return -1;
    }
}
