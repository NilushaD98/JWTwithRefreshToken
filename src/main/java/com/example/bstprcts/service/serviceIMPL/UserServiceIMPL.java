package com.example.bstprcts.service.serviceIMPL;

import com.example.bstprcts.dto.request.RequestAddUserDTO;
import com.example.bstprcts.entity.ApplicationUser;
import com.example.bstprcts.repo.ApplicationUserRepo;
import com.example.bstprcts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private ApplicationUserRepo applicationUserRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void adduser(RequestAddUserDTO requestAddUserDTO) {
        ApplicationUser applicationUser = new ApplicationUser(
                requestAddUserDTO.getUsername(),
                bCryptPasswordEncoder.encode(requestAddUserDTO.getPassword()),
                requestAddUserDTO.getRole()
        );
        applicationUserRepo.save(applicationUser);
    }
}
