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
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.v;
import com.bxkj.base.util.w;
import com.bxkj.student.common.utils.m;
import com.bxkj.student.personal.login.LoginActivity;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class UpdatePasswordActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private LinearLayout f22174k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayout f22175l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f22176m;

    /* renamed from: n  reason: collision with root package name */
    private EditText f22177n;

    /* renamed from: o  reason: collision with root package name */
    private EditText f22178o;

    /* renamed from: p  reason: collision with root package name */
    private EditText f22179p;

    /* renamed from: q  reason: collision with root package name */
    private EditText f22180q;

    /* renamed from: r  reason: collision with root package name */
    private Button f22181r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f22182s;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            UpdatePasswordActivity.this.finish();
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
                UpdatePasswordActivity.this.startActivity(new Intent(((BaseActivity) UpdatePasswordActivity.this).f1656h, LoginActivity.class));
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) UpdatePasswordActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setLogin(false);
            iOSOneButtonDialog buttonOnClickListener = new iOSOneButtonDialog(((BaseActivity) UpdatePasswordActivity.this).f1656h).setMessage("\u5bc6\u7801\u4fee\u6539\u6210\u529f\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55").setButtonOnClickListener(new a());
            buttonOnClickListener.setCancelable(false);
            buttonOnClickListener.show();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22181r.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427504;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        TextView textView = this.f22182s;
        textView.setText("\u5b66\u53f7\uff1a" + LoginUser.getLoginUser().getAccount());
        String realName = LoginUser.getLoginUser().getRealName();
        if (!TextUtils.isEmpty(realName)) {
            if (realName.length() <= 4) {
                int intValue = w.a(realName.length(), 1).get(0).intValue() - 1;
                StringBuilder sb = new StringBuilder();
                for (int i4 = 0; i4 < realName.toCharArray().length; i4++) {
                    if (i4 == intValue) {
                        sb.append(realName.charAt(i4));
                    } else {
                        sb.append("*");
                    }
                }
                TextView textView2 = this.f22176m;
                textView2.setText("\u59d3\u540d\uff1a" + ((Object) sb));
            } else {
                TextView textView3 = this.f22176m;
                textView3.setText("\u59d3\u540d\uff1a" + realName);
                this.f22180q.setText(realName);
                this.f22175l.setVisibility(8);
            }
        }
        if (getIntent().hasExtra("msg")) {
            new iOSOneButtonDialog(this.f1656h).setMessage(getIntent().getStringExtra("msg")).show();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        e0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22174k = (LinearLayout) findViewById(2131232207);
        this.f22176m = (TextView) findViewById(2131233040);
        this.f22177n = (EditText) findViewById(2131231263);
        this.f22178o = (EditText) findViewById(2131231264);
        this.f22179p = (EditText) findViewById(2131231265);
        this.f22180q = (EditText) findViewById(2131231255);
        this.f22181r = (Button) findViewById(2131230968);
        this.f22182s = (TextView) findViewById(2131232838);
        this.f22175l = (LinearLayout) findViewById(2131232178);
        Toolbar toolbar = (Toolbar) findViewById(2131232711);
        ((TextView) findViewById(2131233204)).setText("\u4fee\u6539\u5bc6\u7801");
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
        String str;
        String trim = this.f22177n.getText().toString().trim();
        String trim2 = this.f22178o.getText().toString().trim();
        String trim3 = this.f22179p.getText().toString().trim();
        String trim4 = this.f22180q.getText().toString().trim();
        if (trim4.isEmpty()) {
            h0("\u8bf7\u8f93\u5165\u771f\u5b9e\u59d3\u540d");
        } else if (!trim4.equals(LoginUser.getLoginUser().getRealName())) {
            h0("\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u59d3\u540d");
        } else if (trim.isEmpty()) {
            h0("\u8bf7\u8f93\u5165\u65e7\u5bc6\u7801");
        } else if (trim2.isEmpty()) {
            h0("\u8bf7\u8f93\u5165\u65b0\u5bc6\u7801");
        } else if (trim3.isEmpty()) {
            h0("\u8bf7\u518d\u6b21\u8f93\u5165\u65b0\u5bc6\u7801");
        } else if (!trim2.equals(trim3)) {
            h0("\u4e24\u6b21\u8f93\u5165\u5bc6\u7801\u4e0d\u4e00\u81f4");
        } else {
            String str2 = null;
            try {
                str = new v().a(trim);
                try {
                    str2 = new v().a(trim2);
                } catch (Exception e4) {
                    e = e4;
                    new iOSOneButtonDialog(this.f1656h).setMessage("\u4fee\u6539\u5bc6\u7801\u5f02\u5e38\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
                    e.printStackTrace();
                    Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).n0(LoginUser.getLoginUser().getUserId(), str, str2)).setDataListener(new b());
                }
            } catch (Exception e5) {
                e = e5;
                str = null;
            }
            Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).n0(LoginUser.getLoginUser().getUserId(), str, str2)).setDataListener(new b());
        }
    }
}
