package imie.survey.auth;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;

import imie.survey.dao.UtilisateurRepository;
import imie.survey.data.Utilisateur;

import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UtilisateurRepository userRepository;

	public UserDetailsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur = userRepository.findByPseudo(username);
		
		//Set<GrantedAuthority> 
		return null;
	}

}
