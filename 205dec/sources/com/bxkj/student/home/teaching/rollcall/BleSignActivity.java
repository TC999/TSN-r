package com.bxkj.student.home.teaching.rollcall;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.http.dialog.LoadingDialog;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.WaveView;
import com.bxkj.student.home.teaching.rollcall.BleSignActivity;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import com.clj.fastble.scan.b;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import l.b;
import m.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BleSignActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/bxkj/student/home/teaching/rollcall/BleSignActivity;", "Lcn/bluemobi/dylan/base/BaseActivity;", "Lkotlin/f1;", "u0", "v0", "w0", "y0", "", "t0", "U", "", "P", "Landroid/os/Bundle;", "savedInstanceState", "V", "T", "N", "Landroid/view/View;", "v", "onClick", "onDestroy", "k", "Ljava/lang/String;", "uuid", "l", "teachingClockingin", "m", "stuTeacherCurriculum", "n", "weekNum", "Lcom/bxkj/base/view/WaveView;", "o", "Lcom/bxkj/base/view/WaveView;", "waveView", "Lcn/bluemobi/dylan/http/dialog/LoadingDialog;", "p", "Lcn/bluemobi/dylan/http/dialog/LoadingDialog;", "s0", "()Lcn/bluemobi/dylan/http/dialog/LoadingDialog;", "x0", "(Lcn/bluemobi/dylan/http/dialog/LoadingDialog;)V", "loadingDialog", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class BleSignActivity extends BaseActivity {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private String f21232k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private String f21233l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private String f21234m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private String f21235n;

    /* renamed from: o  reason: collision with root package name */
    private WaveView f21236o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private LoadingDialog f21237p;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BleSignActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016\u00a8\u0006\f"}, d2 = {"com/bxkj/student/home/teaching/rollcall/BleSignActivity$a", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "", "status", "msg", "netOnOtherStatus", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends HttpCallBack {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(BleSignActivity this$0, View view) {
            f0.p(this$0, "this$0");
            this$0.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int i4, @NotNull String msg) {
            f0.p(msg, "msg");
            super.netOnOtherStatus(i4, msg);
            iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) BleSignActivity.this).f1656h).setMessage(msg);
            final BleSignActivity bleSignActivity = BleSignActivity.this;
            message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BleSignActivity.a.b(BleSignActivity.this, view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            f0.p(data, "data");
            BleSignActivity.this.f21232k = JsonParse.getString(data, "Identify");
            BleSignActivity.this.f21233l = JsonParse.getString(data, "teachingClockingin");
            BleSignActivity.this.f21234m = JsonParse.getString(data, "stuTeacherCurriculum");
            BleSignActivity.this.f21235n = JsonParse.getString(data, "weekNum");
            BleSignActivity.this.v0();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BleSignActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\u0007J\b\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/student/home/teaching/rollcall/BleSignActivity$b", "Ll/b$a;", "", "", "permission", "Lkotlin/f1;", "c", "([Ljava/lang/String;)V", "a", "b", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b implements b.a {
        b() {
        }

        @Override // l.b.a
        public void a(@NotNull String[] permission) {
            f0.p(permission, "permission");
            new iOSOneButtonDialog(((BaseActivity) BleSignActivity.this).f1656h).setMessage("\u60a8\u62d2\u7edd\u4e86\u84dd\u7259\u5b9a\u4f4d\u6743\u9650,\u65e0\u6cd5\u8fdb\u884c\u84dd\u7259\u7b7e\u5230,\u8bf7\u5728(\u8bbe\u7f6e->\u5e94\u7528\u2014>\u4f53\u9002\u80fd->\u6743\u9650\u7ba1\u7406->\u83b7\u53d6\u5b9a\u4f4d)\u8bbe\u7f6e\u5141\u8bb8\u5b9a\u4f4d\u540e\u518d\u8fdb\u884c\u84dd\u7259\u7b7e\u5230").show();
        }

        @Override // l.b.a
        public void b() {
            if (Build.VERSION.SDK_INT >= 21) {
                com.clj.fastble.a.v().G(BleSignActivity.this.getApplication());
                com.clj.fastble.a.v().l(true).f0(1, 5000L).d0(5000);
                BleSignActivity.this.u0();
                return;
            }
            new iOSOneButtonDialog(((BaseActivity) BleSignActivity.this).f1656h).setMessage("\u60a8\u7684\u624b\u673a\u4e0d\u652f\u6301\u84dd\u7259\u7b7e\u5230,\u8bf7\u8054\u7cfb\u8001\u5e08\u624b\u52a8\u7b7e\u5230").show();
        }

        @Override // l.b.a
        public void c(@NotNull String[] permission) {
            f0.p(permission, "permission");
            new iOSOneButtonDialog(((BaseActivity) BleSignActivity.this).f1656h).setMessage("\u60a8\u62d2\u7edd\u4e86\u84dd\u7259\u548c\u5b9a\u4f4d\u6743\u9650,\u65e0\u6cd5\u8fdb\u884c\u84dd\u7259\u7b7e\u5230,\u8bf7\u5728(\u8bbe\u7f6e->\u5e94\u7528\u2014>\u4f53\u9002\u80fd->\u6743\u9650\u7ba1\u7406->\u83b7\u53d6\u5b9a\u4f4d)\u8bbe\u7f6e\u5141\u8bb8\u5b9a\u4f4d\u540e\u518d\u8fdb\u884c\u84dd\u7259\u7b7e\u5230").show();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BleSignActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/home/teaching/rollcall/BleSignActivity$c", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c implements b.a {
        c() {
        }

        @Override // m.b.a
        public void a(int i4, @Nullable Intent intent) {
            if (i4 == -1) {
                BleSignActivity.this.w0();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BleSignActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016\u00a8\u0006\r"}, d2 = {"com/bxkj/student/home/teaching/rollcall/BleSignActivity$d", "Lf0/i;", "", "success", "Lkotlin/f1;", "a", "Lcom/clj/fastble/data/BleDevice;", "bleDevice", "c", "b", "", "scanResultList", "d", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class d extends f0.i {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(BleSignActivity this$0) {
            f0.p(this$0, "this$0");
            this$0.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(BleSignActivity this$0) {
            f0.p(this$0, "this$0");
            this$0.u0();
        }

        @Override // f0.j
        public void a(boolean z3) {
            Dialog show;
            com.orhanobut.logger.j.d("onScanStarted", new Object[0]);
            LoadingDialog s02 = BleSignActivity.this.s0();
            if (s02 != null && (show = s02.show("\u6b63\u5728\u641c\u7d22\u84dd\u7259...")) != null) {
                show.show();
            }
            WaveView waveView = BleSignActivity.this.f21236o;
            if (waveView == null) {
                f0.S("waveView");
                waveView = null;
            }
            waveView.k();
        }

        @Override // f0.j
        public void b(@NotNull BleDevice bleDevice) {
            f0.p(bleDevice, "bleDevice");
            com.orhanobut.logger.j.d("onScanning:" + ((Object) bleDevice.d()) + '-' + ((Object) bleDevice.c()), new Object[0]);
            WaveView waveView = BleSignActivity.this.f21236o;
            if (waveView == null) {
                f0.S("waveView");
                waveView = null;
            }
            waveView.l();
            LoadingDialog s02 = BleSignActivity.this.s0();
            if (s02 != null) {
                s02.dismiss();
            }
            com.clj.fastble.a.v().a();
            BleSignActivity.this.y0();
        }

        @Override // f0.i
        public void c(@NotNull BleDevice bleDevice) {
            f0.p(bleDevice, "bleDevice");
            com.orhanobut.logger.j.d("onLeScan:" + ((Object) bleDevice.d()) + '-' + ((Object) bleDevice.c()), new Object[0]);
        }

        @Override // f0.i
        public void d(@NotNull List<? extends BleDevice> scanResultList) {
            f0.p(scanResultList, "scanResultList");
            com.orhanobut.logger.j.d(f0.C("onScanFinished:", scanResultList), new Object[0]);
            WaveView waveView = BleSignActivity.this.f21236o;
            WaveView waveView2 = null;
            if (waveView == null) {
                f0.S("waveView");
                waveView = null;
            }
            if (waveView.i()) {
                com.orhanobut.logger.j.d("\u641c\u7d22\u7ed3\u675f\u63d0\u793a", new Object[0]);
                WaveView waveView3 = BleSignActivity.this.f21236o;
                if (waveView3 == null) {
                    f0.S("waveView");
                } else {
                    waveView2 = waveView3;
                }
                waveView2.l();
                LoadingDialog s02 = BleSignActivity.this.s0();
                if (s02 != null) {
                    s02.dismiss();
                }
                if (scanResultList.isEmpty()) {
                    iOSTwoButtonDialog message = new iOSTwoButtonDialog(((BaseActivity) BleSignActivity.this).f1656h).setMessage("\u672a\u641c\u7d22\u5230\u84dd\u7259\u4fe1\u606f\uff0c\u7b7e\u5230\u5931\u8d25\uff0c\u662f\u5426\u91cd\u8bd5\uff1f");
                    final BleSignActivity bleSignActivity = BleSignActivity.this;
                    iOSTwoButtonDialog leftButtonOnClickListener = message.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.b
                        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                        public final void buttonLeftOnClick() {
                            BleSignActivity.d.g(BleSignActivity.this);
                        }
                    });
                    final BleSignActivity bleSignActivity2 = BleSignActivity.this;
                    leftButtonOnClickListener.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.c
                        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                        public final void buttonRightOnClick() {
                            BleSignActivity.d.h(BleSignActivity.this);
                        }
                    }).show();
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BleSignActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/student/home/teaching/rollcall/BleSignActivity$e", "Landroid/content/DialogInterface$OnKeyListener;", "Landroid/content/DialogInterface;", "dialog", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class e implements DialogInterface.OnKeyListener {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(BleSignActivity this$0) {
            f0.p(this$0, "this$0");
            this$0.finish();
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(@Nullable DialogInterface dialogInterface, int i4, @Nullable KeyEvent keyEvent) {
            if (i4 == 4) {
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    iOSTwoButtonDialog rightButtonText = new iOSTwoButtonDialog(((BaseActivity) BleSignActivity.this).f1656h).setMessage("\u6b63\u5728\u626b\u63cf\u6559\u5e08\u84dd\u7259\u7b7e\u5230\uff0c\u662f\u5426\u9000\u51fa\uff1f").setLeftButtonText("\u7ee7\u7eed\u7b7e\u5230").setRightButtonText("\u53d6\u6d88\u7b7e\u5230");
                    final BleSignActivity bleSignActivity = BleSignActivity.this;
                    rightButtonText.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.d
                        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                        public final void buttonRightOnClick() {
                            BleSignActivity.e.b(BleSignActivity.this);
                        }
                    }).show();
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BleSignActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016\u00a8\u0006\u000f"}, d2 = {"com/bxkj/student/home/teaching/rollcall/BleSignActivity$f", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "", "ex", "netOnFailure", "", "status", "msg", "netOnOtherStatus", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class f extends HttpCallBack {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(BleSignActivity this$0) {
            f0.p(this$0, "this$0");
            this$0.y0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(BleSignActivity this$0) {
            f0.p(this$0, "this$0");
            this$0.y0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(BleSignActivity this$0, View view) {
            f0.p(this$0, "this$0");
            this$0.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(@NotNull Throwable ex) {
            f0.p(ex, "ex");
            super.netOnFailure(ex);
            try {
                iOSTwoButtonDialog message = new iOSTwoButtonDialog(((BaseActivity) BleSignActivity.this).f1656h).setMessage("\u7b7e\u5230\u5931\u8d25\uff0c\u662f\u5426\u91cd\u8bd5\uff1f");
                final BleSignActivity bleSignActivity = BleSignActivity.this;
                message.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.f
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        BleSignActivity.f.d(BleSignActivity.this);
                    }
                }).show();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int i4, @NotNull String msg) {
            f0.p(msg, "msg");
            try {
                iOSTwoButtonDialog message = new iOSTwoButtonDialog(((BaseActivity) BleSignActivity.this).f1656h).setMessage("\u7b7e\u5230\u5931\u8d25\uff0c\u662f\u5426\u91cd\u8bd5\uff1f");
                final BleSignActivity bleSignActivity = BleSignActivity.this;
                message.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.g
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        BleSignActivity.f.e(BleSignActivity.this);
                    }
                }).show();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            f0.p(data, "data");
            try {
                iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) BleSignActivity.this).f1656h).setMessage("\u7b7e\u5230\u6210\u529f");
                final BleSignActivity bleSignActivity = BleSignActivity.this;
                message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BleSignActivity.f.f(BleSignActivity.this, view);
                    }
                }).show();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    private final String t0() {
        return Settings.Secure.getString(this.f1656h.getContentResolver(), "bluetooth_address");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).i0(LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0() {
        if (com.clj.fastble.a.v().L()) {
            new m.b(this).startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE")).c(new c());
        } else {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u60a8\u7684\u624b\u673a\u4e0d\u652f\u6301\u84dd\u7259\u7b7e\u5230,\u8bf7\u8054\u7cfb\u8001\u5e08\u624b\u52a8\u7b7e\u5230").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0() {
        com.clj.fastble.a.v().H(new b.a().g(new UUID[]{UUID.fromString(this.f21232k)}).f(PolicyConfig.mServerBusyRetryBaseInternal).b());
        this.f21237p = new LoadingDialog(this.f1656h);
        com.clj.fastble.a.v().Y(new d());
        LoadingDialog loadingDialog = this.f21237p;
        if (loadingDialog == null) {
            return;
        }
        loadingDialog.setOnKeyListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0() {
        Http.with(this.f1656h).setLoadingMessage("\u6b63\u5728\u7b7e\u5230...").setObservable(((w.a) Http.getApiService(w.a.class)).A1(this.f21233l, this.f21234m, this.f21235n, t0(), LoginUser.getLoginUser().getSchoolId())).setDataListener(new f());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427492;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        FragmentActivity mActivity = this.f1657i;
        f0.o(mActivity, "mActivity");
        new l.b(mActivity).c("android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION").d(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4e0a\u8bfe\u7b7e\u5230");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(@Nullable Bundle bundle) {
        View findViewById = findViewById(2131233314);
        f0.o(findViewById, "findViewById(R.id.waveView)");
        WaveView waveView = (WaveView) findViewById;
        this.f21236o = waveView;
        WaveView waveView2 = null;
        if (waveView == null) {
            f0.S("waveView");
            waveView = null;
        }
        waveView.setStyle(Paint.Style.FILL);
        WaveView waveView3 = this.f21236o;
        if (waveView3 == null) {
            f0.S("waveView");
        } else {
            waveView2 = waveView3;
        }
        waveView2.setColor(ContextCompat.getColor(this.f1656h, 2131034172));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com.clj.fastble.a v3;
        super.onDestroy();
        LoadingDialog loadingDialog = this.f21237p;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
        WaveView waveView = this.f21236o;
        if (waveView == null) {
            f0.S("waveView");
            waveView = null;
        }
        waveView.l();
        if (com.clj.fastble.a.v().C() != BleScanState.STATE_SCANNING || (v3 = com.clj.fastble.a.v()) == null) {
            return;
        }
        v3.a();
    }

    @Nullable
    public final LoadingDialog s0() {
        return this.f21237p;
    }

    public final void x0(@Nullable LoadingDialog loadingDialog) {
        this.f21237p = loadingDialog;
    }
}
