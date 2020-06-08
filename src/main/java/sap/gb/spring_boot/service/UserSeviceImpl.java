package sap.gb.spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sap.gb.spring_boot.exception.NoSuchUserException;
import sap.gb.spring_boot.model.User;
import sap.gb.spring_boot.repo.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserSeviceImpl implements UserService{
    private UserRepo userRepo;

    @Autowired
    public UserSeviceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepo.findById(id);
    }

    public void updateUser(User user) throws NoSuchUserException{
        findUserById(user.getId()).orElseThrow(NoSuchUserException::new);
        saveUser(user);
    }

    @Override
    public void deleteUser(Long id) throws NoSuchUserException{
        userRepo.delete(findUserById(id)
                .orElseThrow(NoSuchUserException::new));
    }
}
