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
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.ObservableHorizontalScrollView;
import com.bxkj.place.C4159R;
import com.bxkj.place.apply.PlaceListActivity;
import com.bxkj.place.view.MyRecyclerViewOnScrollListener;
import com.google.android.material.tabs.TabLayout;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.umeng.analytics.AnalyticsConfig;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import p650v.PlaceApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PlaceListActivity extends BaseActivity {

    /* renamed from: A */
    private String f15816A;

    /* renamed from: B */
    private MyRecyclerViewOnScrollListener f15817B;

    /* renamed from: C */
    private MyRecyclerViewOnScrollListener f15818C;

    /* renamed from: k */
    private TextView f15819k;

    /* renamed from: l */
    private TabLayout f15820l;

    /* renamed from: m */
    private RecyclerView f15821m;

    /* renamed from: n */
    private RecyclerView f15822n;

    /* renamed from: o */
    private RecyclerView f15823o;

    /* renamed from: p */
    private ObservableHorizontalScrollView f15824p;

    /* renamed from: q */
    private List<Map<String, Object>> f15825q;

    /* renamed from: r */
    private CommonAdapter<String> f15826r;

    /* renamed from: s */
    private List<String> f15827s;

    /* renamed from: t */
    private Button f15828t;

    /* renamed from: u */
    private CommonAdapter<Map<String, Object>> f15829u;

    /* renamed from: v */
    private List<Map<String, Object>> f15830v;

    /* renamed from: w */
    private int f15831w;

    /* renamed from: x */
    private String f15832x;

    /* renamed from: y */
    private String f15833y;

    /* renamed from: z */
    private String f15834z = "";

    /* renamed from: com.bxkj.place.apply.PlaceListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4176a extends CommonAdapter<String> {
        C4176a(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final String s) {
            holder.m57874J(C4159R.C4163id.tv_name, s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.place.apply.PlaceListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4177b extends CommonAdapter<Map<String, Object>> {
        C4177b(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void m43046o(final String showStatus, final Map stringObjectMap, View v) {
            if ("1".equals(showStatus)) {
                PlaceListActivity.this.m57919h0("已被预约");
            } else if ("2".equals(showStatus)) {
                PlaceListActivity.this.m57919h0("时间已过");
            } else if ("3".equals(showStatus)) {
                PlaceListActivity.this.m57919h0("未开放");
            } else if ("4".equals(showStatus)) {
                PlaceListActivity.this.m57919h0("已禁用");
            } else {
                PlaceListActivity.this.f15819k.setVisibility(0);
                TextView textView = PlaceListActivity.this.f15819k;
                textView.setText(JsonParse.getString(stringObjectMap, "fieldName") + "\u3000" + JsonParse.getString(stringObjectMap, AnalyticsConfig.RTD_START_TIME) + "-" + JsonParse.getString(stringObjectMap, "endTime"));
                PlaceListActivity.this.f15819k.setTag(JsonParse.getString(stringObjectMap, "id"));
                PlaceListActivity.this.f15828t.setTag(JsonParse.getString(stringObjectMap, "isParty"));
                PlaceListActivity.this.f15828t.setEnabled(true);
                PlaceListActivity.this.f15829u.m57836g(PlaceListActivity.this.f15825q);
            }
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            if (JsonParse.getString(stringObjectMap, "id").isEmpty()) {
                ((LinearLayout) holder.m57862h(C4159R.C4163id.ll_root)).setPadding(0, 0, 0, 0);
                holder.m57870N(C4159R.C4163id.tv_name, false);
            } else {
                ((LinearLayout) holder.m57862h(C4159R.C4163id.ll_root)).setPadding(1, 1, 1, 1);
                int i = C4159R.C4163id.tv_name;
                holder.m57870N(i, true);
                holder.m57874J(i, JsonParse.getString(stringObjectMap, AnalyticsConfig.RTD_START_TIME) + "-" + JsonParse.getString(stringObjectMap, "endTime"));
            }
            String str = (String) PlaceListActivity.this.f15819k.getTag();
            final String string = JsonParse.getString(stringObjectMap, "showStatus");
            if (str != null && str.equals(JsonParse.getString(stringObjectMap, "id"))) {
                holder.m57859k(C4159R.C4163id.tv_name, PlaceListActivity.this.getResources().getColor(C4159R.C4161color.themeColor));
            } else if ("0".equals(string)) {
                holder.m57859k(C4159R.C4163id.tv_name, PlaceListActivity.this.getResources().getColor(C4159R.C4161color.colorWhite));
            } else if ("1".equals(string)) {
                holder.m57859k(C4159R.C4163id.tv_name, PlaceListActivity.this.getResources().getColor(C4159R.C4161color.textColorGray));
            } else if ("2".equals(string)) {
                holder.m57859k(C4159R.C4163id.tv_name, PlaceListActivity.this.getResources().getColor(C4159R.C4161color.cardBlue));
            } else if ("3".equals(string)) {
                holder.m57859k(C4159R.C4163id.tv_name, PlaceListActivity.this.getResources().getColor(C4159R.C4161color.cardYellow));
            } else if ("4".equals(string)) {
                holder.m57859k(C4159R.C4163id.tv_name, PlaceListActivity.this.getResources().getColor(C4159R.C4161color.color_red));
            }
            holder.m57847w(C4159R.C4163id.tv_name, new View.OnClickListener() { // from class: com.bxkj.place.apply.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlaceListActivity.C4177b.this.m43046o(string, stringObjectMap, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.place.apply.PlaceListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4178c extends HttpCallBack {

        /* renamed from: a */
        private TabLayout.OnTabSelectedListener f15837a = new C4179a();

        /* renamed from: com.bxkj.place.apply.PlaceListActivity$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4179a implements TabLayout.OnTabSelectedListener {
            C4179a() {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                PlaceListActivity.this.f15834z = tab.getText().toString().trim();
                PlaceListActivity.this.m43070E0();
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        }

        C4178c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if (TextUtils.isEmpty(msg)) {
                return;
            }
            new iOSOneButtonDialog(((BaseActivity) PlaceListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            if (!Tools.m57617b0(msg)) {
                new iOSOneButtonDialog(((BaseActivity) PlaceListActivity.this).f1669h).setMessage(msg).show();
            }
            PlaceListActivity.this.m57932R().setVisibility(0);
            List<String> list = JsonParse.getList(data, "dateList", String.class);
            PlaceListActivity.this.f15820l.clearOnTabSelectedListeners();
            PlaceListActivity.this.f15820l.removeAllTabs();
            for (String str : list) {
                String replace = str.replace("/", ShellAdbUtils.f33810d);
                TabLayout.Tab text = PlaceListActivity.this.f15820l.newTab().setText(replace);
                PlaceListActivity.this.f15820l.addTab(text);
                if (replace.equals(PlaceListActivity.this.f15834z)) {
                    text.select();
                }
            }
            PlaceListActivity.this.f15820l.addOnTabSelectedListener(this.f15837a);
            PlaceListActivity.this.f15830v = JsonParse.getList(data, "fieldPlanList");
            PlaceListActivity.this.f15827s = new ArrayList();
            int i = 0;
            for (Map map : PlaceListActivity.this.f15830v) {
                PlaceListActivity.this.f15827s.add(JsonParse.getString(map, "name"));
                List<Map<String, Object>> list2 = JsonParse.getList(map, RtspHeaders.Values.TIME);
                if (list2.size() > i) {
                    i = list2.size();
                }
            }
            PlaceListActivity.this.f15826r.m57836g(PlaceListActivity.this.f15827s);
            PlaceListActivity.this.f15825q = new ArrayList();
            int size = PlaceListActivity.this.f15827s.size();
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < size; i3++) {
                    List<Map<String, Object>> list3 = JsonParse.getList((Map) PlaceListActivity.this.f15830v.get(i3), RtspHeaders.Values.TIME);
                    Map<String, Object> arrayMap = new ArrayMap<>();
                    if (i2 < list3.size()) {
                        arrayMap = list3.get(i2);
                    }
                    PlaceListActivity.this.f15825q.add(arrayMap);
                }
            }
            if (PlaceListActivity.this.f15825q.size() > 0) {
                PlaceListActivity.this.f15823o.setLayoutManager(new GridLayoutManager(((BaseActivity) PlaceListActivity.this).f1669h, PlaceListActivity.this.f15827s.size(), 1, false));
            }
            PlaceListActivity.this.f15829u.m57836g(PlaceListActivity.this.f15825q);
        }
    }

    /* renamed from: com.bxkj.place.apply.PlaceListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4180d implements RecyclerView.OnItemTouchListener {

        /* renamed from: a */
        private int f15840a;

        C4180d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            if (rv.getScrollState() == 0) {
                onTouchEvent(rv, e);
                return false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            if (e.getAction() == 0 && PlaceListActivity.this.f15823o.getScrollState() == 0) {
                this.f15840a = rv.getScrollY();
                rv.addOnScrollListener(PlaceListActivity.this.f15817B);
            } else if (e.getAction() == 1 && rv.getScrollY() == this.f15840a) {
                rv.removeOnScrollListener(PlaceListActivity.this.f15817B);
            }
        }
    }

    /* renamed from: com.bxkj.place.apply.PlaceListActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4181e implements RecyclerView.OnItemTouchListener {

        /* renamed from: a */
        private int f15842a;

        C4181e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            if (rv.getScrollState() == 0) {
                onTouchEvent(rv, e);
                return false;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            if (e.getAction() == 0 && PlaceListActivity.this.f15821m.getScrollState() == 0) {
                this.f15842a = rv.getScrollY();
                rv.addOnScrollListener(PlaceListActivity.this.f15818C);
            } else if (e.getAction() == 1 && rv.getScrollY() == this.f15842a) {
                rv.removeOnScrollListener(PlaceListActivity.this.f15818C);
            }
        }
    }

    /* renamed from: com.bxkj.place.apply.PlaceListActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4182f extends HttpCallBack {
        C4182f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PlaceListActivity.this.m43070E0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ void m43069F0(ObservableHorizontalScrollView scrollView, int x, int y, int oldx, int oldy) {
        this.f15823o.removeOnScrollListener(this.f15818C);
        this.f15821m.removeOnScrollListener(this.f15817B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0 */
    public /* synthetic */ void m43068G0() {
        startActivity(getIntent().setClass(this.f1669h, ApplyIntroductionActivity.class));
    }

    /* renamed from: E0 */
    public void m43070E0() {
        this.f15819k.setVisibility(8);
        this.f15819k.setText("");
        this.f15819k.setTag(null);
        this.f15828t.setEnabled(false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        TabLayout tabLayout = this.f15820l;
        if (tabLayout.getTabAt(tabLayout.getSelectedTabPosition()) != null) {
            try {
                TabLayout tabLayout2 = this.f15820l;
                format = simpleDateFormat.format(simpleDateFormat.parse(tabLayout2.getTabAt(tabLayout2.getSelectedTabPosition()).getText().toString().trim()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().setObservable(((PlaceApiService) Http.getApiService(PlaceApiService.class)).m210k(LoginUser.getLoginUser().getUserId(), this.f15831w, this.f15833y, format)).setDataListener(new C4178c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15817B = new MyRecyclerViewOnScrollListener(this.f15823o);
        this.f15818C = new MyRecyclerViewOnScrollListener(this.f15821m);
        this.f15821m.addOnItemTouchListener(new C4180d());
        this.f15823o.addOnItemTouchListener(new C4181e());
        this.f15824p.setScrollViewListener(new ObservableHorizontalScrollView.InterfaceC3997a() { // from class: com.bxkj.place.apply.b
            @Override // com.bxkj.base.view.ObservableHorizontalScrollView.InterfaceC3997a
            /* renamed from: a */
            public final void mo43031a(ObservableHorizontalScrollView observableHorizontalScrollView, int i, int i2, int i3, int i4) {
                PlaceListActivity.this.m43069F0(observableHorizontalScrollView, i, i2, i3, i4);
            }
        });
        this.f15828t.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4159R.C4165layout.ac_place_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("id")) {
            this.f15833y = getIntent().getStringExtra("id");
        }
        if (getIntent().hasExtra("appointType")) {
            this.f15831w = getIntent().getIntExtra("appointType", 1);
        }
        this.f15828t.setText(this.f15831w == 2 ? "立即申请" : "立即预约");
        int i = this.f15831w;
        this.f15832x = i == 2 ? "申请" : "立预约";
        setTitle(i == 2 ? "申请场地" : "预约场地");
        this.f15822n.setLayoutManager(new LinearLayoutManager(this.f1669h, 0, false));
        C4176a c4176a = new C4176a(this.f1669h, C4159R.C4165layout.item_for_place_name, this.f15827s);
        this.f15826r = c4176a;
        this.f15822n.setAdapter(c4176a);
        C4177b c4177b = new C4177b(this.f1669h, C4159R.C4165layout.item_for_place_checked, this.f15825q);
        this.f15829u = c4177b;
        this.f15823o.setAdapter(c4177b);
        m43070E0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("申请场地");
        m57925b0(C4159R.mipmap.help, new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.place.apply.a
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                PlaceListActivity.this.m43068G0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15819k = (TextView) findViewById(C4159R.C4163id.tv_order);
        this.f15820l = (TabLayout) findViewById(C4159R.C4163id.tb_date);
        this.f15822n = (RecyclerView) findViewById(C4159R.C4163id.rv_top);
        this.f15823o = (RecyclerView) findViewById(C4159R.C4163id.recyclerView);
        this.f15821m = (RecyclerView) findViewById(C4159R.C4163id.rv_left);
        this.f15824p = (ObservableHorizontalScrollView) findViewById(C4159R.C4163id.f15770hs);
        this.f15828t = (Button) findViewById(C4159R.C4163id.bt_ok);
        m57932R().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != C4159R.C4163id.bt_ok || this.f15828t.getTag() == null) {
            return;
        }
        if (!this.f15828t.getTag().toString().trim().equals("1") && this.f15831w != 2) {
            Http.with(this.f1669h).setObservable(((PlaceApiService) Http.getApiService(PlaceApiService.class)).m212i(LoginUser.getLoginUser().getUserId(), (String) this.f15819k.getTag(), "", "", this.f15831w, "1")).setDataListener(new C4182f());
            return;
        }
        Intent intent = new Intent(this.f1669h, ApplyPlaceActivity.class);
        TabLayout tabLayout = this.f15820l;
        startActivity(intent.putExtra("date", tabLayout.getTabAt(tabLayout.getSelectedTabPosition()).getText()).putExtra("id", (String) this.f15819k.getTag()).putExtra("appointType", this.f15831w));
    }
}
