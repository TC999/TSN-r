package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* compiled from: ProcessUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f783a;

    public static String a(Context context) {
        String str = f783a;
        if (TextUtils.isEmpty(str)) {
            try {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        String str2 = runningAppProcessInfo.processName;
                        f783a = str2;
                        return str2;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            String a4 = a();
            f783a = a4;
            return a4;
        }
        return str;
    }

    public static boolean b(Context context) {
        String a4 = a(context);
        return (a4 == null || !a4.contains(":")) && a4 != null && a4.equals(context.getPackageName());
    }

    public static boolean c(Context context) {
        String a4 = a(context);
        return a4 != null && (a4.endsWith(":push") || a4.endsWith(":pushservice"));
    }

    private static String a() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read <= 0) {
                    break;
                }
                sb.append((char) read);
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            return sb2;
        } catch (Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception unused4) {
                }
            }
            return null;
        }
    }
}
