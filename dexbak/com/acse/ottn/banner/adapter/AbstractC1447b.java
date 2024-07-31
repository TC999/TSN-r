package com.acse.ottn.banner.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.acse.ottn.banner.p036a.C1444a;
import java.util.List;

/* renamed from: com.acse.ottn.banner.adapter.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class AbstractC1447b<T> extends AbstractC1446a<T, C1444a> {
    public AbstractC1447b(List<T> list) {
        super(list);
    }

    @Override // com.acse.ottn.banner.p036a.InterfaceC1445b
    /* renamed from: a */
    public C1444a mo56734a(ViewGroup viewGroup, int i) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new C1444a(imageView);
    }
}
