package com.bytedance.pangle.p120e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.pangle.util.C6253i;
import com.bytedance.pangle.util.MethodUtils;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;

/* renamed from: com.bytedance.pangle.e.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6096b {

    /* renamed from: a */
    public static int f21942a = 1;

    /* renamed from: b */
    public static int f21943b = 2;

    /* renamed from: a */
    public static SharedPreferences m37198a(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("plugin_oat_info", 0);
    }

    /* renamed from: b */
    public static String m37192b(String str) {
        String substring = str.substring(str.lastIndexOf("."));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        if (".dex".equals(substring)) {
            return substring;
        }
        if (".zip".equals(substring) || ".apk".equals(substring)) {
            return str2;
        }
        return str + str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String[] m37195a(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList.add("--runtime-arg");
            arrayList.add("-classpath");
            arrayList.add("--runtime-arg");
            arrayList.add("&");
        }
        arrayList.add("--instruction-set=" + m37199a());
        if (i == f21942a) {
            if (C6253i.m36879i()) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
        } else if (i == f21943b) {
            arrayList.add("--compiler-filter=speed");
        }
        arrayList.add("--dex-file=".concat(String.valueOf(str)));
        arrayList.add("--oat-file=".concat(String.valueOf(str2)));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: a */
    public static String m37199a() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m37197a(String str) {
        String substring = str.substring(str.lastIndexOf("/") + 1);
        String substring2 = substring.substring(substring.lastIndexOf("."));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        if (".dex".equals(substring2)) {
            return substring;
        }
        if (!".zip".equals(substring2) && !".apk".equals(substring2)) {
            return substring + str2;
        }
        return substring.replace(substring2, str2);
    }

    /* renamed from: a */
    public static boolean m37196a(String str, String str2) {
        return C6094a.m37200a(m37195a(str, str2, f21942a));
    }

    /* renamed from: a */
    public static boolean m37193a(String... strArr) {
        for (int i = 0; i <= 0; i++) {
            File file = new File(strArr[0]);
            if (!file.exists() || !C6108h.m37175a(file)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m37194a(String str, String... strArr) {
        for (String str2 : strArr) {
            if (!new File(str + File.separator + m37197a(str2)).exists()) {
                return false;
            }
        }
        return true;
    }
}
