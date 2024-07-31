package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.entity.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class VideoReportData {

    /* renamed from: a */
    public static int f30525a = 1;

    /* renamed from: b */
    public static int f30526b;

    /* renamed from: A */
    private String f30527A;

    /* renamed from: B */
    private String f30528B;

    /* renamed from: C */
    private String f30529C;

    /* renamed from: D */
    private String f30530D;

    /* renamed from: E */
    private String f30531E;

    /* renamed from: F */
    private String f30532F;

    /* renamed from: G */
    private String f30533G;

    /* renamed from: I */
    private int f30535I;

    /* renamed from: c */
    private String f30536c;

    /* renamed from: d */
    private String f30537d;

    /* renamed from: e */
    private String f30538e;

    /* renamed from: f */
    private String f30539f;

    /* renamed from: g */
    private int f30540g;

    /* renamed from: h */
    private String f30541h;

    /* renamed from: i */
    private int f30542i;

    /* renamed from: j */
    private int f30543j;

    /* renamed from: k */
    private int f30544k;

    /* renamed from: l */
    private String f30545l;

    /* renamed from: m */
    private String f30546m;

    /* renamed from: n */
    private int f30547n;

    /* renamed from: o */
    private int f30548o;

    /* renamed from: p */
    private String f30549p;

    /* renamed from: q */
    private long f30550q;

    /* renamed from: s */
    private String f30552s;

    /* renamed from: t */
    private String f30553t;

    /* renamed from: u */
    private String f30554u;

    /* renamed from: v */
    private String f30555v;

    /* renamed from: w */
    private String f30556w;

    /* renamed from: x */
    private String f30557x;

    /* renamed from: y */
    private String f30558y;

    /* renamed from: z */
    private String f30559z;

    /* renamed from: r */
    private int f30551r = 0;

    /* renamed from: H */
    private int f30534H = 0;

    public VideoReportData(String str, int i, int i2, int i3, int i4, String str2, String str3, int i5, String str4, int i6, String str5) {
        this.f30539f = str;
        this.f30540g = i;
        this.f30541h = str5;
        this.f30542i = i2;
        this.f30543j = i3;
        this.f30544k = i4;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.f30545l = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.f30546m = str3;
        this.f30548o = i5;
        this.f30549p = str4;
        this.f30550q = i6;
    }

    /* renamed from: a */
    public final String m22449a() {
        return this.f30536c;
    }

    /* renamed from: b */
    public final String m22444b() {
        return this.f30537d;
    }

    /* renamed from: c */
    public final String m22439c() {
        return this.f30538e;
    }

    /* renamed from: d */
    public final String m22434d() {
        return this.f30532F;
    }

    /* renamed from: e */
    public final String m22429e() {
        return this.f30531E;
    }

    /* renamed from: f */
    public final String m22425f() {
        return this.f30530D;
    }

    /* renamed from: g */
    public final String m22421g() {
        return this.f30529C;
    }

    /* renamed from: h */
    public final String m22418h() {
        return this.f30533G;
    }

    /* renamed from: i */
    public final String m22415i() {
        return this.f30556w;
    }

    /* renamed from: j */
    public final void m22412j(String str) {
        this.f30558y = str;
    }

    /* renamed from: k */
    public final String m22411k() {
        return this.f30552s;
    }

    /* renamed from: l */
    public final String m22409l() {
        return this.f30553t;
    }

    /* renamed from: m */
    public final String m22407m() {
        return this.f30554u;
    }

    /* renamed from: n */
    public final String m22405n() {
        return this.f30555v;
    }

    /* renamed from: o */
    public final String m22403o() {
        return this.f30539f;
    }

    /* renamed from: p */
    public final int m22401p() {
        return this.f30543j;
    }

    /* renamed from: q */
    public final int m22399q() {
        return this.f30544k;
    }

    /* renamed from: r */
    public final String m22397r() {
        return this.f30545l;
    }

    /* renamed from: s */
    public final String m22395s() {
        return TextUtils.isEmpty(this.f30546m) ? "" : this.f30546m;
    }

    /* renamed from: t */
    public final String m22394t() {
        return this.f30549p;
    }

    public final String toString() {
        return "RewardReportData [key=" + this.f30539f + ", networkType=" + this.f30540g + ", isCompleteView=" + this.f30542i + ", watchedMillis=" + this.f30543j + ", videoLength=" + this.f30544k + ", offerUrl=" + this.f30545l + ", reason=" + this.f30546m + ", result=" + this.f30548o + ", duration=" + this.f30549p + ", videoSize=" + this.f30550q + "]";
    }

    /* renamed from: u */
    public final long m22393u() {
        return this.f30550q;
    }

    /* renamed from: v */
    public final int m22392v() {
        return this.f30540g;
    }

    /* renamed from: w */
    public final String m22391w() {
        return this.f30541h;
    }

    /* renamed from: x */
    public final int m22390x() {
        return this.f30542i;
    }

    /* renamed from: y */
    public final int m22389y() {
        return this.f30548o;
    }

    /* renamed from: a */
    public final void m22446a(String str) {
        this.f30536c = str;
    }

    /* renamed from: b */
    public final void m22441b(String str) {
        this.f30537d = str;
    }

    /* renamed from: c */
    public final void m22436c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f30538e = URLEncoder.encode(str);
    }

    /* renamed from: d */
    public final void m22431d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f30532F = URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public final void m22427e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f30531E = URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    public final void m22423f(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f30530D = URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    public final void m22419g(String str) {
        this.f30529C = str;
    }

    /* renamed from: h */
    public final void m22416h(String str) {
        this.f30533G = str;
    }

    /* renamed from: i */
    public final void m22414i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f30556w = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: j */
    public final int m22413j() {
        return this.f30535I;
    }

    /* renamed from: k */
    public final void m22410k(String str) {
        this.f30552s = str;
    }

    /* renamed from: l */
    public final void m22408l(String str) {
        this.f30553t = str;
    }

    /* renamed from: m */
    public final void m22406m(String str) {
        this.f30554u = str;
    }

    /* renamed from: n */
    public final void m22404n(String str) {
        this.f30555v = str;
    }

    /* renamed from: o */
    public final void m22402o(String str) {
        this.f30539f = str;
    }

    /* renamed from: p */
    public final void m22400p(String str) {
        this.f30546m = str;
    }

    /* renamed from: q */
    public final void m22398q(String str) {
        this.f30549p = str;
    }

    /* renamed from: r */
    public final void m22396r(String str) {
        this.f30541h = str;
    }

    /* renamed from: g */
    public static String m22420g(VideoReportData videoReportData) {
        if (videoReportData != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + videoReportData.f30539f + "&");
            stringBuffer.append("cid=" + videoReportData.f30555v + "&");
            stringBuffer.append("rid=" + videoReportData.f30552s + "&");
            stringBuffer.append("rid_n=" + videoReportData.f30553t + "&");
            stringBuffer.append("unit_id=" + videoReportData.f30554u + "&");
            stringBuffer.append("network_type=" + videoReportData.f30540g + "&");
            stringBuffer.append("mraid_type=" + videoReportData.f30534H + "&");
            stringBuffer.append("platform=1");
            return stringBuffer.toString();
        }
        return "";
    }

    /* renamed from: h */
    public static String m22417h(VideoReportData videoReportData) {
        if (videoReportData != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + videoReportData.f30539f + "&");
            stringBuffer.append("cid=" + videoReportData.f30555v + "&");
            stringBuffer.append("rid=" + videoReportData.f30552s + "&");
            stringBuffer.append("rid_n=" + videoReportData.f30553t + "&");
            stringBuffer.append("unit_id=" + videoReportData.f30554u + "&");
            stringBuffer.append("reason=" + videoReportData.m22395s() + "&");
            stringBuffer.append("case=" + videoReportData.f30547n + "&");
            StringBuilder sb = new StringBuilder();
            sb.append("network_type=");
            sb.append(videoReportData.f30540g);
            stringBuffer.append(sb.toString());
            return stringBuffer.toString();
        }
        return "";
    }

    /* renamed from: a */
    public final void m22448a(int i) {
        this.f30534H = i;
    }

    /* renamed from: b */
    public final void m22443b(int i) {
        this.f30535I = i;
    }

    /* renamed from: a */
    public static String m22445a(List<VideoReportData> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (VideoReportData videoReportData : list) {
            if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + videoReportData.f30539f + "&");
                stringBuffer.append("network_type=" + videoReportData.f30540g + "&");
                stringBuffer.append("network_str=" + videoReportData.f30541h + "&");
                stringBuffer.append("reason=" + videoReportData.m22395s() + "&");
                stringBuffer.append("cid=" + videoReportData.f30555v + "&");
                stringBuffer.append("video_url=" + videoReportData.f30531E + "&");
                stringBuffer.append("rid=" + videoReportData.f30552s + "&");
                stringBuffer.append("rid_n=" + videoReportData.f30553t + "&");
                stringBuffer.append("unit_id=" + videoReportData.f30554u + "&");
                StringBuilder sb = new StringBuilder();
                sb.append("offer_url=");
                sb.append(videoReportData.f30545l);
                stringBuffer.append(sb.toString());
                stringBuffer.append(ShellAdbUtils.f33810d);
            } else {
                stringBuffer.append("key=" + videoReportData.f30539f + "&");
                stringBuffer.append("reason=" + videoReportData.m22395s() + "&");
                stringBuffer.append("cid=" + videoReportData.f30555v + "&");
                stringBuffer.append("video_url=" + videoReportData.f30531E + "&");
                stringBuffer.append("rid=" + videoReportData.f30552s + "&");
                stringBuffer.append("rid_n=" + videoReportData.f30553t + "&");
                stringBuffer.append("unit_id=" + videoReportData.f30554u + "&");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("offer_url=");
                sb2.append(videoReportData.f30545l);
                stringBuffer.append(sb2.toString());
                stringBuffer.append(ShellAdbUtils.f33810d);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static String m22440b(List<VideoReportData> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<VideoReportData> it = list.iterator();
        while (it.hasNext()) {
            VideoReportData next = it.next();
            Iterator<VideoReportData> it2 = it;
            if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + next.f30539f + "&");
                stringBuffer.append("network_type=" + next.f30540g + "&");
                stringBuffer.append("network_str=" + next.f30541h + "&");
                stringBuffer.append("result=" + next.f30548o + "&");
                stringBuffer.append("duration=" + next.f30549p + "&");
                stringBuffer.append("video_size=" + next.f30550q + "&");
                stringBuffer.append("video_length=" + next.f30544k + "&");
                stringBuffer.append("reason=" + next.m22395s() + "&");
                stringBuffer.append("cid=" + next.f30555v + "&");
                stringBuffer.append("video_url=" + next.f30531E + "&");
                stringBuffer.append("rid=" + next.f30552s + "&");
                stringBuffer.append("rid_n=" + next.f30553t + "&");
                stringBuffer.append("unit_id=" + next.f30554u + "&");
                stringBuffer.append("offer_url=" + next.f30545l + "&");
            } else {
                stringBuffer.append("key=" + next.f30539f + "&");
                stringBuffer.append("result=" + next.f30548o + "&");
                stringBuffer.append("duration=" + next.f30549p + "&");
                stringBuffer.append("video_size=" + next.f30550q + "&");
                stringBuffer.append("video_length=" + next.f30544k + "&");
                stringBuffer.append("reason=" + next.m22395s() + "&");
                stringBuffer.append("cid=" + next.f30555v + "&");
                stringBuffer.append("video_url=" + next.f30531E + "&");
                stringBuffer.append("rid=" + next.f30552s + "&");
                stringBuffer.append("rid_n=" + next.f30553t + "&");
                stringBuffer.append("unit_id=" + next.f30554u + "&");
                stringBuffer.append("offer_url=" + next.f30545l + "&");
            }
            if (next.f30536c != null) {
                stringBuffer.append("resource_type=" + next.f30536c + "&");
            }
            if (next.f30538e != null) {
                stringBuffer.append("creative=" + next.f30538e + "&");
            }
            stringBuffer.append(ShellAdbUtils.f33810d);
            it = it2;
        }
        return stringBuffer.toString();
    }

    /* renamed from: c */
    public final void m22438c(int i) {
        this.f30540g = i;
    }

    /* renamed from: c */
    public static String m22437c(VideoReportData videoReportData) {
        if (videoReportData != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + videoReportData.f30539f + "&");
            stringBuffer.append("result=" + videoReportData.f30548o + "&");
            stringBuffer.append("duration=" + videoReportData.f30549p + "&");
            stringBuffer.append("cid=" + videoReportData.f30555v + "&");
            stringBuffer.append("reason=" + videoReportData.m22395s() + "&");
            stringBuffer.append("ad_type=" + videoReportData.f30533G + "&");
            stringBuffer.append("unit_id=" + videoReportData.f30554u + "&");
            stringBuffer.append("devid=" + videoReportData.f30537d + "&");
            stringBuffer.append("mraid_type=" + videoReportData.f30534H + "&");
            stringBuffer.append("network_type=" + videoReportData.f30540g + "&");
            if (!TextUtils.isEmpty(videoReportData.f30530D)) {
                stringBuffer.append("endcard_url=" + videoReportData.f30530D + "&");
            }
            if (!TextUtils.isEmpty(videoReportData.f30529C)) {
                stringBuffer.append("type=" + videoReportData.f30529C + "&");
            }
            if (videoReportData.f30536c != null) {
                stringBuffer.append("resource_type=" + videoReportData.f30536c + "&");
            }
            stringBuffer.append("rid_n=" + videoReportData.f30553t + "&");
            StringBuilder sb = new StringBuilder();
            sb.append("rid=");
            sb.append(videoReportData.f30552s);
            stringBuffer.append(sb.toString());
            stringBuffer.append(ShellAdbUtils.f33810d);
            return stringBuffer.toString();
        }
        return null;
    }

    /* renamed from: e */
    public static String m22426e(List<VideoReportData> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (VideoReportData videoReportData : list) {
            if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + videoReportData.f30539f + "&");
                stringBuffer.append("network_type=" + videoReportData.f30540g + "&");
                stringBuffer.append("cid=" + videoReportData.f30555v + "&");
                stringBuffer.append("image_url=" + videoReportData.f30532F + "&");
                stringBuffer.append("reason=" + videoReportData.m22395s() + "&");
                stringBuffer.append("rid=" + videoReportData.f30552s + "&");
                stringBuffer.append("rid_n=" + videoReportData.f30553t + "&");
                stringBuffer.append("unit_id=" + videoReportData.f30554u + "&");
                stringBuffer.append(ShellAdbUtils.f33810d);
            } else {
                stringBuffer.append("key=" + videoReportData.f30539f + "&");
                stringBuffer.append("cid=" + videoReportData.f30555v + "&");
                stringBuffer.append("image_url=" + videoReportData.f30532F + "&");
                stringBuffer.append("reason=" + videoReportData.m22395s() + "&");
                stringBuffer.append("rid=" + videoReportData.f30552s + "&");
                stringBuffer.append("rid_n=" + videoReportData.f30553t + "&");
                stringBuffer.append("unit_id=" + videoReportData.f30554u + "&");
                stringBuffer.append(ShellAdbUtils.f33810d);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: f */
    public static String m22424f(VideoReportData videoReportData) {
        if (videoReportData != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    stringBuffer.append("key=" + videoReportData.f30539f + "&");
                    stringBuffer.append("event=" + SameTool.m21991c(videoReportData.f30559z) + "&");
                    stringBuffer.append("template=" + SameTool.m21991c(videoReportData.f30557x) + "&");
                    stringBuffer.append("layout=" + SameTool.m21991c(videoReportData.f30527A) + "&");
                    stringBuffer.append("unit_id=" + SameTool.m21991c(videoReportData.f30554u) + "&");
                    stringBuffer.append("cid=" + SameTool.m21991c(videoReportData.f30555v) + "&");
                    stringBuffer.append("network_str=" + videoReportData.f30541h + "&");
                    StringBuilder sb = new StringBuilder();
                    sb.append("network_type=");
                    sb.append(videoReportData.f30540g);
                    stringBuffer.append(sb.toString());
                } else {
                    stringBuffer.append("key=" + videoReportData.f30539f + "&");
                    stringBuffer.append("event=" + SameTool.m21991c(videoReportData.f30559z) + "&");
                    stringBuffer.append("template=" + SameTool.m21991c(videoReportData.f30557x) + "&");
                    stringBuffer.append("layout=" + SameTool.m21991c(videoReportData.f30527A) + "&");
                    stringBuffer.append("unit_id=" + SameTool.m21991c(videoReportData.f30554u) + "&");
                    stringBuffer.append("cid=" + SameTool.m21991c(videoReportData.f30555v) + "&");
                }
                return stringBuffer.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: d */
    public final void m22433d(int i) {
        this.f30548o = i;
    }

    /* renamed from: d */
    public static String m22432d(VideoReportData videoReportData) {
        if (videoReportData != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + videoReportData.f30539f + "&");
            stringBuffer.append("result=" + videoReportData.f30548o + "&");
            stringBuffer.append("duration=" + videoReportData.f30549p + "&");
            stringBuffer.append("cid=" + videoReportData.f30555v + "&");
            stringBuffer.append("unit_id=" + videoReportData.f30554u + "&");
            stringBuffer.append("reason=" + videoReportData.m22395s() + "&");
            stringBuffer.append("ad_type=" + videoReportData.f30533G + "&");
            stringBuffer.append("rid=" + videoReportData.f30552s + "&");
            stringBuffer.append("rid_n=" + videoReportData.f30553t + "&");
            stringBuffer.append("network_type=" + videoReportData.f30540g + "&");
            stringBuffer.append("mraid_type=" + videoReportData.f30534H + "&");
            stringBuffer.append("devid=" + videoReportData.f30537d + "&");
            if (videoReportData.f30536c != null) {
                stringBuffer.append("resource_type=" + videoReportData.f30536c + "&");
            }
            if (!TextUtils.isEmpty(videoReportData.f30530D)) {
                stringBuffer.append("endcard_url=" + videoReportData.f30530D + "&");
            }
            stringBuffer.append("type=" + videoReportData.f30529C);
            return stringBuffer.toString();
        }
        return null;
    }

    public VideoReportData() {
    }

    public VideoReportData(String str, int i, String str2, String str3, String str4) {
        this.f30539f = str;
        this.f30541h = str4;
        this.f30540g = i;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.f30545l = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        this.f30546m = str3;
    }

    public VideoReportData(String str, int i, int i2, String str2, int i3, String str3, int i4, String str4) {
        this.f30539f = str;
        this.f30540g = i;
        this.f30541h = str4;
        this.f30544k = i2;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.f30545l = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        this.f30548o = i3;
        this.f30549p = str3;
        this.f30550q = i4;
    }

    /* renamed from: e */
    public static String m22428e(VideoReportData videoReportData) {
        if (videoReportData != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    stringBuffer.append("key=" + videoReportData.f30539f + "&");
                    stringBuffer.append("error=" + SameTool.m21991c(videoReportData.f30558y) + "&");
                    stringBuffer.append("template_url=" + SameTool.m21991c(videoReportData.f30556w) + "&");
                    stringBuffer.append("unit_id=" + SameTool.m21991c(videoReportData.f30554u) + "&");
                    stringBuffer.append("cid=" + SameTool.m21991c(videoReportData.f30555v) + "&");
                    stringBuffer.append("network_str=" + videoReportData.f30541h + "&");
                    StringBuilder sb = new StringBuilder();
                    sb.append("network_type=");
                    sb.append(videoReportData.f30540g);
                    stringBuffer.append(sb.toString());
                } else {
                    stringBuffer.append("key=" + videoReportData.f30539f + "&");
                    stringBuffer.append("error=" + SameTool.m21991c(videoReportData.f30558y) + "&");
                    stringBuffer.append("template_url=" + SameTool.m21991c(videoReportData.f30556w) + "&");
                    stringBuffer.append("unit_id=" + SameTool.m21991c(videoReportData.f30554u) + "&");
                    stringBuffer.append("cid=" + SameTool.m21991c(videoReportData.f30555v) + "&");
                }
                return stringBuffer.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: f */
    public static String m22422f(List<VideoReportData> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (VideoReportData videoReportData : list) {
                        stringBuffer.append(videoReportData.f30528B);
                        stringBuffer.append(ShellAdbUtils.f33810d);
                    }
                    return stringBuffer.toString();
                }
                return null;
            } catch (Throwable th) {
                SameLogTool.m21735b("VideoReportData", th.getMessage(), th);
                return null;
            }
        }
        return null;
    }

    public VideoReportData(Context context, CampaignEx campaignEx, int i, String str, long j, int i2) {
        if (i2 == 1) {
            this.f30539f = "2000022";
        } else if (i2 == 287 || i2 == 94) {
            this.f30539f = "2000022";
        } else if (i2 == 95) {
            this.f30539f = "2000025";
        }
        int m21804D = SameDiTool.m21804D(context);
        this.f30540g = m21804D;
        this.f30541h = SameDiTool.m21784a(context, m21804D);
        this.f30544k = campaignEx.getVideoLength();
        this.f30552s = campaignEx.getRequestId();
        this.f30553t = campaignEx.getRequestIdNotice();
        if (!TextUtils.isEmpty(this.f30545l)) {
            try {
                this.f30545l = URLEncoder.encode(campaignEx.getNoticeUrl() == null ? campaignEx.getClickURL() : campaignEx.getNoticeUrl(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        this.f30548o = i;
        this.f30549p = str;
        this.f30550q = j == 0 ? campaignEx.getVideoSize() : j;
    }

    /* renamed from: a */
    public static String m22447a(VideoReportData videoReportData) {
        if (videoReportData != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + videoReportData.f30539f + "&");
            stringBuffer.append("cid=" + videoReportData.f30555v + "&");
            stringBuffer.append("unit_id=" + videoReportData.f30554u + "&");
            stringBuffer.append("network_type=" + videoReportData.f30540g + "&");
            stringBuffer.append("rid=" + videoReportData.f30552s + "&");
            stringBuffer.append("rid_n=" + videoReportData.f30553t + "&");
            StringBuilder sb = new StringBuilder();
            sb.append("reason=");
            sb.append(videoReportData.m22395s());
            stringBuffer.append(sb.toString());
            stringBuffer.append(ShellAdbUtils.f33810d);
            return stringBuffer.toString();
        }
        return null;
    }

    /* renamed from: d */
    public static String m22430d(List<VideoReportData> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (VideoReportData videoReportData : list) {
            if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + videoReportData.f30539f + "&");
                stringBuffer.append("network_type=" + videoReportData.f30540g + "&");
                stringBuffer.append("result=" + videoReportData.f30548o + "&");
                stringBuffer.append("cid=" + videoReportData.f30555v + "&");
                stringBuffer.append("template_url=" + videoReportData.f30556w + "&");
                stringBuffer.append("reason=" + videoReportData.m22395s() + "&");
                stringBuffer.append("rid=" + videoReportData.f30552s + "&");
                stringBuffer.append("rid_n=" + videoReportData.f30553t + "&");
                stringBuffer.append("unit_id=" + videoReportData.f30554u + "&");
                stringBuffer.append(ShellAdbUtils.f33810d);
            } else {
                stringBuffer.append("key=" + videoReportData.f30539f + "&");
                stringBuffer.append("result=" + videoReportData.f30548o + "&");
                stringBuffer.append("cid=" + videoReportData.f30555v + "&");
                stringBuffer.append("template_url=" + videoReportData.f30556w + "&");
                stringBuffer.append("reason=" + videoReportData.m22395s() + "&");
                stringBuffer.append("rid=" + videoReportData.f30552s + "&");
                stringBuffer.append("rid_n=" + videoReportData.f30553t + "&");
                stringBuffer.append("unit_id=" + videoReportData.f30554u + "&");
                stringBuffer.append(ShellAdbUtils.f33810d);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: c */
    public static String m22435c(List<VideoReportData> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (VideoReportData videoReportData : list) {
            stringBuffer.append("key=" + videoReportData.f30539f + "&");
            stringBuffer.append("result=" + videoReportData.f30548o + "&");
            stringBuffer.append("duration=" + videoReportData.f30549p + "&");
            stringBuffer.append("endcard_url=" + videoReportData.f30530D + "&");
            stringBuffer.append("cid=" + videoReportData.f30555v + "&");
            stringBuffer.append("unit_id=" + videoReportData.f30554u + "&");
            stringBuffer.append("reason=" + videoReportData.m22395s() + "&");
            stringBuffer.append("ad_type=" + videoReportData.f30533G + "&");
            stringBuffer.append("rid=" + videoReportData.f30552s + "&");
            stringBuffer.append("rid_n=" + videoReportData.f30553t + "&");
            stringBuffer.append("type=" + videoReportData.f30529C + "&");
            StringBuilder sb = new StringBuilder();
            sb.append("adspace_t=");
            sb.append(videoReportData.f30535I);
            stringBuffer.append(sb.toString());
            stringBuffer.append(ShellAdbUtils.f33810d);
        }
        return stringBuffer.toString();
    }

    public VideoReportData(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        this.f30539f = str;
        this.f30559z = str2;
        this.f30557x = str3;
        this.f30527A = str4;
        this.f30554u = str5;
        this.f30555v = str6;
        this.f30540g = i;
        this.f30541h = str7;
    }

    /* renamed from: b */
    public static String m22442b(VideoReportData videoReportData) {
        if (videoReportData != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=" + videoReportData.f30539f + "&");
            stringBuffer.append("cid=" + videoReportData.f30555v + "&");
            stringBuffer.append("unit_id=" + videoReportData.f30554u + "&");
            stringBuffer.append("network_type=" + videoReportData.f30540g + "&");
            stringBuffer.append("mraid_type=" + videoReportData.f30534H + "&");
            stringBuffer.append("rid_n=" + videoReportData.f30553t + "&");
            StringBuilder sb = new StringBuilder();
            sb.append("rid=");
            sb.append(videoReportData.f30552s);
            stringBuffer.append(sb.toString());
            stringBuffer.append(ShellAdbUtils.f33810d);
            return stringBuffer.toString();
        }
        return null;
    }

    public VideoReportData(String str) {
        this.f30528B = str;
    }

    public VideoReportData(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f30539f = str;
        this.f30548o = i;
        this.f30549p = str2;
        try {
            if (!TextUtils.isEmpty(str3)) {
                this.f30530D = URLEncoder.encode(str3, "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.f30555v = str4;
        this.f30554u = str5;
        this.f30546m = str6;
        this.f30529C = str7;
        if (Integer.valueOf(str2).intValue() > CommonConst.f30598u) {
            this.f30548o = 2;
        }
    }

    public VideoReportData(String str, String str2, String str3, String str4, String str5, int i) {
        this.f30539f = str;
        this.f30555v = str2;
        this.f30552s = str3;
        this.f30553t = str4;
        this.f30554u = str5;
        this.f30540g = i;
    }

    public VideoReportData(String str, String str2, String str3, String str4, String str5, int i, int i2, String str6) {
        this.f30539f = str;
        this.f30555v = str2;
        this.f30552s = str3;
        this.f30553t = str4;
        this.f30554u = str5;
        this.f30540g = i;
        this.f30546m = str6;
        this.f30547n = i2;
    }
}
