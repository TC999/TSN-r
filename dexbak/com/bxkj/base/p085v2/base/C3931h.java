package com.bxkj.base.p085v2.base;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;

/* compiled from: BaseUI.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aX\u0010\u000b\u001a\u0004\u0018\u00018\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002\"\n\b\u0002\u0010\u0005\u0018\u0001*\u00020\u0004*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0086\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m12616d2 = {"Landroidx/databinding/ViewDataBinding;", "VB", "Lcom/bxkj/base/v2/base/BaseViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "F", "Lcom/bxkj/base/v2/base/g;", "Landroidx/navigation/fragment/NavHostFragment;", "navHostFragment", "Ljava/lang/Class;", "fragmentClass", "a", "(Lcom/bxkj/base/v2/base/g;Landroidx/navigation/fragment/NavHostFragment;Ljava/lang/Class;)Landroidx/fragment/app/Fragment;", "base_release"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.base.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C3931h {
    /* renamed from: a */
    public static final /* synthetic */ <VB extends ViewDataBinding, VM extends BaseViewModel, F extends Fragment> F m43890a(BaseUI<VB, VM> baseUI, NavHostFragment navHostFragment, Class<F> fragmentClass) {
        C14342f0.m8184p(baseUI, "<this>");
        C14342f0.m8184p(navHostFragment, "navHostFragment");
        C14342f0.m8184p(fragmentClass, "fragmentClass");
        List<Fragment> fragments = navHostFragment.getChildFragmentManager().getFragments();
        C14342f0.m8185o(fragments, "navHostFragment.childFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (it.hasNext()) {
            F f = (F) it.next();
            if (fragmentClass.isAssignableFrom(f.getClass())) {
                C14342f0.m8175y(1, "F");
                return f;
            }
        }
        return null;
    }
}
