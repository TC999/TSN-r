package p622n;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.C3770j;

/* renamed from: n.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BytesResource implements Resource<byte[]> {

    /* renamed from: a */
    private final byte[] f44096a;

    public BytesResource(byte[] bArr) {
        this.f44096a = (byte[]) C3770j.m44392d(bArr);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: a */
    public byte[] get() {
        return this.f44096a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: b */
    public Class<byte[]> mo2883b() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.f44096a.length;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }
}
