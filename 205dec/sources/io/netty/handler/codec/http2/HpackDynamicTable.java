package io.netty.handler.codec.http2;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class HpackDynamicTable {
    private long capacity = -1;
    int head;
    HpackHeaderField[] hpackHeaderFields;
    private long size;
    int tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HpackDynamicTable(long j4) {
        setCapacity(j4);
    }

    public void add(HpackHeaderField hpackHeaderField) {
        long j4;
        long size = hpackHeaderField.size();
        if (size > this.capacity) {
            clear();
            return;
        }
        while (true) {
            long j5 = this.capacity;
            j4 = this.size;
            if (j5 - j4 >= size) {
                break;
            }
            remove();
        }
        HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
        int i4 = this.head;
        this.head = i4 + 1;
        hpackHeaderFieldArr[i4] = hpackHeaderField;
        this.size = j4 + hpackHeaderField.size();
        if (this.head == this.hpackHeaderFields.length) {
            this.head = 0;
        }
    }

    public long capacity() {
        return this.capacity;
    }

    public void clear() {
        while (true) {
            int i4 = this.tail;
            if (i4 != this.head) {
                HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
                int i5 = i4 + 1;
                this.tail = i5;
                hpackHeaderFieldArr[i4] = null;
                if (i5 == hpackHeaderFieldArr.length) {
                    this.tail = 0;
                }
            } else {
                this.head = 0;
                this.tail = 0;
                this.size = 0L;
                return;
            }
        }
    }

    public HpackHeaderField getEntry(int i4) {
        if (i4 > 0 && i4 <= length()) {
            int i5 = this.head - i4;
            if (i5 < 0) {
                HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
                return hpackHeaderFieldArr[i5 + hpackHeaderFieldArr.length];
            }
            return this.hpackHeaderFields[i5];
        }
        throw new IndexOutOfBoundsException();
    }

    public int length() {
        int i4 = this.head;
        int i5 = this.tail;
        return i4 < i5 ? (this.hpackHeaderFields.length - i5) + i4 : i4 - i5;
    }

    public HpackHeaderField remove() {
        HpackHeaderField hpackHeaderField = this.hpackHeaderFields[this.tail];
        if (hpackHeaderField == null) {
            return null;
        }
        this.size -= hpackHeaderField.size();
        HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
        int i4 = this.tail;
        int i5 = i4 + 1;
        this.tail = i5;
        hpackHeaderFieldArr[i4] = null;
        if (i5 == hpackHeaderFieldArr.length) {
            this.tail = 0;
        }
        return hpackHeaderField;
    }

    public void setCapacity(long j4) {
        if (j4 >= 0 && j4 <= 4294967295L) {
            if (this.capacity == j4) {
                return;
            }
            this.capacity = j4;
            if (j4 == 0) {
                clear();
            } else {
                while (this.size > j4) {
                    remove();
                }
            }
            int i4 = (int) (j4 / 32);
            if (j4 % 32 != 0) {
                i4++;
            }
            HpackHeaderField[] hpackHeaderFieldArr = this.hpackHeaderFields;
            if (hpackHeaderFieldArr == null || hpackHeaderFieldArr.length != i4) {
                HpackHeaderField[] hpackHeaderFieldArr2 = new HpackHeaderField[i4];
                int length = length();
                int i5 = this.tail;
                for (int i6 = 0; i6 < length; i6++) {
                    HpackHeaderField[] hpackHeaderFieldArr3 = this.hpackHeaderFields;
                    int i7 = i5 + 1;
                    hpackHeaderFieldArr2[i6] = hpackHeaderFieldArr3[i5];
                    i5 = i7 == hpackHeaderFieldArr3.length ? 0 : i7;
                }
                this.tail = 0;
                this.head = 0 + length;
                this.hpackHeaderFields = hpackHeaderFieldArr2;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("capacity is invalid: " + j4);
    }

    public long size() {
        return this.size;
    }
}
