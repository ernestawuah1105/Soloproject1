 function GetIdeas(){
 var e=window.event;
 e.preventDefault();
    
    const response =  fetch("/ideas", {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' }
       })
    .then(response => response.json())
    .then(data=>{
   		let table = document.getElementById("games");
   		
   		console.log(data);
   		for (let element of data) {
    let row = table.insertRow();
    for (key in element) {
      let cell = row.insertCell();
      let text = document.createTextNode(element[key]);
      cell.appendChild(text);
    }
   	}
   		let thead = table.createTHead();
   		const headers = ["Id", "Game", "Created By"]
   		
  let row = thead.insertRow();
  for (let key of headers) {
    let th = document.createElement("th");
    let text = document.createTextNode(key);
    th.appendChild(text);
    row.appendChild(th);
  }
   		
    
    })
      .catch((error) => {
      error.json();
        console.error('Error:', error);
      });
 }