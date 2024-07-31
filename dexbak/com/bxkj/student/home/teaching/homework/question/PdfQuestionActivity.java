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
import com.bxkj.base.util.file.C3898b;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.GetPathFromUri;
import com.bxkj.student.home.teaching.homework.HomeWorkApiService;
import com.bxkj.student.home.teaching.homework.question.PdfQuestionActivity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.orhanobut.logger.C11792j;
import java.io.File;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p618m.StartActivityForResult;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PdfQuestionActivity extends BaseActivity {

    /* renamed from: A */
    private List<Map<String, Object>> f17027A;

    /* renamed from: B */
    private CommonAdapter<Map<String, Object>> f17028B;

    /* renamed from: C */
    private int f17029C = 60;

    /* renamed from: D */
    private final int f17030D = 23;

    /* renamed from: k */
    private TextView f17031k;

    /* renamed from: l */
    private TextView f17032l;

    /* renamed from: m */
    private TextView f17033m;

    /* renamed from: n */
    private TextView f17034n;

    /* renamed from: o */
    private TextView f17035o;

    /* renamed from: p */
    private RecyclerView f17036p;

    /* renamed from: q */
    private ImageView f17037q;

    /* renamed from: r */
    private ImageView f17038r;

    /* renamed from: s */
    private TextView f17039s;

    /* renamed from: t */
    private Button f17040t;

    /* renamed from: u */
    private Button f17041u;

    /* renamed from: v */
    private TextView f17042v;

    /* renamed from: w */
    private String f17043w;

    /* renamed from: x */
    private int f17044x;

    /* renamed from: y */
    private String f17045y;

    /* renamed from: z */
    private LinearLayout f17046z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.PdfQuestionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4534a extends CommonAdapter<Map<String, Object>> {
        C4534a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void m42067o(Map map, View view) {
            PdfQuestionActivity.this.startActivity(new Intent(this.f1721a, PdfViewActivity.class).putExtra("url", JsonParse.getString(map, "answerStr")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_commit_time, "回答时间：" + JsonParse.getString(stringObjectMap, "answerTime"));
            holder.m57852r(2131231451, 2131165510);
            holder.m57870N(C4215R.C4219id.cv_video_flag, false);
            String string = JsonParse.getString(stringObjectMap, "reviewTime");
            holder.m57870N(C4215R.C4219id.tv_check_time, !TextUtils.isEmpty(string));
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
            holder.m57847w(C4215R.C4219id.fl_video_play, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PdfQuestionActivity.C4534a.this.m42067o(stringObjectMap, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.PdfQuestionActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4535b extends HttpCallBack {
        C4535b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PdfQuestionActivity.this.m57932R().setVisibility(0);
            PdfQuestionActivity.this.m42070w0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.PdfQuestionActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4536c extends HttpCallBack {
        C4536c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m42065b(View view) {
            PdfQuestionActivity.this.m42076q0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable e) {
            super.netOnFailure(e);
            if (e instanceof SocketTimeoutException) {
                new iOSOneButtonDialog(((BaseActivity) PdfQuestionActivity.this).f1669h).setMessage("上传超时,请检查网络后重试").setOneButtonText("重试").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PdfQuestionActivity.C4536c.this.m42065b(view);
                    }
                }).show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            PdfQuestionActivity.this.finish();
        }
    }

    /* renamed from: p0 */
    private void m42077p0() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("application/pdf");
        intent.addCategory("android.intent.category.OPENABLE");
        new StartActivityForResult(this).startActivityForResult(intent).m3460c(new StartActivityForResult.InterfaceC15293a() { // from class: com.bxkj.student.home.teaching.homework.question.i
            @Override // p618m.StartActivityForResult.InterfaceC15293a
            /* renamed from: a */
            public final void mo3459a(int i, Intent intent2) {
                PdfQuestionActivity.this.m42071v0(i, intent2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public void m42076q0() {
        if (TextUtils.isEmpty(this.f17045y)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请选择文件").show();
            return;
        }
        File file = new File(this.f17045y);
        if (file.exists()) {
            C11792j.m20470c("文件存在");
            Http.with(this.f1669h).setLoadingMessage("正在上传...").setTimeout(3L, TimeUnit.MINUTES).setObservable(((HomeWorkApiService) Http.getApiService(HomeWorkApiService.class)).m42112a(RequestParameter.getRequestBody(this.f17043w), null, RequestParameter.getFilePart("files", file))).setDataListener(new C4536c());
        }
    }

    /* renamed from: r0 */
    private void m42075r0() {
        Http.with(this.f1669h).setObservable(((HomeWorkApiService) Http.getApiService(HomeWorkApiService.class)).m42110c(this.f17043w, this.f17044x)).setDataListener(new C4535b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void m42074s0(View view) {
        if (!TextUtils.isEmpty(this.f17045y)) {
            this.f17045y = "";
        }
        this.f17035o.setText("");
        this.f17037q.setImageResource(C4215R.C4218drawable.ic_upload_pdf);
        this.f17038r.setVisibility(8);
        this.f17039s.setVisibility(8);
        this.f17040t.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void m42073t0(View view) {
        if (TextUtils.isEmpty(this.f17045y)) {
            m42077p0();
            return;
        }
        Intent intent = new Intent(this.f1669h, PdfViewActivity.class);
        intent.putExtra(TTDownloadField.TT_FILE_PATH, this.f17045y);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void m42072u0(View view) {
        m42076q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void m42071v0(int i, Intent intent) {
        if (intent != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f17045y = GetPathFromUri.m42847b(this.f1669h, intent.getData());
            } else {
                this.f17045y = GetPathFromUri.m42846c(this.f1669h, intent.getData());
            }
            if (!"pdf".equalsIgnoreCase(C3898b.m44102i(this.f17045y))) {
                this.f17045y = null;
                new iOSOneButtonDialog(this.f1669h).setMessage("只能上传PDF文件").show();
                return;
            }
            this.f17037q.setImageResource(C4215R.mipmap.pdf);
            this.f17040t.setVisibility(0);
            C11792j.m20470c("filePath=" + this.f17045y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public void m42070w0(Map<String, Object> data) {
        this.f17032l.setText(JsonParse.getString(data, "questionTypeName"));
        boolean z = JsonParse.getBoolean(data, "isFlag");
        int i = this.f17044x;
        if (i == 1) {
            this.f17041u.setText("已合格");
            ((View) this.f17037q.getParent()).setVisibility(8);
            this.f17041u.setEnabled(false);
        } else if (i == 2) {
            this.f17041u.setText("待批改");
            ((View) this.f17037q.getParent()).setVisibility(8);
            this.f17041u.setEnabled(false);
        } else if (z) {
            this.f17041u.setText("提交");
            this.f17041u.setEnabled(true);
        } else {
            this.f17041u.setText("不合格");
            this.f17041u.setEnabled(false);
            ((View) this.f17037q.getParent()).setVisibility(8);
            this.f17042v.setVisibility(0);
            this.f17042v.setText(JsonParse.getString(data, "markAnswer"));
        }
        this.f17027A = JsonParse.getList(data, "questionsRecord");
        this.f17029C = JsonParse.getInt(data, "maxDuration", this.f17029C);
        if (this.f17027A.isEmpty()) {
            this.f17046z.setVisibility(8);
            this.f17036p.setVisibility(8);
        } else {
            this.f17028B.m57836g(this.f17027A);
        }
        TextView textView = this.f17033m;
        textView.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.f17034n.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17040t.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PdfQuestionActivity.this.m42074s0(view);
            }
        });
        this.f17037q.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PdfQuestionActivity.this.m42073t0(view);
            }
        });
        this.f17041u.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PdfQuestionActivity.this.m42072u0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_learn_video_question;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.f17043w = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f17044x = getIntent().getIntExtra("isQualified", 0);
        }
        this.f17036p.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4534a c4534a = new C4534a(this.f1669h, C4215R.C4221layout.item_for_learn_video_list, this.f17027A);
        this.f17028B = c4534a;
        this.f17036p.setAdapter(c4534a);
        m42075r0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("课后作业开始答题-PDF文件");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17031k = (TextView) findViewById(C4215R.C4219id.tv_index);
        this.f17032l = (TextView) findViewById(2131233211);
        this.f17033m = (TextView) findViewById(2131233146);
        this.f17034n = (TextView) findViewById(C4215R.C4219id.tv_question);
        this.f17035o = (TextView) findViewById(C4215R.C4219id.tv_file);
        this.f17036p = (RecyclerView) findViewById(C4215R.C4219id.rv_answer);
        this.f17037q = (ImageView) findViewById(2131231434);
        this.f17038r = (ImageView) findViewById(C4215R.C4219id.cv_video_flag);
        this.f17039s = (TextView) findViewById(C4215R.C4219id.tv_duration);
        this.f17040t = (Button) findViewById(2131230970);
        this.f17041u = (Button) findViewById(2131230967);
        this.f17042v = (TextView) findViewById(C4215R.C4219id.tv_right_answer);
        this.f17046z = (LinearLayout) findViewById(C4215R.C4219id.ll_history_answer);
        this.f17037q.setImageResource(C4215R.C4218drawable.ic_upload_pdf);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
