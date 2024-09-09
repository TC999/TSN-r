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
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.rollcall.term.ViewTermActivity;
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
    private SmartRefreshLayout f21295k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f21296l;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21298n;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f21297m = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    protected int f21299o = 10;

    /* renamed from: p  reason: collision with root package name */
    protected int f21300p = 1;

    /* renamed from: q  reason: collision with root package name */
    protected int f21301q = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Map map, View view) {
            ViewTermActivity.this.startActivity(new Intent(this.f1707a, ViewLessonActivity.class).putExtra("id", JsonParse.getString(map, "id")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131232927, JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "sysUserName"));
            holder.J(2131233045, JsonParse.getString(stringObjectMap, "sysUserUserNum"));
            holder.J(2131233169, JsonParse.getString(stringObjectMap, "type"));
            holder.J(2131233146, JsonParse.getString(stringObjectMap, "score"));
            holder.J(2131230989, "\u67e5\u770b\u9009\u8bfe");
            holder.w(2131230989, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.term.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewTermActivity.a.this.o(stringObjectMap, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements e {
        b() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            viewTermActivity.f21300p = 1;
            viewTermActivity.l0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            int i4 = viewTermActivity.f21301q;
            int i5 = viewTermActivity.f21299o;
            int i6 = i4 / i5;
            int i7 = viewTermActivity.f21300p;
            if (i4 % i5 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                viewTermActivity.f21295k.h();
                Toast.makeText(((BaseActivity) ViewTermActivity.this).f1656h, "\u6ca1\u6709\u4e86", 0).show();
                return;
            }
            viewTermActivity.f21300p = i7 + 1;
            viewTermActivity.l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ViewTermActivity.this.f21295k.y();
            ViewTermActivity.this.f21295k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewTermActivity.this.f21301q = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d4 = ViewTermActivity.this.f21298n.d();
            if (ViewTermActivity.this.f21300p != 1) {
                d4.addAll(list);
                list = d4;
            }
            ViewTermActivity.this.f21298n.g(list);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427444;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f21296l.setLayoutManager(new LinearLayoutManager(this.f1656h, 1, false));
        a aVar = new a(this.f1656h, 2131427771, this.f21297m);
        this.f21298n = aVar;
        this.f21296l.setAdapter(aVar);
        m0();
        this.f21295k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4e0a\u8bfe\u7b7e\u5230-\u67e5\u770b\u5b66\u671f");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131232642)).setVisibility(8);
        this.f21295k = (SmartRefreshLayout) findViewById(2131232483);
        this.f21296l = (RecyclerView) findViewById(2131232481);
    }

    public void l0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((w.a) Http.getApiService(w.a.class)).q0(LoginUser.getLoginUser().getUserId(), this.f21300p, this.f21299o)).setDataListener(new c());
    }

    public void m0() {
        this.f21295k.n1(new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
