package com.bxkj.student.personal.password;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.RSAUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.StatusUtil;
import com.bxkj.student.personal.login.LoginActivity;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class InputNewPasswordActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f18882k;

    /* renamed from: l */
    private EditText f18883l;

    /* renamed from: m */
    private EditText f18884m;

    /* renamed from: n */
    private Button f18885n;

    /* renamed from: o */
    private String f18886o;

    /* renamed from: com.bxkj.student.personal.password.InputNewPasswordActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnClickListenerC5165a implements View.OnClickListener {
        View$OnClickListenerC5165a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            InputNewPasswordActivity.this.finish();
        }
    }

    /* renamed from: com.bxkj.student.personal.password.InputNewPasswordActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5166b extends HttpCallBack {

        /* renamed from: com.bxkj.student.personal.password.InputNewPasswordActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC5167a implements View.OnClickListener {
            View$OnClickListenerC5167a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AppManager.m57776n().m57780j();
                InputNewPasswordActivity.this.startActivity(new Intent(((BaseActivity) InputNewPasswordActivity.this).f1669h, LoginActivity.class));
            }
        }

        C5166b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) InputNewPasswordActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setLogin(false);
            iOSOneButtonDialog buttonOnClickListener = new iOSOneButtonDialog(((BaseActivity) InputNewPasswordActivity.this).f1669h).setMessage("密码重置成功，请登录").setButtonOnClickListener(new View$OnClickListenerC5167a());
            buttonOnClickListener.setCancelable(false);
            buttonOnClickListener.show();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18885n.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_input_new_password;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("name")) {
            this.f18886o = getIntent().getStringExtra("userNum");
            String stringExtra = getIntent().getStringExtra("name");
            TextView textView = this.f18882k;
            textView.setText(this.f18886o + "--" + stringExtra);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        m57922e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18882k = (TextView) findViewById(C4215R.C4219id.tv_account);
        this.f18883l = (EditText) findViewById(C4215R.C4219id.et_password);
        this.f18884m = (EditText) findViewById(C4215R.C4219id.et_password_agn);
        this.f18885n = (Button) findViewById(C4215R.C4219id.bt_login);
        Toolbar toolbar = (Toolbar) findViewById(C4215R.C4219id.f16009tb);
        ((TextView) findViewById(2131233204)).setText("设置新密码");
        toolbar.setNavigationIcon(2131165513);
        toolbar.setNavigationOnClickListener(new View$OnClickListenerC5165a());
        try {
            toolbar.getRootView().getRootView().setBackgroundResource(C4215R.mipmap.login_bg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StatusUtil.m42797d(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        String trim = this.f18883l.getText().toString().trim();
        String trim2 = this.f18884m.getText().toString().trim();
        if (trim.isEmpty()) {
            m57919h0("请输入新密码");
        } else if (trim2.isEmpty()) {
            m57919h0("请再次输入新密码");
        } else if (!trim.equals(trim2)) {
            m57919h0("两次输入密码不一致");
        } else {
            String str = null;
            try {
                str = new RSAUtils().m44022a(trim);
            } catch (Exception e) {
                new iOSOneButtonDialog(this.f1669h).setMessage("设置新密码异常，请联系管理员").show();
                e.printStackTrace();
            }
            Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m85o1(this.f18886o, str)).setDataListener(new C5166b());
        }
    }
}
