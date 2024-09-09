package com.mbridge.msdk.foundation.same.net.f;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

/* compiled from: RequestUrlUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    public String A;
    public String B;
    public int C;
    public int D;
    public boolean E;
    public ArrayList<String> F;
    public ArrayList<String> G;
    private final String H;
    private boolean I;
    private int J;
    private String K;

    /* renamed from: L  reason: collision with root package name */
    private String f39563L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;

    /* renamed from: a  reason: collision with root package name */
    public String f39564a;

    /* renamed from: b  reason: collision with root package name */
    public String f39565b;

    /* renamed from: c  reason: collision with root package name */
    public String f39566c;

    /* renamed from: d  reason: collision with root package name */
    public String f39567d;

    /* renamed from: e  reason: collision with root package name */
    public String f39568e;

    /* renamed from: f  reason: collision with root package name */
    public int f39569f;

    /* renamed from: g  reason: collision with root package name */
    public int f39570g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39571h;

    /* renamed from: i  reason: collision with root package name */
    public int f39572i;

    /* renamed from: j  reason: collision with root package name */
    public String f39573j;

    /* renamed from: k  reason: collision with root package name */
    public String f39574k;

    /* renamed from: l  reason: collision with root package name */
    public String f39575l;

    /* renamed from: m  reason: collision with root package name */
    public String f39576m;

    /* renamed from: n  reason: collision with root package name */
    public String f39577n;

    /* renamed from: o  reason: collision with root package name */
    public String f39578o;

    /* renamed from: p  reason: collision with root package name */
    public String f39579p;

    /* renamed from: q  reason: collision with root package name */
    public String f39580q;

    /* renamed from: r  reason: collision with root package name */
    public String f39581r;

    /* renamed from: s  reason: collision with root package name */
    public String f39582s;

    /* renamed from: t  reason: collision with root package name */
    public String f39583t;

    /* renamed from: u  reason: collision with root package name */
    public String f39584u;

    /* renamed from: v  reason: collision with root package name */
    public String f39585v;

    /* renamed from: w  reason: collision with root package name */
    public String f39586w;

    /* renamed from: x  reason: collision with root package name */
    public String f39587x;

    /* renamed from: y  reason: collision with root package name */
    public String f39588y;

    /* renamed from: z  reason: collision with root package name */
    public String f39589z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RequestUrlUtil.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final d f39590a = new d();
    }

    public static d a() {
        return a.f39590a;
    }

    public final int b() {
        return this.J;
    }

    public final void c() {
        HashMap<String, String> aW;
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 != null) {
            this.f39571h = b4.ba() == 2;
            this.f39572i = b4.ba();
            this.I = !b4.l(2);
            if (b4.aW() != null && b4.aW().size() > 0 && (aW = b4.aW()) != null && aW.size() > 0) {
                if (aW.containsKey("v") && !TextUtils.isEmpty(aW.get("v")) && a(aW.get("v"))) {
                    this.f39565b = aW.get("v");
                    this.f39575l = this.f39565b + this.N;
                    this.f39576m = this.f39565b + this.O;
                    this.f39577n = this.f39565b + this.P;
                    this.f39578o = this.f39565b + this.Q;
                }
                if (aW.containsKey(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(aW.get(CampaignEx.JSON_KEY_HB)) && a(aW.get(CampaignEx.JSON_KEY_HB))) {
                    this.K = aW.get(CampaignEx.JSON_KEY_HB);
                    this.f39573j = this.K + this.f39563L;
                    this.f39574k = this.K + this.M;
                }
                if (aW.containsKey("lg") && !TextUtils.isEmpty(aW.get("lg"))) {
                    String str = aW.get("lg");
                    if (a(str)) {
                        this.f39564a = str;
                    } else {
                        this.f39568e = str;
                    }
                }
                if (aW.containsKey(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE) && !TextUtils.isEmpty(aW.get(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE)) && a(aW.get(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE))) {
                    this.A = aW.get(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE);
                }
                if (aW.containsKey("df") && !TextUtils.isEmpty(aW.get("df")) && a(aW.get("df"))) {
                    this.f39589z = aW.get("df");
                }
            }
            String al = b4.al();
            if (!TextUtils.isEmpty(al)) {
                this.f39566c = al;
                e();
                this.F.add(0, al);
            }
            String am = b4.am();
            if (TextUtils.isEmpty(am)) {
                return;
            }
            this.f39567d = am;
            f();
            this.G.add(0, am);
        }
    }

    public final boolean d() {
        try {
            if (!this.f39571h) {
                ArrayList<String> arrayList = this.F;
                if (arrayList != null && this.C <= arrayList.size() - 1) {
                    this.f39566c = this.F.get(this.C);
                    e();
                    return true;
                }
            } else {
                ArrayList<String> arrayList2 = this.G;
                if (arrayList2 != null && this.D <= arrayList2.size() - 1) {
                    if (!a(this.G.get(this.D))) {
                        this.f39567d = this.G.get(this.D);
                        f();
                    }
                    return true;
                }
            }
            if (this.E) {
                this.C = 0;
                this.D = 0;
            }
            return false;
        } catch (Throwable th) {
            x.a("RequestUrlUtil", th.getMessage());
            return false;
        }
    }

    public final void e() {
        this.f39579p = this.f39566c + this.S;
        this.f39580q = this.f39566c + this.T;
        this.f39581r = this.f39566c + this.U;
        this.f39582s = this.f39566c + this.R;
        this.f39583t = this.f39566c + this.V;
    }

    public final void f() {
        this.f39584u = this.f39567d + this.S;
        this.f39585v = this.f39567d + this.T;
        this.f39586w = this.f39567d + this.U;
        this.f39587x = this.f39567d + this.R;
        this.f39588y = this.f39567d + this.V;
    }

    private d() {
        this.H = "RequestUrlUtil";
        this.I = true;
        this.J = 0;
        this.K = "https://{}hb.rayjump.com";
        this.f39564a = "https://analytics.rayjump.com";
        this.f39565b = "https://net.rayjump.com";
        this.f39566c = "https://configure.rayjump.com";
        this.f39567d = "configure-tcp.rayjump.com";
        this.f39568e = s.b("DkPtYdQTLkfAW+xUhoPwLkPTHkJBDkM/Yr5T");
        this.f39569f = 9377;
        this.f39570g = 9377;
        this.f39571h = false;
        this.f39572i = 1;
        this.f39563L = "/bid";
        this.M = "/load";
        this.N = "/openapi/ad/v3";
        this.O = "/openapi/ad/v4";
        this.P = "/openapi/ad/v5";
        this.Q = "/image";
        this.R = "/mapping";
        this.S = "/setting";
        this.T = "/sdk/customid";
        this.U = "/rewardsetting";
        this.V = "/appwall/setting";
        this.f39573j = this.K + this.f39563L;
        this.f39574k = this.K + this.M;
        this.f39575l = this.f39565b + this.N;
        this.f39576m = this.f39565b + this.O;
        this.f39577n = this.f39565b + this.P;
        this.f39578o = this.f39565b + this.Q;
        this.f39579p = this.f39566c + this.S;
        this.f39580q = this.f39566c + this.T;
        this.f39581r = this.f39566c + this.U;
        this.f39582s = this.f39566c + this.R;
        this.f39583t = this.f39566c + this.V;
        this.f39584u = this.f39567d + this.S;
        this.f39585v = this.f39567d + this.T;
        this.f39586w = this.f39567d + this.U;
        this.f39587x = this.f39567d + this.R;
        this.f39588y = this.f39567d + this.V;
        this.f39589z = "https://detect.rayjump.com/mapi/find";
        this.A = "https://detect.rayjump.com/mapi/result";
        this.B = "https://d1tru86qrby720.cloudfront.net/hostsetting";
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.F = new ArrayList<>(Arrays.asList("https://configure.rayjump.com", "https://policy.rayjump.com", "https://lazy.rayjump.com", "https://check.rayjump.com"));
        this.G = new ArrayList<>(Arrays.asList("configure-tcp.rayjump.com", "policy-tcp.rayjump.com", "lazy-tcp.rayjump.com", "check-tcp.rayjump.com"));
    }

    public final void a(int i4) {
        this.J = i4;
    }

    public final String a(String str, int i4) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("_");
                if (split.length > 1) {
                    return a(true, split[1]);
                }
                return a(true, "");
            }
        } catch (Exception e4) {
            x.d("RequestUrlUtil", e4.getMessage());
        }
        return i4 % 2 == 0 ? this.f39577n : this.f39575l;
    }

    public final String a(boolean z3, String str) {
        if (z3) {
            if (this.f39574k.contains("{}") && !TextUtils.isEmpty(str)) {
                String str2 = this.f39574k;
                return str2.replace("{}", str + "-");
            }
            return this.f39574k.replace("{}", "");
        }
        return this.f39573j.replace("{}", "");
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("(https|http)://[-A-Za-z0-9{}+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(str.trim()).matches();
    }
}
