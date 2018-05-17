package sk.bavaria.bavaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sk.bavaria.bavaria.model.User;
import sk.bavaria.bavaria.repository.UserRepository;
import sk.bavaria.bavaria.security.JwtTokenProvider;

import javax.annotation.PostConstruct;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;



    @PostConstruct
    public void init() {
        User u = new User();
        u.setUsername("Admin");
        u.setPassword(passwordEncoder.encode("admin"));

        User u1 = new User();
        u1.setUsername("Admin1");
        u1.setPassword(passwordEncoder.encode("admin1"));

        userRepository.save(u);
        userRepository.save(u1);
    }

//    @PostMapping("login")
//    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//            return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
//        } catch (AuthenticationException e) {
//            throw new SecurityException("Invalid username/password supplied");
//        }
//    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final User byUsername = userRepository.findByUsername(s);
        if (byUsername == null) {
            throw new UsernameNotFoundException("User not found for username:" + s);
        }
        return byUsername;


    }
}
