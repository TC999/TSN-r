package com.bxkj.student.personal.sign;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q.f;
import r0.h;
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SignRecordListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f22215k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f22216l;

    /* renamed from: n  reason: collision with root package name */
    private int f22218n;

    /* renamed from: o  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f22219o;

    /* renamed from: p  reason: collision with root package name */
    private com.bxkj.student.life.mall.order.a f22220p;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f22217m = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private int f22221q = 1;

    /* renamed from: r  reason: collision with root package name */
    private int f22222r = 15;

    /* renamed from: s  reason: collision with root package name */
    private int f22223s = 0;

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
            holder.J(2131233040, "\u79ef\u5206+" + JsonParse.getString(stringObjectMap, "integral"));
            holder.J(2131233198, JsonParse.getString(stringObjectMap, "integralDate"));
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
            SignRecordListActivity.this.f22221q = 1;
            SignRecordListActivity.this.s0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = SignRecordListActivity.this.f22223s / SignRecordListActivity.this.f22222r;
            int i5 = SignRecordListActivity.this.f22221q;
            if (SignRecordListActivity.this.f22223s % SignRecordListActivity.this.f22222r != 0) {
                i4++;
            }
            if (i5 >= i4) {
                SignRecordListActivity.this.f22215k.h();
                SignRecordListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            SignRecordListActivity.n0(SignRecordListActivity.this);
            SignRecordListActivity.this.s0();
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
            if (SignRecordListActivity.this.f22215k != null && SignRecordListActivity.this.f22215k.S()) {
                SignRecordListActivity.this.f22215k.y();
            }
            if (SignRecordListActivity.this.f22215k == null || !SignRecordListActivity.this.f22215k.z()) {
                return;
            }
            SignRecordListActivity.this.f22215k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SignRecordListActivity.this.f22223s = JsonParse.getInt(data, "total");
            if (SignRecordListActivity.this.f22221q == 1) {
                SignRecordListActivity.this.f22217m.clear();
            }
            SignRecordListActivity.this.f22217m.addAll(JsonParse.getList(data, "data"));
            SignRecordListActivity.this.f22219o.notifyDataSetChanged();
        }
    }

    static /* synthetic */ int n0(SignRecordListActivity signRecordListActivity) {
        int i4 = signRecordListActivity.f22221q;
        signRecordListActivity.f22221q = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((f) Http.getApiService(f.class)).w(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getAccount(), this.f22221q, this.f22222r)).setDataListener(new c());
    }

    private void t0() {
        this.f22215k.n1(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f22216l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427764, this.f22217m);
        this.f22219o = aVar;
        this.f22216l.setAdapter(aVar);
        this.f22216l.setEmptyView(findViewById(2131232952));
        t0();
        this.f22215k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7b7e\u5230\u8bb0\u5f55");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22215k = (SmartRefreshLayout) findViewById(2131232482);
        this.f22216l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
