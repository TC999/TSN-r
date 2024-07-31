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

/* renamed from: com.bxkj.student.run.app.utils.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CheckSimulator {

    /* renamed from: a */
    private static final String[] f19576a = {"com.mumu.launcher", "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.bluestacks.appmart", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* renamed from: b */
    private static final String[] f19577b = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    /* renamed from: c */
    private static final String[] f19578c = {"/data/data/com.android.flysilkworm", "/data/data/com.bluestacks.filemanager"};

    /* renamed from: a */
    private static List m39654a(Context context) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                String[] strArr = f19576a;
                if (i2 >= strArr.length) {
                    break;
                }
                try {
                    context.getPackageManager().getPackageInfo(strArr[i2], 1);
                    arrayList.add(strArr[i2]);
                } catch (PackageManager.NameNotFoundException unused) {
                }
                i2++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (arrayList.size() == 0) {
            while (true) {
                String[] strArr2 = f19578c;
                if (i >= strArr2.length) {
                    break;
                }
                if (new File(strArr2[i]).exists()) {
                    arrayList.add(strArr2[i]);
                }
                i++;
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private static String m39653b(List<String> list) {
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
            return "蓝叠";
        }
        if (str.contains("kaopu001") || str.contains("tiantian")) {
            return "天天";
        }
        if (str.contains("kpzs")) {
            return "靠谱助手";
        }
        if (!str.contains("genymotion")) {
            return str.contains("uc") ? "uc" : str.contains("blue") ? "blue" : str.contains("microvirt") ? "逍遥" : str.contains("itools") ? "itools" : str.contains("syd") ? "手游岛" : str.contains("bignox") ? "夜神" : str.contains("haimawan") ? "海马玩" : str.contains("windroy") ? "windroy" : str.contains("flysilkworm") ? "雷电" : str.contains("emu") ? "emu" : str.contains("le8") ? "le8" : str.contains("vphone") ? "vphone" : str.contains("duoyi") ? "多益" : "";
        }
        String str2 = Build.MODEL;
        return str2.contains("iTools") ? "iTools" : str2.contains("ChangWan") ? "畅玩" : "genymotion";
    }

    /* renamed from: c */
    public static List m39652c(Context paramContext) {
        new ArrayList();
        ArrayList arrayList = new ArrayList();
        try {
            String m39653b = m39653b(m39654a(paramContext));
            if (TextUtils.isEmpty(m39653b)) {
                List m39650e = m39650e(paramContext);
                if (m39650e.size() > 0) {
                    arrayList.add(m39650e.get(0));
                }
            } else {
                arrayList.add(m39653b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: d */
    public static boolean m39651d(Context paramContext) {
        try {
            new ArrayList();
            List m39654a = m39654a(paramContext);
            if (m39654a.size() == 0) {
                int i = 0;
                while (true) {
                    String[] strArr = f19577b;
                    if (i >= strArr.length) {
                        break;
                    }
                    if (i == 0) {
                        if (!new File(strArr[i]).exists()) {
                            m39654a.add(Integer.valueOf(i));
                        }
                    } else if (new File(strArr[i]).exists()) {
                        m39654a.add(Integer.valueOf(i));
                    }
                    i++;
                }
            }
            if (m39654a.size() == 0) {
                m39654a = m39650e(paramContext);
            }
            return (m39654a.size() == 0 ? null : m39654a.toString()) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: e */
    public static List m39650e(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            ActivityInfo activityInfo = queryIntentActivities.get(i).activityInfo;
            String str = activityInfo.packageName;
            String str2 = activityInfo.name;
            activityInfo.loadLabel(context.getPackageManager());
            if (!TextUtils.isEmpty(str) && str.contains("bluestacks")) {
                arrayList.add("蓝叠");
                return arrayList;
            }
        }
        return arrayList;
    }
}
