package com.kwad.sdk.pngencrypt.chunk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static final byte[] aLU = gi("IHDR");
    public static final byte[] aLV = gi("PLTE");
    public static final byte[] aLW = gi("IDAT");
    public static final byte[] aLX = gi("IEND");
    private static byte[] aLY = new byte[4096];
    public static Pattern aLZ = Pattern.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");

    public static List<PngChunk> a(List<PngChunk> list, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (PngChunk pngChunk : list) {
            if (cVar.a(pngChunk)) {
                arrayList.add(pngChunk);
            }
        }
        return arrayList;
    }

    public static byte[] b(byte[] bArr, int i4, int i5, boolean z3) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayInputStream byteArrayInputStream;
        InflaterInputStream inflaterInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr, i4, i5);
            try {
                InflaterInputStream inflaterInputStream2 = new InflaterInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        i(inflaterInputStream2, byteArrayOutputStream2);
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                        return byteArray;
                    } catch (Exception e4) {
                        e = e4;
                        inflaterInputStream = inflaterInputStream2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        try {
                            com.kwad.sdk.core.e.c.printStackTrace(e);
                            com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                            return new byte[0];
                        } catch (Throwable th) {
                            th = th;
                            com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inflaterInputStream = inflaterInputStream2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(inflaterInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream2 = null;
                }
            } catch (Exception e6) {
                e = e6;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            }
        } catch (Exception e7) {
            e = e7;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        }
    }

    public static String d(byte[] bArr, int i4, int i5) {
        return new String(bArr, i4, i5, com.kwad.sdk.pngencrypt.n.aLC);
    }

    public static String e(byte[] bArr, int i4, int i5) {
        return new String(bArr, i4, i5, com.kwad.sdk.pngencrypt.n.aLD);
    }

    public static byte[] gi(String str) {
        return str.getBytes(com.kwad.sdk.pngencrypt.n.aLC);
    }

    public static boolean gj(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    public static boolean gk(String str) {
        return Character.isUpperCase(str.charAt(1));
    }

    public static boolean gl(String str) {
        return !Character.isUpperCase(str.charAt(3));
    }

    public static String i(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.aLC);
    }

    public static String j(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.aLD);
    }

    private static void i(InputStream inputStream, OutputStream outputStream) {
        synchronized (aLY) {
            while (true) {
                int read = inputStream.read(aLY);
                if (read > 0) {
                    outputStream.write(aLY, 0, read);
                }
            }
        }
    }

    public static String i(byte[] bArr, int i4) {
        return (bArr == null || bArr.length < 8) ? "?" : d(bArr, 4, 4);
    }
}
