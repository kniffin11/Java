// this allows you to grab anything on a page with an id, then manipulate it
// css style selector is the argument passed to the querySelector
var heading = document.querySelector('#title')
console.log(heading)

// the element means its generic and you can thorw multiple different things at it and itll work
// function change(element){
//     element.innerText = "BOOYAH"
// }

function change(heading){
    heading.innerText = "BOOYAH"
}

// grabbing this element through its id
var firstName = document.querySelector('#firstName')

function hello(){
    //we use firstName.value because it refers to what the user inputs for the variable fristname
    //console.log(firstName.value)
    alert('Hello, ' + firstName.value)
}

