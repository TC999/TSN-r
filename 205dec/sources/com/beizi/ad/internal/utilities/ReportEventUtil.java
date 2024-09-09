package com.beizi.ad.internal.utilities;

import android.text.TextUtils;
import com.beizi.ad.internal.i;
import com.beizi.ad.lance.a.c;
import com.beizi.ad.lance.a.l;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ReportEventUtil {
    private static final String TAG = "ReportEventUtil";

    public static void report(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            String str = list.get(i4);
            l.a("ReportEventUtil", "ReportEventUtil:" + str);
            if (!TextUtils.isEmpty(str)) {
                new i(UrlUtil.replaceToTouchEventUrl(str, "", "", "", "", "", "", "")).executeOnExecutor(c.b().d(), new Void[0]);
            }
        }
    }
}
