package kotlin.p613io;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.umeng.ccg.CcgConstant;
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
import kotlin.Unit;
import kotlin.internal.C14307b;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.C14520s;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: ReadWrite.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u0017\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0017\u0010\u0007\u001a\u00020\u0006*\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u001e\u0010\f\u001a\u00020\n*\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u001a\u0010\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\r*\u00020\u0000\u001a:\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f*\u00020\u00002\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0010\u0012\u0004\u0012\u00028\u00000\bH\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a\r\u0010\u0016\u001a\u00020\u0015*\u00020\tH\u0087\b\u001a\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0010*\u00020\u0003\u001a\n\u0010\u0018\u001a\u00020\t*\u00020\u0000\u001a\u001c\u0010\u001b\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u0017\u0010\u001f\u001a\u00020\t*\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0087\b\u001a\n\u0010!\u001a\u00020 *\u00020\u001c\u0082\u0002\u000f\n\u0006\b\u0011(\u00120\u0001\n\u0005\b\u009920\u0001¨\u0006\""}, m12616d2 = {"Ljava/io/Reader;", "", "bufferSize", "Ljava/io/BufferedReader;", "a", "Ljava/io/Writer;", "Ljava/io/BufferedWriter;", "b", "Lkotlin/Function1;", "", "Lkotlin/f1;", CcgConstant.f38549t, "g", "", "j", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/m;", "block", "Requires newer compiler version to be inlined correctly.", "o", "(Ljava/io/Reader;Ll1/l;)Ljava/lang/Object;", "Ljava/io/StringReader;", "n", "h", "k", "out", "", "e", "Ljava/net/URL;", "Ljava/nio/charset/Charset;", "charset", C7304t.f25048d, "", "i", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "TextStreamsKt")
/* renamed from: kotlin.io.t */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14333t {

    /* compiled from: ReadWrite.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"", "it", "Lkotlin/f1;", "a", "(Ljava/lang/String;)V"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.io.t$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14334a extends Lambda implements InterfaceC15280l<String, Unit> {

        /* renamed from: a */
        final /* synthetic */ ArrayList f41112a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14334a(ArrayList arrayList) {
            super(1);
            this.f41112a = arrayList;
        }

        /* renamed from: a */
        public final void m8235a(@NotNull String it) {
            C14342f0.m8184p(it, "it");
            this.f41112a.add(it);
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            m8235a(str);
            return Unit.f41048a;
        }
    }

    @InlineOnly
    /* renamed from: a */
    private static final BufferedReader m8250a(Reader reader, int i) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i);
    }

    @InlineOnly
    /* renamed from: b */
    private static final BufferedWriter m8249b(Writer writer, int i) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i);
    }

    /* renamed from: c */
    static /* synthetic */ BufferedReader m8248c(Reader reader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i);
    }

    /* renamed from: d */
    static /* synthetic */ BufferedWriter m8247d(Writer writer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i);
    }

    /* renamed from: e */
    public static final long m8246e(@NotNull Reader copyTo, @NotNull Writer out, int i) {
        C14342f0.m8184p(copyTo, "$this$copyTo");
        C14342f0.m8184p(out, "out");
        char[] cArr = new char[i];
        int read = copyTo.read(cArr);
        long j = 0;
        while (read >= 0) {
            out.write(cArr, 0, read);
            j += read;
            read = copyTo.read(cArr);
        }
        return j;
    }

    /* renamed from: f */
    public static /* synthetic */ long m8245f(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return m8246e(reader, writer, i);
    }

    /* renamed from: g */
    public static final void m8244g(@NotNull Reader forEachLine, @NotNull InterfaceC15280l<? super String, Unit> action) {
        C14342f0.m8184p(forEachLine, "$this$forEachLine");
        C14342f0.m8184p(action, "action");
        BufferedReader bufferedReader = forEachLine instanceof BufferedReader ? (BufferedReader) forEachLine : new BufferedReader(forEachLine, 8192);
        try {
            for (String str : m8243h(bufferedReader)) {
                action.invoke(str);
            }
            Unit unit = Unit.f41048a;
            Closeable.m8492a(bufferedReader, null);
        } finally {
        }
    }

    @NotNull
    /* renamed from: h */
    public static final Sequence<String> m8243h(@NotNull BufferedReader lineSequence) {
        Sequence<String> m6989i;
        C14342f0.m8184p(lineSequence, "$this$lineSequence");
        m6989i = C14520s.m6989i(new ReadWrite(lineSequence));
        return m6989i;
    }

    @NotNull
    /* renamed from: i */
    public static final byte[] m8242i(@NotNull URL readBytes) {
        C14342f0.m8184p(readBytes, "$this$readBytes");
        InputStream it = readBytes.openStream();
        try {
            C14342f0.m8185o(it, "it");
            byte[] m8506p = IOStreams.m8506p(it);
            Closeable.m8492a(it, null);
            return m8506p;
        } finally {
        }
    }

    @NotNull
    /* renamed from: j */
    public static final List<String> m8241j(@NotNull Reader readLines) {
        C14342f0.m8184p(readLines, "$this$readLines");
        ArrayList arrayList = new ArrayList();
        m8244g(readLines, new C14334a(arrayList));
        return arrayList;
    }

    @NotNull
    /* renamed from: k */
    public static final String m8240k(@NotNull Reader readText) {
        C14342f0.m8184p(readText, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        m8245f(readText, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        C14342f0.m8185o(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    @InlineOnly
    /* renamed from: l */
    private static final String m8239l(URL url, Charset charset) {
        return new String(m8242i(url), charset);
    }

    /* renamed from: m */
    static /* synthetic */ String m8238m(URL url, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        return new String(m8242i(url), charset);
    }

    @InlineOnly
    /* renamed from: n */
    private static final StringReader m8237n(String str) {
        return new StringReader(str);
    }

    /* renamed from: o */
    public static final <T> T m8236o(@NotNull Reader useLines, @NotNull InterfaceC15280l<? super Sequence<String>, ? extends T> block) {
        C14342f0.m8184p(useLines, "$this$useLines");
        C14342f0.m8184p(block, "block");
        BufferedReader bufferedReader = useLines instanceof BufferedReader ? (BufferedReader) useLines : new BufferedReader(useLines, 8192);
        try {
            T invoke = block.invoke(m8243h(bufferedReader));
            InlineMarker.m8228d(1);
            if (C14307b.m8534a(1, 1, 0)) {
                Closeable.m8492a(bufferedReader, null);
            } else {
                bufferedReader.close();
            }
            InlineMarker.m8229c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.m8228d(1);
                if (C14307b.m8534a(1, 1, 0)) {
                    Closeable.m8492a(bufferedReader, th);
                } else {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.m8229c(1);
                throw th2;
            }
        }
    }
}
