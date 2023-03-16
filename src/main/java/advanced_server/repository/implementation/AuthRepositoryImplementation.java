package advanced_server.repository.implementation;

import advanced_server.entity.UserEntity;
import advanced_server.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import neacron_2fjooq.tables.Users;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class AuthRepositoryImplementation implements AuthRepository {

    private final DSLContext dslContext;

    @Override
    public Boolean existByEmail(String email) {
        var changingEntity = dslContext.selectFrom(Users.USERS)
                .where(Users.USERS.EMAIL.eq(email))
                .fetchOptional()
                .map(record -> record.into(UserEntity.class));

        if (!changingEntity.isPresent()) {
            return false;
        }
        return true;
    }

    @Override
    public Optional<UserEntity> findByEmailJooq(String email) {
        return dslContext.selectFrom(Users.USERS)
                .where(Users.USERS.EMAIL.eq(email))
                .fetchOptional()
                .map(record -> record.into(UserEntity.class));
    }

    @Override
    public Optional<UserEntity> findByIdJooq(UUID userId) {
        return dslContext.selectFrom(Users.USERS)
                .where(Users.USERS.ID.eq(userId))
                .fetchOptional()
                .map(record -> record.into(UserEntity.class));
    }

    @Override
    public void save(UserEntity user) {
        Field<UUID> uuidField = DSL.field(DSL.uuid());
        UUID uuid = dslContext.select(uuidField).fetchOne().getValue(uuidField);
        user.setId(uuid);
            dslContext.insertInto(Users.USERS)
                    .set(dslContext.newRecord(Users.USERS, user))
                    .set(Users.USERS.ID, uuid)
                    .execute();
    }
}
