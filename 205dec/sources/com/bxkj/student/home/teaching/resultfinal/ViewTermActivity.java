package com.bxkj.student.home.teaching.resultfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
import com.bxkj.base.user.LoginUser;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ViewTermActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f21221k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f21222l;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21224n;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f21223m = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    protected int f21225o = 10;

    /* renamed from: p  reason: collision with root package name */
    protected int f21226p = 1;

    /* renamed from: q  reason: collision with root package name */
    protected int f21227q = 1;

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
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131232927, "\u5b66\u671f\uff1a" + JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "sysUserName"));
            holder.J(2131233045, JsonParse.getString(stringObjectMap, "sysUserUserNum"));
            holder.J(2131233169, JsonParse.getString(stringObjectMap, "type"));
            holder.J(2131233146, JsonParse.getString(stringObjectMap, "score"));
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
            ViewTermActivity.this.startActivity(new Intent(((BaseActivity) ViewTermActivity.this).f1656h, AllScoreForTeamActivity.class).putExtra("stuName", JsonParse.getString((Map) ViewTermActivity.this.f21224n.getItem(position), "sysUserName")).putExtra("stuNum", JsonParse.getString((Map) ViewTermActivity.this.f21224n.getItem(position), "sysUserUserNum")).putExtra("stuTeamScoreId", JsonParse.getString((Map) ViewTermActivity.this.f21224n.getItem(position), "id")));
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
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            viewTermActivity.f21226p = 1;
            viewTermActivity.m0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            int i4 = viewTermActivity.f21227q;
            int i5 = viewTermActivity.f21225o;
            int i6 = i4 / i5;
            int i7 = viewTermActivity.f21226p;
            if (i4 % i5 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                viewTermActivity.f21221k.h();
                Toast.makeText(((BaseActivity) ViewTermActivity.this).f1656h, "\u6ca1\u6709\u4e86", 0).show();
                return;
            }
            viewTermActivity.f21226p = i7 + 1;
            viewTermActivity.m0();
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
            ViewTermActivity.this.f21221k.y();
            ViewTermActivity.this.f21221k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewTermActivity.this.f21227q = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d4 = ViewTermActivity.this.f21224n.d();
            if (ViewTermActivity.this.f21226p != 1) {
                d4.addAll(list);
                list = d4;
            }
            ViewTermActivity.this.f21224n.g(list);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21224n.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f21222l.setLayoutManager(new LinearLayoutManager(this.f1656h, 1, false));
        a aVar = new a(this.f1656h, 2131427772, this.f21223m);
        this.f21224n = aVar;
        this.f21222l.setAdapter(aVar);
        n0();
        this.f21221k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u67e5\u770b\u5b66\u671f\u603b\u5206");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21221k = (SmartRefreshLayout) findViewById(2131232482);
        this.f21222l = (RecyclerView) findViewById(2131232481);
    }

    public void m0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((w.a) Http.getApiService(w.a.class)).q0(LoginUser.getLoginUser().getUserId(), this.f21226p, this.f21225o)).setDataListener(new d());
    }

    public void n0() {
        this.f21221k.n1(new c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
