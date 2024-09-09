package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Uri.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\u0086\b\u00a8\u0006\u0005"}, d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class UriKt {
    @NotNull
    public static final File toFile(@NotNull Uri toFile) {
        f0.q(toFile, "$this$toFile");
        if (f0.g(toFile.getScheme(), "file")) {
            String path = toFile.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(("Uri path is null: " + toFile).toString());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + toFile).toString());
    }

    @NotNull
    public static final Uri toUri(@NotNull String toUri) {
        f0.q(toUri, "$this$toUri");
        Uri parse = Uri.parse(toUri);
        f0.h(parse, "Uri.parse(this)");
        return parse;
    }

    @NotNull
    public static final Uri toUri(@NotNull File toUri) {
        f0.q(toUri, "$this$toUri");
        Uri fromFile = Uri.fromFile(toUri);
        f0.h(fromFile, "Uri.fromFile(this)");
        return fromFile;
    }
}
