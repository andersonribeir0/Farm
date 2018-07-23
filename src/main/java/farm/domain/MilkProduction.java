package farm.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
public class MilkProduction implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final Date date;
    private final float quantity;

    public MilkProduction() {
        this(null,0f);
    }

    public MilkProduction(Date date, float quantity) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.quantity = quantity;
    }
}
