package io.netty.util.internal.chmv8;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.chmv8.Striped64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class LongAdderV8 extends Striped64 implements Serializable, LongCounter {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(sum());
    }

    @Override // io.netty.util.internal.LongCounter
    public void add(long j4) {
        int length;
        Striped64.Cell cell;
        Striped64.Cell[] cellArr = this.cells;
        if (cellArr == null) {
            long j5 = this.base;
            if (casBase(j5, j5 + j4)) {
                return;
            }
        }
        int[] iArr = Striped64.threadHashCode.get();
        boolean z3 = true;
        if (iArr != null && cellArr != null && (length = cellArr.length) >= 1 && (cell = cellArr[(length - 1) & iArr[0]]) != null) {
            long j6 = cell.value;
            z3 = cell.cas(j6, j6 + j4);
            if (z3) {
                return;
            }
        }
        retryUpdate(j4, iArr, z3);
    }

    @Override // io.netty.util.internal.LongCounter
    public void decrement() {
        add(-1L);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) sum();
    }

    @Override // io.netty.util.internal.chmv8.Striped64
    final long fn(long j4, long j5) {
        return j4 + j5;
    }

    @Override // io.netty.util.internal.LongCounter
    public void increment() {
        add(1L);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    public void reset() {
        internalReset(0L);
    }

    public long sum() {
        long j4 = this.base;
        Striped64.Cell[] cellArr = this.cells;
        if (cellArr != null) {
            for (Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j4 += cell.value;
                }
            }
        }
        return j4;
    }

    public long sumThenReset() {
        long j4 = this.base;
        Striped64.Cell[] cellArr = this.cells;
        this.base = 0L;
        if (cellArr != null) {
            for (Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j4 += cell.value;
                    cell.value = 0L;
                }
            }
        }
        return j4;
    }

    public String toString() {
        return Long.toString(sum());
    }

    @Override // io.netty.util.internal.LongCounter
    public long value() {
        return sum();
    }
}
