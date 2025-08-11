package com.centreal.bodyswitch.domain.admin.service;

import com.centreal.bodyswitch.domain.admin.entity.Admin;
import com.centreal.bodyswitch.domain.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminRepository.findByUsername(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
    }

    // 해당하는 User 객체를 UserDetails 객체로 변환
    private UserDetails createUserDetails(Admin admin) {
        return User.builder()
                .username(admin.getUsername())
                .password(admin.getPassword())
                .build();
    }

}
