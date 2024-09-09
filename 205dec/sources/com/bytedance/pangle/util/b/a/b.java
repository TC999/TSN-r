package com.bytedance.pangle.util.b.a;

import com.bytedance.pangle.util.b.b.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {
    public static void a(d dVar, ByteArrayOutputStream byteArrayOutputStream) {
        List<com.bytedance.pangle.util.b.b.c> list;
        com.bytedance.pangle.util.b.b.a aVar = dVar.f28999a;
        if (aVar == null || (list = aVar.f28986a) == null || list.size() <= 0) {
            return;
        }
        for (com.bytedance.pangle.util.b.b.c cVar : dVar.f28999a.f28986a) {
            c cVar2 = dVar.f29001c;
            if (cVar != null) {
                byte[] bArr = {0, 0};
                cVar2.a((OutputStream) byteArrayOutputStream, 33639248);
                cVar2.a(byteArrayOutputStream, 0);
                cVar2.a(byteArrayOutputStream, 0);
                cVar2.a(byteArrayOutputStream, 0);
                cVar2.a(byteArrayOutputStream, cVar.f28989a);
                cVar2.a(byteArrayOutputStream, 2081);
                cVar2.a(byteArrayOutputStream, 545);
                cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f28990b);
                cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f28991c);
                cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f28992d);
                byte[] bArr2 = new byte[0];
                String str = cVar.f28996h;
                if (str != null && str.trim().length() > 0) {
                    bArr2 = cVar.f28996h.getBytes(Charset.forName("UTF-8"));
                }
                cVar2.a(byteArrayOutputStream, bArr2.length);
                int i4 = cVar.f28994f;
                cVar2.a(byteArrayOutputStream, i4);
                cVar2.a(byteArrayOutputStream, 0);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr);
                cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f28997i);
                if (bArr2.length > 0) {
                    byteArrayOutputStream.write(bArr2);
                }
                if (i4 > 0) {
                    byteArrayOutputStream.write(new byte[i4]);
                }
            } else {
                throw new IOException("input parameters is null, cannot write local file header");
            }
        }
    }
}
