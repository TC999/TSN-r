package com.bytedance.sdk.openadsdk.core.p;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.bytedance.sdk.openadsdk.core.eq.r;
import com.bytedance.sdk.openadsdk.core.fz.a;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {
    public static void c(Activity activity, final String[] strArr, final ITTPermissionCallback iTTPermissionCallback) {
        boolean z3;
        com.bytedance.sdk.openadsdk.ys.w.xv.sr f4;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    z3 = false;
                    break;
                } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i4])) {
                    z3 = true;
                    break;
                } else {
                    i4++;
                }
            }
            if (z3 && (f4 = k.sr().f()) != null && iTTPermissionCallback != null && !f4.ux()) {
                iTTPermissionCallback.onDenied("android.permission.WRITE_EXTERNAL_STORAGE");
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && com.bytedance.sdk.openadsdk.core.r.c.xv(activity) < 23) {
            if (iTTPermissionCallback != null) {
                iTTPermissionCallback.onGranted();
            }
        } else if (strArr == null || strArr.length <= 0) {
            if (iTTPermissionCallback != null) {
                iTTPermissionCallback.onGranted();
            }
        } else {
            long hashCode = activity.hashCode();
            for (String str : strArr) {
                hashCode += str.hashCode();
            }
            com.bytedance.sdk.openadsdk.core.eq.r.c(String.valueOf(hashCode), strArr, new r.c() { // from class: com.bytedance.sdk.openadsdk.core.p.r.1
                @Override // com.bytedance.sdk.openadsdk.core.eq.r.c
                public void c() {
                    ITTPermissionCallback iTTPermissionCallback2 = ITTPermissionCallback.this;
                    if (iTTPermissionCallback2 != null) {
                        iTTPermissionCallback2.onGranted();
                    }
                    a.c().c(true, strArr);
                }

                @Override // com.bytedance.sdk.openadsdk.core.eq.r.c
                public void c(String str2) {
                    ITTPermissionCallback iTTPermissionCallback2 = ITTPermissionCallback.this;
                    if (iTTPermissionCallback2 != null) {
                        iTTPermissionCallback2.onDenied(str2);
                    }
                    a.c().c(false, new String[]{str2});
                }
            });
        }
    }

    public static boolean c(Context context, String str) {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux;
        if (!"android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(str) || (ux = k.sr().ux()) == null || ux.ux()) {
            if (context == null) {
                context = ls.getContext();
            }
            return com.bytedance.sdk.openadsdk.core.j.ux.c().c(context, str);
        }
        return false;
    }
}
