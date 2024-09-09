package cn.jiguang.api;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public interface JAction {
    long dispatchMessage(Context context, long j4, int i4, Object obj, ByteBuffer byteBuffer);

    void dispatchTimeOutMessage(Context context, long j4, long j5, int i4);

    IBinder getBinderByType(String str);

    String getSdkVersion();

    void handleMessage(Context context, long j4, Object obj);

    boolean isSupportedCMD(int i4);

    void onActionRun(Context context, long j4, Bundle bundle, Object obj);

    void onEvent(Context context, long j4, int i4);
}
