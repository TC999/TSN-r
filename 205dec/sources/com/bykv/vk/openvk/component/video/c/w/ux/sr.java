package com.bykv.vk.openvk.component.video.c.w.ux;

import android.text.TextUtils;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.t;
import java.io.IOException;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements w {

    /* renamed from: c  reason: collision with root package name */
    private a f25141c;

    public sr() {
        this.f25141c = null;
        this.f25141c = com.bykv.vk.openvk.component.video.api.xv.xv();
    }

    @Override // com.bykv.vk.openvk.component.video.c.w.ux.w
    public c c(ux uxVar) throws IOException {
        t.c cVar = new t.c();
        try {
            Map<String, String> map = uxVar.ux;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        cVar.w(key, value);
                    }
                }
            }
            fp c4 = this.f25141c.c(cVar.c(uxVar.f25143w).c().w()).c();
            com.bykv.vk.openvk.component.video.api.f.xv.w("NetworkSoureVolleyImpl", "response code = ", Integer.valueOf(c4.xv()));
            return new f(c4, uxVar);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
