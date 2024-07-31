package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ProcessUtils {

    /* renamed from: a */
    private static String f790a;

    /* renamed from: a */
    public static String m58981a(Context context) {
        String str = f790a;
        if (TextUtils.isEmpty(str)) {
            try {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        String str2 = runningAppProcessInfo.processName;
                        f790a = str2;
                        return str2;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String m58982a = m58982a();
            f790a = m58982a;
            return m58982a;
        }
        return str;
    }

    /* renamed from: b */
    public static boolean m58980b(Context context) {
        String m58981a = m58981a(context);
        return (m58981a == null || !m58981a.contains(":")) && m58981a != null && m58981a.equals(context.getPackageName());
    }

    /* renamed from: c */
    public static boolean m58979c(Context context) {
        String m58981a = m58981a(context);
        return m58981a != null && (m58981a.endsWith(":push") || m58981a.endsWith(":pushservice"));
    }

    /* renamed from: a */
    private static String m58982a() {
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
