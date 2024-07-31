package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.col.p047s.C2073i1;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.UByte;
import org.json.JSONObject;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Utils.java */
/* renamed from: com.amap.api.col.s.j1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2079j1 {

    /* renamed from: a */
    private static final String[] f6219a = {"arm64-v8a", "x86_64"};

    /* renamed from: b */
    private static final String[] f6220b = {"arm", DeviceUtils.f47125a};

    /* renamed from: c */
    static String f6221c;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append("=");
        }
        f6221c = sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: A */
    public static String m52881A(byte[] bArr) {
        try {
            return m52878D(bArr);
        } catch (Throwable th) {
            C2041d2.m53085e(th, "ut", "h2s");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: B */
    public static String m52880B(byte[] bArr) {
        try {
            return m52878D(bArr);
        } catch (Throwable th) {
            C2041d2.m53085e(th, "ut", "csb2h");
            return null;
        }
    }

    /* renamed from: C */
    private static void m52879C(String str) {
        int i;
        while (true) {
            if (str.length() < 78) {
                break;
            }
            String substring = str.substring(0, 78);
            Log.i("authErrLog", "|" + substring + "|");
            str = str.substring(78);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        sb.append(str);
        for (i = 0; i < 78 - str.length(); i++) {
            sb.append(" ");
        }
        sb.append("|");
        Log.i("authErrLog", sb.toString());
    }

    /* renamed from: D */
    public static String m52878D(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UByte.f41242c);
            if (hexString.length() == 1) {
                hexString = "0".concat(hexString);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: E */
    private static byte[] m52877E(byte[] bArr) throws IOException, Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream2 = gZIPOutputStream;
            try {
                throw th;
            } catch (Throwable th4) {
                if (gZIPOutputStream2 != null) {
                    gZIPOutputStream2.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th4;
            }
        }
    }

    /* renamed from: a */
    public static C2073i1 m52876a() throws C2022bv {
        return new C2073i1.C2074a("collection", "1.0", "AMap_collection_1.0").m52910c(new String[]{"com.amap.api.collection"}).m52909d();
    }

    /* renamed from: b */
    public static String m52875b(long j) {
        return m52874c(j, "yyyyMMdd HH:mm:ss:SSS");
    }

    /* renamed from: c */
    public static String m52874c(long j, String str) {
        try {
            return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            C2041d2.m53085e(th, "ut", "ctt");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m52873d(android.content.Context r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            java.lang.String r2 = "ut"
            r3 = 28
            r4 = 21
            if (r0 < r4) goto L31
            if (r0 >= r3) goto L31
            android.content.pm.ApplicationInfo r0 = r7.getApplicationInfo()     // Catch: java.lang.Throwable -> L2b
            java.lang.Class<android.content.pm.ApplicationInfo> r4 = android.content.pm.ApplicationInfo.class
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L2b
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r5 = "primaryCpuAbi"
            java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch: java.lang.Throwable -> L2b
            r4.setAccessible(r1)     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r0 = r4.get(r0)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L2b
            goto L33
        L2b:
            r0 = move-exception
            java.lang.String r4 = "gct"
            com.amap.api.col.p047s.C2041d2.m53085e(r0, r2, r4)
        L31:
            java.lang.String r0 = ""
        L33:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r3) goto La0
            java.lang.Class<android.os.Build> r3 = android.os.Build.class
            java.lang.String r4 = "SUPPORTED_ABIS"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch: java.lang.Throwable -> L9a
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L9a
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch: java.lang.Throwable -> L9a
            r5 = 0
            if (r3 == 0) goto L4e
            int r6 = r3.length     // Catch: java.lang.Throwable -> L9a
            if (r6 <= 0) goto L4e
            r0 = r3[r5]     // Catch: java.lang.Throwable -> L9a
        L4e:
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L9a
            if (r3 != 0) goto La0
            java.lang.String[] r3 = com.amap.api.col.p047s.C2079j1.f6219a     // Catch: java.lang.Throwable -> L9a
            java.util.List r3 = java.util.Arrays.asList(r3)     // Catch: java.lang.Throwable -> L9a
            boolean r3 = r3.contains(r0)     // Catch: java.lang.Throwable -> L9a
            if (r3 == 0) goto La0
            android.content.pm.ApplicationInfo r7 = r7.getApplicationInfo()     // Catch: java.lang.Throwable -> L9a
            java.lang.String r7 = r7.nativeLibraryDir     // Catch: java.lang.Throwable -> L9a
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L9a
            if (r3 != 0) goto La0
            java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Throwable -> L9a
            int r3 = r7.lastIndexOf(r3)     // Catch: java.lang.Throwable -> L9a
            int r3 = r3 + r1
            java.lang.String r7 = r7.substring(r3)     // Catch: java.lang.Throwable -> L9a
            java.lang.String[] r1 = com.amap.api.col.p047s.C2079j1.f6220b     // Catch: java.lang.Throwable -> L9a
            java.util.List r1 = java.util.Arrays.asList(r1)     // Catch: java.lang.Throwable -> L9a
            boolean r7 = r1.contains(r7)     // Catch: java.lang.Throwable -> L9a
            if (r7 == 0) goto La0
            java.lang.Class<android.os.Build> r7 = android.os.Build.class
            java.lang.String r1 = "SUPPORTED_32_BIT_ABIS"
            java.lang.reflect.Field r7 = r7.getDeclaredField(r1)     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Throwable -> L9a
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch: java.lang.Throwable -> L9a
            if (r7 == 0) goto La0
            int r1 = r7.length     // Catch: java.lang.Throwable -> L9a
            if (r1 <= 0) goto La0
            r7 = r7[r5]     // Catch: java.lang.Throwable -> L9a
            r0 = r7
            goto La0
        L9a:
            r7 = move-exception
            java.lang.String r1 = "gct_p"
            com.amap.api.col.p047s.C2041d2.m53085e(r7, r2, r1)
        La0:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 == 0) goto La8
            java.lang.String r0 = android.os.Build.CPU_ABI
        La8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p047s.C2079j1.m52873d(android.content.Context):java.lang.String");
    }

    /* renamed from: e */
    public static String m52872e(Throwable th) {
        StringWriter stringWriter;
        PrintWriter printWriter;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
            } catch (Throwable th2) {
                th = th2;
                printWriter = null;
            }
        } catch (Throwable th3) {
            th = th3;
            stringWriter = null;
            printWriter = null;
        }
        try {
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            String obj = stringWriter.toString();
            try {
                stringWriter.close();
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            try {
                printWriter.close();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            return obj;
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                return null;
            } finally {
                if (stringWriter != null) {
                    try {
                        stringWriter.close();
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                    }
                }
                if (printWriter != null) {
                    try {
                        printWriter.close();
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: f */
    public static String m52871f(Map<String, String> map) {
        if (map.size() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (z) {
                    z = false;
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(entry.getValue());
                } else {
                    stringBuffer.append("&");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(entry.getValue());
                }
            }
        } catch (Throwable th) {
            C2041d2.m53085e(th, "ut", "abP");
        }
        return stringBuffer.toString();
    }

    /* renamed from: g */
    public static String m52870g(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    /* renamed from: h */
    public static Calendar m52869h(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.CHINA);
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(simpleDateFormat.parse(str));
            calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), calendar2.get(11), calendar2.get(12), calendar2.get(13));
            return calendar;
        } catch (ParseException e) {
            C2041d2.m53085e(e, "ut", "ctt");
            return null;
        }
    }

    /* renamed from: i */
    public static void m52868i(Context context, String str, String str2, JSONObject jSONObject) {
        String str3;
        String str4;
        String str5;
        String str6;
        str3 = "";
        String m52328h = C2199x0.m52328h(context);
        String m52992a = C2059g1.m52992a(m52328h);
        String m52335a = C2199x0.m52335a(context);
        try {
            if (jSONObject.has("info")) {
                str5 = jSONObject.getString("info");
                str6 = "请在高德开放平台官网中搜索\"" + str5 + "\"相关内容进行解决";
            } else {
                str5 = "";
                str6 = str5;
            }
        } catch (Throwable unused) {
        }
        try {
        } catch (Throwable unused2) {
            str3 = str6;
            str4 = str3;
            Log.i("authErrLog", f6221c);
            Log.i("authErrLog", "                                   鉴权错误信息                                  ");
            Log.i("authErrLog", f6221c);
            m52879C("SHA1Package:".concat(String.valueOf(m52328h)));
            m52879C("key:".concat(String.valueOf(m52335a)));
            m52879C("csid:".concat(String.valueOf(str)));
            m52879C("gsid:".concat(String.valueOf(str2)));
            m52879C("json:" + jSONObject.toString());
            Log.i("authErrLog", "                                                                               ");
            Log.i("authErrLog", str4);
            Log.i("authErrLog", f6221c);
        }
        if ("INVALID_USER_SCODE".equals(str5)) {
            String string = jSONObject.has("sec_code") ? jSONObject.getString("sec_code") : "";
            str3 = jSONObject.has("sec_code_debug") ? jSONObject.getString("sec_code_debug") : "";
            if (m52992a.equals(string) || m52992a.equals(str3)) {
                str4 = m52857t("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5Lit5pCc57Si") + "\"请求内容过长导致业务调用失败\"相关内容进行解决";
                Log.i("authErrLog", f6221c);
                Log.i("authErrLog", "                                   鉴权错误信息                                  ");
                Log.i("authErrLog", f6221c);
                m52879C("SHA1Package:".concat(String.valueOf(m52328h)));
                m52879C("key:".concat(String.valueOf(m52335a)));
                m52879C("csid:".concat(String.valueOf(str)));
                m52879C("gsid:".concat(String.valueOf(str2)));
                m52879C("json:" + jSONObject.toString());
                Log.i("authErrLog", "                                                                               ");
                Log.i("authErrLog", str4);
                Log.i("authErrLog", f6221c);
            }
        } else if ("INVALID_USER_KEY".equals(str5)) {
            str3 = jSONObject.has(DomainCampaignEx.LOOPBACK_KEY) ? jSONObject.getString(DomainCampaignEx.LOOPBACK_KEY) : "";
            if (str3.length() > 0 && !m52335a.equals(str3)) {
                str6 = m52857t("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5LiK5Y+R6LW35oqA5pyv5ZKo6K+i5bel5Y2V4oCUPui0puWPt+S4jktleemXrumimO+8jOWSqOivoklOVkFMSURfVVNFUl9LRVnlpoLkvZXop6PlhrM=");
            }
        }
        str4 = str6;
        Log.i("authErrLog", f6221c);
        Log.i("authErrLog", "                                   鉴权错误信息                                  ");
        Log.i("authErrLog", f6221c);
        m52879C("SHA1Package:".concat(String.valueOf(m52328h)));
        m52879C("key:".concat(String.valueOf(m52335a)));
        m52879C("csid:".concat(String.valueOf(str)));
        m52879C("gsid:".concat(String.valueOf(str2)));
        m52879C("json:" + jSONObject.toString());
        Log.i("authErrLog", "                                                                               ");
        Log.i("authErrLog", str4);
        Log.i("authErrLog", f6221c);
    }

    /* renamed from: j */
    public static void m52867j(ByteArrayOutputStream byteArrayOutputStream, byte b, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b});
            int i = b & UByte.f41242c;
            if (i < 255 && i > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (i == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e) {
            C2041d2.m53085e(e, "ut", "wFie");
        }
    }

    /* renamed from: k */
    public static void m52866k(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
                return;
            } catch (IOException e) {
                C2041d2.m53085e(e, "ut", "wsf");
                return;
            }
        }
        int length = str.length();
        if (length > 255) {
            length = 255;
        }
        m52867j(byteArrayOutputStream, (byte) length, m52862o(str));
    }

    /* renamed from: l */
    public static boolean m52865l(Context context, String str) {
        if (context != null && context.checkCallingOrSelfPermission(str) == 0) {
            if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
                try {
                    if (((Integer) context.getClass().getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                        return false;
                    }
                } catch (Throwable th) {
                    C2041d2.m53085e(th, "ut", "cpm");
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: m */
    public static boolean m52864m(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    /* renamed from: n */
    public static byte[] m52863n(int i) {
        return new byte[]{(byte) (i / 256), (byte) (i % 256)};
    }

    /* renamed from: o */
    public static byte[] m52862o(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    /* renamed from: p */
    public static C2073i1 m52861p() throws C2022bv {
        return new C2073i1.C2074a("co", "1.0.0", "AMap_co_1.0.0").m52910c(new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}).m52909d();
    }

    /* renamed from: q */
    public static String m52860q(String str) {
        if (str == null) {
            return null;
        }
        String m53088i = C2040d1.m53088i(m52862o(str));
        try {
            return ((char) ((m53088i.length() % 26) + 65)) + m53088i;
        } catch (Throwable th) {
            C2041d2.m53085e(th, "ut", "tsfb64");
            return "";
        }
    }

    /* renamed from: r */
    public static String m52859r(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return m52851z(sb.toString());
    }

    /* renamed from: s */
    public static byte[] m52858s(byte[] bArr) {
        try {
            return m52877E(bArr);
        } catch (Throwable th) {
            C2041d2.m53085e(th, "ut", "gZp");
            return new byte[0];
        }
    }

    /* renamed from: t */
    public static String m52857t(String str) {
        return str.length() < 2 ? "" : C2040d1.m53096a(str.substring(1));
    }

    /* renamed from: u */
    public static byte[] m52856u() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
            byte[] bArr = new byte[split.length];
            for (int i = 0; i < split.length; i++) {
                bArr[i] = Byte.parseByte(split[i]);
            }
            String[] split2 = new StringBuffer(new String(C2040d1.m53090g(new String(bArr)))).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                bArr2[i2] = Byte.parseByte(split2[i2]);
            }
            return bArr2;
        } catch (Throwable th) {
            C2041d2.m53085e(th, "ut", "gIV");
            return new byte[16];
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003c -> B:58:0x005c). Please submit an issue!!! */
    /* renamed from: v */
    public static byte[] m52855v(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ZipOutputStream zipOutputStream;
        byte[] bArr2 = null;
        if (bArr != null) {
            try {
            } catch (Throwable th) {
                C2041d2.m53085e(th, "ut", "zp2");
            }
            if (bArr.length != 0) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        zipOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    zipOutputStream = null;
                }
                try {
                    zipOutputStream.putNextEntry(new ZipEntry("log"));
                    zipOutputStream.write(bArr);
                    zipOutputStream.closeEntry();
                    zipOutputStream.finish();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    try {
                        zipOutputStream.close();
                    } catch (Throwable th4) {
                        C2041d2.m53085e(th4, "ut", "zp1");
                    }
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        C2041d2.m53085e(th, "ut", "zp");
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (Throwable th6) {
                                C2041d2.m53085e(th6, "ut", "zp1");
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return bArr2;
                    } catch (Throwable th7) {
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (Throwable th8) {
                                C2041d2.m53085e(th8, "ut", "zp1");
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th9) {
                                C2041d2.m53085e(th9, "ut", "zp2");
                            }
                        }
                        throw th7;
                    }
                }
                return bArr2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public static PublicKey m52854w() throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(C2040d1.m53090g("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance(m52857t("IWC41MDk"));
                KeyFactory keyFactory = KeyFactory.getInstance(m52857t("EUlNB"));
                Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
                if (generateCertificate != null && keyFactory != null) {
                    PublicKey generatePublic = keyFactory.generatePublic(new X509EncodedKeySpec(generateCertificate.getPublicKey().getEncoded()));
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    return generatePublic;
                }
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return null;
            } catch (Throwable unused) {
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable unused2) {
            byteArrayInputStream = null;
        }
    }

    /* renamed from: x */
    public static byte[] m52853x(String str) {
        if (str.length() % 2 != 0) {
            str = "0".concat(str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    /* renamed from: y */
    public static byte[] m52852y(byte[] bArr) {
        try {
            return m52877E(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    /* renamed from: z */
    private static String m52851z(String str) {
        try {
        } catch (Throwable th) {
            C2041d2.m53085e(th, "ut", "sPa");
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(str2);
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
        }
        return str;
    }
}
