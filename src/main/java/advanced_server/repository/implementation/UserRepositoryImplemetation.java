package advanced_server.repository.implementation;

import advanced_server.dto.PublicUserView;
import advanced_server.dto.PutUserDtoResponse;
import advanced_server.entity.UserEntity;
import advanced_server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import neacron_2fjooq.tables.Users;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImplemetation implements UserRepository {

    private final DSLContext dslContext;

    @Override
    public PublicUserView getUserInfoById(UUID id) {
        return dslContext.selectFrom(Users.USERS)
                .where(Users.USERS.ID.eq(id))
                .fetchOne()
                .into(PublicUserView.class);
    }

    @Override
    public List<PublicUserView> getUsersInfo() {
        return dslContext.selectFrom(Users.USERS).fetchInto(PublicUserView.class);
    }

    @Override
    public Optional<UserEntity> getOptionalUserInfoById(UUID id) {
        Optional<UserEntity> optionalUser = Optional.of(dslContext.selectFrom(Users.USERS)
                .where(Users.USERS.ID.eq(id))
                .fetchOneInto(UserEntity.class));
        return optionalUser;
    }

    @Override
    public PutUserDtoResponse changeUserInfo(UUID id, String avatar, String email, String name, String role) {
        return dslContext.update(Users.USERS)
                .set(Users.USERS.AVATAR, avatar)
                .set(Users.USERS.EMAIL, email)
                .set(Users.USERS.NAME, name)
                .set(Users.USERS.ROLE, role)
                .where(Users.USERS.ID.eq(id))
                .returning()
                .fetchOne()
                .into(PutUserDtoResponse.class);
    }

    @Override
    public PutUserDtoResponse changeUserInfoByEmail(String avatar, String email, String name, String role) {
       return dslContext.update(Users.USERS)
                .set(Users.USERS.AVATAR, avatar)
                .set(Users.USERS.NAME, name)
                .set(Users.USERS.ROLE, role)
                .where(Users.USERS.EMAIL.eq(email))
               .returning()
               .fetchOne()
               .into(PutUserDtoResponse.class);
    }

    @Override
    public void deleteUser(UUID id) {
        dslContext.deleteFrom(Users.USERS)
                .where(Users.USERS.ID.eq(id))
                .execute();
    }

    @Override
    public void deleteUser(String email) {

    }
}
