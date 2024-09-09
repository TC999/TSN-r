package com.bjtsn.dylan.startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import m.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: EventDispatcherFragment.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/bjtsn/dylan/startactivityforresult/EventDispatcherFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f1;", "onCreate", "Landroid/content/Intent;", "intent", "Lm/b$a;", "callback", "startActivityForResult", "", "requestCode", "resultCode", "data", "onActivityResult", "Landroid/util/SparseArray;", "a", "Landroid/util/SparseArray;", "b", "()Landroid/util/SparseArray;", "c", "(Landroid/util/SparseArray;)V", "mCallbacks", "<init>", "()V", "startActivityForResult_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class EventDispatcherFragment extends Fragment {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<b.a> f16432a = new SparseArray<>();

    @NotNull
    public final SparseArray<b.a> b() {
        return this.f16432a;
    }

    public final void c(@NotNull SparseArray<b.a> sparseArray) {
        f0.p(sparseArray, "<set-?>");
        this.f16432a = sparseArray;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        super.onActivityResult(i4, i5, intent);
        b.a aVar = this.f16432a.get(i4);
        if (aVar != null) {
            this.f16432a.remove(i4);
            aVar.a(i5, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public final void startActivityForResult(@NotNull Intent intent, @NotNull b.a callback) {
        f0.p(intent, "intent");
        f0.p(callback, "callback");
        int size = this.f16432a.size();
        this.f16432a.put(size, callback);
        startActivityForResult(intent, size);
    }
}
