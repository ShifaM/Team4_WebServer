package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "fees")
public class Fee {
    @Id
    @Column(name = "FeeId", nullable = false, length = 10)
    private String id;

    @Column(name = "FeeName", nullable = false, length = 50)
    private String feeName;

    @Column(name = "FeeAmt", nullable = false, precision = 19, scale = 4)
    private BigDecimal feeAmt;

    @Column(name = "FeeDesc", length = 50)
    private String feeDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public BigDecimal getFeeAmt() {
        return feeAmt;
    }

    public void setFeeAmt(BigDecimal feeAmt) {
        this.feeAmt = feeAmt;
    }

    public String getFeeDesc() {
        return feeDesc;
    }

    public void setFeeDesc(String feeDesc) {
        this.feeDesc = feeDesc;
    }

}