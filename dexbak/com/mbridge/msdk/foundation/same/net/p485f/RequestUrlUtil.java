package com.mbridge.msdk.foundation.same.net.p485f;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameBase64Tool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

/* renamed from: com.mbridge.msdk.foundation.same.net.f.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class RequestUrlUtil {

    /* renamed from: A */
    public String f30769A;

    /* renamed from: B */
    public String f30770B;

    /* renamed from: C */
    public int f30771C;

    /* renamed from: D */
    public int f30772D;

    /* renamed from: E */
    public boolean f30773E;

    /* renamed from: F */
    public ArrayList<String> f30774F;

    /* renamed from: G */
    public ArrayList<String> f30775G;

    /* renamed from: H */
    private final String f30776H;

    /* renamed from: I */
    private boolean f30777I;

    /* renamed from: J */
    private int f30778J;

    /* renamed from: K */
    private String f30779K;

    /* renamed from: L */
    private String f30780L;

    /* renamed from: M */
    private String f30781M;

    /* renamed from: N */
    private String f30782N;

    /* renamed from: O */
    private String f30783O;

    /* renamed from: P */
    private String f30784P;

    /* renamed from: Q */
    private String f30785Q;

    /* renamed from: R */
    private String f30786R;

    /* renamed from: S */
    private String f30787S;

    /* renamed from: T */
    private String f30788T;

    /* renamed from: U */
    private String f30789U;

    /* renamed from: V */
    private String f30790V;

    /* renamed from: a */
    public String f30791a;

    /* renamed from: b */
    public String f30792b;

    /* renamed from: c */
    public String f30793c;

    /* renamed from: d */
    public String f30794d;

    /* renamed from: e */
    public String f30795e;

    /* renamed from: f */
    public int f30796f;

    /* renamed from: g */
    public int f30797g;

    /* renamed from: h */
    public boolean f30798h;

    /* renamed from: i */
    public int f30799i;

    /* renamed from: j */
    public String f30800j;

    /* renamed from: k */
    public String f30801k;

    /* renamed from: l */
    public String f30802l;

    /* renamed from: m */
    public String f30803m;

    /* renamed from: n */
    public String f30804n;

    /* renamed from: o */
    public String f30805o;

    /* renamed from: p */
    public String f30806p;

    /* renamed from: q */
    public String f30807q;

    /* renamed from: r */
    public String f30808r;

    /* renamed from: s */
    public String f30809s;

    /* renamed from: t */
    public String f30810t;

    /* renamed from: u */
    public String f30811u;

    /* renamed from: v */
    public String f30812v;

    /* renamed from: w */
    public String f30813w;

    /* renamed from: x */
    public String f30814x;

    /* renamed from: y */
    public String f30815y;

    /* renamed from: z */
    public String f30816z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RequestUrlUtil.java */
    /* renamed from: com.mbridge.msdk.foundation.same.net.f.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11353a {

        /* renamed from: a */
        private static final RequestUrlUtil f30817a = new RequestUrlUtil();
    }

    /* renamed from: a */
    public static RequestUrlUtil m22248a() {
        return C11353a.f30817a;
    }

    /* renamed from: b */
    public final int m22243b() {
        return this.f30778J;
    }

    /* renamed from: c */
    public final void m22242c() {
        HashMap<String, String> m23375aW;
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b != null) {
            this.f30798h = m23252b.m23340ba() == 2;
            this.f30799i = m23252b.m23340ba();
            this.f30777I = !m23252b.m23300l(2);
            if (m23252b.m23375aW() != null && m23252b.m23375aW().size() > 0 && (m23375aW = m23252b.m23375aW()) != null && m23375aW.size() > 0) {
                if (m23375aW.containsKey("v") && !TextUtils.isEmpty(m23375aW.get("v")) && m22246a(m23375aW.get("v"))) {
                    this.f30792b = m23375aW.get("v");
                    this.f30802l = this.f30792b + this.f30782N;
                    this.f30803m = this.f30792b + this.f30783O;
                    this.f30804n = this.f30792b + this.f30784P;
                    this.f30805o = this.f30792b + this.f30785Q;
                }
                if (m23375aW.containsKey(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(m23375aW.get(CampaignEx.JSON_KEY_HB)) && m22246a(m23375aW.get(CampaignEx.JSON_KEY_HB))) {
                    this.f30779K = m23375aW.get(CampaignEx.JSON_KEY_HB);
                    this.f30800j = this.f30779K + this.f30780L;
                    this.f30801k = this.f30779K + this.f30781M;
                }
                if (m23375aW.containsKey("lg") && !TextUtils.isEmpty(m23375aW.get("lg"))) {
                    String str = m23375aW.get("lg");
                    if (m22246a(str)) {
                        this.f30791a = str;
                    } else {
                        this.f30795e = str;
                    }
                }
                if (m23375aW.containsKey(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE) && !TextUtils.isEmpty(m23375aW.get(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE)) && m22246a(m23375aW.get(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE))) {
                    this.f30769A = m23375aW.get(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE);
                }
                if (m23375aW.containsKey("df") && !TextUtils.isEmpty(m23375aW.get("df")) && m22246a(m23375aW.get("df"))) {
                    this.f30816z = m23375aW.get("df");
                }
            }
            String m23360al = m23252b.m23360al();
            if (!TextUtils.isEmpty(m23360al)) {
                this.f30793c = m23360al;
                m22240e();
                this.f30774F.add(0, m23360al);
            }
            String m23359am = m23252b.m23359am();
            if (TextUtils.isEmpty(m23359am)) {
                return;
            }
            this.f30794d = m23359am;
            m22239f();
            this.f30775G.add(0, m23359am);
        }
    }

    /* renamed from: d */
    public final boolean m22241d() {
        try {
            if (!this.f30798h) {
                ArrayList<String> arrayList = this.f30774F;
                if (arrayList != null && this.f30771C <= arrayList.size() - 1) {
                    this.f30793c = this.f30774F.get(this.f30771C);
                    m22240e();
                    return true;
                }
            } else {
                ArrayList<String> arrayList2 = this.f30775G;
                if (arrayList2 != null && this.f30772D <= arrayList2.size() - 1) {
                    if (!m22246a(this.f30775G.get(this.f30772D))) {
                        this.f30794d = this.f30775G.get(this.f30772D);
                        m22239f();
                    }
                    return true;
                }
            }
            if (this.f30773E) {
                this.f30771C = 0;
                this.f30772D = 0;
            }
            return false;
        } catch (Throwable th) {
            SameLogTool.m21738a("RequestUrlUtil", th.getMessage());
            return false;
        }
    }

    /* renamed from: e */
    public final void m22240e() {
        this.f30806p = this.f30793c + this.f30787S;
        this.f30807q = this.f30793c + this.f30788T;
        this.f30808r = this.f30793c + this.f30789U;
        this.f30809s = this.f30793c + this.f30786R;
        this.f30810t = this.f30793c + this.f30790V;
    }

    /* renamed from: f */
    public final void m22239f() {
        this.f30811u = this.f30794d + this.f30787S;
        this.f30812v = this.f30794d + this.f30788T;
        this.f30813w = this.f30794d + this.f30789U;
        this.f30814x = this.f30794d + this.f30786R;
        this.f30815y = this.f30794d + this.f30790V;
    }

    private RequestUrlUtil() {
        this.f30776H = "RequestUrlUtil";
        this.f30777I = true;
        this.f30778J = 0;
        this.f30779K = "https://{}hb.rayjump.com";
        this.f30791a = "https://analytics.rayjump.com";
        this.f30792b = "https://net.rayjump.com";
        this.f30793c = "https://configure.rayjump.com";
        this.f30794d = "configure-tcp.rayjump.com";
        this.f30795e = SameBase64Tool.m21812b("DkPtYdQTLkfAW+xUhoPwLkPTHkJBDkM/Yr5T");
        this.f30796f = 9377;
        this.f30797g = 9377;
        this.f30798h = false;
        this.f30799i = 1;
        this.f30780L = "/bid";
        this.f30781M = "/load";
        this.f30782N = "/openapi/ad/v3";
        this.f30783O = "/openapi/ad/v4";
        this.f30784P = "/openapi/ad/v5";
        this.f30785Q = "/image";
        this.f30786R = "/mapping";
        this.f30787S = "/setting";
        this.f30788T = "/sdk/customid";
        this.f30789U = "/rewardsetting";
        this.f30790V = "/appwall/setting";
        this.f30800j = this.f30779K + this.f30780L;
        this.f30801k = this.f30779K + this.f30781M;
        this.f30802l = this.f30792b + this.f30782N;
        this.f30803m = this.f30792b + this.f30783O;
        this.f30804n = this.f30792b + this.f30784P;
        this.f30805o = this.f30792b + this.f30785Q;
        this.f30806p = this.f30793c + this.f30787S;
        this.f30807q = this.f30793c + this.f30788T;
        this.f30808r = this.f30793c + this.f30789U;
        this.f30809s = this.f30793c + this.f30786R;
        this.f30810t = this.f30793c + this.f30790V;
        this.f30811u = this.f30794d + this.f30787S;
        this.f30812v = this.f30794d + this.f30788T;
        this.f30813w = this.f30794d + this.f30789U;
        this.f30814x = this.f30794d + this.f30786R;
        this.f30815y = this.f30794d + this.f30790V;
        this.f30816z = "https://detect.rayjump.com/mapi/find";
        this.f30769A = "https://detect.rayjump.com/mapi/result";
        this.f30770B = "https://d1tru86qrby720.cloudfront.net/hostsetting";
        this.f30771C = 0;
        this.f30772D = 0;
        this.f30773E = false;
        this.f30774F = new ArrayList<>(Arrays.asList("https://configure.rayjump.com", "https://policy.rayjump.com", "https://lazy.rayjump.com", "https://check.rayjump.com"));
        this.f30775G = new ArrayList<>(Arrays.asList("configure-tcp.rayjump.com", "policy-tcp.rayjump.com", "lazy-tcp.rayjump.com", "check-tcp.rayjump.com"));
    }

    /* renamed from: a */
    public final void m22247a(int i) {
        this.f30778J = i;
    }

    /* renamed from: a */
    public final String m22245a(String str, int i) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("_");
                if (split.length > 1) {
                    return m22244a(true, split[1]);
                }
                return m22244a(true, "");
            }
        } catch (Exception e) {
            SameLogTool.m21733d("RequestUrlUtil", e.getMessage());
        }
        return i % 2 == 0 ? this.f30804n : this.f30802l;
    }

    /* renamed from: a */
    public final String m22244a(boolean z, String str) {
        if (z) {
            if (this.f30801k.contains("{}") && !TextUtils.isEmpty(str)) {
                String str2 = this.f30801k;
                return str2.replace("{}", str + "-");
            }
            return this.f30801k.replace("{}", "");
        }
        return this.f30800j.replace("{}", "");
    }

    /* renamed from: a */
    private boolean m22246a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("(https|http)://[-A-Za-z0-9{}+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(str.trim()).matches();
    }
}
