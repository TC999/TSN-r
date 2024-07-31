package com.p521ss.android.downloadlib.p534h;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.mikephil.charting.utils.Utils;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.umeng.analytics.pro.UMCommonContent;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.h.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12201n {
    @NonNull
    /* renamed from: a */
    public static C12534ok m18751a(DownloadModel downloadModel) {
        return C12534ok.m17589ok(m18738ok(downloadModel));
    }

    /* renamed from: bl */
    public static int m18746bl(@NonNull DownloadModel downloadModel) {
        return m18736ok(m18751a(downloadModel));
    }

    /* renamed from: h */
    public static boolean m18744h(int i) {
        return C12534ok.m17599ok(i).m17593ok("clean_app_cache_dir", 0) == 1;
    }

    /* renamed from: kf */
    public static boolean m18743kf(int i) {
        return C12534ok.m17599ok(i).m17593ok("clean_space_switch", 0) == 1;
    }

    /* renamed from: n */
    public static boolean m18741n(int i) {
        return C12534ok.m17599ok(i).m17592ok("clean_space_before_download_switch", 0L) == 1;
    }

    @Nullable
    /* renamed from: ok */
    public static JSONObject m18740ok() {
        return C12128r.m18946q().optJSONObject(UMCommonContent.f37822az);
    }

    /* renamed from: s */
    public static boolean m18734s(int i) {
        return C12534ok.m17599ok(i).m17592ok("clean_fetch_apk_switch", 0L) == 1;
    }

    /* renamed from: a */
    public static boolean m18750a(InterfaceC11999ok interfaceC11999ok) {
        return m18737ok(interfaceC11999ok).m17593ok("pause_reserve_on_wifi", 0) == 1 && interfaceC11999ok.mo19288x();
    }

    /* renamed from: n */
    public static long m18742n() {
        long optLong = C12128r.m18946q().optLong("next_install_min_interval");
        if (optLong == 0) {
            return 10000L;
        }
        return optLong;
    }

    /* renamed from: ok */
    public static JSONObject m18738ok(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? C12197j.m18773ok(C12128r.m18946q(), downloadModel.getDownloadSettings()) : downloadModel.getDownloadSettings();
    }

    /* renamed from: s */
    public static long m18735s() {
        long optLong = C12128r.m18946q().optLong("start_install_interval");
        if (optLong == 0) {
            return 300000L;
        }
        return optLong;
    }

    /* renamed from: bl */
    public static boolean m18745bl(InterfaceC11999ok interfaceC11999ok) {
        return m18737ok(interfaceC11999ok).m17593ok("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && interfaceC11999ok.mo19288x();
    }

    /* renamed from: a */
    public static long m18752a(int i) {
        return C12534ok.m17599ok(i).m17592ok("storage_min_size", 0L);
    }

    /* renamed from: a */
    public static boolean m18749a(C12534ok c12534ok) {
        return c12534ok != null && c12534ok.m17593ok("kllk_need_rename_apk", 0) == 1;
    }

    /* renamed from: bl */
    public static long m18747bl(int i) {
        return C12534ok.m17599ok(i).m17592ok("clean_fetch_apk_head_time_out", 800L);
    }

    @NonNull
    /* renamed from: ok */
    public static C12534ok m18737ok(InterfaceC11999ok interfaceC11999ok) {
        if (interfaceC11999ok == null) {
            return C12534ok.m17605bl();
        }
        if (interfaceC11999ok.mo19285zz() != 0) {
            return C12534ok.m17599ok(interfaceC11999ok.mo19285zz());
        }
        if (interfaceC11999ok.mo19308bl()) {
            return C12534ok.m17589ok(m18740ok());
        }
        if (interfaceC11999ok.mo19291td() != null) {
            return C12534ok.m17589ok(interfaceC11999ok.mo19291td());
        }
        return C12534ok.m17605bl();
    }

    /* renamed from: a */
    public static boolean m18753a() {
        return C12534ok.m17605bl().m17595ok("fix_notification_anr");
    }

    /* renamed from: bl */
    public static boolean m18748bl() {
        return C12128r.m18946q().optInt("is_enable_start_install_again") == 1;
    }

    /* renamed from: ok */
    public static int m18736ok(@NonNull C12534ok c12534ok) {
        return c12534ok.m17593ok("external_storage_permission_path_type", 0);
    }

    /* renamed from: ok */
    public static double m18739ok(int i) {
        return C12534ok.m17599ok(i).m17594ok("clean_min_install_size", Utils.DOUBLE_EPSILON);
    }
}
