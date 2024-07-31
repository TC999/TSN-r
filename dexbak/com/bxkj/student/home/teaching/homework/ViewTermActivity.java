package com.bxkj.student.home.teaching.homework;

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
    private SmartRefreshLayout f16977k;

    /* renamed from: l */
    private RecyclerView f16978l;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f16980n;

    /* renamed from: o */
    private String f16981o;

    /* renamed from: m */
    private List<Map<String, Object>> f16979m = new ArrayList();

    /* renamed from: p */
    protected int f16982p = 10;

    /* renamed from: q */
    protected int f16983q = 1;

    /* renamed from: r */
    protected int f16984r = 1;

    /* renamed from: com.bxkj.student.home.teaching.homework.ViewTermActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4523a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.teaching.homework.ViewTermActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4524a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f16986a;

            View$OnClickListenerC4524a(final Map val$stringObjectMap) {
                this.f16986a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ViewTermActivity.this.startActivity(new Intent(((CommonAdapter) C4523a.this).f1721a, ViewLessonActivity.class).putExtra("id", JsonParse.getString(this.f16986a, "id")));
            }
        }

        C4523a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131232927, JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "sysUserName"));
            holder.m57874J(2131233045, JsonParse.getString(stringObjectMap, "sysUserUserNum"));
            holder.m57874J(2131233169, JsonParse.getString(stringObjectMap, "type"));
            holder.m57874J(2131233146, JsonParse.getString(stringObjectMap, "score"));
            holder.m57874J(2131230989, "查看课程");
            holder.m57847w(2131230989, new View$OnClickListenerC4524a(stringObjectMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.ViewTermActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4525b implements OnRefreshLoadmoreListener {
        C4525b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            viewTermActivity.f16983q = 1;
            viewTermActivity.m42116l0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            int i = viewTermActivity.f16984r;
            int i2 = viewTermActivity.f16982p;
            int i3 = i / i2;
            int i4 = viewTermActivity.f16983q;
            if (i % i2 != 0) {
                i3++;
            }
            if (i4 >= i3) {
                viewTermActivity.f16977k.mo2041g();
                Toast.makeText(((BaseActivity) ViewTermActivity.this).f1669h, "没有了", 0).show();
                return;
            }
            viewTermActivity.f16983q = i4 + 1;
            viewTermActivity.m42116l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.ViewTermActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4526c extends HttpCallBack {
        C4526c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ViewTermActivity.this.f16977k.mo2078B();
            ViewTermActivity.this.f16977k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewTermActivity.this.f16984r = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            List m57837d = ViewTermActivity.this.f16980n.m57837d();
            if (ViewTermActivity.this.f16983q != 1) {
                m57837d.addAll(list);
                list = m57837d;
            }
            ViewTermActivity.this.f16980n.m57836g(list);
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
        this.f16981o = getIntent().getStringExtra(Constants.FROM);
        this.f16978l.setLayoutManager(new LinearLayoutManager(this.f1669h, 1, false));
        C4523a c4523a = new C4523a(this.f1669h, C4215R.C4221layout.item_for_term_lesson_list, this.f16979m);
        this.f16980n = c4523a;
        this.f16978l.setAdapter(c4523a);
        m42115m0();
        this.f16977k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("课后作业-查看学期");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131232642)).setVisibility(8);
        this.f16977k = (SmartRefreshLayout) findViewById(2131232483);
        this.f16978l = (RecyclerView) findViewById(2131232481);
    }

    /* renamed from: l0 */
    public void m42116l0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m80q0(LoginUser.getLoginUser().getUserId(), this.f16983q, this.f16982p)).setDataListener(new C4526c());
    }

    /* renamed from: m0 */
    public void m42115m0() {
        this.f16977k.mo2019v(new C4525b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
