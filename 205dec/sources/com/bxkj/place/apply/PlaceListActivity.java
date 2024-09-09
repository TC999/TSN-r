package com.bxkj.place.apply;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.ObservableHorizontalScrollView;
import com.bxkj.place.R;
import com.bxkj.place.apply.PlaceListActivity;
import com.bxkj.place.view.MyRecyclerViewOnScrollListener;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.google.android.material.tabs.TabLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PlaceListActivity extends BaseActivity {
    private String A;
    private MyRecyclerViewOnScrollListener B;
    private MyRecyclerViewOnScrollListener C;

    /* renamed from: k  reason: collision with root package name */
    private TextView f19298k;

    /* renamed from: l  reason: collision with root package name */
    private TabLayout f19299l;

    /* renamed from: m  reason: collision with root package name */
    private RecyclerView f19300m;

    /* renamed from: n  reason: collision with root package name */
    private RecyclerView f19301n;

    /* renamed from: o  reason: collision with root package name */
    private RecyclerView f19302o;

    /* renamed from: p  reason: collision with root package name */
    private ObservableHorizontalScrollView f19303p;

    /* renamed from: q  reason: collision with root package name */
    private List<Map<String, Object>> f19304q;

    /* renamed from: r  reason: collision with root package name */
    private CommonAdapter<String> f19305r;

    /* renamed from: s  reason: collision with root package name */
    private List<String> f19306s;

    /* renamed from: t  reason: collision with root package name */
    private Button f19307t;

    /* renamed from: u  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19308u;

    /* renamed from: v  reason: collision with root package name */
    private List<Map<String, Object>> f19309v;

    /* renamed from: w  reason: collision with root package name */
    private int f19310w;

    /* renamed from: x  reason: collision with root package name */
    private String f19311x;

    /* renamed from: y  reason: collision with root package name */
    private String f19312y;

    /* renamed from: z  reason: collision with root package name */
    private String f19313z = "";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<String> {
        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(final ViewHolder holder, final String s3) {
            holder.J(R.id.tv_name, s3);
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

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(final String showStatus, final Map stringObjectMap, View v3) {
            if ("1".equals(showStatus)) {
                PlaceListActivity.this.h0("\u5df2\u88ab\u9884\u7ea6");
            } else if ("2".equals(showStatus)) {
                PlaceListActivity.this.h0("\u65f6\u95f4\u5df2\u8fc7");
            } else if ("3".equals(showStatus)) {
                PlaceListActivity.this.h0("\u672a\u5f00\u653e");
            } else if ("4".equals(showStatus)) {
                PlaceListActivity.this.h0("\u5df2\u7981\u7528");
            } else {
                PlaceListActivity.this.f19298k.setVisibility(0);
                TextView textView = PlaceListActivity.this.f19298k;
                textView.setText(JsonParse.getString(stringObjectMap, "fieldName") + "\u3000" + JsonParse.getString(stringObjectMap, "startTime") + "-" + JsonParse.getString(stringObjectMap, "endTime"));
                PlaceListActivity.this.f19298k.setTag(JsonParse.getString(stringObjectMap, "id"));
                PlaceListActivity.this.f19307t.setTag(JsonParse.getString(stringObjectMap, "isParty"));
                PlaceListActivity.this.f19307t.setEnabled(true);
                PlaceListActivity.this.f19308u.g(PlaceListActivity.this.f19304q);
            }
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            if (JsonParse.getString(stringObjectMap, "id").isEmpty()) {
                ((LinearLayout) holder.h(R.id.ll_root)).setPadding(0, 0, 0, 0);
                holder.N(R.id.tv_name, false);
            } else {
                ((LinearLayout) holder.h(R.id.ll_root)).setPadding(1, 1, 1, 1);
                int i4 = R.id.tv_name;
                holder.N(i4, true);
                holder.J(i4, JsonParse.getString(stringObjectMap, "startTime") + "-" + JsonParse.getString(stringObjectMap, "endTime"));
            }
            String str = (String) PlaceListActivity.this.f19298k.getTag();
            final String string = JsonParse.getString(stringObjectMap, "showStatus");
            if (str != null && str.equals(JsonParse.getString(stringObjectMap, "id"))) {
                holder.k(R.id.tv_name, PlaceListActivity.this.getResources().getColor(R.color.themeColor));
            } else if ("0".equals(string)) {
                holder.k(R.id.tv_name, PlaceListActivity.this.getResources().getColor(R.color.colorWhite));
            } else if ("1".equals(string)) {
                holder.k(R.id.tv_name, PlaceListActivity.this.getResources().getColor(R.color.textColorGray));
            } else if ("2".equals(string)) {
                holder.k(R.id.tv_name, PlaceListActivity.this.getResources().getColor(R.color.cardBlue));
            } else if ("3".equals(string)) {
                holder.k(R.id.tv_name, PlaceListActivity.this.getResources().getColor(R.color.cardYellow));
            } else if ("4".equals(string)) {
                holder.k(R.id.tv_name, PlaceListActivity.this.getResources().getColor(R.color.color_red));
            }
            holder.w(R.id.tv_name, new View.OnClickListener() { // from class: com.bxkj.place.apply.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlaceListActivity.b.this.o(string, stringObjectMap, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        private TabLayout.OnTabSelectedListener f19316a = new a();

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements TabLayout.OnTabSelectedListener {
            a() {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                PlaceListActivity.this.f19313z = tab.getText().toString().trim();
                PlaceListActivity.this.E0();
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        }

        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if (TextUtils.isEmpty(msg)) {
                return;
            }
            new iOSOneButtonDialog(((BaseActivity) PlaceListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            if (!u.b0(msg)) {
                new iOSOneButtonDialog(((BaseActivity) PlaceListActivity.this).f1656h).setMessage(msg).show();
            }
            PlaceListActivity.this.R().setVisibility(0);
            List<String> list = JsonParse.getList(data, "dateList", String.class);
            PlaceListActivity.this.f19299l.clearOnTabSelectedListeners();
            PlaceListActivity.this.f19299l.removeAllTabs();
            for (String str : list) {
                String replace = str.replace(TTPathConst.sSeparator, "\n");
                TabLayout.Tab text = PlaceListActivity.this.f19299l.newTab().setText(replace);
                PlaceListActivity.this.f19299l.addTab(text);
                if (replace.equals(PlaceListActivity.this.f19313z)) {
                    text.select();
                }
            }
            PlaceListActivity.this.f19299l.addOnTabSelectedListener(this.f19316a);
            PlaceListActivity.this.f19309v = JsonParse.getList(data, "fieldPlanList");
            PlaceListActivity.this.f19306s = new ArrayList();
            int i4 = 0;
            for (Map map : PlaceListActivity.this.f19309v) {
                PlaceListActivity.this.f19306s.add(JsonParse.getString(map, "name"));
                List<Map<String, Object>> list2 = JsonParse.getList(map, "time");
                if (list2.size() > i4) {
                    i4 = list2.size();
                }
            }
            PlaceListActivity.this.f19305r.g(PlaceListActivity.this.f19306s);
            PlaceListActivity.this.f19304q = new ArrayList();
            int size = PlaceListActivity.this.f19306s.size();
            for (int i5 = 0; i5 < i4; i5++) {
                for (int i6 = 0; i6 < size; i6++) {
                    List<Map<String, Object>> list3 = JsonParse.getList((Map) PlaceListActivity.this.f19309v.get(i6), "time");
                    Map<String, Object> arrayMap = new ArrayMap<>();
                    if (i5 < list3.size()) {
                        arrayMap = list3.get(i5);
                    }
                    PlaceListActivity.this.f19304q.add(arrayMap);
                }
            }
            if (PlaceListActivity.this.f19304q.size() > 0) {
                PlaceListActivity.this.f19302o.setLayoutManager(new GridLayoutManager(((BaseActivity) PlaceListActivity.this).f1656h, PlaceListActivity.this.f19306s.size(), 1, false));
            }
            PlaceListActivity.this.f19308u.g(PlaceListActivity.this.f19304q);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d implements RecyclerView.OnItemTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private int f19319a;

        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e4) {
            if (rv.getScrollState() == 0) {
                onTouchEvent(rv, e4);
                return false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e4) {
            if (e4.getAction() == 0 && PlaceListActivity.this.f19302o.getScrollState() == 0) {
                this.f19319a = rv.getScrollY();
                rv.addOnScrollListener(PlaceListActivity.this.B);
            } else if (e4.getAction() == 1 && rv.getScrollY() == this.f19319a) {
                rv.removeOnScrollListener(PlaceListActivity.this.B);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class e implements RecyclerView.OnItemTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private int f19321a;

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e4) {
            if (rv.getScrollState() == 0) {
                onTouchEvent(rv, e4);
                return false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e4) {
            if (e4.getAction() == 0 && PlaceListActivity.this.f19300m.getScrollState() == 0) {
                this.f19321a = rv.getScrollY();
                rv.addOnScrollListener(PlaceListActivity.this.C);
            } else if (e4.getAction() == 1 && rv.getScrollY() == this.f19321a) {
                rv.removeOnScrollListener(PlaceListActivity.this.C);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PlaceListActivity.this.E0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(ObservableHorizontalScrollView scrollView, int x3, int y3, int oldx, int oldy) {
        this.f19302o.removeOnScrollListener(this.C);
        this.f19300m.removeOnScrollListener(this.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0() {
        startActivity(getIntent().setClass(this.f1656h, ApplyIntroductionActivity.class));
    }

    public void E0() {
        this.f19298k.setVisibility(8);
        this.f19298k.setText("");
        this.f19298k.setTag(null);
        this.f19307t.setEnabled(false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        TabLayout tabLayout = this.f19299l;
        if (tabLayout.getTabAt(tabLayout.getSelectedTabPosition()) != null) {
            try {
                TabLayout tabLayout2 = this.f19299l;
                format = simpleDateFormat.format(simpleDateFormat.parse(tabLayout2.getTabAt(tabLayout2.getSelectedTabPosition()).getText().toString().trim()));
            } catch (ParseException e4) {
                e4.printStackTrace();
            }
        }
        Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((v.b) Http.getApiService(v.b.class)).k(LoginUser.getLoginUser().getUserId(), this.f19310w, this.f19312y, format)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.B = new MyRecyclerViewOnScrollListener(this.f19302o);
        this.C = new MyRecyclerViewOnScrollListener(this.f19300m);
        this.f19300m.addOnItemTouchListener(new d());
        this.f19302o.addOnItemTouchListener(new e());
        this.f19303p.setScrollViewListener(new ObservableHorizontalScrollView.a() { // from class: com.bxkj.place.apply.b
            @Override // com.bxkj.base.view.ObservableHorizontalScrollView.a
            public final void a(ObservableHorizontalScrollView observableHorizontalScrollView, int i4, int i5, int i6, int i7) {
                PlaceListActivity.this.F0(observableHorizontalScrollView, i4, i5, i6, i7);
            }
        });
        this.f19307t.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_place_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("id")) {
            this.f19312y = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("appointType")) {
            this.f19310w = getIntent().getIntExtra("appointType", 1);
        }
        this.f19307t.setText(this.f19310w == 2 ? "\u7acb\u5373\u7533\u8bf7" : "\u7acb\u5373\u9884\u7ea6");
        int i4 = this.f19310w;
        this.f19311x = i4 == 2 ? "\u7533\u8bf7" : "\u7acb\u9884\u7ea6";
        setTitle(i4 == 2 ? "\u7533\u8bf7\u573a\u5730" : "\u9884\u7ea6\u573a\u5730");
        this.f19301n.setLayoutManager(new LinearLayoutManager(this.f1656h, 0, false));
        a aVar = new a(this.f1656h, R.layout.item_for_place_name, this.f19306s);
        this.f19305r = aVar;
        this.f19301n.setAdapter(aVar);
        b bVar = new b(this.f1656h, R.layout.item_for_place_checked, this.f19304q);
        this.f19308u = bVar;
        this.f19302o.setAdapter(bVar);
        E0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7533\u8bf7\u573a\u5730");
        b0(R.mipmap.help, new BaseActivity.c() { // from class: com.bxkj.place.apply.a
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                PlaceListActivity.this.G0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19298k = (TextView) findViewById(R.id.tv_order);
        this.f19299l = (TabLayout) findViewById(R.id.tb_date);
        this.f19301n = (RecyclerView) findViewById(R.id.rv_top);
        this.f19302o = (RecyclerView) findViewById(R.id.recyclerView);
        this.f19300m = (RecyclerView) findViewById(R.id.rv_left);
        this.f19303p = (ObservableHorizontalScrollView) findViewById(R.id.hs);
        this.f19307t = (Button) findViewById(R.id.bt_ok);
        R().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != R.id.bt_ok || this.f19307t.getTag() == null) {
            return;
        }
        if (!this.f19307t.getTag().toString().trim().equals("1") && this.f19310w != 2) {
            Http.with(this.f1656h).setObservable(((v.b) Http.getApiService(v.b.class)).i(LoginUser.getLoginUser().getUserId(), (String) this.f19298k.getTag(), "", "", this.f19310w, "1")).setDataListener(new f());
            return;
        }
        Intent intent = new Intent(this.f1656h, ApplyPlaceActivity.class);
        TabLayout tabLayout = this.f19299l;
        startActivity(intent.putExtra("date", tabLayout.getTabAt(tabLayout.getSelectedTabPosition()).getText()).putExtra("id", (String) this.f19298k.getTag()).putExtra("appointType", this.f19310w));
    }
}
