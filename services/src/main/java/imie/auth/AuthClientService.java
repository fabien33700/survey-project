package imie.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import imie.survey.dao.UtilisateurRepository;
import imie.survey.data.Utilisateur;

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
