package androidx.core.util;

import androidx.annotation.RequiresApi;
import com.baidu.mobads.sdk.internal.C2573a;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: AtomicFile.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a0\u0010\b\u001a\u00020\u0006*\u00020\u00002!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001H\u0087\b\u001a\u0014\u0010\u000b\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0007\u001a\u001e\u0010\u0010\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007\u001a\r\u0010\u0011\u001a\u00020\t*\u00020\u0000H\u0087\b\u001a\u0016\u0010\u0012\u001a\u00020\f*\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¨\u0006\u0013"}, m12616d2 = {"Landroid/util/AtomicFile;", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "Lkotlin/f1;", "block", "tryWrite", "", "array", "writeBytes", "", C2573a.f8443b, "Ljava/nio/charset/Charset;", "charset", "writeText", "readBytes", "readText", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class AtomicFileKt {
    @RequiresApi(17)
    @NotNull
    public static final byte[] readBytes(@NotNull android.util.AtomicFile readBytes) {
        C14342f0.m8183q(readBytes, "$this$readBytes");
        byte[] readFully = readBytes.readFully();
        C14342f0.m8192h(readFully, "readFully()");
        return readFully;
    }

    @RequiresApi(17)
    @NotNull
    public static final String readText(@NotNull android.util.AtomicFile readText, @NotNull Charset charset) {
        C14342f0.m8183q(readText, "$this$readText");
        C14342f0.m8183q(charset, "charset");
        byte[] readFully = readText.readFully();
        C14342f0.m8192h(readFully, "readFully()");
        return new String(readFully, charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(@NotNull android.util.AtomicFile tryWrite, @NotNull InterfaceC15280l<? super FileOutputStream, Unit> block) {
        C14342f0.m8183q(tryWrite, "$this$tryWrite");
        C14342f0.m8183q(block, "block");
        FileOutputStream stream = tryWrite.startWrite();
        try {
            C14342f0.m8192h(stream, "stream");
            block.invoke(stream);
            InlineMarker.m8228d(1);
            tryWrite.finishWrite(stream);
            InlineMarker.m8229c(1);
        } catch (Throwable th) {
            InlineMarker.m8228d(1);
            tryWrite.failWrite(stream);
            InlineMarker.m8229c(1);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(@NotNull android.util.AtomicFile writeBytes, @NotNull byte[] array) {
        C14342f0.m8183q(writeBytes, "$this$writeBytes");
        C14342f0.m8183q(array, "array");
        FileOutputStream stream = writeBytes.startWrite();
        try {
            C14342f0.m8192h(stream, "stream");
            stream.write(array);
            writeBytes.finishWrite(stream);
        } catch (Throwable th) {
            writeBytes.failWrite(stream);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(@NotNull android.util.AtomicFile writeText, @NotNull String text, @NotNull Charset charset) {
        C14342f0.m8183q(writeText, "$this$writeText");
        C14342f0.m8183q(text, "text");
        C14342f0.m8183q(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        C14342f0.m8192h(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(writeText, bytes);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.f41591a;
        }
        writeText(atomicFile, str, charset);
    }
}
