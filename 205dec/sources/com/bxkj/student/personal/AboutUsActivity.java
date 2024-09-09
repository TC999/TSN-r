package com.bxkj.student.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.user.LoginUser;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AboutUsActivity extends BaseActivity {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v3) {
            AboutUsActivity.this.n0();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ iOSTwoButtonDialog f21997a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements iOSTwoButtonDialog.RightButtonOnClick {
            a() {
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                LoginUser.getLoginUser().setOpenModel(false);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.personal.AboutUsActivity$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class C0275b implements iOSTwoButtonDialog.RightButtonOnClick {
            C0275b() {
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                LoginUser.getLoginUser().setOpenModel(true);
            }
        }

        b(final iOSTwoButtonDialog val$iOSTwoButtonDialog) {
            this.f21997a = val$iOSTwoButtonDialog;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f21997a.show();
            String trim = ((EditText) this.f21997a.findViewById(2131231264)).getText().toString().trim();
            if (trim.isEmpty()) {
                AboutUsActivity.this.h0("\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a");
                return;
            }
            try {
                this.f21997a.dismiss();
                if ("396436".equals(trim)) {
                    if (LoginUser.getLoginUser().isOpenModel()) {
                        new iOSTwoButtonDialog(((BaseActivity) AboutUsActivity.this).f1656h).setMessage("\u786e\u5b9a\u5173\u95ed\u5f00\u53d1\u8005\u6a21\u5f0f\uff1f").setRightButtonOnClickListener(new a()).show();
                    } else {
                        new iOSTwoButtonDialog(((BaseActivity) AboutUsActivity.this).f1656h).setMessage("\u786e\u5b9a\u6253\u5f00\u5f00\u53d1\u8005\u6a21\u5f0f\uff1f").setRightButtonOnClickListener(new C0275b()).show();
                    }
                } else {
                    new iOSOneButtonDialog(((BaseActivity) AboutUsActivity.this).f1656h).setMessage("\u5bc6\u7801\u9519\u8bef\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
                }
            } catch (Exception e4) {
                new iOSOneButtonDialog(((BaseActivity) AboutUsActivity.this).f1656h).setMessage("\u9a8c\u8bc1\u5bc6\u7801\u5f02\u5e38\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1656h);
        iostwobuttondialog.setMessage("\u5f00\u53d1\u8005\u6a21\u5f0f\u4e13\u4f9b\u5f00\u53d1\u8005\u8c03\u8bd5\u4f7f\u7528\uff0c\u8bf7\u8c28\u614e\u5f00\u542f\uff01\u5f00\u5173\u5f00\u53d1\u8005\u6a21\u5f0f\u9700\u8981\u9a8c\u8bc1\u4f60\u7684\u8eab\u4efd\uff0c\u8bf7\u8f93\u5165\u5bc6\u7801\u8fdb\u884c\u9a8c\u8bc1").setCenterCustomView(2131427593).setRightButtonOnClickListener(new b(iostwobuttondialog)).show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        findViewById(2131231451).setOnLongClickListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427356;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5173\u4e8e\u6211\u4eec");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
