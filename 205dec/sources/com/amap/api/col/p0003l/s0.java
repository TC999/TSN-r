package com.amap.api.col.p0003l;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: FileAccessI.java */
/* renamed from: com.amap.api.col.3l.s0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
final class s0 {

    /* renamed from: a  reason: collision with root package name */
    RandomAccessFile f8926a;

    public s0() throws IOException {
        this("", 0L);
    }

    public final synchronized int a(byte[] bArr) throws IOException {
        this.f8926a.write(bArr);
        return bArr.length;
    }

    public final void b() {
        RandomAccessFile randomAccessFile = this.f8926a;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            this.f8926a = null;
        }
    }

    public s0(String str, long j4) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e4) {
                u5.p(e4, "FileAccessI", "create");
                e4.printStackTrace();
            }
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        this.f8926a = randomAccessFile;
        randomAccessFile.seek(j4);
    }
}
