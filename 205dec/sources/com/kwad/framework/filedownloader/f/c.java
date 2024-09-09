package com.kwad.framework.filedownloader.f;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwad.framework.filedownloader.exception.PathConflictException;
import com.kwad.framework.filedownloader.y;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    @SuppressLint({"StaticFieldLeak"})
    private static Context aik;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        int O(long j4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        com.kwad.framework.filedownloader.a.b be(String str);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.framework.filedownloader.f.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface InterfaceC0672c {
        com.kwad.framework.filedownloader.b.a wM();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface d {
        int f(String str, String str2, boolean z3);

        int g(String str, String str2, boolean z3);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface e {
        com.kwad.framework.filedownloader.e.a c(File file);
    }

    public static boolean a(int i4, String str, boolean z3, boolean z4) {
        if (!z3 && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.kwad.framework.filedownloader.message.e.wf().s(com.kwad.framework.filedownloader.message.f.a(i4, file, z4));
                return true;
            }
        }
        return false;
    }

    public static void am(Context context) {
        aik = context;
    }

    public static Context wL() {
        return aik;
    }

    public static boolean a(int i4, com.kwad.framework.filedownloader.d.c cVar, y yVar, boolean z3) {
        if (yVar.a(cVar)) {
            com.kwad.framework.filedownloader.message.e.wf().s(com.kwad.framework.filedownloader.message.f.a(i4, cVar.wl(), cVar.getTotal(), z3));
            return true;
        }
        return false;
    }

    public static boolean a(int i4, long j4, String str, String str2, y yVar) {
        int p3;
        if (str2 == null || str == null || (p3 = yVar.p(str, i4)) == 0) {
            return false;
        }
        com.kwad.framework.filedownloader.message.e.wf().s(com.kwad.framework.filedownloader.message.f.a(i4, j4, new PathConflictException(p3, str, str2)));
        return true;
    }
}
