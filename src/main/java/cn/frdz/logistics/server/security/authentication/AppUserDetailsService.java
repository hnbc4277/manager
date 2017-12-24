package cn.frdz.logistics.server.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import cn.frdz.logistics.server.business.entity.sys.User;
import cn.frdz.logistics.server.business.repository.sys.UserRepository;
import cn.frdz.logistics.server.security.util.SecurityUser;

/**
 * 
 * @author sxc
 *
 */
@Component
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
	PasswordEncoder passwordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);

        user.setPassword(passwordEncoder.encode("123456"));
        
        
        
        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        user.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//        });
//        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

//        UserDetails userDetails = new org.springframework.security.core.userdetails.
//                User(user.getUsername(), user.getPassword(), authorities);

        
        SecurityUser securityUser = new SecurityUser(user, null);
        
        
        return securityUser;
    }
}
