package com.acse.ottn;

import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class v<T> extends t<T, w> {
    public v(List<T> list) {
        super(list);
    }

    @Override // com.acse.ottn.m1
    /* renamed from: b */
    public w a(ViewGroup viewGroup, int i4) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new w(imageView);
    }
}
