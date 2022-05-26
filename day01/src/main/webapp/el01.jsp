<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>el language(EL 표현식)</h1>
	<p><%=1+2+3+4+5 %></p>
	<p>${1+2+3+4+5 }</p>
	<table>
		<tr>
			<th>자료형</th>
			<th>표현식</th>
			<th>EL</th>
			<th></th>
		</tr>
		<tr>
			<td>숫자(정수)</td>
			<td><%=-1234 %></td>
			<td>${-1234 }</td>
			<td></td>
		</tr>
		<tr>
			<td>숫자(실수)</td>
			<td><%=3.14 %></td>
			<td>${3.14 }</td>
			<td></td>
		</tr>
		<tr>
			<td>문자</td>
			<td><%='A' %></td>
			<td></td>
			<td>문자 지원안함(표현 안됨)</td>
		</tr>
		<tr>
			<td>문자열</td>
			<td><%="ABC" %></td>
			<td>${"ABC" }</td>
			<td>'',"" 둘다 문자열</td>
		</tr>
		<tr>
			<td>문자열</td>
			<td><%="ABC" %></td>
			<td>${"'ABC'" }</td>
			<td></td>
		</tr>
		<tr>
			<td>문자열</td>
			<td><%="ABC" %></td>
			<td>${'"ABC"' }</td>
			<td></td>
		</tr>
		<tr>
			<td>boolean</td>
			<td><%=true %></td>
			<td>${true }</td>
			<td></td>
		</tr>
		<tr>
			<td>boolean</td>
			<td><%=false %></td>
			<td>${false }</td>
			<td></td>
		</tr>
		<tr>
			<td>object</td>
			<td><%=new java.util.Date() %></td>
			<td></td>
			<td>전달 받아야 쓸수 있음</td>
		</tr>
		<tr>
			<td>object</td>
			<td><%
			Object a=null;
			out.print(a);
			%></td>
			<td>${null}</td>
			<td>null 은 표현 안함</td>
		</tr>
		<tr>
			<td>연산(사칙)</td>
			<td><%=2*3 %></td>
			<td>${2*3 }</td>
			<td></td>
		</tr>
		<tr>
			<td>연산(사칙)</td>
			<td><%=4/2 %></td>
			<td>${4/2 }</td>
			<td></td>
		</tr>
		<tr>
			<td>연산(사칙)</td>
			<td><%=5/2 %></td>
			<td>${5/2 }</td>
			<td></td>
		</tr>
		<tr>
			<td>연산(사칙)</td>
			<td><%=5%2 %></td>
			<td>${5%2 }</td>
			<td>${5 mod 2 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td><%=5>2 %></td>
			<td>${5>2 }</td>
			<td>${5 gt 2 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td><%=5<2 %></td>
			<td>${5<2 }</td>
			<td>${5 lt 2 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td><%=5==2 %></td>
			<td>${5==2 }</td>
			<td>${5 eq 2 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td><%=5!=2 %></td>
			<td>${5!=2 }</td>
			<td>${5 ne 2 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td><%=5<=2 %></td>
			<td>${5<=2 }</td>
			<td>${5 le 2 }</td>
		</tr>
		<tr>
			<td>비교</td>
			<td><%=5>=2 %></td>
			<td>${5>=2 }</td>
			<td>${5 ge 2 }</td>
		</tr>
		<tr>
			<td>논리</td>
			<td><%=true&&false %></td>
			<td>${true&&false }</td>
			<td></td>
		</tr>
		<tr>
			<td>논리</td>
			<td><%=true||false %></td>
			<td>${true||false }</td>
			<td></td>
		</tr>
		<tr>
			<td>삼항</td>
			<td><%=5>2?"크다":"작다" %></td>
			<td>${5>2?"크다":"작다" }</td>
			<td></td>
		</tr>
		<tr>
			<td>삼항</td>
			<td><%=5<2?null:"작다" %></td>
			<td>${5<2?null:"작다" }</td>
			<td></td>
		</tr>
	</table>
</body>
</html>








