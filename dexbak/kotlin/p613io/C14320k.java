package kotlin.p613io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.C14236x;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.C14579x;
import org.jetbrains.annotations.NotNull;

/* compiled from: FilePathComponents.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0000\u001a\u001c\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0000\"\u0018\u0010\f\u001a\u00020\u0000*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0018\u0010\u000f\u001a\u00020\u0004*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0015\u0010\u0013\u001a\u00020\u0010*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, m12616d2 = {"", "", "b", "(Ljava/lang/String;)I", "Ljava/io/File;", "Lkotlin/io/g;", "f", "beginIndex", "endIndex", "e", "c", "(Ljava/io/File;)Ljava/lang/String;", "rootName", "a", "(Ljava/io/File;)Ljava/io/File;", "root", "", "d", "(Ljava/io/File;)Z", "isRooted", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/io/FilesKt")
/* renamed from: kotlin.io.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C14320k {
    @NotNull
    /* renamed from: a */
    public static final File m8441a(@NotNull File root) {
        C14342f0.m8184p(root, "$this$root");
        return new File(m8439c(root));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        r0 = kotlin.text.C14579x.m6401q3(r8, r3, 2, false, 4, null);
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int m8440b(java.lang.String r8) {
        /*
            char r1 = java.io.File.separatorChar
            r2 = 0
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r8
            int r0 = kotlin.text.C14573n.m6748q3(r0, r1, r2, r3, r4, r5)
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
            int r0 = kotlin.text.C14573n.m6748q3(r2, r3, r4, r5, r6, r7)
            if (r0 < 0) goto L3c
            char r3 = java.io.File.separatorChar
            int r4 = r0 + 1
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r8
            int r0 = kotlin.text.C14573n.m6748q3(r2, r3, r4, r5, r6, r7)
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
            boolean r0 = kotlin.text.C14573n.m6764a3(r8, r2, r3, r0, r1)
            if (r0 == 0) goto L5c
            int r8 = r8.length()
            return r8
        L5c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p613io.C14320k.m8440b(java.lang.String):int");
    }

    @NotNull
    /* renamed from: c */
    public static final String m8439c(@NotNull File rootName) {
        C14342f0.m8184p(rootName, "$this$rootName");
        String path = rootName.getPath();
        C14342f0.m8185o(path, "path");
        String path2 = rootName.getPath();
        C14342f0.m8185o(path2, "path");
        int m8440b = m8440b(path2);
        if (path != null) {
            String substring = path.substring(0, m8440b);
            C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: d */
    public static final boolean m8438d(@NotNull File isRooted) {
        C14342f0.m8184p(isRooted, "$this$isRooted");
        String path = isRooted.getPath();
        C14342f0.m8185o(path, "path");
        return m8440b(path) > 0;
    }

    @NotNull
    /* renamed from: e */
    public static final File m8437e(@NotNull File subPath, int i, int i2) {
        C14342f0.m8184p(subPath, "$this$subPath");
        return m8436f(subPath).m8456j(i, i2);
    }

    @NotNull
    /* renamed from: f */
    public static final FilePathComponents m8436f(@NotNull File toComponents) {
        List<String> m6475S4;
        int m8957Y;
        List list;
        C14342f0.m8184p(toComponents, "$this$toComponents");
        String path = toComponents.getPath();
        C14342f0.m8185o(path, "path");
        int m8440b = m8440b(path);
        String substring = path.substring(0, m8440b);
        C14342f0.m8185o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String substring2 = path.substring(m8440b);
        C14342f0.m8185o(substring2, "(this as java.lang.String).substring(startIndex)");
        if (substring2.length() == 0) {
            list = CollectionsKt__CollectionsKt.m12478E();
        } else {
            m6475S4 = C14579x.m6475S4(substring2, new char[]{File.separatorChar}, false, 0, 6, null);
            m8957Y = C14236x.m8957Y(m6475S4, 10);
            ArrayList arrayList = new ArrayList(m8957Y);
            for (String str : m6475S4) {
                arrayList.add(new File(str));
            }
            list = arrayList;
        }
        return new FilePathComponents(new File(substring), list);
    }
}
