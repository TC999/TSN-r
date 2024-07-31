package com.bxkj.base.util.file;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* renamed from: com.bxkj.base.util.file.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RxUtils {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxUtils.java */
    /* renamed from: com.bxkj.base.util.file.d$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3899a implements ObservableTransformer {
        C3899a() {
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource apply(Observable observable) {
            return observable.subscribeOn(Schedulers.m12671io()).observeOn(AndroidSchedulers.mainThread());
        }
    }

    /* renamed from: a */
    public static LifecycleTransformer m44094a(@NonNull Context context) {
        if (context instanceof LifecycleProvider) {
            return ((LifecycleProvider) context).mo14874t();
        }
        throw new IllegalArgumentException("context not the LifecycleProvider type");
    }

    /* renamed from: b */
    public static <T> LifecycleTransformer m44093b(@NonNull Fragment fragment) {
        if (fragment instanceof LifecycleProvider) {
            return ((LifecycleProvider) fragment).mo14874t();
        }
        throw new IllegalArgumentException("fragment not the LifecycleProvider type");
    }

    /* renamed from: c */
    public static <T> LifecycleTransformer m44092c(@NonNull LifecycleProvider lifecycleProvider) {
        return lifecycleProvider.mo14874t();
    }

    /* renamed from: d */
    public static ObservableTransformer m44091d() {
        return new C3899a();
    }
}
