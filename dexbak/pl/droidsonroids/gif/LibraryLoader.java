package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.stub.StubApp;
import pl.droidsonroids.relinker.ReLinker;

/* renamed from: pl.droidsonroids.gif.n */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class LibraryLoader {

    /* renamed from: a */
    private static final String f44464a = "pl_droidsonroids_gif";
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b */
    private static Context f44465b;

    private LibraryLoader() {
    }

    /* renamed from: a */
    public static void m2367a(@NonNull Context context) {
        f44465b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m2366b() {
        try {
            System.loadLibrary(f44464a);
        } catch (UnsatisfiedLinkError unused) {
            ReLinker.m2357b(getContext(), f44464a);
        }
    }

    private static Context getContext() {
        if (f44465b == null) {
            try {
                f44465b = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
            }
        }
        return f44465b;
    }
}
