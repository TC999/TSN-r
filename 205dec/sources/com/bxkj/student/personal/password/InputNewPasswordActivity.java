package com.bxkj.student.personal.password;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.v;
import com.bxkj.student.common.utils.m;
import com.bxkj.student.personal.login.LoginActivity;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class InputNewPasswordActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f22166k;

    /* renamed from: l  reason: collision with root package name */
    private EditText f22167l;

    /* renamed from: m  reason: collision with root package name */
    private EditText f22168m;

    /* renamed from: n  reason: collision with root package name */
    private Button f22169n;

    /* renamed from: o  reason: collision with root package name */
    private String f22170o;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            InputNewPasswordActivity.this.finish();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                cn.bluemobi.dylan.base.utils.a.n().j();
                InputNewPasswordActivity.this.startActivity(new Intent(((BaseActivity) InputNewPasswordActivity.this).f1656h, LoginActivity.class));
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) InputNewPasswordActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setLogin(false);
            iOSOneButtonDialog buttonOnClickListener = new iOSOneButtonDialog(((BaseActivity) InputNewPasswordActivity.this).f1656h).setMessage("\u5bc6\u7801\u91cd\u7f6e\u6210\u529f\uff0c\u8bf7\u767b\u5f55").setButtonOnClickListener(new a());
            buttonOnClickListener.setCancelable(false);
            buttonOnClickListener.show();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22169n.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427416;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("name")) {
            this.f22170o = getIntent().getStringExtra("userNum");
            String stringExtra = getIntent().getStringExtra("name");
            TextView textView = this.f22166k;
            textView.setText(this.f22170o + "--" + stringExtra);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22166k = (TextView) findViewById(2131232838);
        this.f22167l = (EditText) findViewById(2131231264);
        this.f22168m = (EditText) findViewById(2131231265);
        this.f22169n = (Button) findViewById(2131230984);
        Toolbar toolbar = (Toolbar) findViewById(2131232711);
        ((TextView) findViewById(2131233204)).setText("\u8bbe\u7f6e\u65b0\u5bc6\u7801");
        toolbar.setNavigationIcon(2131165513);
        toolbar.setNavigationOnClickListener(new a());
        try {
            toolbar.getRootView().getRootView().setBackgroundResource(2131558821);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        m.d(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        String trim = this.f22167l.getText().toString().trim();
        String trim2 = this.f22168m.getText().toString().trim();
        if (trim.isEmpty()) {
            h0("\u8bf7\u8f93\u5165\u65b0\u5bc6\u7801");
        } else if (trim2.isEmpty()) {
            h0("\u8bf7\u518d\u6b21\u8f93\u5165\u65b0\u5bc6\u7801");
        } else if (!trim.equals(trim2)) {
            h0("\u4e24\u6b21\u8f93\u5165\u5bc6\u7801\u4e0d\u4e00\u81f4");
        } else {
            String str = null;
            try {
                str = new v().a(trim);
            } catch (Exception e4) {
                new iOSOneButtonDialog(this.f1656h).setMessage("\u8bbe\u7f6e\u65b0\u5bc6\u7801\u5f02\u5e38\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
                e4.printStackTrace();
            }
            Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).o1(this.f22170o, str)).setDataListener(new b());
        }
    }
}
