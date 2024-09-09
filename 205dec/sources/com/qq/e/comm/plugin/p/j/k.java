package com.qq.e.comm.plugin.p.j;

import com.qq.e.comm.plugin.p.j.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class k extends a {
    public k(InputStream inputStream, File file, c cVar) {
        super(inputStream, file, cVar);
    }

    @Override // com.qq.e.comm.plugin.p.j.a
    protected int a(FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[8192];
        this.f45216c.a(this.f45215b.length());
        while (!this.f45218e.get()) {
            try {
                int read = this.f45214a.read(bArr);
                if (read <= 0 || this.f45218e.get()) {
                    break;
                }
                try {
                    fileOutputStream.write(bArr, 0, read);
                    this.f45216c.a(this.f45215b.length());
                } catch (IOException e4) {
                    throw new a.b(e4);
                }
            } catch (IOException e5) {
                throw new a.C0870a(e5);
            }
        }
        return 0;
    }
}
