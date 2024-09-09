package javax.mail;

import javax.mail.FetchProfile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface UIDFolder {
    public static final long LASTUID = -1;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class FetchProfileItem extends FetchProfile.Item {
        public static final FetchProfileItem UID = new FetchProfileItem("UID");

        protected FetchProfileItem(String str) {
            super(str);
        }
    }

    Message getMessageByUID(long j4) throws MessagingException;

    Message[] getMessagesByUID(long j4, long j5) throws MessagingException;

    Message[] getMessagesByUID(long[] jArr) throws MessagingException;

    long getUID(Message message) throws MessagingException;

    long getUIDValidity() throws MessagingException;
}
