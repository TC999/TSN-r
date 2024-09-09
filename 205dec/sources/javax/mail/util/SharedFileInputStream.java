package javax.mail.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import javax.mail.internet.SharedInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class SharedFileInputStream extends BufferedInputStream implements SharedInputStream {
    private static int defaultBufferSize = 2048;
    protected long bufpos;
    protected int bufsize;
    protected long datalen;
    protected RandomAccessFile in;

    /* renamed from: master  reason: collision with root package name */
    private boolean f55222master;
    private SharedFile sf;
    protected long start;

    public SharedFileInputStream(File file) throws IOException {
        this(file, defaultBufferSize);
    }

    private void ensureOpen() throws IOException {
        if (this.in == null) {
            throw new IOException("Stream closed");
        }
    }

    private void fill() throws IOException {
        if (((BufferedInputStream) this).markpos < 0) {
            ((BufferedInputStream) this).pos = 0;
            this.bufpos += ((BufferedInputStream) this).count;
        } else if (((BufferedInputStream) this).pos >= ((BufferedInputStream) this).buf.length) {
            int i4 = ((BufferedInputStream) this).markpos;
            if (i4 > 0) {
                int i5 = ((BufferedInputStream) this).pos - i4;
                System.arraycopy(((BufferedInputStream) this).buf, ((BufferedInputStream) this).markpos, ((BufferedInputStream) this).buf, 0, i5);
                ((BufferedInputStream) this).pos = i5;
                this.bufpos += ((BufferedInputStream) this).markpos;
                ((BufferedInputStream) this).markpos = 0;
            } else {
                int length = ((BufferedInputStream) this).buf.length;
                int i6 = ((BufferedInputStream) this).marklimit;
                if (length >= i6) {
                    ((BufferedInputStream) this).markpos = -1;
                    ((BufferedInputStream) this).pos = 0;
                    this.bufpos += ((BufferedInputStream) this).count;
                } else {
                    int i7 = ((BufferedInputStream) this).pos * 2;
                    if (i7 <= i6) {
                        i6 = i7;
                    }
                    byte[] bArr = new byte[i6];
                    System.arraycopy(((BufferedInputStream) this).buf, 0, bArr, 0, ((BufferedInputStream) this).pos);
                    ((BufferedInputStream) this).buf = bArr;
                }
            }
        }
        int i8 = ((BufferedInputStream) this).pos;
        ((BufferedInputStream) this).count = i8;
        this.in.seek(this.bufpos + i8);
        int length2 = ((BufferedInputStream) this).buf.length;
        int i9 = ((BufferedInputStream) this).pos;
        int i10 = length2 - i9;
        long j4 = this.bufpos;
        long j5 = this.start;
        long j6 = (j4 - j5) + i9 + i10;
        long j7 = this.datalen;
        if (j6 > j7) {
            i10 = (int) (j7 - ((j4 - j5) + i9));
        }
        int read = this.in.read(((BufferedInputStream) this).buf, ((BufferedInputStream) this).pos, i10);
        if (read > 0) {
            ((BufferedInputStream) this).count = read + ((BufferedInputStream) this).pos;
        }
    }

    private int in_available() throws IOException {
        return (int) ((this.start + this.datalen) - (this.bufpos + ((BufferedInputStream) this).count));
    }

    private void init(SharedFile sharedFile, int i4) throws IOException {
        this.sf = sharedFile;
        RandomAccessFile open = sharedFile.open();
        this.in = open;
        this.start = 0L;
        this.datalen = open.length();
        this.bufsize = i4;
        ((BufferedInputStream) this).buf = new byte[i4];
    }

    private int read1(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;
        if (i6 <= 0) {
            fill();
            i6 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;
            if (i6 <= 0) {
                return -1;
            }
        }
        if (i6 < i5) {
            i5 = i6;
        }
        System.arraycopy(((BufferedInputStream) this).buf, ((BufferedInputStream) this).pos, bArr, i4, i5);
        ((BufferedInputStream) this).pos += i5;
        return i5;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        ensureOpen();
        return (((BufferedInputStream) this).count - ((BufferedInputStream) this).pos) + in_available();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [javax.mail.util.SharedFileInputStream$SharedFile, java.io.RandomAccessFile, byte[]] */
    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.in == null) {
            return;
        }
        try {
            if (this.f55222master) {
                this.sf.forceClose();
            } else {
                this.sf.close();
            }
        } finally {
            this.sf = null;
            this.in = null;
            ((BufferedInputStream) this).buf = null;
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        close();
    }

    @Override // javax.mail.internet.SharedInputStream
    public long getPosition() {
        if (this.in != null) {
            return (this.bufpos + ((BufferedInputStream) this).pos) - this.start;
        }
        throw new RuntimeException("Stream closed");
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i4) {
        ((BufferedInputStream) this).marklimit = i4;
        ((BufferedInputStream) this).markpos = ((BufferedInputStream) this).pos;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // javax.mail.internet.SharedInputStream
    public InputStream newStream(long j4, long j5) {
        if (this.in != null) {
            if (j4 >= 0) {
                if (j5 == -1) {
                    j5 = this.datalen;
                }
                return new SharedFileInputStream(this.sf, this.start + ((int) j4), (int) (j5 - j4), this.bufsize);
            }
            throw new IllegalArgumentException("start < 0");
        }
        throw new RuntimeException("Stream closed");
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        ensureOpen();
        if (((BufferedInputStream) this).pos >= ((BufferedInputStream) this).count) {
            fill();
            if (((BufferedInputStream) this).pos >= ((BufferedInputStream) this).count) {
                return -1;
            }
        }
        byte[] bArr = ((BufferedInputStream) this).buf;
        int i4 = ((BufferedInputStream) this).pos;
        ((BufferedInputStream) this).pos = i4 + 1;
        return bArr[i4] & 255;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        ensureOpen();
        int i4 = ((BufferedInputStream) this).markpos;
        if (i4 >= 0) {
            ((BufferedInputStream) this).pos = i4;
        } else {
            throw new IOException("Resetting to invalid mark");
        }
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j4) throws IOException {
        ensureOpen();
        if (j4 <= 0) {
            return 0L;
        }
        long j5 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;
        if (j5 <= 0) {
            fill();
            j5 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;
            if (j5 <= 0) {
                return 0L;
            }
        }
        if (j5 < j4) {
            j4 = j5;
        }
        ((BufferedInputStream) this).pos = (int) (((BufferedInputStream) this).pos + j4);
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class SharedFile {
        private int cnt;
        private RandomAccessFile in;

        SharedFile(String str) throws IOException {
            this.in = new RandomAccessFile(str, "r");
        }

        public synchronized void close() throws IOException {
            int i4 = this.cnt;
            if (i4 > 0) {
                int i5 = i4 - 1;
                this.cnt = i5;
                if (i5 <= 0) {
                    this.in.close();
                }
            }
        }

        protected void finalize() throws Throwable {
            super.finalize();
            this.in.close();
        }

        public synchronized void forceClose() throws IOException {
            if (this.cnt > 0) {
                this.cnt = 0;
                this.in.close();
            } else {
                try {
                    this.in.close();
                } catch (IOException unused) {
                }
            }
        }

        public RandomAccessFile open() {
            this.cnt++;
            return this.in;
        }

        SharedFile(File file) throws IOException {
            this.in = new RandomAccessFile(file, "r");
        }
    }

    public SharedFileInputStream(String str) throws IOException {
        this(str, defaultBufferSize);
    }

    public SharedFileInputStream(File file, int i4) throws IOException {
        super(null);
        this.start = 0L;
        this.f55222master = true;
        if (i4 > 0) {
            init(new SharedFile(file), i4);
            return;
        }
        throw new IllegalArgumentException("Buffer size <= 0");
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i4, int i5) throws IOException {
        ensureOpen();
        int i6 = i4 + i5;
        if ((i4 | i5 | i6 | (bArr.length - i6)) >= 0) {
            if (i5 == 0) {
                return 0;
            }
            int read1 = read1(bArr, i4, i5);
            if (read1 <= 0) {
                return read1;
            }
            while (read1 < i5) {
                int read12 = read1(bArr, i4 + read1, i5 - read1);
                if (read12 <= 0) {
                    break;
                }
                read1 += read12;
            }
            return read1;
        }
        throw new IndexOutOfBoundsException();
    }

    public SharedFileInputStream(String str, int i4) throws IOException {
        super(null);
        this.start = 0L;
        this.f55222master = true;
        if (i4 > 0) {
            init(new SharedFile(str), i4);
            return;
        }
        throw new IllegalArgumentException("Buffer size <= 0");
    }

    private SharedFileInputStream(SharedFile sharedFile, long j4, long j5, int i4) {
        super(null);
        this.start = 0L;
        this.f55222master = false;
        this.sf = sharedFile;
        this.in = sharedFile.open();
        this.start = j4;
        this.bufpos = j4;
        this.datalen = j5;
        this.bufsize = i4;
        ((BufferedInputStream) this).buf = new byte[i4];
    }
}
