package com.kwad.sdk.core.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.service.p449a.InterfaceC10971i;
import java.io.File;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IImageLoader extends InterfaceC10971i {
    void clearMemory(Context context);

    File isImageExistOnDisk(String str);

    void load(@NonNull Context context, String str, ImageView imageView, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener);

    void load(Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener);

    void load(ImageView imageView, Object obj, ImageLoadingListener imageLoadingListener);

    void load(KsFragment ksFragment, Context context, String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener);

    Bitmap loadImageSync(String str);

    void pause();

    void resume();
}
