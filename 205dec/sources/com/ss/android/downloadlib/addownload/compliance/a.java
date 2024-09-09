package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.ss.android.download.api.config.td;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.h.bl;
import com.ss.android.downloadlib.h.j;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    private SoftReference<Activity> ok;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {
        private static a ok = new a();
    }

    public void a(long j4) {
        com.ss.android.downloadlib.addownload.n ok2 = com.ss.android.downloadlib.h.ok().ok(com.ss.android.downloadlib.addownload.a.kf.ok().n(j4).f48371a.getDownloadUrl());
        if (ok2 != null) {
            ok2.ok(true, true);
            return;
        }
        h.ok(11, j4);
        com.ss.android.downloadlib.n.bl.ok().a("startDownload handler null");
    }

    private a() {
    }

    public static a ok() {
        return ok.ok;
    }

    public void ok(long j4) {
        TTDelegateActivity.ok(j4);
    }

    public boolean ok(DownloadModel downloadModel) {
        if (downloadModel.isAd() && com.ss.android.downloadlib.addownload.r.q().optInt("ad_lp_show_app_dialog") != 0) {
            String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
            return (TextUtils.isEmpty(webUrl) || Pattern.compile(com.ss.android.downloadlib.addownload.r.q().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
        }
        return false;
    }

    public Activity a() {
        Activity activity = this.ok.get();
        this.ok = null;
        return activity;
    }

    public boolean ok(@NonNull com.ss.android.downloadlib.addownload.a.n nVar) {
        long j4;
        long j5;
        if (!TextUtils.isEmpty(nVar.f48371a.getLogExtra())) {
            try {
                j4 = j.ok(new JSONObject(nVar.f48371a.getLogExtra()), "convert_id");
            } catch (Exception e4) {
                e4.printStackTrace();
                j4 = 0;
            }
            if (j4 <= 0) {
                h.ok(3, nVar);
            }
            j5 = j4;
        } else {
            h.ok(9, nVar);
            com.ss.android.downloadlib.n.bl.ok().ok("requestAppInfo getLogExtra null");
            j5 = 0;
        }
        final long j6 = nVar.ok;
        com.ss.android.downloadlib.addownload.a.a ok2 = bl.ok().ok(j5, j6);
        if (ok2 != null) {
            s.ok().ok(ok2.ok(), j6, ok2.f48360s);
            ok(ok2.ok());
            h.ok("lp_app_dialog_try_show", nVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j5 > 0) {
            sb.append("convert_id=");
            sb.append(j5);
        }
        if (!TextUtils.isEmpty(nVar.f48371a.getPackageName())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=");
            sb.append(nVar.f48371a.getPackageName());
        }
        if (sb.length() <= 0) {
            h.ok(6, nVar);
            return false;
        }
        final long j7 = j5;
        com.ss.android.downloadlib.h.bl.ok((bl.ok<String, R>) new bl.ok<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.a.2
            @Override // com.ss.android.downloadlib.h.bl.ok
            public Boolean ok(String str) {
                final boolean[] zArr = {false};
                com.ss.android.downloadlib.addownload.r.s().ok("GET", str, new HashMap(), new td() { // from class: com.ss.android.downloadlib.addownload.compliance.a.2.1
                    @Override // com.ss.android.download.api.config.td
                    public void ok(String str2) {
                        boolean[] zArr2 = zArr;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = a.this.ok(j7, j6, str2);
                    }

                    @Override // com.ss.android.download.api.config.td
                    public void ok(Throwable th) {
                        h.ok(2, j6);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).ok(new bl.ok<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.a.1
            @Override // com.ss.android.downloadlib.h.bl.ok
            public Object ok(Boolean bool) {
                if (bool.booleanValue()) {
                    a.this.ok(com.ss.android.downloadlib.addownload.a.a.ok(j7, j6));
                    h.a("lp_app_dialog_try_show", j6);
                    return null;
                }
                a.this.a(j6);
                return null;
            }
        }).ok();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ok(long j4, long j5, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("package");
            if (optJSONObject != null && optJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.a.a aVar = new com.ss.android.downloadlib.addownload.a.a();
                aVar.ok = j4;
                aVar.f48355a = j5;
                aVar.f48360s = optJSONObject.optString(CampaignEx.JSON_KEY_ICON_URL);
                aVar.f48357n = optJSONObject.optString("app_name");
                aVar.bl = optJSONObject.optString("package_name");
                aVar.kf = optJSONObject.optString("version_name");
                aVar.f48356h = optJSONObject.optString("developer_name");
                aVar.f48359q = optJSONObject.optString("policy_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray(com.bytedance.msdk.api.activity.TTDelegateActivity.INTENT_PERMISSIONS);
                if (optJSONArray != null) {
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        JSONObject jSONObject = (JSONObject) optJSONArray.get(i4);
                        aVar.f48358p.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                bl.ok().ok(aVar);
                s.ok().ok(aVar.ok(), j5, aVar.f48360s);
                return true;
            }
            h.ok(7, j5);
            return false;
        } catch (Exception e4) {
            com.ss.android.downloadlib.n.bl.ok().ok(e4, "AdLpComplianceManager parseResponse");
            h.ok(7, j5);
            return false;
        }
    }

    public void ok(Activity activity) {
        this.ok = new SoftReference<>(activity);
    }
}
