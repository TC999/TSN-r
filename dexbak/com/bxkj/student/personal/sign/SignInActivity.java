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
import com.bxkj.student.C4215R;
import java.util.ArrayList;
import java.util.Map;
import p635q.MainApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SignInActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f18925k;

    /* renamed from: l */
    private Button f18926l;

    /* renamed from: m */
    private CycleViewPager f18927m;

    /* renamed from: com.bxkj.student.personal.sign.SignInActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5183a implements BaseActivity.InterfaceC1107c {
        C5183a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            SignInActivity.this.startActivity(new Intent(((BaseActivity) SignInActivity.this).f1669h, SignRecordListActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.sign.SignInActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5184b extends HttpCallBack {
        C5184b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SignInActivity.this.m57932R().setVisibility(0);
            TextView textView = SignInActivity.this.f18925k;
            textView.setText("我的积分：" + JsonParse.getString(data, "sumIntegral"));
            boolean z = JsonParse.getBoolean(data, "isSign");
            SignInActivity.this.f18926l.setEnabled(z ^ true);
            if (z) {
                SignInActivity.this.f18926l.setText("今日已签到");
            } else {
                SignInActivity.this.f18926l.setText("立即签到");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.sign.SignInActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5185c extends HttpCallBack {
        C5185c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SignInActivity.this.mo39374T();
            new iOSOneButtonDialog(((BaseActivity) SignInActivity.this).f1669h).setCenterCustomView(C4215R.C4221layout.dialog_sign_success).show();
        }
    }

    /* renamed from: m0 */
    private void m40384m0() {
        Http.with(this.f1669h).hideSuccessMessage().setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2271f(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getAccount())).setDataListener(new C5185c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18926l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_sign_in;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        Http.with(this.f1669h).setObservable(((MainApiService) Http.getApiService(MainApiService.class)).m2263n(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getRealName())).setDataListener(new C5184b());
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        this.f18927m.setData(arrayList, null);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("签到领积分");
        m57921f0(ContextCompat.getColor(this, 2131034196));
        m57923d0("记录", new C5183a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18925k = (TextView) findViewById(2131233146);
        this.f18926l = (Button) findViewById(C4215R.C4219id.bt_signs);
        this.f18927m = (CycleViewPager) findViewById(2131231170);
        m57932R().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131231010) {
            return;
        }
        m40384m0();
    }
}
