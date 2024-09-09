package defpackage;

import CyVHHabzCrUqKeyhTwFaxBD.ources;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import ulL.WeEFDVoZmmWVmW.yXd.XposedBridge;

/* renamed from: L0  reason: default package */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final /* synthetic */ class L0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f37a;

    public /* synthetic */ L0(int i4) {
        this.f37a = i4;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f37a) {
            case 0:
                return ources.a((String) obj);
            case 1:
                return (String) ((Map.Entry) obj).getValue();
            case 2:
                return (String) ((Map.Entry) obj).getKey();
            default:
                SharedMemory sharedMemory = (SharedMemory) obj;
                ArrayList arrayList = C1474m0.f60823c;
                try {
                    return sharedMemory.mapReadOnly();
                } catch (ErrnoException e4) {
                    Log.w(XposedBridge.TAG, "Can not map " + sharedMemory, e4);
                    return null;
                }
        }
    }
}
