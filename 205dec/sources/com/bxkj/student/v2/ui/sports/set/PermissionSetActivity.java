package com.bxkj.student.v2.ui.sports.set;

import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.util.s;
import com.bxkj.base.util.z;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.data.a;
import com.bxkj.base.v2.h5.d;
import com.bxkj.student.databinding.AcV2PermissionSetBinding;
import com.bxkj.student.v2.common.utils.n;
import com.bxkj.student.v2.vm.sports.PermissionSetVM;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PermissionSetActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0004H\u0014J\u0006\u0010\u000b\u001a\u00020\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/set/PermissionSetActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV2PermissionSetBinding;", "Lcom/bxkj/student/v2/vm/sports/PermissionSetVM;", "Lkotlin/f1;", "N", "E", "p", "P", "Q", "onResume", "O", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class PermissionSetActivity extends BaseActivity<AcV2PermissionSetBinding, PermissionSetVM> {
    private final void N() {
        Button button = M().btFastSet;
        n.a aVar = n.f23377a;
        button.setEnabled(!aVar.b());
        M().btFastSet.setText(aVar.b() ? "\u6743\u9650\u5df2\u5f00\u542f" : "\u4e00\u952e\u81ea\u52a8\u5f00\u542f");
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setMActivity(this);
        SmartWebView smartWebView = M().sw;
        SmartWebView smartWebView2 = M().sw;
        f0.o(smartWebView2, "mDataBinding.sw");
        smartWebView.setWebViewClient(new d(smartWebView2));
        SmartWebView smartWebView3 = M().sw;
        StringBuilder sb = new StringBuilder();
        sb.append("https://h.tsnkj.com/?school=");
        a.b bVar = com.bxkj.base.v2.data.a.b;
        sb.append(bVar.a().p());
        sb.append("#/pages/stu/exercise/exercisePermissionDescription?model=");
        sb.append((Object) z.d());
        smartWebView3.j(sb.toString());
        M().btFastSet.setVisibility(bVar.a().B() == 1 ? 0 : 8);
    }

    public final void O() {
        n.f23377a.e(w());
    }

    public final void P() {
        if (Build.VERSION.SDK_INT >= 22) {
            startActivity(new Intent("android.settings.BATTERY_SAVER_SETTINGS"));
        } else {
            ContextExtKt.m(this, "\u8bf7\u624b\u52a8\u5728\u624b\u673a\u3010\u8bbe\u7f6e\u3011->\u3010\u7535\u6c60\u3011->\u3010\u7701\u7535\u6a21\u5f0f\u3011\u4e2d\u5173\u95ed\u7701\u7535\u6a21\u5f0f");
        }
    }

    public final void Q() {
        s.o(w());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        N();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
