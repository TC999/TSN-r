package kotlin;

import com.daimajia.numberprogressbar.BuildConfig;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.internal.C14307b;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Exceptions.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\b\u001a\f\u0010\n\u001a\u00020\t*\u00020\u0000H\u0007\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0007\"!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\u00008F¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\"$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00000\u0014*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, m12616d2 = {"", "Lkotlin/f1;", "f", "Ljava/io/PrintWriter;", "writer", "h", "Ljava/io/PrintStream;", "stream", "g", "", "i", "exception", "a", "", "Ljava/lang/StackTraceElement;", "b", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "stackTrace", "", "d", "(Ljava/lang/Throwable;)Ljava/util/List;", "getSuppressedExceptions$annotations", "suppressedExceptions", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/ExceptionsKt")
/* renamed from: kotlin.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14305i {
    @SinceKotlin(version = "1.1")
    @HidesMembers
    /* renamed from: a */
    public static void m8548a(@NotNull Throwable addSuppressed, @NotNull Throwable exception) {
        C14342f0.m8184p(addSuppressed, "$this$addSuppressed");
        C14342f0.m8184p(exception, "exception");
        if (addSuppressed != exception) {
            C14307b.f41062a.mo8538a(addSuppressed, exception);
        }
    }

    @NotNull
    /* renamed from: b */
    public static final StackTraceElement[] m8547b(@NotNull Throwable stackTrace) {
        C14342f0.m8184p(stackTrace, "$this$stackTrace");
        StackTraceElement[] stackTrace2 = stackTrace.getStackTrace();
        C14342f0.m8187m(stackTrace2);
        return stackTrace2;
    }

    /* renamed from: c */
    public static /* synthetic */ void m8546c(Throwable th) {
    }

    @NotNull
    /* renamed from: d */
    public static final List<Throwable> m8545d(@NotNull Throwable suppressedExceptions) {
        C14342f0.m8184p(suppressedExceptions, "$this$suppressedExceptions");
        return C14307b.f41062a.mo8535d(suppressedExceptions);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: e */
    public static /* synthetic */ void m8544e(Throwable th) {
    }

    @InlineOnly
    /* renamed from: f */
    private static final void m8543f(Throwable th) {
        if (th == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace();
    }

    @InlineOnly
    /* renamed from: g */
    private static final void m8542g(Throwable th, PrintStream printStream) {
        if (th == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace(printStream);
    }

    @InlineOnly
    /* renamed from: h */
    private static final void m8541h(Throwable th, PrintWriter printWriter) {
        if (th == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Throwable");
        }
        th.printStackTrace(printWriter);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    /* renamed from: i */
    public static final String m8540i(@NotNull Throwable stackTraceToString) {
        C14342f0.m8184p(stackTraceToString, "$this$stackTraceToString");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        stackTraceToString.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        C14342f0.m8185o(stringWriter2, "sw.toString()");
        return stringWriter2;
    }
}
