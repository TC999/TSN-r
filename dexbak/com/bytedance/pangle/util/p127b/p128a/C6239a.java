package com.bytedance.pangle.util.p127b.p128a;

import com.bytedance.pangle.util.p127b.p129b.C6243a;
import com.bytedance.pangle.util.p127b.p129b.C6244b;
import com.bytedance.pangle.util.p127b.p129b.C6245c;
import com.bytedance.pangle.util.p127b.p129b.C6246d;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* renamed from: com.bytedance.pangle.util.b.a.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6239a {
    /* renamed from: a */
    public static C6246d m36924a(String str) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (randomAccessFile.length() >= 22) {
                C6246d c6246d = new C6246d(str);
                long length = randomAccessFile.length();
                if (length >= 22) {
                    long j = length - 22;
                    randomAccessFile.seek(j);
                    if (c6246d.f22231c.m36919a(randomAccessFile) != 101010256) {
                        j = m36923b(randomAccessFile, c6246d);
                    }
                    randomAccessFile.seek(j + 4);
                    C6244b c6244b = new C6244b();
                    randomAccessFile.skipBytes(6);
                    c6244b.f22217a = c6246d.f22231c.m36916b(randomAccessFile);
                    randomAccessFile.skipBytes(4);
                    c6244b.f22218b = c6246d.f22231c.m36919a(randomAccessFile);
                    c6246d.f22230b = c6244b;
                    if (c6244b.f22217a == 0) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused) {
                        }
                        return c6246d;
                    }
                    m36925a(randomAccessFile, c6246d);
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return c6246d;
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

    /* renamed from: b */
    private static long m36923b(RandomAccessFile randomAccessFile, C6246d c6246d) {
        long length = randomAccessFile.length() - 22;
        for (long length2 = randomAccessFile.length() < 65536 ? randomAccessFile.length() : 65536L; length2 > 0 && length > 0; length2--) {
            length--;
            randomAccessFile.seek(length);
            if (c6246d.f22231c.m36919a(randomAccessFile) == 101010256) {
                return length;
            }
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    /* renamed from: a */
    private static void m36925a(RandomAccessFile randomAccessFile, C6246d c6246d) {
        C6243a c6243a = new C6243a();
        ArrayList arrayList = new ArrayList();
        C6244b c6244b = c6246d.f22230b;
        long j = c6244b.f22218b;
        long j2 = c6244b.f22217a;
        randomAccessFile.seek(j);
        for (int i = 0; i < j2; i++) {
            C6245c c6245c = new C6245c();
            if (c6246d.f22231c.m36919a(randomAccessFile) == 33639248) {
                randomAccessFile.skipBytes(6);
                c6245c.f22219a = c6246d.f22231c.m36916b(randomAccessFile);
                randomAccessFile.skipBytes(4);
                c6245c.f22220b = c6246d.f22231c.m36919a(randomAccessFile);
                c6245c.f22221c = c6246d.f22231c.m36919a(randomAccessFile);
                c6245c.f22222d = c6246d.f22231c.m36919a(randomAccessFile);
                int m36916b = c6246d.f22231c.m36916b(randomAccessFile);
                c6245c.f22223e = m36916b;
                c6245c.f22224f = c6246d.f22231c.m36916b(randomAccessFile);
                int m36916b2 = c6246d.f22231c.m36916b(randomAccessFile);
                randomAccessFile.skipBytes(8);
                c6245c.f22227i = c6246d.f22231c.m36919a(randomAccessFile);
                if (m36916b > 0) {
                    byte[] bArr = new byte[m36916b];
                    randomAccessFile.readFully(bArr);
                    c6245c.f22226h = new String(bArr, Charset.forName("UTF-8"));
                    randomAccessFile.skipBytes(c6245c.f22224f);
                    if (m36916b2 > 0) {
                        randomAccessFile.skipBytes(m36916b2);
                    }
                    long filePointer = randomAccessFile.getFilePointer();
                    randomAccessFile.seek(c6245c.f22227i + 28);
                    c6245c.f22225g = c6246d.f22231c.m36916b(randomAccessFile);
                    randomAccessFile.seek(filePointer);
                    arrayList.add(c6245c);
                } else {
                    throw new IOException("Invalid entry name in file header");
                }
            } else {
                throw new IOException("Expected central directory entry not found (#" + (i + 1) + ")");
            }
        }
        c6243a.f22216a = arrayList;
        c6246d.f22229a = c6243a;
    }
}
