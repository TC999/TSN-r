package com.kwad.framework.filedownloader.message;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    private volatile g ahs;
    private volatile b aht;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {
        private static final e ahu = new e();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void r(MessageSnapshot messageSnapshot);
    }

    public static e wf() {
        return a.ahu;
    }

    public final void a(b bVar) {
        this.aht = bVar;
        if (bVar == null) {
            this.ahs = null;
        } else {
            this.ahs = new g(5, bVar);
        }
    }

    public final void s(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwad.framework.filedownloader.message.b) {
            if (this.aht != null) {
                this.aht.r(messageSnapshot);
            }
        } else if (this.ahs != null) {
            this.ahs.u(messageSnapshot);
        }
    }
}
