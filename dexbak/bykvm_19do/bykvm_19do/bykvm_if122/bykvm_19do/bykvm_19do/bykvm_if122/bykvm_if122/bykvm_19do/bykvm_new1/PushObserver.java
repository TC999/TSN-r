package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource;
import java.io.IOException;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.m */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public interface PushObserver {

    /* renamed from: a */
    public static final PushObserver f1202a = new C1056a();

    /* compiled from: PushObserver.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.m$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1056a implements PushObserver {
        C1056a() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.PushObserver
        /* renamed from: a */
        public void mo58525a(int i, ErrorCode errorCode) {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.PushObserver
        /* renamed from: a */
        public boolean mo58526a(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
            bufferedSource.skip(i2);
            return true;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.PushObserver
        /* renamed from: a */
        public boolean mo58524a(int i, List<Header> list) {
            return true;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.PushObserver
        /* renamed from: a */
        public boolean mo58523a(int i, List<Header> list, boolean z) {
            return true;
        }
    }

    /* renamed from: a */
    void mo58525a(int i, ErrorCode errorCode);

    /* renamed from: a */
    boolean mo58526a(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException;

    /* renamed from: a */
    boolean mo58524a(int i, List<Header> list);

    /* renamed from: a */
    boolean mo58523a(int i, List<Header> list, boolean z);
}
