package advanced_server.repository;

import advanced_server.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface AuthRepository {
    Boolean existByEmail(String email);
    Optional<UserEntity> findByEmailJooq(String email);
    Optional<UserEntity> findByIdJooq(UUID userId);
    void  save(UserEntity user);
}
