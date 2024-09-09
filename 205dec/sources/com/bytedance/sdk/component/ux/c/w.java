package com.bytedance.sdk.component.ux.c;

import com.bytedance.sdk.component.ux.a;
import com.bytedance.sdk.component.ux.gd;
import java.util.WeakHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static a c() {
        return new a() { // from class: com.bytedance.sdk.component.ux.c.w.1

            /* renamed from: c  reason: collision with root package name */
            private WeakHashMap<String, String> f30234c = new WeakHashMap<>();

            @Override // com.bytedance.sdk.component.ux.a
            public String c(gd gdVar) {
                return c(gdVar.w() + "#width=" + gdVar.xv() + "#height=" + gdVar.sr() + "#scaletype=" + gdVar.ux() + "#bitmapConfig=" + gdVar.ev());
            }

            @Override // com.bytedance.sdk.component.ux.a
            public String w(gd gdVar) {
                return c(gdVar.w());
            }

            private String c(String str) {
                String str2 = this.f30234c.get(str);
                if (str2 == null) {
                    String c4 = com.bytedance.sdk.component.ux.xv.xv.xv.c(str);
                    this.f30234c.put(str, c4);
                    return c4;
                }
                return str2;
            }
        };
    }
}
