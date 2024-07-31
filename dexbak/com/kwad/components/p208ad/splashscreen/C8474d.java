package com.kwad.components.p208ad.splashscreen;

import android.text.TextUtils;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.p208ad.splashscreen.p277b.C8363a;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;

/* renamed from: com.kwad.components.ad.splashscreen.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8474d {

    /* renamed from: Ci */
    public static int f27844Ci;

    /* renamed from: Cj */
    private String f27845Cj;

    /* renamed from: Ck */
    private int f27846Ck = 2;

    /* renamed from: S */
    private void m30662S(String str) {
        this.f27845Cj = str;
    }

    /* renamed from: V */
    private void m30661V(int i) {
        this.f27846Ck = i;
    }

    /* renamed from: a */
    public static C8474d m30657a(AdTemplate adTemplate, AdInfo adInfo, C8619c c8619c, int i) {
        C8474d c8474d = new C8474d();
        f27844Ci = i;
        if (adInfo != null && c8619c != null) {
            if (i != 1 && i != 4) {
                if (C10483a.m25956aF(adInfo)) {
                    int m30141nW = c8619c.m30141nW();
                    c8474d.m30662S("或点击" + m30659a(adTemplate, adInfo, m30141nW, 0));
                } else {
                    String m26522a = C10251d.m26522a(C8363a.f27626CO);
                    if (TextUtils.isEmpty(m26522a)) {
                        m26522a = "点击跳转详情页或第三方应用";
                    }
                    c8474d.m30662S("或" + m26522a);
                }
            } else {
                c8474d.m30662S(m30658a(adTemplate, adInfo, c8619c));
            }
        }
        c8474d.m30661V(C10484b.m25686ds(adInfo));
        return c8474d;
    }

    /* renamed from: ku */
    public final String m30656ku() {
        return this.f27845Cj;
    }

    /* renamed from: kv */
    public final int m30655kv() {
        return this.f27846Ck;
    }

    /* renamed from: a */
    public static String m30659a(AdTemplate adTemplate, AdInfo adInfo, int i, int i2) {
        String m25957aE = C10483a.m25957aE(adInfo);
        if (i == 2) {
            return i2 + "%";
        } else if (i != 4) {
            if (i != 8) {
                return i != 12 ? m25957aE : C10483a.m25933ac(adInfo);
            }
            return C10483a.m25882bY(adTemplate);
        } else {
            return "继续下载";
        }
    }

    /* renamed from: a */
    private static String m30660a(AdInfo adInfo, int i) {
        return i == 1 ? C10484b.m25698dm(adInfo) != null ? C10484b.m25698dm(adInfo) : "" : (i != 4 || C10484b.m25696dn(adInfo) == null) ? "" : C10484b.m25696dn(adInfo);
    }

    /* renamed from: a */
    private static String m30658a(AdTemplate adTemplate, AdInfo adInfo, C8619c c8619c) {
        if (C10483a.m25956aF(adInfo)) {
            return m30659a(adTemplate, adInfo, c8619c.m30141nW(), 0);
        }
        String m30660a = m30660a(adInfo, f27844Ci);
        return TextUtils.isEmpty(m30660a) ? "点击跳转详情页或第三方应用" : m30660a;
    }
}
