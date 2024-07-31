package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class PermissionsResultAction {

    /* renamed from: c */
    private static final String f316c = "f";

    /* renamed from: a */
    private final Set<String> f317a;

    /* renamed from: b */
    private Looper f318b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.f$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC0946a implements Runnable {
        RunnableC0946a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PermissionsResultAction.this.onGranted();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.f$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC0947b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f320a;

        RunnableC0947b(String str) {
            this.f320a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            PermissionsResultAction.this.onDenied(this.f320a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.f$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC0948c implements Runnable {
        RunnableC0948c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PermissionsResultAction.this.onGranted();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.f$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class RunnableC0949d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f323a;

        RunnableC0949d(String str) {
            this.f323a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            PermissionsResultAction.this.onDenied(this.f323a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.f$e */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static /* synthetic */ class C0950e {

        /* renamed from: a */
        static final /* synthetic */ int[] f325a;

        static {
            int[] iArr = new int[Permissions.values().length];
            f325a = iArr;
            try {
                iArr[Permissions.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f325a[Permissions.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f325a[Permissions.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public PermissionsResultAction() {
        this.f317a = new HashSet(1);
        this.f318b = Looper.getMainLooper();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final synchronized boolean m59814a(@NonNull String str, int i) {
        if (i == 0) {
            return m59813a(str, Permissions.GRANTED);
        }
        return m59813a(str, Permissions.DENIED);
    }

    public abstract void onDenied(String str);

    public abstract void onGranted();

    public synchronized boolean shouldIgnorePermissionNotFound(String str) {
        String str2 = f316c;
        Log.d(str2, "Permission not found: " + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final synchronized boolean m59813a(@NonNull String str, Permissions permissions) {
        this.f317a.remove(str);
        int i = C0950e.f325a[permissions.ordinal()];
        if (i != 1) {
            if (i == 2) {
                new Handler(this.f318b).post(new RunnableC0947b(str));
                return true;
            } else if (i == 3) {
                if (shouldIgnorePermissionNotFound(str)) {
                    if (this.f317a.isEmpty()) {
                        new Handler(this.f318b).post(new RunnableC0948c());
                        return true;
                    }
                } else {
                    new Handler(this.f318b).post(new RunnableC0949d(str));
                    return true;
                }
            }
        } else if (this.f317a.isEmpty()) {
            new Handler(this.f318b).post(new RunnableC0946a());
            return true;
        }
        return false;
    }

    public PermissionsResultAction(@NonNull Looper looper) {
        this.f317a = new HashSet(1);
        Looper.getMainLooper();
        this.f318b = looper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final synchronized void m59812a(@NonNull String[] strArr) {
        Collections.addAll(this.f317a, strArr);
    }
}
