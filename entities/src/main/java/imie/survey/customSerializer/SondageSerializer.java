package imie.survey.customSerializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import imie.survey.resources.ProposalResource;
import imie.survey.resources.SurveyResource;

public class SondageSerializer extends StdSerializer<SurveyResource> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4860752331844234705L;

	public SondageSerializer() {
		this(null);
	}
	
	public SondageSerializer(Class<SurveyResource> t) {
		super(t);
	}
	
	@Override
    public void serialize(
      SurveyResource value, JsonGenerator jgen, SerializerProvider provider) 
      throws IOException, JsonProcessingException {
  
        jgen.writeStartObject();
        jgen.writeNumberField("id", value.getId());
        jgen.writeStringField("name", value.getName());
        jgen.writeStringField("author", value.getAuthor().getPseudo());
        jgen.writeStringField("dateDebut", value.getDateStart());
        jgen.writeStringField("dateFin", value.getDateEnd());
        jgen.writeStringField("question", value.getQuestion());
        
        jgen.writeArrayFieldStart("propositions");
        
        for (ProposalResource prop : value.getProposals()) {
        	jgen.writeStartObject();
        	jgen.writeNumberField("id", prop.getId());
        	jgen.writeStringField("value", prop.getValue());
        	jgen.writeEndObject();
        }
        
        jgen.writeEndArray();
        jgen.writeEndObject();
    }
}
