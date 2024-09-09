package com.beizi.fusion.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.e.a.b;
import com.beizi.fusion.model.RequestInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: OaidUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    static String f14804a = "OaidUtil";

    /* renamed from: c  reason: collision with root package name */
    private static String f14806c;

    /* renamed from: b  reason: collision with root package name */
    public static b.a f14805b = new b.a() { // from class: com.beizi.fusion.g.aj.1
        @Override // com.beizi.fusion.e.a.b.a
        public void a(@NonNull String str) {
            String str2 = aj.f14804a;
            Log.e(str2, "code cn Oaid:" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String unused = aj.f14806c = str;
            Context e4 = com.beizi.fusion.d.b.a().e();
            au.a(e4, "__OAID__", (Object) aj.f14806c);
            au.a(e4, "__CNOAID__", (Object) aj.f14806c);
            if (RequestInfo.getInstance(e4).getDevInfo() != null) {
                if (ak.b() && BeiZis.isLimitPersonalAds()) {
                    return;
                }
                RequestInfo.getInstance(e4).getDevInfo().setOaid(aj.f14806c);
                RequestInfo.getInstance(e4).getDevInfo().setCnOaid(aj.f14806c);
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static boolean f14807d = true;
}
