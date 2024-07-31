package com.kwad.sdk.core.p385a;

import com.kwad.sdk.crash.utils.C10738b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.kwad.sdk.core.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9885b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    /* renamed from: a */
    private static byte[] m27450a(byte[] bArr, byte[] bArr2, int i) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(i, secretKeySpec);
            return cipher.doFinal(bArr2);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    /* renamed from: d */
    public static byte[] m27449d(byte[] bArr, byte[] bArr2) {
        return m27450a(bArr, bArr2, 1);
    }

    /* renamed from: e */
    private static void m27448e(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    gZIPOutputStream.write(bArr, 0, read);
                } else {
                    gZIPOutputStream.finish();
                    gZIPOutputStream.flush();
                    C10738b.closeQuietly(gZIPOutputStream);
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            C10738b.closeQuietly(gZIPOutputStream2);
            throw th;
        }
    }

    /* renamed from: f */
    public static byte[] m27446f(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
            try {
                m27448e(byteArrayInputStream, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                C10738b.closeQuietly(byteArrayOutputStream);
                C10738b.closeQuietly(byteArrayInputStream);
                return byteArray;
            } catch (Throwable th3) {
                th = th3;
                C10738b.closeQuietly(byteArrayOutputStream);
                C10738b.closeQuietly(byteArrayInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    /* renamed from: g */
    public static byte[] m27445g(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
            try {
                m27447f(byteArrayInputStream, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                C10738b.closeQuietly(byteArrayOutputStream);
                C10738b.closeQuietly(byteArrayInputStream);
                return byteArray;
            } catch (Throwable th3) {
                th = th3;
                C10738b.closeQuietly(byteArrayOutputStream);
                C10738b.closeQuietly(byteArrayInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    /* renamed from: a */
    public static byte[] m27451a(String str, byte[] bArr) {
        return m27450a(str.getBytes(UTF_8), bArr, 2);
    }

    /* renamed from: f */
    private static void m27447f(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(inputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    C10738b.closeQuietly(gZIPInputStream);
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream2 = gZIPInputStream;
            C10738b.closeQuietly(gZIPInputStream2);
            throw th;
        }
    }
}
