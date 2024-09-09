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
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.webview.H5DetailActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import r0.h;
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class HelpCenterListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f22008k;

    /* renamed from: l  reason: collision with root package name */
    private SmartRefreshLayout f22009l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f22010m;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f22011n;

    /* renamed from: o  reason: collision with root package name */
    protected int f22012o = 10;

    /* renamed from: p  reason: collision with root package name */
    protected int f22013p = 1;

    /* renamed from: q  reason: collision with root package name */
    protected int f22014q = 1;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.N(2131231460, false);
            holder.N(2131233009, false);
            holder.J(2131233204, (holder.f() + 1) + "\u3001" + u.O(stringObjectMap, "helpTitle"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            Intent intent = new Intent(((BaseActivity) HelpCenterListActivity.this).f1656h, H5DetailActivity.class);
            intent.putExtra("title", u.O((Map) HelpCenterListActivity.this.f22011n.getItem(position), "helpTitle"));
            intent.putExtra("content", u.O((Map) HelpCenterListActivity.this.f22011n.getItem(position), "helpContent"));
            HelpCenterListActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements e {
        c() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            HelpCenterListActivity helpCenterListActivity = HelpCenterListActivity.this;
            helpCenterListActivity.f22013p = 1;
            helpCenterListActivity.o0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            HelpCenterListActivity helpCenterListActivity = HelpCenterListActivity.this;
            int i4 = helpCenterListActivity.f22014q;
            int i5 = helpCenterListActivity.f22012o;
            int i6 = i4 / i5;
            int i7 = helpCenterListActivity.f22013p;
            if (i4 % i5 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                helpCenterListActivity.f22009l.h();
                Toast.makeText(((BaseActivity) HelpCenterListActivity.this).f1656h, "\u6ca1\u6709\u4e86", 0).show();
                return;
            }
            helpCenterListActivity.f22013p = i7 + 1;
            helpCenterListActivity.o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            HelpCenterListActivity.this.f22009l.y();
            HelpCenterListActivity.this.f22009l.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            HelpCenterListActivity.this.f22014q = Integer.parseInt(u.O(data, "total"));
            List<Map<String, Object>> list = JsonParse.getList(data, "data");
            HelpCenterListActivity helpCenterListActivity = HelpCenterListActivity.this;
            if (helpCenterListActivity.f22013p == 1) {
                helpCenterListActivity.f22010m = list;
            } else {
                helpCenterListActivity.f22010m.addAll(list);
            }
            HelpCenterListActivity.this.f22011n.g(HelpCenterListActivity.this.f22010m);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22011n.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f22008k.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f22008k.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, 2131427778, this.f22010m);
        this.f22011n = aVar;
        this.f22008k.setAdapter(aVar);
        p0();
        this.f22009l.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5e2e\u52a9\u4e2d\u5fc3");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22008k = (RecyclerView) findViewById(2131232481);
        this.f22009l = (SmartRefreshLayout) findViewById(2131232482);
    }

    public void o0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((w.a) Http.getApiService(w.a.class)).E0(2, this.f22013p, this.f22012o)).setDataListener(new d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    public void p0() {
        this.f22009l.n1(new c());
    }
}
