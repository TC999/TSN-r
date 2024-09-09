package cn.jiguang.ao;

import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.ah.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2346a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f2347b = new ConcurrentHashMap<>();

    public static String a(String str) {
        return new String(Base64.decode(str.getBytes(), 2));
    }

    public static String a(String str, boolean z3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] decode = Base64.decode(str, 2);
            if (z3) {
                decode = b(decode);
            }
            String str2 = a.C0049a.f2223l;
            return new String(cn.jiguang.ap.b.a(decode, str2, str2, false));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(long j4, long j5) {
        try {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            Long l4 = new Long(j4);
            Long l5 = new Long(j5);
            calendar.setTime(simpleDateFormat.parse(simpleDateFormat.format(l4)));
            calendar2.setTime(simpleDateFormat2.parse(simpleDateFormat2.format(l5)));
            return a(calendar, calendar2);
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean a(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            return true;
        }
        return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static byte[] a(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(byteArrayOutputStream);
            a(gZIPOutputStream);
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            a(byteArrayOutputStream);
            a(gZIPOutputStream2);
            throw th;
        }
    }

    public static String b(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    public static String b(String str, boolean z3) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (z3) {
                bytes = a(bytes);
            }
            String str2 = a.C0049a.f2223l;
            return Base64.encodeToString(cn.jiguang.ap.b.a(bytes, str2, str2, true), 2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static byte[] b(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } catch (Throwable th2) {
            gZIPInputStream = null;
            th = th2;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read < 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(byteArrayOutputStream);
                    a(byteArrayInputStream);
                    a(gZIPInputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (Throwable th3) {
            th = th3;
            a(byteArrayOutputStream);
            a(byteArrayInputStream);
            a(gZIPInputStream);
            throw th;
        }
    }
}
