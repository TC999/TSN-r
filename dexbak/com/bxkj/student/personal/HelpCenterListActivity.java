package com.bxkj.student.personal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.C4215R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class HelpCenterListActivity extends BaseActivity {

    /* renamed from: k */
    private RecyclerView f18708k;

    /* renamed from: l */
    private SmartRefreshLayout f18709l;

    /* renamed from: m */
    private List<Map<String, Object>> f18710m;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f18711n;

    /* renamed from: o */
    protected int f18712o = 10;

    /* renamed from: p */
    protected int f18713p = 1;

    /* renamed from: q */
    protected int f18714q = 1;

    /* renamed from: com.bxkj.student.personal.HelpCenterListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5110a extends CommonAdapter<Map<String, Object>> {
        C5110a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57870N(C4215R.C4219id.iv_not_read, false);
            holder.m57870N(C4215R.C4219id.tv_label, false);
            holder.m57874J(2131233204, (holder.m57864f() + 1) + "、" + Tools.m57632O(stringObjectMap, "helpTitle"));
        }
    }

    /* renamed from: com.bxkj.student.personal.HelpCenterListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5111b implements OnItemClickListener {
        C5111b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            Intent intent = new Intent(((BaseActivity) HelpCenterListActivity.this).f1669h, H5DetailActivity.class);
            intent.putExtra("title", Tools.m57632O((Map) HelpCenterListActivity.this.f18711n.getItem(position), "helpTitle"));
            intent.putExtra("content", Tools.m57632O((Map) HelpCenterListActivity.this.f18711n.getItem(position), "helpContent"));
            HelpCenterListActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.HelpCenterListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5112c implements OnRefreshLoadmoreListener {
        C5112c() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            HelpCenterListActivity helpCenterListActivity = HelpCenterListActivity.this;
            helpCenterListActivity.f18713p = 1;
            helpCenterListActivity.m40576o0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            HelpCenterListActivity helpCenterListActivity = HelpCenterListActivity.this;
            int i = helpCenterListActivity.f18714q;
            int i2 = helpCenterListActivity.f18712o;
            int i3 = i / i2;
            int i4 = helpCenterListActivity.f18713p;
            if (i % i2 != 0) {
                i3++;
            }
            if (i4 >= i3) {
                helpCenterListActivity.f18709l.mo2041g();
                Toast.makeText(((BaseActivity) HelpCenterListActivity.this).f1669h, "没有了", 0).show();
                return;
            }
            helpCenterListActivity.f18713p = i4 + 1;
            helpCenterListActivity.m40576o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.personal.HelpCenterListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5113d extends HttpCallBack {
        C5113d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            HelpCenterListActivity.this.f18709l.mo2078B();
            HelpCenterListActivity.this.f18709l.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            HelpCenterListActivity.this.f18714q = Integer.parseInt(Tools.m57632O(data, "total"));
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            HelpCenterListActivity helpCenterListActivity = HelpCenterListActivity.this;
            if (helpCenterListActivity.f18713p == 1) {
                helpCenterListActivity.f18710m = list;
            } else {
                helpCenterListActivity.f18710m.addAll(list);
            }
            HelpCenterListActivity.this.f18711n.m57836g(HelpCenterListActivity.this.f18710m);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18711n.m57834k(new C5111b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f18708k.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f18708k.setLayoutAnimation(layoutAnimationController);
        C5110a c5110a = new C5110a(this.f1669h, C4215R.C4221layout.item_notice, this.f18710m);
        this.f18711n = c5110a;
        this.f18708k.setAdapter(c5110a);
        m40575p0();
        this.f18709l.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("帮助中心");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18708k = (RecyclerView) findViewById(2131232481);
        this.f18709l = (SmartRefreshLayout) findViewById(2131232482);
    }

    /* renamed from: o0 */
    public void m40576o0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m176E0(2, this.f18713p, this.f18712o)).setDataListener(new C5113d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* renamed from: p0 */
    public void m40575p0() {
        this.f18709l.mo2019v(new C5112c());
    }
}
