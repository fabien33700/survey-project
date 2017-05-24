package imie.survey.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import imie.survey.dao.UtilisateurRepository;
import imie.survey.data.Utilisateur;

@Component
public class AuthClientService implements UserDetailsService {

	@Autowired
	private UtilisateurRepository utiliDao;

	@Override
	public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
		Utilisateur utilisateur = utiliDao.findByPseudo(pseudo);
		
		if (utilisateur != null) {
			return utilisateur;
		}
		
		throw new UsernameNotFoundException("Username not found !");
	}

}
