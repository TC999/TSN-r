package com.qq.e.comm.plugin.p0;

import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import yaq.pro;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f45348a = Executors.newSingleThreadExecutor();

    /* renamed from: b  reason: collision with root package name */
    private final String f45349b;

    /* renamed from: c  reason: collision with root package name */
    private final int f45350c;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private class b implements Callable<Boolean> {
        private b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(h.a(h.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str, int i4) {
        this.f45349b = str;
        this.f45350c = i4;
    }

    private List<Proxy> a() {
        return (List) pro.getobjresult(102, 0, this);
    }

    static /* synthetic */ boolean a(h hVar) throws k {
        return pro.getZresult(103, 1, hVar);
    }

    private String b() {
        return (String) pro.getobjresult(104, 0, this);
    }

    private boolean c() throws k {
        return pro.getZresult(105, 0, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Socket socket) throws IOException {
        pro.getVresult(106, 0, this, socket);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i4, int i5) {
        return pro.getZresult(107, 0, this, Integer.valueOf(i4), Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        return pro.getZresult(108, 0, this, str);
    }
}
