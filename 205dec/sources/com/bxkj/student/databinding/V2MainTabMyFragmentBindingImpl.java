package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.main.MyFragment;
import com.google.android.material.button.MaterialButton;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class V2MainTabMyFragmentBindingImpl extends V2MainTabMyFragmentBinding implements a.InterfaceC0220a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback21;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131233204, 4);
        sparseIntArray.put(2131232535, 5);
        sparseIntArray.put(2131231064, 6);
        sparseIntArray.put(2131231426, 7);
        sparseIntArray.put(2131232550, 8);
    }

    public V2MainTabMyFragmentBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        MyFragment myFragment = this.mMyFragment;
        if (myFragment != null) {
            myFragment.h();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        String str;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        com.bxkj.base.v2.data.a aVar = this.mLoggedInUser;
        long j5 = 6 & j4;
        String str2 = null;
        if (j5 == 0 || aVar == null) {
            str = null;
        } else {
            str2 = aVar.v();
            str = aVar.u();
        }
        if ((j4 & 4) != 0) {
            this.btLogout.setOnClickListener(this.mCallback21);
        }
        if (j5 != 0) {
            TextViewBindingAdapter.setText(this.tvName, str2);
            TextViewBindingAdapter.setText(this.tvUserNumber, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.bxkj.student.databinding.V2MainTabMyFragmentBinding
    public void setLoggedInUser(@Nullable com.bxkj.base.v2.data.a LoggedInUser) {
        this.mLoggedInUser = LoggedInUser;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(12);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V2MainTabMyFragmentBinding
    public void setMyFragment(@Nullable MyFragment MyFragment) {
        this.mMyFragment = MyFragment;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (19 == variableId) {
            setMyFragment((MyFragment) variable);
        } else if (12 != variableId) {
            return false;
        } else {
            setLoggedInUser((com.bxkj.base.v2.data.a) variable);
        }
        return true;
    }

    private V2MainTabMyFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialButton) bindings[3], (CardView) bindings[6], (ImageView) bindings[7], (NestedScrollView) bindings[5], (RecyclerView) bindings[8], (TextView) bindings[1], (TextView) bindings[4], (TextView) bindings[2]);
        this.mDirtyFlags = -1L;
        this.btLogout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvName.setTag(null);
        this.tvUserNumber.setTag(null);
        setRootTag(root);
        this.mCallback21 = new a(this, 1);
        invalidateAll();
    }
}
