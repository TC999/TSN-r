package l;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bjtsn.dylan.requestpermission.PermissionDispatcherFragment;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RequestPermission.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0012\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\u000b\u001a\u00020\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0016"}, d2 = {"Ll/b;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/bjtsn/dylan/requestpermission/PermissionDispatcherFragment;", "b", "Landroidx/fragment/app/Fragment;", "a", "", "", TTDelegateActivity.INTENT_PERMISSIONS, "c", "([Ljava/lang/String;)Ll/b;", "Ll/b$a;", "permissionCheckCallBack", "d", "Landroidx/fragment/app/FragmentActivity;", "activity", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "fragment", "(Landroidx/fragment/app/Fragment;)V", "requestPermission_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f60785a;

    /* renamed from: b  reason: collision with root package name */
    private PermissionDispatcherFragment f60786b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f60787c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RequestPermission.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u001f\u0010\u0007\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H&\u00a2\u0006\u0004\b\t\u0010\b\u00a8\u0006\n"}, d2 = {"Ll/b$a;", "", "Lkotlin/f1;", "b", "", "", "permission", "c", "([Ljava/lang/String;)V", "a", "requestPermission_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface a {
        void a(@NotNull String[] strArr);

        void b();

        void c(@NotNull String[] strArr);
    }

    public b(@NotNull FragmentActivity activity) {
        f0.p(activity, "activity");
        this.f60785a = "REQUEST_PERMISSION_FRAGMENT";
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        f0.o(supportFragmentManager, "activity.supportFragmentManager");
        this.f60786b = b(supportFragmentManager);
    }

    private final Fragment a(FragmentManager fragmentManager) {
        return fragmentManager.findFragmentByTag(this.f60785a);
    }

    private final PermissionDispatcherFragment b(FragmentManager fragmentManager) {
        Fragment a4 = a(fragmentManager);
        if (a4 == null) {
            a4 = new PermissionDispatcherFragment();
            fragmentManager.beginTransaction().add(a4, this.f60785a).commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return (PermissionDispatcherFragment) a4;
    }

    @NotNull
    public final b c(@NotNull String... strArr) {
        f0.p(strArr, TTDelegateActivity.INTENT_PERMISSIONS);
        this.f60787c = strArr;
        return this;
    }

    @NotNull
    public final b d(@NotNull a permissionCheckCallBack) {
        f0.p(permissionCheckCallBack, "permissionCheckCallBack");
        PermissionDispatcherFragment permissionDispatcherFragment = this.f60786b;
        String[] strArr = this.f60787c;
        if (strArr == null) {
            f0.S(TTDelegateActivity.INTENT_PERMISSIONS);
        }
        permissionDispatcherFragment.requestPermissions(strArr, permissionCheckCallBack);
        return this;
    }

    public b(@NotNull Fragment fragment) {
        f0.p(fragment, "fragment");
        this.f60785a = "REQUEST_PERMISSION_FRAGMENT";
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        f0.o(childFragmentManager, "fragment.childFragmentManager");
        this.f60786b = b(childFragmentManager);
    }
}
