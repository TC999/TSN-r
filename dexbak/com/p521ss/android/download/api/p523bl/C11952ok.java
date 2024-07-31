package com.p521ss.android.download.api.p523bl;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12317n;
import java.util.List;

/* renamed from: com.ss.android.download.api.bl.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C11952ok {
    /* renamed from: a */
    public static String m19658a(@NonNull Uri uri) {
        String scheme = uri.getScheme();
        List<String> pathSegments = uri.getPathSegments();
        if (C12128r.m18946q().optInt("market_scheme_opt") == 1 && C12317n.m18242h() && "samsungapps".equals(scheme) && pathSegments != null && pathSegments.size() == 1) {
            return pathSegments.get(0);
        }
        return C11951a.m19660ok(uri.getQueryParameter("id"), uri.getQueryParameter("packagename"), uri.getQueryParameter("pkg"), uri.getQueryParameter("package_name"), uri.getQueryParameter("appId"));
    }

    /* renamed from: ok */
    public static boolean m19657ok(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        if (C12128r.m18946q().optInt("market_url_opt", 1) == 0) {
            return "market".equals(scheme);
        }
        return "market".equals(scheme) || "appmarket".equals(scheme) || "oaps".equals(scheme) || "oppomarket".equals(scheme) || "mimarket".equals(scheme) || "vivomarket".equals(scheme) || "vivoMarket".equals(scheme) || "gomarket".equals(scheme) || "goMarket".equals(scheme) || "mstore".equals(scheme) || "samsungapps".equals(scheme);
    }
}
