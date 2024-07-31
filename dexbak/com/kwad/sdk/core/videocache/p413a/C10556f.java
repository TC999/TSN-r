package com.kwad.sdk.core.videocache.p413a;

import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.utils.C11010ad;
import java.util.HashMap;
import java.util.Set;

/* renamed from: com.kwad.sdk.core.videocache.a.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10556f implements InterfaceC10551c {
    /* renamed from: eI */
    private static String m25473eI(String str) {
        Uri parse = Uri.parse(str);
        if (parse.getHost() == null || !parse.getHost().contains("yximgs.com")) {
            return str;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        HashMap hashMap = new HashMap();
        if (parse.isHierarchical()) {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            for (String str2 : queryParameterNames) {
                hashMap.put(str2, parse.getQueryParameter(str2));
            }
            buildUpon.clearQuery();
            for (String str3 : queryParameterNames) {
                if (!"tag".equals(str3) && !"di".equals(str3) && str3 != null) {
                    buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
                }
            }
        }
        return buildUpon.toString();
    }

    private static String getExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.kwad.sdk.core.videocache.p413a.InterfaceC10551c
    public final String generate(String str) {
        String m25473eI = m25473eI(str);
        String extension = getExtension(m25473eI);
        String m24144bu = C11010ad.m24144bu(m25473eI);
        if (TextUtils.isEmpty(extension)) {
            return m24144bu;
        }
        return m24144bu + "." + extension;
    }
}
