package com.bxkj.student.home.teaching.lesson;

import android.content.Context;
import android.content.Intent;
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
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.rollcall.RollCallActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ViewTermActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f17849k;

    /* renamed from: l */
    private RecyclerView f17850l;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f17852n;

    /* renamed from: o */
    private String f17853o;

    /* renamed from: m */
    private List<Map<String, Object>> f17851m = new ArrayList();

    /* renamed from: p */
    protected int f17854p = 10;

    /* renamed from: q */
    protected int f17855q = 1;

    /* renamed from: r */
    protected int f17856r = 1;

    /* renamed from: com.bxkj.student.home.teaching.lesson.ViewTermActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4811a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.lesson.ViewTermActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4812a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f17858a;

            View$OnClickListenerC4812a(final Map val$stringObjectMap) {
                this.f17858a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (("查看" + LoginUser.getLoginUser().getViewAfterLabelName()).equals(ViewTermActivity.this.f17853o)) {
                    ViewTermActivity.this.startActivity(new Intent(((CommonAdapter) C4811a.this).f1721a, ViewLessonActivity.class).putExtra("id", JsonParse.getString(this.f17858a, "id")));
                } else if ("查看点名".equals(ViewTermActivity.this.f17853o)) {
                    ViewTermActivity.this.startActivity(new Intent(((CommonAdapter) C4811a.this).f1721a, RollCallActivity.class).putExtra("id", JsonParse.getString(this.f17858a, "id")));
                }
            }
        }

        C4811a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131232927, JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "sysUserName"));
            holder.m57874J(2131233045, JsonParse.getString(stringObjectMap, "sysUserUserNum"));
            holder.m57874J(2131233169, JsonParse.getString(stringObjectMap, "type"));
            holder.m57874J(2131233146, JsonParse.getString(stringObjectMap, "score"));
            holder.m57874J(2131230989, ViewTermActivity.this.f17853o);
            holder.m57847w(2131230989, new View$OnClickListenerC4812a(stringObjectMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.ViewTermActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4813b implements OnRefreshLoadmoreListener {
        C4813b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            viewTermActivity.f17855q = 1;
            viewTermActivity.m41277m0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            int i = viewTermActivity.f17856r;
            int i2 = viewTermActivity.f17854p;
            int i3 = i / i2;
            int i4 = viewTermActivity.f17855q;
            if (i % i2 != 0) {
                i3++;
            }
            if (i4 >= i3) {
                viewTermActivity.f17849k.mo2041g();
                Toast.makeText(((BaseActivity) ViewTermActivity.this).f1669h, "没有了", 0).show();
                return;
            }
            viewTermActivity.f17855q = i4 + 1;
            viewTermActivity.m41277m0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.lesson.ViewTermActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4814c extends HttpCallBack {
        C4814c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ViewTermActivity.this.f17849k.mo2078B();
            ViewTermActivity.this.f17849k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewTermActivity.this.f17856r = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            List m57837d = ViewTermActivity.this.f17852n.m57837d();
            if (ViewTermActivity.this.f17855q != 1) {
                m57837d.addAll(list);
                list = m57837d;
            }
            ViewTermActivity.this.f17852n.m57836g(list);
        }
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
        this.f17853o = getIntent().getStringExtra(Constants.FROM);
        this.f17850l.setLayoutManager(new LinearLayoutManager(this.f1669h, 1, false));
        C4811a c4811a = new C4811a(this.f1669h, C4215R.C4221layout.item_for_term_lesson_list, this.f17851m);
        this.f17852n = c4811a;
        this.f17850l.setAdapter(c4811a);
        m41276n0();
        this.f17849k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("查看学期");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131232642)).setVisibility(8);
        this.f17849k = (SmartRefreshLayout) findViewById(2131232483);
        this.f17850l = (RecyclerView) findViewById(2131232481);
    }

    /* renamed from: m0 */
    public void m41277m0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m80q0(LoginUser.getLoginUser().getUserId(), this.f17855q, this.f17854p)).setDataListener(new C4814c());
    }

    /* renamed from: n0 */
    public void m41276n0() {
        this.f17849k.mo2019v(new C4813b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
