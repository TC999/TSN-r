package com.bxkj.student.v2.common.utils;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.acse.ottn.activity.AccessibiltyTsnPermissionGreenActivity;
import com.acse.ottn.activity.AcseHelpManager;
import com.bxkj.student.v2.common.utils.n;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import m.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: SQZSManager.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/bxkj/student/v2/common/utils/n;", "", "<init>", "()V", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class n {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f23377a = new a(null);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: SQZSManager.kt */
    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000e"}, d2 = {"Lcom/bxkj/student/v2/common/utils/n$a;", "", "Landroidx/fragment/app/FragmentActivity;", "mActivity", "Lkotlin/Function0;", "Lkotlin/f1;", "next", "close", "c", "e", "", "b", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
        /* compiled from: SQZSManager.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/student/v2/common/utils/n$a$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.common.utils.n$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class C0293a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FragmentActivity f23378a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ d2.a<f1> f23379b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ d2.a<f1> f23380c;

            C0293a(FragmentActivity fragmentActivity, d2.a<f1> aVar, d2.a<f1> aVar2) {
                this.f23378a = fragmentActivity;
                this.f23379b = aVar;
                this.f23380c = aVar2;
            }

            @Override // m.b.a
            public void a(int i4, @Nullable Intent intent) {
                n.f23377a.c(this.f23378a, this.f23379b, this.f23380c);
            }
        }

        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(d2.a next, d2.a close, FragmentActivity mActivity, String str) {
            f0.p(next, "$next");
            f0.p(close, "$close");
            f0.p(mActivity, "$mActivity");
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
            new m.b(mActivity).startActivityForResult(new Intent(mActivity, AccessibiltyTsnPermissionGreenActivity.class)).c(new C0293a(mActivity, next, close));
        }

        public final boolean b() {
            return AcseHelpManager.isOPenPermission();
        }

        public final void c(@NotNull final FragmentActivity mActivity, @NotNull final d2.a<f1> next, @NotNull final d2.a<f1> close) {
            f0.p(mActivity, "mActivity");
            f0.p(next, "next");
            f0.p(close, "close");
            if (com.bxkj.base.v2.data.a.f18673h.a().J() == 0) {
                com.orhanobut.logger.j.d("LoggedInUser.instance.isOpenSQZS = 0", new Object[0]);
                next.invoke();
            } else if (b()) {
                com.orhanobut.logger.j.d("AcseHelpManager.isOPenPermission->\u6743\u9650\u5df2\u5f00\u542f", new Object[0]);
                next.invoke();
            } else {
                AcseHelpManager.startRunning(mActivity, true, new AcseHelpManager.OnCurrentStateCallBack() { // from class: com.bxkj.student.v2.common.utils.m
                    @Override // com.acse.ottn.activity.AcseHelpManager.OnCurrentStateCallBack
                    public final void onState(String str) {
                        n.a.d(d2.a.this, close, mActivity, str);
                    }
                });
            }
        }

        public final void e(@NotNull FragmentActivity mActivity) {
            f0.p(mActivity, "mActivity");
            AcseHelpManager.startAccessibilityIntroduceActivityForResult(mActivity, 170);
        }
    }
}
