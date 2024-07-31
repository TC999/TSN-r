package p618m;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bjtsn.dylan.startactivityforresult.EventDispatcherFragment;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\bB\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¨\u0006\u0016"}, m12616d2 = {"Lm/b;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/bjtsn/dylan/startactivityforresult/EventDispatcherFragment;", "b", "manager", "Landroidx/fragment/app/Fragment;", "a", "Landroid/content/Intent;", "intent", "startActivityForResult", "Lm/b$a;", "callBack", "Lkotlin/f1;", "c", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "fragment", "(Landroidx/fragment/app/Fragment;)V", "startActivityForResult_debug"}, m12615k = 1, m12614mv = {1, 4, 2})
/* renamed from: m.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class StartActivityForResult {

    /* renamed from: a */
    private EventDispatcherFragment f43488a;

    /* renamed from: b */
    private final String f43489b;

    /* renamed from: c */
    private Intent f43490c;

    /* compiled from: StartActivityForResult.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\b"}, m12616d2 = {"Lm/b$a;", "", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "startActivityForResult_debug"}, m12615k = 1, m12614mv = {1, 4, 2})
    /* renamed from: m.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC15293a {
        /* renamed from: a */
        void mo3459a(int i, @Nullable Intent intent);
    }

    public StartActivityForResult(@NotNull FragmentActivity activity) {
        C14342f0.m8184p(activity, "activity");
        this.f43489b = "START_ACTIVITY_FOR_RESULT_DISPATCHER_FRAGMENT";
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        C14342f0.m8185o(supportFragmentManager, "activity.supportFragmentManager");
        this.f43488a = m3461b(supportFragmentManager);
    }

    /* renamed from: a */
    private final Fragment m3462a(FragmentManager fragmentManager) {
        return fragmentManager.findFragmentByTag(this.f43489b);
    }

    /* renamed from: b */
    private final EventDispatcherFragment m3461b(FragmentManager fragmentManager) {
        Fragment m3462a = m3462a(fragmentManager);
        if (m3462a == null) {
            m3462a = new EventDispatcherFragment();
            fragmentManager.beginTransaction().add(m3462a, this.f43489b).commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return (EventDispatcherFragment) m3462a;
    }

    /* renamed from: c */
    public final void m3460c(@NotNull InterfaceC15293a callBack) {
        C14342f0.m8184p(callBack, "callBack");
        EventDispatcherFragment eventDispatcherFragment = this.f43488a;
        Intent intent = this.f43490c;
        if (intent == null) {
            C14342f0.m8200S("intent");
        }
        eventDispatcherFragment.startActivityForResult(intent, callBack);
    }

    @NotNull
    public final StartActivityForResult startActivityForResult(@NotNull Intent intent) {
        C14342f0.m8184p(intent, "intent");
        this.f43490c = intent;
        return this;
    }

    public StartActivityForResult(@NotNull Fragment fragment) {
        C14342f0.m8184p(fragment, "fragment");
        this.f43489b = "START_ACTIVITY_FOR_RESULT_DISPATCHER_FRAGMENT";
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        C14342f0.m8185o(childFragmentManager, "fragment.childFragmentManager");
        this.f43488a = m3461b(childFragmentManager);
    }
}
