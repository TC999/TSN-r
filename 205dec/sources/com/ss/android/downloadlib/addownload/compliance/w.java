package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.r.xv;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private SoftReference<Activity> f48516c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private static w f48523c = new w();
    }

    public void w(long j4) {
        com.ss.android.downloadlib.addownload.ux c4 = com.ss.android.downloadlib.r.c().c(com.ss.android.downloadlib.addownload.w.f.c().ux(j4).f48723w.getDownloadUrl());
        if (c4 != null) {
            c4.c(true, true);
            return;
        }
        r.c(11, j4);
        com.ss.android.downloadlib.ux.xv.c().w("startDownload handler null");
    }

    private w() {
    }

    public static w c() {
        return c.f48523c;
    }

    public void c(long j4) {
        TTDelegateActivity.c(j4);
    }

    public boolean c(DownloadModel downloadModel) {
        if (downloadModel.isAd() && k.gd().optInt("ad_lp_show_app_dialog") != 0) {
            String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
            return (TextUtils.isEmpty(webUrl) || Pattern.compile(k.gd().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
        }
        return false;
    }

    public Activity w() {
        Activity activity = this.f48516c.get();
        this.f48516c = null;
        return activity;
    }

    public boolean c(@NonNull com.ss.android.downloadlib.addownload.w.ux uxVar) {
        long j4;
        long j5;
        if (!TextUtils.isEmpty(uxVar.f48723w.getLogExtra())) {
            try {
                j4 = com.ss.android.downloadlib.r.a.c(new JSONObject(uxVar.f48723w.getLogExtra()), "convert_id");
            } catch (Exception e4) {
                e4.printStackTrace();
                j4 = 0;
            }
            if (j4 <= 0) {
                r.c(3, uxVar);
            }
            j5 = j4;
        } else {
            r.c(9, uxVar);
            com.ss.android.downloadlib.ux.xv.c().c("requestAppInfo getLogExtra null");
            j5 = 0;
        }
        final long j6 = uxVar.f48722c;
        com.ss.android.downloadlib.addownload.w.w c4 = xv.c().c(j5, j6);
        if (c4 != null) {
            sr.c().c(c4.c(), j6, c4.sr);
            c(c4.c());
            r.c("lp_app_dialog_try_show", uxVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j5 > 0) {
            sb.append("convert_id=");
            sb.append(j5);
        }
        if (!TextUtils.isEmpty(uxVar.f48723w.getPackageName())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=");
            sb.append(uxVar.f48723w.getPackageName());
        }
        if (sb.length() <= 0) {
            r.c(6, uxVar);
            return false;
        }
        final long j7 = j5;
        com.ss.android.downloadlib.r.xv.c((xv.c<String, R>) new xv.c<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.w.2
            @Override // com.ss.android.downloadlib.r.xv.c
            public Boolean c(String str) {
                final boolean[] zArr = {false};
                k.sr().c("GET", str, new HashMap(), new com.ss.android.download.api.config.s() { // from class: com.ss.android.downloadlib.addownload.compliance.w.2.1
                    @Override // com.ss.android.download.api.config.s
                    public void c(String str2) {
                        boolean[] zArr2 = zArr;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = w.this.c(j7, j6, str2);
                    }

                    @Override // com.ss.android.download.api.config.s
                    public void c(Throwable th) {
                        r.c(2, j6);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).c(new xv.c<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.w.1
            @Override // com.ss.android.downloadlib.r.xv.c
            public Object c(Boolean bool) {
                if (bool.booleanValue()) {
                    w.this.c(com.ss.android.downloadlib.addownload.w.w.c(j7, j6));
                    r.w("lp_app_dialog_try_show", j6);
                    return null;
                }
                w.this.w(j6);
                return null;
            }
        }).c();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(long j4, long j5, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("package");
            if (optJSONObject != null && optJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.w.w wVar = new com.ss.android.downloadlib.addownload.w.w();
                wVar.f48724c = j4;
                wVar.f48727w = j5;
                wVar.sr = optJSONObject.optString(CampaignEx.JSON_KEY_ICON_URL);
                wVar.ux = optJSONObject.optString("app_name");
                wVar.xv = optJSONObject.optString("package_name");
                wVar.f48725f = optJSONObject.optString("version_name");
                wVar.f48726r = optJSONObject.optString("developer_name");
                wVar.gd = optJSONObject.optString("policy_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray(com.bytedance.msdk.api.activity.TTDelegateActivity.INTENT_PERMISSIONS);
                if (optJSONArray != null) {
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        JSONObject jSONObject = (JSONObject) optJSONArray.get(i4);
                        wVar.ev.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                xv.c().c(wVar);
                sr.c().c(wVar.c(), j5, wVar.sr);
                return true;
            }
            r.c(7, j5);
            return false;
        } catch (Exception e4) {
            com.ss.android.downloadlib.ux.xv.c().c(e4, "AdLpComplianceManager parseResponse");
            r.c(7, j5);
            return false;
        }
    }

    public void c(Activity activity) {
        this.f48516c = new SoftReference<>(activity);
    }
}
