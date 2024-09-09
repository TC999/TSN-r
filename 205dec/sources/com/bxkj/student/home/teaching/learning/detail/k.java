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
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.learning.FaceDetectLearnActivity;
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.detail.db.ReadExceptionDataDB;
import com.bxkj.student.home.teaching.learning.detail.k;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.f1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AlertConfirmReadDialog.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private Context f20753a;

    /* renamed from: b  reason: collision with root package name */
    private Button f20754b;

    /* renamed from: d  reason: collision with root package name */
    private int f20756d;

    /* renamed from: e  reason: collision with root package name */
    private String f20757e;

    /* renamed from: f  reason: collision with root package name */
    private String f20758f;

    /* renamed from: g  reason: collision with root package name */
    private int f20759g;

    /* renamed from: h  reason: collision with root package name */
    private int f20760h;

    /* renamed from: i  reason: collision with root package name */
    private int f20761i;

    /* renamed from: j  reason: collision with root package name */
    private int f20762j;

    /* renamed from: k  reason: collision with root package name */
    private int f20763k;

    /* renamed from: l  reason: collision with root package name */
    private Long f20764l;

    /* renamed from: m  reason: collision with root package name */
    public Timer f20765m;

    /* renamed from: n  reason: collision with root package name */
    public TimerTask f20766n;

    /* renamed from: o  reason: collision with root package name */
    private BottomFragment f20767o;

    /* renamed from: p  reason: collision with root package name */
    private iOSTwoButtonDialog f20768p;

    /* renamed from: q  reason: collision with root package name */
    private v f20769q;

    /* renamed from: r  reason: collision with root package name */
    private ReadExceptionDataDB f20770r;

    /* renamed from: c  reason: collision with root package name */
    private int f20755c = 0;

    /* renamed from: s  reason: collision with root package name */
    private long f20771s = 0;

    /* renamed from: t  reason: collision with root package name */
    private final int f20772t = 170;

    /* renamed from: u  reason: collision with root package name */
    public Handler f20773u = new b();

    /* renamed from: v  reason: collision with root package name */
    private boolean f20774v = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AlertConfirmReadDialog.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (k.this.f20774v) {
                return;
            }
            k.o(k.this);
            if (k.this.f20771s % 10 == 0) {
                k.this.Q();
            }
            k.this.f20773u.sendEmptyMessage(170);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AlertConfirmReadDialog.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what != 170) {
                return;
            }
            k.this.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AlertConfirmReadDialog.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f20777a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Button f20778b;

        c(final EditText val$et_code, final Button val$btn_two) {
            this.f20777a = val$et_code;
            this.f20778b = val$btn_two;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s3) {
            Context context;
            int i4;
            boolean z3 = this.f20777a.getText().toString().length() == 4;
            this.f20778b.setEnabled(z3);
            Button button = this.f20778b;
            if (z3) {
                context = k.this.f20753a;
                i4 = 2131034277;
            } else {
                context = k.this.f20753a;
                i4 = 2131034173;
            }
            button.setTextColor(ContextCompat.getColor(context, i4));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s3, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s3, int start, int before, int count) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AlertConfirmReadDialog.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            k.this.C();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            k.this.C();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if (ex instanceof SocketTimeoutException) {
                new iOSTwoButtonDialog(k.this.f20753a).setMessage("\u83b7\u53d6\u79ef\u5206\u8d85\u65f6,\u8bf7\u91cd\u8bd5").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.m
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        k.d.this.c();
                    }
                }).setRightButtonText("\u91cd\u8bd5").show();
            } else {
                new iOSTwoButtonDialog(k.this.f20753a).setMessage("\u83b7\u53d6\u79ef\u5206\u5931\u8d25,\u8bf7\u91cd\u8bd5").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.l
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        k.d.this.d();
                    }
                }).setRightButtonText("\u91cd\u8bd5").show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            k.this.f20754b.setText("");
            k.this.f20754b.setEnabled(false);
            ((LearnDetailActivity) k.this.f20767o.getActivity()).w0(false);
            new iOSOneButtonDialog(k.this.f20753a).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            k.this.f20754b.setText(k.this.f20761i == 1 ? "\u5f00\u59cb\u7b54\u9898" : "\u5df2\u5b8c\u6210");
            k.this.f20754b.setEnabled(k.this.f20761i == 1);
            ((LearnDetailActivity) k.this.f20767o.getActivity()).w0(false);
            LearnHomeListActivity learnHomeListActivity = (LearnHomeListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(LearnHomeListActivity.class);
            if (learnHomeListActivity != null) {
                learnHomeListActivity.V0();
            }
            Toast toast = new Toast(k.this.f20753a);
            View inflate = View.inflate(k.this.f20753a, 2131428063, null);
            ((LinearLayout) inflate.findViewById(2131232217)).setLayoutParams(new ViewGroup.LayoutParams(cn.bluemobi.dylan.base.utils.u.a(120.0f, k.this.f20753a), cn.bluemobi.dylan.base.utils.u.a(120.0f, k.this.f20753a)));
            ((TextView) inflate.findViewById(2131233032)).setText("+" + k.this.f20763k + "\u79ef\u5206");
            toast.setView(inflate);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.show();
            cn.bluemobi.dylan.sqlitelibrary.c.h().delete(ReadExceptionDataDB.class, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), k.this.f20758f});
            k.this.f20770r = null;
        }
    }

    public k(BottomFragment bottomFragment, Context mContext, int duration, int popTime, String id, String detailId, Button bt_question, int hasQuestion, int valType, int integral) {
        this.f20756d = 0;
        this.f20759g = 30;
        this.f20767o = bottomFragment;
        this.f20753a = mContext;
        this.f20757e = id;
        this.f20760h = duration;
        this.f20754b = bt_question;
        this.f20759g = popTime;
        if (popTime == 0) {
            this.f20756d = 0;
        } else {
            this.f20756d = duration / popTime;
        }
        this.f20758f = detailId;
        this.f20761i = hasQuestion;
        this.f20762j = valType;
        this.f20763k = integral;
        this.f20769q = new v(mContext);
        com.orhanobut.logger.j.c("\u9700\u8981\u5f39\u6846\u6b21\u6570=" + this.f20756d);
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void H(iOSTwoButtonDialog iOSTwoButtonDialog, EditText et_code, TextView tv_code) {
        if (!et_code.getText().toString().trim().equals(this.f20769q.b().toString())) {
            Toast.makeText(this.f20753a, "\u9a8c\u8bc1\u7801\u9519\u8bef", 0).show();
            tv_code.setText(this.f20769q.a());
            return;
        }
        y(iOSTwoButtonDialog);
    }

    private void B() {
        List query = cn.bluemobi.dylan.sqlitelibrary.c.h().query(ReadExceptionDataDB.class, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), this.f20758f});
        if (query.size() > 0) {
            ReadExceptionDataDB readExceptionDataDB = (ReadExceptionDataDB) query.get(0);
            this.f20770r = readExceptionDataDB;
            long countTime = readExceptionDataDB.getCountTime();
            this.f20771s = countTime;
            int i4 = this.f20760h;
            if (countTime > i4) {
                this.f20771s = i4;
            }
            this.f20755c = this.f20770r.getAlertCount();
            this.f20764l = Long.valueOf(this.f20770r.getStartTime());
            return;
        }
        this.f20764l = Long.valueOf(System.currentTimeMillis());
        this.f20770r = new ReadExceptionDataDB();
        this.f20770r.setCreateTime(com.bxkj.student.run.app.utils.i.h(this.f20764l.longValue(), "yyyy-MM-dd HH:mm:ss"));
        this.f20770r.setUserId(LoginUser.getLoginUser().getUserId());
        this.f20770r.setDetailId(this.f20758f);
        this.f20770r.setStartTime(this.f20764l.longValue());
        cn.bluemobi.dylan.sqlitelibrary.c.h().insert((cn.bluemobi.dylan.sqlitelibrary.c) this.f20770r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        Http.with(this.f20753a).setLoadingMessage("\u83b7\u53d6\u79ef\u5206\u4e2d,\u8bf7\u7a0d\u540e...").hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setCanCancel(false).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).t(this.f20758f, "4", 1)).setDataListener(new d());
    }

    private void F() {
        if (this.f20760h - this.f20771s != 0) {
            return;
        }
        U();
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(TextView textView, View view) {
        textView.setText(this.f20769q.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(iOSTwoButtonDialog iostwobuttondialog) {
        iostwobuttondialog.dismiss();
        ((Activity) this.f20753a).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(final iOSTwoButtonDialog iostwobuttondialog) {
        new iOSTwoButtonDialog(this.f20753a).setMessage("\u6b63\u5728\u5b66\u4e60,\u5982\u679c\u79bb\u5f00\u5c06\u4e0d\u79ef\u5206,\u786e\u5b9a\u79bb\u5f00\uff1f").setLeftButtonText("\u7ee7\u7eed\u5b66\u4e60").setRightButtonText("\u786e\u5b9a\u79bb\u5f00").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.h
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                k.this.I(iostwobuttondialog);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean K(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
        return i4 == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(EditText editText, DialogInterface dialogInterface) {
        S(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        this.f20768p.dismiss();
        ((Activity) this.f20753a).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        new iOSTwoButtonDialog(this.f20753a).setMessage("\u6b63\u5728\u5b66\u4e60,\u5982\u679c\u79bb\u5f00\u5c06\u4e0d\u79ef\u5206,\u786e\u5b9a\u79bb\u5f00\uff1f").setLeftButtonText("\u7ee7\u7eed\u5b66\u4e60").setRightButtonText("\u786e\u5b9a\u79bb\u5f00").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.g
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                k.this.M();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 O() {
        this.f20767o.startActivityForResult(new Intent(this.f20753a, FaceDetectLearnActivity.class), 170);
        ((FragmentActivity) this.f20753a).overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() {
        com.bxkj.base.v2.common.ext.g.c((FragmentActivity) this.f20753a, "\u4eba\u8138\u8bc6\u522b", new l1.a() { // from class: com.bxkj.student.home.teaching.learning.detail.j
            public final Object invoke() {
                f1 O;
                O = k.this.O();
                return O;
            }
        });
    }

    private void k() {
        final iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f20753a);
        Button button = (Button) iostwobuttondialog.findViewById(2131231032);
        iostwobuttondialog.setTitle("\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801\u7ee7\u7eed\u89c2\u770b");
        iostwobuttondialog.setCenterCustomView(2131427594);
        iostwobuttondialog.setClickAutoCancel(false);
        iostwobuttondialog.setCanceledOnTouchOutside(false);
        button.setEnabled(false);
        final EditText editText = (EditText) iostwobuttondialog.findViewById(2131231254);
        button.setTextColor(ContextCompat.getColor(this.f20753a, 2131034173));
        final TextView textView = (TextView) iostwobuttondialog.findViewById(2131232907);
        textView.setText(this.f20769q.a());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.this.G(textView, view);
            }
        });
        editText.addTextChangedListener(new c(editText, button));
        iostwobuttondialog.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.i
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                k.this.H(iostwobuttondialog, editText, textView);
            }
        });
        iostwobuttondialog.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.e
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                k.this.J(iostwobuttondialog);
            }
        });
        iostwobuttondialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.student.home.teaching.learning.detail.a
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                boolean K;
                K = k.K(dialogInterface, i4, keyEvent);
                return K;
            }
        });
        iostwobuttondialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bxkj.student.home.teaching.learning.detail.b
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                k.this.L(editText, dialogInterface);
            }
        });
        iostwobuttondialog.show();
    }

    static /* synthetic */ long o(k kVar) {
        long j4 = kVar.f20771s;
        kVar.f20771s = 1 + j4;
        return j4;
    }

    private void x() {
        iOSTwoButtonDialog message = new iOSTwoButtonDialog(this.f20753a).setMessage("\u5b66\u4e60\u5df2\u6682\u505c\uff0c\u8bf7\u5148\u8fdb\u884c\u4eba\u8138\u8bc6\u522b");
        this.f20768p = message;
        message.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.d
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                k.this.N();
            }
        });
        this.f20768p.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.f
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                k.this.P();
            }
        });
        this.f20768p.setClickAutoCancel(false);
        this.f20768p.setCancelable(false);
        this.f20768p.setCanceledOnTouchOutside(false);
        this.f20768p.show();
    }

    private void y(iOSTwoButtonDialog iOSTwoButtonDialog) {
        this.f20755c++;
        if (iOSTwoButtonDialog != null) {
            iOSTwoButtonDialog.dismiss();
        }
        com.orhanobut.logger.j.c("\u5df2\u70b9\u51fb\u5f39\u6846\u6b21\u6570=" + this.f20755c);
        F();
        R(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        int i4;
        this.f20754b.setText(E(this.f20760h - this.f20771s));
        long j4 = this.f20771s;
        if (j4 > 0 && (i4 = this.f20759g) > 0 && j4 % i4 == 0) {
            R(true);
            if (this.f20762j == 2) {
                x();
                return;
            } else {
                k();
                return;
            }
        }
        F();
    }

    public void D() {
        y(this.f20768p);
    }

    public String E(long recordingTime) {
        String valueOf;
        String valueOf2;
        if (recordingTime < 0) {
            U();
            recordingTime = 0;
        }
        long j4 = recordingTime / 60;
        if (j4 < 10) {
            valueOf = "0" + j4;
        } else {
            valueOf = String.valueOf(j4);
        }
        long j5 = recordingTime % 60;
        if (j5 < 10) {
            valueOf2 = "0" + j5;
        } else {
            valueOf2 = String.valueOf(j5);
        }
        return valueOf + ":" + valueOf2;
    }

    public void Q() {
        ReadExceptionDataDB readExceptionDataDB = this.f20770r;
        if (readExceptionDataDB == null) {
            return;
        }
        readExceptionDataDB.setCountTime(this.f20771s);
        this.f20770r.setAlertCount(this.f20755c);
        cn.bluemobi.dylan.sqlitelibrary.c.h().update(this.f20770r, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), this.f20758f});
        com.orhanobut.logger.j.c("readExceptionDataDB=" + this.f20770r.toString());
    }

    public void R(boolean pauseCountDown) {
        this.f20774v = pauseCountDown;
    }

    public void S(EditText editText) {
        if (editText != null) {
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
            ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
        }
    }

    public void T() {
        com.orhanobut.logger.j.c("time=" + this.f20771s);
        z();
        this.f20766n = new a();
        Timer timer = new Timer();
        this.f20765m = timer;
        timer.schedule(this.f20766n, 0L, 1000L);
    }

    public void U() {
        TimerTask timerTask = this.f20766n;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.f20765m;
        if (timer != null) {
            timer.cancel();
        }
        Handler handler = this.f20773u;
        if (handler != null) {
            handler.removeCallbacks(this.f20766n);
        }
    }
}
