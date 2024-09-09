package com.bytedance.pangle.util.b.a;

import com.bytedance.pangle.util.b.b.d;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class a {
    public static d a(String str) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (randomAccessFile.length() >= 22) {
                d dVar = new d(str);
                long length = randomAccessFile.length();
                if (length >= 22) {
                    long j4 = length - 22;
                    randomAccessFile.seek(j4);
                    if (dVar.f29001c.a(randomAccessFile) != 101010256) {
                        j4 = b(randomAccessFile, dVar);
                    }
                    randomAccessFile.seek(j4 + 4);
                    com.bytedance.pangle.util.b.b.b bVar = new com.bytedance.pangle.util.b.b.b();
                    randomAccessFile.skipBytes(6);
                    bVar.f28987a = dVar.f29001c.b(randomAccessFile);
                    randomAccessFile.skipBytes(4);
                    bVar.f28988b = dVar.f29001c.a(randomAccessFile);
                    dVar.f29000b = bVar;
                    if (bVar.f28987a == 0) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused) {
                        }
                        return dVar;
                    }
                    a(randomAccessFile, dVar);
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return dVar;
                }
                throw new IOException("Zip file size less than size of zip headers. Probably not a zip file.");
            }
            throw new IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    private static long b(RandomAccessFile randomAccessFile, d dVar) {
        long length = randomAccessFile.length() - 22;
        for (long length2 = randomAccessFile.length() < 65536 ? randomAccessFile.length() : 65536L; length2 > 0 && length > 0; length2--) {
            length--;
            randomAccessFile.seek(length);
            if (dVar.f29001c.a(randomAccessFile) == 101010256) {
                return length;
            }
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private static void a(RandomAccessFile randomAccessFile, d dVar) {
        com.bytedance.pangle.util.b.b.a aVar = new com.bytedance.pangle.util.b.b.a();
        ArrayList arrayList = new ArrayList();
        com.bytedance.pangle.util.b.b.b bVar = dVar.f29000b;
        long j4 = bVar.f28988b;
        long j5 = bVar.f28987a;
        randomAccessFile.seek(j4);
        for (int i4 = 0; i4 < j5; i4++) {
            com.bytedance.pangle.util.b.b.c cVar = new com.bytedance.pangle.util.b.b.c();
            if (dVar.f29001c.a(randomAccessFile) == 33639248) {
                randomAccessFile.skipBytes(6);
                cVar.f28989a = dVar.f29001c.b(randomAccessFile);
                randomAccessFile.skipBytes(4);
                cVar.f28990b = dVar.f29001c.a(randomAccessFile);
                cVar.f28991c = dVar.f29001c.a(randomAccessFile);
                cVar.f28992d = dVar.f29001c.a(randomAccessFile);
                int b4 = dVar.f29001c.b(randomAccessFile);
                cVar.f28993e = b4;
                cVar.f28994f = dVar.f29001c.b(randomAccessFile);
                int b5 = dVar.f29001c.b(randomAccessFile);
                randomAccessFile.skipBytes(8);
                cVar.f28997i = dVar.f29001c.a(randomAccessFile);
                if (b4 > 0) {
                    byte[] bArr = new byte[b4];
                    randomAccessFile.readFully(bArr);
                    cVar.f28996h = new String(bArr, Charset.forName("UTF-8"));
                    randomAccessFile.skipBytes(cVar.f28994f);
                    if (b5 > 0) {
                        randomAccessFile.skipBytes(b5);
                    }
                    long filePointer = randomAccessFile.getFilePointer();
                    randomAccessFile.seek(cVar.f28997i + 28);
                    cVar.f28995g = dVar.f29001c.b(randomAccessFile);
                    randomAccessFile.seek(filePointer);
                    arrayList.add(cVar);
                } else {
                    throw new IOException("Invalid entry name in file header");
                }
            } else {
                throw new IOException("Expected central directory entry not found (#" + (i4 + 1) + ")");
            }
        }
        aVar.f28986a = arrayList;
        dVar.f28999a = aVar;
    }
}
