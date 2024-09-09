package io.reactivex.internal.util;

import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class LinkedArrayList {
    final int capacityHint;
    Object[] head;
    int indexInTail;
    volatile int size;
    Object[] tail;

    public LinkedArrayList(int i4) {
        this.capacityHint = i4;
    }

    public void add(Object obj) {
        if (this.size == 0) {
            Object[] objArr = new Object[this.capacityHint + 1];
            this.head = objArr;
            this.tail = objArr;
            objArr[0] = obj;
            this.indexInTail = 1;
            this.size = 1;
            return;
        }
        int i4 = this.indexInTail;
        int i5 = this.capacityHint;
        if (i4 == i5) {
            Object[] objArr2 = new Object[i5 + 1];
            objArr2[0] = obj;
            this.tail[i5] = objArr2;
            this.tail = objArr2;
            this.indexInTail = 1;
            this.size++;
            return;
        }
        this.tail[i4] = obj;
        this.indexInTail = i4 + 1;
        this.size++;
    }

    public Object[] head() {
        return this.head;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i4 = this.capacityHint;
        int i5 = this.size;
        ArrayList arrayList = new ArrayList(i5 + 1);
        Object[] head = head();
        int i6 = 0;
        while (true) {
            int i7 = 0;
            while (i6 < i5) {
                arrayList.add(head[i7]);
                i6++;
                i7++;
                if (i7 == i4) {
                    break;
                }
            }
            return arrayList.toString();
            head = head[i4];
        }
    }
}
