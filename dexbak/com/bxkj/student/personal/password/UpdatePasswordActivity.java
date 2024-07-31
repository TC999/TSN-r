package com.bxkj.student.personal.password;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.C3916w;
import com.bxkj.base.util.RSAUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.StatusUtil;
import com.bxkj.student.personal.login.LoginActivity;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class UpdatePasswordActivity extends BaseActivity {

    /* renamed from: k */
    private LinearLayout f18890k;

    /* renamed from: l */
    private LinearLayout f18891l;

    /* renamed from: m */
    private TextView f18892m;

    /* renamed from: n */
    private EditText f18893n;

    /* renamed from: o */
    private EditText f18894o;

    /* renamed from: p */
    private EditText f18895p;

    /* renamed from: q */
    private EditText f18896q;

    /* renamed from: r */
    private Button f18897r;

    /* renamed from: s */
    private TextView f18898s;

    /* renamed from: com.bxkj.student.personal.password.UpdatePasswordActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnClickListenerC5168a implements View.OnClickListener {
        View$OnClickListenerC5168a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            UpdatePasswordActivity.this.finish();
        }
    }

    /* renamed from: com.bxkj.student.personal.password.UpdatePasswordActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5169b extends HttpCallBack {

        /* renamed from: com.bxkj.student.personal.password.UpdatePasswordActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC5170a implements View.OnClickListener {
            View$OnClickListenerC5170a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AppManager.m57776n().m57780j();
                UpdatePasswordActivity.this.startActivity(new Intent(((BaseActivity) UpdatePasswordActivity.this).f1669h, LoginActivity.class));
            }
        }

        C5169b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) UpdatePasswordActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setLogin(false);
            iOSOneButtonDialog buttonOnClickListener = new iOSOneButtonDialog(((BaseActivity) UpdatePasswordActivity.this).f1669h).setMessage("密码修改成功，请重新登录").setButtonOnClickListener(new View$OnClickListenerC5170a());
            buttonOnClickListener.setCancelable(false);
            buttonOnClickListener.show();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18897r.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_update_password;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        TextView textView = this.f18898s;
        textView.setText("学号：" + LoginUser.getLoginUser().getAccount());
        String realName = LoginUser.getLoginUser().getRealName();
        if (!TextUtils.isEmpty(realName)) {
            if (realName.length() <= 4) {
                int intValue = C3916w.m44020a(realName.length(), 1).get(0).intValue() - 1;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < realName.toCharArray().length; i++) {
                    if (i == intValue) {
                        sb.append(realName.charAt(i));
                    } else {
                        sb.append("*");
                    }
                }
                TextView textView2 = this.f18892m;
                textView2.setText("姓名：" + ((Object) sb));
            } else {
                TextView textView3 = this.f18892m;
                textView3.setText("姓名：" + realName);
                this.f18896q.setText(realName);
                this.f18891l.setVisibility(8);
            }
        }
        if (getIntent().hasExtra("msg")) {
            new iOSOneButtonDialog(this.f1669h).setMessage(getIntent().getStringExtra("msg")).show();
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
        this.f18890k = (LinearLayout) findViewById(C4215R.C4219id.ll_name);
        this.f18892m = (TextView) findViewById(2131233040);
        this.f18893n = (EditText) findViewById(C4215R.C4219id.et_old_password);
        this.f18894o = (EditText) findViewById(C4215R.C4219id.et_password);
        this.f18895p = (EditText) findViewById(C4215R.C4219id.et_password_agn);
        this.f18896q = (EditText) findViewById(C4215R.C4219id.et_confirm_name);
        this.f18897r = (Button) findViewById(C4215R.C4219id.bt_complete);
        this.f18898s = (TextView) findViewById(C4215R.C4219id.tv_account);
        this.f18891l = (LinearLayout) findViewById(C4215R.C4219id.ll_confirm_name);
        Toolbar toolbar = (Toolbar) findViewById(C4215R.C4219id.f16009tb);
        ((TextView) findViewById(2131233204)).setText("修改密码");
        toolbar.setNavigationIcon(2131165513);
        toolbar.setNavigationOnClickListener(new View$OnClickListenerC5168a());
        try {
            toolbar.getRootView().getRootView().setBackgroundResource(C4215R.mipmap.login_bg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        StatusUtil.m42797d(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        String str;
        String trim = this.f18893n.getText().toString().trim();
        String trim2 = this.f18894o.getText().toString().trim();
        String trim3 = this.f18895p.getText().toString().trim();
        String trim4 = this.f18896q.getText().toString().trim();
        if (trim4.isEmpty()) {
            m57919h0("请输入真实姓名");
        } else if (!trim4.equals(LoginUser.getLoginUser().getRealName())) {
            m57919h0("请输入正确的姓名");
        } else if (trim.isEmpty()) {
            m57919h0("请输入旧密码");
        } else if (trim2.isEmpty()) {
            m57919h0("请输入新密码");
        } else if (trim3.isEmpty()) {
            m57919h0("请再次输入新密码");
        } else if (!trim2.equals(trim3)) {
            m57919h0("两次输入密码不一致");
        } else {
            String str2 = null;
            try {
                str = new RSAUtils().m44022a(trim);
                try {
                    str2 = new RSAUtils().m44022a(trim2);
                } catch (Exception e) {
                    e = e;
                    new iOSOneButtonDialog(this.f1669h).setMessage("修改密码异常，请联系管理员").show();
                    e.printStackTrace();
                    Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m89n0(LoginUser.getLoginUser().getUserId(), str, str2)).setDataListener(new C5169b());
                }
            } catch (Exception e2) {
                e = e2;
                str = null;
            }
            Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m89n0(LoginUser.getLoginUser().getUserId(), str, str2)).setDataListener(new C5169b());
        }
    }
}
