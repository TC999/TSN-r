package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d {
    public static b a(Map<String, List<String>> map, b bVar, List<String> list) {
        int responseCode = bVar.getResponseCode();
        String bd = bVar.bd("Location");
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (bi(responseCode)) {
            if (bd != null) {
                if (com.kwad.framework.filedownloader.f.d.ail) {
                    com.kwad.framework.filedownloader.f.d.c(d.class, "redirect to %s with %d, %s", bd, Integer.valueOf(responseCode), arrayList);
                }
                bVar.ve();
                bVar = a(map, bd);
                arrayList.add(bd);
                bVar.execute();
                responseCode = bVar.getResponseCode();
                bd = bVar.bd("Location");
                i4++;
                if (i4 >= 10) {
                    throw new IllegalAccessException(f.b("redirect too many times! %s", arrayList));
                }
            } else {
                throw new IllegalAccessException(f.b("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(responseCode), bVar.vd()));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }

    private static boolean bi(int i4) {
        return i4 == 301 || i4 == 302 || i4 == 303 || i4 == 300 || i4 == 307 || i4 == 308;
    }

    private static b a(Map<String, List<String>> map, String str) {
        b bh = com.kwad.framework.filedownloader.download.b.vo().bh(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                for (String str2 : value) {
                    bh.addHeader(key, str2);
                }
            }
        }
        return bh;
    }
}
