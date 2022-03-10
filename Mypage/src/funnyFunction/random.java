package funnyFunction;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		//String data = request.getParameter("data");
		//String decodedData = URLDecoder.decode(data, "UTF-8");
		String data = URLDecoder.decode( request.getParameter("data"), "UTF-8");


		
		
		String datas [] = data.split("&");
		List<String> list = new ArrayList<>();
		String res = "";
		
		for(String d : datas) {
			list.add(d);
		}
		
		Collections.shuffle(list);
		
		int li = list.get(0).indexOf("=") + 1;
		String result = list.get(0).substring(li);
		
		System.out.println(result);
		
		res = "{ \"sw\" : \""+ result +"\"  }";
		PrintWriter out = response.getWriter();
		out.println(res);
		
	}

}
