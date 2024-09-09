package com.kwad.sdk.e;

import android.content.Context;
import android.content.Intent;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.proxy.app.DownloadService;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static void C(Context context, String str) {
        com.kwad.sdk.core.e.c.d("DownloadClient", "pauseDownload");
        try {
            Intent intent = new Intent(context, DownloadService.class);
            intent.putExtra("download_service_type_tag", 2);
            intent.putExtra("download_service_id_tag", str);
            context.startService(intent);
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, String str, DownloadTask.DownloadRequest downloadRequest) {
        try {
            Intent intent = new Intent(context, DownloadService.class);
            intent.putExtra("download_service_type_tag", 1);
            intent.putExtra("download_service_id_tag", str);
            intent.putExtra("download_service_args_tag", downloadRequest);
            context.startService(intent);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void e(Context context, String str, String str2) {
        com.kwad.sdk.core.e.c.d("DownloadClient", "cancelDownload");
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