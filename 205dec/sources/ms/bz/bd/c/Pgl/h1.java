package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f61394a = (String) pblk.a(16777217, 0, 0, "61b0dd", new byte[]{23, 33, 30, 71, 94, 96, 38, 31, 33});

    /* renamed from: b  reason: collision with root package name */
    private static final String f61395b = (String) pblk.a(16777217, 0, 0, "0238a2", new byte[]{9, 49, 82, 72, 73, 36, 33, 22});

    /* renamed from: c  reason: collision with root package name */
    private static final String f61396c = (String) pblk.a(16777217, 0, 0, "449ee7", new byte[]{3, 51, 75, 5, 79, 50, 50, 6});

    /* renamed from: d  reason: collision with root package name */
    private static final String f61397d = (String) pblk.a(16777217, 0, 0, "674c4f", new byte[]{55, 54});

    /* renamed from: e  reason: collision with root package name */
    private static final String f61398e = (String) pblk.a(16777217, 0, 0, "5803b8", new byte[]{44, 45});

    /* renamed from: f  reason: collision with root package name */
    private static final String f61399f = (String) pblk.a(16777217, 0, 0, "a30ebb", new byte[]{118, 37});

    /* renamed from: g  reason: collision with root package name */
    private static final String f61400g = (String) pblk.a(16777217, 0, 0, "9e6263", new byte[]{37, 102, 93});

    /* renamed from: h  reason: collision with root package name */
    private static final String f61401h = (String) pblk.a(16777217, 0, 0, "3c9b01", new byte[]{47, 104, 68});

    /* renamed from: i  reason: collision with root package name */
    private static final String f61402i = (String) pblk.a(16777217, 0, 0, "875dae", new byte[]{42, 58, 84, 21});

    /* renamed from: j  reason: collision with root package name */
    private static final FileFilter f61403j = new pgla();

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class pgla implements FileFilter {
        pgla() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches((String) pblk.a(16777217, 0, 0L, "651882", new byte[]{36, 39, 87, 119, 87, 104, 108, 41}), file.getName());
        }
    }

    public static String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, String> d4 = d();
            jSONObject.put(f61402i, e());
            jSONObject.put(f61397d, c(d4, f61394a));
            jSONObject.put(f61398e, c(d4, f61395b));
            jSONObject.put(f61400g, b((String) pblk.a(16777217, 0, 0L, "05d38f", new byte[]{110, 36, 14, 84, 72, 117, 54, 2, 60, 96, 36, 36, 88, 84, 30, 98, 39, 17, 56, 44, 34, 39, 2, 8, 4, 97, 38, 68, 122, 96, 49, 34, 17, 85, 2, 96, 124, 23, 37, 118, 40, 57, 17, 72, 56, 124, 50, 12, 10, 101, 51, 50, 6})));
            jSONObject.put(f61401h, b((String) pblk.a(16777217, 0, 0L, "be9b26", new byte[]{60, 116, 83, 5, 66, 37, 100, 82, 97, 49, 118, 116, 5, 5, 20, 50, 117, 65, 101, 125, 112, 119, 95, 89, 14, 49, 116, 20, 39, 49, 99, 114, 76, 4, 8, 48, 46, 71, 120, 39, 122, 105, 76, 25, 50, 44, 104, 74, 87, 52, 97, 98, 91})));
            jSONObject.put(f61399f, c(d4, f61396c));
        } catch (Throwable unused) {
        }
        String jSONObject2 = jSONObject.toString();
        return TextUtils.isEmpty(jSONObject2) ? (String) pblk.a(16777217, 0, 0L, "fa5682", new byte[]{108, 126}) : jSONObject2.trim();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
        if (r10 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(java.lang.String r10) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L39
            r3.<init>(r10)     // Catch: java.lang.Throwable -> L39
            boolean r10 = r3.exists()     // Catch: java.lang.Throwable -> L39
            if (r10 != 0) goto L23
            r4 = 16777217(0x1000001, float:2.350989E-38)
            r5 = 0
            r6 = 0
            java.lang.String r8 = "1c6a18"
            byte[] r9 = new byte[r1]     // Catch: java.lang.Throwable -> L39
            r10 = 112(0x70, float:1.57E-43)
            r9[r0] = r10     // Catch: java.lang.Throwable -> L39
            java.lang.Object r10 = ms.bz.bd.c.Pgl.pblk.a(r4, r5, r6, r8, r9)     // Catch: java.lang.Throwable -> L39
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L39
            return r10
        L23:
            java.io.FileReader r10 = new java.io.FileReader     // Catch: java.lang.Throwable -> L39
            r10.<init>(r3)     // Catch: java.lang.Throwable -> L39
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L37
            r3.<init>(r10)     // Catch: java.lang.Throwable -> L37
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L35
            r3.close()     // Catch: java.lang.Throwable -> L44
            goto L44
        L35:
            goto L3b
        L37:
            r3 = r2
            goto L3b
        L39:
            r10 = r2
            r3 = r10
        L3b:
            if (r3 == 0) goto L42
            r3.close()     // Catch: java.lang.Throwable -> L41
            goto L42
        L41:
        L42:
            if (r10 == 0) goto L49
        L44:
            r10.close()     // Catch: java.lang.Throwable -> L48
            goto L49
        L48:
        L49:
            if (r2 != 0) goto L60
            byte[] r8 = new byte[r1]
            r10 = 39
            r8[r0] = r10
            r3 = 16777217(0x1000001, float:2.350989E-38)
            r4 = 0
            r5 = 0
            java.lang.String r7 = "faa705"
            java.lang.Object r10 = ms.bz.bd.c.Pgl.pblk.a(r3, r4, r5, r7, r8)
            java.lang.String r10 = (java.lang.String) r10
            goto L64
        L60:
            java.lang.String r10 = r2.trim()
        L64:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.h1.b(java.lang.String):java.lang.String");
    }

    private static String c(HashMap<String, String> hashMap, String str) {
        String str2;
        try {
            str2 = hashMap.get(str);
        } catch (Throwable unused) {
            str2 = null;
        }
        return str2 == null ? "" : str2.trim();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00af, code lost:
        if (r2 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.HashMap<java.lang.String, java.lang.String> d() {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> La7
            r3 = 16777217(0x1000001, float:2.350989E-38)
            r4 = 0
            r5 = 0
            java.lang.String r7 = "5a07d0"
            r8 = 13
            byte[] r8 = new byte[r8]     // Catch: java.lang.Throwable -> La7
            r9 = 107(0x6b, float:1.5E-43)
            r10 = 0
            r8[r10] = r9     // Catch: java.lang.Throwable -> La7
            r9 = 115(0x73, float:1.61E-43)
            r11 = 1
            r8[r11] = r9     // Catch: java.lang.Throwable -> La7
            r9 = 81
            r12 = 2
            r8[r12] = r9     // Catch: java.lang.Throwable -> La7
            r9 = 3
            r13 = 76
            r8[r9] = r13     // Catch: java.lang.Throwable -> La7
            r9 = 4
            r14 = 88
            r8[r9] = r14     // Catch: java.lang.Throwable -> La7
            r9 = 5
            r14 = 104(0x68, float:1.46E-43)
            r8[r9] = r14     // Catch: java.lang.Throwable -> La7
            r9 = 6
            r14 = 53
            r8[r9] = r14     // Catch: java.lang.Throwable -> La7
            r9 = 7
            r14 = 80
            r8[r9] = r14     // Catch: java.lang.Throwable -> La7
            r9 = 8
            r14 = 116(0x74, float:1.63E-43)
            r8[r9] = r14     // Catch: java.lang.Throwable -> La7
            r9 = 9
            r14 = 110(0x6e, float:1.54E-43)
            r8[r9] = r14     // Catch: java.lang.Throwable -> La7
            r9 = 10
            r14 = 42
            r8[r9] = r14     // Catch: java.lang.Throwable -> La7
            r9 = 11
            r14 = 101(0x65, float:1.42E-43)
            r8[r9] = r14     // Catch: java.lang.Throwable -> La7
            r9 = 12
            r8[r9] = r13     // Catch: java.lang.Throwable -> La7
            java.lang.Object r3 = ms.bz.bd.c.Pgl.pblk.a(r3, r4, r5, r7, r8)     // Catch: java.lang.Throwable -> La7
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> La7
            r2.<init>(r3)     // Catch: java.lang.Throwable -> La7
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> La5
            r3.<init>(r2)     // Catch: java.lang.Throwable -> La5
        L66:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> La3
            if (r1 != 0) goto L70
            r3.close()     // Catch: java.lang.Throwable -> Lb1
            goto Lb1
        L70:
            r4 = 16777217(0x1000001, float:2.350989E-38)
            r5 = 0
            r6 = 0
            java.lang.String r8 = "d41aa2"
            byte[] r9 = new byte[r11]     // Catch: java.lang.Throwable -> La3
            r13 = 47
            r9[r10] = r13     // Catch: java.lang.Throwable -> La3
            java.lang.Object r4 = ms.bz.bd.c.Pgl.pblk.a(r4, r5, r6, r8, r9)     // Catch: java.lang.Throwable -> La3
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> La3
            java.lang.String[] r1 = r1.split(r4, r12)     // Catch: java.lang.Throwable -> La3
            int r4 = r1.length     // Catch: java.lang.Throwable -> La3
            if (r4 >= r12) goto L8c
            goto L66
        L8c:
            r4 = r1[r10]     // Catch: java.lang.Throwable -> La3
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Throwable -> La3
            r1 = r1[r11]     // Catch: java.lang.Throwable -> La3
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Throwable -> La3
            java.lang.Object r5 = r0.get(r4)     // Catch: java.lang.Throwable -> La3
            if (r5 == 0) goto L9f
            goto L66
        L9f:
            r0.put(r4, r1)     // Catch: java.lang.Throwable -> La3
            goto L66
        La3:
            r1 = r3
            goto La8
        La5:
            goto La8
        La7:
            r2 = r1
        La8:
            if (r1 == 0) goto Laf
            r1.close()     // Catch: java.lang.Throwable -> Lae
            goto Laf
        Lae:
        Laf:
            if (r2 == 0) goto Lb4
        Lb1:
            r2.close()     // Catch: java.lang.Throwable -> Lb4
        Lb4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.h1.d():java.util.HashMap");
    }

    private static int e() {
        try {
            return new File((String) pblk.a(16777217, 0, 0L, "3cb95a", new byte[]{109, 114, 8, 94, 69, 114, 53, 84, 58, 106, 39, 114, 94, 94, 19, 101, 36, 71, 62, 38, 33, 113, 4, 2})).listFiles(f61403j).length;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
