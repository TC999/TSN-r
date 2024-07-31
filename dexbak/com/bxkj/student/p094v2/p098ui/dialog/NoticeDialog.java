package com.bxkj.student.p094v2.p098ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.Glide;
import com.bxkj.base.p085v2.base.BaseDialog;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.data.ParcelableMap;
import com.bxkj.student.databinding.DialogTipsBinding;
import com.bxkj.student.p094v2.common.utils.WechatUtils;
import com.bxkj.student.p094v2.p103vm.NoticeVM;
import com.orhanobut.logger.C11792j;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.Nullable;

/* compiled from: NoticeDialog.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\b\u0010\f\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/dialog/NoticeDialog;", "Lcom/bxkj/base/v2/base/BaseDialog;", "Lcom/bxkj/student/databinding/DialogTipsBinding;", "Lcom/bxkj/student/v2/vm/NoticeVM;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f1;", "onCreate", ExifInterface.LONGITUDE_EAST, "p", "i", "j", "onStart", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.dialog.NoticeDialog */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class NoticeDialog extends BaseDialog<DialogTipsBinding, NoticeVM> {
    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        Bundle arguments;
        ParcelableMap parcelableMap;
        mo43920M().setDialog(this);
        Bundle arguments2 = getArguments();
        if (arguments2 == null || !arguments2.containsKey("data") || (arguments = getArguments()) == null || (parcelableMap = (ParcelableMap) arguments.getParcelable("data")) == null) {
            return;
        }
        Map<String, ? extends Object> m43694a = parcelableMap.m43694a();
        C11792j.m20469d(C14342f0.m8216C("NoticeDialog=", m43694a), new Object[0]);
        mo43911x().m38123t().postValue(m43694a);
        JsonGet jsonGet = JsonGet.f15134a;
        if (jsonGet.m43769k(m43694a, "type") == 0) {
            ImageView imageView = mo43920M().f16282iv;
            C14342f0.m8185o(imageView, "mDataBinding.iv");
            imageView.setVisibility(8);
            LinearLayout linearLayout = mo43920M().llMsg;
            C14342f0.m8185o(linearLayout, "mDataBinding.llMsg");
            linearLayout.setVisibility(0);
            mo43920M().tvTitle.setText(jsonGet.m43760t(m43694a, "title"));
            mo43920M().tvContent.setText(jsonGet.m43760t(m43694a, "des"));
            return;
        }
        ImageView imageView2 = mo43920M().f16282iv;
        C14342f0.m8185o(imageView2, "mDataBinding.iv");
        imageView2.setVisibility(0);
        LinearLayout linearLayout2 = mo43920M().llMsg;
        C14342f0.m8185o(linearLayout2, "mDataBinding.llMsg");
        linearLayout2.setVisibility(8);
        C14342f0.m8185o(Glide.m45751C(mo43926C()).mo45507a(jsonGet.m43760t(m43694a, "imageUrl")).m45551i1(mo43920M().f16282iv), "{\n                      …iv)\n                    }");
    }

    /* renamed from: i */
    public final void m38850i() {
        mo43911x().m38122u();
        dismiss();
    }

    /* renamed from: j */
    public final void m38849j() {
        m38850i();
        WechatUtils.C5553a c5553a = WechatUtils.f20152a;
        Context mo43926C = mo43926C();
        JsonGet jsonGet = JsonGet.f15134a;
        c5553a.m39050a(mo43926C, jsonGet.m43760t(mo43911x().m38123t().getValue(), "appletId"), jsonGet.m43760t(mo43911x().m38123t().getValue(), "appletPath"));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, 2131886649);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawableResource(2131034508);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 == null) {
            return;
        }
        dialog2.setCanceledOnTouchOutside(false);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
