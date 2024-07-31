package com.bytedance.pangle.util.p127b.p128a;

import com.bytedance.pangle.util.p127b.p129b.C6243a;
import com.bytedance.pangle.util.p127b.p129b.C6245c;
import com.bytedance.pangle.util.p127b.p129b.C6246d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

/* renamed from: com.bytedance.pangle.util.b.a.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6240b {
    /* renamed from: a */
    public static void m36922a(C6246d c6246d, ByteArrayOutputStream byteArrayOutputStream) {
        List<C6245c> list;
        C6243a c6243a = c6246d.f22229a;
        if (c6243a == null || (list = c6243a.f22216a) == null || list.size() <= 0) {
            return;
        }
        for (C6245c c6245c : c6246d.f22229a.f22216a) {
            C6241c c6241c = c6246d.f22231c;
            if (c6245c != null) {
                byte[] bArr = {0, 0};
                c6241c.m36920a((OutputStream) byteArrayOutputStream, 33639248);
                c6241c.m36921a(byteArrayOutputStream, 0);
                c6241c.m36921a(byteArrayOutputStream, 0);
                c6241c.m36921a(byteArrayOutputStream, 0);
                c6241c.m36921a(byteArrayOutputStream, c6245c.f22219a);
                c6241c.m36921a(byteArrayOutputStream, 2081);
                c6241c.m36921a(byteArrayOutputStream, 545);
                c6241c.m36920a((OutputStream) byteArrayOutputStream, (int) c6245c.f22220b);
                c6241c.m36920a((OutputStream) byteArrayOutputStream, (int) c6245c.f22221c);
                c6241c.m36920a((OutputStream) byteArrayOutputStream, (int) c6245c.f22222d);
                byte[] bArr2 = new byte[0];
                String str = c6245c.f22226h;
                if (str != null && str.trim().length() > 0) {
                    bArr2 = c6245c.f22226h.getBytes(Charset.forName("UTF-8"));
                }
                c6241c.m36921a(byteArrayOutputStream, bArr2.length);
                int i = c6245c.f22224f;
                c6241c.m36921a(byteArrayOutputStream, i);
                c6241c.m36921a(byteArrayOutputStream, 0);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr);
                c6241c.m36920a((OutputStream) byteArrayOutputStream, (int) c6245c.f22227i);
                if (bArr2.length > 0) {
                    byteArrayOutputStream.write(bArr2);
                }
                if (i > 0) {
                    byteArrayOutputStream.write(new byte[i]);
                }
            } else {
                throw new IOException("input parameters is null, cannot write local file header");
            }
        }
    }
}
