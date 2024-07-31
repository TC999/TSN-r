package com.bxkj.student.personal.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.RSAUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.StatusUtil;
import com.bxkj.student.personal.bind.WechatQQBindAccountActivity;
import com.bxkj.student.personal.password.forget.FindPasswordTypeActivity;
import com.bxkj.student.splash.SelectSchoolV2Activity;
import com.orhanobut.logger.C11792j;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LoginActivity extends BaseActivity {

    /* renamed from: k */
    private Toolbar f18855k;

    /* renamed from: l */
    private TextView f18856l;

    /* renamed from: m */
    private EditText f18857m;

    /* renamed from: n */
    private EditText f18858n;

    /* renamed from: o */
    private Button f18859o;

    /* renamed from: p */
    private TextView f18860p;

    /* renamed from: q */
    private TextView f18861q;

    /* renamed from: r */
    private Button f18862r;

    /* renamed from: s */
    private Button f18863s;

    /* renamed from: t */
    private FrameLayout f18864t;

    /* renamed from: u */
    private CheckBox f18865u;

    /* renamed from: v */
    private TextView f18866v;

    /* renamed from: w */
    private TextView f18867w;

    /* renamed from: x */
    private LinearLayout f18868x;

    /* renamed from: y */
    UMAuthListener f18869y = new C5161d();

    /* renamed from: com.bxkj.student.personal.login.LoginActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnClickListenerC5156a implements View.OnClickListener {
        View$OnClickListenerC5156a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            LoginActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.login.LoginActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5157b implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ iOSTwoButtonDialog f18871a;

        /* renamed from: com.bxkj.student.personal.login.LoginActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5158a implements iOSTwoButtonDialog.RightButtonOnClick {
            C5158a() {
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                LoginUser.getLoginUser().setOpenModel(false);
            }
        }

        /* renamed from: com.bxkj.student.personal.login.LoginActivity$b$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5159b implements iOSTwoButtonDialog.RightButtonOnClick {
            C5159b() {
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                LoginUser.getLoginUser().setOpenModel(true);
            }
        }

        C5157b(final iOSTwoButtonDialog val$iOSTwoButtonDialog) {
            this.f18871a = val$iOSTwoButtonDialog;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f18871a.show();
            String trim = ((EditText) this.f18871a.findViewById(C4215R.C4219id.et_password)).getText().toString().trim();
            if (trim.isEmpty()) {
                LoginActivity.this.m57919h0("密码不能为空");
                return;
            }
            try {
                this.f18871a.dismiss();
                if ("396436".equals(trim)) {
                    if (LoginUser.getLoginUser().isOpenModel()) {
                        new iOSTwoButtonDialog(((BaseActivity) LoginActivity.this).f1669h).setMessage("确定关闭开发者模式？").setRightButtonOnClickListener(new C5158a()).show();
                    } else {
                        new iOSTwoButtonDialog(((BaseActivity) LoginActivity.this).f1669h).setMessage("确定打开开发者模式？").setRightButtonOnClickListener(new C5159b()).show();
                    }
                } else {
                    new iOSOneButtonDialog(((BaseActivity) LoginActivity.this).f1669h).setMessage("密码错误，请联系管理员").show();
                }
            } catch (Exception e) {
                new iOSOneButtonDialog(((BaseActivity) LoginActivity.this).f1669h).setMessage("验证密码异常，请联系管理员").show();
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.login.LoginActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5160c extends HttpCallBack {
        C5160c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUtils.m40420b(((BaseActivity) LoginActivity.this).f1670i, data);
        }
    }

    /* renamed from: com.bxkj.student.personal.login.LoginActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5161d implements UMAuthListener {
        C5161d() {
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(((BaseActivity) LoginActivity.this).f1669h, "您取消了登录", 1).show();
            LoginActivity.this.f18862r.setEnabled(true);
            LoginActivity.this.f18863s.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            C11792j.m20470c("platform=" + platform.name());
            C11792j.m20470c("data=" + data);
            String str = platform == SHARE_MEDIA.WEIXIN ? "1" : "0";
            data.put("login_type", str);
            LoginActivity.this.m40440E0(str, data);
            LoginActivity.this.f18862r.setEnabled(true);
            LoginActivity.this.f18863s.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            C11792j.m20470c(t.getMessage());
            C11792j.m20470c("action=" + action);
            Toast.makeText(((BaseActivity) LoginActivity.this).f1669h, "登录失败,请稍后再试", 1).show();
            LoginActivity.this.f18862r.setEnabled(true);
            LoginActivity.this.f18863s.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(SHARE_MEDIA platform) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.login.LoginActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5162e extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ Map f18877a;

        C5162e(final Map val$data) {
            this.f18877a = val$data;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            LoginActivity.this.f18862r.setEnabled(true);
            LoginActivity.this.f18863s.setEnabled(true);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            if (status == 201) {
                LoginActivity.this.startActivity(new Intent(((BaseActivity) LoginActivity.this).f1669h, WechatQQBindAccountActivity.class).putExtra("openid", (String) this.f18877a.get("openid")).putExtra("name", (String) this.f18877a.get("name")).putExtra("iconurl", (String) this.f18877a.get("iconurl")).putExtra("login_type", (String) this.f18877a.get("login_type")));
            } else {
                new iOSOneButtonDialog(((BaseActivity) LoginActivity.this).f1669h).setMessage(msg).show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUtils.m40420b(((BaseActivity) LoginActivity.this).f1670i, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public /* synthetic */ void m40444A0(iOSTwoButtonDialog iostwobuttondialog) {
        LoginUser.getLoginUser().setAgreement(true);
        this.f18865u.setChecked(true);
        iostwobuttondialog.dismiss();
    }

    /* renamed from: B0 */
    private void m40443B0() {
        String trim = this.f18857m.getText().toString().trim();
        String trim2 = this.f18858n.getText().toString().trim();
        if (trim.isEmpty()) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请输入账号").show();
        } else if (trim2.isEmpty()) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请输入密码").show();
        } else if (!this.f18865u.isChecked()) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请勾选同意用户协议").show();
        } else {
            try {
                Http.with(this.f1669h).setLoadingMessage("正在登录").setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m54z(trim, new RSAUtils().m44022a(trim2))).setDataListener(new C5160c());
            } catch (Exception e) {
                new iOSOneButtonDialog(this.f1669h).setMessage("登录异常，请联系管理员").show();
                e.printStackTrace();
            }
        }
    }

    /* renamed from: C0 */
    private void m40442C0() {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1669h);
        iostwobuttondialog.setMessage("开发者模式专供开发者调试使用，请谨慎开启！开关开发者模式需要验证你的身份，请输入密码进行验证").setCenterCustomView(C4215R.C4221layout.dialog_confim_password).setRightButtonOnClickListener(new C5157b(iostwobuttondialog)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0 */
    public void m40440E0(String type, Map<String, String> data) {
        C11792j.m20470c("data=" + data);
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m179D0(type, data.get("openid"))).setDataListener(new C5162e(data));
    }

    /* renamed from: x0 */
    private void m40424x0() {
        this.f18868x = (LinearLayout) findViewById(C4215R.C4219id.ll_account_login);
        this.f18867w = (TextView) findViewById(C4215R.C4219id.tv_switch_account);
        this.f18857m = (EditText) findViewById(C4215R.C4219id.et_account);
        this.f18858n = (EditText) findViewById(C4215R.C4219id.et_password);
        this.f18859o = (Button) findViewById(C4215R.C4219id.bt_login);
        this.f18860p = (TextView) findViewById(C4215R.C4219id.tv_forget_password);
        this.f18861q = (TextView) findViewById(C4215R.C4219id.tv_switch_school);
        this.f18862r = (Button) findViewById(C4215R.C4219id.bt_wechat_login);
        this.f18863s = (Button) findViewById(C4215R.C4219id.bt_qq_login);
        this.f18864t = (FrameLayout) findViewById(C4215R.C4219id.ll_contact_customer);
        this.f18855k = (Toolbar) findViewById(C4215R.C4219id.f16009tb);
        this.f18856l = (TextView) findViewById(2131233204);
        this.f18865u = (CheckBox) findViewById(2131231080);
        this.f18866v = (TextView) findViewById(C4215R.C4219id.tv_agree);
    }

    /* renamed from: y0 */
    private void m40423y0() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=" + this.f18864t.getTag().toString())));
        } catch (Exception unused) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请先安装QQ！").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ boolean m40422z0(View view) {
        m40442C0();
        return false;
    }

    /* renamed from: D0 */
    public void m40441D0(String qq) {
        this.f18864t.setTag(qq);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18866v.setOnClickListener(this);
        this.f18859o.setOnClickListener(this);
        this.f18860p.setOnClickListener(this);
        this.f18862r.setOnClickListener(this);
        this.f18863s.setOnClickListener(this);
        this.f18861q.setOnClickListener(this);
        this.f18864t.setOnClickListener(this);
        findViewById(2131231451).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.bxkj.student.personal.login.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean m40422z0;
                m40422z0 = LoginActivity.this.m40422z0(view);
                return m40422z0;
            }
        });
        this.f18867w.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_login;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f18857m.setText(LoginUser.getLoginUser().getAccount());
        this.f18866v.getPaint().setFlags(8);
        this.f18866v.getPaint().setAntiAlias(true);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        m57922e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(16);
        m40424x0();
        try {
            this.f18855k.getRootView().getRootView().setBackgroundResource(C4215R.mipmap.login_bg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StatusUtil.m42797d(this);
        this.f18856l.setText(LoginUser.getLoginUser().getSchoolName());
        this.f18855k.setNavigationIcon(2131165513);
        this.f18855k.setNavigationOnClickListener(new View$OnClickListenerC5156a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case C4215R.C4219id.bt_login /* 2131230984 */:
                m40443B0();
                return;
            case C4215R.C4219id.bt_qq_login /* 2131230997 */:
                if (!this.f18865u.isChecked()) {
                    new iOSOneButtonDialog(this.f1669h).setMessage("请勾选同意用户协议").show();
                    return;
                }
                UMShareAPI uMShareAPI = UMShareAPI.get(this.f1669h);
                SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                if (!uMShareAPI.isInstall(this, share_media)) {
                    m57919h0("您还未安装QQ或QQ版本过低");
                    return;
                }
                this.f18863s.setEnabled(false);
                UMShareAPI.get(this.f1669h).getPlatformInfo(this, share_media, this.f18869y);
                return;
            case C4215R.C4219id.bt_wechat_login /* 2131231022 */:
                UMShareAPI uMShareAPI2 = UMShareAPI.get(this.f1669h);
                SHARE_MEDIA share_media2 = SHARE_MEDIA.WEIXIN;
                if (!uMShareAPI2.isInstall(this, share_media2)) {
                    m57919h0("您还未安装微信或微信版本过低");
                    return;
                } else if (!this.f18865u.isChecked()) {
                    new iOSOneButtonDialog(this.f1669h).setMessage("请勾选同意用户协议").show();
                    return;
                } else {
                    this.f18862r.setEnabled(false);
                    UMShareAPI.get(this.f1669h).getPlatformInfo(this, share_media2, this.f18869y);
                    return;
                }
            case C4215R.C4219id.ll_contact_customer /* 2131232179 */:
                m40423y0();
                return;
            case C4215R.C4219id.tv_agree /* 2131232842 */:
                final iOSTwoButtonDialog rightButtonText = new iOSTwoButtonDialog(this.f1669h).setTitle("用户协议").setCenterCustomView(2131427408).setLeftButtonText("仅浏览").setRightButtonText("同意");
                ((SmartWebView) rightButtonText.findViewById(2131232631)).m57493j("https://www.boxkj.com/resources/user_agreement_info.html");
                rightButtonText.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.personal.login.b
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        LoginActivity.this.m40444A0(rightButtonText);
                    }
                });
                rightButtonText.show();
                return;
            case C4215R.C4219id.tv_forget_password /* 2131232974 */:
                startActivity(new Intent(this.f1669h, FindPasswordTypeActivity.class));
                return;
            case C4215R.C4219id.tv_switch_account /* 2131233187 */:
                if (this.f18868x.getVisibility() == 0) {
                    this.f18868x.setVisibility(8);
                    return;
                } else {
                    this.f18868x.setVisibility(0);
                    return;
                }
            case C4215R.C4219id.tv_switch_school /* 2131233188 */:
                startActivity(new Intent(this.f1669h, SelectSchoolV2Activity.class));
                return;
            default:
                return;
        }
    }
}
