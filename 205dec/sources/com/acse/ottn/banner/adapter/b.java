package com.acse.ottn.banner.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class b<T> extends a<T, com.acse.ottn.banner.a.a> {
    public b(List<T> list) {
        super(list);
    }

    @Override // com.acse.ottn.banner.a.b
    public com.acse.ottn.banner.a.a a(ViewGroup viewGroup, int i4) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new com.acse.ottn.banner.a.a(imageView);
    }
}
