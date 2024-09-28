package cap.dragons.service;

import cap.dragons.entity.Role;
import cap.dragons.entity.User;
import cap.dragons.repository.RoleRepository;
import cap.dragons.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User createUser(User user, Set<Role> roles) {
        for (Role role : roles) {
            Role existingRole = roleRepository.findById(role.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Role not found"));
            user.getRoles().add(existingRole);
        }
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public User updateUser(Long id, User updatedUser, Set<Role> roles) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.getRoles().clear();
        for (Role role : roles) {
            Role existingRole = roleRepository.findById(role.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Role not found"));
            existingUser.getRoles().add(existingRole);
        }
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

