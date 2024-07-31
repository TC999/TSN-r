package com.tencent.open.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C13050b {

    /* renamed from: a */
    private static final C13072n f37410a = new C13072n(101010256);

    /* renamed from: b */
    private static final C13073o f37411b = new C13073o(38651);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.utils.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13052a {

        /* renamed from: a */
        Properties f37412a;

        /* renamed from: b */
        byte[] f37413b;

        private C13052a() {
            this.f37412a = new Properties();
        }

        /* renamed from: a */
        void m15048a(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = C13050b.f37411b.m14913a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (C13050b.f37411b.equals(new C13073o(bArr2))) {
                if (bArr.length - length <= 2) {
                    return;
                }
                byte[] bArr3 = new byte[2];
                wrap.get(bArr3);
                int m14912b = new C13073o(bArr3).m14912b();
                if ((bArr.length - length) - 2 < m14912b) {
                    return;
                }
                byte[] bArr4 = new byte[m14912b];
                wrap.get(bArr4);
                this.f37412a.load(new ByteArrayInputStream(bArr4));
                int length2 = ((bArr.length - length) - m14912b) - 2;
                if (length2 > 0) {
                    byte[] bArr5 = new byte[length2];
                    this.f37413b = bArr5;
                    wrap.get(bArr5);
                    return;
                }
                return;
            }
            throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.f37412a + ", otherData=" + Arrays.toString(this.f37413b) + "]";
        }
    }

    /* renamed from: a */
    public static String m15050a(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] m15049a = m15049a(randomAccessFile);
            if (m15049a == null) {
                randomAccessFile.close();
                return null;
            }
            C13052a c13052a = new C13052a();
            c13052a.m15048a(m15049a);
            String property = c13052a.f37412a.getProperty(str);
            randomAccessFile.close();
            return property;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static String m15051a(File file) throws IOException {
        return m15050a(file, "channelNo");
    }

    /* renamed from: a */
    private static byte[] m15049a(RandomAccessFile randomAccessFile) throws IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] m14915a = f37410a.m14915a();
        int read = randomAccessFile.read();
        while (true) {
            z = true;
            if (read == -1) {
                z = false;
                break;
            } else if (read == m14915a[0] && randomAccessFile.read() == m14915a[1] && randomAccessFile.read() == m14915a[2] && randomAccessFile.read() == m14915a[3]) {
                break;
            } else {
                length--;
                randomAccessFile.seek(length);
                read = randomAccessFile.read();
            }
        }
        if (z) {
            randomAccessFile.seek(length + 16 + 4);
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            int m14912b = new C13073o(bArr).m14912b();
            if (m14912b == 0) {
                return null;
            }
            byte[] bArr2 = new byte[m14912b];
            randomAccessFile.read(bArr2);
            return bArr2;
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
