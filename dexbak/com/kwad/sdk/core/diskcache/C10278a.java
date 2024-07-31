package com.kwad.sdk.core.diskcache;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.kwad.sdk.C9774c;
import com.kwad.sdk.InterfaceC10750d;
import com.kwad.sdk.core.C9882a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11031aw;
import com.kwad.sdk.utils.C11095g;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.kwad.sdk.core.diskcache.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10278a {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static PackageInfo m26450a(Context context, File file) {
        if (file != null && file.exists()) {
            try {
                if (file.exists() & (!file.isDirectory())) {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getPath(), 65);
                    if (packageManager.getPackageInfo(packageArchiveInfo.packageName, 1) != null) {
                        return null;
                    }
                    return packageArchiveInfo;
                }
            } catch (Exception e) {
                C10331c.printStackTrace(e);
            }
        }
        return null;
    }

    /* renamed from: aU */
    public static void m26449aU(final Context context) {
        C11095g.schedule(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.diskcache.a.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                InterfaceC10750d m27788xN;
                synchronized (C10278a.class) {
                    File m23995cL = C11031aw.m23995cL(context);
                    if (m23995cL.exists()) {
                        for (File file : C10278a.m26447n(m23995cL)) {
                            if (file.getName().endsWith(".apk") && C9882a.m27460Bc().m27458cT(file.getAbsolutePath()) != null && C10278a.m26450a(context, file) != null && (m27788xN = C9774c.m27790xL().m27788xN()) != null) {
                                m27788xN.mo24933g(file);
                            }
                        }
                    }
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static List<File> m26447n(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        m26445v(arrayList);
        return arrayList;
    }

    /* renamed from: v */
    private static void m26445v(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.a.2
            /* renamed from: c */
            private static int m26444c(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return m26444c(file, file2);
            }
        });
    }
}
