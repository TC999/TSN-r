package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.stub.StubApp;

/* compiled from: LibraryLoader.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final String f61877a = "pl_droidsonroids_gif";
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static Context f61878b;

    private n() {
    }

    public static void a(@NonNull Context context) {
        f61878b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        try {
            System.loadLibrary(f61877a);
        } catch (UnsatisfiedLinkError unused) {
            pl.droidsonroids.relinker.c.b(getContext(), f61877a);
        }
    }

    private static Context getContext() {
        if (f61878b == null) {
            try {
                f61878b = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e4) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e4);
            }
        }
        return f61878b;
    }
}
