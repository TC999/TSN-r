package com.bxkj.place.apply;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.place.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SchoolDistrictActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private Spinner f19324k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f19325l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f19326m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f19327n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f19328o;

    /* renamed from: p  reason: collision with root package name */
    private List<Map<String, Object>> f19329p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19330q;

    /* renamed from: r  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f19331r;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, "name"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.s(R.id.imageView, JsonParse.getString(stringObjectMap, "picture"));
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, "name"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        c() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            SchoolDistrictActivity schoolDistrictActivity = SchoolDistrictActivity.this;
            schoolDistrictActivity.startActivity(schoolDistrictActivity.getIntent().setClass(((BaseActivity) SchoolDistrictActivity.this).f1656h, PlaceListActivity.class).putExtra("id", u.O((Map) SchoolDistrictActivity.this.f19330q.getItem(position), "id")));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SchoolDistrictActivity schoolDistrictActivity = SchoolDistrictActivity.this;
            schoolDistrictActivity.s0(JsonParse.getString((Map) schoolDistrictActivity.f19331r.getItem(position), "id"));
            TextView textView = SchoolDistrictActivity.this.f19326m;
            textView.setText("\u6821\u533a\u5730\u5740\uff1a" + JsonParse.getString((Map) SchoolDistrictActivity.this.f19331r.getItem(position), "address"));
            TextView textView2 = SchoolDistrictActivity.this.f19327n;
            textView2.setText("\u8054\u7cfb\u4eba\u3000\uff1a" + JsonParse.getString((Map) SchoolDistrictActivity.this.f19331r.getItem(position), "linkUser"));
            TextView textView3 = SchoolDistrictActivity.this.f19328o;
            textView3.setText("\u8054\u7cfb\u7535\u8bdd\uff1a" + JsonParse.getString((Map) SchoolDistrictActivity.this.f19331r.getItem(position), "phoneNum"));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SchoolDistrictActivity.this.R().setVisibility(0);
            SchoolDistrictActivity.this.f19329p = (List) data.get("data");
            SchoolDistrictActivity.this.f19331r.c(SchoolDistrictActivity.this.f19329p);
            for (int i4 = 0; i4 < SchoolDistrictActivity.this.f19329p.size(); i4++) {
                if ("1".equals(JsonParse.getString((Map) SchoolDistrictActivity.this.f19329p.get(i4), "isDefault"))) {
                    SchoolDistrictActivity.this.f19324k.setSelection(i4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SchoolDistrictActivity.this.f19330q.g((List) data.get("data"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(String campusId) {
        Http.with(this.f1656h).setObservable(((v.b) Http.getApiService(v.b.class)).j(campusId)).setDataListener(new f());
    }

    private void t0() {
        Http.with(this.f1656h).setObservable(((v.b) Http.getApiService(v.b.class)).b()).setDataListener(new e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19330q.k(new c());
        this.f19324k.setOnItemSelectedListener(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_school_district;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        a aVar = new a(this.f1656h, R.layout.item_for_school_district_list, this.f19329p);
        this.f19331r = aVar;
        this.f19324k.setAdapter((SpinnerAdapter) aVar);
        this.f19325l.setLayoutManager(new GridLayoutManager(this.f1656h, 4, 1, false));
        b bVar = new b(this.f1656h, R.layout.item_for_sport_typeu, this.f19329p);
        this.f19330q = bVar;
        this.f19325l.setAdapter(bVar);
        t0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9009\u62e9\u9879\u76ee");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19324k = (Spinner) findViewById(R.id.spinner);
        this.f19325l = (RecyclerView) findViewById(R.id.recyclerView);
        this.f19326m = (TextView) findViewById(R.id.tv_address);
        this.f19327n = (TextView) findViewById(R.id.tv_user);
        this.f19328o = (TextView) findViewById(R.id.tv_phone);
        R().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
