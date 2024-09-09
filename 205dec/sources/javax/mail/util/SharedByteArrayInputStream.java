package javax.mail.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.mail.internet.SharedInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
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
    public InputStream newStream(long j4, long j5) {
        if (j4 >= 0) {
            if (j5 == -1) {
                j5 = ((ByteArrayInputStream) this).count - this.start;
            }
            return new SharedByteArrayInputStream(((ByteArrayInputStream) this).buf, this.start + ((int) j4), (int) (j5 - j4));
        }
        throw new IllegalArgumentException("start < 0");
    }

    public SharedByteArrayInputStream(byte[] bArr, int i4, int i5) {
        super(bArr, i4, i5);
        this.start = i4;
    }
}
