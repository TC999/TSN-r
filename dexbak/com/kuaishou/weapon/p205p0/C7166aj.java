package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.aj */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7166aj {

    /* renamed from: b */
    private static final String[] f24481b = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};

    /* renamed from: a */
    private Context f24482a;

    public C7166aj(Context context) {
        this.f24482a = context;
    }

    /* renamed from: b */
    public static boolean m34409b() {
        String m34262a;
        try {
            m34262a = C7191bh.m34262a("ro.build.display.id");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(m34262a)) {
            return false;
        }
        if (m34262a.contains("flyme")) {
            return true;
        }
        return m34262a.toLowerCase().contains("flyme");
    }

    /* renamed from: a */
    public int m34412a() {
        boolean z;
        try {
            String[] m34410a = m34410a(C7193bi.f24591z);
            int length = m34410a.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (new File(m34410a[i], "su").exists()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        } catch (Exception unused) {
        }
        return z ? 1 : 0;
    }

    /* renamed from: c */
    public String m34408c() {
        try {
            if (Build.VERSION.SDK_INT > 29) {
                return null;
            }
            return C7157aa.m34446a().m34443b("su -v").replace(ShellAdbUtils.f33810d, "");
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public int m34407d() {
        String m34444a = C7157aa.m34446a().m34444a("ro.secure");
        return (m34444a == null || !"0".equals(m34444a)) ? 1 : 0;
    }

    /* renamed from: e */
    public int m34406e() {
        String m34444a = C7157aa.m34446a().m34444a("ro.debuggable");
        return (m34444a == null || !"0".equals(m34444a)) ? 1 : 0;
    }

    /* renamed from: f */
    public int m34405f() {
        String m34444a = C7157aa.m34446a().m34444a("ro.adb.secure");
        return (m34444a == null || !"0".equals(m34444a)) ? 1 : 0;
    }

    /* renamed from: g */
    public JSONObject m34404g() {
        try {
            JSONObject jSONObject = new JSONObject();
            String m34411a = m34411a(" which su ");
            if (!TextUtils.isEmpty(m34411a) && m34411a.length() > 2) {
                jSONObject.put("0", 1);
                jSONObject.put("0-p", m34411a);
            } else {
                jSONObject.put("0", 0);
            }
            String m34411a2 = m34411a(" id ");
            if (!TextUtils.isEmpty(m34411a2)) {
                if (m34411a2.toLowerCase().contains("uid=0")) {
                    jSONObject.put("1", 1);
                } else {
                    jSONObject.put("1", 0);
                }
            }
            String m34411a3 = m34411a(" busybox df ");
            if (!TextUtils.isEmpty(m34411a3) && !m34411a3.contains("not found")) {
                if (m34411a3.length() > 30) {
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

    /* renamed from: h */
    public int m34403h() {
        return new File("/system/app/Superuser.apk").exists() ? 1 : 0;
    }

    /* renamed from: i */
    public String m34402i() {
        String[] strArr;
        for (String str : f24481b) {
            if (new File(str, "magisk").exists()) {
                return str + "magisk";
            }
        }
        return "";
    }

    /* renamed from: j */
    public String m34401j() {
        String[] strArr;
        for (String str : f24481b) {
            if (new File(str, "su").exists()) {
                return str + "su";
            }
        }
        return "";
    }

    /* renamed from: k */
    public String m34400k() {
        StackTraceElement[] stackTrace;
        try {
            throw new Exception("");
        } catch (Exception e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") || stackTraceElement.getMethodName().equals("invoked") || stackTraceElement.getMethodName().equals("main") || stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    return stackTraceElement.getClassName();
                }
            }
            return "";
        }
    }

    /* renamed from: a */
    private String[] m34410a(String[] strArr) {
        String str;
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        try {
            str = System.getenv("PATH");
        } catch (Exception unused) {
        }
        if (str != null && !"".equals(str)) {
            String[] split = str.split(":");
            int length = split.length;
            for (int i = 0; i < length; i++) {
                String str2 = split[i];
                if (!str2.endsWith("/")) {
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

    /* renamed from: a */
    public String m34411a(String str) {
        try {
            return C7157aa.m34446a().m34443b(str).replace(ShellAdbUtils.f33810d, "");
        } catch (Exception unused) {
            return "";
        }
    }
}
