package javax.mail.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.ParseException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class ByteArrayDataSource implements DataSource {
    private byte[] data;
    private int len;
    private String name;
    private String type;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class DSByteArrayOutputStream extends ByteArrayOutputStream {
        DSByteArrayOutputStream() {
        }

        public byte[] getBuf() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }
    }

    public ByteArrayDataSource(InputStream inputStream, String str) throws IOException {
        this.len = -1;
        this.name = "";
        DSByteArrayOutputStream dSByteArrayOutputStream = new DSByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                break;
            }
            dSByteArrayOutputStream.write(bArr, 0, read);
        }
        this.data = dSByteArrayOutputStream.getBuf();
        int count = dSByteArrayOutputStream.getCount();
        this.len = count;
        if (this.data.length - count > 262144) {
            byte[] byteArray = dSByteArrayOutputStream.toByteArray();
            this.data = byteArray;
            this.len = byteArray.length;
        }
        this.type = str;
    }

    @Override // javax.activation.DataSource
    public String getContentType() {
        return this.type;
    }

    @Override // javax.activation.DataSource
    public InputStream getInputStream() throws IOException {
        byte[] bArr = this.data;
        if (bArr != null) {
            if (this.len < 0) {
                this.len = bArr.length;
            }
            return new SharedByteArrayInputStream(this.data, 0, this.len);
        }
        throw new IOException("no data");
    }

    @Override // javax.activation.DataSource
    public String getName() {
        return this.name;
    }

    @Override // javax.activation.DataSource
    public OutputStream getOutputStream() throws IOException {
        throw new IOException("cannot do this");
    }

    public void setName(String str) {
        this.name = str;
    }

    public ByteArrayDataSource(byte[] bArr, String str) {
        this.len = -1;
        this.name = "";
        this.data = bArr;
        this.type = str;
    }

    public ByteArrayDataSource(String str, String str2) throws IOException {
        String str3;
        this.len = -1;
        this.name = "";
        try {
            str3 = new ContentType(str2).getParameter("charset");
        } catch (ParseException unused) {
            str3 = null;
        }
        this.data = str.getBytes(str3 == null ? MimeUtility.getDefaultJavaCharset() : str3);
        this.type = str2;
    }
}
