package com.bxkj.student.home.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
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
public class SystemMessageListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f19724k;

    /* renamed from: l  reason: collision with root package name */
    private SmartRefreshLayout f19725l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f19726m;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19727n;

    /* renamed from: o  reason: collision with root package name */
    private int f19728o = 1;

    /* renamed from: p  reason: collision with root package name */
    private int f19729p = 12;

    /* renamed from: q  reason: collision with root package name */
    private int f19730q = 1;

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
            holder.J(2131233204, u.O(stringObjectMap, "title"));
            ((ImageView) holder.h(2131231460)).setVisibility(u.O(stringObjectMap, "isread").equals("0") ? 0 : 4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements e {
        b() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            SystemMessageListActivity.this.f19728o = 1;
            SystemMessageListActivity.this.u0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = SystemMessageListActivity.this.f19730q / SystemMessageListActivity.this.f19729p;
            int i5 = SystemMessageListActivity.this.f19728o;
            if (SystemMessageListActivity.this.f19730q % SystemMessageListActivity.this.f19729p != 0) {
                i4++;
            }
            if (i5 >= i4) {
                SystemMessageListActivity.this.f19725l.h();
                SystemMessageListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            SystemMessageListActivity.n0(SystemMessageListActivity.this);
            SystemMessageListActivity.this.u0();
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
            SystemMessageListActivity.this.f19725l.y();
            SystemMessageListActivity.this.f19725l.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SystemMessageListActivity.this.f19730q = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (SystemMessageListActivity.this.f19728o == 1) {
                SystemMessageListActivity.this.f19726m = list;
            } else {
                SystemMessageListActivity.this.f19726m.addAll(list);
            }
            SystemMessageListActivity.this.f19727n.g(SystemMessageListActivity.this.f19726m);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            Intent intent = new Intent(((BaseActivity) SystemMessageListActivity.this).f1656h, H5DetailActivity.class);
            intent.putExtra("title", u.O((Map) SystemMessageListActivity.this.f19727n.getItem(position), "title"));
            intent.putExtra("url", u.O((Map) SystemMessageListActivity.this.f19727n.getItem(position), "url"));
            SystemMessageListActivity.this.startActivity(intent);
            ((Map) SystemMessageListActivity.this.f19727n.getItem(position)).put("isread", "1");
            SystemMessageListActivity.this.f19727n.notifyItemChanged(position);
        }
    }

    static /* synthetic */ int n0(SystemMessageListActivity systemMessageListActivity) {
        int i4 = systemMessageListActivity.f19728o;
        systemMessageListActivity.f19728o = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((w.a) Http.getApiService(w.a.class)).O0(LoginUser.getLoginUser().getUserId(), "0", this.f19728o, this.f19729p)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19727n.k(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427443;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f19724k.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427778, this.f19726m);
        this.f19727n = aVar;
        this.f19724k.setAdapter(aVar);
        this.f19725l.n1(new b());
        this.f19725l.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u901a\u77e5\u6d88\u606f");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19724k = (RecyclerView) findViewById(2131232481);
        this.f19725l = (SmartRefreshLayout) findViewById(2131232483);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
