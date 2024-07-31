package com.bxkj.student.home.teaching.homework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.homework.ViewLessonActivity;
import com.bxkj.student.home.teaching.homework.question.list.QuestionListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import p638r0.RefreshLayout;
import p640rx.Observable;
import p642s0.OnRefreshLoadmoreListener;
import p653w.InterfaceC16236a;
import retrofit2.Response;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ViewLessonActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f16963k;

    /* renamed from: l */
    private RecyclerView f16964l;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f16966n;

    /* renamed from: m */
    private List<Map<String, Object>> f16965m = new ArrayList();

    /* renamed from: o */
    protected int f16967o = 10;

    /* renamed from: p */
    protected int f16968p = 1;

    /* renamed from: q */
    protected int f16969q = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.ViewLessonActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4518a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.homework.ViewLessonActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4519a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f16971a;

            View$OnClickListenerC4519a(final Map val$stringObjectMap) {
                this.f16971a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ViewLessonActivity.this.startActivity(new Intent(((CommonAdapter) C4518a.this).f1721a, QuestionListActivity.class).putExtra("teacherCurriculumId", JsonParse.getString(this.f16971a, "id")));
            }
        }

        C4518a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p */
        public /* synthetic */ void m42120p(Map map, View view) {
            ViewLessonActivity.this.m42124q0(JsonParse.getString(map, "classimg"));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_lesson_name, JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingCurriculumName"));
            holder.m57874J(2131232927, JsonParse.getString(stringObjectMap, "teacherCurriculumSysTermName"));
            holder.m57874J(2131233198, JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingSchoolTimeName"));
            holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "teacherCurriculumSysOrgName"));
            holder.m57874J(C4215R.C4219id.tv_school_area, JsonParse.getString(stringObjectMap, "teacherCurriculumSysCampusName"));
            holder.m57874J(2131233211, JsonParse.getString(stringObjectMap, "teacherCurriculumType"));
            holder.m57874J(C4215R.C4219id.tv_feature, JsonParse.getString(stringObjectMap, "teacherCurriculumFeature"));
            holder.m57874J(C4215R.C4219id.tv_teacher, "教师：" + JsonParse.getString(stringObjectMap, "teacherCurriculumSysUserName"));
            holder.m57870N(2131232841, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "address")) ^ true);
            holder.m57874J(2131232841, JsonParse.getString(stringObjectMap, "address"));
            ((Button) holder.m57862h(2131230989)).setText("课后作业");
            holder.m57870N(C4215R.C4219id.bt_qrcode, true);
            holder.m57847w(C4215R.C4219id.bt_qrcode, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewLessonActivity.C4518a.this.m42120p(stringObjectMap, view);
                }
            });
            holder.m57847w(2131230989, new View$OnClickListenerC4519a(stringObjectMap));
            holder.m57870N(C4215R.C4219id.bt_qrcode, false);
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.homework.ViewLessonActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4520b extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ int f16973a;

        C4520b(final int val$position) {
            this.f16973a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.f16966n.m57837d().remove(this.f16973a);
            ViewLessonActivity.this.f16966n.notifyItemRemoved(this.f16973a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.ViewLessonActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4521c implements OnRefreshLoadmoreListener {
        C4521c() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            viewLessonActivity.f16968p = 1;
            viewLessonActivity.m42127n0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            int i = viewLessonActivity.f16969q;
            int i2 = viewLessonActivity.f16967o;
            int i3 = i / i2;
            int i4 = viewLessonActivity.f16968p;
            if (i % i2 != 0) {
                i3++;
            }
            if (i4 >= i3) {
                viewLessonActivity.f16963k.mo2041g();
                Toast.makeText(((BaseActivity) ViewLessonActivity.this).f1669h, "没有了", 0).show();
                return;
            }
            viewLessonActivity.f16968p = i4 + 1;
            viewLessonActivity.m42127n0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.ViewLessonActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4522d extends HttpCallBack {
        C4522d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ViewLessonActivity.this.f16963k.mo2078B();
            ViewLessonActivity.this.f16963k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.f16969q = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            List m57837d = ViewLessonActivity.this.f16966n.m57837d();
            if (ViewLessonActivity.this.f16968p != 1) {
                m57837d.addAll(list);
                list = m57837d;
            }
            ViewLessonActivity.this.f16966n.m57836g(list);
        }
    }

    /* renamed from: m0 */
    private void m42128m0(final int position) {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m61w1(JsonParse.getString(this.f16966n.getItem(position), "id"))).setDataListener(new C4520b(position));
    }

    /* renamed from: o0 */
    private Observable<Response<ResponseBody>> m42126o0() {
        return ((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m148Q0(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("id"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public void m42124q0(String url) {
        Intent intent = new Intent(this.f1669h, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.f1869h, new String[]{url});
        intent.putExtra(ImagePagerActivity.f1868g, 1);
        intent.putExtra(ImagePagerActivity.f1870i, true);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_my_lesson;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f16963k.mo2064P(false);
        this.f16964l.setLayoutManager(new LinearLayoutManager(this.f1669h, 1, false));
        C4518a c4518a = new C4518a(this.f1669h, C4215R.C4221layout.item_for_lesson_list, this.f16965m);
        this.f16966n = c4518a;
        this.f16964l.setAdapter(c4518a);
        m42125p0();
        this.f16963k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("课后作业-查看" + LoginUser.getLoginUser().getViewAfterLabelName());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131232642)).setVisibility(8);
        this.f16963k = (SmartRefreshLayout) findViewById(2131232483);
        this.f16964l = (RecyclerView) findViewById(2131232481);
    }

    /* renamed from: n0 */
    public void m42127n0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(m42126o0()).setDataListener(new C4522d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* renamed from: p0 */
    public void m42125p0() {
        this.f16963k.mo2019v(new C4521c());
    }
}
