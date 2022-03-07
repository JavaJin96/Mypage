<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$("#cnt").on("change", function(){
			code = "";
			cnt = $("#cnt").val();
			for(i = 0; i < cnt; i++){
				code += "항목을 입력해주세요<input type='text' name='cont" + i + "'><br>"
			}
			code += "<input type='button' id='btn' value='추첨'>";
			
			$("#d2").append(code);
		})
		
		$("#d2").on("click", "#btn", function(){
			alert("추첨을 시작합니다.");
			
			count = 0;
			
			pcode = "<div class='progress'>";
			pcode += "<div class='progress-bar' style='width:" + count + "%' id='pb'></div>";
			pcode += "</div>"
			
			$("#d3").html(pcode);
			
			for(count = 0; count <= 100; count++){
				setTimeout(() => {
					count ++;
					$("#pb").attr("style", "width:" + count + "%" );
				}, 20);
			}
			
			$.ajax({
				url : "<%=request.getContextPath()%>/tt.do",
				data : {
					
				},
				method : "post",
				success : function(res) {

				},
				error : function(jqXHR, textStatus, errorThrown) {
					console.log(jqXHR);
					console.log(textStatus);
					console.log(errorThrown);
				},
				dataType : ""
			})
		
			
		})
		
	})
</script>
</head>
<body>
	<div id ="d1">
		항목의 수를 입력해주세요<input type="number" name="cnt" id="cnt">
	</div>
	
	<div id="d2">
	
	</div>
	
	<div id="d3">
	
	</div>
</body>
</html>