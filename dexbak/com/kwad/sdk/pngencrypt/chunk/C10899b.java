package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.pngencrypt.C10936n;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;

/* renamed from: com.kwad.sdk.pngencrypt.chunk.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10899b {
    public static final byte[] aLU = m24497gi("IHDR");
    public static final byte[] aLV = m24497gi("PLTE");
    public static final byte[] aLW = m24497gi("IDAT");
    public static final byte[] aLX = m24497gi("IEND");
    private static byte[] aLY = new byte[4096];
    public static Pattern aLZ = Pattern.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");

    /* renamed from: a */
    public static List<PngChunk> m24501a(List<PngChunk> list, InterfaceC10900c interfaceC10900c) {
        ArrayList arrayList = new ArrayList();
        for (PngChunk pngChunk : list) {
            if (interfaceC10900c.mo24479a(pngChunk)) {
                arrayList.add(pngChunk);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static byte[] m24500b(byte[] bArr, int i, int i2, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayInputStream byteArrayInputStream;
        InflaterInputStream inflaterInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            try {
                InflaterInputStream inflaterInputStream2 = new InflaterInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        m24493i(inflaterInputStream2, byteArrayOutputStream2);
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        C10738b.closeQuietly(inflaterInputStream2);
                        C10738b.closeQuietly(byteArrayInputStream);
                        C10738b.closeQuietly(byteArrayOutputStream2);
                        C10738b.closeQuietly(byteArrayOutputStream2);
                        return byteArray;
                    } catch (Exception e) {
                        e = e;
                        inflaterInputStream = inflaterInputStream2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        try {
                            C10331c.printStackTrace(e);
                            C10738b.closeQuietly(inflaterInputStream);
                            C10738b.closeQuietly(byteArrayInputStream);
                            C10738b.closeQuietly(byteArrayOutputStream2);
                            C10738b.closeQuietly(byteArrayOutputStream);
                            return new byte[0];
                        } catch (Throwable th) {
                            th = th;
                            C10738b.closeQuietly(inflaterInputStream);
                            C10738b.closeQuietly(byteArrayInputStream);
                            C10738b.closeQuietly(byteArrayOutputStream2);
                            C10738b.closeQuietly(byteArrayOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inflaterInputStream = inflaterInputStream2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        C10738b.closeQuietly(inflaterInputStream);
                        C10738b.closeQuietly(byteArrayInputStream);
                        C10738b.closeQuietly(byteArrayOutputStream2);
                        C10738b.closeQuietly(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream2 = null;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            }
        } catch (Exception e4) {
            e = e4;
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

    /* renamed from: d */
    public static String m24499d(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, C10936n.aLC);
    }

    /* renamed from: e */
    public static String m24498e(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, C10936n.aLD);
    }

    /* renamed from: gi */
    public static byte[] m24497gi(String str) {
        return str.getBytes(C10936n.aLC);
    }

    /* renamed from: gj */
    public static boolean m24496gj(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    /* renamed from: gk */
    public static boolean m24495gk(String str) {
        return Character.isUpperCase(str.charAt(1));
    }

    /* renamed from: gl */
    public static boolean m24494gl(String str) {
        return !Character.isUpperCase(str.charAt(3));
    }

    /* renamed from: i */
    public static String m24492i(byte[] bArr) {
        return new String(bArr, C10936n.aLC);
    }

    /* renamed from: j */
    public static String m24490j(byte[] bArr) {
        return new String(bArr, C10936n.aLD);
    }

    /* renamed from: i */
    private static void m24493i(InputStream inputStream, OutputStream outputStream) {
        synchronized (aLY) {
            while (true) {
                int read = inputStream.read(aLY);
                if (read > 0) {
                    outputStream.write(aLY, 0, read);
                }
            }
        }
    }

    /* renamed from: i */
    public static String m24491i(byte[] bArr, int i) {
        return (bArr == null || bArr.length < 8) ? "?" : m24499d(bArr, 4, 4);
    }
}
