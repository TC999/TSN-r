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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.C4215R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SystemMessageListActivity extends BaseActivity {

    /* renamed from: k */
    private RecyclerView f16334k;

    /* renamed from: l */
    private SmartRefreshLayout f16335l;

    /* renamed from: m */
    private List<Map<String, Object>> f16336m;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f16337n;

    /* renamed from: o */
    private int f16338o = 1;

    /* renamed from: p */
    private int f16339p = 12;

    /* renamed from: q */
    private int f16340q = 1;

    /* renamed from: com.bxkj.student.home.message.SystemMessageListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4316a extends CommonAdapter<Map<String, Object>> {
        C4316a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233204, Tools.m57632O(stringObjectMap, "title"));
            ((ImageView) holder.m57862h(C4215R.C4219id.iv_not_read)).setVisibility(Tools.m57632O(stringObjectMap, "isread").equals("0") ? 0 : 4);
        }
    }

    /* renamed from: com.bxkj.student.home.message.SystemMessageListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4317b implements OnRefreshLoadmoreListener {
        C4317b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            SystemMessageListActivity.this.f16338o = 1;
            SystemMessageListActivity.this.m42696u0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = SystemMessageListActivity.this.f16340q / SystemMessageListActivity.this.f16339p;
            int i2 = SystemMessageListActivity.this.f16338o;
            if (SystemMessageListActivity.this.f16340q % SystemMessageListActivity.this.f16339p != 0) {
                i++;
            }
            if (i2 >= i) {
                SystemMessageListActivity.this.f16335l.mo2041g();
                SystemMessageListActivity.this.m57919h0("没有了");
                return;
            }
            SystemMessageListActivity.m42703n0(SystemMessageListActivity.this);
            SystemMessageListActivity.this.m42696u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.message.SystemMessageListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4318c extends HttpCallBack {
        C4318c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            SystemMessageListActivity.this.f16335l.mo2078B();
            SystemMessageListActivity.this.f16335l.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SystemMessageListActivity.this.f16340q = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            if (SystemMessageListActivity.this.f16338o == 1) {
                SystemMessageListActivity.this.f16336m = list;
            } else {
                SystemMessageListActivity.this.f16336m.addAll(list);
            }
            SystemMessageListActivity.this.f16337n.m57836g(SystemMessageListActivity.this.f16336m);
        }
    }

    /* renamed from: com.bxkj.student.home.message.SystemMessageListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4319d implements OnItemClickListener {
        C4319d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            Intent intent = new Intent(((BaseActivity) SystemMessageListActivity.this).f1669h, H5DetailActivity.class);
            intent.putExtra("title", Tools.m57632O((Map) SystemMessageListActivity.this.f16337n.getItem(position), "title"));
            intent.putExtra("url", Tools.m57632O((Map) SystemMessageListActivity.this.f16337n.getItem(position), "url"));
            SystemMessageListActivity.this.startActivity(intent);
            ((Map) SystemMessageListActivity.this.f16337n.getItem(position)).put("isread", "1");
            SystemMessageListActivity.this.f16337n.notifyItemChanged(position);
        }
    }

    /* renamed from: n0 */
    static /* synthetic */ int m42703n0(SystemMessageListActivity systemMessageListActivity) {
        int i = systemMessageListActivity.f16338o;
        systemMessageListActivity.f16338o = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m42696u0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m152O0(LoginUser.getLoginUser().getUserId(), "0", this.f16338o, this.f16339p)).setDataListener(new C4318c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16337n.m57834k(new C4319d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_notify;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f16334k.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4316a c4316a = new C4316a(this.f1669h, C4215R.C4221layout.item_notice, this.f16336m);
        this.f16337n = c4316a;
        this.f16334k.setAdapter(c4316a);
        this.f16335l.mo2019v(new C4317b());
        this.f16335l.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("通知消息");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16334k = (RecyclerView) findViewById(2131232481);
        this.f16335l = (SmartRefreshLayout) findViewById(2131232483);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
