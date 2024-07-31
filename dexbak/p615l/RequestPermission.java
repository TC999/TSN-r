package p615l;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bjtsn.dylan.requestpermission.PermissionDispatcherFragment;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\u000b\u001a\u00020\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u0016"}, m12616d2 = {"Ll/b;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/bjtsn/dylan/requestpermission/PermissionDispatcherFragment;", "b", "Landroidx/fragment/app/Fragment;", "a", "", "", TTDelegateActivity.INTENT_PERMISSIONS, "c", "([Ljava/lang/String;)Ll/b;", "Ll/b$a;", "permissionCheckCallBack", "d", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "fragment", "(Landroidx/fragment/app/Fragment;)V", "requestPermission_debug"}, m12615k = 1, m12614mv = {1, 4, 2})
/* renamed from: l.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class RequestPermission {

    /* renamed from: a */
    private final String f43468a;

    /* renamed from: b */
    private PermissionDispatcherFragment f43469b;

    /* renamed from: c */
    private String[] f43470c;

    /* compiled from: RequestPermission.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u001f\u0010\u0007\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, m12616d2 = {"Ll/b$a;", "", "Lkotlin/f1;", "b", "", "", "permission", "c", "([Ljava/lang/String;)V", "a", "requestPermission_debug"}, m12615k = 1, m12614mv = {1, 4, 2})
    /* renamed from: l.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC15268a {
        /* renamed from: a */
        void mo3478a(@NotNull String[] strArr);

        /* renamed from: b */
        void mo3477b();

        /* renamed from: c */
        void mo3476c(@NotNull String[] strArr);
    }

    public RequestPermission(@NotNull FragmentActivity activity) {
        C14342f0.m8184p(activity, "activity");
        this.f43468a = "REQUEST_PERMISSION_FRAGMENT";
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        C14342f0.m8185o(supportFragmentManager, "activity.supportFragmentManager");
        this.f43469b = m3481b(supportFragmentManager);
    }

    /* renamed from: a */
    private final Fragment m3482a(FragmentManager fragmentManager) {
        return fragmentManager.findFragmentByTag(this.f43468a);
    }

    /* renamed from: b */
    private final PermissionDispatcherFragment m3481b(FragmentManager fragmentManager) {
        Fragment m3482a = m3482a(fragmentManager);
        if (m3482a == null) {
            m3482a = new PermissionDispatcherFragment();
            fragmentManager.beginTransaction().add(m3482a, this.f43468a).commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return (PermissionDispatcherFragment) m3482a;
    }

    @NotNull
    /* renamed from: c */
    public final RequestPermission m3480c(@NotNull String... permissions) {
        C14342f0.m8184p(permissions, "permissions");
        this.f43470c = permissions;
        return this;
    }

    @NotNull
    /* renamed from: d */
    public final RequestPermission m3479d(@NotNull InterfaceC15268a permissionCheckCallBack) {
        C14342f0.m8184p(permissionCheckCallBack, "permissionCheckCallBack");
        PermissionDispatcherFragment permissionDispatcherFragment = this.f43469b;
        String[] strArr = this.f43470c;
        if (strArr == null) {
            C14342f0.m8200S(TTDelegateActivity.INTENT_PERMISSIONS);
        }
        permissionDispatcherFragment.requestPermissions(strArr, permissionCheckCallBack);
        return this;
    }

    public RequestPermission(@NotNull Fragment fragment) {
        C14342f0.m8184p(fragment, "fragment");
        this.f43468a = "REQUEST_PERMISSION_FRAGMENT";
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        C14342f0.m8185o(childFragmentManager, "fragment.childFragmentManager");
        this.f43469b = m3481b(childFragmentManager);
    }
}
