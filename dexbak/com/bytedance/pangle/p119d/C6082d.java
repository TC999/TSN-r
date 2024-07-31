package com.bytedance.pangle.p119d;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.bytedance.pangle.d.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6082d {

    /* renamed from: a */
    private static String f21920a;

    /* renamed from: b */
    private static List<String> f21921b = new CopyOnWriteArrayList();

    /* renamed from: a */
    public static String m37218a() {
        if (!TextUtils.isEmpty(f21920a)) {
            return f21920a;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String processName = Application.getProcessName();
                if (!TextUtils.isEmpty(processName)) {
                    f21920a = processName;
                }
                return f21920a;
            }
        } catch (Throwable unused) {
        }
        try {
            Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.app.ActivityThread"), "currentProcessName", new Object[0]);
            if (!TextUtils.isEmpty((String) invokeStaticMethod)) {
                f21920a = (String) invokeStaticMethod;
            }
            return f21920a;
        } catch (Exception e) {
            e.printStackTrace();
            String m37215b = m37215b();
            f21920a = m37215b;
            return m37215b;
        }
    }

    /* renamed from: b */
    private static String m37215b() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                if (ZeusLogger.isDebug()) {
                    ZeusLogger.m37083d("Process", "get processName = " + sb.toString());
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return sb2;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    /* renamed from: a */
    public static boolean m37217a(Context context) {
        String m37218a = m37218a();
        return (m37218a == null || !m37218a.contains(":")) && m37218a != null && m37218a.equals(context.getPackageName());
    }

    /* renamed from: a */
    public static String m37216a(String str) {
        return (TextUtils.isEmpty(str) || !str.contains(":")) ? "main" : str.split(":")[1];
    }
}
