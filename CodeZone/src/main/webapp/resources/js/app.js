let menuTrigger = document.querySelector('.settings button')
let menu = document.querySelector('.settings .menu')

menuTrigger.addEventListener('click',(e)=>{
    menuTrigger.classList.toggle('open')
    menu.classList.toggle('active')


})

// collapse menu if clicked outside
document.addEventListener('click',(e)=>{
    if(e.target.classList.contains('settings')){
        return
    }
    menuTrigger.classList.remove('open')
    menu.classList.remove('active')

})