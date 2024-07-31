package com.bxkj.student.p094v2.p098ui.sports.set;

import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.p085v2.p086h5.H5BaseWebViewClient;
import com.bxkj.base.util.C3912s;
import com.bxkj.base.util.SystemUtils;
import com.bxkj.student.databinding.AcV2PermissionSetBinding;
import com.bxkj.student.p094v2.common.utils.SQZSManager;
import com.bxkj.student.p094v2.p103vm.sports.PermissionSetVM;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;

/* compiled from: PermissionSetActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0004H\u0014J\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\u000e"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/set/PermissionSetActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV2PermissionSetBinding;", "Lcom/bxkj/student/v2/vm/sports/PermissionSetVM;", "Lkotlin/f1;", "N", ExifInterface.LONGITUDE_EAST, "p", "P", "Q", "onResume", "O", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.set.PermissionSetActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class PermissionSetActivity extends BaseActivity<AcV2PermissionSetBinding, PermissionSetVM> {
    /* renamed from: N */
    private final void m38615N() {
        Button button = mo43920M().btFastSet;
        SQZSManager.C5547a c5547a = SQZSManager.f20133a;
        button.setEnabled(!c5547a.m39067b());
        mo43920M().btFastSet.setText(c5547a.m39067b() ? "权限已开启" : "一键自动开启");
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setMActivity(this);
        SmartWebView smartWebView = mo43920M().f16276sw;
        SmartWebView smartWebView2 = mo43920M().f16276sw;
        C14342f0.m8185o(smartWebView2, "mDataBinding.sw");
        smartWebView.setWebViewClient(new H5BaseWebViewClient(smartWebView2));
        SmartWebView smartWebView3 = mo43920M().f16276sw;
        StringBuilder sb = new StringBuilder();
        sb.append("https://h.tsnkj.com/?school=");
        LoggedInUser.C3984b c3984b = LoggedInUser.f15182b;
        sb.append(c3984b.m43634a().m43646p());
        sb.append("#/pages/stu/exercise/exercisePermissionDescription?model=");
        sb.append((Object) SystemUtils.m44002d());
        smartWebView3.m57493j(sb.toString());
        mo43920M().btFastSet.setVisibility(c3984b.m43634a().m43689B() == 1 ? 0 : 8);
    }

    /* renamed from: O */
    public final void m38614O() {
        SQZSManager.f20133a.m39064e(mo43912w());
    }

    /* renamed from: P */
    public final void m38613P() {
        if (Build.VERSION.SDK_INT >= 22) {
            startActivity(new Intent("android.settings.BATTERY_SAVER_SETTINGS"));
        } else {
            ContextExt.m43851m(this, "请手动在手机【设置】->【电池】->【省电模式】中关闭省电模式");
        }
    }

    /* renamed from: Q */
    public final void m38612Q() {
        C3912s.m44034o(mo43912w());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m38615N();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
