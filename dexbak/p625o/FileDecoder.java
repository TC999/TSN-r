package p625o;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;

/* renamed from: o.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class FileDecoder implements ResourceDecoder<File, File> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: c */
    public Resource<File> mo2813b(@NonNull File file, int i, int i2, @NonNull Options options) {
        return new FileResource(file);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public boolean mo2814a(@NonNull File file, @NonNull Options options) {
        return true;
    }
}
