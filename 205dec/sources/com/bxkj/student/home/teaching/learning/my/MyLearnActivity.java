package com.bxkj.student.home.teaching.learning.my;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.learning.m;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MyLearnActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f20859k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayout f20860l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20861m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f20862n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f20863o;

    /* renamed from: p  reason: collision with root package name */
    private ListView f20864p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f20865q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f20866r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f20867s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f20868t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f20869u;

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
            MyLearnActivity.this.R().setVisibility(0);
            MyLearnActivity.this.A0(data);
            TextView textView = MyLearnActivity.this.f20866r;
            textView.setText("\u6211\u7684\u70b9\u8d5e(" + JsonParse.getString(data, "sumLike") + ")");
            TextView textView2 = MyLearnActivity.this.f20867s;
            textView2.setText("\u6211\u7684\u6536\u85cf(" + JsonParse.getString(data, "sumCollection") + ")");
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
            int i4 = JsonParse.getInt(data, "data");
            TextView textView = MyLearnActivity.this.f20865q;
            textView.setText("\u5f85\u5904\u7406\u4f5c\u4e1a(" + i4 + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        c(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131233195, JsonParse.getString(stringObjectMap, "termSysTerm"));
            holder.J(2131232947, "\u65f6\u957f\uff1a" + JsonParse.getString(stringObjectMap, "termSumDuration"));
            holder.J(2131233006, "\u79ef\u5206\uff1a" + JsonParse.getString(stringObjectMap, "termSumIntegral"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(Map<String, Object> data) {
        TextView textView = this.f20859k;
        textView.setText(JsonParse.getString(data, "sumDuration") + "\u5206\u949f");
        this.f20861m.setText(JsonParse.getString(data, "sumIntegral"));
        this.f20863o.setText(JsonParse.getString(data, "rank"));
        this.f20864p.setAdapter((ListAdapter) new c(this.f1656h, 2131427729, JsonParse.getList(data, "termData")));
    }

    private void s0() {
        t0();
        Http.with(this.f1656h).setObservable(((m) Http.getApiService(m.class)).r(LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    private void t0() {
        Http.with(this.f1656h).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((m) Http.getApiService(m.class)).q()).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(View view) {
        startActivity(new Intent(this.f1656h, RefuseQuestionListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(View view) {
        startActivity(new Intent(this.f1656h, MyRecordListActivity.class).putExtra("title", "\u6211\u7684\u70b9\u8d5e").putExtra("resultType", "3"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(View view) {
        startActivity(new Intent(this.f1656h, MyRecordListActivity.class).putExtra("title", "\u6211\u7684\u6536\u85cf").putExtra("resultType", "2"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(View view) {
        startActivity(new Intent(this.f1656h, MyRecordListActivity.class).putExtra("title", "\u6d4f\u89c8\u8bb0\u5f55").putExtra("resultType", "1"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(View view) {
        startActivity(new Intent(this.f1656h, MyRecordListActivity.class).putExtra("title", "\u5206\u4eab\u8bb0\u5f55").putExtra("resultType", "4"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(View view) {
        startActivity(new Intent(this.f1656h, MyIntegralListActivity.class).putExtra("title", "\u6211\u7684\u79ef\u5206").putExtra("resultType", "5"));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20865q.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.u0(view);
            }
        });
        this.f20866r.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.v0(view);
            }
        });
        this.f20867s.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.w0(view);
            }
        });
        this.f20868t.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.x0(view);
            }
        });
        this.f20869u.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.y0(view);
            }
        });
        this.f20860l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.z0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427438;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        s0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u5b66\u4e60");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20859k = (TextView) findViewById(2131232947);
        this.f20860l = (LinearLayout) findViewById(2131232199);
        this.f20861m = (TextView) findViewById(2131233006);
        this.f20862n = (LinearLayout) findViewById(2131232216);
        this.f20863o = (TextView) findViewById(2131233116);
        this.f20864p = (ListView) findViewById(2131232540);
        this.f20865q = (TextView) findViewById(2131233122);
        this.f20866r = (TextView) findViewById(2131233016);
        this.f20867s = (TextView) findViewById(2131232908);
        this.f20868t = (TextView) findViewById(2131233121);
        this.f20869u = (TextView) findViewById(2131233153);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        s0();
    }
}
