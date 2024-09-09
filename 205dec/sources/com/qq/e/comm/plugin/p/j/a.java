package com.qq.e.comm.plugin.p.j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final InputStream f45214a;

    /* renamed from: b  reason: collision with root package name */
    protected final File f45215b;

    /* renamed from: c  reason: collision with root package name */
    protected final c f45216c;

    /* renamed from: d  reason: collision with root package name */
    protected String f45217d;

    /* renamed from: e  reason: collision with root package name */
    protected AtomicBoolean f45218e = new AtomicBoolean(false);

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.p.j.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    protected static class C0870a extends IOException {
        /* JADX INFO: Access modifiers changed from: protected */
        public C0870a(IOException iOException) {
            super(iOException);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    protected static class b extends IOException {
        /* JADX INFO: Access modifiers changed from: protected */
        public b(IOException iOException) {
            super(iOException);
        }
    }

    public a(InputStream inputStream, File file, c cVar) {
        this.f45214a = inputStream;
        this.f45215b = file;
        this.f45216c = cVar;
    }

    public int a() {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = new FileOutputStream(this.f45215b, true);
                try {
                    try {
                        try {
                            int a4 = a(fileOutputStream);
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused) {
                            }
                            return a4;
                        } catch (b e4) {
                            this.f45217d = "WriteIOExceptionWhileDoPartitionRW:" + e4.getMessage();
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused2) {
                            }
                            return 512;
                        } catch (SocketTimeoutException e5) {
                            this.f45217d = "SocketTimeoutExceptionWhileDoPartitionRW:" + e5.getMessage();
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused3) {
                            }
                            return 16777216;
                        }
                    } catch (SocketException e6) {
                        this.f45217d = "UnknowSocketExceptionWhileDoPartitionRW:" + e6.getMessage();
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused4) {
                        }
                        return 4194304;
                    } catch (IOException e7) {
                        this.f45217d = "UnknowIOExceptionWhileDoPartitionRW:" + e7.getMessage();
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused5) {
                        }
                        return 2;
                    }
                } catch (C0870a e8) {
                    this.f45217d = "ReadIOExceptionWhileDoPartitionRW:" + e8.getMessage();
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused6) {
                    }
                    return 524288;
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused7) {
                }
                throw th;
            }
        } catch (IOException e9) {
            this.f45217d = "UnKnownExceptionWhileCreateOutputStreamForPartitionFile:" + e9.getMessage();
            return 512;
        }
    }

    protected abstract int a(FileOutputStream fileOutputStream) throws IOException;

    public String b() {
        return this.f45217d;
    }

    public final void c() {
        this.f45218e.set(true);
    }
}
