package com.bxkj.student.p094v2.common.utils;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.acse.ottn.activity.AccessibiltyTsnPermissionGreenActivity;
import com.acse.ottn.activity.AcseHelpManager;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.p094v2.common.utils.SQZSManager;
import com.orhanobut.logger.C11792j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p618m.StartActivityForResult;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/n;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.utils.n */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class SQZSManager {
    @NotNull

    /* renamed from: a */
    public static final C5547a f20133a = new C5547a(null);

    /* compiled from: SQZSManager.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ*\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u000e"}, m12616d2 = {"Lcom/bxkj/student/v2/common/utils/n$a;", "", "Landroidx/fragment/app/FragmentActivity;", "mActivity", "Lkotlin/Function0;", "Lkotlin/f1;", "next", "close", "c", "e", "", "b", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.utils.n$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5547a {

        /* compiled from: SQZSManager.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/student/v2/common/utils/n$a$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.common.utils.n$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C5548a implements StartActivityForResult.InterfaceC15293a {

            /* renamed from: a */
            final /* synthetic */ FragmentActivity f20134a;

            /* renamed from: b */
            final /* synthetic */ InterfaceC15269a<Unit> f20135b;

            /* renamed from: c */
            final /* synthetic */ InterfaceC15269a<Unit> f20136c;

            C5548a(FragmentActivity fragmentActivity, InterfaceC15269a<Unit> interfaceC15269a, InterfaceC15269a<Unit> interfaceC15269a2) {
                this.f20134a = fragmentActivity;
                this.f20135b = interfaceC15269a;
                this.f20136c = interfaceC15269a2;
            }

            @Override // p618m.StartActivityForResult.InterfaceC15293a
            /* renamed from: a */
            public void mo3459a(int i, @Nullable Intent intent) {
                SQZSManager.f20133a.m39066c(this.f20134a, this.f20135b, this.f20136c);
            }
        }

        private C5547a() {
        }

        public /* synthetic */ C5547a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public static final void m39065d(InterfaceC15269a next, InterfaceC15269a close, FragmentActivity mActivity, String str) {
            C14342f0.m8184p(next, "$next");
            C14342f0.m8184p(close, "$close");
            C14342f0.m8184p(mActivity, "$mActivity");
            if (str == null) {
                return;
            }
            int hashCode = str.hashCode();
            if (hashCode != 48) {
                if (hashCode != 50) {
                    if (hashCode == 52 && str.equals("4")) {
                        close.invoke();
                        return;
                    }
                } else if (str.equals("2")) {
                    next.invoke();
                    return;
                }
            } else if (str.equals("0")) {
                next.invoke();
                return;
            }
            new StartActivityForResult(mActivity).startActivityForResult(new Intent(mActivity, AccessibiltyTsnPermissionGreenActivity.class)).m3460c(new C5548a(mActivity, next, close));
        }

        /* renamed from: b */
        public final boolean m39067b() {
            return AcseHelpManager.isOPenPermission();
        }

        /* renamed from: c */
        public final void m39066c(@NotNull final FragmentActivity mActivity, @NotNull final InterfaceC15269a<Unit> next, @NotNull final InterfaceC15269a<Unit> close) {
            C14342f0.m8184p(mActivity, "mActivity");
            C14342f0.m8184p(next, "next");
            C14342f0.m8184p(close, "close");
            if (LoggedInUser.f15182b.m43634a().m43689B() == 0) {
                C11792j.m20469d("LoggedInUser.instance.isOpenSQZS = 0", new Object[0]);
                next.invoke();
            } else if (m39067b()) {
                C11792j.m20469d("AcseHelpManager.isOPenPermission->权限已开启", new Object[0]);
                next.invoke();
            } else {
                AcseHelpManager.startRunning(mActivity, true, new AcseHelpManager.OnCurrentStateCallBack() { // from class: com.bxkj.student.v2.common.utils.m
                    @Override // com.acse.ottn.activity.AcseHelpManager.OnCurrentStateCallBack
                    public final void onState(String str) {
                        SQZSManager.C5547a.m39065d(InterfaceC15269a.this, close, mActivity, str);
                    }
                });
            }
        }

        /* renamed from: e */
        public final void m39064e(@NotNull FragmentActivity mActivity) {
            C14342f0.m8184p(mActivity, "mActivity");
            AcseHelpManager.startAccessibilityIntroduceActivityForResult(mActivity, 170);
        }
    }
}
