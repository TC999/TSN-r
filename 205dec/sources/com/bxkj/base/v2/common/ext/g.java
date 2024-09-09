package com.bxkj.base.v2.common.ext;

import android.content.Intent;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.util.s;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import l.b;
import l1.l;
import m.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PermissionExt.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a$\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a8\u0010\b\u001a\u00020\u0004*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u001a$\u0010\t\u001a\u00020\u0004*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a$\u0010\n\u001a\u00020\u0004*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a\u0018\u0010\u000b\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a\u0018\u0010\f\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a\"\u0010\u000e\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u00a8\u0006\u000f"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "", "use", "Lkotlin/Function0;", "Lkotlin/f1;", "agree", "c", "refuse", "d", "g", "j", "i", "b", "context", "l", "base_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class g {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionExt.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends Lambda implements l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f18546a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f18547b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f18548c;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: PermissionExt.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\u0007J\b\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/base/v2/common/ext/g$a$a", "Ll/b$a;", "", "", "permission", "Lkotlin/f1;", "c", "([Ljava/lang/String;)V", "a", "b", "base_release"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.bxkj.base.v2.common.ext.g$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class C0201a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FragmentActivity f18549a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FragmentActivity f18550b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ l1.a<f1> f18551c;

            C0201a(FragmentActivity fragmentActivity, FragmentActivity fragmentActivity2, l1.a<f1> aVar) {
                this.f18549a = fragmentActivity;
                this.f18550b = fragmentActivity2;
                this.f18551c = aVar;
            }

            @Override // l.b.a
            public void a(@NotNull String[] permission) {
                f0.p(permission, "permission");
                g.l(this.f18549a, this.f18550b, this.f18551c);
            }

            @Override // l.b.a
            public void b() {
                this.f18551c.invoke();
            }

            @Override // l.b.a
            public void c(@NotNull String[] permission) {
                f0.p(permission, "permission");
                g.l(this.f18549a, this.f18550b, this.f18551c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(FragmentActivity fragmentActivity, l1.a<f1> aVar, FragmentActivity fragmentActivity2) {
            super(1);
            this.f18546a = fragmentActivity;
            this.f18547b = aVar;
            this.f18548c = fragmentActivity2;
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            if (Build.VERSION.SDK_INT >= 29) {
                new l.b(this.f18546a).c("android.permission.ACCESS_BACKGROUND_LOCATION").d(new C0201a(this.f18546a, this.f18548c, this.f18547b));
            } else {
                this.f18547b.invoke();
            }
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionExt.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends Lambda implements l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f18552a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f18553b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f18554c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(FragmentActivity fragmentActivity, FragmentActivity fragmentActivity2, l1.a<f1> aVar) {
            super(1);
            this.f18552a = fragmentActivity;
            this.f18553b = fragmentActivity2;
            this.f18554c = aVar;
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            g.l(this.f18552a, this.f18553b, this.f18554c);
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionExt.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class c extends Lambda implements l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f18555a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f18556b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18557c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f18558d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: PermissionExt.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J#\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\t\u0010\b\u00a8\u0006\n"}, d2 = {"com/bxkj/base/v2/common/ext/g$c$a", "Ll/b$a;", "Lkotlin/f1;", "b", "", "", "permission", "c", "([Ljava/lang/String;)V", "a", "base_release"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l1.a<f1> f18559a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FragmentActivity f18560b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f18561c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ l1.a<f1> f18562d;

            a(l1.a<f1> aVar, FragmentActivity fragmentActivity, String str, l1.a<f1> aVar2) {
                this.f18559a = aVar;
                this.f18560b = fragmentActivity;
                this.f18561c = str;
                this.f18562d = aVar2;
            }

            @Override // l.b.a
            public void a(@NotNull String... permission) {
                f0.p(permission, "permission");
                ContextExtKt.m(this.f18560b, this.f18561c);
                l1.a<f1> aVar = this.f18562d;
                if (aVar == null) {
                    return;
                }
                f1 f1Var = (f1) aVar.invoke();
            }

            @Override // l.b.a
            public void b() {
                this.f18559a.invoke();
            }

            @Override // l.b.a
            public void c(@NotNull String... permission) {
                f0.p(permission, "permission");
                ContextExtKt.m(this.f18560b, this.f18561c);
                l1.a<f1> aVar = this.f18562d;
                if (aVar == null) {
                    return;
                }
                f1 f1Var = (f1) aVar.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(FragmentActivity fragmentActivity, l1.a<f1> aVar, String str, l1.a<f1> aVar2) {
            super(1);
            this.f18555a = fragmentActivity;
            this.f18556b = aVar;
            this.f18557c = str;
            this.f18558d = aVar2;
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            new l.b(this.f18555a).c("android.permission.CAMERA").d(new a(this.f18556b, this.f18555a, this.f18557c, this.f18558d));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionExt.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class d extends Lambda implements l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f18563a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18564b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f18565c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(FragmentActivity fragmentActivity, String str, l1.a<f1> aVar) {
            super(1);
            this.f18563a = fragmentActivity;
            this.f18564b = str;
            this.f18565c = aVar;
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            ContextExtKt.m(this.f18563a, this.f18564b);
            l1.a<f1> aVar = this.f18565c;
            if (aVar == null) {
                return;
            }
            f1 f1Var = (f1) aVar.invoke();
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionExt.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class e extends Lambda implements l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f18566a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f18567b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18568c;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: PermissionExt.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J#\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\t\u0010\b\u00a8\u0006\n"}, d2 = {"com/bxkj/base/v2/common/ext/g$e$a", "Ll/b$a;", "Lkotlin/f1;", "b", "", "", "permission", "c", "([Ljava/lang/String;)V", "a", "base_release"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l1.a<f1> f18569a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FragmentActivity f18570b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f18571c;

            a(l1.a<f1> aVar, FragmentActivity fragmentActivity, String str) {
                this.f18569a = aVar;
                this.f18570b = fragmentActivity;
                this.f18571c = str;
            }

            @Override // l.b.a
            public void a(@NotNull String... permission) {
                f0.p(permission, "permission");
                ContextExtKt.m(this.f18570b, this.f18571c);
            }

            @Override // l.b.a
            public void b() {
                this.f18569a.invoke();
            }

            @Override // l.b.a
            public void c(@NotNull String... permission) {
                f0.p(permission, "permission");
                ContextExtKt.m(this.f18570b, this.f18571c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(FragmentActivity fragmentActivity, l1.a<f1> aVar, String str) {
            super(1);
            this.f18566a = fragmentActivity;
            this.f18567b = aVar;
            this.f18568c = str;
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            new l.b(this.f18566a).c("android.permission.READ_EXTERNAL_STORAGE").d(new a(this.f18567b, this.f18566a, this.f18568c));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionExt.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class f extends Lambda implements l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f18572a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18573b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(FragmentActivity fragmentActivity, String str) {
            super(1);
            this.f18572a = fragmentActivity;
            this.f18573b = str;
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            ContextExtKt.m(this.f18572a, this.f18573b);
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionExt.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.ext.g$g  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class C0202g extends Lambda implements l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f18574a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f18575b;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: PermissionExt.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\u0007J\b\u0010\t\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/base/v2/common/ext/g$g$a", "Ll/b$a;", "", "", "permission", "Lkotlin/f1;", "c", "([Ljava/lang/String;)V", "a", "b", "base_release"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.bxkj.base.v2.common.ext.g$g$a */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FragmentActivity f18576a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ l1.a<f1> f18577b;

            a(FragmentActivity fragmentActivity, l1.a<f1> aVar) {
                this.f18576a = fragmentActivity;
                this.f18577b = aVar;
            }

            @Override // l.b.a
            public void a(@NotNull String[] permission) {
                f0.p(permission, "permission");
                ContextExtKt.m(this.f18576a, "\u4f60\u62d2\u7edd\u4e86\u5b9a\u4f4d\u6743\u9650\u65e0\u6cd5\u5b9a\u4f4d");
            }

            @Override // l.b.a
            public void b() {
                this.f18577b.invoke();
            }

            @Override // l.b.a
            public void c(@NotNull String[] permission) {
                f0.p(permission, "permission");
                ContextExtKt.m(this.f18576a, "\u4f60\u62d2\u7edd\u4e86\u5b9a\u4f4d\u6743\u9650\u65e0\u6cd5\u5b9a\u4f4d");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0202g(FragmentActivity fragmentActivity, l1.a<f1> aVar) {
            super(1);
            this.f18574a = fragmentActivity;
            this.f18575b = aVar;
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            new l.b(this.f18574a).c("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION").d(new a(this.f18574a, this.f18575b));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionExt.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class h extends Lambda implements l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        public static final h f18578a = new h();

        h() {
            super(1);
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionExt.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class i extends Lambda implements l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f18579a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String[] f18580b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f18581c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f18582d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: PermissionExt.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J#\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\t\u0010\b\u00a8\u0006\n"}, d2 = {"com/bxkj/base/v2/common/ext/g$i$a", "Ll/b$a;", "Lkotlin/f1;", "b", "", "", "permission", "c", "([Ljava/lang/String;)V", "a", "base_release"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l1.a<f1> f18583a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FragmentActivity f18584b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f18585c;

            a(l1.a<f1> aVar, FragmentActivity fragmentActivity, String str) {
                this.f18583a = aVar;
                this.f18584b = fragmentActivity;
                this.f18585c = str;
            }

            @Override // l.b.a
            public void a(@NotNull String... permission) {
                f0.p(permission, "permission");
                ContextExtKt.m(this.f18584b, this.f18585c);
            }

            @Override // l.b.a
            public void b() {
                this.f18583a.invoke();
            }

            @Override // l.b.a
            public void c(@NotNull String... permission) {
                f0.p(permission, "permission");
                ContextExtKt.m(this.f18584b, this.f18585c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(FragmentActivity fragmentActivity, String[] strArr, l1.a<f1> aVar, String str) {
            super(1);
            this.f18579a = fragmentActivity;
            this.f18580b = strArr;
            this.f18581c = aVar;
            this.f18582d = str;
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            l.b bVar = new l.b(this.f18579a);
            String[] strArr = this.f18580b;
            bVar.c((String[]) Arrays.copyOf(strArr, strArr.length)).d(new a(this.f18581c, this.f18579a, this.f18582d));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionExt.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class j extends Lambda implements l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f18586a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f18587b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(FragmentActivity fragmentActivity, String str) {
            super(1);
            this.f18586a = fragmentActivity;
            this.f18587b = str;
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            ContextExtKt.m(this.f18586a, this.f18587b);
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: PermissionExt.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class k extends Lambda implements l<iOSTwoButtonDialog, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f18588a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentActivity f18589b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f18590c;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: PermissionExt.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/bxkj/base/v2/common/ext/g$k$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "base_release"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ FragmentActivity f18591a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ l1.a<f1> f18592b;

            a(FragmentActivity fragmentActivity, l1.a<f1> aVar) {
                this.f18591a = fragmentActivity;
                this.f18592b = aVar;
            }

            @Override // m.b.a
            public void a(int i4, @Nullable Intent intent) {
                g.b(this.f18591a, this.f18592b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(FragmentActivity fragmentActivity, FragmentActivity fragmentActivity2, l1.a<f1> aVar) {
            super(1);
            this.f18588a = fragmentActivity;
            this.f18589b = fragmentActivity2;
            this.f18590c = aVar;
        }

        public final void a(@NotNull iOSTwoButtonDialog it) {
            f0.p(it, "it");
            s.p(this.f18588a, new a(this.f18589b, this.f18590c));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
            a(iostwobuttondialog);
            return f1.f55527a;
        }
    }

    public static final void b(@NotNull FragmentActivity fragmentActivity, @NotNull l1.a<f1> agree) {
        f0.p(fragmentActivity, "<this>");
        f0.p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
            agree.invoke();
        } else {
            ContextExtKt.g(fragmentActivity, "\u59cb\u7ec8\u5141\u8bb8\u5b9a\u4f4d", "\u662f\u5426\u5141\u8bb8\u5e94\u7528\u59cb\u7ec8\u5141\u8bb8\u5b9a\u4f4d,\u4fbf\u4e8eAPP\u9501\u5c4f\u540e\u7ee7\u7eed\u8bb0\u5f55\u8dd1\u6b65\u8f68\u8ff9", new a(fragmentActivity, agree, fragmentActivity), new b(fragmentActivity, fragmentActivity, agree), "\u62d2\u7edd", "\u540c\u610f\u5e76\u4f7f\u7528");
        }
    }

    public static final void c(@NotNull FragmentActivity fragmentActivity, @Nullable String str, @NotNull l1.a<f1> agree) {
        f0.p(fragmentActivity, "<this>");
        f0.p(agree, "agree");
        d(fragmentActivity, str, agree, null);
    }

    public static final void d(@NotNull FragmentActivity fragmentActivity, @Nullable String str, @NotNull l1.a<f1> agree, @Nullable l1.a<f1> aVar) {
        f0.p(fragmentActivity, "<this>");
        f0.p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.CAMERA") == 0) {
            agree.invoke();
            return;
        }
        String str2 = "\u60a8\u62d2\u7edd\u4e86\u6444\u50cf\u5934\u6743\u9650\uff0c\u65e0\u6cd5\u4f7f\u7528" + ((Object) str) + "\u529f\u80fd\uff0c\u8bf7\u5728\u3010\u8bbe\u7f6e->\u5e94\u7528\u2014>\u4f53\u9002\u80fd->\u6743\u9650\u7ba1\u7406->\u6444\u50cf\u5934\u3011\u8bbe\u7f6e\u5141\u8bb8\u540e\u518d\u8fdb\u884c\u64cd\u4f5c";
        ContextExtKt.g(fragmentActivity, str, f0.C("\u662f\u5426\u5141\u8bb8\u8bbf\u95ee\u6444\u50cf\u5934\uff0c\u4fbf\u4e8e", str), new c(fragmentActivity, agree, str2, aVar), new d(fragmentActivity, str2, aVar), "\u62d2\u7edd", "\u540c\u610f\u5e76\u4f7f\u7528");
    }

    public static /* synthetic */ void e(FragmentActivity fragmentActivity, String str, l1.a aVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "\u62cd\u7167";
        }
        c(fragmentActivity, str, aVar);
    }

    public static /* synthetic */ void f(FragmentActivity fragmentActivity, String str, l1.a aVar, l1.a aVar2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "\u62cd\u7167";
        }
        if ((i4 & 4) != 0) {
            aVar2 = null;
        }
        d(fragmentActivity, str, aVar, aVar2);
    }

    public static final void g(@NotNull FragmentActivity fragmentActivity, @Nullable String str, @NotNull l1.a<f1> agree) {
        f0.p(fragmentActivity, "<this>");
        f0.p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            agree.invoke();
            return;
        }
        String str2 = "\u60a8\u62d2\u7edd\u4e86\u8bbf\u95ee\u5b58\u50a8\u7a7a\u95f4\u6743\u9650\uff0c\u65e0\u6cd5\u4f7f\u7528" + ((Object) str) + "\u529f\u80fd\uff0c\u8bf7\u5728\u3010\u8bbe\u7f6e->\u5e94\u7528\u2014>\u4f53\u9002\u80fd->\u6743\u9650\u7ba1\u7406->\u5b58\u50a8\u7a7a\u95f4\u3011\u8bbe\u7f6e\u5141\u8bb8\u540e\u518d\u8fdb\u884c\u64cd\u4f5c";
        ContextExtKt.g(fragmentActivity, str, f0.C("\u662f\u5426\u5141\u8bb8\u8bbf\u95ee\u5b58\u50a8\u7a7a\u95f4\uff0c\u4fbf\u4e8e\u83b7\u53d6", str), new e(fragmentActivity, agree, str2), new f(fragmentActivity, str2), "\u62d2\u7edd", "\u540c\u610f\u5e76\u4f7f\u7528");
    }

    public static /* synthetic */ void h(FragmentActivity fragmentActivity, String str, l1.a aVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "\u76f8\u518c";
        }
        g(fragmentActivity, str, aVar);
    }

    public static final void i(@NotNull FragmentActivity fragmentActivity, @NotNull l1.a<f1> agree) {
        f0.p(fragmentActivity, "<this>");
        f0.p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.ACCESS_COARSE_LOCATION") == 0 && ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            agree.invoke();
        } else {
            ContextExtKt.g(fragmentActivity, "\u5b9a\u4f4d", "\u662f\u5426\u5141\u8bb8\u8bbf\u95ee\u5b9a\u4f4d,\u4fbf\u4e8e\u8bb0\u5f55\u8dd1\u6b65\u8f68\u8ff9", new C0202g(fragmentActivity, agree), h.f18578a, "\u62d2\u7edd", "\u540c\u610f\u5e76\u4f7f\u7528");
        }
    }

    public static final void j(@NotNull FragmentActivity fragmentActivity, @Nullable String str, @NotNull l1.a<f1> agree) {
        f0.p(fragmentActivity, "<this>");
        f0.p(agree, "agree");
        String[] strArr = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE"};
        if (ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.CAMERA") == 0 && ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.RECORD_AUDIO") == 0) {
            agree.invoke();
            return;
        }
        String str2 = "\u60a8\u62d2\u7edd\u4e86\u6444\u50cf\u5934\u3001\u5f55\u97f3\u3001\u8bbf\u95ee\u5b58\u50a8\u7a7a\u95f4\u6743\u9650\uff0c\u65e0\u6cd5\u4f7f\u7528" + ((Object) str) + "\u529f\u80fd\uff0c\u8bf7\u5728\u3010\u8bbe\u7f6e->\u5e94\u7528\u2014>\u4f53\u9002\u80fd->\u6743\u9650\u7ba1\u7406->\u6444\u50cf\u5934\u3001\u5f55\u97f3\u3001\u5b58\u50a8\u7a7a\u95f4\u3011\u8bbe\u7f6e\u5141\u8bb8\u540e\u518d\u8fdb\u884c\u64cd\u4f5c";
        ContextExtKt.g(fragmentActivity, str, f0.C("\u662f\u5426\u5141\u8bb8\u6444\u50cf\u5934\u3001\u5f55\u97f3\u3001\u8bbf\u95ee\u5b58\u50a8\u7a7a\u95f4\uff0c\u4fbf\u4e8e", str), new i(fragmentActivity, strArr, agree, str2), new j(fragmentActivity, str2), "\u62d2\u7edd", "\u540c\u610f\u5e76\u4f7f\u7528");
    }

    public static /* synthetic */ void k(FragmentActivity fragmentActivity, String str, l1.a aVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = "\u5f55\u5236\u89c6\u9891";
        }
        j(fragmentActivity, str, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(FragmentActivity fragmentActivity, FragmentActivity fragmentActivity2, l1.a<f1> aVar) {
        ContextExtKt.h(fragmentActivity, "\u6743\u9650\u63d0\u793a", "\u4e3a\u4e86\u6b63\u5e38\u8bb0\u5f55\u4f60\u7684\u8fd0\u52a8\u6570\u636e\uff0c\u9700\u8981\u4f60\u5c06\u3010\u4f53\u9002\u80fd\u3011APP\u7684\u3010\u6743\u9650\u8bbe\u7f6e\u3011\u4e2d\u7684\u3010\u4f4d\u7f6e\u4fe1\u606f\u3011\u8bbe\u7f6e\u4e3a\u3010\u59cb\u7ec8\u5141\u8bb8\u3011\u540e\u518d\u5f00\u59cb\u8dd1\u6b65\u3002", new k(fragmentActivity2, fragmentActivity, aVar), null, null, "\u53bb\u8bbe\u7f6e", 24, null);
    }
}
