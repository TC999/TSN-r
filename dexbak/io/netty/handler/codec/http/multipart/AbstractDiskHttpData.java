package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractDiskHttpData extends AbstractHttpData {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractDiskHttpData.class);
    private File file;
    private FileChannel fileChannel;
    private boolean isRenamed;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDiskHttpData(String str, Charset charset, long j) {
        super(str, charset, j);
    }

    private static byte[] readFrom(File file) throws IOException {
        long length = file.length();
        if (length <= 2147483647L) {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[(int) length];
            try {
                FileChannel channel = fileInputStream.getChannel();
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                for (int i = 0; i < length; i += channel.read(wrap)) {
                }
                return bArr;
            } finally {
                fileInputStream.close();
            }
        }
        throw new IllegalArgumentException("File too big to be loaded in memory");
    }

    private File tempFile() throws IOException {
        String postfix;
        File createTempFile;
        String diskFilename = getDiskFilename();
        if (diskFilename != null) {
            postfix = '_' + diskFilename;
        } else {
            postfix = getPostfix();
        }
        if (getBaseDirectory() == null) {
            createTempFile = File.createTempFile(getPrefix(), postfix);
        } else {
            createTempFile = File.createTempFile(getPrefix(), postfix, new File(getBaseDirectory()));
        }
        if (deleteOnExit()) {
            createTempFile.deleteOnExit();
        }
        return createTempFile;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z) throws IOException {
        if (byteBuf != null) {
            try {
                int readableBytes = byteBuf.readableBytes();
                long j = readableBytes;
                checkSize(this.size + j);
                long j2 = this.definedSize;
                if (j2 > 0 && j2 < this.size + j) {
                    throw new IOException("Out of size: " + (this.size + j) + " > " + this.definedSize);
                }
                ByteBuffer nioBuffer = byteBuf.nioBufferCount() == 1 ? byteBuf.nioBuffer() : byteBuf.copy().nioBuffer();
                if (this.file == null) {
                    this.file = tempFile();
                }
                if (this.fileChannel == null) {
                    this.fileChannel = new FileOutputStream(this.file).getChannel();
                }
                int i = 0;
                while (i < readableBytes) {
                    i += this.fileChannel.write(nioBuffer);
                }
                this.size += j;
                byteBuf.readerIndex(byteBuf.readerIndex() + i);
            } finally {
                byteBuf.release();
            }
        }
        if (!z) {
            if (byteBuf == null) {
                throw new NullPointerException("buffer");
            }
            return;
        }
        if (this.file == null) {
            this.file = tempFile();
        }
        if (this.fileChannel == null) {
            this.fileChannel = new FileOutputStream(this.file).getChannel();
        }
        this.fileChannel.force(false);
        this.fileChannel.close();
        this.fileChannel = null;
        setCompleted();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void delete() {
        FileChannel fileChannel = this.fileChannel;
        if (fileChannel != null) {
            try {
                fileChannel.force(false);
                this.fileChannel.close();
            } catch (IOException e) {
                logger.warn("Failed to close a file.", (Throwable) e);
            }
            this.fileChannel = null;
        }
        if (this.isRenamed) {
            return;
        }
        File file = this.file;
        if (file != null && file.exists() && !this.file.delete()) {
            logger.warn("Failed to delete: {}", this.file);
        }
        this.file = null;
    }

    protected abstract boolean deleteOnExit();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public byte[] get() throws IOException {
        File file = this.file;
        if (file == null) {
            return EmptyArrays.EMPTY_BYTES;
        }
        return readFrom(file);
    }

    protected abstract String getBaseDirectory();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getByteBuf() throws IOException {
        File file = this.file;
        if (file == null) {
            return Unpooled.EMPTY_BUFFER;
        }
        return Unpooled.wrappedBuffer(readFrom(file));
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getChunk(int i) throws IOException {
        if (this.file != null && i != 0) {
            if (this.fileChannel == null) {
                this.fileChannel = new FileInputStream(this.file).getChannel();
            }
            ByteBuffer allocate = ByteBuffer.allocate(i);
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                }
                int read = this.fileChannel.read(allocate);
                if (read == -1) {
                    this.fileChannel.close();
                    this.fileChannel = null;
                    break;
                }
                i2 += read;
            }
            if (i2 == 0) {
                return Unpooled.EMPTY_BUFFER;
            }
            allocate.flip();
            ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(allocate);
            wrappedBuffer.readerIndex(0);
            wrappedBuffer.writerIndex(i2);
            return wrappedBuffer;
        }
        return Unpooled.EMPTY_BUFFER;
    }

    protected abstract String getDiskFilename();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public File getFile() throws IOException {
        return this.file;
    }

    protected abstract String getPostfix();

    protected abstract String getPrefix();

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString() throws IOException {
        return getString(HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isInMemory() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00cb  */
    @Override // io.netty.handler.codec.http.multipart.HttpData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean renameTo(java.io.File r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.AbstractDiskHttpData.renameTo(java.io.File):boolean");
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(ByteBuf byteBuf) throws IOException {
        if (byteBuf != null) {
            try {
                long readableBytes = byteBuf.readableBytes();
                this.size = readableBytes;
                checkSize(readableBytes);
                long j = this.definedSize;
                if (j > 0 && j < this.size) {
                    throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
                }
                if (this.file == null) {
                    this.file = tempFile();
                }
                if (byteBuf.readableBytes() == 0) {
                    if (this.file.createNewFile()) {
                        return;
                    }
                    throw new IOException("file exists already: " + this.file);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(this.file);
                FileChannel channel = fileOutputStream.getChannel();
                ByteBuffer nioBuffer = byteBuf.nioBuffer();
                int i = 0;
                while (i < this.size) {
                    i += channel.write(nioBuffer);
                }
                byteBuf.readerIndex(byteBuf.readerIndex() + i);
                channel.force(false);
                fileOutputStream.close();
                setCompleted();
                return;
            } finally {
                byteBuf.release();
            }
        }
        throw new NullPointerException("buffer");
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData touch() {
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public HttpData touch(Object obj) {
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString(Charset charset) throws IOException {
        File file = this.file;
        if (file == null) {
            return "";
        }
        if (charset == null) {
            return new String(readFrom(file), HttpConstants.DEFAULT_CHARSET.name());
        }
        return new String(readFrom(file), charset.name());
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(File file) throws IOException {
        if (this.file != null) {
            delete();
        }
        this.file = file;
        long length = file.length();
        this.size = length;
        checkSize(length);
        this.isRenamed = true;
        setCompleted();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            if (this.file != null) {
                delete();
            }
            this.file = tempFile();
            FileOutputStream fileOutputStream = new FileOutputStream(this.file);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                byte[] bArr = new byte[16384];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                int read = inputStream.read(bArr);
                int i = 0;
                while (read > 0) {
                    wrap.position(read).flip();
                    i += channel.write(wrap);
                    checkSize(i);
                    read = inputStream.read(bArr);
                }
                channel.force(false);
                fileOutputStream.close();
                long j = i;
                this.size = j;
                long j2 = this.definedSize;
                if (j2 > 0 && j2 < j) {
                    if (!this.file.delete()) {
                        logger.warn("Failed to delete: {}", this.file);
                    }
                    this.file = null;
                    throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
                }
                this.isRenamed = true;
                setCompleted();
                return;
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        }
        throw new NullPointerException("inputStream");
    }
}
