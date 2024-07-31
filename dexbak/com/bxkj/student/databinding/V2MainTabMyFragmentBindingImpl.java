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
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.generated.callback.View$OnClickListenerC4297a;
import com.bxkj.student.p094v2.p098ui.main.MyFragment;
import com.google.android.material.button.MaterialButton;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class V2MainTabMyFragmentBindingImpl extends V2MainTabMyFragmentBinding implements View$OnClickListenerC4297a.InterfaceC4298a {
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
        sparseIntArray.put(C4215R.C4219id.card_head, 6);
        sparseIntArray.put(2131231426, 7);
        sparseIntArray.put(C4215R.C4219id.rv_menu, 8);
    }

    public V2MainTabMyFragmentBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.View$OnClickListenerC4297a.InterfaceC4298a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        MyFragment myFragment = this.mMyFragment;
        if (myFragment != null) {
            myFragment.m38663h();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        LoggedInUser loggedInUser = this.mLoggedInUser;
        long j2 = 6 & j;
        String str2 = null;
        if (j2 == 0 || loggedInUser == null) {
            str = null;
        } else {
            str2 = loggedInUser.m43640v();
            str = loggedInUser.m43641u();
        }
        if ((j & 4) != 0) {
            this.btLogout.setOnClickListener(this.mCallback21);
        }
        if (j2 != 0) {
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
    public void setLoggedInUser(@Nullable LoggedInUser LoggedInUser) {
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
            setLoggedInUser((LoggedInUser) variable);
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
        this.mCallback21 = new View$OnClickListenerC4297a(this, 1);
        invalidateAll();
    }
}
