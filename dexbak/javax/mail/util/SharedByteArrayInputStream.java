package javax.mail.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.mail.internet.SharedInputStream;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class SharedByteArrayInputStream extends ByteArrayInputStream implements SharedInputStream {
    protected int start;

    public SharedByteArrayInputStream(byte[] bArr) {
        super(bArr);
        this.start = 0;
    }

    @Override // javax.mail.internet.SharedInputStream
    public long getPosition() {
        return ((ByteArrayInputStream) this).pos - this.start;
    }

    @Override // javax.mail.internet.SharedInputStream
    public InputStream newStream(long j, long j2) {
        if (j >= 0) {
            if (j2 == -1) {
                j2 = ((ByteArrayInputStream) this).count - this.start;
            }
            return new SharedByteArrayInputStream(((ByteArrayInputStream) this).buf, this.start + ((int) j), (int) (j2 - j));
        }
        throw new IllegalArgumentException("start < 0");
    }

    public SharedByteArrayInputStream(byte[] bArr, int i, int i2) {
        super(bArr, i, i2);
        this.start = i;
    }
}
