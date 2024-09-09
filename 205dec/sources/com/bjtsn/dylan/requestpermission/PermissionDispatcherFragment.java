package com.bjtsn.dylan.requestpermission;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import l.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PermissionDispatcherFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J%\u0010\u0012\u001a\u00020\u000e2\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/bjtsn/dylan/requestpermission/PermissionDispatcherFragment;", "Landroidx/fragment/app/Fragment;", "", "permission", "", "b", "", TTDelegateActivity.INTENT_PERMISSIONS, "", "c", "([Ljava/lang/String;)Ljava/util/List;", "d", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f1;", "onCreate", "Ll/b$a;", "callBack", "requestPermissions", "([Ljava/lang/String;Ll/b$a;)V", "", "requestCode", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Landroid/util/SparseArray;", "a", "Landroid/util/SparseArray;", "mCallbacks", "<init>", "()V", "requestPermission_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class PermissionDispatcherFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<b.a> f16431a = new SparseArray<>();

    private final boolean b(String str) {
        Context context = getContext();
        return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
    }

    private final List<String> c(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!b(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private final boolean d(String str) {
        FragmentActivity activity = getActivity();
        return activity != null && ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i4, @NotNull String[] strArr, @NotNull int[] grantResults) {
        StubApp.interface22(i4, strArr, grantResults);
        f0.p(strArr, TTDelegateActivity.INTENT_PERMISSIONS);
        f0.p(grantResults, "grantResults");
        super.onRequestPermissionsResult(i4, strArr, grantResults);
        b.a aVar = this.f16431a.get(i4);
        this.f16431a.remove(i4);
        if (aVar == null) {
            return;
        }
        List<String> c4 = c(strArr);
        if (c4.isEmpty()) {
            aVar.b();
            return;
        }
        boolean z3 = false;
        Iterator<String> it = c4.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (!d(it.next())) {
                z3 = true;
                break;
            }
        }
        if (z3) {
            aVar.a(strArr);
        } else {
            aVar.c(strArr);
        }
    }

    public final void requestPermissions(@NotNull String[] strArr, @NotNull b.a callBack) {
        f0.p(strArr, TTDelegateActivity.INTENT_PERMISSIONS);
        f0.p(callBack, "callBack");
        if (!c(strArr).isEmpty()) {
            int size = this.f16431a.size() + 1;
            this.f16431a.put(size, callBack);
            requestPermissions(strArr, size);
            return;
        }
        callBack.b();
    }
}
