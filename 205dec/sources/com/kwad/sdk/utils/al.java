package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.FileProvider;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class al {

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface a {
        void d(Throwable th);

        void oK();
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    public static PendingIntent a(Context context, int i4, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getBroadcast(context, i4, intent, 201326592);
        }
        return PendingIntent.getBroadcast(context, i4, intent, 134217728);
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    private static PendingIntent b(Context context, int i4, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, i4, intent, 201326592);
        }
        return PendingIntent.getActivity(context, i4, intent, 134217728);
    }

    private static Uri c(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
        }
        return Uri.fromFile(file);
    }

    @Nullable
    public static PendingIntent d(Context context, String str, int i4) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        return b(context, i4, launchIntentForPackage);
    }

    private static Intent h(Intent intent) {
        Intent intent2 = new Intent("intent.action.requestInstallPermission");
        intent2.putExtra("fromNotification", true);
        intent2.putExtra("pendingIntent", intent);
        intent2.addFlags(268435456);
        return intent2;
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public static PendingIntent a(Context context, File file, int i4, boolean z3) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435459);
        Uri c4 = c(context, file);
        intent.setDataAndType(c4, "application/vnd.android.package-archive");
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            context.grantUriPermission(resolveInfo.activityInfo.packageName, c4, 3);
        }
        if (z3) {
            com.kwad.sdk.c.xL();
            if (com.kwad.sdk.c.xO()) {
                intent = h(intent);
            }
        }
        return b(context, i4, intent);
    }
}
