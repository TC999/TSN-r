package com.p521ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.p518qq.p519e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.p521ss.android.download.api.config.InterfaceC11969td;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.downloadlib.C12184h;
import com.p521ss.android.downloadlib.activity.TTDelegateActivity;
import com.p521ss.android.downloadlib.addownload.C12095n;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12029a;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12035n;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.RunnableC12194bl;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.compliance.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12058a {

    /* renamed from: ok */
    private SoftReference<Activity> f34137ok;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.addownload.compliance.a$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12062ok {

        /* renamed from: ok */
        private static C12058a f34146ok = new C12058a();
    }

    /* renamed from: a */
    public void m19229a(long j) {
        C12095n m18826ok = C12184h.m18835ok().m18826ok(C12032kf.m19324ok().m19325n(j).f34076a.getDownloadUrl());
        if (m18826ok != null) {
            m18826ok.m19066ok(true, true);
            return;
        }
        C12066h.m19212ok(11, j);
        C12235bl.m18640ok().m18643a("startDownload handler null");
    }

    private C12058a() {
    }

    /* renamed from: ok */
    public static C12058a m19228ok() {
        return C12062ok.f34146ok;
    }

    /* renamed from: ok */
    public void m19227ok(long j) {
        TTDelegateActivity.m19358ok(j);
    }

    /* renamed from: ok */
    public boolean m19224ok(DownloadModel downloadModel) {
        if (downloadModel.isAd() && C12128r.m18946q().optInt("ad_lp_show_app_dialog") != 0) {
            String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
            return (TextUtils.isEmpty(webUrl) || Pattern.compile(C12128r.m18946q().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
        }
        return false;
    }

    /* renamed from: a */
    public Activity m19230a() {
        Activity activity = this.f34137ok.get();
        this.f34137ok = null;
        return activity;
    }

    /* renamed from: ok */
    public boolean m19223ok(@NonNull C12035n c12035n) {
        long j;
        long j2;
        if (!TextUtils.isEmpty(c12035n.f34076a.getLogExtra())) {
            try {
                j = C12197j.m18779ok(new JSONObject(c12035n.f34076a.getLogExtra()), "convert_id");
            } catch (Exception e) {
                e.printStackTrace();
                j = 0;
            }
            if (j <= 0) {
                C12066h.m19211ok(3, c12035n);
            }
            j2 = j;
        } else {
            C12066h.m19211ok(9, c12035n);
            C12235bl.m18640ok().m18639ok("requestAppInfo getLogExtra null");
            j2 = 0;
        }
        final long j3 = c12035n.f34079ok;
        C12029a m19216ok = C12063bl.m19218ok().m19216ok(j2, j3);
        if (m19216ok != null) {
            C12084s.m19129ok().m19127ok(m19216ok.m19341ok(), j3, m19216ok.f34056s);
            m19227ok(m19216ok.m19341ok());
            C12066h.m19209ok("lp_app_dialog_try_show", c12035n);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j2 > 0) {
            sb.append("convert_id=");
            sb.append(j2);
        }
        if (!TextUtils.isEmpty(c12035n.f34076a.getPackageName())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=");
            sb.append(c12035n.f34076a.getPackageName());
        }
        if (sb.length() <= 0) {
            C12066h.m19211ok(6, c12035n);
            return false;
        }
        final long j4 = j2;
        RunnableC12194bl.m18813ok((RunnableC12194bl.InterfaceC12195ok<String, R>) new RunnableC12194bl.InterfaceC12195ok<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.a.2
            @Override // com.p521ss.android.downloadlib.p534h.RunnableC12194bl.InterfaceC12195ok
            /* renamed from: ok  reason: avoid collision after fix types in other method */
            public Boolean mo18812ok(String str) {
                final boolean[] zArr = {false};
                C12128r.m18943s().mo19648ok("GET", str, new HashMap(), new InterfaceC11969td() { // from class: com.ss.android.downloadlib.addownload.compliance.a.2.1
                    @Override // com.p521ss.android.download.api.config.InterfaceC11969td
                    /* renamed from: ok */
                    public void mo18687ok(String str2) {
                        boolean[] zArr2 = zArr;
                        C120602 c120602 = C120602.this;
                        zArr2[0] = C12058a.this.m19226ok(j4, j3, str2);
                    }

                    @Override // com.p521ss.android.download.api.config.InterfaceC11969td
                    /* renamed from: ok */
                    public void mo18686ok(Throwable th) {
                        C12066h.m19212ok(2, j3);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).m18814ok(new RunnableC12194bl.InterfaceC12195ok<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.a.1
            @Override // com.p521ss.android.downloadlib.p534h.RunnableC12194bl.InterfaceC12195ok
            /* renamed from: ok  reason: avoid collision after fix types in other method */
            public Object mo18812ok(Boolean bool) {
                if (bool.booleanValue()) {
                    C12058a.this.m19227ok(C12029a.m19340ok(j4, j3));
                    C12066h.m19213a("lp_app_dialog_try_show", j3);
                    return null;
                }
                C12058a.this.m19229a(j3);
                return null;
            }
        }).m18816ok();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public boolean m19226ok(long j, long j2, String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("package");
            if (optJSONObject != null && optJSONObject.length() != 0) {
                C12029a c12029a = new C12029a();
                c12029a.f34053ok = j;
                c12029a.f34048a = j2;
                c12029a.f34056s = optJSONObject.optString(CampaignEx.JSON_KEY_ICON_URL);
                c12029a.f34052n = optJSONObject.optString("app_name");
                c12029a.f34049bl = optJSONObject.optString("package_name");
                c12029a.f34051kf = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                c12029a.f34050h = optJSONObject.optString("developer_name");
                c12029a.f34055q = optJSONObject.optString("policy_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray(com.bytedance.msdk.api.activity.TTDelegateActivity.INTENT_PERMISSIONS);
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) optJSONArray.get(i);
                        c12029a.f34054p.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                    }
                }
                C12063bl.m19218ok().m19215ok(c12029a);
                C12084s.m19129ok().m19127ok(c12029a.m19341ok(), j2, c12029a.f34056s);
                return true;
            }
            C12066h.m19212ok(7, j2);
            return false;
        } catch (Exception e) {
            C12235bl.m18640ok().mo18637ok(e, "AdLpComplianceManager parseResponse");
            C12066h.m19212ok(7, j2);
            return false;
        }
    }

    /* renamed from: ok */
    public void m19225ok(Activity activity) {
        this.f34137ok = new SoftReference<>(activity);
    }
}
