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
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.keyboard.KeyboardHelper;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.PointLengthFilter;
import com.bxkj.competition.C4017R;
import com.bxkj.competition.CompeApiService;
import com.google.android.material.tabs.TabLayout;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class FieldScoreListActivity extends BaseActivity {

    /* renamed from: k */
    private String f15499k;

    /* renamed from: l */
    private TabLayout f15500l;

    /* renamed from: m */
    private RecyclerView f15501m;

    /* renamed from: n */
    private List<Map<String, Object>> f15502n = new ArrayList();

    /* renamed from: o */
    private List<Map<String, Object>> f15503o = new ArrayList();

    /* renamed from: p */
    private CommonAdapter<Map<String, Object>> f15504p;

    /* renamed from: q */
    private cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter<Map<String, Object>> f15505q;

    /* renamed from: r */
    private EditText f15506r;

    /* renamed from: com.bxkj.competition.score.teacher.FieldScoreListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4073a extends cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter<Map<String, Object>> {
        C4073a(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(C4017R.C4021id.tv_no, JsonParse.getString(stringObjectMap, "passNum"));
            holder.m57874J(C4017R.C4021id.tv_name, JsonParse.getString(stringObjectMap, "name"));
            holder.m57874J(C4017R.C4021id.tv_num, JsonParse.getString(stringObjectMap, "num"));
            holder.m57874J(C4017R.C4021id.tv_stateName, JsonParse.getString(stringObjectMap, "stateName"));
            holder.m57874J(C4017R.C4021id.tv_check, JsonParse.getString(stringObjectMap, "check"));
            holder.m57874J(C4017R.C4021id.tv_rank, JsonParse.getString(stringObjectMap, "rank"));
            holder.m57874J(C4017R.C4021id.tv_time, JsonParse.getString(stringObjectMap, RtspHeaders.Values.TIME));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.teacher.FieldScoreListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4074b extends HttpCallBack {
        C4074b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FieldScoreListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i = JsonParse.getInt(data, "data");
            for (int i2 = 1; i2 <= i; i2++) {
                TabLayout tabLayout = FieldScoreListActivity.this.f15500l;
                TabLayout.Tab newTab = FieldScoreListActivity.this.f15500l.newTab();
                tabLayout.addTab(newTab.setText("第" + i2 + "组"));
            }
            FieldScoreListActivity.this.m43282w0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.teacher.FieldScoreListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4075c extends HttpCallBack {
        C4075c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FieldScoreListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            FieldScoreListActivity.this.f15503o = JsonParse.getList(data, "data");
            FieldScoreListActivity.this.f15505q.m57836g(FieldScoreListActivity.this.f15503o);
        }
    }

    /* renamed from: com.bxkj.competition.score.teacher.FieldScoreListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4076d implements TabLayout.OnTabSelectedListener {
        C4076d() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            FieldScoreListActivity.this.m43282w0();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* renamed from: com.bxkj.competition.score.teacher.FieldScoreListActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4077e implements OnItemClickListener {
        C4077e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, final int position) {
            FieldScoreListActivity.this.m43281x0(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.teacher.FieldScoreListActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4078f implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a */
        final /* synthetic */ RadioGroup f15512a;

        /* renamed from: b */
        final /* synthetic */ EditText f15513b;

        C4078f(final RadioGroup val$et_value, final EditText val$rg) {
            this.f15512a = val$et_value;
            this.f15513b = val$rg;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == this.f15512a.getChildAt(1).getId()) {
                this.f15513b.setVisibility(0);
            } else {
                this.f15513b.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.teacher.FieldScoreListActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4079g implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ int f15515a;

        /* renamed from: b */
        final /* synthetic */ EditText f15516b;

        /* renamed from: c */
        final /* synthetic */ EditText f15517c;

        /* renamed from: d */
        final /* synthetic */ RadioGroup f15518d;

        C4079g(final int val$rg, final EditText val$et_rank, final EditText val$et_value, final RadioGroup val$position) {
            this.f15515a = val$rg;
            this.f15516b = val$et_rank;
            this.f15517c = val$et_value;
            this.f15518d = val$position;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            if (TextUtils.isEmpty(JsonParse.getString((Map) FieldScoreListActivity.this.f15505q.getItem(this.f15515a), "traffId"))) {
                new iOSOneButtonDialog(((BaseActivity) FieldScoreListActivity.this).f1669h).setMessage("该道次为空,不能添加成绩").show();
                return;
            }
            String trim = this.f15516b.getText().toString().trim();
            String trim2 = this.f15517c.getText().toString().trim();
            String trim3 = FieldScoreListActivity.this.f15506r.getText().toString().trim();
            HashMap hashMap = new HashMap(3);
            hashMap.put("_state", "modified");
            hashMap.put("traffId", JsonParse.getString((Map) FieldScoreListActivity.this.f15505q.getItem(this.f15515a), "traffId"));
            hashMap.put("check", Boolean.valueOf(this.f15518d.getCheckedRadioButtonId() == this.f15518d.getChildAt(1).getId()));
            if (!TextUtils.isEmpty(trim)) {
                hashMap.put("memo", trim);
            }
            hashMap.put("rank", trim2);
            hashMap.put(RtspHeaders.Values.TIME, trim3);
            FieldScoreListActivity.this.m43284u0(hashMap, this.f15515a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.teacher.FieldScoreListActivity$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4080h extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ Map f15520a;

        /* renamed from: b */
        final /* synthetic */ int f15521b;

        C4080h(final Map val$position, final int val$map) {
            this.f15520a = val$position;
            this.f15521b = val$map;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) FieldScoreListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            Map map = this.f15520a;
            map.put("check", JsonParse.getBoolean(map, "check") ? "犯规" : "未犯规");
            if (this.f15520a.containsKey(RtspHeaders.Values.TIME)) {
                Map map2 = this.f15520a;
                map2.put(RtspHeaders.Values.TIME, JsonParse.getString(map2, RtspHeaders.Values.TIME));
            }
            if (this.f15520a.containsKey("rank")) {
                Map map3 = this.f15520a;
                map3.put("rank", JsonParse.getString(map3, "rank"));
            }
            ((Map) FieldScoreListActivity.this.f15505q.getItem(this.f15521b)).putAll(this.f15520a);
            FieldScoreListActivity.this.f15505q.notifyItemChanged(this.f15521b);
            FieldScoreListActivity.this.m43281x0(this.f15521b + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m43284u0(final Map<String, Object> map, final int position) {
        Http.with(this.f1669h).setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43444m(LoginUser.getLoginUser().getUserId(), JSON.toJSONString(map))).setDataListener(new C4080h(map, position));
    }

    /* renamed from: v0 */
    private void m43283v0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43446k(this.f15499k)).setDataListener(new C4074b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public void m43282w0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43445l(this.f15499k, this.f15500l.getSelectedTabPosition() + 1, "1")).setDataListener(new C4075c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public void m43281x0(final int position) {
        if (position >= this.f15505q.getItemCount()) {
            new iOSOneButtonDialog(this.f1669h).setMessage("最后一条已录入完毕").show();
            return;
        }
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1669h);
        iOSTwoButtonDialog centerCustomView = iostwobuttondialog.setTitle("道次：" + JsonParse.getString(this.f15505q.getItem(position), "passNum") + "\u3000姓名：" + JsonParse.getString(this.f15505q.getItem(position), "name")).setCenterCustomView(C4017R.C4023layout.dialog_add_score_field);
        EditText editText = (EditText) centerCustomView.findViewById(C4017R.C4021id.et_value);
        EditText editText2 = (EditText) centerCustomView.findViewById(C4017R.C4021id.et_rank);
        EditText editText3 = (EditText) centerCustomView.findViewById(C4017R.C4021id.et_time);
        this.f15506r = editText3;
        editText3.setFilters(new InputFilter[]{new PointLengthFilter()});
        Window window = centerCustomView.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(48);
        attributes.width = -1;
        attributes.height = -2;
        centerCustomView.onWindowAttributesChanged(attributes);
        window.setAttributes(attributes);
        KeyboardHelper keyboardHelper = new KeyboardHelper(this);
        keyboardHelper.m44189a(editText2);
        keyboardHelper.m44189a(this.f15506r);
        RadioGroup radioGroup = (RadioGroup) centerCustomView.findViewById(C4017R.C4021id.f15343rg);
        radioGroup.setOnCheckedChangeListener(new C4078f(radioGroup, editText));
        editText.setText(JsonParse.getString(this.f15505q.getItem(position), "memo"));
        editText2.setText(JsonParse.getString(this.f15505q.getItem(position), "rank"));
        this.f15506r.setText(JsonParse.getString(this.f15505q.getItem(position), RtspHeaders.Values.TIME));
        if ("犯规".equals(JsonParse.getString(this.f15505q.getItem(position), "check"))) {
            radioGroup.check(radioGroup.getChildAt(1).getId());
        }
        centerCustomView.setRightButtonOnClickListener(new C4079g(position, editText, editText2, radioGroup));
        centerCustomView.getWindow().clearFlags(131080);
        centerCustomView.getWindow().setSoftInputMode(18);
        centerCustomView.show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15500l.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new C4076d());
        this.f15505q.m57834k(new C4077e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4017R.C4023layout.ac_student_list_add_score;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("scheduleId")) {
            this.f15499k = getIntent().getStringExtra("scheduleId");
        }
        this.f15501m.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4073a c4073a = new C4073a(this.f1669h, C4017R.C4023layout.item_for_field_score_list, this.f15503o);
        this.f15505q = c4073a;
        this.f15501m.setAdapter(c4073a);
        m43283v0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("录入成绩");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15501m = (RecyclerView) findViewById(C4017R.C4021id.f15344rv);
        this.f15500l = (TabLayout) findViewById(C4017R.C4021id.tb_group);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
