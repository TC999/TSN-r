package com.beizi.p051ad.internal.utilities;

import android.text.TextUtils;
import com.beizi.p051ad.internal.ClickTracker;
import com.beizi.p051ad.lance.p062a.BeiZiExecutor;
import com.beizi.p051ad.lance.p062a.LogUtil;
import java.util.List;

/* renamed from: com.beizi.ad.internal.utilities.ReportEventUtil */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ReportEventUtil {
    private static final String TAG = "ReportEventUtil";

    public static void report(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            LogUtil.m49046a(TAG, "ReportEventUtil:" + str);
            if (!TextUtils.isEmpty(str)) {
                new ClickTracker(UrlUtil.replaceToTouchEventUrl(str, "", "", "", "", "", "", "")).executeOnExecutor(BeiZiExecutor.m49087b().m49085d(), new Void[0]);
            }
        }
    }
}
