package com.ss.android.downloadlib.r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.ss.android.download.api.download.DownloadModel;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux {
    @Nullable
    public static JSONObject c() {
        return com.ss.android.downloadlib.addownload.k.gd().optJSONObject("ad");
    }

    public static boolean f(int i4) {
        return com.ss.android.socialbase.downloader.r.c.c(i4).c("clean_space_switch", 0) == 1;
    }

    public static boolean r(int i4) {
        return com.ss.android.socialbase.downloader.r.c.c(i4).c("clean_app_cache_dir", 0) == 1;
    }

    public static boolean sr(int i4) {
        return com.ss.android.socialbase.downloader.r.c.c(i4).c("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean ux(int i4) {
        return com.ss.android.socialbase.downloader.r.c.c(i4).c("clean_space_before_download_switch", 0L) == 1;
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.r.c w(DownloadModel downloadModel) {
        return com.ss.android.socialbase.downloader.r.c.c(c(downloadModel));
    }

    public static int xv(@NonNull DownloadModel downloadModel) {
        return c(w(downloadModel));
    }

    public static JSONObject c(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? a.c(com.ss.android.downloadlib.addownload.k.gd(), downloadModel.getDownloadSettings()) : downloadModel.getDownloadSettings();
    }

    public static long sr() {
        long optLong = com.ss.android.downloadlib.addownload.k.gd().optLong("start_install_interval");
        if (optLong == 0) {
            return 300000L;
        }
        return optLong;
    }

    public static long ux() {
        long optLong = com.ss.android.downloadlib.addownload.k.gd().optLong("next_install_min_interval");
        return optLong == 0 ? ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT : optLong;
    }

    public static boolean w(com.ss.android.downloadad.api.c.c cVar) {
        return c(cVar).c("pause_reserve_on_wifi", 0) == 1 && cVar.ia();
    }

    public static boolean xv(com.ss.android.downloadad.api.c.c cVar) {
        return c(cVar).c("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && cVar.ia();
    }

    public static long w(int i4) {
        return com.ss.android.socialbase.downloader.r.c.c(i4).c("storage_min_size", 0L);
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.r.c c(com.ss.android.downloadad.api.c.c cVar) {
        if (cVar == null) {
            return com.ss.android.socialbase.downloader.r.c.xv();
        }
        if (cVar.fz() != 0) {
            return com.ss.android.socialbase.downloader.r.c.c(cVar.fz());
        }
        if (cVar.xv()) {
            return com.ss.android.socialbase.downloader.r.c.c(c());
        }
        if (cVar.s() != null) {
            return com.ss.android.socialbase.downloader.r.c.c(cVar.s());
        }
        return com.ss.android.socialbase.downloader.r.c.xv();
    }

    public static boolean w(com.ss.android.socialbase.downloader.r.c cVar) {
        return cVar != null && cVar.c("kllk_need_rename_apk", 0) == 1;
    }

    public static long xv(int i4) {
        return com.ss.android.socialbase.downloader.r.c.c(i4).c("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean w() {
        return com.ss.android.socialbase.downloader.r.c.xv().c("fix_notification_anr");
    }

    public static boolean xv() {
        return com.ss.android.downloadlib.addownload.k.gd().optInt("is_enable_start_install_again") == 1;
    }

    public static int c(@NonNull com.ss.android.socialbase.downloader.r.c cVar) {
        return cVar.c("external_storage_permission_path_type", 0);
    }

    public static double c(int i4) {
        return com.ss.android.socialbase.downloader.r.c.c(i4).c("clean_min_install_size", 0.0d);
    }
}
