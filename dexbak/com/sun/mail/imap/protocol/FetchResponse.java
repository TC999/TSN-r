package com.sun.mail.imap.protocol;

import com.sun.mail.iap.C12727f;
import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.ProtocolException;
import java.io.IOException;
import java.util.Vector;

/* renamed from: com.sun.mail.imap.protocol.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FetchResponse extends IMAPResponse {

    /* renamed from: u */
    private static final char[] f36114u = {'.', 'H', 'E', 'A', 'D', 'E', 'R'};

    /* renamed from: v */
    private static final char[] f36115v = {'.', 'T', 'E', 'X', 'T'};

    /* renamed from: t */
    private Item[] f36116t;

    public FetchResponse(C12727f c12727f) throws IOException, ProtocolException {
        super(c12727f);
        m16208l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x003a, code lost:
        continue;
     */
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.sun.mail.imap.protocol.Item m16211K(com.sun.mail.iap.C12728g[] r7, int r8, java.lang.Class r9) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            r1 = 0
            r2 = 0
        L6:
            int r3 = r7.length
            if (r2 < r3) goto La
            return r0
        La:
            r3 = r7[r2]
            if (r3 == 0) goto L3a
            r3 = r7[r2]
            boolean r3 = r3 instanceof com.sun.mail.imap.protocol.FetchResponse
            if (r3 == 0) goto L3a
            r3 = r7[r2]
            com.sun.mail.imap.protocol.f r3 = (com.sun.mail.imap.protocol.FetchResponse) r3
            int r3 = r3.m16121E()
            if (r3 == r8) goto L1f
            goto L3a
        L1f:
            r3 = r7[r2]
            com.sun.mail.imap.protocol.f r3 = (com.sun.mail.imap.protocol.FetchResponse) r3
            r4 = 0
        L24:
            com.sun.mail.imap.protocol.l[] r5 = r3.f36116t
            int r6 = r5.length
            if (r4 < r6) goto L2a
            goto L3a
        L2a:
            r5 = r5[r4]
            boolean r5 = r9.isInstance(r5)
            if (r5 == 0) goto L37
            com.sun.mail.imap.protocol.l[] r7 = r3.f36116t
            r7 = r7[r4]
            return r7
        L37:
            int r4 = r4 + 1
            goto L24
        L3a:
            int r2 = r2 + 1
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.FetchResponse.m16211K(com.sun.mail.iap.g[], int, java.lang.Class):com.sun.mail.imap.protocol.l");
    }

    /* renamed from: M */
    private boolean m16209M(char[] cArr) {
        int length = cArr.length;
        int i = this.f35876a;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            int i4 = i2 + 1;
            if (Character.toUpperCase((char) this.f35879d[i]) != cArr[i2]) {
                return false;
            }
            i2 = i4;
            i = i3;
        }
        return true;
    }

    /* renamed from: l */
    private void m16208l() throws ParsingException {
        byte[] bArr;
        int i;
        m16408B();
        if (this.f35879d[this.f35876a] == 40) {
            Vector vector = new Vector();
            Object obj = null;
            do {
                int i2 = this.f35876a + 1;
                this.f35876a = i2;
                if (i2 < this.f35878c) {
                    byte b = this.f35879d[i2];
                    if (b == 66) {
                        char[] cArr = BODY.f36074e;
                        if (m16209M(cArr)) {
                            byte[] bArr2 = this.f35879d;
                            int i3 = this.f35876a;
                            if (bArr2[i3 + 4] == 91) {
                                this.f35876a = i3 + cArr.length;
                                obj = new BODY(this);
                            } else {
                                char[] cArr2 = BODYSTRUCTURE.f36079r;
                                if (m16209M(cArr2)) {
                                    this.f35876a += cArr2.length;
                                } else {
                                    this.f35876a += cArr.length;
                                }
                                obj = new BODYSTRUCTURE(this);
                            }
                        }
                    } else if (b == 73) {
                        char[] cArr3 = INTERNALDATE.f36144c;
                        if (m16209M(cArr3)) {
                            this.f35876a += cArr3.length;
                            obj = new INTERNALDATE(this);
                        }
                    } else if (b == 82) {
                        char[] cArr4 = RFC822SIZE.f36176c;
                        if (m16209M(cArr4)) {
                            this.f35876a += cArr4.length;
                            obj = new RFC822SIZE(this);
                        } else {
                            char[] cArr5 = RFC822DATA.f36173c;
                            if (m16209M(cArr5)) {
                                this.f35876a += cArr5.length;
                                char[] cArr6 = f36114u;
                                if (m16209M(cArr6)) {
                                    this.f35876a += cArr6.length;
                                } else {
                                    char[] cArr7 = f36115v;
                                    if (m16209M(cArr7)) {
                                        this.f35876a += cArr7.length;
                                    }
                                }
                                obj = new RFC822DATA(this);
                            }
                        }
                    } else if (b == 85) {
                        char[] cArr8 = UID.f36188c;
                        if (m16209M(cArr8)) {
                            this.f35876a += cArr8.length;
                            obj = new UID(this);
                        }
                    } else if (b == 69) {
                        char[] cArr9 = ENVELOPE.f36101l;
                        if (m16209M(cArr9)) {
                            this.f35876a += cArr9.length;
                            obj = new ENVELOPE(this);
                        }
                    } else if (b == 70) {
                        char[] cArr10 = FLAGS.name;
                        if (m16209M(cArr10)) {
                            this.f35876a += cArr10.length;
                            obj = new FLAGS(this);
                        }
                    }
                    if (obj != null) {
                        vector.addElement(obj);
                    }
                    bArr = this.f35879d;
                    i = this.f35876a;
                } else {
                    throw new ParsingException("error in FETCH parsing, ran off end of buffer, size " + this.f35878c);
                }
            } while (bArr[i] != 41);
            this.f35876a = i + 1;
            Item[] itemArr = new Item[vector.size()];
            this.f36116t = itemArr;
            vector.copyInto(itemArr);
            return;
        }
        throw new ParsingException("error in FETCH parsing, missing '(' at index " + this.f35876a);
    }

    /* renamed from: I */
    public Item m16213I(int i) {
        return this.f36116t[i];
    }

    /* renamed from: J */
    public Item m16212J(Class cls) {
        int i = 0;
        while (true) {
            Item[] itemArr = this.f36116t;
            if (i >= itemArr.length) {
                return null;
            }
            if (cls.isInstance(itemArr[i])) {
                return this.f36116t[i];
            }
            i++;
        }
    }

    /* renamed from: L */
    public int m16210L() {
        return this.f36116t.length;
    }

    public FetchResponse(IMAPResponse iMAPResponse) throws IOException, ProtocolException {
        super(iMAPResponse);
        m16208l();
    }
}
