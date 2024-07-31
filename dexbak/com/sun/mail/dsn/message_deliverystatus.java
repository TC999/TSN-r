package com.sun.mail.dsn;

import java.io.IOException;
import java.io.OutputStream;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataContentHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import myjava.awt.datatransfer.DataFlavor;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class message_deliverystatus implements DataContentHandler {
    ActivationDataFlavor ourDataFlavor = new ActivationDataFlavor(DeliveryStatus.class, "message/delivery-status", "Delivery Status");

    @Override // javax.activation.DataContentHandler
    public Object getContent(DataSource dataSource) throws IOException {
        try {
            return new DeliveryStatus(dataSource.getInputStream());
        } catch (MessagingException e) {
            throw new IOException("Exception creating DeliveryStatus in message/devliery-status DataContentHandler: " + e.toString());
        }
    }

    @Override // javax.activation.DataContentHandler
    public Object getTransferData(DataFlavor dataFlavor, DataSource dataSource) throws IOException {
        if (this.ourDataFlavor.equals(dataFlavor)) {
            return getContent(dataSource);
        }
        return null;
    }

    @Override // javax.activation.DataContentHandler
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{this.ourDataFlavor};
    }

    @Override // javax.activation.DataContentHandler
    public void writeTo(Object obj, String str, OutputStream outputStream) throws IOException {
        if (obj instanceof DeliveryStatus) {
            try {
                ((DeliveryStatus) obj).writeTo(outputStream);
                return;
            } catch (MessagingException e) {
                throw new IOException(e.toString());
            }
        }
        throw new IOException("unsupported object");
    }
}
