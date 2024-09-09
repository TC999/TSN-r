package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Charsets.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0011\u0010\u0018\u001a\u00020\u00028G\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u00028G\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u00028G\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lkotlin/text/d;", "", "Ljava/nio/charset/Charset;", "b", "Ljava/nio/charset/Charset;", "UTF_8", "c", "UTF_16", "d", "UTF_16BE", "e", "UTF_16LE", "f", "US_ASCII", "g", "ISO_8859_1", "h", "utf_32", "i", "utf_32le", "j", "utf_32be", "a", "()Ljava/nio/charset/Charset;", "UTF_32", "UTF_32LE", "UTF_32BE", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final d f58929a = new d();
    @JvmField
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f58930b;
    @JvmField
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f58931c;
    @JvmField
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f58932d;
    @JvmField
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f58933e;
    @JvmField
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f58934f;
    @JvmField
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public static final Charset f58935g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static Charset f58936h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static Charset f58937i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static Charset f58938j;

    static {
        Charset forName = Charset.forName("UTF-8");
        f0.o(forName, "forName(\"UTF-8\")");
        f58930b = forName;
        Charset forName2 = Charset.forName("UTF-16");
        f0.o(forName2, "forName(\"UTF-16\")");
        f58931c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        f0.o(forName3, "forName(\"UTF-16BE\")");
        f58932d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        f0.o(forName4, "forName(\"UTF-16LE\")");
        f58933e = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        f0.o(forName5, "forName(\"US-ASCII\")");
        f58934f = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        f0.o(forName6, "forName(\"ISO-8859-1\")");
        f58935g = forName6;
    }

    private d() {
    }

    @JvmName(name = "UTF32")
    @NotNull
    public final Charset a() {
        Charset charset = f58936h;
        if (charset == null) {
            Charset forName = Charset.forName("UTF-32");
            f0.o(forName, "forName(\"UTF-32\")");
            f58936h = forName;
            return forName;
        }
        return charset;
    }

    @JvmName(name = "UTF32_BE")
    @NotNull
    public final Charset b() {
        Charset charset = f58938j;
        if (charset == null) {
            Charset forName = Charset.forName("UTF-32BE");
            f0.o(forName, "forName(\"UTF-32BE\")");
            f58938j = forName;
            return forName;
        }
        return charset;
    }

    @JvmName(name = "UTF32_LE")
    @NotNull
    public final Charset c() {
        Charset charset = f58937i;
        if (charset == null) {
            Charset forName = Charset.forName("UTF-32LE");
            f0.o(forName, "forName(\"UTF-32LE\")");
            f58937i = forName;
            return forName;
        }
        return charset;
    }
}
