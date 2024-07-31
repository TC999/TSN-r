package javax.mail;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Date;
import javax.mail.Flags;
import javax.mail.search.SearchTerm;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class Message implements Part {
    protected boolean expunged;
    protected Folder folder;
    protected int msgnum;
    protected Session session;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class RecipientType implements Serializable {
        private static final long serialVersionUID = -7479791750606340008L;
        protected String type;

        /* renamed from: TO */
        public static final RecipientType f40788TO = new RecipientType("To");

        /* renamed from: CC */
        public static final RecipientType f40787CC = new RecipientType("Cc");
        public static final RecipientType BCC = new RecipientType("Bcc");

        /* JADX INFO: Access modifiers changed from: protected */
        public RecipientType(String str) {
            this.type = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Object readResolve() throws ObjectStreamException {
            if (this.type.equals("To")) {
                return f40788TO;
            }
            if (this.type.equals("Cc")) {
                return f40787CC;
            }
            if (this.type.equals("Bcc")) {
                return BCC;
            }
            throw new InvalidObjectException("Attempt to resolve unknown RecipientType: " + this.type);
        }

        public String toString() {
            return this.type;
        }
    }

    protected Message() {
        this.msgnum = 0;
        this.expunged = false;
        this.folder = null;
        this.session = null;
    }

    public abstract void addFrom(Address[] addressArr) throws MessagingException;

    public void addRecipient(RecipientType recipientType, Address address) throws MessagingException {
        addRecipients(recipientType, new Address[]{address});
    }

    public abstract void addRecipients(RecipientType recipientType, Address[] addressArr) throws MessagingException;

    public Address[] getAllRecipients() throws MessagingException {
        int i;
        Address[] recipients = getRecipients(RecipientType.f40788TO);
        Address[] recipients2 = getRecipients(RecipientType.f40787CC);
        Address[] recipients3 = getRecipients(RecipientType.BCC);
        if (recipients2 == null && recipients3 == null) {
            return recipients;
        }
        Address[] addressArr = new Address[(recipients != null ? recipients.length : 0) + (recipients2 != null ? recipients2.length : 0) + (recipients3 != null ? recipients3.length : 0)];
        if (recipients != null) {
            System.arraycopy(recipients, 0, addressArr, 0, recipients.length);
            i = recipients.length + 0;
        } else {
            i = 0;
        }
        if (recipients2 != null) {
            System.arraycopy(recipients2, 0, addressArr, i, recipients2.length);
            i += recipients2.length;
        }
        if (recipients3 != null) {
            System.arraycopy(recipients3, 0, addressArr, i, recipients3.length);
        }
        return addressArr;
    }

    public abstract Flags getFlags() throws MessagingException;

    public Folder getFolder() {
        return this.folder;
    }

    public abstract Address[] getFrom() throws MessagingException;

    public int getMessageNumber() {
        return this.msgnum;
    }

    public abstract Date getReceivedDate() throws MessagingException;

    public abstract Address[] getRecipients(RecipientType recipientType) throws MessagingException;

    public Address[] getReplyTo() throws MessagingException {
        return getFrom();
    }

    public abstract Date getSentDate() throws MessagingException;

    public abstract String getSubject() throws MessagingException;

    public boolean isExpunged() {
        return this.expunged;
    }

    public boolean isSet(Flags.Flag flag) throws MessagingException {
        return getFlags().contains(flag);
    }

    public boolean match(SearchTerm searchTerm) throws MessagingException {
        return searchTerm.match(this);
    }

    public abstract Message reply(boolean z) throws MessagingException;

    public abstract void saveChanges() throws MessagingException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void setExpunged(boolean z) {
        this.expunged = z;
    }

    public void setFlag(Flags.Flag flag, boolean z) throws MessagingException {
        setFlags(new Flags(flag), z);
    }

    public abstract void setFlags(Flags flags, boolean z) throws MessagingException;

    public abstract void setFrom() throws MessagingException;

    public abstract void setFrom(Address address) throws MessagingException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMessageNumber(int i) {
        this.msgnum = i;
    }

    public void setRecipient(RecipientType recipientType, Address address) throws MessagingException {
        setRecipients(recipientType, new Address[]{address});
    }

    public abstract void setRecipients(RecipientType recipientType, Address[] addressArr) throws MessagingException;

    public void setReplyTo(Address[] addressArr) throws MessagingException {
        throw new MethodNotSupportedException("setReplyTo not supported");
    }

    public abstract void setSentDate(Date date) throws MessagingException;

    public abstract void setSubject(String str) throws MessagingException;

    /* JADX INFO: Access modifiers changed from: protected */
    public Message(Folder folder, int i) {
        this.expunged = false;
        this.session = null;
        this.folder = folder;
        this.msgnum = i;
        this.session = folder.store.session;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Message(Session session) {
        this.msgnum = 0;
        this.expunged = false;
        this.folder = null;
        this.session = session;
    }
}
