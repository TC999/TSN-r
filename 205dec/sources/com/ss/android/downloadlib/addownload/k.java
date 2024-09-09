package com.ss.android.downloadlib.addownload;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.fp;
import com.ss.android.download.api.config.fz;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class k {

    /* renamed from: com.ss.android.downloadlib.addownload.k$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class AnonymousClass1 implements com.ss.android.download.api.config.xv {
        AnonymousClass1() {
        }

        @Override // com.ss.android.download.api.config.xv
        public void c(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
        }

        @Override // com.ss.android.download.api.config.xv
        public void c(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.k$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class AnonymousClass2 implements com.ss.android.socialbase.appdownloader.xv.ev {
        AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.appdownloader.xv.ev
        public void c(DownloadInfo downloadInfo, BaseException baseException, int i4) {
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.k$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class AnonymousClass3 implements fp {
        AnonymousClass3() {
        }

        @Override // com.ss.android.download.api.config.fp
        public void c(String str, int i4, JSONObject jSONObject) {
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.k$4  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class AnonymousClass4 implements com.ss.android.download.api.w.c {
        AnonymousClass4() {
        }

        @Override // com.ss.android.download.api.w.c
        public void c(Throwable th, String str) {
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.k$5  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class AnonymousClass5 implements fz {
        AnonymousClass5() {
        }

        @Override // com.ss.android.download.api.config.fz
        public void c(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i4) {
        }
    }

    public static int ok(int i4, int i5) {
        return (i5 <= 0 || i5 >= 100 || !ok(i4)) ? i5 : (int) (Math.sqrt(i5) * 10.0d);
    }

    public static long ok(int i4, long j4, long j5) {
        if (ok(i4)) {
            if (j4 <= 0) {
                return 0L;
            }
            return j5 <= 0 ? j4 : (j5 * ok(i4, (int) ((j4 * 100) / j5))) / 100;
        }
        return j4;
    }

    public static DownloadShortInfo ok(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null && ok((int) downloadShortInfo.id)) {
            downloadShortInfo.currentBytes = ok((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    private static boolean ok(int i4) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("pause_optimise_pretend_download_percent_switch", 0) == 1 && com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("pause_optimise_switch", 0) == 1;
    }
}
