package com.bxkj.student.v2.ui.sports.v3.detail;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.base.BaseDialog;
import com.bxkj.student.databinding.ItemForV3PassPointDialogBinding;
import com.bxkj.student.databinding.V3ExceptionDialogBinding;
import com.bxkj.student.v2.vm.sports.SportsVM;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3ExceptionDialog.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R+\u0010\u0013\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R>\u0010\u001b\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/detail/V3ExceptionDialog;", "Lcom/bxkj/base/v2/base/BaseDialog;", "Lcom/bxkj/student/databinding/V3ExceptionDialogBinding;", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f1;", "onCreate", "onStart", "E", "p", "", "", "", "", "i", "Ljava/util/List;", "j", "()Ljava/util/List;", "dataList", "Lcom/bxkj/base/v2/base/BaseAdapter;", "", "Lcom/bxkj/student/databinding/ItemForV3PassPointDialogBinding;", "Lcom/bxkj/base/v2/base/BaseAdapter;", "()Lcom/bxkj/base/v2/base/BaseAdapter;", "k", "(Lcom/bxkj/base/v2/base/BaseAdapter;)V", "adapter", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3ExceptionDialog extends BaseDialog<V3ExceptionDialogBinding, SportsVM> {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final List<Map<String, Object>> f24088i = new ArrayList();
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> f24089j;

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setDialog(this);
    }

    @Nullable
    public final BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> i() {
        return this.f24089j;
    }

    @NotNull
    public final List<Map<String, Object>> j() {
        return this.f24088i;
    }

    public final void k(@Nullable BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> baseAdapter) {
        this.f24089j = baseAdapter;
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
        w().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setBackgroundDrawableResource(2131034508);
        WindowManager.LayoutParams attributes = window.getAttributes();
        f0.o(attributes, "attributes");
        double d4 = displayMetrics.widthPixels;
        Double.isNaN(d4);
        attributes.width = (int) (d4 * 0.9d);
        attributes.height = -2;
        attributes.gravity = 17;
        window.setGravity(17);
        window.setAttributes(attributes);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
