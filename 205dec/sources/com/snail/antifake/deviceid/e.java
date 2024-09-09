package com.snail.antifake.deviceid;

import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ShellAdbUtils.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f48141a = "su";

    /* renamed from: b  reason: collision with root package name */
    public static final String f48142b = "sh";

    /* renamed from: c  reason: collision with root package name */
    public static final String f48143c = "exit\n";

    /* renamed from: d  reason: collision with root package name */
    public static final String f48144d = "\n";

    private e() {
        throw new AssertionError();
    }

    public static boolean a() {
        return c("echo root", true, false).f48145a == 0;
    }

    public static a b(String str, boolean z3) {
        return g(new String[]{str}, z3, true);
    }

    public static a c(String str, boolean z3, boolean z4) {
        return g(new String[]{str}, z3, z4);
    }

    public static a d(List<String> list, boolean z3) {
        return g(list == null ? null : (String[]) list.toArray(new String[0]), z3, true);
    }

    public static a e(List<String> list, boolean z3, boolean z4) {
        return g(list == null ? null : (String[]) list.toArray(new String[0]), z3, z4);
    }

    public static a f(String[] strArr, boolean z3) {
        return g(strArr, z3, true);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:6|7|(1:9)(1:161)|10|12|13|14|15|(3:17|(2:19|20)(2:22|23)|21)|24|25|(19:47|48|49|50|51|52|54|55|(3:56|57|(1:59)(1:60))|(2:61|(1:63)(0))|29|(1:31)|(1:33)|35|36|(1:38)(1:44)|(1:40)|41|42)(1:27)|28|29|(0)|(0)|35|36|(0)(0)|(0)|41|42) */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x014b, code lost:
        if (r10 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x016f, code lost:
        if (r10 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0171, code lost:
        r10.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0174, code lost:
        r8 = r9;
        r10 = r1;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f7, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f8, code lost:
        r2.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0144 A[Catch: IOException -> 0x013b, TRY_LEAVE, TryCatch #7 {IOException -> 0x013b, blocks: (B:95:0x0137, B:99:0x013f, B:101:0x0144), top: B:152:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0163 A[Catch: IOException -> 0x015f, TryCatch #21 {IOException -> 0x015f, blocks: (B:112:0x015b, B:116:0x0163, B:118:0x0168), top: B:161:0x015b }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0168 A[Catch: IOException -> 0x015f, TRY_LEAVE, TryCatch #21 {IOException -> 0x015f, blocks: (B:112:0x015b, B:116:0x0163, B:118:0x0168), top: B:161:0x015b }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019b A[Catch: IOException -> 0x0197, TryCatch #9 {IOException -> 0x0197, blocks: (B:136:0x0193, B:140:0x019b, B:142:0x01a0), top: B:156:0x0193 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a0 A[Catch: IOException -> 0x0197, TRY_LEAVE, TryCatch #9 {IOException -> 0x0197, blocks: (B:136:0x0193, B:140:0x019b, B:142:0x01a0), top: B:156:0x0193 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x015b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ee A[Catch: IOException -> 0x00f7, TryCatch #0 {IOException -> 0x00f7, blocks: (B:64:0x00e9, B:66:0x00ee, B:68:0x00f3), top: B:150:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f3 A[Catch: IOException -> 0x00f7, TRY_LEAVE, TryCatch #0 {IOException -> 0x00f7, blocks: (B:64:0x00e9, B:66:0x00ee, B:68:0x00f3), top: B:150:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013f A[Catch: IOException -> 0x013b, TryCatch #7 {IOException -> 0x013b, blocks: (B:95:0x0137, B:99:0x013f, B:101:0x0144), top: B:152:0x0137 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v24, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.snail.antifake.deviceid.e.a g(java.lang.String[] r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.snail.antifake.deviceid.e.g(java.lang.String[], boolean, boolean):com.snail.antifake.deviceid.e$a");
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ShellAdbUtils.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f48145a;

        /* renamed from: b  reason: collision with root package name */
        public String f48146b;

        /* renamed from: c  reason: collision with root package name */
        public String f48147c;

        public a(int i4) {
            this.f48145a = i4;
        }

        public a(int i4, String str, String str2) {
            this.f48145a = i4;
            this.f48146b = str;
            this.f48147c = str2;
        }
    }
}
