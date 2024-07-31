package com.bxkj.student.home.teaching.rollcall.term;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.rollcall.SignActivity;
import com.bxkj.student.home.teaching.rollcall.term.ViewLessonActivity;
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
    private SmartRefreshLayout f17945k;

    /* renamed from: l */
    private RecyclerView f17946l;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f17948n;

    /* renamed from: m */
    private List<Map<String, Object>> f17947m = new ArrayList();

    /* renamed from: o */
    protected int f17949o = 10;

    /* renamed from: p */
    protected int f17950p = 1;

    /* renamed from: q */
    protected int f17951q = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.rollcall.term.ViewLessonActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4854a extends CommonAdapter<Map<String, Object>> {
        C4854a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void m41173o(Map map, View view) {
            ViewLessonActivity.this.startActivity(new Intent(this.f1721a, SignActivity.class).putExtra("id", JsonParse.getString(map, "id")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_lesson_name, JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingCurriculumName"));
            holder.m57874J(2131232927, JsonParse.getString(stringObjectMap, "teacherCurriculumSysTermName"));
            holder.m57874J(2131233198, JsonParse.getString(stringObjectMap, "teacherCurriculumTeachingSchoolTimeName"));
            holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "teacherCurriculumSysOrgName"));
            holder.m57874J(C4215R.C4219id.tv_school_area, JsonParse.getString(stringObjectMap, "teacherCurriculumSysCampusName"));
            holder.m57874J(C4215R.C4219id.tv_week, "第" + JsonParse.getString(stringObjectMap, "parameter") + "周");
            holder.m57874J(2131233211, JsonParse.getString(stringObjectMap, "teacherCurriculumType"));
            holder.m57874J(C4215R.C4219id.tv_feature, JsonParse.getString(stringObjectMap, "teacherCurriculumFeature"));
            holder.m57874J(C4215R.C4219id.tv_teacher, "教师：" + JsonParse.getString(stringObjectMap, "teacherCurriculumSysUserName"));
            holder.m57870N(2131232841, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "address")) ^ true);
            holder.m57874J(2131232841, JsonParse.getString(stringObjectMap, "address"));
            holder.m57870N(2131230989, false);
            holder.m57870N(C4215R.C4219id.bt_qrcode, false);
            holder.m57870N(C4215R.C4219id.bt_certificate, true);
            holder.m57874J(C4215R.C4219id.bt_certificate, "上课签到");
            holder.m57847w(C4215R.C4219id.bt_certificate, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.term.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewLessonActivity.C4854a.this.m41173o(stringObjectMap, view);
                }
            });
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.rollcall.term.ViewLessonActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4855b extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ int f17953a;

        C4855b(final int val$position) {
            this.f17953a = val$position;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.f17948n.m57837d().remove(this.f17953a);
            ViewLessonActivity.this.f17948n.notifyItemRemoved(this.f17953a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.rollcall.term.ViewLessonActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4856c implements OnRefreshLoadmoreListener {
        C4856c() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            viewLessonActivity.f17950p = 1;
            viewLessonActivity.m41178m0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            ViewLessonActivity viewLessonActivity = ViewLessonActivity.this;
            int i = viewLessonActivity.f17951q;
            int i2 = viewLessonActivity.f17949o;
            int i3 = i / i2;
            int i4 = viewLessonActivity.f17950p;
            if (i % i2 != 0) {
                i3++;
            }
            if (i4 >= i3) {
                viewLessonActivity.f17945k.mo2041g();
                Toast.makeText(((BaseActivity) ViewLessonActivity.this).f1669h, "没有了", 0).show();
                return;
            }
            viewLessonActivity.f17950p = i4 + 1;
            viewLessonActivity.m41178m0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.rollcall.term.ViewLessonActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4857d extends HttpCallBack {
        C4857d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ViewLessonActivity.this.f17945k.mo2078B();
            ViewLessonActivity.this.f17945k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLessonActivity.this.f17951q = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            List m57837d = ViewLessonActivity.this.f17948n.m57837d();
            if (ViewLessonActivity.this.f17950p != 1) {
                m57837d.addAll(list);
                list = m57837d;
            }
            ViewLessonActivity.this.f17948n.m57836g(list);
        }
    }

    /* renamed from: l0 */
    private void m41179l0(final int position) {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m61w1(JsonParse.getString(this.f17948n.getItem(position), "id"))).setDataListener(new C4855b(position));
    }

    /* renamed from: n0 */
    private Observable<Response<ResponseBody>> m41177n0() {
        return ((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m148Q0(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("id"));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_online_lesson;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f17945k.mo2064P(false);
        this.f17946l.setLayoutManager(new LinearLayoutManager(this.f1669h, 1, false));
        C4854a c4854a = new C4854a(this.f1669h, C4215R.C4221layout.item_for_lesson_list, this.f17947m);
        this.f17948n = c4854a;
        this.f17946l.setAdapter(c4854a);
        m41176o0();
        this.f17945k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("上课签到-查看" + LoginUser.getLoginUser().getViewAfterLabelName());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131232642)).setVisibility(8);
        this.f17945k = (SmartRefreshLayout) findViewById(2131232483);
        this.f17946l = (RecyclerView) findViewById(2131232481);
    }

    /* renamed from: m0 */
    public void m41178m0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(m41177n0()).setDataListener(new C4857d());
    }

    /* renamed from: o0 */
    public void m41176o0() {
        this.f17945k.mo2019v(new C4856c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
