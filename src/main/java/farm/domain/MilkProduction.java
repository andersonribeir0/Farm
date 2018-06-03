package farm.domain;

import java.io.Serializable;
import java.util.Date;

public class MilkProduction implements Serializable {
    private final Date date;
    private final float quantity;

    public MilkProduction(Date date, float quantity) {
        this.date = date;
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public float getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "MilkProduction{" +
                "date=" + date +
                ", quantity=" + quantity +
                '}';
    }
}
