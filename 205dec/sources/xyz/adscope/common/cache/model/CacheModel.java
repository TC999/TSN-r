package xyz.adscope.common.cache.model;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CacheModel {

    /* renamed from: a  reason: collision with root package name */
    public String f64569a;

    /* renamed from: b  reason: collision with root package name */
    public long f64570b;

    /* renamed from: c  reason: collision with root package name */
    public long f64571c;

    /* renamed from: d  reason: collision with root package name */
    public int f64572d;

    public int getCanDelete() {
        return this.f64572d;
    }

    public String getFileName() {
        return this.f64569a;
    }

    public long getFileSize() {
        return this.f64570b;
    }

    public long getLastUsedTime() {
        return this.f64571c;
    }

    public void setCanDelete(int i4) {
        this.f64572d = i4;
    }

    public void setFileName(String str) {
        this.f64569a = str;
    }

    public void setFileSize(long j4) {
        this.f64570b = j4;
    }

    public void setLastUsedTime(long j4) {
        this.f64571c = j4;
    }
}
