package javax.mail;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class Multipart {
    protected Part parent;
    protected Vector parts = new Vector();
    protected String contentType = "multipart/mixed";

    public synchronized void addBodyPart(BodyPart bodyPart) throws MessagingException {
        if (this.parts == null) {
            this.parts = new Vector();
        }
        this.parts.addElement(bodyPart);
        bodyPart.setParent(this);
    }

    public synchronized BodyPart getBodyPart(int i4) throws MessagingException {
        Vector vector;
        vector = this.parts;
        if (vector != null) {
        } else {
            throw new IndexOutOfBoundsException("No such BodyPart");
        }
        return (BodyPart) vector.elementAt(i4);
    }

    public String getContentType() {
        return this.contentType;
    }

    public synchronized int getCount() throws MessagingException {
        Vector vector = this.parts;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public synchronized Part getParent() {
        return this.parent;
    }

    public synchronized boolean removeBodyPart(BodyPart bodyPart) throws MessagingException {
        boolean removeElement;
        Vector vector = this.parts;
        if (vector != null) {
            removeElement = vector.removeElement(bodyPart);
            bodyPart.setParent(null);
        } else {
            throw new MessagingException("No such body part");
        }
        return removeElement;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void setMultipartDataSource(MultipartDataSource multipartDataSource) throws MessagingException {
        this.contentType = multipartDataSource.getContentType();
        int count = multipartDataSource.getCount();
        for (int i4 = 0; i4 < count; i4++) {
            addBodyPart(multipartDataSource.getBodyPart(i4));
        }
    }

    public synchronized void setParent(Part part) {
        this.parent = part;
    }

    public abstract void writeTo(OutputStream outputStream) throws IOException, MessagingException;

    public synchronized void addBodyPart(BodyPart bodyPart, int i4) throws MessagingException {
        if (this.parts == null) {
            this.parts = new Vector();
        }
        this.parts.insertElementAt(bodyPart, i4);
        bodyPart.setParent(this);
    }

    public synchronized void removeBodyPart(int i4) throws MessagingException {
        Vector vector = this.parts;
        if (vector != null) {
            this.parts.removeElementAt(i4);
            ((BodyPart) vector.elementAt(i4)).setParent(null);
        } else {
            throw new IndexOutOfBoundsException("No such BodyPart");
        }
    }
}
