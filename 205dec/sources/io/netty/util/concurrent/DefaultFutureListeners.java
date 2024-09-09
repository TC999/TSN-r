package io.netty.util.concurrent;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class DefaultFutureListeners {
    private GenericFutureListener<? extends Future<?>>[] listeners;
    private int progressiveSize;
    private int size = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultFutureListeners(GenericFutureListener<? extends Future<?>> genericFutureListener, GenericFutureListener<? extends Future<?>> genericFutureListener2) {
        this.listeners = r1;
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = {genericFutureListener, genericFutureListener2};
        if (genericFutureListener instanceof GenericProgressiveFutureListener) {
            this.progressiveSize++;
        }
        if (genericFutureListener2 instanceof GenericProgressiveFutureListener) {
            this.progressiveSize++;
        }
    }

    public void add(GenericFutureListener<? extends Future<?>> genericFutureListener) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = this.listeners;
        int i4 = this.size;
        if (i4 == genericFutureListenerArr.length) {
            genericFutureListenerArr = (GenericFutureListener[]) Arrays.copyOf(genericFutureListenerArr, i4 << 1);
            this.listeners = genericFutureListenerArr;
        }
        genericFutureListenerArr[i4] = genericFutureListener;
        this.size = i4 + 1;
        if (genericFutureListener instanceof GenericProgressiveFutureListener) {
            this.progressiveSize++;
        }
    }

    public GenericFutureListener<? extends Future<?>>[] listeners() {
        return this.listeners;
    }

    public int progressiveSize() {
        return this.progressiveSize;
    }

    public void remove(GenericFutureListener<? extends Future<?>> genericFutureListener) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = this.listeners;
        int i4 = this.size;
        for (int i5 = 0; i5 < i4; i5++) {
            if (genericFutureListenerArr[i5] == genericFutureListener) {
                int i6 = (i4 - i5) - 1;
                if (i6 > 0) {
                    System.arraycopy(genericFutureListenerArr, i5 + 1, genericFutureListenerArr, i5, i6);
                }
                int i7 = i4 - 1;
                genericFutureListenerArr[i7] = null;
                this.size = i7;
                if (genericFutureListener instanceof GenericProgressiveFutureListener) {
                    this.progressiveSize--;
                    return;
                }
                return;
            }
        }
    }

    public int size() {
        return this.size;
    }
}
