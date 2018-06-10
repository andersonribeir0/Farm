package farm.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class MilkProductionDTO implements Serializable {

    @NotNull
    private Date date;
    @NotNull
    private float quantity;

    public MilkProductionDTO(Date date, float quantity) {
        this.date = date;
        this.quantity = quantity;
    }

    public MilkProductionDTO() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "MilkProductionDTO{" +
                "date='" + date + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
