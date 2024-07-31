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
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TrackScoreListActivity extends BaseActivity {

    /* renamed from: k */
    private String f15523k;

    /* renamed from: l */
    private TabLayout f15524l;

    /* renamed from: m */
    private RecyclerView f15525m;

    /* renamed from: n */
    private List<Map<String, Object>> f15526n = new ArrayList();

    /* renamed from: o */
    private List<Map<String, Object>> f15527o = new ArrayList();

    /* renamed from: p */
    private CommonAdapter<Map<String, Object>> f15528p;

    /* renamed from: q */
    private cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter<Map<String, Object>> f15529q;

    /* renamed from: r */
    private String f15530r;

    /* renamed from: s */
    private int f15531s;

    /* renamed from: t */
    private KeyboardHelper f15532t;

    /* renamed from: com.bxkj.competition.score.teacher.TrackScoreListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4081a extends cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter<Map<String, Object>> {
        C4081a(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            String string;
            holder.m57874J(C4017R.C4021id.tv_no, JsonParse.getString(stringObjectMap, "passNum"));
            holder.m57874J(C4017R.C4021id.tv_name, JsonParse.getString(stringObjectMap, "name"));
            holder.m57874J(C4017R.C4021id.tv_num, JsonParse.getString(stringObjectMap, "num"));
            holder.m57874J(C4017R.C4021id.tv_stateName, JsonParse.getString(stringObjectMap, "stateName"));
            if (TrackScoreListActivity.this.f15530r.equals(ScoreMenu.START)) {
                string = JsonParse.getString(stringObjectMap, CampaignEx.JSON_NATIVE_VIDEO_START);
            } else if (TrackScoreListActivity.this.f15530r.equals(ScoreMenu.CHECK)) {
                string = JsonParse.getString(stringObjectMap, "check");
            } else if (TrackScoreListActivity.this.f15530r.equals(ScoreMenu.RANK)) {
                string = JsonParse.getString(stringObjectMap, "rank");
            } else {
                string = TrackScoreListActivity.this.f15530r.equals(ScoreMenu.TIME) ? JsonParse.getString(stringObjectMap, RtspHeaders.Values.TIME) : "";
            }
            holder.m57874J(C4017R.C4021id.tv_value, string);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.teacher.TrackScoreListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4082b extends HttpCallBack {
        C4082b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i = JsonParse.getInt(data, "data");
            for (int i2 = 1; i2 <= i; i2++) {
                TabLayout tabLayout = TrackScoreListActivity.this.f15524l;
                TabLayout.Tab newTab = TrackScoreListActivity.this.f15524l.newTab();
                tabLayout.addTab(newTab.setText("第" + i2 + "组"));
            }
            TrackScoreListActivity.this.m43264x0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.teacher.TrackScoreListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4083c extends HttpCallBack {
        C4083c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TrackScoreListActivity.this.f15527o = JsonParse.getList(data, "data");
            TrackScoreListActivity.this.f15529q.m57836g(TrackScoreListActivity.this.f15527o);
        }
    }

    /* renamed from: com.bxkj.competition.score.teacher.TrackScoreListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4084d implements TabLayout.OnTabSelectedListener {
        C4084d() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            TrackScoreListActivity.this.m43264x0();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* renamed from: com.bxkj.competition.score.teacher.TrackScoreListActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4085e implements OnItemClickListener {
        C4085e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, final int position) {
            TrackScoreListActivity.this.m43263y0(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.teacher.TrackScoreListActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4086f implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ int f15538a;

        /* renamed from: b */
        final /* synthetic */ EditText f15539b;

        C4086f(final int val$et_value, final EditText val$position) {
            this.f15538a = val$et_value;
            this.f15539b = val$position;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            String str;
            if (TextUtils.isEmpty(JsonParse.getString((Map) TrackScoreListActivity.this.f15529q.getItem(this.f15538a), "traffId"))) {
                new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).f1669h).setMessage("该道次为空,不能添加成绩").show();
                return;
            }
            String trim = this.f15539b.getText().toString().trim();
            if (TrackScoreListActivity.this.f15530r.equals(ScoreMenu.TIME)) {
                str = RtspHeaders.Values.TIME;
            } else {
                str = TrackScoreListActivity.this.f15530r.equals(ScoreMenu.RANK) ? "rank" : "";
            }
            HashMap hashMap = new HashMap(3);
            hashMap.put("_state", "modified");
            hashMap.put("traffId", JsonParse.getString((Map) TrackScoreListActivity.this.f15529q.getItem(this.f15538a), "traffId"));
            hashMap.put(str, trim);
            TrackScoreListActivity.this.m43266v0(hashMap, this.f15538a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.teacher.TrackScoreListActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4087g implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a */
        final /* synthetic */ RadioGroup f15541a;

        /* renamed from: b */
        final /* synthetic */ EditText f15542b;

        C4087g(final RadioGroup val$et_value, final EditText val$rg) {
            this.f15541a = val$et_value;
            this.f15542b = val$rg;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == this.f15541a.getChildAt(1).getId()) {
                this.f15542b.setVisibility(0);
            } else {
                this.f15542b.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.teacher.TrackScoreListActivity$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4088h implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ int f15544a;

        /* renamed from: b */
        final /* synthetic */ EditText f15545b;

        /* renamed from: c */
        final /* synthetic */ RadioGroup f15546c;

        C4088h(final int val$rg, final EditText val$et_value, final RadioGroup val$position) {
            this.f15544a = val$rg;
            this.f15545b = val$et_value;
            this.f15546c = val$position;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            String str;
            if (TextUtils.isEmpty(JsonParse.getString((Map) TrackScoreListActivity.this.f15529q.getItem(this.f15544a), "traffId"))) {
                new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).f1669h).setMessage("该道次为空,不能添加成绩").show();
                return;
            }
            String trim = this.f15545b.getText().toString().trim();
            if (TrackScoreListActivity.this.f15530r.equals(ScoreMenu.START)) {
                str = CampaignEx.JSON_NATIVE_VIDEO_START;
            } else {
                str = TrackScoreListActivity.this.f15530r.equals(ScoreMenu.CHECK) ? "check" : "";
            }
            HashMap hashMap = new HashMap(3);
            hashMap.put("_state", "modified");
            hashMap.put("traffId", JsonParse.getString((Map) TrackScoreListActivity.this.f15529q.getItem(this.f15544a), "traffId"));
            hashMap.put(str, Boolean.valueOf(this.f15546c.getCheckedRadioButtonId() == this.f15546c.getChildAt(1).getId()));
            if (!TextUtils.isEmpty(trim)) {
                hashMap.put("memo", trim);
            }
            TrackScoreListActivity.this.m43266v0(hashMap, this.f15544a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.teacher.TrackScoreListActivity$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4089i extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ Map f15548a;

        /* renamed from: b */
        final /* synthetic */ int f15549b;

        C4089i(final Map val$position, final int val$map) {
            this.f15548a = val$position;
            this.f15549b = val$map;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) TrackScoreListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (this.f15548a.containsKey(CampaignEx.JSON_NATIVE_VIDEO_START)) {
                Map map = this.f15548a;
                map.put(CampaignEx.JSON_NATIVE_VIDEO_START, JsonParse.getBoolean(map, CampaignEx.JSON_NATIVE_VIDEO_START) ? "犯规" : "未犯规");
            }
            if (this.f15548a.containsKey("check")) {
                Map map2 = this.f15548a;
                map2.put("check", JsonParse.getBoolean(map2, "check") ? "犯规" : "未犯规");
            }
            if (this.f15548a.containsKey(RtspHeaders.Values.TIME)) {
                Map map3 = this.f15548a;
                map3.put(RtspHeaders.Values.TIME, JsonParse.getString(map3, RtspHeaders.Values.TIME));
            }
            if (this.f15548a.containsKey("rank")) {
                Map map4 = this.f15548a;
                map4.put("rank", JsonParse.getString(map4, "rank"));
            }
            ((Map) TrackScoreListActivity.this.f15529q.getItem(this.f15549b)).putAll(this.f15548a);
            TrackScoreListActivity.this.f15529q.notifyItemChanged(this.f15549b);
            TrackScoreListActivity.this.m43263y0(this.f15549b + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public void m43266v0(final Map<String, Object> map, final int position) {
        Http.with(this.f1669h).setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43444m(LoginUser.getLoginUser().getUserId(), JSON.toJSONString(map))).setDataListener(new C4089i(map, position));
    }

    /* renamed from: w0 */
    private void m43265w0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43446k(this.f15523k)).setDataListener(new C4082b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public void m43264x0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43445l(this.f15523k, this.f15524l.getSelectedTabPosition() + 1, "1")).setDataListener(new C4083c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public void m43263y0(final int position) {
        String string;
        if (position >= this.f15529q.getItemCount()) {
            new iOSOneButtonDialog(this.f1669h).setMessage("最后一条已录入完毕").show();
            return;
        }
        Map<String, Object> item = this.f15529q.getItem(position);
        if (this.f15530r.equals(ScoreMenu.START)) {
            string = JsonParse.getString(item, CampaignEx.JSON_NATIVE_VIDEO_START);
        } else if (this.f15530r.equals(ScoreMenu.CHECK)) {
            string = JsonParse.getString(item, "check");
        } else if (this.f15530r.equals(ScoreMenu.RANK)) {
            string = JsonParse.getString(item, "rank");
        } else {
            string = this.f15530r.equals(ScoreMenu.TIME) ? JsonParse.getString(item, RtspHeaders.Values.TIME) : "";
        }
        int i = this.f15531s;
        if (i != 0) {
            if (i == 1) {
                iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f1669h);
                iOSTwoButtonDialog centerCustomView = iostwobuttondialog.setTitle("姓名：" + JsonParse.getString(this.f15529q.getItem(position), "name")).setCenterCustomView(C4017R.C4023layout.dialog_add_score_radiot);
                EditText editText = (EditText) centerCustomView.findViewById(C4017R.C4021id.et_value);
                RadioGroup radioGroup = (RadioGroup) centerCustomView.findViewById(C4017R.C4021id.f15343rg);
                radioGroup.setOnCheckedChangeListener(new C4087g(radioGroup, editText));
                if ("犯规".equals(string)) {
                    radioGroup.check(radioGroup.getChildAt(1).getId());
                }
                editText.setText(JsonParse.getString(item, "memo"));
                centerCustomView.setRightButtonOnClickListener(new C4088h(position, editText, radioGroup));
                centerCustomView.show();
                return;
            }
            return;
        }
        iOSTwoButtonDialog iostwobuttondialog2 = new iOSTwoButtonDialog(this.f1669h);
        iOSTwoButtonDialog centerCustomView2 = iostwobuttondialog2.setTitle("道次：" + JsonParse.getString(this.f15529q.getItem(position), "passNum") + "\u3000姓名：" + JsonParse.getString(this.f15529q.getItem(position), "name")).setCenterCustomView(C4017R.C4023layout.dialog_add_score_input);
        EditText editText2 = (EditText) centerCustomView2.findViewById(C4017R.C4021id.et_value);
        editText2.setText(string);
        editText2.setHint("请输入" + this.f15530r);
        if (this.f15530r.equals(ScoreMenu.TIME)) {
            editText2.setKeyListener(DigitsKeyListener.getInstance("0123456789:."));
            editText2.setFilters(new InputFilter[]{new PointLengthFilter()});
        } else if (this.f15530r.equals(ScoreMenu.RANK)) {
            editText2.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        }
        Window window = centerCustomView2.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(17);
        attributes.width = -1;
        attributes.height = -1;
        centerCustomView2.onWindowAttributesChanged(attributes);
        window.setAttributes(attributes);
        this.f15532t.m44189a(editText2);
        centerCustomView2.setRightButtonOnClickListener(new C4086f(position, editText2));
        centerCustomView2.show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15524l.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new C4084d());
        this.f15529q.m57834k(new C4085e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4017R.C4023layout.ac_student_list_add_score;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f15532t = new KeyboardHelper(this);
        if (getIntent().hasExtra("scheduleId")) {
            this.f15523k = getIntent().getStringExtra("scheduleId");
        }
        if (getIntent().hasExtra("type")) {
            this.f15531s = getIntent().getIntExtra("type", 0);
        }
        this.f15525m.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4081a c4081a = new C4081a(this.f1669h, C4017R.C4023layout.item_for_student_score_list, this.f15527o);
        this.f15529q = c4081a;
        this.f15525m.setAdapter(c4081a);
        m43265w0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("录入成绩");
        if (getIntent().hasExtra("menu")) {
            this.f15530r = getIntent().getStringExtra("menu");
            setTitle(this.f15530r + "录入");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15525m = (RecyclerView) findViewById(C4017R.C4021id.f15344rv);
        this.f15524l = (TabLayout) findViewById(C4017R.C4021id.tb_group);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
