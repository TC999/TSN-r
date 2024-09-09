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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TextQuestionActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f20430k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f20431l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20432m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f20433n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f20434o;

    /* renamed from: p  reason: collision with root package name */
    private LinearLayout f20435p;

    /* renamed from: q  reason: collision with root package name */
    private RecyclerView f20436q;

    /* renamed from: r  reason: collision with root package name */
    private EditText f20437r;

    /* renamed from: s  reason: collision with root package name */
    private Button f20438s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f20439t;

    /* renamed from: u  reason: collision with root package name */
    private String f20440u;

    /* renamed from: v  reason: collision with root package name */
    private int f20441v;

    /* renamed from: w  reason: collision with root package name */
    private List<Map<String, Object>> f20442w = new ArrayList();

    /* renamed from: x  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20443x;

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
            holder.J(2131232843, JsonParse.getString(stringObjectMap, "answerStr"));
            holder.J(2131232909, "\u56de\u7b54\u65f6\u95f4\uff1a" + JsonParse.getString(stringObjectMap, "answerTime"));
            String string = JsonParse.getString(stringObjectMap, "reviewTime");
            holder.N(2131232898, TextUtils.isEmpty(string) ^ true);
            holder.J(2131232898, "\u6279\u6539\u65f6\u95f4\uff1a" + string);
            int i4 = JsonParse.getInt(stringObjectMap, "isRight");
            if (i4 == 0) {
                holder.J(2131233007, "\u662f\u5426\u5408\u683c\uff1a\u4e0d\u5408\u683c");
            } else if (i4 == 1) {
                holder.J(2131233007, "\u662f\u5426\u5408\u683c\uff1a\u5408\u683c");
            } else if (i4 == 2) {
                holder.J(2131233007, "\u662f\u5426\u5408\u683c\uff1a\u5f85\u6279\u6539");
            }
            String string2 = JsonParse.getString(stringObjectMap, "note");
            holder.N(2131233132, !TextUtils.isEmpty(string2));
            holder.J(2131233132, "\u5907\u6ce8\uff1a" + string2);
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
            TextQuestionActivity.this.R().setVisibility(0);
            TextQuestionActivity.this.m0(data);
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

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TextQuestionActivity.this.finish();
        }
    }

    private void k0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).c(this.f20440u, this.f20441v)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(View view) {
        String trim = this.f20437r.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u586b\u5199\u7b54\u6848").show();
        } else {
            Http.with(this.f1656h).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).b(this.f20440u, trim)).setDataListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(Map<String, Object> data) {
        boolean z3 = JsonParse.getBoolean(data, "isFlag");
        int i4 = this.f20441v;
        if (i4 == 1) {
            this.f20438s.setText("\u5df2\u5408\u683c");
            this.f20437r.setVisibility(8);
            this.f20433n.setVisibility(8);
            this.f20438s.setEnabled(false);
        } else if (i4 == 2) {
            this.f20438s.setText("\u5f85\u6279\u6539");
            this.f20437r.setVisibility(8);
            this.f20433n.setVisibility(8);
            this.f20438s.setEnabled(false);
        } else if (z3) {
            this.f20438s.setText("\u63d0\u4ea4");
            this.f20438s.setEnabled(true);
        } else {
            this.f20438s.setText("\u4e0d\u5408\u683c");
            this.f20438s.setEnabled(false);
            this.f20437r.setVisibility(8);
            this.f20433n.setVisibility(8);
            this.f20439t.setVisibility(0);
            this.f20439t.setText(JsonParse.getString(data, "markAnswer"));
        }
        List<Map<String, Object>> list = JsonParse.getList(data, "questionsRecord");
        this.f20442w = list;
        if (list.isEmpty()) {
            this.f20435p.setVisibility(8);
            this.f20436q.setVisibility(8);
        } else {
            this.f20443x.g(this.f20442w);
        }
        TextView textView = this.f20432m;
        textView.setText("(" + JsonParse.getString(data, "socre") + "\u5206)");
        int i5 = JsonParse.getInt(data, "limitWordsLsl");
        int i6 = JsonParse.getInt(data, "limitWordsUsl");
        TextView textView2 = this.f20433n;
        textView2.setText("\u5b57\u6570:" + i5 + "-" + i6 + "\u4e4b\u95f4");
        this.f20434o.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20438s.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextQuestionActivity.this.l0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427424;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.f20440u = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f20441v = getIntent().getIntExtra("isQualified", 0);
        }
        this.f20436q.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427710, this.f20442w);
        this.f20443x = aVar;
        this.f20436q.setAdapter(aVar);
        k0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8bfe\u540e\u4f5c\u4e1a\u5f00\u59cb\u7b54\u9898-\u95ee\u7b54\u9898");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20430k = (TextView) findViewById(2131233002);
        this.f20431l = (TextView) findViewById(2131233211);
        this.f20432m = (TextView) findViewById(2131233146);
        this.f20434o = (TextView) findViewById(2131233112);
        this.f20433n = (TextView) findViewById(2131233017);
        this.f20436q = (RecyclerView) findViewById(2131232542);
        this.f20435p = (LinearLayout) findViewById(2131232197);
        this.f20437r = (EditText) findViewById(2131231252);
        this.f20438s = (Button) findViewById(2131230967);
        this.f20439t = (TextView) findViewById(2131233134);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
