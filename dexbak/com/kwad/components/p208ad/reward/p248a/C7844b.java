package com.kwad.components.p208ad.reward.p248a;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;

/* renamed from: com.kwad.components.ad.reward.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7844b {
    /* renamed from: gA */
    public static int m32194gA() {
        return C7843a.f26430qG.getValue().intValue();
    }

    /* renamed from: gB */
    public static boolean m32193gB() {
        return C7843a.f26431qH.getValue().booleanValue();
    }

    /* renamed from: gC */
    public static boolean m32192gC() {
        return C7843a.f26432qI.getValue().intValue() == 1 || C7843a.f26432qI.getValue().intValue() == 3;
    }

    /* renamed from: gD */
    public static boolean m32191gD() {
        return C7843a.f26433qJ.getValue().booleanValue();
    }

    /* renamed from: gE */
    public static boolean m32190gE() {
        return C7843a.f26434qK.getValue().booleanValue();
    }

    /* renamed from: gp */
    public static int m32189gp() {
        return C7843a.f26435qt.getValue().intValue();
    }

    /* renamed from: gq */
    public static String m32188gq() {
        return C7843a.f26439qx.getValue();
    }

    /* renamed from: gr */
    public static int m32187gr() {
        return C7843a.f26436qu.getValue().intValue();
    }

    /* renamed from: gs */
    public static boolean m32186gs() {
        return C7843a.f26438qw.getValue().booleanValue();
    }

    /* renamed from: gt */
    public static int m32185gt() {
        return C7843a.f26437qv.getValue().intValue();
    }

    /* renamed from: gu */
    private static boolean m32184gu() {
        return C7843a.f26441qz.getValue().intValue() == 1;
    }

    /* renamed from: gv */
    public static float m32183gv() {
        return C7843a.f26428qE.getValue().floatValue();
    }

    /* renamed from: gw */
    public static boolean m32182gw() {
        return C7843a.f26428qE.getValue().floatValue() > 0.0f && C7843a.f26428qE.getValue().floatValue() < 1.0f;
    }

    /* renamed from: gx */
    public static boolean m32181gx() {
        return C7843a.f26429qF.getValue().booleanValue();
    }

    /* renamed from: gy */
    public static long m32180gy() {
        return C7843a.f26426qC.getValue().intValue();
    }

    /* renamed from: gz */
    public static int m32179gz() {
        return C7843a.f26427qD.getValue().intValue();
    }

    /* renamed from: i */
    public static boolean m32178i(AdInfo adInfo) {
        return !m32177j(adInfo) && C10483a.m25844cJ(adInfo) && m32184gu();
    }

    /* renamed from: j */
    public static boolean m32177j(AdInfo adInfo) {
        return C10483a.m25844cJ(adInfo) && C7843a.f26425qB.getValue().intValue() == 1;
    }

    /* renamed from: k */
    public static boolean m32176k(AdInfo adInfo) {
        return m32178i(adInfo);
    }
}
