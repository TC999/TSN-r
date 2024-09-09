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
    private SmartRefreshLayout f20347k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f20348l;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20350n;

    /* renamed from: o  reason: collision with root package name */
    private String f20351o;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f20349m = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    protected int f20352p = 10;

    /* renamed from: q  reason: collision with root package name */
    protected int f20353q = 1;

    /* renamed from: r  reason: collision with root package name */
    protected int f20354r = 1;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.teaching.homework.ViewTermActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0234a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f20356a;

            View$OnClickListenerC0234a(final Map val$stringObjectMap) {
                this.f20356a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                ViewTermActivity.this.startActivity(new Intent(((CommonAdapter) a.this).f1707a, ViewLessonActivity.class).putExtra("id", JsonParse.getString(this.f20356a, "id")));
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131232927, JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "sysUserName"));
            holder.J(2131233045, JsonParse.getString(stringObjectMap, "sysUserUserNum"));
            holder.J(2131233169, JsonParse.getString(stringObjectMap, "type"));
            holder.J(2131233146, JsonParse.getString(stringObjectMap, "score"));
            holder.J(2131230989, "\u67e5\u770b\u8bfe\u7a0b");
            holder.w(2131230989, new View$OnClickListenerC0234a(stringObjectMap));
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
            viewTermActivity.f20353q = 1;
            viewTermActivity.l0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            ViewTermActivity viewTermActivity = ViewTermActivity.this;
            int i4 = viewTermActivity.f20354r;
            int i5 = viewTermActivity.f20352p;
            int i6 = i4 / i5;
            int i7 = viewTermActivity.f20353q;
            if (i4 % i5 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                viewTermActivity.f20347k.h();
                Toast.makeText(((BaseActivity) ViewTermActivity.this).f1656h, "\u6ca1\u6709\u4e86", 0).show();
                return;
            }
            viewTermActivity.f20353q = i7 + 1;
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
            ViewTermActivity.this.f20347k.y();
            ViewTermActivity.this.f20347k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewTermActivity.this.f20354r = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d4 = ViewTermActivity.this.f20350n.d();
            if (ViewTermActivity.this.f20353q != 1) {
                d4.addAll(list);
                list = d4;
            }
            ViewTermActivity.this.f20350n.g(list);
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
        this.f20351o = getIntent().getStringExtra("from");
        this.f20348l.setLayoutManager(new LinearLayoutManager(this.f1656h, 1, false));
        a aVar = new a(this.f1656h, 2131427771, this.f20349m);
        this.f20350n = aVar;
        this.f20348l.setAdapter(aVar);
        m0();
        this.f20347k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8bfe\u540e\u4f5c\u4e1a-\u67e5\u770b\u5b66\u671f");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        ((Spinner) findViewById(2131232642)).setVisibility(8);
        this.f20347k = (SmartRefreshLayout) findViewById(2131232483);
        this.f20348l = (RecyclerView) findViewById(2131232481);
    }

    public void l0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((w.a) Http.getApiService(w.a.class)).q0(LoginUser.getLoginUser().getUserId(), this.f20353q, this.f20352p)).setDataListener(new c());
    }

    public void m0() {
        this.f20347k.n1(new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
