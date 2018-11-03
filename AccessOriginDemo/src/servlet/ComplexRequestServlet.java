package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/complexRequestServlet.do")
public class ComplexRequestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		StringBuffer sBuffer = new StringBuffer();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sBuffer.append(line);
		}
		PrintWriter printWriter = response.getWriter();
		printWriter.print(sBuffer);
		printWriter.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
