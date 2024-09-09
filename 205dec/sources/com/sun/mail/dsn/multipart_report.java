package com.sun.mail.dsn;

import java.io.IOException;
import java.io.OutputStream;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import myjava.awt.datatransfer.DataFlavor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class multipart_report implements DataContentHandler {
    private ActivationDataFlavor myDF = new ActivationDataFlavor(MultipartReport.class, "multipart/report", "Multipart Report");

    @Override // javax.activation.DataContentHandler
    public Object getContent(DataSource dataSource) throws IOException {
        try {
            return new MultipartReport(dataSource);
        } catch (MessagingException e4) {
            IOException iOException = new IOException("Exception while constructing MultipartReport");
            iOException.initCause(e4);
            throw iOException;
        }
    }

    @Override // javax.activation.DataContentHandler
    public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) throws IOException {
        if (this.myDF.equals(dataFlavor)) {
            return getContent(dataSource);
        }
        return null;
    }

    @Override // javax.activation.DataContentHandler
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{this.myDF};
    }

    @Override // javax.activation.DataContentHandler
    public void writeTo(Object obj, String str, OutputStream outputStream) throws IOException {
        if (obj instanceof MultipartReport) {
            try {
                ((MultipartReport) obj).writeTo(outputStream);
            } catch (MessagingException e4) {
                throw new IOException(e4.toString());
            }
        }
    }
}
