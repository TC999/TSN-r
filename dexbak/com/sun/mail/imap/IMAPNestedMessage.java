package com.sun.mail.imap;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import com.sun.mail.imap.protocol.ENVELOPE;
import com.sun.mail.imap.protocol.IMAPProtocol;
import javax.mail.Flags;
import javax.mail.FolderClosedException;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;

/* renamed from: com.sun.mail.imap.i */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IMAPNestedMessage extends IMAPMessage {

    /* renamed from: o */
    private IMAPMessage f36006o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMAPNestedMessage(IMAPMessage iMAPMessage, BODYSTRUCTURE bodystructure, ENVELOPE envelope, String str) {
        super(iMAPMessage.m16313d());
        this.f36006o = iMAPMessage;
        this.f35985a = bodystructure;
        this.f35986b = envelope;
        this.f35992h = str;
    }

    @Override // com.sun.mail.imap.IMAPMessage
    /* renamed from: A */
    protected boolean mo16295A() throws FolderClosedException {
        return this.f36006o.mo16295A();
    }

    @Override // com.sun.mail.imap.IMAPMessage, javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        return this.f35985a.f36089f;
    }

    @Override // javax.mail.Message
    public boolean isExpunged() {
        return this.f36006o.isExpunged();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    /* renamed from: n */
    protected void mo16294n() throws MessageRemovedException {
        this.f36006o.mo16294n();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    /* renamed from: r */
    protected int mo16293r() {
        return this.f36006o.mo16293r();
    }

    @Override // com.sun.mail.imap.IMAPMessage, javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized void setFlags(Flags flags, boolean z) throws MessagingException {
        throw new MethodNotSupportedException("Cannot set flags on this nested message");
    }

    @Override // com.sun.mail.imap.IMAPMessage
    /* renamed from: t */
    protected Object mo16292t() {
        return this.f36006o.mo16292t();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    /* renamed from: v */
    protected IMAPProtocol mo16291v() throws ProtocolException, FolderClosedException {
        return this.f36006o.mo16291v();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    /* renamed from: w */
    protected int mo16290w() {
        return this.f36006o.mo16290w();
    }
}
