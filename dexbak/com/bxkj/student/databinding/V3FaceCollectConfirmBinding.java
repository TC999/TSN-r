package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.p098ui.face.FaceCollectConfirmActivity;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class V3FaceCollectConfirmBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivFace;
    @NonNull
    public final V3PubTitleBinding layoutTitle;
    @Bindable
    protected FaceCollectConfirmActivity mActivity;
    @NonNull
    public final TextView tvInfo;
    @NonNull
    public final TextView tvInfoTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public V3FaceCollectConfirmBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivFace, V3PubTitleBinding layoutTitle, TextView tvInfo, TextView tvInfoTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivFace = ivFace;
        this.layoutTitle = layoutTitle;
        this.tvInfo = tvInfo;
        this.tvInfoTitle = tvInfoTitle;
    }

    public static V3FaceCollectConfirmBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3FaceCollectConfirmBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public FaceCollectConfirmActivity getActivity() {
        return this.mActivity;
    }

    public abstract void setActivity(@Nullable FaceCollectConfirmActivity activity);

    @Deprecated
    public static V3FaceCollectConfirmBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3FaceCollectConfirmBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.v3_face_collect_confirm);
    }

    @NonNull
    @Deprecated
    public static V3FaceCollectConfirmBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3FaceCollectConfirmBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v3_face_collect_confirm, root, attachToRoot, component);
    }

    @NonNull
    public static V3FaceCollectConfirmBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3FaceCollectConfirmBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3FaceCollectConfirmBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v3_face_collect_confirm, null, false, component);
    }
}
