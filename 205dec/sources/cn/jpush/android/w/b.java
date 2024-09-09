package cn.jpush.android.w;

import android.content.Context;
import cn.jpush.android.ad.m;
import java.io.InputStream;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4480a = cn.jpush.android.ad.d.b(new byte[]{32, 0, 14, 41, 38, 38, 63, 1, 23, 43});

    /* renamed from: b  reason: collision with root package name */
    private static final String f4481b = cn.jpush.android.ad.d.b(new byte[]{62, 82, 38, 113, 19, 93, 73, 85, 84, 2, 23, 92, 58, 34, 40, 115, 19, 47, 78, 84, 32, 3, 19, 40, 57, 83, 32, 114, 23, 93, 49, 82});

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, String> f4482c = new HashMap<>();

    /* JADX WARN: Removed duplicated region for block: B:64:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r18, java.lang.String r19, java.lang.String r20, int r21, long r22) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.w.b.a(android.content.Context, java.lang.String, java.lang.String, int, long):java.lang.String");
    }

    public static String a(String str) {
        HashMap<String, String> hashMap = f4482c;
        if (hashMap == null || hashMap.size() <= 0 || !f4482c.containsKey(str)) {
            return null;
        }
        return f4482c.get(str);
    }

    public static byte[] a(Context context, String str, String str2, int i4, int i5) {
        return a(context, str, str2, i4, i5, false);
    }

    public static byte[] a(Context context, String str, String str2, int i4, int i5, boolean z3) {
        byte[] bArr = null;
        for (int i6 = 0; i6 < i4; i6++) {
            bArr = a(context, str, str2, i5, z3);
            if (bArr != null) {
                break;
            }
        }
        return bArr;
    }

    public static byte[] a(Context context, String str, String str2, int i4, long j4, int i5) {
        byte[] bArr = null;
        for (int i6 = 0; i6 < i5; i6++) {
            bArr = b(context, str, str2, i4, j4);
            if (bArr != null) {
                break;
            }
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0150, code lost:
        if (r8 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0152, code lost:
        r8.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0173, code lost:
        if (r8 == null) goto L55;
     */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0163: IF  (r12 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:80:0x0168, block:B:78:0x0163 */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014d A[Catch: all -> 0x0176, TRY_ENTER, TryCatch #10 {all -> 0x0176, blocks: (B:57:0x0120, B:58:0x0123, B:69:0x014d, B:71:0x0152, B:84:0x0170), top: B:99:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015a A[Catch: all -> 0x0162, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0162, blocks: (B:67:0x0133, B:75:0x015a), top: B:94:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0170 A[Catch: all -> 0x0176, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x0176, blocks: (B:57:0x0120, B:58:0x0123, B:69:0x014d, B:71:0x0152, B:84:0x0170), top: B:99:0x0044 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] a(android.content.Context r14, java.lang.String r15, java.lang.String r16, int r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.w.b.a(android.content.Context, java.lang.String, java.lang.String, int, boolean):byte[]");
    }

    public static byte[] a(InputStream inputStream) {
        return m.b(inputStream);
    }

    public static void b(String str) {
        try {
            HashMap<String, String> hashMap = f4482c;
            if (hashMap != null) {
                hashMap.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a4, code lost:
        if (r6 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a6, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ea, code lost:
        if (r11 == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ec, code lost:
        r11.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01b3, code lost:
        if (r11 == null) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:127:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(android.content.Context r15, java.lang.String r16, java.lang.String r17, int r18, long r19) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.w.b.b(android.content.Context, java.lang.String, java.lang.String, int, long):byte[]");
    }
}
