package kotlin.p613io;

import androidx.exifinterface.media.ExifInterface;
import com.kwad.sdk.api.model.AdnName;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Annotations;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections._Collections;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.C14579x;
import kotlin.text.StringsJVM;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: Utils.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000>\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\u001a*\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007\u001a*\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007\u001a\u0012\u0010\b\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u0012\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u0012\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u001d\u0010\f\u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\r\u001a&\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u001a8\u0010\u0018\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0003\u001a\u0012\u0010\u001b\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003\u001a\u0012\u0010\u001c\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0000\u001a\u0012\u0010\u001d\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003\u001a\u0012\u0010\u001e\u001a\u00020\u000f*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0000\u001a\n\u0010\u001f\u001a\u00020\u0003*\u00020\u0003\u001a\u0013\u0010!\u001a\u00020 *\u00020 H\u0002¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030#*\b\u0012\u0004\u0012\u00020\u00030#H\u0002¢\u0006\u0004\b$\u0010%\u001a\u0012\u0010'\u001a\u00020\u0003*\u00020\u00032\u0006\u0010&\u001a\u00020\u0003\u001a\u0012\u0010(\u001a\u00020\u0003*\u00020\u00032\u0006\u0010&\u001a\u00020\u0000\u001a\u0012\u0010)\u001a\u00020\u0003*\u00020\u00032\u0006\u0010&\u001a\u00020\u0003\u001a\u0012\u0010*\u001a\u00020\u0003*\u00020\u00032\u0006\u0010&\u001a\u00020\u0000\"\u0015\u0010-\u001a\u00020\u0000*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b+\u0010,\"\u0015\u0010/\u001a\u00020\u0000*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010,\"\u0015\u00101\u001a\u00020\u0000*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010,¨\u00062"}, m12616d2 = {"", "prefix", "suffix", "Ljava/io/File;", "directory", "R", ExifInterface.GPS_DIRECTION_TRUE, "base", "n0", "e0", "g0", "f0", "o0", "(Ljava/io/File;Ljava/io/File;)Ljava/lang/String;", "target", "", "overwrite", "", "bufferSize", "P", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "onError", "N", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, AdnName.OTHER, "l0", "m0", ExifInterface.LONGITUDE_WEST, "X", "b0", "Lkotlin/io/g;", "d0", "(Lkotlin/io/g;)Lkotlin/io/g;", "", "c0", "(Ljava/util/List;)Ljava/util/List;", "relative", "h0", "i0", "j0", "k0", "Y", "(Ljava/io/File;)Ljava/lang/String;", "extension", "Z", "invariantSeparatorsPath", "a0", "nameWithoutExtension", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/io/FilesKt")
/* renamed from: kotlin.io.n */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class C14324n extends C14323m {

    /* compiled from: Utils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {"Ljava/io/File;", "<anonymous parameter 0>", "Ljava/io/IOException;", "exception", "", "a", "(Ljava/io/File;Ljava/io/IOException;)Ljava/lang/Void;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.io.n$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14325a extends Lambda implements InterfaceC15284p {

        /* renamed from: a */
        public static final C14325a f41094a = new C14325a();

        C14325a() {
            super(2);
        }

        @Override // p617l1.InterfaceC15284p
        @NotNull
        /* renamed from: a */
        public final Void invoke(@NotNull File file, @NotNull IOException exception) {
            C14342f0.m8184p(file, "<anonymous parameter 0>");
            C14342f0.m8184p(exception, "exception");
            throw exception;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Utils.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {"Ljava/io/File;", "f", "Ljava/io/IOException;", "e", "Lkotlin/f1;", "a", "(Ljava/io/File;Ljava/io/IOException;)V"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.io.n$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14326b extends Lambda implements InterfaceC15284p<File, IOException, Unit> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15284p f41095a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14326b(InterfaceC15284p interfaceC15284p) {
            super(2);
            this.f41095a = interfaceC15284p;
        }

        /* renamed from: a */
        public final void m8372a(@NotNull File f, @NotNull IOException e) {
            C14342f0.m8184p(f, "f");
            C14342f0.m8184p(e, "e");
            if (((OnErrorAction) this.f41095a.invoke(f, e)) == OnErrorAction.TERMINATE) {
                throw new C14332s(f);
            }
        }

        @Override // p617l1.InterfaceC15284p
        public /* bridge */ /* synthetic */ Unit invoke(File file, IOException iOException) {
            m8372a(file, iOException);
            return Unit.f41048a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0 A[SYNTHETIC] */
    /* renamed from: N */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean m8401N(@org.jetbrains.annotations.NotNull java.io.File r11, @org.jetbrains.annotations.NotNull java.io.File r12, boolean r13, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15284p<? super java.io.File, ? super java.io.IOException, ? extends kotlin.p613io.OnErrorAction> r14) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p613io.C14324n.m8401N(java.io.File, java.io.File, boolean, l1.p):boolean");
    }

    /* renamed from: O */
    public static /* synthetic */ boolean m8400O(File file, File file2, boolean z, InterfaceC15284p interfaceC15284p, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            interfaceC15284p = C14325a.f41094a;
        }
        return m8401N(file, file2, z, interfaceC15284p);
    }

    @NotNull
    /* renamed from: P */
    public static final File m8399P(@NotNull File copyTo, @NotNull File target, boolean z, int i) {
        C14342f0.m8184p(copyTo, "$this$copyTo");
        C14342f0.m8184p(target, "target");
        if (copyTo.exists()) {
            if (target.exists()) {
                if (z) {
                    if (!target.delete()) {
                        throw new FileAlreadyExistsException(copyTo, target, "Tried to overwrite the destination, but failed to delete it.");
                    }
                } else {
                    throw new FileAlreadyExistsException(copyTo, target, "The destination file already exists.");
                }
            }
            if (copyTo.isDirectory()) {
                if (!target.mkdirs()) {
                    throw new FileSystemException(copyTo, target, "Failed to create target directory.");
                }
            } else {
                File parentFile = target.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileInputStream fileInputStream = new FileInputStream(copyTo);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(target);
                    IOStreams.m8511k(fileInputStream, fileOutputStream, i);
                    Closeable.m8492a(fileOutputStream, null);
                    Closeable.m8492a(fileInputStream, null);
                } finally {
                }
            }
            return target;
        }
        throw new NoSuchFileException(copyTo, null, "The source file doesn't exist.", 2, null);
    }

    /* renamed from: Q */
    public static /* synthetic */ File m8398Q(File file, File file2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 8192;
        }
        return m8399P(file, file2, z, i);
    }

    @Annotations(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    @NotNull
    /* renamed from: R */
    public static final File m8397R(@NotNull String prefix, @Nullable String str, @Nullable File file) {
        C14342f0.m8184p(prefix, "prefix");
        File dir = File.createTempFile(prefix, str, file);
        dir.delete();
        if (dir.mkdir()) {
            C14342f0.m8185o(dir, "dir");
            return dir;
        }
        throw new IOException("Unable to create temporary directory " + dir + '.');
    }

    /* renamed from: S */
    public static /* synthetic */ File m8396S(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return m8397R(str, str2, file);
    }

    @Annotations(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    @NotNull
    /* renamed from: T */
    public static final File m8395T(@NotNull String prefix, @Nullable String str, @Nullable File file) {
        C14342f0.m8184p(prefix, "prefix");
        File createTempFile = File.createTempFile(prefix, str, file);
        C14342f0.m8185o(createTempFile, "File.createTempFile(prefix, suffix, directory)");
        return createTempFile;
    }

    /* renamed from: U */
    public static /* synthetic */ File m8394U(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return m8395T(str, str2, file);
    }

    /* renamed from: V */
    public static final boolean m8393V(@NotNull File deleteRecursively) {
        C14342f0.m8184p(deleteRecursively, "$this$deleteRecursively");
        while (true) {
            boolean z = true;
            for (File file : C14323m.m8403L(deleteRecursively)) {
                if (file.delete() || !file.exists()) {
                    if (z) {
                        break;
                    }
                }
                z = false;
            }
            return z;
        }
    }

    /* renamed from: W */
    public static final boolean m8392W(@NotNull File endsWith, @NotNull File other) {
        C14342f0.m8184p(endsWith, "$this$endsWith");
        C14342f0.m8184p(other, "other");
        FilePathComponents m8436f = C14320k.m8436f(endsWith);
        FilePathComponents m8436f2 = C14320k.m8436f(other);
        if (m8436f2.m8457i()) {
            return C14342f0.m8193g(endsWith, other);
        }
        int m8458h = m8436f.m8458h() - m8436f2.m8458h();
        if (m8458h < 0) {
            return false;
        }
        return m8436f.m8459g().subList(m8458h, m8436f.m8458h()).equals(m8436f2.m8459g());
    }

    /* renamed from: X */
    public static final boolean m8391X(@NotNull File endsWith, @NotNull String other) {
        C14342f0.m8184p(endsWith, "$this$endsWith");
        C14342f0.m8184p(other, "other");
        return m8392W(endsWith, new File(other));
    }

    @NotNull
    /* renamed from: Y */
    public static final String m8390Y(@NotNull File extension) {
        String m6399q5;
        C14342f0.m8184p(extension, "$this$extension");
        String name = extension.getName();
        C14342f0.m8185o(name, "name");
        m6399q5 = C14579x.m6399q5(name, '.', "");
        return m6399q5;
    }

    @NotNull
    /* renamed from: Z */
    public static final String m8389Z(@NotNull File invariantSeparatorsPath) {
        String m6570j2;
        C14342f0.m8184p(invariantSeparatorsPath, "$this$invariantSeparatorsPath");
        if (File.separatorChar == '/') {
            String path = invariantSeparatorsPath.getPath();
            C14342f0.m8185o(path, "path");
            return path;
        }
        String path2 = invariantSeparatorsPath.getPath();
        C14342f0.m8185o(path2, "path");
        m6570j2 = StringsJVM.m6570j2(path2, File.separatorChar, '/', false, 4, null);
        return m6570j2;
    }

    @NotNull
    /* renamed from: a0 */
    public static final String m8388a0(@NotNull File nameWithoutExtension) {
        String m6532B5;
        C14342f0.m8184p(nameWithoutExtension, "$this$nameWithoutExtension");
        String name = nameWithoutExtension.getName();
        C14342f0.m8185o(name, "name");
        m6532B5 = C14579x.m6532B5(name, ".", null, 2, null);
        return m6532B5;
    }

    @NotNull
    /* renamed from: b0 */
    public static final File m8387b0(@NotNull File normalize) {
        String m12151Z2;
        C14342f0.m8184p(normalize, "$this$normalize");
        FilePathComponents m8436f = C14320k.m8436f(normalize);
        File m8461e = m8436f.m8461e();
        List<File> m8386c0 = m8386c0(m8436f.m8459g());
        String str = File.separator;
        C14342f0.m8185o(str, "File.separator");
        m12151Z2 = _Collections.m12151Z2(m8386c0, str, null, null, 0, null, null, 62, null);
        return m8380i0(m8461e, m12151Z2);
    }

    /* renamed from: c0 */
    private static final List<File> m8386c0(List<? extends File> list) {
        Object m12137c3;
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != 46) {
                    if (hashCode == 1472 && name.equals("..")) {
                        if (!arrayList.isEmpty()) {
                            m12137c3 = _Collections.m12137c3(arrayList);
                            if (!C14342f0.m8193g(((File) m12137c3).getName(), "..")) {
                                arrayList.remove(arrayList.size() - 1);
                            }
                        }
                        arrayList.add(file);
                    }
                } else if (name.equals(".")) {
                }
            }
            arrayList.add(file);
        }
        return arrayList;
    }

    /* renamed from: d0 */
    private static final FilePathComponents m8385d0(FilePathComponents filePathComponents) {
        return new FilePathComponents(filePathComponents.m8461e(), m8386c0(filePathComponents.m8459g()));
    }

    @NotNull
    /* renamed from: e0 */
    public static final File m8384e0(@NotNull File relativeTo, @NotNull File base) {
        C14342f0.m8184p(relativeTo, "$this$relativeTo");
        C14342f0.m8184p(base, "base");
        return new File(m8375n0(relativeTo, base));
    }

    @Nullable
    /* renamed from: f0 */
    public static final File m8383f0(@NotNull File relativeToOrNull, @NotNull File base) {
        C14342f0.m8184p(relativeToOrNull, "$this$relativeToOrNull");
        C14342f0.m8184p(base, "base");
        String m8374o0 = m8374o0(relativeToOrNull, base);
        if (m8374o0 != null) {
            return new File(m8374o0);
        }
        return null;
    }

    @NotNull
    /* renamed from: g0 */
    public static final File m8382g0(@NotNull File relativeToOrSelf, @NotNull File base) {
        C14342f0.m8184p(relativeToOrSelf, "$this$relativeToOrSelf");
        C14342f0.m8184p(base, "base");
        String m8374o0 = m8374o0(relativeToOrSelf, base);
        return m8374o0 != null ? new File(m8374o0) : relativeToOrSelf;
    }

    @NotNull
    /* renamed from: h0 */
    public static final File m8381h0(@NotNull File resolve, @NotNull File relative) {
        boolean m6449a3;
        C14342f0.m8184p(resolve, "$this$resolve");
        C14342f0.m8184p(relative, "relative");
        if (C14320k.m8438d(relative)) {
            return relative;
        }
        String file = resolve.toString();
        C14342f0.m8185o(file, "this.toString()");
        if (!(file.length() == 0)) {
            m6449a3 = C14579x.m6449a3(file, File.separatorChar, false, 2, null);
            if (!m6449a3) {
                return new File(file + File.separatorChar + relative);
            }
        }
        return new File(file + relative);
    }

    @NotNull
    /* renamed from: i0 */
    public static final File m8380i0(@NotNull File resolve, @NotNull String relative) {
        C14342f0.m8184p(resolve, "$this$resolve");
        C14342f0.m8184p(relative, "relative");
        return m8381h0(resolve, new File(relative));
    }

    @NotNull
    /* renamed from: j0 */
    public static final File m8379j0(@NotNull File resolveSibling, @NotNull File relative) {
        C14342f0.m8184p(resolveSibling, "$this$resolveSibling");
        C14342f0.m8184p(relative, "relative");
        FilePathComponents m8436f = C14320k.m8436f(resolveSibling);
        return m8381h0(m8381h0(m8436f.m8461e(), m8436f.m8458h() == 0 ? new File("..") : m8436f.m8456j(0, m8436f.m8458h() - 1)), relative);
    }

    @NotNull
    /* renamed from: k0 */
    public static final File m8378k0(@NotNull File resolveSibling, @NotNull String relative) {
        C14342f0.m8184p(resolveSibling, "$this$resolveSibling");
        C14342f0.m8184p(relative, "relative");
        return m8379j0(resolveSibling, new File(relative));
    }

    /* renamed from: l0 */
    public static final boolean m8377l0(@NotNull File startsWith, @NotNull File other) {
        C14342f0.m8184p(startsWith, "$this$startsWith");
        C14342f0.m8184p(other, "other");
        FilePathComponents m8436f = C14320k.m8436f(startsWith);
        FilePathComponents m8436f2 = C14320k.m8436f(other);
        if (!(!C14342f0.m8193g(m8436f.m8461e(), m8436f2.m8461e())) && m8436f.m8458h() >= m8436f2.m8458h()) {
            return m8436f.m8459g().subList(0, m8436f2.m8458h()).equals(m8436f2.m8459g());
        }
        return false;
    }

    /* renamed from: m0 */
    public static final boolean m8376m0(@NotNull File startsWith, @NotNull String other) {
        C14342f0.m8184p(startsWith, "$this$startsWith");
        C14342f0.m8184p(other, "other");
        return m8377l0(startsWith, new File(other));
    }

    @NotNull
    /* renamed from: n0 */
    public static final String m8375n0(@NotNull File toRelativeString, @NotNull File base) {
        C14342f0.m8184p(toRelativeString, "$this$toRelativeString");
        C14342f0.m8184p(base, "base");
        String m8374o0 = m8374o0(toRelativeString, base);
        if (m8374o0 != null) {
            return m8374o0;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + toRelativeString + " and " + base + '.');
    }

    /* renamed from: o0 */
    private static final String m8374o0(File file, File file2) {
        List m12202P1;
        FilePathComponents m8385d0 = m8385d0(C14320k.m8436f(file));
        FilePathComponents m8385d02 = m8385d0(C14320k.m8436f(file2));
        if (!C14342f0.m8193g(m8385d0.m8461e(), m8385d02.m8461e())) {
            return null;
        }
        int m8458h = m8385d02.m8458h();
        int m8458h2 = m8385d0.m8458h();
        int i = 0;
        int min = Math.min(m8458h2, m8458h);
        while (i < min && C14342f0.m8193g(m8385d0.m8459g().get(i), m8385d02.m8459g().get(i))) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = m8458h - 1;
        if (i2 >= i) {
            while (!C14342f0.m8193g(m8385d02.m8459g().get(i2).getName(), "..")) {
                sb.append("..");
                if (i2 != i) {
                    sb.append(File.separatorChar);
                }
                if (i2 != i) {
                    i2--;
                }
            }
            return null;
        }
        if (i < m8458h2) {
            if (i < m8458h) {
                sb.append(File.separatorChar);
            }
            m12202P1 = _Collections.m12202P1(m8385d0.m8459g(), i);
            String str = File.separator;
            C14342f0.m8185o(str, "File.separator");
            _Collections.m12161X2(m12202P1, sb, str, null, null, 0, null, null, 124, null);
        }
        return sb.toString();
    }
}
