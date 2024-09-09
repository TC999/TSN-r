package com.bxkj.student.home.teaching.learning.question;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
import com.bxkj.student.common.utils.video.LocalVideoPreviewActivity;
import com.bxkj.student.common.utils.video.OnLinePlayVideoActivity;
import com.bxkj.student.common.utils.video.e;
import com.bxkj.student.common.utils.video.g;
import com.bxkj.student.home.teaching.learning.question.VideoQuestionActivity;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.f1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class VideoQuestionActivity extends BaseActivity {
    private List<Map<String, Object>> A;
    private CommonAdapter<Map<String, Object>> B;
    private Dialog D;

    /* renamed from: k  reason: collision with root package name */
    private TextView f20974k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f20975l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20976m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f20977n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f20978o;

    /* renamed from: p  reason: collision with root package name */
    private RecyclerView f20979p;

    /* renamed from: q  reason: collision with root package name */
    private ImageView f20980q;

    /* renamed from: r  reason: collision with root package name */
    private ImageView f20981r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f20982s;

    /* renamed from: t  reason: collision with root package name */
    private Button f20983t;

    /* renamed from: u  reason: collision with root package name */
    private Button f20984u;

    /* renamed from: v  reason: collision with root package name */
    private String f20985v;

    /* renamed from: w  reason: collision with root package name */
    private int f20986w;

    /* renamed from: x  reason: collision with root package name */
    private String f20987x;

    /* renamed from: y  reason: collision with root package name */
    private Bitmap f20988y;

    /* renamed from: z  reason: collision with root package name */
    private LinearLayout f20989z;
    private int C = 60;
    private final int E = 187;

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
            VideoQuestionActivity.this.startActivity(new Intent(this.f1707a, OnLinePlayVideoActivity.class).putExtra("videoPath", JsonParse.getString(map, "answerStr")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131232909, "\u56de\u7b54\u65f6\u95f4\uff1a" + JsonParse.getString(stringObjectMap, "answerTime"));
            holder.t(2131231451, JsonParse.getString(stringObjectMap, "learnVideoImage"), 2131165501, 2131165501);
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
            holder.w(2131231313, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoQuestionActivity.a.this.o(stringObjectMap, view);
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
            VideoQuestionActivity.this.R().setVisibility(0);
            VideoQuestionActivity.this.U0(data);
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
            VideoQuestionActivity.this.H0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable e4) {
            super.netOnFailure(e4);
            if (e4 instanceof SocketTimeoutException) {
                new iOSOneButtonDialog(((BaseActivity) VideoQuestionActivity.this).f1656h).setMessage("\u4e0a\u4f20\u8d85\u65f6,\u8bf7\u68c0\u67e5\u7f51\u7edc\u540e\u91cd\u8bd5").setOneButtonText("\u91cd\u8bd5").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VideoQuestionActivity.c.this.b(view);
                    }
                }).show();
                return;
            }
            StringWriter stringWriter = new StringWriter();
            e4.printStackTrace(new PrintWriter(stringWriter));
            stringWriter.toString();
            new iOSOneButtonDialog(((BaseActivity) VideoQuestionActivity.this).f1656h).setMessage("\u4e0a\u4f20\u5931\u8d25,\u8bf7\u5c1d\u8bd5\u5207\u6362\u7f51\u7edc\u540e\u91cd\u8bd5\u6216\u8005\u5c1d\u8bd5\u76f4\u63a5\u4eceAPP\u5f55\u5236\u4e0a\u4f20").show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            VideoQuestionActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements e.b {

        /* renamed from: a  reason: collision with root package name */
        final ProgressDialog f20993a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f20994b;

        d(final String val$path) {
            this.f20994b = val$path;
            this.f20993a = new ProgressDialog(((BaseActivity) VideoQuestionActivity.this).f1656h);
        }

        @Override // com.bxkj.student.common.utils.video.e.b
        public void a(int percent) {
            ProgressDialog progressDialog = this.f20993a;
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            this.f20993a.setProgress(percent);
        }

        @Override // com.bxkj.student.common.utils.video.e.b
        public void onFail() {
            ProgressDialog progressDialog = this.f20993a;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f20993a.dismiss();
            }
            new iOSOneButtonDialog(((BaseActivity) VideoQuestionActivity.this).f1656h).setMessage("\u538b\u7f29\u5931\u8d25,\u8bf7\u7a0d\u540e\u518d\u8bd5").show();
        }

        @Override // com.bxkj.student.common.utils.video.e.b
        public void onStart() {
            this.f20993a.setTitle("\u6b63\u5728\u538b\u7f29...");
            this.f20993a.setProgressStyle(1);
            this.f20993a.setIndeterminate(false);
            this.f20993a.setCanceledOnTouchOutside(false);
            this.f20993a.setProgress(0);
            this.f20993a.setMax(100);
            this.f20993a.show();
        }

        @Override // com.bxkj.student.common.utils.video.e.b
        public void onSuccess(String outputPath) {
            ProgressDialog progressDialog = this.f20993a;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f20993a.dismiss();
            }
            VideoQuestionActivity.this.f20987x = outputPath;
            VideoQuestionActivity.this.f20988y = com.bxkj.student.common.utils.video.h.a(this.f20994b);
            VideoQuestionActivity.this.f20980q.setImageBitmap(VideoQuestionActivity.this.f20988y);
            VideoQuestionActivity.this.f20983t.setVisibility(0);
            VideoQuestionActivity.this.f20981r.setVisibility(0);
            VideoQuestionActivity.this.f20982s.setVisibility(0);
            VideoQuestionActivity.this.f20982s.setText(VideoQuestionActivity.this.J0(com.bxkj.student.common.utils.video.h.b(outputPath)));
            TextView textView = VideoQuestionActivity.this.f20978o;
            textView.setHint("\u60a8\u89c6\u9891\u5730\u5740\u4e3a:" + VideoQuestionActivity.this.f20987x);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        if (TextUtils.isEmpty(this.f20987x)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u62cd\u6444\u89c6\u9891").show();
            return;
        }
        File file = new File(this.f20987x);
        if (file.exists()) {
            com.orhanobut.logger.j.c("\u6587\u4ef6\u5b58\u5728");
            Http.with(this.f1656h).setLoadingMessage("\u6b63\u5728\u4e0a\u4f20...").setTimeout(10L, TimeUnit.MINUTES).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).a(RequestParameter.getRequestBody(this.f20985v), RequestParameter.getRequestBody(com.bxkj.base.util.c.a(this.f20988y)), RequestParameter.getFilePart("files", file))).setDataListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String J0(long needFromatTime) {
        return new SimpleDateFormat("mm:ss").format(Long.valueOf(needFromatTime));
    }

    private void K0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).c(this.f20985v, this.f20986w)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(View view) {
        if (!TextUtils.isEmpty(this.f20987x)) {
            this.f20987x = "";
        }
        this.f20978o.setText("");
        this.f20980q.setImageResource(2131165516);
        this.f20983t.setVisibility(8);
        this.f20981r.setVisibility(8);
        this.f20982s.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(View view) {
        if (TextUtils.isEmpty(this.f20987x)) {
            V0();
            return;
        }
        Intent intent = new Intent(this.f1656h, LocalVideoPreviewActivity.class);
        intent.putExtra("filepath", this.f20987x);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(View view) {
        H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(View view) {
        this.D.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 P0() {
        X0();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(View view) {
        this.D.dismiss();
        com.bxkj.base.v2.common.ext.g.j(this.f1657i, "\u5f55\u5236\u89c6\u9891", new l1.a() { // from class: com.bxkj.student.home.teaching.learning.question.o
            public final Object invoke() {
                f1 P0;
                P0 = VideoQuestionActivity.this.P0();
                return P0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 R0() {
        I0();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(View view) {
        this.D.dismiss();
        com.bxkj.base.v2.common.ext.g.g(this.f1657i, "\u76f8\u518c", new l1.a() { // from class: com.bxkj.student.home.teaching.learning.question.p
            public final Object invoke() {
                f1 R0;
                R0 = VideoQuestionActivity.this.R0();
                return R0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(String str, Bitmap bitmap) {
        W0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(Map<String, Object> data) {
        this.A = JsonParse.getList(data, "questionsRecord");
        this.C = JsonParse.getInt(data, "maxDuration", this.C);
        if (this.A.isEmpty()) {
            this.f20989z.setVisibility(8);
            this.f20979p.setVisibility(8);
        } else {
            this.B.g(this.A);
        }
        TextView textView = this.f20976m;
        textView.setText("(" + JsonParse.getString(data, "socre") + "\u5206)");
        this.f20977n.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    private void W0(String path) {
        new com.bxkj.student.common.utils.video.e().d(this.f1656h, path, new d(path));
    }

    private void X0() {
        new com.bxkj.student.common.utils.video.g().e(this, this.C, new g.a() { // from class: com.bxkj.student.home.teaching.learning.question.n
            @Override // com.bxkj.student.common.utils.video.g.a
            public final void a(String str, Bitmap bitmap) {
                VideoQuestionActivity.this.T0(str, bitmap);
            }
        });
    }

    public void I0() {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT < 19) {
            intent.setAction("android.intent.action.GET_CONTENT");
            intent.setType("video/*");
        } else {
            intent.setAction("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("video/*");
        }
        startActivityForResult(Intent.createChooser(intent, "\u9009\u62e9\u8981\u5f55\u5236\u7684\u89c6\u9891"), 187);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20983t.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.L0(view);
            }
        });
        this.f20980q.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.M0(view);
            }
        });
        this.f20984u.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.N0(view);
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
            this.f20985v = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f20986w = getIntent().getIntExtra("isQualified", 0);
        }
        int i4 = this.f20986w;
        if (i4 == 1) {
            this.f20984u.setText("\u5df2\u5408\u683c");
            ((View) this.f20980q.getParent()).setVisibility(8);
            this.f20984u.setEnabled(false);
        } else if (i4 == 2) {
            this.f20984u.setText("\u5f85\u6279\u6539");
            ((View) this.f20980q.getParent()).setVisibility(8);
            this.f20984u.setEnabled(false);
        }
        this.f20979p.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427711, this.A);
        this.B = aVar;
        this.f20979p.setAdapter(aVar);
        K0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5f00\u59cb\u7b54\u9898-\u89c6\u9891");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20974k = (TextView) findViewById(2131233002);
        this.f20975l = (TextView) findViewById(2131233211);
        this.f20976m = (TextView) findViewById(2131233146);
        this.f20977n = (TextView) findViewById(2131233112);
        this.f20978o = (TextView) findViewById(2131232969);
        this.f20979p = (RecyclerView) findViewById(2131232542);
        this.f20980q = (ImageView) findViewById(2131231434);
        this.f20983t = (Button) findViewById(2131230970);
        this.f20981r = (ImageView) findViewById(2131231169);
        this.f20982s = (TextView) findViewById(2131232947);
        this.f20984u = (Button) findViewById(2131230967);
        this.f20989z = (LinearLayout) findViewById(2131232197);
    }

    public void V0() {
        View inflate = LayoutInflater.from(this.f1656h).inflate(2131428018, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(2131232891);
        Dialog dialog = new Dialog(this.f1656h, 2131886879);
        this.D = dialog;
        dialog.setContentView(inflate);
        this.D.getWindow().setGravity(80);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = this.D.getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        this.D.getWindow().setAttributes(attributes);
        this.D.show();
        ((TextView) inflate.findViewById(2131232893)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.O0(view);
            }
        });
        textView.setText("\u5f55\u5236");
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.Q0(view);
            }
        });
        ((TextView) inflate.findViewById(2131232976)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.S0(view);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 187 && resultCode == -1 && data != null) {
            String c4 = com.bxkj.student.common.utils.e.c(this.f1656h, data.getData());
            long b4 = com.bxkj.student.common.utils.video.h.b(c4);
            if (b4 / 1000 > this.C) {
                iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1656h);
                iosonebuttondialog.setMessage("\u5bf9\u4e0d\u8d77,\u60a8\u9009\u53d6\u7684\u89c6\u9891\u65f6\u957f\u4e0d\u80fd\u5927\u4e8e" + this.C + "\u79d2").show();
                return;
            }
            com.orhanobut.logger.j.c("duration=" + b4);
            W0(c4);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
