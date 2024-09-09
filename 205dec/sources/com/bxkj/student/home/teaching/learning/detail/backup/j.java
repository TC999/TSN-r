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
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.learning.FaceDetectLearnActivity;
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.detail.backup.j;
import com.bxkj.student.home.teaching.learning.detail.db.ReadExceptionDataDB;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import kotlin.f1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AlertConfirmReadDialog.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private Context f20704a;

    /* renamed from: b  reason: collision with root package name */
    private Button f20705b;

    /* renamed from: d  reason: collision with root package name */
    private int f20707d;

    /* renamed from: e  reason: collision with root package name */
    private String f20708e;

    /* renamed from: f  reason: collision with root package name */
    private String f20709f;

    /* renamed from: g  reason: collision with root package name */
    private int f20710g;

    /* renamed from: h  reason: collision with root package name */
    private long f20711h;

    /* renamed from: i  reason: collision with root package name */
    private int f20712i;

    /* renamed from: j  reason: collision with root package name */
    private int f20713j;

    /* renamed from: l  reason: collision with root package name */
    public Timer f20715l;

    /* renamed from: m  reason: collision with root package name */
    public TimerTask f20716m;

    /* renamed from: n  reason: collision with root package name */
    private Long f20717n;

    /* renamed from: o  reason: collision with root package name */
    private BottomFragment f20718o;

    /* renamed from: p  reason: collision with root package name */
    private iOSTwoButtonDialog f20719p;

    /* renamed from: q  reason: collision with root package name */
    private ReadExceptionDataDB f20720q;

    /* renamed from: c  reason: collision with root package name */
    private int f20706c = 0;

    /* renamed from: k  reason: collision with root package name */
    private long f20714k = 0;

    /* renamed from: r  reason: collision with root package name */
    private final int f20721r = 170;

    /* renamed from: s  reason: collision with root package name */
    public Handler f20722s = new b();

    /* renamed from: t  reason: collision with root package name */
    private boolean f20723t = false;

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
            if (j.this.f20723t) {
                return;
            }
            j.n(j.this);
            if (j.this.f20714k % 10 == 0) {
                j.this.N();
            }
            j.this.f20722s.sendEmptyMessage(170);
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
            long j4 = j.this.f20711h - j.this.f20714k;
            j.this.f20705b.setText(j.this.C(j4));
            if (j.this.f20710g != 0 && j.this.f20714k % j.this.f20710g == 0) {
                if (j.this.f20713j == 1) {
                    j.this.j();
                } else if (j.this.f20713j == 2) {
                    j.this.x();
                }
            }
            if (j4 == 0) {
                j.this.f20716m.cancel();
                j.this.f20715l.cancel();
                j jVar = j.this;
                jVar.f20722s.removeCallbacks(jVar.f20716m);
                j.this.D();
            }
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
        final /* synthetic */ EditText f20726a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Button f20727b;

        c(final EditText val$et_code, final Button val$btn_two) {
            this.f20726a = val$et_code;
            this.f20727b = val$btn_two;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s3) {
            Context context;
            int i4;
            boolean z3 = this.f20726a.getText().toString().length() == 4;
            this.f20727b.setEnabled(z3);
            Button button = this.f20727b;
            if (z3) {
                context = j.this.f20704a;
                i4 = 2131034277;
            } else {
                context = j.this.f20704a;
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
    public class d implements iOSTwoButtonDialog.RightButtonOnClick {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ f1 b() {
            j.this.f20718o.startActivityForResult(new Intent(j.this.f20704a, FaceDetectLearnActivity.class), 170);
            ((FragmentActivity) j.this.f20704a).overridePendingTransition(2130771987, 2130771986);
            return null;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            com.bxkj.base.v2.common.ext.g.c((FragmentActivity) j.this.f20704a, "\u4eba\u8138\u8bc6\u522b", new l1.a() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.k
                public final Object invoke() {
                    f1 b4;
                    b4 = j.d.this.b();
                    return b4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AlertConfirmReadDialog.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LearnHomeListActivity learnHomeListActivity = (LearnHomeListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(LearnHomeListActivity.class);
            if (learnHomeListActivity != null) {
                learnHomeListActivity.V0();
            }
        }
    }

    public j(BottomFragment bottomFragment, Context mContext, int duration, int popTime, String id, String detailId, Button bt_question, int hasQuestion, int valType) {
        this.f20707d = 0;
        this.f20710g = 30;
        this.f20718o = bottomFragment;
        this.f20704a = mContext;
        this.f20708e = id;
        this.f20711h = duration;
        this.f20705b = bt_question;
        this.f20710g = popTime;
        if (popTime == 0) {
            this.f20707d = 0;
        } else {
            this.f20707d = duration / popTime;
        }
        this.f20709f = detailId;
        this.f20712i = hasQuestion;
        this.f20713j = valType;
        com.orhanobut.logger.j.c("\u9700\u8981\u5f39\u6846\u6b21\u6570=" + this.f20707d);
        A();
    }

    private void A() {
        List query = cn.bluemobi.dylan.sqlitelibrary.c.h().query(ReadExceptionDataDB.class, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), this.f20709f});
        if (query.size() > 0) {
            ReadExceptionDataDB readExceptionDataDB = (ReadExceptionDataDB) query.get(0);
            this.f20720q = readExceptionDataDB;
            this.f20714k = readExceptionDataDB.getCountTime();
            this.f20706c = this.f20720q.getAlertCount();
            this.f20717n = Long.valueOf(this.f20720q.getStartTime());
            return;
        }
        this.f20717n = Long.valueOf(System.currentTimeMillis());
        this.f20720q = new ReadExceptionDataDB();
        this.f20720q.setCreateTime(com.bxkj.student.run.app.utils.i.h(this.f20717n.longValue(), "yyyy-MM-dd HH:mm:ss"));
        this.f20720q.setUserId(LoginUser.getLoginUser().getUserId());
        this.f20720q.setDetailId(this.f20709f);
        this.f20720q.setStartTime(this.f20717n.longValue());
        cn.bluemobi.dylan.sqlitelibrary.c.h().insert((cn.bluemobi.dylan.sqlitelibrary.c) this.f20720q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (this.f20711h - this.f20714k == 0 && this.f20706c == this.f20707d) {
            this.f20705b.setText(this.f20712i == 1 ? "\u5f00\u59cb\u7b54\u9898" : "\u5df2\u5b8c\u6210");
            this.f20705b.setEnabled(this.f20712i == 1);
            Http.with(this.f20704a).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideOtherStatusMessage().setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).t(this.f20709f, "4", 1)).setDataListener(new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(ImageView imageView, View view) {
        imageView.setImageBitmap(com.bxkj.base.util.d.e().a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        ((Activity) this.f20704a).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        new iOSTwoButtonDialog(this.f20704a).setMessage("\u786e\u5b9a\u8981\u53d6\u6d88\u672c\u6b21\u5b66\u4e60\u5417\uff1f").setLeftButtonText("\u7ee7\u7eed").setRightButtonText("\u653e\u5f03").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.g
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                j.this.G();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean I(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
        return i4 == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(EditText editText, DialogInterface dialogInterface) {
        O(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        this.f20719p.dismiss();
        ((Activity) this.f20704a).finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        new iOSTwoButtonDialog(this.f20704a).setMessage("\u786e\u5b9a\u8981\u53d6\u6d88\u672c\u6b21\u5b66\u4e60\u5417\uff1f").setLeftButtonText("\u7ee7\u7eed").setRightButtonText("\u653e\u5f03").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.f
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                j.this.K();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        this.f20720q.setCountTime(this.f20714k);
        this.f20720q.setAlertCount(this.f20706c);
        int update = cn.bluemobi.dylan.sqlitelibrary.c.h().update(this.f20720q, "userId=? and detailId=?", new String[]{LoginUser.getLoginUser().getUserId(), this.f20709f});
        com.orhanobut.logger.j.c("update=" + update);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.i
            @Override // java.lang.Runnable
            public final void run() {
                j.this.M();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f20723t = true;
        final iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.f20704a);
        Button button = (Button) iostwobuttondialog.findViewById(2131231032);
        iostwobuttondialog.setMessage("\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801\u7ee7\u7eed\u89c2\u770b");
        iostwobuttondialog.setCenterCustomView(2131427594);
        iostwobuttondialog.setClickAutoCancel(false);
        iostwobuttondialog.setCanceledOnTouchOutside(false);
        button.setEnabled(false);
        final EditText editText = (EditText) iostwobuttondialog.findViewById(2131231254);
        button.setTextColor(ContextCompat.getColor(this.f20704a, 2131034173));
        final ImageView imageView = (ImageView) iostwobuttondialog.findViewById(2131231400);
        imageView.setImageBitmap(com.bxkj.base.util.d.e().a());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.E(imageView, view);
            }
        });
        editText.addTextChangedListener(new c(editText, button));
        iostwobuttondialog.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.h
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                j.this.F(iostwobuttondialog, editText, imageView);
            }
        });
        iostwobuttondialog.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.e
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                j.this.H();
            }
        });
        iostwobuttondialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.a
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                boolean I;
                I = j.I(dialogInterface, i4, keyEvent);
                return I;
            }
        });
        iostwobuttondialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.b
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                j.this.J(editText, dialogInterface);
            }
        });
        iostwobuttondialog.show();
    }

    static /* synthetic */ long n(j jVar) {
        long j4 = jVar.f20714k;
        jVar.f20714k = 1 + j4;
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.f20723t = true;
        iOSTwoButtonDialog message = new iOSTwoButtonDialog(this.f20704a).setMessage("\u5b66\u4e60\u5df2\u6682\u505c\uff0c\u8bf7\u5148\u8fdb\u884c\u4eba\u8138\u8bc6\u522b");
        this.f20719p = message;
        message.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.learning.detail.backup.d
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                j.this.L();
            }
        });
        this.f20719p.setRightButtonOnClickListener(new d());
        this.f20719p.setClickAutoCancel(false);
        this.f20719p.setCancelable(false);
        this.f20719p.setCanceledOnTouchOutside(false);
        this.f20719p.show();
    }

    private void y(iOSTwoButtonDialog iOSTwoButtonDialog) {
        this.f20706c++;
        if (iOSTwoButtonDialog != null) {
            iOSTwoButtonDialog.dismiss();
        }
        this.f20723t = false;
        com.orhanobut.logger.j.c("\u5df2\u70b9\u51fb\u5f39\u6846\u6b21\u6570=" + this.f20706c);
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void F(iOSTwoButtonDialog iOSTwoButtonDialog, EditText et_code, ImageView iv_code) {
        if (!et_code.getText().toString().trim().equals(com.bxkj.base.util.d.e().d())) {
            Toast.makeText(this.f20704a, "\u9a8c\u8bc1\u7801\u9519\u8bef", 0).show();
            iv_code.setImageBitmap(com.bxkj.base.util.d.e().a());
            return;
        }
        y(iOSTwoButtonDialog);
    }

    public void B() {
        y(this.f20719p);
    }

    public String C(long recordingTime) {
        String valueOf;
        String valueOf2;
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

    public void O(EditText editText) {
        if (editText != null) {
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
            ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
        }
    }

    public void P() {
        this.f20716m = new a();
        Timer timer = new Timer();
        this.f20715l = timer;
        timer.schedule(this.f20716m, 0L, 1000L);
    }
}
