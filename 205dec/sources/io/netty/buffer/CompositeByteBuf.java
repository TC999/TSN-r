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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class CompositeByteBuf extends AbstractReferenceCountedByteBuf implements Iterable<ByteBuf> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ByteBufAllocator alloc;
    private final List<Component> components;
    private final boolean direct;
    private boolean freed;
    private final int maxNumComponents;
    private static final ByteBuffer EMPTY_NIO_BUFFER = Unpooled.EMPTY_BUFFER.nioBuffer();
    private static final Iterator<ByteBuf> EMPTY_ITERATOR = Collections.emptyList().iterator();

    /* renamed from: io.netty.buffer.CompositeByteBuf$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class AnonymousClass2 implements ByteWrapper<ByteBuffer> {
        AnonymousClass2() {
        }

        @Override // io.netty.buffer.CompositeByteBuf.ByteWrapper
        public boolean isEmpty(ByteBuffer byteBuffer) {
            return !byteBuffer.hasRemaining();
        }

        @Override // io.netty.buffer.CompositeByteBuf.ByteWrapper
        public ByteBuf wrap(ByteBuffer byteBuffer) {
            return Unpooled.wrappedBuffer(byteBuffer);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    interface ByteWrapper<T> {
        boolean isEmpty(T t3);

        ByteBuf wrap(T t3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
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
                        int i4 = this.index;
                        this.index = i4 + 1;
                        return ((Component) list.get(i4)).buf;
                    } catch (IndexOutOfBoundsException unused) {
                        throw new ConcurrentModificationException();
                    }
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z3, int i4) {
        super(Integer.MAX_VALUE);
        if (byteBufAllocator != null) {
            this.alloc = byteBufAllocator;
            this.direct = z3;
            this.maxNumComponents = i4;
            this.components = newList(i4);
            return;
        }
        throw new NullPointerException("alloc");
    }

    private int addComponent0(boolean z3, int i4, ByteBuf byteBuf) {
        boolean z4 = false;
        try {
            checkComponentIndex(i4);
            int readableBytes = byteBuf.readableBytes();
            Component component = new Component(byteBuf.order(ByteOrder.BIG_ENDIAN).slice());
            if (i4 == this.components.size()) {
                z4 = this.components.add(component);
                if (i4 == 0) {
                    component.endOffset = readableBytes;
                } else {
                    int i5 = this.components.get(i4 - 1).endOffset;
                    component.offset = i5;
                    component.endOffset = i5 + readableBytes;
                }
            } else {
                this.components.add(i4, component);
                if (readableBytes != 0) {
                    try {
                        updateComponentOffsets(i4);
                    } catch (Throwable th) {
                        th = th;
                        z4 = true;
                        if (!z4) {
                            byteBuf.release();
                        }
                        throw th;
                    }
                }
                z4 = true;
            }
            if (z3) {
                writerIndex(writerIndex() + byteBuf.readableBytes());
            }
            if (!z4) {
                byteBuf.release();
            }
            return i4;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private int addComponents0(boolean z3, int i4, ByteBuf[] byteBufArr, int i5, int i6) {
        ObjectUtil.checkNotNull(byteBufArr, "buffers");
        try {
            checkComponentIndex(i4);
            while (true) {
                if (i5 >= i6) {
                    break;
                }
                int i7 = i5 + 1;
                try {
                    ByteBuf byteBuf = byteBufArr[i5];
                    if (byteBuf == null) {
                        i5 = i7;
                        break;
                    }
                    i4 = addComponent0(z3, i4, byteBuf) + 1;
                    int size = this.components.size();
                    if (i4 > size) {
                        i4 = size;
                    }
                    i5 = i7;
                } catch (Throwable th) {
                    th = th;
                    i5 = i7;
                    while (i5 < i6) {
                        ByteBuf byteBuf2 = byteBufArr[i5];
                        if (byteBuf2 != null) {
                            try {
                                byteBuf2.release();
                            } catch (Throwable unused) {
                            }
                        }
                        i5++;
                    }
                    throw th;
                }
            }
            while (i5 < i6) {
                ByteBuf byteBuf3 = byteBufArr[i5];
                if (byteBuf3 != null) {
                    try {
                        byteBuf3.release();
                    } catch (Throwable unused2) {
                    }
                }
                i5++;
            }
            return i4;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private ByteBuf allocBuffer(int i4) {
        return this.direct ? alloc().directBuffer(i4) : alloc().heapBuffer(i4);
    }

    private void checkComponentIndex(int i4) {
        ensureAccessible();
        if (i4 < 0 || i4 > this.components.size()) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d (expected: >= 0 && <= numComponents(%d))", Integer.valueOf(i4), Integer.valueOf(this.components.size())));
        }
    }

    private void consolidateIfNeeded() {
        int size = this.components.size();
        if (size > this.maxNumComponents) {
            ByteBuf allocBuffer = allocBuffer(this.components.get(size - 1).endOffset);
            for (int i4 = 0; i4 < size; i4++) {
                Component component = this.components.get(i4);
                allocBuffer.writeBytes(component.buf);
                component.freeIfNecessary();
            }
            Component component2 = new Component(allocBuffer);
            component2.endOffset = component2.length;
            this.components.clear();
            this.components.add(component2);
        }
    }

    private void copyTo(int i4, int i5, int i6, ByteBuf byteBuf) {
        int i7 = 0;
        while (i5 > 0) {
            Component component = this.components.get(i6);
            ByteBuf byteBuf2 = component.buf;
            int i8 = i4 - component.offset;
            int min = Math.min(i5, byteBuf2.capacity() - i8);
            byteBuf2.getBytes(i8, byteBuf, i7, min);
            i4 += min;
            i7 += min;
            i5 -= min;
            i6++;
        }
        byteBuf.writerIndex(byteBuf.capacity());
    }

    private Component findComponent(int i4) {
        checkIndex(i4);
        int size = this.components.size();
        int i5 = 0;
        while (i5 <= size) {
            int i6 = (i5 + size) >>> 1;
            Component component = this.components.get(i6);
            if (i4 >= component.endOffset) {
                i5 = i6 + 1;
            } else if (i4 >= component.offset) {
                return component;
            } else {
                size = i6 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    private static List<Component> newList(int i4) {
        return new ArrayList(Math.min(16, i4));
    }

    private void updateComponentOffsets(int i4) {
        int size = this.components.size();
        if (size <= i4) {
            return;
        }
        Component component = this.components.get(i4);
        if (i4 == 0) {
            component.offset = 0;
            component.endOffset = component.length;
            i4++;
        }
        while (i4 < size) {
            Component component2 = this.components.get(i4);
            int i5 = this.components.get(i4 - 1).endOffset;
            component2.offset = i5;
            component2.endOffset = i5 + component2.length;
            i4++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i4) {
        Component findComponent = findComponent(i4);
        return findComponent.buf.getByte(i4 - findComponent.offset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i4) {
        Component findComponent = findComponent(i4);
        if (i4 + 4 <= findComponent.endOffset) {
            return findComponent.buf.getInt(i4 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getShort(i4 + 2) & 65535) | ((_getShort(i4) & 65535) << 16);
        }
        return ((_getShort(i4 + 2) & 65535) << 16) | (_getShort(i4) & 65535);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i4) {
        Component findComponent = findComponent(i4);
        if (i4 + 4 <= findComponent.endOffset) {
            return findComponent.buf.getIntLE(i4 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getShortLE(i4 + 2) & 65535) << 16) | (_getShortLE(i4) & 65535);
        }
        return (_getShortLE(i4 + 2) & 65535) | ((_getShortLE(i4) & 65535) << 16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i4) {
        Component findComponent = findComponent(i4);
        if (i4 + 8 <= findComponent.endOffset) {
            return findComponent.buf.getLong(i4 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getInt(i4) & 4294967295L) << 32) | (4294967295L & _getInt(i4 + 4));
        }
        return (_getInt(i4) & 4294967295L) | ((4294967295L & _getInt(i4 + 4)) << 32);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i4) {
        Component findComponent = findComponent(i4);
        if (i4 + 8 <= findComponent.endOffset) {
            return findComponent.buf.getLongLE(i4 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getIntLE(i4) & 4294967295L) | ((4294967295L & _getIntLE(i4 + 4)) << 32);
        }
        return ((_getIntLE(i4) & 4294967295L) << 32) | (4294967295L & _getIntLE(i4 + 4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i4) {
        Component findComponent = findComponent(i4);
        if (i4 + 2 <= findComponent.endOffset) {
            return findComponent.buf.getShort(i4 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) ((_getByte(i4 + 1) & 255) | ((_getByte(i4) & 255) << 8));
        }
        return (short) (((_getByte(i4 + 1) & 255) << 8) | (_getByte(i4) & 255));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i4) {
        Component findComponent = findComponent(i4);
        if (i4 + 2 <= findComponent.endOffset) {
            return findComponent.buf.getShortLE(i4 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) (((_getByte(i4 + 1) & 255) << 8) | (_getByte(i4) & 255));
        }
        return (short) ((_getByte(i4 + 1) & 255) | ((_getByte(i4) & 255) << 8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i4) {
        Component findComponent = findComponent(i4);
        if (i4 + 3 <= findComponent.endOffset) {
            return findComponent.buf.getUnsignedMedium(i4 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getByte(i4 + 2) & 255) | ((_getShort(i4) & 65535) << 8);
        }
        return ((_getByte(i4 + 2) & 255) << 16) | (_getShort(i4) & 65535);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i4) {
        Component findComponent = findComponent(i4);
        if (i4 + 3 <= findComponent.endOffset) {
            return findComponent.buf.getUnsignedMediumLE(i4 - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getByte(i4 + 2) & 255) << 16) | (_getShortLE(i4) & 65535);
        }
        return (_getByte(i4 + 2) & 255) | ((_getShortLE(i4) & 65535) << 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i4, int i5) {
        setByte(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i4, int i5) {
        Component findComponent = findComponent(i4);
        if (i4 + 4 <= findComponent.endOffset) {
            findComponent.buf.setInt(i4 - findComponent.offset, i5);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i4, (short) (i5 >>> 16));
            _setShort(i4 + 2, (short) i5);
        } else {
            _setShort(i4, (short) i5);
            _setShort(i4 + 2, (short) (i5 >>> 16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i4, int i5) {
        Component findComponent = findComponent(i4);
        if (i4 + 4 <= findComponent.endOffset) {
            findComponent.buf.setIntLE(i4 - findComponent.offset, i5);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShortLE(i4, (short) i5);
            _setShortLE(i4 + 2, (short) (i5 >>> 16));
        } else {
            _setShortLE(i4, (short) (i5 >>> 16));
            _setShortLE(i4 + 2, (short) i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i4, long j4) {
        Component findComponent = findComponent(i4);
        if (i4 + 8 <= findComponent.endOffset) {
            findComponent.buf.setLong(i4 - findComponent.offset, j4);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setInt(i4, (int) (j4 >>> 32));
            _setInt(i4 + 4, (int) j4);
        } else {
            _setInt(i4, (int) j4);
            _setInt(i4 + 4, (int) (j4 >>> 32));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i4, long j4) {
        Component findComponent = findComponent(i4);
        if (i4 + 8 <= findComponent.endOffset) {
            findComponent.buf.setLongLE(i4 - findComponent.offset, j4);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setIntLE(i4, (int) j4);
            _setIntLE(i4 + 4, (int) (j4 >>> 32));
        } else {
            _setIntLE(i4, (int) (j4 >>> 32));
            _setIntLE(i4 + 4, (int) j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i4, int i5) {
        Component findComponent = findComponent(i4);
        if (i4 + 3 <= findComponent.endOffset) {
            findComponent.buf.setMedium(i4 - findComponent.offset, i5);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i4, (short) (i5 >> 8));
            _setByte(i4 + 2, (byte) i5);
        } else {
            _setShort(i4, (short) i5);
            _setByte(i4 + 2, (byte) (i5 >>> 16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i4, int i5) {
        Component findComponent = findComponent(i4);
        if (i4 + 3 <= findComponent.endOffset) {
            findComponent.buf.setMediumLE(i4 - findComponent.offset, i5);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShortLE(i4, (short) i5);
            _setByte(i4 + 2, (byte) (i5 >>> 16));
        } else {
            _setShortLE(i4, (short) (i5 >> 8));
            _setByte(i4 + 2, (byte) i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i4, int i5) {
        Component findComponent = findComponent(i4);
        if (i4 + 2 <= findComponent.endOffset) {
            findComponent.buf.setShort(i4 - findComponent.offset, i5);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i4, (byte) (i5 >>> 8));
            _setByte(i4 + 1, (byte) i5);
        } else {
            _setByte(i4, (byte) i5);
            _setByte(i4 + 1, (byte) (i5 >>> 8));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i4, int i5) {
        Component findComponent = findComponent(i4);
        if (i4 + 2 <= findComponent.endOffset) {
            findComponent.buf.setShortLE(i4 - findComponent.offset, i5);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i4, (byte) i5);
            _setByte(i4 + 1, (byte) (i5 >>> 8));
        } else {
            _setByte(i4, (byte) (i5 >>> 8));
            _setByte(i4 + 1, (byte) i5);
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

    public ByteBuf component(int i4) {
        return internalComponent(i4).duplicate();
    }

    public ByteBuf componentAtOffset(int i4) {
        return internalComponentAtOffset(i4).duplicate();
    }

    public CompositeByteBuf consolidate() {
        ensureAccessible();
        int numComponents = numComponents();
        if (numComponents <= 1) {
            return this;
        }
        ByteBuf allocBuffer = allocBuffer(this.components.get(numComponents - 1).endOffset);
        for (int i4 = 0; i4 < numComponents; i4++) {
            Component component = this.components.get(i4);
            allocBuffer.writeBytes(component.buf);
            component.freeIfNecessary();
        }
        this.components.clear();
        this.components.add(new Component(allocBuffer));
        updateComponentOffsets(0);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i4, int i5) {
        checkIndex(i4, i5);
        ByteBuf buffer = Unpooled.buffer(i5);
        if (i5 != 0) {
            copyTo(i4, i5, toComponentIndex(i4), buffer);
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
        for (int i4 = 0; i4 < size; i4++) {
            this.components.get(i4).freeIfNecessary();
        }
    }

    public List<ByteBuf> decompose(int i4, int i5) {
        checkIndex(i4, i5);
        if (i5 == 0) {
            return Collections.emptyList();
        }
        int componentIndex = toComponentIndex(i4);
        ArrayList arrayList = new ArrayList(this.components.size());
        Component component = this.components.get(componentIndex);
        ByteBuf duplicate = component.buf.duplicate();
        duplicate.readerIndex(i4 - component.offset);
        while (true) {
            int readableBytes = duplicate.readableBytes();
            if (i5 <= readableBytes) {
                duplicate.writerIndex(duplicate.readerIndex() + i5);
                arrayList.add(duplicate);
                break;
            }
            arrayList.add(duplicate);
            i5 -= readableBytes;
            componentIndex++;
            duplicate = this.components.get(componentIndex).buf.duplicate();
            if (i5 <= 0) {
                break;
            }
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            arrayList.set(i6, ((ByteBuf) arrayList.get(i6)).slice());
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
        for (int i4 = 0; i4 < componentIndex; i4++) {
            this.components.get(i4).freeIfNecessary();
        }
        this.components.subList(0, componentIndex).clear();
        int i5 = this.components.get(0).offset;
        updateComponentOffsets(0);
        setIndex(readerIndex - i5, writerIndex - i5);
        adjustMarkers(i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i4) {
        return _getByte(i4);
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

    public ByteBuf internalComponent(int i4) {
        checkComponentIndex(i4);
        return this.components.get(i4).buf;
    }

    public ByteBuf internalComponentAtOffset(int i4) {
        return findComponent(i4).buf;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i4, int i5) {
        int size = this.components.size();
        if (size != 0) {
            if (size == 1) {
                return this.components.get(0).buf.internalNioBuffer(i4, i5);
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
        for (int i4 = 0; i4 < size; i4++) {
            if (!this.components.get(i4).buf.isDirect()) {
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
    public ByteBuffer nioBuffer(int i4, int i5) {
        checkIndex(i4, i5);
        int size = this.components.size();
        if (size != 0) {
            if (size == 1 && this.components.get(0).buf.nioBufferCount() == 1) {
                return this.components.get(0).buf.nioBuffer(i4, i5);
            }
            ByteBuffer order = ByteBuffer.allocate(i5).order(order());
            for (ByteBuffer byteBuffer : nioBuffers(i4, i5)) {
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
                int i4 = 0;
                for (int i5 = 0; i5 < size2; i5++) {
                    i4 += this.components.get(i5).buf.nioBufferCount();
                }
                return i4;
            }
            return this.components.get(0).buf.nioBufferCount();
        }
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i4, int i5) {
        checkIndex(i4, i5);
        if (i5 == 0) {
            return new ByteBuffer[]{EMPTY_NIO_BUFFER};
        }
        ArrayList arrayList = new ArrayList(this.components.size());
        int componentIndex = toComponentIndex(i4);
        while (i5 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf = component.buf;
            int i6 = i4 - component.offset;
            int min = Math.min(i5, byteBuf.capacity() - i6);
            int nioBufferCount = byteBuf.nioBufferCount();
            if (nioBufferCount == 0) {
                throw new UnsupportedOperationException();
            }
            if (nioBufferCount != 1) {
                Collections.addAll(arrayList, byteBuf.nioBuffers(i6, min));
            } else {
                arrayList.add(byteBuf.nioBuffer(i6, min));
            }
            i4 += min;
            i5 -= min;
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

    public CompositeByteBuf removeComponent(int i4) {
        checkComponentIndex(i4);
        Component remove = this.components.remove(i4);
        remove.freeIfNecessary();
        if (remove.length > 0) {
            updateComponentOffsets(i4);
        }
        return this;
    }

    public CompositeByteBuf removeComponents(int i4, int i5) {
        checkComponentIndex(i4, i5);
        if (i5 == 0) {
            return this;
        }
        List<Component> subList = this.components.subList(i4, i5 + i4);
        boolean z3 = false;
        for (Component component : subList) {
            if (component.length > 0) {
                z3 = true;
            }
            component.freeIfNecessary();
        }
        subList.clear();
        if (z3) {
            updateComponentOffsets(i4);
        }
        return this;
    }

    public int toByteIndex(int i4) {
        checkComponentIndex(i4);
        return this.components.get(i4).offset;
    }

    public int toComponentIndex(int i4) {
        checkIndex(i4);
        int size = this.components.size();
        int i5 = 0;
        while (i5 <= size) {
            int i6 = (i5 + size) >>> 1;
            Component component = this.components.get(i6);
            if (i4 >= component.endOffset) {
                i5 = i6 + 1;
            } else if (i4 >= component.offset) {
                return i6;
            } else {
                size = i6 - 1;
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

    public CompositeByteBuf addComponent(int i4, ByteBuf byteBuf) {
        return addComponent(false, i4, byteBuf);
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
        for (int i4 = 0; i4 < componentIndex; i4++) {
            this.components.get(i4).freeIfNecessary();
        }
        this.components.subList(0, componentIndex).clear();
        Component component2 = this.components.get(0);
        int i5 = readerIndex - component2.offset;
        int i6 = component2.length;
        if (i5 == i6) {
            this.components.remove(0);
        } else {
            this.components.set(0, new Component(component2.buf.slice(i5, i6 - i5)));
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
    public CompositeByteBuf ensureWritable(int i4) {
        return (CompositeByteBuf) super.ensureWritable(i4);
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
    public CompositeByteBuf readerIndex(int i4) {
        return (CompositeByteBuf) super.readerIndex(i4);
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
    public CompositeByteBuf setBoolean(int i4, boolean z3) {
        return (CompositeByteBuf) super.setBoolean(i4, z3);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setByte(int i4, int i5) {
        Component findComponent = findComponent(i4);
        findComponent.buf.setByte(i4 - findComponent.offset, i5);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setChar(int i4, int i5) {
        return (CompositeByteBuf) super.setChar(i4, i5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setDouble(int i4, double d4) {
        return (CompositeByteBuf) super.setDouble(i4, d4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setFloat(int i4, float f4) {
        return (CompositeByteBuf) super.setFloat(i4, f4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setIndex(int i4, int i5) {
        return (CompositeByteBuf) super.setIndex(i4, i5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setInt(int i4, int i5) {
        return (CompositeByteBuf) super.setInt(i4, i5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setLong(int i4, long j4) {
        return (CompositeByteBuf) super.setLong(i4, j4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setMedium(int i4, int i5) {
        return (CompositeByteBuf) super.setMedium(i4, i5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setShort(int i4, int i5) {
        return (CompositeByteBuf) super.setShort(i4, i5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setZero(int i4, int i5) {
        return (CompositeByteBuf) super.setZero(i4, i5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf skipBytes(int i4) {
        return (CompositeByteBuf) super.skipBytes(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBoolean(boolean z3) {
        return (CompositeByteBuf) super.writeBoolean(z3);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeByte(int i4) {
        return (CompositeByteBuf) super.writeByte(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeChar(int i4) {
        return (CompositeByteBuf) super.writeChar(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeDouble(double d4) {
        return (CompositeByteBuf) super.writeDouble(d4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeFloat(float f4) {
        return (CompositeByteBuf) super.writeFloat(f4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeInt(int i4) {
        return (CompositeByteBuf) super.writeInt(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeLong(long j4) {
        return (CompositeByteBuf) super.writeLong(j4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeMedium(int i4) {
        return (CompositeByteBuf) super.writeMedium(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeShort(int i4) {
        return (CompositeByteBuf) super.writeShort(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeZero(int i4) {
        return (CompositeByteBuf) super.writeZero(i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writerIndex(int i4) {
        return (CompositeByteBuf) super.writerIndex(i4);
    }

    public CompositeByteBuf addComponent(boolean z3, ByteBuf byteBuf) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        addComponent0(z3, this.components.size(), byteBuf);
        consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf addComponents(boolean z3, ByteBuf... byteBufArr) {
        addComponents0(z3, this.components.size(), byteBufArr, 0, byteBufArr.length);
        consolidateIfNeeded();
        return this;
    }

    private void checkComponentIndex(int i4, int i5) {
        ensureAccessible();
        if (i4 < 0 || i4 + i5 > this.components.size()) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d, numComponents: %d (expected: cIndex >= 0 && cIndex + numComponents <= totalNumComponents(%d))", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(this.components.size())));
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf capacity(int i4) {
        ensureAccessible();
        if (i4 >= 0 && i4 <= maxCapacity()) {
            int capacity = capacity();
            if (i4 > capacity) {
                int i5 = i4 - capacity;
                if (this.components.size() < this.maxNumComponents) {
                    ByteBuf allocBuffer = allocBuffer(i5);
                    allocBuffer.setIndex(0, i5);
                    addComponent0(false, this.components.size(), allocBuffer);
                } else {
                    ByteBuf allocBuffer2 = allocBuffer(i5);
                    allocBuffer2.setIndex(0, i5);
                    addComponent0(false, this.components.size(), allocBuffer2);
                    consolidateIfNeeded();
                }
            } else if (i4 < capacity) {
                int i6 = capacity - i4;
                List<Component> list = this.components;
                ListIterator<Component> listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    Component previous = listIterator.previous();
                    int i7 = previous.length;
                    if (i6 >= i7) {
                        i6 -= i7;
                        listIterator.remove();
                    } else {
                        Component component = new Component(previous.buf.slice(0, i7 - i6));
                        int i8 = previous.offset;
                        component.offset = i8;
                        component.endOffset = i8 + component.length;
                        listIterator.set(component);
                        break;
                    }
                }
                if (readerIndex() > i4) {
                    setIndex(i4, i4);
                } else if (writerIndex() > i4) {
                    writerIndex(i4);
                }
            }
            return this;
        }
        throw new IllegalArgumentException("newCapacity: " + i4);
    }

    public CompositeByteBuf addComponents(boolean z3, Iterable<ByteBuf> iterable) {
        addComponents0(z3, this.components.size(), iterable);
        consolidateIfNeeded();
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain(int i4) {
        return (CompositeByteBuf) super.retain(i4);
    }

    public CompositeByteBuf addComponent(boolean z3, int i4, ByteBuf byteBuf) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        addComponent0(z3, i4, byteBuf);
        consolidateIfNeeded();
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain() {
        return (CompositeByteBuf) super.retain();
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z3, int i4, ByteBuf... byteBufArr) {
        this(byteBufAllocator, z3, i4, byteBufArr, 0, byteBufArr.length);
    }

    public CompositeByteBuf addComponents(int i4, ByteBuf... byteBufArr) {
        addComponents0(false, i4, byteBufArr, 0, byteBufArr.length);
        consolidateIfNeeded();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i4, byte[] bArr, int i5, int i6) {
        checkSrcIndex(i4, i6, i5, bArr.length);
        if (i6 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i4);
        while (i6 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf = component.buf;
            int i7 = i4 - component.offset;
            int min = Math.min(i6, byteBuf.capacity() - i7);
            byteBuf.setBytes(i7, bArr, i5, min);
            i4 += min;
            i5 += min;
            i6 -= min;
            componentIndex++;
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf) {
        return (CompositeByteBuf) super.writeBytes(byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z3, int i4, ByteBuf[] byteBufArr, int i5, int i6) {
        super(Integer.MAX_VALUE);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (i4 >= 2) {
            this.alloc = byteBufAllocator;
            this.direct = z3;
            this.maxNumComponents = i4;
            this.components = newList(i4);
            addComponents0(false, 0, byteBufArr, i5, i6);
            consolidateIfNeeded();
            setIndex(0, capacity());
            return;
        }
        throw new IllegalArgumentException("maxNumComponents: " + i4 + " (expected: >= 2)");
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i4, byte[] bArr, int i5, int i6) {
        checkDstIndex(i4, i6, i5, bArr.length);
        if (i6 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i4);
        while (i6 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf = component.buf;
            int i7 = i4 - component.offset;
            int min = Math.min(i6, byteBuf.capacity() - i7);
            byteBuf.getBytes(i7, bArr, i5, min);
            i4 += min;
            i5 += min;
            i6 -= min;
            componentIndex++;
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf) {
        return (CompositeByteBuf) super.readBytes(byteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i4) {
        return (CompositeByteBuf) super.writeBytes(byteBuf, i4);
    }

    public CompositeByteBuf addComponents(int i4, Iterable<ByteBuf> iterable) {
        addComponents0(false, i4, iterable);
        consolidateIfNeeded();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i4) {
        return (CompositeByteBuf) super.readBytes(byteBuf, i4);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i4, int i5) {
        return (CompositeByteBuf) super.writeBytes(byteBuf, i4, i5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i4, int i5) {
        return (CompositeByteBuf) super.readBytes(byteBuf, i4, i5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr) {
        return (CompositeByteBuf) super.writeBytes(bArr);
    }

    private int addComponents0(boolean z3, int i4, Iterable<ByteBuf> iterable) {
        if (iterable instanceof ByteBuf) {
            return addComponent0(z3, i4, (ByteBuf) iterable);
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
        return addComponents0(z3, i4, (ByteBuf[]) collection.toArray(new ByteBuf[collection.size()]), 0, collection.size());
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr) {
        return (CompositeByteBuf) super.readBytes(bArr);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr, int i4, int i5) {
        return (CompositeByteBuf) super.writeBytes(bArr, i4, i5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr, int i4, int i5) {
        return (CompositeByteBuf) super.readBytes(bArr, i4, i5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuffer byteBuffer) {
        return (CompositeByteBuf) super.writeBytes(byteBuffer);
    }

    public CompositeByteBuf consolidate(int i4, int i5) {
        checkComponentIndex(i4, i5);
        if (i5 <= 1) {
            return this;
        }
        int i6 = i5 + i4;
        ByteBuf allocBuffer = allocBuffer(this.components.get(i6 - 1).endOffset - this.components.get(i4).offset);
        for (int i7 = i4; i7 < i6; i7++) {
            Component component = this.components.get(i7);
            allocBuffer.writeBytes(component.buf);
            component.freeIfNecessary();
        }
        this.components.subList(i4 + 1, i6).clear();
        this.components.set(i4, new Component(allocBuffer));
        updateComponentOffsets(i4);
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
    public CompositeByteBuf readBytes(OutputStream outputStream, int i4) throws IOException {
        return (CompositeByteBuf) super.readBytes(outputStream, i4);
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i4, ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int remaining = byteBuffer.remaining();
        checkIndex(i4, remaining);
        if (remaining == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i4);
        while (remaining > 0) {
            try {
                Component component = this.components.get(componentIndex);
                ByteBuf byteBuf = component.buf;
                int i5 = i4 - component.offset;
                int min = Math.min(remaining, byteBuf.capacity() - i5);
                byteBuffer.limit(byteBuffer.position() + min);
                byteBuf.setBytes(i5, byteBuffer);
                i4 += min;
                remaining -= min;
                componentIndex++;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i4, ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int remaining = byteBuffer.remaining();
        checkIndex(i4, remaining);
        if (remaining == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i4);
        while (remaining > 0) {
            try {
                Component component = this.components.get(componentIndex);
                ByteBuf byteBuf = component.buf;
                int i5 = i4 - component.offset;
                int min = Math.min(remaining, byteBuf.capacity() - i5);
                byteBuffer.limit(byteBuffer.position() + min);
                byteBuf.getBytes(i5, byteBuffer);
                i4 += min;
                remaining -= min;
                componentIndex++;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        return this;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z3, int i4, Iterable<ByteBuf> iterable) {
        super(Integer.MAX_VALUE);
        if (byteBufAllocator == null) {
            throw new NullPointerException("alloc");
        }
        if (i4 >= 2) {
            this.alloc = byteBufAllocator;
            this.direct = z3;
            this.maxNumComponents = i4;
            this.components = newList(i4);
            addComponents0(false, 0, iterable);
            consolidateIfNeeded();
            setIndex(0, capacity());
            return;
        }
        throw new IllegalArgumentException("maxNumComponents: " + i4 + " (expected: >= 2)");
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        checkSrcIndex(i4, i6, i5, byteBuf.capacity());
        if (i6 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i4);
        while (i6 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf2 = component.buf;
            int i7 = i4 - component.offset;
            int min = Math.min(i6, byteBuf2.capacity() - i7);
            byteBuf2.setBytes(i7, byteBuf, i5, min);
            i4 += min;
            i5 += min;
            i6 -= min;
            componentIndex++;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i4, ByteBuf byteBuf, int i5, int i6) {
        checkDstIndex(i4, i6, i5, byteBuf.capacity());
        if (i6 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i4);
        while (i6 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf2 = component.buf;
            int i7 = i4 - component.offset;
            int min = Math.min(i6, byteBuf2.capacity() - i7);
            byteBuf2.getBytes(i7, byteBuf, i5, min);
            i4 += min;
            i5 += min;
            i6 -= min;
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
    public int getBytes(int i4, GatheringByteChannel gatheringByteChannel, int i5) throws IOException {
        if (nioBufferCount() == 1) {
            return gatheringByteChannel.write(internalNioBuffer(i4, i5));
        }
        long write = gatheringByteChannel.write(nioBuffers(i4, i5));
        if (write > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) write;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i4, FileChannel fileChannel, long j4, int i5) throws IOException {
        if (nioBufferCount() == 1) {
            return fileChannel.write(internalNioBuffer(i4, i5), j4);
        }
        long j5 = 0;
        for (ByteBuffer byteBuffer : nioBuffers(i4, i5)) {
            j5 += fileChannel.write(byteBuffer, j4 + j5);
        }
        if (j5 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j5;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i4, OutputStream outputStream, int i5) throws IOException {
        checkIndex(i4, i5);
        if (i5 == 0) {
            return this;
        }
        int componentIndex = toComponentIndex(i4);
        while (i5 > 0) {
            Component component = this.components.get(componentIndex);
            ByteBuf byteBuf = component.buf;
            int i6 = i4 - component.offset;
            int min = Math.min(i5, byteBuf.capacity() - i6);
            byteBuf.getBytes(i6, outputStream, min);
            i4 += min;
            i5 -= min;
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
    public CompositeByteBuf getBytes(int i4, ByteBuf byteBuf) {
        return (CompositeByteBuf) super.getBytes(i4, byteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i4, ByteBuf byteBuf, int i5) {
        return (CompositeByteBuf) super.getBytes(i4, byteBuf, i5);
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
    public CompositeByteBuf getBytes(int i4, byte[] bArr) {
        return (CompositeByteBuf) super.getBytes(i4, bArr);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i4, ByteBuf byteBuf) {
        return (CompositeByteBuf) super.setBytes(i4, byteBuf);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i4, ByteBuf byteBuf, int i5) {
        return (CompositeByteBuf) super.setBytes(i4, byteBuf, i5);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i4, byte[] bArr) {
        return (CompositeByteBuf) super.setBytes(i4, bArr);
    }
}
