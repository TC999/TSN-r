package com.bxkj.student.personal.customer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ContactCustomerServiceActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f18833k;

    /* renamed from: l */
    private EditText f18834l;

    /* renamed from: m */
    private EditText f18835m;

    /* renamed from: n */
    private Button f18836n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.customer.ContactCustomerServiceActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5148a extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ String f18837a;

        /* renamed from: b */
        final /* synthetic */ String f18838b;

        /* renamed from: c */
        final /* synthetic */ String f18839c;

        C5148a(final String val$name, final String val$number, final String val$phone) {
            this.f18837a = val$name;
            this.f18838b = val$number;
            this.f18839c = val$phone;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setTempUserId(JsonParse.getString(data, "id"));
            LoginUser.getLoginUser().setTempUserName(this.f18837a);
            LoginUser.getLoginUser().setTempUserNumber(this.f18838b);
            LoginUser.getLoginUser().setTempUserPhone(this.f18839c);
            ContactCustomerServiceActivity.this.startActivity(new Intent(((BaseActivity) ContactCustomerServiceActivity.this).f1669h, ContactCustomerActivity.class));
            ContactCustomerServiceActivity.this.finish();
        }
    }

    /* renamed from: k0 */
    private void m40459k0() {
        String trim = this.f18833k.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.f1669h).setMessage(this.f18833k.getHint().toString()).show();
            return;
        }
        String trim2 = this.f18834l.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            new iOSOneButtonDialog(this.f1669h).setMessage(this.f18834l.getHint().toString()).show();
            return;
        }
        String trim3 = this.f18835m.getText().toString().trim();
        if (TextUtils.isEmpty(trim3)) {
            new iOSOneButtonDialog(this.f1669h).setMessage(this.f18835m.getHint().toString()).show();
        } else if (trim3.length() != 11) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请输入正确的手机号码").show();
        } else {
            Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m188A0(trim2, trim, trim3)).setDataListener(new C5148a(trim, trim2, trim3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public /* synthetic */ void m40458l0(View view) {
        m40459k0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18836n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.customer.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactCustomerServiceActivity.this.m40458l0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_contact_customer;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("请输入联系方式");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18833k = (EditText) findViewById(C4215R.C4219id.et_name);
        this.f18834l = (EditText) findViewById(2131231262);
        this.f18835m = (EditText) findViewById(2131231266);
        this.f18836n = (Button) findViewById(C4215R.C4219id.bt_contact_customer);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
