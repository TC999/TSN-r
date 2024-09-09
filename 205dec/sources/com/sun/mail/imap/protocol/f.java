package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.ProtocolException;
import java.io.IOException;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: FetchResponse.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class f extends i {

    /* renamed from: u  reason: collision with root package name */
    private static final char[] f50526u = {'.', 'H', 'E', 'A', 'D', 'E', 'R'};

    /* renamed from: v  reason: collision with root package name */
    private static final char[] f50527v = {'.', 'T', 'E', 'X', 'T'};

    /* renamed from: t  reason: collision with root package name */
    private l[] f50528t;

    public f(com.sun.mail.iap.f fVar) throws IOException, ProtocolException {
        super(fVar);
        l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x003a, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.sun.mail.imap.protocol.l K(com.sun.mail.iap.g[] r7, int r8, java.lang.Class r9) {
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
            boolean r3 = r3 instanceof com.sun.mail.imap.protocol.f
            if (r3 == 0) goto L3a
            r3 = r7[r2]
            com.sun.mail.imap.protocol.f r3 = (com.sun.mail.imap.protocol.f) r3
            int r3 = r3.E()
            if (r3 == r8) goto L1f
            goto L3a
        L1f:
            r3 = r7[r2]
            com.sun.mail.imap.protocol.f r3 = (com.sun.mail.imap.protocol.f) r3
            r4 = 0
        L24:
            com.sun.mail.imap.protocol.l[] r5 = r3.f50528t
            int r6 = r5.length
            if (r4 < r6) goto L2a
            goto L3a
        L2a:
            r5 = r5[r4]
            boolean r5 = r9.isInstance(r5)
            if (r5 == 0) goto L37
            com.sun.mail.imap.protocol.l[] r7 = r3.f50528t
            r7 = r7[r4]
            return r7
        L37:
            int r4 = r4 + 1
            goto L24
        L3a:
            int r2 = r2 + 1
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.f.K(com.sun.mail.iap.g[], int, java.lang.Class):com.sun.mail.imap.protocol.l");
    }

    private boolean M(char[] cArr) {
        int length = cArr.length;
        int i4 = this.f50297a;
        int i5 = 0;
        while (i5 < length) {
            int i6 = i4 + 1;
            int i7 = i5 + 1;
            if (Character.toUpperCase((char) this.f50300d[i4]) != cArr[i5]) {
                return false;
            }
            i5 = i7;
            i4 = i6;
        }
        return true;
    }

    private void l() throws ParsingException {
        byte[] bArr;
        int i4;
        B();
        if (this.f50300d[this.f50297a] == 40) {
            Vector vector = new Vector();
            Object obj = null;
            do {
                int i5 = this.f50297a + 1;
                this.f50297a = i5;
                if (i5 < this.f50299c) {
                    byte b4 = this.f50300d[i5];
                    if (b4 == 66) {
                        char[] cArr = c.f50486e;
                        if (M(cArr)) {
                            byte[] bArr2 = this.f50300d;
                            int i6 = this.f50297a;
                            if (bArr2[i6 + 4] == 91) {
                                this.f50297a = i6 + cArr.length;
                                obj = new c(this);
                            } else {
                                char[] cArr2 = d.f50491r;
                                if (M(cArr2)) {
                                    this.f50297a += cArr2.length;
                                } else {
                                    this.f50297a += cArr.length;
                                }
                                obj = new d(this);
                            }
                        }
                    } else if (b4 == 73) {
                        char[] cArr3 = k.f50554c;
                        if (M(cArr3)) {
                            this.f50297a += cArr3.length;
                            obj = new k(this);
                        }
                    } else if (b4 == 82) {
                        char[] cArr4 = r.f50586c;
                        if (M(cArr4)) {
                            this.f50297a += cArr4.length;
                            obj = new r(this);
                        } else {
                            char[] cArr5 = q.f50583c;
                            if (M(cArr5)) {
                                this.f50297a += cArr5.length;
                                char[] cArr6 = f50526u;
                                if (M(cArr6)) {
                                    this.f50297a += cArr6.length;
                                } else {
                                    char[] cArr7 = f50527v;
                                    if (M(cArr7)) {
                                        this.f50297a += cArr7.length;
                                    }
                                }
                                obj = new q(this);
                            }
                        }
                    } else if (b4 == 85) {
                        char[] cArr8 = v.f50598c;
                        if (M(cArr8)) {
                            this.f50297a += cArr8.length;
                            obj = new v(this);
                        }
                    } else if (b4 == 69) {
                        char[] cArr9 = e.f50513l;
                        if (M(cArr9)) {
                            this.f50297a += cArr9.length;
                            obj = new e(this);
                        }
                    } else if (b4 == 70) {
                        char[] cArr10 = FLAGS.name;
                        if (M(cArr10)) {
                            this.f50297a += cArr10.length;
                            obj = new FLAGS(this);
                        }
                    }
                    if (obj != null) {
                        vector.addElement(obj);
                    }
                    bArr = this.f50300d;
                    i4 = this.f50297a;
                } else {
                    throw new ParsingException("error in FETCH parsing, ran off end of buffer, size " + this.f50299c);
                }
            } while (bArr[i4] != 41);
            this.f50297a = i4 + 1;
            l[] lVarArr = new l[vector.size()];
            this.f50528t = lVarArr;
            vector.copyInto(lVarArr);
            return;
        }
        throw new ParsingException("error in FETCH parsing, missing '(' at index " + this.f50297a);
    }

    public l I(int i4) {
        return this.f50528t[i4];
    }

    public l J(Class cls) {
        int i4 = 0;
        while (true) {
            l[] lVarArr = this.f50528t;
            if (i4 >= lVarArr.length) {
                return null;
            }
            if (cls.isInstance(lVarArr[i4])) {
                return this.f50528t[i4];
            }
            i4++;
        }
    }

    public int L() {
        return this.f50528t.length;
    }

    public f(i iVar) throws IOException, ProtocolException {
        super(iVar);
        l();
    }
}
