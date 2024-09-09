package androidx.room;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.room.InvalidationTracker;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class RoomTrackingLiveData<T> extends LiveData<T> {
    final Callable<T> mComputeFunction;
    private final InvalidationLiveDataContainer mContainer;
    final RoomDatabase mDatabase;
    final boolean mInTransaction;
    final InvalidationTracker.Observer mObserver;
    final AtomicBoolean mInvalid = new AtomicBoolean(true);
    final AtomicBoolean mComputing = new AtomicBoolean(false);
    final AtomicBoolean mRegisteredObserver = new AtomicBoolean(false);
    final Runnable mRefreshRunnable = new Runnable() { // from class: androidx.room.RoomTrackingLiveData.1
        @Override // java.lang.Runnable
        @WorkerThread
        public void run() {
            boolean z3;
            if (RoomTrackingLiveData.this.mRegisteredObserver.compareAndSet(false, true)) {
                RoomTrackingLiveData.this.mDatabase.getInvalidationTracker().addWeakObserver(RoomTrackingLiveData.this.mObserver);
            }
            do {
                if (RoomTrackingLiveData.this.mComputing.compareAndSet(false, true)) {
                    T t3 = null;
                    z3 = false;
                    while (RoomTrackingLiveData.this.mInvalid.compareAndSet(true, false)) {
                        try {
                            try {
                                t3 = RoomTrackingLiveData.this.mComputeFunction.call();
                                z3 = true;
                            } catch (Exception e4) {
                                throw new RuntimeException("Exception while computing database live data.", e4);
                            }
                        } finally {
                            RoomTrackingLiveData.this.mComputing.set(false);
                        }
                    }
                    if (z3) {
                        RoomTrackingLiveData.this.postValue(t3);
                    }
                } else {
                    z3 = false;
                }
                if (!z3) {
                    return;
                }
            } while (RoomTrackingLiveData.this.mInvalid.get());
        }
    };
    final Runnable mInvalidationRunnable = new Runnable() { // from class: androidx.room.RoomTrackingLiveData.2
        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            boolean hasActiveObservers = RoomTrackingLiveData.this.hasActiveObservers();
            if (RoomTrackingLiveData.this.mInvalid.compareAndSet(false, true) && hasActiveObservers) {
                RoomTrackingLiveData.this.getQueryExecutor().execute(RoomTrackingLiveData.this.mRefreshRunnable);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"RestrictedApi"})
    public RoomTrackingLiveData(RoomDatabase database, InvalidationLiveDataContainer container, boolean inTransaction, Callable<T> computeFunction, String[] tableNames) {
        this.mDatabase = database;
        this.mInTransaction = inTransaction;
        this.mComputeFunction = computeFunction;
        this.mContainer = container;
        this.mObserver = new InvalidationTracker.Observer(tableNames) { // from class: androidx.room.RoomTrackingLiveData.3
            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@NonNull Set<String> tables) {
                ArchTaskExecutor.getInstance().executeOnMainThread(RoomTrackingLiveData.this.mInvalidationRunnable);
            }
        };
    }

    Executor getQueryExecutor() {
        if (this.mInTransaction) {
            return this.mDatabase.getTransactionExecutor();
        }
        return this.mDatabase.getQueryExecutor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        this.mContainer.onActive(this);
        getQueryExecutor().execute(this.mRefreshRunnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.mContainer.onInactive(this);
    }
}
