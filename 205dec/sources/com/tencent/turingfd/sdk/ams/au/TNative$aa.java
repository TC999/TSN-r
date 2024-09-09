package com.tencent.turingfd.sdk.ams.au;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.SparseArray;
import java.lang.reflect.InvocationHandler;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class TNative$aa {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class bb implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static native SparseArray<Object> a89_DEE08458D4E8C7EA(SparseArray<Object> sparseArray, Context context, Map<String, String> map, Map<Integer, String> map2, int i4);

    public static native SparseArray<Object> b89_DEE08458D4E8C7EA(SparseArray<Object> sparseArray, byte[] bArr, Map<String, String> map, int i4);

    public static native SparseArray<Object> c89_DEE08458D4E8C7EA(SparseArray<Object> sparseArray, Context context);

    public static native SparseArray<Object> d89_DEE08458D4E8C7EA(SparseArray<Object> sparseArray, Context context, int i4);

    public static native SparseArray<Object> e89_DEE08458D4E8C7EA(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i4);

    public static native SparseArray<Object> f89_DEE08458D4E8C7EA(SparseArray<Object> sparseArray, byte[] bArr, int i4);

    public static native SparseArray<Object> g89_DEE08458D4E8C7EA(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i4);

    public static native SparseArray<Object> h89_DEE08458D4E8C7EA(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i4);

    public static native SparseArray<Object> i89_DEE08458D4E8C7EA(SparseArray<Object> sparseArray, Context context, Map<String, String> map, Object obj, Object obj2);

    public static native String j89_DEE08458D4E8C7EA();

    public static native byte[] k89_DEE08458D4E8C7EA(byte[] bArr);

    public static native void l89_DEE08458D4E8C7EA(InvocationHandler invocationHandler, AtomicReference<Object> atomicReference, ClassLoader classLoader);

    public static native SparseArray<Object> m89_DEE08458D4E8C7EA(SparseArray<Object> sparseArray, Context context, Map<String, String> map, int i4);
}
