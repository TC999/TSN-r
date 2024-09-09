package com.ss.android.socialbase.appdownloader.w;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static final String f49249c;

    static {
        StringBuilder sb = new StringBuilder();
        String str = Build.VERSION.RELEASE;
        boolean z3 = true;
        boolean z4 = !TextUtils.isEmpty(str);
        boolean z5 = !TextUtils.isEmpty(Build.ID);
        z3 = (!"REL".equals(Build.VERSION.CODENAME) || TextUtils.isEmpty(Build.MODEL)) ? false : false;
        sb.append("AppDownloader");
        if (z4) {
            sb.append(TTPathConst.sSeparator);
            sb.append(str);
        }
        sb.append(" (Linux; U; Android");
        if (z4) {
            sb.append(" ");
            sb.append(str);
        }
        if (z3 || z5) {
            sb.append(";");
            if (z3) {
                sb.append(" ");
                sb.append(Build.MODEL);
            }
            if (z5) {
                sb.append(" Build/");
                sb.append(Build.ID);
            }
        }
        sb.append(")");
        f49249c = sb.toString();
    }
}
