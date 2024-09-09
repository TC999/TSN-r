package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import kotlin.text.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Utils.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\u001a*\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007\u001a*\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007\u001a\u0012\u0010\b\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u0012\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u0012\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u001d\u0010\f\u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\f\u0010\r\u001a&\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u001a8\u0010\u0018\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0003\u001a\u0012\u0010\u001b\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003\u001a\u0012\u0010\u001c\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0000\u001a\u0012\u0010\u001d\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003\u001a\u0012\u0010\u001e\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0000\u001a\n\u0010\u001f\u001a\u00020\u0003*\u00020\u0003\u001a\u0013\u0010!\u001a\u00020 *\u00020 H\u0002\u00a2\u0006\u0004\b!\u0010\"\u001a\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030#*\b\u0012\u0004\u0012\u00020\u00030#H\u0002\u00a2\u0006\u0004\b$\u0010%\u001a\u0012\u0010'\u001a\u00020\u0003*\u00020\u00032\u0006\u0010&\u001a\u00020\u0003\u001a\u0012\u0010(\u001a\u00020\u0003*\u00020\u00032\u0006\u0010&\u001a\u00020\u0000\u001a\u0012\u0010)\u001a\u00020\u0003*\u00020\u00032\u0006\u0010&\u001a\u00020\u0003\u001a\u0012\u0010*\u001a\u00020\u0003*\u00020\u00032\u0006\u0010&\u001a\u00020\u0000\"\u0015\u0010-\u001a\u00020\u0000*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\"\u0015\u0010/\u001a\u00020\u0000*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b.\u0010,\"\u0015\u00101\u001a\u00020\u0000*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b0\u0010,\u00a8\u00062"}, d2 = {"", "prefix", "suffix", "Ljava/io/File;", "directory", "R", "T", "base", "n0", "e0", "g0", "f0", "o0", "(Ljava/io/File;Ljava/io/File;)Ljava/lang/String;", "target", "", "overwrite", "", "bufferSize", "P", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "onError", "N", "V", "other", "l0", "m0", "W", "X", "b0", "Lkotlin/io/g;", "d0", "(Lkotlin/io/g;)Lkotlin/io/g;", "", "c0", "(Ljava/util/List;)Ljava/util/List;", "relative", "h0", "i0", "j0", "k0", "Y", "(Ljava/io/File;)Ljava/lang/String;", "extension", "Z", "invariantSeparatorsPath", "a0", "nameWithoutExtension", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/io/FilesKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class m extends l {

    /* compiled from: Utils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/io/File;", "<anonymous parameter 0>", "Ljava/io/IOException;", "exception", "", "a", "(Ljava/io/File;Ljava/io/IOException;)Ljava/lang/Void;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f55578a = new a();

        a() {
            super(2);
        }

        @Override // d2.p
        @NotNull
        /* renamed from: a */
        public final Void invoke(@NotNull File noName_0, @NotNull IOException exception) {
            f0.p(noName_0, "$noName_0");
            f0.p(exception, "exception");
            throw exception;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Utils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/io/File;", "f", "Ljava/io/IOException;", "e", "Lkotlin/f1;", "a", "(Ljava/io/File;Ljava/io/IOException;)V"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.p<File, IOException, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.p<File, IOException, OnErrorAction> f55579a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(d2.p<? super File, ? super IOException, ? extends OnErrorAction> pVar) {
            super(2);
            this.f55579a = pVar;
        }

        public final void a(@NotNull File f4, @NotNull IOException e4) {
            f0.p(f4, "f");
            f0.p(e4, "e");
            if (this.f55579a.invoke(f4, e4) == OnErrorAction.TERMINATE) {
                throw new q(f4);
            }
        }

        @Override // d2.p
        public /* bridge */ /* synthetic */ f1 invoke(File file, IOException iOException) {
            a(file, iOException);
            return f1.f55527a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean N(@org.jetbrains.annotations.NotNull java.io.File r11, @org.jetbrains.annotations.NotNull java.io.File r12, boolean r13, @org.jetbrains.annotations.NotNull d2.p<? super java.io.File, ? super java.io.IOException, ? extends kotlin.io.OnErrorAction> r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.f0.p(r11, r0)
            java.lang.String r0 = "target"
            kotlin.jvm.internal.f0.p(r12, r0)
            java.lang.String r0 = "onError"
            kotlin.jvm.internal.f0.p(r14, r0)
            boolean r0 = r11.exists()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L2f
            kotlin.io.NoSuchFileException r12 = new kotlin.io.NoSuchFileException
            r5 = 0
            r7 = 2
            r8 = 0
            java.lang.String r6 = "The source file doesn't exist."
            r3 = r12
            r4 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            java.lang.Object r11 = r14.invoke(r11, r12)
            kotlin.io.OnErrorAction r12 = kotlin.io.OnErrorAction.TERMINATE
            if (r11 == r12) goto L2d
            goto L2e
        L2d:
            r1 = 0
        L2e:
            return r1
        L2f:
            kotlin.io.h r0 = kotlin.io.l.M(r11)     // Catch: kotlin.io.q -> Ldd
            kotlin.io.m$b r3 = new kotlin.io.m$b     // Catch: kotlin.io.q -> Ldd
            r3.<init>(r14)     // Catch: kotlin.io.q -> Ldd
            kotlin.io.h r0 = r0.k(r3)     // Catch: kotlin.io.q -> Ldd
            java.util.Iterator r0 = r0.iterator()     // Catch: kotlin.io.q -> Ldd
        L40:
            boolean r3 = r0.hasNext()     // Catch: kotlin.io.q -> Ldd
            if (r3 == 0) goto Ldc
            java.lang.Object r3 = r0.next()     // Catch: kotlin.io.q -> Ldd
            java.io.File r3 = (java.io.File) r3     // Catch: kotlin.io.q -> Ldd
            boolean r4 = r3.exists()     // Catch: kotlin.io.q -> Ldd
            if (r4 != 0) goto L67
            kotlin.io.NoSuchFileException r10 = new kotlin.io.NoSuchFileException     // Catch: kotlin.io.q -> Ldd
            r6 = 0
            java.lang.String r7 = "The source file doesn't exist."
            r8 = 2
            r9 = 0
            r4 = r10
            r5 = r3
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: kotlin.io.q -> Ldd
            java.lang.Object r3 = r14.invoke(r3, r10)     // Catch: kotlin.io.q -> Ldd
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch: kotlin.io.q -> Ldd
            if (r3 != r4) goto L40
            return r2
        L67:
            java.lang.String r4 = n0(r3, r11)     // Catch: kotlin.io.q -> Ldd
            java.io.File r5 = new java.io.File     // Catch: kotlin.io.q -> Ldd
            r5.<init>(r12, r4)     // Catch: kotlin.io.q -> Ldd
            boolean r4 = r5.exists()     // Catch: kotlin.io.q -> Ldd
            if (r4 == 0) goto Lad
            boolean r4 = r3.isDirectory()     // Catch: kotlin.io.q -> Ldd
            if (r4 == 0) goto L82
            boolean r4 = r5.isDirectory()     // Catch: kotlin.io.q -> Ldd
            if (r4 != 0) goto Lad
        L82:
            if (r13 != 0) goto L86
        L84:
            r4 = 1
            goto L9b
        L86:
            boolean r4 = r5.isDirectory()     // Catch: kotlin.io.q -> Ldd
            if (r4 == 0) goto L93
            boolean r4 = V(r5)     // Catch: kotlin.io.q -> Ldd
            if (r4 != 0) goto L9a
            goto L84
        L93:
            boolean r4 = r5.delete()     // Catch: kotlin.io.q -> Ldd
            if (r4 != 0) goto L9a
            goto L84
        L9a:
            r4 = 0
        L9b:
            if (r4 == 0) goto Lad
            kotlin.io.FileAlreadyExistsException r4 = new kotlin.io.FileAlreadyExistsException     // Catch: kotlin.io.q -> Ldd
            java.lang.String r6 = "The destination file already exists."
            r4.<init>(r3, r5, r6)     // Catch: kotlin.io.q -> Ldd
            java.lang.Object r3 = r14.invoke(r5, r4)     // Catch: kotlin.io.q -> Ldd
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch: kotlin.io.q -> Ldd
            if (r3 != r4) goto L40
            return r2
        Lad:
            boolean r4 = r3.isDirectory()     // Catch: kotlin.io.q -> Ldd
            if (r4 == 0) goto Lb7
            r5.mkdirs()     // Catch: kotlin.io.q -> Ldd
            goto L40
        Lb7:
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r3
            r6 = r13
            java.io.File r4 = Q(r4, r5, r6, r7, r8, r9)     // Catch: kotlin.io.q -> Ldd
            long r4 = r4.length()     // Catch: kotlin.io.q -> Ldd
            long r6 = r3.length()     // Catch: kotlin.io.q -> Ldd
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L40
            java.io.IOException r4 = new java.io.IOException     // Catch: kotlin.io.q -> Ldd
            java.lang.String r5 = "Source file wasn't copied completely, length of destination file differs."
            r4.<init>(r5)     // Catch: kotlin.io.q -> Ldd
            java.lang.Object r3 = r14.invoke(r3, r4)     // Catch: kotlin.io.q -> Ldd
            kotlin.io.OnErrorAction r4 = kotlin.io.OnErrorAction.TERMINATE     // Catch: kotlin.io.q -> Ldd
            if (r3 != r4) goto L40
            return r2
        Ldc:
            return r1
        Ldd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.m.N(java.io.File, java.io.File, boolean, d2.p):boolean");
    }

    public static /* synthetic */ boolean O(File file, File file2, boolean z3, d2.p pVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        if ((i4 & 4) != 0) {
            pVar = a.f55578a;
        }
        return N(file, file2, z3, pVar);
    }

    @NotNull
    public static final File P(@NotNull File file, @NotNull File target, boolean z3, int i4) {
        f0.p(file, "<this>");
        f0.p(target, "target");
        if (file.exists()) {
            if (target.exists()) {
                if (z3) {
                    if (!target.delete()) {
                        throw new FileAlreadyExistsException(file, target, "Tried to overwrite the destination, but failed to delete it.");
                    }
                } else {
                    throw new FileAlreadyExistsException(file, target, "The destination file already exists.");
                }
            }
            if (file.isDirectory()) {
                if (!target.mkdirs()) {
                    throw new FileSystemException(file, target, "Failed to create target directory.");
                }
            } else {
                File parentFile = target.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(target);
                    kotlin.io.a.k(fileInputStream, fileOutputStream, i4);
                    kotlin.io.b.a(fileOutputStream, null);
                    kotlin.io.b.a(fileInputStream, null);
                } finally {
                }
            }
            return target;
        }
        throw new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null);
    }

    public static /* synthetic */ File Q(File file, File file2, boolean z3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z3 = false;
        }
        if ((i5 & 4) != 0) {
            i4 = 8192;
        }
        return P(file, file2, z3, i4);
    }

    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    @NotNull
    public static final File R(@NotNull String prefix, @Nullable String str, @Nullable File file) {
        f0.p(prefix, "prefix");
        File dir = File.createTempFile(prefix, str, file);
        dir.delete();
        if (dir.mkdir()) {
            f0.o(dir, "dir");
            return dir;
        }
        throw new IOException("Unable to create temporary directory " + dir + '.');
    }

    public static /* synthetic */ File S(String str, String str2, File file, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "tmp";
        }
        if ((i4 & 2) != 0) {
            str2 = null;
        }
        if ((i4 & 4) != 0) {
            file = null;
        }
        return R(str, str2, file);
    }

    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    @NotNull
    public static final File T(@NotNull String prefix, @Nullable String str, @Nullable File file) {
        f0.p(prefix, "prefix");
        File createTempFile = File.createTempFile(prefix, str, file);
        f0.o(createTempFile, "createTempFile(prefix, suffix, directory)");
        return createTempFile;
    }

    public static /* synthetic */ File U(String str, String str2, File file, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "tmp";
        }
        if ((i4 & 2) != 0) {
            str2 = null;
        }
        if ((i4 & 4) != 0) {
            file = null;
        }
        return T(str, str2, file);
    }

    public static final boolean V(@NotNull File file) {
        f0.p(file, "<this>");
        while (true) {
            boolean z3 = true;
            for (File file2 : l.L(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z3) {
                        break;
                    }
                }
                z3 = false;
            }
            return z3;
        }
    }

    public static final boolean W(@NotNull File file, @NotNull File other) {
        f0.p(file, "<this>");
        f0.p(other, "other");
        g f4 = j.f(file);
        g f5 = j.f(other);
        if (f5.i()) {
            return f0.g(file, other);
        }
        int h4 = f4.h() - f5.h();
        if (h4 < 0) {
            return false;
        }
        return f4.g().subList(h4, f4.h()).equals(f5.g());
    }

    public static final boolean X(@NotNull File file, @NotNull String other) {
        f0.p(file, "<this>");
        f0.p(other, "other");
        return W(file, new File(other));
    }

    @NotNull
    public static final String Y(@NotNull File file) {
        String q5;
        f0.p(file, "<this>");
        String name = file.getName();
        f0.o(name, "name");
        q5 = x.q5(name, '.', "");
        return q5;
    }

    @NotNull
    public static final String Z(@NotNull File file) {
        String j22;
        f0.p(file, "<this>");
        if (File.separatorChar == '/') {
            String path = file.getPath();
            f0.o(path, "path");
            return path;
        }
        String path2 = file.getPath();
        f0.o(path2, "path");
        j22 = w.j2(path2, File.separatorChar, '/', false, 4, null);
        return j22;
    }

    @NotNull
    public static final String a0(@NotNull File file) {
        String B5;
        f0.p(file, "<this>");
        String name = file.getName();
        f0.o(name, "name");
        B5 = x.B5(name, ".", null, 2, null);
        return B5;
    }

    @NotNull
    public static final File b0(@NotNull File file) {
        String X2;
        f0.p(file, "<this>");
        g f4 = j.f(file);
        File e4 = f4.e();
        List<File> c02 = c0(f4.g());
        String separator = File.separator;
        f0.o(separator, "separator");
        X2 = kotlin.collections.f0.X2(c02, separator, null, null, 0, null, null, 62, null);
        return i0(e4, X2);
    }

    private static final List<File> c0(List<? extends File> list) {
        Object a32;
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (!f0.g(name, ".")) {
                if (f0.g(name, "..")) {
                    if (!arrayList.isEmpty()) {
                        a32 = kotlin.collections.f0.a3(arrayList);
                        if (!f0.g(((File) a32).getName(), "..")) {
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                    arrayList.add(file);
                } else {
                    arrayList.add(file);
                }
            }
        }
        return arrayList;
    }

    private static final g d0(g gVar) {
        return new g(gVar.e(), c0(gVar.g()));
    }

    @NotNull
    public static final File e0(@NotNull File file, @NotNull File base) {
        f0.p(file, "<this>");
        f0.p(base, "base");
        return new File(n0(file, base));
    }

    @Nullable
    public static final File f0(@NotNull File file, @NotNull File base) {
        f0.p(file, "<this>");
        f0.p(base, "base");
        String o02 = o0(file, base);
        if (o02 == null) {
            return null;
        }
        return new File(o02);
    }

    @NotNull
    public static final File g0(@NotNull File file, @NotNull File base) {
        f0.p(file, "<this>");
        f0.p(base, "base");
        String o02 = o0(file, base);
        return o02 == null ? file : new File(o02);
    }

    @NotNull
    public static final File h0(@NotNull File file, @NotNull File relative) {
        boolean a32;
        f0.p(file, "<this>");
        f0.p(relative, "relative");
        if (j.d(relative)) {
            return relative;
        }
        String file2 = file.toString();
        f0.o(file2, "this.toString()");
        if (!(file2.length() == 0)) {
            a32 = x.a3(file2, File.separatorChar, false, 2, null);
            if (!a32) {
                return new File(file2 + File.separatorChar + relative);
            }
        }
        return new File(f0.C(file2, relative));
    }

    @NotNull
    public static final File i0(@NotNull File file, @NotNull String relative) {
        f0.p(file, "<this>");
        f0.p(relative, "relative");
        return h0(file, new File(relative));
    }

    @NotNull
    public static final File j0(@NotNull File file, @NotNull File relative) {
        f0.p(file, "<this>");
        f0.p(relative, "relative");
        g f4 = j.f(file);
        return h0(h0(f4.e(), f4.h() == 0 ? new File("..") : f4.j(0, f4.h() - 1)), relative);
    }

    @NotNull
    public static final File k0(@NotNull File file, @NotNull String relative) {
        f0.p(file, "<this>");
        f0.p(relative, "relative");
        return j0(file, new File(relative));
    }

    public static final boolean l0(@NotNull File file, @NotNull File other) {
        f0.p(file, "<this>");
        f0.p(other, "other");
        g f4 = j.f(file);
        g f5 = j.f(other);
        if (f0.g(f4.e(), f5.e()) && f4.h() >= f5.h()) {
            return f4.g().subList(0, f5.h()).equals(f5.g());
        }
        return false;
    }

    public static final boolean m0(@NotNull File file, @NotNull String other) {
        f0.p(file, "<this>");
        f0.p(other, "other");
        return l0(file, new File(other));
    }

    @NotNull
    public static final String n0(@NotNull File file, @NotNull File base) {
        f0.p(file, "<this>");
        f0.p(base, "base");
        String o02 = o0(file, base);
        if (o02 != null) {
            return o02;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + base + '.');
    }

    private static final String o0(File file, File file2) {
        List N1;
        g d02 = d0(j.f(file));
        g d03 = d0(j.f(file2));
        if (f0.g(d02.e(), d03.e())) {
            int h4 = d03.h();
            int h5 = d02.h();
            int i4 = 0;
            int min = Math.min(h5, h4);
            while (i4 < min && f0.g(d02.g().get(i4), d03.g().get(i4))) {
                i4++;
            }
            StringBuilder sb = new StringBuilder();
            int i5 = h4 - 1;
            if (i4 <= i5) {
                while (true) {
                    int i6 = i5 - 1;
                    if (f0.g(d03.g().get(i5).getName(), "..")) {
                        return null;
                    }
                    sb.append("..");
                    if (i5 != i4) {
                        sb.append(File.separatorChar);
                    }
                    if (i5 == i4) {
                        break;
                    }
                    i5 = i6;
                }
            }
            if (i4 < h5) {
                if (i4 < h4) {
                    sb.append(File.separatorChar);
                }
                N1 = kotlin.collections.f0.N1(d02.g(), i4);
                String separator = File.separator;
                f0.o(separator, "separator");
                kotlin.collections.f0.V2(N1, sb, separator, null, null, 0, null, null, 124, null);
            }
            return sb.toString();
        }
        return null;
    }
}
