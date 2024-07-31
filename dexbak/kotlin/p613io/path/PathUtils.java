package kotlin.p613io.path;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.StringsJVM;
import kotlin.text._Strings;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u001c\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u001c\u0010\n\u001a\n \u0006*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\r"}, m12616d2 = {"Lkotlin/io/path/a;", "", "Ljava/nio/file/Path;", "path", "base", "a", "kotlin.jvm.PlatformType", "Ljava/nio/file/Path;", "emptyPath", "b", "parentPath", "<init>", "()V", "kotlin-stdlib-jdk7"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.io.path.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class PathUtils {
    @NotNull

    /* renamed from: c */
    public static final PathUtils f41107c = new PathUtils();

    /* renamed from: a */
    private static final Path f41105a = Paths.get("", new String[0]);

    /* renamed from: b */
    private static final Path f41106b = Paths.get("..", new String[0]);

    private PathUtils() {
    }

    @NotNull
    /* renamed from: a */
    public final Path m8362a(@NotNull Path path, @NotNull Path base) {
        boolean m6606J1;
        String m6202w6;
        C14342f0.m8184p(path, "path");
        C14342f0.m8184p(base, "base");
        Path bn = base.normalize();
        Path r = path.normalize();
        Path rn = bn.relativize(r);
        C14342f0.m8185o(bn, "bn");
        int nameCount = bn.getNameCount();
        C14342f0.m8185o(r, "pn");
        int min = Math.min(nameCount, r.getNameCount());
        for (int i = 0; i < min; i++) {
            Path name = bn.getName(i);
            Path path2 = f41106b;
            if (!C14342f0.m8193g(name, path2)) {
                break;
            } else if (!C14342f0.m8193g(r.getName(i), path2)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (!(!C14342f0.m8193g(r, bn)) || !C14342f0.m8193g(bn, f41105a)) {
            String obj = rn.toString();
            C14342f0.m8185o(rn, "rn");
            FileSystem fileSystem = rn.getFileSystem();
            C14342f0.m8185o(fileSystem, "rn.fileSystem");
            String separator = fileSystem.getSeparator();
            C14342f0.m8185o(separator, "rn.fileSystem.separator");
            m6606J1 = StringsJVM.m6606J1(obj, separator, false, 2, null);
            if (m6606J1) {
                FileSystem fileSystem2 = rn.getFileSystem();
                FileSystem fileSystem3 = rn.getFileSystem();
                C14342f0.m8185o(fileSystem3, "rn.fileSystem");
                m6202w6 = _Strings.m6202w6(obj, fileSystem3.getSeparator().length());
                r = fileSystem2.getPath(m6202w6, new String[0]);
            } else {
                r = rn;
            }
        }
        C14342f0.m8185o(r, "r");
        return r;
    }
}
