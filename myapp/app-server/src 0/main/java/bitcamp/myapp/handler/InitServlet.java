package bitcamp.myapp.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import bitcamp.util.AbstractServlet;

@WebServlet("/init")
public class InitServlet extends AbstractServlet {


	@Override
	public void service(ServletRequest request, ServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta http-equiv='refresh' content='1;url=/auth/form.html'>");
		out.println("<title>로그인</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>애플리케이션 준비</h1>");
		out.println("<p>애플리케아션을 실행할 준비를 완료했습니다.</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
