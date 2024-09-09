package androidx.core.util;

import androidx.annotation.RequiresApi;
import d2.l;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.text.d;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AtomicFile.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a0\u0010\b\u001a\u00020\u0006*\u00020\u00002!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001H\u0087\b\u001a\u0014\u0010\u000b\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0007\u001a\u001e\u0010\u0010\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007\u001a\r\u0010\u0011\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\u0016\u0010\u0012\u001a\u00020\f*\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007\u00a8\u0006\u0013"}, d2 = {"Landroid/util/AtomicFile;", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "Lkotlin/f1;", "block", "tryWrite", "", "array", "writeBytes", "", "text", "Ljava/nio/charset/Charset;", "charset", "writeText", "readBytes", "readText", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class AtomicFileKt {
    @RequiresApi(17)
    @NotNull
    public static final byte[] readBytes(@NotNull android.util.AtomicFile readBytes) {
        f0.q(readBytes, "$this$readBytes");
        byte[] readFully = readBytes.readFully();
        f0.h(readFully, "readFully()");
        return readFully;
    }

    @RequiresApi(17)
    @NotNull
    public static final String readText(@NotNull android.util.AtomicFile readText, @NotNull Charset charset) {
        f0.q(readText, "$this$readText");
        f0.q(charset, "charset");
        byte[] readFully = readText.readFully();
        f0.h(readFully, "readFully()");
        return new String(readFully, charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = d.f58930b;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(@NotNull android.util.AtomicFile tryWrite, @NotNull l<? super FileOutputStream, f1> block) {
        f0.q(tryWrite, "$this$tryWrite");
        f0.q(block, "block");
        FileOutputStream stream = tryWrite.startWrite();
        try {
            f0.h(stream, "stream");
            block.invoke(stream);
            c0.d(1);
            tryWrite.finishWrite(stream);
            c0.c(1);
        } catch (Throwable th) {
            c0.d(1);
            tryWrite.failWrite(stream);
            c0.c(1);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(@NotNull android.util.AtomicFile writeBytes, @NotNull byte[] array) {
        f0.q(writeBytes, "$this$writeBytes");
        f0.q(array, "array");
        FileOutputStream stream = writeBytes.startWrite();
        try {
            f0.h(stream, "stream");
            stream.write(array);
            writeBytes.finishWrite(stream);
        } catch (Throwable th) {
            writeBytes.failWrite(stream);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(@NotNull android.util.AtomicFile writeText, @NotNull String text, @NotNull Charset charset) {
        f0.q(writeText, "$this$writeText");
        f0.q(text, "text");
        f0.q(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        f0.h(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(writeText, bytes);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            charset = d.f58930b;
        }
        writeText(atomicFile, str, charset);
    }
}
