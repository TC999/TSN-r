package com.bytedance.pangle.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.i;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f28703a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f28704b = 2;

    public static SharedPreferences a(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences("plugin_oat_info", 0);
    }

    public static String b(String str) {
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
    public static String[] a(String str, String str2, int i4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList.add("--runtime-arg");
            arrayList.add("-classpath");
            arrayList.add("--runtime-arg");
            arrayList.add("&");
        }
        arrayList.add("--instruction-set=" + a());
        if (i4 == f28703a) {
            if (i.i()) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
        } else if (i4 == f28704b) {
            arrayList.add("--compiler-filter=speed");
        }
        arrayList.add("--dex-file=".concat(String.valueOf(str)));
        arrayList.add("--oat-file=".concat(String.valueOf(str2)));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String a() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        String substring = str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1);
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

    public static boolean a(String str, String str2) {
        return a.a(a(str, str2, f28703a));
    }

    public static boolean a(String... strArr) {
        for (int i4 = 0; i4 <= 0; i4++) {
            File file = new File(strArr[0]);
            if (!file.exists() || !h.a(file)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String str, String... strArr) {
        for (String str2 : strArr) {
            if (!new File(str + File.separator + a(str2)).exists()) {
                return false;
            }
        }
        return true;
    }
}
