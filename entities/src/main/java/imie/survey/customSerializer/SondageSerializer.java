package imie.survey.customSerializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import imie.survey.data.PropositionReponse;
import imie.survey.resources.SondageResource;

public class SondageSerializer extends StdSerializer<SondageResource> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4860752331844234705L;

	public SondageSerializer() {
		this(null);
	}
	
	public SondageSerializer(Class<SondageResource> t) {
		super(t);
	}
	
	@Override
    public void serialize(
      SondageResource value, JsonGenerator jgen, SerializerProvider provider) 
      throws IOException, JsonProcessingException {
  
        jgen.writeStartObject();
        jgen.writeNumberField("id", value.getId());
        jgen.writeStringField("name", value.getNom());
        jgen.writeStringField("author", value.getAuteur().getPseudo());
        jgen.writeStringField("dateDebut", value.getDateDebut());
        jgen.writeStringField("dateFin", value.getDateFin());
        jgen.writeStringField("question", value.getQuestion());
        
        jgen.writeArrayFieldStart("propositions");
        
        for (PropositionReponse prop : value.getPropositionsReponse()) {
        	jgen.writeStartObject();
        	jgen.writeNumberField("id", prop.getId());
        	jgen.writeStringField("value", prop.getValeur());
        	jgen.writeEndObject();
        }
        
        jgen.writeEndArray();
        jgen.writeEndObject();
    }
	
	
	

}
