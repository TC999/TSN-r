package com.sun.mail.pop3;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;

/* compiled from: DefaultFolder.java */
/* renamed from: com.sun.mail.pop3.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12762a extends Folder {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C12762a(POP3Store pOP3Store) {
        super(pOP3Store);
    }

    @Override // javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Append not supported");
    }

    /* renamed from: b */
    protected Folder m16083b() throws MessagingException {
        return getStore().getFolder("INBOX");
    }

    @Override // javax.mail.Folder
    public void close(boolean z) throws MessagingException {
        throw new MethodNotSupportedException("close");
    }

    @Override // javax.mail.Folder
    public boolean create(int i) throws MessagingException {
        return false;
    }

    @Override // javax.mail.Folder
    public boolean delete(boolean z) throws MessagingException {
        throw new MethodNotSupportedException("delete");
    }

    @Override // javax.mail.Folder
    public boolean exists() {
        return true;
    }

    @Override // javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("expunge");
    }

    @Override // javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        if (str.equalsIgnoreCase("INBOX")) {
            return m16083b();
        }
        throw new MessagingException("only INBOX supported");
    }

    @Override // javax.mail.Folder
    public String getFullName() {
        return "";
    }

    @Override // javax.mail.Folder
    public Message getMessage(int i) throws MessagingException {
        throw new MethodNotSupportedException("getMessage");
    }

    @Override // javax.mail.Folder
    public int getMessageCount() throws MessagingException {
        return 0;
    }

    @Override // javax.mail.Folder
    public String getName() {
        return "";
    }

    @Override // javax.mail.Folder
    public Folder getParent() {
        return null;
    }

    @Override // javax.mail.Folder
    public Flags getPermanentFlags() {
        return new Flags();
    }

    @Override // javax.mail.Folder
    public char getSeparator() {
        return '/';
    }

    @Override // javax.mail.Folder
    public int getType() {
        return 2;
    }

    @Override // javax.mail.Folder
    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    @Override // javax.mail.Folder
    public boolean isOpen() {
        return false;
    }

    @Override // javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        return new Folder[]{m16083b()};
    }

    @Override // javax.mail.Folder
    public void open(int i) throws MessagingException {
        throw new MethodNotSupportedException("open");
    }

    @Override // javax.mail.Folder
    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("renameTo");
    }
}
