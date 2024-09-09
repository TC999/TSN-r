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
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ContactCustomerServiceActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f22117k;

    /* renamed from: l  reason: collision with root package name */
    private EditText f22118l;

    /* renamed from: m  reason: collision with root package name */
    private EditText f22119m;

    /* renamed from: n  reason: collision with root package name */
    private Button f22120n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22121a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f22122b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f22123c;

        a(final String val$name, final String val$number, final String val$phone) {
            this.f22121a = val$name;
            this.f22122b = val$number;
            this.f22123c = val$phone;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setTempUserId(JsonParse.getString(data, "id"));
            LoginUser.getLoginUser().setTempUserName(this.f22121a);
            LoginUser.getLoginUser().setTempUserNumber(this.f22122b);
            LoginUser.getLoginUser().setTempUserPhone(this.f22123c);
            ContactCustomerServiceActivity.this.startActivity(new Intent(((BaseActivity) ContactCustomerServiceActivity.this).f1656h, ContactCustomerActivity.class));
            ContactCustomerServiceActivity.this.finish();
        }
    }

    private void k0() {
        String trim = this.f22117k.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.f1656h).setMessage(this.f22117k.getHint().toString()).show();
            return;
        }
        String trim2 = this.f22118l.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            new iOSOneButtonDialog(this.f1656h).setMessage(this.f22118l.getHint().toString()).show();
            return;
        }
        String trim3 = this.f22119m.getText().toString().trim();
        if (TextUtils.isEmpty(trim3)) {
            new iOSOneButtonDialog(this.f1656h).setMessage(this.f22119m.getHint().toString()).show();
        } else if (trim3.length() != 11) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u624b\u673a\u53f7\u7801").show();
        } else {
            Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).A0(trim2, trim, trim3)).setDataListener(new a(trim, trim2, trim3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(View view) {
        k0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22120n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.customer.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactCustomerServiceActivity.this.l0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427389;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8bf7\u8f93\u5165\u8054\u7cfb\u65b9\u5f0f");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22117k = (EditText) findViewById(2131231260);
        this.f22118l = (EditText) findViewById(2131231262);
        this.f22119m = (EditText) findViewById(2131231266);
        this.f22120n = (Button) findViewById(2131230969);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
