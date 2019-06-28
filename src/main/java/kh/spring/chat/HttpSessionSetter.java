package kh.spring.chat;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
//클라이언트가 요청 하면 이 요청이 modifyHandshake거쳐서 onOpen에 감
public class HttpSessionSetter extends ServerEndpointConfig.Configurator {
	//클래스안에.클래스상속(inner Class)

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		
		HttpSession hsession = (HttpSession)request.getHttpSession();
		sec.getUserProperties().put("httpSession", hsession); //key,value로 넣기
	}
}
