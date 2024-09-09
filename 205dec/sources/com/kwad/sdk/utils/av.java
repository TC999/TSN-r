package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.bu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class av {
    public static String aPG = "";

    public static com.kwad.sdk.l.a.b Ky() {
        return com.kwad.sdk.l.a.b.Ky();
    }

    public static com.kwad.sdk.l.a.f Kz() {
        return com.kwad.sdk.l.a.f.Kz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Mu() {
        com.kwad.sdk.l.a.f Kz = com.kwad.sdk.l.a.f.Kz();
        int i4 = Kz != null ? Kz.aNe : -1;
        if (i4 >= 0) {
            return com.kwad.sdk.f.b.a(false, String.valueOf(i4), 0);
        }
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yA()) {
            return com.kwad.sdk.f.b.a(false, String.valueOf(i4), 1);
        }
        return com.kwad.sdk.f.b.a(false, String.valueOf(i4), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Mv() {
        com.kwad.sdk.l.a.b Ky = com.kwad.sdk.l.a.b.Ky();
        if (Ky != null) {
            return com.kwad.sdk.f.b.a(false, Ky.toJson(), 0);
        }
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).yC()) {
            return com.kwad.sdk.f.b.a(false, "", 1);
        }
        return com.kwad.sdk.f.b.a(false, "", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Mw() {
        return com.kwad.sdk.f.b.a(false, "1", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Mx() {
        return com.kwad.sdk.f.b.a(false, String.valueOf(getSdkVersion()), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String My() {
        return com.kwad.sdk.f.b.a(false, String.valueOf(getAppId()), 0);
    }

    private static String bS(boolean z3) {
        String cd = bi.cd(z3);
        if (!z3) {
            return TextUtils.isEmpty(cd) ? "" : cd;
        }
        boolean z4 = true;
        if (!TextUtils.isEmpty(cd)) {
            return com.kwad.sdk.f.b.a((!au.Mo() || TextUtils.isEmpty(au.Mp())) ? false : false, cd, 0);
        } else if (!au.Mo() && o.Lk()) {
            return com.kwad.sdk.f.b.a(false, cd, 5);
        } else {
            return com.kwad.sdk.f.b.a(false, cd, 1);
        }
    }

    private static String bT(boolean z3) {
        if (com.kwad.framework.a.a.md.booleanValue() && !TextUtils.isEmpty(bj.getDeviceId())) {
            return bj.getDeviceId();
        }
        String deviceId = bi.getDeviceId();
        if (!z3) {
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        boolean z4 = true;
        if (!TextUtils.isEmpty(deviceId)) {
            return com.kwad.sdk.f.b.a((!au.usePhoneStateDisable() || TextUtils.isEmpty(au.Ml())) ? false : false, deviceId, 0);
        } else if (!au.usePhoneStateDisable() && o.Li()) {
            return com.kwad.sdk.f.b.a(false, deviceId, 5);
        } else {
            return com.kwad.sdk.f.b.a(false, deviceId, 1);
        }
    }

    private static String bU(boolean z3) {
        String Nj = bi.Nj();
        if (!z3) {
            return TextUtils.isEmpty(Nj) ? "" : Nj;
        } else if (!TextUtils.isEmpty(Nj)) {
            return com.kwad.sdk.f.b.a(au.Mq(), Nj, 0);
        } else {
            if (!au.Mq() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(8L)) {
                return com.kwad.sdk.f.b.a(false, Nj, 2);
            }
            return com.kwad.sdk.f.b.a(false, Nj, 1);
        }
    }

    static /* synthetic */ String bV(boolean z3) {
        return bS(true);
    }

    static /* synthetic */ String bW(boolean z3) {
        return Mu();
    }

    static /* synthetic */ String bX(boolean z3) {
        return Mv();
    }

    static /* synthetic */ String bY(boolean z3) {
        return bT(true);
    }

    static /* synthetic */ String bZ(boolean z3) {
        return bU(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Context context, boolean z3) {
        String u3 = bi.u(context, z3);
        if (!z3) {
            return TextUtils.isEmpty(u3) ? "" : u3;
        }
        boolean z4 = true;
        if (!TextUtils.isEmpty(u3)) {
            return com.kwad.sdk.f.b.a((!au.usePhoneStateDisable() || TextUtils.isEmpty(au.Mj())) ? false : false, u3, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.f.b.a(false, u3, 4);
        } else {
            if (!au.usePhoneStateDisable() && o.Lo()) {
                return com.kwad.sdk.f.b.a(false, u3, SystemUtil.cU(context) ? 3 : 1);
            }
            return com.kwad.sdk.f.b.a(false, u3, 1);
        }
    }

    public static String cA(Context context) {
        return h(context, false);
    }

    public static String cB(Context context) {
        return i(context, false);
    }

    public static int cC(Context context) {
        return bi.db(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String cD(Context context) {
        int db = bi.db(context);
        if (db > 0) {
            return com.kwad.sdk.f.b.a(false, String.valueOf(db), 0);
        }
        if (Build.VERSION.SDK_INT < 23) {
            return com.kwad.sdk.f.b.a(false, String.valueOf(db), 1);
        }
        return com.kwad.sdk.f.b.a(false, String.valueOf(db), 3);
    }

    public static int cE(Context context) {
        return bi.dc(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String cF(Context context) {
        List<bu.a> n4 = n(context, 15);
        if (n4 != null && n4.size() > 0) {
            return com.kwad.sdk.f.b.a(au.Mq(), t.O(n4), 0);
        }
        if (!au.Mq() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(32L)) {
            return com.kwad.sdk.f.b.a(false, "", bu.dj(context) ? 1 : 3);
        }
        return com.kwad.sdk.f.b.a(false, "", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String cG(Context context) {
        com.kwad.sdk.core.c.b.DD();
        if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
            return com.kwad.sdk.f.b.a(false, "", 5);
        }
        Map<String, InstalledAppInfoManager.AppPackageInfo> bW = InstalledAppInfoManager.bW(context);
        boolean z3 = true;
        if (bW.size() > 0) {
            return com.kwad.sdk.f.b.a((!au.Ms() || au.Mt() == null) ? false : false, InstalledAppInfoManager.h(bW), 0);
        } else if (!au.Ms() && o.Lm()) {
            return com.kwad.sdk.f.b.a(false, "", bi.di(context) ? 3 : 1);
        } else {
            return com.kwad.sdk.f.b.a(false, "", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String cH(Context context) {
        com.kwad.sdk.utils.c.a bV = r.bV(context);
        boolean z3 = true;
        if (bV != null && bV.aSm != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("latitude", String.valueOf(bV.aSm.getLatitude()));
            hashMap.put("longitude", String.valueOf(bV.aSm.getLongitude()));
            return com.kwad.sdk.f.b.a((!au.Mh() || au.Mi() == null) ? false : false, t.parseMap2JSON(hashMap), 0);
        } else if (!au.Mh() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(64L)) {
            return com.kwad.sdk.f.b.a(false, "", ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 ? 3 : 1);
        } else {
            return com.kwad.sdk.f.b.a(false, "", 1);
        }
    }

    @NonNull
    private static com.kwad.sdk.f.c cI(final Context context) {
        return new com.kwad.sdk.f.c() { // from class: com.kwad.sdk.utils.av.1
            @Override // com.kwad.sdk.f.a
            public final String Ig() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMEI:" + av.c(context, true));
                return av.c(context, true);
            }

            @Override // com.kwad.sdk.f.a
            public final String Ih() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + av.d(context, true));
                return av.d(context, true);
            }

            @Override // com.kwad.sdk.f.a
            public final String Ii() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getMac:" + av.e(context, true));
                return av.e(context, true);
            }

            @Override // com.kwad.sdk.f.a
            public final String Ij() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + av.f(context, true));
                return av.f(context, true);
            }

            @Override // com.kwad.sdk.f.a
            public final String Ik() {
                String g4 = av.g(context, true);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + g4);
                return g4;
            }

            @Override // com.kwad.sdk.f.a
            public final String Il() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMSI:" + av.h(context, true));
                return av.h(context, true);
            }

            @Override // com.kwad.sdk.f.a
            public final String Im() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + av.cD(context));
                return av.cD(context);
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
            @Override // com.kwad.sdk.f.a
            public final java.lang.String In() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.av.bW(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getSimCardActivePhoneCount:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.av.AnonymousClass1.In():java.lang.String");
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
            @Override // com.kwad.sdk.f.a
            public final java.lang.String Io() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.av.bX(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getBaseStationInfo:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.av.AnonymousClass1.Io():java.lang.String");
            }

            @Override // com.kwad.sdk.f.a
            public final String Ip() {
                String cF = av.cF(context);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getWifiList:" + cF);
                return cF;
            }

            @Override // com.kwad.sdk.f.a
            public final String Iq() {
                String cG = av.cG(context);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getAppList:" + cG);
                return cG;
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
            @Override // com.kwad.sdk.f.a
            public final java.lang.String Ir() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.av.ca(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getSdkType:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.av.AnonymousClass1.Ir():java.lang.String");
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
            @Override // com.kwad.sdk.f.a
            public final java.lang.String getAppId() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.av.cc(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getAppId:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.av.AnonymousClass1.getAppId():java.lang.String");
            }

            @Override // com.kwad.sdk.f.a
            public final String getDeviceId() {
                String bY = av.bY(true);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + bY);
                return bY;
            }

            @Override // com.kwad.sdk.f.a
            public final String getIccId() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIccId:" + av.i(context, true));
                return av.i(context, true);
            }

            @Override // com.kwad.sdk.f.a
            public final String getIp() {
                String bZ = av.bZ(true);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIp:" + bZ);
                return bZ;
            }

            @Override // com.kwad.sdk.f.a
            public final String getLocation() {
                String cH = av.cH(context);
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getLocation:" + cH);
                return cH;
            }

            @Override // com.kwad.sdk.f.a
            public final String getOaid() {
                com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getOaid:" + av.bV(true));
                return av.bV(true);
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
            @Override // com.kwad.sdk.f.a
            public final java.lang.String getSdkVersion() {
                /*
                    r3 = this;
                    r0 = 1
                    java.lang.String r0 = com.kwad.sdk.utils.av.cb(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    java.lang.String r2 = "getSdkVersion:"
                    r1.<init>(r2)
                    r1.append(r0)
                    java.lang.String r1 = r1.toString()
                    java.lang.String r2 = "SDKPrivateSafetyDataUtil"
                    com.kwad.sdk.core.e.c.d(r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.av.AnonymousClass1.getSdkVersion():java.lang.String");
            }
        };
    }

    static /* synthetic */ String ca(boolean z3) {
        return Mw();
    }

    static /* synthetic */ String cb(boolean z3) {
        return Mx();
    }

    static /* synthetic */ String cc(boolean z3) {
        return My();
    }

    public static String cv(Context context) {
        return c(context, false);
    }

    public static String cw(Context context) {
        return d(context, false);
    }

    public static String cx(Context context) {
        return e(context, false);
    }

    public static String cy(Context context) {
        return f(context, false);
    }

    public static String cz(Context context) {
        return g(context, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(Context context, boolean z3) {
        String cw = bi.cw(context);
        if (!z3) {
            return TextUtils.isEmpty(cw) ? "" : cw;
        }
        boolean z4 = true;
        if (!TextUtils.isEmpty(cw)) {
            return com.kwad.sdk.f.b.a((!au.usePhoneStateDisable() || TextUtils.isEmpty(au.Ml())) ? false : false, cw, 0);
        } else if (!au.usePhoneStateDisable() && o.Li()) {
            return com.kwad.sdk.f.b.a(false, cw, 5);
        } else {
            return com.kwad.sdk.f.b.a(false, cw, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(Context context, boolean z3) {
        String dg = bi.dg(context);
        if (!z3) {
            return TextUtils.isEmpty(dg) ? "" : dg;
        }
        boolean z4 = true;
        if (!TextUtils.isEmpty(dg)) {
            return com.kwad.sdk.f.b.a((!au.Mm() || TextUtils.isEmpty(au.Mn())) ? false : false, dg.toLowerCase(), 0);
        } else if (!au.Mm() && o.Lj()) {
            return com.kwad.sdk.f.b.a(false, dg, am.aq(context, "android.permission.ACCESS_WIFI_STATE") == 0 ? 3 : 1);
        } else {
            return com.kwad.sdk.f.b.a(false, dg, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(Context context, boolean z3) {
        String[] da = bi.da(context);
        String str = (da == null || da.length <= 0) ? null : da[0];
        if (!z3) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        boolean z4 = true;
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.f.b.a((!au.usePhoneStateDisable() || TextUtils.isEmpty(au.Mj())) ? false : false, str, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.f.b.a(false, str, 4);
        } else {
            if (!au.usePhoneStateDisable() && o.Lo()) {
                return com.kwad.sdk.f.b.a(false, str, SystemUtil.cU(context) ? 3 : 1);
            }
            return com.kwad.sdk.f.b.a(false, str, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(Context context, boolean z3) {
        String[] da = bi.da(context);
        boolean z4 = true;
        String str = (da == null || da.length <= 1) ? null : da[1];
        if (!z3) {
            return TextUtils.isEmpty(str) ? "" : str;
        } else if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.f.b.a((!au.usePhoneStateDisable() || TextUtils.isEmpty(au.Mj())) ? false : false, str, 0);
        } else if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.f.b.a(false, str, 4);
        } else {
            if (!au.usePhoneStateDisable() && o.Lo()) {
                return com.kwad.sdk.f.b.a(false, str, SystemUtil.cU(context) ? 3 : 1);
            }
            return com.kwad.sdk.f.b.a(false, str, 1);
        }
    }

    private static String getAppId() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppId();
    }

    public static String getDeviceId() {
        return bT(false);
    }

    public static String getOaid() {
        return bS(false);
    }

    private static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(Context context, boolean z3) {
        String cA = bi.cA(context);
        if (!z3) {
            return TextUtils.isEmpty(cA) ? "" : cA;
        } else if (!TextUtils.isEmpty(cA)) {
            return com.kwad.sdk.f.b.a(au.usePhoneStateDisable(), cA, 0);
        } else {
            if (Build.VERSION.SDK_INT >= 29) {
                return com.kwad.sdk.f.b.a(false, cA, 4);
            }
            if (!au.usePhoneStateDisable() && o.Lp()) {
                return com.kwad.sdk.f.b.a(false, cA, SystemUtil.cU(context) ? 3 : 1);
            }
            return com.kwad.sdk.f.b.a(false, cA, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(Context context, boolean z3) {
        String dd = bi.dd(context);
        if (!z3) {
            return TextUtils.isEmpty(dd) ? "" : dd;
        } else if (!TextUtils.isEmpty(dd)) {
            return com.kwad.sdk.f.b.a(au.usePhoneStateDisable(), dd, 0);
        } else {
            if (!au.usePhoneStateDisable() && o.Lq()) {
                return com.kwad.sdk.f.b.a(false, dd, SystemUtil.cU(context) ? 3 : 1);
            }
            return com.kwad.sdk.f.b.a(false, dd, 1);
        }
    }

    public static void init(Context context) {
        com.kwad.sdk.f.b.a(cI(context));
    }

    public static com.kwad.sdk.utils.c.a bV(Context context) {
        return r.bV(context);
    }

    public static List<bu.a> n(Context context, int i4) {
        return bu.n(context, 15);
    }
}
