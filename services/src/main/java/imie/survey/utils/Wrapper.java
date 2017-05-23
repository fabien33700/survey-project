package imie.survey.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import imie.survey.data.Sondage;
import imie.survey.resources.SondageResource;

@Component
public class Wrapper {
	
	
	private final ModelMapper modelMapper;
	
	@Autowired
	public Wrapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	/**
	 * Convert Sondage to SondageResource
	 * @param post
	 * @return
	 */
	public SondageResource convertSondageToDto(Sondage sondage) {
	    
		SondageResource sondageResource = modelMapper.map(sondage, SondageResource.class);
	    
		// Convertion des dates
	    sondageResource.setDateDebutConverted(sondage.getDateDebut());
	    sondageResource.setDateFinConverted(sondage.getDateFin());
	    
	    return sondageResource;
	}
	
	/**
	 * Convert SondageResource to Sondage
	 * @param sondageResource
	 * @return
	 */
	public Sondage convertSondageToEntity(SondageResource sondageResource) {
	    
		Sondage sondage = modelMapper.map(sondageResource, Sondage.class);
	    
		// Convertion des dates
	    sondage.setDateDebut(sondageResource.getDateDebutConverted());
	    sondage.setDateFin(sondageResource.getDateFinConverted());
	    
	    // Set PropositionsReponse
	    setPropositionsReponseSondage(sondage);
	    
	    return sondage;
	}	
	
	/**
	 * Set sondage property for the PropositionReponse Entity 
	 * @param sondage
	 */
	private static void setPropositionsReponseSondage(Sondage sondage) {
		sondage.getPropositionsReponse().stream().forEach(prop -> prop.setSondage(sondage));
	}
}
