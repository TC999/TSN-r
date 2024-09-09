package com.bxkj.competition.newsletter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.R;
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
public class NewsLetterListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f18956k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f18957l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f18958m;

    /* renamed from: n  reason: collision with root package name */
    private Button f18959n;

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f18960o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private int f18961p = 1;

    /* renamed from: q  reason: collision with root package name */
    private int f18962q = 1;

    /* renamed from: r  reason: collision with root package name */
    private int f18963r = 10;

    /* renamed from: s  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18964s;

    /* renamed from: t  reason: collision with root package name */
    private String f18965t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements e {
        a() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            NewsLetterListActivity.this.f18962q = 1;
            NewsLetterListActivity.this.u0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = NewsLetterListActivity.this.f18961p / NewsLetterListActivity.this.f18963r;
            int i5 = NewsLetterListActivity.this.f18962q;
            if (NewsLetterListActivity.this.f18961p % NewsLetterListActivity.this.f18963r != 0) {
                i4++;
            }
            if (i5 >= i4) {
                NewsLetterListActivity.this.f18956k.h();
                NewsLetterListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            NewsLetterListActivity.n0(NewsLetterListActivity.this);
            NewsLetterListActivity.this.u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends CommonAdapter<Map<String, Object>> {
        b(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, "content"));
            holder.J(R.id.tv_status, JsonParse.getString(stringObjectMap, "auditState"));
            holder.J(R.id.tv_time, JsonParse.getString(stringObjectMap, "publishDate"));
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
            NewsLetterListActivity.this.f18956k.y();
            NewsLetterListActivity.this.f18956k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            NewsLetterListActivity.this.f18961p = JsonParse.getInt(data, "total");
            List list = (List) data.get("data");
            if (NewsLetterListActivity.this.f18962q == 1) {
                NewsLetterListActivity.this.f18960o = list;
            } else {
                NewsLetterListActivity.this.f18960o.addAll(list);
            }
            NewsLetterListActivity.this.f18964s.g(NewsLetterListActivity.this.f18960o);
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
            NewsLetterListActivity.this.startActivity(new Intent(((BaseActivity) NewsLetterListActivity.this).f1656h, PostActivity.class).putExtra("content", JsonParse.getString((Map) NewsLetterListActivity.this.f18964s.getItem(position), "content")));
        }
    }

    static /* synthetic */ int n0(NewsLetterListActivity newsLetterListActivity) {
        int i4 = newsLetterListActivity.f18962q;
        newsLetterListActivity.f18962q = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).r(this.f18965t, LoginUser.getLoginUser().getUserId(), this.f18962q, this.f18963r)).setDataListener(new c());
    }

    private void v0() {
        this.f18957l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f18957l.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.f1656h, R.layout.item_for_newsletter, this.f18960o);
        this.f18964s = bVar;
        this.f18957l.setAdapter(bVar);
        this.f18957l.setEmptyView(findViewById(R.id.tv_emptyView));
    }

    private void w0() {
        this.f18956k.n1(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f18964s.k(new d());
        this.f18959n.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_my_newsletter_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f18965t = getIntent().getStringExtra("competitionId");
        }
        w0();
        v0();
        this.f18956k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u901a\u8baf\u7a3f");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f18956k = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.f18957l = (EmptyRecyclerView) findViewById(R.id.recyclerView);
        this.f18958m = (TextView) findViewById(R.id.tv_emptyView);
        this.f18959n = (Button) findViewById(R.id.bt_post);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() == R.id.bt_post) {
            startActivity(new Intent(this.f1656h, PostActivity.class).putExtra("competitionId", this.f18965t));
        }
    }

    public void x0() {
        this.f18956k.a0();
    }
}
