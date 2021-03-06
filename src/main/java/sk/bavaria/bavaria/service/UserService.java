package sk.bavaria.bavaria.service;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sk.bavaria.bavaria.model.User;
import sk.bavaria.bavaria.repository.UserRepository;
import sk.bavaria.bavaria.security.JwtTokenProvider;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/user")
@Api(value = "/user", description = "Basic crud over pricelist entity.")
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
    @Transactional
    public void init() {
        if (userRepository.findByUsername("admin") == null) {


            User u = new User();
            u.setUsername("admin");
            u.setPassword(passwordEncoder.encode("admin"));

            User u1 = new User();
            u1.setUsername("admin1");
            u1.setPassword(passwordEncoder.encode("admin1"));


            userRepository.save(u);
            userRepository.save(u1);
        }
    }

    @PostMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username);
        } catch (AuthenticationException e) {
            throw new SecurityException("Invalid username/password supplied");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final User byUsername = userRepository.findByUsername(s);
        if (byUsername == null) {
            throw new UsernameNotFoundException("User not found for username:" + s);
        }
        return byUsername;


    }
}
