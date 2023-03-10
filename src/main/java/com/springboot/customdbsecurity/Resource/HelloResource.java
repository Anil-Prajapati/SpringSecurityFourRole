package com.springboot.customdbsecurity.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.springboot.customdbsecurity.Repository.UsersRepository;
import com.springboot.customdbsecurity.model.Users;
import com.springboot.customdbsecurity.service.UserService;

@RequestMapping("/rest/hello")
@RestController
public class HelloResource {
	
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private UserService userService;
	
	//http://localhost:8080/rest/hello/springsecurity-rest/create
	@PostMapping("/create")
	public String create(@RequestBody Users users) {
		usersRepository.save(users);
		return "Your Rgistration Successfully created...";
	}

	//http://localhost:8080/rest/hello/all -> It does not have any secured keyword -> No Authentication/ No Authorization
    @GetMapping("/all")
    public Iterable<Users> hello() {
        return userService.getAll();
    }
    
    //localhost:8080/rest/hello/secured/access -> It will be access only for user who is having ADMIN Role  
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/access")
    public Iterable<Users> access() {
        return usersRepository.findAll();
    }

    //localhost:8080/rest/hello/secured/all -> It will be access only for user who is having ADMIN or GUEST Role
    @PreAuthorize("hasAnyRole('GUEST','ADMIN')")
    @GetMapping("/secured/all")
    public String securedGuest() {
        return "Its secured Page ..Both admin and Guest can view this";
    }
    
  //localhost:8080/rest/hello/secured/order -> It will be access only for user who is having ADMIN or GUEST Role
    @PreAuthorize("hasAnyRole('ORDER','ADMIN')")
    @GetMapping("/secured/order")
    public String securedOder() {
        return "Its secured Page ..Both admin and Order can view this";
    }
    
  //localhost:8080/rest/hello/secured/product -> It will be access only for user who is having ADMIN or GUEST Role
    @PreAuthorize("hasAnyRole('PRODUCT','ADMIN')")
    @GetMapping("/secured/product")
    public String securedproduct() {
        return "Its secured Page ..Both admin and product can view this";
    }
}
