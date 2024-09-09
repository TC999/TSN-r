package cn.bingoogolapple.qrcode.zbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import cn.bingoogolapple.qrcode.core.BarcodeType;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.core.e;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ZBarView extends QRCodeView {

    /* renamed from: t  reason: collision with root package name */
    private ImageScanner f1617t;

    /* renamed from: u  reason: collision with root package name */
    private List<a> f1618u;

    static {
        System.loadLibrary("iconv");
    }

    public ZBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean J(Symbol symbol) {
        return m() && symbol.getType() == 64;
    }

    private String K(Image image) {
        String data;
        if (this.f1617t.scanImage(image) == 0) {
            return null;
        }
        Iterator<Symbol> it = this.f1617t.getResults().iterator();
        while (it.hasNext()) {
            Symbol next = it.next();
            if (next.getType() != 0) {
                if (Build.VERSION.SDK_INT >= 19) {
                    data = new String(next.getDataBytes(), StandardCharsets.UTF_8);
                } else {
                    data = next.getData();
                }
                if (!TextUtils.isEmpty(data)) {
                    boolean J = J(next);
                    if ((n() || J) && I(next.getLocationPoints(), null, J, data)) {
                        return null;
                    }
                    return data;
                }
            }
        }
        return null;
    }

    public void L(BarcodeType barcodeType, List<a> list) {
        this.f1553j = barcodeType;
        this.f1618u = list;
        if (barcodeType == BarcodeType.CUSTOM && (list == null || list.isEmpty())) {
            throw new RuntimeException("barcodeType \u4e3a BarcodeType.CUSTOM \u65f6 formatList \u4e0d\u80fd\u4e3a\u7a7a");
        }
        w();
    }

    public Collection<a> getFormats() {
        BarcodeType barcodeType = this.f1553j;
        if (barcodeType == BarcodeType.ONE_DIMENSION) {
            return a.f1637u;
        }
        if (barcodeType == BarcodeType.TWO_DIMENSION) {
            return a.f1638v;
        }
        if (barcodeType == BarcodeType.ONLY_QR_CODE) {
            return Collections.singletonList(a.f1633q);
        }
        if (barcodeType == BarcodeType.ONLY_CODE_128) {
            return Collections.singletonList(a.f1635s);
        }
        if (barcodeType == BarcodeType.ONLY_EAN_13) {
            return Collections.singletonList(a.f1625i);
        }
        if (barcodeType == BarcodeType.HIGH_FREQUENCY) {
            return a.f1639w;
        }
        if (barcodeType == BarcodeType.CUSTOM) {
            return this.f1618u;
        }
        return a.f1636t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bingoogolapple.qrcode.core.QRCodeView
    public e t(Bitmap bitmap) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Image image = new Image(width, height, "RGB4");
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            image.setData(iArr);
            return new e(K(image.convert("Y800")));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bingoogolapple.qrcode.core.QRCodeView
    public e u(byte[] bArr, int i4, int i5, boolean z3) {
        Image image = new Image(i4, i5, "Y800");
        Rect h4 = this.f1546c.h(i5);
        if (h4 != null && !z3 && h4.left + h4.width() <= i4 && h4.top + h4.height() <= i5) {
            image.setCrop(h4.left, h4.top, h4.width(), h4.height());
        }
        image.setData(bArr);
        return new e(K(image));
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView
    protected void w() {
        ImageScanner imageScanner = new ImageScanner();
        this.f1617t = imageScanner;
        imageScanner.setConfig(0, 256, 3);
        this.f1617t.setConfig(0, 257, 3);
        this.f1617t.setConfig(0, 0, 0);
        for (a aVar : getFormats()) {
            this.f1617t.setConfig(aVar.b(), 0, 1);
        }
    }

    public ZBarView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        w();
    }
}
