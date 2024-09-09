package c;

import android.util.Log;

/* compiled from: LoggerDefault.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c implements b {
    @Override // c.b
    public int a(String str, String str2, Throwable th) {
        return Log.d(str, str2, th);
    }

    @Override // c.b
    public int b(String str, String str2, Throwable th) {
        return Log.v(str, str2, th);
    }

    @Override // c.b
    public int c(String str, String str2, Throwable th) {
        return Log.i(str, str2, th);
    }

    @Override // c.b
    public int d(String str, String str2) {
        return Log.d(str, str2);
    }

    @Override // c.b
    public int e(String str, String str2) {
        return Log.e(str, str2);
    }

    @Override // c.b
    public int i(String str, String str2) {
        return Log.i(str, str2);
    }

    @Override // c.b
    public int v(String str, String str2) {
        return Log.v(str, str2);
    }

    @Override // c.b
    public int w(String str, String str2) {
        return Log.w(str, str2);
    }

    @Override // c.b
    public int e(String str, String str2, Throwable th) {
        return Log.e(str, str2, th);
    }

    @Override // c.b
    public int w(String str, String str2, Throwable th) {
        return Log.w(str, str2, th);
    }
}
