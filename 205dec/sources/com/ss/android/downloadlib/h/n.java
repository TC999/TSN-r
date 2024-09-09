package com.ss.android.downloadlib.h;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.ss.android.download.api.download.DownloadModel;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n {
    @NonNull
    public static com.ss.android.socialbase.downloader.h.ok a(DownloadModel downloadModel) {
        return com.ss.android.socialbase.downloader.h.ok.ok(ok(downloadModel));
    }

    public static int bl(@NonNull DownloadModel downloadModel) {
        return ok(a(downloadModel));
    }

    public static boolean h(int i4) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("clean_app_cache_dir", 0) == 1;
    }

    public static boolean kf(int i4) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("clean_space_switch", 0) == 1;
    }

    public static boolean n(int i4) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("clean_space_before_download_switch", 0L) == 1;
    }

    @Nullable
    public static JSONObject ok() {
        return com.ss.android.downloadlib.addownload.r.q().optJSONObject("ad");
    }

    public static boolean s(int i4) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean a(com.ss.android.downloadad.api.ok.ok okVar) {
        return ok(okVar).ok("pause_reserve_on_wifi", 0) == 1 && okVar.x();
    }

    public static long n() {
        long optLong = com.ss.android.downloadlib.addownload.r.q().optLong("next_install_min_interval");
        return optLong == 0 ? ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT : optLong;
    }

    public static JSONObject ok(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? j.ok(com.ss.android.downloadlib.addownload.r.q(), downloadModel.getDownloadSettings()) : downloadModel.getDownloadSettings();
    }

    public static long s() {
        long optLong = com.ss.android.downloadlib.addownload.r.q().optLong("start_install_interval");
        if (optLong == 0) {
            return 300000L;
        }
        return optLong;
    }

    public static boolean bl(com.ss.android.downloadad.api.ok.ok okVar) {
        return ok(okVar).ok("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && okVar.x();
    }

    public static long a(int i4) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("storage_min_size", 0L);
    }

    public static boolean a(com.ss.android.socialbase.downloader.h.ok okVar) {
        return okVar != null && okVar.ok("kllk_need_rename_apk", 0) == 1;
    }

    public static long bl(int i4) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("clean_fetch_apk_head_time_out", 800L);
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.h.ok ok(com.ss.android.downloadad.api.ok.ok okVar) {
        if (okVar == null) {
            return com.ss.android.socialbase.downloader.h.ok.bl();
        }
        if (okVar.zz() != 0) {
            return com.ss.android.socialbase.downloader.h.ok.ok(okVar.zz());
        }
        if (okVar.bl()) {
            return com.ss.android.socialbase.downloader.h.ok.ok(ok());
        }
        if (okVar.td() != null) {
            return com.ss.android.socialbase.downloader.h.ok.ok(okVar.td());
        }
        return com.ss.android.socialbase.downloader.h.ok.bl();
    }

    public static boolean a() {
        return com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_notification_anr");
    }

    public static boolean bl() {
        return com.ss.android.downloadlib.addownload.r.q().optInt("is_enable_start_install_again") == 1;
    }

    public static int ok(@NonNull com.ss.android.socialbase.downloader.h.ok okVar) {
        return okVar.ok("external_storage_permission_path_type", 0);
    }

    public static double ok(int i4) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i4).ok("clean_min_install_size", 0.0d);
    }
}
