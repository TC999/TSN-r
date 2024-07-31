package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.model.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ByteBufferEncoder implements Encoder<ByteBuffer> {

    /* renamed from: a */
    private static final String f13951a = "ByteBufferEncoder";

    @Override // com.bumptech.glide.load.Encoder
    /* renamed from: c */
    public boolean mo44827a(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull Options options) {
        try {
            ByteBufferUtil.m44427e(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable(f13951a, 3)) {
                Log.d(f13951a, "Failed to write data", e);
            }
            return false;
        }
    }
}
