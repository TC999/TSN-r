package com.p521ss.android.downloadlib.addownload;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.p521ss.android.download.api.config.IDownloadButtonClickListener;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.downloadad.api.download.AdDownloadModel;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12035n;
import com.p521ss.android.downloadlib.p533bl.C12166a;
import com.p521ss.android.downloadlib.p533bl.C12174ok;
import com.p521ss.android.socialbase.appdownloader.C12284a;
import com.p521ss.android.socialbase.appdownloader.C12293bl;
import com.p521ss.android.socialbase.appdownloader.C12312kf;
import com.p521ss.android.socialbase.appdownloader.C12340ok;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12318ok;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.q */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12127q {
    /* renamed from: a */
    public static boolean m18980a(int i) {
        return i == 2 || i == 1;
    }

    /* renamed from: a */
    public static boolean m18979a(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    /* renamed from: ok */
    public static boolean m18978ok(int i) {
        return i == 0 || i == 1;
    }

    /* renamed from: ok */
    public static boolean m18977ok(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    /* renamed from: ok */
    public static boolean m18976ok(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    /* renamed from: ok */
    public static int m18974ok(@NonNull C12035n c12035n, boolean z, C12312kf c12312kf) {
        int i;
        if (c12312kf == null || TextUtils.isEmpty(c12312kf.m18314ok()) || c12312kf.getContext() == null) {
            return 0;
        }
        try {
            i = m18972ok(c12312kf, c12312kf.m18314ok());
        } catch (Throwable th) {
            C12128r.m18940u().mo18637ok(th, "redirectSavePathIfPossible");
            i = 4;
        }
        c12312kf.m18313ok(i);
        if (i == 0) {
            c12312kf.m18307ok(new C12174ok());
        }
        if (!c12312kf.m18342ew()) {
            c12312kf.m18307ok(new C12166a());
        }
        int m18055ok = C12361s.m18068k().m18055ok(c12312kf);
        C11998a m18975ok = m18975ok(c12035n, m18055ok);
        C12032kf.m19324ok().m19318ok(m18975ok);
        m18975ok.m19499h(m18055ok);
        m18975ok.m19468p(System.currentTimeMillis());
        m18975ok.m19464q(0L);
        C12534ok m17589ok = C12534ok.m17589ok(c12312kf.m18279to());
        if (!m18973ok(c12312kf, m17589ok, m18055ok) && c12035n.f34076a.isShowToast()) {
            String startToast = c12035n.f34076a.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = m17589ok.m17603bl("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            C12128r.m18968bl().mo19528ok(2, c12312kf.getContext(), c12035n.f34076a, startToast, null, 0);
        }
        return m18055ok;
    }

    /* renamed from: ok */
    private static C11998a m18975ok(C12035n c12035n, int i) {
        C11998a c11998a = new C11998a(c12035n.f34076a, c12035n.f34077bl, c12035n.f34080s, i);
        boolean z = true;
        if (C12534ok.m17599ok(i).m17593ok("download_event_opt", 1) > 1) {
            try {
                String packageName = c12035n.f34076a.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (C12128r.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    c11998a.m19466p(z);
                }
            } catch (Throwable unused) {
            }
        }
        return c11998a;
    }

    /* renamed from: ok */
    private static boolean m18973ok(C12312kf c12312kf, @NonNull C12534ok c12534ok, int i) {
        String optString;
        JSONArray m17601n = c12534ok.m17601n("ah_plans");
        if (m17601n != null && m17601n.length() != 0) {
            int length = m17601n.length();
            JSONObject jSONObject = null;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    JSONObject optJSONObject = m17601n.optJSONObject(i2);
                    if (optJSONObject != null && ((optString = optJSONObject.optString("type")) == "plan_c" || C12318ok.m18215ok(optJSONObject))) {
                        optString.hashCode();
                        char c = 65535;
                        switch (optString.hashCode()) {
                            case -985763637:
                                if (optString.equals("plan_a")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case -985763636:
                                if (optString.equals("plan_b")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case -985763635:
                                if (optString.equals("plan_c")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case -985763634:
                                if (optString.equals("plan_d")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case -985763633:
                                if (optString.equals("plan_e")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case -985763632:
                                if (optString.equals("plan_f")) {
                                    c = 5;
                                    break;
                                }
                                break;
                            case -985763631:
                                if (optString.equals("plan_g")) {
                                    c = 6;
                                    break;
                                }
                                break;
                            case -985763630:
                                if (optString.equals("plan_h")) {
                                    c = 7;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                            case 1:
                            case 4:
                            case 5:
                                if (C12284a.m18454ok(optJSONObject, c12534ok).f34802a == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                            case 2:
                                jSONObject = optJSONObject;
                                continue;
                            case 6:
                                if (C12284a.m18477a(optJSONObject, c12534ok).f34802a == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                    i2++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("show_unknown_source_on_startup") == 1) {
                    return C12284a.m18466ok(C12490bl.m17807l(), (Intent) null, jSONObject, i, new C12340ok());
                }
            }
        }
        return false;
    }

    /* renamed from: ok */
    public static String m18971ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: ok */
    private static int m18972ok(C12312kf c12312kf, String str) {
        C12534ok m17589ok = C12534ok.m17589ok(c12312kf.m18279to());
        JSONObject m17588s = m17589ok.m17588s("download_dir");
        if (m17588s == null || TextUtils.isEmpty(m17588s.optString("dir_name"))) {
            return -1;
        }
        String m18362a = c12312kf.m18362a();
        String m18296qu = c12312kf.m18296qu();
        if (TextUtils.isEmpty(m18296qu)) {
            m18296qu = C12293bl.m18406ok(str, m18362a, c12312kf.m18331j(), true);
        }
        if (m18296qu.length() > 255) {
            m18296qu = m18296qu.substring(m18296qu.length() - 255);
        }
        if (TextUtils.isEmpty(m18362a)) {
            m18362a = m18296qu;
        }
        String m18356bl = c12312kf.m18356bl();
        if (TextUtils.isEmpty(m18356bl)) {
            m18356bl = C12293bl.m18446a();
        }
        String str2 = m18356bl + File.separator + C12293bl.m18407ok(m18362a, m17589ok);
        DownloadInfo m18061ok = C12361s.m18068k().m18061ok(c12312kf.getContext(), str);
        if (m18061ok != null && m18061ok.isSavePathRedirected()) {
            c12312kf.m18354bl(m18061ok.getSavePath());
            try {
                c12312kf.m18304ok(new JSONObject(m18061ok.getDownloadSettingString()));
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        } else if (m18061ok != null || !"application/vnd.android.package-archive".equalsIgnoreCase(C12361s.m18068k().m18047ok(m18296qu, c12312kf.m18331j()))) {
            return m18061ok != null ? 8 : 9;
        } else {
            int m18457ok = C12284a.m18457ok(m17589ok);
            if (m18457ok == 0) {
                c12312kf.m18354bl(str2);
                return m18457ok;
            }
            return m18457ok;
        }
    }
}
