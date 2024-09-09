package com.qq.e.comm.plugin.apkmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.qq.e.comm.plugin.util.q1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(Context context, ApkDownloadTask apkDownloadTask) {
        return a(context).putExtra("gdt_apkdownload_task", apkDownloadTask.z()).putExtra("download", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent b(Context context) {
        return a(context).putExtra("recover", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent c(Context context) {
        return a(context).putExtra("repair", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Intent intent) {
        return intent.getBooleanExtra("trigger_by_notify_bar", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(Intent intent) {
        return intent.getBooleanExtra("recover", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(Intent intent) {
        return intent.getBooleanExtra("repair", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, q1.b());
        intent.putExtra("process_name", com.qq.e.comm.plugin.d0.a.d().b().e());
        intent.putExtra("GDT_APPID", com.qq.e.comm.plugin.d0.a.d().b().a());
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle b(Intent intent) {
        return intent.getBundleExtra("gdt_apkdownload_task");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Intent intent) {
        return intent.getBooleanExtra("download", false);
    }

    public static void a(Intent intent, boolean z3) {
        intent.putExtra("trigger_by_notify_bar", z3);
    }

    public static String a(Intent intent) {
        return intent.getStringExtra("process_name");
    }
}
