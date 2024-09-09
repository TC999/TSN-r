package cn.jiguang.bz;

import android.content.Context;
import cn.jiguang.cn.f;
import cn.jiguang.cn.g;
import cn.jiguang.internal.JConstants;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Integer f3167a;

    public static int a() {
        Integer num = f3167a;
        if (num != null) {
            return num.intValue();
        }
        Integer valueOf = Integer.valueOf(Math.abs(new SecureRandom().nextInt()));
        f3167a = valueOf;
        return valueOf.intValue();
    }

    public static String a(Context context) {
        long f4 = cn.jiguang.d.a.f(context);
        return f4 > 0 ? g.a(f4) : g.a(a());
    }

    public static String a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.getShort()];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(int i4, byte b4, long j4, String str) {
        cn.jiguang.cc.b bVar = new cn.jiguang.cc.b(20480);
        bVar.b(i4);
        bVar.a((int) b4);
        bVar.b(j4);
        bVar.a(str);
        return bVar.b();
    }

    public static byte[] a(long j4, int i4, long j5, short s3, int i5) {
        cn.jiguang.cc.b bVar = new cn.jiguang.cc.b(20480);
        bVar.b(0);
        bVar.a(6);
        bVar.a(2);
        bVar.b(j4);
        bVar.a(i4);
        bVar.b(j5);
        bVar.a(s3);
        bVar.a(i5);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j4, long j5, String str, String str2, String str3, long j6, byte b4, int i4, String str4, String str5, String str6, String str7, int i5) {
        cn.jiguang.cc.b bVar = new cn.jiguang.cc.b(20480);
        bVar.b(0);
        bVar.a(24);
        bVar.a(1);
        bVar.b(j4);
        bVar.a(0L);
        bVar.b(j5);
        bVar.a(97);
        bVar.a(0);
        bVar.b(0);
        bVar.a(str);
        bVar.a(str3);
        bVar.a(str2);
        bVar.a(0);
        bVar.a(j6);
        bVar.a((int) b4);
        bVar.a(i4);
        bVar.a(str4);
        bVar.a(str5);
        bVar.a(str6);
        bVar.a(str7);
        bVar.a(i5);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j4, String str, String str2, String str3, String str4, long j5, String str5) {
        int a4 = a();
        cn.jiguang.cc.b bVar = new cn.jiguang.cc.b(20480);
        bVar.b(0);
        bVar.a(24);
        bVar.a(0);
        bVar.b(j4);
        bVar.a(a4);
        bVar.b(0L);
        bVar.a(str);
        bVar.a(str2);
        bVar.a(str3);
        bVar.a(0);
        bVar.a(str4);
        bVar.a(j5);
        bVar.a(str5);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }

    public static byte[] a(long j4, String str, long[] jArr) {
        cn.jiguang.cc.b bVar = new cn.jiguang.cc.b(20480);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", str);
            JSONArray jSONArray = new JSONArray();
            if (jArr != null) {
                jSONArray.put(j4);
                for (long j5 : jArr) {
                    jSONArray.put(j5);
                }
            }
            jSONObject.put("uids", jSONArray);
            cn.jiguang.bq.d.c("CorePackage", "attach uids:" + jSONArray.toString());
            bVar.a(jSONObject.toString());
            return bVar.b();
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("CorePackage", "packageAttachInfo:" + th);
            return null;
        }
    }

    public static byte[] a(Context context, int i4, int i5, long j4, byte[] bArr, long j5) {
        cn.jiguang.cc.b bVar = new cn.jiguang.cc.b(20480);
        bVar.b(0);
        bVar.a(i5);
        bVar.a(i4);
        bVar.b(j4);
        bVar.a(JConstants.tcpSessionId);
        if (j5 == 0) {
            j5 = cn.jiguang.d.a.f(context);
        }
        bVar.b(j5);
        bVar.a(bArr);
        bVar.b(bVar.a(), 0);
        return a(context, bVar.b());
    }

    public static byte[] a(Context context, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length - 24;
        byte[] bArr2 = new byte[24];
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, 24);
        System.arraycopy(bArr, 24, bArr3, 0, length);
        String a4 = a(context);
        try {
            byte b4 = JConstants.tcpAlgorithm;
            byte[] a5 = b4 == 2 ? new f().a(bArr3, a4) : g.a(bArr3, a4, a4.substring(0, 16), true);
            int length2 = a5.length + 24;
            byte[] bArr4 = new byte[length2];
            System.arraycopy(bArr2, 0, bArr4, 0, 24);
            System.arraycopy(a5, 0, bArr4, 24, a5.length);
            bArr4[0] = (byte) ((length2 >>> 8) & 255);
            bArr4[1] = (byte) (length2 & 255);
            bArr4[0] = (byte) (bArr4[0] | 128);
            bArr4[4] = b4;
            return bArr4;
        } catch (Exception e4) {
            cn.jiguang.bq.d.i("CorePackage", "e:" + e4);
            cn.jiguang.bq.d.j("CorePackage", "encrpt data failed");
            return null;
        }
    }

    public static byte[] a(String str, long[] jArr) {
        cn.jiguang.cc.b bVar = new cn.jiguang.cc.b(20480);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", str);
            JSONArray jSONArray = new JSONArray();
            if (jArr != null) {
                for (long j4 : jArr) {
                    jSONArray.put(j4);
                }
            }
            jSONObject.put("uids", jSONArray);
            bVar.a(jSONObject.toString());
            return bVar.b();
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("CorePackage", "packageDetachInfo:" + th);
            return null;
        }
    }

    public static byte[] a(short s3, short s4, String str) {
        cn.jiguang.cc.b bVar = new cn.jiguang.cc.b(20480);
        bVar.a((int) s3);
        bVar.a((int) s4);
        bVar.a(str);
        return bVar.b();
    }
}
