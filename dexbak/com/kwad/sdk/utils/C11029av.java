package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p205p0.C7282g;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.p433f.C10758b;
import com.kwad.sdk.p433f.InterfaceC10759c;
import com.kwad.sdk.p441l.p442a.C10853b;
import com.kwad.sdk.p441l.p442a.C10857f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.C11073bu;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.p452c.C11078a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.kwad.sdk.utils.av */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11029av {
    public static String aPG = "";

    /* renamed from: Ky */
    public static C10853b m24062Ky() {
        return C10853b.m24642Ky();
    }

    /* renamed from: Kz */
    public static C10857f m24061Kz() {
        return C10857f.m24627Kz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Mu */
    public static String m24060Mu() {
        C10857f m24627Kz = C10857f.m24627Kz();
        int i = m24627Kz != null ? m24627Kz.aNe : -1;
        if (i >= 0) {
            return C10758b.m24897a(false, String.valueOf(i), 0);
        }
        if (!((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24323yA()) {
            return C10758b.m24897a(false, String.valueOf(i), 1);
        }
        return C10758b.m24897a(false, String.valueOf(i), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Mv */
    public static String m24059Mv() {
        C10853b m24642Ky = C10853b.m24642Ky();
        if (m24642Ky != null) {
            return C10758b.m24897a(false, m24642Ky.toJson(), 0);
        }
        if (!((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24321yC()) {
            return C10758b.m24897a(false, "", 1);
        }
        return C10758b.m24897a(false, "", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Mw */
    public static String m24058Mw() {
        return C10758b.m24897a(false, "1", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Mx */
    public static String m24057Mx() {
        return C10758b.m24897a(false, String.valueOf(getSdkVersion()), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: My */
    public static String m24056My() {
        return C10758b.m24897a(false, String.valueOf(getAppId()), 0);
    }

    /* renamed from: bS */
    private static String m24055bS(boolean z) {
        String m23887cd = C11059bi.m23887cd(z);
        if (!z) {
            return TextUtils.isEmpty(m23887cd) ? "" : m23887cd;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(m23887cd)) {
            return C10758b.m24897a((!C11028au.m24068Mo() || TextUtils.isEmpty(C11028au.m24067Mp())) ? false : false, m23887cd, 0);
        } else if (!C11028au.m24068Mo() && C11120o.m23760Lk()) {
            return C10758b.m24897a(false, m23887cd, 5);
        } else {
            return C10758b.m24897a(false, m23887cd, 1);
        }
    }

    /* renamed from: bT */
    private static String m24054bT(boolean z) {
        if (C9425a.f29473md.booleanValue() && !TextUtils.isEmpty(C11060bj.getDeviceId())) {
            return C11060bj.getDeviceId();
        }
        String deviceId = C11059bi.getDeviceId();
        if (!z) {
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(deviceId)) {
            return C10758b.m24897a((!C11028au.usePhoneStateDisable() || TextUtils.isEmpty(C11028au.m24071Ml())) ? false : false, deviceId, 0);
        } else if (!C11028au.usePhoneStateDisable() && C11120o.m23762Li()) {
            return C10758b.m24897a(false, deviceId, 5);
        } else {
            return C10758b.m24897a(false, deviceId, 1);
        }
    }

    /* renamed from: bU */
    private static String m24053bU(boolean z) {
        String m23898Nj = C11059bi.m23898Nj();
        if (!z) {
            return TextUtils.isEmpty(m23898Nj) ? "" : m23898Nj;
        } else if (!TextUtils.isEmpty(m23898Nj)) {
            return C10758b.m24897a(C11028au.m24066Mq(), m23898Nj, 0);
        } else {
            if (!C11028au.m24066Mq() && !((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(8L)) {
                return C10758b.m24897a(false, m23898Nj, 2);
            }
            return C10758b.m24897a(false, m23898Nj, 1);
        }
    }

    /* renamed from: bV */
    static /* synthetic */ String m24051bV(boolean z) {
        return m24055bS(true);
    }

    /* renamed from: bW */
    static /* synthetic */ String m24050bW(boolean z) {
        return m24060Mu();
    }

    /* renamed from: bX */
    static /* synthetic */ String m24049bX(boolean z) {
        return m24059Mv();
    }

    /* renamed from: bY */
    static /* synthetic */ String m24048bY(boolean z) {
        return m24054bT(true);
    }

    /* renamed from: bZ */
    static /* synthetic */ String m24047bZ(boolean z) {
        return m24053bU(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static String m24046c(Context context, boolean z) {
        String m23871u = C11059bi.m23871u(context, z);
        if (!z) {
            return TextUtils.isEmpty(m23871u) ? "" : m23871u;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(m23871u)) {
            return C10758b.m24897a((!C11028au.usePhoneStateDisable() || TextUtils.isEmpty(C11028au.m24073Mj())) ? false : false, m23871u, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return C10758b.m24897a(false, m23871u, 4);
        } else {
            if (!C11028au.usePhoneStateDisable() && C11120o.m23756Lo()) {
                return C10758b.m24897a(false, m23871u, SystemUtil.m24269cU(context) ? 3 : 1);
            }
            return C10758b.m24897a(false, m23871u, 1);
        }
    }

    /* renamed from: cA */
    public static String m24045cA(Context context) {
        return m24024h(context, false);
    }

    /* renamed from: cB */
    public static String m24044cB(Context context) {
        return m24023i(context, false);
    }

    /* renamed from: cC */
    public static int m24043cC(Context context) {
        return C11059bi.m23884db(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cD */
    public static String m24042cD(Context context) {
        int m23884db = C11059bi.m23884db(context);
        if (m23884db > 0) {
            return C10758b.m24897a(false, String.valueOf(m23884db), 0);
        }
        if (Build.VERSION.SDK_INT < 23) {
            return C10758b.m24897a(false, String.valueOf(m23884db), 1);
        }
        return C10758b.m24897a(false, String.valueOf(m23884db), 3);
    }

    /* renamed from: cE */
    public static int m24041cE(Context context) {
        return C11059bi.m23883dc(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cF */
    public static String m24040cF(Context context) {
        List<C11073bu.C11074a> m24018n = m24018n(context, 15);
        if (m24018n != null && m24018n.size() > 0) {
            return C10758b.m24897a(C11028au.m24066Mq(), C11126t.m23681O(m24018n), 0);
        }
        if (!C11028au.m24066Mq() && !((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(32L)) {
            return C10758b.m24897a(false, "", C11073bu.m23844dj(context) ? 1 : 3);
        }
        return C10758b.m24897a(false, "", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cG */
    public static String m24039cG(Context context) {
        C10232b.m26625DD();
        if (!C10232b.isAppOnForeground()) {
            return C10758b.m24897a(false, "", 5);
        }
        Map<String, InstalledAppInfoManager.AppPackageInfo> m24277bW = InstalledAppInfoManager.m24277bW(context);
        boolean z = true;
        if (m24277bW.size() > 0) {
            return C10758b.m24897a((!C11028au.m24064Ms() || C11028au.m24063Mt() == null) ? false : false, InstalledAppInfoManager.m24274h(m24277bW), 0);
        } else if (!C11028au.m24064Ms() && C11120o.m23758Lm()) {
            return C10758b.m24897a(false, "", C11059bi.m23877di(context) ? 3 : 1);
        } else {
            return C10758b.m24897a(false, "", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cH */
    public static String m24038cH(Context context) {
        C11078a m23711bV = C11123r.m23711bV(context);
        boolean z = true;
        if (m23711bV != null && m23711bV.aSm != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("latitude", String.valueOf(m23711bV.aSm.getLatitude()));
            hashMap.put("longitude", String.valueOf(m23711bV.aSm.getLongitude()));
            return C10758b.m24897a((!C11028au.m24075Mh() || C11028au.m24074Mi() == null) ? false : false, C11126t.parseMap2JSON(hashMap), 0);
        } else if (!C11028au.m24075Mh() && !((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(64L)) {
            return C10758b.m24897a(false, "", ContextCompat.checkSelfPermission(context, C7282g.f24949g) == 0 ? 3 : 1);
        } else {
            return C10758b.m24897a(false, "", 1);
        }
    }

    @NonNull
    /* renamed from: cI */
    private static InterfaceC10759c m24037cI(final Context context) {
        return new InterfaceC10759c() { // from class: com.kwad.sdk.utils.av.1
            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            /* renamed from: Ig */
            public final String mo24010Ig() {
                C10331c.m26254d("SDKPrivateSafetyDataUtil", "getIMEI:" + C11029av.m24046c(context, true));
                return C11029av.m24046c(context, true);
            }

            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            /* renamed from: Ih */
            public final String mo24009Ih() {
                C10331c.m26254d("SDKPrivateSafetyDataUtil", "getAndroidID:" + C11029av.m24028d(context, true));
                return C11029av.m24028d(context, true);
            }

            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            /* renamed from: Ii */
            public final String mo24008Ii() {
                C10331c.m26254d("SDKPrivateSafetyDataUtil", "getMac:" + C11029av.m24027e(context, true));
                return C11029av.m24027e(context, true);
            }

            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            /* renamed from: Ij */
            public final String mo24007Ij() {
                C10331c.m26254d("SDKPrivateSafetyDataUtil", "getIMEI2:" + C11029av.m24026f(context, true));
                return C11029av.m24026f(context, true);
            }

            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            /* renamed from: Ik */
            public final String mo24006Ik() {
                String m24025g = C11029av.m24025g(context, true);
                C10331c.m26254d("SDKPrivateSafetyDataUtil", "getIMEI2:" + m24025g);
                return m24025g;
            }

            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            /* renamed from: Il */
            public final String mo24005Il() {
                C10331c.m26254d("SDKPrivateSafetyDataUtil", "getIMSI:" + C11029av.m24024h(context, true));
                return C11029av.m24024h(context, true);
            }

            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            /* renamed from: Im */
            public final String mo24004Im() {
                C10331c.m26254d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + C11029av.m24042cD(context));
                return C11029av.m24042cD(context);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.av.bW(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4588)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            /* renamed from: In */
            public final java.lang.String mo24003In() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.C11029av.m24050bW(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getSimCardActivePhoneCount:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.p397e.C10331c.m26254d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.C11029av.C110301.mo24003In():java.lang.String");
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.av.bX(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4588)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            /* renamed from: Io */
            public final java.lang.String mo24002Io() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.C11029av.m24049bX(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getBaseStationInfo:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.p397e.C10331c.m26254d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.C11029av.C110301.mo24002Io():java.lang.String");
            }

            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            /* renamed from: Ip */
            public final String mo24001Ip() {
                String m24040cF = C11029av.m24040cF(context);
                C10331c.m26254d("SDKPrivateSafetyDataUtil", "getWifiList:" + m24040cF);
                return m24040cF;
            }

            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            /* renamed from: Iq */
            public final String mo24000Iq() {
                String m24039cG = C11029av.m24039cG(context);
                C10331c.m26254d("SDKPrivateSafetyDataUtil", "getAppList:" + m24039cG);
                return m24039cG;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.av.ca(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4588)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            /* renamed from: Ir */
            public final java.lang.String mo23999Ir() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.C11029av.m24036ca(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getSdkType:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.p397e.C10331c.m26254d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.C11029av.C110301.mo23999Ir():java.lang.String");
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.av.cc(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4588)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            public final java.lang.String getAppId() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.C11029av.m24034cc(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getAppId:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.p397e.C10331c.m26254d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.C11029av.C110301.getAppId():java.lang.String");
            }

            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            public final String getDeviceId() {
                String m24048bY = C11029av.m24048bY(true);
                C10331c.m26254d("SDKPrivateSafetyDataUtil", "getDeviceId:" + m24048bY);
                return m24048bY;
            }

            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            public final String getIccId() {
                C10331c.m26254d("SDKPrivateSafetyDataUtil", "getIccId:" + C11029av.m24023i(context, true));
                return C11029av.m24023i(context, true);
            }

            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            public final String getIp() {
                String m24047bZ = C11029av.m24047bZ(true);
                C10331c.m26254d("SDKPrivateSafetyDataUtil", "getIp:" + m24047bZ);
                return m24047bZ;
            }

            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            public final String getLocation() {
                String m24038cH = C11029av.m24038cH(context);
                C10331c.m26254d("SDKPrivateSafetyDataUtil", "getLocation:" + m24038cH);
                return m24038cH;
            }

            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            public final String getOaid() {
                C10331c.m26254d("SDKPrivateSafetyDataUtil", "getOaid:" + C11029av.m24051bV(true));
                return C11029av.m24051bV(true);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.sdk.utils.av.cb(boolean):java.lang.String
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.IndexOutOfBoundsException: Index: 0
                	at java.base/java.util.Collections$EmptyList.get(Collections.java:4588)
                	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // com.kwad.sdk.p433f.InterfaceC10757a
            public final java.lang.String getSdkVersion() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.C11029av.m24035cb(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getSdkVersion:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.p397e.C10331c.m26254d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.C11029av.C110301.getSdkVersion():java.lang.String");
            }
        };
    }

    /* renamed from: ca */
    static /* synthetic */ String m24036ca(boolean z) {
        return m24058Mw();
    }

    /* renamed from: cb */
    static /* synthetic */ String m24035cb(boolean z) {
        return m24057Mx();
    }

    /* renamed from: cc */
    static /* synthetic */ String m24034cc(boolean z) {
        return m24056My();
    }

    /* renamed from: cv */
    public static String m24033cv(Context context) {
        return m24046c(context, false);
    }

    /* renamed from: cw */
    public static String m24032cw(Context context) {
        return m24028d(context, false);
    }

    /* renamed from: cx */
    public static String m24031cx(Context context) {
        return m24027e(context, false);
    }

    /* renamed from: cy */
    public static String m24030cy(Context context) {
        return m24026f(context, false);
    }

    /* renamed from: cz */
    public static String m24029cz(Context context) {
        return m24025g(context, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static String m24028d(Context context, boolean z) {
        String m23886cw = C11059bi.m23886cw(context);
        if (!z) {
            return TextUtils.isEmpty(m23886cw) ? "" : m23886cw;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(m23886cw)) {
            return C10758b.m24897a((!C11028au.usePhoneStateDisable() || TextUtils.isEmpty(C11028au.m24071Ml())) ? false : false, m23886cw, 0);
        } else if (!C11028au.usePhoneStateDisable() && C11120o.m23762Li()) {
            return C10758b.m24897a(false, m23886cw, 5);
        } else {
            return C10758b.m24897a(false, m23886cw, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static String m24027e(Context context, boolean z) {
        String m23879dg = C11059bi.m23879dg(context);
        if (!z) {
            return TextUtils.isEmpty(m23879dg) ? "" : m23879dg;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(m23879dg)) {
            return C10758b.m24897a((!C11028au.m24070Mm() || TextUtils.isEmpty(C11028au.m24069Mn())) ? false : false, m23879dg.toLowerCase(), 0);
        } else if (!C11028au.m24070Mm() && C11120o.m23761Lj()) {
            return C10758b.m24897a(false, m23879dg, C11020am.m24099aq(context, C7282g.f24946d) == 0 ? 3 : 1);
        } else {
            return C10758b.m24897a(false, m23879dg, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static String m24026f(Context context, boolean z) {
        String[] m23885da = C11059bi.m23885da(context);
        String str = (m23885da == null || m23885da.length <= 0) ? null : m23885da[0];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(str)) {
            return C10758b.m24897a((!C11028au.usePhoneStateDisable() || TextUtils.isEmpty(C11028au.m24073Mj())) ? false : false, str, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return C10758b.m24897a(false, str, 4);
        } else {
            if (!C11028au.usePhoneStateDisable() && C11120o.m23756Lo()) {
                return C10758b.m24897a(false, str, SystemUtil.m24269cU(context) ? 3 : 1);
            }
            return C10758b.m24897a(false, str, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static String m24025g(Context context, boolean z) {
        String[] m23885da = C11059bi.m23885da(context);
        boolean z2 = true;
        String str = (m23885da == null || m23885da.length <= 1) ? null : m23885da[1];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        } else if (!TextUtils.isEmpty(str)) {
            return C10758b.m24897a((!C11028au.usePhoneStateDisable() || TextUtils.isEmpty(C11028au.m24073Mj())) ? false : false, str, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return C10758b.m24897a(false, str, 4);
        } else {
            if (!C11028au.usePhoneStateDisable() && C11120o.m23756Lo()) {
                return C10758b.m24897a(false, str, SystemUtil.m24269cU(context) ? 3 : 1);
            }
            return C10758b.m24897a(false, str, 1);
        }
    }

    private static String getAppId() {
        return ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).getAppId();
    }

    public static String getDeviceId() {
        return m24054bT(false);
    }

    public static String getOaid() {
        return m24055bS(false);
    }

    private static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static String m24024h(Context context, boolean z) {
        String m23893cA = C11059bi.m23893cA(context);
        if (!z) {
            return TextUtils.isEmpty(m23893cA) ? "" : m23893cA;
        } else if (!TextUtils.isEmpty(m23893cA)) {
            return C10758b.m24897a(C11028au.usePhoneStateDisable(), m23893cA, 0);
        } else {
            if (Build.VERSION.SDK_INT >= 29) {
                return C10758b.m24897a(false, m23893cA, 4);
            }
            if (!C11028au.usePhoneStateDisable() && C11120o.m23755Lp()) {
                return C10758b.m24897a(false, m23893cA, SystemUtil.m24269cU(context) ? 3 : 1);
            }
            return C10758b.m24897a(false, m23893cA, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static String m24023i(Context context, boolean z) {
        String m23882dd = C11059bi.m23882dd(context);
        if (!z) {
            return TextUtils.isEmpty(m23882dd) ? "" : m23882dd;
        } else if (!TextUtils.isEmpty(m23882dd)) {
            return C10758b.m24897a(C11028au.usePhoneStateDisable(), m23882dd, 0);
        } else {
            if (!C11028au.usePhoneStateDisable() && C11120o.m23754Lq()) {
                return C10758b.m24897a(false, m23882dd, SystemUtil.m24269cU(context) ? 3 : 1);
            }
            return C10758b.m24897a(false, m23882dd, 1);
        }
    }

    public static void init(Context context) {
        C10758b.m24898a(m24037cI(context));
    }

    /* renamed from: bV */
    public static C11078a m24052bV(Context context) {
        return C11123r.m23711bV(context);
    }

    /* renamed from: n */
    public static List<C11073bu.C11074a> m24018n(Context context, int i) {
        return C11073bu.m23843n(context, 15);
    }
}
