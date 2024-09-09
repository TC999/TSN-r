package com.bxkj.student.home.teaching.exam.record;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ExamDetailActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f20266k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f20267l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f20268m;

    /* renamed from: n  reason: collision with root package name */
    private String f20269n;

    /* renamed from: o  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20270o;

    /* renamed from: p  reason: collision with root package name */
    private String f20271p;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            String str;
            CompoundButton radioButton;
            TextView textView = (TextView) holder.h(2131233112);
            if ("0".equals(JsonParse.getString(stringObjectMap, "questionType"))) {
                str = "\u5355\u9009";
            } else if ("1".equals(JsonParse.getString(stringObjectMap, "questionType"))) {
                str = "\u591a\u9009";
            } else {
                str = "3".equals(JsonParse.getString(stringObjectMap, "questionType")) ? "\u5224\u65ad" : "\u672a\u77e5\u7c7b\u578b";
            }
            holder.J(2131233211, str);
            holder.J(2131233002, (holder.f() + 1) + "");
            holder.J(2131233146, "(" + JsonParse.getString(stringObjectMap, "score") + ")\u5206");
            textView.setText(Html.fromHtml(JsonParse.getString(stringObjectMap, "questionName")));
            RadioGroup radioGroup = (RadioGroup) holder.h(2131232490);
            radioGroup.removeAllViews();
            String string = JsonParse.getString(stringObjectMap, "stuAnswers");
            for (Map map : (List) stringObjectMap.get("answers")) {
                if (str.equals("\u591a\u9009")) {
                    radioButton = new CheckBox(this.f1707a);
                } else {
                    radioButton = new RadioButton(this.f1707a);
                }
                radioButton.setClickable(false);
                radioButton.setTextSize(2, 16.0f);
                String string2 = JsonParse.getString(map, DomainCampaignEx.ROVER_KEY_MARK);
                radioButton.setText(string2 + "." + JsonParse.getString(map, "answerOption"));
                radioButton.setChecked(JsonParse.getString(map, "isRight").equals("0"));
                radioGroup.addView(radioButton);
            }
            holder.N(2131233134, true);
            StringBuilder sb = new StringBuilder();
            sb.append("\u8003\u751f\u7b54\u6848\uff1a");
            sb.append(string);
            sb.append("\uff1b\u662f\u5426\u6b63\u786e\uff1a");
            sb.append(JsonParse.getString(stringObjectMap, "isRight").equals("0") ? "\u6b63\u786e" : "\u9519\u8bef");
            holder.J(2131233134, sb.toString());
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

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamDetailActivity.this.f20268m = (List) data.get("data");
            ExamDetailActivity.this.f20270o.g(ExamDetailActivity.this.f20268m);
        }
    }

    private void l0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).T0(LoginUser.getLoginUser().getUserId(), this.f20269n, this.f20271p)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("stuTeacherCurriculumId")) {
            this.f20269n = getIntent().getStringExtra("stuTeacherCurriculumId");
        }
        if (getIntent().hasExtra("identify")) {
            this.f20271p = getIntent().getStringExtra("identify");
        }
        this.f20267l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427627, this.f20268m);
        this.f20270o = aVar;
        this.f20267l.setAdapter(aVar);
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8bd5\u5377\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20266k = (SmartRefreshLayout) findViewById(2131232482);
        this.f20267l = (RecyclerView) findViewById(2131232481);
        this.f20266k.b0(false);
        this.f20266k.O(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
