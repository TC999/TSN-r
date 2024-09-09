package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReadWrite.kt */
@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u0017\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0017\u0010\u0007\u001a\u00020\u0006*\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u001e\u0010\f\u001a\u00020\n*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u001a\u0010\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\r*\u00020\u0000\u001a:\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f*\u00020\u00002\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0010\u0012\u0004\u0012\u00028\u00000\bH\u0086\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a\r\u0010\u0016\u001a\u00020\u0015*\u00020\tH\u0087\b\u001a\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0010*\u00020\u0003\u001a\n\u0010\u0018\u001a\u00020\t*\u00020\u0000\u001a\u001c\u0010\u001b\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u0017\u0010\u001f\u001a\u00020\t*\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0087\b\u001a\n\u0010!\u001a\u00020 *\u00020\u001c\u0082\u0002\u000f\n\u0006\b\u0011(\u00120\u0001\n\u0005\b\u009920\u0001\u00a8\u0006\""}, d2 = {"Ljava/io/Reader;", "", "bufferSize", "Ljava/io/BufferedReader;", "a", "Ljava/io/Writer;", "Ljava/io/BufferedWriter;", "b", "Lkotlin/Function1;", "", "Lkotlin/f1;", "action", "g", "", "j", "T", "Lkotlin/sequences/m;", "block", "Requires newer compiler version to be inlined correctly.", "o", "(Ljava/io/Reader;Ll1/l;)Ljava/lang/Object;", "Ljava/io/StringReader;", "n", "h", "k", "out", "", "e", "Ljava/net/URL;", "Ljava/nio/charset/Charset;", "charset", "l", "", "i", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
@JvmName(name = "TextStreamsKt")
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class t {

    /* compiled from: ReadWrite.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/f1;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a extends Lambda implements l1.l<String, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f55602a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ArrayList arrayList) {
            super(1);
            this.f55602a = arrayList;
        }

        public final void a(@NotNull String it) {
            f0.p(it, "it");
            this.f55602a.add(it);
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(String str) {
            a(str);
            return f1.f55527a;
        }
    }

    @InlineOnly
    private static final BufferedReader a(Reader reader, int i4) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i4);
    }

    @InlineOnly
    private static final BufferedWriter b(Writer writer, int i4) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i4);
    }

    static /* synthetic */ BufferedReader c(Reader reader, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 8192;
        }
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i4);
    }

    static /* synthetic */ BufferedWriter d(Writer writer, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 8192;
        }
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i4);
    }

    public static final long e(@NotNull Reader copyTo, @NotNull Writer out, int i4) {
        f0.p(copyTo, "$this$copyTo");
        f0.p(out, "out");
        char[] cArr = new char[i4];
        int read = copyTo.read(cArr);
        long j4 = 0;
        while (read >= 0) {
            out.write(cArr, 0, read);
            j4 += read;
            read = copyTo.read(cArr);
        }
        return j4;
    }

    public static /* synthetic */ long f(Reader reader, Writer writer, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 8192;
        }
        return e(reader, writer, i4);
    }

    public static final void g(@NotNull Reader forEachLine, @NotNull l1.l<? super String, f1> action) {
        f0.p(forEachLine, "$this$forEachLine");
        f0.p(action, "action");
        BufferedReader bufferedReader = forEachLine instanceof BufferedReader ? (BufferedReader) forEachLine : new BufferedReader(forEachLine, 8192);
        try {
            for (String str : h(bufferedReader)) {
                action.invoke(str);
            }
            f1 f1Var = f1.f55527a;
            b.a(bufferedReader, null);
        } finally {
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.io.q, kotlin.sequences.m] */
    @NotNull
    public static final kotlin.sequences.m<String> h(@NotNull BufferedReader lineSequence) {
        kotlin.sequences.m<String> i4;
        f0.p(lineSequence, "$this$lineSequence");
        i4 = kotlin.sequences.s.i(new q(lineSequence));
        return i4;
    }

    @NotNull
    public static final byte[] i(@NotNull URL readBytes) {
        f0.p(readBytes, "$this$readBytes");
        InputStream it = readBytes.openStream();
        try {
            f0.o(it, "it");
            byte[] p3 = kotlin.io.a.p(it);
            b.a(it, null);
            return p3;
        } finally {
        }
    }

    @NotNull
    public static final List<String> j(@NotNull Reader readLines) {
        f0.p(readLines, "$this$readLines");
        ArrayList arrayList = new ArrayList();
        g(readLines, new a(arrayList));
        return arrayList;
    }

    @NotNull
    public static final String k(@NotNull Reader readText) {
        f0.p(readText, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        f(readText, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        f0.o(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    @InlineOnly
    private static final String l(URL url, Charset charset) {
        return new String(i(url), charset);
    }

    static /* synthetic */ String m(URL url, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.a;
        }
        return new String(i(url), charset);
    }

    @InlineOnly
    private static final StringReader n(String str) {
        return new StringReader(str);
    }

    public static final <T> T o(@NotNull Reader useLines, @NotNull l1.l<? super kotlin.sequences.m<String>, ? extends T> block) {
        f0.p(useLines, "$this$useLines");
        f0.p(block, "block");
        BufferedReader bufferedReader = useLines instanceof BufferedReader ? (BufferedReader) useLines : new BufferedReader(useLines, 8192);
        try {
            T invoke = block.invoke(h(bufferedReader));
            c0.d(1);
            if (kotlin.internal.b.a(1, 1, 0)) {
                b.a(bufferedReader, null);
            } else {
                bufferedReader.close();
            }
            c0.c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c0.d(1);
                if (kotlin.internal.b.a(1, 1, 0)) {
                    b.a(bufferedReader, th);
                } else {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                c0.c(1);
                throw th2;
            }
        }
    }
}
