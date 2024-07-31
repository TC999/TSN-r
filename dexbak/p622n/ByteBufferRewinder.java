package p622n;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import java.nio.ByteBuffer;

/* renamed from: n.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ByteBufferRewinder implements DataRewinder<ByteBuffer> {

    /* renamed from: a */
    private final ByteBuffer f44095a;

    /* compiled from: ByteBufferRewinder.java */
    /* renamed from: n.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C15372a implements DataRewinder.InterfaceC3563a<ByteBuffer> {
        @Override // com.bumptech.glide.load.data.DataRewinder.InterfaceC3563a
        @NonNull
        /* renamed from: a */
        public Class<ByteBuffer> mo2887a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.InterfaceC3563a
        @NonNull
        /* renamed from: c */
        public DataRewinder<ByteBuffer> mo2886b(ByteBuffer byteBuffer) {
            return new ByteBufferRewinder(byteBuffer);
        }
    }

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.f44095a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    /* renamed from: b */
    public void mo2889b() {
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    @NonNull
    /* renamed from: c */
    public ByteBuffer mo2890a() {
        this.f44095a.position(0);
        return this.f44095a;
    }
}
