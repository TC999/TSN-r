package kotlin.io.path;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import kotlin.text.z;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PathUtils.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u001c\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u001c\u0010\n\u001a\n \u0006*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lkotlin/io/path/a;", "", "Ljava/nio/file/Path;", "path", "base", "a", "kotlin.jvm.PlatformType", "Ljava/nio/file/Path;", "emptyPath", "b", "parentPath", "<init>", "()V", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class a {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final a f55597c = new a();

    /* renamed from: a  reason: collision with root package name */
    private static final Path f55595a = Paths.get("", new String[0]);

    /* renamed from: b  reason: collision with root package name */
    private static final Path f55596b = Paths.get("..", new String[0]);

    private a() {
    }

    @NotNull
    public final Path a(@NotNull Path path, @NotNull Path base) {
        boolean J1;
        String w6;
        f0.p(path, "path");
        f0.p(base, "base");
        Path bn = base.normalize();
        Path r3 = path.normalize();
        Path rn = bn.relativize(r3);
        f0.o(bn, "bn");
        int nameCount = bn.getNameCount();
        f0.o(r3, "pn");
        int min = Math.min(nameCount, r3.getNameCount());
        for (int i4 = 0; i4 < min; i4++) {
            Path name = bn.getName(i4);
            Path path2 = f55596b;
            if (!f0.g(name, path2)) {
                break;
            } else if (!f0.g(r3.getName(i4), path2)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (!(!f0.g(r3, bn)) || !f0.g(bn, f55595a)) {
            String obj = rn.toString();
            f0.o(rn, "rn");
            FileSystem fileSystem = rn.getFileSystem();
            f0.o(fileSystem, "rn.fileSystem");
            String separator = fileSystem.getSeparator();
            f0.o(separator, "rn.fileSystem.separator");
            J1 = w.J1(obj, separator, false, 2, null);
            if (J1) {
                FileSystem fileSystem2 = rn.getFileSystem();
                FileSystem fileSystem3 = rn.getFileSystem();
                f0.o(fileSystem3, "rn.fileSystem");
                w6 = z.w6(obj, fileSystem3.getSeparator().length());
                r3 = fileSystem2.getPath(w6, new String[0]);
            } else {
                r3 = rn;
            }
        }
        f0.o(r3, "r");
        return r3;
    }
}
