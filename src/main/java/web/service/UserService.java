package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    List<User> getAllUsers();
    void removeUser(Long id);
    void editUser(User user);
    User getUser(Long id);
}
