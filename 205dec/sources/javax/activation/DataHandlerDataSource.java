package javax.activation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DataHandler.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DataHandlerDataSource implements DataSource {
    DataHandler dataHandler;

    public DataHandlerDataSource(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    @Override // javax.activation.DataSource
    public String getContentType() {
        return this.dataHandler.getContentType();
    }

    @Override // javax.activation.DataSource
    public InputStream getInputStream() throws IOException {
        return this.dataHandler.getInputStream();
    }

    @Override // javax.activation.DataSource
    public String getName() {
        return this.dataHandler.getName();
    }

    @Override // javax.activation.DataSource
    public OutputStream getOutputStream() throws IOException {
        return this.dataHandler.getOutputStream();
    }
}
