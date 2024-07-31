package kotlin.p613io;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections._Collections;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\"\u0010#J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J#\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001e\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010!\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, m12616d2 = {"Lkotlin/io/g;", "", "", "beginIndex", "endIndex", "Ljava/io/File;", "j", "a", "", "b", "root", "segments", "c", "", "toString", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "Ljava/io/File;", "e", "()Ljava/io/File;", "Ljava/util/List;", "g", "()Ljava/util/List;", "f", "()Ljava/lang/String;", "rootName", "i", "()Z", "isRooted", "h", "()I", "size", "<init>", "(Ljava/io/File;Ljava/util/List;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.io.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FilePathComponents {
    @NotNull

    /* renamed from: a */
    private final File f41070a;
    @NotNull

    /* renamed from: b */
    private final List<File> f41071b;

    /* JADX WARN: Multi-variable type inference failed */
    public FilePathComponents(@NotNull File root, @NotNull List<? extends File> segments) {
        C14342f0.m8184p(root, "root");
        C14342f0.m8184p(segments, "segments");
        this.f41070a = root;
        this.f41071b = segments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public static /* synthetic */ FilePathComponents m8462d(FilePathComponents filePathComponents, File file, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            file = filePathComponents.f41070a;
        }
        if ((i & 2) != 0) {
            list = filePathComponents.f41071b;
        }
        return filePathComponents.m8463c(file, list);
    }

    @NotNull
    /* renamed from: a */
    public final File m8465a() {
        return this.f41070a;
    }

    @NotNull
    /* renamed from: b */
    public final List<File> m8464b() {
        return this.f41071b;
    }

    @NotNull
    /* renamed from: c */
    public final FilePathComponents m8463c(@NotNull File root, @NotNull List<? extends File> segments) {
        C14342f0.m8184p(root, "root");
        C14342f0.m8184p(segments, "segments");
        return new FilePathComponents(root, segments);
    }

    @NotNull
    /* renamed from: e */
    public final File m8461e() {
        return this.f41070a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof FilePathComponents) {
                FilePathComponents filePathComponents = (FilePathComponents) obj;
                return C14342f0.m8193g(this.f41070a, filePathComponents.f41070a) && C14342f0.m8193g(this.f41071b, filePathComponents.f41071b);
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f */
    public final String m8460f() {
        String path = this.f41070a.getPath();
        C14342f0.m8185o(path, "root.path");
        return path;
    }

    @NotNull
    /* renamed from: g */
    public final List<File> m8459g() {
        return this.f41071b;
    }

    /* renamed from: h */
    public final int m8458h() {
        return this.f41071b.size();
    }

    public int hashCode() {
        File file = this.f41070a;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        List<File> list = this.f41071b;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    /* renamed from: i */
    public final boolean m8457i() {
        String path = this.f41070a.getPath();
        C14342f0.m8185o(path, "root.path");
        return path.length() > 0;
    }

    @NotNull
    /* renamed from: j */
    public final File m8456j(int i, int i2) {
        String m12151Z2;
        if (i >= 0 && i <= i2 && i2 <= m8458h()) {
            List<File> subList = this.f41071b.subList(i, i2);
            String str = File.separator;
            C14342f0.m8185o(str, "File.separator");
            m12151Z2 = _Collections.m12151Z2(subList, str, null, null, 0, null, null, 62, null);
            return new File(m12151Z2);
        }
        throw new IllegalArgumentException();
    }

    @NotNull
    public String toString() {
        return "FilePathComponents(root=" + this.f41070a + ", segments=" + this.f41071b + ")";
    }
}
