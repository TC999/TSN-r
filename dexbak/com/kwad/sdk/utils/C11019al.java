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
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.kwad.sdk.C9774c;
import com.kwad.sdk.api.core.fragment.FileProvider;
import java.io.File;

/* renamed from: com.kwad.sdk.utils.al */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11019al {
    @SuppressLint({"UnspecifiedImmutableFlag"})
    /* renamed from: a */
    public static PendingIntent m24105a(Context context, int i, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getBroadcast(context, i, intent, 201326592);
        }
        return PendingIntent.getBroadcast(context, i, intent, AMapEngineUtils.HALF_MAX_P20_WIDTH);
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    /* renamed from: b */
    private static PendingIntent m24103b(Context context, int i, @NonNull Intent intent) {
        if (Build.VERSION.SDK_INT >= 31) {
            return PendingIntent.getActivity(context, i, intent, 201326592);
        }
        return PendingIntent.getActivity(context, i, intent, AMapEngineUtils.HALF_MAX_P20_WIDTH);
    }

    /* renamed from: c */
    private static Uri m24102c(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
        }
        return Uri.fromFile(file);
    }

    @Nullable
    /* renamed from: d */
    public static PendingIntent m24101d(Context context, String str, int i) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        return m24103b(context, i, launchIntentForPackage);
    }

    /* renamed from: h */
    private static Intent m24100h(Intent intent) {
        Intent intent2 = new Intent("intent.action.requestInstallPermission");
        intent2.putExtra("fromNotification", true);
        intent2.putExtra("pendingIntent", intent);
        intent2.addFlags(268435456);
        return intent2;
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    /* renamed from: a */
    public static PendingIntent m24104a(Context context, File file, int i, boolean z) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435459);
        Uri m24102c = m24102c(context, file);
        intent.setDataAndType(m24102c, "application/vnd.android.package-archive");
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            context.grantUriPermission(resolveInfo.activityInfo.packageName, m24102c, 3);
        }
        if (z) {
            C9774c.m27790xL();
            if (C9774c.m27787xO()) {
                intent = m24100h(intent);
            }
        }
        return m24103b(context, i, intent);
    }
}
