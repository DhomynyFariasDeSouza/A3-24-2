package com.a3.api.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.a3.api.DTO.CreateUserDto;
import com.a3.api.DTO.LoginUserDto;
import com.a3.api.DTO.RecoveryJwtTokenDto;
import com.a3.api.Entity.User;
import com.a3.api.Repository.UserRepository;
import com.a3.api.Security.JwtService;
import com.a3.api.Security.Role;
import com.a3.api.Security.SecurityConfig;
import com.a3.api.Security.UserDetailsImpl;

@Service
public class UserService {
	    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository repository;

    @Autowired
    private SecurityConfig security;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
    
	public User insert(User obj) {	
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setEmail(obj.getEmail());
		entity.setName(obj.getName());
		
	}

		public void createUser(CreateUserDto createUserDto) {

			User newUser = User.builder()
					.email(createUserDto.email())
					.password(security.passwordEncoder().encode(createUserDto.password()))
					.roles(List.of(Role.builder().name(createUserDto.role()).build()))
					.build();
	
			repository.save(newUser);
		}

		public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {
        // Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.password());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Gera um token JWT para o usuário autenticado
        return new RecoveryJwtTokenDto(jwtService.generateToken(userDetails));
    }
}
