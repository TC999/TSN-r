package com.autonavi.base.amap.mapcore;

import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.c3;
import com.autonavi.base.amap.mapcore.annotations.ParameterIsClass;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class NativeBase {
    private static final String CREATE_OVERLAY = "createOverlay";
    private static final int LOG_SIZE = 10;
    private static final int STACK_NUMBER = 3;
    private static final String UPDATE_OPTIONS = "updateOptions";
    private boolean mCalledFuntion = false;
    protected boolean useRunnable = true;
    protected volatile boolean destroy = false;
    private int logSizeCount = 1;
    ArrayList<Method> methodMap = new ArrayList<>();
    ArrayList<NativeFunctionRunnable> runnableArrayList = new ArrayList<>();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Method {
        private boolean baseClass;
        private Class<?>[] clazz;
        private String methodName;
        private Object object;
        private Object[] param;

        public Method(Object obj, String str, boolean z3, Object... objArr) {
            this.object = obj;
            this.methodName = str;
            this.baseClass = z3;
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        this.clazz = new Class[objArr.length];
                        if (("createOverlay".equals(str) || "updateOptions".equals(str)) ? true : true) {
                            for (int i4 = 0; i4 < objArr.length; i4++) {
                                if (i4 == 1) {
                                    this.clazz[i4] = objArr[i4].getClass().getSuperclass();
                                } else {
                                    this.clazz[i4] = objArr[i4].getClass();
                                }
                            }
                        } else {
                            for (int i5 = 0; i5 < objArr.length; i5++) {
                                this.clazz[i5] = objArr[i5].getClass();
                            }
                        }
                        this.param = new Object[objArr.length];
                        for (int i6 = 0; i6 < objArr.length; i6++) {
                            this.param[i6] = objArr[i6];
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public synchronized void callAllFunction() {
        java.lang.reflect.Method declaredMethod;
        Runnable runnable;
        if (isReady() && !this.destroy) {
            if (this.mCalledFuntion) {
                return;
            }
            try {
                this.mCalledFuntion = true;
                if (this.useRunnable) {
                    while (this.runnableArrayList.size() > 0 && !this.destroy) {
                        NativeFunctionRunnable nativeFunctionRunnable = this.runnableArrayList.get(0);
                        if (nativeFunctionRunnable != null && (runnable = nativeFunctionRunnable.getRunnable()) != null) {
                            runnable.run();
                        }
                        this.runnableArrayList.remove(0);
                    }
                    this.logSizeCount = 1;
                    return;
                }
                Iterator<Method> it = this.methodMap.iterator();
                while (it.hasNext()) {
                    Method next = it.next();
                    if (this.destroy) {
                        break;
                    } else if (next.object != null && (declaredMethod = next.object.getClass().getDeclaredMethod(next.methodName, next.clazz)) != null) {
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(next.object, next.param);
                    }
                }
                this.methodMap.clear();
            } catch (Throwable unused) {
            }
        }
    }

    protected abstract void createNative();

    public void destroy() {
        this.destroy = true;
        synchronized (this) {
            this.runnableArrayList.clear();
            this.methodMap.clear();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        try {
            finalizeNative();
        } catch (Throwable th) {
            th.toString();
        }
    }

    protected abstract void finalizeNative();

    public int findRunnableIndex(NativeFunctionRunnable nativeFunctionRunnable) {
        if (this.runnableArrayList == null || nativeFunctionRunnable == null) {
            return -1;
        }
        for (int i4 = 0; i4 < this.runnableArrayList.size(); i4++) {
            NativeFunctionRunnable nativeFunctionRunnable2 = this.runnableArrayList.get(i4);
            if (nativeFunctionRunnable2 != null && nativeFunctionRunnable2.getKey().equals(nativeFunctionRunnable.getKey())) {
                return i4;
            }
        }
        return -1;
    }

    protected abstract long getNative();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isReady() {
        return getNative() != 0;
    }

    public synchronized void storeUncallFunction(Object obj, Object obj2, String str, String str2, Object... objArr) {
        try {
            if (this.useRunnable && obj2 != null) {
                NativeFunctionRunnable nativeFunctionRunnable = new NativeFunctionRunnable(str2, str, (Runnable) obj2);
                synchronized (this.runnableArrayList) {
                    int size = this.runnableArrayList.size();
                    if (size > this.logSizeCount * 10) {
                        c3.m(b3.f7207d, "storeUncallFunction size = ".concat(String.valueOf(size)));
                        this.logSizeCount++;
                    }
                    int findRunnableIndex = findRunnableIndex(nativeFunctionRunnable);
                    if (findRunnableIndex >= 0) {
                        this.runnableArrayList.remove(findRunnableIndex);
                    }
                    this.runnableArrayList.add(nativeFunctionRunnable);
                }
            } else {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.methodMap.add(new Method(obj, stackTrace[3].getMethodName(), false, objArr));
                }
            }
            this.mCalledFuntion = false;
        } catch (Throwable unused) {
        }
    }

    public synchronized void storeUncallFunctionArray(Object obj, Object obj2, String[] strArr, String str, Object[] objArr) {
        try {
            if (this.useRunnable && obj2 != null) {
                StringBuilder sb = new StringBuilder("");
                for (String str2 : strArr) {
                    sb.append(str2);
                    sb.append(",");
                }
                NativeFunctionRunnable nativeFunctionRunnable = new NativeFunctionRunnable(str, sb.toString(), (Runnable) obj2);
                synchronized (this.runnableArrayList) {
                    int size = this.runnableArrayList.size();
                    if (size > this.logSizeCount * 10) {
                        c3.m(b3.f7207d, "storeUncallFunctionArray size = ".concat(String.valueOf(size)));
                        this.logSizeCount++;
                    }
                    int findRunnableIndex = findRunnableIndex(nativeFunctionRunnable);
                    if (findRunnableIndex >= 0) {
                        this.runnableArrayList.remove(findRunnableIndex);
                    }
                    this.runnableArrayList.add(nativeFunctionRunnable);
                }
            } else {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.methodMap.add(new Method(obj, stackTrace[3].getMethodName(), false, objArr));
                }
            }
            this.mCalledFuntion = false;
        } catch (Throwable unused) {
        }
    }

    public void validate() {
        ParameterIsClass parameterIsClass;
        Class<?>[] parameterTypes;
        java.lang.reflect.Method[] methods = getClass().getMethods();
        if (methods == null) {
            return;
        }
        for (java.lang.reflect.Method method : methods) {
            if (method.isAnnotationPresent(ParameterIsClass.class) && (parameterIsClass = (ParameterIsClass) method.getAnnotation(ParameterIsClass.class)) != null && parameterIsClass.required() && (parameterTypes = method.getParameterTypes()) != null) {
                for (Class<?> cls : parameterTypes) {
                    if (!(cls instanceof Object)) {
                        throw new RuntimeException("\u51fd\u6570\uff1a" + method + " \u53c2\u6570\u4e0d\u662f\u5bf9\u8c61\u7c7b\u578b");
                    }
                }
                continue;
            }
        }
    }
}
