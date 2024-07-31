package com.bxkj.student.home.teaching.homework.question;

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
import com.bxkj.student.home.teaching.homework.HomeWorkApiService;
import com.bxkj.student.home.teaching.homework.question.VideoQuestionActivity;
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
    private LinearLayout f17083A;

    /* renamed from: B */
    private List<Map<String, Object>> f17084B;

    /* renamed from: C */
    private CommonAdapter<Map<String, Object>> f17085C;

    /* renamed from: E */
    private Dialog f17087E;

    /* renamed from: k */
    private TextView f17089k;

    /* renamed from: l */
    private TextView f17090l;

    /* renamed from: m */
    private TextView f17091m;

    /* renamed from: n */
    private TextView f17092n;

    /* renamed from: o */
    private TextView f17093o;

    /* renamed from: p */
    private RecyclerView f17094p;

    /* renamed from: q */
    private ImageView f17095q;

    /* renamed from: r */
    private ImageView f17096r;

    /* renamed from: s */
    private TextView f17097s;

    /* renamed from: t */
    private Button f17098t;

    /* renamed from: u */
    private Button f17099u;

    /* renamed from: v */
    private TextView f17100v;

    /* renamed from: w */
    private String f17101w;

    /* renamed from: x */
    private int f17102x;

    /* renamed from: y */
    private String f17103y;

    /* renamed from: z */
    private Bitmap f17104z;

    /* renamed from: D */
    private int f17086D = 60;

    /* renamed from: F */
    private final int f17088F = 187;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.VideoQuestionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4543a extends CommonAdapter<Map<String, Object>> {
        C4543a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void m42005o(Map map, View view) {
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
            holder.m57847w(C4215R.C4219id.fl_video_play, new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoQuestionActivity.C4543a.this.m42005o(stringObjectMap, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.VideoQuestionActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4544b extends HttpCallBack {
        C4544b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            VideoQuestionActivity.this.m57932R().setVisibility(0);
            VideoQuestionActivity.this.m42029U0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.VideoQuestionActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4545c extends HttpCallBack {
        C4545c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m42003b(View view) {
            VideoQuestionActivity.this.m42042H0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable e) {
            super.netOnFailure(e);
            if (e instanceof SocketTimeoutException) {
                new iOSOneButtonDialog(((BaseActivity) VideoQuestionActivity.this).f1669h).setMessage("上传超时,请检查网络后重试").setOneButtonText("重试").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.x
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VideoQuestionActivity.C4545c.this.m42003b(view);
                    }
                }).show();
                return;
            }
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            stringWriter.toString();
            new iOSOneButtonDialog(((BaseActivity) VideoQuestionActivity.this).f1669h).setMessage(new StringBuilder("上传失败,请尝试切换网络后重试或者尝试直接从APP录制上传")).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            VideoQuestionActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.VideoQuestionActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4546d implements VideoCompressor.InterfaceC4262b {

        /* renamed from: a */
        final ProgressDialog f17108a;

        /* renamed from: b */
        final /* synthetic */ String f17109b;

        C4546d(final String val$path) {
            this.f17109b = val$path;
            this.f17108a = new ProgressDialog(((BaseActivity) VideoQuestionActivity.this).f1669h);
        }

        @Override // com.bxkj.student.common.utils.video.VideoCompressor.InterfaceC4262b
        /* renamed from: a */
        public void mo41460a(int percent) {
            ProgressDialog progressDialog = this.f17108a;
            if (progressDialog == null || !progressDialog.isShowing()) {
                return;
            }
            this.f17108a.setProgress(percent);
        }

        @Override // com.bxkj.student.common.utils.video.VideoCompressor.InterfaceC4262b
        public void onFail() {
            ProgressDialog progressDialog = this.f17108a;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f17108a.dismiss();
            }
            new iOSOneButtonDialog(((BaseActivity) VideoQuestionActivity.this).f1669h).setMessage("压缩失败,请稍后再试").show();
        }

        @Override // com.bxkj.student.common.utils.video.VideoCompressor.InterfaceC4262b
        public void onStart() {
            this.f17108a.setTitle("正在压缩...");
            this.f17108a.setProgressStyle(1);
            this.f17108a.setCanceledOnTouchOutside(false);
            this.f17108a.setIndeterminate(false);
            this.f17108a.setProgress(0);
            this.f17108a.setMax(100);
            this.f17108a.show();
        }

        @Override // com.bxkj.student.common.utils.video.VideoCompressor.InterfaceC4262b
        public void onSuccess(String outputPath) {
            ProgressDialog progressDialog = this.f17108a;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f17108a.dismiss();
            }
            VideoQuestionActivity.this.f17103y = outputPath;
            VideoQuestionActivity.this.f17104z = VideoUtils.m42768a(this.f17109b);
            VideoQuestionActivity.this.f17095q.setImageBitmap(VideoQuestionActivity.this.f17104z);
            VideoQuestionActivity.this.f17098t.setVisibility(0);
            VideoQuestionActivity.this.f17096r.setVisibility(0);
            VideoQuestionActivity.this.f17097s.setVisibility(0);
            VideoQuestionActivity.this.f17097s.setText(VideoQuestionActivity.this.m42040J0(VideoUtils.m42767b(outputPath)));
            TextView textView = VideoQuestionActivity.this.f17093o;
            textView.setHint("您视频地址为:" + VideoQuestionActivity.this.f17103y);
            C11792j.m20470c("您视频地址为:" + VideoQuestionActivity.this.f17103y + " new File(videoFilePath).exists()=" + new File(VideoQuestionActivity.this.f17103y).exists());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public void m42042H0() {
        if (TextUtils.isEmpty(this.f17103y)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请拍摄视频").show();
            return;
        }
        File file = new File(this.f17103y);
        if (file.exists()) {
            C11792j.m20470c("文件存在");
            Http.with(this.f1669h).setLoadingMessage("正在上传...").setTimeout(3L, TimeUnit.MINUTES).setObservable(((HomeWorkApiService) Http.getApiService(HomeWorkApiService.class)).m42112a(RequestParameter.getRequestBody(this.f17101w), RequestParameter.getRequestBody(BitmapUtils.m44133a(this.f17104z)), RequestParameter.getFilePart("files", file))).setDataListener(new C4545c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public String m42040J0(long needFromatTime) {
        return new SimpleDateFormat("mm:ss").format(Long.valueOf(needFromatTime));
    }

    /* renamed from: K0 */
    private void m42039K0() {
        Http.with(this.f1669h).setObservable(((HomeWorkApiService) Http.getApiService(HomeWorkApiService.class)).m42110c(this.f17101w, this.f17102x)).setDataListener(new C4544b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void m42038L0(View view) {
        if (!TextUtils.isEmpty(this.f17103y)) {
            this.f17103y = "";
        }
        this.f17093o.setText("");
        this.f17095q.setImageResource(C4215R.C4218drawable.ic_upload_video);
        this.f17096r.setVisibility(8);
        this.f17097s.setVisibility(8);
        this.f17098t.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M0 */
    public /* synthetic */ void m42037M0(View view) {
        if (TextUtils.isEmpty(this.f17103y)) {
            m42028V0();
            return;
        }
        Intent intent = new Intent(this.f1669h, LocalVideoPreviewActivity.class);
        intent.putExtra("filepath", this.f17103y);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ void m42036N0(View view) {
        m42042H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void m42035O0(View view) {
        this.f17087E.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public /* synthetic */ Unit m42034P0() {
        m42026X0();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0 */
    public /* synthetic */ void m42033Q0(View view) {
        this.f17087E.dismiss();
        PermissionExt.m43834j(this.f1670i, "录制视频", new InterfaceC15269a() { // from class: com.bxkj.student.home.teaching.homework.question.v
            @Override // p617l1.InterfaceC15269a
            public final Object invoke() {
                Unit m42034P0;
                m42034P0 = VideoQuestionActivity.this.m42034P0();
                return m42034P0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0 */
    public /* synthetic */ Unit m42032R0() {
        m42041I0();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0 */
    public /* synthetic */ void m42031S0(View view) {
        this.f17087E.dismiss();
        PermissionExt.m43837g(this.f1670i, "相册", new InterfaceC15269a() { // from class: com.bxkj.student.home.teaching.homework.question.u
            @Override // p617l1.InterfaceC15269a
            public final Object invoke() {
                Unit m42032R0;
                m42032R0 = VideoQuestionActivity.this.m42032R0();
                return m42032R0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0 */
    public /* synthetic */ void m42030T0(String str, Bitmap bitmap) {
        m42027W0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0 */
    public void m42029U0(Map<String, Object> data) {
        boolean z = JsonParse.getBoolean(data, "isFlag");
        int i = this.f17102x;
        if (i == 1) {
            this.f17099u.setText("已合格");
            ((View) this.f17095q.getParent()).setVisibility(8);
            this.f17099u.setEnabled(false);
        } else if (i == 2) {
            this.f17099u.setText("待批改");
            ((View) this.f17095q.getParent()).setVisibility(8);
            this.f17099u.setEnabled(false);
        } else if (z) {
            this.f17099u.setText("提交");
            this.f17099u.setEnabled(true);
        } else {
            this.f17099u.setText("不合格");
            this.f17099u.setEnabled(false);
            ((View) this.f17095q.getParent()).setVisibility(8);
            this.f17100v.setVisibility(0);
            this.f17100v.setText(JsonParse.getString(data, "markAnswer"));
        }
        this.f17084B = JsonParse.getList(data, "questionsRecord");
        this.f17086D = JsonParse.getInt(data, "maxDuration", this.f17086D);
        if (this.f17084B.isEmpty()) {
            this.f17083A.setVisibility(8);
            this.f17094p.setVisibility(8);
        } else {
            this.f17085C.m57836g(this.f17084B);
        }
        TextView textView = this.f17091m;
        textView.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.f17092n.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
    }

    /* renamed from: W0 */
    private void m42027W0(String path) {
        new VideoCompressor().m42776d(this.f1669h, path, new C4546d(path));
    }

    /* renamed from: X0 */
    private void m42026X0() {
        new VideoRecorder().m42769e(this, this.f17086D, new VideoRecorder.InterfaceC4264a() { // from class: com.bxkj.student.home.teaching.homework.question.t
            @Override // com.bxkj.student.common.utils.video.VideoRecorder.InterfaceC4264a
            /* renamed from: a */
            public final void mo41441a(String str, Bitmap bitmap) {
                VideoQuestionActivity.this.m42030T0(str, bitmap);
            }
        });
    }

    /* renamed from: I0 */
    public void m42041I0() {
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
        this.f17098t.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.m42038L0(view);
            }
        });
        this.f17095q.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.m42037M0(view);
            }
        });
        this.f17099u.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.m42036N0(view);
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
            this.f17101w = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f17102x = getIntent().getIntExtra("isQualified", 0);
        }
        this.f17094p.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4543a c4543a = new C4543a(this.f1669h, C4215R.C4221layout.item_for_learn_video_list, this.f17084B);
        this.f17085C = c4543a;
        this.f17094p.setAdapter(c4543a);
        m42039K0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("课后作业开始答题-视频");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17089k = (TextView) findViewById(C4215R.C4219id.tv_index);
        this.f17090l = (TextView) findViewById(2131233211);
        this.f17091m = (TextView) findViewById(2131233146);
        this.f17092n = (TextView) findViewById(C4215R.C4219id.tv_question);
        this.f17093o = (TextView) findViewById(C4215R.C4219id.tv_file);
        this.f17094p = (RecyclerView) findViewById(C4215R.C4219id.rv_answer);
        this.f17095q = (ImageView) findViewById(2131231434);
        this.f17096r = (ImageView) findViewById(C4215R.C4219id.cv_video_flag);
        this.f17097s = (TextView) findViewById(C4215R.C4219id.tv_duration);
        this.f17098t = (Button) findViewById(2131230970);
        this.f17099u = (Button) findViewById(2131230967);
        this.f17100v = (TextView) findViewById(C4215R.C4219id.tv_right_answer);
        this.f17083A = (LinearLayout) findViewById(C4215R.C4219id.ll_history_answer);
    }

    /* renamed from: V0 */
    public void m42028V0() {
        View inflate = LayoutInflater.from(this.f1669h).inflate(2131428018, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(2131232891);
        Dialog dialog = new Dialog(this.f1669h, 2131886879);
        this.f17087E = dialog;
        dialog.setContentView(inflate);
        this.f17087E.getWindow().setGravity(80);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = this.f17087E.getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        this.f17087E.getWindow().setAttributes(attributes);
        this.f17087E.show();
        ((TextView) inflate.findViewById(2131232893)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.m42035O0(view);
            }
        });
        textView.setText("录制");
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.m42033Q0(view);
            }
        });
        ((TextView) inflate.findViewById(2131232976)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoQuestionActivity.this.m42031S0(view);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 187 && resultCode == -1 && data != null) {
            String m42846c = GetPathFromUri.m42846c(this.f1669h, data.getData());
            long m42767b = VideoUtils.m42767b(m42846c);
            if (m42767b / 1000 > this.f17086D) {
                iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(this.f1669h);
                iosonebuttondialog.setMessage("对不起,您选取的视频时长不能大于" + this.f17086D + "秒").show();
                return;
            }
            C11792j.m20470c("duration=" + m42767b);
            m42027W0(m42846c);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
