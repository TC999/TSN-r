package io.netty.handler.codec.http2.internal.hpack;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class DynamicTable {
    private int capacity = -1;
    int head;
    HeaderField[] headerFields;
    private int size;
    int tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DynamicTable(int i4) {
        setCapacity(i4);
    }

    public void add(HeaderField headerField) {
        int i4;
        int size = headerField.size();
        if (size > this.capacity) {
            clear();
            return;
        }
        while (true) {
            i4 = this.size;
            if (i4 + size <= this.capacity) {
                break;
            }
            remove();
        }
        HeaderField[] headerFieldArr = this.headerFields;
        int i5 = this.head;
        this.head = i5 + 1;
        headerFieldArr[i5] = headerField;
        this.size = i4 + headerField.size();
        if (this.head == this.headerFields.length) {
            this.head = 0;
        }
    }

    public int capacity() {
        return this.capacity;
    }

    public void clear() {
        while (true) {
            int i4 = this.tail;
            if (i4 != this.head) {
                HeaderField[] headerFieldArr = this.headerFields;
                int i5 = i4 + 1;
                this.tail = i5;
                headerFieldArr[i4] = null;
                if (i5 == headerFieldArr.length) {
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

    public HeaderField getEntry(int i4) {
        if (i4 > 0 && i4 <= length()) {
            int i5 = this.head - i4;
            if (i5 < 0) {
                HeaderField[] headerFieldArr = this.headerFields;
                return headerFieldArr[i5 + headerFieldArr.length];
            }
            return this.headerFields[i5];
        }
        throw new IndexOutOfBoundsException();
    }

    public int length() {
        int i4 = this.head;
        int i5 = this.tail;
        return i4 < i5 ? (this.headerFields.length - i5) + i4 : i4 - i5;
    }

    public HeaderField remove() {
        HeaderField headerField = this.headerFields[this.tail];
        if (headerField == null) {
            return null;
        }
        this.size -= headerField.size();
        HeaderField[] headerFieldArr = this.headerFields;
        int i4 = this.tail;
        int i5 = i4 + 1;
        this.tail = i5;
        headerFieldArr[i4] = null;
        if (i5 == headerFieldArr.length) {
            this.tail = 0;
        }
        return headerField;
    }

    public void setCapacity(int i4) {
        if (i4 >= 0) {
            if (this.capacity == i4) {
                return;
            }
            this.capacity = i4;
            if (i4 == 0) {
                clear();
            } else {
                while (this.size > i4) {
                    remove();
                }
            }
            int i5 = i4 / 32;
            if (i4 % 32 != 0) {
                i5++;
            }
            HeaderField[] headerFieldArr = this.headerFields;
            if (headerFieldArr == null || headerFieldArr.length != i5) {
                HeaderField[] headerFieldArr2 = new HeaderField[i5];
                int length = length();
                int i6 = this.tail;
                for (int i7 = 0; i7 < length; i7++) {
                    HeaderField[] headerFieldArr3 = this.headerFields;
                    int i8 = i6 + 1;
                    headerFieldArr2[i7] = headerFieldArr3[i6];
                    i6 = i8 == headerFieldArr3.length ? 0 : i8;
                }
                this.tail = 0;
                this.head = 0 + length;
                this.headerFields = headerFieldArr2;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i4);
    }

    public int size() {
        return this.size;
    }
}
