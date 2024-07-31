package com.bjtsn.dylan.lifecycleobserver;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: LifecycleObserver.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u0011"}, m12616d2 = {"Lcom/bjtsn/dylan/lifecycleobserver/LifecycleObserver;", "", "Lcom/bjtsn/dylan/lifecycleobserver/b;", "lifecycleCallback", "Lkotlin/f1;", "c", "Landroidx/lifecycle/Lifecycle;", "a", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "<init>", "(Landroid/support/v4/app/FragmentActivity;)V", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroid/support/v4/app/Fragment;)V", "lifecycleObserver_release"}, m12615k = 1, m12614mv = {1, 4, 2})
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class LifecycleObserver {

    /* renamed from: a */
    private Lifecycle f13198a;

    public LifecycleObserver(@NotNull FragmentActivity activity) {
        C14342f0.m8184p(activity, "activity");
        Lifecycle lifecycle = activity.getLifecycle();
        C14342f0.m8185o(lifecycle, "activity.lifecycle");
        this.f13198a = lifecycle;
    }

    /* renamed from: c */
    public final void m45791c(@NotNull final LifecycleCallback lifecycleCallback) {
        C14342f0.m8184p(lifecycleCallback, "lifecycleCallback");
        this.f13198a.addObserver(new androidx.lifecycle.LifecycleObserver() { // from class: com.bjtsn.dylan.lifecycleobserver.LifecycleObserver$observer$1
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            public final void onCreate() {
                lifecycleCallback.onCreate();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                Lifecycle lifecycle;
                lifecycleCallback.onDestroy();
                lifecycle = LifecycleObserver.this.f13198a;
                lifecycle.removeObserver(this);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            public final void onPause() {
                lifecycleCallback.onPause();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public final void onResume() {
                lifecycleCallback.onResume();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            public final void onStart() {
                lifecycleCallback.onStart();
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            public final void onStop() {
                lifecycleCallback.onStop();
            }
        });
    }

    public LifecycleObserver(@NotNull Fragment fragment) {
        C14342f0.m8184p(fragment, "fragment");
        Lifecycle lifecycle = fragment.getLifecycle();
        C14342f0.m8185o(lifecycle, "fragment.lifecycle");
        this.f13198a = lifecycle;
    }
}
