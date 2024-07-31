package androidx.core.net;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\u0086\b¨\u0006\u0005"}, m12616d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 1, 16})
/* renamed from: androidx.core.net.UriKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Uri {
    @NotNull
    public static final File toFile(@NotNull android.net.Uri toFile) {
        C14342f0.m8183q(toFile, "$this$toFile");
        if (C14342f0.m8193g(toFile.getScheme(), IDataSource.f43973c)) {
            String path = toFile.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(("Uri path is null: " + toFile).toString());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + toFile).toString());
    }

    @NotNull
    public static final android.net.Uri toUri(@NotNull String toUri) {
        C14342f0.m8183q(toUri, "$this$toUri");
        android.net.Uri parse = android.net.Uri.parse(toUri);
        C14342f0.m8192h(parse, "Uri.parse(this)");
        return parse;
    }

    @NotNull
    public static final android.net.Uri toUri(@NotNull File toUri) {
        C14342f0.m8183q(toUri, "$this$toUri");
        android.net.Uri fromFile = android.net.Uri.fromFile(toUri);
        C14342f0.m8192h(fromFile, "Uri.fromFile(this)");
        return fromFile;
    }
}
