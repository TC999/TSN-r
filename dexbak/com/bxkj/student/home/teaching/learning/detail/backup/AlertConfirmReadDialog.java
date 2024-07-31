package com.bxkj.student.home.teaching.learning.detail.backup;

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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.sqlitelibrary.SQLiteDbUtil;
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.Code;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.learning.FaceDetectLearnActivity;
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.bxkj.student.home.teaching.learning.detail.backup.AlertConfirmReadDialog;
import com.bxkj.student.home.teaching.learning.detail.p090db.ReadExceptionDataDB;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.orhanobut.logger.C11792j;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import kotlin.Unit;
import p617l1.InterfaceC15269a;

/* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.j */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AlertConfirmReadDialog {

    /* renamed from: a */
    private Context f17360a;

    /* renamed from: b */
    private Button f17361b;

    /* renamed from: d */
    private int f17363d;

    /* renamed from: e */
    private String f17364e;

    /* renamed from: f */
    private String f17365f;

    /* renamed from: g */
    private int f17366g;

    /* renamed from: h */
    private long f17367h;

    /* renamed from: i */
    private int f17368i;

    /* renamed from: j */
    private int f17369j;

    /* renamed from: l */
    public Timer f17371l;

    /* renamed from: m */
    public TimerTask f17372m;

    /* renamed from: n */
    private Long f17373n;

    /* renamed from: o */
    private BottomFragment f17374o;

    /* renamed from: p */
    private iOSTwoButtonDialog f17375p;

    /* renamed from: q */
    private ReadExceptionDataDB f17376q;

    /* renamed from: c */
    private int f17362c = 0;

    /* renamed from: k */
    private long f17370k = 0;

    /* renamed from: r */
    private final int f17377r = 170;

    /* renamed from: s */
    public Handler f17378s = new HandlerC4635b();

    /* renamed from: t */
    private boolean f17379t = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlertConfirmReadDialog.java */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.j$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4634a extends TimerTask {
        C4634a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (AlertConfirmReadDialog.this.f17379t) {
                return;
            }
            AlertConfirmReadDialog.m41733n(AlertConfirmReadDialog.this);
            if (AlertConfirmReadDialog.this.f17370k % 10 == 0) {
                AlertConfirmReadDialog.this.m41749N();
            }
            AlertConfirmReadDialog.this.f17378s.sendEmptyMessage(170);
        }
    }

    /* compiled from: AlertConfirmReadDialog.java */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.j$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class HandlerC4635b extends Handler {
        HandlerC4635b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what != 170) {
                return;
            }
            long j = AlertConfirmReadDialog.this.f17367h - AlertConfirmReadDialog.this.f17370k;
            AlertConfirmReadDialog.this.f17361b.setText(AlertConfirmReadDialog.this.m41760C(j));
            if (AlertConfirmReadDialog.this.f17366g != 0 && AlertConfirmReadDialog.this.f17370k % AlertConfirmReadDialog.this.f17366g == 0) {
                if (AlertConfirmReadDialog.this.f17369j == 1) {
                    AlertConfirmReadDialog.this.m41737j();
                } else if (AlertConfirmReadDialog.this.f17369j == 2) {
                    AlertConfirmReadDialog.this.m41723x();
                }
            }
            if (j == 0) {
                AlertConfirmReadDialog.this.f17372m.cancel();
                AlertConfirmReadDialog.this.f17371l.cancel();
                AlertConfirmReadDialog alertConfirmReadDialog = AlertConfirmReadDialog.this;
                alertConfirmReadDialog.f17378s.removeCallbacks(alertConfirmReadDialog.f17372m);
                AlertConfirmReadDialog.this.m41759D();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlertConfirmReadDialog.java */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.j$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4636c implements TextWatcher {

        /* renamed from: a */
        final /* synthetic */ EditText f17382a;

        /* renamed from: b */
        final /* synthetic */ Button f17383b;

        C4636c(final EditText val$et_code, final Button val$btn_two) {
            this.f17382a = val$et_code;
            this.f17383b = val$btn_two;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Context context;
            int i;
            boolean z = this.f17382a.getText().toString().length() == 4;
            this.f17383b.setEnabled(z);
            Button button = this.f17383b;
            if (z) {
                context = AlertConfirmReadDialog.this.f17360a;
                i = C4215R.C4217color.ios_dialog_button_color;
            } else {
                context = AlertConfirmReadDialog.this.f17360a;
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
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.j$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4637d implements iOSTwoButtonDialog.RightButtonOnClick {
        C4637d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ Unit m41719b() {
            AlertConfirmReadDialog.this.f17374o.startActivityForResult(new Intent(AlertConfirmReadDialog.this.f17360a, FaceDetectLearnActivity.class), 170);
            ((FragmentActivity) AlertConfirmReadDialog.this.f17360a).overridePendingTransition(2130771987, 2130771986);
            return null;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            PermissionExt.m43841c((FragmentActivity) AlertConfirmReadDialog.this.f17360a, "人脸识别", new InterfaceC15269a() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.k
                @Override // p617l1.InterfaceC15269a
                public final Object invoke() {
                    Unit m41719b;
                    m41719b = AlertConfirmReadDialog.C4637d.this.m41719b();
                    return m41719b;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlertConfirmReadDialog.java */
    /* renamed from: com.bxkj.student.home.teaching.learning.detail.backup.j$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4638e extends HttpCallBack {
        C4638e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnHomeListActivity learnHomeListActivity = (LearnHomeListActivity) AppManager.m57776n().getActivity(LearnHomeListActivity.class);
            if (learnHomeListActivity != null) {
                learnHomeListActivity.m41949V0();
            }
        }
    }

    public AlertConfirmReadDialog(BottomFragment bottomFragment, Context mContext, int duration, int popTime, String id, String detailId, Button bt_question, int hasQuestion, int valType) {
        this.f17363d = 0;
        this.f17366g = 30;
        this.f17374o = bottomFragment;
        this.f17360a = mContext;
        this.f17364e = id;
        this.f17367h = duration;
        this.f17361b = bt_question;
        this.f17366g = popTime;
        if (popTime == 0) {
            this.f17363d = 0;
        } else {
            this.f17363d = duration / popTime;
        }
        this.f17365f = detailId;
        this.f17368i = hasQuestion;
        this.f17369j = valType;
        C11792j.m20470c("需要弹框次数=" + this.f17363d);
        m41762A();
    }

    /* renamed from: A */
    private void m41762A() {
        List query = SQLiteDbUtil.m57474h().query(ReadExceptionDataDB.class, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), this.f17365f});
        if (query.size() > 0) {
            ReadExceptionDataDB readExceptionDataDB = (ReadExceptionDataDB) query.get(0);
            this.f17376q = readExceptionDataDB;
            this.f17370k = readExceptionDataDB.getCountTime();
            this.f17362c = this.f17376q.getAlertCount();
            this.f17373n = Long.valueOf(this.f17376q.getStartTime());
            return;
        }
        this.f17373n = Long.valueOf(System.currentTimeMillis());
        this.f17376q = new ReadExceptionDataDB();
        this.f17376q.setCreateTime(FormatUtils.m39629h(this.f17373n.longValue(), "yyyy-MM-dd HH:mm:ss"));
        this.f17376q.setUserId(LoginUser.getLoginUser().getUserId());
        this.f17376q.setDetailId(this.f17365f);
        this.f17376q.setStartTime(this.f17373n.longValue());
        SQLiteDbUtil.m57474h().insert((SQLiteDbUtil) this.f17376q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m41759D() {
        if (this.f17367h - this.f17370k == 0 && this.f17362c == this.f17363d) {
            this.f17361b.setText(this.f17368i == 1 ? "开始答题" : "已完成");
            this.f17361b.setEnabled(this.f17368i == 1);
            Http.with(this.f17360a).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideOtherStatusMessage().setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41622t(this.f17365f, "4", 1)).setDataListener(new C4638e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public static /* synthetic */ void m41758E(ImageView imageView, View view) {
        imageView.setImageBitmap(Code.m44128e().m44132a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void m41756G() {
        ((Activity) this.f17360a).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public /* synthetic */ void m41755H() {
        new iOSTwoButtonDialog(this.f17360a).setMessage("确定要取消本次学习吗？").setLeftButtonText("继续").setRightButtonText("放弃").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.g
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                AlertConfirmReadDialog.this.m41756G();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public static /* synthetic */ boolean m41754I(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void m41753J(EditText editText, DialogInterface dialogInterface) {
        m41748O(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public /* synthetic */ void m41752K() {
        this.f17375p.dismiss();
        ((Activity) this.f17360a).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public /* synthetic */ void m41751L() {
        new iOSTwoButtonDialog(this.f17360a).setMessage("确定要取消本次学习吗？").setLeftButtonText("继续").setRightButtonText("放弃").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.f
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                AlertConfirmReadDialog.this.m41752K();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public /* synthetic */ void m41750M() {
        this.f17376q.setCountTime(this.f17370k);
        this.f17376q.setAlertCount(this.f17362c);
        int update = SQLiteDbUtil.m57474h().update(this.f17376q, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), this.f17365f});
        C11792j.m20470c("update=" + update);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public void m41749N() {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.i
            @Override // java.lang.Runnable
            public final void run() {
                AlertConfirmReadDialog.this.m41750M();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m41737j() {
        this.f17379t = true;
        final iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f17360a);
        Button button = (Button) iostwobuttondialog.findViewById(2131231032);
        iostwobuttondialog.setMessage("请输入验证码继续观看");
        iostwobuttondialog.setCenterCustomView(C4215R.C4221layout.dialog_confirm_code);
        iostwobuttondialog.setClickAutoCancel(false);
        iostwobuttondialog.setCanceledOnTouchOutside(false);
        button.setEnabled(false);
        final EditText editText = (EditText) iostwobuttondialog.findViewById(C4215R.C4219id.et_code);
        button.setTextColor(ContextCompat.getColor(this.f17360a, 2131034173));
        final ImageView imageView = (ImageView) iostwobuttondialog.findViewById(C4215R.C4219id.iv_code);
        imageView.setImageBitmap(Code.m44128e().m44132a());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertConfirmReadDialog.m41758E(imageView, view);
            }
        });
        editText.addTextChangedListener(new C4636c(editText, button));
        iostwobuttondialog.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.h
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                AlertConfirmReadDialog.this.m41757F(iostwobuttondialog, editText, imageView);
            }
        });
        iostwobuttondialog.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.e
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                AlertConfirmReadDialog.this.m41755H();
            }
        });
        iostwobuttondialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.a
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean m41754I;
                m41754I = AlertConfirmReadDialog.m41754I(dialogInterface, i, keyEvent);
                return m41754I;
            }
        });
        iostwobuttondialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.b
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                AlertConfirmReadDialog.this.m41753J(editText, dialogInterface);
            }
        });
        iostwobuttondialog.show();
    }

    /* renamed from: n */
    static /* synthetic */ long m41733n(AlertConfirmReadDialog alertConfirmReadDialog) {
        long j = alertConfirmReadDialog.f17370k;
        alertConfirmReadDialog.f17370k = 1 + j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m41723x() {
        this.f17379t = true;
        iOSTwoButtonDialog message = new iOSTwoButtonDialog(this.f17360a).setMessage("学习已暂停，请先进行人脸识别");
        this.f17375p = message;
        message.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.d
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                AlertConfirmReadDialog.this.m41751L();
            }
        });
        this.f17375p.setRightButtonOnClickListener(new C4637d());
        this.f17375p.setClickAutoCancel(false);
        this.f17375p.setCancelable(false);
        this.f17375p.setCanceledOnTouchOutside(false);
        this.f17375p.show();
    }

    /* renamed from: y */
    private void m41722y(iOSTwoButtonDialog iOSTwoButtonDialog) {
        this.f17362c++;
        if (iOSTwoButtonDialog != null) {
            iOSTwoButtonDialog.dismiss();
        }
        this.f17379t = false;
        C11792j.m20470c("已点击弹框次数=" + this.f17362c);
        m41759D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m41757F(iOSTwoButtonDialog iOSTwoButtonDialog, EditText et_code, ImageView iv_code) {
        if (!et_code.getText().toString().trim().equals(Code.m44128e().m44129d())) {
            Toast.makeText(this.f17360a, "验证码错误", 0).show();
            iv_code.setImageBitmap(Code.m44128e().m44132a());
            return;
        }
        m41722y(iOSTwoButtonDialog);
    }

    /* renamed from: B */
    public void m41761B() {
        m41722y(this.f17375p);
    }

    /* renamed from: C */
    public String m41760C(long recordingTime) {
        String valueOf;
        String valueOf2;
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

    /* renamed from: O */
    public void m41748O(EditText editText) {
        if (editText != null) {
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
            ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
        }
    }

    /* renamed from: P */
    public void m41747P() {
        this.f17372m = new C4634a();
        Timer timer = new Timer();
        this.f17371l = timer;
        timer.schedule(this.f17372m, 0L, 1000L);
    }
}
