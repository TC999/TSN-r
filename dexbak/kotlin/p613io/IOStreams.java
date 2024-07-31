package kotlin.p613io;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import kotlin.Annotations;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.collections.AbstractC14218t;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\u0002\u001a\u0017\u0010\u0007\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\bH\u0087\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u0010\u001a\u00020\u0000*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u0012\u001a\u00020\u0011*\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0014\u001a\u00020\u0013*\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0017\u001a\u00020\u0016*\u00020\u00152\b\b\u0002\u0010\u000f\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u0019\u001a\u00020\u0018*\u00020\u00152\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u001b\u001a\u00020\u001a*\u00020\u00152\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0087\b\u001a\u001c\u0010\u001e\u001a\u00020\u001d*\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010\u000f\u001a\u00020\n\u001a\u0016\u0010 \u001a\u00020\b*\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\nH\u0007\u001a\f\u0010!\u001a\u00020\b*\u00020\u000eH\u0007¨\u0006\""}, m12616d2 = {"Ljava/io/BufferedInputStream;", "Lkotlin/collections/t;", "o", "", "Ljava/nio/charset/Charset;", "charset", "Ljava/io/ByteArrayInputStream;", "i", "", "m", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET, "length", "n", "Ljava/io/InputStream;", "bufferSize", "a", "Ljava/io/InputStreamReader;", "s", "Ljava/io/BufferedReader;", "e", "Ljava/io/OutputStream;", "Ljava/io/BufferedOutputStream;", "b", "Ljava/io/OutputStreamWriter;", "u", "Ljava/io/BufferedWriter;", "g", "out", "", "k", "estimatedSize", CampaignEx.JSON_KEY_AD_Q, "p", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "ByteStreamsKt")
/* renamed from: kotlin.io.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class IOStreams {

    /* compiled from: IOStreams.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u001a"}, m12616d2 = {"kotlin/io/a$a", "Lkotlin/collections/t;", "Lkotlin/f1;", "g", "", "hasNext", "", "c", "", "a", "I", "e", "()I", "i", "(I)V", "nextByte", "b", "Z", "f", "()Z", "j", "(Z)V", "nextPrepared", "d", "h", "finished", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.io.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14308a extends AbstractC14218t {

        /* renamed from: a */
        private int f41063a = -1;

        /* renamed from: b */
        private boolean f41064b;

        /* renamed from: c */
        private boolean f41065c;

        /* renamed from: d */
        final /* synthetic */ BufferedInputStream f41066d;

        C14308a(BufferedInputStream bufferedInputStream) {
            this.f41066d = bufferedInputStream;
        }

        /* renamed from: g */
        private final void m8496g() {
            if (this.f41064b || this.f41065c) {
                return;
            }
            int read = this.f41066d.read();
            this.f41063a = read;
            this.f41064b = true;
            this.f41065c = read == -1;
        }

        @Override // kotlin.collections.AbstractC14218t
        /* renamed from: c */
        public byte mo8232c() {
            m8496g();
            if (!this.f41065c) {
                byte b = (byte) this.f41063a;
                this.f41064b = false;
                return b;
            }
            throw new NoSuchElementException("Input stream is over.");
        }

        /* renamed from: d */
        public final boolean m8499d() {
            return this.f41065c;
        }

        /* renamed from: e */
        public final int m8498e() {
            return this.f41063a;
        }

        /* renamed from: f */
        public final boolean m8497f() {
            return this.f41064b;
        }

        /* renamed from: h */
        public final void m8495h(boolean z) {
            this.f41065c = z;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            m8496g();
            return !this.f41065c;
        }

        /* renamed from: i */
        public final void m8494i(int i) {
            this.f41063a = i;
        }

        /* renamed from: j */
        public final void m8493j(boolean z) {
            this.f41064b = z;
        }
    }

    @InlineOnly
    /* renamed from: a */
    private static final BufferedInputStream m8521a(InputStream inputStream, int i) {
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i);
    }

    @InlineOnly
    /* renamed from: b */
    private static final BufferedOutputStream m8520b(OutputStream outputStream, int i) {
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i);
    }

    /* renamed from: c */
    static /* synthetic */ BufferedInputStream m8519c(InputStream inputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i);
    }

    /* renamed from: d */
    static /* synthetic */ BufferedOutputStream m8518d(OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i);
    }

    @InlineOnly
    /* renamed from: e */
    private static final BufferedReader m8517e(InputStream inputStream, Charset charset) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    /* renamed from: f */
    static /* synthetic */ BufferedReader m8516f(InputStream inputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    @InlineOnly
    /* renamed from: g */
    private static final BufferedWriter m8515g(OutputStream outputStream, Charset charset) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    /* renamed from: h */
    static /* synthetic */ BufferedWriter m8514h(OutputStream outputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    @InlineOnly
    /* renamed from: i */
    private static final ByteArrayInputStream m8513i(String str, Charset charset) {
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            C14342f0.m8185o(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteArrayInputStream(bytes);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: j */
    static /* synthetic */ ByteArrayInputStream m8512j(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            C14342f0.m8185o(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteArrayInputStream(bytes);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: k */
    public static final long m8511k(@NotNull InputStream copyTo, @NotNull OutputStream out, int i) {
        C14342f0.m8184p(copyTo, "$this$copyTo");
        C14342f0.m8184p(out, "out");
        byte[] bArr = new byte[i];
        int read = copyTo.read(bArr);
        long j = 0;
        while (read >= 0) {
            out.write(bArr, 0, read);
            j += read;
            read = copyTo.read(bArr);
        }
        return j;
    }

    /* renamed from: l */
    public static /* synthetic */ long m8510l(InputStream inputStream, OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return m8511k(inputStream, outputStream, i);
    }

    @InlineOnly
    /* renamed from: m */
    private static final ByteArrayInputStream m8509m(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    @InlineOnly
    /* renamed from: n */
    private static final ByteArrayInputStream m8508n(byte[] bArr, int i, int i2) {
        return new ByteArrayInputStream(bArr, i, i2);
    }

    @NotNull
    /* renamed from: o */
    public static final AbstractC14218t m8507o(@NotNull BufferedInputStream iterator) {
        C14342f0.m8184p(iterator, "$this$iterator");
        return new C14308a(iterator);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: p */
    public static final byte[] m8506p(@NotNull InputStream readBytes) {
        C14342f0.m8184p(readBytes, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, readBytes.available()));
        m8510l(readBytes, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        C14342f0.m8185o(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    @Annotations(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @ReplaceWith(expression = "readBytes()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = "1.3")
    @NotNull
    /* renamed from: q */
    public static final byte[] m8505q(@NotNull InputStream readBytes, int i) {
        C14342f0.m8184p(readBytes, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i, readBytes.available()));
        m8510l(readBytes, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        C14342f0.m8185o(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    /* renamed from: r */
    public static /* synthetic */ byte[] m8504r(InputStream inputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        return m8505q(inputStream, i);
    }

    @InlineOnly
    /* renamed from: s */
    private static final InputStreamReader m8503s(InputStream inputStream, Charset charset) {
        return new InputStreamReader(inputStream, charset);
    }

    /* renamed from: t */
    static /* synthetic */ InputStreamReader m8502t(InputStream inputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        return new InputStreamReader(inputStream, charset);
    }

    @InlineOnly
    /* renamed from: u */
    private static final OutputStreamWriter m8501u(OutputStream outputStream, Charset charset) {
        return new OutputStreamWriter(outputStream, charset);
    }

    /* renamed from: v */
    static /* synthetic */ OutputStreamWriter m8500v(OutputStream outputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f41591a;
        }
        return new OutputStreamWriter(outputStream, charset);
    }
}
