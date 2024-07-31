package io.netty.handler.codec.http2.internal.hpack;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class DynamicTable {
    private int capacity = -1;
    int head;
    HeaderField[] headerFields;
    private int size;
    int tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DynamicTable(int i) {
        setCapacity(i);
    }

    public void add(HeaderField headerField) {
        int i;
        int size = headerField.size();
        if (size > this.capacity) {
            clear();
            return;
        }
        while (true) {
            i = this.size;
            if (i + size <= this.capacity) {
                break;
            }
            remove();
        }
        HeaderField[] headerFieldArr = this.headerFields;
        int i2 = this.head;
        this.head = i2 + 1;
        headerFieldArr[i2] = headerField;
        this.size = i + headerField.size();
        if (this.head == this.headerFields.length) {
            this.head = 0;
        }
    }

    public int capacity() {
        return this.capacity;
    }

    public void clear() {
        while (true) {
            int i = this.tail;
            if (i != this.head) {
                HeaderField[] headerFieldArr = this.headerFields;
                int i2 = i + 1;
                this.tail = i2;
                headerFieldArr[i] = null;
                if (i2 == headerFieldArr.length) {
                    this.tail = 0;
                }
            } else {
                this.head = 0;
                this.tail = 0;
                this.size = 0;
                return;
            }
        }
    }

    public HeaderField getEntry(int i) {
        if (i > 0 && i <= length()) {
            int i2 = this.head - i;
            if (i2 < 0) {
                HeaderField[] headerFieldArr = this.headerFields;
                return headerFieldArr[i2 + headerFieldArr.length];
            }
            return this.headerFields[i2];
        }
        throw new IndexOutOfBoundsException();
    }

    public int length() {
        int i = this.head;
        int i2 = this.tail;
        return i < i2 ? (this.headerFields.length - i2) + i : i - i2;
    }

    public HeaderField remove() {
        HeaderField headerField = this.headerFields[this.tail];
        if (headerField == null) {
            return null;
        }
        this.size -= headerField.size();
        HeaderField[] headerFieldArr = this.headerFields;
        int i = this.tail;
        int i2 = i + 1;
        this.tail = i2;
        headerFieldArr[i] = null;
        if (i2 == headerFieldArr.length) {
            this.tail = 0;
        }
        return headerField;
    }

    public void setCapacity(int i) {
        if (i >= 0) {
            if (this.capacity == i) {
                return;
            }
            this.capacity = i;
            if (i == 0) {
                clear();
            } else {
                while (this.size > i) {
                    remove();
                }
            }
            int i2 = i / 32;
            if (i % 32 != 0) {
                i2++;
            }
            HeaderField[] headerFieldArr = this.headerFields;
            if (headerFieldArr == null || headerFieldArr.length != i2) {
                HeaderField[] headerFieldArr2 = new HeaderField[i2];
                int length = length();
                int i3 = this.tail;
                for (int i4 = 0; i4 < length; i4++) {
                    HeaderField[] headerFieldArr3 = this.headerFields;
                    int i5 = i3 + 1;
                    headerFieldArr2[i4] = headerFieldArr3[i3];
                    i3 = i5 == headerFieldArr3.length ? 0 : i5;
                }
                this.tail = 0;
                this.head = 0 + length;
                this.headerFields = headerFieldArr2;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i);
    }

    public int size() {
        return this.size;
    }
}
