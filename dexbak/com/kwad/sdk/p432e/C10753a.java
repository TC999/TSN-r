package com.kwad.sdk.p432e;

import android.content.Context;
import android.content.Intent;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.proxy.app.DownloadService;
import com.kwad.sdk.core.p397e.C10331c;

/* renamed from: com.kwad.sdk.e.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10753a {
    /* renamed from: C */
    public static void m24905C(Context context, String str) {
        C10331c.m26254d("DownloadClient", "pauseDownload");
        try {
            Intent intent = new Intent(context, DownloadService.class);
            intent.putExtra("download_service_type_tag", 2);
            intent.putExtra("download_service_id_tag", str);
            context.startService(intent);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m24904a(Context context, String str, DownloadTask.DownloadRequest downloadRequest) {
        try {
            Intent intent = new Intent(context, DownloadService.class);
            intent.putExtra("download_service_type_tag", 1);
            intent.putExtra("download_service_id_tag", str);
            intent.putExtra("download_service_args_tag", downloadRequest);
            context.startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public static void m24903e(Context context, String str, String str2) {
        C10331c.m26254d("DownloadClient", "cancelDownload");
        try {
            Intent intent = new Intent(context, DownloadService.class);
            intent.putExtra("download_service_type_tag", 4);
            intent.putExtra("download_service_id_tag", str);
            intent.putExtra("download_service_path", str2);
            context.startService(intent);
        } catch (Exception unused) {
        }
    }
}
