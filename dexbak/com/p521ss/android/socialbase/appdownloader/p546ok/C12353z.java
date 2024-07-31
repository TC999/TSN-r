package com.p521ss.android.socialbase.appdownloader.p546ok;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12315bl;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.ss.android.socialbase.appdownloader.ok.z */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12353z extends AbstractC12348ok {
    public C12353z(Context context, C12534ok c12534ok, String str) {
        super(context, c12534ok, str);
    }

    /* renamed from: ok */
    public static String m18105ok(Map<String, String> map) {
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

    @Override // com.p521ss.android.socialbase.appdownloader.p546ok.InterfaceC12347n
    /* renamed from: a */
    public Intent mo18106a() {
        String m17603bl = this.f34808a.m17603bl("s");
        String m18260ok = C12315bl.m18260ok(this.f34808a.m17603bl("bb"), m17603bl);
        if (!TextUtils.isEmpty(m18260ok) && m18260ok.split(",").length == 2) {
            String m18260ok2 = C12315bl.m18260ok(this.f34808a.m17603bl("bc"), m17603bl);
            if (!TextUtils.isEmpty(m18260ok2) && m18260ok2.split(",").length == 2) {
                String[] split = m18260ok.split(",");
                String[] split2 = m18260ok2.split(",");
                String m18260ok3 = C12315bl.m18260ok(this.f34808a.m17603bl("bd"), m17603bl);
                String m18260ok4 = C12315bl.m18260ok(this.f34808a.m17603bl("be"), m17603bl);
                String m18260ok5 = C12315bl.m18260ok(this.f34808a.m17603bl("bf"), m17603bl);
                HashMap hashMap = new HashMap();
                hashMap.put(split[0], split[1]);
                hashMap.put(split2[0], split2[1]);
                hashMap.put(m18260ok3, this.f34809bl);
                Intent intent = new Intent();
                intent.setAction(m18260ok5);
                intent.setData(Uri.parse(m18260ok4 + m18105ok(hashMap)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
