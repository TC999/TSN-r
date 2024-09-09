package com.bxkj.student.run.app.my;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RunRankActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f22462k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f22463l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f22464m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f22465n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RunRankActivity.this.f22462k.setText(JsonParse.getString(data, "clazzRank"));
            RunRankActivity.this.f22463l.setText(JsonParse.getString(data, "majorRank"));
            RunRankActivity.this.f22464m.setText(JsonParse.getString(data, "deptRank"));
            RunRankActivity.this.f22465n.setText(JsonParse.getString(data, "schoolRank"));
        }
    }

    private void m0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).c(LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427477;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8dd1\u6b65\u6392\u540d");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22462k = (TextView) findViewById(2131233136);
        this.f22463l = (TextView) findViewById(2131233138);
        this.f22464m = (TextView) findViewById(2131233137);
        this.f22465n = (TextView) findViewById(2131233139);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
