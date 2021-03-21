<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Simple Page Join</h1>
	<hr/>
	ID :  <input type="text" size="20" id="id"/>
	<button onclick="idCheck()">ID Check</button><br>
	PW : <input type="password" size="20" id="pw"/><br>
	NAME : <input type="text" size="20" id="userName"/><br>
	<button id="btn_join" onclick="join()">Join!</button>
	
</body>

<script type="text/javascript">
let idCheckFlg = false;

let idCheck = () => {
	let userId = id.value;
	
	if(userId){
		fetch("/idcheck?userId="+userId,{
			method:"GET"
		})
		.then(reponse => reponse.text())
		.then(text => {
			if(text == 'ok'){
				idCheckFlg = true;
				alert('��� ������ ���̵� �Դϴ�.');
			}else{
				idCheckFlg = false;
				alert('��� �Ұ����� ���̵� �Դϴ�.');
				id.value = "";
			}
		})
	}else{
		alert('���̵� �Է����� �����̽��ϴ�.');
	}	
}
let join = () => {
	
	let header = new Headers();
	let obj = new Object();
	
	header.append("content-type","application/json");
	obj.userId = id.value;
	obj.userPw = pw.value;
	obj.userName = userName.value;
	
	if(!(id || pw || name)){
		alert('������ ������ �ֽ��ϴ�.');
	}else{
		fetch("/joinimpl",{
			method:"POST",
			headers: header,
			body:JSON.stringify(obj)
		})
	}
	
}
</script>
</html>