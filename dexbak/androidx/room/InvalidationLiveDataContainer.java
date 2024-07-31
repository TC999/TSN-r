package androidx.room;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
class InvalidationLiveDataContainer {
    private final RoomDatabase mDatabase;
    @VisibleForTesting
    final Set<LiveData> mLiveDataSet = Collections.newSetFromMap(new IdentityHashMap());

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvalidationLiveDataContainer(RoomDatabase database) {
        this.mDatabase = database;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> LiveData<T> create(String[] tableNames, boolean inTransaction, Callable<T> computeFunction) {
        return new RoomTrackingLiveData(this.mDatabase, this, inTransaction, computeFunction, tableNames);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActive(LiveData liveData) {
        this.mLiveDataSet.add(liveData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInactive(LiveData liveData) {
        this.mLiveDataSet.remove(liveData);
    }
}
