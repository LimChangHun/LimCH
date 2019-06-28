package kh.spring.chat;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/chat",configurator=HttpSessionSetter.class) //핸드쉐이킹 한테 갔다 오겠다라고 해야됨
public class WebChat {

	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	//나중에 동기화 처리를 위해서 synchronizedSet쓴다.
	//동시성 오류 방지하기 위해서! (for문 돌고있는 동안 add도 remove도 안되게 해주는 역할)

	@OnMessage
	public void onMessage(String msg , Session session)throws Exception {

		synchronized(clients) {
			for(Session each : clients) {
				if(each != session) { //자기자신은 안받게!
					each.getBasicRemote().sendText(msg);
				}
			}
		}
	}

	@OnOpen //이게 처음에 붙음! ,메서드이름 중요x
	public void onOpen(Session session,EndpointConfig ec) {
		HttpSession hsession = (HttpSession)ec.getUserProperties().get("httpSession"); // put해놓은 정보 가져오면 됨!
		System.out.println(hsession.getAttribute("id")); //세션에 저장된 id값
		clients.add(session);
	}

	@OnClose
	public void onclose(Session session) {
		clients.remove(session);
	}

}