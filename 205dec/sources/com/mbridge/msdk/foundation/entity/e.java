package com.mbridge.msdk.foundation.entity;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Iterator;
import java.util.List;

/* compiled from: ClickTime.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private String f39258a;

    /* renamed from: b  reason: collision with root package name */
    private String f39259b;

    /* renamed from: c  reason: collision with root package name */
    private String f39260c;

    /* renamed from: d  reason: collision with root package name */
    private String f39261d;

    /* renamed from: e  reason: collision with root package name */
    private String f39262e;

    /* renamed from: f  reason: collision with root package name */
    private int f39263f;

    /* renamed from: g  reason: collision with root package name */
    private String f39264g;

    /* renamed from: h  reason: collision with root package name */
    private String f39265h;

    /* renamed from: i  reason: collision with root package name */
    private String f39266i;

    /* renamed from: j  reason: collision with root package name */
    private int f39267j;

    /* renamed from: k  reason: collision with root package name */
    private int f39268k;

    /* renamed from: l  reason: collision with root package name */
    private String f39269l;

    /* renamed from: m  reason: collision with root package name */
    private int f39270m;

    /* renamed from: n  reason: collision with root package name */
    private int f39271n;

    /* renamed from: o  reason: collision with root package name */
    private String f39272o;

    /* renamed from: p  reason: collision with root package name */
    private int f39273p;

    /* renamed from: q  reason: collision with root package name */
    private String f39274q;

    /* renamed from: r  reason: collision with root package name */
    private int f39275r;

    public e() {
    }

    public final void a(int i4) {
        this.f39273p = i4;
    }

    public final void b(String str) {
        this.f39269l = str;
    }

    public final void c(int i4) {
        this.f39271n = i4;
    }

    public final void d(int i4) {
        this.f39268k = i4;
    }

    public final void e(int i4) {
        this.f39263f = i4;
    }

    public final void f(String str) {
        this.f39266i = str;
    }

    public final void g(String str) {
        this.f39262e = str;
    }

    public final void h(String str) {
        this.f39260c = str;
    }

    public final void i(String str) {
        this.f39261d = str;
    }

    public final void j(String str) {
        this.f39258a = str;
    }

    public final void k(String str) {
        this.f39259b = str;
    }

    public final String toString() {
        return "ClickTime [campaignId=" + this.f39260c + ", click_duration=" + this.f39261d + ", lastUrl=" + this.f39262e + ", code=" + this.f39263f + ", excepiton=" + this.f39264g + ", header=" + this.f39265h + ", content=" + this.f39266i + ", type=" + this.f39267j + ", click_type=" + this.f39268k + "]";
    }

    public e(String str, String str2, String str3, String str4, String str5, int i4, String str6, String str7, String str8, int i5, int i6, String str9, int i7, int i8, String str10, int i9, int i10, String str11) {
        this.f39258a = str;
        this.f39259b = str2;
        this.f39260c = str3;
        this.f39261d = str4;
        this.f39262e = str5;
        this.f39263f = i4;
        this.f39264g = str6;
        this.f39265h = str7;
        this.f39266i = str8;
        this.f39267j = i5;
        this.f39268k = i6;
        this.f39269l = str9;
        this.f39270m = i7;
        this.f39271n = i8;
        this.f39272o = str10;
        this.f39273p = i9;
        this.f39274q = str11;
        this.f39275r = i10;
    }

    public final void a(String str) {
        this.f39274q = str;
    }

    public final void b(int i4) {
        this.f39270m = i4;
    }

    public final void c(String str) {
        this.f39272o = str;
    }

    public final void d(String str) {
        this.f39264g = str;
    }

    public final void e(String str) {
        this.f39265h = str;
    }

    public final void f(int i4) {
        this.f39267j = i4;
    }

    public static String a(List<e> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<e> it = list.iterator();
        while (it.hasNext()) {
            e next = it.next();
            String str = next.f39269l;
            if (!TextUtils.isEmpty(str)) {
                String str2 = com.mbridge.msdk.foundation.controller.a.f39078b.get(str);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("u_stid=");
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                sb2.append("&");
                sb.append(sb2.toString());
            }
            Iterator<e> it2 = it;
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                sb.append("rid=" + next.f39258a);
                sb.append("&rid_n=" + next.f39259b);
                sb.append("&network_type=" + next.f39273p);
                sb.append("&network_str=" + next.f39274q);
                sb.append("&cid=" + next.f39260c);
                sb.append("&click_type=" + next.f39268k);
                sb.append("&type=" + next.f39267j);
                sb.append("&click_duration=" + next.f39261d);
                sb.append("&key=2000013");
                sb.append("&unit_id=" + next.f39269l);
                sb.append("&last_url=" + next.f39262e);
                sb.append("&content=" + next.f39266i);
                sb.append("&code=" + next.f39263f);
                sb.append("&exception=" + next.f39264g);
                sb.append("&header=" + next.f39265h);
                sb.append("&landing_type=" + next.f39270m);
                sb.append("&link_type=" + next.f39271n);
                sb.append("&click_time=" + next.f39272o + "\n");
            } else {
                sb.append("rid=" + next.f39258a);
                sb.append("&rid_n=" + next.f39259b);
                sb.append("&cid=" + next.f39260c);
                sb.append("&click_type=" + next.f39268k);
                sb.append("&type=" + next.f39267j);
                sb.append("&click_duration=" + next.f39261d);
                sb.append("&key=2000013");
                sb.append("&unit_id=" + next.f39269l);
                sb.append("&last_url=" + next.f39262e);
                sb.append("&content=" + next.f39266i);
                sb.append("&code=" + next.f39263f);
                sb.append("&exception=" + next.f39264g);
                sb.append("&header=" + next.f39265h);
                sb.append("&landing_type=" + next.f39270m);
                sb.append("&link_type=" + next.f39271n);
                sb.append("&click_time=" + next.f39272o + "\n");
            }
            it = it2;
        }
        return sb.toString();
    }

    public static String a(e eVar) {
        if (eVar != null) {
            StringBuilder sb = new StringBuilder();
            String str = eVar.f39262e;
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                sb.append("rid=" + eVar.f39258a);
                sb.append("&rid_n=" + eVar.f39259b);
                sb.append("&network_type=" + eVar.f39273p);
                sb.append("&network_str=" + eVar.f39274q);
                sb.append("&click_type=" + eVar.f39268k);
                sb.append("&type=" + eVar.f39267j);
                sb.append("&cid=" + eVar.f39260c);
                sb.append("&click_duration=" + eVar.f39261d);
                sb.append("&key=2000012");
                sb.append("&unit_id=" + eVar.f39269l);
                sb.append("&last_url=" + str);
                sb.append("&code=" + eVar.f39263f);
                sb.append("&exception=" + eVar.f39264g);
                sb.append("&landing_type=" + eVar.f39270m);
                sb.append("&link_type=" + eVar.f39271n);
                sb.append("&click_time=" + eVar.f39272o + "\n");
            } else {
                sb.append("rid=" + eVar.f39258a);
                sb.append("&rid_n=" + eVar.f39259b);
                sb.append("&click_type=" + eVar.f39268k);
                sb.append("&type=" + eVar.f39267j);
                sb.append("&cid=" + eVar.f39260c);
                sb.append("&click_duration=" + eVar.f39261d);
                sb.append("&key=2000012");
                sb.append("&unit_id=" + eVar.f39269l);
                sb.append("&last_url=" + str);
                sb.append("&code=" + eVar.f39263f);
                sb.append("&exception=" + eVar.f39264g);
                sb.append("&landing_type=" + eVar.f39270m);
                sb.append("&link_type=" + eVar.f39271n);
                sb.append("&click_time=" + eVar.f39272o + "\n");
            }
            return sb.toString();
        }
        return null;
    }
}
