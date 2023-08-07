package bitcamp.myapp.Iistener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebServlet;

import bitcamp.myapp.handler.InitServlet;
import bitcamp.util.SqlSessionFactoryProxy;

// 요청이나 응답을 수행했을 때 서블릿 컨테이너로부터 알림을 받는 옵저버 객체
@WebServlet // 서블릿 컴테이너에게 이 클래스가 리스너임을 알린다.
public class MyServletRequestListener implements ServletRequestListener{

	public MyServletRequestListener() {
		System.out.println("ServletRequestListener 객체 생성되었네!");
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		((SqlSessionFactoryProxy) InitServlet.sqlSessionFactory).clean();
	}
}
