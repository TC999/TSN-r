package com.bxkj.student.home.teaching.learning.detail;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.sqlitelibrary.SQLiteDbUtil;
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.learning.FaceDetectLearnActivity;
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.bxkj.student.home.teaching.learning.detail.C4655k;
import com.bxkj.student.home.teaching.learning.detail.p090db.ReadExceptionDataDB;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.orhanobut.logger.C11792j;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Unit;
import org.slf4j.Marker;
import p617l1.InterfaceC15269a;

/* compiled from: AlertConfirmReadDialog.java */
/* renamed from: com.bxkj.student.home.teaching.learning.detail.k */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C4655k {

    /* renamed from: a */
    private Context f17410a;

    /* renamed from: b */
    private Button f17411b;

    /* renamed from: d */
    private int f17413d;

    /* renamed from: e */
    private String f17414e;

    /* renamed from: f */
    private String f17415f;

    /* renamed from: g */
    private int f17416g;

    /* renamed from: h */
    private int f17417h;

    /* renamed from: i */
    private int f17418i;

    /* renamed from: j */
    private int f17419j;

    /* renamed from: k */
    private int f17420k;

    /* renamed from: l */
    private Long f17421l;

    /* renamed from: m */
    public Timer f17422m;

    /* renamed from: n */
    public TimerTask f17423n;

    /* renamed from: o */
    private BottomFragment f17424o;

    /* renamed from: p */
    private iOSTwoButtonDialog f17425p;

    /* renamed from: q */
    private C4679v f17426q;

    /* renamed from: r */
    private ReadExceptionDataDB f17427r;

    /* renamed from: c */
    private int f17412c = 0;

    /* renamed from: s */
    private long f17428s = 0;

    /* renamed from: t */
    private final int f17429t = 170;

    /* renamed from: u */
    public Handler f17430u = new HandlerC4657b();

    /* renamed from: v */
    private boolean f17431v = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlertConfirmReadDialog.java */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.k$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4656a extends TimerTask {
        C4656a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (C4655k.this.f17431v) {
                return;
            }
            C4655k.m41683o(C4655k.this);
            if (C4655k.this.f17428s % 10 == 0) {
                C4655k.this.m41702Q();
            }
            C4655k.this.f17430u.sendEmptyMessage(170);
        }
    }

    /* compiled from: AlertConfirmReadDialog.java */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.k$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class HandlerC4657b extends Handler {
        HandlerC4657b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what != 170) {
                return;
            }
            C4655k.this.m41672z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlertConfirmReadDialog.java */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.k$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4658c implements TextWatcher {

        /* renamed from: a */
        final /* synthetic */ EditText f17434a;

        /* renamed from: b */
        final /* synthetic */ Button f17435b;

        C4658c(final EditText val$et_code, final Button val$btn_two) {
            this.f17434a = val$et_code;
            this.f17435b = val$btn_two;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Context context;
            int i;
            boolean z = this.f17434a.getText().toString().length() == 4;
            this.f17435b.setEnabled(z);
            Button button = this.f17435b;
            if (z) {
                context = C4655k.this.f17410a;
                i = C4215R.C4217color.ios_dialog_button_color;
            } else {
                context = C4655k.this.f17410a;
                i = 2131034173;
            }
            button.setTextColor(ContextCompat.getColor(context, i));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlertConfirmReadDialog.java */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.k$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4659d extends HttpCallBack {
        C4659d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void m41669c() {
            C4655k.this.m41716C();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void m41668d() {
            C4655k.this.m41716C();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if (ex instanceof SocketTimeoutException) {
                new iOSTwoButtonDialog(C4655k.this.f17410a).setMessage("获取积分超时,请重试").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.m
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        C4655k.C4659d.this.m41669c();
                    }
                }).setRightButtonText("重试").show();
            } else {
                new iOSTwoButtonDialog(C4655k.this.f17410a).setMessage("获取积分失败,请重试").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.l
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        C4655k.C4659d.this.m41668d();
                    }
                }).setRightButtonText("重试").show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            C4655k.this.f17411b.setText("");
            C4655k.this.f17411b.setEnabled(false);
            ((LearnDetailActivity) C4655k.this.f17424o.getActivity()).m41822w0(false);
            new iOSOneButtonDialog(C4655k.this.f17410a).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            C4655k.this.f17411b.setText(C4655k.this.f17418i == 1 ? "开始答题" : "已完成");
            C4655k.this.f17411b.setEnabled(C4655k.this.f17418i == 1);
            ((LearnDetailActivity) C4655k.this.f17424o.getActivity()).m41822w0(false);
            LearnHomeListActivity learnHomeListActivity = (LearnHomeListActivity) AppManager.m57776n().getActivity(LearnHomeListActivity.class);
            if (learnHomeListActivity != null) {
                learnHomeListActivity.m41949V0();
            }
            Toast toast = new Toast(C4655k.this.f17410a);
            View inflate = View.inflate(C4655k.this.f17410a, C4215R.C4221layout.toast_learn_get, null);
            ((LinearLayout) inflate.findViewById(2131232217)).setLayoutParams(new ViewGroup.LayoutParams(Tools.m57620a(120.0f, C4655k.this.f17410a), Tools.m57620a(120.0f, C4655k.this.f17410a)));
            ((TextView) inflate.findViewById(C4215R.C4219id.tv_message)).setText(Marker.ANY_NON_NULL_MARKER + C4655k.this.f17420k + "积分");
            toast.setView(inflate);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.show();
            SQLiteDbUtil.m57474h().delete(ReadExceptionDataDB.class, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), C4655k.this.f17415f});
            C4655k.this.f17427r = null;
        }
    }

    public C4655k(BottomFragment bottomFragment, Context mContext, int duration, int popTime, String id, String detailId, Button bt_question, int hasQuestion, int valType, int integral) {
        this.f17413d = 0;
        this.f17416g = 30;
        this.f17424o = bottomFragment;
        this.f17410a = mContext;
        this.f17414e = id;
        this.f17417h = duration;
        this.f17411b = bt_question;
        this.f17416g = popTime;
        if (popTime == 0) {
            this.f17413d = 0;
        } else {
            this.f17413d = duration / popTime;
        }
        this.f17415f = detailId;
        this.f17418i = hasQuestion;
        this.f17419j = valType;
        this.f17420k = integral;
        this.f17426q = new C4679v(mContext);
        C11792j.m20470c("需要弹框次数=" + this.f17413d);
        m41717B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m41711H(iOSTwoButtonDialog iOSTwoButtonDialog, EditText et_code, TextView tv_code) {
        if (!et_code.getText().toString().trim().equals(this.f17426q.m41642b().toString())) {
            Toast.makeText(this.f17410a, "验证码错误", 0).show();
            tv_code.setText(this.f17426q.m41643a());
            return;
        }
        m41673y(iOSTwoButtonDialog);
    }

    /* renamed from: B */
    private void m41717B() {
        List query = SQLiteDbUtil.m57474h().query(ReadExceptionDataDB.class, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), this.f17415f});
        if (query.size() > 0) {
            ReadExceptionDataDB readExceptionDataDB = (ReadExceptionDataDB) query.get(0);
            this.f17427r = readExceptionDataDB;
            long countTime = readExceptionDataDB.getCountTime();
            this.f17428s = countTime;
            int i = this.f17417h;
            if (countTime > i) {
                this.f17428s = i;
            }
            this.f17412c = this.f17427r.getAlertCount();
            this.f17421l = Long.valueOf(this.f17427r.getStartTime());
            return;
        }
        this.f17421l = Long.valueOf(System.currentTimeMillis());
        this.f17427r = new ReadExceptionDataDB();
        this.f17427r.setCreateTime(FormatUtils.m39629h(this.f17421l.longValue(), "yyyy-MM-dd HH:mm:ss"));
        this.f17427r.setUserId(LoginUser.getLoginUser().getUserId());
        this.f17427r.setDetailId(this.f17415f);
        this.f17427r.setStartTime(this.f17421l.longValue());
        SQLiteDbUtil.m57474h().insert((SQLiteDbUtil) this.f17427r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m41716C() {
        Http.with(this.f17410a).setLoadingMessage("获取积分中,请稍后...").hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setCanCancel(false).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41622t(this.f17415f, "4", 1)).setDataListener(new C4659d());
    }

    /* renamed from: F */
    private void m41713F() {
        if (this.f17417h - this.f17428s != 0) {
            return;
        }
        m41698U();
        m41716C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void m41712G(TextView textView, View view) {
        textView.setText(this.f17426q.m41643a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void m41710I(iOSTwoButtonDialog iostwobuttondialog) {
        iostwobuttondialog.dismiss();
        ((Activity) this.f17410a).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void m41709J(final iOSTwoButtonDialog iostwobuttondialog) {
        new iOSTwoButtonDialog(this.f17410a).setMessage("正在学习,如果离开将不积分,确定离开？").setLeftButtonText("继续学习").setRightButtonText("确定离开").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.h
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                C4655k.this.m41710I(iostwobuttondialog);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public static /* synthetic */ boolean m41708K(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ void m41707L(EditText editText, DialogInterface dialogInterface) {
        m41700S(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public /* synthetic */ void m41706M() {
        this.f17425p.dismiss();
        ((Activity) this.f17410a).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public /* synthetic */ void m41705N() {
        new iOSTwoButtonDialog(this.f17410a).setMessage("正在学习,如果离开将不积分,确定离开？").setLeftButtonText("继续学习").setRightButtonText("确定离开").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.g
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                C4655k.this.m41706M();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public /* synthetic */ Unit m41704O() {
        this.f17424o.startActivityForResult(new Intent(this.f17410a, FaceDetectLearnActivity.class), 170);
        ((FragmentActivity) this.f17410a).overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void m41703P() {
        PermissionExt.m43841c((FragmentActivity) this.f17410a, "人脸识别", new InterfaceC15269a() { // from class: com.bxkj.student.home.teaching.learning.detail.j
            @Override // p617l1.InterfaceC15269a
            public final Object invoke() {
                Unit m41704O;
                m41704O = C4655k.this.m41704O();
                return m41704O;
            }
        });
    }

    /* renamed from: k */
    private void m41687k() {
        final iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f17410a);
        Button button = (Button) iostwobuttondialog.findViewById(2131231032);
        iostwobuttondialog.setTitle("请输入验证码继续观看");
        iostwobuttondialog.setCenterCustomView(C4215R.C4221layout.dialog_confirm_code);
        iostwobuttondialog.setClickAutoCancel(false);
        iostwobuttondialog.setCanceledOnTouchOutside(false);
        button.setEnabled(false);
        final EditText editText = (EditText) iostwobuttondialog.findViewById(C4215R.C4219id.et_code);
        button.setTextColor(ContextCompat.getColor(this.f17410a, 2131034173));
        final TextView textView = (TextView) iostwobuttondialog.findViewById(C4215R.C4219id.tv_code);
        textView.setText(this.f17426q.m41643a());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C4655k.this.m41712G(textView, view);
            }
        });
        editText.addTextChangedListener(new C4658c(editText, button));
        iostwobuttondialog.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.i
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                C4655k.this.m41711H(iostwobuttondialog, editText, textView);
            }
        });
        iostwobuttondialog.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.e
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                C4655k.this.m41709J(iostwobuttondialog);
            }
        });
        iostwobuttondialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.student.home.teaching.learning.detail.a
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean m41708K;
                m41708K = C4655k.m41708K(dialogInterface, i, keyEvent);
                return m41708K;
            }
        });
        iostwobuttondialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bxkj.student.home.teaching.learning.detail.b
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                C4655k.this.m41707L(editText, dialogInterface);
            }
        });
        iostwobuttondialog.show();
    }

    /* renamed from: o */
    static /* synthetic */ long m41683o(C4655k c4655k) {
        long j = c4655k.f17428s;
        c4655k.f17428s = 1 + j;
        return j;
    }

    /* renamed from: x */
    private void m41674x() {
        iOSTwoButtonDialog message = new iOSTwoButtonDialog(this.f17410a).setMessage("学习已暂停，请先进行人脸识别");
        this.f17425p = message;
        message.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.d
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                C4655k.this.m41705N();
            }
        });
        this.f17425p.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.f
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                C4655k.this.m41703P();
            }
        });
        this.f17425p.setClickAutoCancel(false);
        this.f17425p.setCancelable(false);
        this.f17425p.setCanceledOnTouchOutside(false);
        this.f17425p.show();
    }

    /* renamed from: y */
    private void m41673y(iOSTwoButtonDialog iOSTwoButtonDialog) {
        this.f17412c++;
        if (iOSTwoButtonDialog != null) {
            iOSTwoButtonDialog.dismiss();
        }
        C11792j.m20470c("已点击弹框次数=" + this.f17412c);
        m41713F();
        m41701R(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m41672z() {
        int i;
        this.f17411b.setText(m41714E(this.f17417h - this.f17428s));
        long j = this.f17428s;
        if (j > 0 && (i = this.f17416g) > 0 && j % i == 0) {
            m41701R(true);
            if (this.f17419j == 2) {
                m41674x();
                return;
            } else {
                m41687k();
                return;
            }
        }
        m41713F();
    }

    /* renamed from: D */
    public void m41715D() {
        m41673y(this.f17425p);
    }

    /* renamed from: E */
    public String m41714E(long recordingTime) {
        String valueOf;
        String valueOf2;
        if (recordingTime < 0) {
            m41698U();
            recordingTime = 0;
        }
        long j = recordingTime / 60;
        if (j < 10) {
            valueOf = "0" + j;
        } else {
            valueOf = String.valueOf(j);
        }
        long j2 = recordingTime % 60;
        if (j2 < 10) {
            valueOf2 = "0" + j2;
        } else {
            valueOf2 = String.valueOf(j2);
        }
        return valueOf + ":" + valueOf2;
    }

    /* renamed from: Q */
    public void m41702Q() {
        ReadExceptionDataDB readExceptionDataDB = this.f17427r;
        if (readExceptionDataDB == null) {
            return;
        }
        readExceptionDataDB.setCountTime(this.f17428s);
        this.f17427r.setAlertCount(this.f17412c);
        SQLiteDbUtil.m57474h().update(this.f17427r, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), this.f17415f});
        C11792j.m20470c("readExceptionDataDB=" + this.f17427r.toString());
    }

    /* renamed from: R */
    public void m41701R(boolean pauseCountDown) {
        this.f17431v = pauseCountDown;
    }

    /* renamed from: S */
    public void m41700S(EditText editText) {
        if (editText != null) {
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
            ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
        }
    }

    /* renamed from: T */
    public void m41699T() {
        C11792j.m20470c("time=" + this.f17428s);
        m41672z();
        this.f17423n = new C4656a();
        Timer timer = new Timer();
        this.f17422m = timer;
        timer.schedule(this.f17423n, 0L, 1000L);
    }

    /* renamed from: U */
    public void m41698U() {
        TimerTask timerTask = this.f17423n;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.f17422m;
        if (timer != null) {
            timer.cancel();
        }
        Handler handler = this.f17430u;
        if (handler != null) {
            handler.removeCallbacks(this.f17423n);
        }
    }
}
