package kotlin.io;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Console.kt */
@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010,\u001a\u00060(j\u0002`)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lkotlin/io/n;", "", "", "endOfInput", "", "b", "a", "nBytes", "nChars", "c", "Ljava/nio/charset/Charset;", "charset", "Lkotlin/f1;", "g", "e", "f", "Ljava/io/InputStream;", "inputStream", "", "d", "I", "BUFFER_SIZE", "Ljava/nio/charset/CharsetDecoder;", "Ljava/nio/charset/CharsetDecoder;", "decoder", "Z", "directEOL", "", "[B", "bytes", "", "[C", "chars", "Ljava/nio/ByteBuffer;", "Ljava/nio/ByteBuffer;", "byteBuf", "Ljava/nio/CharBuffer;", "h", "Ljava/nio/CharBuffer;", "charBuf", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "i", "Ljava/lang/StringBuilder;", "sb", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final n f55580a = new n();

    /* renamed from: b  reason: collision with root package name */
    private static final int f55581b = 32;

    /* renamed from: c  reason: collision with root package name */
    private static CharsetDecoder f55582c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f55583d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f55584e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final char[] f55585f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final ByteBuffer f55586g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final CharBuffer f55587h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private static final StringBuilder f55588i;

    /* compiled from: Utils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/io/File;", "<anonymous parameter 0>", "Ljava/io/IOException;", "exception", "", "a", "(Ljava/io/File;Ljava/io/IOException;)Ljava/lang/Void;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a extends Lambda implements l1.p {

        /* renamed from: a  reason: collision with root package name */
        public static final a f55589a = new a();

        a() {
            super(2);
        }

        @Override // l1.p
        @NotNull
        /* renamed from: a */
        public final Void invoke(@NotNull File file, @NotNull IOException exception) {
            f0.p(file, "<anonymous parameter 0>");
            f0.p(exception, "exception");
            throw exception;
        }
    }

    /* compiled from: Utils.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/io/File;", "f", "Ljava/io/IOException;", "e", "Lkotlin/f1;", "a", "(Ljava/io/File;Ljava/io/IOException;)V"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class b extends Lambda implements l1.p<File, IOException, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l1.p f55590a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(l1.p pVar) {
            super(2);
            this.f55590a = pVar;
        }

        public final void a(@NotNull File f4, @NotNull IOException e4) {
            f0.p(f4, "f");
            f0.p(e4, "e");
            if (((OnErrorAction) this.f55590a.invoke(f4, e4)) == OnErrorAction.TERMINATE) {
                throw new s(f4);
            }
        }

        @Override // l1.p
        public /* bridge */ /* synthetic */ f1 invoke(File file, IOException iOException) {
            a(file, iOException);
            return f1.f55527a;
        }
    }

    static {
        byte[] bArr = new byte[32];
        f55584e = bArr;
        char[] cArr = new char[32];
        f55585f = cArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        f0.o(wrap, "wrap(bytes)");
        f55586g = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(cArr);
        f0.o(wrap2, "wrap(chars)");
        f55587h = wrap2;
        f55588i = new StringBuilder();
    }

    private n() {
    }

    private final int a() {
        ByteBuffer byteBuffer = f55586g;
        byteBuffer.compact();
        int position = byteBuffer.position();
        byteBuffer.position(0);
        return position;
    }

    private final int b(boolean z3) {
        while (true) {
            CharsetDecoder charsetDecoder = f55582c;
            if (charsetDecoder == null) {
                f0.S("decoder");
                charsetDecoder = null;
            }
            ByteBuffer byteBuffer = f55586g;
            CharBuffer charBuffer = f55587h;
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, z3);
            f0.o(decode, "decoder.decode(byteBuf, charBuf, endOfInput)");
            if (decode.isError()) {
                e();
                decode.throwException();
            }
            int position = charBuffer.position();
            if (!decode.isOverflow()) {
                return position;
            }
            StringBuilder sb = f55588i;
            char[] cArr = f55585f;
            int i4 = position - 1;
            sb.append(cArr, 0, i4);
            charBuffer.position(0);
            charBuffer.limit(32);
            charBuffer.put(cArr[i4]);
        }
    }

    private final int c(int i4, int i5) {
        ByteBuffer byteBuffer = f55586g;
        byteBuffer.limit(i4);
        f55587h.position(i5);
        int b4 = b(true);
        CharsetDecoder charsetDecoder = f55582c;
        if (charsetDecoder == null) {
            f0.S("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuffer.position(0);
        return b4;
    }

    private final void e() {
        CharsetDecoder charsetDecoder = f55582c;
        if (charsetDecoder == null) {
            f0.S("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        f55586g.position(0);
        f55588i.setLength(0);
    }

    private final void f() {
        StringBuilder sb = f55588i;
        sb.setLength(32);
        sb.trimToSize();
    }

    private final void g(Charset charset) {
        CharsetDecoder newDecoder = charset.newDecoder();
        f0.o(newDecoder, "charset.newDecoder()");
        f55582c = newDecoder;
        ByteBuffer byteBuffer = f55586g;
        byteBuffer.clear();
        CharBuffer charBuffer = f55587h;
        charBuffer.clear();
        byteBuffer.put((byte) 10);
        byteBuffer.flip();
        CharsetDecoder charsetDecoder = f55582c;
        if (charsetDecoder == null) {
            f0.S("decoder");
            charsetDecoder = null;
        }
        boolean z3 = false;
        charsetDecoder.decode(byteBuffer, charBuffer, false);
        if (charBuffer.position() == 1 && charBuffer.get(0) == '\n') {
            z3 = true;
        }
        f55583d = z3;
        e();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
        if (kotlin.jvm.internal.f0.g(r0.charset(), r12) == false) goto L67;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String d(@org.jetbrains.annotations.NotNull java.io.InputStream r11, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r12) {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.n.d(java.io.InputStream, java.nio.charset.Charset):java.lang.String");
    }
}
