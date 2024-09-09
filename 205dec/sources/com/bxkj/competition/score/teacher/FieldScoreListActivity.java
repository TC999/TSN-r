package com.bxkj.competition.score.teacher;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.t;
import com.bxkj.competition.R;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class FieldScoreListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private String f19043k;

    /* renamed from: l  reason: collision with root package name */
    private TabLayout f19044l;

    /* renamed from: m  reason: collision with root package name */
    private RecyclerView f19045m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f19046n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f19047o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f19048p;

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19049q;

    /* renamed from: r  reason: collision with root package name */
    private EditText f19050r;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_no, JsonParse.getString(stringObjectMap, "passNum"));
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, "name"));
            holder.J(R.id.tv_num, JsonParse.getString(stringObjectMap, "num"));
            holder.J(R.id.tv_stateName, JsonParse.getString(stringObjectMap, "stateName"));
            holder.J(R.id.tv_check, JsonParse.getString(stringObjectMap, "check"));
            holder.J(R.id.tv_rank, JsonParse.getString(stringObjectMap, "rank"));
            holder.J(R.id.tv_time, JsonParse.getString(stringObjectMap, "time"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FieldScoreListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i4 = JsonParse.getInt(data, "data");
            for (int i5 = 1; i5 <= i4; i5++) {
                TabLayout tabLayout = FieldScoreListActivity.this.f19044l;
                TabLayout.Tab newTab = FieldScoreListActivity.this.f19044l.newTab();
                tabLayout.addTab(newTab.setText("\u7b2c" + i5 + "\u7ec4"));
            }
            FieldScoreListActivity.this.w0();
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
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FieldScoreListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            FieldScoreListActivity.this.f19047o = JsonParse.getList(data, "data");
            FieldScoreListActivity.this.f19049q.g(FieldScoreListActivity.this.f19047o);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d implements TabLayout.OnTabSelectedListener {
        d() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            FieldScoreListActivity.this.w0();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class e implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, final int position) {
            FieldScoreListActivity.this.x0(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RadioGroup f19056a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f19057b;

        f(final RadioGroup val$et_value, final EditText val$rg) {
            this.f19056a = val$et_value;
            this.f19057b = val$rg;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == this.f19056a.getChildAt(1).getId()) {
                this.f19057b.setVisibility(0);
            } else {
                this.f19057b.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19059a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f19060b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f19061c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RadioGroup f19062d;

        g(final int val$rg, final EditText val$et_rank, final EditText val$et_value, final RadioGroup val$position) {
            this.f19059a = val$rg;
            this.f19060b = val$et_rank;
            this.f19061c = val$et_value;
            this.f19062d = val$position;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            if (TextUtils.isEmpty(JsonParse.getString((Map) FieldScoreListActivity.this.f19049q.getItem(this.f19059a), "traffId"))) {
                new iOSOneButtonDialog(((BaseActivity) FieldScoreListActivity.this).f1656h).setMessage("\u8be5\u9053\u6b21\u4e3a\u7a7a,\u4e0d\u80fd\u6dfb\u52a0\u6210\u7ee9").show();
                return;
            }
            String trim = this.f19060b.getText().toString().trim();
            String trim2 = this.f19061c.getText().toString().trim();
            String trim3 = FieldScoreListActivity.this.f19050r.getText().toString().trim();
            HashMap hashMap = new HashMap(3);
            hashMap.put("_state", "modified");
            hashMap.put("traffId", JsonParse.getString((Map) FieldScoreListActivity.this.f19049q.getItem(this.f19059a), "traffId"));
            hashMap.put("check", Boolean.valueOf(this.f19062d.getCheckedRadioButtonId() == this.f19062d.getChildAt(1).getId()));
            if (!TextUtils.isEmpty(trim)) {
                hashMap.put("memo", trim);
            }
            hashMap.put("rank", trim2);
            hashMap.put("time", trim3);
            FieldScoreListActivity.this.u0(hashMap, this.f19059a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class h extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f19064a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19065b;

        h(final Map val$position, final int val$map) {
            this.f19064a = val$position;
            this.f19065b = val$map;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FieldScoreListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Map map = this.f19064a;
            map.put("check", JsonParse.getBoolean(map, "check") ? "\u72af\u89c4" : "\u672a\u72af\u89c4");
            if (this.f19064a.containsKey("time")) {
                Map map2 = this.f19064a;
                map2.put("time", JsonParse.getString(map2, "time"));
            }
            if (this.f19064a.containsKey("rank")) {
                Map map3 = this.f19064a;
                map3.put("rank", JsonParse.getString(map3, "rank"));
            }
            ((Map) FieldScoreListActivity.this.f19049q.getItem(this.f19065b)).putAll(this.f19064a);
            FieldScoreListActivity.this.f19049q.notifyItemChanged(this.f19065b);
            FieldScoreListActivity.this.x0(this.f19065b + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(final Map<String, Object> map, final int position) {
        Http.with(this.f1656h).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).m(LoginUser.getLoginUser().getUserId(), JSON.toJSONString(map))).setDataListener(new h(map, position));
    }

    private void v0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).k(this.f19043k)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).l(this.f19043k, this.f19044l.getSelectedTabPosition() + 1, "1")).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(final int position) {
        if (position >= this.f19049q.getItemCount()) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u6700\u540e\u4e00\u6761\u5df2\u5f55\u5165\u5b8c\u6bd5").show();
            return;
        }
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1656h);
        iOSTwoButtonDialog centerCustomView = iostwobuttondialog.setTitle("\u9053\u6b21\uff1a" + JsonParse.getString(this.f19049q.getItem(position), "passNum") + "\u3000\u59d3\u540d\uff1a" + JsonParse.getString(this.f19049q.getItem(position), "name")).setCenterCustomView(R.layout.dialog_add_score_field);
        EditText editText = (EditText) centerCustomView.findViewById(R.id.et_value);
        EditText editText2 = (EditText) centerCustomView.findViewById(R.id.et_rank);
        EditText editText3 = (EditText) centerCustomView.findViewById(R.id.et_time);
        this.f19050r = editText3;
        editText3.setFilters(new InputFilter[]{new t()});
        Window window = centerCustomView.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(48);
        attributes.width = -1;
        attributes.height = -2;
        centerCustomView.onWindowAttributesChanged(attributes);
        window.setAttributes(attributes);
        com.bxkj.base.keyboard.b bVar = new com.bxkj.base.keyboard.b(this);
        bVar.a(editText2);
        bVar.a(this.f19050r);
        RadioGroup radioGroup = (RadioGroup) centerCustomView.findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(new f(radioGroup, editText));
        editText.setText(JsonParse.getString(this.f19049q.getItem(position), "memo"));
        editText2.setText(JsonParse.getString(this.f19049q.getItem(position), "rank"));
        this.f19050r.setText(JsonParse.getString(this.f19049q.getItem(position), "time"));
        if ("\u72af\u89c4".equals(JsonParse.getString(this.f19049q.getItem(position), "check"))) {
            radioGroup.check(radioGroup.getChildAt(1).getId());
        }
        centerCustomView.setRightButtonOnClickListener(new g(position, editText, editText2, radioGroup));
        centerCustomView.getWindow().clearFlags(131080);
        centerCustomView.getWindow().setSoftInputMode(18);
        centerCustomView.show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19044l.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new d());
        this.f19049q.k(new e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_student_list_add_score;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("scheduleId")) {
            this.f19043k = getIntent().getStringExtra("scheduleId");
        }
        this.f19045m.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, R.layout.item_for_field_score_list, this.f19047o);
        this.f19049q = aVar;
        this.f19045m.setAdapter(aVar);
        v0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5f55\u5165\u6210\u7ee9");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19045m = (RecyclerView) findViewById(R.id.rv);
        this.f19044l = (TabLayout) findViewById(R.id.tb_group);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
