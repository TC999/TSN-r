package cn.bingoogolapple.qrcode.zbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import cn.bingoogolapple.qrcode.core.BarcodeType;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.core.ScanResult;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ZBarView extends QRCodeView {

    /* renamed from: t */
    private ImageScanner f1630t;

    /* renamed from: u */
    private List<BarcodeFormat> f1631u;

    static {
        System.loadLibrary("iconv");
    }

    public ZBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: J */
    private boolean m57942J(Symbol symbol) {
        return m58009m() && symbol.getType() == 64;
    }

    /* renamed from: K */
    private String m57941K(Image image) {
        String data;
        if (this.f1630t.scanImage(image) == 0) {
            return null;
        }
        Iterator<Symbol> it = this.f1630t.getResults().iterator();
        while (it.hasNext()) {
            Symbol next = it.next();
            if (next.getType() != 0) {
                if (Build.VERSION.SDK_INT >= 19) {
                    data = new String(next.getDataBytes(), StandardCharsets.UTF_8);
                } else {
                    data = next.getData();
                }
                if (!TextUtils.isEmpty(data)) {
                    boolean m57942J = m57942J(next);
                    if ((m58008n() || m57942J) && m58022I(next.getLocationPoints(), null, m57942J, data)) {
                        return null;
                    }
                    return data;
                }
            }
        }
        return null;
    }

    /* renamed from: L */
    public void m57940L(BarcodeType barcodeType, List<BarcodeFormat> list) {
        this.f1539j = barcodeType;
        this.f1631u = list;
        if (barcodeType == BarcodeType.CUSTOM && (list == null || list.isEmpty())) {
            throw new RuntimeException("barcodeType 为 BarcodeType.CUSTOM 时 formatList 不能为空");
        }
        mo57937w();
    }

    public Collection<BarcodeFormat> getFormats() {
        BarcodeType barcodeType = this.f1539j;
        if (barcodeType == BarcodeType.ONE_DIMENSION) {
            return BarcodeFormat.f1650u;
        }
        if (barcodeType == BarcodeType.TWO_DIMENSION) {
            return BarcodeFormat.f1651v;
        }
        if (barcodeType == BarcodeType.ONLY_QR_CODE) {
            return Collections.singletonList(BarcodeFormat.f1646q);
        }
        if (barcodeType == BarcodeType.ONLY_CODE_128) {
            return Collections.singletonList(BarcodeFormat.f1648s);
        }
        if (barcodeType == BarcodeType.ONLY_EAN_13) {
            return Collections.singletonList(BarcodeFormat.f1638i);
        }
        if (barcodeType == BarcodeType.HIGH_FREQUENCY) {
            return BarcodeFormat.f1652w;
        }
        if (barcodeType == BarcodeType.CUSTOM) {
            return this.f1631u;
        }
        return BarcodeFormat.f1649t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bingoogolapple.qrcode.core.QRCodeView
    /* renamed from: t */
    public ScanResult mo57939t(Bitmap bitmap) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Image image = new Image(width, height, "RGB4");
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            image.setData(iArr);
            return new ScanResult(m57941K(image.convert("Y800")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bingoogolapple.qrcode.core.QRCodeView
    /* renamed from: u */
    public ScanResult mo57938u(byte[] bArr, int i, int i2, boolean z) {
        Image image = new Image(i, i2, "Y800");
        Rect m57990h = this.f1532c.m57990h(i2);
        if (m57990h != null && !z && m57990h.left + m57990h.width() <= i && m57990h.top + m57990h.height() <= i2) {
            image.setCrop(m57990h.left, m57990h.top, m57990h.width(), m57990h.height());
        }
        image.setData(bArr);
        return new ScanResult(m57941K(image));
    }

    @Override // cn.bingoogolapple.qrcode.core.QRCodeView
    /* renamed from: w */
    protected void mo57937w() {
        ImageScanner imageScanner = new ImageScanner();
        this.f1630t = imageScanner;
        imageScanner.setConfig(0, 256, 3);
        this.f1630t.setConfig(0, 257, 3);
        this.f1630t.setConfig(0, 0, 0);
        for (BarcodeFormat barcodeFormat : getFormats()) {
            this.f1630t.setConfig(barcodeFormat.m57935b(), 0, 1);
        }
    }

    public ZBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo57937w();
    }
}
