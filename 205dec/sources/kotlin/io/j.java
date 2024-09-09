package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.y;
import kotlin.jvm.internal.f0;
import kotlin.text.x;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: FilePathComponents.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0000\u001a\u001c\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0000\"\u0018\u0010\f\u001a\u00020\u0000*\u00020\u00048@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0018\u0010\u000f\u001a\u00020\u0004*\u00020\u00048@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0015\u0010\u0013\u001a\u00020\u0010*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"", "", "b", "(Ljava/lang/String;)I", "Ljava/io/File;", "Lkotlin/io/g;", "f", "beginIndex", "endIndex", "e", "c", "(Ljava/io/File;)Ljava/lang/String;", "rootName", "a", "(Ljava/io/File;)Ljava/io/File;", "root", "", "d", "(Ljava/io/File;)Z", "isRooted", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/io/FilesKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class j {
    @NotNull
    public static final File a(@NotNull File file) {
        f0.p(file, "<this>");
        return new File(c(file));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        r0 = kotlin.text.x.q3(r8, r3, 2, false, 4, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int b(java.lang.String r8) {
        /*
            char r1 = java.io.File.separatorChar
            r2 = 0
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r8
            int r0 = kotlin.text.n.q3(r0, r1, r2, r3, r4, r5)
            r1 = 1
            if (r0 != 0) goto L3d
            int r0 = r8.length()
            if (r0 <= r1) goto L3c
            char r0 = r8.charAt(r1)
            char r3 = java.io.File.separatorChar
            if (r0 != r3) goto L3c
            r4 = 2
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r8
            int r0 = kotlin.text.n.q3(r2, r3, r4, r5, r6, r7)
            if (r0 < 0) goto L3c
            char r3 = java.io.File.separatorChar
            int r4 = r0 + 1
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r8
            int r0 = kotlin.text.n.q3(r2, r3, r4, r5, r6, r7)
            if (r0 < 0) goto L37
            int r0 = r0 + r1
            return r0
        L37:
            int r8 = r8.length()
            return r8
        L3c:
            return r1
        L3d:
            r2 = 58
            if (r0 <= 0) goto L4b
            int r3 = r0 + (-1)
            char r3 = r8.charAt(r3)
            if (r3 != r2) goto L4b
            int r0 = r0 + r1
            return r0
        L4b:
            r1 = -1
            r3 = 0
            if (r0 != r1) goto L5c
            r0 = 2
            r1 = 0
            boolean r0 = kotlin.text.n.a3(r8, r2, r3, r0, r1)
            if (r0 == 0) goto L5c
            int r8 = r8.length()
            return r8
        L5c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.j.b(java.lang.String):int");
    }

    @NotNull
    public static final String c(@NotNull File file) {
        f0.p(file, "<this>");
        String path = file.getPath();
        f0.o(path, "path");
        String path2 = file.getPath();
        f0.o(path2, "path");
        String substring = path.substring(0, b(path2));
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean d(@NotNull File file) {
        f0.p(file, "<this>");
        String path = file.getPath();
        f0.o(path, "path");
        return b(path) > 0;
    }

    @NotNull
    public static final File e(@NotNull File file, int i4, int i5) {
        f0.p(file, "<this>");
        return f(file).j(i4, i5);
    }

    @NotNull
    public static final g f(@NotNull File file) {
        List<String> S4;
        int Z;
        List list;
        f0.p(file, "<this>");
        String path = file.getPath();
        f0.o(path, "path");
        int b4 = b(path);
        String substring = path.substring(0, b4);
        f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        String substring2 = path.substring(b4);
        f0.o(substring2, "this as java.lang.String).substring(startIndex)");
        if (substring2.length() == 0) {
            list = CollectionsKt__CollectionsKt.F();
        } else {
            S4 = x.S4(substring2, new char[]{File.separatorChar}, false, 0, 6, null);
            Z = y.Z(S4, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (String str : S4) {
                arrayList.add(new File(str));
            }
            list = arrayList;
        }
        return new g(new File(substring), list);
    }
}
