package com.bxkj.student.home.teaching.homework.question;

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
import com.bxkj.student.home.teaching.homework.HomeWorkApiService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TextQuestionActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f17066k;

    /* renamed from: l */
    private TextView f17067l;

    /* renamed from: m */
    private TextView f17068m;

    /* renamed from: n */
    private TextView f17069n;

    /* renamed from: o */
    private TextView f17070o;

    /* renamed from: p */
    private LinearLayout f17071p;

    /* renamed from: q */
    private RecyclerView f17072q;

    /* renamed from: r */
    private EditText f17073r;

    /* renamed from: s */
    private Button f17074s;

    /* renamed from: t */
    private TextView f17075t;

    /* renamed from: u */
    private String f17076u;

    /* renamed from: v */
    private int f17077v;

    /* renamed from: w */
    private List<Map<String, Object>> f17078w = new ArrayList();

    /* renamed from: x */
    private CommonAdapter<Map<String, Object>> f17079x;

    /* renamed from: com.bxkj.student.home.teaching.homework.question.TextQuestionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4540a extends CommonAdapter<Map<String, Object>> {
        C4540a(Context context, int layoutId, List datas) {
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
    /* renamed from: com.bxkj.student.home.teaching.homework.question.TextQuestionActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4541b extends HttpCallBack {
        C4541b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TextQuestionActivity.this.m57932R().setVisibility(0);
            TextQuestionActivity.this.m42051m0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.TextQuestionActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4542c extends HttpCallBack {
        C4542c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TextQuestionActivity.this.finish();
        }
    }

    /* renamed from: k0 */
    private void m42053k0() {
        Http.with(this.f1669h).setObservable(((HomeWorkApiService) Http.getApiService(HomeWorkApiService.class)).m42110c(this.f17076u, this.f17077v)).setDataListener(new C4541b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public /* synthetic */ void m42052l0(View view) {
        String trim = this.f17073r.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请填写答案").show();
        } else {
            Http.with(this.f1669h).setObservable(((HomeWorkApiService) Http.getApiService(HomeWorkApiService.class)).m42111b(this.f17076u, trim)).setDataListener(new C4542c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public void m42051m0(Map<String, Object> data) {
        boolean z = JsonParse.getBoolean(data, "isFlag");
        int i = this.f17077v;
        if (i == 1) {
            this.f17074s.setText("已合格");
            this.f17073r.setVisibility(8);
            this.f17069n.setVisibility(8);
            this.f17074s.setEnabled(false);
        } else if (i == 2) {
            this.f17074s.setText("待批改");
            this.f17073r.setVisibility(8);
            this.f17069n.setVisibility(8);
            this.f17074s.setEnabled(false);
        } else if (z) {
            this.f17074s.setText("提交");
            this.f17074s.setEnabled(true);
        } else {
            this.f17074s.setText("不合格");
            this.f17074s.setEnabled(false);
            this.f17073r.setVisibility(8);
            this.f17069n.setVisibility(8);
            this.f17075t.setVisibility(0);
            this.f17075t.setText(JsonParse.getString(data, "markAnswer"));
        }
        List<Map<String, Object>> list = JsonParse.getList(data, "questionsRecord");
        this.f17078w = list;
        if (list.isEmpty()) {
            this.f17071p.setVisibility(8);
            this.f17072q.setVisibility(8);
        } else {
            this.f17079x.m57836g(this.f17078w);
        }
        TextView textView = this.f17068m;
        textView.setText("(" + JsonParse.getString(data, "socre") + "分)");
        int i2 = JsonParse.getInt(data, "limitWordsLsl");
        int i3 = JsonParse.getInt(data, "limitWordsUsl");
        TextView textView2 = this.f17069n;
        textView2.setText("字数:" + i2 + "-" + i3 + "之间");
        this.f17070o.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17074s.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextQuestionActivity.this.m42052l0(view);
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
            this.f17076u = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f17077v = getIntent().getIntExtra("isQualified", 0);
        }
        this.f17072q.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4540a c4540a = new C4540a(this.f1669h, C4215R.C4221layout.item_for_learn_test_question_list, this.f17078w);
        this.f17079x = c4540a;
        this.f17072q.setAdapter(c4540a);
        m42053k0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("课后作业开始答题-问答题");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17066k = (TextView) findViewById(C4215R.C4219id.tv_index);
        this.f17067l = (TextView) findViewById(2131233211);
        this.f17068m = (TextView) findViewById(2131233146);
        this.f17070o = (TextView) findViewById(C4215R.C4219id.tv_question);
        this.f17069n = (TextView) findViewById(C4215R.C4219id.tv_limit);
        this.f17072q = (RecyclerView) findViewById(C4215R.C4219id.rv_answer);
        this.f17071p = (LinearLayout) findViewById(C4215R.C4219id.ll_history_answer);
        this.f17073r = (EditText) findViewById(C4215R.C4219id.et_answer);
        this.f17074s = (Button) findViewById(2131230967);
        this.f17075t = (TextView) findViewById(C4215R.C4219id.tv_right_answer);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
