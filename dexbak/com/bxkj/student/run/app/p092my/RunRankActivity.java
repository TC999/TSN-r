package com.bxkj.student.run.app.p092my;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.RunApiService;
import java.util.Map;

/* renamed from: com.bxkj.student.run.app.my.RunRankActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RunRankActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f19225k;

    /* renamed from: l */
    private TextView f19226l;

    /* renamed from: m */
    private TextView f19227m;

    /* renamed from: n */
    private TextView f19228n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.my.RunRankActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5272a extends HttpCallBack {
        C5272a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RunRankActivity.this.f19225k.setText(JsonParse.getString(data, "clazzRank"));
            RunRankActivity.this.f19226l.setText(JsonParse.getString(data, "majorRank"));
            RunRankActivity.this.f19227m.setText(JsonParse.getString(data, "deptRank"));
            RunRankActivity.this.f19228n.setText(JsonParse.getString(data, "schoolRank"));
        }
    }

    /* renamed from: m0 */
    private void m39935m0() {
        Http.with(this.f1669h).setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40118c(LoginUser.getLoginUser().getUserId())).setDataListener(new C5272a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_run_rank;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m39935m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("跑步排名");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19225k = (TextView) findViewById(C4215R.C4219id.tv_run_class_rank);
        this.f19226l = (TextView) findViewById(C4215R.C4219id.tv_run_major_rank);
        this.f19227m = (TextView) findViewById(C4215R.C4219id.tv_run_department_rank);
        this.f19228n = (TextView) findViewById(C4215R.C4219id.tv_run_school_rank);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
