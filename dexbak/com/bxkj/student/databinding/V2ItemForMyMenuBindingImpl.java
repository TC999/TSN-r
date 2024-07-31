package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.base.p085v2.base.BindingAdapter;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.C4215R;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class V2ItemForMyMenuBindingImpl extends V2ItemForMyMenuBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    public V2ItemForMyMenuBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        CharSequence charSequence;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, ? extends Object> map = this.mMap;
        long j2 = j & 3;
        String str = null;
        if (j2 != 0) {
            Object obj = map != null ? map.get("name") : null;
            str = JsonGet.f15134a.m43760t(map, RewardPlus.ICON);
            charSequence = obj;
        } else {
            charSequence = null;
        }
        if (j2 != 0) {
            ImageView imageView = this.ivIcon;
            BindingAdapter.m43883g(imageView, str, AppCompatResources.getDrawable(imageView.getContext(), 2131166066), AppCompatResources.getDrawable(this.ivIcon.getContext(), C4215R.C4218drawable.v2_home_menu_more));
            TextViewBindingAdapter.setText(this.tvName, charSequence);
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

    @Override // com.bxkj.student.databinding.V2ItemForMyMenuBinding
    public void setMap(@Nullable Map<String, Object> Map) {
        this.mMap = Map;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (18 == variableId) {
            setMap((Map) variable);
            return true;
        }
        return false;
    }

    private V2ItemForMyMenuBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[0], (ImageView) bindings[1], (TextView) bindings[2]);
        this.mDirtyFlags = -1L;
        this.clRoot.setTag(null);
        this.ivIcon.setTag(null);
        this.tvName.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
