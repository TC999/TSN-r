package com.snail.antifake.deviceid;

import java.util.List;

/* renamed from: com.snail.antifake.deviceid.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ShellAdbUtils {

    /* renamed from: a */
    public static final String f33807a = "su";

    /* renamed from: b */
    public static final String f33808b = "sh";

    /* renamed from: c */
    public static final String f33809c = "exit\n";

    /* renamed from: d */
    public static final String f33810d = "\n";

    private ShellAdbUtils() {
        throw new AssertionError();
    }

    /* renamed from: a */
    public static boolean m19678a() {
        return m19676c("echo root", true, false).f33811a == 0;
    }

    /* renamed from: b */
    public static C11947a m19677b(String str, boolean z) {
        return m19672g(new String[]{str}, z, true);
    }

    /* renamed from: c */
    public static C11947a m19676c(String str, boolean z, boolean z2) {
        return m19672g(new String[]{str}, z, z2);
    }

    /* renamed from: d */
    public static C11947a m19675d(List<String> list, boolean z) {
        return m19672g(list == null ? null : (String[]) list.toArray(new String[0]), z, true);
    }

    /* renamed from: e */
    public static C11947a m19674e(List<String> list, boolean z, boolean z2) {
        return m19672g(list == null ? null : (String[]) list.toArray(new String[0]), z, z2);
    }

    /* renamed from: f */
    public static C11947a m19673f(String[] strArr, boolean z) {
        return m19672g(strArr, z, true);
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
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.snail.antifake.deviceid.ShellAdbUtils.C11947a m19672g(java.lang.String[] r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.snail.antifake.deviceid.ShellAdbUtils.m19672g(java.lang.String[], boolean, boolean):com.snail.antifake.deviceid.e$a");
    }

    /* compiled from: ShellAdbUtils.java */
    /* renamed from: com.snail.antifake.deviceid.e$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C11947a {

        /* renamed from: a */
        public int f33811a;

        /* renamed from: b */
        public String f33812b;

        /* renamed from: c */
        public String f33813c;

        public C11947a(int i) {
            this.f33811a = i;
        }

        public C11947a(int i, String str, String str2) {
            this.f33811a = i;
            this.f33812b = str;
            this.f33813c = str2;
        }
    }
}
