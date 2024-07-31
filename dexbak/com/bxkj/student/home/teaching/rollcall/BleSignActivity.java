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
import androidx.exifinterface.media.ExifInterface;
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
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.rollcall.BleSignActivity;
import com.clj.fastble.BleManager;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.data.BleScanState;
import com.clj.fastble.scan.BleScanRuleConfig;
import com.kuaishou.weapon.p205p0.C7282g;
import com.kuaishou.weapon.p205p0.C7304t;
import com.orhanobut.logger.C11792j;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p589f0.BleScanCallback;
import p615l.RequestPermission;
import p618m.StartActivityForResult;
import p653w.InterfaceC16236a;

/* compiled from: BleSignActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006,"}, m12616d2 = {"Lcom/bxkj/student/home/teaching/rollcall/BleSignActivity;", "Lcn/bluemobi/dylan/base/BaseActivity;", "Lkotlin/f1;", "u0", "v0", "w0", "y0", "", "t0", "U", "", "P", "Landroid/os/Bundle;", "savedInstanceState", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "N", "Landroid/view/View;", "v", "onClick", "onDestroy", "k", "Ljava/lang/String;", "uuid", C7304t.f25048d, "teachingClockingin", "m", "stuTeacherCurriculum", "n", "weekNum", "Lcom/bxkj/base/view/WaveView;", "o", "Lcom/bxkj/base/view/WaveView;", "waveView", "Lcn/bluemobi/dylan/http/dialog/LoadingDialog;", "p", "Lcn/bluemobi/dylan/http/dialog/LoadingDialog;", "s0", "()Lcn/bluemobi/dylan/http/dialog/LoadingDialog;", "x0", "(Lcn/bluemobi/dylan/http/dialog/LoadingDialog;)V", "loadingDialog", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class BleSignActivity extends BaseActivity {
    @Nullable

    /* renamed from: k */
    private String f17894k;
    @Nullable

    /* renamed from: l */
    private String f17895l;
    @Nullable

    /* renamed from: m */
    private String f17896m;
    @Nullable

    /* renamed from: n */
    private String f17897n;

    /* renamed from: o */
    private WaveView f17898o;
    @Nullable

    /* renamed from: p */
    private LoadingDialog f17899p;

    /* compiled from: BleSignActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\f"}, m12616d2 = {"com/bxkj/student/home/teaching/rollcall/BleSignActivity$a", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "", "status", "msg", "netOnOtherStatus", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.home.teaching.rollcall.BleSignActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C4828a extends HttpCallBack {
        C4828a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static final void m41241b(BleSignActivity this$0, View view) {
            C14342f0.m8184p(this$0, "this$0");
            this$0.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int i, @NotNull String msg) {
            C14342f0.m8184p(msg, "msg");
            super.netOnOtherStatus(i, msg);
            iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) BleSignActivity.this).f1669h).setMessage(msg);
            final BleSignActivity bleSignActivity = BleSignActivity.this;
            message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BleSignActivity.C4828a.m41241b(BleSignActivity.this, view);
                }
            }).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            C14342f0.m8184p(data, "data");
            BleSignActivity.this.f17894k = JsonParse.getString(data, "Identify");
            BleSignActivity.this.f17895l = JsonParse.getString(data, "teachingClockingin");
            BleSignActivity.this.f17896m = JsonParse.getString(data, "stuTeacherCurriculum");
            BleSignActivity.this.f17897n = JsonParse.getString(data, "weekNum");
            BleSignActivity.this.m41246v0();
        }
    }

    /* compiled from: BleSignActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/student/home/teaching/rollcall/BleSignActivity$b", "Ll/b$a;", "", "", "permission", "Lkotlin/f1;", "c", "([Ljava/lang/String;)V", "a", "b", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.home.teaching.rollcall.BleSignActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C4829b implements RequestPermission.InterfaceC15268a {
        C4829b() {
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: a */
        public void mo3478a(@NotNull String[] permission) {
            C14342f0.m8184p(permission, "permission");
            new iOSOneButtonDialog(((BaseActivity) BleSignActivity.this).f1669h).setMessage("您拒绝了蓝牙定位权限,无法进行蓝牙签到,请在(设置->应用—>体适能->权限管理->获取定位)设置允许定位后再进行蓝牙签到").show();
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: b */
        public void mo3477b() {
            if (Build.VERSION.SDK_INT >= 21) {
                BleManager.m36123v().m36178G(BleSignActivity.this.getApplication());
                BleManager.m36123v().m36136l(true).m36147f0(1, 5000L).m36151d0(5000);
                BleSignActivity.this.m41247u0();
                return;
            }
            new iOSOneButtonDialog(((BaseActivity) BleSignActivity.this).f1669h).setMessage("您的手机不支持蓝牙签到,请联系老师手动签到").show();
        }

        @Override // p615l.RequestPermission.InterfaceC15268a
        /* renamed from: c */
        public void mo3476c(@NotNull String[] permission) {
            C14342f0.m8184p(permission, "permission");
            new iOSOneButtonDialog(((BaseActivity) BleSignActivity.this).f1669h).setMessage("您拒绝了蓝牙和定位权限,无法进行蓝牙签到,请在(设置->应用—>体适能->权限管理->获取定位)设置允许定位后再进行蓝牙签到").show();
        }
    }

    /* compiled from: BleSignActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/home/teaching/rollcall/BleSignActivity$c", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.home.teaching.rollcall.BleSignActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C4830c implements StartActivityForResult.InterfaceC15293a {
        C4830c() {
        }

        @Override // p618m.StartActivityForResult.InterfaceC15293a
        /* renamed from: a */
        public void mo3459a(int i, @Nullable Intent intent) {
            if (i == -1) {
                BleSignActivity.this.m41245w0();
            }
        }
    }

    /* compiled from: BleSignActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0016¨\u0006\r"}, m12616d2 = {"com/bxkj/student/home/teaching/rollcall/BleSignActivity$d", "Lf0/i;", "", "success", "Lkotlin/f1;", "a", "Lcom/clj/fastble/data/BleDevice;", "bleDevice", "c", "b", "", "scanResultList", "d", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.home.teaching.rollcall.BleSignActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C4831d extends BleScanCallback {
        C4831d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g */
        public static final void m41238g(BleSignActivity this$0) {
            C14342f0.m8184p(this$0, "this$0");
            this$0.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: h */
        public static final void m41237h(BleSignActivity this$0) {
            C14342f0.m8184p(this$0, "this$0");
            this$0.m41247u0();
        }

        @Override // p589f0.BleScanPresenterImp
        /* renamed from: a */
        public void mo12756a(boolean z) {
            Dialog show;
            C11792j.m20469d("onScanStarted", new Object[0]);
            LoadingDialog m41249s0 = BleSignActivity.this.m41249s0();
            if (m41249s0 != null && (show = m41249s0.show("正在搜索蓝牙...")) != null) {
                show.show();
            }
            WaveView waveView = BleSignActivity.this.f17898o;
            if (waveView == null) {
                C14342f0.m8200S("waveView");
                waveView = null;
            }
            waveView.m43490k();
        }

        @Override // p589f0.BleScanPresenterImp
        /* renamed from: b */
        public void mo12755b(@NotNull BleDevice bleDevice) {
            C14342f0.m8184p(bleDevice, "bleDevice");
            C11792j.m20469d("onScanning:" + ((Object) bleDevice.m36016d()) + '-' + ((Object) bleDevice.m36017c()), new Object[0]);
            WaveView waveView = BleSignActivity.this.f17898o;
            if (waveView == null) {
                C14342f0.m8200S("waveView");
                waveView = null;
            }
            waveView.m43489l();
            LoadingDialog m41249s0 = BleSignActivity.this.m41249s0();
            if (m41249s0 != null) {
                m41249s0.dismiss();
            }
            BleManager.m36123v().m36158a();
            BleSignActivity.this.m41243y0();
        }

        @Override // p589f0.BleScanCallback
        /* renamed from: c */
        public void mo12758c(@NotNull BleDevice bleDevice) {
            C14342f0.m8184p(bleDevice, "bleDevice");
            C11792j.m20469d("onLeScan:" + ((Object) bleDevice.m36016d()) + '-' + ((Object) bleDevice.m36017c()), new Object[0]);
        }

        @Override // p589f0.BleScanCallback
        /* renamed from: d */
        public void mo12757d(@NotNull List<? extends BleDevice> scanResultList) {
            C14342f0.m8184p(scanResultList, "scanResultList");
            C11792j.m20469d(C14342f0.m8216C("onScanFinished:", scanResultList), new Object[0]);
            WaveView waveView = BleSignActivity.this.f17898o;
            WaveView waveView2 = null;
            if (waveView == null) {
                C14342f0.m8200S("waveView");
                waveView = null;
            }
            if (waveView.m43492i()) {
                C11792j.m20469d("搜索结束提示", new Object[0]);
                WaveView waveView3 = BleSignActivity.this.f17898o;
                if (waveView3 == null) {
                    C14342f0.m8200S("waveView");
                } else {
                    waveView2 = waveView3;
                }
                waveView2.m43489l();
                LoadingDialog m41249s0 = BleSignActivity.this.m41249s0();
                if (m41249s0 != null) {
                    m41249s0.dismiss();
                }
                if (scanResultList.isEmpty()) {
                    iOSTwoButtonDialog message = new iOSTwoButtonDialog(((BaseActivity) BleSignActivity.this).f1669h).setMessage("未搜索到蓝牙信息，签到失败，是否重试？");
                    final BleSignActivity bleSignActivity = BleSignActivity.this;
                    iOSTwoButtonDialog leftButtonOnClickListener = message.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.b
                        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
                        public final void buttonLeftOnClick() {
                            BleSignActivity.C4831d.m41238g(BleSignActivity.this);
                        }
                    });
                    final BleSignActivity bleSignActivity2 = BleSignActivity.this;
                    leftButtonOnClickListener.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.c
                        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                        public final void buttonRightOnClick() {
                            BleSignActivity.C4831d.m41237h(BleSignActivity.this);
                        }
                    }).show();
                }
            }
        }
    }

    /* compiled from: BleSignActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/student/home/teaching/rollcall/BleSignActivity$e", "Landroid/content/DialogInterface$OnKeyListener;", "Landroid/content/DialogInterface;", "dialog", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.home.teaching.rollcall.BleSignActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class DialogInterface$OnKeyListenerC4832e implements DialogInterface.OnKeyListener {
        DialogInterface$OnKeyListenerC4832e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public static final void m41235b(BleSignActivity this$0) {
            C14342f0.m8184p(this$0, "this$0");
            this$0.finish();
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(@Nullable DialogInterface dialogInterface, int i, @Nullable KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    iOSTwoButtonDialog rightButtonText = new iOSTwoButtonDialog(((BaseActivity) BleSignActivity.this).f1669h).setMessage("正在扫描教师蓝牙签到，是否退出？").setLeftButtonText("继续签到").setRightButtonText("取消签到");
                    final BleSignActivity bleSignActivity = BleSignActivity.this;
                    rightButtonText.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.d
                        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                        public final void buttonRightOnClick() {
                            BleSignActivity.DialogInterface$OnKeyListenerC4832e.m41235b(BleSignActivity.this);
                        }
                    }).show();
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: BleSignActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, m12616d2 = {"com/bxkj/student/home/teaching/rollcall/BleSignActivity$f", "Lcn/bluemobi/dylan/http/HttpCallBack;", "", "", "", "data", "Lkotlin/f1;", "netOnSuccess", "", "ex", "netOnFailure", "", "status", "msg", "netOnOtherStatus", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.home.teaching.rollcall.BleSignActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C4833f extends HttpCallBack {
        C4833f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public static final void m41231d(BleSignActivity this$0) {
            C14342f0.m8184p(this$0, "this$0");
            this$0.m41243y0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public static final void m41230e(BleSignActivity this$0) {
            C14342f0.m8184p(this$0, "this$0");
            this$0.m41243y0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public static final void m41229f(BleSignActivity this$0, View view) {
            C14342f0.m8184p(this$0, "this$0");
            this$0.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(@NotNull Throwable ex) {
            C14342f0.m8184p(ex, "ex");
            super.netOnFailure(ex);
            try {
                iOSTwoButtonDialog message = new iOSTwoButtonDialog(((BaseActivity) BleSignActivity.this).f1669h).setMessage("签到失败，是否重试？");
                final BleSignActivity bleSignActivity = BleSignActivity.this;
                message.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.f
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        BleSignActivity.C4833f.m41231d(BleSignActivity.this);
                    }
                }).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int i, @NotNull String msg) {
            C14342f0.m8184p(msg, "msg");
            try {
                iOSTwoButtonDialog message = new iOSTwoButtonDialog(((BaseActivity) BleSignActivity.this).f1669h).setMessage("签到失败，是否重试？");
                final BleSignActivity bleSignActivity = BleSignActivity.this;
                message.setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.rollcall.g
                    @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                    public final void buttonRightOnClick() {
                        BleSignActivity.C4833f.m41230e(BleSignActivity.this);
                    }
                }).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(@NotNull Map<String, ? extends Object> data) {
            C14342f0.m8184p(data, "data");
            try {
                iOSOneButtonDialog message = new iOSOneButtonDialog(((BaseActivity) BleSignActivity.this).f1669h).setMessage("签到成功");
                final BleSignActivity bleSignActivity = BleSignActivity.this;
                message.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BleSignActivity.C4833f.m41229f(BleSignActivity.this, view);
                    }
                }).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: t0 */
    private final String m41248t0() {
        return Settings.Secure.getString(this.f1669h.getContentResolver(), "bluetooth_address");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public final void m41247u0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m104i0(LoginUser.getLoginUser().getUserId())).setDataListener(new C4828a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public final void m41246v0() {
        if (BleManager.m36123v().m36173L()) {
            new StartActivityForResult(this).startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE")).m3460c(new C4830c());
        } else {
            new iOSOneButtonDialog(this.f1669h).setMessage("您的手机不支持蓝牙签到,请联系老师手动签到").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public final void m41245w0() {
        BleManager.m36123v().m36177H(new BleScanRuleConfig.C6532a().m35973g(new UUID[]{UUID.fromString(this.f17894k)}).m35974f(30000L).m35978b());
        this.f17899p = new LoadingDialog(this.f1669h);
        BleManager.m36123v().m36160Y(new C4831d());
        LoadingDialog loadingDialog = this.f17899p;
        if (loadingDialog == null) {
            return;
        }
        loadingDialog.setOnKeyListener(new DialogInterface$OnKeyListenerC4832e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public final void m41243y0() {
        Http.with(this.f1669h).setLoadingMessage("正在签到...").setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m187A1(this.f17895l, this.f17896m, this.f17897n, m41248t0(), LoginUser.getLoginUser().getSchoolId())).setDataListener(new C4833f());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_sign;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        FragmentActivity mActivity = this.f1670i;
        C14342f0.m8185o(mActivity, "mActivity");
        new RequestPermission(mActivity).m3480c("android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", C7282g.f24950h, C7282g.f24949g).m3479d(new C4829b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("上课签到");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(@Nullable Bundle bundle) {
        View findViewById = findViewById(C4215R.C4219id.waveView);
        C14342f0.m8185o(findViewById, "findViewById(R.id.waveView)");
        WaveView waveView = (WaveView) findViewById;
        this.f17898o = waveView;
        WaveView waveView2 = null;
        if (waveView == null) {
            C14342f0.m8200S("waveView");
            waveView = null;
        }
        waveView.setStyle(Paint.Style.FILL);
        WaveView waveView3 = this.f17898o;
        if (waveView3 == null) {
            C14342f0.m8200S("waveView");
        } else {
            waveView2 = waveView3;
        }
        waveView2.setColor(ContextCompat.getColor(this.f1669h, 2131034172));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        BleManager m36123v;
        super.onDestroy();
        LoadingDialog loadingDialog = this.f17899p;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
        WaveView waveView = this.f17898o;
        if (waveView == null) {
            C14342f0.m8200S("waveView");
            waveView = null;
        }
        waveView.m43489l();
        if (BleManager.m36123v().m36182C() != BleScanState.STATE_SCANNING || (m36123v = BleManager.m36123v()) == null) {
            return;
        }
        m36123v.m36158a();
    }

    @Nullable
    /* renamed from: s0 */
    public final LoadingDialog m41249s0() {
        return this.f17899p;
    }

    /* renamed from: x0 */
    public final void m41244x0(@Nullable LoadingDialog loadingDialog) {
        this.f17899p = loadingDialog;
    }
}
