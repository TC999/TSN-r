package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.base.p085v2.base.BindingAdapter;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.C4215R;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class V2ItemForClassifyMenuBindingImpl extends V2ItemForClassifyMenuBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    @NonNull
    private final FrameLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C4215R.C4219id.iv_op, 3);
    }

    public V2ItemForClassifyMenuBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
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
        long j2 = j & 6;
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
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.bxkj.student.databinding.V2ItemForClassifyMenuBinding
    public void setLoggedInUser(@Nullable LoggedInUser LoggedInUser) {
        this.mLoggedInUser = LoggedInUser;
    }

    @Override // com.bxkj.student.databinding.V2ItemForClassifyMenuBinding
    public void setMap(@Nullable Map<String, Object> Map) {
        this.mMap = Map;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (12 == variableId) {
            setLoggedInUser((LoggedInUser) variable);
        } else if (18 != variableId) {
            return false;
        } else {
            setMap((Map) variable);
        }
        return true;
    }

    private V2ItemForClassifyMenuBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (ImageView) bindings[3], (TextView) bindings[2]);
        this.mDirtyFlags = -1L;
        this.ivIcon.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
        this.tvName.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
