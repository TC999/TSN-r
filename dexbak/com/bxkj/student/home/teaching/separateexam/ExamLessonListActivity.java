package com.bxkj.student.home.teaching.separateexam;

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
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.separateexam.ExamLessonListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ExamLessonListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f17986k;

    /* renamed from: l */
    private EmptyRecyclerView f17987l;

    /* renamed from: m */
    private TextView f17988m;

    /* renamed from: n */
    private List<Map<String, Object>> f17989n = new ArrayList();

    /* renamed from: o */
    private CommonAdapter<Map<String, Object>> f17990o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.separateexam.ExamLessonListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4869a extends CommonAdapter<Map<String, Object>> {
        C4869a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void m41144o(Map map, View view) {
            ExamLessonListActivity.this.startActivity(new Intent(this.f1721a, ExamLessonDescriptionActivity.class).putExtra("stuid", JsonParse.getString(map, "stuid")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_lesson_name, "课程：" + JsonParse.getString(stringObjectMap, "curriculumName"));
            holder.m57874J(C4215R.C4219id.tv_teacher_name, "教师：" + JsonParse.getString(stringObjectMap, "teacherName"));
            holder.m57847w(C4215R.C4219id.bt_start, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.separateexam.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExamLessonListActivity.C4869a.this.m41144o(stringObjectMap, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.separateexam.ExamLessonListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4870b extends HttpCallBack {
        C4870b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamLessonListActivity.this.f17989n = JsonParse.getList(data, "data");
            ExamLessonListActivity.this.f17990o.m57836g(ExamLessonListActivity.this.f17989n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ void m41147n0() {
        startActivity(new Intent(this.f1669h, MyAppointExamListActivity.class));
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
        this.f17987l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4869a c4869a = new C4869a(this.f1669h, C4215R.C4221layout.item_for_exam_lesson_list, this.f17989n);
        this.f17990o = c4869a;
        this.f17987l.setAdapter(c4869a);
        this.f17987l.setEmptyView(this.f17988m);
        m41148m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("选择约考课程");
        m57923d0("我的约考", new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.home.teaching.separateexam.b
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                ExamLessonListActivity.this.m41147n0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17986k = (SmartRefreshLayout) findViewById(2131232482);
        this.f17987l = (EmptyRecyclerView) findViewById(2131232481);
        this.f17988m = (TextView) findViewById(2131232952);
        this.f17986k.mo2050b0(false);
        this.f17986k.mo2064P(false);
    }

    /* renamed from: m0 */
    public void m41148m0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m167H0(LoginUser.getLoginUser().getUserId())).setDataListener(new C4870b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
