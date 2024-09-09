package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* compiled from: VideoReportData.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static int f39346a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f39347b;
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private int I;

    /* renamed from: c  reason: collision with root package name */
    private String f39348c;

    /* renamed from: d  reason: collision with root package name */
    private String f39349d;

    /* renamed from: e  reason: collision with root package name */
    private String f39350e;

    /* renamed from: f  reason: collision with root package name */
    private String f39351f;

    /* renamed from: g  reason: collision with root package name */
    private int f39352g;

    /* renamed from: h  reason: collision with root package name */
    private String f39353h;

    /* renamed from: i  reason: collision with root package name */
    private int f39354i;

    /* renamed from: j  reason: collision with root package name */
    private int f39355j;

    /* renamed from: k  reason: collision with root package name */
    private int f39356k;

    /* renamed from: l  reason: collision with root package name */
    private String f39357l;

    /* renamed from: m  reason: collision with root package name */
    private String f39358m;

    /* renamed from: n  reason: collision with root package name */
    private int f39359n;

    /* renamed from: o  reason: collision with root package name */
    private int f39360o;

    /* renamed from: p  reason: collision with root package name */
    private String f39361p;

    /* renamed from: q  reason: collision with root package name */
    private long f39362q;

    /* renamed from: s  reason: collision with root package name */
    private String f39364s;

    /* renamed from: t  reason: collision with root package name */
    private String f39365t;

    /* renamed from: u  reason: collision with root package name */
    private String f39366u;

    /* renamed from: v  reason: collision with root package name */
    private String f39367v;

    /* renamed from: w  reason: collision with root package name */
    private String f39368w;

    /* renamed from: x  reason: collision with root package name */
    private String f39369x;

    /* renamed from: y  reason: collision with root package name */
    private String f39370y;

    /* renamed from: z  reason: collision with root package name */
    private String f39371z;

    /* renamed from: r  reason: collision with root package name */
    private int f39363r = 0;
    private int H = 0;

    public p(String str, int i4, int i5, int i6, int i7, String str2, String str3, int i8, String str4, int i9, String str5) {
        this.f39351f = str;
        this.f39352g = i4;
        this.f39353h = str5;
        this.f39354i = i5;
        this.f39355j = i6;
        this.f39356k = i7;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.f39357l = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
        }
        this.f39358m = str3;
        this.f39360o = i8;
        this.f39361p = str4;
        this.f39362q = i9;
    }

    public final String a() {
        return this.f39348c;
    }

    public final String b() {
        return this.f39349d;
    }

    public final String c() {
        return this.f39350e;
    }

    public final String d() {
        return this.F;
    }

    public final String e() {
        return this.E;
    }

    public final String f() {
        return this.D;
    }

    public final String g() {
        return this.C;
    }

    public final String h() {
        return this.G;
    }

    public final String i() {
        return this.f39368w;
    }

    public final void j(String str) {
        this.f39370y = str;
    }

    public final String k() {
        return this.f39364s;
    }

    public final String l() {
        return this.f39365t;
    }

    public final String m() {
        return this.f39366u;
    }

    public final String n() {
        return this.f39367v;
    }

    public final String o() {
        return this.f39351f;
    }

    public final int p() {
        return this.f39355j;
    }

    public final int q() {
        return this.f39356k;
    }

    public final String r() {
        return this.f39357l;
    }

    public final String s() {
        return TextUtils.isEmpty(this.f39358m) ? "" : this.f39358m;
    }

    public final String t() {
        return this.f39361p;
    }

    public final String toString() {
        return "RewardReportData [key=" + this.f39351f + ", networkType=" + this.f39352g + ", isCompleteView=" + this.f39354i + ", watchedMillis=" + this.f39355j + ", videoLength=" + this.f39356k + ", offerUrl=" + this.f39357l + ", reason=" + this.f39358m + ", result=" + this.f39360o + ", duration=" + this.f39361p + ", videoSize=" + this.f39362q + "]";
    }

    public final long u() {
        return this.f39362q;
    }

    public final int v() {
        return this.f39352g;
    }

    public final String w() {
        return this.f39353h;
    }

    public final int x() {
        return this.f39354i;
    }

    public final int y() {
        return this.f39360o;
    }

    public final void a(String str) {
        this.f39348c = str;
    }

    public final void b(String str) {
        this.f39349d = str;
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f39350e = URLEncoder.encode(str);
    }

    public final void d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.F = URLEncoder.encode(str, "utf-8");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.E = URLEncoder.encode(str, "utf-8");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void f(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.D = URLEncoder.encode(str, "utf-8");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void g(String str) {
        this.C = str;
    }

    public final void h(String str) {
        this.G = str;
    }

    public final void i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f39368w = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
        }
    }

    public final int j() {
        return this.I;
    }

    public final void k(String str) {
        this.f39364s = str;
    }

    public final void l(String str) {
        this.f39365t = str;
    }

    public final void m(String str) {
        this.f39366u = str;
    }

    public final void n(String str) {
        this.f39367v = str;
    }

    public final void o(String str) {
        this.f39351f = str;
    }

    public final void p(String str) {
        this.f39358m = str;
    }

    public final void q(String str) {
        this.f39361p = str;
    }

    public final void r(String str) {
        this.f39353h = str;
    }

    public static String g(p pVar) {
        if (pVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + pVar.f39351f + "&");
            stringBuffer.append("cid=" + pVar.f39367v + "&");
            stringBuffer.append("rid=" + pVar.f39364s + "&");
            stringBuffer.append("rid_n=" + pVar.f39365t + "&");
            stringBuffer.append("unit_id=" + pVar.f39366u + "&");
            stringBuffer.append("network_type=" + pVar.f39352g + "&");
            stringBuffer.append("mraid_type=" + pVar.H + "&");
            stringBuffer.append("platform=1");
            return stringBuffer.toString();
        }
        return "";
    }

    public static String h(p pVar) {
        if (pVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + pVar.f39351f + "&");
            stringBuffer.append("cid=" + pVar.f39367v + "&");
            stringBuffer.append("rid=" + pVar.f39364s + "&");
            stringBuffer.append("rid_n=" + pVar.f39365t + "&");
            stringBuffer.append("unit_id=" + pVar.f39366u + "&");
            stringBuffer.append("reason=" + pVar.s() + "&");
            stringBuffer.append("case=" + pVar.f39359n + "&");
            StringBuilder sb = new StringBuilder();
            sb.append("network_type=");
            sb.append(pVar.f39352g);
            stringBuffer.append(sb.toString());
            return stringBuffer.toString();
        }
        return "";
    }

    public final void a(int i4) {
        this.H = i4;
    }

    public final void b(int i4) {
        this.I = i4;
    }

    public static String a(List<p> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (p pVar : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + pVar.f39351f + "&");
                stringBuffer.append("network_type=" + pVar.f39352g + "&");
                stringBuffer.append("network_str=" + pVar.f39353h + "&");
                stringBuffer.append("reason=" + pVar.s() + "&");
                stringBuffer.append("cid=" + pVar.f39367v + "&");
                stringBuffer.append("video_url=" + pVar.E + "&");
                stringBuffer.append("rid=" + pVar.f39364s + "&");
                stringBuffer.append("rid_n=" + pVar.f39365t + "&");
                stringBuffer.append("unit_id=" + pVar.f39366u + "&");
                StringBuilder sb = new StringBuilder();
                sb.append("offer_url=");
                sb.append(pVar.f39357l);
                stringBuffer.append(sb.toString());
                stringBuffer.append("\n");
            } else {
                stringBuffer.append("key=" + pVar.f39351f + "&");
                stringBuffer.append("reason=" + pVar.s() + "&");
                stringBuffer.append("cid=" + pVar.f39367v + "&");
                stringBuffer.append("video_url=" + pVar.E + "&");
                stringBuffer.append("rid=" + pVar.f39364s + "&");
                stringBuffer.append("rid_n=" + pVar.f39365t + "&");
                stringBuffer.append("unit_id=" + pVar.f39366u + "&");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("offer_url=");
                sb2.append(pVar.f39357l);
                stringBuffer.append(sb2.toString());
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String b(List<p> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<p> it = list.iterator();
        while (it.hasNext()) {
            p next = it.next();
            Iterator<p> it2 = it;
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + next.f39351f + "&");
                stringBuffer.append("network_type=" + next.f39352g + "&");
                stringBuffer.append("network_str=" + next.f39353h + "&");
                stringBuffer.append("result=" + next.f39360o + "&");
                stringBuffer.append("duration=" + next.f39361p + "&");
                stringBuffer.append("video_size=" + next.f39362q + "&");
                stringBuffer.append("video_length=" + next.f39356k + "&");
                stringBuffer.append("reason=" + next.s() + "&");
                stringBuffer.append("cid=" + next.f39367v + "&");
                stringBuffer.append("video_url=" + next.E + "&");
                stringBuffer.append("rid=" + next.f39364s + "&");
                stringBuffer.append("rid_n=" + next.f39365t + "&");
                stringBuffer.append("unit_id=" + next.f39366u + "&");
                stringBuffer.append("offer_url=" + next.f39357l + "&");
            } else {
                stringBuffer.append("key=" + next.f39351f + "&");
                stringBuffer.append("result=" + next.f39360o + "&");
                stringBuffer.append("duration=" + next.f39361p + "&");
                stringBuffer.append("video_size=" + next.f39362q + "&");
                stringBuffer.append("video_length=" + next.f39356k + "&");
                stringBuffer.append("reason=" + next.s() + "&");
                stringBuffer.append("cid=" + next.f39367v + "&");
                stringBuffer.append("video_url=" + next.E + "&");
                stringBuffer.append("rid=" + next.f39364s + "&");
                stringBuffer.append("rid_n=" + next.f39365t + "&");
                stringBuffer.append("unit_id=" + next.f39366u + "&");
                stringBuffer.append("offer_url=" + next.f39357l + "&");
            }
            if (next.f39348c != null) {
                stringBuffer.append("resource_type=" + next.f39348c + "&");
            }
            if (next.f39350e != null) {
                stringBuffer.append("creative=" + next.f39350e + "&");
            }
            stringBuffer.append("\n");
            it = it2;
        }
        return stringBuffer.toString();
    }

    public final void c(int i4) {
        this.f39352g = i4;
    }

    public static String c(p pVar) {
        if (pVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + pVar.f39351f + "&");
            stringBuffer.append("result=" + pVar.f39360o + "&");
            stringBuffer.append("duration=" + pVar.f39361p + "&");
            stringBuffer.append("cid=" + pVar.f39367v + "&");
            stringBuffer.append("reason=" + pVar.s() + "&");
            stringBuffer.append("ad_type=" + pVar.G + "&");
            stringBuffer.append("unit_id=" + pVar.f39366u + "&");
            stringBuffer.append("devid=" + pVar.f39349d + "&");
            stringBuffer.append("mraid_type=" + pVar.H + "&");
            stringBuffer.append("network_type=" + pVar.f39352g + "&");
            if (!TextUtils.isEmpty(pVar.D)) {
                stringBuffer.append("endcard_url=" + pVar.D + "&");
            }
            if (!TextUtils.isEmpty(pVar.C)) {
                stringBuffer.append("type=" + pVar.C + "&");
            }
            if (pVar.f39348c != null) {
                stringBuffer.append("resource_type=" + pVar.f39348c + "&");
            }
            stringBuffer.append("rid_n=" + pVar.f39365t + "&");
            StringBuilder sb = new StringBuilder();
            sb.append("rid=");
            sb.append(pVar.f39364s);
            stringBuffer.append(sb.toString());
            stringBuffer.append("\n");
            return stringBuffer.toString();
        }
        return null;
    }

    public static String e(List<p> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (p pVar : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + pVar.f39351f + "&");
                stringBuffer.append("network_type=" + pVar.f39352g + "&");
                stringBuffer.append("cid=" + pVar.f39367v + "&");
                stringBuffer.append("image_url=" + pVar.F + "&");
                stringBuffer.append("reason=" + pVar.s() + "&");
                stringBuffer.append("rid=" + pVar.f39364s + "&");
                stringBuffer.append("rid_n=" + pVar.f39365t + "&");
                stringBuffer.append("unit_id=" + pVar.f39366u + "&");
                stringBuffer.append("\n");
            } else {
                stringBuffer.append("key=" + pVar.f39351f + "&");
                stringBuffer.append("cid=" + pVar.f39367v + "&");
                stringBuffer.append("image_url=" + pVar.F + "&");
                stringBuffer.append("reason=" + pVar.s() + "&");
                stringBuffer.append("rid=" + pVar.f39364s + "&");
                stringBuffer.append("rid_n=" + pVar.f39365t + "&");
                stringBuffer.append("unit_id=" + pVar.f39366u + "&");
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String f(p pVar) {
        if (pVar != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    stringBuffer.append("key=" + pVar.f39351f + "&");
                    stringBuffer.append("event=" + ac.c(pVar.f39371z) + "&");
                    stringBuffer.append("template=" + ac.c(pVar.f39369x) + "&");
                    stringBuffer.append("layout=" + ac.c(pVar.A) + "&");
                    stringBuffer.append("unit_id=" + ac.c(pVar.f39366u) + "&");
                    stringBuffer.append("cid=" + ac.c(pVar.f39367v) + "&");
                    stringBuffer.append("network_str=" + pVar.f39353h + "&");
                    StringBuilder sb = new StringBuilder();
                    sb.append("network_type=");
                    sb.append(pVar.f39352g);
                    stringBuffer.append(sb.toString());
                } else {
                    stringBuffer.append("key=" + pVar.f39351f + "&");
                    stringBuffer.append("event=" + ac.c(pVar.f39371z) + "&");
                    stringBuffer.append("template=" + ac.c(pVar.f39369x) + "&");
                    stringBuffer.append("layout=" + ac.c(pVar.A) + "&");
                    stringBuffer.append("unit_id=" + ac.c(pVar.f39366u) + "&");
                    stringBuffer.append("cid=" + ac.c(pVar.f39367v) + "&");
                }
                return stringBuffer.toString();
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public final void d(int i4) {
        this.f39360o = i4;
    }

    public static String d(p pVar) {
        if (pVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + pVar.f39351f + "&");
            stringBuffer.append("result=" + pVar.f39360o + "&");
            stringBuffer.append("duration=" + pVar.f39361p + "&");
            stringBuffer.append("cid=" + pVar.f39367v + "&");
            stringBuffer.append("unit_id=" + pVar.f39366u + "&");
            stringBuffer.append("reason=" + pVar.s() + "&");
            stringBuffer.append("ad_type=" + pVar.G + "&");
            stringBuffer.append("rid=" + pVar.f39364s + "&");
            stringBuffer.append("rid_n=" + pVar.f39365t + "&");
            stringBuffer.append("network_type=" + pVar.f39352g + "&");
            stringBuffer.append("mraid_type=" + pVar.H + "&");
            stringBuffer.append("devid=" + pVar.f39349d + "&");
            if (pVar.f39348c != null) {
                stringBuffer.append("resource_type=" + pVar.f39348c + "&");
            }
            if (!TextUtils.isEmpty(pVar.D)) {
                stringBuffer.append("endcard_url=" + pVar.D + "&");
            }
            stringBuffer.append("type=" + pVar.C);
            return stringBuffer.toString();
        }
        return null;
    }

    public p() {
    }

    public p(String str, int i4, String str2, String str3, String str4) {
        this.f39351f = str;
        this.f39353h = str4;
        this.f39352g = i4;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.f39357l = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
        }
        this.f39358m = str3;
    }

    public p(String str, int i4, int i5, String str2, int i6, String str3, int i7, String str4) {
        this.f39351f = str;
        this.f39352g = i4;
        this.f39353h = str4;
        this.f39356k = i5;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.f39357l = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
        }
        this.f39360o = i6;
        this.f39361p = str3;
        this.f39362q = i7;
    }

    public static String e(p pVar) {
        if (pVar != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    stringBuffer.append("key=" + pVar.f39351f + "&");
                    stringBuffer.append("error=" + ac.c(pVar.f39370y) + "&");
                    stringBuffer.append("template_url=" + ac.c(pVar.f39368w) + "&");
                    stringBuffer.append("unit_id=" + ac.c(pVar.f39366u) + "&");
                    stringBuffer.append("cid=" + ac.c(pVar.f39367v) + "&");
                    stringBuffer.append("network_str=" + pVar.f39353h + "&");
                    StringBuilder sb = new StringBuilder();
                    sb.append("network_type=");
                    sb.append(pVar.f39352g);
                    stringBuffer.append(sb.toString());
                } else {
                    stringBuffer.append("key=" + pVar.f39351f + "&");
                    stringBuffer.append("error=" + ac.c(pVar.f39370y) + "&");
                    stringBuffer.append("template_url=" + ac.c(pVar.f39368w) + "&");
                    stringBuffer.append("unit_id=" + ac.c(pVar.f39366u) + "&");
                    stringBuffer.append("cid=" + ac.c(pVar.f39367v) + "&");
                }
                return stringBuffer.toString();
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String f(List<p> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (p pVar : list) {
                        stringBuffer.append(pVar.B);
                        stringBuffer.append("\n");
                    }
                    return stringBuffer.toString();
                }
                return null;
            } catch (Throwable th) {
                x.b("VideoReportData", th.getMessage(), th);
                return null;
            }
        }
        return null;
    }

    public p(Context context, CampaignEx campaignEx, int i4, String str, long j4, int i5) {
        if (i5 == 1) {
            this.f39351f = "2000022";
        } else if (i5 == 287 || i5 == 94) {
            this.f39351f = "2000022";
        } else if (i5 == 95) {
            this.f39351f = "2000025";
        }
        int D = t.D(context);
        this.f39352g = D;
        this.f39353h = t.a(context, D);
        this.f39356k = campaignEx.getVideoLength();
        this.f39364s = campaignEx.getRequestId();
        this.f39365t = campaignEx.getRequestIdNotice();
        if (!TextUtils.isEmpty(this.f39357l)) {
            try {
                this.f39357l = URLEncoder.encode(campaignEx.getNoticeUrl() == null ? campaignEx.getClickURL() : campaignEx.getNoticeUrl(), "utf-8");
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
            }
        }
        this.f39360o = i4;
        this.f39361p = str;
        this.f39362q = j4 == 0 ? campaignEx.getVideoSize() : j4;
    }

    public static String a(p pVar) {
        if (pVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + pVar.f39351f + "&");
            stringBuffer.append("cid=" + pVar.f39367v + "&");
            stringBuffer.append("unit_id=" + pVar.f39366u + "&");
            stringBuffer.append("network_type=" + pVar.f39352g + "&");
            stringBuffer.append("rid=" + pVar.f39364s + "&");
            stringBuffer.append("rid_n=" + pVar.f39365t + "&");
            StringBuilder sb = new StringBuilder();
            sb.append("reason=");
            sb.append(pVar.s());
            stringBuffer.append(sb.toString());
            stringBuffer.append("\n");
            return stringBuffer.toString();
        }
        return null;
    }

    public static String d(List<p> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (p pVar : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + pVar.f39351f + "&");
                stringBuffer.append("network_type=" + pVar.f39352g + "&");
                stringBuffer.append("result=" + pVar.f39360o + "&");
                stringBuffer.append("cid=" + pVar.f39367v + "&");
                stringBuffer.append("template_url=" + pVar.f39368w + "&");
                stringBuffer.append("reason=" + pVar.s() + "&");
                stringBuffer.append("rid=" + pVar.f39364s + "&");
                stringBuffer.append("rid_n=" + pVar.f39365t + "&");
                stringBuffer.append("unit_id=" + pVar.f39366u + "&");
                stringBuffer.append("\n");
            } else {
                stringBuffer.append("key=" + pVar.f39351f + "&");
                stringBuffer.append("result=" + pVar.f39360o + "&");
                stringBuffer.append("cid=" + pVar.f39367v + "&");
                stringBuffer.append("template_url=" + pVar.f39368w + "&");
                stringBuffer.append("reason=" + pVar.s() + "&");
                stringBuffer.append("rid=" + pVar.f39364s + "&");
                stringBuffer.append("rid_n=" + pVar.f39365t + "&");
                stringBuffer.append("unit_id=" + pVar.f39366u + "&");
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String c(List<p> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (p pVar : list) {
            stringBuffer.append("key=" + pVar.f39351f + "&");
            stringBuffer.append("result=" + pVar.f39360o + "&");
            stringBuffer.append("duration=" + pVar.f39361p + "&");
            stringBuffer.append("endcard_url=" + pVar.D + "&");
            stringBuffer.append("cid=" + pVar.f39367v + "&");
            stringBuffer.append("unit_id=" + pVar.f39366u + "&");
            stringBuffer.append("reason=" + pVar.s() + "&");
            stringBuffer.append("ad_type=" + pVar.G + "&");
            stringBuffer.append("rid=" + pVar.f39364s + "&");
            stringBuffer.append("rid_n=" + pVar.f39365t + "&");
            stringBuffer.append("type=" + pVar.C + "&");
            StringBuilder sb = new StringBuilder();
            sb.append("adspace_t=");
            sb.append(pVar.I);
            stringBuffer.append(sb.toString());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public p(String str, String str2, String str3, String str4, String str5, String str6, int i4, String str7) {
        this.f39351f = str;
        this.f39371z = str2;
        this.f39369x = str3;
        this.A = str4;
        this.f39366u = str5;
        this.f39367v = str6;
        this.f39352g = i4;
        this.f39353h = str7;
    }

    public static String b(p pVar) {
        if (pVar != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + pVar.f39351f + "&");
            stringBuffer.append("cid=" + pVar.f39367v + "&");
            stringBuffer.append("unit_id=" + pVar.f39366u + "&");
            stringBuffer.append("network_type=" + pVar.f39352g + "&");
            stringBuffer.append("mraid_type=" + pVar.H + "&");
            stringBuffer.append("rid_n=" + pVar.f39365t + "&");
            StringBuilder sb = new StringBuilder();
            sb.append("rid=");
            sb.append(pVar.f39364s);
            stringBuffer.append(sb.toString());
            stringBuffer.append("\n");
            return stringBuffer.toString();
        }
        return null;
    }

    public p(String str) {
        this.B = str;
    }

    public p(String str, int i4, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f39351f = str;
        this.f39360o = i4;
        this.f39361p = str2;
        try {
            if (!TextUtils.isEmpty(str3)) {
                this.D = URLEncoder.encode(str3, "utf-8");
            }
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
        }
        this.f39367v = str4;
        this.f39366u = str5;
        this.f39358m = str6;
        this.C = str7;
        if (Integer.valueOf(str2).intValue() > com.mbridge.msdk.foundation.same.a.f39393u) {
            this.f39360o = 2;
        }
    }

    public p(String str, String str2, String str3, String str4, String str5, int i4) {
        this.f39351f = str;
        this.f39367v = str2;
        this.f39364s = str3;
        this.f39365t = str4;
        this.f39366u = str5;
        this.f39352g = i4;
    }

    public p(String str, String str2, String str3, String str4, String str5, int i4, int i5, String str6) {
        this.f39351f = str;
        this.f39367v = str2;
        this.f39364s = str3;
        this.f39365t = str4;
        this.f39366u = str5;
        this.f39352g = i4;
        this.f39358m = str6;
        this.f39359n = i5;
    }
}
