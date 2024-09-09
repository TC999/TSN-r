package com.bxkj.student.v2.ui.sports.v3;

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
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.base.v2.base.BaseDialog;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.r;
import com.bxkj.student.databinding.AcV3SportsFinishBinding;
import com.bxkj.student.v2.common.data.b;
import com.bxkj.student.v2.ui.face.FaceDetectV3Activity;
import com.bxkj.student.v2.ui.face.FaceLiveV3Activity;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.bxkj.student.v2.ui.sports.v3.service.V3LocationService;
import com.bxkj.student.v2.ui.sports.v3.service.step.V3StepService;
import com.bxkj.student.v2.vm.sports.SportsVM;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.card.MaterialCardView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import l1.p;
import m.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: V3SportsFinishDialog.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u001e\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\u0016\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014J\u0016\u0010\u0018\u001a\u00020\u00042\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010!\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/V3SportsFinishDialog;", "Lcom/bxkj/base/v2/base/BaseDialog;", "Lcom/bxkj/student/databinding/AcV3SportsFinishBinding;", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "Lkotlin/f1;", "P", "d0", "", "isValid", "isException", "Z", "O", "R", "msg", "id", "T", "Q", "", "W", "X", "Lkotlin/Function0;", "finishCommit", "b0", "continueCommit", "a0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "E", "p", "onStart", "N", "c0", "S", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "k", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "bottomSheetDialog", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class V3SportsFinishDialog extends BaseDialog<AcV3SportsFinishBinding, SportsVM> {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private l1.a<f1> f23963i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private l1.a<f1> f23964j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private BottomSheetDialog f23965k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsFinishDialog.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends Lambda implements l1.a<f1> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f23967b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f23968c;

        /* compiled from: V3SportsFinishDialog.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsFinishDialog$a$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3SportsFinishDialog$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class C0315a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ V3SportsFinishDialog f23969a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f23970b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f23971c;

            C0315a(V3SportsFinishDialog v3SportsFinishDialog, String str, String str2) {
                this.f23969a = v3SportsFinishDialog;
                this.f23970b = str;
                this.f23971c = str2;
            }

            @Override // m.b.a
            public void a(int i4, @Nullable Intent intent) {
                if (i4 == -1) {
                    this.f23969a.S(this.f23970b, this.f23971c);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2) {
            super(0);
            this.f23967b = str;
            this.f23968c = str2;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m66invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public final void m66invoke() {
            com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
            Class cls = lVar.k(V3SportsFinishDialog.this.x().B(), "livingFace") == 1 ? FaceLiveV3Activity.class : FaceDetectV3Activity.class;
            m.b bVar = new m.b(V3SportsFinishDialog.this.w());
            Intent putExtra = new Intent(V3SportsFinishDialog.this.C(), cls).putExtra("identify", lVar.t(V3SportsFinishDialog.this.x().B(), "identify")).putExtra("type", "3").putExtra("runType", lVar.l(V3SportsFinishDialog.this.x().B(), "runType", 1));
            f0.o(putExtra, "Intent(mContext, toActiv\u2026e\", SportsType.SUNSHINE))");
            bVar.startActivityForResult(putExtra).c(new C0315a(V3SportsFinishDialog.this, this.f23967b, this.f23968c));
            FragmentActivity activity = V3SportsFinishDialog.this.getActivity();
            if (activity == null) {
                return;
            }
            activity.overridePendingTransition(2130771987, 2130771986);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsFinishDialog.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends Lambda implements l1.l<iOSOneButtonDialog, f1> {

        /* compiled from: V3SportsFinishDialog.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/ui/sports/v3/V3SportsFinishDialog$b$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        public static final class a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ V3SportsFinishDialog f23973a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f23974b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f23975c;

            a(V3SportsFinishDialog v3SportsFinishDialog, String str, String str2) {
                this.f23973a = v3SportsFinishDialog;
                this.f23974b = str;
                this.f23975c = str2;
            }

            @Override // m.b.a
            public void a(int i4, @Nullable Intent intent) {
                if (i4 == -1) {
                    this.f23973a.W(this.f23974b, this.f23975c);
                }
            }
        }

        b() {
            super(1);
        }

        public final void a(@NotNull iOSOneButtonDialog it) {
            f0.p(it, "it");
            V3SportsFinishDialog.this.startActivity(new Intent(V3SportsFinishDialog.this.C(), V3RecordDetailActivity.class).putExtra("identify", com.bxkj.base.v2.common.utils.l.f18624a.t(V3SportsFinishDialog.this.x().B(), "identify")));
            V3SportsFinishDialog.this.Q();
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSOneButtonDialog iosonebuttondialog) {
            a(iosonebuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsFinishDialog.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public /* synthetic */ class c extends FunctionReferenceImpl implements p<String, String, f1> {
        c(Object obj) {
            super(2, obj, V3SportsFinishDialog.class, "commitSuccess", "commitSuccess(Ljava/lang/String;Ljava/lang/String;)V", 0);
        }

        public final void e(@Nullable String str, @Nullable String str2) {
            ((V3SportsFinishDialog) this.receiver).T(str, str2);
        }

        @Override // l1.p
        public /* bridge */ /* synthetic */ f1 invoke(String str, String str2) {
            e(str, str2);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsFinishDialog.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public /* synthetic */ class d extends FunctionReferenceImpl implements l1.a<f1> {
        d(Object obj) {
            super(0, obj, V3SportsFinishDialog.class, "commitFail", "commitFail()V", 0);
        }

        public final void e() {
            ((V3SportsFinishDialog) this.receiver).R();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            e();
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsFinishDialog.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class e extends Lambda implements l1.a<f1> {
        e() {
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m67invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public final void m67invoke() {
            V3SportsFinishDialog.this.Q();
            V3SportsFinishDialog.this.startActivity(new Intent(V3SportsFinishDialog.this.C(), V3RecordDetailActivity.class).putExtra("identify", com.bxkj.base.v2.common.utils.l.f18624a.t(V3SportsFinishDialog.this.x().B(), "identify")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: V3SportsFinishDialog.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class f extends Lambda implements l1.a<f1> {
        f() {
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m68invoke();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public final void m68invoke() {
            V3SportsFinishDialog.this.Q();
        }
    }

    /* compiled from: V3SportsFinishDialog.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class g extends Lambda implements d2.a<f1> {
        g() {
            super(0);
        }

        @Override // d2.a
        public /* bridge */ /* synthetic */ f1 invoke() {
            invoke2();
            return f1.f55527a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            V3SportsFinishDialog.N(V3SportsFinishDialog.this);
        }
    }

    private final void O(String str, String str2) {
        if (com.bxkj.base.v2.common.utils.l.f18624a.k(x().B(), "isEndFace") == 1) {
            com.bxkj.base.v2.common.ext.g.c(w(), "\u4eba\u8138\u8bc6\u522b", new a(str, str2));
        } else {
            S(str, str2);
        }
    }

    private final void P() {
        List<Map<String, Object>> n4 = com.bxkj.base.v2.common.utils.l.f18624a.n(x().B(), "list");
        List<Map<String, Object>> s3 = com.bxkj.student.v2.common.data.b.a.s();
        MaterialCardView materialCardView = M().cardPassPoint;
        f0.o(materialCardView, "mDataBinding.cardPassPoint");
        materialCardView.setVisibility(n4.isEmpty() ^ true ? 0 : 8);
        MaterialCardView materialCardView2 = M().cardNoPass;
        f0.o(materialCardView2, "mDataBinding.cardNoPass");
        materialCardView2.setVisibility(s3.size() < n4.size() ? 0 : 8);
        TextView textView = M().tvPassPointTarget;
        textView.setText("\u672c\u6b21\u9700\u8981\u7ecf\u8fc7\u5fc5\u7ecf\u70b9:" + n4.size() + '\u4e2a');
        TextView textView2 = M().tvPassPoint;
        textView2.setText("\u672c\u6b21\u5b9e\u9645\u7ecf\u8fc7\u5fc5\u7ecf\u70b9: " + s3.size() + '\u4e2a');
        TextView textView3 = M().tvNoPassPoint;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        r rVar = r.f18634a;
        textView3.setText(spannableStringBuilder.append((CharSequence) rVar.a("\u672a\u8fbe\u6807", ContextCompat.getColor(C(), 2131034176))).append((CharSequence) "\n").append((CharSequence) rVar.a("\u672a\u7ecf\u8fc7\u70b9\u8be6\u60c5", ContextCompat.getColor(C(), 2131034551))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        V3SportsHomeActivity v3SportsHomeActivity = (V3SportsHomeActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(V3SportsHomeActivity.class);
        if (v3SportsHomeActivity != null) {
            v3SportsHomeActivity.t0();
        }
        b.g gVar = com.bxkj.student.v2.common.data.b.a;
        gVar.v().clear();
        l1.a<f1> aVar = this.f23963i;
        if (aVar != null) {
            aVar.invoke();
        }
        BottomSheetDialog bottomSheetDialog = this.f23965k;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
        dismissAllowingStateLoss();
        V3SportsMapActivity v3SportsMapActivity = (V3SportsMapActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(V3SportsMapActivity.class);
        if (v3SportsMapActivity != null) {
            v3SportsMapActivity.finish();
        }
        V3SportsActivity v3SportsActivity = (V3SportsActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(V3SportsActivity.class);
        if (v3SportsActivity != null) {
            v3SportsActivity.finish();
        }
        gVar.b0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        iOSOneButtonDialog n4 = ContextExtKt.n(C(), "\u63d0\u4ea4\u5f02\u5e38,\u5df2\u4e3a\u60a8\u6682\u5b58\u672c\u5730,\u8bf7\u7a0d\u540e\u5728\u672c\u5730\u953b\u70bc\u8bb0\u5f55\u4e2d\u91cd\u65b0\u4e0a\u4f20\uff01", new b());
        n4.setCancelable(false);
        n4.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(String str, String str2) {
        if (str == null) {
            str = "\u4e0a\u4f20\u6210\u529f";
        }
        ContextExtKt.q(C(), str);
        Q();
        if (str2 == null) {
            return;
        }
        startActivity(new Intent(C(), V3RecordDetailActivity.class).putExtra("exerciseRecordId", str2));
    }

    static /* synthetic */ void U(V3SportsFinishDialog v3SportsFinishDialog, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "\u4e0a\u4f20\u6210\u529f";
        }
        v3SportsFinishDialog.T(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(V3SportsFinishDialog this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.d0();
    }

    private final boolean W() {
        com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
        if (lVar.l(x().B(), "runType", 1) == 0) {
            return true;
        }
        double f4 = lVar.f(x().B(), "minSaveRange");
        b.g gVar = com.bxkj.student.v2.common.data.b.a;
        if (gVar.d() >= lVar.k(x().B(), "startQualifiedTime") * 60) {
            double f5 = gVar.f();
            double d4 = 1000;
            Double.isNaN(d4);
            if (f5 >= f4 * d4) {
                return true;
            }
        }
        return false;
    }

    private final boolean X() {
        boolean z3;
        TextView textView = M().tvDistance;
        b.g gVar = com.bxkj.student.v2.common.data.b.a;
        textView.setText(f0.C(com.bxkj.student.run.app.utils.i.c(gVar.f()), "\u516c\u91cc"));
        double f4 = gVar.f();
        com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
        double f5 = lVar.f(x().B(), "totalRange");
        double d4 = 1000;
        Double.isNaN(d4);
        if (f4 < f5 * d4) {
            M().tvDistance.setTextColor(ContextCompat.getColor(C(), 2131034176));
            M().tvDistanceStatus.setText("\u672a\u8fbe\u6807");
            M().tvDistanceStatus.setTextColor(ContextCompat.getColor(C(), 2131034176));
            z3 = false;
        } else {
            M().tvDistance.setTextColor(ContextCompat.getColor(C(), 2131034190));
            M().tvDistanceStatus.setText("\u5df2\u8fbe\u6807");
            M().tvDistanceStatus.setTextColor(ContextCompat.getColor(C(), 2131034569));
            z3 = true;
        }
        M().tvTime.setText(com.bxkj.base.v2.common.utils.d.b(gVar.d()));
        int k4 = lVar.k(x().B(), "startQualifiedTime");
        int a4 = gVar.a();
        if (gVar.d() >= k4 * 60 && (a4 == -1 || gVar.d() <= a4 * 60)) {
            M().tvTime.setTextColor(ContextCompat.getColor(C(), 2131034190));
            M().tvTimeStatus.setText("\u5df2\u8fbe\u6807");
            M().tvTimeStatus.setTextColor(ContextCompat.getColor(C(), 2131034569));
        } else {
            M().tvTime.setTextColor(ContextCompat.getColor(C(), 2131034176));
            M().tvTimeStatus.setText("\u672a\u8fbe\u6807");
            M().tvTimeStatus.setTextColor(ContextCompat.getColor(C(), 2131034176));
            z3 = false;
        }
        TextView textView2 = M().tvStep;
        StringBuilder sb = new StringBuilder();
        sb.append(gVar.y());
        sb.append('\u6b65');
        textView2.setText(sb.toString());
        if (gVar.y() < lVar.f(x().B(), "step")) {
            M().tvStep.setTextColor(ContextCompat.getColor(C(), 2131034176));
            M().tvStepStatus.setText("\u672a\u8fbe\u6807");
            M().tvStepStatus.setTextColor(ContextCompat.getColor(C(), 2131034176));
            z3 = false;
        } else {
            M().tvStep.setTextColor(ContextCompat.getColor(C(), 2131034190));
            M().tvStepStatus.setText("\u5df2\u8fbe\u6807");
            M().tvStepStatus.setTextColor(ContextCompat.getColor(C(), 2131034569));
        }
        if (gVar.s().size() < lVar.n(x().B(), "list").size()) {
            return false;
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Y(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
        if (i4 == 4) {
            com.bxkj.student.v2.common.data.b.a.R(false);
        }
        return false;
    }

    private final void Z(String str, String str2) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.stopService(new Intent(C(), V3LocationService.class));
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.stopService(new Intent(C(), V3StepService.class));
        }
        d0.a.f54621a.b(C(), 2131755103);
        x().F(str, str2, new e());
    }

    private final void d0() {
        if (!W()) {
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(C(), 2131886879);
            bottomSheetDialog.setContentView(2131427592);
            TextView textView = (TextView) bottomSheetDialog.findViewById(2131232913);
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        V3SportsFinishDialog.e0(BottomSheetDialog.this, view);
                    }
                });
            }
            TextView textView2 = (TextView) bottomSheetDialog.findViewById(2131233186);
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        V3SportsFinishDialog.f0(V3SportsFinishDialog.this, view);
                    }
                });
            }
            bottomSheetDialog.show();
            f1 f1Var = f1.f55527a;
            this.f23965k = bottomSheetDialog;
            return;
        }
        O(X() ? "1" : "0", "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(BottomSheetDialog this_apply, View view) {
        f0.p(this_apply, "$this_apply");
        this_apply.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(V3SportsFinishDialog this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.x().x(new f());
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        b.g gVar = com.bxkj.student.v2.common.data.b.a;
        x().G(gVar.v());
        M().setDialog(this);
        com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
        M().setSportType(lVar.k(gVar.v(), "runType"));
        M().setTipsText(lVar.t(x().B(), "contextV2"));
        TextView textView = M().tvDistanceTag;
        textView.setText("\u8fbe\u6807\u91cc\u7a0b:" + lVar.t(x().B(), "totalRange") + "\u516c\u91cc");
        M().cpDistance.j(lVar.i(x().B(), "totalRange"));
        M().cpDistance.k((float) com.bxkj.student.run.app.utils.i.e(gVar.f()));
        TextView textView2 = M().tvTimeTarget;
        textView2.setText("\u6709\u6548\u65f6\u95f4:" + lVar.t(x().B(), "startQualifiedTime") + '-' + lVar.t(x().B(), "endQualifiedTime") + "\u5206\u949f");
        M().cpTime.j(lVar.i(x().B(), "startQualifiedTime"));
        M().cpTime.k(((float) gVar.d()) / 60.0f);
        Integer valueOf = Integer.valueOf(gVar.a());
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            M().cpTime.l(intValue);
            TextView textView3 = M().tvTimeTarget;
            textView3.setText("\u6709\u6548\u65f6\u95f4:" + lVar.t(x().B(), "startQualifiedTime") + '-' + intValue + "\u5206\u949f");
        }
        TextView textView4 = M().tvStepTarget;
        textView4.setText("\u8fbe\u6807\u6b65\u6570:" + lVar.t(x().B(), "step") + '\u6b65');
        M().cpStep.j(lVar.i(x().B(), "step"));
        M().cpStep.k((float) gVar.y());
        P();
        X();
        M().btOk.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V3SportsFinishDialog.V(V3SportsFinishDialog.this, view);
            }
        });
    }

    public final void N() {
        l1.a<f1> aVar = this.f23964j;
        if (aVar != null) {
            aVar.invoke();
        }
        dismiss();
        com.bxkj.student.v2.common.data.b.a.R(false);
    }

    public final void S(@NotNull String isValid, @NotNull String isException) {
        f0.p(isValid, "isValid");
        f0.p(isException, "isException");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.stopService(new Intent(C(), V3LocationService.class));
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.stopService(new Intent(C(), V3StepService.class));
        }
        d0.a.f54621a.b(C(), 2131755103);
        x().w(isValid, isException, new c(this), new d(this));
    }

    public final void a0(@Nullable l1.a<f1> aVar) {
        this.f23964j = aVar;
    }

    public final void b0(@Nullable l1.a<f1> aVar) {
        this.f23963i = aVar;
    }

    public final void c0() {
        new V3PassPointDialog().show(J(), "finishDialog");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, 2131886673);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            FragmentActivity w3 = w();
            (w3 == null ? null : w3.getWindowManager()).getDefaultDisplay().getMetrics(displayMetrics);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(2131034508);
                double d4 = displayMetrics.widthPixels;
                Double.isNaN(d4);
                double d5 = displayMetrics.heightPixels;
                Double.isNaN(d5);
                window.setLayout((int) (d4 * 0.9d), (int) (d5 * 0.8d));
            }
            dialog.setCanceledOnTouchOutside(false);
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.student.v2.ui.sports.v3.c
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
                    boolean Y;
                    Y = V3SportsFinishDialog.Y(dialogInterface, i4, keyEvent);
                    return Y;
                }
            });
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
