package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.InterfaceC9427a;
import com.kwad.framework.filedownloader.download.C9474d;
import com.kwad.framework.filedownloader.message.AbstractC9521d;
import com.kwad.framework.filedownloader.message.AbstractC9539h;
import com.kwad.framework.filedownloader.message.InterfaceC9517a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.p351d.C9464c;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9501f;
import java.io.File;

/* renamed from: com.kwad.framework.filedownloader.message.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9535f {
    /* renamed from: a */
    public static MessageSnapshot m28458a(int i, File file, boolean z) {
        long length = file.length();
        if (length > 2147483647L) {
            if (z) {
                return new AbstractC9521d.C9522a(i, true, length);
            }
            return new AbstractC9521d.C9523b(i, true, length);
        } else if (z) {
            return new AbstractC9539h.C9540a(i, true, (int) length);
        } else {
            return new AbstractC9539h.C9541b(i, true, (int) length);
        }
    }

    /* renamed from: e */
    public static MessageSnapshot m28457e(InterfaceC9427a interfaceC9427a) {
        if (interfaceC9427a.mo28733ub()) {
            return new AbstractC9521d.C9526e(interfaceC9427a.getId(), interfaceC9427a.mo28741tT(), interfaceC9427a.mo28740tU());
        }
        return new AbstractC9539h.C9544e(interfaceC9427a.getId(), interfaceC9427a.getSmallFileSoFarBytes(), interfaceC9427a.getSmallFileTotalBytes());
    }

    /* renamed from: t */
    public static MessageSnapshot m28456t(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.mo28442tV() == -3) {
            return new InterfaceC9517a.C9518a(messageSnapshot);
        }
        throw new IllegalStateException(C9501f.m28515b("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.mo28442tV())));
    }

    /* renamed from: a */
    public static MessageSnapshot m28460a(int i, long j, long j2, boolean z) {
        if (j2 > 2147483647L) {
            if (z) {
                return new AbstractC9521d.C9530i(i, j, j2);
            }
            return new AbstractC9521d.C9531j(i, j, j2);
        } else if (z) {
            return new AbstractC9539h.C9548i(i, (int) j, (int) j2);
        } else {
            return new AbstractC9539h.C9549j(i, (int) j, (int) j2);
        }
    }

    /* renamed from: a */
    public static MessageSnapshot m28459a(int i, long j, Throwable th) {
        if (j > 2147483647L) {
            return new AbstractC9521d.C9525d(i, j, th);
        }
        return new AbstractC9539h.C9543d(i, (int) j, th);
    }

    /* renamed from: a */
    public static MessageSnapshot m28461a(byte b, C9464c c9464c, C9474d.C9475a c9475a) {
        MessageSnapshot c9543d;
        IllegalStateException illegalStateException;
        int id = c9464c.getId();
        if (b != -4) {
            if (b == -3) {
                if (c9464c.m28686ub()) {
                    return new AbstractC9521d.C9523b(id, false, c9464c.getTotal());
                }
                return new AbstractC9539h.C9541b(id, false, (int) c9464c.getTotal());
            }
            if (b != -1) {
                if (b == 1) {
                    if (c9464c.m28686ub()) {
                        return new AbstractC9521d.C9527f(id, c9464c.m28683wl(), c9464c.getTotal());
                    }
                    return new AbstractC9539h.C9545f(id, (int) c9464c.m28683wl(), (int) c9464c.getTotal());
                } else if (b == 2) {
                    String filename = c9464c.m28688tR() ? c9464c.getFilename() : null;
                    if (c9464c.m28686ub()) {
                        return new AbstractC9521d.C9524c(id, c9475a.m28584vQ(), c9464c.getTotal(), c9464c.m28682wm(), filename);
                    }
                    return new AbstractC9539h.C9542c(id, c9475a.m28584vQ(), (int) c9464c.getTotal(), c9464c.m28682wm(), filename);
                } else if (b == 3) {
                    if (c9464c.m28686ub()) {
                        return new AbstractC9521d.C9528g(id, c9464c.m28683wl());
                    }
                    return new AbstractC9539h.C9546g(id, (int) c9464c.m28683wl());
                } else if (b != 5) {
                    if (b != 6) {
                        String m28515b = C9501f.m28515b("it can't takes a snapshot for the task(%s) when its status is %d,", c9464c, Byte.valueOf(b));
                        C9498d.m28534d(C9535f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", c9464c, Byte.valueOf(b));
                        if (c9475a.getException() != null) {
                            illegalStateException = new IllegalStateException(m28515b, c9475a.getException());
                        } else {
                            illegalStateException = new IllegalStateException(m28515b);
                        }
                        if (c9464c.m28686ub()) {
                            return new AbstractC9521d.C9525d(id, c9464c.m28683wl(), illegalStateException);
                        }
                        return new AbstractC9539h.C9543d(id, (int) c9464c.m28683wl(), illegalStateException);
                    }
                    return new MessageSnapshot.C9516b(id);
                } else if (c9464c.m28686ub()) {
                    c9543d = new AbstractC9521d.C9529h(id, c9464c.m28683wl(), c9475a.getException(), c9475a.m28585tZ());
                } else {
                    c9543d = new AbstractC9539h.C9547h(id, (int) c9464c.m28683wl(), c9475a.getException(), c9475a.m28585tZ());
                }
            } else if (c9464c.m28686ub()) {
                c9543d = new AbstractC9521d.C9525d(id, c9464c.m28683wl(), c9475a.getException());
            } else {
                c9543d = new AbstractC9539h.C9543d(id, (int) c9464c.m28683wl(), c9475a.getException());
            }
            return c9543d;
        }
        throw new IllegalStateException(C9501f.m28515b("please use #catchWarn instead %d", Integer.valueOf(id)));
    }
}
