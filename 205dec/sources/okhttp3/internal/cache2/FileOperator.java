package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: FileOperator.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lokhttp3/internal/cache2/FileOperator;", "", "", "pos", "Lokio/Buffer;", "source", "byteCount", "Lkotlin/f1;", "write", "sink", "read", "Ljava/nio/channels/FileChannel;", "fileChannel", "Ljava/nio/channels/FileChannel;", "<init>", "(Ljava/nio/channels/FileChannel;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(@NotNull FileChannel fileChannel) {
        f0.p(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j4, @NotNull Buffer sink, long j5) {
        f0.p(sink, "sink");
        if (j5 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j5 > 0) {
            long transferTo = this.fileChannel.transferTo(j4, j5, sink);
            j4 += transferTo;
            j5 -= transferTo;
        }
    }

    public final void write(long j4, @NotNull Buffer source, long j5) throws IOException {
        f0.p(source, "source");
        if (j5 < 0 || j5 > source.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j6 = j4;
        long j7 = j5;
        while (j7 > 0) {
            long transferFrom = this.fileChannel.transferFrom(source, j6, j7);
            j6 += transferFrom;
            j7 -= transferFrom;
        }
    }
}
