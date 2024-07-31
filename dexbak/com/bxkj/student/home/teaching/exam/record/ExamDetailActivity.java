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
import com.bxkj.student.C4215R;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ExamDetailActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f16896k;

    /* renamed from: l */
    private RecyclerView f16897l;

    /* renamed from: m */
    private List<Map<String, Object>> f16898m;

    /* renamed from: n */
    private String f16899n;

    /* renamed from: o */
    private CommonAdapter<Map<String, Object>> f16900o;

    /* renamed from: p */
    private String f16901p;

    /* renamed from: com.bxkj.student.home.teaching.exam.record.ExamDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4498a extends CommonAdapter<Map<String, Object>> {
        C4498a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            String str;
            CompoundButton radioButton;
            TextView textView = (TextView) holder.m57862h(C4215R.C4219id.tv_question);
            if ("0".equals(JsonParse.getString(stringObjectMap, "questionType"))) {
                str = "单选";
            } else if ("1".equals(JsonParse.getString(stringObjectMap, "questionType"))) {
                str = "多选";
            } else {
                str = "3".equals(JsonParse.getString(stringObjectMap, "questionType")) ? "判断" : "未知类型";
            }
            holder.m57874J(2131233211, str);
            holder.m57874J(C4215R.C4219id.tv_index, (holder.m57864f() + 1) + "");
            holder.m57874J(2131233146, "(" + JsonParse.getString(stringObjectMap, "score") + ")分");
            textView.setText(Html.fromHtml(JsonParse.getString(stringObjectMap, "questionName")));
            RadioGroup radioGroup = (RadioGroup) holder.m57862h(C4215R.C4219id.rg_answer);
            radioGroup.removeAllViews();
            String string = JsonParse.getString(stringObjectMap, "stuAnswers");
            for (Map map : (List) stringObjectMap.get("answers")) {
                if (str.equals("多选")) {
                    radioButton = new CheckBox(this.f1721a);
                } else {
                    radioButton = new RadioButton(this.f1721a);
                }
                radioButton.setClickable(false);
                radioButton.setTextSize(2, 16.0f);
                String string2 = JsonParse.getString(map, DomainCampaignEx.ROVER_KEY_MARK);
                radioButton.setText(string2 + "." + JsonParse.getString(map, "answerOption"));
                radioButton.setChecked(JsonParse.getString(map, "isRight").equals("0"));
                radioGroup.addView(radioButton);
            }
            holder.m57870N(C4215R.C4219id.tv_right_answer, true);
            StringBuilder sb = new StringBuilder();
            sb.append("考生答案：");
            sb.append(string);
            sb.append("；是否正确：");
            sb.append(JsonParse.getString(stringObjectMap, "isRight").equals("0") ? "正确" : "错误");
            holder.m57874J(C4215R.C4219id.tv_right_answer, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.record.ExamDetailActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4499b extends HttpCallBack {
        C4499b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamDetailActivity.this.f16898m = (List) data.get("data");
            ExamDetailActivity.this.f16900o.m57836g(ExamDetailActivity.this.f16898m);
        }
    }

    /* renamed from: l0 */
    private void m42183l0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m142T0(LoginUser.getLoginUser().getUserId(), this.f16899n, this.f16901p)).setDataListener(new C4499b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("stuTeacherCurriculumId")) {
            this.f16899n = getIntent().getStringExtra("stuTeacherCurriculumId");
        }
        if (getIntent().hasExtra("identify")) {
            this.f16901p = getIntent().getStringExtra("identify");
        }
        this.f16897l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4498a c4498a = new C4498a(this.f1669h, C4215R.C4221layout.fm_exam, this.f16898m);
        this.f16900o = c4498a;
        this.f16897l.setAdapter(c4498a);
        m42183l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("试卷详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16896k = (SmartRefreshLayout) findViewById(2131232482);
        this.f16897l = (RecyclerView) findViewById(2131232481);
        this.f16896k.mo2050b0(false);
        this.f16896k.mo2064P(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
