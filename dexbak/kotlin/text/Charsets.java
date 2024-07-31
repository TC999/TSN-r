package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0011\u0010\u0017\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0016¨\u0006\u001c"}, m12616d2 = {"Lkotlin/text/d;", "", "Ljava/nio/charset/Charset;", "a", "Ljava/nio/charset/Charset;", "UTF_8", "b", "UTF_16", "c", "UTF_16BE", "d", "UTF_16LE", "e", "US_ASCII", "f", "ISO_8859_1", "g", "utf_32", "h", "utf_32le", "i", "utf_32be", "()Ljava/nio/charset/Charset;", "UTF_32", "UTF_32LE", "UTF_32BE", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.text.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Charsets {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: a */
    public static final Charset f41591a;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: b */
    public static final Charset f41592b;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: c */
    public static final Charset f41593c;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: d */
    public static final Charset f41594d;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: e */
    public static final Charset f41595e;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: f */
    public static final Charset f41596f;

    /* renamed from: g */
    private static Charset f41597g;

    /* renamed from: h */
    private static Charset f41598h;

    /* renamed from: i */
    private static Charset f41599i;
    @NotNull

    /* renamed from: j */
    public static final Charsets f41600j = new Charsets();

    static {
        Charset forName = Charset.forName("UTF-8");
        C14342f0.m8185o(forName, "Charset.forName(\"UTF-8\")");
        f41591a = forName;
        Charset forName2 = Charset.forName("UTF-16");
        C14342f0.m8185o(forName2, "Charset.forName(\"UTF-16\")");
        f41592b = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        C14342f0.m8185o(forName3, "Charset.forName(\"UTF-16BE\")");
        f41593c = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        C14342f0.m8185o(forName4, "Charset.forName(\"UTF-16LE\")");
        f41594d = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        C14342f0.m8185o(forName5, "Charset.forName(\"US-ASCII\")");
        f41595e = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        C14342f0.m8185o(forName6, "Charset.forName(\"ISO-8859-1\")");
        f41596f = forName6;
    }

    private Charsets() {
    }

    @JvmName(name = "UTF32")
    @NotNull
    /* renamed from: a */
    public final Charset m6853a() {
        Charset charset = f41597g;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32");
        C14342f0.m8185o(forName, "Charset.forName(\"UTF-32\")");
        f41597g = forName;
        return forName;
    }

    @JvmName(name = "UTF32_BE")
    @NotNull
    /* renamed from: b */
    public final Charset m6852b() {
        Charset charset = f41599i;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        C14342f0.m8185o(forName, "Charset.forName(\"UTF-32BE\")");
        f41599i = forName;
        return forName;
    }

    @JvmName(name = "UTF32_LE")
    @NotNull
    /* renamed from: c */
    public final Charset m6851c() {
        Charset charset = f41598h;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        C14342f0.m8185o(forName, "Charset.forName(\"UTF-32LE\")");
        f41598h = forName;
        return forName;
    }
}
