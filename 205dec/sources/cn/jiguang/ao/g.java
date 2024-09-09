package cn.jiguang.ao;

import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f2337a = {90, 65, 111, 105, 56, 125, 81, 78, 126, 38, 68, 100, 94, 84, 112, 101, 115};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f2338b = {118, 85, 84, 75, 125, 120, 101, 89, 77, 124};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f2339c = {116, 72, 69, 122};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f2340d = {39, 101, 104, 67, 84, 124, 101, 57, 115, 89, 78, 54, 123, 126};

    public static Process a(String[] strArr) {
        try {
            Class<?> cls = Class.forName(c.b(f2337a));
            Method declaredMethod = cls.getDeclaredMethod(c.b(f2338b), new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = cls.getDeclaredMethod(c.b(f2339c), String.class);
            declaredMethod2.setAccessible(true);
            return (Process) declaredMethod2.invoke(invoke, strArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008d, code lost:
        if (r5 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0132, code lost:
        if (r5 != null) goto L18;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ca A[Catch: IOException -> 0x00c6, DONT_GENERATE, TRY_LEAVE, TryCatch #7 {IOException -> 0x00c6, blocks: (B:47:0x00c2, B:51:0x00ca), top: B:93:0x00c2 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0118 A[Catch: IOException -> 0x0114, TRY_LEAVE, TryCatch #2 {IOException -> 0x0114, blocks: (B:61:0x0110, B:65:0x0118), top: B:87:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0, types: [int] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r13v14, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v20, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r13v21, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> a(java.lang.String[] r12, int r13) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ao.g.a(java.lang.String[], int):java.util.List");
    }
}
