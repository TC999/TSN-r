package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.RomUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class PermissionsManager {

    /* renamed from: d */
    private static final String f311d = "e";

    /* renamed from: e */
    private static PermissionsManager f312e;

    /* renamed from: a */
    private final Set<String> f313a = new HashSet(1);

    /* renamed from: b */
    private final List<WeakReference<PermissionsResultAction>> f314b = new ArrayList(1);

    /* renamed from: c */
    private final List<PermissionsResultAction> f315c = new ArrayList(1);

    private PermissionsManager() {
        m59817b();
    }

    /* renamed from: a */
    public static PermissionsManager m59824a() {
        if (f312e == null) {
            f312e = new PermissionsManager();
        }
        return f312e;
    }

    /* renamed from: b */
    private synchronized void m59817b() {
        for (Field field : Manifest.permission.class.getFields()) {
            String str = null;
            try {
                str = (String) field.get("");
            } catch (IllegalAccessException e) {
                Log.e(f311d, "Could not access field", e);
            }
            this.f313a.add(str);
        }
    }

    @NonNull
    /* renamed from: c */
    private List<String> m59815c(@NonNull Activity activity, @NonNull String[] strArr, @Nullable PermissionsResultAction permissionsResultAction) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.f313a.contains(str)) {
                if (!m59821a(activity, str)) {
                    arrayList.add(str);
                } else if (permissionsResultAction != null) {
                    permissionsResultAction.m59813a(str, Permissions.GRANTED);
                }
            } else if (permissionsResultAction != null) {
                permissionsResultAction.m59813a(str, Permissions.NOT_FOUND);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private synchronized void m59819a(@NonNull String[] strArr, @Nullable PermissionsResultAction permissionsResultAction) {
        if (permissionsResultAction == null) {
            return;
        }
        permissionsResultAction.m59812a(strArr);
        this.f315c.add(permissionsResultAction);
        this.f314b.add(new WeakReference<>(permissionsResultAction));
    }

    /* renamed from: b */
    private void m59816b(@NonNull Activity activity, @NonNull String[] strArr, @Nullable PermissionsResultAction permissionsResultAction) {
        boolean m59813a;
        for (String str : strArr) {
            if (permissionsResultAction != null) {
                try {
                    if (!this.f313a.contains(str)) {
                        m59813a = permissionsResultAction.m59813a(str, Permissions.NOT_FOUND);
                    } else if (PermissionActivityCompat.m59825a(activity, str) != 0) {
                        m59813a = permissionsResultAction.m59813a(str, Permissions.DENIED);
                    } else {
                        m59813a = permissionsResultAction.m59813a(str, Permissions.GRANTED);
                    }
                    if (m59813a) {
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        m59820a(permissionsResultAction);
    }

    /* renamed from: a */
    private synchronized void m59820a(@Nullable PermissionsResultAction permissionsResultAction) {
        Iterator<WeakReference<PermissionsResultAction>> it = this.f314b.iterator();
        while (it.hasNext()) {
            WeakReference<PermissionsResultAction> next = it.next();
            if (next.get() == permissionsResultAction || next.get() == null) {
                it.remove();
            }
        }
        Iterator<PermissionsResultAction> it2 = this.f315c.iterator();
        while (it2.hasNext()) {
            if (it2.next() == permissionsResultAction) {
                it2.remove();
            }
        }
    }

    /* renamed from: a */
    public synchronized boolean m59821a(@Nullable Context context, @NonNull String str) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (RomUtils.m59138t()) {
            if (MIUIPermissionUtils.m59828b(context, str) && (PermissionActivityCompat.m59825a(context, str) == 0 || !this.f313a.contains(str))) {
                z = true;
            }
            return z;
        }
        return (PermissionActivityCompat.m59825a(context, str) == 0 || !this.f313a.contains(str)) ? true : true;
    }

    /* renamed from: a */
    public synchronized void m59823a(@Nullable Activity activity, @NonNull String[] strArr, @Nullable PermissionsResultAction permissionsResultAction) {
        if (activity == null) {
            return;
        }
        try {
            m59819a(strArr, permissionsResultAction);
            if (Build.VERSION.SDK_INT < 23) {
                m59816b(activity, strArr, permissionsResultAction);
            } else {
                List<String> m59815c = m59815c(activity, strArr, permissionsResultAction);
                if (m59815c.isEmpty()) {
                    m59820a(permissionsResultAction);
                } else {
                    PermissionActivityCompat.m59826a(activity, (String[]) m59815c.toArray(new String[m59815c.size()]), 1);
                }
            }
        } finally {
        }
    }

    /* renamed from: a */
    public synchronized void m59822a(@NonNull Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (RomUtils.m59138t() && !MIUIPermissionUtils.m59828b(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            m59818a(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m59818a(@NonNull String[] strArr, @NonNull int[] iArr, String[] strArr2) {
        int i;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<PermissionsResultAction>> it = this.f314b.iterator();
            while (it.hasNext()) {
                PermissionsResultAction permissionsResultAction = it.next().get();
                while (i < length) {
                    i = (permissionsResultAction == null || permissionsResultAction.m59814a(strArr[i], iArr[i])) ? 0 : i + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<PermissionsResultAction> it2 = this.f315c.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
