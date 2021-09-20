package pl.todo.site.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.todo.site.model.User;
import pl.todo.site.repository.UserRepository;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public void registerUser(User user) {
        boolean checkIfExists = userRepository.findByEmail(
                user.getEmail()).isPresent();

        if (checkIfExists) {
            throw new IllegalStateException("Użytkownik o takim adresie email już istnieje");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        User saveUser = userRepository.save(user);

        log.info("Użytkownik zarejestrowany pomyślnie " + saveUser);

    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }
}

