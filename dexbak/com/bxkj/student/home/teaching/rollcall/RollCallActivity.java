package com.bxkj.student.home.teaching.rollcall;

import android.content.Context;
import android.os.Bundle;
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
import com.bxkj.student.C4215R;
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
public class RollCallActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f17922k;

    /* renamed from: l */
    private RecyclerView f17923l;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f17925n;

    /* renamed from: m */
    private List<Map<String, Object>> f17924m = new ArrayList();

    /* renamed from: o */
    protected int f17926o = 10;

    /* renamed from: p */
    protected int f17927p = 1;

    /* renamed from: q */
    protected int f17928q = 1;

    /* renamed from: com.bxkj.student.home.teaching.rollcall.RollCallActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4840a extends CommonAdapter<Map<String, Object>> {
        C4840a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_lessen_name, "课程：" + JsonParse.getString(stringObjectMap, "className"));
            holder.m57874J(C4215R.C4219id.tv_teacher_name, "教师：" + JsonParse.getString(stringObjectMap, "tcheNmae"));
            holder.m57874J(C4215R.C4219id.tv_week, "周数：第" + JsonParse.getString(stringObjectMap, "parameter") + "周");
            StringBuilder sb = new StringBuilder();
            sb.append("时间：");
            sb.append(JsonParse.getString(stringObjectMap, "teachingSchoolTime"));
            holder.m57874J(C4215R.C4219id.tv_teachingSchoolTime, sb.toString());
            holder.m57874J(2131233169, "状态：" + JsonParse.getString(stringObjectMap, "type"));
            holder.m57874J(2131233146, "分数：" + JsonParse.getString(stringObjectMap, "score"));
            holder.m57874J(C4215R.C4219id.tv_escore, "额外分数：" + JsonParse.getString(stringObjectMap, "eScore"));
            holder.m57870N(C4215R.C4219id.tv_escore, JsonParse.getString(stringObjectMap, "eScore").isEmpty() ^ true);
            holder.m57874J(C4215R.C4219id.tv_note, "备注：" + JsonParse.getString(stringObjectMap, "note"));
            holder.m57870N(C4215R.C4219id.tv_note, JsonParse.getString(stringObjectMap, "note").isEmpty() ^ true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.rollcall.RollCallActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4841b implements OnRefreshLoadmoreListener {
        C4841b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            RollCallActivity rollCallActivity = RollCallActivity.this;
            rollCallActivity.f17927p = 1;
            rollCallActivity.m41190l0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            RollCallActivity rollCallActivity = RollCallActivity.this;
            int i = rollCallActivity.f17928q;
            int i2 = rollCallActivity.f17926o;
            int i3 = i / i2;
            int i4 = rollCallActivity.f17927p;
            if (i % i2 != 0) {
                i3++;
            }
            if (i4 >= i3) {
                rollCallActivity.f17922k.mo2041g();
                Toast.makeText(((BaseActivity) RollCallActivity.this).f1669h, "没有了", 0).show();
                return;
            }
            rollCallActivity.f17927p = i4 + 1;
            rollCallActivity.m41190l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.rollcall.RollCallActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4842c extends HttpCallBack {
        C4842c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            RollCallActivity.this.f17922k.mo2078B();
            RollCallActivity.this.f17922k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RollCallActivity.this.f17928q = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            List m57837d = RollCallActivity.this.f17925n.m57837d();
            if (RollCallActivity.this.f17927p != 1) {
                m57837d.addAll(list);
                list = m57837d;
            }
            RollCallActivity.this.f17925n.m57836g(list);
        }
    }

    /* renamed from: m0 */
    private Observable<Response<ResponseBody>> m41189m0() {
        return ((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m60x(getIntent().getStringExtra("id"));
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
        this.f17922k.mo2064P(false);
        this.f17923l.setLayoutManager(new LinearLayoutManager(this.f1669h, 1, false));
        C4840a c4840a = new C4840a(this.f1669h, C4215R.C4221layout.item_for_view_call, this.f17924m);
        this.f17925n = c4840a;
        this.f17923l.setAdapter(c4840a);
        m41188n0();
        this.f17922k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("查看点名");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131232642)).setVisibility(8);
        this.f17922k = (SmartRefreshLayout) findViewById(2131232483);
        this.f17923l = (RecyclerView) findViewById(2131232481);
    }

    /* renamed from: l0 */
    public void m41190l0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(m41189m0()).setDataListener(new C4842c());
    }

    /* renamed from: n0 */
    public void m41188n0() {
        this.f17922k.mo2019v(new C4841b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
