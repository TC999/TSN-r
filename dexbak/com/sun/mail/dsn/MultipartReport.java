package com.sun.mail.dsn;

import java.io.IOException;
import java.util.Vector;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MultipartReport extends MimeMultipart {
    protected boolean constructed;

    public MultipartReport() throws MessagingException {
        super("report");
        setBodyPart(new MimeBodyPart(), 0);
        setBodyPart(new MimeBodyPart(), 1);
        this.constructed = true;
    }

    private synchronized void setBodyPart(BodyPart bodyPart, int i) throws MessagingException {
        if (this.parts == null) {
            this.parts = new Vector();
        }
        if (i < this.parts.size()) {
            super.removeBodyPart(i);
        }
        super.addBodyPart(bodyPart, i);
    }

    @Override // javax.mail.internet.MimeMultipart, javax.mail.Multipart
    public synchronized void addBodyPart(BodyPart bodyPart) throws MessagingException {
        if (!this.constructed) {
            super.addBodyPart(bodyPart);
        } else {
            throw new MessagingException("Can't add body parts to multipart/report 1");
        }
    }

    public synchronized DeliveryStatus getDeliveryStatus() throws MessagingException {
        if (getCount() < 2) {
            return null;
        }
        BodyPart bodyPart = getBodyPart(1);
        if (bodyPart.isMimeType("message/delivery-status")) {
            try {
                return (DeliveryStatus) bodyPart.getContent();
            } catch (IOException e) {
                throw new MessagingException("IOException getting DeliveryStatus", e);
            }
        }
        return null;
    }

    public synchronized MimeMessage getReturnedMessage() throws MessagingException {
        if (getCount() < 3) {
            return null;
        }
        BodyPart bodyPart = getBodyPart(2);
        if (bodyPart.isMimeType("message/rfc822") || bodyPart.isMimeType("text/rfc822-headers")) {
            try {
                return (MimeMessage) bodyPart.getContent();
            } catch (IOException e) {
                throw new MessagingException("IOException getting ReturnedMessage", e);
            }
        }
        return null;
    }

    public synchronized String getText() throws MessagingException {
        try {
            BodyPart bodyPart = getBodyPart(0);
            if (bodyPart.isMimeType("text/plain")) {
                return (String) bodyPart.getContent();
            }
            if (bodyPart.isMimeType("multipart/alternative")) {
                Multipart multipart = (Multipart) bodyPart.getContent();
                for (int i = 0; i < multipart.getCount(); i++) {
                    BodyPart bodyPart2 = multipart.getBodyPart(i);
                    if (bodyPart2.isMimeType("text/plain")) {
                        return (String) bodyPart2.getContent();
                    }
                }
            }
            return null;
        } catch (IOException e) {
            throw new MessagingException("Exception getting text content", e);
        }
    }

    public synchronized MimeBodyPart getTextBodyPart() throws MessagingException {
        return (MimeBodyPart) getBodyPart(0);
    }

    @Override // javax.mail.internet.MimeMultipart, javax.mail.Multipart
    public boolean removeBodyPart(BodyPart bodyPart) throws MessagingException {
        throw new MessagingException("Can't remove body parts from multipart/report");
    }

    public synchronized void setDeliveryStatus(DeliveryStatus deliveryStatus) throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(deliveryStatus, "message/delivery-status");
        setBodyPart(mimeBodyPart, 2);
        ContentType contentType = new ContentType(this.contentType);
        contentType.setParameter("report-type", "delivery-status");
        this.contentType = contentType.toString();
    }

    public synchronized void setReturnedMessage(MimeMessage mimeMessage) throws MessagingException {
        if (mimeMessage == null) {
            BodyPart bodyPart = (BodyPart) this.parts.elementAt(2);
            super.removeBodyPart(2);
            return;
        }
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        if (mimeMessage instanceof MessageHeaders) {
            mimeBodyPart.setContent(mimeMessage, "text/rfc822-headers");
        } else {
            mimeBodyPart.setContent(mimeMessage, "message/rfc822");
        }
        setBodyPart(mimeBodyPart, 2);
    }

    @Override // javax.mail.internet.MimeMultipart
    public synchronized void setSubType(String str) throws MessagingException {
        throw new MessagingException("Can't change subtype of MultipartReport");
    }

    public synchronized void setText(String str) throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText(str);
        setBodyPart(mimeBodyPart, 0);
    }

    public synchronized void setTextBodyPart(MimeBodyPart mimeBodyPart) throws MessagingException {
        setBodyPart(mimeBodyPart, 0);
    }

    @Override // javax.mail.internet.MimeMultipart, javax.mail.Multipart
    public void removeBodyPart(int i) throws MessagingException {
        throw new MessagingException("Can't remove body parts from multipart/report");
    }

    @Override // javax.mail.internet.MimeMultipart, javax.mail.Multipart
    public synchronized void addBodyPart(BodyPart bodyPart, int i) throws MessagingException {
        throw new MessagingException("Can't add body parts to multipart/report 2");
    }

    public MultipartReport(String str, DeliveryStatus deliveryStatus) throws MessagingException {
        super("report");
        ContentType contentType = new ContentType(this.contentType);
        contentType.setParameter("report-type", "delivery-status");
        this.contentType = contentType.toString();
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText(str);
        setBodyPart(mimeBodyPart, 0);
        MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
        mimeBodyPart2.setContent(deliveryStatus, "message/delivery-status");
        setBodyPart(mimeBodyPart2, 1);
        this.constructed = true;
    }

    public MultipartReport(String str, DeliveryStatus deliveryStatus, MimeMessage mimeMessage) throws MessagingException {
        this(str, deliveryStatus);
        if (mimeMessage != null) {
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(mimeMessage, "message/rfc822");
            setBodyPart(mimeBodyPart, 2);
        }
    }

    public MultipartReport(String str, DeliveryStatus deliveryStatus, InternetHeaders internetHeaders) throws MessagingException {
        this(str, deliveryStatus);
        if (internetHeaders != null) {
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(new MessageHeaders(internetHeaders), "text/rfc822-headers");
            setBodyPart(mimeBodyPart, 2);
        }
    }

    public MultipartReport(DataSource dataSource) throws MessagingException {
        super(dataSource);
        parse();
        this.constructed = true;
    }
}
