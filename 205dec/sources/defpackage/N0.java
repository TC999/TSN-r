package defpackage;

import android.app.ActivityThread;
import android.content.SharedPreferences;
import android.util.ArrayMap;
import java.util.function.Consumer;
import ulL.WeEFDVoZmmWVmW.yXd.XposedInit;

/* renamed from: N0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final /* synthetic */ class N0 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f46a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f47b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f48c;

    public /* synthetic */ N0(Object obj, Object obj2, int i4) {
        this.f46a = i4;
        this.f47b = obj;
        this.f48c = obj2;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i4 = this.f46a;
        Object obj2 = this.f48c;
        Object obj3 = this.f47b;
        switch (i4) {
            case 0:
                XposedInit.lambda$loadModules$1((ActivityThread) obj3, (ArrayMap) obj2, (u0) obj);
                return;
            default:
                ((SharedPreferences.OnSharedPreferenceChangeListener) obj).onSharedPreferenceChanged(((BinderC1342b0) obj3).f241a, (String) obj2);
                return;
        }
    }
}
