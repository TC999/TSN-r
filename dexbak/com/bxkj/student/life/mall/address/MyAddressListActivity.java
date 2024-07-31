package com.bxkj.student.life.mall.address;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.MallApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MyAddressListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f18339k;

    /* renamed from: l */
    private EmptyRecyclerView f18340l;

    /* renamed from: m */
    private Button f18341m;

    /* renamed from: n */
    private List<Map<String, Object>> f18342n = new ArrayList();

    /* renamed from: o */
    private int f18343o = 1;

    /* renamed from: p */
    private int f18344p = 15;

    /* renamed from: q */
    private int f18345q = 0;

    /* renamed from: r */
    private CommonAdapter<Map<String, Object>> f18346r;

    /* renamed from: s */
    private String f18347s;

    /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4989a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4990a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f18349a;

            /* renamed from: b */
            final /* synthetic */ String f18350b;

            /* renamed from: c */
            final /* synthetic */ String f18351c;

            /* renamed from: d */
            final /* synthetic */ String f18352d;

            /* renamed from: e */
            final /* synthetic */ String f18353e;

            View$OnClickListenerC4990a(final Map val$stringObjectMap, final String val$name, final String val$phone, final String val$city, final String val$address) {
                this.f18349a = val$stringObjectMap;
                this.f18350b = val$name;
                this.f18351c = val$phone;
                this.f18352d = val$city;
                this.f18353e = val$address;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MyAddressListActivity.this.startActivity(new Intent(((CommonAdapter) C4989a.this).f1721a, AddAddressActivity.class).putExtra("addressId", JsonParse.getString(this.f18349a, "id")).putExtra("name", this.f18350b).putExtra("phone", this.f18351c).putExtra(DistrictSearchQuery.KEYWORDS_CITY, this.f18352d).putExtra("areaId", JsonParse.getString(this.f18349a, "cityId")).putExtra("address", this.f18353e));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4991b implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f18355a;

            /* renamed from: b */
            final /* synthetic */ ViewHolder f18356b;

            /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$b$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            class C4992a implements iOSTwoButtonDialog.RightButtonOnClick {

                /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$b$a$a */
                /* loaded from: E:\fuckcool\tsn\5141176.dex */
                class C4993a extends HttpCallBack {
                    C4993a() {
                    }

                    @Override // cn.bluemobi.dylan.http.HttpResponse
                    public void netOnSuccess(Map<String, Object> data) {
                        C4989a.this.m57837d().remove(View$OnClickListenerC4991b.this.f18355a);
                        View$OnClickListenerC4991b view$OnClickListenerC4991b = View$OnClickListenerC4991b.this;
                        C4989a.this.notifyItemRemoved(view$OnClickListenerC4991b.f18356b.m57864f());
                    }
                }

                C4992a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    Http.with(((CommonAdapter) C4989a.this).f1721a).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2242f(JsonParse.getString(View$OnClickListenerC4991b.this.f18355a, "id"))).setDataListener(new C4993a());
                }
            }

            View$OnClickListenerC4991b(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f18355a = val$stringObjectMap;
                this.f18356b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                new iOSTwoButtonDialog(((CommonAdapter) C4989a.this).f1721a).setMessage("确定要删除吗？").setRightButtonOnClickListener(new C4992a()).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$c */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4994c implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ ViewHolder f18360a;

            View$OnClickListenerC4994c(final ViewHolder val$holder) {
                this.f18360a = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MyAddressListActivity.this.m40854x0(this.f18360a.m57864f());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$d */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4995d implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f18362a;

            /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$a$d$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            class C4996a extends HttpCallBack {
                C4996a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    for (Map map : MyAddressListActivity.this.f18342n) {
                        if (View$OnClickListenerC4995d.this.f18362a.equals(map)) {
                            map.put("firstFlag", 1);
                        } else {
                            map.put("firstFlag", 0);
                        }
                    }
                    C4989a.this.notifyDataSetChanged();
                }
            }

            View$OnClickListenerC4995d(final Map val$stringObjectMap) {
                this.f18362a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Http.with(((CommonAdapter) C4989a.this).f1721a).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2225w(JsonParse.getString(this.f18362a, "id"))).setDataListener(new C4996a());
            }
        }

        C4989a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: q */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            String string = JsonParse.getString(stringObjectMap, "receiverName");
            holder.m57874J(2131233040, string);
            String string2 = JsonParse.getString(stringObjectMap, "receiverPhone");
            holder.m57874J(2131233089, string2);
            String string3 = JsonParse.getString(stringObjectMap, "provenceStr");
            String string4 = JsonParse.getString(stringObjectMap, "detailAddress");
            holder.m57874J(2131232841, string3 + string4);
            holder.m57847w(C4215R.C4219id.iv_edit, new View$OnClickListenerC4990a(stringObjectMap, string, string2, string3, string4));
            holder.m57847w(C4215R.C4219id.iv_delete, new View$OnClickListenerC4991b(stringObjectMap, holder));
            if (!TextUtils.isEmpty(MyAddressListActivity.this.f18347s)) {
                holder.m57874J(C4215R.C4219id.cb_default, "选择该地址");
                holder.m57870N(C4215R.C4219id.tv_is_default, true);
                holder.m57870N(C4215R.C4219id.tv_is_default, "1".equals(JsonParse.getString(stringObjectMap, "firstFlag")));
                holder.m57857m(C4215R.C4219id.cb_default, MyAddressListActivity.this.f18347s.equals(JsonParse.getString(stringObjectMap, "id")));
                holder.m57847w(C4215R.C4219id.ll_set_default, new View$OnClickListenerC4994c(holder));
                return;
            }
            holder.m57874J(C4215R.C4219id.cb_default, "设为默认地址");
            holder.m57870N(C4215R.C4219id.tv_is_default, false);
            holder.m57857m(C4215R.C4219id.cb_default, "1".equals(JsonParse.getString(stringObjectMap, "firstFlag")));
            holder.m57847w(C4215R.C4219id.ll_set_default, new View$OnClickListenerC4995d(stringObjectMap));
        }
    }

    /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4997b implements OnItemClickListener {
        C4997b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            MyAddressListActivity.this.m40854x0(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4998c implements OnRefreshLoadmoreListener {
        C4998c() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            MyAddressListActivity.this.f18343o = 1;
            MyAddressListActivity.this.m40857u0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = MyAddressListActivity.this.f18345q / MyAddressListActivity.this.f18344p;
            int i2 = MyAddressListActivity.this.f18343o;
            if (MyAddressListActivity.this.f18345q % MyAddressListActivity.this.f18344p != 0) {
                i++;
            }
            if (i2 >= i) {
                MyAddressListActivity.this.f18339k.mo2041g();
                MyAddressListActivity.this.m57919h0("没有了");
                return;
            }
            MyAddressListActivity.m40858t0(MyAddressListActivity.this);
            MyAddressListActivity.this.m40857u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.address.MyAddressListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4999d extends HttpCallBack {
        C4999d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (MyAddressListActivity.this.f18339k != null && MyAddressListActivity.this.f18339k.mo2061S()) {
                MyAddressListActivity.this.f18339k.mo2078B();
            }
            if (MyAddressListActivity.this.f18339k == null || !MyAddressListActivity.this.f18339k.mo2015z()) {
                return;
            }
            MyAddressListActivity.this.f18339k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyAddressListActivity.this.f18345q = JsonParse.getInt(data, "total");
            if (MyAddressListActivity.this.f18343o == 1) {
                MyAddressListActivity.this.f18342n.clear();
            }
            MyAddressListActivity.this.f18342n.addAll(JsonParse.getList(data, "data"));
            MyAddressListActivity.this.f18346r.notifyDataSetChanged();
        }
    }

    /* renamed from: t0 */
    static /* synthetic */ int m40858t0(MyAddressListActivity myAddressListActivity) {
        int i = myAddressListActivity.f18343o;
        myAddressListActivity.f18343o = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m40857u0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2244d(LoginUser.getLoginUser().getOpenId(), this.f18343o, this.f18344p)).setDataListener(new C4999d());
    }

    /* renamed from: v0 */
    private void m40856v0() {
        this.f18339k.mo2019v(new C4998c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public void m40854x0(int position) {
        Intent intent = new Intent();
        intent.putExtra("id", JsonParse.getString(this.f18346r.getItem(position), "id"));
        intent.putExtra("receiverName", JsonParse.getString(this.f18346r.getItem(position), "receiverName"));
        intent.putExtra("receiverPhone", JsonParse.getString(this.f18346r.getItem(position), "receiverPhone"));
        intent.putExtra("detailAddress", JsonParse.getString(this.f18346r.getItem(position), "provenceStr") + JsonParse.getString(this.f18346r.getItem(position), "detailAddress"));
        setResult(-1, intent);
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18341m.setOnClickListener(this);
        if (TextUtils.isEmpty(this.f18347s)) {
            return;
        }
        this.f18346r.m57834k(new C4997b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_address_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("addressId")) {
            this.f18347s = getIntent().getStringExtra("addressId");
        }
        this.f18340l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4989a c4989a = new C4989a(this.f1669h, C4215R.C4221layout.item_for_address, this.f18342n);
        this.f18346r = c4989a;
        this.f18340l.setAdapter(c4989a);
        this.f18340l.setEmptyView(findViewById(2131232952));
        m40856v0();
        m40855w0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("收货地址");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18339k = (SmartRefreshLayout) findViewById(2131232483);
        this.f18340l = (EmptyRecyclerView) findViewById(C4215R.C4219id.rv_address);
        this.f18341m = (Button) findViewById(2131230950);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131230950) {
            return;
        }
        startActivity(new Intent(this.f1669h, AddAddressActivity.class));
    }

    /* renamed from: w0 */
    public void m40855w0() {
        this.f18339k.mo2052a0();
    }
}
