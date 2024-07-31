package com.amap.api.col.p0463l;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.amap.api.col.3l.s0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class FileAccessI {

    /* renamed from: a */
    RandomAccessFile f5214a;

    public FileAccessI() throws IOException {
        this("", 0L);
    }

    /* renamed from: a */
    public final synchronized int m54014a(byte[] bArr) throws IOException {
        this.f5214a.write(bArr);
        return bArr.length;
    }

    /* renamed from: b */
    public final void m54013b() {
        RandomAccessFile randomAccessFile = this.f5214a;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f5214a = null;
        }
    }

    public FileAccessI(String str, long j) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                SDKLogHandler.m53863p(e, "FileAccessI", "create");
                e.printStackTrace();
            }
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        this.f5214a = randomAccessFile;
        randomAccessFile.seek(j);
    }
}
