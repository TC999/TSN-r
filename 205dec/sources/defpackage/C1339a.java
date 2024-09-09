package defpackage;

import android.app.IActivityController;
import android.content.Intent;
import android.net.Uri;
import android.os.ServiceManager;
import android.util.Log;
import android.webkit.ValueCallback;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import m.b;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7502512.dex
 */
/* renamed from: a  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final /* synthetic */ class C1339a implements InvocationHandler {

    /* compiled from: CustomWebChromeClient.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"a$a", "Lm/b$a;", "", "resultCode", "Landroid/content/Intent;", "data", "Lkotlin/f1;", "a", "base_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class C0006a implements b.a {
        C0006a() {
        }

        @Override // m.b.a
        public void a(int i4, @Nullable Intent intent) {
            if (C1339a.a(C1339a.this) == null && C1339a.b(C1339a.this) == null) {
                return;
            }
            Uri data = (intent == null || i4 != -1) ? null : intent.getData();
            if (C1339a.b(C1339a.this) != null) {
                C1339a.c(C1339a.this, i4, intent);
            } else if (C1339a.a(C1339a.this) != null) {
                ValueCallback a4 = C1339a.a(C1339a.this);
                f0.m(a4);
                a4.onReceiveValue(data);
                C1339a.d(C1339a.this, null);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [c, android.app.IActivityController$Stub] */
    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if (method.getName().equals("setActivityController")) {
            try {
                IActivityController$StubC1343c.f1464e = (IActivityController) objArr[0];
                if (IActivityController$StubC1343c.f1465f == null) {
                    IActivityController$StubC1343c.f1465f = new IActivityController.Stub();
                }
                objArr[0] = IActivityController$StubC1343c.f1465f;
            } catch (Throwable th) {
                Log.e("LSPosed Bridge", "replace activity controller", th);
            }
        }
        return method.invoke(ServiceManager.getService("activity"), objArr);
    }
}
