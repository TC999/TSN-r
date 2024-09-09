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
import com.bxkj.base.util.v;
import com.bxkj.student.common.utils.m;
import com.bxkj.student.personal.bind.WechatQQBindAccountActivity;
import com.bxkj.student.personal.password.forget.FindPasswordTypeActivity;
import com.bxkj.student.splash.SelectSchoolV2Activity;
import com.orhanobut.logger.j;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LoginActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private Toolbar f22139k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f22140l;

    /* renamed from: m  reason: collision with root package name */
    private EditText f22141m;

    /* renamed from: n  reason: collision with root package name */
    private EditText f22142n;

    /* renamed from: o  reason: collision with root package name */
    private Button f22143o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f22144p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f22145q;

    /* renamed from: r  reason: collision with root package name */
    private Button f22146r;

    /* renamed from: s  reason: collision with root package name */
    private Button f22147s;

    /* renamed from: t  reason: collision with root package name */
    private FrameLayout f22148t;

    /* renamed from: u  reason: collision with root package name */
    private CheckBox f22149u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f22150v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f22151w;

    /* renamed from: x  reason: collision with root package name */
    private LinearLayout f22152x;

    /* renamed from: y  reason: collision with root package name */
    UMAuthListener f22153y = new d();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            LoginActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ iOSTwoButtonDialog f22155a;

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
        /* renamed from: com.bxkj.student.personal.login.LoginActivity$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class C0276b implements iOSTwoButtonDialog.RightButtonOnClick {
            C0276b() {
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                LoginUser.getLoginUser().setOpenModel(true);
            }
        }

        b(final iOSTwoButtonDialog val$iOSTwoButtonDialog) {
            this.f22155a = val$iOSTwoButtonDialog;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f22155a.show();
            String trim = ((EditText) this.f22155a.findViewById(2131231264)).getText().toString().trim();
            if (trim.isEmpty()) {
                LoginActivity.this.h0("\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a");
                return;
            }
            try {
                this.f22155a.dismiss();
                if ("396436".equals(trim)) {
                    if (LoginUser.getLoginUser().isOpenModel()) {
                        new iOSTwoButtonDialog(((BaseActivity) LoginActivity.this).f1656h).setMessage("\u786e\u5b9a\u5173\u95ed\u5f00\u53d1\u8005\u6a21\u5f0f\uff1f").setRightButtonOnClickListener(new a()).show();
                    } else {
                        new iOSTwoButtonDialog(((BaseActivity) LoginActivity.this).f1656h).setMessage("\u786e\u5b9a\u6253\u5f00\u5f00\u53d1\u8005\u6a21\u5f0f\uff1f").setRightButtonOnClickListener(new C0276b()).show();
                    }
                } else {
                    new iOSOneButtonDialog(((BaseActivity) LoginActivity.this).f1656h).setMessage("\u5bc6\u7801\u9519\u8bef\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
                }
            } catch (Exception e4) {
                new iOSOneButtonDialog(((BaseActivity) LoginActivity.this).f1656h).setMessage("\u9a8c\u8bc1\u5bc6\u7801\u5f02\u5e38\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            com.bxkj.student.personal.login.c.b(((BaseActivity) LoginActivity.this).f1657i, data);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d implements UMAuthListener {
        d() {
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(((BaseActivity) LoginActivity.this).f1656h, "\u60a8\u53d6\u6d88\u4e86\u767b\u5f55", 1).show();
            LoginActivity.this.f22146r.setEnabled(true);
            LoginActivity.this.f22147s.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            j.c("platform=" + platform.name());
            j.c("data=" + data);
            String str = platform == SHARE_MEDIA.WEIXIN ? "1" : "0";
            data.put("login_type", str);
            LoginActivity.this.E0(str, data);
            LoginActivity.this.f22146r.setEnabled(true);
            LoginActivity.this.f22147s.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(SHARE_MEDIA platform, int action, Throwable t3) {
            j.c(t3.getMessage());
            j.c("action=" + action);
            Toast.makeText(((BaseActivity) LoginActivity.this).f1656h, "\u767b\u5f55\u5931\u8d25,\u8bf7\u7a0d\u540e\u518d\u8bd5", 1).show();
            LoginActivity.this.f22146r.setEnabled(true);
            LoginActivity.this.f22147s.setEnabled(true);
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(SHARE_MEDIA platform) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f22161a;

        e(final Map val$data) {
            this.f22161a = val$data;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            LoginActivity.this.f22146r.setEnabled(true);
            LoginActivity.this.f22147s.setEnabled(true);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            if (status == 201) {
                LoginActivity.this.startActivity(new Intent(((BaseActivity) LoginActivity.this).f1656h, WechatQQBindAccountActivity.class).putExtra("openid", (String) this.f22161a.get("openid")).putExtra("name", (String) this.f22161a.get("name")).putExtra("iconurl", (String) this.f22161a.get("iconurl")).putExtra("login_type", (String) this.f22161a.get("login_type")));
            } else {
                new iOSOneButtonDialog(((BaseActivity) LoginActivity.this).f1656h).setMessage(msg).show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            com.bxkj.student.personal.login.c.b(((BaseActivity) LoginActivity.this).f1657i, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(iOSTwoButtonDialog iostwobuttondialog) {
        LoginUser.getLoginUser().setAgreement(true);
        this.f22149u.setChecked(true);
        iostwobuttondialog.dismiss();
    }

    private void B0() {
        String trim = this.f22141m.getText().toString().trim();
        String trim2 = this.f22142n.getText().toString().trim();
        if (trim.isEmpty()) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u8f93\u5165\u8d26\u53f7").show();
        } else if (trim2.isEmpty()) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u8f93\u5165\u5bc6\u7801").show();
        } else if (!this.f22149u.isChecked()) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u52fe\u9009\u540c\u610f\u7528\u6237\u534f\u8bae").show();
        } else {
            try {
                Http.with(this.f1656h).setLoadingMessage("\u6b63\u5728\u767b\u5f55").setObservable(((w.a) Http.getApiService(w.a.class)).z(trim, new v().a(trim2))).setDataListener(new c());
            } catch (Exception e4) {
                new iOSOneButtonDialog(this.f1656h).setMessage("\u767b\u5f55\u5f02\u5e38\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
                e4.printStackTrace();
            }
        }
    }

    private void C0() {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1656h);
        iostwobuttondialog.setMessage("\u5f00\u53d1\u8005\u6a21\u5f0f\u4e13\u4f9b\u5f00\u53d1\u8005\u8c03\u8bd5\u4f7f\u7528\uff0c\u8bf7\u8c28\u614e\u5f00\u542f\uff01\u5f00\u5173\u5f00\u53d1\u8005\u6a21\u5f0f\u9700\u8981\u9a8c\u8bc1\u4f60\u7684\u8eab\u4efd\uff0c\u8bf7\u8f93\u5165\u5bc6\u7801\u8fdb\u884c\u9a8c\u8bc1").setCenterCustomView(2131427593).setRightButtonOnClickListener(new b(iostwobuttondialog)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(String type, Map<String, String> data) {
        j.c("data=" + data);
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).D0(type, data.get("openid"))).setDataListener(new e(data));
    }

    private void x0() {
        this.f22152x = (LinearLayout) findViewById(2131232162);
        this.f22151w = (TextView) findViewById(2131233187);
        this.f22141m = (EditText) findViewById(2131231250);
        this.f22142n = (EditText) findViewById(2131231264);
        this.f22143o = (Button) findViewById(2131230984);
        this.f22144p = (TextView) findViewById(2131232974);
        this.f22145q = (TextView) findViewById(2131233188);
        this.f22146r = (Button) findViewById(2131231022);
        this.f22147s = (Button) findViewById(2131230997);
        this.f22148t = (FrameLayout) findViewById(2131232179);
        this.f22139k = (Toolbar) findViewById(2131232711);
        this.f22140l = (TextView) findViewById(2131233204);
        this.f22149u = (CheckBox) findViewById(2131231080);
        this.f22150v = (TextView) findViewById(2131232842);
    }

    private void y0() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=" + this.f22148t.getTag().toString())));
        } catch (Exception unused) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u5148\u5b89\u88c5QQ\uff01").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean z0(View view) {
        C0();
        return false;
    }

    public void D0(String qq) {
        this.f22148t.setTag(qq);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22150v.setOnClickListener(this);
        this.f22143o.setOnClickListener(this);
        this.f22144p.setOnClickListener(this);
        this.f22146r.setOnClickListener(this);
        this.f22147s.setOnClickListener(this);
        this.f22145q.setOnClickListener(this);
        this.f22148t.setOnClickListener(this);
        findViewById(2131231451).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.bxkj.student.personal.login.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean z02;
                z02 = LoginActivity.this.z0(view);
                return z02;
            }
        });
        this.f22151w.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427431;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f22141m.setText(LoginUser.getLoginUser().getAccount());
        this.f22150v.getPaint().setFlags(8);
        this.f22150v.getPaint().setAntiAlias(true);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(16);
        x0();
        try {
            this.f22139k.getRootView().getRootView().setBackgroundResource(2131558821);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        m.d(this);
        this.f22140l.setText(LoginUser.getLoginUser().getSchoolName());
        this.f22139k.setNavigationIcon(2131165513);
        this.f22139k.setNavigationOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        switch (v3.getId()) {
            case 2131230984:
                B0();
                return;
            case 2131230997:
                if (!this.f22149u.isChecked()) {
                    new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u52fe\u9009\u540c\u610f\u7528\u6237\u534f\u8bae").show();
                    return;
                }
                UMShareAPI uMShareAPI = UMShareAPI.get(this.f1656h);
                SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
                if (!uMShareAPI.isInstall(this, share_media)) {
                    h0("\u60a8\u8fd8\u672a\u5b89\u88c5QQ\u6216QQ\u7248\u672c\u8fc7\u4f4e");
                    return;
                }
                this.f22147s.setEnabled(false);
                UMShareAPI.get(this.f1656h).getPlatformInfo(this, share_media, this.f22153y);
                return;
            case 2131231022:
                UMShareAPI uMShareAPI2 = UMShareAPI.get(this.f1656h);
                SHARE_MEDIA share_media2 = SHARE_MEDIA.WEIXIN;
                if (!uMShareAPI2.isInstall(this, share_media2)) {
                    h0("\u60a8\u8fd8\u672a\u5b89\u88c5\u5fae\u4fe1\u6216\u5fae\u4fe1\u7248\u672c\u8fc7\u4f4e");
                    return;
                } else if (!this.f22149u.isChecked()) {
                    new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u52fe\u9009\u540c\u610f\u7528\u6237\u534f\u8bae").show();
                    return;
                } else {
                    this.f22146r.setEnabled(false);
                    UMShareAPI.get(this.f1656h).getPlatformInfo(this, share_media2, this.f22153y);
                    return;
                }
            case 2131232179:
                y0();
                return;
            case 2131232842:
                final iOSTwoButtonDialog rightButtonText = new iOSTwoButtonDialog(this.f1656h).setTitle("\u7528\u6237\u534f\u8bae").setCenterCustomView(2131427408).setLeftButtonText("\u4ec5\u6d4f\u89c8").setRightButtonText("\u540c\u610f");
                ((SmartWebView) rightButtonText.findViewById(2131232631)).j("https://www.boxkj.com/resources/user_agreement_info.html");
                rightButtonText.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.personal.login.b
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        LoginActivity.this.A0(rightButtonText);
                    }
                });
                rightButtonText.show();
                return;
            case 2131232974:
                startActivity(new Intent(this.f1656h, FindPasswordTypeActivity.class));
                return;
            case 2131233187:
                if (this.f22152x.getVisibility() == 0) {
                    this.f22152x.setVisibility(8);
                    return;
                } else {
                    this.f22152x.setVisibility(0);
                    return;
                }
            case 2131233188:
                startActivity(new Intent(this.f1656h, SelectSchoolV2Activity.class));
                return;
            default:
                return;
        }
    }
}
