package com.kwad.sdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.p;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements g {
    private static String auL;

    private static String Dr() {
        Context context;
        if (!TextUtils.isEmpty(auL)) {
            return auL;
        }
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return "";
        }
        String str = context.getPackageName() + bc.cT(context);
        auL = str;
        return str;
    }

    @Override // com.kwad.sdk.core.a.g
    public final void a(String str, Map<String, String> map, String str2) {
        f.a(str, map, str2);
    }

    @Override // com.kwad.sdk.core.a.g
    public final String al(String str) {
        try {
            String dY = p.dY(0);
            return new String(c.Ds().encode(b.d(dY.getBytes("UTF-8"), b.f(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // com.kwad.sdk.core.a.g
    public final void f(@NonNull Map<String, String> map) {
        map.put("Ks-PkgId", Dr());
        map.put("Ks-Encoding", "2");
    }

    @Override // com.kwad.sdk.core.a.g
    public final String getResponseData(String str) {
        try {
            return new String(b.g(b.a(p.dY(0), c.Du().decode(str.getBytes()))), "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }
}
