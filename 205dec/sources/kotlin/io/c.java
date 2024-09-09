package kotlin.io;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Console.kt */
@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0019\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0013\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0087\b\u001a\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\t\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\bH\u0087\b\u001a\u0011\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0011\u0010\r\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\fH\u0087\b\u001a\u0011\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000eH\u0087\b\u001a\u0011\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0010H\u0087\b\u001a\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0012H\u0087\b\u001a\u0011\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0014H\u0087\b\u001a\u0013\u0010\u0016\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0087\b\u001a\u0011\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\b\u001a\u0011\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0006H\u0087\b\u001a\u0011\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\bH\u0087\b\u001a\u0011\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0011\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\fH\u0087\b\u001a\u0011\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000eH\u0087\b\u001a\u0011\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0010H\u0087\b\u001a\u0011\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0012H\u0087\b\u001a\u0011\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0014H\u0087\b\u001a\t\u0010 \u001a\u00020\u0002H\u0087\b\u001a\b\u0010\"\u001a\u00020!H\u0007\u001a\n\u0010#\u001a\u0004\u0018\u00010!H\u0007\u001a\b\u0010$\u001a\u0004\u0018\u00010!\u00a8\u0006%"}, d2 = {"", "message", "Lkotlin/f1;", "g", "", "e", "", "f", "", "a", "", "h", "", "b", "", "i", "", "d", "", "c", "", "j", "r", "p", CampaignEx.JSON_KEY_AD_Q, "l", "s", "m", "t", "o", "n", "u", "k", "", "w", "x", "v", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "ConsoleKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    @InlineOnly
    private static final void a(byte b4) {
        System.out.print(Byte.valueOf(b4));
    }

    @InlineOnly
    private static final void b(char c4) {
        System.out.print(c4);
    }

    @InlineOnly
    private static final void c(double d4) {
        System.out.print(d4);
    }

    @InlineOnly
    private static final void d(float f4) {
        System.out.print(f4);
    }

    @InlineOnly
    private static final void e(int i4) {
        System.out.print(i4);
    }

    @InlineOnly
    private static final void f(long j4) {
        System.out.print(j4);
    }

    @InlineOnly
    private static final void g(Object obj) {
        System.out.print(obj);
    }

    @InlineOnly
    private static final void h(short s3) {
        System.out.print(Short.valueOf(s3));
    }

    @InlineOnly
    private static final void i(boolean z3) {
        System.out.print(z3);
    }

    @InlineOnly
    private static final void j(char[] message) {
        f0.p(message, "message");
        System.out.print(message);
    }

    @InlineOnly
    private static final void k() {
        System.out.println();
    }

    @InlineOnly
    private static final void l(byte b4) {
        System.out.println(Byte.valueOf(b4));
    }

    @InlineOnly
    private static final void m(char c4) {
        System.out.println(c4);
    }

    @InlineOnly
    private static final void n(double d4) {
        System.out.println(d4);
    }

    @InlineOnly
    private static final void o(float f4) {
        System.out.println(f4);
    }

    @InlineOnly
    private static final void p(int i4) {
        System.out.println(i4);
    }

    @InlineOnly
    private static final void q(long j4) {
        System.out.println(j4);
    }

    @InlineOnly
    private static final void r(Object obj) {
        System.out.println(obj);
    }

    @InlineOnly
    private static final void s(short s3) {
        System.out.println(Short.valueOf(s3));
    }

    @InlineOnly
    private static final void t(boolean z3) {
        System.out.println(z3);
    }

    @InlineOnly
    private static final void u(char[] message) {
        f0.p(message, "message");
        System.out.println(message);
    }

    @Nullable
    public static final String v() {
        n nVar = n.f55580a;
        InputStream inputStream = System.in;
        f0.o(inputStream, "`in`");
        Charset defaultCharset = Charset.defaultCharset();
        f0.o(defaultCharset, "defaultCharset()");
        return nVar.d(inputStream, defaultCharset);
    }

    @SinceKotlin(version = "1.6")
    @NotNull
    public static final String w() {
        String x3 = x();
        if (x3 != null) {
            return x3;
        }
        throw new ReadAfterEOFException("EOF has already been reached");
    }

    @SinceKotlin(version = "1.6")
    @Nullable
    public static final String x() {
        return v();
    }
}
