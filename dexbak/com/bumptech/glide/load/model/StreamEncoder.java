package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.model.t */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class StreamEncoder implements Encoder<InputStream> {

    /* renamed from: b */
    private static final String f14043b = "StreamEncoder";

    /* renamed from: a */
    private final ArrayPool f14044a;

    public StreamEncoder(ArrayPool arrayPool) {
        this.f14044a = arrayPool;
    }

    @Override // com.bumptech.glide.load.Encoder
    /* renamed from: c */
    public boolean mo44827a(@NonNull InputStream inputStream, @NonNull File file, @NonNull Options options) {
        byte[] bArr = (byte[]) this.f14044a.mo45394c(65536, byte[].class);
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        } catch (IOException e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            if (Log.isLoggable(f14043b, 3)) {
                                Log.d(f14043b, "Failed to encode data onto the OutputStream", e);
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            this.f14044a.put(bArr);
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            this.f14044a.put(bArr);
                            throw th;
                        }
                    }
                    fileOutputStream2.close();
                    z = true;
                    fileOutputStream2.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException unused2) {
        }
        this.f14044a.put(bArr);
        return z;
    }
}
