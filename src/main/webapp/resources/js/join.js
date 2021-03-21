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
				alert('사용 가능한 아이디 입니다.');
			}else{
				idCheckFlg = false;
				alert('사용 불가능한 아이디 입니다.');
				id.value = "";
			}
		})
	}else{
		alert('아이디를 입력하지 않으셨습니다.');
	}
}