package com.bxkj.student.home.teaching.rollcall.term;

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
import com.bxkj.student.home.teaching.rollcall.term.ViewTermActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ViewTermActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f17957k;

    /* renamed from: l */
    private RecyclerView f17958l;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f17960n;

    /* renamed from: m */
    private List<Map<String, Object>> f17959m = new ArrayList();

    /* renamed from: o */
    protected int f17961o = 10;

    /* renamed from: p */
    protected int f17962p = 1;

    /* renamed from: q */
    protected int f17963q = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.rollcall.term.ViewTermActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4858a extends CommonAdapter<Map<String, Object>> {
        C4858a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void m41165o(Map map, View view) {
            ViewTermActivity.this.startActivity(new Intent(this.f1721a, ViewLessonActivity.class).putExtra("id", JsonParse.getString(map, "id")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131232927, JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "sysUserName"));
            holder.m57874J(2131233045, JsonParse.getString(stringObjectMap, "sysUserUserNum"));
            holder.m57874J(2131233169, JsonParse.getString(stringObjectMap, "type"));
            holder.m57874J(2131233146, JsonParse.getString(stringObjectMap, "score"));
            holder.m57874J(2131230989, "查看选课");
            holder.m57847w(2131230989, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.term.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewTermActivity.C4858a.this.m41165o(stringObjectMap, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.rollcall.term.ViewTermActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4859b implements OnRefreshLoadmoreListener {
        C4859b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            viewTermActivity.f17962p = 1;
            viewTermActivity.m41169l0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            int i = viewTermActivity.f17963q;
            int i2 = viewTermActivity.f17961o;
            int i3 = i / i2;
            int i4 = viewTermActivity.f17962p;
            if (i % i2 != 0) {
                i3++;
            }
            if (i4 >= i3) {
                viewTermActivity.f17957k.mo2041g();
                Toast.makeText(((BaseActivity) ViewTermActivity.this).f1669h, "没有了", 0).show();
                return;
            }
            viewTermActivity.f17962p = i4 + 1;
            viewTermActivity.m41169l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.rollcall.term.ViewTermActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4860c extends HttpCallBack {
        C4860c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ViewTermActivity.this.f17957k.mo2078B();
            ViewTermActivity.this.f17957k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewTermActivity.this.f17963q = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            List m57837d = ViewTermActivity.this.f17960n.m57837d();
            if (ViewTermActivity.this.f17962p != 1) {
                m57837d.addAll(list);
                list = m57837d;
            }
            ViewTermActivity.this.f17960n.m57836g(list);
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
        this.f17958l.setLayoutManager(new LinearLayoutManager(this.f1669h, 1, false));
        C4858a c4858a = new C4858a(this.f1669h, C4215R.C4221layout.item_for_term_lesson_list, this.f17959m);
        this.f17960n = c4858a;
        this.f17958l.setAdapter(c4858a);
        m41168m0();
        this.f17957k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("上课签到-查看学期");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131232642)).setVisibility(8);
        this.f17957k = (SmartRefreshLayout) findViewById(2131232483);
        this.f17958l = (RecyclerView) findViewById(2131232481);
    }

    /* renamed from: l0 */
    public void m41169l0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m80q0(LoginUser.getLoginUser().getUserId(), this.f17962p, this.f17961o)).setDataListener(new C4860c());
    }

    /* renamed from: m0 */
    public void m41168m0() {
        this.f17957k.mo2019v(new C4859b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
