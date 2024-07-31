package io.netty.channel.oio;

import com.umeng.analytics.pro.UMCommonContent;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.WritableByteChannel;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class OioByteStreamChannel extends AbstractOioByteChannel {
    private static final InputStream CLOSED_IN = new InputStream() { // from class: io.netty.channel.oio.OioByteStreamChannel.1
        @Override // java.io.InputStream
        public int read() {
            return -1;
        }
    };
    private static final OutputStream CLOSED_OUT = new OutputStream() { // from class: io.netty.channel.oio.OioByteStreamChannel.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            throw new ClosedChannelException();
        }
    };

    /* renamed from: is */
    private InputStream f40188is;

    /* renamed from: os */
    private OutputStream f40189os;
    private WritableByteChannel outChannel;

    /* JADX INFO: Access modifiers changed from: protected */
    public OioByteStreamChannel(Channel channel) {
        super(channel);
    }

    private static void checkEOF(FileRegion fileRegion) throws IOException {
        if (fileRegion.transferred() >= fileRegion.count()) {
            return;
        }
        throw new EOFException("Expected to be able to write " + fileRegion.count() + " bytes, but only wrote " + fileRegion.transferred());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void activate(InputStream inputStream, OutputStream outputStream) {
        if (this.f40188is == null) {
            if (this.f40189os != null) {
                throw new IllegalStateException("output was set already");
            }
            if (inputStream == null) {
                throw new NullPointerException(UMCommonContent.f37801ae);
            }
            if (outputStream != null) {
                this.f40188is = inputStream;
                this.f40189os = outputStream;
                return;
            }
            throw new NullPointerException("os");
        }
        throw new IllegalStateException("input was set already");
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    protected int available() {
        try {
            return this.f40188is.available();
        } catch (IOException unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        InputStream inputStream = this.f40188is;
        OutputStream outputStream = this.f40189os;
        this.f40188is = CLOSED_IN;
        this.f40189os = CLOSED_OUT;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.oio.AbstractOioByteChannel
    public int doReadBytes(ByteBuf byteBuf) throws Exception {
        RecvByteBufAllocator.Handle recvBufAllocHandle = unsafe().recvBufAllocHandle();
        recvBufAllocHandle.attemptedBytesRead(Math.max(1, Math.min(available(), byteBuf.maxWritableBytes())));
        return byteBuf.writeBytes(this.f40188is, recvBufAllocHandle.attemptedBytesRead());
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    protected void doWriteBytes(ByteBuf byteBuf) throws Exception {
        OutputStream outputStream = this.f40189os;
        if (outputStream != null) {
            byteBuf.readBytes(outputStream, byteBuf.readableBytes());
            return;
        }
        throw new NotYetConnectedException();
    }

    @Override // io.netty.channel.oio.AbstractOioByteChannel
    protected void doWriteFileRegion(FileRegion fileRegion) throws Exception {
        OutputStream outputStream = this.f40189os;
        if (outputStream != null) {
            if (this.outChannel == null) {
                this.outChannel = Channels.newChannel(outputStream);
            }
            long j = 0;
            do {
                long transferTo = fileRegion.transferTo(this.outChannel, j);
                if (transferTo == -1) {
                    checkEOF(fileRegion);
                    return;
                }
                j += transferTo;
            } while (j < fileRegion.count());
            return;
        }
        throw new NotYetConnectedException();
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        OutputStream outputStream;
        InputStream inputStream = this.f40188is;
        return (inputStream == null || inputStream == CLOSED_IN || (outputStream = this.f40189os) == null || outputStream == CLOSED_OUT) ? false : true;
    }
}
