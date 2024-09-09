package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class AsciiHeadersEncoder {
    private final ByteBuf buf;
    private final NewlineType newlineType;
    private final SeparatorType separatorType;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* renamed from: io.netty.handler.codec.AsciiHeadersEncoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType;

        static {
            int[] iArr = new int[NewlineType.values().length];
            $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType = iArr;
            try {
                iArr[NewlineType.LF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType[NewlineType.CRLF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[SeparatorType.values().length];
            $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType = iArr2;
            try {
                iArr2[SeparatorType.COLON.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType[SeparatorType.COLON_SPACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum NewlineType {
        LF,
        CRLF
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum SeparatorType {
        COLON,
        COLON_SPACE
    }

    public AsciiHeadersEncoder(ByteBuf byteBuf) {
        this(byteBuf, SeparatorType.COLON_SPACE, NewlineType.CRLF);
    }

    private static int c2b(char c4) {
        if (c4 < '\u0100') {
            return (byte) c4;
        }
        return 63;
    }

    private static void writeAscii(ByteBuf byteBuf, int i4, CharSequence charSequence, int i5) {
        if (charSequence instanceof AsciiString) {
            writeAsciiString(byteBuf, i4, (AsciiString) charSequence, i5);
        } else {
            writeCharSequence(byteBuf, i4, charSequence, i5);
        }
    }

    private static void writeAsciiString(ByteBuf byteBuf, int i4, AsciiString asciiString, int i5) {
        ByteBufUtil.copy(asciiString, 0, byteBuf, i4, i5);
    }

    private static void writeCharSequence(ByteBuf byteBuf, int i4, CharSequence charSequence, int i5) {
        int i6 = 0;
        while (i6 < i5) {
            byteBuf.setByte(i4, c2b(charSequence.charAt(i6)));
            i6++;
            i4++;
        }
    }

    public void encode(Map.Entry<CharSequence, CharSequence> entry) {
        int i4;
        int i5;
        CharSequence key = entry.getKey();
        CharSequence value = entry.getValue();
        ByteBuf byteBuf = this.buf;
        int length = key.length();
        int length2 = value.length();
        int writerIndex = byteBuf.writerIndex();
        byteBuf.ensureWritable(length + length2 + 4);
        writeAscii(byteBuf, writerIndex, key, length);
        int i6 = writerIndex + length;
        int i7 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType[this.separatorType.ordinal()];
        if (i7 == 1) {
            byteBuf.setByte(i6, 58);
            i4 = i6 + 1;
        } else if (i7 == 2) {
            int i8 = i6 + 1;
            byteBuf.setByte(i6, 58);
            i4 = i8 + 1;
            byteBuf.setByte(i8, 32);
        } else {
            throw new Error();
        }
        writeAscii(byteBuf, i4, value, length2);
        int i9 = i4 + length2;
        int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType[this.newlineType.ordinal()];
        if (i10 == 1) {
            byteBuf.setByte(i9, 10);
            i5 = i9 + 1;
        } else if (i10 == 2) {
            int i11 = i9 + 1;
            byteBuf.setByte(i9, 13);
            i5 = i11 + 1;
            byteBuf.setByte(i11, 10);
        } else {
            throw new Error();
        }
        byteBuf.writerIndex(i5);
    }

    public AsciiHeadersEncoder(ByteBuf byteBuf, SeparatorType separatorType, NewlineType newlineType) {
        if (byteBuf == null) {
            throw new NullPointerException("buf");
        }
        if (separatorType == null) {
            throw new NullPointerException("separatorType");
        }
        if (newlineType != null) {
            this.buf = byteBuf;
            this.separatorType = separatorType;
            this.newlineType = newlineType;
            return;
        }
        throw new NullPointerException("newlineType");
    }
}
