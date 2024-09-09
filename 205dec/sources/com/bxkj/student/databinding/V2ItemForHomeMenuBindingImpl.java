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
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.base.v2.data.a;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class V2ItemForHomeMenuBindingImpl extends V2ItemForHomeMenuBinding {
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
        sparseIntArray.put(2131231461, 3);
    }

    public V2ItemForHomeMenuBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        CharSequence charSequence;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, ? extends Object> map = this.mMap;
        long j5 = j4 & 6;
        String str = null;
        if (j5 != 0) {
            Object obj = map != null ? map.get("name") : null;
            str = l.f18624a.t(map, RewardPlus.ICON);
            charSequence = obj;
        } else {
            charSequence = null;
        }
        if (j5 != 0) {
            ImageView imageView = this.ivIcon;
            com.bxkj.base.v2.base.l.g(imageView, str, AppCompatResources.getDrawable(imageView.getContext(), 2131166066), AppCompatResources.getDrawable(this.ivIcon.getContext(), 2131166065));
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

    @Override // com.bxkj.student.databinding.V2ItemForHomeMenuBinding
    public void setLoggedInUser(@Nullable a LoggedInUser) {
        this.mLoggedInUser = LoggedInUser;
    }

    @Override // com.bxkj.student.databinding.V2ItemForHomeMenuBinding
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
            setLoggedInUser((a) variable);
        } else if (18 != variableId) {
            return false;
        } else {
            setMap((Map) variable);
        }
        return true;
    }

    private V2ItemForHomeMenuBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
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
