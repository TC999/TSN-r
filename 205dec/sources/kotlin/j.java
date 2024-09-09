package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Exceptions.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\b\u001a\f\u0010\n\u001a\u00020\t*\u00020\u0000H\u0007\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0007\"!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\u00008F\u00a2\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\"$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00000\u0014*\u00020\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"", "Lkotlin/f1;", "f", "Ljava/io/PrintWriter;", "writer", "h", "Ljava/io/PrintStream;", "stream", "g", "", "i", "exception", "a", "", "Ljava/lang/StackTraceElement;", "b", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "stackTrace", "", "d", "(Ljava/lang/Throwable;)Ljava/util/List;", "getSuppressedExceptions$annotations", "suppressedExceptions", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/ExceptionsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class j {
    @SinceKotlin(version = "1.1")
    @HidesMembers
    public static void a(@NotNull Throwable th, @NotNull Throwable exception) {
        kotlin.jvm.internal.f0.p(th, "<this>");
        kotlin.jvm.internal.f0.p(exception, "exception");
        if (th != exception) {
            kotlin.internal.b.f55545a.a(th, exception);
        }
    }

    @NotNull
    public static final StackTraceElement[] b(@NotNull Throwable th) {
        kotlin.jvm.internal.f0.p(th, "<this>");
        StackTraceElement[] stackTrace = th.getStackTrace();
        kotlin.jvm.internal.f0.m(stackTrace);
        return stackTrace;
    }

    public static /* synthetic */ void c(Throwable th) {
    }

    @NotNull
    public static final List<Throwable> d(@NotNull Throwable th) {
        kotlin.jvm.internal.f0.p(th, "<this>");
        return kotlin.internal.b.f55545a.d(th);
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void e(Throwable th) {
    }

    @InlineOnly
    private static final void f(Throwable th) {
        kotlin.jvm.internal.f0.p(th, "<this>");
        th.printStackTrace();
    }

    @InlineOnly
    private static final void g(Throwable th, PrintStream stream) {
        kotlin.jvm.internal.f0.p(th, "<this>");
        kotlin.jvm.internal.f0.p(stream, "stream");
        th.printStackTrace(stream);
    }

    @InlineOnly
    private static final void h(Throwable th, PrintWriter writer) {
        kotlin.jvm.internal.f0.p(th, "<this>");
        kotlin.jvm.internal.f0.p(writer, "writer");
        th.printStackTrace(writer);
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final String i(@NotNull Throwable th) {
        kotlin.jvm.internal.f0.p(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        kotlin.jvm.internal.f0.o(stringWriter2, "sw.toString()");
        return stringWriter2;
    }
}
