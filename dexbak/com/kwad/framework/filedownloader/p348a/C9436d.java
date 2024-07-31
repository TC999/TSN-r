package com.kwad.framework.filedownloader.p348a;

import com.kwad.framework.filedownloader.download.C9470b;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9501f;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.kwad.framework.filedownloader.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9436d {
    /* renamed from: a */
    public static InterfaceC9432b m28810a(Map<String, List<String>> map, InterfaceC9432b interfaceC9432b, List<String> list) {
        int responseCode = interfaceC9432b.getResponseCode();
        String mo24750bd = interfaceC9432b.mo24750bd(HttpHeaders.Names.LOCATION);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (m28808bi(responseCode)) {
            if (mo24750bd != null) {
                if (C9498d.ail) {
                    C9498d.m28535c(C9436d.class, "redirect to %s with %d, %s", mo24750bd, Integer.valueOf(responseCode), arrayList);
                }
                interfaceC9432b.mo24747ve();
                interfaceC9432b = m28809a(map, mo24750bd);
                arrayList.add(mo24750bd);
                interfaceC9432b.execute();
                responseCode = interfaceC9432b.getResponseCode();
                mo24750bd = interfaceC9432b.mo24750bd(HttpHeaders.Names.LOCATION);
                i++;
                if (i >= 10) {
                    throw new IllegalAccessException(C9501f.m28515b("redirect too many times! %s", arrayList));
                }
            } else {
                throw new IllegalAccessException(C9501f.m28515b("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(responseCode), interfaceC9432b.mo24748vd()));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return interfaceC9432b;
    }

    /* renamed from: bi */
    private static boolean m28808bi(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }

    /* renamed from: a */
    private static InterfaceC9432b m28809a(Map<String, List<String>> map, String str) {
        InterfaceC9432b m28632bh = C9470b.m28631vo().m28632bh(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                for (String str2 : value) {
                    m28632bh.addHeader(key, str2);
                }
            }
        }
        return m28632bh;
    }
}
