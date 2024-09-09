package javax.activation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface DataSource {
    String getContentType();

    InputStream getInputStream() throws IOException;

    String getName();

    OutputStream getOutputStream() throws IOException;
}
