package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;

/* compiled from: PermissionActivityCompat.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c {
    public static void a(@NonNull Activity activity, @NonNull String[] strArr, int i4) {
        if (Build.VERSION.SDK_INT >= 23) {
            activity.requestPermissions(strArr, i4);
        }
    }

    public static int a(@NonNull Context context, @NonNull String str) {
        if (str != null) {
            try {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            } catch (Throwable th) {
                th.printStackTrace();
                return Build.VERSION.SDK_INT >= 23 ? -1 : 0;
            }
        }
        throw new IllegalArgumentException("permission is null");
    }
}
