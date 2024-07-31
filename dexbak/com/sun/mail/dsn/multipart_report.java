package com.sun.mail.dsn;

import java.io.IOException;
import java.io.OutputStream;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import myjava.awt.datatransfer.DataFlavor;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class multipart_report implements DataContentHandler {
    private ActivationDataFlavor myDF = new ActivationDataFlavor(MultipartReport.class, "multipart/report", "Multipart Report");

    @Override // javax.activation.DataContentHandler
    public Object getContent(DataSource dataSource) throws IOException {
        try {
            return new MultipartReport(dataSource);
        } catch (MessagingException e) {
            IOException iOException = new IOException("Exception while constructing MultipartReport");
            iOException.initCause(e);
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
            } catch (MessagingException e) {
                throw new IOException(e.toString());
            }
        }
    }
}
