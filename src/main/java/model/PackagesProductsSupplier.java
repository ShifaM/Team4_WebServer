package model;

import javax.persistence.*;

@Entity
@Table(name = "packages_products_suppliers")
public class PackagesProductsSupplier {
    @EmbeddedId
    private PackagesProductsSupplierId id;

    @MapsId("packageId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PackageId", nullable = false)
    private Package _package;

    @MapsId("productSupplierId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ProductSupplierId", nullable = false)
    private ProductsSupplier productSupplier;

    public PackagesProductsSupplierId getId() {
        return id;
    }

    public void setId(PackagesProductsSupplierId id) {
        this.id = id;
    }

    public Package get_package() {
        return _package;
    }

    public void set_package(Package _package) {
        this._package = _package;
    }

    public ProductsSupplier getProductSupplier() {
        return productSupplier;
    }

    public void setProductSupplier(ProductsSupplier productSupplier) {
        this.productSupplier = productSupplier;
    }

}