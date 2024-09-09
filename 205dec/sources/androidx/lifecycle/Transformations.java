package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class Transformations {
    private Transformations() {
    }

    @NonNull
    @MainThread
    public static <X> LiveData<X> distinctUntilChanged(@NonNull LiveData<X> source) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(source, new Observer<X>() { // from class: androidx.lifecycle.Transformations.3
            boolean mFirstTime = true;

            @Override // androidx.lifecycle.Observer
            public void onChanged(X currentValue) {
                Object value = MediatorLiveData.this.getValue();
                if (this.mFirstTime || ((value == null && currentValue != null) || !(value == null || value.equals(currentValue)))) {
                    this.mFirstTime = false;
                    MediatorLiveData.this.setValue(currentValue);
                }
            }
        });
        return mediatorLiveData;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> source, @NonNull final Function<X, Y> mapFunction) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(source, new Observer<X>() { // from class: androidx.lifecycle.Transformations.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable X x3) {
                MediatorLiveData.this.setValue(mapFunction.apply(x3));
            }
        });
        return mediatorLiveData;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> source, @NonNull final Function<X, LiveData<Y>> switchMapFunction) {
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(source, new Observer<X>() { // from class: androidx.lifecycle.Transformations.2
            LiveData<Y> mSource;

            @Override // androidx.lifecycle.Observer
            public void onChanged(@Nullable X x3) {
                LiveData<Y> liveData = (LiveData) Function.this.apply(x3);
                Object obj = this.mSource;
                if (obj == liveData) {
                    return;
                }
                if (obj != null) {
                    mediatorLiveData.removeSource(obj);
                }
                this.mSource = liveData;
                if (liveData != 0) {
                    mediatorLiveData.addSource(liveData, new Observer<Y>() { // from class: androidx.lifecycle.Transformations.2.1
                        @Override // androidx.lifecycle.Observer
                        public void onChanged(@Nullable Y y3) {
                            mediatorLiveData.setValue(y3);
                        }
                    });
                }
            }
        });
        return mediatorLiveData;
    }
}
