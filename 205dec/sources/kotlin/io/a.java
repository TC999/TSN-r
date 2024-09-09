package kotlin.io;

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
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: IOStreams.kt */
@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\u0002\u001a\u0017\u0010\u0007\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\bH\u0087\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u0010\u001a\u00020\u0000*\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u0012\u001a\u00020\u0011*\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0014\u001a\u00020\u0013*\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0017\u001a\u00020\u0016*\u00020\u00152\b\b\u0002\u0010\u000f\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u0019\u001a\u00020\u0018*\u00020\u00152\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u001b\u001a\u00020\u001a*\u00020\u00152\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0087\b\u001a\u001c\u0010\u001e\u001a\u00020\u001d*\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010\u000f\u001a\u00020\n\u001a\u0016\u0010 \u001a\u00020\b*\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\nH\u0007\u001a\f\u0010!\u001a\u00020\b*\u00020\u000eH\u0007\u00a8\u0006\""}, d2 = {"Ljava/io/BufferedInputStream;", "Lkotlin/collections/t;", "o", "", "Ljava/nio/charset/Charset;", "charset", "Ljava/io/ByteArrayInputStream;", "i", "", "m", "", "offset", "length", "n", "Ljava/io/InputStream;", "bufferSize", "a", "Ljava/io/InputStreamReader;", "s", "Ljava/io/BufferedReader;", "e", "Ljava/io/OutputStream;", "Ljava/io/BufferedOutputStream;", "b", "Ljava/io/OutputStreamWriter;", "u", "Ljava/io/BufferedWriter;", "g", "out", "", "k", "estimatedSize", CampaignEx.JSON_KEY_AD_Q, "p", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "ByteStreamsKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: IOStreams.kt */
    @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"kotlin/io/a$a", "Lkotlin/collections/t;", "Lkotlin/f1;", "g", "", "hasNext", "", "c", "", "a", "I", "e", "()I", "j", "(I)V", "nextByte", "b", "Z", "f", "()Z", "k", "(Z)V", "nextPrepared", "d", "h", "finished", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlin.io.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1100a extends kotlin.collections.t {

        /* renamed from: a  reason: collision with root package name */
        private int f55546a = -1;

        /* renamed from: b  reason: collision with root package name */
        private boolean f55547b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f55548c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ BufferedInputStream f55549d;

        C1100a(BufferedInputStream bufferedInputStream) {
            this.f55549d = bufferedInputStream;
        }

        private final void g() {
            if (this.f55547b || this.f55548c) {
                return;
            }
            int read = this.f55549d.read();
            this.f55546a = read;
            this.f55547b = true;
            this.f55548c = read == -1;
        }

        @Override // kotlin.collections.t
        public byte c() {
            g();
            if (!this.f55548c) {
                byte b4 = (byte) this.f55546a;
                this.f55547b = false;
                return b4;
            }
            throw new NoSuchElementException("Input stream is over.");
        }

        public final boolean d() {
            return this.f55548c;
        }

        public final int e() {
            return this.f55546a;
        }

        public final boolean f() {
            return this.f55547b;
        }

        public final void h(boolean z3) {
            this.f55548c = z3;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            g();
            return !this.f55548c;
        }

        public final void j(int i4) {
            this.f55546a = i4;
        }

        public final void k(boolean z3) {
            this.f55547b = z3;
        }
    }

    @InlineOnly
    private static final BufferedInputStream a(InputStream inputStream, int i4) {
        f0.p(inputStream, "<this>");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i4);
    }

    @InlineOnly
    private static final BufferedOutputStream b(OutputStream outputStream, int i4) {
        f0.p(outputStream, "<this>");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i4);
    }

    static /* synthetic */ BufferedInputStream c(InputStream inputStream, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 8192;
        }
        f0.p(inputStream, "<this>");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i4);
    }

    static /* synthetic */ BufferedOutputStream d(OutputStream outputStream, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 8192;
        }
        f0.p(outputStream, "<this>");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i4);
    }

    @InlineOnly
    private static final BufferedReader e(InputStream inputStream, Charset charset) {
        f0.p(inputStream, "<this>");
        f0.p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    static /* synthetic */ BufferedReader f(InputStream inputStream, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        f0.p(inputStream, "<this>");
        f0.p(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    @InlineOnly
    private static final BufferedWriter g(OutputStream outputStream, Charset charset) {
        f0.p(outputStream, "<this>");
        f0.p(charset, "charset");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    static /* synthetic */ BufferedWriter h(OutputStream outputStream, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        f0.p(outputStream, "<this>");
        f0.p(charset, "charset");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    @InlineOnly
    private static final ByteArrayInputStream i(String str, Charset charset) {
        f0.p(str, "<this>");
        f0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    static /* synthetic */ ByteArrayInputStream j(String str, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        f0.p(str, "<this>");
        f0.p(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    public static final long k(@NotNull InputStream inputStream, @NotNull OutputStream out, int i4) {
        f0.p(inputStream, "<this>");
        f0.p(out, "out");
        byte[] bArr = new byte[i4];
        int read = inputStream.read(bArr);
        long j4 = 0;
        while (read >= 0) {
            out.write(bArr, 0, read);
            j4 += read;
            read = inputStream.read(bArr);
        }
        return j4;
    }

    public static /* synthetic */ long l(InputStream inputStream, OutputStream outputStream, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 8192;
        }
        return k(inputStream, outputStream, i4);
    }

    @InlineOnly
    private static final ByteArrayInputStream m(byte[] bArr) {
        f0.p(bArr, "<this>");
        return new ByteArrayInputStream(bArr);
    }

    @InlineOnly
    private static final ByteArrayInputStream n(byte[] bArr, int i4, int i5) {
        f0.p(bArr, "<this>");
        return new ByteArrayInputStream(bArr, i4, i5);
    }

    @NotNull
    public static final kotlin.collections.t o(@NotNull BufferedInputStream bufferedInputStream) {
        f0.p(bufferedInputStream, "<this>");
        return new C1100a(bufferedInputStream);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final byte[] p(@NotNull InputStream inputStream) {
        f0.p(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        l(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        f0.o(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    @Deprecated(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @ReplaceWith(expression = "readBytes()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = "1.3")
    @NotNull
    public static final byte[] q(@NotNull InputStream inputStream, int i4) {
        f0.p(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i4, inputStream.available()));
        l(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        f0.o(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    public static /* synthetic */ byte[] r(InputStream inputStream, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 8192;
        }
        return q(inputStream, i4);
    }

    @InlineOnly
    private static final InputStreamReader s(InputStream inputStream, Charset charset) {
        f0.p(inputStream, "<this>");
        f0.p(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    static /* synthetic */ InputStreamReader t(InputStream inputStream, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        f0.p(inputStream, "<this>");
        f0.p(charset, "charset");
        return new InputStreamReader(inputStream, charset);
    }

    @InlineOnly
    private static final OutputStreamWriter u(OutputStream outputStream, Charset charset) {
        f0.p(outputStream, "<this>");
        f0.p(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }

    static /* synthetic */ OutputStreamWriter v(OutputStream outputStream, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charset = kotlin.text.d.f58930b;
        }
        f0.p(outputStream, "<this>");
        f0.p(charset, "charset");
        return new OutputStreamWriter(outputStream, charset);
    }
}
