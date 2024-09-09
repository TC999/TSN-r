package com.bxkj.student.home.teaching.homework.question;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
import cn.bluemobi.dylan.http.RequestParameter;
import com.bxkj.student.home.teaching.homework.question.PdfQuestionActivity;
import java.io.File;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import m.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PdfQuestionActivity extends BaseActivity {
    private List<Map<String, Object>> A;
    private CommonAdapter<Map<String, Object>> B;
    private int C = 60;
    private final int D = 23;

    /* renamed from: k  reason: collision with root package name */
    private TextView f20395k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f20396l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20397m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f20398n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f20399o;

    /* renamed from: p  reason: collision with root package name */
    private RecyclerView f20400p;

    /* renamed from: q  reason: collision with root package name */
    private ImageView f20401q;

    /* renamed from: r  reason: collision with root package name */
    private ImageView f20402r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f20403s;

    /* renamed from: t  reason: collision with root package name */
    private Button f20404t;

    /* renamed from: u  reason: collision with root package name */
    private Button f20405u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f20406v;

    /* renamed from: w  reason: collision with root package name */
    private String f20407w;

    /* renamed from: x  reason: collision with root package name */
    private int f20408x;

    /* renamed from: y  reason: collision with root package name */
    private String f20409y;

    /* renamed from: z  reason: collision with root package name */
    private LinearLayout f20410z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Map map, View view) {
            PdfQuestionActivity.this.startActivity(new Intent(this.f1707a, PdfViewActivity.class).putExtra("url", JsonParse.getString(map, "answerStr")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131232909, "\u56de\u7b54\u65f6\u95f4\uff1a" + JsonParse.getString(stringObjectMap, "answerTime"));
            holder.r(2131231451, 2131165510);
            holder.N(2131231169, false);
            String string = JsonParse.getString(stringObjectMap, "reviewTime");
            holder.N(2131232898, !TextUtils.isEmpty(string));
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
            holder.w(2131231313, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PdfQuestionActivity.a.this.o(stringObjectMap, view);
                }
            });
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
            PdfQuestionActivity.this.R().setVisibility(0);
            PdfQuestionActivity.this.w0(data);
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

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            PdfQuestionActivity.this.q0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable e4) {
            super.netOnFailure(e4);
            if (e4 instanceof SocketTimeoutException) {
                new iOSOneButtonDialog(((BaseActivity) PdfQuestionActivity.this).f1656h).setMessage("\u4e0a\u4f20\u8d85\u65f6,\u8bf7\u68c0\u67e5\u7f51\u7edc\u540e\u91cd\u8bd5").setOneButtonText("\u91cd\u8bd5").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PdfQuestionActivity.c.this.b(view);
                    }
                }).show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PdfQuestionActivity.this.finish();
        }
    }

    private void p0() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("application/pdf");
        intent.addCategory("android.intent.category.OPENABLE");
        new m.b(this).startActivityForResult(intent).c(new b.a() { // from class: com.bxkj.student.home.teaching.homework.question.i
            @Override // m.b.a
            public final void a(int i4, Intent intent2) {
                PdfQuestionActivity.this.v0(i4, intent2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        if (TextUtils.isEmpty(this.f20409y)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u9009\u62e9\u6587\u4ef6").show();
            return;
        }
        File file = new File(this.f20409y);
        if (file.exists()) {
            com.orhanobut.logger.j.c("\u6587\u4ef6\u5b58\u5728");
            Http.with(this.f1656h).setLoadingMessage("\u6b63\u5728\u4e0a\u4f20...").setTimeout(3L, TimeUnit.MINUTES).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).a(RequestParameter.getRequestBody(this.f20407w), null, RequestParameter.getFilePart("files", file))).setDataListener(new c());
        }
    }

    private void r0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).c(this.f20407w, this.f20408x)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(View view) {
        if (!TextUtils.isEmpty(this.f20409y)) {
            this.f20409y = "";
        }
        this.f20399o.setText("");
        this.f20401q.setImageResource(2131165515);
        this.f20402r.setVisibility(8);
        this.f20403s.setVisibility(8);
        this.f20404t.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(View view) {
        if (TextUtils.isEmpty(this.f20409y)) {
            p0();
            return;
        }
        Intent intent = new Intent(this.f1656h, PdfViewActivity.class);
        intent.putExtra("filePath", this.f20409y);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(View view) {
        q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(int i4, Intent intent) {
        if (intent != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f20409y = com.bxkj.student.common.utils.e.b(this.f1656h, intent.getData());
            } else {
                this.f20409y = com.bxkj.student.common.utils.e.c(this.f1656h, intent.getData());
            }
            if (!"pdf".equalsIgnoreCase(com.bxkj.base.util.file.b.i(this.f20409y))) {
                this.f20409y = null;
                new iOSOneButtonDialog(this.f1656h).setMessage("\u53ea\u80fd\u4e0a\u4f20PDF\u6587\u4ef6").show();
                return;
            }
            this.f20401q.setImageResource(2131558898);
            this.f20404t.setVisibility(0);
            com.orhanobut.logger.j.c("filePath=" + this.f20409y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(Map<String, Object> data) {
        this.f20396l.setText(JsonParse.getString(data, "questionTypeName"));
        boolean z3 = JsonParse.getBoolean(data, "isFlag");
        int i4 = this.f20408x;
        if (i4 == 1) {
            this.f20405u.setText("\u5df2\u5408\u683c");
            ((View) this.f20401q.getParent()).setVisibility(8);
            this.f20405u.setEnabled(false);
        } else if (i4 == 2) {
            this.f20405u.setText("\u5f85\u6279\u6539");
            ((View) this.f20401q.getParent()).setVisibility(8);
            this.f20405u.setEnabled(false);
        } else if (z3) {
            this.f20405u.setText("\u63d0\u4ea4");
            this.f20405u.setEnabled(true);
        } else {
            this.f20405u.setText("\u4e0d\u5408\u683c");
            this.f20405u.setEnabled(false);
            ((View) this.f20401q.getParent()).setVisibility(8);
            this.f20406v.setVisibility(0);
            this.f20406v.setText(JsonParse.getString(data, "markAnswer"));
        }
        this.A = JsonParse.getList(data, "questionsRecord");
        this.C = JsonParse.getInt(data, "maxDuration", this.C);
        if (this.A.isEmpty()) {
            this.f20410z.setVisibility(8);
            this.f20400p.setVisibility(8);
        } else {
            this.B.g(this.A);
        }
        TextView textView = this.f20397m;
        textView.setText("(" + JsonParse.getString(data, "socre") + "\u5206)");
        this.f20398n.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20404t.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PdfQuestionActivity.this.s0(view);
            }
        });
        this.f20401q.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PdfQuestionActivity.this.t0(view);
            }
        });
        this.f20405u.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PdfQuestionActivity.this.u0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427425;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.f20407w = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f20408x = getIntent().getIntExtra("isQualified", 0);
        }
        this.f20400p.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427711, this.A);
        this.B = aVar;
        this.f20400p.setAdapter(aVar);
        r0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8bfe\u540e\u4f5c\u4e1a\u5f00\u59cb\u7b54\u9898-PDF\u6587\u4ef6");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20395k = (TextView) findViewById(2131233002);
        this.f20396l = (TextView) findViewById(2131233211);
        this.f20397m = (TextView) findViewById(2131233146);
        this.f20398n = (TextView) findViewById(2131233112);
        this.f20399o = (TextView) findViewById(2131232969);
        this.f20400p = (RecyclerView) findViewById(2131232542);
        this.f20401q = (ImageView) findViewById(2131231434);
        this.f20402r = (ImageView) findViewById(2131231169);
        this.f20403s = (TextView) findViewById(2131232947);
        this.f20404t = (Button) findViewById(2131230970);
        this.f20405u = (Button) findViewById(2131230967);
        this.f20406v = (TextView) findViewById(2131233134);
        this.f20410z = (LinearLayout) findViewById(2131232197);
        this.f20401q.setImageResource(2131165515);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
