package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: CheckSimulator.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f22806a = {"com.mumu.launcher", "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.bluestacks.appmart", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f22807b = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f22808c = {"/data/data/com.android.flysilkworm", "/data/data/com.bluestacks.filemanager"};

    private static List a(Context context) {
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            try {
                String[] strArr = f22806a;
                if (i5 >= strArr.length) {
                    break;
                }
                try {
                    context.getPackageManager().getPackageInfo(strArr[i5], 1);
                    arrayList.add(strArr[i5]);
                } catch (PackageManager.NameNotFoundException unused) {
                }
                i5++;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (arrayList.size() == 0) {
            while (true) {
                String[] strArr2 = f22808c;
                if (i4 >= strArr2.length) {
                    break;
                }
                if (new File(strArr2[i4]).exists()) {
                    arrayList.add(strArr2[i4]);
                }
                i4++;
            }
        }
        return arrayList;
    }

    private static String b(List<String> list) {
        if (list.size() == 0) {
            return "";
        }
        String str = list.get(0);
        if (str.contains("mumu")) {
            return "mumu";
        }
        if (str.contains("ami")) {
            return "AMIDuOS";
        }
        if (str.contains("bluestacks")) {
            return "\u84dd\u53e0";
        }
        if (str.contains("kaopu001") || str.contains("tiantian")) {
            return "\u5929\u5929";
        }
        if (str.contains("kpzs")) {
            return "\u9760\u8c31\u52a9\u624b";
        }
        if (!str.contains("genymotion")) {
            return str.contains("uc") ? "uc" : str.contains("blue") ? "blue" : str.contains("microvirt") ? "\u900d\u9065" : str.contains("itools") ? "itools" : str.contains("syd") ? "\u624b\u6e38\u5c9b" : str.contains("bignox") ? "\u591c\u795e" : str.contains("haimawan") ? "\u6d77\u9a6c\u73a9" : str.contains("windroy") ? "windroy" : str.contains("flysilkworm") ? "\u96f7\u7535" : str.contains("emu") ? "emu" : str.contains("le8") ? "le8" : str.contains("vphone") ? "vphone" : str.contains("duoyi") ? "\u591a\u76ca" : "";
        }
        String str2 = Build.MODEL;
        return str2.contains("iTools") ? "iTools" : str2.contains("ChangWan") ? "\u7545\u73a9" : "genymotion";
    }

    public static List c(Context paramContext) {
        new ArrayList();
        ArrayList arrayList = new ArrayList();
        try {
            String b4 = b(a(paramContext));
            if (TextUtils.isEmpty(b4)) {
                List e4 = e(paramContext);
                if (e4.size() > 0) {
                    arrayList.add(e4.get(0));
                }
            } else {
                arrayList.add(b4);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return arrayList;
    }

    public static boolean d(Context paramContext) {
        try {
            new ArrayList();
            List a4 = a(paramContext);
            if (a4.size() == 0) {
                int i4 = 0;
                while (true) {
                    String[] strArr = f22807b;
                    if (i4 >= strArr.length) {
                        break;
                    }
                    if (i4 == 0) {
                        if (!new File(strArr[i4]).exists()) {
                            a4.add(Integer.valueOf(i4));
                        }
                    } else if (new File(strArr[i4]).exists()) {
                        a4.add(Integer.valueOf(i4));
                    }
                    i4++;
                }
            }
            if (a4.size() == 0) {
                a4 = e(paramContext);
            }
            return (a4.size() == 0 ? null : a4.toString()) != null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static List e(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        for (int i4 = 0; i4 < queryIntentActivities.size(); i4++) {
            ActivityInfo activityInfo = queryIntentActivities.get(i4).activityInfo;
            String str = activityInfo.packageName;
            String str2 = activityInfo.name;
            activityInfo.loadLabel(context.getPackageManager());
            if (!TextUtils.isEmpty(str) && str.contains("bluestacks")) {
                arrayList.add("\u84dd\u53e0");
                return arrayList;
            }
        }
        return arrayList;
    }
}
