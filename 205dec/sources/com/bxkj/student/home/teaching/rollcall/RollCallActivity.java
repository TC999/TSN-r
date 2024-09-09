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
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RollCallActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f21260k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f21261l;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21263n;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f21262m = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    protected int f21264o = 10;

    /* renamed from: p  reason: collision with root package name */
    protected int f21265p = 1;

    /* renamed from: q  reason: collision with root package name */
    protected int f21266q = 1;

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
            holder.J(2131233011, "\u8bfe\u7a0b\uff1a" + JsonParse.getString(stringObjectMap, "className"));
            holder.J(2131233192, "\u6559\u5e08\uff1a" + JsonParse.getString(stringObjectMap, "tcheNmae"));
            holder.J(2131233230, "\u5468\u6570\uff1a\u7b2c" + JsonParse.getString(stringObjectMap, "parameter") + "\u5468");
            StringBuilder sb = new StringBuilder();
            sb.append("\u65f6\u95f4\uff1a");
            sb.append(JsonParse.getString(stringObjectMap, "teachingSchoolTime"));
            holder.J(2131233193, sb.toString());
            holder.J(2131233169, "\u72b6\u6001\uff1a" + JsonParse.getString(stringObjectMap, "type"));
            holder.J(2131233146, "\u5206\u6570\uff1a" + JsonParse.getString(stringObjectMap, "score"));
            holder.J(2131232956, "\u989d\u5916\u5206\u6570\uff1a" + JsonParse.getString(stringObjectMap, "eScore"));
            holder.N(2131232956, JsonParse.getString(stringObjectMap, "eScore").isEmpty() ^ true);
            holder.J(2131233047, "\u5907\u6ce8\uff1a" + JsonParse.getString(stringObjectMap, "note"));
            holder.N(2131233047, JsonParse.getString(stringObjectMap, "note").isEmpty() ^ true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements s0.e {
        b() {
        }

        @Override // s0.d
        public void q(r0.h refreshlayout) {
            RollCallActivity rollCallActivity = RollCallActivity.this;
            rollCallActivity.f21265p = 1;
            rollCallActivity.l0();
        }

        @Override // s0.b
        public void s(r0.h refreshlayout) {
            RollCallActivity rollCallActivity = RollCallActivity.this;
            int i4 = rollCallActivity.f21266q;
            int i5 = rollCallActivity.f21264o;
            int i6 = i4 / i5;
            int i7 = rollCallActivity.f21265p;
            if (i4 % i5 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                rollCallActivity.f21260k.h();
                Toast.makeText(((BaseActivity) RollCallActivity.this).f1656h, "\u6ca1\u6709\u4e86", 0).show();
                return;
            }
            rollCallActivity.f21265p = i7 + 1;
            rollCallActivity.l0();
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
            RollCallActivity.this.f21260k.y();
            RollCallActivity.this.f21260k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RollCallActivity.this.f21266q = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d4 = RollCallActivity.this.f21263n.d();
            if (RollCallActivity.this.f21265p != 1) {
                d4.addAll(list);
                list = d4;
            }
            RollCallActivity.this.f21263n.g(list);
        }
    }

    private rx.e<Response<ResponseBody>> m0() {
        return ((w.a) Http.getApiService(w.a.class)).x(getIntent().getStringExtra("id"));
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
        this.f21260k.O(false);
        this.f21261l.setLayoutManager(new LinearLayoutManager(this.f1656h, 1, false));
        a aVar = new a(this.f1656h, 2131427777, this.f21262m);
        this.f21263n = aVar;
        this.f21261l.setAdapter(aVar);
        n0();
        this.f21260k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u67e5\u770b\u70b9\u540d");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131232642)).setVisibility(8);
        this.f21260k = (SmartRefreshLayout) findViewById(2131232483);
        this.f21261l = (RecyclerView) findViewById(2131232481);
    }

    public void l0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(m0()).setDataListener(new c());
    }

    public void n0() {
        this.f21260k.n1(new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
