package funnyFunction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/random.do")
public class random extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		String data = request.getParameter("data");
		
		String datas [] = data.split("&");
		List<String> list = new ArrayList<>();
		String res = "";
		
		for(String d : datas) {
			list.add(d);
		}
		
		Collections.shuffle(list);
		
		res = "{ \"sw\" : \""+ list.get(0) +"\"  }";
		PrintWriter out = response.getWriter();
		out.println(res);
		
	}

}
