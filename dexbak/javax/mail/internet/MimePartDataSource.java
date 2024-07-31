package javax.mail.internet;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownServiceException;
import javax.activation.DataSource;
import javax.mail.MessageAware;
import javax.mail.MessageContext;
import javax.mail.MessagingException;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class MimePartDataSource implements DataSource, MessageAware {
    private static boolean ignoreMultipartEncoding = true;
    private MessageContext context;
    protected MimePart part;

    static {
        try {
            String property = System.getProperty("mail.mime.ignoremultipartencoding");
            ignoreMultipartEncoding = property == null || !property.equalsIgnoreCase("false");
        } catch (SecurityException unused) {
        }
    }

    public MimePartDataSource(MimePart mimePart) {
        this.part = mimePart;
    }

    private static String restrictEncoding(String str, MimePart mimePart) throws MessagingException {
        String contentType;
        if (!ignoreMultipartEncoding || str == null || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit") || str.equalsIgnoreCase(HttpHeaders.Values.BINARY) || (contentType = mimePart.getContentType()) == null) {
            return str;
        }
        try {
            ContentType contentType2 = new ContentType(contentType);
            if (!contentType2.match("multipart/*")) {
                if (!contentType2.match("message/*")) {
                    return str;
                }
            }
            return null;
        } catch (ParseException unused) {
            return str;
        }
    }

    @Override // javax.activation.DataSource
    public String getContentType() {
        try {
            return this.part.getContentType();
        } catch (MessagingException unused) {
            return HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE;
        }
    }

    @Override // javax.activation.DataSource
    public InputStream getInputStream() throws IOException {
        InputStream contentStream;
        try {
            MimePart mimePart = this.part;
            if (mimePart instanceof MimeBodyPart) {
                contentStream = ((MimeBodyPart) mimePart).getContentStream();
            } else if (mimePart instanceof MimeMessage) {
                contentStream = ((MimeMessage) mimePart).getContentStream();
            } else {
                throw new MessagingException("Unknown part");
            }
            String restrictEncoding = restrictEncoding(this.part.getEncoding(), this.part);
            return restrictEncoding != null ? MimeUtility.decode(contentStream, restrictEncoding) : contentStream;
        } catch (MessagingException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // javax.mail.MessageAware
    public synchronized MessageContext getMessageContext() {
        if (this.context == null) {
            this.context = new MessageContext(this.part);
        }
        return this.context;
    }

    @Override // javax.activation.DataSource
    public String getName() {
        try {
            MimePart mimePart = this.part;
            return mimePart instanceof MimeBodyPart ? ((MimeBodyPart) mimePart).getFileName() : "";
        } catch (MessagingException unused) {
            return "";
        }
    }

    @Override // javax.activation.DataSource
    public OutputStream getOutputStream() throws IOException {
        throw new UnknownServiceException();
    }
}
