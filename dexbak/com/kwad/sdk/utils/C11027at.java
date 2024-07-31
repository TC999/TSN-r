package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;

/* renamed from: com.kwad.sdk.utils.at */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11027at {
    private static String aPE;
    private static String aPF;

    /* renamed from: Md */
    public static boolean m24080Md() {
        return m24077gI("EMUI");
    }

    /* renamed from: Me */
    public static boolean m24079Me() {
        return m24077gI("MIUI");
    }

    /* renamed from: Mf */
    public static boolean m24078Mf() {
        return m24077gI("FLYME");
    }

    /* renamed from: gI */
    private static boolean m24077gI(String str) {
        String str2 = aPE;
        if (str2 != null) {
            return str2.contains(str);
        }
        String str3 = C11054bh.get("ro.build.version.opporom");
        aPF = str3;
        if (!TextUtils.isEmpty(str3)) {
            aPE = "OPPO";
        } else {
            String str4 = C11054bh.get("ro.vivo.os.version");
            aPF = str4;
            if (!TextUtils.isEmpty(str4)) {
                aPE = "VIVO";
            } else {
                String str5 = C11054bh.get("ro.build.version.emui");
                aPF = str5;
                if (!TextUtils.isEmpty(str5)) {
                    aPE = "EMUI";
                } else {
                    String str6 = C11054bh.get("ro.miui.ui.version.name");
                    aPF = str6;
                    if (!TextUtils.isEmpty(str6)) {
                        aPE = "MIUI";
                    } else {
                        String str7 = C11054bh.get("ro.product.system.manufacturer");
                        aPF = str7;
                        if (!TextUtils.isEmpty(str7)) {
                            aPE = "OnePlus";
                        } else {
                            String str8 = C11054bh.get("ro.smartisan.version");
                            aPF = str8;
                            if (!TextUtils.isEmpty(str8)) {
                                aPE = "SMARTISAN";
                            } else if (C11054bh.get("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                aPE = "SAMSUNG";
                            } else {
                                String str9 = Build.DISPLAY;
                                aPF = str9;
                                if (str9.toUpperCase().contains("FLYME")) {
                                    aPE = "FLYME";
                                } else {
                                    aPF = "unknown";
                                    aPE = Build.MANUFACTURER.toUpperCase();
                                }
                            }
                        }
                    }
                }
            }
        }
        return aPE.contains(str);
    }

    public static String getName() {
        if (aPE == null) {
            m24077gI("");
        }
        return aPE;
    }

    public static String getVersion() {
        if (aPF == null) {
            m24077gI("");
        }
        return aPF;
    }
}
