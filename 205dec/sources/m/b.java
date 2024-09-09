package m;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bjtsn.dylan.startactivityforresult.EventDispatcherFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: StartActivityForResult.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\bB\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0016"}, d2 = {"Lm/b;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/bjtsn/dylan/startactivityforresult/EventDispatcherFragment;", "b", "manager", "Landroidx/fragment/app/Fragment;", "a", "Landroid/content/Intent;", "intent", "startActivityForResult", "Lm/b$a;", "callBack", "Lkotlin/f1;", "c", "Landroidx/fragment/app/FragmentActivity;", "activity", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "fragment", "(Landroidx/fragment/app/Fragment;)V", "startActivityForResult_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private EventDispatcherFragment f60820a;

    /* renamed from: b  reason: collision with root package name */
    private final String f60821b;

    /* renamed from: c  reason: collision with root package name */
    private Intent f60822c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: StartActivityForResult.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lm/b$a;", "", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "startActivityForResult_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface a {
        void a(int i4, @Nullable Intent intent);
    }

    public b(@NotNull FragmentActivity activity) {
        f0.p(activity, "activity");
        this.f60821b = "START_ACTIVITY_FOR_RESULT_DISPATCHER_FRAGMENT";
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        f0.o(supportFragmentManager, "activity.supportFragmentManager");
        this.f60820a = b(supportFragmentManager);
    }

    private final Fragment a(FragmentManager fragmentManager) {
        return fragmentManager.findFragmentByTag(this.f60821b);
    }

    private final EventDispatcherFragment b(FragmentManager fragmentManager) {
        Fragment a4 = a(fragmentManager);
        if (a4 == null) {
            a4 = new EventDispatcherFragment();
            fragmentManager.beginTransaction().add(a4, this.f60821b).commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return (EventDispatcherFragment) a4;
    }

    public final void c(@NotNull a callBack) {
        f0.p(callBack, "callBack");
        EventDispatcherFragment eventDispatcherFragment = this.f60820a;
        Intent intent = this.f60822c;
        if (intent == null) {
            f0.S("intent");
        }
        eventDispatcherFragment.startActivityForResult(intent, callBack);
    }

    @NotNull
    public final b startActivityForResult(@NotNull Intent intent) {
        f0.p(intent, "intent");
        this.f60822c = intent;
        return this;
    }

    public b(@NotNull Fragment fragment) {
        f0.p(fragment, "fragment");
        this.f60821b = "START_ACTIVITY_FOR_RESULT_DISPATCHER_FRAGMENT";
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        f0.o(childFragmentManager, "fragment.childFragmentManager");
        this.f60820a = b(childFragmentManager);
    }
}
