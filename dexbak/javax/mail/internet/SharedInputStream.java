package javax.mail.internet;

import java.io.InputStream;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface SharedInputStream {
    long getPosition();

    InputStream newStream(long j, long j2);
}
