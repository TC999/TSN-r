package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;
import xyz.adscope.common.network.cookie.db.Field;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class aj {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f38000b = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};

    /* renamed from: a  reason: collision with root package name */
    private Context f38001a;

    public aj(Context context) {
        this.f38001a = context;
    }

    public static boolean b() {
        String a4;
        try {
            a4 = bh.a("ro.build.display.id");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(a4)) {
            return false;
        }
        if (a4.contains("flyme")) {
            return true;
        }
        return a4.toLowerCase().contains("flyme");
    }

    public int a() {
        boolean z3;
        try {
            String[] a4 = a(bi.f38090z);
            int length = a4.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    z3 = false;
                    break;
                } else if (new File(a4[i4], "su").exists()) {
                    z3 = true;
                    break;
                } else {
                    i4++;
                }
            }
        } catch (Exception unused) {
        }
        return z3 ? 1 : 0;
    }

    public String c() {
        try {
            if (Build.VERSION.SDK_INT > 29) {
                return null;
            }
            return aa.a().b("su -v").replace("\n", "");
        } catch (Exception unused) {
            return null;
        }
    }

    public int d() {
        String a4 = aa.a().a("ro.secure");
        return (a4 == null || !"0".equals(a4)) ? 1 : 0;
    }

    public int e() {
        String a4 = aa.a().a("ro.debuggable");
        return (a4 == null || !"0".equals(a4)) ? 1 : 0;
    }

    public int f() {
        String a4 = aa.a().a("ro.adb.secure");
        return (a4 == null || !"0".equals(a4)) ? 1 : 0;
    }

    public JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject();
            String a4 = a(" which su ");
            if (!TextUtils.isEmpty(a4) && a4.length() > 2) {
                jSONObject.put("0", 1);
                jSONObject.put("0-p", a4);
            } else {
                jSONObject.put("0", 0);
            }
            String a5 = a(" id ");
            if (!TextUtils.isEmpty(a5)) {
                if (a5.toLowerCase().contains("uid=0")) {
                    jSONObject.put("1", 1);
                } else {
                    jSONObject.put("1", 0);
                }
            }
            String a6 = a(" busybox df ");
            if (!TextUtils.isEmpty(a6) && !a6.contains("not found")) {
                if (a6.length() > 30) {
                    jSONObject.put("2", 1);
                } else {
                    jSONObject.put("2", 0);
                }
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public int h() {
        return new File("/system/app/Superuser.apk").exists() ? 1 : 0;
    }

    public String i() {
        String[] strArr;
        for (String str : f38000b) {
            if (new File(str, "magisk").exists()) {
                return str + "magisk";
            }
        }
        return "";
    }

    public String j() {
        String[] strArr;
        for (String str : f38000b) {
            if (new File(str, "su").exists()) {
                return str + "su";
            }
        }
        return "";
    }

    public String k() {
        StackTraceElement[] stackTrace;
        try {
            throw new Exception("");
        } catch (Exception e4) {
            for (StackTraceElement stackTraceElement : e4.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") || stackTraceElement.getMethodName().equals("invoked") || stackTraceElement.getMethodName().equals("main") || stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    return stackTraceElement.getClassName();
                }
            }
            return "";
        }
    }

    private String[] a(String[] strArr) {
        String str;
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        try {
            str = System.getenv(Field.PATH);
        } catch (Exception unused) {
        }
        if (str != null && !"".equals(str)) {
            String[] split = str.split(":");
            int length = split.length;
            for (int i4 = 0; i4 < length; i4++) {
                String str2 = split[i4];
                if (!str2.endsWith(TTPathConst.sSeparator)) {
                    str2 = str2 + '/';
                }
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String a(String str) {
        try {
            return aa.a().b(str).replace("\n", "");
        } catch (Exception unused) {
            return "";
        }
    }
}
