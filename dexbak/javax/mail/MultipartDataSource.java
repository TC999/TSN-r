package javax.mail;

import javax.activation.DataSource;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface MultipartDataSource extends DataSource {
    BodyPart getBodyPart(int i) throws MessagingException;

    int getCount();
}
