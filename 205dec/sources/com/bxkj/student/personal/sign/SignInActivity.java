package com.bxkj.student.personal.sign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.CycleViewPager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import java.util.ArrayList;
import java.util.Map;
import q.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SignInActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f22209k;

    /* renamed from: l  reason: collision with root package name */
    private Button f22210l;

    /* renamed from: m  reason: collision with root package name */
    private CycleViewPager f22211m;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            SignInActivity.this.startActivity(new Intent(((BaseActivity) SignInActivity.this).f1656h, SignRecordListActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SignInActivity.this.R().setVisibility(0);
            TextView textView = SignInActivity.this.f22209k;
            textView.setText("\u6211\u7684\u79ef\u5206\uff1a" + JsonParse.getString(data, "sumIntegral"));
            boolean z3 = JsonParse.getBoolean(data, "isSign");
            SignInActivity.this.f22210l.setEnabled(z3 ^ true);
            if (z3) {
                SignInActivity.this.f22210l.setText("\u4eca\u65e5\u5df2\u7b7e\u5230");
            } else {
                SignInActivity.this.f22210l.setText("\u7acb\u5373\u7b7e\u5230");
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
            SignInActivity.this.T();
            new iOSOneButtonDialog(((BaseActivity) SignInActivity.this).f1656h).setCenterCustomView(2131427605).show();
        }
    }

    private void m0() {
        Http.with(this.f1656h).hideSuccessMessage().setObservable(((f) Http.getApiService(f.class)).f(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getAccount())).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22210l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427493;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        Http.with(this.f1656h).setObservable(((f) Http.getApiService(f.class)).n(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getRealName())).setDataListener(new b());
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        this.f22211m.setData(arrayList, null);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7b7e\u5230\u9886\u79ef\u5206");
        f0(ContextCompat.getColor(this, 2131034196));
        d0("\u8bb0\u5f55", new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22209k = (TextView) findViewById(2131233146);
        this.f22210l = (Button) findViewById(2131231010);
        this.f22211m = (CycleViewPager) findViewById(2131231170);
        R().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131231010) {
            return;
        }
        m0();
    }
}
