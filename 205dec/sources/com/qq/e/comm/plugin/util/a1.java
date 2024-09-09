package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.qq.e.comm.plugin.i0.c;
import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.util.g2;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements com.qq.e.comm.plugin.i0.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f46364a;

        a(String str) {
            this.f46364a = str;
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.i0.n.g gVar) {
            d1.a("PingUrlUtil  onResponse, url : " + this.f46364a + " responseStatus : " + gVar.getStatusCode(), new Object[0]);
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, Exception exc) {
            d1.a("PingUrlUtil onException, url:" + this.f46364a + " errMsg : " + exc.getMessage());
        }
    }

    public static void a(String str) {
        a(str, true, null);
    }

    public static void a(String str, boolean z3) {
        a(str, z3, null);
    }

    public static void a(String str, boolean z3, com.qq.e.comm.plugin.i0.b bVar) {
        a(str, z3, null, bVar, false, null, 0);
    }

    public static void a(String str, boolean z3, Map<String, String> map, com.qq.e.comm.plugin.i0.b bVar, boolean z4, g2.h hVar, int i4) {
        if (TextUtils.isEmpty(str)) {
            d1.a("ping url null!", new Object[0]);
            return;
        }
        d1.a("PingUrlUtil        ping, url : " + str, new Object[0]);
        com.qq.e.comm.plugin.i0.n.c cVar = new com.qq.e.comm.plugin.i0.n.c(str, f.a.GET, (byte[]) null);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                cVar.addHeader(entry.getKey(), entry.getValue());
            }
        }
        d1.a("gdt_tag_net", d1.a(cVar));
        if (z4) {
            cVar.d(z4);
            cVar.a(hVar);
            cVar.a(i4);
        }
        com.qq.e.comm.plugin.i0.c a4 = com.qq.e.comm.plugin.i0.d.a();
        c.a aVar = z3 ? c.a.f44221d : c.a.f44223f;
        if (bVar == null) {
            bVar = new a(str);
        }
        a4.a(cVar, aVar, bVar);
    }
}
