package io.netty.buffer;

import io.netty.util.ByteProcessor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SlicedByteBuf extends AbstractUnpooledSlicedByteBuf {
    private int length;

    public SlicedByteBuf(ByteBuf byteBuf, int i4, int i5) {
        super(byteBuf, i4, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBufAllocator alloc() {
        return super.alloc();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ byte[] array() {
        return super.array();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int arrayOffset() {
        return super.arrayOffset();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf capacity(int i4) {
        return super.capacity(i4);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf copy(int i4, int i5) {
        return super.copy(i4, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf duplicate() {
        return super.duplicate();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int forEachByte(int i4, int i5, ByteProcessor byteProcessor) {
        return super.forEachByte(i4, i5, byteProcessor);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int forEachByteDesc(int i4, int i5, ByteProcessor byteProcessor) {
        return super.forEachByteDesc(i4, i5, byteProcessor);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ byte getByte(int i4) {
        return super.getByte(i4);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        return super.getBytes(i4, fileChannel, j4, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ CharSequence getCharSequence(int i4, int i5, Charset charset) {
        return super.getCharSequence(i4, i5, charset);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getInt(int i4) {
        return super.getInt(i4);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getIntLE(int i4) {
        return super.getIntLE(i4);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ long getLong(int i4) {
        return super.getLong(i4);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ long getLongLE(int i4) {
        return super.getLongLE(i4);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ short getShort(int i4) {
        return super.getShort(i4);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ short getShortLE(int i4) {
        return super.getShortLE(i4);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getUnsignedMedium(int i4) {
        return super.getUnsignedMedium(i4);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getUnsignedMediumLE(int i4) {
        return super.getUnsignedMediumLE(i4);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ boolean hasArray() {
        return super.hasArray();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ boolean hasMemoryAddress() {
        return super.hasMemoryAddress();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    final void initLength(int i4) {
        this.length = i4;
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ boolean isDirect() {
        return super.isDirect();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    final int length() {
        return this.length;
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ long memoryAddress() {
        return super.memoryAddress();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractDerivedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuffer nioBuffer(int i4, int i5) {
        return super.nioBuffer(i4, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int nioBufferCount() {
        return super.nioBufferCount();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuffer[] nioBuffers(int i4, int i5) {
        return super.nioBuffers(i4, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    @Deprecated
    public /* bridge */ /* synthetic */ ByteOrder order() {
        return super.order();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setByte(int i4, int i5) {
        return super.setByte(i4, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int setBytes(int i4, InputStream inputStream, int i5) throws IOException {
        return super.setBytes(i4, inputStream, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int setCharSequence(int i4, CharSequence charSequence, Charset charset) {
        return super.setCharSequence(i4, charSequence, charset);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setInt(int i4, int i5) {
        return super.setInt(i4, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setIntLE(int i4, int i5) {
        return super.setIntLE(i4, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setLong(int i4, long j4) {
        return super.setLong(i4, j4);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setLongLE(int i4, long j4) {
        return super.setLongLE(i4, j4);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setMedium(int i4, int i5) {
        return super.setMedium(i4, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setMediumLE(int i4, int i5) {
        return super.setMediumLE(i4, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setShort(int i4, int i5) {
        return super.setShort(i4, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setShortLE(int i4, int i5) {
        return super.setShortLE(i4, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf slice(int i4, int i5) {
        return super.slice(i4, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf unwrap() {
        return super.unwrap();
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.length;
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getBytes(int i4, GatheringByteChannel gatheringByteChannel, int i5) throws IOException {
        return super.getBytes(i4, gatheringByteChannel, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int setBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        return super.setBytes(i4, fileChannel, j4, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        return super.getBytes(i4, byteBuf, i5, i6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int setBytes(int i4, ScatteringByteChannel scatteringByteChannel, int i5) throws IOException {
        return super.setBytes(i4, scatteringByteChannel, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i4, OutputStream outputStream, int i5) throws IOException {
        return super.getBytes(i4, outputStream, i5);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        return super.setBytes(i4, byteBuf, i5, i6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i4, ByteBuffer byteBuffer) {
        return super.getBytes(i4, byteBuffer);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setBytes(int i4, ByteBuffer byteBuffer) {
        return super.setBytes(i4, byteBuffer);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i4, byte[] bArr, int i5, int i6) {
        return super.getBytes(i4, bArr, i5, i6);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setBytes(int i4, byte[] bArr, int i5, int i6) {
        return super.setBytes(i4, bArr, i5, i6);
    }
}
