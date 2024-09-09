package com.kwad.components.ad.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.n;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class b extends d implements n {
    public final Map<String, AppPackageInfo> K(Context context) {
        return a.K(context);
    }

    public final void a(Context context, com.kwad.sdk.f.a<JSONArray> aVar) {
        a.a(context, aVar);
    }

    public final JSONArray[] b(Context context, List<String> list) {
        return a.b(context, list);
    }

    @NonNull
    public final JSONArray c(@NonNull Map<String, AppPackageInfo> map) {
        return a.c(map);
    }

    public final JSONObject e(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return a.a(a.a(packageInfo, packageManager));
            }
            return null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return null;
        }
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return n.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    public final JSONObject x(String str) {
        AppPackageInfo appPackageInfo = new AppPackageInfo();
        appPackageInfo.packageName = str;
        return a.a(appPackageInfo);
    }
}
