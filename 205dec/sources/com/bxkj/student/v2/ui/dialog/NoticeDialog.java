package com.bxkj.student.v2.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.d;
import com.bxkj.base.v2.base.BaseDialog;
import com.bxkj.base.v2.common.utils.m;
import com.bxkj.base.v2.data.ParcelableMap;
import com.bxkj.student.databinding.DialogTipsBinding;
import com.bxkj.student.v2.common.utils.t;
import com.bxkj.student.v2.vm.NoticeVM;
import com.orhanobut.logger.j;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: NoticeDialog.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\b\u0010\f\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/bxkj/student/v2/ui/dialog/NoticeDialog;", "Lcom/bxkj/base/v2/base/BaseDialog;", "Lcom/bxkj/student/databinding/DialogTipsBinding;", "Lcom/bxkj/student/v2/vm/NoticeVM;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f1;", "onCreate", "E", "p", "m", "D", "onStart", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class NoticeDialog extends BaseDialog<DialogTipsBinding, NoticeVM> {
    public final void D() {
        m();
        t.a aVar = t.f23404a;
        Context C = C();
        m mVar = m.a;
        aVar.a(C, mVar.t(x().t().getValue(), "appletId"), mVar.t(x().t().getValue(), "appletPath"));
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        Bundle arguments;
        ParcelableMap parcelableMap;
        M().setDialog(this);
        Bundle arguments2 = getArguments();
        if (arguments2 == null || !arguments2.containsKey("data") || (arguments = getArguments()) == null || (parcelableMap = (ParcelableMap) arguments.getParcelable("data")) == null) {
            return;
        }
        Map<String, Object> b4 = parcelableMap.b();
        j.d(f0.C("NoticeDialog=", b4), new Object[0]);
        x().t().postValue(b4);
        m mVar = m.a;
        if (mVar.k(b4, "type") == 0) {
            ImageView imageView = M().iv;
            f0.o(imageView, "mDataBinding.iv");
            imageView.setVisibility(8);
            LinearLayout linearLayout = M().llMsg;
            f0.o(linearLayout, "mDataBinding.llMsg");
            linearLayout.setVisibility(0);
            M().tvTitle.setText(mVar.t(b4, "title"));
            M().tvContent.setText(mVar.t(b4, "des"));
            return;
        }
        ImageView imageView2 = M().iv;
        f0.o(imageView2, "mDataBinding.iv");
        imageView2.setVisibility(0);
        LinearLayout linearLayout2 = M().llMsg;
        f0.o(linearLayout2, "mDataBinding.llMsg");
        linearLayout2.setVisibility(8);
        f0.o(d.C(C()).a(mVar.t(b4, "imageUrl")).j1(M().iv), "{\n                      \u2026iv)\n                    }");
    }

    public final void m() {
        x().u();
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, 2131886653);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawableResource(2131034476);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 == null) {
            return;
        }
        dialog2.setCanceledOnTouchOutside(false);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
