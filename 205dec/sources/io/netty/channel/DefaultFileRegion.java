package io.netty.channel;

import io.netty.util.AbstractReferenceCounted;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultFileRegion extends AbstractReferenceCounted implements FileRegion {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultFileRegion.class);
    private final long count;

    /* renamed from: f  reason: collision with root package name */
    private final File f54774f;
    private FileChannel file;
    private final long position;
    private long transferred;

    public DefaultFileRegion(FileChannel fileChannel, long j4, long j5) {
        if (fileChannel == null) {
            throw new NullPointerException("file");
        }
        if (j4 < 0) {
            throw new IllegalArgumentException("position must be >= 0 but was " + j4);
        } else if (j5 >= 0) {
            this.file = fileChannel;
            this.position = j4;
            this.count = j5;
            this.f54774f = null;
        } else {
            throw new IllegalArgumentException("count must be >= 0 but was " + j5);
        }
    }

    @Override // io.netty.channel.FileRegion
    public long count() {
        return this.count;
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        FileChannel fileChannel = this.file;
        if (fileChannel == null) {
            return;
        }
        this.file = null;
        try {
            fileChannel.close();
        } catch (IOException e4) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to close a file.", (Throwable) e4);
            }
        }
    }

    public boolean isOpen() {
        return this.file != null;
    }

    public void open() throws IOException {
        if (isOpen() || refCnt() <= 0) {
            return;
        }
        this.file = new RandomAccessFile(this.f54774f, "r").getChannel();
    }

    @Override // io.netty.channel.FileRegion
    public long position() {
        return this.position;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileRegion touch() {
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public FileRegion touch(Object obj) {
        return this;
    }

    @Override // io.netty.channel.FileRegion
    public long transferTo(WritableByteChannel writableByteChannel, long j4) throws IOException {
        long j5 = this.count - j4;
        if (j5 < 0 || j4 < 0) {
            throw new IllegalArgumentException("position out of range: " + j4 + " (expected: 0 - " + (this.count - 1) + ')');
        } else if (j5 == 0) {
            return 0L;
        } else {
            if (refCnt() != 0) {
                open();
                long transferTo = this.file.transferTo(this.position + j4, j5, writableByteChannel);
                if (transferTo > 0) {
                    this.transferred += transferTo;
                }
                return transferTo;
            }
            throw new IllegalReferenceCountException(0);
        }
    }

    @Override // io.netty.channel.FileRegion
    @Deprecated
    public long transfered() {
        return this.transferred;
    }

    @Override // io.netty.channel.FileRegion
    public long transferred() {
        return this.transferred;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileRegion retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileRegion retain(int i4) {
        super.retain(i4);
        return this;
    }

    public DefaultFileRegion(File file, long j4, long j5) {
        if (file == null) {
            throw new NullPointerException("f");
        }
        if (j4 < 0) {
            throw new IllegalArgumentException("position must be >= 0 but was " + j4);
        } else if (j5 >= 0) {
            this.position = j4;
            this.count = j5;
            this.f54774f = file;
        } else {
            throw new IllegalArgumentException("count must be >= 0 but was " + j5);
        }
    }
}
