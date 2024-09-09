package com.sun.mail.imap.protocol;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BASE64MailboxDecoder.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f50479a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', ','};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f50480b = new byte[256];

    static {
        int i4 = 0;
        for (int i5 = 0; i5 < 255; i5++) {
            f50480b[i5] = -1;
        }
        while (true) {
            char[] cArr = f50479a;
            if (i4 >= cArr.length) {
                return;
            }
            f50480b[cArr[i4]] = (byte) i4;
            i4++;
        }
    }

    protected static int a(char[] cArr, int i4, CharacterIterator characterIterator) {
        byte b4;
        boolean z3 = true;
        while (true) {
            int i5 = -1;
            while (true) {
                byte next = (byte) characterIterator.next();
                if (next == -1) {
                    return i4;
                }
                if (next == 45) {
                    if (z3) {
                        int i6 = i4 + 1;
                        cArr[i4] = '&';
                        return i6;
                    }
                    return i4;
                }
                z3 = false;
                byte next2 = (byte) characterIterator.next();
                if (next2 == -1 || next2 == 45) {
                    return i4;
                }
                byte[] bArr = f50480b;
                byte b5 = bArr[next & 255];
                byte b6 = bArr[next2 & 255];
                byte b7 = (byte) (((b5 << 2) & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF) | ((b6 >>> 4) & 3));
                if (i5 != -1) {
                    cArr[i4] = (char) ((i5 << 8) | (b7 & 255));
                    i4++;
                    i5 = -1;
                } else {
                    i5 = b7 & 255;
                }
                byte next3 = (byte) characterIterator.next();
                if (next3 != 61) {
                    if (next3 == -1 || next3 == 45) {
                        return i4;
                    }
                    byte b8 = bArr[next3 & 255];
                    byte b9 = (byte) (((b6 << 4) & 240) | ((b8 >>> 2) & 15));
                    if (i5 != -1) {
                        cArr[i4] = (char) ((i5 << 8) | (b9 & 255));
                        i4++;
                        i5 = -1;
                    } else {
                        i5 = b9 & 255;
                    }
                    byte next4 = (byte) characterIterator.next();
                    if (next4 == 61) {
                        continue;
                    } else if (next4 == -1 || next4 == 45) {
                        return i4;
                    } else {
                        b4 = (byte) (((b8 << 6) & 192) | (bArr[next4 & 255] & 63));
                        if (i5 != -1) {
                            break;
                        }
                        i5 = b4 & 255;
                    }
                }
            }
            cArr[i4] = (char) ((i5 << 8) | (b4 & 255));
            i4++;
        }
    }

    public static String b(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] cArr = new char[str.length()];
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        boolean z3 = false;
        int i4 = 0;
        for (char first = stringCharacterIterator.first(); first != '\uffff'; first = stringCharacterIterator.next()) {
            if (first == '&') {
                z3 = true;
                i4 = a(cArr, i4, stringCharacterIterator);
            } else {
                cArr[i4] = first;
                i4++;
            }
        }
        return z3 ? new String(cArr, 0, i4) : str;
    }
}
