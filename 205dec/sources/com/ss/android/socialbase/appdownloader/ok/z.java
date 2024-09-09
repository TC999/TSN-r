package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class z extends ok {
    public z(Context context, com.ss.android.socialbase.downloader.h.ok okVar, String str) {
        super(context, okVar, str);
    }

    public static String ok(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.endsWith("&") ? stringBuffer2.substring(0, stringBuffer2.length() - 1) : stringBuffer2;
    }

    @Override // com.ss.android.socialbase.appdownloader.ok.n
    public Intent a() {
        String bl = this.f49163a.bl("s");
        String ok = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f49163a.bl("bb"), bl);
        if (!TextUtils.isEmpty(ok) && ok.split(",").length == 2) {
            String ok2 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f49163a.bl("bc"), bl);
            if (!TextUtils.isEmpty(ok2) && ok2.split(",").length == 2) {
                String[] split = ok.split(",");
                String[] split2 = ok2.split(",");
                String ok3 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f49163a.bl("bd"), bl);
                String ok4 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f49163a.bl("be"), bl);
                String ok5 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f49163a.bl("bf"), bl);
                HashMap hashMap = new HashMap();
                hashMap.put(split[0], split[1]);
                hashMap.put(split2[0], split2[1]);
                hashMap.put(ok3, this.bl);
                Intent intent = new Intent();
                intent.setAction(ok5);
                intent.setData(Uri.parse(ok4 + ok(hashMap)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
