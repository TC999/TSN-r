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
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.base.util.BitmapUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.utils.GetPathFromUri;
import com.bxkj.student.common.utils.video.LocalVideoPreviewActivity;
import com.bxkj.student.common.utils.video.OnLinePlayVideoActivity;
import com.bxkj.student.common.utils.video.VideoCompressor;
import com.bxkj.student.common.utils.video.VideoRecorder;
import com.bxkj.student.common.utils.video.VideoUtils;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.bxkj.student.home.teaching.learning.question.VideoQuestionActivity;
import com.orhanobut.logger.C11792j;
import com.tencent.connect.share.QzonePublish;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import p617l1.InterfaceC15269a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class VideoQuestionActivity extends BaseActivity {

    /* renamed from: A */
    private List<Map<String, Object>> f17631A;

    /* renamed from: B */
    private CommonAdapter<Map<String, Object>> f17632B;

    /* renamed from: D */
    private Dialog f17634D;

    /* renamed from: k */
    private TextView f17636k;

    /* renamed from: l */
    private TextView f17637l;

    /* renamed from: m */
    private TextView f17638m;

    /* renamed from: n */
    private TextView f17639n;

    /* renamed from: o */
    private TextView f17640o;

    /* renamed from: p */
    private RecyclerView f17641p;

    /* renamed from: q */
    private ImageView f17642q;

    /* renamed from: r */
    private ImageView f17643r;

    /* renamed from: s */
    private TextView f17644s;

    /* renamed from: t */
    private Button f17645t;

    /* renamed from: u */
    private Button f17646u;

    /* renamed from: v */
    private String f17647v;

    /* renamed from: w */
    private int f17648w;

    /* renamed from: x */
    private String f17649x;

    /* renamed from: y */
    private Bitmap f17650y;

    /* renamed from: z */
    private LinearLayout f17651z;

    /* renamed from: C */
    private int f17633C = 60;

    /* renamed from: E */
    private final int f17635E = 187;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.VideoQuestionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4725a extends CommonAdapter<Map<String, Object>> {
        C4725a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void m41463o(Map map, View view) {
            VideoQuestionActivity.this.startActivity(new Intent(this.f1721a, OnLinePlayVideoActivity.class).putExtra(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, JsonParse.getString(map, "answerStr")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_commit_time, "回答时间：" + JsonParse.getString(stringObjectMap, "answerTime"));
            holder.m57850t(2131231451, JsonParse.getString(stringObjectMap, "learnVideoImage"), 2131165501, 2131165501);
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
            holder.m57847w(C4215R.C4219id.fl_video_play, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoQuestionActivity.C4725a.this.m41463o(stringObjectMap, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.VideoQuestionActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4726b extends HttpCallBack {
        C4726b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            VideoQuestionActivity.this.m57932R().setVisibility(0);
            VideoQuestionActivity.this.m41487U0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.VideoQuestionActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4727c extends HttpCallBack {
        C4727c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m41461b(View view) {
            VideoQuestionActivity.this.m41500H0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable e) {
            super.netOnFailure(e);
            if (e instanceof SocketTimeoutException) {
                new iOSOneButtonDialog(((BaseActivity) VideoQuestionActivity.this).f1669h).setMessage("上传超时,请检查网络后重试").setOneButtonText("重试").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VideoQuestionActivity.C4727c.this.m41461b(view);
                    }
                }).show();
                return;
            }
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            stringWriter.toString();
            new iOSOneButtonDialog(((BaseActivity) VideoQuestionActivity.this).f1669h).setMessage("上传失败,请尝试切换网络后重试或者尝试直接从APP录制上传").show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            VideoQuestionActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.VideoQuestionActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4728d implements VideoCompressor.InterfaceC4262b {

        /* renamed from: a */
        final ProgressDialog f17655a;

        /* renamed from: b */
        final /* synthetic */ String f17656b;

        C4728d(final String val$path) {
            this.f17656b = val$path;
            this.f17655a = new ProgressDialog(((BaseActivity) VideoQuestionActivity.this).f1669h);
        }

        @Override // com.bxkj.student.common.utils.video.VideoCompressor.InterfaceC4262b
        /* renamed from: a */
        public void mo41460a(int percent) {
            ProgressDialog progressDialog = this.f17655a;
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            this.f17655a.setProgress(percent);
        }

        @Override // com.bxkj.student.common.utils.video.VideoCompressor.InterfaceC4262b
        public void onFail() {
            ProgressDialog progressDialog = this.f17655a;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f17655a.dismiss();
            }
            new iOSOneButtonDialog(((BaseActivity) VideoQuestionActivity.this).f1669h).setMessage("压缩失败,请稍后再试").show();
        }

        @Override // com.bxkj.student.common.utils.video.VideoCompressor.InterfaceC4262b
        public void onStart() {
            this.f17655a.setTitle("正在压缩...");
            this.f17655a.setProgressStyle(1);
            this.f17655a.setIndeterminate(false);
            this.f17655a.setCanceledOnTouchOutside(false);
            this.f17655a.setProgress(0);
            this.f17655a.setMax(100);
            this.f17655a.show();
        }

        @Override // com.bxkj.student.common.utils.video.VideoCompressor.InterfaceC4262b
        public void onSuccess(String outputPath) {
            ProgressDialog progressDialog = this.f17655a;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f17655a.dismiss();
            }
            VideoQuestionActivity.this.f17649x = outputPath;
            VideoQuestionActivity.this.f17650y = VideoUtils.m42768a(this.f17656b);
            VideoQuestionActivity.this.f17642q.setImageBitmap(VideoQuestionActivity.this.f17650y);
            VideoQuestionActivity.this.f17645t.setVisibility(0);
            VideoQuestionActivity.this.f17643r.setVisibility(0);
            VideoQuestionActivity.this.f17644s.setVisibility(0);
            VideoQuestionActivity.this.f17644s.setText(VideoQuestionActivity.this.m41498J0(VideoUtils.m42767b(outputPath)));
            TextView textView = VideoQuestionActivity.this.f17640o;
            textView.setHint("您视频地址为:" + VideoQuestionActivity.this.f17649x);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public void m41500H0() {
        if (TextUtils.isEmpty(this.f17649x)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请拍摄视频").show();
            return;
        }
        File file = new File(this.f17649x);
        if (file.exists()) {
            C11792j.m20470c("文件存在");
            Http.with(this.f1669h).setLoadingMessage("正在上传...").setTimeout(10L, TimeUnit.MINUTES).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41641a(RequestParameter.getRequestBody(this.f17647v), RequestParameter.getRequestBody(BitmapUtils.m44133a(this.f17650y)), RequestParameter.getFilePart("files", file))).setDataListener(new C4727c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public String m41498J0(long needFromatTime) {
        return new SimpleDateFormat("mm:ss").format(Long.valueOf(needFromatTime));
    }

    /* renamed from: K0 */
    private void m41497K0() {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41639c(this.f17647v, this.f17648w)).setDataListener(new C4726b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void m41496L0(View view) {
        if (!TextUtils.isEmpty(this.f17649x)) {
            this.f17649x = "";
        }
        this.f17640o.setText("");
        this.f17642q.setImageResource(C4215R.C4218drawable.ic_upload_video);
        this.f17645t.setVisibility(8);
        this.f17643r.setVisibility(8);
        this.f17644s.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M0 */
    public /* synthetic */ void m41495M0(View view) {
        if (TextUtils.isEmpty(this.f17649x)) {
            m41486V0();
            return;
        }
        Intent intent = new Intent(this.f1669h, LocalVideoPreviewActivity.class);
        intent.putExtra("filepath", this.f17649x);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ void m41494N0(View view) {
        m41500H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void m41493O0(View view) {
        this.f17634D.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public /* synthetic */ Unit m41492P0() {
        m41484X0();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0 */
    public /* synthetic */ void m41491Q0(View view) {
        this.f17634D.dismiss();
        PermissionExt.m43834j(this.f1670i, "录制视频", new InterfaceC15269a() { // from class: com.bxkj.student.home.teaching.learning.question.o
            @Override // p617l1.InterfaceC15269a
            public final Object invoke() {
                Unit m41492P0;
                m41492P0 = VideoQuestionActivity.this.m41492P0();
                return m41492P0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0 */
    public /* synthetic */ Unit m41490R0() {
        m41499I0();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0 */
    public /* synthetic */ void m41489S0(View view) {
        this.f17634D.dismiss();
        PermissionExt.m43837g(this.f1670i, "相册", new InterfaceC15269a() { // from class: com.bxkj.student.home.teaching.learning.question.p
            @Override // p617l1.InterfaceC15269a
            public final Object invoke() {
                Unit m41490R0;
                m41490R0 = VideoQuestionActivity.this.m41490R0();
                return m41490R0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0 */
    public /* synthetic */ void m41488T0(String str, Bitmap bitmap) {
        m41485W0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0 */
    public void m41487U0(Map<String, Object> data) {
        this.f17631A = JsonParse.getList(data, "questionsRecord");
        this.f17633C = JsonParse.getInt(data, "maxDuration", this.f17633C);
        if (this.f17631A.isEmpty()) {
            this.f17651z.setVisibility(8);
            this.f17641p.setVisibility(8);
        } else {
            this.f17632B.m57836g(this.f17631A);
        }
        TextView textView = this.f17638m;
        textView.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.f17639n.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    /* renamed from: W0 */
    private void m41485W0(String path) {
        new VideoCompressor().m42776d(this.f1669h, path, new C4728d(path));
    }

    /* renamed from: X0 */
    private void m41484X0() {
        new VideoRecorder().m42769e(this, this.f17633C, new VideoRecorder.InterfaceC4264a() { // from class: com.bxkj.student.home.teaching.learning.question.n
            @Override // com.bxkj.student.common.utils.video.VideoRecorder.InterfaceC4264a
            /* renamed from: a */
            public final void mo41441a(String str, Bitmap bitmap) {
                VideoQuestionActivity.this.m41488T0(str, bitmap);
            }
        });
    }

    /* renamed from: I0 */
    public void m41499I0() {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT < 19) {
            intent.setAction("android.intent.action.GET_CONTENT");
            intent.setType("video/*");
        } else {
            intent.setAction("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("video/*");
        }
        startActivityForResult(Intent.createChooser(intent, "选择要录制的视频"), 187);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17645t.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.m41496L0(view);
            }
        });
        this.f17642q.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.m41495M0(view);
            }
        });
        this.f17646u.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.m41494N0(view);
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
            this.f17647v = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f17648w = getIntent().getIntExtra("isQualified", 0);
        }
        int i = this.f17648w;
        if (i == 1) {
            this.f17646u.setText("已合格");
            ((View) this.f17642q.getParent()).setVisibility(8);
            this.f17646u.setEnabled(false);
        } else if (i == 2) {
            this.f17646u.setText("待批改");
            ((View) this.f17642q.getParent()).setVisibility(8);
            this.f17646u.setEnabled(false);
        }
        this.f17641p.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4725a c4725a = new C4725a(this.f1669h, C4215R.C4221layout.item_for_learn_video_list, this.f17631A);
        this.f17632B = c4725a;
        this.f17641p.setAdapter(c4725a);
        m41497K0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("开始答题-视频");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17636k = (TextView) findViewById(C4215R.C4219id.tv_index);
        this.f17637l = (TextView) findViewById(2131233211);
        this.f17638m = (TextView) findViewById(2131233146);
        this.f17639n = (TextView) findViewById(C4215R.C4219id.tv_question);
        this.f17640o = (TextView) findViewById(C4215R.C4219id.tv_file);
        this.f17641p = (RecyclerView) findViewById(C4215R.C4219id.rv_answer);
        this.f17642q = (ImageView) findViewById(2131231434);
        this.f17645t = (Button) findViewById(2131230970);
        this.f17643r = (ImageView) findViewById(C4215R.C4219id.cv_video_flag);
        this.f17644s = (TextView) findViewById(C4215R.C4219id.tv_duration);
        this.f17646u = (Button) findViewById(2131230967);
        this.f17651z = (LinearLayout) findViewById(C4215R.C4219id.ll_history_answer);
    }

    /* renamed from: V0 */
    public void m41486V0() {
        View inflate = LayoutInflater.from(this.f1669h).inflate(2131428018, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(2131232891);
        Dialog dialog = new Dialog(this.f1669h, 2131886879);
        this.f17634D = dialog;
        dialog.setContentView(inflate);
        this.f17634D.getWindow().setGravity(80);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = this.f17634D.getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        this.f17634D.getWindow().setAttributes(attributes);
        this.f17634D.show();
        ((TextView) inflate.findViewById(2131232893)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.m41493O0(view);
            }
        });
        textView.setText("录制");
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.m41491Q0(view);
            }
        });
        ((TextView) inflate.findViewById(2131232976)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.m41489S0(view);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 187 && resultCode == -1 && data != null) {
            String m42846c = GetPathFromUri.m42846c(this.f1669h, data.getData());
            long m42767b = VideoUtils.m42767b(m42846c);
            if (m42767b / 1000 > this.f17633C) {
                iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1669h);
                iosonebuttondialog.setMessage("对不起,您选取的视频时长不能大于" + this.f17633C + "秒").show();
                return;
            }
            C11792j.m20470c("duration=" + m42767b);
            m41485W0(m42846c);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
