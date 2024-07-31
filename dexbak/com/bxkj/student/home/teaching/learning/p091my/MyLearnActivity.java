package com.bxkj.student.home.teaching.learning.p091my;

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
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import java.util.List;
import java.util.Map;

/* renamed from: com.bxkj.student.home.teaching.learning.my.MyLearnActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MyLearnActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f17516k;

    /* renamed from: l */
    private LinearLayout f17517l;

    /* renamed from: m */
    private TextView f17518m;

    /* renamed from: n */
    private LinearLayout f17519n;

    /* renamed from: o */
    private TextView f17520o;

    /* renamed from: p */
    private ListView f17521p;

    /* renamed from: q */
    private TextView f17522q;

    /* renamed from: r */
    private TextView f17523r;

    /* renamed from: s */
    private TextView f17524s;

    /* renamed from: t */
    private TextView f17525t;

    /* renamed from: u */
    private TextView f17526u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.my.MyLearnActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4695a extends HttpCallBack {
        C4695a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyLearnActivity.this.m57932R().setVisibility(0);
            MyLearnActivity.this.m41603A0(data);
            TextView textView = MyLearnActivity.this.f17523r;
            textView.setText("我的点赞(" + JsonParse.getString(data, "sumLike") + ")");
            TextView textView2 = MyLearnActivity.this.f17524s;
            textView2.setText("我的收藏(" + JsonParse.getString(data, "sumCollection") + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.my.MyLearnActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4696b extends HttpCallBack {
        C4696b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i = JsonParse.getInt(data, "data");
            TextView textView = MyLearnActivity.this.f17522q;
            textView.setText("待处理作业(" + i + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.my.MyLearnActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4697c extends CommonAdapter<Map<String, Object>> {
        C4697c(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_term, JsonParse.getString(stringObjectMap, "termSysTerm"));
            holder.m57874J(C4215R.C4219id.tv_duration, "时长：" + JsonParse.getString(stringObjectMap, "termSumDuration"));
            holder.m57874J(C4215R.C4219id.tv_integral, "积分：" + JsonParse.getString(stringObjectMap, "termSumIntegral"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public void m41603A0(Map<String, Object> data) {
        TextView textView = this.f17516k;
        textView.setText(JsonParse.getString(data, "sumDuration") + "分钟");
        this.f17518m.setText(JsonParse.getString(data, "sumIntegral"));
        this.f17520o.setText(JsonParse.getString(data, "rank"));
        this.f17521p.setAdapter((ListAdapter) new C4697c(this.f1669h, C4215R.C4221layout.item_for_my_term_learn, JsonParse.getList(data, "termData")));
    }

    /* renamed from: s0 */
    private void m41592s0() {
        m41591t0();
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41624r(LoginUser.getLoginUser().getUserId())).setDataListener(new C4695a());
    }

    /* renamed from: t0 */
    private void m41591t0() {
        Http.with(this.f1669h).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41625q()).setDataListener(new C4696b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void m41590u0(View view) {
        startActivity(new Intent(this.f1669h, RefuseQuestionListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void m41589v0(View view) {
        startActivity(new Intent(this.f1669h, MyRecordListActivity.class).putExtra("title", "我的点赞").putExtra("resultType", "3"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void m41588w0(View view) {
        startActivity(new Intent(this.f1669h, MyRecordListActivity.class).putExtra("title", "我的收藏").putExtra("resultType", "2"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void m41587x0(View view) {
        startActivity(new Intent(this.f1669h, MyRecordListActivity.class).putExtra("title", "浏览记录").putExtra("resultType", "1"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void m41586y0(View view) {
        startActivity(new Intent(this.f1669h, MyRecordListActivity.class).putExtra("title", "分享记录").putExtra("resultType", "4"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ void m41585z0(View view) {
        startActivity(new Intent(this.f1669h, MyIntegralListActivity.class).putExtra("title", "我的积分").putExtra("resultType", "5"));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17522q.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.m41590u0(view);
            }
        });
        this.f17523r.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.m41589v0(view);
            }
        });
        this.f17524s.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.m41588w0(view);
            }
        });
        this.f17525t.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.m41587x0(view);
            }
        });
        this.f17526u.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.m41586y0(view);
            }
        });
        this.f17517l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyLearnActivity.this.m41585z0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_my_learn;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        m41592s0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的学习");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17516k = (TextView) findViewById(C4215R.C4219id.tv_duration);
        this.f17517l = (LinearLayout) findViewById(C4215R.C4219id.ll_integral);
        this.f17518m = (TextView) findViewById(C4215R.C4219id.tv_integral);
        this.f17519n = (LinearLayout) findViewById(C4215R.C4219id.ll_rank);
        this.f17520o = (TextView) findViewById(2131233116);
        this.f17521p = (ListView) findViewById(2131232540);
        this.f17522q = (TextView) findViewById(C4215R.C4219id.tv_refuse_work);
        this.f17523r = (TextView) findViewById(C4215R.C4219id.tv_like);
        this.f17524s = (TextView) findViewById(C4215R.C4219id.tv_collect);
        this.f17525t = (TextView) findViewById(C4215R.C4219id.tv_record);
        this.f17526u = (TextView) findViewById(C4215R.C4219id.tv_share);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        m41592s0();
    }
}
