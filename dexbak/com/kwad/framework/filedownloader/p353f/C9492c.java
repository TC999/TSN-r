package com.kwad.framework.filedownloader.p353f;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwad.framework.filedownloader.InterfaceC9583y;
import com.kwad.framework.filedownloader.exception.PathConflictException;
import com.kwad.framework.filedownloader.message.C9532e;
import com.kwad.framework.filedownloader.message.C9535f;
import com.kwad.framework.filedownloader.p348a.InterfaceC9432b;
import com.kwad.framework.filedownloader.p349b.InterfaceC9440a;
import com.kwad.framework.filedownloader.p351d.C9464c;
import com.kwad.framework.filedownloader.p352e.InterfaceC9480a;
import java.io.File;

/* renamed from: com.kwad.framework.filedownloader.f.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9492c {
    @SuppressLint({"StaticFieldLeak"})
    private static Context aik;

    /* renamed from: com.kwad.framework.filedownloader.f.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9493a {
        /* renamed from: O */
        int mo28543O(long j);
    }

    /* renamed from: com.kwad.framework.filedownloader.f.c$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9494b {
        /* renamed from: be */
        InterfaceC9432b mo24736be(String str);
    }

    /* renamed from: com.kwad.framework.filedownloader.f.c$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9495c {
        /* renamed from: wM */
        InterfaceC9440a m28542wM();
    }

    /* renamed from: com.kwad.framework.filedownloader.f.c$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9496d {
        /* renamed from: f */
        int mo28406f(String str, String str2, boolean z);

        /* renamed from: g */
        int mo28405g(String str, String str2, boolean z);
    }

    /* renamed from: com.kwad.framework.filedownloader.f.c$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9497e {
        /* renamed from: c */
        InterfaceC9480a mo28541c(File file);
    }

    /* renamed from: a */
    public static boolean m28546a(int i, String str, boolean z, boolean z2) {
        if (!z && str != null) {
            File file = new File(str);
            if (file.exists()) {
                C9532e.m28463wf().m28464s(C9535f.m28458a(i, file, z2));
                return true;
            }
        }
        return false;
    }

    /* renamed from: am */
    public static void m28545am(Context context) {
        aik = context;
    }

    /* renamed from: wL */
    public static Context m28544wL() {
        return aik;
    }

    /* renamed from: a */
    public static boolean m28547a(int i, C9464c c9464c, InterfaceC9583y interfaceC9583y, boolean z) {
        if (interfaceC9583y.mo28318a(c9464c)) {
            C9532e.m28463wf().m28464s(C9535f.m28460a(i, c9464c.m28683wl(), c9464c.getTotal(), z));
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m28548a(int i, long j, String str, String str2, InterfaceC9583y interfaceC9583y) {
        int mo28317p;
        if (str2 == null || str == null || (mo28317p = interfaceC9583y.mo28317p(str, i)) == 0) {
            return false;
        }
        C9532e.m28463wf().m28464s(C9535f.m28459a(i, j, new PathConflictException(mo28317p, str, str2)));
        return true;
    }
}
