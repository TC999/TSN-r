package com.p521ss.android.socialbase.appdownloader.p541a;

import android.os.Build;
import android.text.TextUtils;

/* renamed from: com.ss.android.socialbase.appdownloader.a.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12292ok {

    /* renamed from: ok */
    public static final String f34656ok;

    static {
        StringBuilder sb = new StringBuilder();
        String str = Build.VERSION.RELEASE;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(str);
        boolean z3 = !TextUtils.isEmpty(Build.ID);
        z = (!"REL".equals(Build.VERSION.CODENAME) || TextUtils.isEmpty(Build.MODEL)) ? false : false;
        sb.append("AppDownloader");
        if (z2) {
            sb.append("/");
            sb.append(str);
        }
        sb.append(" (Linux; U; Android");
        if (z2) {
            sb.append(" ");
            sb.append(str);
        }
        if (z || z3) {
            sb.append(";");
            if (z) {
                sb.append(" ");
                sb.append(Build.MODEL);
            }
            if (z3) {
                sb.append(" Build/");
                sb.append(Build.ID);
            }
        }
        sb.append(")");
        f34656ok = sb.toString();
    }
}
