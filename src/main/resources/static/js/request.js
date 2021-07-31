function submitPost(form, path){
const thisForm = document.getElementById(form);
console.log(thisForm)
 var e=window.event;
    e.preventDefault();
    const formData = new FormData(thisForm).entries()
    const response =  fetch(path, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(Object.fromEntries(formData))})
    .then(response => response.json())
    .then(data=>{
   		if(data==="user created successfully"){
   		
   		}else{
	        Object.entries(data).forEach(([key, value]) => {
	         const error= document.getElementById(key+"-error"); 
	         error.textContent = value;
	            error.style.color = "red";
	           
	        });
   		}
    
    })
      .catch((error) => {
      error.json();
        console.error('Error:', error);
      });
    

   
}
  function loginUser(form){
  const thisForm = document.getElementById(form);
  var e=window.event;
    e.preventDefault();
    const formData = new FormData(thisForm).entries()
    const response =  fetch("/login", {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(Object.fromEntries(formData))})
    .then(response => response)
    .then(data=>{
   		
   		window.location.replace("Welcome.html");
    
    })
      .catch((error) => {
      error.json();
        console.error('Error:', error);
      });
  }