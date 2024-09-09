package com.bxkj.base.util.file;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RxUtils.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RxUtils.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a implements ObservableTransformer {
        a() {
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource apply(Observable observable) {
            return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        }
    }

    public static com.trello.rxlifecycle2.c a(@NonNull Context context) {
        if (context instanceof com.trello.rxlifecycle2.b) {
            return ((com.trello.rxlifecycle2.b) context).t();
        }
        throw new IllegalArgumentException("context not the LifecycleProvider type");
    }

    public static <T> com.trello.rxlifecycle2.c b(@NonNull Fragment fragment) {
        if (fragment instanceof com.trello.rxlifecycle2.b) {
            return ((com.trello.rxlifecycle2.b) fragment).t();
        }
        throw new IllegalArgumentException("fragment not the LifecycleProvider type");
    }

    public static <T> com.trello.rxlifecycle2.c c(@NonNull com.trello.rxlifecycle2.b bVar) {
        return bVar.t();
    }

    public static ObservableTransformer d() {
        return new a();
    }
}
