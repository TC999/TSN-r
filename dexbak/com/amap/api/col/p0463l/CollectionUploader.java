package com.amap.api.col.p0463l;

import android.util.Base64;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.nio.charset.StandardCharsets;

/* renamed from: com.amap.api.col.3l.k8 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class CollectionUploader {
    /* renamed from: a */
    public static boolean m54633a(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = null;
            try {
                HttpRequest httpRequest = new HttpRequest();
                httpRequest.f4759b.put("Content-Type", HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE);
                httpRequest.f4759b.put("aps_c_src", Base64.encodeToString(HttpRequest.m54421a().getBytes(), 2));
                httpRequest.f4759b.put("aps_c_key", Base64.encodeToString(HttpRequest.m54420b().getBytes(), 2));
                httpRequest.f4761d = bArr;
                if (CollectionConfig.f3689a) {
                    httpRequest.f4758a = "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
                } else {
                    String str = CollectionConfig.f3690b ? "https://" : "http://";
                    httpRequest.f4758a = str + "cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
                }
                HttpResponse mo51670a = AmapContext.m54896c().mo51670a(httpRequest);
                if (mo51670a != null && mo51670a.f5082a == 200) {
                    bArr2 = mo51670a.f5084c;
                }
                if (bArr2 != null) {
                    return "true".equals(new String(bArr2, StandardCharsets.UTF_8));
                }
                return false;
            } catch (Exception e) {
                ALLog.m54456a(e);
                return false;
            }
        }
        return false;
    }
}
