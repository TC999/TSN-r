package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class q extends ok {

    /* renamed from: n  reason: collision with root package name */
    private String f49164n;

    /* renamed from: s  reason: collision with root package name */
    private String f49165s;

    public q(Context context, com.ss.android.socialbase.downloader.h.ok okVar, String str, String str2, String str3) {
        super(context, okVar, str);
        this.f49165s = str2;
        this.f49164n = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.ok.n
    public Intent a() {
        String str;
        String bl = this.f49163a.bl("s");
        String ok = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f49163a.bl("ak"), bl);
        String ok2 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f49163a.bl("am"), bl);
        String ok3 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f49163a.bl("an"), bl);
        String str2 = null;
        if (!TextUtils.isEmpty(ok3) && ok3.split(",").length == 2) {
            String[] split = ok3.split(",");
            String ok4 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f49163a.bl(CampaignEx.JSON_KEY_AD_AL), bl);
            String ok5 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f49163a.bl(LiveConfigKey.AUDIO), bl);
            if (!TextUtils.isEmpty(ok5) && ok5.split(",").length == 2) {
                String[] split2 = ok5.split(",");
                JSONObject s3 = this.f49163a.s("download_dir");
                if (s3 != null) {
                    String optString = s3.optString("dir_name");
                    if (!TextUtils.isEmpty(optString) && optString.contains("%s")) {
                        try {
                            str = String.format(optString, this.f49164n);
                        } catch (Throwable unused) {
                            str = this.f49164n;
                        }
                    } else {
                        str = this.f49164n;
                    }
                    str2 = str;
                    if (str2.length() > 255) {
                        str2 = ok4.substring(str2.length() - 255);
                    }
                }
                Intent intent = new Intent(ok);
                intent.putExtra(split2[0], split2[1]);
                intent.putExtra(ok2, this.f49165s);
                intent.putExtra(ok4, str2);
                intent.putExtra(split[0], Integer.parseInt(split[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
