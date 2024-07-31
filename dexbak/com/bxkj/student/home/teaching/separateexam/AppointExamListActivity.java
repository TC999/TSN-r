package com.bxkj.student.home.teaching.separateexam;

import android.content.Context;
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
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.separateexam.AppointExamListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AppointExamListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f17971k;

    /* renamed from: l */
    private EmptyRecyclerView f17972l;

    /* renamed from: m */
    private TextView f17973m;

    /* renamed from: n */
    private List<Map<String, Object>> f17974n = new ArrayList();

    /* renamed from: o */
    private CommonAdapter<Map<String, Object>> f17975o;

    /* renamed from: p */
    private String f17976p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.separateexam.AppointExamListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4863a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.separateexam.AppointExamListActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C4864a implements iOSTwoButtonDialog.RightButtonOnClick {

            /* renamed from: a */
            final /* synthetic */ Map f17978a;

            /* renamed from: com.bxkj.student.home.teaching.separateexam.AppointExamListActivity$a$a$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            class C4865a extends HttpCallBack {
                C4865a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    AppointExamListActivity.this.m41160m0();
                }
            }

            C4864a(final Map val$stringObjectMap) {
                this.f17978a = val$stringObjectMap;
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                Http.with(((CommonAdapter) C4863a.this).f1721a).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m64v1(AppointExamListActivity.this.f17976p, JsonParse.getString(this.f17978a, "id"))).setDataListener(new C4865a());
            }
        }

        C4863a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p */
        public /* synthetic */ void m41156p(Map map, View view) {
            new iOSTwoButtonDialog(this.f1721a).setMessage("确定选择？").setRightButtonOnClickListener(new C4864a(map)).show();
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "sysOrgId"));
            holder.m57874J(C4215R.C4219id.tv_lesson, JsonParse.getString(stringObjectMap, "TeachingId"));
            holder.m57874J(C4215R.C4219id.tv_teacher_name, JsonParse.getString(stringObjectMap, "teacherId"));
            holder.m57874J(C4215R.C4219id.tv_lesson_all, JsonParse.getString(stringObjectMap, "teachingCurriculumTotalName"));
            holder.m57874J(2131232841, JsonParse.getString(stringObjectMap, "address"));
            holder.m57874J(C4215R.C4219id.tv_appoint_time, JsonParse.getString(stringObjectMap, "appointmentTime"));
            holder.m57874J(C4215R.C4219id.tv_exam_time, JsonParse.getString(stringObjectMap, "examTime"));
            holder.m57847w(C4215R.C4219id.bt_start, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.separateexam.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AppointExamListActivity.C4863a.this.m41156p(stringObjectMap, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.separateexam.AppointExamListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4866b extends HttpCallBack {
        C4866b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            AppointExamListActivity.this.f17974n = JsonParse.getList(data, "data");
            AppointExamListActivity.this.f17975o.m57836g(AppointExamListActivity.this.f17974n);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("stuid")) {
            this.f17976p = getIntent().getStringExtra("stuid");
        }
        this.f17972l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4863a c4863a = new C4863a(this.f1669h, C4215R.C4221layout.item_for_choose_exam_list, this.f17974n);
        this.f17975o = c4863a;
        this.f17972l.setAdapter(c4863a);
        this.f17972l.setEmptyView(this.f17973m);
        m41160m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("预约考试");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17971k = (SmartRefreshLayout) findViewById(2131232482);
        this.f17972l = (EmptyRecyclerView) findViewById(2131232481);
        this.f17973m = (TextView) findViewById(2131232952);
        this.f17971k.mo2050b0(false);
        this.f17971k.mo2064P(false);
    }

    /* renamed from: m0 */
    public void m41160m0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m125b0(this.f17976p)).setDataListener(new C4866b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
