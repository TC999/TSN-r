package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class gd extends c {
    private String sr;
    private String ux;

    public gd(Context context, com.ss.android.socialbase.downloader.r.c cVar, String str, String str2, String str3) {
        super(context, cVar, str);
        this.sr = str2;
        this.ux = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.c.ux
    public Intent w() {
        String str;
        String xv = this.f49038w.xv("s");
        String c4 = com.ss.android.socialbase.appdownloader.f.xv.c(this.f49038w.xv("ak"), xv);
        String c5 = com.ss.android.socialbase.appdownloader.f.xv.c(this.f49038w.xv("am"), xv);
        String c6 = com.ss.android.socialbase.appdownloader.f.xv.c(this.f49038w.xv("an"), xv);
        String str2 = null;
        if (!TextUtils.isEmpty(c6) && c6.split(",").length == 2) {
            String[] split = c6.split(",");
            String c7 = com.ss.android.socialbase.appdownloader.f.xv.c(this.f49038w.xv(CampaignEx.JSON_KEY_AD_AL), xv);
            String c8 = com.ss.android.socialbase.appdownloader.f.xv.c(this.f49038w.xv(LiveConfigKey.AUDIO), xv);
            if (!TextUtils.isEmpty(c8) && c8.split(",").length == 2) {
                String[] split2 = c8.split(",");
                JSONObject sr = this.f49038w.sr("download_dir");
                if (sr != null) {
                    String optString = sr.optString("dir_name");
                    if (!TextUtils.isEmpty(optString) && optString.contains("%s")) {
                        try {
                            str = String.format(optString, this.ux);
                        } catch (Throwable unused) {
                            str = this.ux;
                        }
                    } else {
                        str = this.ux;
                    }
                    str2 = str;
                    if (str2.length() > 255) {
                        str2 = c7.substring(str2.length() - 255);
                    }
                }
                Intent intent = new Intent(c4);
                intent.putExtra(split2[0], split2[1]);
                intent.putExtra(c5, this.sr);
                intent.putExtra(c7, str2);
                intent.putExtra(split[0], Integer.parseInt(split[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
