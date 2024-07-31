package com.bxkj.student.p094v2.p098ui.sports.p102v3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.base.p085v2.base.BaseDialog;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.base.p085v2.common.utils.DataFormatUtils;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.base.p085v2.common.utils.SpannableStringUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.databinding.AcV3SportsFinishBinding;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.p094v2.p098ui.face.FaceDetectV3Activity;
import com.bxkj.student.p094v2.p098ui.face.FaceLiveV3Activity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.V3RecordDetailActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.V3LocationService;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.service.step.V3StepService;
import com.bxkj.student.p094v2.p103vm.sports.SportsVM;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p581d0.VoiceUtils;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p618m.StartActivityForResult;

/* compiled from: V3SportsFinishDialog.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b&\u0010'J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u001e\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\u0016\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014J\u0016\u0010\u0018\u001a\u00020\u00042\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010!\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006("}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/V3SportsFinishDialog;", "Lcom/bxkj/base/v2/base/BaseDialog;", "Lcom/bxkj/student/databinding/AcV3SportsFinishBinding;", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "Lkotlin/f1;", "P", "d0", "", "isValid", "isException", "Z", "O", "R", "msg", "id", ExifInterface.GPS_DIRECTION_TRUE, "Q", "", ExifInterface.LONGITUDE_WEST, "X", "Lkotlin/Function0;", "finishCommit", "b0", "continueCommit", "a0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", ExifInterface.LONGITUDE_EAST, "p", "onStart", "N", "c0", ExifInterface.LATITUDE_SOUTH, "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "k", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "bottomSheetDialog", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsFinishDialog */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3SportsFinishDialog extends BaseDialog<AcV3SportsFinishBinding, SportsVM> {
    @Nullable

    /* renamed from: i */
    private InterfaceC15269a<Unit> f20564i;
    @Nullable

    /* renamed from: j */
    private InterfaceC15269a<Unit> f20565j;
    @Nullable

    /* renamed from: k */
    private BottomSheetDialog f20566k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsFinishDialog.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsFinishDialog$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5711a extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: b */
        final /* synthetic */ String f20568b;

        /* renamed from: c */
        final /* synthetic */ String f20569c;

        /* compiled from: V3SportsFinishDialog.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsFinishDialog$a$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsFinishDialog$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5712a implements StartActivityForResult.InterfaceC15293a {

            /* renamed from: a */
            final /* synthetic */ V3SportsFinishDialog f20570a;

            /* renamed from: b */
            final /* synthetic */ String f20571b;

            /* renamed from: c */
            final /* synthetic */ String f20572c;

            C5712a(V3SportsFinishDialog v3SportsFinishDialog, String str, String str2) {
                this.f20570a = v3SportsFinishDialog;
                this.f20571b = str;
                this.f20572c = str2;
            }

            @Override // p618m.StartActivityForResult.InterfaceC15293a
            /* renamed from: a */
            public void mo3459a(int i, @Nullable Intent intent) {
                if (i == -1) {
                    this.f20570a.m38570S(this.f20571b, this.f20572c);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5711a(String str, String str2) {
            super(0);
            this.f20568b = str;
            this.f20569c = str2;
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            JsonGet jsonGet = JsonGet.f15134a;
            Class cls = jsonGet.m43769k(V3SportsFinishDialog.this.mo43911x().m38035B(), "livingFace") == 1 ? FaceLiveV3Activity.class : FaceDetectV3Activity.class;
            StartActivityForResult startActivityForResult = new StartActivityForResult(V3SportsFinishDialog.this.mo43912w());
            Intent putExtra = new Intent(V3SportsFinishDialog.this.mo43926C(), cls).putExtra("identify", jsonGet.m43760t(V3SportsFinishDialog.this.mo43911x().m38035B(), "identify")).putExtra("type", "3").putExtra("runType", jsonGet.m43768l(V3SportsFinishDialog.this.mo43911x().m38035B(), "runType", 1));
            C14342f0.m8185o(putExtra, "Intent(mContext, toActiv…e\", SportsType.SUNSHINE))");
            startActivityForResult.startActivityForResult(putExtra).m3460c(new C5712a(V3SportsFinishDialog.this, this.f20568b, this.f20569c));
            FragmentActivity activity = V3SportsFinishDialog.this.getActivity();
            if (activity == null) {
                return;
            }
            activity.overridePendingTransition(2130771987, 2130771986);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsFinishDialog.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsFinishDialog$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5713b extends Lambda implements InterfaceC15280l<iOSOneButtonDialog, Unit> {
        C5713b() {
            super(1);
        }

        /* renamed from: a */
        public final void m38551a(@NotNull iOSOneButtonDialog it) {
            C14342f0.m8184p(it, "it");
            V3SportsFinishDialog.this.startActivity(new Intent(V3SportsFinishDialog.this.mo43926C(), V3RecordDetailActivity.class).putExtra("identify", JsonGet.f15134a.m43760t(V3SportsFinishDialog.this.mo43911x().m38035B(), "identify")));
            V3SportsFinishDialog.this.m38572Q();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSOneButtonDialog iosonebuttondialog) {
            m38551a(iosonebuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsFinishDialog.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsFinishDialog$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public /* synthetic */ class C5714c extends FunctionReferenceImpl implements InterfaceC15284p<String, String, Unit> {
        C5714c(Object obj) {
            super(2, obj, V3SportsFinishDialog.class, "commitSuccess", "commitSuccess(Ljava/lang/String;Ljava/lang/String;)V", 0);
        }

        /* renamed from: e */
        public final void m38550e(@Nullable String str, @Nullable String str2) {
            ((V3SportsFinishDialog) this.receiver).m38569T(str, str2);
        }

        @Override // p617l1.InterfaceC15284p
        public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
            m38550e(str, str2);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsFinishDialog.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsFinishDialog$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public /* synthetic */ class C5715d extends FunctionReferenceImpl implements InterfaceC15269a<Unit> {
        C5715d(Object obj) {
            super(0, obj, V3SportsFinishDialog.class, "commitFail", "commitFail()V", 0);
        }

        /* renamed from: e */
        public final void m38549e() {
            ((V3SportsFinishDialog) this.receiver).m38571R();
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            m38549e();
            return Unit.f41048a;
        }
    }

    /* compiled from: V3SportsFinishDialog.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsFinishDialog$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5716e extends Lambda implements InterfaceC15269a<Unit> {
        C5716e() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            V3SportsFinishDialog.this.m38572Q();
            V3SportsFinishDialog.this.startActivity(new Intent(V3SportsFinishDialog.this.mo43926C(), V3RecordDetailActivity.class).putExtra("identify", JsonGet.f15134a.m43760t(V3SportsFinishDialog.this.mo43911x().m38035B(), "identify")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3SportsFinishDialog.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsFinishDialog$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5717f extends Lambda implements InterfaceC15269a<Unit> {
        C5717f() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            V3SportsFinishDialog.this.m38572Q();
        }
    }

    /* renamed from: O */
    private final void m38574O(String str, String str2) {
        if (JsonGet.f15134a.m43769k(mo43911x().m38035B(), "isEndFace") == 1) {
            PermissionExt.m43841c(mo43912w(), "人脸识别", new C5711a(str, str2));
        } else {
            m38570S(str, str2);
        }
    }

    /* renamed from: P */
    private final void m38573P() {
        List<Map<String, Object>> m43766n = JsonGet.f15134a.m43766n(mo43911x().m38035B(), "list");
        List<Map<String, Object>> m39253s = SportsDataAgent.f19899a.m39253s();
        MaterialCardView materialCardView = mo43920M().cardPassPoint;
        C14342f0.m8185o(materialCardView, "mDataBinding.cardPassPoint");
        materialCardView.setVisibility(m43766n.isEmpty() ^ true ? 0 : 8);
        MaterialCardView materialCardView2 = mo43920M().cardNoPass;
        C14342f0.m8185o(materialCardView2, "mDataBinding.cardNoPass");
        materialCardView2.setVisibility(m39253s.size() < m43766n.size() ? 0 : 8);
        TextView textView = mo43920M().tvPassPointTarget;
        textView.setText("本次需要经过必经点:" + m43766n.size() + (char) 20010);
        TextView textView2 = mo43920M().tvPassPoint;
        textView2.setText("本次实际经过必经点: " + m39253s.size() + (char) 20010);
        TextView textView3 = mo43920M().tvNoPassPoint;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringUtils spannableStringUtils = SpannableStringUtils.f15142a;
        textView3.setText(spannableStringBuilder.append((CharSequence) spannableStringUtils.m43737a("未达标", ContextCompat.getColor(mo43926C(), 2131034176))).append((CharSequence) ShellAdbUtils.f33810d).append((CharSequence) spannableStringUtils.m43737a("未经过点详情", ContextCompat.getColor(mo43926C(), C4215R.C4217color.v3_button_color))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public final void m38572Q() {
        V3SportsHomeActivity v3SportsHomeActivity = (V3SportsHomeActivity) AppManager.m57776n().getActivity(V3SportsHomeActivity.class);
        if (v3SportsHomeActivity != null) {
            v3SportsHomeActivity.m38498t0();
        }
        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
        c5481g.m39250v().clear();
        InterfaceC15269a<Unit> interfaceC15269a = this.f20564i;
        if (interfaceC15269a != null) {
            interfaceC15269a.invoke();
        }
        BottomSheetDialog bottomSheetDialog = this.f20566k;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
        dismissAllowingStateLoss();
        V3SportsMapActivity v3SportsMapActivity = (V3SportsMapActivity) AppManager.m57776n().getActivity(V3SportsMapActivity.class);
        if (v3SportsMapActivity != null) {
            v3SportsMapActivity.finish();
        }
        V3SportsActivity v3SportsActivity = (V3SportsActivity) AppManager.m57776n().getActivity(V3SportsActivity.class);
        if (v3SportsActivity != null) {
            v3SportsActivity.finish();
        }
        c5481g.m39277b0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public final void m38571R() {
        iOSOneButtonDialog m43850n = ContextExt.m43850n(mo43926C(), "提交异常,已为您暂存本地,请稍后在本地锻炼记录中重新上传！", new C5713b());
        m43850n.setCancelable(false);
        m43850n.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public final void m38569T(String str, String str2) {
        if (str == null) {
            str = "上传成功";
        }
        ContextExt.m43847q(mo43926C(), str);
        m38572Q();
        if (str2 == null) {
            return;
        }
        startActivity(new Intent(mo43926C(), V3RecordDetailActivity.class).putExtra("exerciseRecordId", str2));
    }

    /* renamed from: U */
    static /* synthetic */ void m38568U(V3SportsFinishDialog v3SportsFinishDialog, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "上传成功";
        }
        v3SportsFinishDialog.m38569T(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public static final void m38567V(V3SportsFinishDialog this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.m38559d0();
    }

    /* renamed from: W */
    private final boolean m38566W() {
        JsonGet jsonGet = JsonGet.f15134a;
        if (jsonGet.m43768l(mo43911x().m38035B(), "runType", 1) == 0) {
            return true;
        }
        double m43774f = jsonGet.m43774f(mo43911x().m38035B(), "minSaveRange");
        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
        if (c5481g.m39274d() >= jsonGet.m43769k(mo43911x().m38035B(), "startQualifiedTime") * 60) {
            double m39270f = c5481g.m39270f();
            double d = 1000;
            Double.isNaN(d);
            if (m39270f >= m43774f * d) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: X */
    private final boolean m38565X() {
        boolean z;
        TextView textView = mo43920M().tvDistance;
        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
        textView.setText(C14342f0.m8216C(FormatUtils.m39634c(c5481g.m39270f()), "公里"));
        double m39270f = c5481g.m39270f();
        JsonGet jsonGet = JsonGet.f15134a;
        double m43774f = jsonGet.m43774f(mo43911x().m38035B(), "totalRange");
        double d = 1000;
        Double.isNaN(d);
        if (m39270f < m43774f * d) {
            mo43920M().tvDistance.setTextColor(ContextCompat.getColor(mo43926C(), 2131034176));
            mo43920M().tvDistanceStatus.setText("未达标");
            mo43920M().tvDistanceStatus.setTextColor(ContextCompat.getColor(mo43926C(), 2131034176));
            z = false;
        } else {
            mo43920M().tvDistance.setTextColor(ContextCompat.getColor(mo43926C(), 2131034190));
            mo43920M().tvDistanceStatus.setText("已达标");
            mo43920M().tvDistanceStatus.setTextColor(ContextCompat.getColor(mo43926C(), C4215R.C4217color.v3_tab_color2));
            z = true;
        }
        mo43920M().tvTime.setText(DataFormatUtils.m43807b(c5481g.m39274d()));
        int m43769k = jsonGet.m43769k(mo43911x().m38035B(), "startQualifiedTime");
        int m39280a = c5481g.m39280a();
        if (c5481g.m39274d() >= m43769k * 60 && (m39280a == -1 || c5481g.m39274d() <= m39280a * 60)) {
            mo43920M().tvTime.setTextColor(ContextCompat.getColor(mo43926C(), 2131034190));
            mo43920M().tvTimeStatus.setText("已达标");
            mo43920M().tvTimeStatus.setTextColor(ContextCompat.getColor(mo43926C(), C4215R.C4217color.v3_tab_color2));
        } else {
            mo43920M().tvTime.setTextColor(ContextCompat.getColor(mo43926C(), 2131034176));
            mo43920M().tvTimeStatus.setText("未达标");
            mo43920M().tvTimeStatus.setTextColor(ContextCompat.getColor(mo43926C(), 2131034176));
            z = false;
        }
        TextView textView2 = mo43920M().tvStep;
        StringBuilder sb = new StringBuilder();
        sb.append(c5481g.m39247y());
        sb.append((char) 27493);
        textView2.setText(sb.toString());
        if (c5481g.m39247y() < jsonGet.m43774f(mo43911x().m38035B(), "step")) {
            mo43920M().tvStep.setTextColor(ContextCompat.getColor(mo43926C(), 2131034176));
            mo43920M().tvStepStatus.setText("未达标");
            mo43920M().tvStepStatus.setTextColor(ContextCompat.getColor(mo43926C(), 2131034176));
            z = false;
        } else {
            mo43920M().tvStep.setTextColor(ContextCompat.getColor(mo43926C(), 2131034190));
            mo43920M().tvStepStatus.setText("已达标");
            mo43920M().tvStepStatus.setTextColor(ContextCompat.getColor(mo43926C(), C4215R.C4217color.v3_tab_color2));
        }
        if (c5481g.m39253s().size() < jsonGet.m43766n(mo43911x().m38035B(), "list").size()) {
            return false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y */
    public static final boolean m38564Y(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4) {
            SportsDataAgent.f19899a.m39289R(false);
        }
        return false;
    }

    /* renamed from: Z */
    private final void m38563Z(String str, String str2) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.stopService(new Intent(mo43926C(), V3LocationService.class));
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.stopService(new Intent(mo43926C(), V3StepService.class));
        }
        VoiceUtils.f40105a.m12842b(mo43926C(), C4215R.raw.stop_run);
        mo43911x().m38031F(str, str2, new C5716e());
    }

    /* renamed from: d0 */
    private final void m38559d0() {
        if (!m38566W()) {
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(mo43926C(), 2131886879);
            bottomSheetDialog.setContentView(C4215R.C4221layout.dialog_bottom_sheet_dialog);
            TextView textView = (TextView) bottomSheetDialog.findViewById(C4215R.C4219id.tv_continue);
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        V3SportsFinishDialog.m38558e0(BottomSheetDialog.this, view);
                    }
                });
            }
            TextView textView2 = (TextView) bottomSheetDialog.findViewById(C4215R.C4219id.tv_stop);
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        V3SportsFinishDialog.m38557f0(V3SportsFinishDialog.this, view);
                    }
                });
            }
            bottomSheetDialog.show();
            Unit unit = Unit.f41048a;
            this.f20566k = bottomSheetDialog;
            return;
        }
        m38574O(m38565X() ? "1" : "0", "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public static final void m38558e0(BottomSheetDialog this_apply, View view) {
        C14342f0.m8184p(this_apply, "$this_apply");
        this_apply.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0 */
    public static final void m38557f0(V3SportsFinishDialog this$0, View view) {
        C14342f0.m8184p(this$0, "this$0");
        this$0.mo43911x().m38025x(new C5717f());
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        SportsDataAgent.C5481g c5481g = SportsDataAgent.f19899a;
        mo43911x().m38030G(c5481g.m39250v());
        mo43920M().setDialog(this);
        JsonGet jsonGet = JsonGet.f15134a;
        mo43920M().setSportType(jsonGet.m43769k(c5481g.m39250v(), "runType"));
        mo43920M().setTipsText(jsonGet.m43760t(mo43911x().m38035B(), "contextV2"));
        TextView textView = mo43920M().tvDistanceTag;
        textView.setText("达标里程:" + jsonGet.m43760t(mo43911x().m38035B(), "totalRange") + "公里");
        mo43920M().cpDistance.m39034j(jsonGet.m43771i(mo43911x().m38035B(), "totalRange"));
        mo43920M().cpDistance.m39033k((float) FormatUtils.m39632e(c5481g.m39270f()));
        TextView textView2 = mo43920M().tvTimeTarget;
        textView2.setText("有效时间:" + jsonGet.m43760t(mo43911x().m38035B(), "startQualifiedTime") + '-' + jsonGet.m43760t(mo43911x().m38035B(), "endQualifiedTime") + "分钟");
        mo43920M().cpTime.m39034j(jsonGet.m43771i(mo43911x().m38035B(), "startQualifiedTime"));
        mo43920M().cpTime.m39033k(((float) c5481g.m39274d()) / 60.0f);
        Integer valueOf = Integer.valueOf(c5481g.m39280a());
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            mo43920M().cpTime.m39032l(intValue);
            TextView textView3 = mo43920M().tvTimeTarget;
            textView3.setText("有效时间:" + jsonGet.m43760t(mo43911x().m38035B(), "startQualifiedTime") + '-' + intValue + "分钟");
        }
        TextView textView4 = mo43920M().tvStepTarget;
        textView4.setText("达标步数:" + jsonGet.m43760t(mo43911x().m38035B(), "step") + (char) 27493);
        mo43920M().cpStep.m39034j(jsonGet.m43771i(mo43911x().m38035B(), "step"));
        mo43920M().cpStep.m39033k((float) c5481g.m39247y());
        m38573P();
        m38565X();
        mo43920M().btOk.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V3SportsFinishDialog.m38567V(V3SportsFinishDialog.this, view);
            }
        });
    }

    /* renamed from: N */
    public final void m38575N() {
        InterfaceC15269a<Unit> interfaceC15269a = this.f20565j;
        if (interfaceC15269a != null) {
            interfaceC15269a.invoke();
        }
        dismiss();
        SportsDataAgent.f19899a.m39289R(false);
    }

    /* renamed from: S */
    public final void m38570S(@NotNull String isValid, @NotNull String isException) {
        C14342f0.m8184p(isValid, "isValid");
        C14342f0.m8184p(isException, "isException");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.stopService(new Intent(mo43926C(), V3LocationService.class));
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.stopService(new Intent(mo43926C(), V3StepService.class));
        }
        VoiceUtils.f40105a.m12842b(mo43926C(), C4215R.raw.stop_run);
        mo43911x().m38026w(isValid, isException, new C5714c(this), new C5715d(this));
    }

    /* renamed from: a0 */
    public final void m38562a0(@Nullable InterfaceC15269a<Unit> interfaceC15269a) {
        this.f20565j = interfaceC15269a;
    }

    /* renamed from: b0 */
    public final void m38561b0(@Nullable InterfaceC15269a<Unit> interfaceC15269a) {
        this.f20564i = interfaceC15269a;
    }

    /* renamed from: c0 */
    public final void m38560c0() {
        new V3PassPointDialog().show(mo43923J(), "finishDialog");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, C4215R.C4225style.V2AppTheme);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            FragmentActivity mo43912w = mo43912w();
            (mo43912w == null ? null : mo43912w.getWindowManager()).getDefaultDisplay().getMetrics(displayMetrics);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(2131034508);
                double d = displayMetrics.widthPixels;
                Double.isNaN(d);
                double d2 = displayMetrics.heightPixels;
                Double.isNaN(d2);
                window.setLayout((int) (d * 0.9d), (int) (d2 * 0.8d));
            }
            dialog.setCanceledOnTouchOutside(false);
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.student.v2.ui.sports.v3.c
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    boolean m38564Y;
                    m38564Y = V3SportsFinishDialog.m38564Y(dialogInterface, i, keyEvent);
                    return m38564Y;
                }
            });
        }
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
