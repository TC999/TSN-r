package com.qq.e.comm.plugin.p.j;

import com.qq.e.comm.plugin.p.j.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class j extends a {

    /* renamed from: f  reason: collision with root package name */
    private final long f45261f;

    public j(InputStream inputStream, long j4, File file, c cVar) {
        super(inputStream, file, cVar);
        this.f45261f = j4;
    }

    @Override // com.qq.e.comm.plugin.p.j.a
    public int a() {
        if (this.f45261f <= 0) {
            return 0;
        }
        return super.a();
    }

    @Override // com.qq.e.comm.plugin.p.j.a
    protected int a(FileOutputStream fileOutputStream) throws IOException {
        int i4;
        byte[] bArr = new byte[8192];
        long j4 = this.f45261f;
        this.f45216c.a(this.f45215b.length());
        while (true) {
            i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
            if (i4 <= 0 || this.f45218e.get()) {
                break;
            }
            try {
                int read = this.f45214a.read(bArr, 0, (int) Math.min(j4, 8192));
                if (read <= 0 || this.f45218e.get()) {
                    break;
                }
                try {
                    fileOutputStream.write(bArr, 0, read);
                    this.f45216c.a(this.f45215b.length());
                    j4 -= read;
                } catch (IOException e4) {
                    throw new a.b(e4);
                }
            } catch (IOException e5) {
                throw new a.C0870a(e5);
            }
        }
        if (i4 != 0) {
            this.f45217d = "NetworkErrInputStreamDoesNotSupportEnoughBytesAsExpected ";
            return 4194304;
        }
        return 0;
    }
}
