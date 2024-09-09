package com.bxkj.competition.score.teacher;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
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
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TrackScoreListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private String f19067k;

    /* renamed from: l  reason: collision with root package name */
    private TabLayout f19068l;

    /* renamed from: m  reason: collision with root package name */
    private RecyclerView f19069m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f19070n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f19071o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f19072p;

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19073q;

    /* renamed from: r  reason: collision with root package name */
    private String f19074r;

    /* renamed from: s  reason: collision with root package name */
    private int f19075s;

    /* renamed from: t  reason: collision with root package name */
    private com.bxkj.base.keyboard.b f19076t;

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
            String string;
            holder.J(R.id.tv_no, JsonParse.getString(stringObjectMap, "passNum"));
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, "name"));
            holder.J(R.id.tv_num, JsonParse.getString(stringObjectMap, "num"));
            holder.J(R.id.tv_stateName, JsonParse.getString(stringObjectMap, "stateName"));
            if (TrackScoreListActivity.this.f19074r.equals("\u8d77\u70b9")) {
                string = JsonParse.getString(stringObjectMap, CampaignEx.JSON_NATIVE_VIDEO_START);
            } else if (TrackScoreListActivity.this.f19074r.equals("\u68c0\u67e5")) {
                string = JsonParse.getString(stringObjectMap, "check");
            } else if (TrackScoreListActivity.this.f19074r.equals("\u540d\u6b21")) {
                string = JsonParse.getString(stringObjectMap, "rank");
            } else {
                string = TrackScoreListActivity.this.f19074r.equals("\u65f6\u95f4") ? JsonParse.getString(stringObjectMap, "time") : "";
            }
            holder.J(R.id.tv_value, string);
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
            new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i4 = JsonParse.getInt(data, "data");
            for (int i5 = 1; i5 <= i4; i5++) {
                TabLayout tabLayout = TrackScoreListActivity.this.f19068l;
                TabLayout.Tab newTab = TrackScoreListActivity.this.f19068l.newTab();
                tabLayout.addTab(newTab.setText("\u7b2c" + i5 + "\u7ec4"));
            }
            TrackScoreListActivity.this.x0();
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
            new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TrackScoreListActivity.this.f19071o = JsonParse.getList(data, "data");
            TrackScoreListActivity.this.f19073q.g(TrackScoreListActivity.this.f19071o);
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
            TrackScoreListActivity.this.x0();
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
            TrackScoreListActivity.this.y0(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19082a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f19083b;

        f(final int val$et_value, final EditText val$position) {
            this.f19082a = val$et_value;
            this.f19083b = val$position;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            String str;
            if (TextUtils.isEmpty(JsonParse.getString((Map) TrackScoreListActivity.this.f19073q.getItem(this.f19082a), "traffId"))) {
                new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).f1656h).setMessage("\u8be5\u9053\u6b21\u4e3a\u7a7a,\u4e0d\u80fd\u6dfb\u52a0\u6210\u7ee9").show();
                return;
            }
            String trim = this.f19083b.getText().toString().trim();
            if (TrackScoreListActivity.this.f19074r.equals("\u65f6\u95f4")) {
                str = "time";
            } else {
                str = TrackScoreListActivity.this.f19074r.equals("\u540d\u6b21") ? "rank" : "";
            }
            HashMap hashMap = new HashMap(3);
            hashMap.put("_state", "modified");
            hashMap.put("traffId", JsonParse.getString((Map) TrackScoreListActivity.this.f19073q.getItem(this.f19082a), "traffId"));
            hashMap.put(str, trim);
            TrackScoreListActivity.this.v0(hashMap, this.f19082a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RadioGroup f19085a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f19086b;

        g(final RadioGroup val$et_value, final EditText val$rg) {
            this.f19085a = val$et_value;
            this.f19086b = val$rg;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == this.f19085a.getChildAt(1).getId()) {
                this.f19086b.setVisibility(0);
            } else {
                this.f19086b.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class h implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19088a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f19089b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RadioGroup f19090c;

        h(final int val$rg, final EditText val$et_value, final RadioGroup val$position) {
            this.f19088a = val$rg;
            this.f19089b = val$et_value;
            this.f19090c = val$position;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            String str;
            if (TextUtils.isEmpty(JsonParse.getString((Map) TrackScoreListActivity.this.f19073q.getItem(this.f19088a), "traffId"))) {
                new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).f1656h).setMessage("\u8be5\u9053\u6b21\u4e3a\u7a7a,\u4e0d\u80fd\u6dfb\u52a0\u6210\u7ee9").show();
                return;
            }
            String trim = this.f19089b.getText().toString().trim();
            if (TrackScoreListActivity.this.f19074r.equals("\u8d77\u70b9")) {
                str = CampaignEx.JSON_NATIVE_VIDEO_START;
            } else {
                str = TrackScoreListActivity.this.f19074r.equals("\u68c0\u67e5") ? "check" : "";
            }
            HashMap hashMap = new HashMap(3);
            hashMap.put("_state", "modified");
            hashMap.put("traffId", JsonParse.getString((Map) TrackScoreListActivity.this.f19073q.getItem(this.f19088a), "traffId"));
            hashMap.put(str, Boolean.valueOf(this.f19090c.getCheckedRadioButtonId() == this.f19090c.getChildAt(1).getId()));
            if (!TextUtils.isEmpty(trim)) {
                hashMap.put("memo", trim);
            }
            TrackScoreListActivity.this.v0(hashMap, this.f19088a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class i extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f19092a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19093b;

        i(final Map val$position, final int val$map) {
            this.f19092a = val$position;
            this.f19093b = val$map;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (this.f19092a.containsKey(CampaignEx.JSON_NATIVE_VIDEO_START)) {
                Map map = this.f19092a;
                map.put(CampaignEx.JSON_NATIVE_VIDEO_START, JsonParse.getBoolean(map, CampaignEx.JSON_NATIVE_VIDEO_START) ? "\u72af\u89c4" : "\u672a\u72af\u89c4");
            }
            if (this.f19092a.containsKey("check")) {
                Map map2 = this.f19092a;
                map2.put("check", JsonParse.getBoolean(map2, "check") ? "\u72af\u89c4" : "\u672a\u72af\u89c4");
            }
            if (this.f19092a.containsKey("time")) {
                Map map3 = this.f19092a;
                map3.put("time", JsonParse.getString(map3, "time"));
            }
            if (this.f19092a.containsKey("rank")) {
                Map map4 = this.f19092a;
                map4.put("rank", JsonParse.getString(map4, "rank"));
            }
            ((Map) TrackScoreListActivity.this.f19073q.getItem(this.f19093b)).putAll(this.f19092a);
            TrackScoreListActivity.this.f19073q.notifyItemChanged(this.f19093b);
            TrackScoreListActivity.this.y0(this.f19093b + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(final Map<String, Object> map, final int position) {
        Http.with(this.f1656h).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).m(LoginUser.getLoginUser().getUserId(), JSON.toJSONString(map))).setDataListener(new i(map, position));
    }

    private void w0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).k(this.f19067k)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).l(this.f19067k, this.f19068l.getSelectedTabPosition() + 1, "1")).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(final int position) {
        String string;
        if (position >= this.f19073q.getItemCount()) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u6700\u540e\u4e00\u6761\u5df2\u5f55\u5165\u5b8c\u6bd5").show();
            return;
        }
        Map<String, Object> item = this.f19073q.getItem(position);
        if (this.f19074r.equals("\u8d77\u70b9")) {
            string = JsonParse.getString(item, CampaignEx.JSON_NATIVE_VIDEO_START);
        } else if (this.f19074r.equals("\u68c0\u67e5")) {
            string = JsonParse.getString(item, "check");
        } else if (this.f19074r.equals("\u540d\u6b21")) {
            string = JsonParse.getString(item, "rank");
        } else {
            string = this.f19074r.equals("\u65f6\u95f4") ? JsonParse.getString(item, "time") : "";
        }
        int i4 = this.f19075s;
        if (i4 != 0) {
            if (i4 == 1) {
                iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1656h);
                iOSTwoButtonDialog centerCustomView = iostwobuttondialog.setTitle("\u59d3\u540d\uff1a" + JsonParse.getString(this.f19073q.getItem(position), "name")).setCenterCustomView(R.layout.dialog_add_score_radiot);
                EditText editText = (EditText) centerCustomView.findViewById(R.id.et_value);
                RadioGroup radioGroup = (RadioGroup) centerCustomView.findViewById(R.id.rg);
                radioGroup.setOnCheckedChangeListener(new g(radioGroup, editText));
                if ("\u72af\u89c4".equals(string)) {
                    radioGroup.check(radioGroup.getChildAt(1).getId());
                }
                editText.setText(JsonParse.getString(item, "memo"));
                centerCustomView.setRightButtonOnClickListener(new h(position, editText, radioGroup));
                centerCustomView.show();
                return;
            }
            return;
        }
        iOSTwoButtonDialog iostwobuttondialog2 = new iOSTwoButtonDialog(this.f1656h);
        iOSTwoButtonDialog centerCustomView2 = iostwobuttondialog2.setTitle("\u9053\u6b21\uff1a" + JsonParse.getString(this.f19073q.getItem(position), "passNum") + "\u3000\u59d3\u540d\uff1a" + JsonParse.getString(this.f19073q.getItem(position), "name")).setCenterCustomView(R.layout.dialog_add_score_input);
        EditText editText2 = (EditText) centerCustomView2.findViewById(R.id.et_value);
        editText2.setText(string);
        editText2.setHint("\u8bf7\u8f93\u5165" + this.f19074r);
        if (this.f19074r.equals("\u65f6\u95f4")) {
            editText2.setKeyListener(DigitsKeyListener.getInstance("0123456789:."));
            editText2.setFilters(new InputFilter[]{new t()});
        } else if (this.f19074r.equals("\u540d\u6b21")) {
            editText2.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        }
        Window window = centerCustomView2.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(17);
        attributes.width = -1;
        attributes.height = -1;
        centerCustomView2.onWindowAttributesChanged(attributes);
        window.setAttributes(attributes);
        this.f19076t.a(editText2);
        centerCustomView2.setRightButtonOnClickListener(new f(position, editText2));
        centerCustomView2.show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19068l.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new d());
        this.f19073q.k(new e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_student_list_add_score;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f19076t = new com.bxkj.base.keyboard.b(this);
        if (getIntent().hasExtra("scheduleId")) {
            this.f19067k = getIntent().getStringExtra("scheduleId");
        }
        if (getIntent().hasExtra("type")) {
            this.f19075s = getIntent().getIntExtra("type", 0);
        }
        this.f19069m.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, R.layout.item_for_student_score_list, this.f19071o);
        this.f19073q = aVar;
        this.f19069m.setAdapter(aVar);
        w0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5f55\u5165\u6210\u7ee9");
        if (getIntent().hasExtra("menu")) {
            this.f19074r = getIntent().getStringExtra("menu");
            setTitle(this.f19074r + "\u5f55\u5165");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19069m = (RecyclerView) findViewById(R.id.rv);
        this.f19068l = (TabLayout) findViewById(R.id.tb_group);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
