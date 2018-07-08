package farm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class MilkProduction implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Date date;
    private final float quantity;

    public MilkProduction() {
        this.date = null;
        this.quantity = -1;
    }



}
