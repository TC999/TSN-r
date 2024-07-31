package com.bxkj.base.p085v2.common.ext;

import android.content.Intent;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.util.C3912s;
import com.kuaishou.weapon.p205p0.C7282g;
import com.kuaishou.weapon.p205p0.C7304t;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p615l.RequestPermission;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p618m.StartActivityForResult;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a$\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a8\u0010\b\u001a\u00020\u0004*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u001a$\u0010\t\u001a\u00020\u0004*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a$\u0010\n\u001a\u00020\u0004*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a\u0018\u0010\u000b\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a\u0018\u0010\f\u001a\u00020\u0004*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a\"\u0010\u000e\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¨\u0006\u000f"}, m12616d2 = {"Landroidx/fragment/app/FragmentActivity;", "", "use", "Lkotlin/Function0;", "Lkotlin/f1;", "agree", "c", "refuse", "d", "g", "j", "i", "b", "context", C7304t.f25048d, "base_release"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.common.ext.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class PermissionExt {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionExt.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.ext.g$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3941a extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        final /* synthetic */ FragmentActivity f15058a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15269a<Unit> f15059b;

        /* renamed from: c */
        final /* synthetic */ FragmentActivity f15060c;

        /* compiled from: PermissionExt.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/base/v2/common/ext/g$a$a", "Ll/b$a;", "", "", "permission", "Lkotlin/f1;", "c", "([Ljava/lang/String;)V", "a", "b", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.base.v2.common.ext.g$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C3942a implements RequestPermission.InterfaceC15268a {

            /* renamed from: a */
            final /* synthetic */ FragmentActivity f15061a;

            /* renamed from: b */
            final /* synthetic */ FragmentActivity f15062b;

            /* renamed from: c */
            final /* synthetic */ InterfaceC15269a<Unit> f15063c;

            C3942a(FragmentActivity fragmentActivity, FragmentActivity fragmentActivity2, InterfaceC15269a<Unit> interfaceC15269a) {
                this.f15061a = fragmentActivity;
                this.f15062b = fragmentActivity2;
                this.f15063c = interfaceC15269a;
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: a */
            public void mo3478a(@NotNull String[] permission) {
                C14342f0.m8184p(permission, "permission");
                PermissionExt.m43832l(this.f15061a, this.f15062b, this.f15063c);
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: b */
            public void mo3477b() {
                this.f15063c.invoke();
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: c */
            public void mo3476c(@NotNull String[] permission) {
                C14342f0.m8184p(permission, "permission");
                PermissionExt.m43832l(this.f15061a, this.f15062b, this.f15063c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3941a(FragmentActivity fragmentActivity, InterfaceC15269a<Unit> interfaceC15269a, FragmentActivity fragmentActivity2) {
            super(1);
            this.f15058a = fragmentActivity;
            this.f15059b = interfaceC15269a;
            this.f15060c = fragmentActivity2;
        }

        /* renamed from: a */
        public final void m43831a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            if (Build.VERSION.SDK_INT >= 29) {
                new RequestPermission(this.f15058a).m3480c("android.permission.ACCESS_BACKGROUND_LOCATION").m3479d(new C3942a(this.f15058a, this.f15060c, this.f15059b));
            } else {
                this.f15059b.invoke();
            }
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m43831a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionExt.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.ext.g$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3943b extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        final /* synthetic */ FragmentActivity f15064a;

        /* renamed from: b */
        final /* synthetic */ FragmentActivity f15065b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15269a<Unit> f15066c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3943b(FragmentActivity fragmentActivity, FragmentActivity fragmentActivity2, InterfaceC15269a<Unit> interfaceC15269a) {
            super(1);
            this.f15064a = fragmentActivity;
            this.f15065b = fragmentActivity2;
            this.f15066c = interfaceC15269a;
        }

        /* renamed from: a */
        public final void m43830a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            PermissionExt.m43832l(this.f15064a, this.f15065b, this.f15066c);
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m43830a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionExt.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.ext.g$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3944c extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        final /* synthetic */ FragmentActivity f15067a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15269a<Unit> f15068b;

        /* renamed from: c */
        final /* synthetic */ String f15069c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC15269a<Unit> f15070d;

        /* compiled from: PermissionExt.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J#\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, m12616d2 = {"com/bxkj/base/v2/common/ext/g$c$a", "Ll/b$a;", "Lkotlin/f1;", "b", "", "", "permission", "c", "([Ljava/lang/String;)V", "a", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.base.v2.common.ext.g$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C3945a implements RequestPermission.InterfaceC15268a {

            /* renamed from: a */
            final /* synthetic */ InterfaceC15269a<Unit> f15071a;

            /* renamed from: b */
            final /* synthetic */ FragmentActivity f15072b;

            /* renamed from: c */
            final /* synthetic */ String f15073c;

            /* renamed from: d */
            final /* synthetic */ InterfaceC15269a<Unit> f15074d;

            C3945a(InterfaceC15269a<Unit> interfaceC15269a, FragmentActivity fragmentActivity, String str, InterfaceC15269a<Unit> interfaceC15269a2) {
                this.f15071a = interfaceC15269a;
                this.f15072b = fragmentActivity;
                this.f15073c = str;
                this.f15074d = interfaceC15269a2;
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: a */
            public void mo3478a(@NotNull String... permission) {
                C14342f0.m8184p(permission, "permission");
                ContextExt.m43851m(this.f15072b, this.f15073c);
                InterfaceC15269a<Unit> interfaceC15269a = this.f15074d;
                if (interfaceC15269a == null) {
                    return;
                }
                interfaceC15269a.invoke();
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: b */
            public void mo3477b() {
                this.f15071a.invoke();
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: c */
            public void mo3476c(@NotNull String... permission) {
                C14342f0.m8184p(permission, "permission");
                ContextExt.m43851m(this.f15072b, this.f15073c);
                InterfaceC15269a<Unit> interfaceC15269a = this.f15074d;
                if (interfaceC15269a == null) {
                    return;
                }
                interfaceC15269a.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3944c(FragmentActivity fragmentActivity, InterfaceC15269a<Unit> interfaceC15269a, String str, InterfaceC15269a<Unit> interfaceC15269a2) {
            super(1);
            this.f15067a = fragmentActivity;
            this.f15068b = interfaceC15269a;
            this.f15069c = str;
            this.f15070d = interfaceC15269a2;
        }

        /* renamed from: a */
        public final void m43829a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            new RequestPermission(this.f15067a).m3480c("android.permission.CAMERA").m3479d(new C3945a(this.f15068b, this.f15067a, this.f15069c, this.f15070d));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m43829a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionExt.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.ext.g$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3946d extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        final /* synthetic */ FragmentActivity f15075a;

        /* renamed from: b */
        final /* synthetic */ String f15076b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15269a<Unit> f15077c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3946d(FragmentActivity fragmentActivity, String str, InterfaceC15269a<Unit> interfaceC15269a) {
            super(1);
            this.f15075a = fragmentActivity;
            this.f15076b = str;
            this.f15077c = interfaceC15269a;
        }

        /* renamed from: a */
        public final void m43828a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            ContextExt.m43851m(this.f15075a, this.f15076b);
            InterfaceC15269a<Unit> interfaceC15269a = this.f15077c;
            if (interfaceC15269a == null) {
                return;
            }
            interfaceC15269a.invoke();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m43828a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionExt.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.ext.g$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3947e extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        final /* synthetic */ FragmentActivity f15078a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15269a<Unit> f15079b;

        /* renamed from: c */
        final /* synthetic */ String f15080c;

        /* compiled from: PermissionExt.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J#\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, m12616d2 = {"com/bxkj/base/v2/common/ext/g$e$a", "Ll/b$a;", "Lkotlin/f1;", "b", "", "", "permission", "c", "([Ljava/lang/String;)V", "a", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.base.v2.common.ext.g$e$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C3948a implements RequestPermission.InterfaceC15268a {

            /* renamed from: a */
            final /* synthetic */ InterfaceC15269a<Unit> f15081a;

            /* renamed from: b */
            final /* synthetic */ FragmentActivity f15082b;

            /* renamed from: c */
            final /* synthetic */ String f15083c;

            C3948a(InterfaceC15269a<Unit> interfaceC15269a, FragmentActivity fragmentActivity, String str) {
                this.f15081a = interfaceC15269a;
                this.f15082b = fragmentActivity;
                this.f15083c = str;
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: a */
            public void mo3478a(@NotNull String... permission) {
                C14342f0.m8184p(permission, "permission");
                ContextExt.m43851m(this.f15082b, this.f15083c);
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: b */
            public void mo3477b() {
                this.f15081a.invoke();
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: c */
            public void mo3476c(@NotNull String... permission) {
                C14342f0.m8184p(permission, "permission");
                ContextExt.m43851m(this.f15082b, this.f15083c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3947e(FragmentActivity fragmentActivity, InterfaceC15269a<Unit> interfaceC15269a, String str) {
            super(1);
            this.f15078a = fragmentActivity;
            this.f15079b = interfaceC15269a;
            this.f15080c = str;
        }

        /* renamed from: a */
        public final void m43827a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            new RequestPermission(this.f15078a).m3480c(C7282g.f24951i).m3479d(new C3948a(this.f15079b, this.f15078a, this.f15080c));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m43827a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionExt.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.ext.g$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3949f extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        final /* synthetic */ FragmentActivity f15084a;

        /* renamed from: b */
        final /* synthetic */ String f15085b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3949f(FragmentActivity fragmentActivity, String str) {
            super(1);
            this.f15084a = fragmentActivity;
            this.f15085b = str;
        }

        /* renamed from: a */
        public final void m43826a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            ContextExt.m43851m(this.f15084a, this.f15085b);
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m43826a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionExt.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.ext.g$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3950g extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        final /* synthetic */ FragmentActivity f15086a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC15269a<Unit> f15087b;

        /* compiled from: PermissionExt.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/base/v2/common/ext/g$g$a", "Ll/b$a;", "", "", "permission", "Lkotlin/f1;", "c", "([Ljava/lang/String;)V", "a", "b", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.base.v2.common.ext.g$g$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C3951a implements RequestPermission.InterfaceC15268a {

            /* renamed from: a */
            final /* synthetic */ FragmentActivity f15088a;

            /* renamed from: b */
            final /* synthetic */ InterfaceC15269a<Unit> f15089b;

            C3951a(FragmentActivity fragmentActivity, InterfaceC15269a<Unit> interfaceC15269a) {
                this.f15088a = fragmentActivity;
                this.f15089b = interfaceC15269a;
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: a */
            public void mo3478a(@NotNull String[] permission) {
                C14342f0.m8184p(permission, "permission");
                ContextExt.m43851m(this.f15088a, "你拒绝了定位权限无法定位");
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: b */
            public void mo3477b() {
                this.f15089b.invoke();
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: c */
            public void mo3476c(@NotNull String[] permission) {
                C14342f0.m8184p(permission, "permission");
                ContextExt.m43851m(this.f15088a, "你拒绝了定位权限无法定位");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3950g(FragmentActivity fragmentActivity, InterfaceC15269a<Unit> interfaceC15269a) {
            super(1);
            this.f15086a = fragmentActivity;
            this.f15087b = interfaceC15269a;
        }

        /* renamed from: a */
        public final void m43825a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            new RequestPermission(this.f15086a).m3480c(C7282g.f24950h, C7282g.f24949g).m3479d(new C3951a(this.f15086a, this.f15087b));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m43825a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionExt.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.ext.g$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3952h extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        public static final C3952h f15090a = new C3952h();

        C3952h() {
            super(1);
        }

        /* renamed from: a */
        public final void m43824a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m43824a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionExt.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.ext.g$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3953i extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        final /* synthetic */ FragmentActivity f15091a;

        /* renamed from: b */
        final /* synthetic */ String[] f15092b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15269a<Unit> f15093c;

        /* renamed from: d */
        final /* synthetic */ String f15094d;

        /* compiled from: PermissionExt.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J#\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, m12616d2 = {"com/bxkj/base/v2/common/ext/g$i$a", "Ll/b$a;", "Lkotlin/f1;", "b", "", "", "permission", "c", "([Ljava/lang/String;)V", "a", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.base.v2.common.ext.g$i$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C3954a implements RequestPermission.InterfaceC15268a {

            /* renamed from: a */
            final /* synthetic */ InterfaceC15269a<Unit> f15095a;

            /* renamed from: b */
            final /* synthetic */ FragmentActivity f15096b;

            /* renamed from: c */
            final /* synthetic */ String f15097c;

            C3954a(InterfaceC15269a<Unit> interfaceC15269a, FragmentActivity fragmentActivity, String str) {
                this.f15095a = interfaceC15269a;
                this.f15096b = fragmentActivity;
                this.f15097c = str;
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: a */
            public void mo3478a(@NotNull String... permission) {
                C14342f0.m8184p(permission, "permission");
                ContextExt.m43851m(this.f15096b, this.f15097c);
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: b */
            public void mo3477b() {
                this.f15095a.invoke();
            }

            @Override // p615l.RequestPermission.InterfaceC15268a
            /* renamed from: c */
            public void mo3476c(@NotNull String... permission) {
                C14342f0.m8184p(permission, "permission");
                ContextExt.m43851m(this.f15096b, this.f15097c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3953i(FragmentActivity fragmentActivity, String[] strArr, InterfaceC15269a<Unit> interfaceC15269a, String str) {
            super(1);
            this.f15091a = fragmentActivity;
            this.f15092b = strArr;
            this.f15093c = interfaceC15269a;
            this.f15094d = str;
        }

        /* renamed from: a */
        public final void m43823a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            RequestPermission requestPermission = new RequestPermission(this.f15091a);
            String[] strArr = this.f15092b;
            requestPermission.m3480c((String[]) Arrays.copyOf(strArr, strArr.length)).m3479d(new C3954a(this.f15093c, this.f15091a, this.f15094d));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m43823a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionExt.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.ext.g$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3955j extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        final /* synthetic */ FragmentActivity f15098a;

        /* renamed from: b */
        final /* synthetic */ String f15099b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3955j(FragmentActivity fragmentActivity, String str) {
            super(1);
            this.f15098a = fragmentActivity;
            this.f15099b = str;
        }

        /* renamed from: a */
        public final void m43822a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            ContextExt.m43851m(this.f15098a, this.f15099b);
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m43822a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionExt.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.common.ext.g$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3956k extends Lambda implements InterfaceC15280l<iOSTwoButtonDialog, Unit> {

        /* renamed from: a */
        final /* synthetic */ FragmentActivity f15100a;

        /* renamed from: b */
        final /* synthetic */ FragmentActivity f15101b;

        /* renamed from: c */
        final /* synthetic */ InterfaceC15269a<Unit> f15102c;

        /* compiled from: PermissionExt.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, m12616d2 = {"com/bxkj/base/v2/common/ext/g$k$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.base.v2.common.ext.g$k$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C3957a implements StartActivityForResult.InterfaceC15293a {

            /* renamed from: a */
            final /* synthetic */ FragmentActivity f15103a;

            /* renamed from: b */
            final /* synthetic */ InterfaceC15269a<Unit> f15104b;

            C3957a(FragmentActivity fragmentActivity, InterfaceC15269a<Unit> interfaceC15269a) {
                this.f15103a = fragmentActivity;
                this.f15104b = interfaceC15269a;
            }

            @Override // p618m.StartActivityForResult.InterfaceC15293a
            /* renamed from: a */
            public void mo3459a(int i, @Nullable Intent intent) {
                PermissionExt.m43842b(this.f15103a, this.f15104b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C3956k(FragmentActivity fragmentActivity, FragmentActivity fragmentActivity2, InterfaceC15269a<Unit> interfaceC15269a) {
            super(1);
            this.f15100a = fragmentActivity;
            this.f15101b = fragmentActivity2;
            this.f15102c = interfaceC15269a;
        }

        /* renamed from: a */
        public final void m43821a(@NotNull iOSTwoButtonDialog it) {
            C14342f0.m8184p(it, "it");
            C3912s.m44033p(this.f15100a, new C3957a(this.f15101b, this.f15102c));
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(iOSTwoButtonDialog iostwobuttondialog) {
            m43821a(iostwobuttondialog);
            return Unit.f41048a;
        }
    }

    /* renamed from: b */
    public static final void m43842b(@NotNull FragmentActivity fragmentActivity, @NotNull InterfaceC15269a<Unit> agree) {
        C14342f0.m8184p(fragmentActivity, "<this>");
        C14342f0.m8184p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
            agree.invoke();
        } else {
            ContextExt.m43857g(fragmentActivity, "始终允许定位", "是否允许应用始终允许定位,便于APP锁屏后继续记录跑步轨迹", new C3941a(fragmentActivity, agree, fragmentActivity), new C3943b(fragmentActivity, fragmentActivity, agree), "拒绝", "同意并使用");
        }
    }

    /* renamed from: c */
    public static final void m43841c(@NotNull FragmentActivity fragmentActivity, @Nullable String str, @NotNull InterfaceC15269a<Unit> agree) {
        C14342f0.m8184p(fragmentActivity, "<this>");
        C14342f0.m8184p(agree, "agree");
        m43840d(fragmentActivity, str, agree, null);
    }

    /* renamed from: d */
    public static final void m43840d(@NotNull FragmentActivity fragmentActivity, @Nullable String str, @NotNull InterfaceC15269a<Unit> agree, @Nullable InterfaceC15269a<Unit> interfaceC15269a) {
        C14342f0.m8184p(fragmentActivity, "<this>");
        C14342f0.m8184p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.CAMERA") == 0) {
            agree.invoke();
            return;
        }
        String str2 = "您拒绝了摄像头权限，无法使用" + ((Object) str) + "功能，请在【设置->应用—>体适能->权限管理->摄像头】设置允许后再进行操作";
        ContextExt.m43857g(fragmentActivity, str, C14342f0.m8216C("是否允许访问摄像头，便于", str), new C3944c(fragmentActivity, agree, str2, interfaceC15269a), new C3946d(fragmentActivity, str2, interfaceC15269a), "拒绝", "同意并使用");
    }

    /* renamed from: e */
    public static /* synthetic */ void m43839e(FragmentActivity fragmentActivity, String str, InterfaceC15269a interfaceC15269a, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "拍照";
        }
        m43841c(fragmentActivity, str, interfaceC15269a);
    }

    /* renamed from: f */
    public static /* synthetic */ void m43838f(FragmentActivity fragmentActivity, String str, InterfaceC15269a interfaceC15269a, InterfaceC15269a interfaceC15269a2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "拍照";
        }
        if ((i & 4) != 0) {
            interfaceC15269a2 = null;
        }
        m43840d(fragmentActivity, str, interfaceC15269a, interfaceC15269a2);
    }

    /* renamed from: g */
    public static final void m43837g(@NotNull FragmentActivity fragmentActivity, @Nullable String str, @NotNull InterfaceC15269a<Unit> agree) {
        C14342f0.m8184p(fragmentActivity, "<this>");
        C14342f0.m8184p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, C7282g.f24951i) == 0) {
            agree.invoke();
            return;
        }
        String str2 = "您拒绝了访问存储空间权限，无法使用" + ((Object) str) + "功能，请在【设置->应用—>体适能->权限管理->存储空间】设置允许后再进行操作";
        ContextExt.m43857g(fragmentActivity, str, C14342f0.m8216C("是否允许访问存储空间，便于获取", str), new C3947e(fragmentActivity, agree, str2), new C3949f(fragmentActivity, str2), "拒绝", "同意并使用");
    }

    /* renamed from: h */
    public static /* synthetic */ void m43836h(FragmentActivity fragmentActivity, String str, InterfaceC15269a interfaceC15269a, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "相册";
        }
        m43837g(fragmentActivity, str, interfaceC15269a);
    }

    /* renamed from: i */
    public static final void m43835i(@NotNull FragmentActivity fragmentActivity, @NotNull InterfaceC15269a<Unit> agree) {
        C14342f0.m8184p(fragmentActivity, "<this>");
        C14342f0.m8184p(agree, "agree");
        if (ContextCompat.checkSelfPermission(fragmentActivity, C7282g.f24950h) == 0 && ContextCompat.checkSelfPermission(fragmentActivity, C7282g.f24949g) == 0) {
            agree.invoke();
        } else {
            ContextExt.m43857g(fragmentActivity, "定位", "是否允许访问定位,便于记录跑步轨迹", new C3950g(fragmentActivity, agree), C3952h.f15090a, "拒绝", "同意并使用");
        }
    }

    /* renamed from: j */
    public static final void m43834j(@NotNull FragmentActivity fragmentActivity, @Nullable String str, @NotNull InterfaceC15269a<Unit> agree) {
        C14342f0.m8184p(fragmentActivity, "<this>");
        C14342f0.m8184p(agree, "agree");
        String[] strArr = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO", C7282g.f24951i};
        if (ContextCompat.checkSelfPermission(fragmentActivity, C7282g.f24951i) == 0 && ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.CAMERA") == 0 && ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.RECORD_AUDIO") == 0) {
            agree.invoke();
            return;
        }
        String str2 = "您拒绝了摄像头、录音、访问存储空间权限，无法使用" + ((Object) str) + "功能，请在【设置->应用—>体适能->权限管理->摄像头、录音、存储空间】设置允许后再进行操作";
        ContextExt.m43857g(fragmentActivity, str, C14342f0.m8216C("是否允许摄像头、录音、访问存储空间，便于", str), new C3953i(fragmentActivity, strArr, agree, str2), new C3955j(fragmentActivity, str2), "拒绝", "同意并使用");
    }

    /* renamed from: k */
    public static /* synthetic */ void m43833k(FragmentActivity fragmentActivity, String str, InterfaceC15269a interfaceC15269a, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "录制视频";
        }
        m43834j(fragmentActivity, str, interfaceC15269a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static final void m43832l(FragmentActivity fragmentActivity, FragmentActivity fragmentActivity2, InterfaceC15269a<Unit> interfaceC15269a) {
        ContextExt.m43856h(fragmentActivity, "权限提示", "为了正常记录你的运动数据，需要你将【体适能】APP的【权限设置】中的【位置信息】设置为【始终允许】后再开始跑步。", new C3956k(fragmentActivity2, fragmentActivity, interfaceC15269a), null, null, "去设置", 24, null);
    }
}
