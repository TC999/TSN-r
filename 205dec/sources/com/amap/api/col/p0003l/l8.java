package com.amap.api.col.p0003l;

import android.util.Base64;
import cn.jpush.android.local.JPushConstants;
import java.nio.charset.StandardCharsets;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CollectionUploader.java */
/* renamed from: com.amap.api.col.3l.l8  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class l8 {
    public static boolean a(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = null;
            try {
                o9 o9Var = new o9();
                o9Var.f8470b.put("Content-Type", "application/octet-stream");
                o9Var.f8470b.put("aps_c_src", Base64.encodeToString(o9.a().getBytes(), 2));
                o9Var.f8470b.put("aps_c_key", Base64.encodeToString(o9.b().getBytes(), 2));
                o9Var.f8472d = bArr;
                if (c8.f7325a) {
                    o9Var.f8469a = "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
                } else {
                    String str = c8.f7326b ? JPushConstants.HTTPS_PRE : JPushConstants.HTTP_PRE;
                    o9Var.f8469a = str + "cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
                }
                q9 a4 = h9.c().a(o9Var);
                if (a4 != null && a4.f8840a == 200) {
                    bArr2 = a4.f8842c;
                }
                if (bArr2 != null) {
                    return "true".equals(new String(bArr2, StandardCharsets.UTF_8));
                }
                return false;
            } catch (Exception e4) {
                n9.a(e4);
                return false;
            }
        }
        return false;
    }
}
