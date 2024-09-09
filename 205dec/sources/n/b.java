package n;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BytesResource.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class b implements u<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f61489a;

    public b(byte[] bArr) {
        this.f61489a = (byte[]) j.d(bArr);
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    /* renamed from: a */
    public byte[] get() {
        return this.f61489a;
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<byte[]> b() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return this.f61489a.length;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void recycle() {
    }
}
