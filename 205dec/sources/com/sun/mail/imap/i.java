package com.sun.mail.imap;

import com.sun.mail.iap.ProtocolException;
import javax.mail.Flags;
import javax.mail.FolderClosedException;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IMAPNestedMessage.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class i extends g {

    /* renamed from: o  reason: collision with root package name */
    private g f50420o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, com.sun.mail.imap.protocol.d dVar, com.sun.mail.imap.protocol.e eVar, String str) {
        super(gVar.d());
        this.f50420o = gVar;
        this.f50399a = dVar;
        this.f50400b = eVar;
        this.f50406h = str;
    }

    @Override // com.sun.mail.imap.g
    protected boolean A() throws FolderClosedException {
        return this.f50420o.A();
    }

    @Override // com.sun.mail.imap.g, javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        return this.f50399a.f50501f;
    }

    @Override // javax.mail.Message
    public boolean isExpunged() {
        return this.f50420o.isExpunged();
    }

    @Override // com.sun.mail.imap.g
    protected void n() throws MessageRemovedException {
        this.f50420o.n();
    }

    @Override // com.sun.mail.imap.g
    protected int r() {
        return this.f50420o.r();
    }

    @Override // com.sun.mail.imap.g, javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized void setFlags(Flags flags, boolean z3) throws MessagingException {
        throw new MethodNotSupportedException("Cannot set flags on this nested message");
    }

    @Override // com.sun.mail.imap.g
    protected Object t() {
        return this.f50420o.t();
    }

    @Override // com.sun.mail.imap.g
    protected com.sun.mail.imap.protocol.h v() throws ProtocolException, FolderClosedException {
        return this.f50420o.v();
    }

    @Override // com.sun.mail.imap.g
    protected int w() {
        return this.f50420o.w();
    }
}
