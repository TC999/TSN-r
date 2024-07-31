package com.bxkj.student.home.teaching.exam.record;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.exam.record.ExamRecordActivity;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ExamRecordActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f16904k;

    /* renamed from: l */
    private TextView f16905l;

    /* renamed from: m */
    private TextView f16906m;

    /* renamed from: n */
    private TextView f16907n;

    /* renamed from: o */
    private TextView f16908o;

    /* renamed from: p */
    private TextView f16909p;

    /* renamed from: q */
    private EmptyRecyclerView f16910q;

    /* renamed from: r */
    private TextView f16911r;

    /* renamed from: s */
    private List<Map<String, Object>> f16912s;

    /* renamed from: t */
    private String f16913t;

    /* renamed from: u */
    private CommonAdapter<Map<String, Object>> f16914u;

    /* renamed from: v */
    private int f16915v = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.record.ExamRecordActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4500a extends CommonAdapter<Map<String, Object>> {
        C4500a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: q */
        public /* synthetic */ void m42167q(ViewHolder viewHolder, Map map) {
            ExamRecordActivity.this.m42173q0(viewHolder.m57864f(), JsonParse.getString(map, "stuId"), JsonParse.getString(map, "identify"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: r */
        public /* synthetic */ void m42166r(final ViewHolder viewHolder, final Map map, View view) {
            new iOSTwoButtonDialog(this.f1721a).setMessage("确定要删除吗？").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.exam.record.c
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    ExamRecordActivity.C4500a.this.m42167q(viewHolder, map);
                }
            }).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: s */
        public /* synthetic */ void m42165s(boolean z, Map map, View view) {
            if (z) {
                ExamRecordActivity.this.startActivity(new Intent(this.f1721a, ExamDetailActivity.class).putExtra("stuTeacherCurriculumId", JsonParse.getString(map, "stuId")).putExtra("identify", JsonParse.getString(map, "identify")));
            }
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: p */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233045, (holder.m57864f() + 1) + "");
            holder.m57874J(C4215R.C4219id.tv_lesson, JsonParse.getString(stringObjectMap, "createTime"));
            holder.m57874J(C4215R.C4219id.tv_teacher, JsonParse.getString(stringObjectMap, "teaUser"));
            holder.m57874J(2131233146, JsonParse.getString(stringObjectMap, "score"));
            holder.m57870N(C4215R.C4219id.bt_delete, JsonParse.getBoolean(stringObjectMap, "isDelete"));
            final boolean z = JsonParse.getBoolean(stringObjectMap, "isToView");
            holder.m57870N(C4215R.C4219id.iv_arrow_right, z);
            holder.m57856n(2131232217, z);
            holder.m57847w(C4215R.C4219id.bt_delete, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.record.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamRecordActivity.C4500a.this.m42166r(holder, stringObjectMap, view);
                }
            });
            holder.m57847w(2131232217, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.record.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamRecordActivity.C4500a.this.m42165s(z, stringObjectMap, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.record.ExamRecordActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4501b extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ int f16917a;

        C4501b(final int val$position) {
            this.f16917a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamRecordActivity.this.f16912s.remove(this.f16917a);
            ExamRecordActivity.this.f16914u.notifyItemRemoved(this.f16917a);
            ExamRecordActivity.this.f16914u.notifyItemRangeChanged(this.f16917a, ExamRecordActivity.this.f16914u.getItemCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.record.ExamRecordActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4502c extends HttpCallBack {
        C4502c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamRecordActivity.this.f16912s = JsonParse.getList(data, "li");
            ExamRecordActivity.this.f16914u.m57836g(ExamRecordActivity.this.f16912s);
            Map<String, Object> map = JsonParse.getMap(data, "av");
            TextView textView = ExamRecordActivity.this.f16906m;
            textView.setText("考试次数：" + JsonParse.getString(map, "total"));
            TextView textView2 = ExamRecordActivity.this.f16907n;
            textView2.setText("平均分：" + JsonParse.getString(map, "avg"));
            TextView textView3 = ExamRecordActivity.this.f16908o;
            textView3.setText("总排名：" + JsonParse.getString(map, "rank"));
            TextView textView4 = ExamRecordActivity.this.f16909p;
            textView4.setText("年级排名：" + JsonParse.getString(map, "gradeRank"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public void m42173q0(int position, String stuId, String identify) {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m118d1(stuId, identify)).setDataListener(new C4501b(position));
    }

    /* renamed from: r0 */
    private void m42172r0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m119d0(this.f16913t, this.f16915v)).setDataListener(new C4502c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_exam_record;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("onlineType")) {
            this.f16915v = getIntent().getIntExtra("onlineType", 0);
        }
        if (getIntent().hasExtra("studentChooseLessonId")) {
            this.f16913t = getIntent().getStringExtra("studentChooseLessonId");
        }
        this.f16910q.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4500a c4500a = new C4500a(this.f1669h, C4215R.C4221layout.item_for_exam_record, this.f16912s);
        this.f16914u = c4500a;
        this.f16910q.setAdapter(c4500a);
        this.f16910q.setEmptyView(this.f16911r);
        m42172r0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("查看考试记录");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16904k = (TextView) findViewById(2131233040);
        this.f16905l = (TextView) findViewById(2131233051);
        this.f16906m = (TextView) findViewById(2131232914);
        this.f16907n = (TextView) findViewById(C4215R.C4219id.tv_avg);
        this.f16908o = (TextView) findViewById(C4215R.C4219id.tv_total_rank);
        this.f16909p = (TextView) findViewById(C4215R.C4219id.tv_grade_rank);
        this.f16910q = (EmptyRecyclerView) findViewById(2131232481);
        this.f16911r = (TextView) findViewById(2131232952);
        TextView textView = this.f16904k;
        textView.setText("姓名：" + LoginUser.getLoginUser().getRealName());
        TextView textView2 = this.f16905l;
        textView2.setText("学号：" + LoginUser.getLoginUser().getAccount());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
