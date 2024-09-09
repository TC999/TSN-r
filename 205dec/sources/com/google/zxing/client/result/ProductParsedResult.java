package com.google.zxing.client.result;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ProductParsedResult extends ParsedResult {
    private final String normalizedProductID;
    private final String productID;

    ProductParsedResult(String str) {
        this(str, str);
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        return this.productID;
    }

    public String getNormalizedProductID() {
        return this.normalizedProductID;
    }

    public String getProductID() {
        return this.productID;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProductParsedResult(String str, String str2) {
        super(ParsedResultType.PRODUCT);
        this.productID = str;
        this.normalizedProductID = str2;
    }
}
