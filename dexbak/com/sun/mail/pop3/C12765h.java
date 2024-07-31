package com.sun.mail.pop3;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.mail.util.SharedByteArrayInputStream;

/* compiled from: Protocol.java */
/* renamed from: com.sun.mail.pop3.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C12765h extends ByteArrayOutputStream {
    public C12765h(int i) {
        super(i);
    }

    /* renamed from: a */
    public InputStream m16051a() {
        return new SharedByteArrayInputStream(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
    }
}
