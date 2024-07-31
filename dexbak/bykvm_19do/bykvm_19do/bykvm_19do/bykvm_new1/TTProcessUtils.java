package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.x */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTProcessUtils {
    /* renamed from: a */
    private static String m59092a(Context context) {
        int myPid = Process.myPid();
        String str = "";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                str = runningAppProcessInfo.processName;
            }
        }
        return str;
    }

    /* renamed from: b */
    public static boolean m59091b(Context context) {
        String packageName;
        try {
            packageName = context.getPackageName();
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        return packageName.equalsIgnoreCase(m59092a(context));
    }
}
