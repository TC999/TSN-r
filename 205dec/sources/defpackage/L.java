package defpackage;

import OcOsO.RddINbhi.wn.EFApGV.EE.r.NativeAPI;
import android.os.SharedMemory;
import java.nio.ByteBuffer;
import java.util.function.Consumer;

/* renamed from: L  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final /* synthetic */ class L implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f36a;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f36a) {
            case 0:
                NativeAPI.recordNativeEntrypoint((String) obj);
                return;
            case 1:
                SharedMemory.unmap((ByteBuffer) obj);
                return;
            default:
                ((SharedMemory) obj).close();
                return;
        }
    }
}
