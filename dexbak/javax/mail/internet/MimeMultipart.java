package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.LineOutputStream;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.MessageAware;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.MultipartDataSource;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class MimeMultipart extends Multipart {
    private static boolean bmparse = true;
    private static boolean ignoreMissingBoundaryParameter = true;
    private static boolean ignoreMissingEndBoundary = true;
    private boolean complete;

    /* renamed from: ds */
    protected DataSource f40794ds;
    protected boolean parsed;
    private String preamble;

    static {
        try {
            String property = System.getProperty("mail.mime.multipart.ignoremissingendboundary");
            boolean z = false;
            ignoreMissingEndBoundary = property == null || !property.equalsIgnoreCase("false");
            String property2 = System.getProperty("mail.mime.multipart.ignoremissingboundaryparameter");
            ignoreMissingBoundaryParameter = property2 == null || !property2.equalsIgnoreCase("false");
            String property3 = System.getProperty("mail.mime.multipart.bmparse");
            if (property3 == null || !property3.equalsIgnoreCase("false")) {
                z = true;
            }
            bmparse = z;
        } catch (SecurityException unused) {
        }
    }

    public MimeMultipart() {
        this("mixed");
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x0178, code lost:
        r12 = r7;
        r28 = r8;
        r17 = (r0.getPosition() - r6) - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d1, code lost:
        r2.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0191 A[Catch: all -> 0x0331, IOException -> 0x0333, TryCatch #1 {, blocks: (B:4:0x0003, B:8:0x0009, B:10:0x0013, B:12:0x0017, B:14:0x001b, B:17:0x0022, B:19:0x0027, B:21:0x002c, B:23:0x003b, B:66:0x00d1, B:67:0x00d4, B:24:0x004a, B:204:0x0340, B:205:0x0347, B:207:0x0349, B:208:0x0350, B:27:0x004f, B:28:0x0056, B:48:0x0093, B:49:0x0099, B:51:0x00a5, B:53:0x00aa, B:57:0x00b9, B:58:0x00bd, B:60:0x00c3, B:63:0x00cb, B:65:0x00cf, B:70:0x00d8, B:71:0x00df, B:74:0x00ec, B:77:0x00f4, B:79:0x0101, B:80:0x0108, B:82:0x0115, B:85:0x011b, B:86:0x011f, B:138:0x01c7, B:148:0x01f9, B:139:0x01d6, B:141:0x01de, B:143:0x01e7, B:146:0x01ed, B:147:0x01f1, B:87:0x012e, B:88:0x0135, B:97:0x014b, B:106:0x015d, B:153:0x0226, B:158:0x023d, B:159:0x0243, B:161:0x024e, B:162:0x025b, B:166:0x0267, B:168:0x026d, B:116:0x0178, B:118:0x0189, B:120:0x0191, B:122:0x019b, B:133:0x01b6, B:135:0x01c0, B:151:0x0214, B:92:0x013d, B:170:0x0286, B:78:0x00fc, B:171:0x0293, B:172:0x029a, B:73:0x00e4, B:173:0x029b, B:181:0x02be, B:177:0x02aa, B:178:0x02af, B:180:0x02b7, B:182:0x02cf, B:183:0x02ea, B:184:0x02f1, B:31:0x0063, B:37:0x0073, B:39:0x007b, B:185:0x02f2, B:188:0x02fa, B:193:0x0308, B:194:0x0314, B:43:0x0086, B:34:0x006b, B:200:0x0334, B:201:0x033b), top: B:216:0x0003, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x031a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x01b1 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v5, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void parsebm() throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 854
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeMultipart.parsebm():void");
    }

    private static int readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i2 > 0) {
            int read = inputStream.read(bArr, i, i2);
            if (read <= 0) {
                break;
            }
            i += read;
            i3 += read;
            i2 -= read;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    private void skipFully(InputStream inputStream, long j) throws IOException {
        while (j > 0) {
            long skip = inputStream.skip(j);
            if (skip <= 0) {
                throw new EOFException("can't skip");
            }
            j -= skip;
        }
    }

    @Override // javax.mail.Multipart
    public synchronized void addBodyPart(BodyPart bodyPart) throws MessagingException {
        parse();
        super.addBodyPart(bodyPart);
    }

    protected InternetHeaders createInternetHeaders(InputStream inputStream) throws MessagingException {
        return new InternetHeaders(inputStream);
    }

    protected MimeBodyPart createMimeBodyPart(InternetHeaders internetHeaders, byte[] bArr) throws MessagingException {
        return new MimeBodyPart(internetHeaders, bArr);
    }

    @Override // javax.mail.Multipart
    public synchronized BodyPart getBodyPart(int i) throws MessagingException {
        parse();
        return super.getBodyPart(i);
    }

    @Override // javax.mail.Multipart
    public synchronized int getCount() throws MessagingException {
        parse();
        return super.getCount();
    }

    public synchronized String getPreamble() throws MessagingException {
        parse();
        return this.preamble;
    }

    public synchronized boolean isComplete() throws MessagingException {
        parse();
        return this.complete;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c4, code lost:
        r2.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0204 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x005f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0180 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void parse() throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 599
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeMultipart.parse():void");
    }

    @Override // javax.mail.Multipart
    public boolean removeBodyPart(BodyPart bodyPart) throws MessagingException {
        parse();
        return super.removeBodyPart(bodyPart);
    }

    public synchronized void setPreamble(String str) throws MessagingException {
        this.preamble = str;
    }

    public synchronized void setSubType(String str) throws MessagingException {
        ContentType contentType = new ContentType(this.contentType);
        contentType.setSubType(str);
        this.contentType = contentType.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateHeaders() throws MessagingException {
        for (int i = 0; i < this.parts.size(); i++) {
            ((MimeBodyPart) this.parts.elementAt(i)).updateHeaders();
        }
    }

    @Override // javax.mail.Multipart
    public synchronized void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        parse();
        String str = "--" + new ContentType(this.contentType).getParameter(HttpHeaders.Values.BOUNDARY);
        LineOutputStream lineOutputStream = new LineOutputStream(outputStream);
        String str2 = this.preamble;
        if (str2 != null) {
            byte[] bytes = ASCIIUtility.getBytes(str2);
            lineOutputStream.write(bytes);
            if (bytes.length > 0 && bytes[bytes.length - 1] != 13 && bytes[bytes.length - 1] != 10) {
                lineOutputStream.writeln();
            }
        }
        for (int i = 0; i < this.parts.size(); i++) {
            lineOutputStream.writeln(str);
            ((MimeBodyPart) this.parts.elementAt(i)).writeTo(outputStream);
            lineOutputStream.writeln();
        }
        lineOutputStream.writeln(String.valueOf(str) + "--");
    }

    public MimeMultipart(String str) {
        this.f40794ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        String uniqueBoundaryValue = UniqueValue.getUniqueBoundaryValue();
        ContentType contentType = new ContentType("multipart", str, null);
        contentType.setParameter(HttpHeaders.Values.BOUNDARY, uniqueBoundaryValue);
        this.contentType = contentType.toString();
    }

    protected MimeBodyPart createMimeBodyPart(InputStream inputStream) throws MessagingException {
        return new MimeBodyPart(inputStream);
    }

    public synchronized BodyPart getBodyPart(String str) throws MessagingException {
        parse();
        int count = getCount();
        for (int i = 0; i < count; i++) {
            MimeBodyPart mimeBodyPart = (MimeBodyPart) getBodyPart(i);
            String contentID = mimeBodyPart.getContentID();
            if (contentID != null && contentID.equals(str)) {
                return mimeBodyPart;
            }
        }
        return null;
    }

    @Override // javax.mail.Multipart
    public void removeBodyPart(int i) throws MessagingException {
        parse();
        super.removeBodyPart(i);
    }

    @Override // javax.mail.Multipart
    public synchronized void addBodyPart(BodyPart bodyPart, int i) throws MessagingException {
        parse();
        super.addBodyPart(bodyPart, i);
    }

    public MimeMultipart(DataSource dataSource) throws MessagingException {
        this.f40794ds = null;
        this.parsed = true;
        this.complete = true;
        this.preamble = null;
        if (dataSource instanceof MessageAware) {
            setParent(((MessageAware) dataSource).getMessageContext().getPart());
        }
        if (dataSource instanceof MultipartDataSource) {
            setMultipartDataSource((MultipartDataSource) dataSource);
            return;
        }
        this.parsed = false;
        this.f40794ds = dataSource;
        this.contentType = dataSource.getContentType();
    }
}
