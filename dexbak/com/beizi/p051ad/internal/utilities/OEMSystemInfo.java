package com.beizi.p051ad.internal.utilities;

import android.os.Build;
import android.text.TextUtils;

/* renamed from: com.beizi.ad.internal.utilities.OEMSystemInfo */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class OEMSystemInfo {
    private OEMInfo mInfo;

    /* renamed from: com.beizi.ad.internal.utilities.OEMSystemInfo$InstanceHolder */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class InstanceHolder {
        private static OEMSystemInfo instance = new OEMSystemInfo();

        private InstanceHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.beizi.ad.internal.utilities.OEMSystemInfo$OEM */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum OEM {
        REALME("ColorOS", "ro.build.version.oplusrom"),
        OPPO("ColorOS", "ro.build.version.oplusrom"),
        MIUI("MIUI", "ro.miui.ui.version.name"),
        HYPER("HyperOS", "ro.mi.os.version.incremental"),
        REDMI("MIUI", "ro.miui.ui.version.name"),
        HARMONY("HarmonyOS", "hw_sc.build.platform.version"),
        MAGICUI("MagicUI", "ro.build.version.magic"),
        EMUI("EMUI", "ro.build.version.emui"),
        MEIZU("Flyme", "ro.build.display.id"),
        ONEPLUS("HydrogenOS", "ro.rom.version"),
        VIVO("Funtouch", "ro.vivo.os.version"),
        NUBIA("ro.build.nubia.rom.name", "ro.build.nubia.rom.code");
        
        private final String ROM;
        private final String propVersion;

        OEM(String str, String str2) {
            this.ROM = str;
            this.propVersion = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.beizi.ad.internal.utilities.OEMSystemInfo$OEMInfo */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class OEMInfo {
        private final String OEM;
        private final String ROM;
        private final String VER;

        private OEMInfo(String str, String str2, String str3) {
            this.OEM = str;
            this.ROM = str2;
            this.VER = str3;
        }
    }

    public static OEMSystemInfo getInstance() {
        return InstanceHolder.instance;
    }

    private String getSystemPropValue(String str) {
        return SysProp.get(str, "");
    }

    private void initByOEM(String str, OEM oem) {
        String str2;
        if (TextUtils.isEmpty(oem.ROM)) {
            return;
        }
        if (oem.ROM.contains(".")) {
            str2 = getSystemPropValue(oem.ROM);
        } else {
            str2 = oem.ROM;
        }
        this.mInfo = new OEMInfo(str, str2, getSystemPropValue(oem.propVersion));
    }

    private void initHonorSeries(String str) {
        if (isHarmonyOS()) {
            initByOEM(str, OEM.HARMONY);
            return;
        }
        OEM oem = OEM.MAGICUI;
        if (!TextUtils.isEmpty(getSystemPropValue(oem.propVersion))) {
            initByOEM(str, oem);
        } else {
            initByOEM(str, OEM.EMUI);
        }
    }

    private void initHuaweiSeries(String str) {
        if (isHarmonyOS()) {
            initByOEM(str, OEM.HARMONY);
        } else {
            initByOEM(str, OEM.EMUI);
        }
    }

    private void initXiaoMiSeries(String str) {
        try {
            if (Integer.valueOf(SysProp.get("ro.miui.ui.version.code", "0")).intValue() >= 816) {
                initByOEM(str, OEM.HYPER);
                return;
            }
        } catch (NumberFormatException unused) {
        }
        initByOEM(str, OEM.MIUI);
    }

    private boolean isHarmonyOS() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String shrinkBoard(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll(" ", "").toUpperCase() : "";
    }

    public String getROM() {
        OEMInfo oEMInfo = this.mInfo;
        return oEMInfo != null ? oEMInfo.ROM : "";
    }

    public String getRomVersion() {
        OEMInfo oEMInfo = this.mInfo;
        return oEMInfo != null ? oEMInfo.VER : "";
    }

    public void initializeOEMInfo() {
        if (this.mInfo != null) {
            return;
        }
        String shrinkBoard = shrinkBoard(Build.BRAND);
        if (TextUtils.isEmpty(shrinkBoard)) {
            return;
        }
        OEM oem = null;
        try {
            oem = OEM.valueOf(shrinkBoard);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (oem != null) {
            initByOEM(shrinkBoard, oem);
            return;
        }
        shrinkBoard.hashCode();
        char c = 65535;
        switch (shrinkBoard.hashCode()) {
            case -1706170181:
                if (shrinkBoard.equals("XIAOMI")) {
                    c = 0;
                    break;
                }
                break;
            case 68924490:
                if (shrinkBoard.equals("HONOR")) {
                    c = 1;
                    break;
                }
                break;
            case 2141820391:
                if (shrinkBoard.equals("HUAWEI")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                initXiaoMiSeries(shrinkBoard);
                return;
            case 1:
                initHonorSeries(shrinkBoard);
                return;
            case 2:
                initHuaweiSeries(shrinkBoard);
                return;
            default:
                return;
        }
    }

    private OEMSystemInfo() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }
}
