package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.student.C4215R;
import com.bxkj.student.generated.callback.View$OnClickListenerC4297a;
import com.bxkj.student.p094v2.p098ui.main.ClassifyFragment;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class V2MainTabClassifyFragmentBindingImpl extends V2MainTabClassifyFragmentBinding implements View$OnClickListenerC4297a.InterfaceC4298a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback65;
    @Nullable
    private final View.OnClickListener mCallback66;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131233204, 3);
        sparseIntArray.put(C4215R.C4219id.card_home, 4);
        sparseIntArray.put(C4215R.C4219id.tv_home_menu_hint, 5);
        sparseIntArray.put(C4215R.C4219id.rv_home_menu, 6);
        sparseIntArray.put(C4215R.C4219id.rv_menu, 7);
    }

    public V2MainTabClassifyFragmentBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.View$OnClickListenerC4297a.InterfaceC4298a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            ClassifyFragment classifyFragment = this.mClassifyFragment;
            if (classifyFragment != null) {
                classifyFragment.m38712D();
            }
        } else if (sourceId != 2) {
        } else {
            ClassifyFragment classifyFragment2 = this.mClassifyFragment;
            if (classifyFragment2 != null) {
                classifyFragment2.m38712D();
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        if ((j & 2) != 0) {
            this.tvHomeMenuArrow.setOnClickListener(this.mCallback66);
            this.tvHomeMenuCount.setOnClickListener(this.mCallback65);
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
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.bxkj.student.databinding.V2MainTabClassifyFragmentBinding
    public void setClassifyFragment(@Nullable ClassifyFragment ClassifyFragment) {
        this.mClassifyFragment = ClassifyFragment;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (5 == variableId) {
            setClassifyFragment((ClassifyFragment) variable);
            return true;
        }
        return false;
    }

    private V2MainTabClassifyFragmentBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (CardView) bindings[4], (RecyclerView) bindings[6], (RecyclerView) bindings[7], (ImageView) bindings[2], (TextView) bindings[1], (TextView) bindings[5], (TextView) bindings[3]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvHomeMenuArrow.setTag(null);
        this.tvHomeMenuCount.setTag(null);
        setRootTag(root);
        this.mCallback65 = new View$OnClickListenerC4297a(this, 1);
        this.mCallback66 = new View$OnClickListenerC4297a(this, 2);
        invalidateAll();
    }
}
