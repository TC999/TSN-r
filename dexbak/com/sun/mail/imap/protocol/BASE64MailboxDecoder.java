package com.sun.mail.imap.protocol;

import com.alibaba.fastjson.asm.Opcodes;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import io.netty.util.internal.StringUtil;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import kotlin.UByte;
import kotlin.text.Typography;
import okio.Utf8;

/* renamed from: com.sun.mail.imap.protocol.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BASE64MailboxDecoder {

    /* renamed from: a */
    static final char[] f36067a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', StringUtil.COMMA};

    /* renamed from: b */
    private static final byte[] f36068b = new byte[256];

    static {
        int i = 0;
        for (int i2 = 0; i2 < 255; i2++) {
            f36068b[i2] = -1;
        }
        while (true) {
            char[] cArr = f36067a;
            if (i >= cArr.length) {
                return;
            }
            f36068b[cArr[i]] = (byte) i;
            i++;
        }
    }

    /* renamed from: a */
    protected static int m16227a(char[] cArr, int i, CharacterIterator characterIterator) {
        byte b;
        boolean z = true;
        while (true) {
            int i2 = -1;
            while (true) {
                byte next = (byte) characterIterator.next();
                if (next == -1) {
                    return i;
                }
                if (next == 45) {
                    if (z) {
                        int i3 = i + 1;
                        cArr[i] = Typography.f41567c;
                        return i3;
                    }
                    return i;
                }
                z = false;
                byte next2 = (byte) characterIterator.next();
                if (next2 == -1 || next2 == 45) {
                    return i;
                }
                byte[] bArr = f36068b;
                byte b2 = bArr[next & UByte.f41242c];
                byte b3 = bArr[next2 & UByte.f41242c];
                byte b4 = (byte) (((b2 << 2) & 252) | ((b3 >>> 4) & 3));
                if (i2 != -1) {
                    cArr[i] = (char) ((i2 << 8) | (b4 & UByte.f41242c));
                    i++;
                    i2 = -1;
                } else {
                    i2 = b4 & UByte.f41242c;
                }
                byte next3 = (byte) characterIterator.next();
                if (next3 != 61) {
                    if (next3 == -1 || next3 == 45) {
                        return i;
                    }
                    byte b5 = bArr[next3 & UByte.f41242c];
                    byte b6 = (byte) (((b3 << 4) & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) | ((b5 >>> 2) & 15));
                    if (i2 != -1) {
                        cArr[i] = (char) ((i2 << 8) | (b6 & UByte.f41242c));
                        i++;
                        i2 = -1;
                    } else {
                        i2 = b6 & UByte.f41242c;
                    }
                    byte next4 = (byte) characterIterator.next();
                    if (next4 == 61) {
                        continue;
                    } else if (next4 == -1 || next4 == 45) {
                        return i;
                    } else {
                        b = (byte) (((b5 << 6) & Opcodes.CHECKCAST) | (bArr[next4 & UByte.f41242c] & Utf8.REPLACEMENT_BYTE));
                        if (i2 != -1) {
                            break;
                        }
                        i2 = b & UByte.f41242c;
                    }
                }
            }
            cArr[i] = (char) ((i2 << 8) | (b & UByte.f41242c));
            i++;
        }
    }

    /* renamed from: b */
    public static String m16226b(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] cArr = new char[str.length()];
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        boolean z = false;
        int i = 0;
        for (char first = stringCharacterIterator.first(); first != 65535; first = stringCharacterIterator.next()) {
            if (first == '&') {
                z = true;
                i = m16227a(cArr, i, stringCharacterIterator);
            } else {
                cArr[i] = first;
                i++;
            }
        }
        return z ? new String(cArr, 0, i) : str;
    }
}
