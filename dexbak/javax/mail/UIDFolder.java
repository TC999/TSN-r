package javax.mail;

import javax.mail.FetchProfile;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface UIDFolder {
    public static final long LASTUID = -1;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class FetchProfileItem extends FetchProfile.Item {
        public static final FetchProfileItem UID = new FetchProfileItem("UID");

        protected FetchProfileItem(String str) {
            super(str);
        }
    }

    Message getMessageByUID(long j) throws MessagingException;

    Message[] getMessagesByUID(long j, long j2) throws MessagingException;

    Message[] getMessagesByUID(long[] jArr) throws MessagingException;

    long getUID(Message message) throws MessagingException;

    long getUIDValidity() throws MessagingException;
}
