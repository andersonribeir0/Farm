package farm.domain;

import java.io.Serializable;
import java.util.Date;

public class MilkProduction implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date date;
    private float quantity;

    public MilkProduction(Date date, float quantity) {
        this.date = date;
        this.quantity = quantity;
    }

    public MilkProduction() {
    }

    public Date getDate() {
        return date;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "MilkProduction{" +
                "date=" + date +
                ", quantity=" + quantity +
                '}';
    }
}
