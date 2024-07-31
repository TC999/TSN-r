package io.netty.buffer;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.UByte;
import kotlin.UShort;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CompositeByteBuf extends AbstractReferenceCountedByteBuf implements Iterable<ByteBuf> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ByteBufAllocator alloc;
    private final List<Component> components;
    private final boolean direct;
    private boolean freed;
    private final int maxNumComponents;
    private static final ByteBuffer EMPTY_NIO_BUFFER = Unpooled.EMPTY_BUFFER.nioBuffer();
    private static final Iterator<ByteBuf> EMPTY_ITERATOR = Collections.emptyList().iterator();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class Component {
        final ByteBuf buf;
        int endOffset;
        final int length;
        int offset;

        Component(ByteBuf byteBuf) {
            this.buf = byteBuf;
            this.length = byteBuf.readableBytes();
        }

        void freeIfNecessary() {
            this.buf.release();
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class CompositeByteBufIterator implements Iterator<ByteBuf> {
        private int index;
        private final int size;

        private CompositeByteBufIterator() {
            this.size = CompositeByteBuf.this.components.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.size > this.index;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-Only");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ByteBuf next() {
            if (this.size == CompositeByteBuf.this.components.size()) {
                if (hasNext()) {
                    try {
                        List list = CompositeByteBuf.this.components;
                        int i = this.index;
                        this.index = i + 1;
                        return ((Component) list.get(i)).buf;
                    } catch (IndexOutOfBoundsException unused) {
                        throw new ConcurrentModificationException();
                    }
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z, int i) {
        super(Integer.MAX_VALUE);
        if (byteBufAllocator != null) {
            this.alloc = byteBufAllocator;
            this.direct = z;
            this.maxNumComponents = i;
            this.components = newList(i);
            return;
        }
        throw new NullPointerException("alloc");
    }

    private int addComponent0(boolean z, int i, ByteBuf byteBuf) {
        boolean z2 = false;
        try {
            checkComponentIndex(i);
            int readableBytes = byteBuf.readableBytes();
            Component component = new Component(byteBuf.order(ByteOrder.BIG_ENDIAN).slice());
            if (i == this.components.size()) {
                z2 = this.components.add(component);
                if (i == 0) {
                    component.endOffset = readableBytes;
                } else {
                    int i2 = this.components.get(i - 1).endOffset;
                    component.offset = i2;
                    component.endOffset = i2 + readableBytes;
                }
            } else {
                this.components.add(i, component);
                if (readableBytes != 0) {
                    try {
                        updateComponentOffsets(i);
                    } catch (Throwable th) {
                        th = th;
                        z2 = true;
                        if (!z2) {
                            byteBuf.release();
                        }
                        throw th;
                    }
                }
                z2 = true;
            }
            if (z) {
                writerIndex(writerIndex() + byteBuf.readableBytes());
            }
            if (!z2) {
                byteBuf.release();
            }
            return i;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private int addComponents0(boolean z, int i, ByteBuf[] byteBufArr, int i2, int i3) {
        ObjectUtil.checkNotNull(byteBufArr, "buffers");
        try {
            checkComponentIndex(i);
            while (true) {
                if (i2 >= i3) {
                    break;
                }
                int i4 = i2 + 1;
                try {
                    ByteBuf byteBuf = byteBufArr[i2];
                    if (byteBuf == null) {
                        i2 = i4;
                        break;
                    }
                    i = addComponent0(z, i, byteBuf) + 1;
                    int size = this.components.size();
                    if (i > size) {
                        i = size;
                    }
                    i2 = i4;
                } catch (Throwable th) {
                    th = th;
                    i2 = i4;
                    while (i2 < i3) {
                        ByteBuf byteBuf2 = byteBufArr[i2];
                        if (byteBuf2 != null) {
                            try {
                                byteBuf2.release();
                            } catch (Throwable unused) {
                            }
                        }
                        i2++;
                    }
                    throw th;
                }
            }
            while (i2 < i3) {
                ByteBuf byteBuf3 = byteBufArr[i2];
                if (byteBuf3 != null) {
                    try {
                        byteBuf3.release();
                    } catch (Throwable unused2) {
                    }
                }
                i2++;
            }
            return i;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private ByteBuf allocBuffer(int i) {
        return this.direct ? alloc().directBuffer(i) : alloc().heapBuffer(i);
    }

    private void checkComponentIndex(int i) {
        ensureAccessible();
        if (i < 0 || i > this.components.size()) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d (expected: >= 0 && <= numComponents(%d))", Integer.valueOf(i), Integer.valueOf(this.components.size())));
        }
    }

    private void consolidateIfNeeded() {
        int size = this.components.size();
        if (size > this.maxNumComponents) {
            ByteBuf allocBuffer = allocBuffer(this.components.get(size - 1).endOffset);
            for (int i = 0; i < size; i++) {
                Component component = this.components.get(i);
                allocBuffer.writeBytes(component.buf);
                component.freeIfNecessary();
            }
            Component component2 = new Component(allocBuffer);
            component2.endOffset = component2.length;
            this.components.clear();
            this.components.add(component2);
        }
    }

    private void copyTo(int i, int i2, int i3, ByteBuf byteBuf) {
        int i4 = 0;
        while (i2 > 0) {
            Component component = this.components.get(i3);
            ByteBuf byteBuf2 = component.buf;
            int i5 = i - component.offset;
            int min = Math.min(i2, byteBuf2.capacity() - i5);
            byteBuf2.getBytes(i5, byteBuf, i4, min);
            i += min;
            i4 += min;
            i2 -= min;
            i3++;
        }
        byteBuf.writerIndex(byteBuf.capacity());
    }

    private Component findComponent(int i) {
        checkIndex(i);
        int size = this.components.size();
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            Component component = this.components.get(i3);
            if (i >= component.endOffset) {
                i2 = i3 + 1;
            } else if (i >= component.offset) {
                return component;
            } else {
                size = i3 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    private static List<Component> newList(int i) {
        return new ArrayList(Math.min(16, i));
    }

    private void updateComponentOffsets(int i) {
        int size = this.components.size();
        if (size <= i) {
            return;
        }
        Component component = this.components.get(i);
        if (i == 0) {
            component.offset = 0;
            component.endOffset = component.length;
            i++;
        }
        while (i < size) {
            Component component2 = this.components.get(i);
            int i2 = this.components.get(i - 1).endOffset;
            component2.offset = i2;
            component2.endOffset = i2 + component2.length;
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i) {
        Component findComponent = findComponent(i);
        return findComponent.buf.getByte(i - findComponent.offset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i) {
        Component findComponent = findComponent(i);
        if (i + 4 <= findComponent.endOffset) {
            return findComponent.buf.getInt(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getShort(i + 2) & UShort.f40820c) | ((_getShort(i) & UShort.f40820c) << 16);
        }
        return ((_getShort(i + 2) & UShort.f40820c) << 16) | (_getShort(i) & UShort.f40820c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i) {
        Component findComponent = findComponent(i);
        if (i + 4 <= findComponent.endOffset) {
            return findComponent.buf.getIntLE(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getShortLE(i + 2) & UShort.f40820c) << 16) | (_getShortLE(i) & UShort.f40820c);
        }
        return (_getShortLE(i + 2) & UShort.f40820c) | ((_getShortLE(i) & UShort.f40820c) << 16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i) {
        Component findComponent = findComponent(i);
        if (i + 8 <= findComponent.endOffset) {
            return findComponent.buf.getLong(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getInt(i) & 4294967295L) << 32) | (4294967295L & _getInt(i + 4));
        }
        return (_getInt(i) & 4294967295L) | ((4294967295L & _getInt(i + 4)) << 32);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i) {
        Component findComponent = findComponent(i);
        if (i + 8 <= findComponent.endOffset) {
            return findComponent.buf.getLongLE(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getIntLE(i) & 4294967295L) | ((4294967295L & _getIntLE(i + 4)) << 32);
        }
        return ((_getIntLE(i) & 4294967295L) << 32) | (4294967295L & _getIntLE(i + 4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i) {
        Component findComponent = findComponent(i);
        if (i + 2 <= findComponent.endOffset) {
            return findComponent.buf.getShort(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) ((_getByte(i + 1) & UByte.f41242c) | ((_getByte(i) & UByte.f41242c) << 8));
        }
        return (short) (((_getByte(i + 1) & UByte.f41242c) << 8) | (_getByte(i) & UByte.f41242c));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i) {
        Component findComponent = findComponent(i);
        if (i + 2 <= findComponent.endOffset) {
            return findComponent.buf.getShortLE(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) (((_getByte(i + 1) & UByte.f41242c) << 8) | (_getByte(i) & UByte.f41242c));
        }
        return (short) ((_getByte(i + 1) & UByte.f41242c) | ((_getByte(i) & UByte.f41242c) << 8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i) {
        Component findComponent = findComponent(i);
        if (i + 3 <= findComponent.endOffset) {
            return findComponent.buf.getUnsignedMedium(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getByte(i + 2) & UByte.f41242c) | ((_getShort(i) & UShort.f40820c) << 8);
        }
        return ((_getByte(i + 2) & UByte.f41242c) << 16) | (_getShort(i) & UShort.f40820c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i) {
        Component findComponent = findComponent(i);
        if (i + 3 <= findComponent.endOffset) {
            return findComponent.buf.getUnsignedMediumLE(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getByte(i + 2) & UByte.f41242c) << 16) | (_getShortLE(i) & UShort.f40820c);
        }
        return (_getByte(i + 2) & UByte.f41242c) | ((_getShortLE(i) & UShort.f40820c) << 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i, int i2) {
        setByte(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i, int i2) {
        Component findComponent = findComponent(i);
        if (i + 4 <= findComponent.endOffset) {
            findComponent.buf.setInt(i - findComponent.offset, i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i, (short) (i2 >>> 16));
            _setShort(i + 2, (short) i2);
        } else {
            _setShort(i, (short) i2);
            _setShort(i + 2, (short) (i2 >>> 16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i, int i2) {
        Component findComponent = findComponent(i);
        if (i + 4 <= findComponent.endOffset) {
            findComponent.buf.setIntLE(i - findComponent.offset, i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShortLE(i, (short) i2);
            _setShortLE(i + 2, (short) (i2 >>> 16));
        } else {
            _setShortLE(i, (short) (i2 >>> 16));
            _setShortLE(i + 2, (short) i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i, long j) {
        Component findComponent = findComponent(i);
        if (i + 8 <= findComponent.endOffset) {
            findComponent.buf.setLong(i - findComponent.offset, j);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setInt(i, (int) (j >>> 32));
            _setInt(i + 4, (int) j);
        } else {
            _setInt(i, (int) j);
            _setInt(i + 4, (int) (j >>> 32));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i, long j) {
        Component findComponent = findComponent(i);
        if (i + 8 <= findComponent.endOffset) {
            findComponent.buf.setLongLE(i - findComponent.offset, j);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setIntLE(i, (int) j);
            _setIntLE(i + 4, (int) (j >>> 32));
        } else {
            _setIntLE(i, (int) (j >>> 32));
            _setIntLE(i + 4, (int) j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i, int i2) {
        Component findComponent = findComponent(i);
        if (i + 3 <= findComponent.endOffset) {
            findComponent.buf.setMedium(i - findComponent.offset, i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i, (short) (i2 >> 8));
            _setByte(i + 2, (byte) i2);
        } else {
            _setShort(i, (short) i2);
            _setByte(i + 2, (byte) (i2 >>> 16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i, int i2) {
        Component findComponent = findComponent(i);
        if (i + 3 <= findComponent.endOffset) {
            findComponent.buf.setMediumLE(i - findComponent.offset, i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShortLE(i, (short) i2);
            _setByte(i + 2, (byte) (i2 >>> 16));
        } else {
            _setShortLE(i, (short) (i2 >> 8));
            _setByte(i + 2, (byte) i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i, int i2) {
        Component findComponent = findComponent(i);
        if (i + 2 <= findComponent.endOffset) {
            findComponent.buf.setShort(i - findComponent.offset, i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i, (byte) (i2 >>> 8));
            _setByte(i + 1, (byte) i2);
        } else {
            _setByte(i, (byte) i2);
            _setByte(i + 1, (byte) (i2 >>> 8));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i, int i2) {
        Component findComponent = findComponent(i);
        if (i + 2 <= findComponent.endOffset) {
            findComponent.buf.setShortLE(i - findComponent.offset, i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i, (byte) i2);
            _setByte(i + 1, (byte) (i2 >>> 8));
        } else {
            _setByte(i, (byte) (i2 >>> 8));
            _setByte(i + 1, (byte) i2);
        }
    }

    public CompositeByteBuf addComponent(ByteBuf byteBuf) {
        return addComponent(false, byteBuf);
    }

    public CompositeByteBuf addComponents(ByteBuf... byteBufArr) {
        return addComponents(false, byteBufArr);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        int size = this.components.size();
        if (size != 0) {
            if (size == 1) {
                return this.components.get(0).buf.array();
            }
            throw new UnsupportedOperationException();
        }
        return EmptyArrays.EMPTY_BYTES;
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        int size = this.components.size();
        if (size != 0) {
            if (size == 1) {
                return this.components.get(0).buf.arrayOffset();
            }
            throw new UnsupportedOperationException();
        }
        return 0;
    }

    public ByteBuf component(int i) {
        return internalComponent(i).duplicate();
    }

    public ByteBuf componentAtOffset(int i) {
        return internalComponentAtOffset(i).duplicate();
    }

    public CompositeByteBuf consolidate() {
        ensureAccessible();
        int numComponents = numComponents();
        if (numComponents <= 1) {
            return this;
        }
        ByteBuf allocBuffer = allocBuffer(this.components.get(numComponents - 1).endOffset);
        for (int i = 0; i < numComponents; i++) {
            Component component = this.components.get(i);
            allocBuffer.writeBytes(component.buf);
            component.freeIfNecessary();
        }
        this.components.clear();
        this.components.add(new Component(allocBuffer));
        updateComponentOffsets(0);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        ByteBuf buffer = Unpooled.buffer(i2);
        if (i2 != 0) {
            copyTo(i, i2, toComponentIndex(i), buffer);
        }
        return buffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    public void deallocate() {
        if (this.freed) {
            return;
        }
        this.freed = true;
        int size = this.components.size();
        for (int i = 0; i < size; i++) {
            this.components.get(i).freeIfNecessary();
        }
    }

    public List<ByteBuf> decompose(int i, int i2) {
        checkIndex(i, i2);
        if (i2 == 0) {
            return Collections.emptyList();
        }
        int componentIndex = toComponentIndex(i);
        ArrayList arrayList = new ArrayList(this.components.size());
        Component component = this.components.get(componentIndex);
        ByteBuf duplicate = component.buf.duplicate();
        duplicate.readerIndex(i - component.offset);
        while (true) {
            int readableBytes = duplicate.readableBytes();
            if (i2 <= readableBytes) {
                duplicate.writerIndex(duplicate.readerIndex() + i2);
                arrayList.add(duplicate);
                break;
            }
            arrayList.add(duplicate);
            i2 -= readableBytes;
            componentIndex++;
            duplicate = this.components.get(componentIndex).buf.duplicate();
            if (i2 <= 0) {
                break;
            }
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList.set(i3, ((ByteBuf) arrayList.get(i3)).slice());
        }
        return arrayList;
    }

    public CompositeByteBuf discardReadComponents() {
        ensureAccessible();
        int readerIndex = readerIndex();
        if (readerIndex == 0) {
            return this;
        }
        int writerIndex = writerIndex();
        if (readerIndex == writerIndex && writerIndex == capacity()) {
            for (Component component : this.components) {
                component.freeIfNecessary();
            }
            this.components.clear();
            setIndex(0, 0);
            adjustMarkers(readerIndex);
            return this;
        }
        int componentIndex = toComponentIndex(readerIndex);
        for (int i = 0; i < componentIndex; i++) {
            this.components.get(i).freeIfNecessary();
        }
        this.components.subList(0, componentIndex).clear();
        int i2 = this.components.get(0).offset;
        updateComponentOffsets(0);
        setIndex(readerIndex - i2, writerIndex - i2);
        adjustMarkers(i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i) {
        return _getByte(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        int size = this.components.size();
        if (size != 0) {
            if (size != 1) {
                return false;
            }
            return this.components.get(0).buf.hasArray();
        }
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        int size = this.components.size();
        if (size != 0) {
            if (size != 1) {
                return false;
            }
            return this.components.get(0).buf.hasMemoryAddress();
        }
        return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
    }

    public ByteBuf internalComponent(int i) {
        checkComponentIndex(i);
        return this.components.get(i).buf;
    }

    public ByteBuf internalComponentAtOffset(int i) {
        return findComponent(i).buf;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i, int i2) {
        int size = this.components.size();
        if (size != 0) {
            if (size == 1) {
                return this.components.get(0).buf.internalNioBuffer(i, i2);
            }
            throw new UnsupportedOperationException();
        }
        return EMPTY_NIO_BUFFER;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        int size = this.components.size();
        if (size == 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.components.get(i).buf.isDirect()) {
                return false;
            }
        }
        return true;
    }

    public Iterator<ByteBuf> iterator() {
        ensureAccessible();
        if (this.components.isEmpty()) {
            return EMPTY_ITERATOR;
        }
        return new CompositeByteBufIterator();
    }

    public int maxNumComponents() {
        return this.maxNumComponents;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        int size = this.components.size();
        if (size != 0) {
            if (size == 1) {
                return this.components.get(0).buf.memoryAddress();
            }
            throw new UnsupportedOperationException();
        }
        return Unpooled.EMPTY_BUFFER.memoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i, int i2) {
        checkIndex(i, i2);
        int size = this.components.size();
        if (size != 0) {
            if (size == 1 && this.components.get(0).buf.nioBufferCount() == 1) {
                return this.components.get(0).buf.nioBuffer(i, i2);
            }
            ByteBuffer order = ByteBuffer.allocate(i2).order(order());
            for (ByteBuffer byteBuffer : nioBuffers(i, i2)) {
                order.put(byteBuffer);
            }
            order.flip();
            return order;
        }
        return EMPTY_NIO_BUFFER;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        int size = this.components.size();
        if (size != 0) {
            if (size != 1) {
                int size2 = this.components.size();
                int i = 0;
                for (int i2 = 0; i2 < size2; i2++) {
                    i += this.components.get(i2).buf.nioBufferCount();
                }
                return i;
            }
            return this.components.get(0).buf.nioBufferCount();
        }
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i, int i2) {
        checkIndex(i, i2);
        if (i2 == 0) {
            return new ByteBuffer[]{EMPTY_NIO_BUFFER};
        }
        ArrayList arrayList = new ArrayList(this.components.size());
        int componentIndex = toComponentIndex(i);
        while (i2 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf = component.buf;
            int i3 = i - component.offset;
            int min = Math.min(i2, byteBuf.capacity() - i3);
            int nioBufferCount = byteBuf.nioBufferCount();
            if (nioBufferCount == 0) {
                throw new UnsupportedOperationException();
            }
            if (nioBufferCount != 1) {
                Collections.addAll(arrayList, byteBuf.nioBuffers(i3, min));
            } else {
                arrayList.add(byteBuf.nioBuffer(i3, min));
            }
            i += min;
            i2 -= min;
            componentIndex++;
        }
        return (ByteBuffer[]) arrayList.toArray(new ByteBuffer[arrayList.size()]);
    }

    public int numComponents() {
        return this.components.size();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    public CompositeByteBuf removeComponent(int i) {
        checkComponentIndex(i);
        Component remove = this.components.remove(i);
        remove.freeIfNecessary();
        if (remove.length > 0) {
            updateComponentOffsets(i);
        }
        return this;
    }

    public CompositeByteBuf removeComponents(int i, int i2) {
        checkComponentIndex(i, i2);
        if (i2 == 0) {
            return this;
        }
        List<Component> subList = this.components.subList(i, i2 + i);
        boolean z = false;
        for (Component component : subList) {
            if (component.length > 0) {
                z = true;
            }
            component.freeIfNecessary();
        }
        subList.clear();
        if (z) {
            updateComponentOffsets(i);
        }
        return this;
    }

    public int toByteIndex(int i) {
        checkComponentIndex(i);
        return this.components.get(i).offset;
    }

    public int toComponentIndex(int i) {
        checkIndex(i);
        int size = this.components.size();
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            Component component = this.components.get(i3);
            if (i >= component.endOffset) {
                i2 = i3 + 1;
            } else if (i >= component.offset) {
                return i3;
            } else {
                size = i3 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public String toString() {
        String abstractByteBuf = super.toString();
        String substring = abstractByteBuf.substring(0, abstractByteBuf.length() - 1);
        return substring + ", components=" + this.components.size() + ')';
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf touch() {
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf touch(Object obj) {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    public CompositeByteBuf addComponent(int i, ByteBuf byteBuf) {
        return addComponent(false, i, byteBuf);
    }

    public CompositeByteBuf addComponents(Iterable<ByteBuf> iterable) {
        return addComponents(false, iterable);
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        int size = this.components.size();
        if (size == 0) {
            return 0;
        }
        return this.components.get(size - 1).endOffset;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf clear() {
        return (CompositeByteBuf) super.clear();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf discardReadBytes() {
        ensureAccessible();
        int readerIndex = readerIndex();
        if (readerIndex == 0) {
            return this;
        }
        int writerIndex = writerIndex();
        if (readerIndex == writerIndex && writerIndex == capacity()) {
            for (Component component : this.components) {
                component.freeIfNecessary();
            }
            this.components.clear();
            setIndex(0, 0);
            adjustMarkers(readerIndex);
            return this;
        }
        int componentIndex = toComponentIndex(readerIndex);
        for (int i = 0; i < componentIndex; i++) {
            this.components.get(i).freeIfNecessary();
        }
        this.components.subList(0, componentIndex).clear();
        Component component2 = this.components.get(0);
        int i2 = readerIndex - component2.offset;
        int i3 = component2.length;
        if (i2 == i3) {
            this.components.remove(0);
        } else {
            this.components.set(0, new Component(component2.buf.slice(i2, i3 - i2)));
        }
        updateComponentOffsets(0);
        setIndex(0, writerIndex - readerIndex);
        adjustMarkers(readerIndex);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf discardSomeReadBytes() {
        return discardReadComponents();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf ensureWritable(int i) {
        return (CompositeByteBuf) super.ensureWritable(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf markReaderIndex() {
        return (CompositeByteBuf) super.markReaderIndex();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf markWriterIndex() {
        return (CompositeByteBuf) super.markWriterIndex();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readerIndex(int i) {
        return (CompositeByteBuf) super.readerIndex(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf resetReaderIndex() {
        return (CompositeByteBuf) super.resetReaderIndex();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf resetWriterIndex() {
        return (CompositeByteBuf) super.resetWriterIndex();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBoolean(int i, boolean z) {
        return (CompositeByteBuf) super.setBoolean(i, z);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setByte(int i, int i2) {
        Component findComponent = findComponent(i);
        findComponent.buf.setByte(i - findComponent.offset, i2);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setChar(int i, int i2) {
        return (CompositeByteBuf) super.setChar(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setDouble(int i, double d) {
        return (CompositeByteBuf) super.setDouble(i, d);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setFloat(int i, float f) {
        return (CompositeByteBuf) super.setFloat(i, f);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setIndex(int i, int i2) {
        return (CompositeByteBuf) super.setIndex(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setInt(int i, int i2) {
        return (CompositeByteBuf) super.setInt(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setLong(int i, long j) {
        return (CompositeByteBuf) super.setLong(i, j);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setMedium(int i, int i2) {
        return (CompositeByteBuf) super.setMedium(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setShort(int i, int i2) {
        return (CompositeByteBuf) super.setShort(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setZero(int i, int i2) {
        return (CompositeByteBuf) super.setZero(i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf skipBytes(int i) {
        return (CompositeByteBuf) super.skipBytes(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBoolean(boolean z) {
        return (CompositeByteBuf) super.writeBoolean(z);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeByte(int i) {
        return (CompositeByteBuf) super.writeByte(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeChar(int i) {
        return (CompositeByteBuf) super.writeChar(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeDouble(double d) {
        return (CompositeByteBuf) super.writeDouble(d);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeFloat(float f) {
        return (CompositeByteBuf) super.writeFloat(f);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeInt(int i) {
        return (CompositeByteBuf) super.writeInt(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeLong(long j) {
        return (CompositeByteBuf) super.writeLong(j);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeMedium(int i) {
        return (CompositeByteBuf) super.writeMedium(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeShort(int i) {
        return (CompositeByteBuf) super.writeShort(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeZero(int i) {
        return (CompositeByteBuf) super.writeZero(i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writerIndex(int i) {
        return (CompositeByteBuf) super.writerIndex(i);
    }

    public CompositeByteBuf addComponent(boolean z, ByteBuf byteBuf) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        addComponent0(z, this.components.size(), byteBuf);
        consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf addComponents(boolean z, ByteBuf... byteBufArr) {
        addComponents0(z, this.components.size(), byteBufArr, 0, byteBufArr.length);
        consolidateIfNeeded();
        return this;
    }

    private void checkComponentIndex(int i, int i2) {
        ensureAccessible();
        if (i < 0 || i + i2 > this.components.size()) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d, numComponents: %d (expected: cIndex >= 0 && cIndex + numComponents <= totalNumComponents(%d))", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.components.size())));
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf capacity(int i) {
        ensureAccessible();
        if (i >= 0 && i <= maxCapacity()) {
            int capacity = capacity();
            if (i > capacity) {
                int i2 = i - capacity;
                if (this.components.size() < this.maxNumComponents) {
                    ByteBuf allocBuffer = allocBuffer(i2);
                    allocBuffer.setIndex(0, i2);
                    addComponent0(false, this.components.size(), allocBuffer);
                } else {
                    ByteBuf allocBuffer2 = allocBuffer(i2);
                    allocBuffer2.setIndex(0, i2);
                    addComponent0(false, this.components.size(), allocBuffer2);
                    consolidateIfNeeded();
                }
            } else if (i < capacity) {
                int i3 = capacity - i;
                List<Component> list = this.components;
                ListIterator<Component> listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    Component previous = listIterator.previous();
                    int i4 = previous.length;
                    if (i3 >= i4) {
                        i3 -= i4;
                        listIterator.remove();
                    } else {
                        Component component = new Component(previous.buf.slice(0, i4 - i3));
                        int i5 = previous.offset;
                        component.offset = i5;
                        component.endOffset = i5 + component.length;
                        listIterator.set(component);
                        break;
                    }
                }
                if (readerIndex() > i) {
                    setIndex(i, i);
                } else if (writerIndex() > i) {
                    writerIndex(i);
                }
            }
            return this;
        }
        throw new IllegalArgumentException("newCapacity: " + i);
    }

    public CompositeByteBuf addComponents(boolean z, Iterable<ByteBuf> iterable) {
        addComponents0(z, this.components.size(), iterable);
        consolidateIfNeeded();
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain(int i) {
        return (CompositeByteBuf) super.retain(i);
    }

    public CompositeByteBuf addComponent(boolean z, int i, ByteBuf byteBuf) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        addComponent0(z, i, byteBuf);
        consolidateIfNeeded();
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain() {
        return (CompositeByteBuf) super.retain();
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z, int i, ByteBuf... byteBufArr) {
        this(byteBufAllocator, z, i, byteBufArr, 0, byteBufArr.length);
    }

    public CompositeByteBuf addComponents(int i, ByteBuf... byteBufArr) {
        addComponents0(false, i, byteBufArr, 0, byteBufArr.length);
        consolidateIfNeeded();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        checkSrcIndex(i, i3, i2, bArr.length);
        if (i3 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i);
        while (i3 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf = component.buf;
            int i4 = i - component.offset;
            int min = Math.min(i3, byteBuf.capacity() - i4);
            byteBuf.setBytes(i4, bArr, i2, min);
            i += min;
            i2 += min;
            i3 -= min;
            componentIndex++;
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf) {
        return (CompositeByteBuf) super.writeBytes(byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z, int i, ByteBuf[] byteBufArr, int i2, int i3) {
        super(Integer.MAX_VALUE);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (i >= 2) {
            this.alloc = byteBufAllocator;
            this.direct = z;
            this.maxNumComponents = i;
            this.components = newList(i);
            addComponents0(false, 0, byteBufArr, i2, i3);
            consolidateIfNeeded();
            setIndex(0, capacity());
            return;
        }
        throw new IllegalArgumentException("maxNumComponents: " + i + " (expected: >= 2)");
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkDstIndex(i, i3, i2, bArr.length);
        if (i3 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i);
        while (i3 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf = component.buf;
            int i4 = i - component.offset;
            int min = Math.min(i3, byteBuf.capacity() - i4);
            byteBuf.getBytes(i4, bArr, i2, min);
            i += min;
            i2 += min;
            i3 -= min;
            componentIndex++;
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf) {
        return (CompositeByteBuf) super.readBytes(byteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i) {
        return (CompositeByteBuf) super.writeBytes(byteBuf, i);
    }

    public CompositeByteBuf addComponents(int i, Iterable<ByteBuf> iterable) {
        addComponents0(false, i, iterable);
        consolidateIfNeeded();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i) {
        return (CompositeByteBuf) super.readBytes(byteBuf, i);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i, int i2) {
        return (CompositeByteBuf) super.writeBytes(byteBuf, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i, int i2) {
        return (CompositeByteBuf) super.readBytes(byteBuf, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr) {
        return (CompositeByteBuf) super.writeBytes(bArr);
    }

    private int addComponents0(boolean z, int i, Iterable<ByteBuf> iterable) {
        if (iterable instanceof ByteBuf) {
            return addComponent0(z, i, (ByteBuf) iterable);
        }
        ObjectUtil.checkNotNull(iterable, "buffers");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList();
            try {
                for (ByteBuf byteBuf : iterable) {
                    arrayList.add(byteBuf);
                }
                iterable = arrayList;
            } catch (Throwable th) {
                if (iterable != arrayList) {
                    for (ByteBuf byteBuf2 : iterable) {
                        if (byteBuf2 != null) {
                            try {
                                byteBuf2.release();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
                throw th;
            }
        }
        Collection collection = (Collection) iterable;
        return addComponents0(z, i, (ByteBuf[]) collection.toArray(new ByteBuf[collection.size()]), 0, collection.size());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr) {
        return (CompositeByteBuf) super.readBytes(bArr);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr, int i, int i2) {
        return (CompositeByteBuf) super.writeBytes(bArr, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr, int i, int i2) {
        return (CompositeByteBuf) super.readBytes(bArr, i, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuffer byteBuffer) {
        return (CompositeByteBuf) super.writeBytes(byteBuffer);
    }

    public CompositeByteBuf consolidate(int i, int i2) {
        checkComponentIndex(i, i2);
        if (i2 <= 1) {
            return this;
        }
        int i3 = i2 + i;
        ByteBuf allocBuffer = allocBuffer(this.components.get(i3 - 1).endOffset - this.components.get(i).offset);
        for (int i4 = i; i4 < i3; i4++) {
            Component component = this.components.get(i4);
            allocBuffer.writeBytes(component.buf);
            component.freeIfNecessary();
        }
        this.components.subList(i + 1, i3).clear();
        this.components.set(i, new Component(allocBuffer));
        updateComponentOffsets(i);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuffer byteBuffer) {
        return (CompositeByteBuf) super.readBytes(byteBuffer);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return nioBuffers(readerIndex(), readableBytes());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(OutputStream outputStream, int i) throws IOException {
        return (CompositeByteBuf) super.readBytes(outputStream, i);
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int remaining = byteBuffer.remaining();
        checkIndex(i, remaining);
        if (remaining == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i);
        while (remaining > 0) {
            try {
                Component component = this.components.get(componentIndex);
                ByteBuf byteBuf = component.buf;
                int i2 = i - component.offset;
                int min = Math.min(remaining, byteBuf.capacity() - i2);
                byteBuffer.limit(byteBuffer.position() + min);
                byteBuf.setBytes(i2, byteBuffer);
                i += min;
                remaining -= min;
                componentIndex++;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int remaining = byteBuffer.remaining();
        checkIndex(i, remaining);
        if (remaining == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i);
        while (remaining > 0) {
            try {
                Component component = this.components.get(componentIndex);
                ByteBuf byteBuf = component.buf;
                int i2 = i - component.offset;
                int min = Math.min(remaining, byteBuf.capacity() - i2);
                byteBuffer.limit(byteBuffer.position() + min);
                byteBuf.getBytes(i2, byteBuffer);
                i += min;
                remaining -= min;
                componentIndex++;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        return this;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z, int i, Iterable<ByteBuf> iterable) {
        super(Integer.MAX_VALUE);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (i >= 2) {
            this.alloc = byteBufAllocator;
            this.direct = z;
            this.maxNumComponents = i;
            this.components = newList(i);
            addComponents0(false, 0, iterable);
            consolidateIfNeeded();
            setIndex(0, capacity());
            return;
        }
        throw new IllegalArgumentException("maxNumComponents: " + i + " (expected: >= 2)");
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkSrcIndex(i, i3, i2, byteBuf.capacity());
        if (i3 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i);
        while (i3 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf2 = component.buf;
            int i4 = i - component.offset;
            int min = Math.min(i3, byteBuf2.capacity() - i4);
            byteBuf2.setBytes(i4, byteBuf, i2, min);
            i += min;
            i2 += min;
            i3 -= min;
            componentIndex++;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkDstIndex(i, i3, i2, byteBuf.capacity());
        if (i3 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i);
        while (i3 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf2 = component.buf;
            int i4 = i - component.offset;
            int min = Math.min(i3, byteBuf2.capacity() - i4);
            byteBuf2.getBytes(i4, byteBuf, i2, min);
            i += min;
            i2 += min;
            i3 -= min;
            componentIndex++;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeByteBuf(ByteBufAllocator byteBufAllocator) {
        super(Integer.MAX_VALUE);
        this.alloc = byteBufAllocator;
        this.direct = false;
        this.maxNumComponents = 0;
        this.components = Collections.emptyList();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042 A[EDGE_INSN: B:20:0x0042->B:19:0x0042 ?: BREAK  , SYNTHETIC] */
    @Override // io.netty.buffer.ByteBuf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int setBytes(int r6, java.io.InputStream r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            r5.checkIndex(r6, r8)
            if (r8 != 0) goto Lc
            byte[] r6 = io.netty.util.internal.EmptyArrays.EMPTY_BYTES
            int r6 = r7.read(r6)
            return r6
        Lc:
            int r0 = r5.toComponentIndex(r6)
            r1 = 0
        L11:
            java.util.List<io.netty.buffer.CompositeByteBuf$Component> r2 = r5.components
            java.lang.Object r2 = r2.get(r0)
            io.netty.buffer.CompositeByteBuf$Component r2 = (io.netty.buffer.CompositeByteBuf.Component) r2
            io.netty.buffer.ByteBuf r3 = r2.buf
            int r2 = r2.offset
            int r4 = r3.capacity()
            int r2 = r6 - r2
            int r4 = r4 - r2
            int r4 = java.lang.Math.min(r8, r4)
            if (r4 != 0) goto L2d
        L2a:
            int r0 = r0 + 1
            goto L40
        L2d:
            int r2 = r3.setBytes(r2, r7, r4)
            if (r2 >= 0) goto L37
            if (r1 != 0) goto L42
            r6 = -1
            return r6
        L37:
            if (r2 != r4) goto L3d
            int r6 = r6 + r4
            int r8 = r8 - r4
            int r1 = r1 + r4
            goto L2a
        L3d:
            int r6 = r6 + r2
            int r8 = r8 - r2
            int r1 = r1 + r2
        L40:
            if (r8 > 0) goto L11
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.CompositeByteBuf.setBytes(int, java.io.InputStream, int):int");
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        if (nioBufferCount() == 1) {
            return gatheringByteChannel.write(internalNioBuffer(i, i2));
        }
        long write = gatheringByteChannel.write(nioBuffers(i, i2));
        if (write > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) write;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        if (nioBufferCount() == 1) {
            return fileChannel.write(internalNioBuffer(i, i2), j);
        }
        long j2 = 0;
        for (ByteBuffer byteBuffer : nioBuffers(i, i2)) {
            j2 += fileChannel.write(byteBuffer, j + j2);
        }
        if (j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j2;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        checkIndex(i, i2);
        if (i2 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i);
        while (i2 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf = component.buf;
            int i3 = i - component.offset;
            int min = Math.min(i2, byteBuf.capacity() - i3);
            byteBuf.getBytes(i3, outputStream, min);
            i += min;
            i2 -= min;
            componentIndex++;
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0045 A[EDGE_INSN: B:23:0x0045->B:21:0x0045 ?: BREAK  , SYNTHETIC] */
    @Override // io.netty.buffer.ByteBuf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int setBytes(int r6, java.nio.channels.ScatteringByteChannel r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            r5.checkIndex(r6, r8)
            if (r8 != 0) goto Lc
            java.nio.ByteBuffer r6 = io.netty.buffer.CompositeByteBuf.EMPTY_NIO_BUFFER
            int r6 = r7.read(r6)
            return r6
        Lc:
            int r0 = r5.toComponentIndex(r6)
            r1 = 0
        L11:
            java.util.List<io.netty.buffer.CompositeByteBuf$Component> r2 = r5.components
            java.lang.Object r2 = r2.get(r0)
            io.netty.buffer.CompositeByteBuf$Component r2 = (io.netty.buffer.CompositeByteBuf.Component) r2
            io.netty.buffer.ByteBuf r3 = r2.buf
            int r2 = r2.offset
            int r4 = r3.capacity()
            int r2 = r6 - r2
            int r4 = r4 - r2
            int r4 = java.lang.Math.min(r8, r4)
            if (r4 != 0) goto L2d
        L2a:
            int r0 = r0 + 1
            goto L43
        L2d:
            int r2 = r3.setBytes(r2, r7, r4)
            if (r2 != 0) goto L34
            goto L45
        L34:
            if (r2 >= 0) goto L3a
            if (r1 != 0) goto L45
            r6 = -1
            return r6
        L3a:
            if (r2 != r4) goto L40
            int r6 = r6 + r4
            int r8 = r8 - r4
            int r1 = r1 + r4
            goto L2a
        L40:
            int r6 = r6 + r2
            int r8 = r8 - r2
            int r1 = r1 + r2
        L43:
            if (r8 > 0) goto L11
        L45:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.CompositeByteBuf.setBytes(int, java.nio.channels.ScatteringByteChannel, int):int");
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i, ByteBuf byteBuf) {
        return (CompositeByteBuf) super.getBytes(i, byteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i, ByteBuf byteBuf, int i2) {
        return (CompositeByteBuf) super.getBytes(i, byteBuf, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b A[EDGE_INSN: B:23:0x004b->B:21:0x004b ?: BREAK  , SYNTHETIC] */
    @Override // io.netty.buffer.ByteBuf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int setBytes(int r11, java.nio.channels.FileChannel r12, long r13, int r15) throws java.io.IOException {
        /*
            r10 = this;
            r10.checkIndex(r11, r15)
            if (r15 != 0) goto Lc
            java.nio.ByteBuffer r11 = io.netty.buffer.CompositeByteBuf.EMPTY_NIO_BUFFER
            int r11 = r12.read(r11, r13)
            return r11
        Lc:
            int r0 = r10.toComponentIndex(r11)
            r1 = 0
        L11:
            java.util.List<io.netty.buffer.CompositeByteBuf$Component> r2 = r10.components
            java.lang.Object r2 = r2.get(r0)
            io.netty.buffer.CompositeByteBuf$Component r2 = (io.netty.buffer.CompositeByteBuf.Component) r2
            io.netty.buffer.ByteBuf r3 = r2.buf
            int r2 = r2.offset
            int r4 = r3.capacity()
            int r2 = r11 - r2
            int r4 = r4 - r2
            int r9 = java.lang.Math.min(r15, r4)
            if (r9 != 0) goto L2d
        L2a:
            int r0 = r0 + 1
            goto L49
        L2d:
            long r4 = (long) r1
            long r6 = r13 + r4
            r4 = r2
            r5 = r12
            r8 = r9
            int r2 = r3.setBytes(r4, r5, r6, r8)
            if (r2 != 0) goto L3a
            goto L4b
        L3a:
            if (r2 >= 0) goto L40
            if (r1 != 0) goto L4b
            r11 = -1
            return r11
        L40:
            if (r2 != r9) goto L46
            int r11 = r11 + r9
            int r15 = r15 - r9
            int r1 = r1 + r9
            goto L2a
        L46:
            int r11 = r11 + r2
            int r15 = r15 - r2
            int r1 = r1 + r2
        L49:
            if (r15 > 0) goto L11
        L4b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.CompositeByteBuf.setBytes(int, java.nio.channels.FileChannel, long, int):int");
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i, byte[] bArr) {
        return (CompositeByteBuf) super.getBytes(i, bArr);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i, ByteBuf byteBuf) {
        return (CompositeByteBuf) super.setBytes(i, byteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i, ByteBuf byteBuf, int i2) {
        return (CompositeByteBuf) super.setBytes(i, byteBuf, i2);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i, byte[] bArr) {
        return (CompositeByteBuf) super.setBytes(i, bArr);
    }
}
