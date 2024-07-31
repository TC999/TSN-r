package kotlin.p613io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Console.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010'R\u0018\u0010,\u001a\u00060)j\u0002`*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010+¨\u0006/"}, m12616d2 = {"Lkotlin/io/p;", "", "", "endOfInput", "", "d", "c", "nBytes", "nChars", "e", "Ljava/nio/charset/Charset;", "charset", "Lkotlin/f1;", "i", "g", "h", "Ljava/io/InputStream;", "inputStream", "", "f", "a", "I", "BUFFER_SIZE", "Ljava/nio/charset/CharsetDecoder;", "b", "Ljava/nio/charset/CharsetDecoder;", "decoder", "Z", "directEOL", "", "[B", "bytes", "", "[C", "chars", "Ljava/nio/ByteBuffer;", "Ljava/nio/ByteBuffer;", "byteBuf", "Ljava/nio/CharBuffer;", "Ljava/nio/CharBuffer;", "charBuf", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuilder;", "sb", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.io.p */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14328p {

    /* renamed from: a */
    private static final int f41096a = 32;

    /* renamed from: b */
    private static CharsetDecoder f41097b;

    /* renamed from: c */
    private static boolean f41098c;

    /* renamed from: d */
    private static final byte[] f41099d;

    /* renamed from: e */
    private static final char[] f41100e;

    /* renamed from: f */
    private static final ByteBuffer f41101f;

    /* renamed from: g */
    private static final CharBuffer f41102g;

    /* renamed from: h */
    private static final StringBuilder f41103h;
    @NotNull

    /* renamed from: i */
    public static final C14328p f41104i = new C14328p();

    static {
        byte[] bArr = new byte[32];
        f41099d = bArr;
        char[] cArr = new char[32];
        f41100e = cArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        C14342f0.m8185o(wrap, "ByteBuffer.wrap(bytes)");
        f41101f = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(cArr);
        C14342f0.m8185o(wrap2, "CharBuffer.wrap(chars)");
        f41102g = wrap2;
        f41103h = new StringBuilder();
    }

    private C14328p() {
    }

    /* renamed from: a */
    public static final /* synthetic */ CharsetDecoder m8371a(C14328p c14328p) {
        CharsetDecoder charsetDecoder = f41097b;
        if (charsetDecoder == null) {
            C14342f0.m8200S("decoder");
        }
        return charsetDecoder;
    }

    /* renamed from: c */
    private final int m8369c() {
        ByteBuffer byteBuffer = f41101f;
        byteBuffer.compact();
        int position = byteBuffer.position();
        byteBuffer.position(0);
        return position;
    }

    /* renamed from: d */
    private final int m8368d(boolean z) {
        while (true) {
            CharsetDecoder charsetDecoder = f41097b;
            if (charsetDecoder == null) {
                C14342f0.m8200S("decoder");
            }
            ByteBuffer byteBuffer = f41101f;
            CharBuffer charBuffer = f41102g;
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, z);
            C14342f0.m8185o(decode, "decoder.decode(byteBuf, charBuf, endOfInput)");
            if (decode.isError()) {
                m8365g();
                decode.throwException();
            }
            int position = charBuffer.position();
            if (!decode.isOverflow()) {
                return position;
            }
            StringBuilder sb = f41103h;
            char[] cArr = f41100e;
            int i = position - 1;
            sb.append(cArr, 0, i);
            charBuffer.position(0);
            charBuffer.limit(32);
            charBuffer.put(cArr[i]);
        }
    }

    /* renamed from: e */
    private final int m8367e(int i, int i2) {
        ByteBuffer byteBuffer = f41101f;
        byteBuffer.limit(i);
        f41102g.position(i2);
        int m8368d = m8368d(true);
        CharsetDecoder charsetDecoder = f41097b;
        if (charsetDecoder == null) {
            C14342f0.m8200S("decoder");
        }
        charsetDecoder.reset();
        byteBuffer.position(0);
        return m8368d;
    }

    /* renamed from: g */
    private final void m8365g() {
        CharsetDecoder charsetDecoder = f41097b;
        if (charsetDecoder == null) {
            C14342f0.m8200S("decoder");
        }
        charsetDecoder.reset();
        f41101f.position(0);
        f41103h.setLength(0);
    }

    /* renamed from: h */
    private final void m8364h() {
        StringBuilder sb = f41103h;
        sb.setLength(32);
        sb.trimToSize();
    }

    /* renamed from: i */
    private final void m8363i(Charset charset) {
        CharsetDecoder newDecoder = charset.newDecoder();
        C14342f0.m8185o(newDecoder, "charset.newDecoder()");
        f41097b = newDecoder;
        ByteBuffer byteBuffer = f41101f;
        byteBuffer.clear();
        CharBuffer charBuffer = f41102g;
        charBuffer.clear();
        byteBuffer.put((byte) 10);
        byteBuffer.flip();
        CharsetDecoder charsetDecoder = f41097b;
        if (charsetDecoder == null) {
            C14342f0.m8200S("decoder");
        }
        boolean z = false;
        charsetDecoder.decode(byteBuffer, charBuffer, false);
        if (charBuffer.position() == 1 && charBuffer.get(0) == '\n') {
            z = true;
        }
        f41098c = z;
        m8365g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
        if ((!kotlin.jvm.internal.C14342f0.m8193g(r0.charset(), r11)) != false) goto L68;
     */
    @org.jetbrains.annotations.Nullable
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m8366f(@org.jetbrains.annotations.NotNull java.io.InputStream r10, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r11) {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p613io.C14328p.m8366f(java.io.InputStream, java.nio.charset.Charset):java.lang.String");
    }
}
