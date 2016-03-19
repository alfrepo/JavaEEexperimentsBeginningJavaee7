package de.exp.service.rest.jaxrs.scoped;

import java.util.UUID;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

/**
 * - No inheritance is allowed for beans
 * - Method, which serves requests (here @GET annotated) must be public   
 * 
 * This bean is conversationScoped. 
 * I failed to automatically rewrite the URL, 
 * but you can pass the ?cid=CONVERSATIONID to the url to stay within the conversation 
 * 
 */
@Named("scopesServiceConversation")
@ConversationScoped
public class ScopesServiceConversation extends HttpServlet {
	
	private static final long serialVersionUID = -5137498027163774482L;
	
	final String uuid = UUID.randomUUID().toString();

	/**
	 * @ConversationScoped does NOT work with Servlets.
	 * Maybe because it is part of another spec - JavaServerFaces spec 
	 */
	@Inject 
	Conversation conversation;
	
	@Inject 
	HttpSession httpSession;
	
	String state = "Transient";
	private boolean conversationStarted = false;
	
	
	public void startConversation(){
		if(conversation!=null && conversation.isTransient()){
			conversation.begin();
//			resp.encodeURL("http://localhost:8080/ExpWebProject/faces/Convertor.jsp?cid="+conversation.getId());
			
			conversationStarted = true;
			state = "Long living";
		}else{
			this.state = "Failed to start COnversation.";
		}
	}
	
	public void endConversation(){
		if(conversation!=null && !conversation.isTransient()){
			conversation.end();	
			
			conversationStarted = false;
			state = "Transient";
		}else{
			this.state = "Failed to end COnversation.";
		}
	}
	
	public boolean getConversationStarted() {
		return conversationStarted;
	}
	
	public String getState() {
		return state;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public String getConversationCid() {
		return conversation.getId();
	}
}
