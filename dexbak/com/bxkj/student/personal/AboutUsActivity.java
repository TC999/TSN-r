package com.bxkj.student.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AboutUsActivity extends BaseActivity {

    /* renamed from: com.bxkj.student.personal.AboutUsActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnLongClickListenerC5106a implements View.OnLongClickListener {
        View$OnLongClickListenerC5106a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            AboutUsActivity.this.m40584n0();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.AboutUsActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5107b implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ iOSTwoButtonDialog f18697a;

        /* renamed from: com.bxkj.student.personal.AboutUsActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5108a implements iOSTwoButtonDialog.RightButtonOnClick {
            C5108a() {
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                LoginUser.getLoginUser().setOpenModel(false);
            }
        }

        /* renamed from: com.bxkj.student.personal.AboutUsActivity$b$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5109b implements iOSTwoButtonDialog.RightButtonOnClick {
            C5109b() {
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                LoginUser.getLoginUser().setOpenModel(true);
            }
        }

        C5107b(final iOSTwoButtonDialog val$iOSTwoButtonDialog) {
            this.f18697a = val$iOSTwoButtonDialog;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f18697a.show();
            String trim = ((EditText) this.f18697a.findViewById(C4215R.C4219id.et_password)).getText().toString().trim();
            if (trim.isEmpty()) {
                AboutUsActivity.this.m57919h0("密码不能为空");
                return;
            }
            try {
                this.f18697a.dismiss();
                if ("396436".equals(trim)) {
                    if (LoginUser.getLoginUser().isOpenModel()) {
                        new iOSTwoButtonDialog(((BaseActivity) AboutUsActivity.this).f1669h).setMessage("确定关闭开发者模式？").setRightButtonOnClickListener(new C5108a()).show();
                    } else {
                        new iOSTwoButtonDialog(((BaseActivity) AboutUsActivity.this).f1669h).setMessage("确定打开开发者模式？").setRightButtonOnClickListener(new C5109b()).show();
                    }
                } else {
                    new iOSOneButtonDialog(((BaseActivity) AboutUsActivity.this).f1669h).setMessage("密码错误，请联系管理员").show();
                }
            } catch (Exception e) {
                new iOSOneButtonDialog(((BaseActivity) AboutUsActivity.this).f1669h).setMessage("验证密码异常，请联系管理员").show();
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public void m40584n0() {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1669h);
        iostwobuttondialog.setMessage("开发者模式专供开发者调试使用，请谨慎开启！开关开发者模式需要验证你的身份，请输入密码进行验证").setCenterCustomView(C4215R.C4221layout.dialog_confim_password).setRightButtonOnClickListener(new C5107b(iostwobuttondialog)).show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        findViewById(2131231451).setOnLongClickListener(new View$OnLongClickListenerC5106a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_about_us;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("关于我们");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
