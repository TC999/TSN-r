package com.sun.mail.pop3;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.mail.util.SharedByteArrayInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Protocol.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class h extends ByteArrayOutputStream {
    public h(int i4) {
        super(i4);
    }

    public InputStream a() {
        return new SharedByteArrayInputStream(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
    }
}
