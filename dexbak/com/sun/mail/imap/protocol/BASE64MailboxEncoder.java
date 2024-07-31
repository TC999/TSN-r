package com.sun.mail.imap.protocol;

import io.netty.util.internal.StringUtil;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;
import okio.Utf8;

/* renamed from: com.sun.mail.imap.protocol.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BASE64MailboxEncoder {

    /* renamed from: e */
    private static final char[] f36069e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', StringUtil.COMMA};

    /* renamed from: a */
    protected byte[] f36070a = new byte[4];

    /* renamed from: b */
    protected int f36071b = 0;

    /* renamed from: c */
    protected boolean f36072c = false;

    /* renamed from: d */
    protected Writer f36073d;

    public BASE64MailboxEncoder(Writer writer) {
        this.f36073d = writer;
    }

    /* renamed from: a */
    public static String m16225a(String str) {
        char[] charArray = str.toCharArray();
        CharArrayWriter charArrayWriter = new CharArrayWriter(charArray.length);
        BASE64MailboxEncoder bASE64MailboxEncoder = null;
        boolean z = false;
        for (char c : charArray) {
            if (c < ' ' || c > '~') {
                if (bASE64MailboxEncoder == null) {
                    bASE64MailboxEncoder = new BASE64MailboxEncoder(charArrayWriter);
                    z = true;
                }
                bASE64MailboxEncoder.m16222d(c);
            } else {
                if (bASE64MailboxEncoder != null) {
                    bASE64MailboxEncoder.m16223c();
                }
                if (c == '&') {
                    charArrayWriter.write(38);
                    charArrayWriter.write(45);
                    z = true;
                } else {
                    charArrayWriter.write(c);
                }
            }
        }
        if (bASE64MailboxEncoder != null) {
            bASE64MailboxEncoder.m16223c();
        }
        return z ? charArrayWriter.toString() : str;
    }

    /* renamed from: b */
    protected void m16224b() throws IOException {
        int i = this.f36071b;
        if (i == 1) {
            byte b = this.f36070a[0];
            Writer writer = this.f36073d;
            char[] cArr = f36069e;
            writer.write(cArr[(b >>> 2) & 63]);
            this.f36073d.write(cArr[((b << 4) & 48) + 0]);
        } else if (i == 2) {
            byte[] bArr = this.f36070a;
            byte b2 = bArr[0];
            byte b3 = bArr[1];
            Writer writer2 = this.f36073d;
            char[] cArr2 = f36069e;
            writer2.write(cArr2[(b2 >>> 2) & 63]);
            this.f36073d.write(cArr2[((b2 << 4) & 48) + ((b3 >>> 4) & 15)]);
            this.f36073d.write(cArr2[((b3 << 2) & 60) + 0]);
        } else {
            byte[] bArr2 = this.f36070a;
            byte b4 = bArr2[0];
            byte b5 = bArr2[1];
            byte b6 = bArr2[2];
            Writer writer3 = this.f36073d;
            char[] cArr3 = f36069e;
            writer3.write(cArr3[(b4 >>> 2) & 63]);
            this.f36073d.write(cArr3[((b4 << 4) & 48) + ((b5 >>> 4) & 15)]);
            this.f36073d.write(cArr3[((b5 << 2) & 60) + ((b6 >>> 6) & 3)]);
            this.f36073d.write(cArr3[b6 & Utf8.REPLACEMENT_BYTE]);
            if (this.f36071b == 4) {
                byte[] bArr3 = this.f36070a;
                bArr3[0] = bArr3[3];
            }
        }
    }

    /* renamed from: c */
    public void m16223c() {
        try {
            if (this.f36071b > 0) {
                m16224b();
                this.f36071b = 0;
            }
            if (this.f36072c) {
                this.f36073d.write(45);
                this.f36072c = false;
            }
        } catch (IOException unused) {
        }
    }

    /* renamed from: d */
    public void m16222d(int i) {
        try {
            if (!this.f36072c) {
                this.f36072c = true;
                this.f36073d.write(38);
            }
            byte[] bArr = this.f36070a;
            int i2 = this.f36071b;
            int i3 = i2 + 1;
            this.f36071b = i3;
            bArr[i2] = (byte) (i >> 8);
            int i4 = i3 + 1;
            this.f36071b = i4;
            bArr[i3] = (byte) (i & 255);
            if (i4 >= 3) {
                m16224b();
                this.f36071b -= 3;
            }
        } catch (IOException unused) {
        }
    }
}
