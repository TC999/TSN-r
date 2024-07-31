package com.kwad.sdk.utils;

import android.location.Location;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.utils.au */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11028au {
    /* renamed from: Mg */
    private static boolean m24076Mg() {
        if (C9425a.f29473md.booleanValue()) {
            C9861c.m27501f(DevelopMangerComponents.class);
            return false;
        }
        return false;
    }

    /* renamed from: Mh */
    public static boolean m24075Mh() {
        KsCustomController ksCustomController;
        if (m24076Mg()) {
            return true;
        }
        try {
            SdkConfig m24362KP = ServiceProvider.m24362KP();
            if (m24362KP != null && (ksCustomController = m24362KP.ksCustomController) != null) {
                if (!ksCustomController.canReadLocation()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: Mi */
    public static Location m24074Mi() {
        KsCustomController ksCustomController;
        try {
            SdkConfig m24362KP = ServiceProvider.m24362KP();
            if (m24362KP == null || (ksCustomController = m24362KP.ksCustomController) == null) {
                return null;
            }
            return ksCustomController.getLocation();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: Mj */
    public static String m24073Mj() {
        KsCustomController ksCustomController;
        try {
            SdkConfig m24362KP = ServiceProvider.m24362KP();
            return (m24362KP == null || (ksCustomController = m24362KP.ksCustomController) == null) ? "" : ksCustomController.getImei();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: Mk */
    public static String[] m24072Mk() {
        KsCustomController ksCustomController;
        try {
            SdkConfig m24362KP = ServiceProvider.m24362KP();
            if (m24362KP != null && (ksCustomController = m24362KP.ksCustomController) != null) {
                return ksCustomController.getImeis();
            }
        } catch (Throwable unused) {
        }
        return new String[]{"", ""};
    }

    /* renamed from: Ml */
    public static String m24071Ml() {
        KsCustomController ksCustomController;
        try {
            SdkConfig m24362KP = ServiceProvider.m24362KP();
            return (m24362KP == null || (ksCustomController = m24362KP.ksCustomController) == null) ? "" : ksCustomController.getAndroidId();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: Mm */
    public static boolean m24070Mm() {
        KsCustomController ksCustomController;
        if (m24076Mg()) {
            return true;
        }
        try {
            SdkConfig m24362KP = ServiceProvider.m24362KP();
            if (m24362KP != null && (ksCustomController = m24362KP.ksCustomController) != null) {
                if (!ksCustomController.canUseMacAddress()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: Mn */
    public static String m24069Mn() {
        KsCustomController ksCustomController;
        try {
            SdkConfig m24362KP = ServiceProvider.m24362KP();
            return (m24362KP == null || (ksCustomController = m24362KP.ksCustomController) == null) ? "" : ksCustomController.getMacAddress();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: Mo */
    public static boolean m24068Mo() {
        KsCustomController ksCustomController;
        if (m24076Mg()) {
            return true;
        }
        try {
            SdkConfig m24362KP = ServiceProvider.m24362KP();
            if (m24362KP != null && (ksCustomController = m24362KP.ksCustomController) != null) {
                if (!ksCustomController.canUseOaid()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: Mp */
    public static String m24067Mp() {
        KsCustomController ksCustomController;
        try {
            SdkConfig m24362KP = ServiceProvider.m24362KP();
            return (m24362KP == null || (ksCustomController = m24362KP.ksCustomController) == null) ? "" : ksCustomController.getOaid();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: Mq */
    public static boolean m24066Mq() {
        KsCustomController ksCustomController;
        if (m24076Mg()) {
            return true;
        }
        try {
            SdkConfig m24362KP = ServiceProvider.m24362KP();
            if (m24362KP != null && (ksCustomController = m24362KP.ksCustomController) != null) {
                if (!ksCustomController.canUseNetworkState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: Mr */
    public static boolean m24065Mr() {
        KsCustomController ksCustomController;
        if (m24076Mg()) {
            return true;
        }
        try {
            SdkConfig m24362KP = ServiceProvider.m24362KP();
            if (m24362KP != null && (ksCustomController = m24362KP.ksCustomController) != null) {
                if (!ksCustomController.canUseStoragePermission()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: Ms */
    public static boolean m24064Ms() {
        KsCustomController ksCustomController;
        if (m24076Mg()) {
            return true;
        }
        try {
            SdkConfig m24362KP = ServiceProvider.m24362KP();
            if (m24362KP != null && (ksCustomController = m24362KP.ksCustomController) != null) {
                if (!ksCustomController.canReadInstalledPackages()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: Mt */
    public static List<String> m24063Mt() {
        KsCustomController ksCustomController;
        try {
            SdkConfig m24362KP = ServiceProvider.m24362KP();
            if (m24362KP != null && (ksCustomController = m24362KP.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }

    public static boolean usePhoneStateDisable() {
        KsCustomController ksCustomController;
        if (m24076Mg()) {
            return true;
        }
        try {
            SdkConfig m24362KP = ServiceProvider.m24362KP();
            if (m24362KP != null && (ksCustomController = m24362KP.ksCustomController) != null) {
                if (!ksCustomController.canUsePhoneState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
