package com.bxkj.student.home.teaching.learning.question;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TextQuestionActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f17615k;

    /* renamed from: l */
    private TextView f17616l;

    /* renamed from: m */
    private TextView f17617m;

    /* renamed from: n */
    private TextView f17618n;

    /* renamed from: o */
    private TextView f17619o;

    /* renamed from: p */
    private LinearLayout f17620p;

    /* renamed from: q */
    private RecyclerView f17621q;

    /* renamed from: r */
    private EditText f17622r;

    /* renamed from: s */
    private Button f17623s;

    /* renamed from: t */
    private String f17624t;

    /* renamed from: u */
    private int f17625u;

    /* renamed from: v */
    private List<Map<String, Object>> f17626v = new ArrayList();

    /* renamed from: w */
    private CommonAdapter<Map<String, Object>> f17627w;

    /* renamed from: com.bxkj.student.home.teaching.learning.question.TextQuestionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4722a extends CommonAdapter<Map<String, Object>> {
        C4722a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_answer, JsonParse.getString(stringObjectMap, "answerStr"));
            holder.m57874J(C4215R.C4219id.tv_commit_time, "回答时间：" + JsonParse.getString(stringObjectMap, "answerTime"));
            String string = JsonParse.getString(stringObjectMap, "reviewTime");
            holder.m57870N(C4215R.C4219id.tv_check_time, TextUtils.isEmpty(string) ^ true);
            holder.m57874J(C4215R.C4219id.tv_check_time, "批改时间：" + string);
            int i = JsonParse.getInt(stringObjectMap, "isRight");
            if (i == 0) {
                holder.m57874J(C4215R.C4219id.tv_isOK, "是否合格：不合格");
            } else if (i == 1) {
                holder.m57874J(C4215R.C4219id.tv_isOK, "是否合格：合格");
            } else if (i == 2) {
                holder.m57874J(C4215R.C4219id.tv_isOK, "是否合格：待批改");
            }
            String string2 = JsonParse.getString(stringObjectMap, "note");
            holder.m57870N(C4215R.C4219id.tv_reviewer, !TextUtils.isEmpty(string2));
            holder.m57874J(C4215R.C4219id.tv_reviewer, "备注：" + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.TextQuestionActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4723b extends HttpCallBack {
        C4723b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TextQuestionActivity.this.m57932R().setVisibility(0);
            TextQuestionActivity.this.m41509m0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.TextQuestionActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4724c extends HttpCallBack {
        C4724c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TextQuestionActivity.this.finish();
        }
    }

    /* renamed from: k0 */
    private void m41511k0() {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41639c(this.f17624t, this.f17625u)).setDataListener(new C4723b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public /* synthetic */ void m41510l0(View view) {
        String trim = this.f17622r.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请填写答案").show();
        } else {
            Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41640b(this.f17624t, trim)).setDataListener(new C4724c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public void m41509m0(Map<String, Object> data) {
        List<Map<String, Object>> list = JsonParse.getList(data, "questionsRecord");
        this.f17626v = list;
        if (list.isEmpty()) {
            this.f17620p.setVisibility(8);
            this.f17621q.setVisibility(8);
        } else {
            this.f17627w.m57836g(this.f17626v);
        }
        TextView textView = this.f17617m;
        textView.setText("(" + JsonParse.getString(data, "socre") + "分)");
        int i = JsonParse.getInt(data, "limitWordsLsl");
        int i2 = JsonParse.getInt(data, "limitWordsUsl");
        TextView textView2 = this.f17618n;
        textView2.setText("字数:" + i + "-" + i2 + "之间");
        this.f17619o.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17623s.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextQuestionActivity.this.m41510l0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_learn_text_question;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.f17624t = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f17625u = getIntent().getIntExtra("isQualified", 0);
        }
        int i = this.f17625u;
        if (i == 1) {
            this.f17623s.setText("已合格");
            this.f17622r.setVisibility(8);
            this.f17618n.setVisibility(8);
            this.f17623s.setEnabled(false);
        } else if (i == 2) {
            this.f17623s.setText("待批改");
            this.f17622r.setVisibility(8);
            this.f17618n.setVisibility(8);
            this.f17623s.setEnabled(false);
        }
        this.f17621q.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4722a c4722a = new C4722a(this.f1669h, C4215R.C4221layout.item_for_learn_test_question_list, this.f17626v);
        this.f17627w = c4722a;
        this.f17621q.setAdapter(c4722a);
        m41511k0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("开始答题-问答题");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17615k = (TextView) findViewById(C4215R.C4219id.tv_index);
        this.f17616l = (TextView) findViewById(2131233211);
        this.f17617m = (TextView) findViewById(2131233146);
        this.f17619o = (TextView) findViewById(C4215R.C4219id.tv_question);
        this.f17618n = (TextView) findViewById(C4215R.C4219id.tv_limit);
        this.f17621q = (RecyclerView) findViewById(C4215R.C4219id.rv_answer);
        this.f17620p = (LinearLayout) findViewById(C4215R.C4219id.ll_history_answer);
        this.f17622r = (EditText) findViewById(C4215R.C4219id.et_answer);
        this.f17623s = (Button) findViewById(2131230967);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
