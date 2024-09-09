package javax.mail.internet;

import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface SharedInputStream {
    long getPosition();

    InputStream newStream(long j4, long j5);
}
