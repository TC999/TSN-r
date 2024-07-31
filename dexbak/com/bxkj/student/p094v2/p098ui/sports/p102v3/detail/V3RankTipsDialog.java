package com.bxkj.student.p094v2.p098ui.sports.p102v3.detail;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import com.bxkj.base.p085v2.base.BaseAdapter;
import com.bxkj.base.p085v2.base.BaseDialog;
import com.bxkj.student.databinding.ItemForV3PassPointDialogBinding;
import com.bxkj.student.databinding.V3RankDialogBinding;
import com.bxkj.student.p094v2.p103vm.sports.SportsVM;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: V3RankTipsDialog.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R+\u0010\u0013\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f0\u000b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R>\u0010\u001b\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/detail/V3RankTipsDialog;", "Lcom/bxkj/base/v2/base/BaseDialog;", "Lcom/bxkj/student/databinding/V3RankDialogBinding;", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f1;", "onCreate", "onStart", ExifInterface.LONGITUDE_EAST, "p", "", "", "", "", "i", "Ljava/util/List;", "j", "()Ljava/util/List;", "dataList", "Lcom/bxkj/base/v2/base/BaseAdapter;", "", "Lcom/bxkj/student/databinding/ItemForV3PassPointDialogBinding;", "Lcom/bxkj/base/v2/base/BaseAdapter;", "()Lcom/bxkj/base/v2/base/BaseAdapter;", "k", "(Lcom/bxkj/base/v2/base/BaseAdapter;)V", "adapter", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.detail.V3RankTipsDialog */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3RankTipsDialog extends BaseDialog<V3RankDialogBinding, SportsVM> {
    @NotNull

    /* renamed from: i */
    private final List<Map<String, Object>> f20675i = new ArrayList();
    @Nullable

    /* renamed from: j */
    private BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> f20676j;

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setDialog(this);
    }

    @Nullable
    /* renamed from: i */
    public final BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> m38449i() {
        return this.f20676j;
    }

    @NotNull
    /* renamed from: j */
    public final List<Map<String, Object>> m38448j() {
        return this.f20675i;
    }

    /* renamed from: k */
    public final void m38447k(@Nullable BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> baseAdapter) {
        this.f20676j = baseAdapter;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, 2131886554);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        mo43912w().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setBackgroundDrawableResource(2131034508);
        WindowManager.LayoutParams attributes = window.getAttributes();
        C14342f0.m8185o(attributes, "attributes");
        double d = displayMetrics.widthPixels;
        Double.isNaN(d);
        attributes.width = (int) (d * 0.9d);
        attributes.height = -2;
        attributes.gravity = 17;
        window.setGravity(17);
        window.setAttributes(attributes);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
