package javax.mail;

import javax.activation.DataSource;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface MultipartDataSource extends DataSource {
    BodyPart getBodyPart(int i4) throws MessagingException;

    int getCount();
}
