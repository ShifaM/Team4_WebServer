package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PackagesProductsSupplierId implements Serializable {
    private static final long serialVersionUID = -4462079031633143522L;
    @Column(name = "PackageId", nullable = false)
    private Integer packageId;

    @Column(name = "ProductSupplierId", nullable = false)
    private Integer productSupplierId;

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Integer getProductSupplierId() {
        return productSupplierId;
    }

    public void setProductSupplierId(Integer productSupplierId) {
        this.productSupplierId = productSupplierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackagesProductsSupplierId entity = (PackagesProductsSupplierId) o;
        return Objects.equals(this.packageId, entity.packageId) &&
                Objects.equals(this.productSupplierId, entity.productSupplierId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageId, productSupplierId);
    }

}