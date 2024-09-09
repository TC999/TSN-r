package io.reactivex.observers;

import io.reactivex.Notification;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {
    protected boolean checkSubscriptionOnce;
    protected long completions;
    protected int establishedFusionMode;
    protected int initialFusionMode;
    protected Thread lastThread;
    protected CharSequence tag;
    protected boolean timeout;
    protected final List<T> values = new VolatileSizeArrayList();
    protected final List<Throwable> errors = new VolatileSizeArrayList();
    protected final CountDownLatch done = new CountDownLatch(1);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum TestWaitStrategy implements Runnable {
        SPIN { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.1
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
            }
        },
        YIELD { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.2
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                Thread.yield();
            }
        },
        SLEEP_1MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.3
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(1);
            }
        },
        SLEEP_10MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.4
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(10);
            }
        },
        SLEEP_100MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.5
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(100);
            }
        },
        SLEEP_1000MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.6
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(1000);
            }
        };

        static void sleep(int i4) {
            try {
                Thread.sleep(i4);
            } catch (InterruptedException e4) {
                throw new RuntimeException(e4);
            }
        }

        @Override // java.lang.Runnable
        public abstract void run();
    }

    public static String valueAndClass(Object obj) {
        if (obj != null) {
            return obj + " (class: " + obj.getClass().getSimpleName() + ")";
        }
        return "null";
    }

    public final U assertComplete() {
        long j4 = this.completions;
        if (j4 != 0) {
            if (j4 <= 1) {
                return this;
            }
            throw fail("Multiple completions: " + j4);
        }
        throw fail("Not completed");
    }

    public final U assertEmpty() {
        return (U) assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    public final U assertError(Throwable th) {
        return assertError(Functions.equalsWith(th));
    }

    public final U assertErrorMessage(String str) {
        int size = this.errors.size();
        if (size != 0) {
            if (size == 1) {
                String message = this.errors.get(0).getMessage();
                if (ObjectHelper.equals(str, message)) {
                    return this;
                }
                throw fail("Error message differs; Expected: " + str + ", Actual: " + message);
            }
            throw fail("Multiple errors");
        }
        throw fail("No errors");
    }

    public final U assertFailure(Class<? extends Throwable> cls, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertNotComplete();
    }

    public final U assertFailureAndMessage(Class<? extends Throwable> cls, String str, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertErrorMessage(str).assertNotComplete();
    }

    public final U assertNever(T t3) {
        int size = this.values.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (ObjectHelper.equals(this.values.get(i4), t3)) {
                throw fail("Value at position " + i4 + " is equal to " + valueAndClass(t3) + "; Expected them to be different");
            }
        }
        return this;
    }

    public final U assertNoErrors() {
        if (this.errors.size() == 0) {
            return this;
        }
        throw fail("Error(s) present: " + this.errors);
    }

    public final U assertNoTimeout() {
        if (this.timeout) {
            throw fail("Timeout?!");
        }
        return this;
    }

    public final U assertNoValues() {
        return assertValueCount(0);
    }

    public final U assertNotComplete() {
        long j4 = this.completions;
        if (j4 != 1) {
            if (j4 <= 1) {
                return this;
            }
            throw fail("Multiple completions: " + j4);
        }
        throw fail("Completed!");
    }

    public abstract U assertNotSubscribed();

    public final U assertNotTerminated() {
        if (this.done.getCount() != 0) {
            return this;
        }
        throw fail("Subscriber terminated!");
    }

    public final U assertResult(T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertComplete();
    }

    public abstract U assertSubscribed();

    public final U assertTerminated() {
        if (this.done.getCount() == 0) {
            long j4 = this.completions;
            if (j4 <= 1) {
                int size = this.errors.size();
                if (size > 1) {
                    throw fail("Terminated with multiple errors: " + size);
                } else if (j4 == 0 || size == 0) {
                    return this;
                } else {
                    throw fail("Terminated with multiple completions and errors: " + j4);
                }
            }
            throw fail("Terminated with multiple completions: " + j4);
        }
        throw fail("Subscriber still running!");
    }

    public final U assertTimeout() {
        if (this.timeout) {
            return this;
        }
        throw fail("No timeout?!");
    }

    public final U assertValue(T t3) {
        if (this.values.size() == 1) {
            T t4 = this.values.get(0);
            if (ObjectHelper.equals(t3, t4)) {
                return this;
            }
            throw fail("Expected: " + valueAndClass(t3) + ", Actual: " + valueAndClass(t4));
        }
        throw fail("Expected: " + valueAndClass(t3) + ", Actual: " + this.values);
    }

    @Experimental
    public final U assertValueAt(int i4, T t3) {
        int size = this.values.size();
        if (size != 0) {
            if (i4 < size) {
                T t4 = this.values.get(i4);
                if (ObjectHelper.equals(t3, t4)) {
                    return this;
                }
                throw fail("Expected: " + valueAndClass(t3) + ", Actual: " + valueAndClass(t4));
            }
            throw fail("Invalid index: " + i4);
        }
        throw fail("No values");
    }

    public final U assertValueCount(int i4) {
        int size = this.values.size();
        if (size == i4) {
            return this;
        }
        throw fail("Value counts differ; Expected: " + i4 + ", Actual: " + size);
    }

    public final U assertValueSequence(Iterable<? extends T> iterable) {
        boolean hasNext;
        boolean hasNext2;
        Iterator<T> it = this.values.iterator();
        Iterator<? extends T> it2 = iterable.iterator();
        int i4 = 0;
        while (true) {
            hasNext = it2.hasNext();
            hasNext2 = it.hasNext();
            if (!hasNext2 || !hasNext) {
                break;
            }
            T next = it2.next();
            T next2 = it.next();
            if (!ObjectHelper.equals(next, next2)) {
                throw fail("Values at position " + i4 + " differ; Expected: " + valueAndClass(next) + ", Actual: " + valueAndClass(next2));
            }
            i4++;
        }
        if (hasNext2) {
            throw fail("More values received than expected (" + i4 + ")");
        } else if (hasNext) {
            throw fail("Fewer values received than expected (" + i4 + ")");
        } else {
            return this;
        }
    }

    public final U assertValueSet(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            assertNoValues();
            return this;
        }
        for (T t3 : this.values) {
            if (!collection.contains(t3)) {
                throw fail("Value not in the expected collection: " + valueAndClass(t3));
            }
        }
        return this;
    }

    public final U assertValues(T... tArr) {
        int size = this.values.size();
        if (size != tArr.length) {
            throw fail("Value count differs; Expected: " + tArr.length + " " + Arrays.toString(tArr) + ", Actual: " + size + " " + this.values);
        }
        for (int i4 = 0; i4 < size; i4++) {
            T t3 = this.values.get(i4);
            T t4 = tArr[i4];
            if (!ObjectHelper.equals(t4, t3)) {
                throw fail("Values at position " + i4 + " differ; Expected: " + valueAndClass(t4) + ", Actual: " + valueAndClass(t3));
            }
        }
        return this;
    }

    @Experimental
    public final U assertValuesOnly(T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertNotComplete();
    }

    public final U await() throws InterruptedException {
        if (this.done.getCount() == 0) {
            return this;
        }
        this.done.await();
        return this;
    }

    public final U awaitCount(int i4) {
        return awaitCount(i4, TestWaitStrategy.SLEEP_10MS, 5000L);
    }

    public final U awaitDone(long j4, TimeUnit timeUnit) {
        try {
            if (!this.done.await(j4, timeUnit)) {
                this.timeout = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e4) {
            dispose();
            throw ExceptionHelper.wrapOrThrow(e4);
        }
    }

    public final boolean awaitTerminalEvent() {
        try {
            await();
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U clearTimeout() {
        this.timeout = false;
        return this;
    }

    public final long completions() {
        return this.completions;
    }

    public final int errorCount() {
        return this.errors.size();
    }

    public final List<Throwable> errors() {
        return this.errors;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AssertionError fail(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 64);
        sb.append(str);
        sb.append(" (");
        sb.append("latch = ");
        sb.append(this.done.getCount());
        sb.append(", ");
        sb.append("values = ");
        sb.append(this.values.size());
        sb.append(", ");
        sb.append("errors = ");
        sb.append(this.errors.size());
        sb.append(", ");
        sb.append("completions = ");
        sb.append(this.completions);
        if (this.timeout) {
            sb.append(", timeout!");
        }
        if (isDisposed()) {
            sb.append(", disposed!");
        }
        CharSequence charSequence = this.tag;
        if (charSequence != null) {
            sb.append(", tag = ");
            sb.append(charSequence);
        }
        sb.append(')');
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                assertionError.initCause(this.errors.get(0));
            } else {
                assertionError.initCause(new CompositeException(this.errors));
            }
        }
        return assertionError;
    }

    public final List<List<Object>> getEvents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(values());
        arrayList.add(errors());
        ArrayList arrayList2 = new ArrayList();
        for (long j4 = 0; j4 < this.completions; j4++) {
            arrayList2.add(Notification.createOnComplete());
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    public final boolean isTerminated() {
        return this.done.getCount() == 0;
    }

    public final boolean isTimeout() {
        return this.timeout;
    }

    public final Thread lastThread() {
        return this.lastThread;
    }

    public final int valueCount() {
        return this.values.size();
    }

    public final List<T> values() {
        return this.values;
    }

    public final U withTag(CharSequence charSequence) {
        this.tag = charSequence;
        return this;
    }

    public final U assertError(Class<? extends Throwable> cls) {
        return assertError(Functions.isInstanceOf(cls));
    }

    public final U awaitCount(int i4, Runnable runnable) {
        return awaitCount(i4, runnable, 5000L);
    }

    public final U assertError(Predicate<Throwable> predicate) {
        int size = this.errors.size();
        if (size != 0) {
            boolean z3 = false;
            Iterator<Throwable> it = this.errors.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                try {
                    if (predicate.test(it.next())) {
                        z3 = true;
                        break;
                    }
                } catch (Exception e4) {
                    throw ExceptionHelper.wrapOrThrow(e4);
                }
            }
            if (z3) {
                if (size == 1) {
                    return this;
                }
                throw fail("Error present but other errors as well");
            }
            throw fail("Error not present");
        }
        throw fail("No errors");
    }

    public final boolean await(long j4, TimeUnit timeUnit) throws InterruptedException {
        boolean z3 = this.done.getCount() == 0 || this.done.await(j4, timeUnit);
        this.timeout = !z3;
        return z3;
    }

    public final U awaitCount(int i4, Runnable runnable, long j4) {
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (j4 > 0 && System.currentTimeMillis() - currentTimeMillis >= j4) {
                this.timeout = true;
                break;
            } else if (this.done.getCount() == 0 || this.values.size() >= i4) {
                break;
            } else {
                runnable.run();
            }
        }
        return this;
    }

    public final boolean awaitTerminalEvent(long j4, TimeUnit timeUnit) {
        try {
            return await(j4, timeUnit);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U assertFailure(Predicate<Throwable> predicate, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(predicate).assertNotComplete();
    }

    public final U assertNever(Predicate<? super T> predicate) {
        int size = this.values.size();
        for (int i4 = 0; i4 < size; i4++) {
            try {
                if (predicate.test((T) this.values.get(i4))) {
                    throw fail("Value at position " + i4 + " matches predicate " + predicate.toString() + ", which was not expected.");
                }
            } catch (Exception e4) {
                throw ExceptionHelper.wrapOrThrow(e4);
            }
        }
        return this;
    }

    public final U assertValue(Predicate<T> predicate) {
        assertValueAt(0, (Predicate) predicate);
        if (this.values.size() <= 1) {
            return this;
        }
        throw fail("Value present but other values as well");
    }

    public final U assertValueAt(int i4, Predicate<T> predicate) {
        if (this.values.size() != 0) {
            if (i4 < this.values.size()) {
                try {
                    if (predicate.test(this.values.get(i4))) {
                        return this;
                    }
                    throw fail("Value not present");
                } catch (Exception e4) {
                    throw ExceptionHelper.wrapOrThrow(e4);
                }
            }
            throw fail("Invalid index: " + i4);
        }
        throw fail("No values");
    }
}
