package farm.event;

import lombok.Data;

import java.io.Serializable;

@Data
public class MilkProductionCreatedEvent implements Serializable {
    private final String caddleId;
    private final float quantity;
}
