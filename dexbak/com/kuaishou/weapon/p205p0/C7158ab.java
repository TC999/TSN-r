package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import java.io.BufferedReader;
import java.io.FileReader;

/* renamed from: com.kuaishou.weapon.p0.ab */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7158ab {
    /* renamed from: a */
    public static String m34442a() {
        BufferedReader bufferedReader;
        Throwable th;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/status"));
            do {
                try {
                    readLine = bufferedReader.readLine();
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                            return "";
                        } catch (Exception unused2) {
                            return "";
                        }
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } while (!readLine.contains("TracerPid"));
            String replace = readLine.replace("\t", " ");
            try {
                bufferedReader.close();
            } catch (Exception unused4) {
            }
            return replace;
        } catch (Exception unused5) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    /* renamed from: b */
    public static boolean m34440b() {
        try {
            return Boolean.valueOf(Debug.isDebuggerConnected()).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m34439b(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192).flags & 2) == 1) {
                    return true;
                }
            } else if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192).flags & 2) == 1) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m34441a(Context context) {
        return (context.getPackageManager().getApplicationInfo(context.getPackageName(), 8192).flags & 2) == 1;
    }
}
