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

@Deprecated
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SlicedByteBuf extends AbstractUnpooledSlicedByteBuf {
    private int length;

    public SlicedByteBuf(ByteBuf byteBuf, int i, int i2) {
        super(byteBuf, i, i2);
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
    public /* bridge */ /* synthetic */ ByteBuf capacity(int i) {
        return super.capacity(i);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf copy(int i, int i2) {
        return super.copy(i, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf duplicate() {
        return super.duplicate();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int forEachByte(int i, int i2, ByteProcessor byteProcessor) {
        return super.forEachByte(i, i2, byteProcessor);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int forEachByteDesc(int i, int i2, ByteProcessor byteProcessor) {
        return super.forEachByteDesc(i, i2, byteProcessor);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ byte getByte(int i) {
        return super.getByte(i);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        return super.getBytes(i, fileChannel, j, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ CharSequence getCharSequence(int i, int i2, Charset charset) {
        return super.getCharSequence(i, i2, charset);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getInt(int i) {
        return super.getInt(i);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getIntLE(int i) {
        return super.getIntLE(i);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ long getLong(int i) {
        return super.getLong(i);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ long getLongLE(int i) {
        return super.getLongLE(i);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ short getShort(int i) {
        return super.getShort(i);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ short getShortLE(int i) {
        return super.getShortLE(i);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getUnsignedMedium(int i) {
        return super.getUnsignedMedium(i);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int getUnsignedMediumLE(int i) {
        return super.getUnsignedMediumLE(i);
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
    final void initLength(int i) {
        this.length = i;
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
    public /* bridge */ /* synthetic */ ByteBuffer nioBuffer(int i, int i2) {
        return super.nioBuffer(i, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int nioBufferCount() {
        return super.nioBufferCount();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuffer[] nioBuffers(int i, int i2) {
        return super.nioBuffers(i, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    @Deprecated
    public /* bridge */ /* synthetic */ ByteOrder order() {
        return super.order();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setByte(int i, int i2) {
        return super.setByte(i, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        return super.setBytes(i, inputStream, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int setCharSequence(int i, CharSequence charSequence, Charset charset) {
        return super.setCharSequence(i, charSequence, charset);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setInt(int i, int i2) {
        return super.setInt(i, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setIntLE(int i, int i2) {
        return super.setIntLE(i, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setLong(int i, long j) {
        return super.setLong(i, j);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setLongLE(int i, long j) {
        return super.setLongLE(i, j);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setMedium(int i, int i2) {
        return super.setMedium(i, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setMediumLE(int i, int i2) {
        return super.setMediumLE(i, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setShort(int i, int i2) {
        return super.setShort(i, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setShortLE(int i, int i2) {
        return super.setShortLE(i, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf slice(int i, int i2) {
        return super.slice(i, i2);
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
    public /* bridge */ /* synthetic */ int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        return super.getBytes(i, gatheringByteChannel, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int setBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        return super.setBytes(i, fileChannel, j, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        return super.getBytes(i, byteBuf, i2, i3);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) throws IOException {
        return super.setBytes(i, scatteringByteChannel, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        return super.getBytes(i, outputStream, i2);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        return super.setBytes(i, byteBuf, i2, i3);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        return super.getBytes(i, byteBuffer);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        return super.setBytes(i, byteBuffer);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        return super.getBytes(i, bArr, i2, i3);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public /* bridge */ /* synthetic */ ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        return super.setBytes(i, bArr, i2, i3);
    }
}
