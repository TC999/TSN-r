package com.beizi.fusion.g;

import android.os.Build;
import android.text.TextUtils;
import com.beizi.ad.internal.utilities.SysProp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OEMSystemInfo.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private c f14784a;

    /* compiled from: OEMSystemInfo.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static ai f14785a = new ai();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OEMSystemInfo.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum b {
        REALME("ColorOS", "ro.build.version.oplusrom"),
        f14787b("ColorOS", "ro.build.version.oplusrom"),
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
        

        /* renamed from: m  reason: collision with root package name */
        private final String f14799m;

        /* renamed from: n  reason: collision with root package name */
        private final String f14800n;

        b(String str, String str2) {
            this.f14799m = str;
            this.f14800n = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OEMSystemInfo.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private final String f14801a;

        /* renamed from: b  reason: collision with root package name */
        private final String f14802b;

        /* renamed from: c  reason: collision with root package name */
        private final String f14803c;

        private c(String str, String str2, String str3) {
            this.f14801a = str;
            this.f14802b = str2;
            this.f14803c = str3;
        }
    }

    public static ai a() {
        return a.f14785a;
    }

    private void c(String str) {
        try {
            if (Integer.valueOf(SysProp.get("ro.miui.ui.version.code", "0")).intValue() >= 816) {
                a(str, b.HYPER);
                return;
            }
        } catch (NumberFormatException unused) {
        }
        a(str, b.MIUI);
    }

    private String d(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll(" ", "").toUpperCase() : "";
    }

    private String e(String str) {
        return SysProp.get(str, "");
    }

    public void b() {
        if (this.f14784a != null) {
            return;
        }
        String d4 = d(Build.BRAND);
        if (TextUtils.isEmpty(d4)) {
            return;
        }
        b bVar = null;
        try {
            bVar = b.valueOf(d4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (bVar != null) {
            a(d4, bVar);
            return;
        }
        d4.hashCode();
        char c4 = '\uffff';
        switch (d4.hashCode()) {
            case -1706170181:
                if (d4.equals("XIAOMI")) {
                    c4 = 0;
                    break;
                }
                break;
            case 68924490:
                if (d4.equals("HONOR")) {
                    c4 = 1;
                    break;
                }
                break;
            case 2141820391:
                if (d4.equals("HUAWEI")) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                c(d4);
                return;
            case 1:
                b(d4);
                return;
            case 2:
                a(d4);
                return;
            default:
                return;
        }
    }

    private ai() {
        if (a.f14785a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    private void a(String str, b bVar) {
        String str2;
        if (TextUtils.isEmpty(bVar.f14799m)) {
            return;
        }
        if (bVar.f14799m.contains(".")) {
            str2 = e(bVar.f14799m);
        } else {
            str2 = bVar.f14799m;
        }
        this.f14784a = new c(str, str2, e(bVar.f14800n));
    }

    private boolean d() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public String c() {
        c cVar = this.f14784a;
        return cVar != null ? cVar.f14803c : "";
    }

    private void a(String str) {
        if (d()) {
            a(str, b.HARMONY);
        } else {
            a(str, b.EMUI);
        }
    }

    private void b(String str) {
        if (d()) {
            a(str, b.HARMONY);
            return;
        }
        b bVar = b.MAGICUI;
        if (!TextUtils.isEmpty(e(bVar.f14800n))) {
            a(str, bVar);
        } else {
            a(str, b.EMUI);
        }
    }
}
