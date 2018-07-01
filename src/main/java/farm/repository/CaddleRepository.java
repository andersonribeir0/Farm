package farm.repository;

import farm.domain.Caddle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaddleRepository extends MongoRepository<Caddle, String> {

    @Query("{ number : ?0}")
    List<Caddle> findByNumber(int number);

}
