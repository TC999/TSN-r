package com.bytedance.c.w.r;

import android.text.TextUtils;
import com.bytedance.c.w.b;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.pangle.sdk.component.log.impl.net.EventNetApiImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f26556a;

    /* renamed from: b  reason: collision with root package name */
    private static e f26557b;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum c {
        NONE(0),
        GZIP(1),
        DEFLATER(2);
        
        final int sr;

        c(int i4) {
            this.sr = i4;
        }
    }

    /* renamed from: com.bytedance.c.w.r.w$w  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum EnumC0374w {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);
        

        /* renamed from: r  reason: collision with root package name */
        final int f26563r;

        EnumC0374w(int i4) {
            this.f26563r = i4;
        }
    }

    public static b a(long j4, String str, byte[] bArr, c cVar, String str2, boolean z3) throws IOException {
        if (str == null) {
            return new b(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        String str3 = null;
        if (c.GZIP == cVar && length > 128) {
            bArr = l(bArr);
            str3 = "gzip";
        } else if (c.DEFLATER == cVar && length > 128) {
            bArr = i(bArr);
            str3 = "deflate";
        }
        String str4 = str3;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return new b(202);
        }
        if (z3) {
            byte[] a4 = TTEncryptUtils.a(bArr2, bArr2.length);
            if (a4 != null) {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    if (!str.endsWith("?")) {
                        str = str + "?";
                    }
                } else if (!str.endsWith("&")) {
                    str = str + "&";
                }
                str = str + "tt_data=a";
                str2 = EventNetApiImpl.CONTENT_TYPE_APPLICATION_STREAM;
                bArr2 = a4;
            }
            return e(str, bArr2, str2, str4, "POST", true, true);
        }
        return e(str, bArr2, str2, str4, "POST", true, false);
    }

    public static b b(d dVar) {
        if (dVar == null) {
            return new b(201);
        }
        try {
            return a(2097152L, dVar.a(), dVar.h(), c.GZIP, "application/json; charset=utf-8", dVar.f());
        } catch (Throwable th) {
            b.k.c(th);
            return new b(207, th);
        }
    }

    public static b c(String str, String str2) {
        return d(str, str2, g());
    }

    public static b d(String str, String str2, boolean z3) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return a(2097152L, str, str2.getBytes(), c.GZIP, "application/json; charset=utf-8", z3);
            }
            return new b(201);
        } catch (Throwable th) {
            b.k.c(th);
            return new b(207, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.bytedance.c.w.r.b e(java.lang.String r5, byte[] r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, boolean r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.c.w.r.w.e(java.lang.String, byte[], java.lang.String, java.lang.String, java.lang.String, boolean, boolean):com.bytedance.c.w.r.b");
    }

    public static String f(Map map) {
        return com.bytedance.c.w.d.j().e();
    }

    public static boolean g() {
        return true;
    }

    private static byte[] h(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    b.g.a(byteArrayOutputStream);
                }
            }
        }
    }

    private static byte[] i(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    public static String j(Map map) {
        return com.bytedance.c.w.d.j().f();
    }

    public static boolean k() {
        return true;
    }

    private static byte[] l(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                b.k.c(th);
                return null;
            } finally {
                gZIPOutputStream.close();
            }
        }
    }

    private static b m(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            String str = new String(bArr, Charset.forName("utf-8"));
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    return new b(0, jSONObject);
                }
                return new b(204, str);
            } catch (JSONException unused) {
                return new b(204, str);
            }
        }
        return new b(203);
    }
}
