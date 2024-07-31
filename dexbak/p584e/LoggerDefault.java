package p584e;

import android.util.Log;

/* renamed from: e.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LoggerDefault implements InterfaceC13574b {
    @Override // p584e.InterfaceC13574b
    /* renamed from: a */
    public int mo12834a(String str, String str2, Throwable th) {
        return Log.d(str, str2, th);
    }

    @Override // p584e.InterfaceC13574b
    /* renamed from: b */
    public int mo12833b(String str, String str2, Throwable th) {
        return Log.v(str, str2, th);
    }

    @Override // p584e.InterfaceC13574b
    /* renamed from: c */
    public int mo12832c(String str, String str2, Throwable th) {
        return Log.i(str, str2, th);
    }

    @Override // p584e.InterfaceC13574b
    /* renamed from: d */
    public int mo12831d(String str, String str2) {
        return Log.d(str, str2);
    }

    @Override // p584e.InterfaceC13574b
    /* renamed from: e */
    public int mo12830e(String str, String str2) {
        return Log.e(str, str2);
    }

    @Override // p584e.InterfaceC13574b
    /* renamed from: i */
    public int mo12828i(String str, String str2) {
        return Log.i(str, str2);
    }

    @Override // p584e.InterfaceC13574b
    /* renamed from: v */
    public int mo12827v(String str, String str2) {
        return Log.v(str, str2);
    }

    @Override // p584e.InterfaceC13574b
    /* renamed from: w */
    public int mo12826w(String str, String str2) {
        return Log.w(str, str2);
    }

    @Override // p584e.InterfaceC13574b
    /* renamed from: e */
    public int mo12829e(String str, String str2, Throwable th) {
        return Log.e(str, str2, th);
    }

    @Override // p584e.InterfaceC13574b
    /* renamed from: w */
    public int mo12825w(String str, String str2, Throwable th) {
        return Log.w(str, str2, th);
    }
}
