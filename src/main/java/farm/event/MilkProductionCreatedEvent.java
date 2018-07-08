package farm.event;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MilkProductionCreatedEvent implements Serializable {
    private final String caddleId;
    private final Date date;
    private final float quantity;
}
