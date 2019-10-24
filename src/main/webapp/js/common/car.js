const oreder={
		getItem(key){
			return JSON.parse(sessionStorage.getItem(key)) ;
			
		},
		setItem(key,value){
			return sessionStorage.setItem(key,JSON.stringify(value));
		},
		del(key){
			return sessionStorage.removeItem(key);
		}
}