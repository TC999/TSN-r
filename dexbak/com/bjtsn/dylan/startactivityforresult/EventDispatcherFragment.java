package com.bjtsn.dylan.startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p618m.StartActivityForResult;

/* compiled from: EventDispatcherFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, m12616d2 = {"Lcom/bjtsn/dylan/startactivityforresult/EventDispatcherFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f1;", "onCreate", "Landroid/content/Intent;", "intent", "Lm/b$a;", "callback", "startActivityForResult", "", "requestCode", "resultCode", "data", "onActivityResult", "Landroid/util/SparseArray;", "a", "Landroid/util/SparseArray;", "b", "()Landroid/util/SparseArray;", "c", "(Landroid/util/SparseArray;)V", "mCallbacks", "<init>", "()V", "startActivityForResult_debug"}, m12615k = 1, m12614mv = {1, 4, 2})
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class EventDispatcherFragment extends Fragment {
    @NotNull

    /* renamed from: a */
    private SparseArray<StartActivityForResult.InterfaceC15293a> f13209a = new SparseArray<>();

    @NotNull
    /* renamed from: b */
    public final SparseArray<StartActivityForResult.InterfaceC15293a> m45787b() {
        return this.f13209a;
    }

    /* renamed from: c */
    public final void m45786c(@NotNull SparseArray<StartActivityForResult.InterfaceC15293a> sparseArray) {
        C14342f0.m8184p(sparseArray, "<set-?>");
        this.f13209a = sparseArray;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        StartActivityForResult.InterfaceC15293a interfaceC15293a = this.f13209a.get(i);
        if (interfaceC15293a != null) {
            this.f13209a.remove(i);
            interfaceC15293a.mo3459a(i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public final void startActivityForResult(@NotNull Intent intent, @NotNull StartActivityForResult.InterfaceC15293a callback) {
        C14342f0.m8184p(intent, "intent");
        C14342f0.m8184p(callback, "callback");
        int size = this.f13209a.size();
        this.f13209a.put(size, callback);
        startActivityForResult(intent, size);
    }
}
