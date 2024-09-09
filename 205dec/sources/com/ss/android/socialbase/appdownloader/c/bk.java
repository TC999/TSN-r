package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class bk extends c {
    public bk(Context context, com.ss.android.socialbase.downloader.r.c cVar, String str) {
        super(context, cVar, str);
    }

    public static String c(Map<String, String> map) {
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

    @Override // com.ss.android.socialbase.appdownloader.c.ux
    public Intent w() {
        String xv = this.f49038w.xv("s");
        String c4 = com.ss.android.socialbase.appdownloader.f.xv.c(this.f49038w.xv("bb"), xv);
        if (!TextUtils.isEmpty(c4) && c4.split(",").length == 2) {
            String c5 = com.ss.android.socialbase.appdownloader.f.xv.c(this.f49038w.xv("bc"), xv);
            if (!TextUtils.isEmpty(c5) && c5.split(",").length == 2) {
                String[] split = c4.split(",");
                String[] split2 = c5.split(",");
                String c6 = com.ss.android.socialbase.appdownloader.f.xv.c(this.f49038w.xv("bd"), xv);
                String c7 = com.ss.android.socialbase.appdownloader.f.xv.c(this.f49038w.xv("be"), xv);
                String c8 = com.ss.android.socialbase.appdownloader.f.xv.c(this.f49038w.xv("bf"), xv);
                HashMap hashMap = new HashMap();
                hashMap.put(split[0], split[1]);
                hashMap.put(split2[0], split2[1]);
                hashMap.put(c6, this.xv);
                Intent intent = new Intent();
                intent.setAction(c8);
                intent.setData(Uri.parse(c7 + c(hashMap)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
