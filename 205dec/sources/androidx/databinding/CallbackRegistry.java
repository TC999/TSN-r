package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class CallbackRegistry<C, T, A> implements Cloneable {
    private static final String TAG = "CallbackRegistry";
    private List<C> mCallbacks = new ArrayList();
    private long mFirst64Removed = 0;
    private int mNotificationLevel;
    private final NotifierCallback<C, T, A> mNotifier;
    private long[] mRemainderRemoved;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static abstract class NotifierCallback<C, T, A> {
        public abstract void onNotifyCallback(C callback, T sender, int arg, A arg2);
    }

    public CallbackRegistry(NotifierCallback<C, T, A> notifier) {
        this.mNotifier = notifier;
    }

    private boolean isRemoved(int index) {
        int i4;
        if (index < 64) {
            return ((1 << index) & this.mFirst64Removed) != 0;
        }
        long[] jArr = this.mRemainderRemoved;
        if (jArr != null && (i4 = (index / 64) - 1) < jArr.length) {
            return ((1 << (index % 64)) & jArr[i4]) != 0;
        }
        return false;
    }

    private void notifyFirst64(T sender, int arg, A arg2) {
        notifyCallbacks(sender, arg, arg2, 0, Math.min(64, this.mCallbacks.size()), this.mFirst64Removed);
    }

    private void notifyRecurse(T sender, int arg, A arg2) {
        int size = this.mCallbacks.size();
        long[] jArr = this.mRemainderRemoved;
        int length = jArr == null ? -1 : jArr.length - 1;
        notifyRemainder(sender, arg, arg2, length);
        notifyCallbacks(sender, arg, arg2, (length + 2) * 64, size, 0L);
    }

    private void notifyRemainder(T sender, int arg, A arg2, int remainderIndex) {
        if (remainderIndex < 0) {
            notifyFirst64(sender, arg, arg2);
            return;
        }
        long j4 = this.mRemainderRemoved[remainderIndex];
        int i4 = (remainderIndex + 1) * 64;
        int min = Math.min(this.mCallbacks.size(), i4 + 64);
        notifyRemainder(sender, arg, arg2, remainderIndex - 1);
        notifyCallbacks(sender, arg, arg2, i4, min, j4);
    }

    private void removeRemovedCallbacks(int startIndex, long removed) {
        long j4 = Long.MIN_VALUE;
        for (int i4 = (startIndex + 64) - 1; i4 >= startIndex; i4--) {
            if ((removed & j4) != 0) {
                this.mCallbacks.remove(i4);
            }
            j4 >>>= 1;
        }
    }

    private void setRemovalBit(int index) {
        if (index < 64) {
            this.mFirst64Removed = (1 << index) | this.mFirst64Removed;
            return;
        }
        int i4 = (index / 64) - 1;
        long[] jArr = this.mRemainderRemoved;
        if (jArr == null) {
            this.mRemainderRemoved = new long[this.mCallbacks.size() / 64];
        } else if (jArr.length <= i4) {
            long[] jArr2 = new long[this.mCallbacks.size() / 64];
            long[] jArr3 = this.mRemainderRemoved;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.mRemainderRemoved = jArr2;
        }
        long j4 = 1 << (index % 64);
        long[] jArr4 = this.mRemainderRemoved;
        jArr4[i4] = j4 | jArr4[i4];
    }

    public synchronized void add(C callback) {
        if (callback != null) {
            int lastIndexOf = this.mCallbacks.lastIndexOf(callback);
            if (lastIndexOf < 0 || isRemoved(lastIndexOf)) {
                this.mCallbacks.add(callback);
            }
        } else {
            throw new IllegalArgumentException("callback cannot be null");
        }
    }

    public synchronized void clear() {
        if (this.mNotificationLevel == 0) {
            this.mCallbacks.clear();
        } else if (!this.mCallbacks.isEmpty()) {
            for (int size = this.mCallbacks.size() - 1; size >= 0; size--) {
                setRemovalBit(size);
            }
        }
    }

    public synchronized ArrayList<C> copyCallbacks() {
        ArrayList<C> arrayList;
        arrayList = new ArrayList<>(this.mCallbacks.size());
        int size = this.mCallbacks.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (!isRemoved(i4)) {
                arrayList.add(this.mCallbacks.get(i4));
            }
        }
        return arrayList;
    }

    public synchronized boolean isEmpty() {
        if (this.mCallbacks.isEmpty()) {
            return true;
        }
        if (this.mNotificationLevel == 0) {
            return false;
        }
        int size = this.mCallbacks.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (!isRemoved(i4)) {
                return false;
            }
        }
        return true;
    }

    public synchronized void notifyCallbacks(T sender, int arg, A arg2) {
        this.mNotificationLevel++;
        notifyRecurse(sender, arg, arg2);
        int i4 = this.mNotificationLevel - 1;
        this.mNotificationLevel = i4;
        if (i4 == 0) {
            long[] jArr = this.mRemainderRemoved;
            if (jArr != null) {
                for (int length = jArr.length - 1; length >= 0; length--) {
                    long j4 = this.mRemainderRemoved[length];
                    if (j4 != 0) {
                        removeRemovedCallbacks((length + 1) * 64, j4);
                        this.mRemainderRemoved[length] = 0;
                    }
                }
            }
            long j5 = this.mFirst64Removed;
            if (j5 != 0) {
                removeRemovedCallbacks(0, j5);
                this.mFirst64Removed = 0L;
            }
        }
    }

    public synchronized void remove(C callback) {
        if (this.mNotificationLevel == 0) {
            this.mCallbacks.remove(callback);
        } else {
            int lastIndexOf = this.mCallbacks.lastIndexOf(callback);
            if (lastIndexOf >= 0) {
                setRemovalBit(lastIndexOf);
            }
        }
    }

    /* renamed from: clone */
    public synchronized CallbackRegistry<C, T, A> m5clone() {
        CallbackRegistry<C, T, A> callbackRegistry;
        CloneNotSupportedException e4;
        try {
            callbackRegistry = (CallbackRegistry) super.clone();
        } catch (CloneNotSupportedException e5) {
            callbackRegistry = null;
            e4 = e5;
        }
        try {
            callbackRegistry.mFirst64Removed = 0L;
            callbackRegistry.mRemainderRemoved = null;
            callbackRegistry.mNotificationLevel = 0;
            callbackRegistry.mCallbacks = new ArrayList();
            int size = this.mCallbacks.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!isRemoved(i4)) {
                    callbackRegistry.mCallbacks.add(this.mCallbacks.get(i4));
                }
            }
        } catch (CloneNotSupportedException e6) {
            e4 = e6;
            e4.printStackTrace();
            return callbackRegistry;
        }
        return callbackRegistry;
    }

    public synchronized void copyCallbacks(List<C> callbacks) {
        callbacks.clear();
        int size = this.mCallbacks.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (!isRemoved(i4)) {
                callbacks.add(this.mCallbacks.get(i4));
            }
        }
    }

    private void notifyCallbacks(T sender, int arg, A arg2, final int startIndex, final int endIndex, final long bits) {
        long j4 = 1;
        while (startIndex < endIndex) {
            if ((bits & j4) == 0) {
                this.mNotifier.onNotifyCallback(this.mCallbacks.get(startIndex), sender, arg, arg2);
            }
            j4 <<= 1;
            startIndex++;
        }
    }
}
