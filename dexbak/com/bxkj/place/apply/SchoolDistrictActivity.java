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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.place.C4159R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p650v.PlaceApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SchoolDistrictActivity extends BaseActivity {

    /* renamed from: k */
    private Spinner f15845k;

    /* renamed from: l */
    private RecyclerView f15846l;

    /* renamed from: m */
    private TextView f15847m;

    /* renamed from: n */
    private TextView f15848n;

    /* renamed from: o */
    private TextView f15849o;

    /* renamed from: p */
    private List<Map<String, Object>> f15850p = new ArrayList();

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f15851q;

    /* renamed from: r */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter<Map<String, Object>> f15852r;

    /* renamed from: com.bxkj.place.apply.SchoolDistrictActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4183a extends cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter<Map<String, Object>> {
        C4183a(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(C4159R.C4163id.tv_name, JsonParse.getString(stringObjectMap, "name"));
        }
    }

    /* renamed from: com.bxkj.place.apply.SchoolDistrictActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4184b extends CommonAdapter<Map<String, Object>> {
        C4184b(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57851s(C4159R.C4163id.imageView, JsonParse.getString(stringObjectMap, "picture"));
            holder.m57874J(C4159R.C4163id.tv_name, JsonParse.getString(stringObjectMap, "name"));
        }
    }

    /* renamed from: com.bxkj.place.apply.SchoolDistrictActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4185c implements OnItemClickListener {
        C4185c() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            SchoolDistrictActivity schoolDistrictActivity = SchoolDistrictActivity.this;
            schoolDistrictActivity.startActivity(schoolDistrictActivity.getIntent().setClass(((BaseActivity) SchoolDistrictActivity.this).f1669h, PlaceListActivity.class).putExtra("id", Tools.m57632O((Map) SchoolDistrictActivity.this.f15851q.getItem(position), "id")));
        }
    }

    /* renamed from: com.bxkj.place.apply.SchoolDistrictActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4186d implements AdapterView.OnItemSelectedListener {
        C4186d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            SchoolDistrictActivity schoolDistrictActivity = SchoolDistrictActivity.this;
            schoolDistrictActivity.m43035s0(JsonParse.getString((Map) schoolDistrictActivity.f15852r.getItem(position), "id"));
            TextView textView = SchoolDistrictActivity.this.f15847m;
            textView.setText("校区地址：" + JsonParse.getString((Map) SchoolDistrictActivity.this.f15852r.getItem(position), "address"));
            TextView textView2 = SchoolDistrictActivity.this.f15848n;
            textView2.setText("联系人\u3000：" + JsonParse.getString((Map) SchoolDistrictActivity.this.f15852r.getItem(position), "linkUser"));
            TextView textView3 = SchoolDistrictActivity.this.f15849o;
            textView3.setText("联系电话：" + JsonParse.getString((Map) SchoolDistrictActivity.this.f15852r.getItem(position), "phoneNum"));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.place.apply.SchoolDistrictActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4187e extends HttpCallBack {
        C4187e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SchoolDistrictActivity.this.m57932R().setVisibility(0);
            SchoolDistrictActivity.this.f15850p = (List) data.get("data");
            SchoolDistrictActivity.this.f15852r.m57842c(SchoolDistrictActivity.this.f15850p);
            for (int i = 0; i < SchoolDistrictActivity.this.f15850p.size(); i++) {
                if ("1".equals(JsonParse.getString((Map) SchoolDistrictActivity.this.f15850p.get(i), "isDefault"))) {
                    SchoolDistrictActivity.this.f15845k.setSelection(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.place.apply.SchoolDistrictActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4188f extends HttpCallBack {
        C4188f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SchoolDistrictActivity.this.f15851q.m57836g((List) data.get("data"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public void m43035s0(String campusId) {
        Http.with(this.f1669h).setObservable(((PlaceApiService) Http.getApiService(PlaceApiService.class)).m211j(campusId)).setDataListener(new C4188f());
    }

    /* renamed from: t0 */
    private void m43034t0() {
        Http.with(this.f1669h).setObservable(((PlaceApiService) Http.getApiService(PlaceApiService.class)).m216b()).setDataListener(new C4187e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15851q.m57834k(new C4185c());
        this.f15845k.setOnItemSelectedListener(new C4186d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4159R.C4165layout.ac_school_district;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        C4183a c4183a = new C4183a(this.f1669h, C4159R.C4165layout.item_for_school_district_list, this.f15850p);
        this.f15852r = c4183a;
        this.f15845k.setAdapter((SpinnerAdapter) c4183a);
        this.f15846l.setLayoutManager(new GridLayoutManager(this.f1669h, 4, 1, false));
        C4184b c4184b = new C4184b(this.f1669h, C4159R.C4165layout.item_for_sport_typeu, this.f15850p);
        this.f15851q = c4184b;
        this.f15846l.setAdapter(c4184b);
        m43034t0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("选择项目");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15845k = (Spinner) findViewById(C4159R.C4163id.spinner);
        this.f15846l = (RecyclerView) findViewById(C4159R.C4163id.recyclerView);
        this.f15847m = (TextView) findViewById(C4159R.C4163id.tv_address);
        this.f15848n = (TextView) findViewById(C4159R.C4163id.tv_user);
        this.f15849o = (TextView) findViewById(C4159R.C4163id.tv_phone);
        m57932R().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
