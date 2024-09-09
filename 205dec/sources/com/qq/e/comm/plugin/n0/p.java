package com.qq.e.comm.plugin.n0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class p implements o {

    /* renamed from: a  reason: collision with root package name */
    private int f44780a;

    /* renamed from: b  reason: collision with root package name */
    private long f44781b;

    /* renamed from: c  reason: collision with root package name */
    private String f44782c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i4, String str) {
        this.f44780a = i4;
        this.f44782c = str;
        this.f44781b = -1L;
    }

    @Override // com.qq.e.comm.plugin.n0.o
    public long a() {
        return this.f44781b;
    }

    @Override // com.qq.e.comm.plugin.n0.o
    public String getContent() {
        return this.f44782c;
    }

    @Override // com.qq.e.comm.plugin.n0.o
    public int getId() {
        return this.f44780a;
    }

    public String toString() {
        return getClass().getSimpleName() + "{id=" + this.f44780a + ", time=" + this.f44781b + ", content='" + this.f44782c + "'}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(String str, long j4) {
        this.f44780a = -1;
        this.f44781b = j4;
        this.f44782c = str;
    }
}
