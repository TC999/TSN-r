package com.mbridge.msdk.foundation.entity;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.entity.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ClickTime {

    /* renamed from: a */
    private String f30437a;

    /* renamed from: b */
    private String f30438b;

    /* renamed from: c */
    private String f30439c;

    /* renamed from: d */
    private String f30440d;

    /* renamed from: e */
    private String f30441e;

    /* renamed from: f */
    private int f30442f;

    /* renamed from: g */
    private String f30443g;

    /* renamed from: h */
    private String f30444h;

    /* renamed from: i */
    private String f30445i;

    /* renamed from: j */
    private int f30446j;

    /* renamed from: k */
    private int f30447k;

    /* renamed from: l */
    private String f30448l;

    /* renamed from: m */
    private int f30449m;

    /* renamed from: n */
    private int f30450n;

    /* renamed from: o */
    private String f30451o;

    /* renamed from: p */
    private int f30452p;

    /* renamed from: q */
    private String f30453q;

    /* renamed from: r */
    private int f30454r;

    public ClickTime() {
    }

    /* renamed from: a */
    public final void m22597a(int i) {
        this.f30452p = i;
    }

    /* renamed from: b */
    public final void m22592b(String str) {
        this.f30448l = str;
    }

    /* renamed from: c */
    public final void m22591c(int i) {
        this.f30450n = i;
    }

    /* renamed from: d */
    public final void m22589d(int i) {
        this.f30447k = i;
    }

    /* renamed from: e */
    public final void m22587e(int i) {
        this.f30442f = i;
    }

    /* renamed from: f */
    public final void m22584f(String str) {
        this.f30445i = str;
    }

    /* renamed from: g */
    public final void m22583g(String str) {
        this.f30441e = str;
    }

    /* renamed from: h */
    public final void m22582h(String str) {
        this.f30439c = str;
    }

    /* renamed from: i */
    public final void m22581i(String str) {
        this.f30440d = str;
    }

    /* renamed from: j */
    public final void m22580j(String str) {
        this.f30437a = str;
    }

    /* renamed from: k */
    public final void m22579k(String str) {
        this.f30438b = str;
    }

    public final String toString() {
        return "ClickTime [campaignId=" + this.f30439c + ", click_duration=" + this.f30440d + ", lastUrl=" + this.f30441e + ", code=" + this.f30442f + ", excepiton=" + this.f30443g + ", header=" + this.f30444h + ", content=" + this.f30445i + ", type=" + this.f30446j + ", click_type=" + this.f30447k + "]";
    }

    public ClickTime(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, int i2, int i3, String str9, int i4, int i5, String str10, int i6, int i7, String str11) {
        this.f30437a = str;
        this.f30438b = str2;
        this.f30439c = str3;
        this.f30440d = str4;
        this.f30441e = str5;
        this.f30442f = i;
        this.f30443g = str6;
        this.f30444h = str7;
        this.f30445i = str8;
        this.f30446j = i2;
        this.f30447k = i3;
        this.f30448l = str9;
        this.f30449m = i4;
        this.f30450n = i5;
        this.f30451o = str10;
        this.f30452p = i6;
        this.f30453q = str11;
        this.f30454r = i7;
    }

    /* renamed from: a */
    public final void m22595a(String str) {
        this.f30453q = str;
    }

    /* renamed from: b */
    public final void m22593b(int i) {
        this.f30449m = i;
    }

    /* renamed from: c */
    public final void m22590c(String str) {
        this.f30451o = str;
    }

    /* renamed from: d */
    public final void m22588d(String str) {
        this.f30443g = str;
    }

    /* renamed from: e */
    public final void m22586e(String str) {
        this.f30444h = str;
    }

    /* renamed from: f */
    public final void m22585f(int i) {
        this.f30446j = i;
    }

    /* renamed from: a */
    public static String m22594a(List<ClickTime> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<ClickTime> it = list.iterator();
        while (it.hasNext()) {
            ClickTime next = it.next();
            String str = next.f30448l;
            if (!TextUtils.isEmpty(str)) {
                String str2 = MBSDKContext.f30251b.get(str);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("u_stid=");
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                sb2.append("&");
                sb.append(sb2.toString());
            }
            Iterator<ClickTime> it2 = it;
            if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                sb.append("rid=" + next.f30437a);
                sb.append("&rid_n=" + next.f30438b);
                sb.append("&network_type=" + next.f30452p);
                sb.append("&network_str=" + next.f30453q);
                sb.append("&cid=" + next.f30439c);
                sb.append("&click_type=" + next.f30447k);
                sb.append("&type=" + next.f30446j);
                sb.append("&click_duration=" + next.f30440d);
                sb.append("&key=2000013");
                sb.append("&unit_id=" + next.f30448l);
                sb.append("&last_url=" + next.f30441e);
                sb.append("&content=" + next.f30445i);
                sb.append("&code=" + next.f30442f);
                sb.append("&exception=" + next.f30443g);
                sb.append("&header=" + next.f30444h);
                sb.append("&landing_type=" + next.f30449m);
                sb.append("&link_type=" + next.f30450n);
                sb.append("&click_time=" + next.f30451o + ShellAdbUtils.f33810d);
            } else {
                sb.append("rid=" + next.f30437a);
                sb.append("&rid_n=" + next.f30438b);
                sb.append("&cid=" + next.f30439c);
                sb.append("&click_type=" + next.f30447k);
                sb.append("&type=" + next.f30446j);
                sb.append("&click_duration=" + next.f30440d);
                sb.append("&key=2000013");
                sb.append("&unit_id=" + next.f30448l);
                sb.append("&last_url=" + next.f30441e);
                sb.append("&content=" + next.f30445i);
                sb.append("&code=" + next.f30442f);
                sb.append("&exception=" + next.f30443g);
                sb.append("&header=" + next.f30444h);
                sb.append("&landing_type=" + next.f30449m);
                sb.append("&link_type=" + next.f30450n);
                sb.append("&click_time=" + next.f30451o + ShellAdbUtils.f33810d);
            }
            it = it2;
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m22596a(ClickTime clickTime) {
        if (clickTime != null) {
            StringBuilder sb = new StringBuilder();
            String str = clickTime.f30441e;
            if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                sb.append("rid=" + clickTime.f30437a);
                sb.append("&rid_n=" + clickTime.f30438b);
                sb.append("&network_type=" + clickTime.f30452p);
                sb.append("&network_str=" + clickTime.f30453q);
                sb.append("&click_type=" + clickTime.f30447k);
                sb.append("&type=" + clickTime.f30446j);
                sb.append("&cid=" + clickTime.f30439c);
                sb.append("&click_duration=" + clickTime.f30440d);
                sb.append("&key=2000012");
                sb.append("&unit_id=" + clickTime.f30448l);
                sb.append("&last_url=" + str);
                sb.append("&code=" + clickTime.f30442f);
                sb.append("&exception=" + clickTime.f30443g);
                sb.append("&landing_type=" + clickTime.f30449m);
                sb.append("&link_type=" + clickTime.f30450n);
                sb.append("&click_time=" + clickTime.f30451o + ShellAdbUtils.f33810d);
            } else {
                sb.append("rid=" + clickTime.f30437a);
                sb.append("&rid_n=" + clickTime.f30438b);
                sb.append("&click_type=" + clickTime.f30447k);
                sb.append("&type=" + clickTime.f30446j);
                sb.append("&cid=" + clickTime.f30439c);
                sb.append("&click_duration=" + clickTime.f30440d);
                sb.append("&key=2000012");
                sb.append("&unit_id=" + clickTime.f30448l);
                sb.append("&last_url=" + str);
                sb.append("&code=" + clickTime.f30442f);
                sb.append("&exception=" + clickTime.f30443g);
                sb.append("&landing_type=" + clickTime.f30449m);
                sb.append("&link_type=" + clickTime.f30450n);
                sb.append("&click_time=" + clickTime.f30451o + ShellAdbUtils.f33810d);
            }
            return sb.toString();
        }
        return null;
    }
}
