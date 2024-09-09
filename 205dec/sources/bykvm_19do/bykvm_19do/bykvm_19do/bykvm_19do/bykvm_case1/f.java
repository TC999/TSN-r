package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PermissionsResultAction.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class f {

    /* renamed from: c  reason: collision with root package name */
    private static final String f313c = "f";

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f314a;

    /* renamed from: b  reason: collision with root package name */
    private Looper f315b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.onGranted();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f317a;

        b(String str) {
            this.f317a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.onDenied(this.f317a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.onGranted();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f320a;

        d(String str) {
            this.f320a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.onDenied(this.f320a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f322a;

        static {
            int[] iArr = new int[bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.d.values().length];
            f322a = iArr;
            try {
                iArr[bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.d.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f322a[bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.d.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f322a[bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.d.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f() {
        this.f314a = new HashSet(1);
        this.f315b = Looper.getMainLooper();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized boolean a(@NonNull String str, int i4) {
        if (i4 == 0) {
            return a(str, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.d.GRANTED);
        }
        return a(str, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.d.DENIED);
    }

    public abstract void onDenied(String str);

    public abstract void onGranted();

    public synchronized boolean shouldIgnorePermissionNotFound(String str) {
        String str2 = f313c;
        Log.d(str2, "Permission not found: " + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized boolean a(@NonNull String str, bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.d dVar) {
        this.f314a.remove(str);
        int i4 = e.f322a[dVar.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                new Handler(this.f315b).post(new b(str));
                return true;
            } else if (i4 == 3) {
                if (shouldIgnorePermissionNotFound(str)) {
                    if (this.f314a.isEmpty()) {
                        new Handler(this.f315b).post(new c());
                        return true;
                    }
                } else {
                    new Handler(this.f315b).post(new d(str));
                    return true;
                }
            }
        } else if (this.f314a.isEmpty()) {
            new Handler(this.f315b).post(new a());
            return true;
        }
        return false;
    }

    public f(@NonNull Looper looper) {
        this.f314a = new HashSet(1);
        Looper.getMainLooper();
        this.f315b = looper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void a(@NonNull String[] strArr) {
        Collections.addAll(this.f314a, strArr);
    }
}
