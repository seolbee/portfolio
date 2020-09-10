window.addEventListener("load", (e)=>{
    click_event();
})

function click_event(){
    let input = document.querySelectorAll("input");
    input.forEach(x=> x.isClick = false);
    input.forEach(x=> x.addEventListener("click", (e)=>{
        if(!x.isClick){
            x.style.border="2px solid #222";
            x.placeholder="";
            x.isClick = true;
        }
        
    }))

    document.addEventListener("click", ()=>{
        input.forEach(x=> {
            x.style.border="none";
            x.placeholder = `Enter ${x.className}`;
            x.isClick = false;
        })
    })
}

function ranking(){
    let a = document.querySelector(".rank_btn");
    let btn = document.querySelector(".fas");
    let popup = document.querySelector(".popup");
    let page = 1;
    a.addEventListener("click", (e)=>{
        e.preventDefault();
        popup.style.display="block";
    })
    btn.addEventListener("click", (e)=>popup.style.display="none");
}